package net.minecraft.server;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class class_dz extends class_eb.class_a_in_class_eb {
	private short b;

	public class_dz() {
	}

	public class_dz(short var1) {
		b = var1;
	}

	@Override
	void a(DataOutput var1) throws IOException {
		var1.writeShort(b);
	}

	@Override
	void a(DataInput var1, int var2, class_dw var3) throws IOException {
		var3.a(80L);
		b = var1.readShort();
	}

	@Override
	public byte a() {
		return (byte) 2;
	}

	@Override
	public String toString() {
		return "" + b + "s";
	}

	@Override
	public class_eb b() {
		return new class_dz(b);
	}

	@Override
	public boolean equals(Object var1) {
		if (super.equals(var1)) {
			class_dz var2 = (class_dz) var1;
			return b == var2.b;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return super.hashCode() ^ b;
	}

	@Override
	public long c() {
		return b;
	}

	@Override
	public int d() {
		return b;
	}

	@Override
	public short e() {
		return b;
	}

	@Override
	public byte f() {
		return (byte) (b & 255);
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
