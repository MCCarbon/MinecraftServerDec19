package net.minecraft.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufInputStream;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.buffer.ByteBufProcessor;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.EncoderException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;
import java.util.UUID;

import com.google.common.base.Charsets;

public class PacketDataSerializer extends ByteBuf {

	private final ByteBuf byteBuf;

	public PacketDataSerializer(ByteBuf buf) {
		byteBuf = buf;
	}

	public static int getVarIntLength(int i) {
		for (int var1 = 1; var1 < 5; ++var1) {
			if ((i & (-1 << (var1 * 7))) == 0) {
				return var1;
			}
		}
		return 5;
	}

	public void writeArray(byte[] array) {
		writeVarInt(array.length);
		this.writeBytes(array);
	}

	public byte[] readArray() {
		byte[] array = new byte[readVarInt()];
		this.readBytes(array);
		return array;
	}

	public BlockPosition readBlockPosition() {
		return BlockPosition.fromLong(readLong());
	}

	public void writeBlockPosition(BlockPosition pos) {
		writeLong(pos.asLong());
	}

	public IChatBaseComponent readChat() throws IOException {
		return IChatBaseComponent.ChatSerializer.fromJson(readString(32767));
	}

	public void writeChat(IChatBaseComponent chat) throws IOException {
		writeString(IChatBaseComponent.ChatSerializer.toJson(chat));
	}

	public <T extends Enum<T>> T readEnum(Class<T> enumClass) {
		return enumClass.getEnumConstants()[readVarInt()];
	}

	public void writeEnum(Enum<?> e) {
		writeVarInt(e.ordinal());
	}

	public int readVarInt() {
		int i = 0;
		int length = 0;

		byte b;
		do {
			b = readByte();
			i |= (b & 127) << (length++ * 7);
			if (length > 5) {
				throw new RuntimeException("VarInt too big");
			}
		} while ((b & 128) == 128);

		return i;
	}

	public long readVarLong() {
		long l = 0L;
		int length = 0;

		byte b;
		do {
			b = readByte();
			l |= (long) (b & 127) << (length++ * 7);
			if (length > 10) {
				throw new RuntimeException("VarLong too big");
			}
		} while ((b & 128) == 128);

		return l;
	}

	public void writeUUID(UUID uuid) {
		writeLong(uuid.getMostSignificantBits());
		writeLong(uuid.getLeastSignificantBits());
	}

	public UUID readUUID() {
		return new UUID(readLong(), readLong());
	}

	public void writeVarInt(int i) {
		while ((i & -128) != 0) {
			writeByte((i & 127) | 128);
			i >>>= 7;
		}
		writeByte(i);
	}

	public void writeVarLong(long l) {
		while ((l & -128L) != 0L) {
			writeByte((int) (l & 127L) | 128);
			l >>>= 7;
		}
		writeByte((int) l);
	}

	public void writeNBTTagCompound(NBTTagCompound compound) {
		if (compound == null) {
			writeByte(0);
		} else {
			try {
				NBTCompressedStreamTools.writeToData(compound, (new ByteBufOutputStream(this)));
			} catch (IOException var3) {
				throw new EncoderException(var3);
			}
		}
	}

	public NBTTagCompound readNBTTagCompund() throws IOException {
		int readerIndex = this.readerIndex();
		byte length = readByte();
		if (length == 0) {
			return null;
		} else {
			this.readerIndex(readerIndex);
			return NBTCompressedStreamTools.frowDataOutput((new ByteBufInputStream(this)), (new NBTReadLimiter(2097152L)));
		}
	}

	public void writeItemStack(ItemStack var1) {
		if (var1 == null) {
			writeShort(-1);
		} else {
			writeShort(Item.getId(var1.getItem()));
			writeByte(var1.count);
			writeShort(var1.i());
			NBTTagCompound var2 = null;
			if (var1.getItem().usesDurability() || var1.getItem().shouldSendNBT()) {
				var2 = var1.getTag();
			}

			writeNBTTagCompound(var2);
		}
	}

	public ItemStack readItemStack() throws IOException {
		ItemStack stack = null;
		short id = readShort();
		if (id >= 0) {
			byte count = readByte();
			short data = readShort();
			stack = new ItemStack(Item.getById(id), count, data);
			stack.setTag(readNBTTagCompund());
		}
		return stack;
	}

