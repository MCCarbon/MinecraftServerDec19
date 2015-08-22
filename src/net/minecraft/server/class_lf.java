package net.minecraft.server;


public class class_lf extends class_ll {
	private class_ll a;

	public class_lf(MinecraftServer var1, class_axu var2, int var3, class_ll var4, class_ob var5) {
		super(var1, var2, new class_axq(var4.R()), var3, var5);
		a = var4;
		var4.ah().a(new class_aqe() {
			@Override
			public void a(class_aqg var1, double var2) {
				class_lf.this.ah().a(var2);
			}

			@Override
			public void a(class_aqg var1, double var2, double var4, long var6) {
				class_lf.this.ah().a(var2, var4, var6);
			}

			@Override
			public void a(class_aqg var1, double var2, double var4) {
				class_lf.this.ah().c(var2, var4);
			}

			@Override
			public void a(class_aqg var1, int var2) {
				class_lf.this.ah().b(var2);
			}

			@Override
			public void b(class_aqg var1, int var2) {
				class_lf.this.ah().c(var2);
			}

			@Override
			public void b(class_aqg var1, double var2) {
				class_lf.this.ah().c(var2);
			}

			@Override
			public void c(class_aqg var1, double var2) {
				class_lf.this.ah().b(var2);
			}
		});
	}

	@Override
	protected void a() {
	}

	@Override
	public class_ago b() {
		z = a.V();
		C = a.ab();
		String var1 = class_ux.a(t);
		class_ux var2 = (class_ux) z.a(class_ux.class, var1);
		if (var2 == null) {
			A = new class_ux(this);
			z.a(var1, A);
		} else {
			A = var2;
			A.a(this);
		}

		return this;
	}

	public void c() {
		t.q();
	}
}
