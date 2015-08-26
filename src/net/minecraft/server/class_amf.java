package net.minecraft.server;

import com.google.common.base.Predicate;

public class class_amf extends class_akx {
	private class_apr a;
	private class_apr b;
	private class_apr N;
	private class_apr P;
	private static final Predicate Q = new Predicate() {
		public boolean a(class_apn var1) {
			return (var1 != null) && ((var1.c() == Blocks.aU) || (var1.c() == Blocks.aZ));
		}

		// $FF: synthetic method
		@Override
		public boolean apply(Object var1) {
			return this.a((class_apn) var1);
		}
	};

	protected class_amf() {
		super(class_avq.C, class_avr.q);
		this.j(M.b().a(O, class_cq.c));
		this.a(true);
		this.a(class_abp.b);
	}

	@Override
	public void d(class_ago var1, class_cj var2, class_apn var3) {
		super.d(var1, var2, var3);
		this.e(var1, var2);
	}

	public boolean d(class_ago var1, class_cj var2) {
		return (l().a(var1, var2) != null) || (o().a(var1, var2) != null);
	}

	private void e(class_ago var1, class_cj var2) {
		class_apr.class_b_in_class_apr var3;
		int var4;
		int var6;
		if ((var3 = n().a(var1, var2)) != null) {
			for (var4 = 0; var4 < n().b(); ++var4) {
				class_apq var5 = var3.a(0, var4, 0);
				var1.a(var5.d(), Blocks.AIR.S(), 2);
			}

			class_vn var9 = new class_vn(var1);
			class_cj var10 = var3.a(0, 2, 0).d();
			var9.b(var10.n() + 0.5D, var10.o() + 0.05D, var10.p() + 0.5D, 0.0F, 0.0F);
			var1.a(var9);

			for (var6 = 0; var6 < 120; ++var6) {
				var1.a(class_cy.G, var10.n() + var1.s.nextDouble(), var10.o() + (var1.s.nextDouble() * 2.5D), var10.p() + var1.s.nextDouble(), 0.0D, 0.0D, 0.0D, new int[0]);
			}

			for (var6 = 0; var6 < n().b(); ++var6) {
				class_apq var7 = var3.a(0, var6, 0);
				var1.c(var7.d(), Blocks.AIR);
			}
		} else if ((var3 = p().a(var1, var2)) != null) {
			for (var4 = 0; var4 < p().c(); ++var4) {
				for (int var12 = 0; var12 < p().b(); ++var12) {
					var1.a(var3.a(var4, var12, 0).d(), Blocks.AIR.S(), 2);
				}
			}

			class_cj var11 = var3.a(1, 2, 0).d();
			class_vp var13 = new class_vp(var1);
			var13.m(true);
			var13.b(var11.n() + 0.5D, var11.o() + 0.05D, var11.p() + 0.5D, 0.0F, 0.0F);
			var1.a(var13);

			for (var6 = 0; var6 < 120; ++var6) {
				var1.a(class_cy.F, var11.n() + var1.s.nextDouble(), var11.o() + (var1.s.nextDouble() * 3.9D), var11.p() + var1.s.nextDouble(), 0.0D, 0.0D, 0.0D, new int[0]);
			}

			for (var6 = 0; var6 < p().c(); ++var6) {
				for (int var14 = 0; var14 < p().b(); ++var14) {
					class_apq var8 = var3.a(var6, var14, 0);
					var1.c(var8.d(), Blocks.AIR);
				}
			}
		}

	}

	@Override
	public boolean c(class_ago var1, class_cj var2) {
		return var1.p(var2).c().J.j() && class_ago.a(var1, var2.b());
	}

	@Override
	public class_apn a(class_apn var1, Block.class_c_in_class_ail var2) {
		return var1.c() != this ? var1 : var1.a(O, var2.a((class_cq) var1.b(O)));
	}

	@Override
	public class_apn a(class_apn var1, Block.class_a_in_class_ail var2) {
		return var1.c() != this ? var1 : this.a(var1, var2.a((class_cq) var1.b(O)));
	}

	@Override
	public class_apn a(class_ago var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, class_rg var8) {
		return S().a(O, var8.aV().d());
	}

	@Override
	public class_apn a(int var1) {
		return S().a(O, class_cq.b(var1));
	}

	@Override
	public int c(class_apn var1) {
		return ((class_cq) var1.b(O)).b();
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { O });
	}

	protected class_apr l() {
		if (a == null) {
			a = class_aps.a().a(new String[] { " ", "#", "#" }).a('#', class_apq.a(class_apv.a(Blocks.aJ))).b();
		}

		return a;
	}

	protected class_apr n() {
		if (b == null) {
			b = class_aps.a().a(new String[] { "^", "#", "#" }).a('^', class_apq.a(Q)).a('#', class_apq.a(class_apv.a(Blocks.aJ))).b();
		}

		return b;
	}

	protected class_apr o() {
		if (N == null) {
			N = class_aps.a().a(new String[] { "~ ~", "###", "~#~" }).a('#', class_apq.a(class_apv.a(Blocks.S))).a('~', class_apq.a(class_apv.a(Blocks.AIR))).b();
		}

		return N;
	}

	protected class_apr p() {
		if (P == null) {
			P = class_aps.a().a(new String[] { "~^~", "###", "~#~" }).a('^', class_apq.a(Q)).a('#', class_apq.a(class_apv.a(Blocks.S))).a('~', class_apq.a(class_apv.a(Blocks.AIR))).b();
		}

		return P;
	}
}