	public String readString(int limit) {
		int length = readVarInt();
		if (length > (limit * 4)) {
			throw new DecoderException("The received encoded string buffer length is longer than maximum allowed (" + length + " > " + (limit * 4) + ")");
		} else if (length < 0) {
			throw new DecoderException("The received encoded string buffer length is less than zero! Weird string!");
		} else {
			String string = new String(this.readBytes(length).array(), Charsets.UTF_8);
			if (string.length() > limit) {
				throw new DecoderException("The received string length is longer than maximum allowed (" + length + " > " + limit + ")");
			} else {
				return string;
			}
		}
	}

	public PacketDataSerializer writeString(String string) {
		byte[] bytes = string.getBytes(Charsets.UTF_8);
		if (bytes.length > 32767) {
			throw new EncoderException("String too big (was " + string.length() + " bytes encoded, max " + 32767 + ")");
		} else {
			writeVarInt(bytes.length);
			this.writeBytes(bytes);
			return this;
		}
	}

	@Override
	public int capacity() {
		return byteBuf.capacity();
	}

	@Override
	public ByteBuf capacity(int var1) {
		return byteBuf.capacity(var1);
	}

	@Override
	public int maxCapacity() {
		return byteBuf.maxCapacity();
	}

	@Override
	public ByteBufAllocator alloc() {
		return byteBuf.alloc();
	}

	@Override
	public ByteOrder order() {
		return byteBuf.order();
	}

	@Override
	public ByteBuf order(ByteOrder var1) {
		return byteBuf.order(var1);
	}

	@Override
	public ByteBuf unwrap() {
		return byteBuf.unwrap();
	}

	@Override
	public boolean isDirect() {
		return byteBuf.isDirect();
	}

	@Override
	public int readerIndex() {
		return byteBuf.readerIndex();
	}

	@Override
	public ByteBuf readerIndex(int var1) {
		return byteBuf.readerIndex(var1);
	}

	@Override
	public int writerIndex() {
		return byteBuf.writerIndex();
	}

	@Override
	public ByteBuf writerIndex(int var1) {
		return byteBuf.writerIndex(var1);
	}

	@Override
	public ByteBuf setIndex(int var1, int var2) {
		return byteBuf.setIndex(var1, var2);
	}

	@Override
	public int readableBytes() {
		return byteBuf.readableBytes();
	}

	@Override
	public int writableBytes() {
		return byteBuf.writableBytes();
	}

	@Override
	public int maxWritableBytes() {
		return byteBuf.maxWritableBytes();
	}

	@Override
	public boolean isReadable() {
		return byteBuf.isReadable();
	}

	@Override
	public boolean isReadable(int var1) {
		return byteBuf.isReadable(var1);
	}

	@Override
	public boolean isWritable() {
		return byteBuf.isWritable();
	}

	@Override
	public boolean isWritable(int var1) {
		return byteBuf.isWritable(var1);
	}

	@Override
	public ByteBuf clear() {
		return byteBuf.clear();
	}

	@Override
	public ByteBuf markReaderIndex() {
		return byteBuf.markReaderIndex();
	}

	@Override
	public ByteBuf resetReaderIndex() {
		return byteBuf.resetReaderIndex();
	}

	@Override
	public ByteBuf markWriterIndex() {
		return byteBuf.markWriterIndex();
	}

	@Override
	public ByteBuf resetWriterIndex() {
		return byteBuf.resetWriterIndex();
	}

	@Override
	public ByteBuf discardReadBytes() {
		return byteBuf.discardReadBytes();
	}

	@Override
	public ByteBuf discardSomeReadBytes() {
		return byteBuf.discardSomeReadBytes();
	}

	@Override
	public ByteBuf ensureWritable(int var1) {
		return byteBuf.ensureWritable(var1);
	}

	@Override
	public int ensureWritable(int var1, boolean var2) {
		return byteBuf.ensureWritable(var1, var2);
	}

	@Override
	public boolean getBoolean(int var1) {
		return byteBuf.getBoolean(var1);
	}

	@Override
	public byte getByte(int var1) {
		return byteBuf.getByte(var1);
	}

	@Override
	public short getUnsignedByte(int var1) {
		return byteBuf.getUnsignedByte(var1);
	}

	@Override
	public short getShort(int var1) {
		return byteBuf.getShort(var1);
	}

	@Override
	public int getUnsignedShort(int var1) {
		return byteBuf.getUnsignedShort(var1);
	}

