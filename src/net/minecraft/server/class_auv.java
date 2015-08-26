package net.minecraft.server;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;

public class class_auv {
	public static void a() {
		class_aup.a(class_auv.class_a_in_class_auv.class, "ViBH");
		class_aup.a(class_auv.class_b_in_class_auv.class, "ViDF");
		class_aup.a(class_auv.class_c_in_class_auv.class, "ViF");
		class_aup.a(class_auv.class_d_in_class_auv.class, "ViL");
		class_aup.a(class_auv.class_f_in_class_auv.class, "ViPH");
		class_aup.a(class_auv.class_g_in_class_auv.class, "ViSH");
		class_aup.a(class_auv.class_h_in_class_auv.class, "ViSmH");
		class_aup.a(class_auv.class_i_in_class_auv.class, "ViST");
		class_aup.a(class_auv.class_j_in_class_auv.class, "ViS");
		class_aup.a(class_auv.class_k_in_class_auv.class, "ViStart");
		class_aup.a(class_auv.class_l_in_class_auv.class, "ViSR");
		class_aup.a(class_auv.class_m_in_class_auv.class, "ViTRH");
		class_aup.a(class_auv.class_p_in_class_auv.class, "ViW");
	}

	public static List a(Random var0, int var1) {
		ArrayList var2 = Lists.newArrayList();
		var2.add(new class_auv.class_e_in_class_auv(class_auv.class_g_in_class_auv.class, 4, MathHelper.a(var0, 2 + var1, 4 + (var1 * 2))));
		var2.add(new class_auv.class_e_in_class_auv(class_auv.class_i_in_class_auv.class, 20, MathHelper.a(var0, 0 + var1, 1 + var1)));
		var2.add(new class_auv.class_e_in_class_auv(class_auv.class_a_in_class_auv.class, 20, MathHelper.a(var0, 0 + var1, 2 + var1)));
		var2.add(new class_auv.class_e_in_class_auv(class_auv.class_h_in_class_auv.class, 3, MathHelper.a(var0, 2 + var1, 5 + (var1 * 3))));
		var2.add(new class_auv.class_e_in_class_auv(class_auv.class_f_in_class_auv.class, 15, MathHelper.a(var0, 0 + var1, 2 + var1)));
		var2.add(new class_auv.class_e_in_class_auv(class_auv.class_b_in_class_auv.class, 3, MathHelper.a(var0, 1 + var1, 4 + var1)));
		var2.add(new class_auv.class_e_in_class_auv(class_auv.class_c_in_class_auv.class, 3, MathHelper.a(var0, 2 + var1, 4 + (var1 * 2))));
		var2.add(new class_auv.class_e_in_class_auv(class_auv.class_j_in_class_auv.class, 15, MathHelper.a(var0, 0, 1 + var1)));
		var2.add(new class_auv.class_e_in_class_auv(class_auv.class_m_in_class_auv.class, 8, MathHelper.a(var0, 0 + var1, 3 + (var1 * 2))));
		Iterator var3 = var2.iterator();

		while (var3.hasNext()) {
			if (((class_auv.class_e_in_class_auv) var3.next()).d == 0) {
				var3.remove();
			}
		}

		return var2;
	}

	private static int a(List var0) {
		boolean var1 = false;
		int var2 = 0;

		class_auv.class_e_in_class_auv var4;
		for (Iterator var3 = var0.iterator(); var3.hasNext(); var2 += var4.b) {
			var4 = (class_auv.class_e_in_class_auv) var3.next();
			if ((var4.d > 0) && (var4.c < var4.d)) {
				var1 = true;
			}
		}

		return var1 ? var2 : -1;
	}

	private static class_auv.class_n_in_class_auv a(class_auv.class_k_in_class_auv var0, class_auv.class_e_in_class_auv var1, List var2, Random var3, int var4, int var5, int var6, class_cq var7, int var8) {
		Class var9 = var1.a;
		Object var10 = null;
		if (var9 == class_auv.class_g_in_class_auv.class) {
			var10 = class_auv.class_g_in_class_auv.a(var0, var2, var3, var4, var5, var6, var7, var8);
		} else if (var9 == class_auv.class_i_in_class_auv.class) {
			var10 = class_auv.class_i_in_class_auv.a(var0, var2, var3, var4, var5, var6, var7, var8);
		} else if (var9 == class_auv.class_a_in_class_auv.class) {
			var10 = class_auv.class_a_in_class_auv.a(var0, var2, var3, var4, var5, var6, var7, var8);
		} else if (var9 == class_auv.class_h_in_class_auv.class) {
			var10 = class_auv.class_h_in_class_auv.a(var0, var2, var3, var4, var5, var6, var7, var8);
		} else if (var9 == class_auv.class_f_in_class_auv.class) {
			var10 = class_auv.class_f_in_class_auv.a(var0, var2, var3, var4, var5, var6, var7, var8);
		} else if (var9 == class_auv.class_b_in_class_auv.class) {
			var10 = class_auv.class_b_in_class_auv.a(var0, var2, var3, var4, var5, var6, var7, var8);
		} else if (var9 == class_auv.class_c_in_class_auv.class) {
			var10 = class_auv.class_c_in_class_auv.a(var0, var2, var3, var4, var5, var6, var7, var8);
		} else if (var9 == class_auv.class_j_in_class_auv.class) {
			var10 = class_auv.class_j_in_class_auv.a(var0, var2, var3, var4, var5, var6, var7, var8);
		} else if (var9 == class_auv.class_m_in_class_auv.class) {
			var10 = class_auv.class_m_in_class_auv.a(var0, var2, var3, var4, var5, var6, var7, var8);
		}

		return (class_auv.class_n_in_class_auv) var10;
	}

	private static class_auv.class_n_in_class_auv c(class_auv.class_k_in_class_auv var0, List var1, Random var2, int var3, int var4, int var5, class_cq var6, int var7) {
		int var8 = a(var0.e);
		if (var8 <= 0) {
			return null;
		} else {
			int var9 = 0;

			while (var9 < 5) {
				++var9;
				int var10 = var2.nextInt(var8);
				Iterator var11 = var0.e.iterator();

				while (var11.hasNext()) {
					class_auv.class_e_in_class_auv var12 = (class_auv.class_e_in_class_auv) var11.next();
					var10 -= var12.b;
					if (var10 < 0) {
						if (!var12.a(var7) || ((var12 == var0.d) && (var0.e.size() > 1))) {
							break;
						}

						class_auv.class_n_in_class_auv var13 = a(var0, var12, var1, var2, var3, var4, var5, var6, var7);
						if (var13 != null) {
							++var12.c;
							var0.d = var12;
							if (!var12.a()) {
								var0.e.remove(var12);
							}

							return var13;
						}
					}
				}
			}

			class_aua var14 = class_auv.class_d_in_class_auv.a(var0, var1, var2, var3, var4, var5, var6);
			if (var14 != null) {
				return new class_auv.class_d_in_class_auv(var0, var7, var2, var14, var6);
			} else {
				return null;
			}
		}
	}

	private static class_aur d(class_auv.class_k_in_class_auv var0, List var1, Random var2, int var3, int var4, int var5, class_cq var6, int var7) {
		if (var7 > 50) {
			return null;
		} else if ((Math.abs(var3 - var0.c().a) <= 112) && (Math.abs(var5 - var0.c().c) <= 112)) {
			class_auv.class_n_in_class_auv var8 = c(var0, var1, var2, var3, var4, var5, var6, var7 + 1);
			if (var8 != null) {
				int var9 = (var8.l.a + var8.l.d) / 2;
				int var10 = (var8.l.c + var8.l.f) / 2;
				int var11 = var8.l.d - var8.l.a;
				int var12 = var8.l.f - var8.l.c;
				int var13 = var11 > var12 ? var11 : var12;
				if (var0.h().a(var9, var10, (var13 / 2) + 4, class_auu.d)) {
					var1.add(var8);
					var0.f.add(var8);
					return var8;
				}
			}

			return null;
		} else {
			return null;
		}
	}

