package net.minecraft.server;


public class class_aap extends class_qc {
	private class_aor a;

	public class_aap() {
		super("container.enderchest", false, 27);
	}

	public void a(class_aor var1) {
		a = var1;
	}

	public void a(class_du var1) {
		int var2;
		for (var2 = 0; var2 < n_(); ++var2) {
			this.a(var2, (class_aco) null);
		}

		for (var2 = 0; var2 < var1.c(); ++var2) {
			class_dn var3 = var1.b(var2);
			int var4 = var3.f("Slot") & 255;
			if ((var4 >= 0) && (var4 < n_())) {
				this.a(var4, class_aco.a(var3));
			}
		}

	}

	public class_du h() {
		class_du var1 = new class_du();

		for (int var2 = 0; var2 < n_(); ++var2) {
			class_aco var3 = this.a(var2);
			if (var3 != null) {
				class_dn var4 = new class_dn();
				var4.a("Slot", (byte) var2);
				var3.b(var4);
				var1.a(var4);
			}
		}

		return var1;
	}

	@Override
	public boolean a(class_yu var1) {
		return (a != null) && !a.a(var1) ? false : super.a(var1);
	}

	@Override
	public void b(class_yu var1) {
		if (a != null) {
			a.b();
		}

		super.b(var1);
	}

	@Override
	public void c(class_yu var1) {
		if (a != null) {
			a.d();
		}

		super.c(var1);
		a = null;
	}
}
