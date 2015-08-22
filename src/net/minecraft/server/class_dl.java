package net.minecraft.server;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Arrays;

public class class_dl extends class_eb {
	private byte[] b;

	class_dl() {
	}

	public class_dl(byte[] var1) {
		b = var1;
	}

	@Override
	void a(DataOutput var1) throws IOException {
		var1.writeInt(b.length);
		var1.write(b);
	}

	@Override
	void a(DataInput var1, int var2, class_dw var3) throws IOException {
		var3.a(192L);
		int var4 = var1.readInt();
		var3.a(8 * var4);
		b = new byte[var4];
		var1.readFully(b);
	}

	@Override
	public byte a() {
		return (byte) 7;
	}

	@Override
	public String toString() {
		return "[" + b.length + " bytes]";
	}

	@Override
	public class_eb b() {
		byte[] var1 = new byte[b.length];
		System.arraycopy(b, 0, var1, 0, b.length);
		return new class_dl(var1);
	}

	@Override
	public boolean equals(Object var1) {
		return super.equals(var1) ? Arrays.equals(b, ((class_dl) var1).b) : false;
	}

	@Override
	public int hashCode() {
		return super.hashCode() ^ Arrays.hashCode(b);
	}

	public byte[] c() {
		return b;
	}
}
