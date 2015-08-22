package net.minecraft.server;

public class class_axk {
	private byte a;
	private byte b;
	private byte c;
	private byte d;

	public class_axk(byte var1, byte var2, byte var3, byte var4) {
		a = var1;
		b = var2;
		c = var3;
		d = var4;
	}

	public class_axk(class_axk var1) {
		a = var1.a;
		b = var1.b;
		c = var1.c;
		d = var1.d;
	}

	public byte a() {
		return a;
	}

	public byte b() {
		return b;
	}

	public byte c() {
		return c;
	}

	public byte d() {
		return d;
	}

	@Override
	public boolean equals(Object var1) {
		if (this == var1) {
			return true;
		} else if (!(var1 instanceof class_axk)) {
			return false;
		} else {
			class_axk var2 = (class_axk) var1;
			return a != var2.a ? false : (d != var2.d ? false : (b != var2.b ? false : c == var2.c));
		}
	}

	@Override
	public int hashCode() {
		byte var1 = a;
		int var2 = (31 * var1) + b;
		var2 = (31 * var2) + c;
		var2 = (31 * var2) + d;
		return var2;
	}
}
