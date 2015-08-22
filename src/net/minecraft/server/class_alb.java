package net.minecraft.server;

import java.util.Iterator;

public class class_alb extends Block {
	public static final class_apz a;

	protected class_alb() {
		super(class_avq.q);
		this.j(M.b().a(a, class_cq.c));
		this.a(class_abp.c);
	}

	@Override
	public class_ayk a(class_ago var1, class_cj var2, class_apn var3) {
		this.d(var3);
		return super.a(var1, var2, var3);
	}

	@Override
	public void a(class_ags var1, class_cj var2) {
		this.d(var1.p(var2));
	}

	private void d(class_apn var1) {
		float var2 = 0.1875F;
		switch (class_alb.SyntheticClass_1.a[((class_cq) var1.b(a)).ordinal()]) {
			case 1:
				this.a(0.0F, 0.0F, 1.0F - var2, 1.0F, 1.0F, 1.0F);
				break;
			case 2:
				this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var2);
				break;
			case 3:
				this.a(1.0F - var2, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
				break;
			case 4:
			default:
				this.a(0.0F, 0.0F, 0.0F, var2, 1.0F, 1.0F);
		}

	}

	@Override
	public boolean c() {
		return false;
	}

	@Override
	public boolean d() {
		return false;
	}

	@Override
	public boolean c(class_ago var1, class_cj var2) {
		return var1.p(var2.e()).c().x() ? true : (var1.p(var2.f()).c().x() ? true : (var1.p(var2.c()).c().x() ? true : var1.p(var2.d()).c().x()));
	}

	@Override
	public class_apn a(class_ago var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, class_rg var8) {
		if (var3.k().c() && this.a(var1, var2, var3)) {
			return S().a(a, var3);
		} else {
			Iterator var9 = class_cq.class_c_in_class_cq.a.iterator();

			class_cq var10;
			do {
				if (!var9.hasNext()) {
					return S();
				}

				var10 = (class_cq) var9.next();
			} while (!this.a(var1, var2, var10));

			return S().a(a, var10);
		}
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, Block var4) {
		class_cq var5 = (class_cq) var3.b(a);
		if (!this.a(var1, var2, var5)) {
			this.b(var1, var2, var3, 0);
			var1.g(var2);
		}

		super.a(var1, var2, var3, var4);
	}

	protected boolean a(class_ago var1, class_cj var2, class_cq var3) {
		return var1.p(var2.a(var3.d())).c().x();
	}

	@Override
	public class_apn a(int var1) {
		class_cq var2 = class_cq.a(var1);
		if (var2.k() == class_cq.class_a_in_class_cq.b) {
			var2 = class_cq.c;
		}

		return S().a(a, var2);
	}

	@Override
	public int c(class_apn var1) {
		return ((class_cq) var1.b(a)).a();
	}

	@Override
	public class_apn a(class_apn var1, Block.class_c_in_class_ail var2) {
		return var1.c() != this ? var1 : var1.a(a, var2.a((class_cq) var1.b(a)));
	}

	@Override
	public class_apn a(class_apn var1, Block.class_a_in_class_ail var2) {
		return var1.c() != this ? var1 : this.a(var1, var2.a((class_cq) var1.b(a)));
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { a });
	}

	static {
		a = class_akx.O;
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a = new int[class_cq.values().length];

		static {
			try {
				a[class_cq.c.ordinal()] = 1;
			} catch (NoSuchFieldError var4) {
				;
			}

			try {
				a[class_cq.d.ordinal()] = 2;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				a[class_cq.e.ordinal()] = 3;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[class_cq.f.ordinal()] = 4;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}
}
