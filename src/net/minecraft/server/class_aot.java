package net.minecraft.server;


public class class_aot extends class_aow implements class_ks, class_qf {
	private static final int[] a = new int[] { 0 };
	private static final int[] f = new int[] { 2, 1 };
	private static final int[] g = new int[] { 1 };
	private class_aco[] h = new class_aco[3];
	private int i;
	private int j;
	private int k;
	private int l;
	private String m;

	@Override
	public int n_() {
		return h.length;
	}

	@Override
	public class_aco a(int var1) {
		return h[var1];
	}

	@Override
	public class_aco a(int var1, int var2) {
		if (h[var1] != null) {
			class_aco var3;
			if (h[var1].b <= var2) {
				var3 = h[var1];
				h[var1] = null;
				return var3;
			} else {
				var3 = h[var1].a(var2);
				if (h[var1].b == 0) {
					h[var1] = null;
				}

				return var3;
			}
		} else {
			return null;
		}
	}

	@Override
	public class_aco b(int var1) {
		if (h[var1] != null) {
			class_aco var2 = h[var1];
			h[var1] = null;
			return var2;
		} else {
			return null;
		}
	}

	@Override
	public void a(int var1, class_aco var2) {
		boolean var3 = (var2 != null) && var2.a(h[var1]) && class_aco.a(var2, h[var1]);
		h[var1] = var2;
		if ((var2 != null) && (var2.b > p_())) {
			var2.b = p_();
		}

		if ((var1 == 0) && !var3) {
			l = this.a(var2);
			k = 0;
			o_();
		}

	}

	@Override
	public String e_() {
		return k_() ? m : "container.furnace";
	}

	@Override
	public boolean k_() {
		return (m != null) && !m.isEmpty();
	}

	public void a(String var1) {
		m = var1;
	}

	@Override
	public void a(class_dn var1) {
		super.a(var1);
		class_du var2 = var1.c("Items", 10);
		h = new class_aco[n_()];

		for (int var3 = 0; var3 < var2.c(); ++var3) {
			class_dn var4 = var2.b(var3);
			byte var5 = var4.f("Slot");
			if ((var5 >= 0) && (var5 < h.length)) {
				h[var5] = class_aco.a(var4);
			}
		}

		i = var1.g("BurnTime");
		k = var1.g("CookTime");
		l = var1.g("CookTimeTotal");
		j = b(h[1]);
		if (var1.b("CustomName", 8)) {
			m = var1.l("CustomName");
		}

	}

	@Override
	public void b(class_dn var1) {
		super.b(var1);
		var1.a("BurnTime", (short) i);
		var1.a("CookTime", (short) k);
		var1.a("CookTimeTotal", (short) l);
		class_du var2 = new class_du();

		for (int var3 = 0; var3 < h.length; ++var3) {
			if (h[var3] != null) {
				class_dn var4 = new class_dn();
				var4.a("Slot", (byte) var3);
				h[var3].b(var4);
				var2.a(var4);
			}
		}

		var1.a("Items", var2);
		if (k_()) {
			var1.a("CustomName", m);
		}

	}

	@Override
	public int p_() {
		return 64;
	}

	public boolean m() {
		return i > 0;
	}

	@Override
	public void c() {
		boolean var1 = m();
		boolean var2 = false;
		if (m()) {
			--i;
		}

		if (!b.D) {
			if (!m() && ((h[1] == null) || (h[0] == null))) {
				if (!m() && (k > 0)) {
					k = class_oa.a(k - 2, 0, l);
				}
			} else {
				if (!m() && o()) {
					j = i = b(h[1]);
					if (m()) {
						var2 = true;
						if (h[1] != null) {
							--h[1].b;
							if (h[1].b == 0) {
								Item var3 = h[1].b().q();
								h[1] = var3 != null ? new class_aco(var3) : null;
							}
						}
					}
				}

				if (m() && o()) {
					++k;
					if (k == l) {
						k = 0;
						l = this.a(h[0]);
						n();
						var2 = true;
					}
				} else {
					k = 0;
				}
			}

			if (var1 != m()) {
				var2 = true;
				class_akj.a(m(), b, c);
			}
		}

		if (var2) {
			o_();
		}

	}

