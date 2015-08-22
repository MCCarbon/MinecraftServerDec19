package net.minecraft.server;


public class class_un extends class_ul {
	private class_cj f;

	public class_un(class_rh var1, class_ago var2) {
		super(var1, var2);
	}

	@Override
	public class_axc a(class_cj var1) {
		f = var1;
		return super.a(var1);
	}

	@Override
	public class_axc a(class_qx var1) {
		f = new class_cj(var1);
		return super.a(var1);
	}

	@Override
	public boolean a(class_qx var1, double var2) {
		class_axc var4 = this.a(var1);
		if (var4 != null) {
			return this.a(var4, var2);
		} else {
			f = new class_cj(var1);
			e = var2;
			return true;
		}
	}

	@Override
	public void k() {
		if (!m()) {
			super.k();
		} else {
			if (f != null) {
				double var1 = b.J * b.J;
				if ((b.c(f) >= var1) && ((b.t <= f.o()) || (b.c((new class_cj(f.n(), class_oa.c(b.t), f.p()))) >= var1))) {
					b.r().a(f.n(), f.o(), f.p(), e);
				} else {
					f = null;
				}
			}

		}
	}
}
