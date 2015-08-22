package net.minecraft.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufInputStream;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.buffer.ByteBufProcessor;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.EncoderException;

import java.io.DataOutput;
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
	private final ByteBuf a;

	public PacketDataSerializer(ByteBuf var1) {
		a = var1;
	}

	public static int a(int var0) {
		for (int var1 = 1; var1 < 5; ++var1) {
			if ((var0 & (-1 << (var1 * 7))) == 0) {
				return var1;
			}
		}

		return 5;
	}

	public void a(byte[] var1) {
		this.b(var1.length);
		this.writeBytes(var1);
	}

	public byte[] a() {
		byte[] var1 = new byte[g()];
		this.readBytes(var1);
		return var1;
	}

	public void a(int[] var1) {
		this.b(var1.length);

		for (int var2 = 0; var2 < var1.length; ++var2) {
			writeInt(var1[var2]);
		}

	}

	public int[] b() {
		int[] var1 = new int[g()];

		for (int var2 = 0; var2 < var1.length; ++var2) {
			var1[var2] = readInt();
		}

		return var1;
	}

	public void a(long[] var1) {
		this.b(var1.length);

		for (int var2 = 0; var2 < var1.length; ++var2) {
			writeLong(var1[var2]);
		}

	}

	public class_cj e() {
		return class_cj.a(readLong());
	}

	public void a(class_cj var1) {
		writeLong(var1.g());
	}

	public class_eu f() {
		return class_eu.class_a_in_class_eu.a(c(32767));
	}

	public void a(class_eu var1) {
		this.a(class_eu.class_a_in_class_eu.a(var1));
	}

	public Enum a(Class var1) {
		return ((Enum[]) var1.getEnumConstants())[g()];
	}

	public void a(Enum var1) {
		this.b(var1.ordinal());
	}

	public int g() {
		int var1 = 0;
		int var2 = 0;

		byte var3;
		do {
			var3 = readByte();
			var1 |= (var3 & 127) << (var2++ * 7);
			if (var2 > 5) {
				throw new RuntimeException("VarInt too big");
			}
		} while ((var3 & 128) == 128);

		return var1;
	}

	public long h() {
		long var1 = 0L;
		int var3 = 0;

		byte var4;
		do {
			var4 = readByte();
			var1 |= (long) (var4 & 127) << (var3++ * 7);
			if (var3 > 10) {
				throw new RuntimeException("VarLong too big");
			}
		} while ((var4 & 128) == 128);

		return var1;
	}

	public void a(UUID var1) {
		writeLong(var1.getMostSignificantBits());
		writeLong(var1.getLeastSignificantBits());
	}

	public UUID i() {
		return new UUID(readLong(), readLong());
	}

	public void b(int var1) {
		while ((var1 & -128) != 0) {
			writeByte((var1 & 127) | 128);
			var1 >>>= 7;
		}

		writeByte(var1);
	}

	public void b(long var1) {
		while ((var1 & -128L) != 0L) {
			writeByte((int) (var1 & 127L) | 128);
			var1 >>>= 7;
		}

		writeByte((int) var1);
	}

	public void a(class_dn var1) {
		if (var1 == null) {
			writeByte(0);
		} else {
			try {
				class_dx.a(var1, (DataOutput) (new ByteBufOutputStream(this)));
			} catch (IOException var3) {
				throw new EncoderException(var3);
			}
		}

	}

	public class_dn j() {
		int var1 = this.readerIndex();
		byte var2 = readByte();
		if (var2 == 0) {
			return null;
		} else {
			this.readerIndex(var1);

			try {
				return class_dx.a((new ByteBufInputStream(this)), (new class_dw(2097152L)));
			} catch (IOException var4) {
				throw new EncoderException(var4);
			}
		}
	}

	public void a(class_aco var1) {
		if (var1 == null) {
			writeShort(-1);
		} else {
			writeShort(class_acm.b(var1.b()));
			writeByte(var1.b);
			writeShort(var1.i());
			class_dn var2 = null;
			if (var1.b().m() || var1.b().p()) {
				var2 = var1.o();
			}

			this.a(var2);
		}

	}

	public class_aco k() {
		class_aco var1 = null;
		short var2 = readShort();
		if (var2 >= 0) {
			byte var3 = readByte();
			short var4 = readShort();
			var1 = new class_aco(class_acm.c(var2), var3, var4);
			var1.d(j());
		}

		return var1;
	}

	public String c(int var1) {
		int var2 = g();
		if (var2 > (var1 * 4)) {
			throw new DecoderException("The received encoded string buffer length is longer than maximum allowed (" + var2 + " > " + (var1 * 4) + ")");
		} else if (var2 < 0) {
			throw new DecoderException("The received encoded string buffer length is less than zero! Weird string!");
		} else {
			String var3 = new String(this.readBytes(var2).array(), Charsets.UTF_8);
			if (var3.length() > var1) {
				throw new DecoderException("The received string length is longer than maximum allowed (" + var2 + " > " + var1 + ")");
			} else {
				return var3;
			}
		}
	}

	public PacketDataSerializer a(String var1) {
		byte[] var2 = var1.getBytes(Charsets.UTF_8);
		if (var2.length > 32767) {
			throw new EncoderException("String too big (was " + var1.length() + " bytes encoded, max " + 32767 + ")");
		} else {
			this.b(var2.length);
			this.writeBytes(var2);
			return this;
		}
	}

	@Override
	public int capacity() {
		return a.capacity();
	}

	@Override
	public ByteBuf capacity(int var1) {
		return a.capacity(var1);
	}

	@Override
	public int maxCapacity() {
		return a.maxCapacity();
	}

	@Override
	public ByteBufAllocator alloc() {
		return a.alloc();
	}

	@Override
	public ByteOrder order() {
		return a.order();
	}

	@Override
	public ByteBuf order(ByteOrder var1) {
		return a.order(var1);
	}

	@Override
	public ByteBuf unwrap() {
		return a.unwrap();
	}

	@Override
	public boolean isDirect() {
		return a.isDirect();
	}

	@Override
	public int readerIndex() {
		return a.readerIndex();
	}

	@Override
	public ByteBuf readerIndex(int var1) {
		return a.readerIndex(var1);
	}

	@Override
	public int writerIndex() {
		return a.writerIndex();
	}

	@Override
	public ByteBuf writerIndex(int var1) {
		return a.writerIndex(var1);
	}

	@Override
	public ByteBuf setIndex(int var1, int var2) {
		return a.setIndex(var1, var2);
	}

	@Override
	public int readableBytes() {
		return a.readableBytes();
	}

	@Override
	public int writableBytes() {
		return a.writableBytes();
	}

	@Override
	public int maxWritableBytes() {
		return a.maxWritableBytes();
	}

	@Override
	public boolean isReadable() {
		return a.isReadable();
	}

	@Override
	public boolean isReadable(int var1) {
		return a.isReadable(var1);
	}

	@Override
	public boolean isWritable() {
		return a.isWritable();
	}

	@Override
	public boolean isWritable(int var1) {
		return a.isWritable(var1);
	}

	@Override
	public ByteBuf clear() {
		return a.clear();
	}

	@Override
	public ByteBuf markReaderIndex() {
		return a.markReaderIndex();
	}

	@Override
	public ByteBuf resetReaderIndex() {
		return a.resetReaderIndex();
	}

	@Override
	public ByteBuf markWriterIndex() {
		return a.markWriterIndex();
	}

	@Override
	public ByteBuf resetWriterIndex() {
		return a.resetWriterIndex();
	}

	@Override
	public ByteBuf discardReadBytes() {
		return a.discardReadBytes();
	}

	@Override
	public ByteBuf discardSomeReadBytes() {
		return a.discardSomeReadBytes();
	}

	@Override
	public ByteBuf ensureWritable(int var1) {
		return a.ensureWritable(var1);
	}

	@Override
	public int ensureWritable(int var1, boolean var2) {
		return a.ensureWritable(var1, var2);
	}

	@Override
	public boolean getBoolean(int var1) {
		return a.getBoolean(var1);
	}

	@Override
	public byte getByte(int var1) {
		return a.getByte(var1);
	}

	@Override
	public short getUnsignedByte(int var1) {
		return a.getUnsignedByte(var1);
	}

	@Override
	public short getShort(int var1) {
		return a.getShort(var1);
	}

	@Override
	public int getUnsignedShort(int var1) {
		return a.getUnsignedShort(var1);
	}

	@Override
	public int getMedium(int var1) {
		return a.getMedium(var1);
	}

	@Override
	public int getUnsignedMedium(int var1) {
		return a.getUnsignedMedium(var1);
	}

	@Override
	public int getInt(int var1) {
		return a.getInt(var1);
	}

	@Override
	public long getUnsignedInt(int var1) {
		return a.getUnsignedInt(var1);
	}

	@Override
	public long getLong(int var1) {
		return a.getLong(var1);
	}

	@Override
	public char getChar(int var1) {
		return a.getChar(var1);
	}

	@Override
	public float getFloat(int var1) {
		return a.getFloat(var1);
	}

	@Override
	public double getDouble(int var1) {
		return a.getDouble(var1);
	}

	@Override
	public ByteBuf getBytes(int var1, ByteBuf var2) {
		return a.getBytes(var1, var2);
	}

	@Override
	public ByteBuf getBytes(int var1, ByteBuf var2, int var3) {
		return a.getBytes(var1, var2, var3);
	}

	@Override
	public ByteBuf getBytes(int var1, ByteBuf var2, int var3, int var4) {
		return a.getBytes(var1, var2, var3, var4);
	}

	@Override
	public ByteBuf getBytes(int var1, byte[] var2) {
		return a.getBytes(var1, var2);
	}

	@Override
	public ByteBuf getBytes(int var1, byte[] var2, int var3, int var4) {
		return a.getBytes(var1, var2, var3, var4);
	}

	@Override
	public ByteBuf getBytes(int var1, ByteBuffer var2) {
		return a.getBytes(var1, var2);
	}

	@Override
	public ByteBuf getBytes(int var1, OutputStream var2, int var3) throws IOException {
		return a.getBytes(var1, var2, var3);
	}

	@Override
	public int getBytes(int var1, GatheringByteChannel var2, int var3) throws IOException {
		return a.getBytes(var1, var2, var3);
	}

	@Override
	public ByteBuf setBoolean(int var1, boolean var2) {
		return a.setBoolean(var1, var2);
	}

	@Override
	public ByteBuf setByte(int var1, int var2) {
		return a.setByte(var1, var2);
	}

	@Override
	public ByteBuf setShort(int var1, int var2) {
		return a.setShort(var1, var2);
	}

	@Override
	public ByteBuf setMedium(int var1, int var2) {
		return a.setMedium(var1, var2);
	}

	@Override
	public ByteBuf setInt(int var1, int var2) {
		return a.setInt(var1, var2);
	}

	@Override
	public ByteBuf setLong(int var1, long var2) {
		return a.setLong(var1, var2);
	}

	@Override
	public ByteBuf setChar(int var1, int var2) {
		return a.setChar(var1, var2);
	}

	@Override
	public ByteBuf setFloat(int var1, float var2) {
		return a.setFloat(var1, var2);
	}

	@Override
	public ByteBuf setDouble(int var1, double var2) {
		return a.setDouble(var1, var2);
	}

	@Override
	public ByteBuf setBytes(int var1, ByteBuf var2) {
		return a.setBytes(var1, var2);
	}

	@Override
	public ByteBuf setBytes(int var1, ByteBuf var2, int var3) {
		return a.setBytes(var1, var2, var3);
	}

	@Override
	public ByteBuf setBytes(int var1, ByteBuf var2, int var3, int var4) {
		return a.setBytes(var1, var2, var3, var4);
	}

	@Override
	public ByteBuf setBytes(int var1, byte[] var2) {
		return a.setBytes(var1, var2);
	}

	@Override
	public ByteBuf setBytes(int var1, byte[] var2, int var3, int var4) {
		return a.setBytes(var1, var2, var3, var4);
	}

	@Override
	public ByteBuf setBytes(int var1, ByteBuffer var2) {
		return a.setBytes(var1, var2);
	}

	@Override
	public int setBytes(int var1, InputStream var2, int var3) throws IOException {
		return a.setBytes(var1, var2, var3);
	}

	@Override
	public int setBytes(int var1, ScatteringByteChannel var2, int var3) throws IOException {
		return a.setBytes(var1, var2, var3);
	}

	@Override
	public ByteBuf setZero(int var1, int var2) {
		return a.setZero(var1, var2);
	}

	@Override
	public boolean readBoolean() {
		return a.readBoolean();
	}

	@Override
	public byte readByte() {
		return a.readByte();
	}

	@Override
	public short readUnsignedByte() {
		return a.readUnsignedByte();
	}

	@Override
	public short readShort() {
		return a.readShort();
	}

	@Override
	public int readUnsignedShort() {
		return a.readUnsignedShort();
	}

	@Override
	public int readMedium() {
		return a.readMedium();
	}

	@Override
	public int readUnsignedMedium() {
		return a.readUnsignedMedium();
	}

	@Override
	public int readInt() {
		return a.readInt();
	}

	@Override
	public long readUnsignedInt() {
		return a.readUnsignedInt();
	}

	@Override
	public long readLong() {
		return a.readLong();
	}

	@Override
	public char readChar() {
		return a.readChar();
	}

	@Override
	public float readFloat() {
		return a.readFloat();
	}

	@Override
	public double readDouble() {
		return a.readDouble();
	}

	@Override
	public ByteBuf readBytes(int var1) {
		return a.readBytes(var1);
	}

	@Override
	public ByteBuf readSlice(int var1) {
		return a.readSlice(var1);
	}

	@Override
	public ByteBuf readBytes(ByteBuf var1) {
		return a.readBytes(var1);
	}

	@Override
	public ByteBuf readBytes(ByteBuf var1, int var2) {
		return a.readBytes(var1, var2);
	}

	@Override
	public ByteBuf readBytes(ByteBuf var1, int var2, int var3) {
		return a.readBytes(var1, var2, var3);
	}

	@Override
	public ByteBuf readBytes(byte[] var1) {
		return a.readBytes(var1);
	}

	@Override
	public ByteBuf readBytes(byte[] var1, int var2, int var3) {
		return a.readBytes(var1, var2, var3);
	}

	@Override
	public ByteBuf readBytes(ByteBuffer var1) {
		return a.readBytes(var1);
	}

	@Override
	public ByteBuf readBytes(OutputStream var1, int var2) throws IOException {
		return a.readBytes(var1, var2);
	}

	@Override
	public int readBytes(GatheringByteChannel var1, int var2) throws IOException {
		return a.readBytes(var1, var2);
	}

	@Override
	public ByteBuf skipBytes(int var1) {
		return a.skipBytes(var1);
	}

	@Override
	public ByteBuf writeBoolean(boolean var1) {
		return a.writeBoolean(var1);
	}

	@Override
	public ByteBuf writeByte(int var1) {
		return a.writeByte(var1);
	}

	@Override
	public ByteBuf writeShort(int var1) {
		return a.writeShort(var1);
	}

	@Override
	public ByteBuf writeMedium(int var1) {
		return a.writeMedium(var1);
	}

	@Override
	public ByteBuf writeInt(int var1) {
		return a.writeInt(var1);
	}

	@Override
	public ByteBuf writeLong(long var1) {
		return a.writeLong(var1);
	}

	@Override
	public ByteBuf writeChar(int var1) {
		return a.writeChar(var1);
	}

	@Override
	public ByteBuf writeFloat(float var1) {
		return a.writeFloat(var1);
	}

	@Override
	public ByteBuf writeDouble(double var1) {
		return a.writeDouble(var1);
	}

	@Override
	public ByteBuf writeBytes(ByteBuf var1) {
		return a.writeBytes(var1);
	}

	@Override
	public ByteBuf writeBytes(ByteBuf var1, int var2) {
		return a.writeBytes(var1, var2);
	}

	@Override
	public ByteBuf writeBytes(ByteBuf var1, int var2, int var3) {
		return a.writeBytes(var1, var2, var3);
	}

	@Override
	public ByteBuf writeBytes(byte[] var1) {
		return a.writeBytes(var1);
	}

	@Override
	public ByteBuf writeBytes(byte[] var1, int var2, int var3) {
		return a.writeBytes(var1, var2, var3);
	}

	@Override
	public ByteBuf writeBytes(ByteBuffer var1) {
		return a.writeBytes(var1);
	}

	@Override
	public int writeBytes(InputStream var1, int var2) throws IOException {
		return a.writeBytes(var1, var2);
	}

	@Override
	public int writeBytes(ScatteringByteChannel var1, int var2) throws IOException {
		return a.writeBytes(var1, var2);
	}

	@Override
	public ByteBuf writeZero(int var1) {
		return a.writeZero(var1);
	}

	@Override
	public int indexOf(int var1, int var2, byte var3) {
		return a.indexOf(var1, var2, var3);
	}

	@Override
	public int bytesBefore(byte var1) {
		return a.bytesBefore(var1);
	}

	@Override
	public int bytesBefore(int var1, byte var2) {
		return a.bytesBefore(var1, var2);
	}

	@Override
	public int bytesBefore(int var1, int var2, byte var3) {
		return a.bytesBefore(var1, var2, var3);
	}

	@Override
	public int forEachByte(ByteBufProcessor var1) {
		return a.forEachByte(var1);
	}

	@Override
	public int forEachByte(int var1, int var2, ByteBufProcessor var3) {
		return a.forEachByte(var1, var2, var3);
	}

	@Override
	public int forEachByteDesc(ByteBufProcessor var1) {
		return a.forEachByteDesc(var1);
	}

	@Override
	public int forEachByteDesc(int var1, int var2, ByteBufProcessor var3) {
		return a.forEachByteDesc(var1, var2, var3);
	}

	@Override
	public ByteBuf copy() {
		return a.copy();
	}

	@Override
	public ByteBuf copy(int var1, int var2) {
		return a.copy(var1, var2);
	}

	@Override
	public ByteBuf slice() {
		return a.slice();
	}

	@Override
	public ByteBuf slice(int var1, int var2) {
		return a.slice(var1, var2);
	}

	@Override
	public ByteBuf duplicate() {
		return a.duplicate();
	}

	@Override
	public int nioBufferCount() {
		return a.nioBufferCount();
	}

	@Override
	public ByteBuffer nioBuffer() {
		return a.nioBuffer();
	}

	@Override
	public ByteBuffer nioBuffer(int var1, int var2) {
		return a.nioBuffer(var1, var2);
	}

	@Override
	public ByteBuffer internalNioBuffer(int var1, int var2) {
		return a.internalNioBuffer(var1, var2);
	}

	@Override
	public ByteBuffer[] nioBuffers() {
		return a.nioBuffers();
	}

	@Override
	public ByteBuffer[] nioBuffers(int var1, int var2) {
		return a.nioBuffers(var1, var2);
	}

	@Override
	public boolean hasArray() {
		return a.hasArray();
	}

	@Override
	public byte[] array() {
		return a.array();
	}

	@Override
	public int arrayOffset() {
		return a.arrayOffset();
	}

	@Override
	public boolean hasMemoryAddress() {
		return a.hasMemoryAddress();
	}

	@Override
	public long memoryAddress() {
		return a.memoryAddress();
	}

	@Override
	public String toString(Charset var1) {
		return a.toString(var1);
	}

	@Override
	public String toString(int var1, int var2, Charset var3) {
		return a.toString(var1, var2, var3);
	}

	@Override
	public int hashCode() {
		return a.hashCode();
	}

	@Override
	public boolean equals(Object var1) {
		return a.equals(var1);
	}

	@Override
	public int compareTo(ByteBuf var1) {
		return a.compareTo(var1);
	}

	@Override
	public String toString() {
		return a.toString();
	}

	@Override
	public ByteBuf retain(int var1) {
		return a.retain(var1);
	}

	@Override
	public ByteBuf retain() {
		return a.retain();
	}

	@Override
	public int refCnt() {
		return a.refCnt();
	}

	@Override
	public boolean release() {
		return a.release();
	}

	@Override
	public boolean release(int var1) {
		return a.release(var1);
	}

}
