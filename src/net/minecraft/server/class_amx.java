package net.minecraft.server;

import java.util.Iterator;
import java.util.Random;

import com.google.common.base.Predicate;

public class class_amx extends class_aif {
	public static final class_apz a;
	public static final class_apy b;
	private static final Predicate N;
	private class_apr O;
	private class_apr P;

	protected class_amx() {
		super(class_avq.q);
		this.j(M.b().a(a, class_cq.c).a(b, Boolean.valueOf(false)));
		this.a(0.25F, 0.0F, 0.25F, 0.75F, 0.5F, 0.75F);
	}

	@Override
	public String f() {
		return class_di.a("tile.skull.skeleton.name");
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
	public void a(class_ags var1, class_cj var2) {
		this.d(var1.p(var2));
	}

	private void d(class_apn var1) {
		switch (class_amx.SyntheticClass_1.a[((class_cq) var1.b(a)).ordinal()]) {
			case 1:
			default:
				this.a(0.25F, 0.0F, 0.25F, 0.75F, 0.5F, 0.75F);
				break;
			case 2:
				this.a(0.25F, 0.25F, 0.5F, 0.75F, 0.75F, 1.0F);
				break;
			case 3:
				this.a(0.25F, 0.25F, 0.0F, 0.75F, 0.75F, 0.5F);
				break;
			case 4:
				this.a(0.5F, 0.25F, 0.25F, 1.0F, 0.75F, 0.75F);
				break;
			case 5:
				this.a(0.0F, 0.25F, 0.25F, 0.5F, 0.75F, 0.75F);
		}

	}

	@Override
	public class_ayk a(class_ago var1, class_cj var2, class_apn var3) {
		this.d(var3);
		return super.a(var1, var2, var3);
	}

	@Override
	public class_apn a(class_ago var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, class_rg var8) {
		return S().a(a, var8.aV()).a(b, Boolean.valueOf(false));
	}

	@Override
	public class_aoi a(class_ago var1, int var2) {
		return new class_apa();
	}

	@Override
	public class_aco b(class_ago var1, class_cj var2, class_apn var3) {
		int var4 = 0;
		class_aoi var5 = var1.s(var2);
		if (var5 instanceof class_apa) {
			var4 = ((class_apa) var5).d();
		}

		return new class_aco(class_acq.cc, 1, var4);
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, float var4, int var5) {
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, class_yu var4) {
		if (var4.bI.d) {
			var3 = var3.a(b, Boolean.valueOf(true));
			var1.a(var2, var3, 4);
		}

		super.a(var1, var2, var3, var4);
	}

	@Override
	public void c(class_ago var1, class_cj var2, class_apn var3) {
		if (!var1.D) {
			if (!((Boolean) var3.b(b)).booleanValue()) {
				class_aoi var4 = var1.s(var2);
				if (var4 instanceof class_apa) {
					class_apa var5 = (class_apa) var4;
					class_aco var6 = this.b(var1, var2, var3);
					if ((var5.d() == 3) && (var5.b() != null)) {
						var6.d(new class_dn());
						class_dn var7 = new class_dn();
						class_dy.a(var7, var5.b());
						var6.o().a("SkullOwner", var7);
					}

					a(var1, var2, var6);
				}
			}

			super.c(var1, var2, var3);
		}
	}

	@Override
	public class_acm a(class_apn var1, Random var2, int var3) {
		return class_acq.cc;
	}

	public boolean b(class_ago var1, class_cj var2, class_aco var3) {
		return (var3.i() == 1) && (var2.o() >= 2) && (var1.ac() != class_ps.a) && !var1.D ? l().a(var1, var2) != null : false;
	}

	public void a(class_ago var1, class_cj var2, class_apa var3) {
		if ((var3.d() == 1) && (var2.o() >= 2) && (var1.ac() != class_ps.a) && !var1.D) {
			class_apr var4 = n();
			class_apr.class_b_in_class_apr var5 = var4.a(var1, var2);
			if (var5 != null) {
				int var6;
				for (var6 = 0; var6 < 3; ++var6) {
					class_apq var7 = var5.a(var6, 0, 0);
					var1.a(var7.d(), var7.a().a(b, Boolean.valueOf(true)), 2);
				}

				for (var6 = 0; var6 < var4.c(); ++var6) {
					for (int var13 = 0; var13 < var4.b(); ++var13) {
						class_apq var8 = var5.a(var6, var13, 0);
						var1.a(var8.d(), class_aim.a.S(), 2);
					}
				}

				class_cj var12 = var5.a(1, 0, 0).d();
				class_wq var14 = new class_wq(var1);
				class_cj var15 = var5.a(1, 2, 0).d();
				var14.b(var15.n() + 0.5D, var15.o() + 0.55D, var15.p() + 0.5D, var5.b().k() == class_cq.class_a_in_class_cq.a ? 0.0F : 90.0F, 0.0F);
				var14.aM = var5.b().k() == class_cq.class_a_in_class_cq.a ? 0.0F : 90.0F;
				var14.n();
				Iterator var9 = var1.a(class_yu.class, var14.aX().b(50.0D, 50.0D, 50.0D)).iterator();

				while (var9.hasNext()) {
					class_yu var10 = (class_yu) var9.next();
					var10.b(class_my.I);
				}

				var1.a(var14);

				int var16;
				for (var16 = 0; var16 < 120; ++var16) {
					var1.a(class_cy.F, var12.n() + var1.s.nextDouble(), var12.o() - 2 + (var1.s.nextDouble() * 3.9D), var12.p() + var1.s.nextDouble(), 0.0D, 0.0D, 0.0D, new int[0]);
				}

				for (var16 = 0; var16 < var4.c(); ++var16) {
					for (int var17 = 0; var17 < var4.b(); ++var17) {
						class_apq var11 = var5.a(var16, var17, 0);
						var1.c(var11.d(), class_aim.a);
					}
				}

			}
		}
	}

	@Override
	public class_apn a(int var1) {
		return S().a(a, class_cq.a(var1 & 7)).a(b, Boolean.valueOf((var1 & 8) > 0));
	}

	@Override
	public int c(class_apn var1) {
		byte var2 = 0;
		int var3 = var2 | ((class_cq) var1.b(a)).a();
		if (((Boolean) var1.b(b)).booleanValue()) {
			var3 |= 8;
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
		return new class_apo(this, new class_aqc[] { a, b });
	}

	protected class_apr l() {
		if (O == null) {
			O = class_aps.a().a(new String[] { "   ", "###", "~#~" }).a('#', class_apq.a(class_apv.a(class_aim.aW))).a('~', class_apq.a(class_apv.a(class_aim.a))).b();
		}

		return O;
	}

	protected class_apr n() {
		if (P == null) {
			P = class_aps.a().a(new String[] { "^^^", "###", "~#~" }).a('#', class_apq.a(class_apv.a(class_aim.aW))).a('^', N).a('~', class_apq.a(class_apv.a(class_aim.a))).b();
		}

		return P;
	}

	static {
		a = class_ajk.b;
		b = class_apy.a("nodrop");
		N = new Predicate() {
			public boolean a(class_apq var1) {
				return (var1.a() != null) && (var1.a().c() == class_aim.ce) && (var1.b() instanceof class_apa) && (((class_apa) var1.b()).d() == 1);
			}

			// $FF: synthetic method
			@Override
			public boolean apply(Object var1) {
				return this.a((class_apq) var1);
			}
		};
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a = new int[class_cq.values().length];

		static {
			try {
				a[class_cq.b.ordinal()] = 1;
			} catch (NoSuchFieldError var5) {
				;
			}

			try {
				a[class_cq.c.ordinal()] = 2;
			} catch (NoSuchFieldError var4) {
				;
			}

			try {
				a[class_cq.d.ordinal()] = 3;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				a[class_cq.e.ordinal()] = 4;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[class_cq.f.ordinal()] = 5;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}
}