	private static class_aur e(class_auv.class_k_in_class_auv var0, List var1, Random var2, int var3, int var4, int var5, class_cq var6, int var7) {
		if (var7 > (3 + var0.c)) {
			return null;
		} else if ((Math.abs(var3 - var0.c().a) <= 112) && (Math.abs(var5 - var0.c().c) <= 112)) {
			class_aua var8 = class_auv.class_l_in_class_auv.a(var0, var1, var2, var3, var4, var5, var6);
			if ((var8 != null) && (var8.b > 10)) {
				class_auv.class_l_in_class_auv var9 = new class_auv.class_l_in_class_auv(var0, var7, var2, var8, var6);
				int var10 = (var9.l.a + var9.l.d) / 2;
				int var11 = (var9.l.c + var9.l.f) / 2;
				int var12 = var9.l.d - var9.l.a;
				int var13 = var9.l.f - var9.l.c;
				int var14 = var12 > var13 ? var12 : var13;
				if (var0.h().a(var10, var11, (var14 / 2) + 4, class_auu.d)) {
					var1.add(var9);
					var0.g.add(var9);
					return var9;
				}
			}

			return null;
		} else {
			return null;
		}
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

	public static class class_d_in_class_auv extends class_auv.class_n_in_class_auv {
		public class_d_in_class_auv() {
		}

		public class_d_in_class_auv(class_auv.class_k_in_class_auv var1, int var2, Random var3, class_aua var4, class_cq var5) {
			super(var1, var2);
			this.a(var5);
			l = var4;
		}

		public static class_aua a(class_auv.class_k_in_class_auv var0, List var1, Random var2, int var3, int var4, int var5, class_cq var6) {
			class_aua var7 = class_aua.a(var3, var4, var5, 0, 0, 0, 3, 4, 2, var6);
			return class_aur.a(var1, var7) != null ? null : var7;
		}

		@Override
		public boolean a(class_ago var1, Random var2, class_aua var3) {
			if (h < 0) {
				h = this.b(var1, var3);
				if (h < 0) {
					return true;
				}

				l.a(0, ((h - l.e) + 4) - 1, 0);
			}

			this.a(var1, var3, 0, 0, 0, 2, 3, 1, Blocks.AIR.S(), Blocks.AIR.S(), false);
			this.a(var1, Blocks.FENCE.S(), 1, 0, 0, var3);
			this.a(var1, Blocks.FENCE.S(), 1, 1, 0, var3);
			this.a(var1, Blocks.FENCE.S(), 1, 2, 0, var3);
			this.a(var1, Blocks.WOOL.a(class_abt.a.b()), 1, 3, 0, var3);
			this.a(var1, Blocks.TORCH.S().a(class_anr.a, class_cq.f), 2, 3, 0, var3);
			this.a(var1, Blocks.TORCH.S().a(class_anr.a, class_cq.c), 1, 3, 1, var3);
			this.a(var1, Blocks.TORCH.S().a(class_anr.a, class_cq.e), 0, 3, 0, var3);
			this.a(var1, Blocks.TORCH.S().a(class_anr.a, class_cq.d), 1, 3, -1, var3);
			return true;
		}
	}

	public static class class_b_in_class_auv extends class_auv.class_n_in_class_auv {
		private Block a;
		private Block b;
		private Block c;
		private Block d;

		public class_b_in_class_auv() {
		}

		public class_b_in_class_auv(class_auv.class_k_in_class_auv var1, int var2, Random var3, class_aua var4, class_cq var5) {
			super(var1, var2);
			this.a(var5);
			l = var4;
			a = this.a(var3);
			b = this.a(var3);
			c = this.a(var3);
			d = this.a(var3);
		}

		@Override
		protected void a(class_dn var1) {
			super.a(var1);
			var1.a("CA", Block.c.a(a));
			var1.a("CB", Block.c.a(b));
			var1.a("CC", Block.c.a(c));
			var1.a("CD", Block.c.a(d));
		}

		@Override
		protected void b(class_dn var1) {
			super.b(var1);
			a = Block.c(var1.h("CA"));
			b = Block.c(var1.h("CB"));
			c = Block.c(var1.h("CC"));
			d = Block.c(var1.h("CD"));
		}

		private Block a(Random var1) {
			switch (var1.nextInt(10)) {
				case 0:
				case 1:
					return Blocks.CARROTS;
				case 2:
				case 3:
					return Blocks.POTATOES;
				case 4:
					return Blocks.BEETROOTS;
				default:
					return Blocks.WHEAT;
			}
		}

		public static class_auv.class_b_in_class_auv a(class_auv.class_k_in_class_auv var0, List var1, Random var2, int var3, int var4, int var5, class_cq var6, int var7) {
			class_aua var8 = class_aua.a(var3, var4, var5, 0, 0, 0, 13, 4, 9, var6);
			return a(var8) && (class_aur.a(var1, var8) == null) ? new class_auv.class_b_in_class_auv(var0, var7, var2, var8, var6) : null;
		}

		@Override
		public boolean a(class_ago var1, Random var2, class_aua var3) {
			if (h < 0) {
				h = this.b(var1, var3);
				if (h < 0) {
					return true;
				}

				l.a(0, ((h - l.e) + 4) - 1, 0);
			}

			this.a(var1, var3, 0, 1, 0, 12, 4, 8, Blocks.AIR.S(), Blocks.AIR.S(), false);
			this.a(var1, var3, 1, 0, 1, 2, 0, 7, Blocks.FARMLAND.S(), Blocks.FARMLAND.S(), false);
			this.a(var1, var3, 4, 0, 1, 5, 0, 7, Blocks.FARMLAND.S(), Blocks.FARMLAND.S(), false);
			this.a(var1, var3, 7, 0, 1, 8, 0, 7, Blocks.FARMLAND.S(), Blocks.FARMLAND.S(), false);
			this.a(var1, var3, 10, 0, 1, 11, 0, 7, Blocks.FARMLAND.S(), Blocks.FARMLAND.S(), false);
			this.a(var1, var3, 0, 0, 0, 0, 0, 8, Blocks.LOG.S(), Blocks.LOG.S(), false);
			this.a(var1, var3, 6, 0, 0, 6, 0, 8, Blocks.LOG.S(), Blocks.LOG.S(), false);
			this.a(var1, var3, 12, 0, 0, 12, 0, 8, Blocks.LOG.S(), Blocks.LOG.S(), false);
			this.a(var1, var3, 1, 0, 0, 11, 0, 0, Blocks.LOG.S(), Blocks.LOG.S(), false);
			this.a(var1, var3, 1, 0, 8, 11, 0, 8, Blocks.LOG.S(), Blocks.LOG.S(), false);
			this.a(var1, var3, 3, 0, 1, 3, 0, 7, Blocks.WATER.S(), Blocks.WATER.S(), false);
			this.a(var1, var3, 9, 0, 1, 9, 0, 7, Blocks.WATER.S(), Blocks.WATER.S(), false);

			int var4;
			int var5;
			for (var4 = 1; var4 <= 7; ++var4) {
				var5 = ((class_ajf) a).n();
				int var6 = var5 / 3;
				this.a(var1, a.a(MathHelper.a(var2, var6, var5)), 1, 1, var4, var3);
				this.a(var1, a.a(MathHelper.a(var2, var6, var5)), 2, 1, var4, var3);
				int var7 = ((class_ajf) b).n();
				int var8 = var7 / 3;
				this.a(var1, b.a(MathHelper.a(var2, var8, var7)), 4, 1, var4, var3);
				this.a(var1, b.a(MathHelper.a(var2, var8, var7)), 5, 1, var4, var3);
				int var9 = ((class_ajf) c).n();
				int var10 = var9 / 3;
				this.a(var1, c.a(MathHelper.a(var2, var10, var9)), 7, 1, var4, var3);
				this.a(var1, c.a(MathHelper.a(var2, var10, var9)), 8, 1, var4, var3);
				int var11 = ((class_ajf) d).n();
				int var12 = var11 / 3;
				this.a(var1, d.a(MathHelper.a(var2, var12, var11)), 10, 1, var4, var3);
				this.a(var1, d.a(MathHelper.a(var2, var12, var11)), 11, 1, var4, var3);
			}

			for (var4 = 0; var4 < 9; ++var4) {
				for (var5 = 0; var5 < 13; ++var5) {
					this.b(var1, var5, 4, var4, var3);
					this.b(var1, Blocks.DIRT.S(), var5, -1, var4, var3);
				}
			}

			return true;
		}
	}

	public static class class_c_in_class_auv extends class_auv.class_n_in_class_auv {
		private Block a;
		private Block b;

		public class_c_in_class_auv() {
		}

		public class_c_in_class_auv(class_auv.class_k_in_class_auv var1, int var2, Random var3, class_aua var4, class_cq var5) {
			super(var1, var2);
			this.a(var5);
			l = var4;
			a = this.a(var3);
			b = this.a(var3);
		}

		@Override
		protected void a(class_dn var1) {
			super.a(var1);
			var1.a("CA", Block.c.a(a));
			var1.a("CB", Block.c.a(b));
		}

		@Override
		protected void b(class_dn var1) {
			super.b(var1);
			a = Block.c(var1.h("CA"));
			b = Block.c(var1.h("CB"));
		}

		private Block a(Random var1) {
			switch (var1.nextInt(10)) {
				case 0:
				case 1:
					return Blocks.CARROTS;
				case 2:
				case 3:
					return Blocks.POTATOES;
				case 4:
					return Blocks.BEETROOTS;
				default:
					return Blocks.WHEAT;
			}
		}

		public static class_auv.class_c_in_class_auv a(class_auv.class_k_in_class_auv var0, List var1, Random var2, int var3, int var4, int var5, class_cq var6, int var7) {
			class_aua var8 = class_aua.a(var3, var4, var5, 0, 0, 0, 7, 4, 9, var6);
			return a(var8) && (class_aur.a(var1, var8) == null) ? new class_auv.class_c_in_class_auv(var0, var7, var2, var8, var6) : null;
		}

		@Override
		public boolean a(class_ago var1, Random var2, class_aua var3) {
			if (h < 0) {
				h = this.b(var1, var3);
				if (h < 0) {
					return true;
				}

				l.a(0, ((h - l.e) + 4) - 1, 0);
			}

			this.a(var1, var3, 0, 1, 0, 6, 4, 8, Blocks.AIR.S(), Blocks.AIR.S(), false);
			this.a(var1, var3, 1, 0, 1, 2, 0, 7, Blocks.FARMLAND.S(), Blocks.FARMLAND.S(), false);
			this.a(var1, var3, 4, 0, 1, 5, 0, 7, Blocks.FARMLAND.S(), Blocks.FARMLAND.S(), false);
			this.a(var1, var3, 0, 0, 0, 0, 0, 8, Blocks.LOG.S(), Blocks.LOG.S(), false);
			this.a(var1, var3, 6, 0, 0, 6, 0, 8, Blocks.LOG.S(), Blocks.LOG.S(), false);
			this.a(var1, var3, 1, 0, 0, 5, 0, 0, Blocks.LOG.S(), Blocks.LOG.S(), false);
			this.a(var1, var3, 1, 0, 8, 5, 0, 8, Blocks.LOG.S(), Blocks.LOG.S(), false);
			this.a(var1, var3, 3, 0, 1, 3, 0, 7, Blocks.WATER.S(), Blocks.WATER.S(), false);

			int var4;
			int var5;
			for (var4 = 1; var4 <= 7; ++var4) {
				var5 = ((class_ajf) a).n();
				int var6 = var5 / 3;
				this.a(var1, a.a(MathHelper.a(var2, var6, var5)), 1, 1, var4, var3);
				this.a(var1, a.a(MathHelper.a(var2, var6, var5)), 2, 1, var4, var3);
				int var7 = ((class_ajf) b).n();
				int var8 = var7 / 3;
				this.a(var1, b.a(MathHelper.a(var2, var8, var7)), 4, 1, var4, var3);
				this.a(var1, b.a(MathHelper.a(var2, var8, var7)), 5, 1, var4, var3);
			}

			for (var4 = 0; var4 < 9; ++var4) {
				for (var5 = 0; var5 < 7; ++var5) {
					this.b(var1, var5, 4, var4, var3);
					this.b(var1, Blocks.DIRT.S(), var5, -1, var4, var3);
				}
			}

			return true;
		}
	}

	public static class class_j_in_class_auv extends class_auv.class_n_in_class_auv {
		private static final List a;
		private boolean b;

		public class_j_in_class_auv() {
		}

		public class_j_in_class_auv(class_auv.class_k_in_class_auv var1, int var2, Random var3, class_aua var4, class_cq var5) {
			super(var1, var2);
			this.a(var5);
			l = var4;
		}

		public static class_auv.class_j_in_class_auv a(class_auv.class_k_in_class_auv var0, List var1, Random var2, int var3, int var4, int var5, class_cq var6, int var7) {
			class_aua var8 = class_aua.a(var3, var4, var5, 0, 0, 0, 10, 6, 7, var6);
			return a(var8) && (class_aur.a(var1, var8) == null) ? new class_auv.class_j_in_class_auv(var0, var7, var2, var8, var6) : null;
		}

		@Override
		protected void a(class_dn var1) {
			super.a(var1);
			var1.a("Chest", b);
		}

		@Override
		protected void b(class_dn var1) {
			super.b(var1);
			b = var1.p("Chest");
		}

		@Override
		public boolean a(class_ago var1, Random var2, class_aua var3) {
			if (h < 0) {
				h = this.b(var1, var3);
				if (h < 0) {
					return true;
				}

				l.a(0, ((h - l.e) + 6) - 1, 0);
			}

			this.a(var1, var3, 0, 1, 0, 9, 4, 6, Blocks.AIR.S(), Blocks.AIR.S(), false);
			this.a(var1, var3, 0, 0, 0, 9, 0, 6, Blocks.COBBLESTONE.S(), Blocks.COBBLESTONE.S(), false);
			this.a(var1, var3, 0, 4, 0, 9, 4, 6, Blocks.COBBLESTONE.S(), Blocks.COBBLESTONE.S(), false);
			this.a(var1, var3, 0, 5, 0, 9, 5, 6, Blocks.STONE_SLAB.S(), Blocks.STONE_SLAB.S(), false);
			this.a(var1, var3, 1, 5, 1, 8, 5, 5, Blocks.AIR.S(), Blocks.AIR.S(), false);
			this.a(var1, var3, 1, 1, 0, 2, 3, 0, Blocks.PLANKS.S(), Blocks.PLANKS.S(), false);
			this.a(var1, var3, 0, 1, 0, 0, 4, 0, Blocks.LOG.S(), Blocks.LOG.S(), false);
			this.a(var1, var3, 3, 1, 0, 3, 4, 0, Blocks.LOG.S(), Blocks.LOG.S(), false);
			this.a(var1, var3, 0, 1, 6, 0, 4, 6, Blocks.LOG.S(), Blocks.LOG.S(), false);
			this.a(var1, Blocks.PLANKS.S(), 3, 3, 1, var3);
			this.a(var1, var3, 3, 1, 2, 3, 3, 2, Blocks.PLANKS.S(), Blocks.PLANKS.S(), false);
			this.a(var1, var3, 4, 1, 3, 5, 3, 3, Blocks.PLANKS.S(), Blocks.PLANKS.S(), false);
			this.a(var1, var3, 0, 1, 1, 0, 3, 5, Blocks.PLANKS.S(), Blocks.PLANKS.S(), false);
			this.a(var1, var3, 1, 1, 6, 5, 3, 6, Blocks.PLANKS.S(), Blocks.PLANKS.S(), false);
			this.a(var1, var3, 5, 1, 0, 5, 3, 0, Blocks.FENCE.S(), Blocks.FENCE.S(), false);
			this.a(var1, var3, 9, 1, 0, 9, 3, 0, Blocks.FENCE.S(), Blocks.FENCE.S(), false);
			this.a(var1, var3, 6, 1, 4, 9, 4, 6, Blocks.COBBLESTONE.S(), Blocks.COBBLESTONE.S(), false);
			this.a(var1, Blocks.FLOWING_LAVA.S(), 7, 1, 5, var3);
			this.a(var1, Blocks.FLOWING_LAVA.S(), 8, 1, 5, var3);
			this.a(var1, Blocks.IRON_BARS.S(), 9, 2, 5, var3);
			this.a(var1, Blocks.IRON_BARS.S(), 9, 2, 4, var3);
			this.a(var1, var3, 7, 2, 4, 8, 2, 5, Blocks.AIR.S(), Blocks.AIR.S(), false);
			this.a(var1, Blocks.COBBLESTONE.S(), 6, 1, 3, var3);
			this.a(var1, Blocks.FURNACE.S(), 6, 2, 3, var3);
			this.a(var1, Blocks.FURNACE.S(), 6, 3, 3, var3);
			this.a(var1, Blocks.DOUBLE_SANDSTONE_SLAB.S(), 8, 1, 1, var3);
			this.a(var1, Blocks.GLASS_PANE.S(), 0, 2, 2, var3);
			this.a(var1, Blocks.GLASS_PANE.S(), 0, 2, 4, var3);
			this.a(var1, Blocks.GLASS_PANE.S(), 2, 2, 6, var3);
			this.a(var1, Blocks.GLASS_PANE.S(), 4, 2, 6, var3);
			this.a(var1, Blocks.FENCE.S(), 2, 1, 4, var3);
			this.a(var1, Blocks.WOODEN_PRESSURE_PLATE.S(), 2, 2, 4, var3);
			this.a(var1, Blocks.PLANKS.S(), 1, 1, 5, var3);
			this.a(var1, Blocks.OAK_STAIRS.S().a(class_anf.a, class_cq.c), 2, 1, 5, var3);
			this.a(var1, Blocks.OAK_STAIRS.S().a(class_anf.a, class_cq.e), 1, 1, 4, var3);
			if (!b && var3.b((new class_cj(this.a(5, 5), this.d(1), this.b(5, 5))))) {
				b = true;
				this.a(var1, var3, var2, 5, 1, 5, a, 3 + var2.nextInt(6));
			}

			int var4;
			for (var4 = 6; var4 <= 8; ++var4) {
				if ((this.a(var1, var4, 0, -1, var3).c().v() == class_avq.a) && (this.a(var1, var4, -1, -1, var3).c().v() != class_avq.a)) {
					this.a(var1, Blocks.STONE_STAIRS.S().a(class_anf.a, class_cq.c), var4, 0, -1, var3);
				}
			}

			for (var4 = 0; var4 < 7; ++var4) {
				for (int var5 = 0; var5 < 10; ++var5) {
					this.b(var1, var5, 6, var4, var3);
					this.b(var1, Blocks.COBBLESTONE.S(), var5, -1, var4, var3);
				}
			}

			this.a(var1, var3, 7, 1, 1, 1);
			return true;
		}

		@Override
		protected int c(int var1, int var2) {
			return 3;
		}

		static {
			a = Lists.newArrayList((Object[]) (new class_oj[] { new class_oj(Items.k, 0, 1, 3, 3), new class_oj(Items.l, 0, 1, 5, 10), new class_oj(Items.m, 0, 1, 3, 5), new class_oj(Items.R, 0, 1, 3, 15), new class_oj(Items.e, 0, 1, 3, 15), new class_oj(Items.b, 0, 1, 1, 5), new class_oj(Items.n, 0, 1, 1, 5), new class_oj(Items.ab, 0, 1, 1, 5), new class_oj(Items.aa, 0, 1, 1, 5), new class_oj(Items.ac, 0, 1, 1, 5), new class_oj(Items.ad, 0, 1, 1, 5),
					new class_oj(Item.a(Blocks.OBSIDIAN), 0, 3, 7, 5), new class_oj(Item.a(Blocks.SAPLING), 0, 3, 7, 5), new class_oj(Items.aC, 0, 1, 1, 3), new class_oj(Items.cp, 0, 1, 1, 1), new class_oj(Items.cq, 0, 1, 1, 1), new class_oj(Items.cr, 0, 1, 1, 1) }));
		}
	}

	public static class class_m_in_class_auv extends class_auv.class_n_in_class_auv {
		public class_m_in_class_auv() {
		}

		public class_m_in_class_auv(class_auv.class_k_in_class_auv var1, int var2, Random var3, class_aua var4, class_cq var5) {
			super(var1, var2);
			this.a(var5);
			l = var4;
		}

		public static class_auv.class_m_in_class_auv a(class_auv.class_k_in_class_auv var0, List var1, Random var2, int var3, int var4, int var5, class_cq var6, int var7) {
			class_aua var8 = class_aua.a(var3, var4, var5, 0, 0, 0, 9, 7, 12, var6);
			return a(var8) && (class_aur.a(var1, var8) == null) ? new class_auv.class_m_in_class_auv(var0, var7, var2, var8, var6) : null;
		}

		@Override
		public boolean a(class_ago var1, Random var2, class_aua var3) {
			if (h < 0) {
				h = this.b(var1, var3);
				if (h < 0) {
					return true;
				}

				l.a(0, ((h - l.e) + 7) - 1, 0);
			}

			this.a(var1, var3, 1, 1, 1, 7, 4, 4, Blocks.AIR.S(), Blocks.AIR.S(), false);
			this.a(var1, var3, 2, 1, 6, 8, 4, 10, Blocks.AIR.S(), Blocks.AIR.S(), false);
			this.a(var1, var3, 2, 0, 5, 8, 0, 10, Blocks.PLANKS.S(), Blocks.PLANKS.S(), false);
			this.a(var1, var3, 1, 0, 1, 7, 0, 4, Blocks.PLANKS.S(), Blocks.PLANKS.S(), false);
			this.a(var1, var3, 0, 0, 0, 0, 3, 5, Blocks.COBBLESTONE.S(), Blocks.COBBLESTONE.S(), false);
			this.a(var1, var3, 8, 0, 0, 8, 3, 10, Blocks.COBBLESTONE.S(), Blocks.COBBLESTONE.S(), false);
			this.a(var1, var3, 1, 0, 0, 7, 2, 0, Blocks.COBBLESTONE.S(), Blocks.COBBLESTONE.S(), false);
			this.a(var1, var3, 1, 0, 5, 2, 1, 5, Blocks.COBBLESTONE.S(), Blocks.COBBLESTONE.S(), false);
			this.a(var1, var3, 2, 0, 6, 2, 3, 10, Blocks.COBBLESTONE.S(), Blocks.COBBLESTONE.S(), false);
			this.a(var1, var3, 3, 0, 10, 7, 3, 10, Blocks.COBBLESTONE.S(), Blocks.COBBLESTONE.S(), false);
			this.a(var1, var3, 1, 2, 0, 7, 3, 0, Blocks.PLANKS.S(), Blocks.PLANKS.S(), false);
			this.a(var1, var3, 1, 2, 5, 2, 3, 5, Blocks.PLANKS.S(), Blocks.PLANKS.S(), false);
			this.a(var1, var3, 0, 4, 1, 8, 4, 1, Blocks.PLANKS.S(), Blocks.PLANKS.S(), false);
			this.a(var1, var3, 0, 4, 4, 3, 4, 4, Blocks.PLANKS.S(), Blocks.PLANKS.S(), false);
			this.a(var1, var3, 0, 5, 2, 8, 5, 3, Blocks.PLANKS.S(), Blocks.PLANKS.S(), false);
			this.a(var1, Blocks.PLANKS.S(), 0, 4, 2, var3);
			this.a(var1, Blocks.PLANKS.S(), 0, 4, 3, var3);
			this.a(var1, Blocks.PLANKS.S(), 8, 4, 2, var3);
			this.a(var1, Blocks.PLANKS.S(), 8, 4, 3, var3);
			this.a(var1, Blocks.PLANKS.S(), 8, 4, 4, var3);
			class_apn var4 = Blocks.OAK_STAIRS.S().a(class_anf.a, class_cq.c);
			class_apn var5 = Blocks.OAK_STAIRS.S().a(class_anf.a, class_cq.d);
			class_apn var6 = Blocks.OAK_STAIRS.S().a(class_anf.a, class_cq.e);
			class_apn var7 = Blocks.OAK_STAIRS.S().a(class_anf.a, class_cq.f);

			int var8;
			int var9;
			for (var8 = -1; var8 <= 2; ++var8) {
				for (var9 = 0; var9 <= 8; ++var9) {
					this.a(var1, var4, var9, 4 + var8, var8, var3);
					if (((var8 > -1) || (var9 <= 1)) && ((var8 > 0) || (var9 <= 3)) && ((var8 > 1) || (var9 <= 4) || (var9 >= 6))) {
						this.a(var1, var5, var9, 4 + var8, 5 - var8, var3);
					}
				}
			}

			this.a(var1, var3, 3, 4, 5, 3, 4, 10, Blocks.PLANKS.S(), Blocks.PLANKS.S(), false);
			this.a(var1, var3, 7, 4, 2, 7, 4, 10, Blocks.PLANKS.S(), Blocks.PLANKS.S(), false);
			this.a(var1, var3, 4, 5, 4, 4, 5, 10, Blocks.PLANKS.S(), Blocks.PLANKS.S(), false);
			this.a(var1, var3, 6, 5, 4, 6, 5, 10, Blocks.PLANKS.S(), Blocks.PLANKS.S(), false);
			this.a(var1, var3, 5, 6, 3, 5, 6, 10, Blocks.PLANKS.S(), Blocks.PLANKS.S(), false);

			for (var8 = 4; var8 >= 1; --var8) {
				this.a(var1, Blocks.PLANKS.S(), var8, 2 + var8, 7 - var8, var3);

				for (var9 = 8 - var8; var9 <= 10; ++var9) {
					this.a(var1, var7, var8, 2 + var8, var9, var3);
				}
			}

			this.a(var1, Blocks.PLANKS.S(), 6, 6, 3, var3);
			this.a(var1, Blocks.PLANKS.S(), 7, 5, 4, var3);
			this.a(var1, var6, 6, 6, 4, var3);

			for (var8 = 6; var8 <= 8; ++var8) {
				for (var9 = 5; var9 <= 10; ++var9) {
					this.a(var1, var6, var8, 12 - var8, var9, var3);
				}
			}

			this.a(var1, Blocks.LOG.S(), 0, 2, 1, var3);
			this.a(var1, Blocks.LOG.S(), 0, 2, 4, var3);
			this.a(var1, Blocks.GLASS_PANE.S(), 0, 2, 2, var3);
			this.a(var1, Blocks.GLASS_PANE.S(), 0, 2, 3, var3);
			this.a(var1, Blocks.LOG.S(), 4, 2, 0, var3);
			this.a(var1, Blocks.GLASS_PANE.S(), 5, 2, 0, var3);
			this.a(var1, Blocks.LOG.S(), 6, 2, 0, var3);
			this.a(var1, Blocks.LOG.S(), 8, 2, 1, var3);
			this.a(var1, Blocks.GLASS_PANE.S(), 8, 2, 2, var3);
			this.a(var1, Blocks.GLASS_PANE.S(), 8, 2, 3, var3);
			this.a(var1, Blocks.LOG.S(), 8, 2, 4, var3);
			this.a(var1, Blocks.PLANKS.S(), 8, 2, 5, var3);
			this.a(var1, Blocks.LOG.S(), 8, 2, 6, var3);
			this.a(var1, Blocks.GLASS_PANE.S(), 8, 2, 7, var3);
			this.a(var1, Blocks.GLASS_PANE.S(), 8, 2, 8, var3);
			this.a(var1, Blocks.LOG.S(), 8, 2, 9, var3);
			this.a(var1, Blocks.LOG.S(), 2, 2, 6, var3);
			this.a(var1, Blocks.GLASS_PANE.S(), 2, 2, 7, var3);
			this.a(var1, Blocks.GLASS_PANE.S(), 2, 2, 8, var3);
			this.a(var1, Blocks.LOG.S(), 2, 2, 9, var3);
			this.a(var1, Blocks.LOG.S(), 4, 4, 10, var3);
			this.a(var1, Blocks.GLASS_PANE.S(), 5, 4, 10, var3);
			this.a(var1, Blocks.LOG.S(), 6, 4, 10, var3);
			this.a(var1, Blocks.PLANKS.S(), 5, 5, 10, var3);
			this.a(var1, Blocks.AIR.S(), 2, 1, 0, var3);
			this.a(var1, Blocks.AIR.S(), 2, 2, 0, var3);
			this.a(var1, Blocks.TORCH.S().a(class_anr.a, class_cq.c), 2, 3, 1, var3);
			this.a(var1, var3, var2, 2, 1, 0, class_cq.c);
			this.a(var1, var3, 1, 0, -1, 3, 2, -1, Blocks.AIR.S(), Blocks.AIR.S(), false);
			if ((this.a(var1, 2, 0, -1, var3).c().v() == class_avq.a) && (this.a(var1, 2, -1, -1, var3).c().v() != class_avq.a)) {
				this.a(var1, var4, 2, 0, -1, var3);
			}

			for (var8 = 0; var8 < 5; ++var8) {
				for (var9 = 0; var9 < 9; ++var9) {
					this.b(var1, var9, 7, var8, var3);
					this.b(var1, Blocks.COBBLESTONE.S(), var9, -1, var8, var3);
				}
			}

			for (var8 = 5; var8 < 11; ++var8) {
				for (var9 = 2; var9 < 9; ++var9) {
					this.b(var1, var9, 7, var8, var3);
					this.b(var1, Blocks.COBBLESTONE.S(), var9, -1, var8, var3);
				}
			}

			this.a(var1, var3, 4, 1, 2, 2);
			return true;
		}
	}

	public static class class_f_in_class_auv extends class_auv.class_n_in_class_auv {
		public class_f_in_class_auv() {
		}

		public class_f_in_class_auv(class_auv.class_k_in_class_auv var1, int var2, Random var3, class_aua var4, class_cq var5) {
			super(var1, var2);
			this.a(var5);
			l = var4;
		}

		public static class_auv.class_f_in_class_auv a(class_auv.class_k_in_class_auv var0, List var1, Random var2, int var3, int var4, int var5, class_cq var6, int var7) {
			class_aua var8 = class_aua.a(var3, var4, var5, 0, 0, 0, 9, 7, 11, var6);
			return a(var8) && (class_aur.a(var1, var8) == null) ? new class_auv.class_f_in_class_auv(var0, var7, var2, var8, var6) : null;
		}

		@Override
		public boolean a(class_ago var1, Random var2, class_aua var3) {
			if (h < 0) {
				h = this.b(var1, var3);
				if (h < 0) {
					return true;
				}

				l.a(0, ((h - l.e) + 7) - 1, 0);
			}

			this.a(var1, var3, 1, 1, 1, 7, 4, 4, Blocks.AIR.S(), Blocks.AIR.S(), false);
			this.a(var1, var3, 2, 1, 6, 8, 4, 10, Blocks.AIR.S(), Blocks.AIR.S(), false);
			this.a(var1, var3, 2, 0, 6, 8, 0, 10, Blocks.DIRT.S(), Blocks.DIRT.S(), false);
			this.a(var1, Blocks.COBBLESTONE.S(), 6, 0, 6, var3);
			this.a(var1, var3, 2, 1, 6, 2, 1, 10, Blocks.FENCE.S(), Blocks.FENCE.S(), false);
			this.a(var1, var3, 8, 1, 6, 8, 1, 10, Blocks.FENCE.S(), Blocks.FENCE.S(), false);
			this.a(var1, var3, 3, 1, 10, 7, 1, 10, Blocks.FENCE.S(), Blocks.FENCE.S(), false);
			this.a(var1, var3, 1, 0, 1, 7, 0, 4, Blocks.PLANKS.S(), Blocks.PLANKS.S(), false);
			this.a(var1, var3, 0, 0, 0, 0, 3, 5, Blocks.COBBLESTONE.S(), Blocks.COBBLESTONE.S(), false);
			this.a(var1, var3, 8, 0, 0, 8, 3, 5, Blocks.COBBLESTONE.S(), Blocks.COBBLESTONE.S(), false);
			this.a(var1, var3, 1, 0, 0, 7, 1, 0, Blocks.COBBLESTONE.S(), Blocks.COBBLESTONE.S(), false);
			this.a(var1, var3, 1, 0, 5, 7, 1, 5, Blocks.COBBLESTONE.S(), Blocks.COBBLESTONE.S(), false);
			this.a(var1, var3, 1, 2, 0, 7, 3, 0, Blocks.PLANKS.S(), Blocks.PLANKS.S(), false);
			this.a(var1, var3, 1, 2, 5, 7, 3, 5, Blocks.PLANKS.S(), Blocks.PLANKS.S(), false);
			this.a(var1, var3, 0, 4, 1, 8, 4, 1, Blocks.PLANKS.S(), Blocks.PLANKS.S(), false);
			this.a(var1, var3, 0, 4, 4, 8, 4, 4, Blocks.PLANKS.S(), Blocks.PLANKS.S(), false);
			this.a(var1, var3, 0, 5, 2, 8, 5, 3, Blocks.PLANKS.S(), Blocks.PLANKS.S(), false);
			this.a(var1, Blocks.PLANKS.S(), 0, 4, 2, var3);
			this.a(var1, Blocks.PLANKS.S(), 0, 4, 3, var3);
			this.a(var1, Blocks.PLANKS.S(), 8, 4, 2, var3);
			this.a(var1, Blocks.PLANKS.S(), 8, 4, 3, var3);
			class_apn var4 = Blocks.OAK_STAIRS.S().a(class_anf.a, class_cq.c);
			class_apn var5 = Blocks.OAK_STAIRS.S().a(class_anf.a, class_cq.d);
			class_apn var6 = Blocks.OAK_STAIRS.S().a(class_anf.a, class_cq.e);

			int var7;
			int var8;
			for (var7 = -1; var7 <= 2; ++var7) {
				for (var8 = 0; var8 <= 8; ++var8) {
					this.a(var1, var4, var8, 4 + var7, var7, var3);
					this.a(var1, var5, var8, 4 + var7, 5 - var7, var3);
				}
			}

			this.a(var1, Blocks.LOG.S(), 0, 2, 1, var3);
			this.a(var1, Blocks.LOG.S(), 0, 2, 4, var3);
			this.a(var1, Blocks.LOG.S(), 8, 2, 1, var3);
			this.a(var1, Blocks.LOG.S(), 8, 2, 4, var3);
			this.a(var1, Blocks.GLASS_PANE.S(), 0, 2, 2, var3);
			this.a(var1, Blocks.GLASS_PANE.S(), 0, 2, 3, var3);
			this.a(var1, Blocks.GLASS_PANE.S(), 8, 2, 2, var3);
			this.a(var1, Blocks.GLASS_PANE.S(), 8, 2, 3, var3);
			this.a(var1, Blocks.GLASS_PANE.S(), 2, 2, 5, var3);
			this.a(var1, Blocks.GLASS_PANE.S(), 3, 2, 5, var3);
			this.a(var1, Blocks.GLASS_PANE.S(), 5, 2, 0, var3);
			this.a(var1, Blocks.GLASS_PANE.S(), 6, 2, 5, var3);
			this.a(var1, Blocks.FENCE.S(), 2, 1, 3, var3);
			this.a(var1, Blocks.WOODEN_PRESSURE_PLATE.S(), 2, 2, 3, var3);
			this.a(var1, Blocks.PLANKS.S(), 1, 1, 4, var3);
			this.a(var1, var4, 2, 1, 4, var3);
			this.a(var1, var6, 1, 1, 3, var3);
			this.a(var1, var3, 5, 0, 1, 7, 0, 3, Blocks.DOUBLE_SANDSTONE_SLAB.S(), Blocks.DOUBLE_SANDSTONE_SLAB.S(), false);
			this.a(var1, Blocks.DOUBLE_SANDSTONE_SLAB.S(), 6, 1, 1, var3);
			this.a(var1, Blocks.DOUBLE_SANDSTONE_SLAB.S(), 6, 1, 2, var3);
			this.a(var1, Blocks.AIR.S(), 2, 1, 0, var3);
			this.a(var1, Blocks.AIR.S(), 2, 2, 0, var3);
			this.a(var1, Blocks.TORCH.S().a(class_anr.a, class_cq.c), 2, 3, 1, var3);
			this.a(var1, var3, var2, 2, 1, 0, class_cq.c);
			if ((this.a(var1, 2, 0, -1, var3).c().v() == class_avq.a) && (this.a(var1, 2, -1, -1, var3).c().v() != class_avq.a)) {
				this.a(var1, var4, 2, 0, -1, var3);
			}

			this.a(var1, Blocks.AIR.S(), 6, 1, 5, var3);
			this.a(var1, Blocks.AIR.S(), 6, 2, 5, var3);
			this.a(var1, Blocks.TORCH.S().a(class_anr.a, class_cq.d), 6, 3, 4, var3);
			this.a(var1, var3, var2, 6, 1, 5, class_cq.d);

			for (var7 = 0; var7 < 5; ++var7) {
				for (var8 = 0; var8 < 9; ++var8) {
					this.b(var1, var8, 7, var7, var3);
					this.b(var1, Blocks.COBBLESTONE.S(), var8, -1, var7, var3);
				}
			}

			this.a(var1, var3, 4, 1, 2, 2);
			return true;
		}

		@Override
		protected int c(int var1, int var2) {
			return var1 == 0 ? 4 : super.c(var1, var2);
		}
	}

	public static class class_h_in_class_auv extends class_auv.class_n_in_class_auv {
		private boolean a;
		private int b;

		public class_h_in_class_auv() {
		}

		public class_h_in_class_auv(class_auv.class_k_in_class_auv var1, int var2, Random var3, class_aua var4, class_cq var5) {
			super(var1, var2);
			this.a(var5);
			l = var4;
			a = var3.nextBoolean();
			b = var3.nextInt(3);
		}

		@Override
		protected void a(class_dn var1) {
			super.a(var1);
			var1.a("T", b);
			var1.a("C", a);
		}

		@Override
		protected void b(class_dn var1) {
			super.b(var1);
			b = var1.h("T");
			a = var1.p("C");
		}

		public static class_auv.class_h_in_class_auv a(class_auv.class_k_in_class_auv var0, List var1, Random var2, int var3, int var4, int var5, class_cq var6, int var7) {
			class_aua var8 = class_aua.a(var3, var4, var5, 0, 0, 0, 4, 6, 5, var6);
			return a(var8) && (class_aur.a(var1, var8) == null) ? new class_auv.class_h_in_class_auv(var0, var7, var2, var8, var6) : null;
		}

		@Override
		public boolean a(class_ago var1, Random var2, class_aua var3) {
			if (h < 0) {
				h = this.b(var1, var3);
				if (h < 0) {
					return true;
				}

				l.a(0, ((h - l.e) + 6) - 1, 0);
			}

			this.a(var1, var3, 1, 1, 1, 3, 5, 4, Blocks.AIR.S(), Blocks.AIR.S(), false);
			this.a(var1, var3, 0, 0, 0, 3, 0, 4, Blocks.COBBLESTONE.S(), Blocks.COBBLESTONE.S(), false);
			this.a(var1, var3, 1, 0, 1, 2, 0, 3, Blocks.DIRT.S(), Blocks.DIRT.S(), false);
			if (a) {
				this.a(var1, var3, 1, 4, 1, 2, 4, 3, Blocks.LOG.S(), Blocks.LOG.S(), false);
			} else {
				this.a(var1, var3, 1, 5, 1, 2, 5, 3, Blocks.LOG.S(), Blocks.LOG.S(), false);
			}

			this.a(var1, Blocks.LOG.S(), 1, 4, 0, var3);
			this.a(var1, Blocks.LOG.S(), 2, 4, 0, var3);
			this.a(var1, Blocks.LOG.S(), 1, 4, 4, var3);
			this.a(var1, Blocks.LOG.S(), 2, 4, 4, var3);
			this.a(var1, Blocks.LOG.S(), 0, 4, 1, var3);
			this.a(var1, Blocks.LOG.S(), 0, 4, 2, var3);
			this.a(var1, Blocks.LOG.S(), 0, 4, 3, var3);
			this.a(var1, Blocks.LOG.S(), 3, 4, 1, var3);
			this.a(var1, Blocks.LOG.S(), 3, 4, 2, var3);
			this.a(var1, Blocks.LOG.S(), 3, 4, 3, var3);
			this.a(var1, var3, 0, 1, 0, 0, 3, 0, Blocks.LOG.S(), Blocks.LOG.S(), false);
			this.a(var1, var3, 3, 1, 0, 3, 3, 0, Blocks.LOG.S(), Blocks.LOG.S(), false);
			this.a(var1, var3, 0, 1, 4, 0, 3, 4, Blocks.LOG.S(), Blocks.LOG.S(), false);
			this.a(var1, var3, 3, 1, 4, 3, 3, 4, Blocks.LOG.S(), Blocks.LOG.S(), false);
			this.a(var1, var3, 0, 1, 1, 0, 3, 3, Blocks.PLANKS.S(), Blocks.PLANKS.S(), false);
			this.a(var1, var3, 3, 1, 1, 3, 3, 3, Blocks.PLANKS.S(), Blocks.PLANKS.S(), false);
			this.a(var1, var3, 1, 1, 0, 2, 3, 0, Blocks.PLANKS.S(), Blocks.PLANKS.S(), false);
			this.a(var1, var3, 1, 1, 4, 2, 3, 4, Blocks.PLANKS.S(), Blocks.PLANKS.S(), false);
			this.a(var1, Blocks.GLASS_PANE.S(), 0, 2, 2, var3);
			this.a(var1, Blocks.GLASS_PANE.S(), 3, 2, 2, var3);
			if (b > 0) {
				this.a(var1, Blocks.FENCE.S(), b, 1, 3, var3);
				this.a(var1, Blocks.WOODEN_PRESSURE_PLATE.S(), b, 2, 3, var3);
			}

			this.a(var1, Blocks.AIR.S(), 1, 1, 0, var3);
			this.a(var1, Blocks.AIR.S(), 1, 2, 0, var3);
			this.a(var1, var3, var2, 1, 1, 0, class_cq.c);
			if ((this.a(var1, 1, 0, -1, var3).c().v() == class_avq.a) && (this.a(var1, 1, -1, -1, var3).c().v() != class_avq.a)) {
				this.a(var1, Blocks.STONE_STAIRS.S().a(class_anf.a, class_cq.c), 1, 0, -1, var3);
			}

			for (int var4 = 0; var4 < 5; ++var4) {
				for (int var5 = 0; var5 < 4; ++var5) {
					this.b(var1, var5, 6, var4, var3);
					this.b(var1, Blocks.COBBLESTONE.S(), var5, -1, var4, var3);
				}
			}

			this.a(var1, var3, 1, 1, 2, 1);
			return true;
		}
	}

	public static class class_a_in_class_auv extends class_auv.class_n_in_class_auv {
		public class_a_in_class_auv() {
		}

		public class_a_in_class_auv(class_auv.class_k_in_class_auv var1, int var2, Random var3, class_aua var4, class_cq var5) {
			super(var1, var2);
			this.a(var5);
			l = var4;
		}

		public static class_auv.class_a_in_class_auv a(class_auv.class_k_in_class_auv var0, List var1, Random var2, int var3, int var4, int var5, class_cq var6, int var7) {
			class_aua var8 = class_aua.a(var3, var4, var5, 0, 0, 0, 9, 9, 6, var6);
			return a(var8) && (class_aur.a(var1, var8) == null) ? new class_auv.class_a_in_class_auv(var0, var7, var2, var8, var6) : null;
		}

		@Override
		public boolean a(class_ago var1, Random var2, class_aua var3) {
			if (h < 0) {
				h = this.b(var1, var3);
				if (h < 0) {
					return true;
				}

				l.a(0, ((h - l.e) + 9) - 1, 0);
			}

			this.a(var1, var3, 1, 1, 1, 7, 5, 4, Blocks.AIR.S(), Blocks.AIR.S(), false);
			this.a(var1, var3, 0, 0, 0, 8, 0, 5, Blocks.COBBLESTONE.S(), Blocks.COBBLESTONE.S(), false);
			this.a(var1, var3, 0, 5, 0, 8, 5, 5, Blocks.COBBLESTONE.S(), Blocks.COBBLESTONE.S(), false);
			this.a(var1, var3, 0, 6, 1, 8, 6, 4, Blocks.COBBLESTONE.S(), Blocks.COBBLESTONE.S(), false);
			this.a(var1, var3, 0, 7, 2, 8, 7, 3, Blocks.COBBLESTONE.S(), Blocks.COBBLESTONE.S(), false);

			int var5;
			for (int var4 = -1; var4 <= 2; ++var4) {
				for (var5 = 0; var5 <= 8; ++var5) {
					this.a(var1, Blocks.OAK_STAIRS.S().a(class_anf.a, class_cq.c), var5, 6 + var4, var4, var3);
					this.a(var1, Blocks.OAK_STAIRS.S().a(class_anf.a, class_cq.d), var5, 6 + var4, 5 - var4, var3);
				}
			}

			this.a(var1, var3, 0, 1, 0, 0, 1, 5, Blocks.COBBLESTONE.S(), Blocks.COBBLESTONE.S(), false);
			this.a(var1, var3, 1, 1, 5, 8, 1, 5, Blocks.COBBLESTONE.S(), Blocks.COBBLESTONE.S(), false);
			this.a(var1, var3, 8, 1, 0, 8, 1, 4, Blocks.COBBLESTONE.S(), Blocks.COBBLESTONE.S(), false);
			this.a(var1, var3, 2, 1, 0, 7, 1, 0, Blocks.COBBLESTONE.S(), Blocks.COBBLESTONE.S(), false);
			this.a(var1, var3, 0, 2, 0, 0, 4, 0, Blocks.COBBLESTONE.S(), Blocks.COBBLESTONE.S(), false);
			this.a(var1, var3, 0, 2, 5, 0, 4, 5, Blocks.COBBLESTONE.S(), Blocks.COBBLESTONE.S(), false);
			this.a(var1, var3, 8, 2, 5, 8, 4, 5, Blocks.COBBLESTONE.S(), Blocks.COBBLESTONE.S(), false);
			this.a(var1, var3, 8, 2, 0, 8, 4, 0, Blocks.COBBLESTONE.S(), Blocks.COBBLESTONE.S(), false);
			this.a(var1, var3, 0, 2, 1, 0, 4, 4, Blocks.PLANKS.S(), Blocks.PLANKS.S(), false);
			this.a(var1, var3, 1, 2, 5, 7, 4, 5, Blocks.PLANKS.S(), Blocks.PLANKS.S(), false);
			this.a(var1, var3, 8, 2, 1, 8, 4, 4, Blocks.PLANKS.S(), Blocks.PLANKS.S(), false);
			this.a(var1, var3, 1, 2, 0, 7, 4, 0, Blocks.PLANKS.S(), Blocks.PLANKS.S(), false);
			this.a(var1, Blocks.GLASS_PANE.S(), 4, 2, 0, var3);
			this.a(var1, Blocks.GLASS_PANE.S(), 5, 2, 0, var3);
			this.a(var1, Blocks.GLASS_PANE.S(), 6, 2, 0, var3);
			this.a(var1, Blocks.GLASS_PANE.S(), 4, 3, 0, var3);
			this.a(var1, Blocks.GLASS_PANE.S(), 5, 3, 0, var3);
			this.a(var1, Blocks.GLASS_PANE.S(), 6, 3, 0, var3);
			this.a(var1, Blocks.GLASS_PANE.S(), 0, 2, 2, var3);
			this.a(var1, Blocks.GLASS_PANE.S(), 0, 2, 3, var3);
			this.a(var1, Blocks.GLASS_PANE.S(), 0, 3, 2, var3);
			this.a(var1, Blocks.GLASS_PANE.S(), 0, 3, 3, var3);
			this.a(var1, Blocks.GLASS_PANE.S(), 8, 2, 2, var3);
			this.a(var1, Blocks.GLASS_PANE.S(), 8, 2, 3, var3);
			this.a(var1, Blocks.GLASS_PANE.S(), 8, 3, 2, var3);
			this.a(var1, Blocks.GLASS_PANE.S(), 8, 3, 3, var3);
			this.a(var1, Blocks.GLASS_PANE.S(), 2, 2, 5, var3);
			this.a(var1, Blocks.GLASS_PANE.S(), 3, 2, 5, var3);
			this.a(var1, Blocks.GLASS_PANE.S(), 5, 2, 5, var3);
			this.a(var1, Blocks.GLASS_PANE.S(), 6, 2, 5, var3);
			this.a(var1, var3, 1, 4, 1, 7, 4, 1, Blocks.PLANKS.S(), Blocks.PLANKS.S(), false);
			this.a(var1, var3, 1, 4, 4, 7, 4, 4, Blocks.PLANKS.S(), Blocks.PLANKS.S(), false);
			this.a(var1, var3, 1, 3, 4, 7, 3, 4, Blocks.BOOKSHELF.S(), Blocks.BOOKSHELF.S(), false);
			this.a(var1, Blocks.PLANKS.S(), 7, 1, 4, var3);
			this.a(var1, Blocks.OAK_STAIRS.S().a(class_anf.a, class_cq.f), 7, 1, 3, var3);
			class_apn var7 = Blocks.OAK_STAIRS.S().a(class_anf.a, class_cq.c);
			this.a(var1, var7, 6, 1, 4, var3);
			this.a(var1, var7, 5, 1, 4, var3);
			this.a(var1, var7, 4, 1, 4, var3);
			this.a(var1, var7, 3, 1, 4, var3);
			this.a(var1, Blocks.FENCE.S(), 6, 1, 3, var3);
			this.a(var1, Blocks.WOODEN_PRESSURE_PLATE.S(), 6, 2, 3, var3);
			this.a(var1, Blocks.FENCE.S(), 4, 1, 3, var3);
			this.a(var1, Blocks.WOODEN_PRESSURE_PLATE.S(), 4, 2, 3, var3);
			this.a(var1, Blocks.CRAFTING_TABLE.S(), 7, 1, 1, var3);
			this.a(var1, Blocks.AIR.S(), 1, 1, 0, var3);
			this.a(var1, Blocks.AIR.S(), 1, 2, 0, var3);
			this.a(var1, var3, var2, 1, 1, 0, class_cq.c);
			if ((this.a(var1, 1, 0, -1, var3).c().v() == class_avq.a) && (this.a(var1, 1, -1, -1, var3).c().v() != class_avq.a)) {
				this.a(var1, Blocks.STONE_STAIRS.S().a(class_anf.a, class_cq.c), 1, 0, -1, var3);
			}

			for (var5 = 0; var5 < 6; ++var5) {
				for (int var6 = 0; var6 < 9; ++var6) {
					this.b(var1, var6, 9, var5, var3);
					this.b(var1, Blocks.COBBLESTONE.S(), var6, -1, var5, var3);
				}
			}

			this.a(var1, var3, 2, 1, 2, 1);
			return true;
		}

		@Override
		protected int c(int var1, int var2) {
			return 1;
		}
	}

	public static class class_i_in_class_auv extends class_auv.class_n_in_class_auv {
		public class_i_in_class_auv() {
		}

		public class_i_in_class_auv(class_auv.class_k_in_class_auv var1, int var2, Random var3, class_aua var4, class_cq var5) {
			super(var1, var2);
			this.a(var5);
			l = var4;
		}

		public static class_auv.class_i_in_class_auv a(class_auv.class_k_in_class_auv var0, List var1, Random var2, int var3, int var4, int var5, class_cq var6, int var7) {
			class_aua var8 = class_aua.a(var3, var4, var5, 0, 0, 0, 5, 12, 9, var6);
			return a(var8) && (class_aur.a(var1, var8) == null) ? new class_auv.class_i_in_class_auv(var0, var7, var2, var8, var6) : null;
		}

		@Override
		public boolean a(class_ago var1, Random var2, class_aua var3) {
			if (h < 0) {
				h = this.b(var1, var3);
				if (h < 0) {
					return true;
				}

				l.a(0, ((h - l.e) + 12) - 1, 0);
			}

			this.a(var1, var3, 1, 1, 1, 3, 3, 7, Blocks.AIR.S(), Blocks.AIR.S(), false);
			this.a(var1, var3, 1, 5, 1, 3, 9, 3, Blocks.AIR.S(), Blocks.AIR.S(), false);
			this.a(var1, var3, 1, 0, 0, 3, 0, 8, Blocks.COBBLESTONE.S(), Blocks.COBBLESTONE.S(), false);
			this.a(var1, var3, 1, 1, 0, 3, 10, 0, Blocks.COBBLESTONE.S(), Blocks.COBBLESTONE.S(), false);
			this.a(var1, var3, 0, 1, 1, 0, 10, 3, Blocks.COBBLESTONE.S(), Blocks.COBBLESTONE.S(), false);
			this.a(var1, var3, 4, 1, 1, 4, 10, 3, Blocks.COBBLESTONE.S(), Blocks.COBBLESTONE.S(), false);
			this.a(var1, var3, 0, 0, 4, 0, 4, 7, Blocks.COBBLESTONE.S(), Blocks.COBBLESTONE.S(), false);
			this.a(var1, var3, 4, 0, 4, 4, 4, 7, Blocks.COBBLESTONE.S(), Blocks.COBBLESTONE.S(), false);
			this.a(var1, var3, 1, 1, 8, 3, 4, 8, Blocks.COBBLESTONE.S(), Blocks.COBBLESTONE.S(), false);
			this.a(var1, var3, 1, 5, 4, 3, 10, 4, Blocks.COBBLESTONE.S(), Blocks.COBBLESTONE.S(), false);
			this.a(var1, var3, 1, 5, 5, 3, 5, 7, Blocks.COBBLESTONE.S(), Blocks.COBBLESTONE.S(), false);
			this.a(var1, var3, 0, 9, 0, 4, 9, 4, Blocks.COBBLESTONE.S(), Blocks.COBBLESTONE.S(), false);
			this.a(var1, var3, 0, 4, 0, 4, 4, 4, Blocks.COBBLESTONE.S(), Blocks.COBBLESTONE.S(), false);
			this.a(var1, Blocks.COBBLESTONE.S(), 0, 11, 2, var3);
			this.a(var1, Blocks.COBBLESTONE.S(), 4, 11, 2, var3);
			this.a(var1, Blocks.COBBLESTONE.S(), 2, 11, 0, var3);
			this.a(var1, Blocks.COBBLESTONE.S(), 2, 11, 4, var3);
			this.a(var1, Blocks.COBBLESTONE.S(), 1, 1, 6, var3);
			this.a(var1, Blocks.COBBLESTONE.S(), 1, 1, 7, var3);
			this.a(var1, Blocks.COBBLESTONE.S(), 2, 1, 7, var3);
			this.a(var1, Blocks.COBBLESTONE.S(), 3, 1, 6, var3);
			this.a(var1, Blocks.COBBLESTONE.S(), 3, 1, 7, var3);
			class_apn var4 = Blocks.STONE_STAIRS.S().a(class_anf.a, class_cq.c);
			class_apn var5 = Blocks.STONE_STAIRS.S().a(class_anf.a, class_cq.e);
			class_apn var6 = Blocks.STONE_STAIRS.S().a(class_anf.a, class_cq.f);
			this.a(var1, var4, 1, 1, 5, var3);
			this.a(var1, var4, 2, 1, 6, var3);
			this.a(var1, var4, 3, 1, 5, var3);
			this.a(var1, var5, 1, 2, 7, var3);
			this.a(var1, var6, 3, 2, 7, var3);
			this.a(var1, Blocks.GLASS_PANE.S(), 0, 2, 2, var3);
			this.a(var1, Blocks.GLASS_PANE.S(), 0, 3, 2, var3);
			this.a(var1, Blocks.GLASS_PANE.S(), 4, 2, 2, var3);
			this.a(var1, Blocks.GLASS_PANE.S(), 4, 3, 2, var3);
			this.a(var1, Blocks.GLASS_PANE.S(), 0, 6, 2, var3);
			this.a(var1, Blocks.GLASS_PANE.S(), 0, 7, 2, var3);
			this.a(var1, Blocks.GLASS_PANE.S(), 4, 6, 2, var3);
			this.a(var1, Blocks.GLASS_PANE.S(), 4, 7, 2, var3);
			this.a(var1, Blocks.GLASS_PANE.S(), 2, 6, 0, var3);
			this.a(var1, Blocks.GLASS_PANE.S(), 2, 7, 0, var3);
			this.a(var1, Blocks.GLASS_PANE.S(), 2, 6, 4, var3);
			this.a(var1, Blocks.GLASS_PANE.S(), 2, 7, 4, var3);
			this.a(var1, Blocks.GLASS_PANE.S(), 0, 3, 6, var3);
			this.a(var1, Blocks.GLASS_PANE.S(), 4, 3, 6, var3);
			this.a(var1, Blocks.GLASS_PANE.S(), 2, 3, 8, var3);
			this.a(var1, Blocks.TORCH.S().a(class_anr.a, class_cq.d), 2, 4, 7, var3);
			this.a(var1, Blocks.TORCH.S().a(class_anr.a, class_cq.f), 1, 4, 6, var3);
			this.a(var1, Blocks.TORCH.S().a(class_anr.a, class_cq.e), 3, 4, 6, var3);
			this.a(var1, Blocks.TORCH.S().a(class_anr.a, class_cq.c), 2, 4, 5, var3);
			class_apn var7 = Blocks.LADDER.S().a(class_alb.a, class_cq.e);

			int var8;
			for (var8 = 1; var8 <= 9; ++var8) {
				this.a(var1, var7, 3, var8, 3, var3);
			}

			this.a(var1, Blocks.AIR.S(), 2, 1, 0, var3);
			this.a(var1, Blocks.AIR.S(), 2, 2, 0, var3);
			this.a(var1, var3, var2, 2, 1, 0, class_cq.c);
			if ((this.a(var1, 2, 0, -1, var3).c().v() == class_avq.a) && (this.a(var1, 2, -1, -1, var3).c().v() != class_avq.a)) {
				this.a(var1, var4, 2, 0, -1, var3);
			}

			for (var8 = 0; var8 < 9; ++var8) {
				for (int var9 = 0; var9 < 5; ++var9) {
					this.b(var1, var9, 12, var8, var3);
					this.b(var1, Blocks.COBBLESTONE.S(), var9, -1, var8, var3);
				}
			}

			this.a(var1, var3, 2, 1, 2, 1);
			return true;
		}

		@Override
		protected int c(int var1, int var2) {
			return 2;
		}
	}

	public static class class_g_in_class_auv extends class_auv.class_n_in_class_auv {
		private boolean a;

		public class_g_in_class_auv() {
		}

		public class_g_in_class_auv(class_auv.class_k_in_class_auv var1, int var2, Random var3, class_aua var4, class_cq var5) {
			super(var1, var2);
			this.a(var5);
			l = var4;
			a = var3.nextBoolean();
		}

		@Override
		protected void a(class_dn var1) {
			super.a(var1);
			var1.a("Terrace", a);
		}

		@Override
		protected void b(class_dn var1) {
			super.b(var1);
			a = var1.p("Terrace");
		}

		public static class_auv.class_g_in_class_auv a(class_auv.class_k_in_class_auv var0, List var1, Random var2, int var3, int var4, int var5, class_cq var6, int var7) {
			class_aua var8 = class_aua.a(var3, var4, var5, 0, 0, 0, 5, 6, 5, var6);
			return class_aur.a(var1, var8) != null ? null : new class_auv.class_g_in_class_auv(var0, var7, var2, var8, var6);
		}

		@Override
		public boolean a(class_ago var1, Random var2, class_aua var3) {
			if (h < 0) {
				h = this.b(var1, var3);
				if (h < 0) {
					return true;
				}

				l.a(0, ((h - l.e) + 6) - 1, 0);
			}

			this.a(var1, var3, 0, 0, 0, 4, 0, 4, Blocks.COBBLESTONE.S(), Blocks.COBBLESTONE.S(), false);
			this.a(var1, var3, 0, 4, 0, 4, 4, 4, Blocks.LOG.S(), Blocks.LOG.S(), false);
			this.a(var1, var3, 1, 4, 1, 3, 4, 3, Blocks.PLANKS.S(), Blocks.PLANKS.S(), false);
			this.a(var1, Blocks.COBBLESTONE.S(), 0, 1, 0, var3);
			this.a(var1, Blocks.COBBLESTONE.S(), 0, 2, 0, var3);
			this.a(var1, Blocks.COBBLESTONE.S(), 0, 3, 0, var3);
			this.a(var1, Blocks.COBBLESTONE.S(), 4, 1, 0, var3);
			this.a(var1, Blocks.COBBLESTONE.S(), 4, 2, 0, var3);
			this.a(var1, Blocks.COBBLESTONE.S(), 4, 3, 0, var3);
			this.a(var1, Blocks.COBBLESTONE.S(), 0, 1, 4, var3);
			this.a(var1, Blocks.COBBLESTONE.S(), 0, 2, 4, var3);
			this.a(var1, Blocks.COBBLESTONE.S(), 0, 3, 4, var3);
			this.a(var1, Blocks.COBBLESTONE.S(), 4, 1, 4, var3);
			this.a(var1, Blocks.COBBLESTONE.S(), 4, 2, 4, var3);
			this.a(var1, Blocks.COBBLESTONE.S(), 4, 3, 4, var3);
			this.a(var1, var3, 0, 1, 1, 0, 3, 3, Blocks.PLANKS.S(), Blocks.PLANKS.S(), false);
			this.a(var1, var3, 4, 1, 1, 4, 3, 3, Blocks.PLANKS.S(), Blocks.PLANKS.S(), false);
			this.a(var1, var3, 1, 1, 4, 3, 3, 4, Blocks.PLANKS.S(), Blocks.PLANKS.S(), false);
			this.a(var1, Blocks.GLASS_PANE.S(), 0, 2, 2, var3);
			this.a(var1, Blocks.GLASS_PANE.S(), 2, 2, 4, var3);
			this.a(var1, Blocks.GLASS_PANE.S(), 4, 2, 2, var3);
			this.a(var1, Blocks.PLANKS.S(), 1, 1, 0, var3);
			this.a(var1, Blocks.PLANKS.S(), 1, 2, 0, var3);
			this.a(var1, Blocks.PLANKS.S(), 1, 3, 0, var3);
			this.a(var1, Blocks.PLANKS.S(), 2, 3, 0, var3);
			this.a(var1, Blocks.PLANKS.S(), 3, 3, 0, var3);
			this.a(var1, Blocks.PLANKS.S(), 3, 2, 0, var3);
			this.a(var1, Blocks.PLANKS.S(), 3, 1, 0, var3);
			if ((this.a(var1, 2, 0, -1, var3).c().v() == class_avq.a) && (this.a(var1, 2, -1, -1, var3).c().v() != class_avq.a)) {
				this.a(var1, Blocks.STONE_STAIRS.S().a(class_anf.a, class_cq.c), 2, 0, -1, var3);
			}

			this.a(var1, var3, 1, 1, 1, 3, 3, 3, Blocks.AIR.S(), Blocks.AIR.S(), false);
			if (a) {
				this.a(var1, Blocks.FENCE.S(), 0, 5, 0, var3);
				this.a(var1, Blocks.FENCE.S(), 1, 5, 0, var3);
				this.a(var1, Blocks.FENCE.S(), 2, 5, 0, var3);
				this.a(var1, Blocks.FENCE.S(), 3, 5, 0, var3);
				this.a(var1, Blocks.FENCE.S(), 4, 5, 0, var3);
				this.a(var1, Blocks.FENCE.S(), 0, 5, 4, var3);
				this.a(var1, Blocks.FENCE.S(), 1, 5, 4, var3);
				this.a(var1, Blocks.FENCE.S(), 2, 5, 4, var3);
				this.a(var1, Blocks.FENCE.S(), 3, 5, 4, var3);
				this.a(var1, Blocks.FENCE.S(), 4, 5, 4, var3);
				this.a(var1, Blocks.FENCE.S(), 4, 5, 1, var3);
				this.a(var1, Blocks.FENCE.S(), 4, 5, 2, var3);
				this.a(var1, Blocks.FENCE.S(), 4, 5, 3, var3);
				this.a(var1, Blocks.FENCE.S(), 0, 5, 1, var3);
				this.a(var1, Blocks.FENCE.S(), 0, 5, 2, var3);
				this.a(var1, Blocks.FENCE.S(), 0, 5, 3, var3);
			}

			if (a) {
				class_apn var4 = Blocks.LADDER.S().a(class_alb.a, class_cq.d);
				this.a(var1, var4, 3, 1, 3, var3);
				this.a(var1, var4, 3, 2, 3, var3);
				this.a(var1, var4, 3, 3, 3, var3);
				this.a(var1, var4, 3, 4, 3, var3);
			}

			this.a(var1, Blocks.TORCH.S().a(class_anr.a, class_cq.c), 2, 3, 1, var3);

			for (int var6 = 0; var6 < 5; ++var6) {
				for (int var5 = 0; var5 < 5; ++var5) {
					this.b(var1, var5, 6, var6, var3);
					this.b(var1, Blocks.COBBLESTONE.S(), var5, -1, var6, var3);
				}
			}

			this.a(var1, var3, 1, 1, 2, 1);
			return true;
		}
	}

	public static class class_l_in_class_auv extends class_auv.class_o_in_class_auv {
		private int a;

		public class_l_in_class_auv() {
		}

		public class_l_in_class_auv(class_auv.class_k_in_class_auv var1, int var2, Random var3, class_aua var4, class_cq var5) {
			super(var1, var2);
			this.a(var5);
			l = var4;
			a = Math.max(var4.c(), var4.e());
		}

		@Override
		protected void a(class_dn var1) {
			super.a(var1);
			var1.a("Length", a);
		}

		@Override
		protected void b(class_dn var1) {
			super.b(var1);
			a = var1.h("Length");
		}

		@Override
		public void a(class_aur var1, List var2, Random var3) {
			boolean var4 = false;

			int var5;
			class_aur var6;
			for (var5 = var3.nextInt(5); var5 < (a - 8); var5 += 2 + var3.nextInt(5)) {
				var6 = this.a((class_auv.class_k_in_class_auv) var1, var2, var3, 0, var5);
				if (var6 != null) {
					var5 += Math.max(var6.l.c(), var6.l.e());
					var4 = true;
				}
			}

			for (var5 = var3.nextInt(5); var5 < (a - 8); var5 += 2 + var3.nextInt(5)) {
				var6 = this.b((class_auv.class_k_in_class_auv) var1, var2, var3, 0, var5);
				if (var6 != null) {
					var5 += Math.max(var6.l.c(), var6.l.e());
					var4 = true;
				}
			}

			class_cq var7 = this.e();
			if (var4 && (var3.nextInt(3) > 0) && (var7 != null)) {
				switch (class_auv.SyntheticClass_1.a[var7.ordinal()]) {
					case 1:
						class_auv.e((class_auv.class_k_in_class_auv) var1, var2, var3, l.a - 1, l.b, l.c, class_cq.e, this.d());
						break;
					case 2:
						class_auv.e((class_auv.class_k_in_class_auv) var1, var2, var3, l.a - 1, l.b, l.f - 2, class_cq.e, this.d());
						break;
					case 3:
						class_auv.e((class_auv.class_k_in_class_auv) var1, var2, var3, l.a, l.b, l.c - 1, class_cq.c, this.d());
						break;
					case 4:
						class_auv.e((class_auv.class_k_in_class_auv) var1, var2, var3, l.d - 2, l.b, l.c - 1, class_cq.c, this.d());
				}
			}

			if (var4 && (var3.nextInt(3) > 0) && (var7 != null)) {
				switch (class_auv.SyntheticClass_1.a[var7.ordinal()]) {
					case 1:
						class_auv.e((class_auv.class_k_in_class_auv) var1, var2, var3, l.d + 1, l.b, l.c, class_cq.f, this.d());
						break;
					case 2:
						class_auv.e((class_auv.class_k_in_class_auv) var1, var2, var3, l.d + 1, l.b, l.f - 2, class_cq.f, this.d());
						break;
					case 3:
						class_auv.e((class_auv.class_k_in_class_auv) var1, var2, var3, l.a, l.b, l.f + 1, class_cq.d, this.d());
						break;
					case 4:
						class_auv.e((class_auv.class_k_in_class_auv) var1, var2, var3, l.d - 2, l.b, l.f + 1, class_cq.d, this.d());
				}
			}

		}

		public static class_aua a(class_auv.class_k_in_class_auv var0, List var1, Random var2, int var3, int var4, int var5, class_cq var6) {
			for (int var7 = 7 * MathHelper.a(var2, 3, 5); var7 >= 7; var7 -= 7) {
				class_aua var8 = class_aua.a(var3, var4, var5, 0, 0, 0, 3, 3, var7, var6);
				if (class_aur.a(var1, var8) == null) {
					return var8;
				}
			}

			return null;
		}

		@Override
		public boolean a(class_ago var1, Random var2, class_aua var3) {
			class_apn var4 = this.a(Blocks.GRAVEL.S());
			class_apn var5 = this.a(Blocks.COBBLESTONE.S());

			for (int var6 = l.a; var6 <= l.d; ++var6) {
				for (int var7 = l.c; var7 <= l.f; ++var7) {
					class_cj var8 = new class_cj(var6, 64, var7);
					if (var3.b(var8)) {
						var8 = var1.r(var8).b();
						var1.a(var8, var4, 2);
						var1.a(var8.b(), var5, 2);
					}
				}
			}

			return true;
		}
	}

	public abstract static class class_o_in_class_auv extends class_auv.class_n_in_class_auv {
		public class_o_in_class_auv() {
		}

		protected class_o_in_class_auv(class_auv.class_k_in_class_auv var1, int var2) {
			super(var1, var2);
		}
	}

	public static class class_k_in_class_auv extends class_auv.class_p_in_class_auv {
		public class_ahf a;
		public boolean b;
		public int c;
		public class_auv.class_e_in_class_auv d;
		public List e;
		public List f = Lists.newArrayList();
		public List g = Lists.newArrayList();

		public class_k_in_class_auv() {
		}

		public class_k_in_class_auv(class_ahf var1, int var2, Random var3, int var4, int var5, List var6, int var7) {
			super((class_auv.class_k_in_class_auv) null, 0, var3, var4, var5);
			a = var1;
			e = var6;
			c = var7;
			class_ahb var8 = var1.a(new class_cj(var4, 0, var5), class_ahb.ad);
			b = (var8 == class_ahb.r) || (var8 == class_ahb.G);
			this.a(b);
		}

		public class_ahf h() {
			return a;
		}
	}

	public static class class_p_in_class_auv extends class_auv.class_n_in_class_auv {
		public class_p_in_class_auv() {
		}

		public class_p_in_class_auv(class_auv.class_k_in_class_auv var1, int var2, Random var3, int var4, int var5) {
			super(var1, var2);
			this.a(class_cq.class_c_in_class_cq.a.a(var3));
			if (this.e().k() == class_cq.class_a_in_class_cq.c) {
				l = new class_aua(var4, 64, var5, (var4 + 6) - 1, 78, (var5 + 6) - 1);
			} else {
				l = new class_aua(var4, 64, var5, (var4 + 6) - 1, 78, (var5 + 6) - 1);
			}

		}

		@Override
		public void a(class_aur var1, List var2, Random var3) {
			class_auv.e((class_auv.class_k_in_class_auv) var1, var2, var3, l.a - 1, l.e - 4, l.c + 1, class_cq.e, this.d());
			class_auv.e((class_auv.class_k_in_class_auv) var1, var2, var3, l.d + 1, l.e - 4, l.c + 1, class_cq.f, this.d());
			class_auv.e((class_auv.class_k_in_class_auv) var1, var2, var3, l.a + 1, l.e - 4, l.c - 1, class_cq.c, this.d());
			class_auv.e((class_auv.class_k_in_class_auv) var1, var2, var3, l.a + 1, l.e - 4, l.f + 1, class_cq.d, this.d());
		}

		@Override
		public boolean a(class_ago var1, Random var2, class_aua var3) {
			if (h < 0) {
				h = this.b(var1, var3);
				if (h < 0) {
					return true;
				}

				l.a(0, (h - l.e) + 3, 0);
			}

			this.a(var1, var3, 1, 0, 1, 4, 12, 4, Blocks.COBBLESTONE.S(), Blocks.FLOWING_WATER.S(), false);
			this.a(var1, Blocks.AIR.S(), 2, 12, 2, var3);
			this.a(var1, Blocks.AIR.S(), 3, 12, 2, var3);
			this.a(var1, Blocks.AIR.S(), 2, 12, 3, var3);
			this.a(var1, Blocks.AIR.S(), 3, 12, 3, var3);
			this.a(var1, Blocks.FENCE.S(), 1, 13, 1, var3);
			this.a(var1, Blocks.FENCE.S(), 1, 14, 1, var3);
			this.a(var1, Blocks.FENCE.S(), 4, 13, 1, var3);
			this.a(var1, Blocks.FENCE.S(), 4, 14, 1, var3);
			this.a(var1, Blocks.FENCE.S(), 1, 13, 4, var3);
			this.a(var1, Blocks.FENCE.S(), 1, 14, 4, var3);
			this.a(var1, Blocks.FENCE.S(), 4, 13, 4, var3);
			this.a(var1, Blocks.FENCE.S(), 4, 14, 4, var3);
			this.a(var1, var3, 1, 15, 1, 4, 15, 4, Blocks.COBBLESTONE.S(), Blocks.COBBLESTONE.S(), false);

			for (int var4 = 0; var4 <= 5; ++var4) {
				for (int var5 = 0; var5 <= 5; ++var5) {
					if ((var5 == 0) || (var5 == 5) || (var4 == 0) || (var4 == 5)) {
						this.a(var1, Blocks.GRAVEL.S(), var5, 11, var4, var3);
						this.b(var1, var5, 12, var4, var3);
					}
				}
			}

			return true;
		}
	}

	abstract static class class_n_in_class_auv extends class_aur {
		protected int h = -1;
		private int a;
		private boolean b;

		public class_n_in_class_auv() {
		}

		protected class_n_in_class_auv(class_auv.class_k_in_class_auv var1, int var2) {
			super(var2);
			if (var1 != null) {
				b = var1.b;
			}

		}

		@Override
		protected void a(class_dn var1) {
			var1.a("HPos", h);
			var1.a("VCount", a);
			var1.a("Desert", b);
		}

		@Override
		protected void b(class_dn var1) {
			h = var1.h("HPos");
			a = var1.h("VCount");
			b = var1.p("Desert");
		}

		protected class_aur a(class_auv.class_k_in_class_auv var1, List var2, Random var3, int var4, int var5) {
			class_cq var6 = this.e();
			if (var6 != null) {
				switch (class_auv.SyntheticClass_1.a[var6.ordinal()]) {
					case 1:
						return class_auv.d(var1, var2, var3, l.a - 1, l.b + var4, l.c + var5, class_cq.e, this.d());
					case 2:
						return class_auv.d(var1, var2, var3, l.a - 1, l.b + var4, l.c + var5, class_cq.e, this.d());
					case 3:
						return class_auv.d(var1, var2, var3, l.a + var5, l.b + var4, l.c - 1, class_cq.c, this.d());
					case 4:
						return class_auv.d(var1, var2, var3, l.a + var5, l.b + var4, l.c - 1, class_cq.c, this.d());
				}
			}

			return null;
		}

		protected class_aur b(class_auv.class_k_in_class_auv var1, List var2, Random var3, int var4, int var5) {
			class_cq var6 = this.e();
			if (var6 != null) {
				switch (class_auv.SyntheticClass_1.a[var6.ordinal()]) {
					case 1:
						return class_auv.d(var1, var2, var3, l.d + 1, l.b + var4, l.c + var5, class_cq.f, this.d());
					case 2:
						return class_auv.d(var1, var2, var3, l.d + 1, l.b + var4, l.c + var5, class_cq.f, this.d());
					case 3:
						return class_auv.d(var1, var2, var3, l.a + var5, l.b + var4, l.f + 1, class_cq.d, this.d());
					case 4:
						return class_auv.d(var1, var2, var3, l.a + var5, l.b + var4, l.f + 1, class_cq.d, this.d());
				}
			}

			return null;
		}

		protected int b(class_ago var1, class_aua var2) {
			int var3 = 0;
			int var4 = 0;
			class_cj.class_a_in_class_cj var5 = new class_cj.class_a_in_class_cj();

			for (int var6 = l.c; var6 <= l.f; ++var6) {
				for (int var7 = l.a; var7 <= l.d; ++var7) {
					var5.c(var7, 64, var6);
					if (var2.b(var5)) {
						var3 += Math.max(var1.r(var5).o(), var1.t.i());
						++var4;
					}
				}
			}

			if (var4 == 0) {
				return -1;
			} else {
				return var3 / var4;
			}
		}

		protected static boolean a(class_aua var0) {
			return (var0 != null) && (var0.b > 10);
		}

		protected void a(class_ago var1, class_aua var2, int var3, int var4, int var5, int var6) {
			if (a < var6) {
				for (int var7 = a; var7 < var6; ++var7) {
					int var8 = this.a(var3 + var7, var5);
					int var9 = this.d(var4);
					int var10 = this.b(var3 + var7, var5);
					if (!var2.b((new class_cj(var8, var9, var10)))) {
						break;
					}

					++a;
					class_yp var11 = new class_yp(var1);
					var11.b(var8 + 0.5D, var9, var10 + 0.5D, 0.0F, 0.0F);
					var11.a(var1.E(new class_cj(var11)), (class_rj) null);
					var11.k(this.c(var7, var11.cE()));
					var1.a(var11);
				}

			}
		}

		protected int c(int var1, int var2) {
			return var2;
		}

		protected class_apn a(class_apn var1) {
			if (b) {
				if ((var1.c() == Blocks.LOG) || (var1.c() == Blocks.LOG2)) {
					return Blocks.SANDSTONE.S();
				}

				if (var1.c() == Blocks.COBBLESTONE) {
					return Blocks.SANDSTONE.a(class_amt.class_a_in_class_amt.a.a());
				}

				if (var1.c() == Blocks.PLANKS) {
					return Blocks.SANDSTONE.a(class_amt.class_a_in_class_amt.c.a());
				}

				if (var1.c() == Blocks.OAK_STAIRS) {
					return Blocks.SANDSTONE_STAIRS.S().a(class_anf.a, var1.b(class_anf.a));
				}

				if (var1.c() == Blocks.STONE_STAIRS) {
					return Blocks.SANDSTONE_STAIRS.S().a(class_anf.a, var1.b(class_anf.a));
				}

				if (var1.c() == Blocks.GRAVEL) {
					return Blocks.SANDSTONE.S();
				}
			}

			return var1;
		}

		@Override
		protected void a(class_ago var1, class_apn var2, int var3, int var4, int var5, class_aua var6) {
			class_apn var7 = this.a(var2);
			super.a(var1, var7, var3, var4, var5, var6);
		}

		@Override
		protected void a(class_ago var1, class_aua var2, int var3, int var4, int var5, int var6, int var7, int var8, class_apn var9, class_apn var10, boolean var11) {
			class_apn var12 = this.a(var9);
			class_apn var13 = this.a(var10);
			super.a(var1, var2, var3, var4, var5, var6, var7, var8, var12, var13, var11);
		}

		@Override
		protected void b(class_ago var1, class_apn var2, int var3, int var4, int var5, class_aua var6) {
			class_apn var7 = this.a(var2);
			super.b(var1, var7, var3, var4, var5, var6);
		}

		protected void a(boolean var1) {
			b = var1;
		}
	}

	public static class class_e_in_class_auv {
		public Class a;
		public final int b;
		public int c;
		public int d;

		public class_e_in_class_auv(Class var1, int var2, int var3) {
			a = var1;
			b = var2;
			d = var3;
		}

		public boolean a(int var1) {
			return (d == 0) || (c < d);
		}

		public boolean a() {
			return (d == 0) || (c < d);
		}
	}
}
