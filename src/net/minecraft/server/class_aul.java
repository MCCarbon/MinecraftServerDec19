package net.minecraft.server;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;

public class class_aul {
	public static void a() {
		class_aup.a(class_aul.class_a_in_class_aul.class, "TeDP");
		class_aup.a(class_aul.class_b_in_class_aul.class, "TeJP");
		class_aup.a(class_aul.class_d_in_class_aul.class, "TeSH");
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
	}

	public static class class_d_in_class_aul extends class_aul.class_c_in_class_aul {
		private boolean e;

		public class_d_in_class_aul() {
		}

		public class_d_in_class_aul(Random var1, int var2, int var3) {
			super(var1, var2, 64, var3, 7, 7, 9);
		}

		@Override
		protected void a(class_dn var1) {
			super.a(var1);
			var1.a("Witch", e);
		}

		@Override
		protected void b(class_dn var1) {
			super.b(var1);
			e = var1.p("Witch");
		}

		@Override
		public boolean a(class_ago var1, Random var2, class_aua var3) {
			if (!this.a(var1, var3, 0)) {
				return false;
			} else {
				this.a(var1, var3, 1, 1, 1, 5, 1, 7, class_aim.f.a(class_aly.class_a_in_class_aly.b.a()), class_aim.f.a(class_aly.class_a_in_class_aly.b.a()), false);
				this.a(var1, var3, 1, 4, 2, 5, 4, 7, class_aim.f.a(class_aly.class_a_in_class_aly.b.a()), class_aim.f.a(class_aly.class_a_in_class_aly.b.a()), false);
				this.a(var1, var3, 2, 1, 0, 4, 1, 0, class_aim.f.a(class_aly.class_a_in_class_aly.b.a()), class_aim.f.a(class_aly.class_a_in_class_aly.b.a()), false);
				this.a(var1, var3, 2, 2, 2, 3, 3, 2, class_aim.f.a(class_aly.class_a_in_class_aly.b.a()), class_aim.f.a(class_aly.class_a_in_class_aly.b.a()), false);
				this.a(var1, var3, 1, 2, 3, 1, 3, 6, class_aim.f.a(class_aly.class_a_in_class_aly.b.a()), class_aim.f.a(class_aly.class_a_in_class_aly.b.a()), false);
				this.a(var1, var3, 5, 2, 3, 5, 3, 6, class_aim.f.a(class_aly.class_a_in_class_aly.b.a()), class_aim.f.a(class_aly.class_a_in_class_aly.b.a()), false);
				this.a(var1, var3, 2, 2, 7, 4, 3, 7, class_aim.f.a(class_aly.class_a_in_class_aly.b.a()), class_aim.f.a(class_aly.class_a_in_class_aly.b.a()), false);
				this.a(var1, var3, 1, 0, 2, 1, 3, 2, class_aim.r.S(), class_aim.r.S(), false);
				this.a(var1, var3, 5, 0, 2, 5, 3, 2, class_aim.r.S(), class_aim.r.S(), false);
				this.a(var1, var3, 1, 0, 7, 1, 3, 7, class_aim.r.S(), class_aim.r.S(), false);
				this.a(var1, var3, 5, 0, 7, 5, 3, 7, class_aim.r.S(), class_aim.r.S(), false);
				this.a(var1, class_aim.aO.S(), 2, 3, 2, var3);
				this.a(var1, class_aim.aO.S(), 3, 3, 7, var3);
				this.a(var1, class_aim.a.S(), 1, 3, 4, var3);
				this.a(var1, class_aim.a.S(), 5, 3, 4, var3);
				this.a(var1, class_aim.a.S(), 5, 3, 5, var3);
				this.a(var1, class_aim.ca.S().a(class_akf.b, class_akf.class_a_in_class_akf.r), 1, 3, 5, var3);
				this.a(var1, class_aim.ai.S(), 3, 2, 6, var3);
				this.a(var1, class_aim.bE.S(), 4, 2, 6, var3);
				this.a(var1, class_aim.aO.S(), 1, 2, 1, var3);
				this.a(var1, class_aim.aO.S(), 5, 2, 1, var3);
				class_apn var4 = class_aim.bU.S().a(class_anf.a, class_cq.c);
				class_apn var5 = class_aim.bU.S().a(class_anf.a, class_cq.f);
				class_apn var6 = class_aim.bU.S().a(class_anf.a, class_cq.e);
				class_apn var7 = class_aim.bU.S().a(class_anf.a, class_cq.d);
				this.a(var1, var3, 0, 4, 1, 6, 4, 1, var4, var4, false);
				this.a(var1, var3, 0, 4, 2, 0, 4, 7, var5, var5, false);
				this.a(var1, var3, 6, 4, 2, 6, 4, 7, var6, var6, false);
				this.a(var1, var3, 0, 4, 8, 6, 4, 8, var7, var7, false);

				int var8;
				int var9;
				for (var8 = 2; var8 <= 7; var8 += 5) {
					for (var9 = 1; var9 <= 5; var9 += 4) {
						this.b(var1, class_aim.r.S(), var9, -1, var8, var3);
					}
				}

				if (!e) {
					var8 = this.a(2, 5);
					var9 = this.d(2);
					int var10 = this.b(2, 5);
					if (var3.b((new class_cj(var8, var9, var10)))) {
						e = true;
						class_yk var11 = new class_yk(var1);
						var11.b(var8 + 0.5D, var9, var10 + 0.5D, 0.0F, 0.0F);
						var11.a(var1.E(new class_cj(var8, var9, var10)), (class_rj) null);
						var1.a(var11);
					}
				}

				return true;
			}
		}
	}

