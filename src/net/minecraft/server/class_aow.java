package net.minecraft.server;


public abstract class class_aow extends TileEntity implements class_pv, class_qa {
	private class_pz a;

	public class_aow() {
		a = class_pz.a;
	}

	@Override
	public void a(class_dn var1) {
		super.a(var1);
		a = class_pz.b(var1);
	}

	@Override
	public void b(class_dn var1) {
		super.b(var1);
		if (a != null) {
			a.a(var1);
		}

	}

	@Override
	public boolean q_() {
		return (a != null) && !a.a();
	}

	@Override
	public class_pz i() {
		return a;
	}

	@Override
	public void a(class_pz var1) {
		a = var1;
	}

	@Override
	public IChatBaseComponent f_() {
		return k_() ? new class_fa(e_()) : new class_fb(e_(), new Object[0]);
	}
}
