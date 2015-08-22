package net.minecraft.server;

import java.util.Random;

public class class_akf extends class_aif {
	public static final class_aqb a = class_aqb.a("legacy_data", 0, 15);
	public static final class_aqa b = class_aqa.a("contents", class_akf.class_a_in_class_akf.class);

	public class_akf() {
		super(class_avq.q);
		this.j(M.b().a(b, class_akf.class_a_in_class_akf.a).a(a, Integer.valueOf(0)));
		this.j();
	}

	@Override
	public String f() {
		return class_di.a("item.flowerPot.name");
	}

	@Override
	public void j() {
		float var1 = 0.375F;
		float var2 = var1 / 2.0F;
		this.a(0.5F - var2, 0.0F, 0.5F - var2, 0.5F + var2, var1, 0.5F + var2);
	}

	@Override
	public boolean c() {
		return false;
	}

	@Override
	public int b() {
		return 3;
	}

	@Override
	public boolean d() {
		return false;
	}

	@Override
	public boolean a(class_ago var1, class_cj var2, class_apn var3, class_yu var4, class_pu var5, class_aco var6, class_cq var7, float var8, float var9, float var10) {
		if ((var6 != null) && (var6.b() instanceof class_abb)) {
			class_aos var11 = this.e(var1, var2);
			if (var11 == null) {
				return false;
			} else if (var11.c() != null) {
				return false;
			} else {
				class_ail var12 = class_ail.a(var6.b());
				if (!this.a(var12, var6.i())) {
					return false;
				} else {
					var11.a(var6.b(), var6.i());
					var11.o_();
					var1.h(var2);
					var4.b(class_nh.U);
					if (!var4.bI.d) {
						--var6.b;
					}

					return true;
				}
			}
		} else {
			return false;
		}
	}

	private boolean a(class_ail var1, int var2) {
		return (var1 != class_aim.N) && (var1 != class_aim.O) && (var1 != class_aim.aK) && (var1 != class_aim.P) && (var1 != class_aim.Q) && (var1 != class_aim.g) && (var1 != class_aim.I) ? (var1 == class_aim.H) && (var2 == class_ano.class_a_in_class_ano.c.a()) : true;
	}

	@Override
	public class_aco b(class_ago var1, class_cj var2, class_apn var3) {
		class_aos var4 = this.e(var1, var2);
		if (var4 != null) {
			class_aco var5 = var4.b();
			if (var5 != null) {
				return var5;
			}
		}

		return new class_aco(class_acq.bV);
	}

	@Override
	public boolean c(class_ago var1, class_cj var2) {
		return super.c(var1, var2) && class_ago.a(var1, var2.b());
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, class_ail var4) {
		if (!class_ago.a(var1, var2.b())) {
			this.b(var1, var2, var3, 0);
			var1.g(var2);
		}

	}

	@Override
	public void c(class_ago var1, class_cj var2, class_apn var3) {
		class_aos var4 = this.e(var1, var2);
		if ((var4 != null) && (var4.c() != null)) {
			a(var1, var2, new class_aco(var4.c(), 1, var4.d()));
		}

		super.c(var1, var2, var3);
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, class_yu var4) {
		super.a(var1, var2, var3, var4);
		if (var4.bI.d) {
			class_aos var5 = this.e(var1, var2);
			if (var5 != null) {
				var5.a((class_acm) null, 0);
			}
		}

	}

	@Override
	public class_acm a(class_apn var1, Random var2, int var3) {
		return class_acq.bV;
	}

	private class_aos e(class_ago var1, class_cj var2) {
		class_aoi var3 = var1.s(var2);
		return var3 instanceof class_aos ? (class_aos) var3 : null;
	}

