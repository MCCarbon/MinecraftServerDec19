package net.minecraft.server;

import java.util.Map;
import java.util.Random;
import java.util.UUID;

import com.google.common.base.Function;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;

public class class_acm {
	public static final class_cx e = new class_cx();
	private static final Map a = Maps.newHashMap();
	private static final class_acp b = new class_acp() {
	};
	private static final class_acp c = new class_acp() {
	};
	private static final class_acp d = new class_acp() {
	};
	private static final class_acp l = new class_acp() {
	};
	private final class_db m = new class_dd();
	protected static final UUID f = UUID.fromString("CB3F55D3-645C-4F38-A497-9C13A33DB5CF");
	protected static final UUID g = UUID.fromString("FA233E1C-4180-4865-B01B-BCCE9785ACA3");
	private class_abp n;
	protected static Random h = new Random();
	protected int i = 64;
	private int o;
	protected boolean j;
	protected boolean k;
	private class_acm p;
	private String q;

	public static int a(class_acm var0) {
		return var0 == null ? 0 : e.a(var0);
	}

	public static int b(class_acm var0) {
		return var0 == null ? 0 : e.a(var0);
	}

	public static class_acm c(int var0) {
		return (class_acm) e.a(var0);
	}

	public static class_acm a(class_ail var0) {
		return (class_acm) a.get(var0);
	}

	public static class_acm d(String var0) {
		class_acm var1 = (class_acm) e.c(new class_ke(var0));
		if (var1 == null) {
			try {
				return c(Integer.parseInt(var0));
			} catch (NumberFormatException var3) {
				;
			}
		}

		return var1;
	}

	public final void a(class_ke var1, class_acp var2) {
		m.a(var1, var2);
	}

	public boolean a(class_dn var1) {
		return false;
	}

	public class_acm() {
		this.a(new class_ke("lefthanded"), d);
		this.a(new class_ke("cooldown"), l);
	}

	public class_acm d(int var1) {
		i = var1;
		return this;
	}

	public class_pw a(class_aco var1, class_yu var2, class_ago var3, class_cj var4, class_pu var5, class_cq var6, float var7, float var8, float var9) {
		return class_pw.b;
	}

	public float a(class_aco var1, class_ail var2) {
		return 1.0F;
	}

	public class_px a(class_aco var1, class_ago var2, class_yu var3, class_pu var4) {
		return new class_px(class_pw.b, var1);
	}

	public class_aco a(class_aco var1, class_ago var2, class_rg var3) {
		return var1;
	}

	public int j() {
		return i;
	}

	public int a(int var1) {
		return 0;
	}

	public boolean k() {
		return k;
	}

	protected class_acm a(boolean var1) {
		k = var1;
		return this;
	}

	public int l() {
		return o;
	}

	protected class_acm e(int var1) {
		o = var1;
		if (var1 > 0) {
			this.a(new class_ke("damaged"), b);
			this.a(new class_ke("damage"), c);
		}

		return this;
	}

	public boolean m() {
		return (o > 0) && !k;
	}

	public boolean a(class_aco var1, class_rg var2, class_rg var3) {
		return false;
	}

	public boolean a(class_aco var1, class_ago var2, class_ail var3, class_cj var4, class_rg var5) {
		return false;
	}

	public boolean b(class_ail var1) {
		return false;
	}

	public boolean a(class_aco var1, class_yu var2, class_rg var3, class_pu var4) {
		return false;
	}

	public class_acm n() {
		j = true;
		return this;
	}

	public class_acm c(String var1) {
		q = var1;
		return this;
	}

	public String j(class_aco var1) {
		String var2 = e_(var1);
		return var2 == null ? "" : class_di.a(var2);
	}

	public String a() {
		return "item." + q;
	}

	public String e_(class_aco var1) {
		return "item." + q;
	}

	public class_acm c(class_acm var1) {
		p = var1;
		return this;
	}

	public boolean p() {
		return true;
	}

	public class_acm q() {
		return p;
	}

	public boolean r() {
		return p != null;
	}

	public void a(class_aco var1, class_ago var2, class_qx var3, int var4, boolean var5) {
	}

	public void b(class_aco var1, class_ago var2, class_yu var3) {
	}

	public boolean f() {
		return false;
	}

	public class_ady f(class_aco var1) {
		return class_ady.a;
	}

	public int e(class_aco var1) {
		return 0;
	}

	public void a(class_aco var1, class_ago var2, class_rg var3, int var4) {
	}

	public String a(class_aco var1) {
		return ("" + class_di.a(this.j(var1) + ".name")).trim();
	}

	public class_adc g(class_aco var1) {
		return var1.w() ? class_adc.c : class_adc.a;
	}

	public boolean f_(class_aco var1) {
		return (this.j() == 1) && m();
	}