	@Override
	public int getMedium(int var1) {
		return byteBuf.getMedium(var1);
	}

	@Override
	public int getUnsignedMedium(int var1) {
		return byteBuf.getUnsignedMedium(var1);
	}

	@Override
	public int getInt(int var1) {
		return byteBuf.getInt(var1);
	}

	@Override
	public long getUnsignedInt(int var1) {
		return byteBuf.getUnsignedInt(var1);
	}

	@Override
	public long getLong(int var1) {
		return byteBuf.getLong(var1);
	}

	@Override
	public char getChar(int var1) {
		return byteBuf.getChar(var1);
	}

	@Override
	public float getFloat(int var1) {
		return byteBuf.getFloat(var1);
	}

	@Override
	public double getDouble(int var1) {
		return byteBuf.getDouble(var1);
	}

	@Override
	public ByteBuf getBytes(int var1, ByteBuf var2) {
		return byteBuf.getBytes(var1, var2);
	}

	@Override
	public ByteBuf getBytes(int var1, ByteBuf var2, int var3) {
		return byteBuf.getBytes(var1, var2, var3);
	}

	@Override
	public ByteBuf getBytes(int var1, ByteBuf var2, int var3, int var4) {
		return byteBuf.getBytes(var1, var2, var3, var4);
	}

	@Override
	public ByteBuf getBytes(int var1, byte[] var2) {
		return byteBuf.getBytes(var1, var2);
	}

	@Override
	public ByteBuf getBytes(int var1, byte[] var2, int var3, int var4) {
		return byteBuf.getBytes(var1, var2, var3, var4);
	}

	@Override
	public ByteBuf getBytes(int var1, ByteBuffer var2) {
		return byteBuf.getBytes(var1, var2);
	}

	@Override
	public ByteBuf getBytes(int var1, OutputStream var2, int var3) throws IOException {
		return byteBuf.getBytes(var1, var2, var3);
	}

	@Override
	public int getBytes(int var1, GatheringByteChannel var2, int var3) throws IOException {
		return byteBuf.getBytes(var1, var2, var3);
	}

	@Override
	public ByteBuf setBoolean(int var1, boolean var2) {
		return byteBuf.setBoolean(var1, var2);
	}

	@Override
	public ByteBuf setByte(int var1, int var2) {
		return byteBuf.setByte(var1, var2);
	}

	@Override
	public ByteBuf setShort(int var1, int var2) {
		return byteBuf.setShort(var1, var2);
	}

	@Override
	public ByteBuf setMedium(int var1, int var2) {
		return byteBuf.setMedium(var1, var2);
	}

	@Override
	public ByteBuf setInt(int var1, int var2) {
		return byteBuf.setInt(var1, var2);
	}

	@Override
	public ByteBuf setLong(int var1, long var2) {
		return byteBuf.setLong(var1, var2);
	}

	@Override
	public ByteBuf setChar(int var1, int var2) {
		return byteBuf.setChar(var1, var2);
	}

	@Override
	public ByteBuf setFloat(int var1, float var2) {
		return byteBuf.setFloat(var1, var2);
	}

	@Override
	public ByteBuf setDouble(int var1, double var2) {
		return byteBuf.setDouble(var1, var2);
	}

	@Override
	public ByteBuf setBytes(int var1, ByteBuf var2) {
		return byteBuf.setBytes(var1, var2);
	}

	@Override
	public ByteBuf setBytes(int var1, ByteBuf var2, int var3) {
		return byteBuf.setBytes(var1, var2, var3);
	}

	@Override
	public ByteBuf setBytes(int var1, ByteBuf var2, int var3, int var4) {
		return byteBuf.setBytes(var1, var2, var3, var4);
	}

	@Override
	public ByteBuf setBytes(int var1, byte[] var2) {
		return byteBuf.setBytes(var1, var2);
	}

	@Override
	public ByteBuf setBytes(int var1, byte[] var2, int var3, int var4) {
		return byteBuf.setBytes(var1, var2, var3, var4);
	}

	@Override
	public ByteBuf setBytes(int var1, ByteBuffer var2) {
		return byteBuf.setBytes(var1, var2);
	}

	@Override
	public int setBytes(int var1, InputStream var2, int var3) throws IOException {
		return byteBuf.setBytes(var1, var2, var3);
	}

	@Override
	public int setBytes(int var1, ScatteringByteChannel var2, int var3) throws IOException {
		return byteBuf.setBytes(var1, var2, var3);
	}

