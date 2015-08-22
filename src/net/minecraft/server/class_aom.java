package net.minecraft.server;


public class class_aom extends TileEntity {
	private int a;

	@Override
	public void b(class_dn var1) {
		super.b(var1);
		var1.a("OutputSignal", a);
	}

	@Override
	public void a(class_dn var1) {
		super.a(var1);
		a = var1.h("OutputSignal");
	}

	public int b() {
		return a;
	}

	public void a(int var1) {
		a = var1;
	}
}