	public int a(class_aco var1) {
		return 200;
	}

	private boolean o() {
		if (h[0] == null) {
			return false;
		} else {
			class_aco var1 = class_aen.a().a(h[0]);
			return var1 == null ? false : (h[2] == null ? true : (!h[2].a(var1) ? false : ((h[2].b < p_()) && (h[2].b < h[2].c()) ? true : h[2].b < var1.c())));
		}
	}

	public void n() {
		if (o()) {
			class_aco var1 = class_aen.a().a(h[0]);
			if (h[2] == null) {
				h[2] = var1.k();
			} else if (h[2].b() == var1.b()) {
				++h[2].b;
			}

			if ((h[0].b() == Item.a(Blocks.SPONGE)) && (h[0].i() == 1) && (h[1] != null) && (h[1].b() == Items.ay)) {
				h[1] = new class_aco(Items.az);
			}

			--h[0].b;
			if (h[0].b <= 0) {
				h[0] = null;
			}

		}
	}

	public static int b(class_aco var0) {
		if (var0 == null) {
			return 0;
		} else {
			Item var1 = var0.b();
			if ((var1 instanceof class_abb) && (Block.a(var1) != Blocks.AIR)) {
				Block var2 = Block.a(var1);
				if (var2 == Blocks.WOODEN_SLAB) {
					return 150;
				}

				if (var2.v() == class_avq.d) {
					return 300;
				}

				if (var2 == Blocks.COAL_BLOCK) {
					return 16000;
				}
			}

			return (var1 instanceof class_abq) && ((class_abq) var1).h().equals("WOOD") ? 200 : ((var1 instanceof class_adv) && ((class_adv) var1).h().equals("WOOD") ? 200 : ((var1 instanceof class_acl) && ((class_acl) var1).g().equals("WOOD") ? 200 : (var1 == Items.A ? 100 : (var1 == Items.j ? 1600 : (var1 == Items.aA ? 20000 : (var1 == Item.a(Blocks.SAPLING) ? 100 : (var1 == Items.bx ? 2400 : 0)))))));
		}
	}

	public static boolean c(class_aco var0) {
		return b(var0) > 0;
	}

	@Override
	public boolean a(class_yu var1) {
		return b.s(c) != this ? false : var1.e(c.n() + 0.5D, c.o() + 0.5D, c.p() + 0.5D) <= 64.0D;
	}

	@Override
	public void b(class_yu var1) {
	}

	@Override
	public void c(class_yu var1) {
	}

	@Override
	public boolean b(int var1, class_aco var2) {
		return var1 == 2 ? false : (var1 != 1 ? true : c(var2) || class_aaf.c_(var2));
	}

	@Override
	public int[] a(class_cq var1) {
		return var1 == class_cq.a ? f : (var1 == class_cq.b ? a : g);
	}

	@Override
	public boolean a(int var1, class_aco var2, class_cq var3) {
		return this.b(var1, var2);
	}

	@Override
	public boolean b(int var1, class_aco var2, class_cq var3) {
		if ((var3 == class_cq.a) && (var1 == 1)) {
			Item var4 = var2.b();
			if ((var4 != Items.az) && (var4 != Items.ay)) {
				return false;
			}
		}

		return true;
	}

	@Override
	public String k() {
		return "minecraft:furnace";
	}

	@Override
	public class_zu a(class_yt var1, class_yu var2) {
		return new class_aag(var1, this);
	}

	@Override
	public int c(int var1) {
		switch (var1) {
			case 0:
				return i;
			case 1:
				return j;
			case 2:
				return k;
			case 3:
				return l;
			default:
				return 0;
		}
	}

	@Override
	public void b(int var1, int var2) {
		switch (var1) {
			case 0:
				i = var2;
				break;
			case 1:
				j = var2;
				break;
			case 2:
				k = var2;
				break;
			case 3:
				l = var2;
		}

	}

	@Override
	public int g() {
		return 4;
	}

	@Override
	public void l() {
		for (int var1 = 0; var1 < h.length; ++var1) {
			h[var1] = null;
		}

	}
}
