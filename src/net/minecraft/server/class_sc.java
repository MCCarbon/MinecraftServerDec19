package net.minecraft.server;


public class class_sc {
	private EntityInsentient b;
	protected boolean a;

	public class_sc(EntityInsentient var1) {
		b = var1;
	}

	public void a() {
		a = true;
	}

	public void b() {
		b.i(a);
		a = false;
	}
}
