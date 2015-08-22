package net.minecraft.server;

import com.google.gson.JsonParseException;

public class class_aoz extends class_aoi {
	public final class_eu[] a = new class_eu[] { new class_fa(""), new class_fa(""), new class_fa(""), new class_fa("") };
	public int f = -1;
	private boolean g = true;
	private class_yu h;
	private final class_n i = new class_n();

	@Override
	public void b(class_dn var1) {
		super.b(var1);

		for (int var2 = 0; var2 < 4; ++var2) {
			String var3 = class_eu.class_a_in_class_eu.a(a[var2]);
			var1.a("Text" + (var2 + 1), var3);
		}

		i.b(var1);
	}

	@Override
	public void a(class_dn var1) {
		g = false;
		super.a(var1);
		class_m var2 = new class_m() {
			@Override
			public String e_() {
				return "Sign";
			}

			@Override
			public class_eu f_() {
				return new class_fa(e_());
			}

			@Override
			public void a(class_eu var1) {
			}

			@Override
			public boolean a(int var1, String var2) {
				return true;
			}

			@Override
			public class_cj c() {
				return class_aoz.this.c;
			}

			@Override
			public class_aym d() {
				return new class_aym(class_aoz.this.c.n() + 0.5D, class_aoz.this.c.o() + 0.5D, class_aoz.this.c.p() + 0.5D);
			}

			@Override
			public class_ago e() {
				return class_aoz.this.b;
			}

			@Override
			public class_qx f() {
				return null;
			}

			@Override
			public boolean s_() {
				return false;
			}

			@Override
			public void a(class_n.class_a_in_class_n var1, int var2) {
			}
		};

		for (int var3 = 0; var3 < 4; ++var3) {
			String var4 = var1.l("Text" + (var3 + 1));

			try {
				class_eu var5 = class_eu.class_a_in_class_eu.a(var4);

				try {
					a[var3] = class_ev.a(var2, var5, (class_qx) null);
				} catch (class_bz var7) {
					a[var3] = var5;
				}
			} catch (JsonParseException var8) {
				a[var3] = new class_fa(var4);
			}
		}

		i.a(var1);
	}

	@Override
	public class_ff x_() {
		class_eu[] var1 = new class_eu[4];
		System.arraycopy(a, 0, var1, 0, 4);
		return new class_hx(b, c, var1);
	}

	@Override
	public boolean F() {
		return true;
	}

	public boolean b() {
		return g;
	}

	public void a(class_yu var1) {
		h = var1;
	}

	public class_yu c() {
		return h;
	}

	public boolean b(final class_yu var1) {
		class_m var2 = new class_m() {
			@Override
			public String e_() {
				return var1.e_();
			}

			@Override
			public class_eu f_() {
				return var1.f_();
			}

			@Override
			public void a(class_eu var1x) {
			}

			@Override
			public boolean a(int var1x, String var2) {
				return var1x <= 2;
			}

			@Override
			public class_cj c() {
				return class_aoz.this.c;
			}

			@Override
			public class_aym d() {
				return new class_aym(class_aoz.this.c.n() + 0.5D, class_aoz.this.c.o() + 0.5D, class_aoz.this.c.p() + 0.5D);
			}

			@Override
			public class_ago e() {
				return var1.e();
			}

			@Override
			public class_qx f() {
				return var1;
			}

			@Override
			public boolean s_() {
				return false;
			}

			@Override
			public void a(class_n.class_a_in_class_n var1x, int var2) {
				i.a(this, var1x, var2);
			}
		};

		for (int var3 = 0; var3 < a.length; ++var3) {
			class_ez var4 = a[var3] == null ? null : a[var3].b();
			if ((var4 != null) && (var4.h() != null)) {
				class_et var5 = var4.h();
				if (var5.a() == class_et.class_a_in_class_et.c) {
					MinecraftServer.P().R().a(var2, var5.b());
				}
			}
		}

		return true;
	}

	public class_n d() {
		return i;
	}
}
