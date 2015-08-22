package net.minecraft.server;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class class_dm extends class_eb.class_a_in_class_eb {
	private byte b;

	class_dm() {
	}

	public class_dm(byte var1) {
		b = var1;
	}

	@Override
	void a(DataOutput var1) throws IOException {
		var1.writeByte(b);
	}

	@Override
	void a(DataInput var1, int var2, class_dw var3) throws IOException {
		var3.a(72L);
		b = var1.readByte();
	}

	@Override
	public byte a() {
		return (byte) 1;
	}

	@Override
	public String toString() {
		return "" + b + "b";
	}

	@Override
	public class_eb b() {
		return new class_dm(b);
	}

	@Override
	public boolean equals(Object var1) {
		if (super.equals(var1)) {
			class_dm var2 = (class_dm) var1;
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
		return b;
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
