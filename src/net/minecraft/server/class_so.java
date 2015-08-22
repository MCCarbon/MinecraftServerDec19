package net.minecraft.server;


public class class_so extends class_sr {
	private class_rh a;

	public class_so(class_rh var1) {
		a = var1;
		this.a(4);
		((class_ul) var1.u()).d(true);
	}

	@Override
	public boolean a() {
		return a.Y() || a.ae();
	}

	@Override
	public void e() {
		if (a.bj().nextFloat() < 0.8F) {
			a.s().a();
		}

	}
}
