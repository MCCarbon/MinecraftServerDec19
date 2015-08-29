package net.minecraft.server;


public class class_tr extends class_sr {
	private EntityCreature a;

	public class_tr(EntityCreature var1) {
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
