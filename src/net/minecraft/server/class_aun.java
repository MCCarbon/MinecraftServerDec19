package net.minecraft.server;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;

public class class_aun {
	private static final class_aun.class_f_in_class_aun[] b = new class_aun.class_f_in_class_aun[] { new class_aun.class_f_in_class_aun(class_aun.class_n_in_class_aun.class, 40, 0), new class_aun.class_f_in_class_aun(class_aun.class_h_in_class_aun.class, 5, 5), new class_aun.class_f_in_class_aun(class_aun.class_d_in_class_aun.class, 20, 0), new class_aun.class_f_in_class_aun(class_aun.class_i_in_class_aun.class, 20, 0),
		new class_aun.class_f_in_class_aun(class_aun.class_j_in_class_aun.class, 10, 6), new class_aun.class_f_in_class_aun(class_aun.class_o_in_class_aun.class, 5, 5), new class_aun.class_f_in_class_aun(class_aun.class_l_in_class_aun.class, 5, 5), new class_aun.class_f_in_class_aun(class_aun.class_c_in_class_aun.class, 5, 4), new class_aun.class_f_in_class_aun(class_aun.class_a_in_class_aun.class, 5, 4), new class_aun.class_f_in_class_aun(class_aun.class_e_in_class_aun.class, 10, 2) {
		@Override
		public boolean a(int var1) {
			return super.a(var1) && (var1 > 4);
		}
	}, new class_aun.class_f_in_class_aun(class_aun.class_g_in_class_aun.class, 20, 1) {
		@Override
		public boolean a(int var1) {
			return super.a(var1) && (var1 > 5);
		}
	} };
	private static List c;
	private static Class d;
	static int a;
	private static final class_aun.class_k_in_class_aun e = new class_aun.class_k_in_class_aun(null);

	public static void a() {
		class_aup.a(class_aun.class_a_in_class_aun.class, "SHCC");
		class_aup.a(class_aun.class_b_in_class_aun.class, "SHFC");
		class_aup.a(class_aun.class_c_in_class_aun.class, "SH5C");
		class_aup.a(class_aun.class_d_in_class_aun.class, "SHLT");
		class_aup.a(class_aun.class_e_in_class_aun.class, "SHLi");
		class_aup.a(class_aun.class_g_in_class_aun.class, "SHPR");
		class_aup.a(class_aun.class_h_in_class_aun.class, "SHPH");
		class_aup.a(class_aun.class_i_in_class_aun.class, "SHRT");
		class_aup.a(class_aun.class_j_in_class_aun.class, "SHRC");
		class_aup.a(class_aun.class_l_in_class_aun.class, "SHSD");
		class_aup.a(class_aun.class_m_in_class_aun.class, "SHStart");
		class_aup.a(class_aun.class_n_in_class_aun.class, "SHS");
		class_aup.a(class_aun.class_o_in_class_aun.class, "SHSSD");
	}

	public static void b() {
		c = Lists.newArrayList();
		class_aun.class_f_in_class_aun[] var0 = b;
		int var1 = var0.length;

		for (int var2 = 0; var2 < var1; ++var2) {
			class_aun.class_f_in_class_aun var3 = var0[var2];
			var3.c = 0;
			c.add(var3);
		}

		d = null;
	}

	private static boolean d() {
		boolean var0 = false;
		a = 0;

		class_aun.class_f_in_class_aun var2;
		for (Iterator var1 = c.iterator(); var1.hasNext(); a += var2.b) {
			var2 = (class_aun.class_f_in_class_aun) var1.next();
			if ((var2.d > 0) && (var2.c < var2.d)) {
				var0 = true;
			}
		}

		return var0;
	}

	private static class_aun.class_p_in_class_aun a(Class var0, List var1, Random var2, int var3, int var4, int var5, class_cq var6, int var7) {
		Object var8 = null;
		if (var0 == class_aun.class_n_in_class_aun.class) {
			var8 = class_aun.class_n_in_class_aun.a(var1, var2, var3, var4, var5, var6, var7);
		} else if (var0 == class_aun.class_h_in_class_aun.class) {
			var8 = class_aun.class_h_in_class_aun.a(var1, var2, var3, var4, var5, var6, var7);
		} else if (var0 == class_aun.class_d_in_class_aun.class) {
			var8 = class_aun.class_d_in_class_aun.a(var1, var2, var3, var4, var5, var6, var7);
		} else if (var0 == class_aun.class_i_in_class_aun.class) {
			var8 = class_d_in_class_aun.a(var1, var2, var3, var4, var5, var6, var7);
		} else if (var0 == class_aun.class_j_in_class_aun.class) {
			var8 = class_aun.class_j_in_class_aun.a(var1, var2, var3, var4, var5, var6, var7);
		} else if (var0 == class_aun.class_o_in_class_aun.class) {
			var8 = class_aun.class_o_in_class_aun.a(var1, var2, var3, var4, var5, var6, var7);
		} else if (var0 == class_aun.class_l_in_class_aun.class) {
			var8 = class_aun.class_l_in_class_aun.a(var1, var2, var3, var4, var5, var6, var7);
		} else if (var0 == class_aun.class_c_in_class_aun.class) {
			var8 = class_aun.class_c_in_class_aun.a(var1, var2, var3, var4, var5, var6, var7);
		} else if (var0 == class_aun.class_a_in_class_aun.class) {
			var8 = class_aun.class_a_in_class_aun.a(var1, var2, var3, var4, var5, var6, var7);
		} else if (var0 == class_aun.class_e_in_class_aun.class) {
			var8 = class_aun.class_e_in_class_aun.a(var1, var2, var3, var4, var5, var6, var7);
		} else if (var0 == class_aun.class_g_in_class_aun.class) {
			var8 = class_aun.class_g_in_class_aun.a(var1, var2, var3, var4, var5, var6, var7);
		}

		return (class_aun.class_p_in_class_aun) var8;
	}

	private static class_aun.class_p_in_class_aun b(class_aun.class_m_in_class_aun var0, List var1, Random var2, int var3, int var4, int var5, class_cq var6, int var7) {
		if (!d()) {
			return null;
		} else {
			if (d != null) {
				class_aun.class_p_in_class_aun var8 = a(d, var1, var2, var3, var4, var5, var6, var7);
				d = null;
				if (var8 != null) {
					return var8;
				}
			}

			int var13 = 0;

			while (var13 < 5) {
				++var13;
				int var9 = var2.nextInt(a);
				Iterator var10 = c.iterator();

				while (var10.hasNext()) {
					class_aun.class_f_in_class_aun var11 = (class_aun.class_f_in_class_aun) var10.next();
					var9 -= var11.b;
					if (var9 < 0) {
						if (!var11.a(var7) || (var11 == var0.a)) {
							break;
						}

						class_aun.class_p_in_class_aun var12 = a(var11.a, var1, var2, var3, var4, var5, var6, var7);
						if (var12 != null) {
							++var11.c;
							var0.a = var11;
							if (!var11.a()) {
								c.remove(var11);
							}

							return var12;
						}
					}
				}
			}

			class_aua var14 = class_aun.class_b_in_class_aun.a(var1, var2, var3, var4, var5, var6);
			if ((var14 != null) && (var14.b > 1)) {
				return new class_aun.class_b_in_class_aun(var7, var2, var14, var6);
			} else {
				return null;
			}
		}
	}