	public static class class_b_in_class_aul extends class_aul.class_c_in_class_aul {
		private boolean e;
		private boolean f;
		private boolean g;
		private boolean h;
		private static final List i;
		private static final List j;
		private static class_aul.class_b_in_class_aul.class_b_in_class_aul$class_a_in_class_b_in_class_aul k;

		public class_b_in_class_aul() {
		}

		public class_b_in_class_aul(Random var1, int var2, int var3) {
			super(var1, var2, 64, var3, 12, 10, 15);
		}

		@Override
		protected void a(class_dn var1) {
			super.a(var1);
			var1.a("placedMainChest", e);
			var1.a("placedHiddenChest", f);
			var1.a("placedTrap1", g);
			var1.a("placedTrap2", h);
		}

		@Override
		protected void b(class_dn var1) {
			super.b(var1);
			e = var1.p("placedMainChest");
			f = var1.p("placedHiddenChest");
			g = var1.p("placedTrap1");
			h = var1.p("placedTrap2");
		}

		@Override
		public boolean a(class_ago var1, Random var2, class_aua var3) {
			if (!this.a(var1, var3, 0)) {
				return false;
			} else {
				this.a(var1, var3, 0, -4, 0, a - 1, 0, c - 1, false, var2, k);
				this.a(var1, var3, 2, 1, 2, 9, 2, 2, false, var2, k);
				this.a(var1, var3, 2, 1, 12, 9, 2, 12, false, var2, k);
				this.a(var1, var3, 2, 1, 3, 2, 2, 11, false, var2, k);
				this.a(var1, var3, 9, 1, 3, 9, 2, 11, false, var2, k);
				this.a(var1, var3, 1, 3, 1, 10, 6, 1, false, var2, k);
				this.a(var1, var3, 1, 3, 13, 10, 6, 13, false, var2, k);
				this.a(var1, var3, 1, 3, 2, 1, 6, 12, false, var2, k);
				this.a(var1, var3, 10, 3, 2, 10, 6, 12, false, var2, k);
				this.a(var1, var3, 2, 3, 2, 9, 3, 12, false, var2, k);
				this.a(var1, var3, 2, 6, 2, 9, 6, 12, false, var2, k);
				this.a(var1, var3, 3, 7, 3, 8, 7, 11, false, var2, k);
				this.a(var1, var3, 4, 8, 4, 7, 8, 10, false, var2, k);
				this.a(var1, var3, 3, 1, 3, 8, 2, 11);
				this.a(var1, var3, 4, 3, 6, 7, 3, 9);
				this.a(var1, var3, 2, 4, 2, 9, 5, 12);
				this.a(var1, var3, 4, 6, 5, 7, 6, 9);
				this.a(var1, var3, 5, 7, 6, 6, 7, 8);
				this.a(var1, var3, 5, 1, 2, 6, 2, 2);
				this.a(var1, var3, 5, 2, 12, 6, 2, 12);
				this.a(var1, var3, 5, 5, 1, 6, 5, 1);
				this.a(var1, var3, 5, 5, 13, 6, 5, 13);
				this.a(var1, class_aim.a.S(), 1, 5, 5, var3);
				this.a(var1, class_aim.a.S(), 10, 5, 5, var3);
				this.a(var1, class_aim.a.S(), 1, 5, 9, var3);
				this.a(var1, class_aim.a.S(), 10, 5, 9, var3);

				int var4;
				for (var4 = 0; var4 <= 14; var4 += 14) {
					this.a(var1, var3, 2, 4, var4, 2, 5, var4, false, var2, k);
					this.a(var1, var3, 4, 4, var4, 4, 5, var4, false, var2, k);
					this.a(var1, var3, 7, 4, var4, 7, 5, var4, false, var2, k);
					this.a(var1, var3, 9, 4, var4, 9, 5, var4, false, var2, k);
				}

				this.a(var1, var3, 5, 6, 0, 6, 6, 0, false, var2, k);

				for (var4 = 0; var4 <= 11; var4 += 11) {
					for (int var5 = 2; var5 <= 12; var5 += 2) {
						this.a(var1, var3, var4, 4, var5, var4, 5, var5, false, var2, k);
					}

					this.a(var1, var3, var4, 6, 5, var4, 6, 5, false, var2, k);
					this.a(var1, var3, var4, 6, 9, var4, 6, 9, false, var2, k);
				}

				this.a(var1, var3, 2, 7, 2, 2, 9, 2, false, var2, k);
				this.a(var1, var3, 9, 7, 2, 9, 9, 2, false, var2, k);
				this.a(var1, var3, 2, 7, 12, 2, 9, 12, false, var2, k);
				this.a(var1, var3, 9, 7, 12, 9, 9, 12, false, var2, k);
				this.a(var1, var3, 4, 9, 4, 4, 9, 4, false, var2, k);
				this.a(var1, var3, 7, 9, 4, 7, 9, 4, false, var2, k);
				this.a(var1, var3, 4, 9, 10, 4, 9, 10, false, var2, k);
				this.a(var1, var3, 7, 9, 10, 7, 9, 10, false, var2, k);
				this.a(var1, var3, 5, 9, 7, 6, 9, 7, false, var2, k);
				class_apn var9 = class_aim.aw.S().a(class_anf.a, class_cq.f);
				class_apn var10 = class_aim.aw.S().a(class_anf.a, class_cq.e);
				class_apn var6 = class_aim.aw.S().a(class_anf.a, class_cq.d);
				class_apn var7 = class_aim.aw.S().a(class_anf.a, class_cq.c);
				this.a(var1, var7, 5, 9, 6, var3);
				this.a(var1, var7, 6, 9, 6, var3);
				this.a(var1, var6, 5, 9, 8, var3);
				this.a(var1, var6, 6, 9, 8, var3);
				this.a(var1, var7, 4, 0, 0, var3);
				this.a(var1, var7, 5, 0, 0, var3);
				this.a(var1, var7, 6, 0, 0, var3);
				this.a(var1, var7, 7, 0, 0, var3);
				this.a(var1, var7, 4, 1, 8, var3);
				this.a(var1, var7, 4, 2, 9, var3);
				this.a(var1, var7, 4, 3, 10, var3);
				this.a(var1, var7, 7, 1, 8, var3);
				this.a(var1, var7, 7, 2, 9, var3);
				this.a(var1, var7, 7, 3, 10, var3);
				this.a(var1, var3, 4, 1, 9, 4, 1, 9, false, var2, k);
				this.a(var1, var3, 7, 1, 9, 7, 1, 9, false, var2, k);
				this.a(var1, var3, 4, 1, 10, 7, 2, 10, false, var2, k);
				this.a(var1, var3, 5, 4, 5, 6, 4, 5, false, var2, k);
				this.a(var1, var9, 4, 4, 5, var3);
				this.a(var1, var10, 7, 4, 5, var3);

				int var8;
				for (var8 = 0; var8 < 4; ++var8) {
					this.a(var1, var6, 5, 0 - var8, 6 + var8, var3);
					this.a(var1, var6, 6, 0 - var8, 6 + var8, var3);
					this.a(var1, var3, 5, 0 - var8, 7 + var8, 6, 0 - var8, 9 + var8);
				}

				this.a(var1, var3, 1, -3, 12, 10, -1, 13);
				this.a(var1, var3, 1, -3, 1, 3, -1, 13);
				this.a(var1, var3, 1, -3, 1, 9, -1, 5);

				for (var8 = 1; var8 <= 13; var8 += 2) {
					this.a(var1, var3, 1, -3, var8, 1, -2, var8, false, var2, k);
				}

				for (var8 = 2; var8 <= 12; var8 += 2) {
					this.a(var1, var3, 1, -1, var8, 3, -1, var8, false, var2, k);
				}

				this.a(var1, var3, 2, -2, 1, 5, -2, 1, false, var2, k);
				this.a(var1, var3, 7, -2, 1, 9, -2, 1, false, var2, k);
				this.a(var1, var3, 6, -3, 1, 6, -3, 1, false, var2, k);
				this.a(var1, var3, 6, -1, 1, 6, -1, 1, false, var2, k);
				this.a(var1, class_aim.bR.S().a(class_anv.a, class_cq.f).a(class_anv.N, Boolean.valueOf(true)), 1, -3, 8, var3);
				this.a(var1, class_aim.bR.S().a(class_anv.a, class_cq.e).a(class_anv.N, Boolean.valueOf(true)), 4, -3, 8, var3);
				this.a(var1, class_aim.bS.S().a(class_anu.N, Boolean.valueOf(true)), 2, -3, 8, var3);
				this.a(var1, class_aim.bS.S().a(class_anu.N, Boolean.valueOf(true)), 3, -3, 8, var3);
				this.a(var1, class_aim.af.S(), 5, -3, 7, var3);
				this.a(var1, class_aim.af.S(), 5, -3, 6, var3);
				this.a(var1, class_aim.af.S(), 5, -3, 5, var3);
				this.a(var1, class_aim.af.S(), 5, -3, 4, var3);
				this.a(var1, class_aim.af.S(), 5, -3, 3, var3);
				this.a(var1, class_aim.af.S(), 5, -3, 2, var3);
				this.a(var1, class_aim.af.S(), 5, -3, 1, var3);
				this.a(var1, class_aim.af.S(), 4, -3, 1, var3);
				this.a(var1, class_aim.Y.S(), 3, -3, 1, var3);
				if (!g) {
					g = this.a(var1, var3, var2, 3, -2, 1, class_cq.c, j, 2);
				}

				this.a(var1, class_aim.bn.S().a(class_anw.O, Boolean.valueOf(true)), 3, -2, 2, var3);
				this.a(var1, class_aim.bR.S().a(class_anv.a, class_cq.c).a(class_anv.N, Boolean.valueOf(true)), 7, -3, 1, var3);
				this.a(var1, class_aim.bR.S().a(class_anv.a, class_cq.d).a(class_anv.N, Boolean.valueOf(true)), 7, -3, 5, var3);
				this.a(var1, class_aim.bS.S().a(class_anu.N, Boolean.valueOf(true)), 7, -3, 2, var3);
				this.a(var1, class_aim.bS.S().a(class_anu.N, Boolean.valueOf(true)), 7, -3, 3, var3);
				this.a(var1, class_aim.bS.S().a(class_anu.N, Boolean.valueOf(true)), 7, -3, 4, var3);
				this.a(var1, class_aim.af.S(), 8, -3, 6, var3);
				this.a(var1, class_aim.af.S(), 9, -3, 6, var3);
				this.a(var1, class_aim.af.S(), 9, -3, 5, var3);
				this.a(var1, class_aim.Y.S(), 9, -3, 4, var3);
				this.a(var1, class_aim.af.S(), 9, -2, 4, var3);
				if (!h) {
					h = this.a(var1, var3, var2, 9, -2, 3, class_cq.e, j, 2);
				}

				this.a(var1, class_aim.bn.S().a(class_anw.N, Boolean.valueOf(true)), 8, -1, 3, var3);
				this.a(var1, class_aim.bn.S().a(class_anw.N, Boolean.valueOf(true)), 8, -2, 3, var3);
				if (!e) {
					e = this.a(var1, var3, var2, 8, -3, 3, class_oj.a(i, new class_oj[] { class_acq.ci.b(var2) }), 2 + var2.nextInt(5));
				}

				this.a(var1, class_aim.Y.S(), 9, -3, 2, var3);
				this.a(var1, class_aim.Y.S(), 8, -3, 1, var3);
				this.a(var1, class_aim.Y.S(), 4, -3, 5, var3);
				this.a(var1, class_aim.Y.S(), 5, -2, 5, var3);
				this.a(var1, class_aim.Y.S(), 5, -1, 5, var3);
				this.a(var1, class_aim.Y.S(), 6, -3, 5, var3);
				this.a(var1, class_aim.Y.S(), 7, -2, 5, var3);
				this.a(var1, class_aim.Y.S(), 7, -1, 5, var3);
				this.a(var1, class_aim.Y.S(), 8, -3, 5, var3);
				this.a(var1, var3, 9, -1, 1, 9, -1, 5, false, var2, k);
				this.a(var1, var3, 8, -3, 8, 10, -1, 10);
				this.a(var1, class_aim.bf.a(class_ank.P), 8, -2, 11, var3);
				this.a(var1, class_aim.bf.a(class_ank.P), 9, -2, 11, var3);
				this.a(var1, class_aim.bf.a(class_ank.P), 10, -2, 11, var3);
				class_apn var11 = class_aim.ay.S().a(class_ale.a, class_ale.class_a_in_class_ale.e);
				this.a(var1, var11, 8, -2, 12, var3);
				this.a(var1, var11, 9, -2, 12, var3);
				this.a(var1, var11, 10, -2, 12, var3);
				this.a(var1, var3, 8, -3, 8, 8, -3, 10, false, var2, k);
				this.a(var1, var3, 10, -3, 8, 10, -3, 10, false, var2, k);
				this.a(var1, class_aim.Y.S(), 10, -2, 9, var3);
				this.a(var1, class_aim.af.S(), 8, -2, 9, var3);
				this.a(var1, class_aim.af.S(), 8, -2, 10, var3);
				this.a(var1, class_aim.af.S(), 10, -1, 9, var3);
				this.a(var1, class_aim.F.S().a(class_ajk.b, class_cq.b), 9, -2, 8, var3);
				this.a(var1, class_aim.F.S().a(class_ajk.b, class_cq.e), 10, -2, 8, var3);
				this.a(var1, class_aim.F.S().a(class_ajk.b, class_cq.e), 10, -1, 8, var3);
				this.a(var1, class_aim.bb.S().a(class_akx.O, class_cq.c), 10, -2, 10, var3);
				if (!f) {
					f = this.a(var1, var3, var2, 9, -3, 10, class_oj.a(i, new class_oj[] { class_acq.ci.b(var2) }), 2 + var2.nextInt(5));
				}

				return true;
			}
		}