	protected class_ayl a(class_ago var1, class_yu var2, boolean var3) {
		float var4 = var2.z;
		float var5 = var2.y;
		double var6 = var2.s;
		double var8 = var2.t + var2.aY();
		double var10 = var2.u;
		class_aym var12 = new class_aym(var6, var8, var10);
		float var13 = class_oa.b((-var5 * 0.017453292F) - 3.1415927F);
		float var14 = class_oa.a((-var5 * 0.017453292F) - 3.1415927F);
		float var15 = -class_oa.b(-var4 * 0.017453292F);
		float var16 = class_oa.a(-var4 * 0.017453292F);
		float var17 = var14 * var15;
		float var19 = var13 * var15;
		double var20 = 5.0D;
		class_aym var22 = var12.b(var17 * var20, var16 * var20, var19 * var20);
		return var1.a(var12, var22, var3, !var3, false);
	}

	public int c() {
		return 0;
	}

	public class_acm a(class_abp var1) {
		n = var1;
		return this;
	}

	public boolean s() {
		return false;
	}

	public boolean a(class_aco var1, class_aco var2) {
		return false;
	}

	public Multimap a(class_rc var1) {
		return HashMultimap.create();
	}

	public static void t() {
		a(class_aim.b, (new class_acx(class_aim.b, class_aim.b, new Function() {
			public String a(class_aco var1) {
				return class_anj.class_a_in_class_anj.a(var1.i()).d();
			}

			// $FF: synthetic method
			@Override
			public Object apply(Object var1) {
				return this.a((class_aco) var1);
			}
		})).b("stone"));
		a(class_aim.c, (new class_adw(class_aim.c, false)));
		a(class_aim.d, (new class_acx(class_aim.d, class_aim.d, new Function() {
			public String a(class_aco var1) {
				return class_ajl.class_a_in_class_ajl.a(var1.i()).c();
			}

			// $FF: synthetic method
			@Override
			public Object apply(Object var1) {
				return this.a((class_aco) var1);
			}
		})).b("dirt"));
		c(class_aim.e);
		a(class_aim.f, (new class_acx(class_aim.f, class_aim.f, new Function() {
			public String a(class_aco var1) {
				return class_aly.class_a_in_class_aly.a(var1.i()).d();
			}

			// $FF: synthetic method
			@Override
			public Object apply(Object var1) {
				return this.a((class_aco) var1);
			}
		})).b("wood"));
		a(class_aim.g, (new class_acx(class_aim.g, class_aim.g, new Function() {
			public String a(class_aco var1) {
				return class_aly.class_a_in_class_aly.a(var1.i()).d();
			}

			// $FF: synthetic method
			@Override
			public Object apply(Object var1) {
				return this.a((class_aco) var1);
			}
		})).b("sapling"));
		c(class_aim.h);
		a(class_aim.m, (new class_acx(class_aim.m, class_aim.m, new Function() {
			public String a(class_aco var1) {
				return class_ams.class_a_in_class_ams.a(var1.i()).d();
			}

			// $FF: synthetic method
			@Override
			public Object apply(Object var1) {
				return this.a((class_aco) var1);
			}
		})).b("sand"));
		c(class_aim.n);
		c(class_aim.o);
		c(class_aim.p);
		c(class_aim.q);
		a(class_aim.r, (new class_acx(class_aim.r, class_aim.r, new Function() {
			public String a(class_aco var1) {
				return class_aly.class_a_in_class_aly.a(var1.i()).d();
			}

			// $FF: synthetic method
			@Override
			public Object apply(Object var1) {
				return this.a((class_aco) var1);
			}
		})).b("log"));
		a(class_aim.s, (new class_acx(class_aim.s, class_aim.s, new Function() {
			public String a(class_aco var1) {
				return class_aly.class_a_in_class_aly.a(var1.i() + 4).d();
			}

			// $FF: synthetic method
			@Override
			public Object apply(Object var1) {
				return this.a((class_aco) var1);
			}
		})).b("log"));
		a(class_aim.t, (new class_acs(class_aim.t)).b("leaves"));
		a(class_aim.u, (new class_acs(class_aim.u)).b("leaves"));
		a(class_aim.v, (new class_acx(class_aim.v, class_aim.v, new Function() {
			public String a(class_aco var1) {
				return (var1.i() & 1) == 1 ? "wet" : "dry";
			}

			// $FF: synthetic method
			@Override
			public Object apply(Object var1) {
				return this.a((class_aco) var1);
			}
		})).b("sponge"));
		c(class_aim.w);
		c(class_aim.x);
		c(class_aim.y);
		c(class_aim.z);
		a(class_aim.A, (new class_acx(class_aim.A, class_aim.A, new Function() {
			public String a(class_aco var1) {
				return class_amt.class_a_in_class_amt.a(var1.i()).c();
			}

			// $FF: synthetic method
			@Override
			public Object apply(Object var1) {
				return this.a((class_aco) var1);
			}
		})).b("sandStone"));
		c(class_aim.B);
		c(class_aim.D);
		c(class_aim.E);
		a(class_aim.F, (new class_ada(class_aim.F)));
		c(class_aim.G);
		a(class_aim.H, (new class_adw(class_aim.H, true)).a(new String[] { "shrub", "grass", "fern" }));
		c(class_aim.I);
		a(class_aim.J, (new class_ada(class_aim.J)));
		a(class_aim.L, (new class_abv(class_aim.L)).b("cloth"));
		a(class_aim.N, (new class_acx(class_aim.N, class_aim.N, new Function() {
			public String a(class_aco var1) {
				return class_ake.class_a_in_class_ake.a(class_ake.class_b_in_class_ake.a, var1.i()).d();
			}

			// $FF: synthetic method
			@Override
			public Object apply(Object var1) {
				return this.a((class_aco) var1);
			}
		})).b("flower"));
		a(class_aim.O, (new class_acx(class_aim.O, class_aim.O, new Function() {
			public String a(class_aco var1) {
				return class_ake.class_a_in_class_ake.a(class_ake.class_b_in_class_ake.b, var1.i()).d();
			}

			// $FF: synthetic method
			@Override
			public Object apply(Object var1) {
				return this.a((class_aco) var1);
			}
		})).b("rose"));
		c(class_aim.P);
		c(class_aim.Q);
		c(class_aim.R);
		c(class_aim.S);
		a(class_aim.U, (new class_adp(class_aim.U, class_aim.U, class_aim.T)).b("stoneSlab"));
		c(class_aim.V);
		c(class_aim.W);
		c(class_aim.X);
		c(class_aim.Y);
		c(class_aim.Z);
		c(class_aim.aa);
		c(class_aim.cQ);
		c(class_aim.cR);
		c(class_aim.cS);
		c(class_aim.cT);
		c(class_aim.cU);
		c(class_aim.cV);
		a(class_aim.cX, (new class_adp(class_aim.cX, class_aim.cX, class_aim.cW)).b("purpurSlab"));
		c(class_aim.ac);
		c(class_aim.ad);
		c(class_aim.ae);
		c(class_aim.ag);
		c(class_aim.ah);
		c(class_aim.ai);
		c(class_aim.ak);
		c(class_aim.al);
		c(class_aim.am);
		c(class_aim.au);
		c(class_aim.av);
		c(class_aim.aw);
		c(class_aim.ay);
		c(class_aim.az);
		c(class_aim.aB);
		c(class_aim.aC);
		c(class_aim.aF);
		c(class_aim.aG);
		a(class_aim.aH, (new class_adq(class_aim.aH)));
		c(class_aim.aI);
		c(class_aim.aJ);
		c(class_aim.aK);
		c(class_aim.aL);
		c(class_aim.aN);
		c(class_aim.aO);
		c(class_aim.aP);
		c(class_aim.aQ);
		c(class_aim.aR);
		c(class_aim.aS);
		c(class_aim.aT);
		c(class_aim.aU);
		c(class_aim.aV);
		c(class_aim.aW);
		c(class_aim.aX);
		c(class_aim.aZ);
		c(class_aim.bd);
		a(class_aim.be, (new class_acx(class_aim.be, class_aim.be, new Function() {
			public String a(class_aco var1) {
				return class_alj.class_a_in_class_alj.a(var1.i()).c();
			}

			// $FF: synthetic method
			@Override
			public Object apply(Object var1) {
				return this.a((class_aco) var1);
			}
		})).b("monsterStoneEgg"));
		a(class_aim.bf, (new class_acx(class_aim.bf, class_aim.bf, new Function() {
			public String a(class_aco var1) {
				return class_ank.class_a_in_class_ank.a(var1.i()).c();
			}

			// $FF: synthetic method
			@Override
			public Object apply(Object var1) {
				return this.a((class_aco) var1);
			}
		})).b("stonebricksmooth"));
		c(class_aim.bg);
		c(class_aim.bh);
		c(class_aim.bi);
		c(class_aim.bj);
		c(class_aim.bk);
		a(class_aim.bn, (new class_adw(class_aim.bn, false)));
		c(class_aim.bo);
		c(class_aim.bp);
		c(class_aim.bq);
		c(class_aim.br);
		c(class_aim.bs);
		c(class_aim.bt);
		c(class_aim.bu);
		c(class_aim.bv);
		c(class_aim.bw);
		a(class_aim.bx, (new class_adz(class_aim.bx)));
		c(class_aim.by);
		c(class_aim.bz);
		c(class_aim.bA);
		c(class_aim.bC);
		c(class_aim.bG);
		c(class_aim.bH);
		c(class_aim.cY);
		c(class_aim.bI);
		c(class_aim.bJ);
		a(class_aim.bM, (new class_adp(class_aim.bM, class_aim.bM, class_aim.bL)).b("woodSlab"));
		c(class_aim.bO);
		c(class_aim.bP);
		c(class_aim.bQ);
		c(class_aim.bR);
		c(class_aim.bT);
		c(class_aim.bU);
		c(class_aim.bV);
		c(class_aim.bW);
		c(class_aim.bX);
		c(class_aim.bY);
		a(class_aim.bZ, (new class_acx(class_aim.bZ, class_aim.bZ, new Function() {
			public String a(class_aco var1) {
				return class_anx.class_a_in_class_anx.a(var1.i()).c();
			}

			// $FF: synthetic method
			@Override
			public Object apply(Object var1) {
				return this.a((class_aco) var1);
			}
		})).b("cobbleWall"));
		c(class_aim.cd);
		a(class_aim.cf, (new class_aau(class_aim.cf)).b("anvil"));
		c(class_aim.cg);
		c(class_aim.ch);
		c(class_aim.ci);
		c(class_aim.cl);
		c(class_aim.cn);
		c(class_aim.co);
		c(class_aim.cp);
		a(class_aim.cq, (new class_acx(class_aim.cq, class_aim.cq, new String[] { "default", "chiseled", "lines" })).b("quartzBlock"));
		c(class_aim.cr);
		c(class_aim.cs);
		c(class_aim.ct);
		a(class_aim.cu, (new class_abv(class_aim.cu)).b("clayHardenedStained"));
		c(class_aim.cv);
		c(class_aim.cw);
		c(class_aim.cx);
		a(class_aim.cy, (new class_abv(class_aim.cy)).b("woolCarpet"));
		c(class_aim.cz);
		c(class_aim.cA);
		c(class_aim.cB);
		c(class_aim.cC);
		c(class_aim.cD);
		c(class_aim.cE);
		c(class_aim.da);
		a(class_aim.cF, (new class_abs(class_aim.cF, class_aim.cF, new Function() {
			public String a(class_aco var1) {
				return class_ajo.class_b_in_class_ajo.a(var1.i()).c();
			}

			// $FF: synthetic method
			@Override
			public Object apply(Object var1) {
				return this.a((class_aco) var1);
			}
		})).b("doublePlant"));
		a(class_aim.cG, (new class_abv(class_aim.cG)).b("stainedGlass"));
		a(class_aim.cH, (new class_abv(class_aim.cH)).b("stainedGlassPane"));
		a(class_aim.cI, (new class_acx(class_aim.cI, class_aim.cI, new Function() {
			public String a(class_aco var1) {
				return class_ame.class_a_in_class_ame.a(var1.i()).c();
			}

			// $FF: synthetic method
			@Override
			public Object apply(Object var1) {
				return this.a((class_aco) var1);
			}
		})).b("prismarine"));
		c(class_aim.cJ);
		a(class_aim.cM, (new class_acx(class_aim.cM, class_aim.cM, new Function() {
			public String a(class_aco var1) {
				return class_amk.class_a_in_class_amk.a(var1.i()).c();
			}

			// $FF: synthetic method
			@Override
			public Object apply(Object var1) {
				return this.a((class_aco) var1);
			}
		})).b("redSandStone"));
		c(class_aim.cN);
		a(class_aim.cP, (new class_adp(class_aim.cP, class_aim.cP, class_aim.cO)).b("stoneSlab2"));
		c(class_aim.dc);
		c(class_aim.dd);
		a(256, "iron_shovel", (new class_adl(class_acm.class_a_in_class_acm.c)).c("shovelIron"));
		a(257, "iron_pickaxe", (new class_acz(class_acm.class_a_in_class_acm.c)).c("pickaxeIron"));
		a(258, "iron_axe", (new class_aay(class_acm.class_a_in_class_acm.c)).c("hatchetIron"));
		a(259, "flint_and_steel", (new class_ach()).c("flintAndSteel"));
		a(260, "apple", (new class_aci(4, 0.3F, false)).c("apple"));
		a(261, "bow", (new class_abg()).c("bow"));
		a(262, "arrow", (new class_aax()).c("arrow"));
		a(263, "coal", (new class_abm()).c("coal"));
		a(264, "diamond", (new class_acm()).c("diamond").a(class_abp.l));
		a(265, "iron_ingot", (new class_acm()).c("ingotIron").a(class_abp.l));
		a(266, "gold_ingot", (new class_acm()).c("ingotGold").a(class_abp.l));
		a(267, "iron_sword", (new class_adv(class_acm.class_a_in_class_acm.c)).c("swordIron"));
		a(268, "wooden_sword", (new class_adv(class_acm.class_a_in_class_acm.a)).c("swordWood"));
		a(269, "wooden_shovel", (new class_adl(class_acm.class_a_in_class_acm.a)).c("shovelWood"));
		a(270, "wooden_pickaxe", (new class_acz(class_acm.class_a_in_class_acm.a)).c("pickaxeWood"));
		a(271, "wooden_axe", (new class_aay(class_acm.class_a_in_class_acm.a)).c("hatchetWood"));
		a(272, "stone_sword", (new class_adv(class_acm.class_a_in_class_acm.b)).c("swordStone"));
		a(273, "stone_shovel", (new class_adl(class_acm.class_a_in_class_acm.b)).c("shovelStone"));
		a(274, "stone_pickaxe", (new class_acz(class_acm.class_a_in_class_acm.b)).c("pickaxeStone"));
		a(275, "stone_axe", (new class_aay(class_acm.class_a_in_class_acm.b)).c("hatchetStone"));
		a(276, "diamond_sword", (new class_adv(class_acm.class_a_in_class_acm.d)).c("swordDiamond"));
		a(277, "diamond_shovel", (new class_adl(class_acm.class_a_in_class_acm.d)).c("shovelDiamond"));
		a(278, "diamond_pickaxe", (new class_acz(class_acm.class_a_in_class_acm.d)).c("pickaxeDiamond"));
		a(279, "diamond_axe", (new class_aay(class_acm.class_a_in_class_acm.d)).c("hatchetDiamond"));
		a(280, "stick", (new class_acm()).n().c("stick").a(class_abp.l));
		a(281, "bowl", (new class_acm()).c("bowl").a(class_abp.l));
		a(282, "mushroom_stew", (new class_abh(6)).c("mushroomStew"));
		a(283, "golden_sword", (new class_adv(class_acm.class_a_in_class_acm.e)).c("swordGold"));
		a(284, "golden_shovel", (new class_adl(class_acm.class_a_in_class_acm.e)).c("shovelGold"));
		a(285, "golden_pickaxe", (new class_acz(class_acm.class_a_in_class_acm.e)).c("pickaxeGold"));
		a(286, "golden_axe", (new class_aay(class_acm.class_a_in_class_acm.e)).c("hatchetGold"));
		a(287, "string", (new class_abc(class_aim.bS)).c("string").a(class_abp.l));
		a(288, "feather", (new class_acm()).c("feather").a(class_abp.l));
		a(289, "gunpowder", (new class_acm()).c("sulphur").a(class_abp.l));
		a(290, "wooden_hoe", (new class_acl(class_acm.class_a_in_class_acm.a)).c("hoeWood"));
		a(291, "stone_hoe", (new class_acl(class_acm.class_a_in_class_acm.b)).c("hoeStone"));
		a(292, "iron_hoe", (new class_acl(class_acm.class_a_in_class_acm.c)).c("hoeIron"));
		a(293, "diamond_hoe", (new class_acl(class_acm.class_a_in_class_acm.d)).c("hoeDiamond"));
		a(294, "golden_hoe", (new class_acl(class_acm.class_a_in_class_acm.e)).c("hoeGold"));
		a(295, "wheat_seeds", (new class_adh(class_aim.aj, class_aim.ak)).c("seeds"));
		a(296, "wheat", (new class_acm()).c("wheat").a(class_abp.l));
		a(297, "bread", (new class_aci(5, 0.6F, false)).c("bread"));
		a(298, "leather_helmet", (new class_aav(class_aav.class_a_in_class_aav.a, 0, class_rc.f)).c("helmetCloth"));
		a(299, "leather_chestplate", (new class_aav(class_aav.class_a_in_class_aav.a, 0, class_rc.e)).c("chestplateCloth"));
		a(300, "leather_leggings", (new class_aav(class_aav.class_a_in_class_aav.a, 0, class_rc.d)).c("leggingsCloth"));
		a(301, "leather_boots", (new class_aav(class_aav.class_a_in_class_aav.a, 0, class_rc.c)).c("bootsCloth"));
		a(302, "chainmail_helmet", (new class_aav(class_aav.class_a_in_class_aav.b, 1, class_rc.f)).c("helmetChain"));
		a(303, "chainmail_chestplate", (new class_aav(class_aav.class_a_in_class_aav.b, 1, class_rc.e)).c("chestplateChain"));
		a(304, "chainmail_leggings", (new class_aav(class_aav.class_a_in_class_aav.b, 1, class_rc.d)).c("leggingsChain"));
		a(305, "chainmail_boots", (new class_aav(class_aav.class_a_in_class_aav.b, 1, class_rc.c)).c("bootsChain"));
		a(306, "iron_helmet", (new class_aav(class_aav.class_a_in_class_aav.c, 2, class_rc.f)).c("helmetIron"));
		a(307, "iron_chestplate", (new class_aav(class_aav.class_a_in_class_aav.c, 2, class_rc.e)).c("chestplateIron"));
		a(308, "iron_leggings", (new class_aav(class_aav.class_a_in_class_aav.c, 2, class_rc.d)).c("leggingsIron"));
		a(309, "iron_boots", (new class_aav(class_aav.class_a_in_class_aav.c, 2, class_rc.c)).c("bootsIron"));
		a(310, "diamond_helmet", (new class_aav(class_aav.class_a_in_class_aav.e, 3, class_rc.f)).c("helmetDiamond"));
		a(311, "diamond_chestplate", (new class_aav(class_aav.class_a_in_class_aav.e, 3, class_rc.e)).c("chestplateDiamond"));
		a(312, "diamond_leggings", (new class_aav(class_aav.class_a_in_class_aav.e, 3, class_rc.d)).c("leggingsDiamond"));
		a(313, "diamond_boots", (new class_aav(class_aav.class_a_in_class_aav.e, 3, class_rc.c)).c("bootsDiamond"));
		a(314, "golden_helmet", (new class_aav(class_aav.class_a_in_class_aav.d, 4, class_rc.f)).c("helmetGold"));
		a(315, "golden_chestplate", (new class_aav(class_aav.class_a_in_class_aav.d, 4, class_rc.e)).c("chestplateGold"));
		a(316, "golden_leggings", (new class_aav(class_aav.class_a_in_class_aav.d, 4, class_rc.d)).c("leggingsGold"));
		a(317, "golden_boots", (new class_aav(class_aav.class_a_in_class_aav.d, 4, class_rc.c)).c("bootsGold"));
		a(318, "flint", (new class_acm()).c("flint").a(class_abp.l));
		a(319, "porkchop", (new class_aci(3, 0.3F, true)).c("porkchopRaw"));
		a(320, "cooked_porkchop", (new class_aci(8, 0.8F, true)).c("porkchopCooked"));
		a(321, "painting", (new class_ack(class_ww.class)).c("painting"));
		a(322, "golden_apple", (new class_acj(4, 1.2F, false)).h().a(new class_qr(class_qs.j, 100, 1), 1.0F).c("appleGold"));
		a(323, "sign", (new class_adm()).c("sign"));
		a(324, "wooden_door", (new class_abr(class_aim.ao)).c("doorOak"));
		class_acm var0 = (new class_abi(class_aim.a)).c("bucket").d(16);
		a(325, "bucket", var0);
		a(326, "water_bucket", (new class_abi(class_aim.i)).c("bucketWater").c(var0));
		a(327, "lava_bucket", (new class_abi(class_aim.k)).c("bucketLava").c(var0));
		a(328, "minecart", (new class_acw(class_xh.class_a_in_class_xh.a)).c("minecart"));
		a(329, "saddle", (new class_adf()).c("saddle"));
		a(330, "iron_door", (new class_abr(class_aim.aA)).c("doorIron"));
		a(331, "redstone", (new class_ade()).c("redstone"));
		a(332, "snowball", (new class_adr()).c("snowball"));
		a(333, "boat", (new class_abd()).c("boat"));
		a(334, "leather", (new class_acm()).c("leather").a(class_abp.l));
		a(335, "milk_bucket", (new class_acv()).c("milk").c(var0));
		a(336, "brick", (new class_acm()).c("brick").a(class_abp.l));
		a(337, "clay_ball", (new class_acm()).c("clay").a(class_abp.l));
		a(338, "reeds", (new class_abc(class_aim.aM)).c("reeds").a(class_abp.l));
		a(339, "paper", (new class_acm()).c("paper").a(class_abp.f));
		a(340, "book", (new class_abe()).c("book").a(class_abp.f));
		a(341, "slime_ball", (new class_acm()).c("slimeball").a(class_abp.f));
		a(342, "chest_minecart", (new class_acw(class_xh.class_a_in_class_xh.b)).c("minecartChest"));
		a(343, "furnace_minecart", (new class_acw(class_xh.class_a_in_class_xh.c)).c("minecartFurnace"));
		a(344, "egg", (new class_abw()).c("egg"));
		a(345, "compass", (new class_abn()).c("compass").a(class_abp.i));
		a(346, "fishing_rod", (new class_acg()).c("fishingRod"));
		a(347, "clock", (new class_abl()).c("clock").a(class_abp.i));
		a(348, "glowstone_dust", (new class_acm()).c("yellowDust").a(class_abp.l));
		a(349, "fish", (new class_acf(false)).c("fish").a(true));
		a(350, "cooked_fish", (new class_acf(true)).c("fish").a(true));
		a(351, "dye", (new class_abu()).c("dyePowder"));
		a(352, "bone", (new class_acm()).c("bone").n().a(class_abp.f));
		a(353, "sugar", (new class_acm()).c("sugar").a(class_abp.l));
		a(354, "cake", (new class_abc(class_aim.ba)).d(1).c("cake").a(class_abp.h));
		a(355, "bed", (new class_aba()).d(1).c("bed"));
		a(356, "repeater", (new class_abc(class_aim.bb)).c("diode").a(class_abp.d));
		a(357, "cookie", (new class_aci(2, 0.1F, false)).c("cookie"));
		a(358, "filled_map", (new class_acu()).c("map"));
		a(359, "shears", (new class_adj()).c("shears"));
		a(360, "melon", (new class_aci(2, 0.3F, false)).c("melon"));
		a(361, "pumpkin_seeds", (new class_adh(class_aim.bl, class_aim.ak)).c("seeds_pumpkin"));
		a(362, "melon_seeds", (new class_adh(class_aim.bm, class_aim.ak)).c("seeds_melon"));
		a(363, "beef", (new class_aci(3, 0.3F, true)).c("beefRaw"));
		a(364, "cooked_beef", (new class_aci(8, 0.8F, true)).c("beefCooked"));
		a(365, "chicken", (new class_aci(2, 0.3F, true)).a(new class_qr(class_qs.q, 600, 0), 0.3F).c("chickenRaw"));
		a(366, "cooked_chicken", (new class_aci(6, 0.6F, true)).c("chickenCooked"));
		a(367, "rotten_flesh", (new class_aci(4, 0.1F, true)).a(new class_qr(class_qs.q, 600, 0), 0.8F).c("rottenFlesh"));
		a(368, "ender_pearl", (new class_aca()).c("enderPearl"));
		a(369, "blaze_rod", (new class_acm()).c("blazeRod").a(class_abp.l).n());
		a(370, "ghast_tear", (new class_acm()).c("ghastTear").a(class_abp.k));
		a(371, "gold_nugget", (new class_acm()).c("goldNugget").a(class_abp.l));
		a(372, "nether_wart", (new class_adh(class_aim.bB, class_aim.aW)).c("netherStalkSeeds"));
		a(373, "potion", (new class_adb()).c("potion"));
		class_acm var1 = (new class_abf()).c("glassBottle");
		a(374, "glass_bottle", var1);
		a(375, "spider_eye", (new class_aci(2, 0.8F, false)).a(new class_qr(class_qs.s, 100, 0), 1.0F).c("spiderEye"));
		a(376, "fermented_spider_eye", (new class_acm()).c("fermentedSpiderEye").a(class_abp.k));
		a(377, "blaze_powder", (new class_acm()).c("blazePowder").a(class_abp.k));
		a(378, "magma_cream", (new class_acm()).c("magmaCream").a(class_abp.k));
		a(379, "brewing_stand", (new class_abc(class_aim.bD)).c("brewingStand").a(class_abp.k));
		a(380, "cauldron", (new class_abc(class_aim.bE)).c("cauldron").a(class_abp.k));
		a(381, "ender_eye", (new class_abz()).c("eyeOfEnder"));
		a(382, "speckled_melon", (new class_acm()).c("speckledMelon").a(class_abp.k));
		a(383, "spawn_egg", (new class_ads()).c("monsterPlacer"));
		a(384, "experience_bottle", (new class_acb()).c("expBottle"));
		a(385, "fire_charge", (new class_acc()).c("fireball"));
		a(386, "writable_book", (new class_aea()).c("writingBook").a(class_abp.f));
		a(387, "written_book", (new class_aeb()).c("writtenBook").d(16));
		a(388, "emerald", (new class_acm()).c("emerald").a(class_abp.l));
		a(389, "item_frame", (new class_ack(class_wu.class)).c("frame"));
		a(390, "flower_pot", (new class_abc(class_aim.ca)).c("flowerPot").a(class_abp.c));
		a(391, "carrot", (new class_adg(3, 0.6F, class_aim.cb, class_aim.ak)).c("carrots"));
		a(392, "potato", (new class_adg(1, 0.3F, class_aim.cc, class_aim.ak)).c("potato"));
		a(393, "baked_potato", (new class_aci(5, 0.6F, false)).c("potatoBaked"));
		a(394, "poisonous_potato", (new class_aci(2, 0.3F, false)).a(new class_qr(class_qs.s, 100, 0), 0.6F).c("potatoPoisonous"));
		a(395, "map", (new class_abx()).c("emptyMap"));
		a(396, "golden_carrot", (new class_aci(6, 1.2F, false)).c("carrotGolden").a(class_abp.k));
		a(397, "skull", (new class_ado()).c("skull"));
		a(398, "carrot_on_a_stick", (new class_abj()).c("carrotOnAStick"));
		a(399, "nether_star", (new class_adn()).c("netherStar").a(class_abp.l));
		a(400, "pumpkin_pie", (new class_aci(8, 0.3F, false)).c("pumpkinPie").a(class_abp.h));
		a(401, "fireworks", (new class_ace()).c("fireworks"));
		a(402, "firework_charge", (new class_acd()).c("fireworksCharge").a(class_abp.f));
		a(403, "enchanted_book", (new class_aby()).d(1).c("enchantedBook"));
		a(404, "comparator", (new class_abc(class_aim.cj)).c("comparator").a(class_abp.d));
		a(405, "netherbrick", (new class_acm()).c("netherbrick").a(class_abp.l));
		a(406, "quartz", (new class_acm()).c("netherquartz").a(class_abp.l));
		a(407, "tnt_minecart", (new class_acw(class_xh.class_a_in_class_xh.d)).c("minecartTnt"));
		a(408, "hopper_minecart", (new class_acw(class_xh.class_a_in_class_xh.f)).c("minecartHopper"));
		a(409, "prismarine_shard", (new class_acm()).c("prismarineShard").a(class_abp.l));
		a(410, "prismarine_crystals", (new class_acm()).c("prismarineCrystals").a(class_abp.l));
		a(411, "rabbit", (new class_aci(3, 0.3F, true)).c("rabbitRaw"));
		a(412, "cooked_rabbit", (new class_aci(5, 0.6F, true)).c("rabbitCooked"));
		a(413, "rabbit_stew", (new class_abh(10)).c("rabbitStew"));
		a(414, "rabbit_foot", (new class_acm()).c("rabbitFoot").a(class_abp.k));
		a(415, "rabbit_hide", (new class_acm()).c("rabbitHide").a(class_abp.l));
		a(416, "armor_stand", (new class_aaw()).c("armorStand").d(16));
		a(417, "iron_horse_armor", (new class_acm()).c("horsearmormetal").d(1).a(class_abp.f));
		a(418, "golden_horse_armor", (new class_acm()).c("horsearmorgold").d(1).a(class_abp.f));
		a(419, "diamond_horse_armor", (new class_acm()).c("horsearmordiamond").d(1).a(class_abp.f));
		a(420, "lead", (new class_acr()).c("leash"));
		a(421, "name_tag", (new class_acy()).c("nameTag"));
		a(422, "command_block_minecart", (new class_acw(class_xh.class_a_in_class_xh.g)).c("minecartCommandBlock").a((class_abp) null));
		a(423, "mutton", (new class_aci(2, 0.3F, true)).c("muttonRaw"));
		a(424, "cooked_mutton", (new class_aci(6, 0.8F, true)).c("muttonCooked"));
		a(425, "banner", (new class_aaz()).b("banner"));
		a(427, "spruce_door", (new class_abr(class_aim.ap)).c("doorSpruce"));
		a(428, "birch_door", (new class_abr(class_aim.aq)).c("doorBirch"));
		a(429, "jungle_door", (new class_abr(class_aim.ar)).c("doorJungle"));
		a(430, "acacia_door", (new class_abr(class_aim.as)).c("doorAcacia"));
		a(431, "dark_oak_door", (new class_abr(class_aim.at)).c("doorDarkOak"));
		a(432, "chorus_fruit", (new class_abk(4, 0.3F)).h().c("chorusFruit").a(class_abp.l));
		a(433, "chorus_fruit_popped", (new class_acm()).c("chorusFruitPopped").a(class_abp.l));
		a(434, "beetroot", (new class_aci(1, 0.6F, false)).c("beetroot"));
		a(435, "beetroot_seeds", (new class_adh(class_aim.cZ, class_aim.ak)).c("beetroot_seeds"));
		a(436, "beetroot_soup", (new class_abh(6)).c("beetroot_soup"));
		a(437, "dragon_breath", (new class_acm()).a(class_abp.k).c("dragon_breath").c(var1));
		a(438, "splash_potion", (new class_adu()).c("splash_potion"));
		a(439, "spectral_arrow", (new class_adt()).c("spectral_arrow"));
		a(440, "tipped_arrow", (new class_adx()).c("tipped_arrow"));
		a(441, "lingering_potion", (new class_act()).c("lingering_potion"));
		a(442, "shield", (new class_adk()).c("shield"));
		a(2256, "record_13", (new class_add("13")).c("record"));
		a(2257, "record_cat", (new class_add("cat")).c("record"));
		a(2258, "record_blocks", (new class_add("blocks")).c("record"));
		a(2259, "record_chirp", (new class_add("chirp")).c("record"));
		a(2260, "record_far", (new class_add("far")).c("record"));
		a(2261, "record_mall", (new class_add("mall")).c("record"));
		a(2262, "record_mellohi", (new class_add("mellohi")).c("record"));
		a(2263, "record_stal", (new class_add("stal")).c("record"));
		a(2264, "record_strad", (new class_add("strad")).c("record"));
		a(2265, "record_ward", (new class_add("ward")).c("record"));
		a(2266, "record_11", (new class_add("11")).c("record"));
		a(2267, "record_wait", (new class_add("wait")).c("record"));
	}

