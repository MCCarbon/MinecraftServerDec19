package net.minecraft.server;

import com.google.common.base.Charsets;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufInputStream;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.buffer.ByteBufProcessor;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.EncoderException;
import io.netty.util.ReferenceCounted;
import java.io.DataInput;
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
import net.minecraft.server.Item;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_dw;
import net.minecraft.server.class_dx;
import net.minecraft.server.class_eu;

public class class_em extends ByteBuf {
	private final ByteBuf a;

	public class_em(ByteBuf var1) {
		this.a = var1;
	}

	public static int a(int var0) {
		for (int var1 = 1; var1 < 5; ++var1) {
			if ((var0 & -1 << var1 * 7) == 0) {
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
		byte[] var1 = new byte[this.e()];
		this.readBytes(var1);
		return var1;
	}

	public class_cj c() {
		return class_cj.a(this.readLong());
	}

	public void a(class_cj var1) {
		this.writeLong(var1.g());
	}

	public class_eu d() throws IOException {
		return class_eu.class_a_in_class_eu.a(this.c(32767));
	}

	public void a(class_eu var1) throws IOException {
		this.a(class_eu.class_a_in_class_eu.a(var1));
	}

	public Enum a(Class var1) {
		return ((Enum[]) var1.getEnumConstants())[this.e()];
	}

	public void a(Enum var1) {
		this.b(var1.ordinal());
	}

	public int e() {
		int var1 = 0;
		int var2 = 0;

		byte var3;
		do {
			var3 = this.readByte();
			var1 |= (var3 & 127) << var2++ * 7;
			if (var2 > 5) {
				throw new RuntimeException("VarInt too big");
			}
		} while ((var3 & 128) == 128);

		return var1;
	}

	public long f() {
		long var1 = 0L;
		int var3 = 0;

		byte var4;
		do {
			var4 = this.readByte();
			var1 |= (long) (var4 & 127) << var3++ * 7;
			if (var3 > 10) {
				throw new RuntimeException("VarLong too big");
			}
		} while ((var4 & 128) == 128);

		return var1;
	}

	public void a(UUID var1) {
		this.writeLong(var1.getMostSignificantBits());
		this.writeLong(var1.getLeastSignificantBits());
	}

	public UUID g() {
		return new UUID(this.readLong(), this.readLong());
	}

	public void b(int var1) {
		while ((var1 & -128) != 0) {
			this.writeByte(var1 & 127 | 128);
			var1 >>>= 7;
		}

		this.writeByte(var1);
	}

	public void b(long var1) {
		while ((var1 & -128L) != 0L) {
			this.writeByte((int) (var1 & 127L) | 128);
			var1 >>>= 7;
		}

		this.writeByte((int) var1);
	}

	public void a(class_dn var1) {
		if (var1 == null) {
			this.writeByte(0);
		} else {
			try {
				class_dx.a((class_dn) var1, (DataOutput) (new ByteBufOutputStream(this)));
			} catch (IOException var3) {
				throw new EncoderException(var3);
			}
		}

	}

	public class_dn h() throws IOException {
		int var1 = this.readerIndex();
		byte var2 = this.readByte();
		if (var2 == 0) {
			return null;
		} else {
			this.readerIndex(var1);
			return class_dx.a((DataInput) (new ByteBufInputStream(this)), (class_dw) (new class_dw(2097152L)));
		}
	}

	public void a(class_aas var1) {
		if (var1 == null) {
			this.writeShort(-1);
		} else {
			this.writeShort(Item.getId(var1.b()));
			this.writeByte(var1.b);
			this.writeShort(var1.i());
			class_dn var2 = null;
			if (var1.b().m() || var1.b().p()) {
				var2 = var1.o();
			}

			this.a(var2);
		}

	}

	public class_aas i() throws IOException {
		class_aas var1 = null;
		short var2 = this.readShort();
		if (var2 >= 0) {
			byte var3 = this.readByte();
			short var4 = this.readShort();
			var1 = new class_aas(Item.getById(var2), var3, var4);
			var1.d(this.h());
		}

		return var1;
	}

	public String c(int var1) {
		int var2 = this.e();
		if (var2 > var1 * 4) {
			throw new DecoderException("The received encoded string buffer length is longer than maximum allowed (" + var2 + " > " + var1 * 4 + ")");
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

	public class_em a(String var1) {
		byte[] var2 = var1.getBytes(Charsets.UTF_8);
		if (var2.length > 32767) {
			throw new EncoderException("String too big (was " + var1.length() + " bytes encoded, max " + 32767 + ")");
		} else {
			this.b(var2.length);
			this.writeBytes(var2);
			return this;
		}
	}

	public int capacity() {
		return this.a.capacity();
	}

	public ByteBuf capacity(int var1) {
		return this.a.capacity(var1);
	}

	public int maxCapacity() {
		return this.a.maxCapacity();
	}

	public ByteBufAllocator alloc() {
		return this.a.alloc();
	}

	public ByteOrder order() {
		return this.a.order();
	}

	public ByteBuf order(ByteOrder var1) {
		return this.a.order(var1);
	}

	public ByteBuf unwrap() {
		return this.a.unwrap();
	}

	public boolean isDirect() {
		return this.a.isDirect();
	}

	public int readerIndex() {
		return this.a.readerIndex();
	}

	public ByteBuf readerIndex(int var1) {
		return this.a.readerIndex(var1);
	}

	public int writerIndex() {
		return this.a.writerIndex();
	}

	public ByteBuf writerIndex(int var1) {
		return this.a.writerIndex(var1);
	}

	public ByteBuf setIndex(int var1, int var2) {
		return this.a.setIndex(var1, var2);
	}

	public int readableBytes() {
		return this.a.readableBytes();
	}

	public int writableBytes() {
		return this.a.writableBytes();
	}

	public int maxWritableBytes() {
		return this.a.maxWritableBytes();
	}

	public boolean isReadable() {
		return this.a.isReadable();
	}

	public boolean isReadable(int var1) {
		return this.a.isReadable(var1);
	}

	public boolean isWritable() {
		return this.a.isWritable();
	}

	public boolean isWritable(int var1) {
		return this.a.isWritable(var1);
	}

	public ByteBuf clear() {
		return this.a.clear();
	}

	public ByteBuf markReaderIndex() {
		return this.a.markReaderIndex();
	}

	public ByteBuf resetReaderIndex() {
		return this.a.resetReaderIndex();
	}

	public ByteBuf markWriterIndex() {
		return this.a.markWriterIndex();
	}

	public ByteBuf resetWriterIndex() {
		return this.a.resetWriterIndex();
	}

	public ByteBuf discardReadBytes() {
		return this.a.discardReadBytes();
	}

	public ByteBuf discardSomeReadBytes() {
		return this.a.discardSomeReadBytes();
	}

	public ByteBuf ensureWritable(int var1) {
		return this.a.ensureWritable(var1);
	}

	public int ensureWritable(int var1, boolean var2) {
		return this.a.ensureWritable(var1, var2);
	}

	public boolean getBoolean(int var1) {
		return this.a.getBoolean(var1);
	}

	public byte getByte(int var1) {
		return this.a.getByte(var1);
	}

	public short getUnsignedByte(int var1) {
		return this.a.getUnsignedByte(var1);
	}

	public short getShort(int var1) {
		return this.a.getShort(var1);
	}

	public int getUnsignedShort(int var1) {
		return this.a.getUnsignedShort(var1);
	}

	public int getMedium(int var1) {
		return this.a.getMedium(var1);
	}

	public int getUnsignedMedium(int var1) {
		return this.a.getUnsignedMedium(var1);
	}

	public int getInt(int var1) {
		return this.a.getInt(var1);
	}

	public long getUnsignedInt(int var1) {
		return this.a.getUnsignedInt(var1);
	}

	public long getLong(int var1) {
		return this.a.getLong(var1);
	}

	public char getChar(int var1) {
		return this.a.getChar(var1);
	}

	public float getFloat(int var1) {
		return this.a.getFloat(var1);
	}

	public double getDouble(int var1) {
		return this.a.getDouble(var1);
	}

	public ByteBuf getBytes(int var1, ByteBuf var2) {
		return this.a.getBytes(var1, var2);
	}

	public ByteBuf getBytes(int var1, ByteBuf var2, int var3) {
		return this.a.getBytes(var1, var2, var3);
	}

	public ByteBuf getBytes(int var1, ByteBuf var2, int var3, int var4) {
		return this.a.getBytes(var1, var2, var3, var4);
	}

	public ByteBuf getBytes(int var1, byte[] var2) {
		return this.a.getBytes(var1, var2);
	}

	public ByteBuf getBytes(int var1, byte[] var2, int var3, int var4) {
		return this.a.getBytes(var1, var2, var3, var4);
	}

	public ByteBuf getBytes(int var1, ByteBuffer var2) {
		return this.a.getBytes(var1, var2);
	}

	public ByteBuf getBytes(int var1, OutputStream var2, int var3) throws IOException {
		return this.a.getBytes(var1, var2, var3);
	}

	public int getBytes(int var1, GatheringByteChannel var2, int var3) throws IOException {
		return this.a.getBytes(var1, var2, var3);
	}

	public ByteBuf setBoolean(int var1, boolean var2) {
		return this.a.setBoolean(var1, var2);
	}

	public ByteBuf setByte(int var1, int var2) {
		return this.a.setByte(var1, var2);
	}

	public ByteBuf setShort(int var1, int var2) {
		return this.a.setShort(var1, var2);
	}

	public ByteBuf setMedium(int var1, int var2) {
		return this.a.setMedium(var1, var2);
	}

	public ByteBuf setInt(int var1, int var2) {
		return this.a.setInt(var1, var2);
	}

	public ByteBuf setLong(int var1, long var2) {
		return this.a.setLong(var1, var2);
	}

	public ByteBuf setChar(int var1, int var2) {
		return this.a.setChar(var1, var2);
	}

	public ByteBuf setFloat(int var1, float var2) {
		return this.a.setFloat(var1, var2);
	}

	public ByteBuf setDouble(int var1, double var2) {
		return this.a.setDouble(var1, var2);
	}

	public ByteBuf setBytes(int var1, ByteBuf var2) {
		return this.a.setBytes(var1, var2);
	}

	public ByteBuf setBytes(int var1, ByteBuf var2, int var3) {
		return this.a.setBytes(var1, var2, var3);
	}

	public ByteBuf setBytes(int var1, ByteBuf var2, int var3, int var4) {
		return this.a.setBytes(var1, var2, var3, var4);
	}

	public ByteBuf setBytes(int var1, byte[] var2) {
		return this.a.setBytes(var1, var2);
	}

	public ByteBuf setBytes(int var1, byte[] var2, int var3, int var4) {
		return this.a.setBytes(var1, var2, var3, var4);
	}

	public ByteBuf setBytes(int var1, ByteBuffer var2) {
		return this.a.setBytes(var1, var2);
	}

	public int setBytes(int var1, InputStream var2, int var3) throws IOException {
		return this.a.setBytes(var1, var2, var3);
	}

	public int setBytes(int var1, ScatteringByteChannel var2, int var3) throws IOException {
		return this.a.setBytes(var1, var2, var3);
	}

	public ByteBuf setZero(int var1, int var2) {
		return this.a.setZero(var1, var2);
	}

	public boolean readBoolean() {
		return this.a.readBoolean();
	}

	public byte readByte() {
		return this.a.readByte();
	}

	public short readUnsignedByte() {
		return this.a.readUnsignedByte();
	}

	public short readShort() {
		return this.a.readShort();
	}

	public int readUnsignedShort() {
		return this.a.readUnsignedShort();
	}

	public int readMedium() {
		return this.a.readMedium();
	}

	public int readUnsignedMedium() {
		return this.a.readUnsignedMedium();
	}

	public int readInt() {
		return this.a.readInt();
	}

	public long readUnsignedInt() {
		return this.a.readUnsignedInt();
	}

	public long readLong() {
		return this.a.readLong();
	}

	public char readChar() {
		return this.a.readChar();
	}

	public float readFloat() {
		return this.a.readFloat();
	}

	public double readDouble() {
		return this.a.readDouble();
	}

	public ByteBuf readBytes(int var1) {
		return this.a.readBytes(var1);
	}

	public ByteBuf readSlice(int var1) {
		return this.a.readSlice(var1);
	}

	public ByteBuf readBytes(ByteBuf var1) {
		return this.a.readBytes(var1);
	}

	public ByteBuf readBytes(ByteBuf var1, int var2) {
		return this.a.readBytes(var1, var2);
	}

	public ByteBuf readBytes(ByteBuf var1, int var2, int var3) {
		return this.a.readBytes(var1, var2, var3);
	}

	public ByteBuf readBytes(byte[] var1) {
		return this.a.readBytes(var1);
	}

	public ByteBuf readBytes(byte[] var1, int var2, int var3) {
		return this.a.readBytes(var1, var2, var3);
	}

	public ByteBuf readBytes(ByteBuffer var1) {
		return this.a.readBytes(var1);
	}

	public ByteBuf readBytes(OutputStream var1, int var2) throws IOException {
		return this.a.readBytes(var1, var2);
	}

	public int readBytes(GatheringByteChannel var1, int var2) throws IOException {
		return this.a.readBytes(var1, var2);
	}

	public ByteBuf skipBytes(int var1) {
		return this.a.skipBytes(var1);
	}

	public ByteBuf writeBoolean(boolean var1) {
		return this.a.writeBoolean(var1);
	}

	public ByteBuf writeByte(int var1) {
		return this.a.writeByte(var1);
	}

	public ByteBuf writeShort(int var1) {
		return this.a.writeShort(var1);
	}

	public ByteBuf writeMedium(int var1) {
		return this.a.writeMedium(var1);
	}

	public ByteBuf writeInt(int var1) {
		return this.a.writeInt(var1);
	}

	public ByteBuf writeLong(long var1) {
		return this.a.writeLong(var1);
	}

	public ByteBuf writeChar(int var1) {
		return this.a.writeChar(var1);
	}

	public ByteBuf writeFloat(float var1) {
		return this.a.writeFloat(var1);
	}

	public ByteBuf writeDouble(double var1) {
		return this.a.writeDouble(var1);
	}

	public ByteBuf writeBytes(ByteBuf var1) {
		return this.a.writeBytes(var1);
	}

	public ByteBuf writeBytes(ByteBuf var1, int var2) {
		return this.a.writeBytes(var1, var2);
	}

	public ByteBuf writeBytes(ByteBuf var1, int var2, int var3) {
		return this.a.writeBytes(var1, var2, var3);
	}

	public ByteBuf writeBytes(byte[] var1) {
		return this.a.writeBytes(var1);
	}

	public ByteBuf writeBytes(byte[] var1, int var2, int var3) {
		return this.a.writeBytes(var1, var2, var3);
	}

	public ByteBuf writeBytes(ByteBuffer var1) {
		return this.a.writeBytes(var1);
	}

	public int writeBytes(InputStream var1, int var2) throws IOException {
		return this.a.writeBytes(var1, var2);
	}

	public int writeBytes(ScatteringByteChannel var1, int var2) throws IOException {
		return this.a.writeBytes(var1, var2);
	}

	public ByteBuf writeZero(int var1) {
		return this.a.writeZero(var1);
	}

	public int indexOf(int var1, int var2, byte var3) {
		return this.a.indexOf(var1, var2, var3);
	}

	public int bytesBefore(byte var1) {
		return this.a.bytesBefore(var1);
	}

	public int bytesBefore(int var1, byte var2) {
		return this.a.bytesBefore(var1, var2);
	}

	public int bytesBefore(int var1, int var2, byte var3) {
		return this.a.bytesBefore(var1, var2, var3);
	}

	public int forEachByte(ByteBufProcessor var1) {
		return this.a.forEachByte(var1);
	}

	public int forEachByte(int var1, int var2, ByteBufProcessor var3) {
		return this.a.forEachByte(var1, var2, var3);
	}

	public int forEachByteDesc(ByteBufProcessor var1) {
		return this.a.forEachByteDesc(var1);
	}

	public int forEachByteDesc(int var1, int var2, ByteBufProcessor var3) {
		return this.a.forEachByteDesc(var1, var2, var3);
	}

	public ByteBuf copy() {
		return this.a.copy();
	}

	public ByteBuf copy(int var1, int var2) {
		return this.a.copy(var1, var2);
	}

	public ByteBuf slice() {
		return this.a.slice();
	}

	public ByteBuf slice(int var1, int var2) {
		return this.a.slice(var1, var2);
	}

	public ByteBuf duplicate() {
		return this.a.duplicate();
	}

	public int nioBufferCount() {
		return this.a.nioBufferCount();
	}

	public ByteBuffer nioBuffer() {
		return this.a.nioBuffer();
	}

	public ByteBuffer nioBuffer(int var1, int var2) {
		return this.a.nioBuffer(var1, var2);
	}

	public ByteBuffer internalNioBuffer(int var1, int var2) {
		return this.a.internalNioBuffer(var1, var2);
	}

	public ByteBuffer[] nioBuffers() {
		return this.a.nioBuffers();
	}

	public ByteBuffer[] nioBuffers(int var1, int var2) {
		return this.a.nioBuffers(var1, var2);
	}

	public boolean hasArray() {
		return this.a.hasArray();
	}

	public byte[] array() {
		return this.a.array();
	}

	public int arrayOffset() {
		return this.a.arrayOffset();
	}

	public boolean hasMemoryAddress() {
		return this.a.hasMemoryAddress();
	}

	public long memoryAddress() {
		return this.a.memoryAddress();
	}

	public String toString(Charset var1) {
		return this.a.toString(var1);
	}

	public String toString(int var1, int var2, Charset var3) {
		return this.a.toString(var1, var2, var3);
	}

	public int hashCode() {
		return this.a.hashCode();
	}

	public boolean equals(Object var1) {
		return this.a.equals(var1);
	}

	public int compareTo(ByteBuf var1) {
		return this.a.compareTo(var1);
	}

	public String toString() {
		return this.a.toString();
	}

	public ByteBuf retain(int var1) {
		return this.a.retain(var1);
	}

	public ByteBuf retain() {
		return this.a.retain();
	}

	public int refCnt() {
		return this.a.refCnt();
	}

	public boolean release() {
		return this.a.release();
	}

	public boolean release(int var1) {
		return this.a.release(var1);
	}

}