		static {
			i = Lists.newArrayList((Object[]) (new class_oj[] { new class_oj(class_acq.k, 0, 1, 3, 3), new class_oj(class_acq.l, 0, 1, 5, 10), new class_oj(class_acq.m, 0, 2, 7, 15), new class_oj(class_acq.bT, 0, 1, 3, 2), new class_oj(class_acq.aZ, 0, 4, 6, 20), new class_oj(class_acq.bv, 0, 3, 7, 16), new class_oj(class_acq.aC, 0, 1, 1, 3), new class_oj(class_acq.cp, 0, 1, 1, 1), new class_oj(class_acq.cq, 0, 1, 1, 1), new class_oj(class_acq.cr, 0, 1, 1, 1) }));
			j = Lists.newArrayList((Object[]) (new class_oj[] { new class_oj(class_acq.g, 0, 2, 7, 30) }));
			k = new class_aul.class_b_in_class_aul.class_b_in_class_aul$class_a_in_class_b_in_class_aul();
		}

		static class class_b_in_class_aul$class_a_in_class_b_in_class_aul extends class_aur.class_a_in_class_aur {
			private class_b_in_class_aul$class_a_in_class_b_in_class_aul() {
			}

			@Override
			public void a(Random var1, int var2, int var3, int var4, boolean var5) {
				if (var1.nextFloat() < 0.4F) {
					a = class_aim.e.S();
				} else {
					a = class_aim.Y.S();
				}

			}

