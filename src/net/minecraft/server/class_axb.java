package net.minecraft.server;


public abstract class class_axb {
	protected class_ags a;
	protected class_qx b;
	protected final class_nu c = new class_nu();
	protected int d;
	protected int e;
	protected int f;

	public void a(class_ags var1, class_qx var2) {
		a = var1;
		b = var2;
		c.c();
		d = class_oa.d(var2.J + 1.0F);
		e = class_oa.d(var2.K + 1.0F);
		f = class_oa.d(var2.J + 1.0F);
	}

	public void a() {
	}

	protected class_axa a(int var1, int var2, int var3) {
		int var4 = class_axa.a(var1, var2, var3);
		class_axa var5 = (class_axa) c.a(var4);
		if (var5 == null) {
			var5 = new class_axa(var1, var2, var3);
			c.a(var4, var5);
		}

		return var5;
	}

	public abstract class_axa b();

	public abstract class_axa a(double var1, double var3, double var5);

	public abstract int a(class_axa[] var1, class_axa var2, class_axa var3, float var4);
}
