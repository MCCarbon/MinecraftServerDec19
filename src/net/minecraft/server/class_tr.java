package net.minecraft.server;


public class class_tr extends class_sr {
	private class_rn a;

	public class_tr(class_rn var1) {
		a = var1;
	}

	@Override
	public boolean a() {
		return a.o.z();
	}

	@Override
	public void c() {
		((class_ul) a.u()).e(true);
	}

	@Override
	public void d() {
		((class_ul) a.u()).e(false);
	}
}