	private static void c(class_ail var0) {
		a(var0, (new class_abb(var0)));
	}

	protected static void a(class_ail var0, class_acm var1) {
		a(class_ail.a(var0), (class_ke) class_ail.c.b(var0), var1);
		a.put(var0, var1);
	}

	private static void a(int var0, String var1, class_acm var2) {
		a(var0, new class_ke(var1), var2);
	}

	private static void a(int var0, class_ke var1, class_acm var2) {
		e.a(var0, var1, var2);
	}

	public static enum class_a_in_class_acm {
		a(0, 59, 2.0F, 0.0F, 15),
		b(1, 131, 4.0F, 1.0F, 5),
		c(2, 250, 6.0F, 2.0F, 14),
		d(3, 1561, 8.0F, 3.0F, 10),
		e(0, 32, 12.0F, 0.0F, 22);

		private final int f;
		private final int g;
		private final float h;
		private final float i;
		private final int j;

		private class_a_in_class_acm(int var3, int var4, float var5, float var6, int var7) {
			f = var3;
			g = var4;
			h = var5;
			i = var6;
			j = var7;
		}

		public int a() {
			return g;
		}

		public float b() {
			return h;
		}

		public float c() {
			return i;
		}

		public int d() {
			return f;
		}

		public int e() {
			return j;
		}

		public class_acm f() {
			return this == a ? class_acm.a(class_aim.f) : (this == b ? class_acm.a(class_aim.e) : (this == e ? class_acq.m : (this == c ? class_acq.l : (this == d ? class_acq.k : null))));
		}
	}
}
