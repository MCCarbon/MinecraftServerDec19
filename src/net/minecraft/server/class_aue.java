package net.minecraft.server;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;

public class class_aue {
	private static final List a;

	public static void a() {
		class_aup.a(class_aue.class_a_in_class_aue.class, "MSCorridor");
		class_aup.a(class_aue.class_b_in_class_aue.class, "MSCrossing");
		class_aup.a(class_aue.class_c_in_class_aue.class, "MSRoom");
		class_aup.a(class_aue.class_d_in_class_aue.class, "MSStairs");
	}

	private static class_aur a(List var0, Random var1, int var2, int var3, int var4, class_cq var5, int var6) {
		int var7 = var1.nextInt(100);
		class_aua var8;
		if (var7 >= 80) {
			var8 = class_aue.class_b_in_class_aue.a(var0, var1, var2, var3, var4, var5);
			if (var8 != null) {
				return new class_aue.class_b_in_class_aue(var6, var1, var8, var5);
			}
		} else if (var7 >= 70) {
			var8 = class_aue.class_d_in_class_aue.a(var0, var1, var2, var3, var4, var5);
			if (var8 != null) {
				return new class_aue.class_d_in_class_aue(var6, var1, var8, var5);
			}
		} else {
			var8 = class_aue.class_a_in_class_aue.a(var0, var1, var2, var3, var4, var5);
			if (var8 != null) {
				return new class_aue.class_a_in_class_aue(var6, var1, var8, var5);
			}
		}

		return null;
	}

	private static class_aur b(class_aur var0, List var1, Random var2, int var3, int var4, int var5, class_cq var6, int var7) {
		if (var7 > 8) {
			return null;
		} else if ((Math.abs(var3 - var0.c().a) <= 80) && (Math.abs(var5 - var0.c().c) <= 80)) {
			class_aur var8 = a(var1, var2, var3, var4, var5, var6, var7 + 1);
			if (var8 != null) {
				var1.add(var8);
				var8.a(var0, var1, var2);
			}

			return var8;
		} else {
			return null;
		}
	}

