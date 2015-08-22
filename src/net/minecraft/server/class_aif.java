package net.minecraft.server;


public abstract class class_aif extends Block implements class_ajy {
	protected class_aif(class_avq var1) {
		this(var1, var1.r());
	}

	protected class_aif(class_avq var1, class_avr var2) {
		super(var1, var2);
		A = true;
	}

	protected boolean a(class_ago var1, class_cj var2, class_cq var3) {
		return var1.p(var2.a(var3)).c().v() == class_avq.A;
	}

	protected boolean d(class_ago var1, class_cj var2) {
		return this.a(var1, var2, class_cq.c) || this.a(var1, var2, class_cq.d) || this.a(var1, var2, class_cq.e) || this.a(var1, var2, class_cq.f);
	}

	@Override
	public int b() {
		return -1;
	}

	@Override
	public void c(class_ago var1, class_cj var2, class_apn var3) {
		super.c(var1, var2, var3);
		var1.t(var2);
	}

	@Override
	public boolean a(class_ago var1, class_cj var2, class_apn var3, int var4, int var5) {
		super.a(var1, var2, var3, var4, var5);
		TileEntity var6 = var1.s(var2);
		return var6 == null ? false : var6.c(var4, var5);
	}
}
