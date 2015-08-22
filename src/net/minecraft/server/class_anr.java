package net.minecraft.server;

import java.util.Iterator;

import com.google.common.base.Predicate;

public class class_anr extends class_ail {
	public static final class_apz a = class_apz.a("facing", new Predicate() {
		public boolean a(class_cq var1) {
			return var1 != class_cq.a;
		}

		// $FF: synthetic method
		@Override
		public boolean apply(Object var1) {
			return this.a((class_cq) var1);
		}
	});

	protected class_anr() {
		super(class_avq.q);
		this.j(M.b().a(a, class_cq.b));
		this.a(true);
		this.a(class_abp.c);
	}

	@Override
	public class_ayk a(class_ago var1, class_cj var2, class_apn var3) {
		return null;
	}

	@Override
	public boolean c() {
		return false;
	}

	@Override
	public boolean d() {
		return false;
	}

	private boolean d(class_ago var1, class_cj var2) {
		if (class_ago.a(var1, var2)) {
			return true;
		} else {
			class_ail var3 = var1.p(var2).c();
			return (var3 instanceof class_akb) || (var3 == class_aim.w) || (var3 == class_aim.bZ) || (var3 == class_aim.cG);
		}
	}

	@Override
	public boolean c(class_ago var1, class_cj var2) {
		Iterator var3 = a.c().iterator();

		class_cq var4;
		do {
			if (!var3.hasNext()) {
				return false;
			}

			var4 = (class_cq) var3.next();
		} while (!this.a(var1, var2, var4));

		return true;
	}

	private boolean a(class_ago var1, class_cj var2, class_cq var3) {
		class_cj var4 = var2.a(var3.d());
		boolean var5 = var3.k().c();
		return (var5 && var1.d(var4, true)) || (var3.equals(class_cq.b) && this.d(var1, var4));
	}

	@Override
	public class_apn a(class_ago var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, class_rg var8) {
		if (this.a(var1, var2, var3)) {
			return S().a(a, var3);
		} else {
			Iterator var9 = class_cq.class_c_in_class_cq.a.iterator();

			class_cq var10;
			do {
				if (!var9.hasNext()) {
					return S();
				}

				var10 = (class_cq) var9.next();
			} while (!var1.d(var2.a(var10.d()), true));

			return S().a(a, var10);
		}
	}

	@Override
	public void d(class_ago var1, class_cj var2, class_apn var3) {
		this.g(var1, var2, var3);
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, class_ail var4) {
		this.f(var1, var2, var3);
	}

	protected boolean f(class_ago var1, class_cj var2, class_apn var3) {
		if (!this.g(var1, var2, var3)) {
			return true;
		} else {
			class_cq var4 = (class_cq) var3.b(a);
			class_cq.class_a_in_class_cq var5 = var4.k();
			class_cq var6 = var4.d();
			boolean var7 = false;
			if (var5.c() && !var1.d(var2.a(var6), true)) {
				var7 = true;
			} else if (var5.b() && !this.d(var1, var2.a(var6))) {
				var7 = true;
			}

			if (var7) {
				this.b(var1, var2, var3, 0);
				var1.g(var2);
				return true;
			} else {
				return false;
			}
		}
	}

	protected boolean g(class_ago var1, class_cj var2, class_apn var3) {
		if ((var3.c() == this) && this.a(var1, var2, (class_cq) var3.b(a))) {
			return true;
		} else {
			if (var1.p(var2).c() == this) {
				this.b(var1, var2, var3, 0);
				var1.g(var2);
			}

			return false;
		}
	}

	@Override
	public class_ayl a(class_ago var1, class_cj var2, class_aym var3, class_aym var4) {
		class_cq var5 = (class_cq) var1.p(var2).b(a);
		float var6 = 0.15F;
		if (var5 == class_cq.f) {
			this.a(0.0F, 0.2F, 0.5F - var6, var6 * 2.0F, 0.8F, 0.5F + var6);
		} else if (var5 == class_cq.e) {
			this.a(1.0F - (var6 * 2.0F), 0.2F, 0.5F - var6, 1.0F, 0.8F, 0.5F + var6);
		} else if (var5 == class_cq.d) {
			this.a(0.5F - var6, 0.2F, 0.0F, 0.5F + var6, 0.8F, var6 * 2.0F);
		} else if (var5 == class_cq.c) {
			this.a(0.5F - var6, 0.2F, 1.0F - (var6 * 2.0F), 0.5F + var6, 0.8F, 1.0F);
		} else {
			var6 = 0.1F;
			this.a(0.5F - var6, 0.0F, 0.5F - var6, 0.5F + var6, 0.6F, 0.5F + var6);
		}

		return super.a(var1, var2, var3, var4);
	}

	@Override
	public class_apn a(int var1) {
		class_apn var2 = S();
		switch (var1) {
			case 1:
				var2 = var2.a(a, class_cq.f);
				break;
			case 2:
				var2 = var2.a(a, class_cq.e);
				break;
			case 3:
				var2 = var2.a(a, class_cq.d);
				break;
			case 4:
				var2 = var2.a(a, class_cq.c);
				break;
			case 5:
			default:
				var2 = var2.a(a, class_cq.b);
		}

		return var2;
	}

	@Override
	public int c(class_apn var1) {
		byte var2 = 0;
		int var3;
		switch (class_anr.SyntheticClass_1.a[((class_cq) var1.b(a)).ordinal()]) {
			case 1:
				var3 = var2 | 1;
				break;
			case 2:
				var3 = var2 | 2;
				break;
			case 3:
				var3 = var2 | 3;
				break;
			case 4:
				var3 = var2 | 4;
				break;
			case 5:
			case 6:
			default:
				var3 = var2 | 5;
		}

		return var3;
	}

	@Override
	public class_apn a(class_apn var1, class_ail.class_c_in_class_ail var2) {
		return var1.c() != this ? var1 : var1.a(a, var2.a((class_cq) var1.b(a)));
	}

	@Override
	public class_apn a(class_apn var1, class_ail.class_a_in_class_ail var2) {
		return var1.c() != this ? var1 : this.a(var1, var2.a((class_cq) var1.b(a)));
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { a });
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a = new int[class_cq.values().length];

		static {
			try {
				a[class_cq.f.ordinal()] = 1;
			} catch (NoSuchFieldError var6) {
				;
			}

			try {
				a[class_cq.e.ordinal()] = 2;
			} catch (NoSuchFieldError var5) {
				;
			}

			try {
				a[class_cq.d.ordinal()] = 3;
			} catch (NoSuchFieldError var4) {
				;
			}

			try {
				a[class_cq.c.ordinal()] = 4;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				a[class_cq.a.ordinal()] = 5;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[class_cq.b.ordinal()] = 6;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}
}