			// $FF: synthetic method
			class_b_in_class_aul$class_a_in_class_b_in_class_aul(class_aul.SyntheticClass_1 var1) {
				this();
			}
		}
	}

	public static class class_a_in_class_aul extends class_aul.class_c_in_class_aul {
		private boolean[] e = new boolean[4];
		private static final List f;

		public class_a_in_class_aul() {
		}

		public class_a_in_class_aul(Random var1, int var2, int var3) {
			super(var1, var2, 64, var3, 21, 15, 21);
		}

		@Override
		protected void a(class_dn var1) {
			super.a(var1);
			var1.a("hasPlacedChest0", e[0]);
			var1.a("hasPlacedChest1", e[1]);
			var1.a("hasPlacedChest2", e[2]);
			var1.a("hasPlacedChest3", e[3]);
		}

		@Override
		protected void b(class_dn var1) {
			super.b(var1);
			e[0] = var1.p("hasPlacedChest0");
			e[1] = var1.p("hasPlacedChest1");
			e[2] = var1.p("hasPlacedChest2");
			e[3] = var1.p("hasPlacedChest3");
		}

		@Override
		public boolean a(class_ago var1, Random var2, class_aua var3) {
			this.a(var1, var3, 0, -4, 0, a - 1, 0, c - 1, class_aim.A.S(), class_aim.A.S(), false);

			int var4;
			for (var4 = 1; var4 <= 9; ++var4) {
				this.a(var1, var3, var4, var4, var4, a - 1 - var4, var4, c - 1 - var4, class_aim.A.S(), class_aim.A.S(), false);
				this.a(var1, var3, var4 + 1, var4, var4 + 1, a - 2 - var4, var4, c - 2 - var4, class_aim.a.S(), class_aim.a.S(), false);
			}

			for (var4 = 0; var4 < a; ++var4) {
				for (int var5 = 0; var5 < c; ++var5) {
					byte var6 = -5;
					this.b(var1, class_aim.A.S(), var4, var6, var5, var3);
				}
			}

			class_apn var14 = class_aim.bO.S().a(class_anf.a, class_cq.c);
			class_apn var15 = class_aim.bO.S().a(class_anf.a, class_cq.d);
			class_apn var16 = class_aim.bO.S().a(class_anf.a, class_cq.f);
			class_apn var7 = class_aim.bO.S().a(class_anf.a, class_cq.e);
			int var8 = ~class_abt.b.b() & 15;
			int var9 = ~class_abt.l.b() & 15;
			this.a(var1, var3, 0, 0, 0, 4, 9, 4, class_aim.A.S(), class_aim.a.S(), false);
			this.a(var1, var3, 1, 10, 1, 3, 10, 3, class_aim.A.S(), class_aim.A.S(), false);
			this.a(var1, var14, 2, 10, 0, var3);
			this.a(var1, var15, 2, 10, 4, var3);
			this.a(var1, var16, 0, 10, 2, var3);
			this.a(var1, var7, 4, 10, 2, var3);
			this.a(var1, var3, a - 5, 0, 0, a - 1, 9, 4, class_aim.A.S(), class_aim.a.S(), false);
			this.a(var1, var3, a - 4, 10, 1, a - 2, 10, 3, class_aim.A.S(), class_aim.A.S(), false);
			this.a(var1, var14, a - 3, 10, 0, var3);
			this.a(var1, var15, a - 3, 10, 4, var3);
			this.a(var1, var16, a - 5, 10, 2, var3);
			this.a(var1, var7, a - 1, 10, 2, var3);
			this.a(var1, var3, 8, 0, 0, 12, 4, 4, class_aim.A.S(), class_aim.a.S(), false);
			this.a(var1, var3, 9, 1, 0, 11, 3, 4, class_aim.a.S(), class_aim.a.S(), false);
			this.a(var1, class_aim.A.a(class_amt.class_a_in_class_amt.c.a()), 9, 1, 1, var3);
			this.a(var1, class_aim.A.a(class_amt.class_a_in_class_amt.c.a()), 9, 2, 1, var3);
			this.a(var1, class_aim.A.a(class_amt.class_a_in_class_amt.c.a()), 9, 3, 1, var3);
			this.a(var1, class_aim.A.a(class_amt.class_a_in_class_amt.c.a()), 10, 3, 1, var3);
			this.a(var1, class_aim.A.a(class_amt.class_a_in_class_amt.c.a()), 11, 3, 1, var3);
			this.a(var1, class_aim.A.a(class_amt.class_a_in_class_amt.c.a()), 11, 2, 1, var3);
			this.a(var1, class_aim.A.a(class_amt.class_a_in_class_amt.c.a()), 11, 1, 1, var3);
			this.a(var1, var3, 4, 1, 1, 8, 3, 3, class_aim.A.S(), class_aim.a.S(), false);
			this.a(var1, var3, 4, 1, 2, 8, 2, 2, class_aim.a.S(), class_aim.a.S(), false);
			this.a(var1, var3, 12, 1, 1, 16, 3, 3, class_aim.A.S(), class_aim.a.S(), false);
			this.a(var1, var3, 12, 1, 2, 16, 2, 2, class_aim.a.S(), class_aim.a.S(), false);
			this.a(var1, var3, 5, 4, 5, a - 6, 4, c - 6, class_aim.A.S(), class_aim.A.S(), false);
			this.a(var1, var3, 9, 4, 9, 11, 4, 11, class_aim.a.S(), class_aim.a.S(), false);
			this.a(var1, var3, 8, 1, 8, 8, 3, 8, class_aim.A.a(class_amt.class_a_in_class_amt.c.a()), class_aim.A.a(class_amt.class_a_in_class_amt.c.a()), false);
			this.a(var1, var3, 12, 1, 8, 12, 3, 8, class_aim.A.a(class_amt.class_a_in_class_amt.c.a()), class_aim.A.a(class_amt.class_a_in_class_amt.c.a()), false);
			this.a(var1, var3, 8, 1, 12, 8, 3, 12, class_aim.A.a(class_amt.class_a_in_class_amt.c.a()), class_aim.A.a(class_amt.class_a_in_class_amt.c.a()), false);
			this.a(var1, var3, 12, 1, 12, 12, 3, 12, class_aim.A.a(class_amt.class_a_in_class_amt.c.a()), class_aim.A.a(class_amt.class_a_in_class_amt.c.a()), false);
			this.a(var1, var3, 1, 1, 5, 4, 4, 11, class_aim.A.S(), class_aim.A.S(), false);
			this.a(var1, var3, a - 5, 1, 5, a - 2, 4, 11, class_aim.A.S(), class_aim.A.S(), false);
			this.a(var1, var3, 6, 7, 9, 6, 7, 11, class_aim.A.S(), class_aim.A.S(), false);
			this.a(var1, var3, a - 7, 7, 9, a - 7, 7, 11, class_aim.A.S(), class_aim.A.S(), false);
			this.a(var1, var3, 5, 5, 9, 5, 7, 11, class_aim.A.a(class_amt.class_a_in_class_amt.c.a()), class_aim.A.a(class_amt.class_a_in_class_amt.c.a()), false);
			this.a(var1, var3, a - 6, 5, 9, a - 6, 7, 11, class_aim.A.a(class_amt.class_a_in_class_amt.c.a()), class_aim.A.a(class_amt.class_a_in_class_amt.c.a()), false);
			this.a(var1, class_aim.a.S(), 5, 5, 10, var3);
			this.a(var1, class_aim.a.S(), 5, 6, 10, var3);
			this.a(var1, class_aim.a.S(), 6, 6, 10, var3);
			this.a(var1, class_aim.a.S(), a - 6, 5, 10, var3);
			this.a(var1, class_aim.a.S(), a - 6, 6, 10, var3);
			this.a(var1, class_aim.a.S(), a - 7, 6, 10, var3);
			this.a(var1, var3, 2, 4, 4, 2, 6, 4, class_aim.a.S(), class_aim.a.S(), false);
			this.a(var1, var3, a - 3, 4, 4, a - 3, 6, 4, class_aim.a.S(), class_aim.a.S(), false);
			this.a(var1, var14, 2, 4, 5, var3);
			this.a(var1, var14, 2, 3, 4, var3);
			this.a(var1, var14, a - 3, 4, 5, var3);
			this.a(var1, var14, a - 3, 3, 4, var3);
			this.a(var1, var3, 1, 1, 3, 2, 2, 3, class_aim.A.S(), class_aim.A.S(), false);
			this.a(var1, var3, a - 3, 1, 3, a - 2, 2, 3, class_aim.A.S(), class_aim.A.S(), false);
			this.a(var1, class_aim.A.S(), 1, 1, 2, var3);
			this.a(var1, class_aim.A.S(), a - 2, 1, 2, var3);
			this.a(var1, class_aim.U.a(class_anm.class_a_in_class_anm.b.a()), 1, 2, 2, var3);
			this.a(var1, class_aim.U.a(class_anm.class_a_in_class_anm.b.a()), a - 2, 2, 2, var3);
			this.a(var1, var7, 2, 1, 2, var3);
			this.a(var1, var16, a - 3, 1, 2, var3);
			this.a(var1, var3, 4, 3, 5, 4, 3, 18, class_aim.A.S(), class_aim.A.S(), false);
			this.a(var1, var3, a - 5, 3, 5, a - 5, 3, 17, class_aim.A.S(), class_aim.A.S(), false);
			this.a(var1, var3, 3, 1, 5, 4, 2, 16, class_aim.a.S(), class_aim.a.S(), false);
			this.a(var1, var3, a - 6, 1, 5, a - 5, 2, 16, class_aim.a.S(), class_aim.a.S(), false);

			int var10;
			for (var10 = 5; var10 <= 17; var10 += 2) {
				this.a(var1, class_aim.A.a(class_amt.class_a_in_class_amt.c.a()), 4, 1, var10, var3);
				this.a(var1, class_aim.A.a(class_amt.class_a_in_class_amt.b.a()), 4, 2, var10, var3);
				this.a(var1, class_aim.A.a(class_amt.class_a_in_class_amt.c.a()), a - 5, 1, var10, var3);
				this.a(var1, class_aim.A.a(class_amt.class_a_in_class_amt.b.a()), a - 5, 2, var10, var3);
			}

			this.a(var1, class_aim.cu.a(var8), 10, 0, 7, var3);
			this.a(var1, class_aim.cu.a(var8), 10, 0, 8, var3);
			this.a(var1, class_aim.cu.a(var8), 9, 0, 9, var3);
			this.a(var1, class_aim.cu.a(var8), 11, 0, 9, var3);
			this.a(var1, class_aim.cu.a(var8), 8, 0, 10, var3);
			this.a(var1, class_aim.cu.a(var8), 12, 0, 10, var3);
			this.a(var1, class_aim.cu.a(var8), 7, 0, 10, var3);
			this.a(var1, class_aim.cu.a(var8), 13, 0, 10, var3);
			this.a(var1, class_aim.cu.a(var8), 9, 0, 11, var3);
			this.a(var1, class_aim.cu.a(var8), 11, 0, 11, var3);
			this.a(var1, class_aim.cu.a(var8), 10, 0, 12, var3);
			this.a(var1, class_aim.cu.a(var8), 10, 0, 13, var3);
			this.a(var1, class_aim.cu.a(var9), 10, 0, 10, var3);

			for (var10 = 0; var10 <= (a - 1); var10 += a - 1) {
				this.a(var1, class_aim.A.a(class_amt.class_a_in_class_amt.c.a()), var10, 2, 1, var3);
				this.a(var1, class_aim.cu.a(var8), var10, 2, 2, var3);
				this.a(var1, class_aim.A.a(class_amt.class_a_in_class_amt.c.a()), var10, 2, 3, var3);
				this.a(var1, class_aim.A.a(class_amt.class_a_in_class_amt.c.a()), var10, 3, 1, var3);
				this.a(var1, class_aim.cu.a(var8), var10, 3, 2, var3);
				this.a(var1, class_aim.A.a(class_amt.class_a_in_class_amt.c.a()), var10, 3, 3, var3);
				this.a(var1, class_aim.cu.a(var8), var10, 4, 1, var3);
				this.a(var1, class_aim.A.a(class_amt.class_a_in_class_amt.b.a()), var10, 4, 2, var3);
				this.a(var1, class_aim.cu.a(var8), var10, 4, 3, var3);
				this.a(var1, class_aim.A.a(class_amt.class_a_in_class_amt.c.a()), var10, 5, 1, var3);
				this.a(var1, class_aim.cu.a(var8), var10, 5, 2, var3);
				this.a(var1, class_aim.A.a(class_amt.class_a_in_class_amt.c.a()), var10, 5, 3, var3);
				this.a(var1, class_aim.cu.a(var8), var10, 6, 1, var3);
				this.a(var1, class_aim.A.a(class_amt.class_a_in_class_amt.b.a()), var10, 6, 2, var3);
				this.a(var1, class_aim.cu.a(var8), var10, 6, 3, var3);
				this.a(var1, class_aim.cu.a(var8), var10, 7, 1, var3);
				this.a(var1, class_aim.cu.a(var8), var10, 7, 2, var3);
				this.a(var1, class_aim.cu.a(var8), var10, 7, 3, var3);
				this.a(var1, class_aim.A.a(class_amt.class_a_in_class_amt.c.a()), var10, 8, 1, var3);
				this.a(var1, class_aim.A.a(class_amt.class_a_in_class_amt.c.a()), var10, 8, 2, var3);
				this.a(var1, class_aim.A.a(class_amt.class_a_in_class_amt.c.a()), var10, 8, 3, var3);
			}

			for (var10 = 2; var10 <= (a - 3); var10 += a - 3 - 2) {
				this.a(var1, class_aim.A.a(class_amt.class_a_in_class_amt.c.a()), var10 - 1, 2, 0, var3);
				this.a(var1, class_aim.cu.a(var8), var10, 2, 0, var3);
				this.a(var1, class_aim.A.a(class_amt.class_a_in_class_amt.c.a()), var10 + 1, 2, 0, var3);
				this.a(var1, class_aim.A.a(class_amt.class_a_in_class_amt.c.a()), var10 - 1, 3, 0, var3);
				this.a(var1, class_aim.cu.a(var8), var10, 3, 0, var3);
				this.a(var1, class_aim.A.a(class_amt.class_a_in_class_amt.c.a()), var10 + 1, 3, 0, var3);
				this.a(var1, class_aim.cu.a(var8), var10 - 1, 4, 0, var3);
				this.a(var1, class_aim.A.a(class_amt.class_a_in_class_amt.b.a()), var10, 4, 0, var3);
				this.a(var1, class_aim.cu.a(var8), var10 + 1, 4, 0, var3);
				this.a(var1, class_aim.A.a(class_amt.class_a_in_class_amt.c.a()), var10 - 1, 5, 0, var3);
				this.a(var1, class_aim.cu.a(var8), var10, 5, 0, var3);
				this.a(var1, class_aim.A.a(class_amt.class_a_in_class_amt.c.a()), var10 + 1, 5, 0, var3);
				this.a(var1, class_aim.cu.a(var8), var10 - 1, 6, 0, var3);
				this.a(var1, class_aim.A.a(class_amt.class_a_in_class_amt.b.a()), var10, 6, 0, var3);
				this.a(var1, class_aim.cu.a(var8), var10 + 1, 6, 0, var3);
				this.a(var1, class_aim.cu.a(var8), var10 - 1, 7, 0, var3);
				this.a(var1, class_aim.cu.a(var8), var10, 7, 0, var3);
				this.a(var1, class_aim.cu.a(var8), var10 + 1, 7, 0, var3);
				this.a(var1, class_aim.A.a(class_amt.class_a_in_class_amt.c.a()), var10 - 1, 8, 0, var3);
				this.a(var1, class_aim.A.a(class_amt.class_a_in_class_amt.c.a()), var10, 8, 0, var3);
				this.a(var1, class_aim.A.a(class_amt.class_a_in_class_amt.c.a()), var10 + 1, 8, 0, var3);
			}

			this.a(var1, var3, 8, 4, 0, 12, 6, 0, class_aim.A.a(class_amt.class_a_in_class_amt.c.a()), class_aim.A.a(class_amt.class_a_in_class_amt.c.a()), false);
			this.a(var1, class_aim.a.S(), 8, 6, 0, var3);
			this.a(var1, class_aim.a.S(), 12, 6, 0, var3);
			this.a(var1, class_aim.cu.a(var8), 9, 5, 0, var3);
			this.a(var1, class_aim.A.a(class_amt.class_a_in_class_amt.b.a()), 10, 5, 0, var3);
			this.a(var1, class_aim.cu.a(var8), 11, 5, 0, var3);
			this.a(var1, var3, 8, -14, 8, 12, -11, 12, class_aim.A.a(class_amt.class_a_in_class_amt.c.a()), class_aim.A.a(class_amt.class_a_in_class_amt.c.a()), false);
			this.a(var1, var3, 8, -10, 8, 12, -10, 12, class_aim.A.a(class_amt.class_a_in_class_amt.b.a()), class_aim.A.a(class_amt.class_a_in_class_amt.b.a()), false);
			this.a(var1, var3, 8, -9, 8, 12, -9, 12, class_aim.A.a(class_amt.class_a_in_class_amt.c.a()), class_aim.A.a(class_amt.class_a_in_class_amt.c.a()), false);
			this.a(var1, var3, 8, -8, 8, 12, -1, 12, class_aim.A.S(), class_aim.A.S(), false);
			this.a(var1, var3, 9, -11, 9, 11, -1, 11, class_aim.a.S(), class_aim.a.S(), false);
			this.a(var1, class_aim.az.S(), 10, -11, 10, var3);
			this.a(var1, var3, 9, -13, 9, 11, -13, 11, class_aim.W.S(), class_aim.a.S(), false);
			this.a(var1, class_aim.a.S(), 8, -11, 10, var3);
			this.a(var1, class_aim.a.S(), 8, -10, 10, var3);
			this.a(var1, class_aim.A.a(class_amt.class_a_in_class_amt.b.a()), 7, -10, 10, var3);
			this.a(var1, class_aim.A.a(class_amt.class_a_in_class_amt.c.a()), 7, -11, 10, var3);
			this.a(var1, class_aim.a.S(), 12, -11, 10, var3);
			this.a(var1, class_aim.a.S(), 12, -10, 10, var3);
			this.a(var1, class_aim.A.a(class_amt.class_a_in_class_amt.b.a()), 13, -10, 10, var3);
			this.a(var1, class_aim.A.a(class_amt.class_a_in_class_amt.c.a()), 13, -11, 10, var3);
			this.a(var1, class_aim.a.S(), 10, -11, 8, var3);
			this.a(var1, class_aim.a.S(), 10, -10, 8, var3);
			this.a(var1, class_aim.A.a(class_amt.class_a_in_class_amt.b.a()), 10, -10, 7, var3);
			this.a(var1, class_aim.A.a(class_amt.class_a_in_class_amt.c.a()), 10, -11, 7, var3);
			this.a(var1, class_aim.a.S(), 10, -11, 12, var3);
			this.a(var1, class_aim.a.S(), 10, -10, 12, var3);
			this.a(var1, class_aim.A.a(class_amt.class_a_in_class_amt.b.a()), 10, -10, 13, var3);
			this.a(var1, class_aim.A.a(class_amt.class_a_in_class_amt.c.a()), 10, -11, 13, var3);
			Iterator var17 = class_cq.class_c_in_class_cq.a.iterator();

			while (var17.hasNext()) {
				class_cq var11 = (class_cq) var17.next();
				if (!e[var11.b()]) {
					int var12 = var11.g() * 2;
					int var13 = var11.i() * 2;
					e[var11.b()] = this.a(var1, var3, var2, 10 + var12, -11, 10 + var13, class_oj.a(f, new class_oj[] { class_acq.ci.b(var2) }), 2 + var2.nextInt(5));
				}
			}

			return true;
		}