	@Override
	public ByteBuf setZero(int var1, int var2) {
		return byteBuf.setZero(var1, var2);
	}

	@Override
	public boolean readBoolean() {
		return byteBuf.readBoolean();
	}

	@Override
	public byte readByte() {
		return byteBuf.readByte();
	}

	@Override
	public short readUnsignedByte() {
		return byteBuf.readUnsignedByte();
	}

	@Override
	public short readShort() {
		return byteBuf.readShort();
	}

	@Override
	public int readUnsignedShort() {
		return byteBuf.readUnsignedShort();
	}

	@Override
	public int readMedium() {
		return byteBuf.readMedium();
	}

	@Override
	public int readUnsignedMedium() {
		return byteBuf.readUnsignedMedium();
	}

	@Override
	public int readInt() {
		return byteBuf.readInt();
	}

	@Override
	public long readUnsignedInt() {
		return byteBuf.readUnsignedInt();
	}

	@Override
	public long readLong() {
		return byteBuf.readLong();
	}

	@Override
	public char readChar() {
		return byteBuf.readChar();
	}

	@Override
	public float readFloat() {
		return byteBuf.readFloat();
	}

	@Override
	public double readDouble() {
		return byteBuf.readDouble();
	}

	@Override
	public ByteBuf readBytes(int var1) {
		return byteBuf.readBytes(var1);
	}

	@Override
	public ByteBuf readSlice(int var1) {
		return byteBuf.readSlice(var1);
	}

	@Override
	public ByteBuf readBytes(ByteBuf var1) {
		return byteBuf.readBytes(var1);
	}

	@Override
	public ByteBuf readBytes(ByteBuf var1, int var2) {
		return byteBuf.readBytes(var1, var2);
	}

	@Override
	public ByteBuf readBytes(ByteBuf var1, int var2, int var3) {
		return byteBuf.readBytes(var1, var2, var3);
	}

	@Override
	public ByteBuf readBytes(byte[] var1) {
		return byteBuf.readBytes(var1);
	}

	@Override
	public ByteBuf readBytes(byte[] var1, int var2, int var3) {
		return byteBuf.readBytes(var1, var2, var3);
	}

	@Override
	public ByteBuf readBytes(ByteBuffer var1) {
		return byteBuf.readBytes(var1);
	}

	@Override
	public ByteBuf readBytes(OutputStream var1, int var2) throws IOException {
		return byteBuf.readBytes(var1, var2);
	}

	@Override
	public int readBytes(GatheringByteChannel var1, int var2) throws IOException {
		return byteBuf.readBytes(var1, var2);
	}

	@Override
	public ByteBuf skipBytes(int var1) {
		return byteBuf.skipBytes(var1);
	}

	@Override
	public ByteBuf writeBoolean(boolean var1) {
		return byteBuf.writeBoolean(var1);
	}

	@Override
	public ByteBuf writeByte(int var1) {
		return byteBuf.writeByte(var1);
	}

	@Override
	public ByteBuf writeShort(int var1) {
		return byteBuf.writeShort(var1);
	}

	@Override
	public ByteBuf writeMedium(int var1) {
		return byteBuf.writeMedium(var1);
	}

	@Override
	public ByteBuf writeInt(int var1) {
		return byteBuf.writeInt(var1);
	}

	@Override
	public ByteBuf writeLong(long var1) {
		return byteBuf.writeLong(var1);
	}

	@Override
	public ByteBuf writeChar(int var1) {
		return byteBuf.writeChar(var1);
	}

	@Override
	public ByteBuf writeFloat(float var1) {
		return byteBuf.writeFloat(var1);
	}

	@Override
	public ByteBuf writeDouble(double var1) {
		return byteBuf.writeDouble(var1);
	}

	@Override
	public ByteBuf writeBytes(ByteBuf var1) {
		return byteBuf.writeBytes(var1);
	}

	@Override
	public ByteBuf writeBytes(ByteBuf var1, int var2) {
		return byteBuf.writeBytes(var1, var2);
	}

	@Override
	public ByteBuf writeBytes(ByteBuf var1, int var2, int var3) {
		return byteBuf.writeBytes(var1, var2, var3);
	}

	@Override
	public ByteBuf writeBytes(byte[] var1) {
		return byteBuf.writeBytes(var1);
	}

	@Override
	public ByteBuf writeBytes(byte[] var1, int var2, int var3) {
		return byteBuf.writeBytes(var1, var2, var3);
	}