	private static class_aur c(class_aun.class_m_in_class_aun var0, List var1, Random var2, int var3, int var4, int var5, class_cq var6, int var7) {
		if (var7 > 50) {
			return null;
		} else if ((Math.abs(var3 - var0.c().a) <= 112) && (Math.abs(var5 - var0.c().c) <= 112)) {
			class_aun.class_p_in_class_aun var8 = b(var0, var1, var2, var3, var4, var5, var6, var7 + 1);
			if (var8 != null) {
				var1.add(var8);
				var0.c.add(var8);
			}

			return var8;
		} else {
			return null;
		}
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a;
		// $FF: synthetic field
		static final int[] b = new int[class_cq.values().length];

		static {
			try {
				b[class_cq.c.ordinal()] = 1;
			} catch (NoSuchFieldError var8) {
				;
			}

			try {
				b[class_cq.d.ordinal()] = 2;
			} catch (NoSuchFieldError var7) {
				;
			}

			try {
				b[class_cq.e.ordinal()] = 3;
			} catch (NoSuchFieldError var6) {
				;
			}

			try {
				b[class_cq.f.ordinal()] = 4;
			} catch (NoSuchFieldError var5) {
				;
			}

			a = new int[class_aun.class_p_in_class_aun.class_p_in_class_aun$class_a_in_class_p_in_class_aun.values().length];

			try {
				a[class_aun.class_p_in_class_aun.class_p_in_class_aun$class_a_in_class_p_in_class_aun.a.ordinal()] = 1;
			} catch (NoSuchFieldError var4) {
				;
			}

			try {
				a[class_aun.class_p_in_class_aun.class_p_in_class_aun$class_a_in_class_p_in_class_aun.b.ordinal()] = 2;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				a[class_aun.class_p_in_class_aun.class_p_in_class_aun$class_a_in_class_p_in_class_aun.c.ordinal()] = 3;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[class_aun.class_p_in_class_aun.class_p_in_class_aun$class_a_in_class_p_in_class_aun.d.ordinal()] = 4;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}

	static class class_k_in_class_aun extends class_aur.class_a_in_class_aur {
		private class_k_in_class_aun() {
		}

		@Override
		public void a(Random var1, int var2, int var3, int var4, boolean var5) {
			if (var5) {
				float var6 = var1.nextFloat();
				if (var6 < 0.2F) {
					a = Blocks.STONE_BRICK.a(class_ank.O);
				} else if (var6 < 0.5F) {
					a = Blocks.STONE_BRICK.a(class_ank.N);
				} else if (var6 < 0.55F) {
					a = Blocks.MONSTER_EGG.a(class_alj.class_a_in_class_alj.c.a());
				} else {
					a = Blocks.STONE_BRICK.S();
				}
			} else {
				a = Blocks.AIR.S();
			}

		}

		// $FF: synthetic method
		class_k_in_class_aun(Object var1) {
			this();
		}
	}

	public static class class_g_in_class_aun extends class_aun.class_p_in_class_aun {
		private boolean a;

		public class_g_in_class_aun() {
		}

		public class_g_in_class_aun(int var1, Random var2, class_aua var3, class_cq var4) {
			super(var1);
			this.a(var4);
			l = var3;
		}

		@Override
		protected void a(class_dn var1) {
			super.a(var1);
			var1.a("Mob", a);
		}

		@Override
		protected void b(class_dn var1) {
			super.b(var1);
			a = var1.p("Mob");
		}

		@Override
		public void a(class_aur var1, List var2, Random var3) {
			if (var1 != null) {
				((class_aun.class_m_in_class_aun) var1).b = this;
			}

		}

		public static class_aun.class_g_in_class_aun a(List var0, Random var1, int var2, int var3, int var4, class_cq var5, int var6) {
			class_aua var7 = class_aua.a(var2, var3, var4, -4, -1, 0, 11, 8, 16, var5);
			return a(var7) && (class_aur.a(var0, var7) == null) ? new class_aun.class_g_in_class_aun(var6, var1, var7, var5) : null;
		}

		@Override
		public boolean a(class_ago var1, Random var2, class_aua var3) {
			this.a(var1, var3, 0, 0, 0, 10, 7, 15, false, var2, class_aun.e);
			this.a(var1, var2, var3, class_aun.class_p_in_class_aun.class_p_in_class_aun$class_a_in_class_p_in_class_aun.c, 4, 1, 0);
			byte var4 = 6;
			this.a(var1, var3, 1, var4, 1, 1, var4, 14, false, var2, class_aun.e);
			this.a(var1, var3, 9, var4, 1, 9, var4, 14, false, var2, class_aun.e);
			this.a(var1, var3, 2, var4, 1, 8, var4, 2, false, var2, class_aun.e);
			this.a(var1, var3, 2, var4, 14, 8, var4, 14, false, var2, class_aun.e);
			this.a(var1, var3, 1, 1, 1, 2, 1, 4, false, var2, class_aun.e);
			this.a(var1, var3, 8, 1, 1, 9, 1, 4, false, var2, class_aun.e);
			this.a(var1, var3, 1, 1, 1, 1, 1, 3, Blocks.FLOWING_LAVA.S(), Blocks.FLOWING_LAVA.S(), false);
			this.a(var1, var3, 9, 1, 1, 9, 1, 3, Blocks.FLOWING_LAVA.S(), Blocks.FLOWING_LAVA.S(), false);
			this.a(var1, var3, 3, 1, 8, 7, 1, 12, false, var2, class_aun.e);
			this.a(var1, var3, 4, 1, 9, 6, 1, 11, Blocks.FLOWING_LAVA.S(), Blocks.FLOWING_LAVA.S(), false);

			int var5;
			for (var5 = 3; var5 < 14; var5 += 2) {
				this.a(var1, var3, 0, 3, var5, 0, 4, var5, Blocks.IRON_BARS.S(), Blocks.IRON_BARS.S(), false);
				this.a(var1, var3, 10, 3, var5, 10, 4, var5, Blocks.IRON_BARS.S(), Blocks.IRON_BARS.S(), false);
			}

			for (var5 = 2; var5 < 9; var5 += 2) {
				this.a(var1, var3, var5, 3, 15, var5, 4, 15, Blocks.IRON_BARS.S(), Blocks.IRON_BARS.S(), false);
			}

			class_apn var13 = Blocks.STONE_BRICK_STAIRS.S().a(class_anf.a, class_cq.c);
			this.a(var1, var3, 4, 1, 5, 6, 1, 7, false, var2, class_aun.e);
			this.a(var1, var3, 4, 2, 6, 6, 2, 7, false, var2, class_aun.e);
			this.a(var1, var3, 4, 3, 7, 6, 3, 7, false, var2, class_aun.e);

			for (int var6 = 4; var6 <= 6; ++var6) {
				this.a(var1, var13, var6, 1, 4, var3);
				this.a(var1, var13, var6, 2, 5, var3);
				this.a(var1, var13, var6, 3, 6, var3);
			}

			class_apn var14 = Blocks.END_PORTAL_FRAME.S().a(class_ajv.a, class_cq.c);
			class_apn var7 = Blocks.END_PORTAL_FRAME.S().a(class_ajv.a, class_cq.d);
			class_apn var8 = Blocks.END_PORTAL_FRAME.S().a(class_ajv.a, class_cq.f);
			class_apn var9 = Blocks.END_PORTAL_FRAME.S().a(class_ajv.a, class_cq.e);
			this.a(var1, var14.a(class_ajv.b, Boolean.valueOf(var2.nextFloat() > 0.9F)), 4, 3, 8, var3);
			this.a(var1, var14.a(class_ajv.b, Boolean.valueOf(var2.nextFloat() > 0.9F)), 5, 3, 8, var3);
			this.a(var1, var14.a(class_ajv.b, Boolean.valueOf(var2.nextFloat() > 0.9F)), 6, 3, 8, var3);
			this.a(var1, var7.a(class_ajv.b, Boolean.valueOf(var2.nextFloat() > 0.9F)), 4, 3, 12, var3);
			this.a(var1, var7.a(class_ajv.b, Boolean.valueOf(var2.nextFloat() > 0.9F)), 5, 3, 12, var3);
			this.a(var1, var7.a(class_ajv.b, Boolean.valueOf(var2.nextFloat() > 0.9F)), 6, 3, 12, var3);
			this.a(var1, var8.a(class_ajv.b, Boolean.valueOf(var2.nextFloat() > 0.9F)), 3, 3, 9, var3);
			this.a(var1, var8.a(class_ajv.b, Boolean.valueOf(var2.nextFloat() > 0.9F)), 3, 3, 10, var3);
			this.a(var1, var8.a(class_ajv.b, Boolean.valueOf(var2.nextFloat() > 0.9F)), 3, 3, 11, var3);
			this.a(var1, var9.a(class_ajv.b, Boolean.valueOf(var2.nextFloat() > 0.9F)), 7, 3, 9, var3);
			this.a(var1, var9.a(class_ajv.b, Boolean.valueOf(var2.nextFloat() > 0.9F)), 7, 3, 10, var3);
			this.a(var1, var9.a(class_ajv.b, Boolean.valueOf(var2.nextFloat() > 0.9F)), 7, 3, 11, var3);
			if (!a) {
				int var12 = this.d(3);
				class_cj var10 = new class_cj(this.a(5, 6), var12, this.b(5, 6));
				if (var3.b(var10)) {
					a = true;
					var1.a(var10, Blocks.MOB_SPAWNER.S(), 2);
					TileEntity var11 = var1.s(var10);
					if (var11 instanceof class_aox) {
						((class_aox) var11).b().a("Silverfish");
					}
				}
			}

			return true;
		}
	}

	public static class class_c_in_class_aun extends class_aun.class_p_in_class_aun {
		private boolean a;
		private boolean b;
		private boolean c;
		private boolean e;

		public class_c_in_class_aun() {
		}

		public class_c_in_class_aun(int var1, Random var2, class_aua var3, class_cq var4) {
			super(var1);
			this.a(var4);
			d = this.a(var2);
			l = var3;
			a = var2.nextBoolean();
			b = var2.nextBoolean();
			c = var2.nextBoolean();
			e = var2.nextInt(3) > 0;
		}

		@Override
		protected void a(class_dn var1) {
			super.a(var1);
			var1.a("leftLow", a);
			var1.a("leftHigh", b);
			var1.a("rightLow", c);
			var1.a("rightHigh", e);
		}

		@Override
		protected void b(class_dn var1) {
			super.b(var1);
			a = var1.p("leftLow");
			b = var1.p("leftHigh");
			c = var1.p("rightLow");
			e = var1.p("rightHigh");
		}

		@Override
		public void a(class_aur var1, List var2, Random var3) {
			int var4 = 3;
			int var5 = 5;
			class_cq var6 = e();
			if ((var6 == class_cq.e) || (var6 == class_cq.c)) {
				var4 = 8 - var4;
				var5 = 8 - var5;
			}

			this.a((class_aun.class_m_in_class_aun) var1, var2, var3, 5, 1);
			if (a) {
				this.b((class_aun.class_m_in_class_aun) var1, var2, var3, var4, 1);
			}

			if (b) {
				this.b((class_aun.class_m_in_class_aun) var1, var2, var3, var5, 7);
			}

			if (c) {
				this.c((class_aun.class_m_in_class_aun) var1, var2, var3, var4, 1);
			}

			if (e) {
				this.c((class_aun.class_m_in_class_aun) var1, var2, var3, var5, 7);
			}

		}

		public static class_aun.class_c_in_class_aun a(List var0, Random var1, int var2, int var3, int var4, class_cq var5, int var6) {
			class_aua var7 = class_aua.a(var2, var3, var4, -4, -3, 0, 10, 9, 11, var5);
			return a(var7) && (class_aur.a(var0, var7) == null) ? new class_aun.class_c_in_class_aun(var6, var1, var7, var5) : null;
		}

		@Override
		public boolean a(class_ago var1, Random var2, class_aua var3) {
			if (this.a(var1, var3)) {
				return false;
			} else {
				this.a(var1, var3, 0, 0, 0, 9, 8, 10, true, var2, class_aun.e);
				this.a(var1, var2, var3, d, 4, 3, 0);
				if (a) {
					this.a(var1, var3, 0, 3, 1, 0, 5, 3, Blocks.AIR.S(), Blocks.AIR.S(), false);
				}

				if (c) {
					this.a(var1, var3, 9, 3, 1, 9, 5, 3, Blocks.AIR.S(), Blocks.AIR.S(), false);
				}

				if (b) {
					this.a(var1, var3, 0, 5, 7, 0, 7, 9, Blocks.AIR.S(), Blocks.AIR.S(), false);
				}

				if (e) {
					this.a(var1, var3, 9, 5, 7, 9, 7, 9, Blocks.AIR.S(), Blocks.AIR.S(), false);
				}

				this.a(var1, var3, 5, 1, 10, 7, 3, 10, Blocks.AIR.S(), Blocks.AIR.S(), false);
				this.a(var1, var3, 1, 2, 1, 8, 2, 6, false, var2, class_aun.e);
				this.a(var1, var3, 4, 1, 5, 4, 4, 9, false, var2, class_aun.e);
				this.a(var1, var3, 8, 1, 5, 8, 4, 9, false, var2, class_aun.e);
				this.a(var1, var3, 1, 4, 7, 3, 4, 9, false, var2, class_aun.e);
				this.a(var1, var3, 1, 3, 5, 3, 3, 6, false, var2, class_aun.e);
				this.a(var1, var3, 1, 3, 4, 3, 3, 4, Blocks.STONE_SLAB.S(), Blocks.STONE_SLAB.S(), false);
				this.a(var1, var3, 1, 4, 6, 3, 4, 6, Blocks.STONE_SLAB.S(), Blocks.STONE_SLAB.S(), false);
				this.a(var1, var3, 5, 1, 7, 7, 1, 8, false, var2, class_aun.e);
				this.a(var1, var3, 5, 1, 9, 7, 1, 9, Blocks.STONE_SLAB.S(), Blocks.STONE_SLAB.S(), false);
				this.a(var1, var3, 5, 2, 7, 7, 2, 7, Blocks.STONE_SLAB.S(), Blocks.STONE_SLAB.S(), false);
				this.a(var1, var3, 4, 5, 7, 4, 5, 9, Blocks.STONE_SLAB.S(), Blocks.STONE_SLAB.S(), false);
				this.a(var1, var3, 8, 5, 7, 8, 5, 9, Blocks.STONE_SLAB.S(), Blocks.STONE_SLAB.S(), false);
				this.a(var1, var3, 5, 5, 7, 7, 5, 9, Blocks.DOUBLE_SANDSTONE_SLAB.S(), Blocks.DOUBLE_SANDSTONE_SLAB.S(), false);
				this.a(var1, Blocks.TORCH.S().a(class_anr.a, class_cq.d), 6, 5, 6, var3);
				return true;
			}
		}
	}

	public static class class_e_in_class_aun extends class_aun.class_p_in_class_aun {
		private static final List a;
		private boolean b;

		public class_e_in_class_aun() {
		}

		public class_e_in_class_aun(int var1, Random var2, class_aua var3, class_cq var4) {
			super(var1);
			this.a(var4);
			d = this.a(var2);
			l = var3;
			b = var3.d() > 6;
		}

		@Override
		protected void a(class_dn var1) {
			super.a(var1);
			var1.a("Tall", b);
		}

		@Override
		protected void b(class_dn var1) {
			super.b(var1);
			b = var1.p("Tall");
		}

		public static class_aun.class_e_in_class_aun a(List var0, Random var1, int var2, int var3, int var4, class_cq var5, int var6) {
			class_aua var7 = class_aua.a(var2, var3, var4, -4, -1, 0, 14, 11, 15, var5);
			if (!a(var7) || (class_aur.a(var0, var7) != null)) {
				var7 = class_aua.a(var2, var3, var4, -4, -1, 0, 14, 6, 15, var5);
				if (!a(var7) || (class_aur.a(var0, var7) != null)) {
					return null;
				}
			}

			return new class_aun.class_e_in_class_aun(var6, var1, var7, var5);
		}

		@Override
		public boolean a(class_ago var1, Random var2, class_aua var3) {
			if (this.a(var1, var3)) {
				return false;
			} else {
				byte var4 = 11;
				if (!b) {
					var4 = 6;
				}

				this.a(var1, var3, 0, 0, 0, 13, var4 - 1, 14, true, var2, class_aun.e);
				this.a(var1, var2, var3, d, 4, 1, 0);
				this.a(var1, var3, var2, 0.07F, 2, 1, 1, 11, 4, 13, Blocks.WEB.S(), Blocks.WEB.S(), false);
				boolean var5 = true;
				boolean var6 = true;

				int var7;
				for (var7 = 1; var7 <= 13; ++var7) {
					if (((var7 - 1) % 4) == 0) {
						this.a(var1, var3, 1, 1, var7, 1, 4, var7, Blocks.PLANKS.S(), Blocks.PLANKS.S(), false);
						this.a(var1, var3, 12, 1, var7, 12, 4, var7, Blocks.PLANKS.S(), Blocks.PLANKS.S(), false);
						this.a(var1, Blocks.TORCH.S().a(class_anr.a, class_cq.f), 2, 3, var7, var3);
						this.a(var1, Blocks.TORCH.S().a(class_anr.a, class_cq.e), 11, 3, var7, var3);
						if (b) {
							this.a(var1, var3, 1, 6, var7, 1, 9, var7, Blocks.PLANKS.S(), Blocks.PLANKS.S(), false);
							this.a(var1, var3, 12, 6, var7, 12, 9, var7, Blocks.PLANKS.S(), Blocks.PLANKS.S(), false);
						}
					} else {
						this.a(var1, var3, 1, 1, var7, 1, 4, var7, Blocks.BOOKSHELF.S(), Blocks.BOOKSHELF.S(), false);
						this.a(var1, var3, 12, 1, var7, 12, 4, var7, Blocks.BOOKSHELF.S(), Blocks.BOOKSHELF.S(), false);
						if (b) {
							this.a(var1, var3, 1, 6, var7, 1, 9, var7, Blocks.BOOKSHELF.S(), Blocks.BOOKSHELF.S(), false);
							this.a(var1, var3, 12, 6, var7, 12, 9, var7, Blocks.BOOKSHELF.S(), Blocks.BOOKSHELF.S(), false);
						}
					}
				}

				for (var7 = 3; var7 < 12; var7 += 2) {
					this.a(var1, var3, 3, 1, var7, 4, 3, var7, Blocks.BOOKSHELF.S(), Blocks.BOOKSHELF.S(), false);
					this.a(var1, var3, 6, 1, var7, 7, 3, var7, Blocks.BOOKSHELF.S(), Blocks.BOOKSHELF.S(), false);
					this.a(var1, var3, 9, 1, var7, 10, 3, var7, Blocks.BOOKSHELF.S(), Blocks.BOOKSHELF.S(), false);
				}

				if (b) {
					this.a(var1, var3, 1, 5, 1, 3, 5, 13, Blocks.PLANKS.S(), Blocks.PLANKS.S(), false);
					this.a(var1, var3, 10, 5, 1, 12, 5, 13, Blocks.PLANKS.S(), Blocks.PLANKS.S(), false);
					this.a(var1, var3, 4, 5, 1, 9, 5, 2, Blocks.PLANKS.S(), Blocks.PLANKS.S(), false);
					this.a(var1, var3, 4, 5, 12, 9, 5, 13, Blocks.PLANKS.S(), Blocks.PLANKS.S(), false);
					this.a(var1, Blocks.PLANKS.S(), 9, 5, 11, var3);
					this.a(var1, Blocks.PLANKS.S(), 8, 5, 11, var3);
					this.a(var1, Blocks.PLANKS.S(), 9, 5, 10, var3);
					this.a(var1, var3, 3, 6, 2, 3, 6, 12, Blocks.FENCE.S(), Blocks.FENCE.S(), false);
					this.a(var1, var3, 10, 6, 2, 10, 6, 10, Blocks.FENCE.S(), Blocks.FENCE.S(), false);
					this.a(var1, var3, 4, 6, 2, 9, 6, 2, Blocks.FENCE.S(), Blocks.FENCE.S(), false);
					this.a(var1, var3, 4, 6, 12, 8, 6, 12, Blocks.FENCE.S(), Blocks.FENCE.S(), false);
					this.a(var1, Blocks.FENCE.S(), 9, 6, 11, var3);
					this.a(var1, Blocks.FENCE.S(), 8, 6, 11, var3);
					this.a(var1, Blocks.FENCE.S(), 9, 6, 10, var3);
					class_apn var11 = Blocks.LADDER.S().a(class_alb.a, class_cq.d);
					this.a(var1, var11, 10, 1, 13, var3);
					this.a(var1, var11, 10, 2, 13, var3);
					this.a(var1, var11, 10, 3, 13, var3);
					this.a(var1, var11, 10, 4, 13, var3);
					this.a(var1, var11, 10, 5, 13, var3);
					this.a(var1, var11, 10, 6, 13, var3);
					this.a(var1, var11, 10, 7, 13, var3);
					byte var8 = 7;
					byte var9 = 7;
					this.a(var1, Blocks.FENCE.S(), var8 - 1, 9, var9, var3);
					this.a(var1, Blocks.FENCE.S(), var8, 9, var9, var3);
					this.a(var1, Blocks.FENCE.S(), var8 - 1, 8, var9, var3);
					this.a(var1, Blocks.FENCE.S(), var8, 8, var9, var3);
					this.a(var1, Blocks.FENCE.S(), var8 - 1, 7, var9, var3);
					this.a(var1, Blocks.FENCE.S(), var8, 7, var9, var3);
					this.a(var1, Blocks.FENCE.S(), var8 - 2, 7, var9, var3);
					this.a(var1, Blocks.FENCE.S(), var8 + 1, 7, var9, var3);
					this.a(var1, Blocks.FENCE.S(), var8 - 1, 7, var9 - 1, var3);
					this.a(var1, Blocks.FENCE.S(), var8 - 1, 7, var9 + 1, var3);
					this.a(var1, Blocks.FENCE.S(), var8, 7, var9 - 1, var3);
					this.a(var1, Blocks.FENCE.S(), var8, 7, var9 + 1, var3);
					class_apn var10 = Blocks.TORCH.S().a(class_anr.a, class_cq.b);
					this.a(var1, var10, var8 - 2, 8, var9, var3);
					this.a(var1, var10, var8 + 1, 8, var9, var3);
					this.a(var1, var10, var8 - 1, 8, var9 - 1, var3);
					this.a(var1, var10, var8 - 1, 8, var9 + 1, var3);
					this.a(var1, var10, var8, 8, var9 - 1, var3);
					this.a(var1, var10, var8, 8, var9 + 1, var3);
				}

				this.a(var1, var3, var2, 3, 3, 5, class_oj.a(a, new class_oj[] { Items.ci.a(var2, 1, 5, 2) }), 1 + var2.nextInt(4));
				if (b) {
					this.a(var1, Blocks.AIR.S(), 12, 9, 1, var3);
					this.a(var1, var3, var2, 12, 8, 1, class_oj.a(a, new class_oj[] { Items.ci.a(var2, 1, 5, 2) }), 1 + var2.nextInt(4));
				}

				return true;
			}
		}

		static {
			a = Lists.newArrayList((Object[]) (new class_oj[] { new class_oj(Items.aN, 0, 1, 3, 20), new class_oj(Items.aM, 0, 2, 7, 20), new class_oj(Items.ca, 0, 1, 1, 1), new class_oj(Items.aS, 0, 1, 1, 1) }));
		}
	}

	public static class class_h_in_class_aun extends class_aun.class_p_in_class_aun {
		public class_h_in_class_aun() {
		}

		public class_h_in_class_aun(int var1, Random var2, class_aua var3, class_cq var4) {
			super(var1);
			this.a(var4);
			d = this.a(var2);
			l = var3;
		}

		@Override
		public void a(class_aur var1, List var2, Random var3) {
			this.a((class_aun.class_m_in_class_aun) var1, var2, var3, 1, 1);
		}

		public static class_aun.class_h_in_class_aun a(List var0, Random var1, int var2, int var3, int var4, class_cq var5, int var6) {
			class_aua var7 = class_aua.a(var2, var3, var4, -1, -1, 0, 9, 5, 11, var5);
			return a(var7) && (class_aur.a(var0, var7) == null) ? new class_aun.class_h_in_class_aun(var6, var1, var7, var5) : null;
		}

		@Override
		public boolean a(class_ago var1, Random var2, class_aua var3) {
			if (this.a(var1, var3)) {
				return false;
			} else {
				this.a(var1, var3, 0, 0, 0, 8, 4, 10, true, var2, class_aun.e);
				this.a(var1, var2, var3, d, 1, 1, 0);
				this.a(var1, var3, 1, 1, 10, 3, 3, 10, Blocks.AIR.S(), Blocks.AIR.S(), false);
				this.a(var1, var3, 4, 1, 1, 4, 3, 1, false, var2, class_aun.e);
				this.a(var1, var3, 4, 1, 3, 4, 3, 3, false, var2, class_aun.e);
				this.a(var1, var3, 4, 1, 7, 4, 3, 7, false, var2, class_aun.e);
				this.a(var1, var3, 4, 1, 9, 4, 3, 9, false, var2, class_aun.e);
				this.a(var1, var3, 4, 1, 4, 4, 3, 6, Blocks.IRON_BARS.S(), Blocks.IRON_BARS.S(), false);
				this.a(var1, var3, 5, 1, 5, 7, 3, 5, Blocks.IRON_BARS.S(), Blocks.IRON_BARS.S(), false);
				this.a(var1, Blocks.IRON_BARS.S(), 4, 3, 2, var3);
				this.a(var1, Blocks.IRON_BARS.S(), 4, 3, 8, var3);
				class_apn var4 = Blocks.IRON_DOOR.S().a(class_ajn.a, class_cq.e);
				class_apn var5 = Blocks.IRON_DOOR.S().a(class_ajn.a, class_cq.e).a(class_ajn.P, class_ajn.class_a_in_class_ajn.a);
				this.a(var1, var4, 4, 1, 2, var3);
				this.a(var1, var5, 4, 2, 2, var3);
				this.a(var1, var4, 4, 1, 8, var3);
				this.a(var1, var5, 4, 2, 8, var3);
				return true;
			}
		}
	}

	public static class class_j_in_class_aun extends class_aun.class_p_in_class_aun {
		private static final List b;
		protected int a;

		public class_j_in_class_aun() {
		}

		public class_j_in_class_aun(int var1, Random var2, class_aua var3, class_cq var4) {
			super(var1);
			this.a(var4);
			d = this.a(var2);
			l = var3;
			a = var2.nextInt(5);
		}

		@Override
		protected void a(class_dn var1) {
			super.a(var1);
			var1.a("Type", a);
		}

		@Override
		protected void b(class_dn var1) {
			super.b(var1);
			a = var1.h("Type");
		}

		@Override
		public void a(class_aur var1, List var2, Random var3) {
			this.a((class_aun.class_m_in_class_aun) var1, var2, var3, 4, 1);
			this.b((class_aun.class_m_in_class_aun) var1, var2, var3, 1, 4);
			this.c((class_aun.class_m_in_class_aun) var1, var2, var3, 1, 4);
		}

		public static class_aun.class_j_in_class_aun a(List var0, Random var1, int var2, int var3, int var4, class_cq var5, int var6) {
			class_aua var7 = class_aua.a(var2, var3, var4, -4, -1, 0, 11, 7, 11, var5);
			return a(var7) && (class_aur.a(var0, var7) == null) ? new class_aun.class_j_in_class_aun(var6, var1, var7, var5) : null;
		}

		@Override
		public boolean a(class_ago var1, Random var2, class_aua var3) {
			if (this.a(var1, var3)) {
				return false;
			} else {
				this.a(var1, var3, 0, 0, 0, 10, 6, 10, true, var2, class_aun.e);
				this.a(var1, var2, var3, d, 4, 1, 0);
				this.a(var1, var3, 4, 1, 10, 6, 3, 10, Blocks.AIR.S(), Blocks.AIR.S(), false);
				this.a(var1, var3, 0, 1, 4, 0, 3, 6, Blocks.AIR.S(), Blocks.AIR.S(), false);
				this.a(var1, var3, 10, 1, 4, 10, 3, 6, Blocks.AIR.S(), Blocks.AIR.S(), false);
				int var4;
				switch (a) {
					case 0:
						this.a(var1, Blocks.STONE_BRICK.S(), 5, 1, 5, var3);
						this.a(var1, Blocks.STONE_BRICK.S(), 5, 2, 5, var3);
						this.a(var1, Blocks.STONE_BRICK.S(), 5, 3, 5, var3);
						this.a(var1, Blocks.TORCH.S().a(class_anr.a, class_cq.e), 4, 3, 5, var3);
						this.a(var1, Blocks.TORCH.S().a(class_anr.a, class_cq.f), 6, 3, 5, var3);
						this.a(var1, Blocks.TORCH.S().a(class_anr.a, class_cq.d), 5, 3, 4, var3);
						this.a(var1, Blocks.TORCH.S().a(class_anr.a, class_cq.c), 5, 3, 6, var3);
						this.a(var1, Blocks.STONE_SLAB.S(), 4, 1, 4, var3);
						this.a(var1, Blocks.STONE_SLAB.S(), 4, 1, 5, var3);
						this.a(var1, Blocks.STONE_SLAB.S(), 4, 1, 6, var3);
						this.a(var1, Blocks.STONE_SLAB.S(), 6, 1, 4, var3);
						this.a(var1, Blocks.STONE_SLAB.S(), 6, 1, 5, var3);
						this.a(var1, Blocks.STONE_SLAB.S(), 6, 1, 6, var3);
						this.a(var1, Blocks.STONE_SLAB.S(), 5, 1, 4, var3);
						this.a(var1, Blocks.STONE_SLAB.S(), 5, 1, 6, var3);
						break;
					case 1:
						for (var4 = 0; var4 < 5; ++var4) {
							this.a(var1, Blocks.STONE_BRICK.S(), 3, 1, 3 + var4, var3);
							this.a(var1, Blocks.STONE_BRICK.S(), 7, 1, 3 + var4, var3);
							this.a(var1, Blocks.STONE_BRICK.S(), 3 + var4, 1, 3, var3);
							this.a(var1, Blocks.STONE_BRICK.S(), 3 + var4, 1, 7, var3);
						}

						this.a(var1, Blocks.STONE_BRICK.S(), 5, 1, 5, var3);
						this.a(var1, Blocks.STONE_BRICK.S(), 5, 2, 5, var3);
						this.a(var1, Blocks.STONE_BRICK.S(), 5, 3, 5, var3);
						this.a(var1, Blocks.FLOWING_WATER.S(), 5, 4, 5, var3);
						break;
					case 2:
						for (var4 = 1; var4 <= 9; ++var4) {
							this.a(var1, Blocks.COBBLESTONE.S(), 1, 3, var4, var3);
							this.a(var1, Blocks.COBBLESTONE.S(), 9, 3, var4, var3);
						}

						for (var4 = 1; var4 <= 9; ++var4) {
							this.a(var1, Blocks.COBBLESTONE.S(), var4, 3, 1, var3);
							this.a(var1, Blocks.COBBLESTONE.S(), var4, 3, 9, var3);
						}

						this.a(var1, Blocks.COBBLESTONE.S(), 5, 1, 4, var3);
						this.a(var1, Blocks.COBBLESTONE.S(), 5, 1, 6, var3);
						this.a(var1, Blocks.COBBLESTONE.S(), 5, 3, 4, var3);
						this.a(var1, Blocks.COBBLESTONE.S(), 5, 3, 6, var3);
						this.a(var1, Blocks.COBBLESTONE.S(), 4, 1, 5, var3);
						this.a(var1, Blocks.COBBLESTONE.S(), 6, 1, 5, var3);
						this.a(var1, Blocks.COBBLESTONE.S(), 4, 3, 5, var3);
						this.a(var1, Blocks.COBBLESTONE.S(), 6, 3, 5, var3);

						for (var4 = 1; var4 <= 3; ++var4) {
							this.a(var1, Blocks.COBBLESTONE.S(), 4, var4, 4, var3);
							this.a(var1, Blocks.COBBLESTONE.S(), 6, var4, 4, var3);
							this.a(var1, Blocks.COBBLESTONE.S(), 4, var4, 6, var3);
							this.a(var1, Blocks.COBBLESTONE.S(), 6, var4, 6, var3);
						}

						this.a(var1, Blocks.TORCH.S(), 5, 3, 5, var3);

						for (var4 = 2; var4 <= 8; ++var4) {
							this.a(var1, Blocks.PLANKS.S(), 2, 3, var4, var3);
							this.a(var1, Blocks.PLANKS.S(), 3, 3, var4, var3);
							if ((var4 <= 3) || (var4 >= 7)) {
								this.a(var1, Blocks.PLANKS.S(), 4, 3, var4, var3);
								this.a(var1, Blocks.PLANKS.S(), 5, 3, var4, var3);
								this.a(var1, Blocks.PLANKS.S(), 6, 3, var4, var3);
							}

							this.a(var1, Blocks.PLANKS.S(), 7, 3, var4, var3);
							this.a(var1, Blocks.PLANKS.S(), 8, 3, var4, var3);
						}

						class_apn var5 = Blocks.LADDER.S().a(class_alb.a, class_cq.e);
						this.a(var1, var5, 9, 1, 3, var3);
						this.a(var1, var5, 9, 2, 3, var3);
						this.a(var1, var5, 9, 3, 3, var3);
						this.a(var1, var3, var2, 3, 4, 8, class_oj.a(b, new class_oj[] { Items.ci.b(var2) }), 1 + var2.nextInt(4));
				}

				return true;
			}
		}

		static {
			b = Lists.newArrayList((Object[]) (new class_oj[] { new class_oj(Items.l, 0, 1, 5, 10), new class_oj(Items.m, 0, 1, 3, 5), new class_oj(Items.aE, 0, 4, 9, 5), new class_oj(Items.j, 0, 3, 8, 10), new class_oj(Items.R, 0, 1, 3, 15), new class_oj(Items.e, 0, 1, 3, 15), new class_oj(Items.b, 0, 1, 1, 1) }));
		}
	}

	public static class class_i_in_class_aun extends class_aun.class_d_in_class_aun {
		@Override
		public void a(class_aur var1, List var2, Random var3) {
			class_cq var4 = e();
			if ((var4 != class_cq.c) && (var4 != class_cq.f)) {
				this.b((class_aun.class_m_in_class_aun) var1, var2, var3, 1, 1);
			} else {
				this.c((class_aun.class_m_in_class_aun) var1, var2, var3, 1, 1);
			}

		}

		@Override
		public boolean a(class_ago var1, Random var2, class_aua var3) {
			if (this.a(var1, var3)) {
				return false;
			} else {
				this.a(var1, var3, 0, 0, 0, 4, 4, 4, true, var2, class_aun.e);
				this.a(var1, var2, var3, d, 1, 1, 0);
				class_cq var4 = e();
				if ((var4 != class_cq.c) && (var4 != class_cq.f)) {
					this.a(var1, var3, 0, 1, 1, 0, 3, 3, Blocks.AIR.S(), Blocks.AIR.S(), false);
				} else {
					this.a(var1, var3, 4, 1, 1, 4, 3, 3, Blocks.AIR.S(), Blocks.AIR.S(), false);
				}

				return true;
			}
		}
	}

	public static class class_d_in_class_aun extends class_aun.class_p_in_class_aun {
		public class_d_in_class_aun() {
		}

		public class_d_in_class_aun(int var1, Random var2, class_aua var3, class_cq var4) {
			super(var1);
			this.a(var4);
			d = this.a(var2);
			l = var3;
		}

		@Override
		public void a(class_aur var1, List var2, Random var3) {
			class_cq var4 = e();
			if ((var4 != class_cq.c) && (var4 != class_cq.f)) {
				this.c((class_aun.class_m_in_class_aun) var1, var2, var3, 1, 1);
			} else {
				this.b((class_aun.class_m_in_class_aun) var1, var2, var3, 1, 1);
			}

		}

		public static class_aun.class_d_in_class_aun a(List var0, Random var1, int var2, int var3, int var4, class_cq var5, int var6) {
			class_aua var7 = class_aua.a(var2, var3, var4, -1, -1, 0, 5, 5, 5, var5);
			return a(var7) && (class_aur.a(var0, var7) == null) ? new class_aun.class_d_in_class_aun(var6, var1, var7, var5) : null;
		}

		@Override
		public boolean a(class_ago var1, Random var2, class_aua var3) {
			if (this.a(var1, var3)) {
				return false;
			} else {
				this.a(var1, var3, 0, 0, 0, 4, 4, 4, true, var2, class_aun.e);
				this.a(var1, var2, var3, d, 1, 1, 0);
				class_cq var4 = e();
				if ((var4 != class_cq.c) && (var4 != class_cq.f)) {
					this.a(var1, var3, 4, 1, 1, 4, 3, 3, Blocks.AIR.S(), Blocks.AIR.S(), false);
				} else {
					this.a(var1, var3, 0, 1, 1, 0, 3, 3, Blocks.AIR.S(), Blocks.AIR.S(), false);
				}

				return true;
			}
		}
	}

	public static class class_o_in_class_aun extends class_aun.class_p_in_class_aun {
		public class_o_in_class_aun() {
		}

		public class_o_in_class_aun(int var1, Random var2, class_aua var3, class_cq var4) {
			super(var1);
			this.a(var4);
			d = this.a(var2);
			l = var3;
		}

		@Override
		public void a(class_aur var1, List var2, Random var3) {
			this.a((class_aun.class_m_in_class_aun) var1, var2, var3, 1, 1);
		}

		public static class_aun.class_o_in_class_aun a(List var0, Random var1, int var2, int var3, int var4, class_cq var5, int var6) {
			class_aua var7 = class_aua.a(var2, var3, var4, -1, -7, 0, 5, 11, 8, var5);
			return a(var7) && (class_aur.a(var0, var7) == null) ? new class_aun.class_o_in_class_aun(var6, var1, var7, var5) : null;
		}

		@Override
		public boolean a(class_ago var1, Random var2, class_aua var3) {
			if (this.a(var1, var3)) {
				return false;
			} else {
				this.a(var1, var3, 0, 0, 0, 4, 10, 7, true, var2, class_aun.e);
				this.a(var1, var2, var3, d, 1, 7, 0);
				this.a(var1, var2, var3, class_aun.class_p_in_class_aun.class_p_in_class_aun$class_a_in_class_p_in_class_aun.a, 1, 1, 7);
				class_apn var4 = Blocks.STONE_STAIRS.S().a(class_anf.a, class_cq.d);

				for (int var5 = 0; var5 < 6; ++var5) {
					this.a(var1, var4, 1, 6 - var5, 1 + var5, var3);
					this.a(var1, var4, 2, 6 - var5, 1 + var5, var3);
					this.a(var1, var4, 3, 6 - var5, 1 + var5, var3);
					if (var5 < 5) {
						this.a(var1, Blocks.STONE_BRICK.S(), 1, 5 - var5, 1 + var5, var3);
						this.a(var1, Blocks.STONE_BRICK.S(), 2, 5 - var5, 1 + var5, var3);
						this.a(var1, Blocks.STONE_BRICK.S(), 3, 5 - var5, 1 + var5, var3);
					}
				}

				return true;
			}
		}
	}

	public static class class_a_in_class_aun extends class_aun.class_p_in_class_aun {
		private static final List a;
		private boolean b;

		public class_a_in_class_aun() {
		}

		public class_a_in_class_aun(int var1, Random var2, class_aua var3, class_cq var4) {
			super(var1);
			this.a(var4);
			d = this.a(var2);
			l = var3;
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
		public void a(class_aur var1, List var2, Random var3) {
			this.a((class_aun.class_m_in_class_aun) var1, var2, var3, 1, 1);
		}

		public static class_aun.class_a_in_class_aun a(List var0, Random var1, int var2, int var3, int var4, class_cq var5, int var6) {
			class_aua var7 = class_aua.a(var2, var3, var4, -1, -1, 0, 5, 5, 7, var5);
			return a(var7) && (class_aur.a(var0, var7) == null) ? new class_aun.class_a_in_class_aun(var6, var1, var7, var5) : null;
		}

		@Override
		public boolean a(class_ago var1, Random var2, class_aua var3) {
			if (this.a(var1, var3)) {
				return false;
			} else {
				this.a(var1, var3, 0, 0, 0, 4, 4, 6, true, var2, class_aun.e);
				this.a(var1, var2, var3, d, 1, 1, 0);
				this.a(var1, var2, var3, class_aun.class_p_in_class_aun.class_p_in_class_aun$class_a_in_class_p_in_class_aun.a, 1, 1, 6);
				this.a(var1, var3, 3, 1, 2, 3, 1, 4, Blocks.STONE_BRICK.S(), Blocks.STONE_BRICK.S(), false);
				this.a(var1, Blocks.STONE_SLAB.a(class_anm.class_a_in_class_anm.f.a()), 3, 1, 1, var3);
				this.a(var1, Blocks.STONE_SLAB.a(class_anm.class_a_in_class_anm.f.a()), 3, 1, 5, var3);
				this.a(var1, Blocks.STONE_SLAB.a(class_anm.class_a_in_class_anm.f.a()), 3, 2, 2, var3);
				this.a(var1, Blocks.STONE_SLAB.a(class_anm.class_a_in_class_anm.f.a()), 3, 2, 4, var3);

				for (int var4 = 2; var4 <= 4; ++var4) {
					this.a(var1, Blocks.STONE_SLAB.a(class_anm.class_a_in_class_anm.f.a()), 2, 1, var4, var3);
				}

				if (!b && var3.b((new class_cj(this.a(3, 3), this.d(2), this.b(3, 3))))) {
					b = true;
					this.a(var1, var3, var2, 3, 2, 3, class_oj.a(a, new class_oj[] { Items.ci.b(var2) }), 2 + var2.nextInt(2));
				}

				return true;
			}
		}

		static {
			a = Lists.newArrayList((Object[]) (new class_oj[] { new class_oj(Items.bw, 0, 1, 1, 10), new class_oj(Items.k, 0, 1, 3, 3), new class_oj(Items.l, 0, 1, 5, 10), new class_oj(Items.m, 0, 1, 3, 5), new class_oj(Items.aE, 0, 4, 9, 5), new class_oj(Items.R, 0, 1, 3, 15), new class_oj(Items.e, 0, 1, 3, 15), new class_oj(Items.b, 0, 1, 1, 5), new class_oj(Items.n, 0, 1, 1, 5), new class_oj(Items.ab, 0, 1, 1, 5),
					new class_oj(Items.aa, 0, 1, 1, 5), new class_oj(Items.ac, 0, 1, 1, 5), new class_oj(Items.ad, 0, 1, 1, 5), new class_oj(Items.aq, 0, 1, 1, 1), new class_oj(Items.aC, 0, 1, 1, 1), new class_oj(Items.cp, 0, 1, 1, 1), new class_oj(Items.cq, 0, 1, 1, 1), new class_oj(Items.cr, 0, 1, 1, 1) }));
		}
	}

	public static class class_n_in_class_aun extends class_aun.class_p_in_class_aun {
		private boolean a;
		private boolean b;

		public class_n_in_class_aun() {
		}

		public class_n_in_class_aun(int var1, Random var2, class_aua var3, class_cq var4) {
			super(var1);
			this.a(var4);
			d = this.a(var2);
			l = var3;
			a = var2.nextInt(2) == 0;
			b = var2.nextInt(2) == 0;
		}

		@Override
		protected void a(class_dn var1) {
			super.a(var1);
			var1.a("Left", a);
			var1.a("Right", b);
		}

		@Override
		protected void b(class_dn var1) {
			super.b(var1);
			a = var1.p("Left");
			b = var1.p("Right");
		}

		@Override
		public void a(class_aur var1, List var2, Random var3) {
			this.a((class_aun.class_m_in_class_aun) var1, var2, var3, 1, 1);
			if (a) {
				this.b((class_aun.class_m_in_class_aun) var1, var2, var3, 1, 2);
			}

			if (b) {
				this.c((class_aun.class_m_in_class_aun) var1, var2, var3, 1, 2);
			}

		}

		public static class_aun.class_n_in_class_aun a(List var0, Random var1, int var2, int var3, int var4, class_cq var5, int var6) {
			class_aua var7 = class_aua.a(var2, var3, var4, -1, -1, 0, 5, 5, 7, var5);
			return a(var7) && (class_aur.a(var0, var7) == null) ? new class_aun.class_n_in_class_aun(var6, var1, var7, var5) : null;
		}

		@Override
		public boolean a(class_ago var1, Random var2, class_aua var3) {
			if (this.a(var1, var3)) {
				return false;
			} else {
				this.a(var1, var3, 0, 0, 0, 4, 4, 6, true, var2, class_aun.e);
				this.a(var1, var2, var3, d, 1, 1, 0);
				this.a(var1, var2, var3, class_aun.class_p_in_class_aun.class_p_in_class_aun$class_a_in_class_p_in_class_aun.a, 1, 1, 6);
				class_apn var4 = Blocks.TORCH.S().a(class_anr.a, class_cq.f);
				class_apn var5 = Blocks.TORCH.S().a(class_anr.a, class_cq.e);
				this.a(var1, var3, var2, 0.1F, 1, 2, 1, var4);
				this.a(var1, var3, var2, 0.1F, 3, 2, 1, var5);
				this.a(var1, var3, var2, 0.1F, 1, 2, 5, var4);
				this.a(var1, var3, var2, 0.1F, 3, 2, 5, var5);
				if (a) {
					this.a(var1, var3, 0, 1, 2, 0, 3, 4, Blocks.AIR.S(), Blocks.AIR.S(), false);
				}

				if (b) {
					this.a(var1, var3, 4, 1, 2, 4, 3, 4, Blocks.AIR.S(), Blocks.AIR.S(), false);
				}

				return true;
			}
		}
	}

	public static class class_m_in_class_aun extends class_aun.class_l_in_class_aun {
		public class_aun.class_f_in_class_aun a;
		public class_aun.class_g_in_class_aun b;
		public List c = Lists.newArrayList();

		public class_m_in_class_aun() {
		}

		public class_m_in_class_aun(int var1, Random var2, int var3, int var4) {
			super(0, var2, var3, var4);
		}

		@Override
		public class_cj a() {
			return b != null ? b.a() : super.a();
		}
	}

	public static class class_l_in_class_aun extends class_aun.class_p_in_class_aun {
		private boolean a;

		public class_l_in_class_aun() {
		}

		public class_l_in_class_aun(int var1, Random var2, int var3, int var4) {
			super(var1);
			a = true;
			this.a(class_cq.class_c_in_class_cq.a.a(var2));
			d = class_aun.class_p_in_class_aun.class_p_in_class_aun$class_a_in_class_p_in_class_aun.a;
			if (e().k() == class_cq.class_a_in_class_cq.c) {
				l = new class_aua(var3, 64, var4, (var3 + 5) - 1, 74, (var4 + 5) - 1);
			} else {
				l = new class_aua(var3, 64, var4, (var3 + 5) - 1, 74, (var4 + 5) - 1);
			}

		}

		public class_l_in_class_aun(int var1, Random var2, class_aua var3, class_cq var4) {
			super(var1);
			a = false;
			this.a(var4);
			d = this.a(var2);
			l = var3;
		}

		@Override
		protected void a(class_dn var1) {
			super.a(var1);
			var1.a("Source", a);
		}

		@Override
		protected void b(class_dn var1) {
			super.b(var1);
			a = var1.p("Source");
		}

		@Override
		public void a(class_aur var1, List var2, Random var3) {
			if (a) {
				class_aun.d = class_aun.class_c_in_class_aun.class;
			}

			this.a((class_aun.class_m_in_class_aun) var1, var2, var3, 1, 1);
		}

		public static class_aun.class_l_in_class_aun a(List var0, Random var1, int var2, int var3, int var4, class_cq var5, int var6) {
			class_aua var7 = class_aua.a(var2, var3, var4, -1, -7, 0, 5, 11, 5, var5);
			return a(var7) && (class_aur.a(var0, var7) == null) ? new class_aun.class_l_in_class_aun(var6, var1, var7, var5) : null;
		}

		@Override
		public boolean a(class_ago var1, Random var2, class_aua var3) {
			if (this.a(var1, var3)) {
				return false;
			} else {
				this.a(var1, var3, 0, 0, 0, 4, 10, 4, true, var2, class_aun.e);
				this.a(var1, var2, var3, d, 1, 7, 0);
				this.a(var1, var2, var3, class_aun.class_p_in_class_aun.class_p_in_class_aun$class_a_in_class_p_in_class_aun.a, 1, 1, 4);
				this.a(var1, Blocks.STONE_BRICK.S(), 2, 6, 1, var3);
				this.a(var1, Blocks.STONE_BRICK.S(), 1, 5, 1, var3);
				this.a(var1, Blocks.STONE_SLAB.a(class_anm.class_a_in_class_anm.a.a()), 1, 6, 1, var3);
				this.a(var1, Blocks.STONE_BRICK.S(), 1, 5, 2, var3);
				this.a(var1, Blocks.STONE_BRICK.S(), 1, 4, 3, var3);
				this.a(var1, Blocks.STONE_SLAB.a(class_anm.class_a_in_class_anm.a.a()), 1, 5, 3, var3);
				this.a(var1, Blocks.STONE_BRICK.S(), 2, 4, 3, var3);
				this.a(var1, Blocks.STONE_BRICK.S(), 3, 3, 3, var3);
				this.a(var1, Blocks.STONE_SLAB.a(class_anm.class_a_in_class_anm.a.a()), 3, 4, 3, var3);
				this.a(var1, Blocks.STONE_BRICK.S(), 3, 3, 2, var3);
				this.a(var1, Blocks.STONE_BRICK.S(), 3, 2, 1, var3);
				this.a(var1, Blocks.STONE_SLAB.a(class_anm.class_a_in_class_anm.a.a()), 3, 3, 1, var3);
				this.a(var1, Blocks.STONE_BRICK.S(), 2, 2, 1, var3);
				this.a(var1, Blocks.STONE_BRICK.S(), 1, 1, 1, var3);
				this.a(var1, Blocks.STONE_SLAB.a(class_anm.class_a_in_class_anm.a.a()), 1, 2, 1, var3);
				this.a(var1, Blocks.STONE_BRICK.S(), 1, 1, 2, var3);
				this.a(var1, Blocks.STONE_SLAB.a(class_anm.class_a_in_class_anm.a.a()), 1, 1, 3, var3);
				return true;
			}
		}
	}

	public static class class_b_in_class_aun extends class_aun.class_p_in_class_aun {
		private int a;

		public class_b_in_class_aun() {
		}

		public class_b_in_class_aun(int var1, Random var2, class_aua var3, class_cq var4) {
			super(var1);
			this.a(var4);
			l = var3;
			a = (var4 != class_cq.c) && (var4 != class_cq.d) ? var3.c() : var3.e();
		}

		@Override
		protected void a(class_dn var1) {
			super.a(var1);
			var1.a("Steps", a);
		}

		@Override
		protected void b(class_dn var1) {
			super.b(var1);
			a = var1.h("Steps");
		}

		public static class_aua a(List var0, Random var1, int var2, int var3, int var4, class_cq var5) {
			boolean var6 = true;
			class_aua var7 = class_aua.a(var2, var3, var4, -1, -1, 0, 5, 5, 4, var5);
			class_aur var8 = class_aur.a(var0, var7);
			if (var8 == null) {
				return null;
			} else {
				if (var8.c().b == var7.b) {
					for (int var9 = 3; var9 >= 1; --var9) {
						var7 = class_aua.a(var2, var3, var4, -1, -1, 0, 5, 5, var9 - 1, var5);
						if (!var8.c().a(var7)) {
							return class_aua.a(var2, var3, var4, -1, -1, 0, 5, 5, var9, var5);
						}
					}
				}

				return null;
			}
		}

		@Override
		public boolean a(class_ago var1, Random var2, class_aua var3) {
			if (this.a(var1, var3)) {
				return false;
			} else {
				for (int var4 = 0; var4 < a; ++var4) {
					this.a(var1, Blocks.STONE_BRICK.S(), 0, 0, var4, var3);
					this.a(var1, Blocks.STONE_BRICK.S(), 1, 0, var4, var3);
					this.a(var1, Blocks.STONE_BRICK.S(), 2, 0, var4, var3);
					this.a(var1, Blocks.STONE_BRICK.S(), 3, 0, var4, var3);
					this.a(var1, Blocks.STONE_BRICK.S(), 4, 0, var4, var3);

					for (int var5 = 1; var5 <= 3; ++var5) {
						this.a(var1, Blocks.STONE_BRICK.S(), 0, var5, var4, var3);
						this.a(var1, Blocks.AIR.S(), 1, var5, var4, var3);
						this.a(var1, Blocks.AIR.S(), 2, var5, var4, var3);
						this.a(var1, Blocks.AIR.S(), 3, var5, var4, var3);
						this.a(var1, Blocks.STONE_BRICK.S(), 4, var5, var4, var3);
					}

					this.a(var1, Blocks.STONE_BRICK.S(), 0, 4, var4, var3);
					this.a(var1, Blocks.STONE_BRICK.S(), 1, 4, var4, var3);
					this.a(var1, Blocks.STONE_BRICK.S(), 2, 4, var4, var3);
					this.a(var1, Blocks.STONE_BRICK.S(), 3, 4, var4, var3);
					this.a(var1, Blocks.STONE_BRICK.S(), 4, 4, var4, var3);
				}

				return true;
			}
		}
	}

	abstract static class class_p_in_class_aun extends class_aur {
		protected class_aun.class_p_in_class_aun.class_p_in_class_aun$class_a_in_class_p_in_class_aun d;

		public class_p_in_class_aun() {
			d = class_aun.class_p_in_class_aun.class_p_in_class_aun$class_a_in_class_p_in_class_aun.a;
		}

		protected class_p_in_class_aun(int var1) {
			super(var1);
			d = class_aun.class_p_in_class_aun.class_p_in_class_aun$class_a_in_class_p_in_class_aun.a;
		}

		@Override
		protected void a(class_dn var1) {
			var1.a("EntryDoor", d.name());
		}

		@Override
		protected void b(class_dn var1) {
			d = class_aun.class_p_in_class_aun.class_p_in_class_aun$class_a_in_class_p_in_class_aun.valueOf(var1.l("EntryDoor"));
		}

		protected void a(class_ago var1, Random var2, class_aua var3, class_aun.class_p_in_class_aun.class_p_in_class_aun$class_a_in_class_p_in_class_aun var4, int var5, int var6, int var7) {
			switch (class_aun.SyntheticClass_1.a[var4.ordinal()]) {
				case 1:
				default:
					this.a(var1, var3, var5, var6, var7, (var5 + 3) - 1, (var6 + 3) - 1, var7, Blocks.AIR.S(), Blocks.AIR.S(), false);
					break;
				case 2:
					this.a(var1, Blocks.STONE_BRICK.S(), var5, var6, var7, var3);
					this.a(var1, Blocks.STONE_BRICK.S(), var5, var6 + 1, var7, var3);
					this.a(var1, Blocks.STONE_BRICK.S(), var5, var6 + 2, var7, var3);
					this.a(var1, Blocks.STONE_BRICK.S(), var5 + 1, var6 + 2, var7, var3);
					this.a(var1, Blocks.STONE_BRICK.S(), var5 + 2, var6 + 2, var7, var3);
					this.a(var1, Blocks.STONE_BRICK.S(), var5 + 2, var6 + 1, var7, var3);
					this.a(var1, Blocks.STONE_BRICK.S(), var5 + 2, var6, var7, var3);
					this.a(var1, Blocks.WOODEN_DOOR.S(), var5 + 1, var6, var7, var3);
					this.a(var1, Blocks.WOODEN_DOOR.S().a(class_ajn.P, class_ajn.class_a_in_class_ajn.a), var5 + 1, var6 + 1, var7, var3);
					break;
				case 3:
					this.a(var1, Blocks.AIR.S(), var5 + 1, var6, var7, var3);
					this.a(var1, Blocks.AIR.S(), var5 + 1, var6 + 1, var7, var3);
					this.a(var1, Blocks.IRON_BARS.S(), var5, var6, var7, var3);
					this.a(var1, Blocks.IRON_BARS.S(), var5, var6 + 1, var7, var3);
					this.a(var1, Blocks.IRON_BARS.S(), var5, var6 + 2, var7, var3);
					this.a(var1, Blocks.IRON_BARS.S(), var5 + 1, var6 + 2, var7, var3);
					this.a(var1, Blocks.IRON_BARS.S(), var5 + 2, var6 + 2, var7, var3);
					this.a(var1, Blocks.IRON_BARS.S(), var5 + 2, var6 + 1, var7, var3);
					this.a(var1, Blocks.IRON_BARS.S(), var5 + 2, var6, var7, var3);
					break;
				case 4:
					this.a(var1, Blocks.STONE_BRICK.S(), var5, var6, var7, var3);
					this.a(var1, Blocks.STONE_BRICK.S(), var5, var6 + 1, var7, var3);
					this.a(var1, Blocks.STONE_BRICK.S(), var5, var6 + 2, var7, var3);
					this.a(var1, Blocks.STONE_BRICK.S(), var5 + 1, var6 + 2, var7, var3);
					this.a(var1, Blocks.STONE_BRICK.S(), var5 + 2, var6 + 2, var7, var3);
					this.a(var1, Blocks.STONE_BRICK.S(), var5 + 2, var6 + 1, var7, var3);
					this.a(var1, Blocks.STONE_BRICK.S(), var5 + 2, var6, var7, var3);
					this.a(var1, Blocks.IRON_DOOR.S(), var5 + 1, var6, var7, var3);
					this.a(var1, Blocks.IRON_DOOR.S().a(class_ajn.P, class_ajn.class_a_in_class_ajn.a), var5 + 1, var6 + 1, var7, var3);
					this.a(var1, Blocks.STONE_BUTTON.S().a(class_ajk.b, class_cq.c), var5 + 2, var6 + 1, var7 + 1, var3);
					this.a(var1, Blocks.STONE_BUTTON.S().a(class_ajk.b, class_cq.d), var5 + 2, var6 + 1, var7 - 1, var3);
			}

		}

		protected class_aun.class_p_in_class_aun.class_p_in_class_aun$class_a_in_class_p_in_class_aun a(Random var1) {
			int var2 = var1.nextInt(5);
			switch (var2) {
				case 0:
				case 1:
				default:
					return class_aun.class_p_in_class_aun.class_p_in_class_aun$class_a_in_class_p_in_class_aun.a;
				case 2:
					return class_aun.class_p_in_class_aun.class_p_in_class_aun$class_a_in_class_p_in_class_aun.b;
				case 3:
					return class_aun.class_p_in_class_aun.class_p_in_class_aun$class_a_in_class_p_in_class_aun.c;
				case 4:
					return class_aun.class_p_in_class_aun.class_p_in_class_aun$class_a_in_class_p_in_class_aun.d;
			}
		}

		protected class_aur a(class_aun.class_m_in_class_aun var1, List var2, Random var3, int var4, int var5) {
			class_cq var6 = e();
			if (var6 != null) {
				switch (class_aun.SyntheticClass_1.b[var6.ordinal()]) {
					case 1:
						return class_aun.c(var1, var2, var3, l.a + var4, l.b + var5, l.c - 1, var6, this.d());
					case 2:
						return class_aun.c(var1, var2, var3, l.a + var4, l.b + var5, l.f + 1, var6, this.d());
					case 3:
						return class_aun.c(var1, var2, var3, l.a - 1, l.b + var5, l.c + var4, var6, this.d());
					case 4:
						return class_aun.c(var1, var2, var3, l.d + 1, l.b + var5, l.c + var4, var6, this.d());
				}
			}

			return null;
		}

		protected class_aur b(class_aun.class_m_in_class_aun var1, List var2, Random var3, int var4, int var5) {
			class_cq var6 = e();
			if (var6 != null) {
				switch (class_aun.SyntheticClass_1.b[var6.ordinal()]) {
					case 1:
						return class_aun.c(var1, var2, var3, l.a - 1, l.b + var4, l.c + var5, class_cq.e, this.d());
					case 2:
						return class_aun.c(var1, var2, var3, l.a - 1, l.b + var4, l.c + var5, class_cq.e, this.d());
					case 3:
						return class_aun.c(var1, var2, var3, l.a + var5, l.b + var4, l.c - 1, class_cq.c, this.d());
					case 4:
						return class_aun.c(var1, var2, var3, l.a + var5, l.b + var4, l.c - 1, class_cq.c, this.d());
				}
			}

			return null;
		}

		protected class_aur c(class_aun.class_m_in_class_aun var1, List var2, Random var3, int var4, int var5) {
			class_cq var6 = e();
			if (var6 != null) {
				switch (class_aun.SyntheticClass_1.b[var6.ordinal()]) {
					case 1:
						return class_aun.c(var1, var2, var3, l.d + 1, l.b + var4, l.c + var5, class_cq.f, this.d());
					case 2:
						return class_aun.c(var1, var2, var3, l.d + 1, l.b + var4, l.c + var5, class_cq.f, this.d());
					case 3:
						return class_aun.c(var1, var2, var3, l.a + var5, l.b + var4, l.f + 1, class_cq.d, this.d());
					case 4:
						return class_aun.c(var1, var2, var3, l.a + var5, l.b + var4, l.f + 1, class_cq.d, this.d());
				}
			}

			return null;
		}

		protected static boolean a(class_aua var0) {
			return (var0 != null) && (var0.b > 10);
		}

		public static enum class_p_in_class_aun$class_a_in_class_p_in_class_aun {
			a,
			b,
			c,
			d;
		}
	}

	static class class_f_in_class_aun {
		public Class a;
		public final int b;
		public int c;
		public int d;

		public class_f_in_class_aun(Class var1, int var2, int var3) {
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
