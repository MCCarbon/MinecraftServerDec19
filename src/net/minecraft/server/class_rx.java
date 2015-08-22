package net.minecraft.server;


public class class_rx extends class_rs {
	private final double a;
	private final double b;
	private String c;

	public class_rx(class_rp var1, String var2, double var3, double var5, double var7) {
		super(var1, var2, var3);
		a = var5;
		b = var7;
		if (var5 > var7) {
			throw new IllegalArgumentException("Minimum value cannot be bigger than maximum value!");
		} else if (var3 < var5) {
			throw new IllegalArgumentException("Default value cannot be lower than minimum value!");
		} else if (var3 > var7) {
			throw new IllegalArgumentException("Default value cannot be bigger than maximum value!");
		}
	}

	public class_rx a(String var1) {
		c = var1;
		return this;
	}

	public String g() {
		return c;
	}

	@Override
	public double a(double var1) {
		var1 = class_oa.a(var1, a, b);
		return var1;
	}
}