	@Override
	public class_aoi a(class_ago var1, int var2) {
		Object var3 = null;
		int var4 = 0;
		switch (var2) {
			case 1:
				var3 = class_aim.O;
				var4 = class_ake.class_a_in_class_ake.b.b();
				break;
			case 2:
				var3 = class_aim.N;
				break;
			case 3:
				var3 = class_aim.g;
				var4 = class_aly.class_a_in_class_aly.a.a();
				break;
			case 4:
				var3 = class_aim.g;
				var4 = class_aly.class_a_in_class_aly.b.a();
				break;
			case 5:
				var3 = class_aim.g;
				var4 = class_aly.class_a_in_class_aly.c.a();
				break;
			case 6:
				var3 = class_aim.g;
				var4 = class_aly.class_a_in_class_aly.d.a();
				break;
			case 7:
				var3 = class_aim.Q;
				break;
			case 8:
				var3 = class_aim.P;
				break;
			case 9:
				var3 = class_aim.aK;
				break;
			case 10:
				var3 = class_aim.I;
				break;
			case 11:
				var3 = class_aim.H;
				var4 = class_ano.class_a_in_class_ano.c.a();
				break;
			case 12:
				var3 = class_aim.g;
				var4 = class_aly.class_a_in_class_aly.e.a();
				break;
			case 13:
				var3 = class_aim.g;
				var4 = class_aly.class_a_in_class_aly.f.a();
		}

		return new class_aos(class_acm.a((class_ail) var3), var4);
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { b, a });
	}

	@Override
	public int c(class_apn var1) {
		return ((Integer) var1.b(a)).intValue();
	}

	@Override
	public class_apn a(class_apn var1, class_ags var2, class_cj var3) {
		class_akf.class_a_in_class_akf var4 = class_akf.class_a_in_class_akf.a;
		class_aoi var5 = var2.s(var3);
		if (var5 instanceof class_aos) {
			class_aos var6 = (class_aos) var5;
			class_acm var7 = var6.c();
			if (var7 instanceof class_abb) {
				int var8 = var6.d();
				class_ail var9 = class_ail.a(var7);
				if (var9 == class_aim.g) {
					switch (class_akf.SyntheticClass_1.a[class_aly.class_a_in_class_aly.a(var8).ordinal()]) {
						case 1:
							var4 = class_akf.class_a_in_class_akf.l;
							break;
						case 2:
							var4 = class_akf.class_a_in_class_akf.m;
							break;
						case 3:
							var4 = class_akf.class_a_in_class_akf.n;
							break;
						case 4:
							var4 = class_akf.class_a_in_class_akf.o;
							break;
						case 5:
							var4 = class_akf.class_a_in_class_akf.p;
							break;
						case 6:
							var4 = class_akf.class_a_in_class_akf.q;
							break;
						default:
							var4 = class_akf.class_a_in_class_akf.a;
					}
				} else if (var9 == class_aim.H) {
					switch (var8) {
						case 0:
							var4 = class_akf.class_a_in_class_akf.t;
							break;
						case 2:
							var4 = class_akf.class_a_in_class_akf.u;
							break;
						default:
							var4 = class_akf.class_a_in_class_akf.a;
					}
				} else if (var9 == class_aim.N) {
					var4 = class_akf.class_a_in_class_akf.k;
				} else if (var9 == class_aim.O) {
					switch (class_akf.SyntheticClass_1.b[class_ake.class_a_in_class_ake.a(class_ake.class_b_in_class_ake.b, var8).ordinal()]) {
						case 1:
							var4 = class_akf.class_a_in_class_akf.b;
							break;
						case 2:
							var4 = class_akf.class_a_in_class_akf.c;
							break;
						case 3:
							var4 = class_akf.class_a_in_class_akf.d;
							break;
						case 4:
							var4 = class_akf.class_a_in_class_akf.e;
							break;
						case 5:
							var4 = class_akf.class_a_in_class_akf.f;
							break;
						case 6:
							var4 = class_akf.class_a_in_class_akf.g;
							break;
						case 7:
							var4 = class_akf.class_a_in_class_akf.h;
							break;
						case 8:
							var4 = class_akf.class_a_in_class_akf.i;
							break;
						case 9:
							var4 = class_akf.class_a_in_class_akf.j;
							break;
						default:
							var4 = class_akf.class_a_in_class_akf.a;
					}
				} else if (var9 == class_aim.Q) {
					var4 = class_akf.class_a_in_class_akf.r;
				} else if (var9 == class_aim.P) {
					var4 = class_akf.class_a_in_class_akf.s;
				} else if (var9 == class_aim.I) {
					var4 = class_akf.class_a_in_class_akf.t;
				} else if (var9 == class_aim.aK) {
					var4 = class_akf.class_a_in_class_akf.v;
				}
			}
		}

		return var1.a(b, var4);
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a;
		// $FF: synthetic field
		static final int[] b = new int[class_ake.class_a_in_class_ake.values().length];

		static {
			try {
				b[class_ake.class_a_in_class_ake.b.ordinal()] = 1;
			} catch (NoSuchFieldError var15) {
				;
			}

			try {
				b[class_ake.class_a_in_class_ake.c.ordinal()] = 2;
			} catch (NoSuchFieldError var14) {
				;
			}

			try {
				b[class_ake.class_a_in_class_ake.d.ordinal()] = 3;
			} catch (NoSuchFieldError var13) {
				;
			}

			try {
				b[class_ake.class_a_in_class_ake.e.ordinal()] = 4;
			} catch (NoSuchFieldError var12) {
				;
			}

			try {
				b[class_ake.class_a_in_class_ake.f.ordinal()] = 5;
			} catch (NoSuchFieldError var11) {
				;
			}

			try {
				b[class_ake.class_a_in_class_ake.g.ordinal()] = 6;
			} catch (NoSuchFieldError var10) {
				;
			}

			try {
				b[class_ake.class_a_in_class_ake.h.ordinal()] = 7;
			} catch (NoSuchFieldError var9) {
				;
			}

			try {
				b[class_ake.class_a_in_class_ake.i.ordinal()] = 8;
			} catch (NoSuchFieldError var8) {
				;
			}

			try {
				b[class_ake.class_a_in_class_ake.j.ordinal()] = 9;
			} catch (NoSuchFieldError var7) {
				;
			}

			a = new int[class_aly.class_a_in_class_aly.values().length];

			try {
				a[class_aly.class_a_in_class_aly.a.ordinal()] = 1;
			} catch (NoSuchFieldError var6) {
				;
			}

			try {
				a[class_aly.class_a_in_class_aly.b.ordinal()] = 2;
			} catch (NoSuchFieldError var5) {
				;
			}

			try {
				a[class_aly.class_a_in_class_aly.c.ordinal()] = 3;
			} catch (NoSuchFieldError var4) {
				;
			}

			try {
				a[class_aly.class_a_in_class_aly.d.ordinal()] = 4;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				a[class_aly.class_a_in_class_aly.e.ordinal()] = 5;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[class_aly.class_a_in_class_aly.f.ordinal()] = 6;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}

	public static enum class_a_in_class_akf implements class_oe {
		a("empty"),
		b("rose"),
		c("blue_orchid"),
		d("allium"),
		e("houstonia"),
		f("red_tulip"),
		g("orange_tulip"),
		h("white_tulip"),
		i("pink_tulip"),
		j("oxeye_daisy"),
		k("dandelion"),
		l("oak_sapling"),
		m("spruce_sapling"),
		n("birch_sapling"),
		o("jungle_sapling"),
		p("acacia_sapling"),
		q("dark_oak_sapling"),
		r("mushroom_red"),
		s("mushroom_brown"),
		t("dead_bush"),
		u("fern"),
		v("cactus");

		private final String w;

		private class_a_in_class_akf(String var3) {
			w = var3;
		}

		@Override
		public String toString() {
			return w;
		}

		@Override
		public String l() {
			return w;
		}
	}
}
