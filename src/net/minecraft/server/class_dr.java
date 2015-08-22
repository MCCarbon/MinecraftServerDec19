package net.minecraft.server;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class class_dr extends class_eb.class_a_in_class_eb {
	private float b;

	class_dr() {
	}

	public class_dr(float var1) {
		b = var1;
	}

	@Override
	void a(DataOutput var1) throws IOException {
		var1.writeFloat(b);
	}

	@Override
	void a(DataInput var1, int var2, class_dw var3) throws IOException {
		var3.a(96L);
		b = var1.readFloat();
	}

	@Override
	public byte a() {
		return (byte) 5;
	}

	@Override
	public String toString() {
		return "" + b + "f";
	}

	@Override
	public class_eb b() {
		return new class_dr(b);
	}

	@Override
	public boolean equals(Object var1) {
		if (super.equals(var1)) {
			class_dr var2 = (class_dr) var1;
			return b == var2.b;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return super.hashCode() ^ Float.floatToIntBits(b);
	}

	@Override
	public long c() {
		return (long) b;
	}

	@Override
	public int d() {
		return class_oa.d(b);
	}

	@Override
	public short e() {
		return (short) (class_oa.d(b) & '\uffff');
	}

	@Override
	public byte f() {
		return (byte) (class_oa.d(b) & 255);
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