	static {
		a = Lists.newArrayList((Object[]) (new class_oj[] { new class_oj(class_acq.l, 0, 1, 5, 10), new class_oj(class_acq.m, 0, 1, 3, 5), new class_oj(class_acq.aE, 0, 4, 9, 5), new class_oj(class_acq.aY, class_abt.l.b(), 4, 9, 5), new class_oj(class_acq.k, 0, 1, 2, 3), new class_oj(class_acq.j, 0, 3, 8, 10), new class_oj(class_acq.R, 0, 1, 3, 15), new class_oj(class_acq.b, 0, 1, 1, 1), new class_oj(class_acm.a(class_aim.av), 0, 4, 8, 1), new class_oj(class_acq.bj, 0, 2, 4, 10),
				new class_oj(class_acq.bi, 0, 2, 4, 10), new class_oj(class_acq.aC, 0, 1, 1, 3), new class_oj(class_acq.cp, 0, 1, 1, 1) }));
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

	public static class class_d_in_class_aue extends class_aur {
		public class_d_in_class_aue() {
		}

		public class_d_in_class_aue(int var1, Random var2, class_aua var3, class_cq var4) {
			super(var1);
			this.a(var4);
			l = var3;
		}

		@Override
		protected void a(class_dn var1) {
		}

		@Override
		protected void b(class_dn var1) {
		}

		public static class_aua a(List var0, Random var1, int var2, int var3, int var4, class_cq var5) {
			class_aua var6 = new class_aua(var2, var3 - 5, var4, var2, var3 + 2, var4);
			switch (class_aue.SyntheticClass_1.a[var5.ordinal()]) {
				case 1:
					var6.d = var2 + 2;
					var6.c = var4 - 8;
					break;
				case 2:
					var6.d = var2 + 2;
					var6.f = var4 + 8;
					break;
				case 3:
					var6.a = var2 - 8;
					var6.f = var4 + 2;
					break;
				case 4:
					var6.d = var2 + 8;
					var6.f = var4 + 2;
			}

			return class_aur.a(var0, var6) != null ? null : var6;
		}

		@Override
		public void a(class_aur var1, List var2, Random var3) {
			int var4 = this.d();
			class_cq var5 = e();
			if (var5 != null) {
				switch (class_aue.SyntheticClass_1.a[var5.ordinal()]) {
					case 1:
						class_aue.b(var1, var2, var3, l.a, l.b, l.c - 1, class_cq.c, var4);
						break;
					case 2:
						class_aue.b(var1, var2, var3, l.a, l.b, l.f + 1, class_cq.d, var4);
						break;
					case 3:
						class_aue.b(var1, var2, var3, l.a - 1, l.b, l.c, class_cq.e, var4);
						break;
					case 4:
						class_aue.b(var1, var2, var3, l.d + 1, l.b, l.c, class_cq.f, var4);
				}
			}

		}

		@Override
		public boolean a(class_ago var1, Random var2, class_aua var3) {
			if (this.a(var1, var3)) {
				return false;
			} else {
				this.a(var1, var3, 0, 5, 0, 2, 7, 1, class_aim.a.S(), class_aim.a.S(), false);
				this.a(var1, var3, 0, 0, 7, 2, 2, 8, class_aim.a.S(), class_aim.a.S(), false);

				for (int var4 = 0; var4 < 5; ++var4) {
					this.a(var1, var3, 0, 5 - var4 - (var4 < 4 ? 1 : 0), 2 + var4, 2, 7 - var4, 2 + var4, class_aim.a.S(), class_aim.a.S(), false);
				}

				return true;
			}
		}
	}

	public static class class_b_in_class_aue extends class_aur {
		private class_cq a;
		private boolean b;

		public class_b_in_class_aue() {
		}

		@Override
		protected void a(class_dn var1) {
			var1.a("tf", b);
			var1.a("D", a.b());
		}

		@Override
		protected void b(class_dn var1) {
			b = var1.p("tf");
			a = class_cq.b(var1.h("D"));
		}

		public class_b_in_class_aue(int var1, Random var2, class_aua var3, class_cq var4) {
			super(var1);
			a = var4;
			l = var3;
			b = var3.d() > 3;
		}

		public static class_aua a(List var0, Random var1, int var2, int var3, int var4, class_cq var5) {
			class_aua var6 = new class_aua(var2, var3, var4, var2, var3 + 2, var4);
			if (var1.nextInt(4) == 0) {
				var6.e += 4;
			}

			switch (class_aue.SyntheticClass_1.a[var5.ordinal()]) {
				case 1:
					var6.a = var2 - 1;
					var6.d = var2 + 3;
					var6.c = var4 - 4;
					break;
				case 2:
					var6.a = var2 - 1;
					var6.d = var2 + 3;
					var6.f = var4 + 4;
					break;
				case 3:
					var6.a = var2 - 4;
					var6.c = var4 - 1;
					var6.f = var4 + 3;
					break;
				case 4:
					var6.d = var2 + 4;
					var6.c = var4 - 1;
					var6.f = var4 + 3;
			}

			return class_aur.a(var0, var6) != null ? null : var6;
		}

		@Override
		public void a(class_aur var1, List var2, Random var3) {
			int var4 = this.d();
			switch (class_aue.SyntheticClass_1.a[a.ordinal()]) {
				case 1:
					class_aue.b(var1, var2, var3, l.a + 1, l.b, l.c - 1, class_cq.c, var4);
					class_aue.b(var1, var2, var3, l.a - 1, l.b, l.c + 1, class_cq.e, var4);
					class_aue.b(var1, var2, var3, l.d + 1, l.b, l.c + 1, class_cq.f, var4);
					break;
				case 2:
					class_aue.b(var1, var2, var3, l.a + 1, l.b, l.f + 1, class_cq.d, var4);
					class_aue.b(var1, var2, var3, l.a - 1, l.b, l.c + 1, class_cq.e, var4);
					class_aue.b(var1, var2, var3, l.d + 1, l.b, l.c + 1, class_cq.f, var4);
					break;
				case 3:
					class_aue.b(var1, var2, var3, l.a + 1, l.b, l.c - 1, class_cq.c, var4);
					class_aue.b(var1, var2, var3, l.a + 1, l.b, l.f + 1, class_cq.d, var4);
					class_aue.b(var1, var2, var3, l.a - 1, l.b, l.c + 1, class_cq.e, var4);
					break;
				case 4:
					class_aue.b(var1, var2, var3, l.a + 1, l.b, l.c - 1, class_cq.c, var4);
					class_aue.b(var1, var2, var3, l.a + 1, l.b, l.f + 1, class_cq.d, var4);
					class_aue.b(var1, var2, var3, l.d + 1, l.b, l.c + 1, class_cq.f, var4);
			}

			if (b) {
				if (var3.nextBoolean()) {
					class_aue.b(var1, var2, var3, l.a + 1, l.b + 3 + 1, l.c - 1, class_cq.c, var4);
				}

				if (var3.nextBoolean()) {
					class_aue.b(var1, var2, var3, l.a - 1, l.b + 3 + 1, l.c + 1, class_cq.e, var4);
				}

				if (var3.nextBoolean()) {
					class_aue.b(var1, var2, var3, l.d + 1, l.b + 3 + 1, l.c + 1, class_cq.f, var4);
				}

				if (var3.nextBoolean()) {
					class_aue.b(var1, var2, var3, l.a + 1, l.b + 3 + 1, l.f + 1, class_cq.d, var4);
				}
			}

		}

		@Override
		public boolean a(class_ago var1, Random var2, class_aua var3) {
			if (this.a(var1, var3)) {
				return false;
			} else {
				if (b) {
					this.a(var1, var3, l.a + 1, l.b, l.c, l.d - 1, (l.b + 3) - 1, l.f, class_aim.a.S(), class_aim.a.S(), false);
					this.a(var1, var3, l.a, l.b, l.c + 1, l.d, (l.b + 3) - 1, l.f - 1, class_aim.a.S(), class_aim.a.S(), false);
					this.a(var1, var3, l.a + 1, l.e - 2, l.c, l.d - 1, l.e, l.f, class_aim.a.S(), class_aim.a.S(), false);
					this.a(var1, var3, l.a, l.e - 2, l.c + 1, l.d, l.e, l.f - 1, class_aim.a.S(), class_aim.a.S(), false);
					this.a(var1, var3, l.a + 1, l.b + 3, l.c + 1, l.d - 1, l.b + 3, l.f - 1, class_aim.a.S(), class_aim.a.S(), false);
				} else {
					this.a(var1, var3, l.a + 1, l.b, l.c, l.d - 1, l.e, l.f, class_aim.a.S(), class_aim.a.S(), false);
					this.a(var1, var3, l.a, l.b, l.c + 1, l.d, l.e, l.f - 1, class_aim.a.S(), class_aim.a.S(), false);
				}

				this.a(var1, var3, l.a + 1, l.b, l.c + 1, l.a + 1, l.e, l.c + 1, class_aim.f.S(), class_aim.a.S(), false);
				this.a(var1, var3, l.a + 1, l.b, l.f - 1, l.a + 1, l.e, l.f - 1, class_aim.f.S(), class_aim.a.S(), false);
				this.a(var1, var3, l.d - 1, l.b, l.c + 1, l.d - 1, l.e, l.c + 1, class_aim.f.S(), class_aim.a.S(), false);
				this.a(var1, var3, l.d - 1, l.b, l.f - 1, l.d - 1, l.e, l.f - 1, class_aim.f.S(), class_aim.a.S(), false);

				for (int var4 = l.a; var4 <= l.d; ++var4) {
					for (int var5 = l.c; var5 <= l.f; ++var5) {
						if (this.a(var1, var4, l.b - 1, var5, var3).c().v() == class_avq.a) {
							this.a(var1, class_aim.f.S(), var4, l.b - 1, var5, var3);
						}
					}
				}

				return true;
			}
		}
	}

	public static class class_a_in_class_aue extends class_aur {
		private boolean a;
		private boolean b;
		private boolean c;
		private int d;

		public class_a_in_class_aue() {
		}

		@Override
		protected void a(class_dn var1) {
			var1.a("hr", a);
			var1.a("sc", b);
			var1.a("hps", c);
			var1.a("Num", d);
		}

		@Override
		protected void b(class_dn var1) {
			a = var1.p("hr");
			b = var1.p("sc");
			c = var1.p("hps");
			d = var1.h("Num");
		}

		public class_a_in_class_aue(int var1, Random var2, class_aua var3, class_cq var4) {
			super(var1);
			this.a(var4);
			l = var3;
			a = var2.nextInt(3) == 0;
			b = !a && (var2.nextInt(23) == 0);
			if (e().k() == class_cq.class_a_in_class_cq.c) {
				d = var3.e() / 5;
			} else {
				d = var3.c() / 5;
			}

		}

		public static class_aua a(List var0, Random var1, int var2, int var3, int var4, class_cq var5) {
			class_aua var6 = new class_aua(var2, var3, var4, var2, var3 + 2, var4);

			int var7;
			for (var7 = var1.nextInt(3) + 2; var7 > 0; --var7) {
				int var8 = var7 * 5;
				switch (class_aue.SyntheticClass_1.a[var5.ordinal()]) {
					case 1:
						var6.d = var2 + 2;
						var6.c = var4 - (var8 - 1);
						break;
					case 2:
						var6.d = var2 + 2;
						var6.f = var4 + (var8 - 1);
						break;
					case 3:
						var6.a = var2 - (var8 - 1);
						var6.f = var4 + 2;
						break;
					case 4:
						var6.d = var2 + (var8 - 1);
						var6.f = var4 + 2;
				}

				if (class_aur.a(var0, var6) == null) {
					break;
				}
			}

			return var7 > 0 ? var6 : null;
		}

		@Override
		public void a(class_aur var1, List var2, Random var3) {
			int var4 = this.d();
			int var5 = var3.nextInt(4);
			class_cq var6 = e();
			if (var6 != null) {
				switch (class_aue.SyntheticClass_1.a[var6.ordinal()]) {
					case 1:
						if (var5 <= 1) {
							class_aue.b(var1, var2, var3, l.a, (l.b - 1) + var3.nextInt(3), l.c - 1, var6, var4);
						} else if (var5 == 2) {
							class_aue.b(var1, var2, var3, l.a - 1, (l.b - 1) + var3.nextInt(3), l.c, class_cq.e, var4);
						} else {
							class_aue.b(var1, var2, var3, l.d + 1, (l.b - 1) + var3.nextInt(3), l.c, class_cq.f, var4);
						}
						break;
					case 2:
						if (var5 <= 1) {
							class_aue.b(var1, var2, var3, l.a, (l.b - 1) + var3.nextInt(3), l.f + 1, var6, var4);
						} else if (var5 == 2) {
							class_aue.b(var1, var2, var3, l.a - 1, (l.b - 1) + var3.nextInt(3), l.f - 3, class_cq.e, var4);
						} else {
							class_aue.b(var1, var2, var3, l.d + 1, (l.b - 1) + var3.nextInt(3), l.f - 3, class_cq.f, var4);
						}
						break;
					case 3:
						if (var5 <= 1) {
							class_aue.b(var1, var2, var3, l.a - 1, (l.b - 1) + var3.nextInt(3), l.c, var6, var4);
						} else if (var5 == 2) {
							class_aue.b(var1, var2, var3, l.a, (l.b - 1) + var3.nextInt(3), l.c - 1, class_cq.c, var4);
						} else {
							class_aue.b(var1, var2, var3, l.a, (l.b - 1) + var3.nextInt(3), l.f + 1, class_cq.d, var4);
						}
						break;
					case 4:
						if (var5 <= 1) {
							class_aue.b(var1, var2, var3, l.d + 1, (l.b - 1) + var3.nextInt(3), l.c, var6, var4);
						} else if (var5 == 2) {
							class_aue.b(var1, var2, var3, l.d - 3, (l.b - 1) + var3.nextInt(3), l.c - 1, class_cq.c, var4);
						} else {
							class_aue.b(var1, var2, var3, l.d - 3, (l.b - 1) + var3.nextInt(3), l.f + 1, class_cq.d, var4);
						}
				}
			}

			if (var4 < 8) {
				int var7;
				int var8;
				if ((var6 != class_cq.c) && (var6 != class_cq.d)) {
					for (var7 = l.a + 3; (var7 + 3) <= l.d; var7 += 5) {
						var8 = var3.nextInt(5);
						if (var8 == 0) {
							class_aue.b(var1, var2, var3, var7, l.b, l.c - 1, class_cq.c, var4 + 1);
						} else if (var8 == 1) {
							class_aue.b(var1, var2, var3, var7, l.b, l.f + 1, class_cq.d, var4 + 1);
						}
					}
				} else {
					for (var7 = l.c + 3; (var7 + 3) <= l.f; var7 += 5) {
						var8 = var3.nextInt(5);
						if (var8 == 0) {
							class_aue.b(var1, var2, var3, l.a - 1, l.b, var7, class_cq.e, var4 + 1);
						} else if (var8 == 1) {
							class_aue.b(var1, var2, var3, l.d + 1, l.b, var7, class_cq.f, var4 + 1);
						}
					}
				}
			}

		}

		@Override
		protected boolean a(class_ago var1, class_aua var2, Random var3, int var4, int var5, int var6, List var7, int var8) {
			class_cj var9 = new class_cj(this.a(var4, var6), this.d(var5), this.b(var4, var6));
			if (var2.b(var9) && (var1.p(var9).c().v() == class_avq.a)) {
				class_apn var10 = class_aim.av.S().a(class_ami.b, var3.nextBoolean() ? class_aih.class_b_in_class_aih.a : class_aih.class_b_in_class_aih.b);
				this.a(var1, var10, var4, var5, var6, var2);
				class_xi var11 = new class_xi(var1, var9.n() + 0.5F, var9.o() + 0.5F, var9.p() + 0.5F);
				class_oj.a(var3, var7, var11, var8);
				var1.a(var11);
				return true;
			} else {
				return false;
			}
		}

		@Override
		public boolean a(class_ago var1, Random var2, class_aua var3) {
			if (this.a(var1, var3)) {
				return false;
			} else {
				boolean var4 = false;
				boolean var5 = true;
				boolean var6 = false;
				boolean var7 = true;
				int var8 = (d * 5) - 1;
				this.a(var1, var3, 0, 0, 0, 2, 1, var8, class_aim.a.S(), class_aim.a.S(), false);
				this.a(var1, var3, var2, 0.8F, 0, 2, 0, 2, 2, var8, class_aim.a.S(), class_aim.a.S(), false);
				if (b) {
					this.a(var1, var3, var2, 0.6F, 0, 0, 0, 2, 1, var8, class_aim.G.S(), class_aim.a.S(), false);
				}

				int var9;
				int var10;
				for (var9 = 0; var9 < d; ++var9) {
					var10 = 2 + (var9 * 5);
					this.a(var1, var3, 0, 0, var10, 0, 1, var10, class_aim.aO.S(), class_aim.a.S(), false);
					this.a(var1, var3, 2, 0, var10, 2, 1, var10, class_aim.aO.S(), class_aim.a.S(), false);
					if (var2.nextInt(4) == 0) {
						this.a(var1, var3, 0, 2, var10, 0, 2, var10, class_aim.f.S(), class_aim.a.S(), false);
						this.a(var1, var3, 2, 2, var10, 2, 2, var10, class_aim.f.S(), class_aim.a.S(), false);
					} else {
						this.a(var1, var3, 0, 2, var10, 2, 2, var10, class_aim.f.S(), class_aim.a.S(), false);
					}

					this.a(var1, var3, var2, 0.1F, 0, 2, var10 - 1, class_aim.G.S());
					this.a(var1, var3, var2, 0.1F, 2, 2, var10 - 1, class_aim.G.S());
					this.a(var1, var3, var2, 0.1F, 0, 2, var10 + 1, class_aim.G.S());
					this.a(var1, var3, var2, 0.1F, 2, 2, var10 + 1, class_aim.G.S());
					this.a(var1, var3, var2, 0.05F, 0, 2, var10 - 2, class_aim.G.S());
					this.a(var1, var3, var2, 0.05F, 2, 2, var10 - 2, class_aim.G.S());
					this.a(var1, var3, var2, 0.05F, 0, 2, var10 + 2, class_aim.G.S());
					this.a(var1, var3, var2, 0.05F, 2, 2, var10 + 2, class_aim.G.S());
					this.a(var1, var3, var2, 0.05F, 1, 2, var10 - 1, class_aim.aa.S().a(class_anr.a, class_cq.d));
					this.a(var1, var3, var2, 0.05F, 1, 2, var10 + 1, class_aim.aa.S().a(class_anr.a, class_cq.c));
					if (var2.nextInt(100) == 0) {
						this.a(var1, var3, var2, 2, 0, var10 - 1, class_oj.a(class_aue.a, new class_oj[] { class_acq.ci.b(var2) }), 3 + var2.nextInt(4));
					}

					if (var2.nextInt(100) == 0) {
						this.a(var1, var3, var2, 0, 0, var10 + 1, class_oj.a(class_aue.a, new class_oj[] { class_acq.ci.b(var2) }), 3 + var2.nextInt(4));
					}

					if (b && !c) {
						int var11 = this.d(0);
						int var12 = (var10 - 1) + var2.nextInt(3);
						int var13 = this.a(1, var12);
						var12 = this.b(1, var12);
						class_cj var14 = new class_cj(var13, var11, var12);
						if (var3.b(var14)) {
							c = true;
							var1.a(var14, class_aim.ac.S(), 2);
							class_aoi var15 = var1.s(var14);
							if (var15 instanceof class_aox) {
								((class_aox) var15).b().a("CaveSpider");
							}
						}
					}
				}

				for (var9 = 0; var9 <= 2; ++var9) {
					for (var10 = 0; var10 <= var8; ++var10) {
						byte var17 = -1;
						class_apn var19 = this.a(var1, var9, var17, var10, var3);
						if (var19.c().v() == class_avq.a) {
							byte var20 = -1;
							this.a(var1, class_aim.f.S(), var9, var20, var10, var3);
						}
					}
				}

				if (a) {
					class_apn var16 = class_aim.av.S().a(class_ami.b, class_aih.class_b_in_class_aih.a);

					for (var10 = 0; var10 <= var8; ++var10) {
						class_apn var18 = this.a(var1, 1, -1, var10, var3);
						if ((var18.c().v() != class_avq.a) && var18.c().q()) {
							this.a(var1, var3, var2, 0.7F, 1, 0, var10, var16);
						}
					}
				}

				return true;
			}
		}
	}

	public static class class_c_in_class_aue extends class_aur {
		private List a = Lists.newLinkedList();

		public class_c_in_class_aue() {
		}

		public class_c_in_class_aue(int var1, Random var2, int var3, int var4) {
			super(var1);
			l = new class_aua(var3, 50, var4, var3 + 7 + var2.nextInt(6), 54 + var2.nextInt(6), var4 + 7 + var2.nextInt(6));
		}

		@Override
		public void a(class_aur var1, List var2, Random var3) {
			int var4 = this.d();
			int var6 = l.d() - 3 - 1;
			if (var6 <= 0) {
				var6 = 1;
			}

			int var5;
			class_aur var7;
			class_aua var8;
			for (var5 = 0; var5 < l.c(); var5 += 4) {
				var5 += var3.nextInt(l.c());
				if ((var5 + 3) > l.c()) {
					break;
				}

				var7 = class_aue.b(var1, var2, var3, l.a + var5, l.b + var3.nextInt(var6) + 1, l.c - 1, class_cq.c, var4);
				if (var7 != null) {
					var8 = var7.c();
					a.add(new class_aua(var8.a, var8.b, l.c, var8.d, var8.e, l.c + 1));
				}
			}

			for (var5 = 0; var5 < l.c(); var5 += 4) {
				var5 += var3.nextInt(l.c());
				if ((var5 + 3) > l.c()) {
					break;
				}

				var7 = class_aue.b(var1, var2, var3, l.a + var5, l.b + var3.nextInt(var6) + 1, l.f + 1, class_cq.d, var4);
				if (var7 != null) {
					var8 = var7.c();
					a.add(new class_aua(var8.a, var8.b, l.f - 1, var8.d, var8.e, l.f));
				}
			}

			for (var5 = 0; var5 < l.e(); var5 += 4) {
				var5 += var3.nextInt(l.e());
				if ((var5 + 3) > l.e()) {
					break;
				}

				var7 = class_aue.b(var1, var2, var3, l.a - 1, l.b + var3.nextInt(var6) + 1, l.c + var5, class_cq.e, var4);
				if (var7 != null) {
					var8 = var7.c();
					a.add(new class_aua(l.a, var8.b, var8.c, l.a + 1, var8.e, var8.f));
				}
			}

			for (var5 = 0; var5 < l.e(); var5 += 4) {
				var5 += var3.nextInt(l.e());
				if ((var5 + 3) > l.e()) {
					break;
				}

				var7 = class_aue.b(var1, var2, var3, l.d + 1, l.b + var3.nextInt(var6) + 1, l.c + var5, class_cq.f, var4);
				if (var7 != null) {
					var8 = var7.c();
					a.add(new class_aua(l.d - 1, var8.b, var8.c, l.d, var8.e, var8.f));
				}
			}

		}

		@Override
		public boolean a(class_ago var1, Random var2, class_aua var3) {
			if (this.a(var1, var3)) {
				return false;
			} else {
				this.a(var1, var3, l.a, l.b, l.c, l.d, l.b, l.f, class_aim.d.S(), class_aim.a.S(), true);
				this.a(var1, var3, l.a, l.b + 1, l.c, l.d, Math.min(l.b + 3, l.e), l.f, class_aim.a.S(), class_aim.a.S(), false);
				Iterator var4 = a.iterator();

				while (var4.hasNext()) {
					class_aua var5 = (class_aua) var4.next();
					this.a(var1, var3, var5.a, var5.e - 2, var5.c, var5.d, var5.e, var5.f, class_aim.a.S(), class_aim.a.S(), false);
				}

				this.a(var1, var3, l.a, l.b + 4, l.c, l.d, l.e, l.f, class_aim.a.S(), false);
				return true;
			}
		}

		@Override
		public void a(int var1, int var2, int var3) {
			super.a(var1, var2, var3);
			Iterator var4 = a.iterator();

			while (var4.hasNext()) {
				class_aua var5 = (class_aua) var4.next();
				var5.a(var1, var2, var3);
			}

		}

		@Override
		protected void a(class_dn var1) {
			class_du var2 = new class_du();
			Iterator var3 = a.iterator();

			while (var3.hasNext()) {
				class_aua var4 = (class_aua) var3.next();
				var2.a(var4.g());
			}

			var1.a("Entrances", var2);
		}

		@Override
		protected void b(class_dn var1) {
			class_du var2 = var1.c("Entrances", 11);

			for (int var3 = 0; var3 < var2.c(); ++var3) {
				a.add(new class_aua(var2.d(var3)));
			}

		}
	}
}
