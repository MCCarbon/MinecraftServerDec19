package net.minecraft.server;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class class_dp extends class_eb.class_a_in_class_eb {
	private double b;

	class_dp() {
	}

	public class_dp(double var1) {
		b = var1;
	}

	@Override
	void a(DataOutput var1) throws IOException {
		var1.writeDouble(b);
	}

	@Override
	void a(DataInput var1, int var2, class_dw var3) throws IOException {
		var3.a(128L);
		b = var1.readDouble();
	}

	@Override
	public byte a() {
		return (byte) 6;
	}

	@Override
	public String toString() {
		return "" + b + "d";
	}

	@Override
	public class_eb b() {
		return new class_dp(b);
	}

	@Override
	public boolean equals(Object var1) {
		if (super.equals(var1)) {
			class_dp var2 = (class_dp) var1;
			return b == var2.b;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		long var1 = Double.doubleToLongBits(b);
		return super.hashCode() ^ (int) (var1 ^ (var1 >>> 32));
	}

	@Override
	public long c() {
		return (long) Math.floor(b);
	}

	@Override
	public int d() {
		return MathHelper.c(b);
	}

	@Override
	public short e() {
		return (short) (MathHelper.c(b) & '\uffff');
	}

	@Override
	public byte f() {
		return (byte) (MathHelper.c(b) & 255);
	}

	@Override
	public double g() {
		return b;
	}

	@Override
	public float h() {
		return (float) b;
	}
}
