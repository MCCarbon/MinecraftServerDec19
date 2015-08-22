package net.minecraft.server;


public class class_qn extends class_qq {
	protected final double a;

	protected class_qn(boolean var1, int var2, double var3) {
		super(var1, var2);
		a = var3;
	}

	@Override
	public double a(int var1, class_rr var2) {
		return a * (var1 + 1);
	}
}