		static {
			f = Lists.newArrayList((Object[]) (new class_oj[] { new class_oj(class_acq.k, 0, 1, 3, 3), new class_oj(class_acq.l, 0, 1, 5, 10), new class_oj(class_acq.m, 0, 2, 7, 15), new class_oj(class_acq.bT, 0, 1, 3, 2), new class_oj(class_acq.aZ, 0, 4, 6, 20), new class_oj(class_acq.bv, 0, 3, 7, 16), new class_oj(class_acq.aC, 0, 1, 1, 3), new class_oj(class_acq.cp, 0, 1, 1, 1), new class_oj(class_acq.cq, 0, 1, 1, 1), new class_oj(class_acq.cr, 0, 1, 1, 1) }));
		}
	}

	abstract static class class_c_in_class_aul extends class_aur {
		protected int a;
		protected int b;
		protected int c;
		protected int d = -1;

		public class_c_in_class_aul() {
		}

		protected class_c_in_class_aul(Random var1, int var2, int var3, int var4, int var5, int var6, int var7) {
			super(0);
			a = var5;
			b = var6;
			c = var7;
			this.a(class_cq.class_c_in_class_cq.a.a(var1));
			if (e().k() == class_cq.class_a_in_class_cq.c) {
				l = new class_aua(var2, var3, var4, (var2 + var5) - 1, (var3 + var6) - 1, (var4 + var7) - 1);
			} else {
				l = new class_aua(var2, var3, var4, (var2 + var7) - 1, (var3 + var6) - 1, (var4 + var5) - 1);
			}

		}

		@Override
		protected void a(class_dn var1) {
			var1.a("Width", a);
			var1.a("Height", b);
			var1.a("Depth", c);
			var1.a("HPos", d);
		}

		@Override
		protected void b(class_dn var1) {
			a = var1.h("Width");
			b = var1.h("Height");
			c = var1.h("Depth");
			d = var1.h("HPos");
		}

		protected boolean a(class_ago var1, class_aua var2, int var3) {
			if (d >= 0) {
				return true;
			} else {
				int var4 = 0;
				int var5 = 0;
				class_cj.class_a_in_class_cj var6 = new class_cj.class_a_in_class_cj();

				for (int var7 = l.c; var7 <= l.f; ++var7) {
					for (int var8 = l.a; var8 <= l.d; ++var8) {
						var6.c(var8, 64, var7);
						if (var2.b(var6)) {
							var4 += Math.max(var1.r(var6).o(), var1.t.i());
							++var5;
						}
					}
				}

				if (var5 == 0) {
					return false;
				} else {
					d = var4 / var5;
					l.a(0, (d - l.b) + var3, 0);
					return true;
				}
			}
		}
	}
}