	@Override
	public ByteBuf writeBytes(ByteBuffer var1) {
		return byteBuf.writeBytes(var1);
	}

	@Override
	public int writeBytes(InputStream var1, int var2) throws IOException {
		return byteBuf.writeBytes(var1, var2);
	}

	@Override
	public int writeBytes(ScatteringByteChannel var1, int var2) throws IOException {
		return byteBuf.writeBytes(var1, var2);
	}

	@Override
	public ByteBuf writeZero(int var1) {
		return byteBuf.writeZero(var1);
	}

	@Override
	public int indexOf(int var1, int var2, byte var3) {
		return byteBuf.indexOf(var1, var2, var3);
	}

	@Override
	public int bytesBefore(byte var1) {
		return byteBuf.bytesBefore(var1);
	}

	@Override
	public int bytesBefore(int var1, byte var2) {
		return byteBuf.bytesBefore(var1, var2);
	}

	@Override
	public int bytesBefore(int var1, int var2, byte var3) {
		return byteBuf.bytesBefore(var1, var2, var3);
	}

	@Override
	public int forEachByte(ByteBufProcessor var1) {
		return byteBuf.forEachByte(var1);
	}

	@Override
	public int forEachByte(int var1, int var2, ByteBufProcessor var3) {
		return byteBuf.forEachByte(var1, var2, var3);
	}

	@Override
	public int forEachByteDesc(ByteBufProcessor var1) {
		return byteBuf.forEachByteDesc(var1);
	}

	@Override
	public int forEachByteDesc(int var1, int var2, ByteBufProcessor var3) {
		return byteBuf.forEachByteDesc(var1, var2, var3);
	}

	@Override
	public ByteBuf copy() {
		return byteBuf.copy();
	}

	@Override
	public ByteBuf copy(int var1, int var2) {
		return byteBuf.copy(var1, var2);
	}

	@Override
	public ByteBuf slice() {
		return byteBuf.slice();
	}

	@Override
	public ByteBuf slice(int var1, int var2) {
		return byteBuf.slice(var1, var2);
	}

	@Override
	public ByteBuf duplicate() {
		return byteBuf.duplicate();
	}

	@Override
	public int nioBufferCount() {
		return byteBuf.nioBufferCount();
	}

	@Override
	public ByteBuffer nioBuffer() {
		return byteBuf.nioBuffer();
	}

	@Override
	public ByteBuffer nioBuffer(int var1, int var2) {
		return byteBuf.nioBuffer(var1, var2);
	}

	@Override
	public ByteBuffer internalNioBuffer(int var1, int var2) {
		return byteBuf.internalNioBuffer(var1, var2);
	}

	@Override
	public ByteBuffer[] nioBuffers() {
		return byteBuf.nioBuffers();
	}

	@Override
	public ByteBuffer[] nioBuffers(int var1, int var2) {
		return byteBuf.nioBuffers(var1, var2);
	}

	@Override
	public boolean hasArray() {
		return byteBuf.hasArray();
	}

	@Override
	public byte[] array() {
		return byteBuf.array();
	}

	@Override
	public int arrayOffset() {
		return byteBuf.arrayOffset();
	}

	@Override
	public boolean hasMemoryAddress() {
		return byteBuf.hasMemoryAddress();
	}

	@Override
	public long memoryAddress() {
		return byteBuf.memoryAddress();
	}

	@Override
	public String toString(Charset var1) {
		return byteBuf.toString(var1);
	}

	@Override
	public String toString(int var1, int var2, Charset var3) {
		return byteBuf.toString(var1, var2, var3);
	}

	@Override
	public int hashCode() {
		return byteBuf.hashCode();
	}

	@Override
	public boolean equals(Object var1) {
		return byteBuf.equals(var1);
	}

	@Override
	public int compareTo(ByteBuf var1) {
		return byteBuf.compareTo(var1);
	}

	@Override
	public String toString() {
		return byteBuf.toString();
	}

	@Override
	public ByteBuf retain(int var1) {
		return byteBuf.retain(var1);
	}

	@Override
	public ByteBuf retain() {
		return byteBuf.retain();
	}

	@Override
	public int refCnt() {
		return byteBuf.refCnt();
	}

	@Override
	public boolean release() {
		return byteBuf.release();
	}

	@Override
	public boolean release(int var1) {
		return byteBuf.release(var1);
	}

}
