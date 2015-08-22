package net.minecraft.server;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class class_dv extends class_eb.class_a_in_class_eb {
	private long b;

	class_dv() {
	}

	public class_dv(long var1) {
		b = var1;
	}

	@Override
	void a(DataOutput var1) throws IOException {
		var1.writeLong(b);
	}

	@Override
	void a(DataInput var1, int var2, class_dw var3) throws IOException {
		var3.a(128L);
		b = var1.readLong();
	}

	@Override
	public byte a() {
		return (byte) 4;
	}

	@Override
	public String toString() {
		return "" + b + "L";
	}

	@Override
	public class_eb b() {
		return new class_dv(b);
	}

	@Override
	public boolean equals(Object var1) {
		if (super.equals(var1)) {
			class_dv var2 = (class_dv) var1;
			return b == var2.b;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return super.hashCode() ^ (int) (b ^ (b >>> 32));
	}

	@Override
	public long c() {
		return b;
	}

	@Override
	public int d() {
		return (int) (b & -1L);
	}

	@Override
	public short e() {
		return (short) ((int) (b & 65535L));
	}

	@Override
	public byte f() {
		return (byte) ((int) (b & 255L));
	}

	@Override
	public double g() {
		return b;
	}

	@Override
	public float h() {
		return b;
	}
}
