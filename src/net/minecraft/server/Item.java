package net.minecraft.server;

import java.util.Map;
import java.util.Random;
import java.util.UUID;

import com.google.common.base.Function;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;

public class Item {
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
	private Item p;
	private String q;

	public static int a(Item var0) {
		return var0 == null ? 0 : e.a(var0);
	}

	public static int b(Item var0) {
		return var0 == null ? 0 : e.a(var0);
	}

	public static Item c(int var0) {
		return (Item) e.a(var0);
	}

	public static Item a(Block var0) {
		return (Item) a.get(var0);
	}

	public static Item d(String var0) {
		Item var1 = (Item) e.c(new class_ke(var0));
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

	public Item() {
		this.a(new class_ke("lefthanded"), d);
		this.a(new class_ke("cooldown"), l);
	}

	public Item d(int var1) {
		i = var1;
		return this;
	}

	public class_pw a(class_aco var1, class_yu var2, class_ago var3, class_cj var4, class_pu var5, class_cq var6, float var7, float var8, float var9) {
		return class_pw.b;
	}

	public float a(class_aco var1, Block var2) {
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

	protected Item a(boolean var1) {
		k = var1;
		return this;
	}

	public int l() {
		return o;
	}

	protected Item e(int var1) {
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

	public boolean a(class_aco var1, class_ago var2, Block var3, class_cj var4, class_rg var5) {
		return false;
	}

	public boolean b(Block var1) {
		return false;
	}

	public boolean a(class_aco var1, class_yu var2, class_rg var3, class_pu var4) {
		return false;
	}

	public Item n() {
		j = true;
		return this;
	}

	public Item c(String var1) {
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

	public Item c(Item var1) {
		p = var1;
		return this;
	}

	public boolean p() {
		return true;
	}

	public Item q() {
		return p;
	}

	public boolean r() {
		return p != null;
	}

	public void a(class_aco var1, class_ago var2, Entity var3, int var4, boolean var5) {
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

	public Item a(class_abp var1) {
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
		a(Blocks.STONE, (new class_acx(Blocks.STONE, Blocks.STONE, new Function() {
			public String a(class_aco var1) {
				return class_anj.class_a_in_class_anj.a(var1.i()).d();
			}

			// $FF: synthetic method
			@Override
			public Object apply(Object var1) {
				return this.a((class_aco) var1);
			}
		})).b("stone"));
		a(Blocks.GRASS, (new class_adw(Blocks.GRASS, false)));
		a(Blocks.DIRT, (new class_acx(Blocks.DIRT, Blocks.DIRT, new Function() {
			public String a(class_aco var1) {
				return class_ajl.class_a_in_class_ajl.a(var1.i()).c();
			}

			// $FF: synthetic method
			@Override
			public Object apply(Object var1) {
				return this.a((class_aco) var1);
			}
		})).b("dirt"));
		c(Blocks.COBBLESTONE);
		a(Blocks.PLANKS, (new class_acx(Blocks.PLANKS, Blocks.PLANKS, new Function() {
			public String a(class_aco var1) {
				return class_aly.class_a_in_class_aly.a(var1.i()).d();
			}

			// $FF: synthetic method
			@Override
			public Object apply(Object var1) {
				return this.a((class_aco) var1);
			}
		})).b("wood"));
		a(Blocks.SAPLING, (new class_acx(Blocks.SAPLING, Blocks.SAPLING, new Function() {
			public String a(class_aco var1) {
				return class_aly.class_a_in_class_aly.a(var1.i()).d();
			}

			// $FF: synthetic method
			@Override
			public Object apply(Object var1) {
				return this.a((class_aco) var1);
			}
		})).b("sapling"));
		c(Blocks.BEDROCK);
		a(Blocks.SAND, (new class_acx(Blocks.SAND, Blocks.SAND, new Function() {
			public String a(class_aco var1) {
				return BlockSand.class_a_in_class_ams.a(var1.i()).d();
			}

			// $FF: synthetic method
			@Override
			public Object apply(Object var1) {
				return this.a((class_aco) var1);
			}
		})).b("sand"));
		c(Blocks.GRAVEL);
		c(Blocks.GOLD_ORE);
		c(Blocks.IRON_ORE);
		c(Blocks.COAL_ORE);
		a(Blocks.LOG, (new class_acx(Blocks.LOG, Blocks.LOG, new Function() {
			public String a(class_aco var1) {
				return class_aly.class_a_in_class_aly.a(var1.i()).d();
			}

			// $FF: synthetic method
			@Override
			public Object apply(Object var1) {
				return this.a((class_aco) var1);
			}
		})).b("log"));
		a(Blocks.LOG2, (new class_acx(Blocks.LOG2, Blocks.LOG2, new Function() {
			public String a(class_aco var1) {
				return class_aly.class_a_in_class_aly.a(var1.i() + 4).d();
			}

			// $FF: synthetic method
			@Override
			public Object apply(Object var1) {
				return this.a((class_aco) var1);
			}
		})).b("log"));
		a(Blocks.LEAVES, (new class_acs(Blocks.LEAVES)).b("leaves"));
		a(Blocks.LEAVES2, (new class_acs(Blocks.LEAVES2)).b("leaves"));
		a(Blocks.SPONGE, (new class_acx(Blocks.SPONGE, Blocks.SPONGE, new Function() {
			public String a(class_aco var1) {
				return (var1.i() & 1) == 1 ? "wet" : "dry";
			}

			// $FF: synthetic method
			@Override
			public Object apply(Object var1) {
				return this.a((class_aco) var1);
			}
		})).b("sponge"));
		c(Blocks.GLASS);
		c(Blocks.LAPIS_ORE);
		c(Blocks.LAPIS_BLOCK);
		c(Blocks.DISPENSER);
		a(Blocks.SANDSTONE, (new class_acx(Blocks.SANDSTONE, Blocks.SANDSTONE, new Function() {
			public String a(class_aco var1) {
				return class_amt.class_a_in_class_amt.a(var1.i()).c();
			}

			// $FF: synthetic method
			@Override
			public Object apply(Object var1) {
				return this.a((class_aco) var1);
			}
		})).b("sandStone"));
		c(Blocks.NOTEBLOCK);
		c(Blocks.GOLDEN_RAIL);
		c(Blocks.DETECTOR_RAIL);
		a(Blocks.F, (new class_ada(Blocks.F)));
		c(Blocks.G);
		a(Blocks.H, (new class_adw(Blocks.H, true)).a(new String[] { "shrub", "grass", "fern" }));
		c(Blocks.I);
		a(Blocks.J, (new class_ada(Blocks.J)));
		a(Blocks.L, (new class_abv(Blocks.L)).b("cloth"));
		a(Blocks.N, (new class_acx(Blocks.N, Blocks.N, new Function() {
			public String a(class_aco var1) {
				return BlockFlowers.class_a_in_class_ake.a(BlockFlowers.class_b_in_class_ake.a, var1.i()).d();
			}

			// $FF: synthetic method
			@Override
			public Object apply(Object var1) {
				return this.a((class_aco) var1);
			}
		})).b("flower"));
		a(Blocks.O, (new class_acx(Blocks.O, Blocks.O, new Function() {
			public String a(class_aco var1) {
				return BlockFlowers.class_a_in_class_ake.a(BlockFlowers.class_b_in_class_ake.b, var1.i()).d();
			}

			// $FF: synthetic method
			@Override
			public Object apply(Object var1) {
				return this.a((class_aco) var1);
			}
		})).b("rose"));
		c(Blocks.P);
		c(Blocks.Q);
		c(Blocks.R);
		c(Blocks.S);
		a(Blocks.U, (new class_adp(Blocks.U, Blocks.U, Blocks.T)).b("stoneSlab"));
		c(Blocks.V);
		c(Blocks.W);
		c(Blocks.X);
		c(Blocks.Y);
		c(Blocks.Z);
		c(Blocks.aa);
		c(Blocks.cQ);
		c(Blocks.cR);
		c(Blocks.cS);
		c(Blocks.cT);
		c(Blocks.cU);
		c(Blocks.cV);
		a(Blocks.cX, (new class_adp(Blocks.cX, Blocks.cX, Blocks.cW)).b("purpurSlab"));
		c(Blocks.ac);
		c(Blocks.ad);
		c(Blocks.ae);
		c(Blocks.ag);
		c(Blocks.ah);
		c(Blocks.ai);
		c(Blocks.ak);
		c(Blocks.al);
		c(Blocks.am);
		c(Blocks.au);
		c(Blocks.av);
		c(Blocks.aw);
		c(Blocks.ay);
		c(Blocks.az);
		c(Blocks.aB);
		c(Blocks.aC);
		c(Blocks.aF);
		c(Blocks.aG);
		a(Blocks.aH, (new class_adq(Blocks.aH)));
		c(Blocks.aI);
		c(Blocks.aJ);
		c(Blocks.aK);
		c(Blocks.aL);
		c(Blocks.aN);
		c(Blocks.aO);
		c(Blocks.aP);
		c(Blocks.aQ);
		c(Blocks.aR);
		c(Blocks.aS);
		c(Blocks.aT);
		c(Blocks.aU);
		c(Blocks.aV);
		c(Blocks.aW);
		c(Blocks.aX);
		c(Blocks.aZ);
		c(Blocks.bd);
		a(Blocks.be, (new class_acx(Blocks.be, Blocks.be, new Function() {
			public String a(class_aco var1) {
				return class_alj.class_a_in_class_alj.a(var1.i()).c();
			}

			// $FF: synthetic method
			@Override
			public Object apply(Object var1) {
				return this.a((class_aco) var1);
			}
		})).b("monsterStoneEgg"));
		a(Blocks.bf, (new class_acx(Blocks.bf, Blocks.bf, new Function() {
			public String a(class_aco var1) {
				return class_ank.class_a_in_class_ank.a(var1.i()).c();
			}

			// $FF: synthetic method
			@Override
			public Object apply(Object var1) {
				return this.a((class_aco) var1);
			}
		})).b("stonebricksmooth"));
		c(Blocks.bg);
		c(Blocks.bh);
		c(Blocks.bi);
		c(Blocks.bj);
		c(Blocks.bk);
		a(Blocks.bn, (new class_adw(Blocks.bn, false)));
		c(Blocks.bo);
		c(Blocks.bp);
		c(Blocks.bq);
		c(Blocks.br);
		c(Blocks.bs);
		c(Blocks.bt);
		c(Blocks.bu);
		c(Blocks.bv);
		c(Blocks.bw);
		a(Blocks.bx, (new class_adz(Blocks.bx)));
		c(Blocks.by);
		c(Blocks.bz);
		c(Blocks.bA);
		c(Blocks.bC);
		c(Blocks.bG);
		c(Blocks.bH);
		c(Blocks.cY);
		c(Blocks.bI);
		c(Blocks.bJ);
		a(Blocks.bM, (new class_adp(Blocks.bM, Blocks.bM, Blocks.bL)).b("woodSlab"));
		c(Blocks.bO);
		c(Blocks.bP);
		c(Blocks.bQ);
		c(Blocks.bR);
		c(Blocks.bT);
		c(Blocks.bU);
		c(Blocks.bV);
		c(Blocks.bW);
		c(Blocks.bX);
		c(Blocks.bY);
		a(Blocks.bZ, (new class_acx(Blocks.bZ, Blocks.bZ, new Function() {
			public String a(class_aco var1) {
				return class_anx.class_a_in_class_anx.a(var1.i()).c();
			}

			// $FF: synthetic method
			@Override
			public Object apply(Object var1) {
				return this.a((class_aco) var1);
			}
		})).b("cobbleWall"));
		c(Blocks.cd);
		a(Blocks.cf, (new class_aau(Blocks.cf)).b("anvil"));
		c(Blocks.cg);
		c(Blocks.ch);
		c(Blocks.ci);
		c(Blocks.cl);
		c(Blocks.cn);
		c(Blocks.co);
		c(Blocks.cp);
		a(Blocks.cq, (new class_acx(Blocks.cq, Blocks.cq, new String[] { "default", "chiseled", "lines" })).b("quartzBlock"));
		c(Blocks.cr);
		c(Blocks.cs);
		c(Blocks.ct);
		a(Blocks.cu, (new class_abv(Blocks.cu)).b("clayHardenedStained"));
		c(Blocks.cv);
		c(Blocks.cw);
		c(Blocks.cx);
		a(Blocks.cy, (new class_abv(Blocks.cy)).b("woolCarpet"));
		c(Blocks.cz);
		c(Blocks.cA);
		c(Blocks.cB);
		c(Blocks.cC);
		c(Blocks.cD);
		c(Blocks.cE);
		c(Blocks.da);
		a(Blocks.cF, (new class_abs(Blocks.cF, Blocks.cF, new Function() {
			public String a(class_aco var1) {
				return BlockTallPlant.class_b_in_class_ajo.a(var1.i()).c();
			}

			// $FF: synthetic method
			@Override
			public Object apply(Object var1) {
				return this.a((class_aco) var1);
			}
		})).b("doublePlant"));
		a(Blocks.cG, (new class_abv(Blocks.cG)).b("stainedGlass"));
		a(Blocks.cH, (new class_abv(Blocks.cH)).b("stainedGlassPane"));
		a(Blocks.cI, (new class_acx(Blocks.cI, Blocks.cI, new Function() {
			public String a(class_aco var1) {
				return class_ame.class_a_in_class_ame.a(var1.i()).c();
			}

			// $FF: synthetic method
			@Override
			public Object apply(Object var1) {
				return this.a((class_aco) var1);
			}
		})).b("prismarine"));
		c(Blocks.cJ);
		a(Blocks.cM, (new class_acx(Blocks.cM, Blocks.cM, new Function() {
			public String a(class_aco var1) {
				return class_amk.class_a_in_class_amk.a(var1.i()).c();
			}

			// $FF: synthetic method
			@Override
			public Object apply(Object var1) {
				return this.a((class_aco) var1);
			}
		})).b("redSandStone"));
		c(Blocks.cN);
		a(Blocks.cP, (new class_adp(Blocks.cP, Blocks.cP, Blocks.cO)).b("stoneSlab2"));
		c(Blocks.dc);
		c(Blocks.dd);
		a(256, "iron_shovel", (new class_adl(Item.class_a_in_class_acm.c)).c("shovelIron"));
		a(257, "iron_pickaxe", (new class_acz(Item.class_a_in_class_acm.c)).c("pickaxeIron"));
		a(258, "iron_axe", (new class_aay(Item.class_a_in_class_acm.c)).c("hatchetIron"));
		a(259, "flint_and_steel", (new class_ach()).c("flintAndSteel"));
		a(260, "apple", (new class_aci(4, 0.3F, false)).c("apple"));
		a(261, "bow", (new class_abg()).c("bow"));
		a(262, "arrow", (new class_aax()).c("arrow"));
		a(263, "coal", (new class_abm()).c("coal"));
		a(264, "diamond", (new Item()).c("diamond").a(class_abp.l));
		a(265, "iron_ingot", (new Item()).c("ingotIron").a(class_abp.l));
		a(266, "gold_ingot", (new Item()).c("ingotGold").a(class_abp.l));
		a(267, "iron_sword", (new class_adv(Item.class_a_in_class_acm.c)).c("swordIron"));
		a(268, "wooden_sword", (new class_adv(Item.class_a_in_class_acm.a)).c("swordWood"));
		a(269, "wooden_shovel", (new class_adl(Item.class_a_in_class_acm.a)).c("shovelWood"));
		a(270, "wooden_pickaxe", (new class_acz(Item.class_a_in_class_acm.a)).c("pickaxeWood"));
		a(271, "wooden_axe", (new class_aay(Item.class_a_in_class_acm.a)).c("hatchetWood"));
		a(272, "stone_sword", (new class_adv(Item.class_a_in_class_acm.b)).c("swordStone"));
		a(273, "stone_shovel", (new class_adl(Item.class_a_in_class_acm.b)).c("shovelStone"));
		a(274, "stone_pickaxe", (new class_acz(Item.class_a_in_class_acm.b)).c("pickaxeStone"));
		a(275, "stone_axe", (new class_aay(Item.class_a_in_class_acm.b)).c("hatchetStone"));
		a(276, "diamond_sword", (new class_adv(Item.class_a_in_class_acm.d)).c("swordDiamond"));
		a(277, "diamond_shovel", (new class_adl(Item.class_a_in_class_acm.d)).c("shovelDiamond"));
		a(278, "diamond_pickaxe", (new class_acz(Item.class_a_in_class_acm.d)).c("pickaxeDiamond"));
		a(279, "diamond_axe", (new class_aay(Item.class_a_in_class_acm.d)).c("hatchetDiamond"));
		a(280, "stick", (new Item()).n().c("stick").a(class_abp.l));
		a(281, "bowl", (new Item()).c("bowl").a(class_abp.l));
		a(282, "mushroom_stew", (new class_abh(6)).c("mushroomStew"));
		a(283, "golden_sword", (new class_adv(Item.class_a_in_class_acm.e)).c("swordGold"));
		a(284, "golden_shovel", (new class_adl(Item.class_a_in_class_acm.e)).c("shovelGold"));
		a(285, "golden_pickaxe", (new class_acz(Item.class_a_in_class_acm.e)).c("pickaxeGold"));
		a(286, "golden_axe", (new class_aay(Item.class_a_in_class_acm.e)).c("hatchetGold"));
		a(287, "string", (new class_abc(Blocks.bS)).c("string").a(class_abp.l));
		a(288, "feather", (new Item()).c("feather").a(class_abp.l));
		a(289, "gunpowder", (new Item()).c("sulphur").a(class_abp.l));
		a(290, "wooden_hoe", (new class_acl(Item.class_a_in_class_acm.a)).c("hoeWood"));
		a(291, "stone_hoe", (new class_acl(Item.class_a_in_class_acm.b)).c("hoeStone"));
		a(292, "iron_hoe", (new class_acl(Item.class_a_in_class_acm.c)).c("hoeIron"));
		a(293, "diamond_hoe", (new class_acl(Item.class_a_in_class_acm.d)).c("hoeDiamond"));
		a(294, "golden_hoe", (new class_acl(Item.class_a_in_class_acm.e)).c("hoeGold"));
		a(295, "wheat_seeds", (new class_adh(Blocks.aj, Blocks.ak)).c("seeds"));
		a(296, "wheat", (new Item()).c("wheat").a(class_abp.l));
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
		a(318, "flint", (new Item()).c("flint").a(class_abp.l));
		a(319, "porkchop", (new class_aci(3, 0.3F, true)).c("porkchopRaw"));
		a(320, "cooked_porkchop", (new class_aci(8, 0.8F, true)).c("porkchopCooked"));
		a(321, "painting", (new class_ack(class_ww.class)).c("painting"));
		a(322, "golden_apple", (new class_acj(4, 1.2F, false)).h().a(new class_qr(class_qs.j, 100, 1), 1.0F).c("appleGold"));
		a(323, "sign", (new class_adm()).c("sign"));
		a(324, "wooden_door", (new class_abr(Blocks.ao)).c("doorOak"));
		Item var0 = (new class_abi(Blocks.AIR)).c("bucket").d(16);
		a(325, "bucket", var0);
		a(326, "water_bucket", (new class_abi(Blocks.FLOWING_WATER)).c("bucketWater").c(var0));
		a(327, "lava_bucket", (new class_abi(Blocks.FLOWING_LAVA)).c("bucketLava").c(var0));
		a(328, "minecart", (new class_acw(class_xh.class_a_in_class_xh.a)).c("minecart"));
		a(329, "saddle", (new class_adf()).c("saddle"));
		a(330, "iron_door", (new class_abr(Blocks.aA)).c("doorIron"));
		a(331, "redstone", (new class_ade()).c("redstone"));
		a(332, "snowball", (new class_adr()).c("snowball"));
		a(333, "boat", (new class_abd()).c("boat"));
		a(334, "leather", (new Item()).c("leather").a(class_abp.l));
		a(335, "milk_bucket", (new class_acv()).c("milk").c(var0));
		a(336, "brick", (new Item()).c("brick").a(class_abp.l));
		a(337, "clay_ball", (new Item()).c("clay").a(class_abp.l));
		a(338, "reeds", (new class_abc(Blocks.aM)).c("reeds").a(class_abp.l));
		a(339, "paper", (new Item()).c("paper").a(class_abp.f));
		a(340, "book", (new class_abe()).c("book").a(class_abp.f));
		a(341, "slime_ball", (new Item()).c("slimeball").a(class_abp.f));
		a(342, "chest_minecart", (new class_acw(class_xh.class_a_in_class_xh.b)).c("minecartChest"));
		a(343, "furnace_minecart", (new class_acw(class_xh.class_a_in_class_xh.c)).c("minecartFurnace"));
		a(344, "egg", (new class_abw()).c("egg"));
		a(345, "compass", (new class_abn()).c("compass").a(class_abp.i));
		a(346, "fishing_rod", (new class_acg()).c("fishingRod"));
		a(347, "clock", (new class_abl()).c("clock").a(class_abp.i));
		a(348, "glowstone_dust", (new Item()).c("yellowDust").a(class_abp.l));
		a(349, "fish", (new class_acf(false)).c("fish").a(true));
		a(350, "cooked_fish", (new class_acf(true)).c("fish").a(true));
		a(351, "dye", (new class_abu()).c("dyePowder"));
		a(352, "bone", (new Item()).c("bone").n().a(class_abp.f));
		a(353, "sugar", (new Item()).c("sugar").a(class_abp.l));
		a(354, "cake", (new class_abc(Blocks.ba)).d(1).c("cake").a(class_abp.h));
		a(355, "bed", (new class_aba()).d(1).c("bed"));
		a(356, "repeater", (new class_abc(Blocks.bb)).c("diode").a(class_abp.d));
		a(357, "cookie", (new class_aci(2, 0.1F, false)).c("cookie"));
		a(358, "filled_map", (new class_acu()).c("map"));
		a(359, "shears", (new class_adj()).c("shears"));
		a(360, "melon", (new class_aci(2, 0.3F, false)).c("melon"));
		a(361, "pumpkin_seeds", (new class_adh(Blocks.bl, Blocks.ak)).c("seeds_pumpkin"));
		a(362, "melon_seeds", (new class_adh(Blocks.bm, Blocks.ak)).c("seeds_melon"));
		a(363, "beef", (new class_aci(3, 0.3F, true)).c("beefRaw"));
		a(364, "cooked_beef", (new class_aci(8, 0.8F, true)).c("beefCooked"));
		a(365, "chicken", (new class_aci(2, 0.3F, true)).a(new class_qr(class_qs.q, 600, 0), 0.3F).c("chickenRaw"));
		a(366, "cooked_chicken", (new class_aci(6, 0.6F, true)).c("chickenCooked"));
		a(367, "rotten_flesh", (new class_aci(4, 0.1F, true)).a(new class_qr(class_qs.q, 600, 0), 0.8F).c("rottenFlesh"));
		a(368, "ender_pearl", (new class_aca()).c("enderPearl"));
		a(369, "blaze_rod", (new Item()).c("blazeRod").a(class_abp.l).n());
		a(370, "ghast_tear", (new Item()).c("ghastTear").a(class_abp.k));
		a(371, "gold_nugget", (new Item()).c("goldNugget").a(class_abp.l));
		a(372, "nether_wart", (new class_adh(Blocks.bB, Blocks.aW)).c("netherStalkSeeds"));
		a(373, "potion", (new class_adb()).c("potion"));
		Item var1 = (new class_abf()).c("glassBottle");
		a(374, "glass_bottle", var1);
		a(375, "spider_eye", (new class_aci(2, 0.8F, false)).a(new class_qr(class_qs.s, 100, 0), 1.0F).c("spiderEye"));
		a(376, "fermented_spider_eye", (new Item()).c("fermentedSpiderEye").a(class_abp.k));
		a(377, "blaze_powder", (new Item()).c("blazePowder").a(class_abp.k));
		a(378, "magma_cream", (new Item()).c("magmaCream").a(class_abp.k));
		a(379, "brewing_stand", (new class_abc(Blocks.bD)).c("brewingStand").a(class_abp.k));
		a(380, "cauldron", (new class_abc(Blocks.bE)).c("cauldron").a(class_abp.k));
		a(381, "ender_eye", (new class_abz()).c("eyeOfEnder"));
		a(382, "speckled_melon", (new Item()).c("speckledMelon").a(class_abp.k));
		a(383, "spawn_egg", (new class_ads()).c("monsterPlacer"));
		a(384, "experience_bottle", (new class_acb()).c("expBottle"));
		a(385, "fire_charge", (new class_acc()).c("fireball"));
		a(386, "writable_book", (new class_aea()).c("writingBook").a(class_abp.f));
		a(387, "written_book", (new class_aeb()).c("writtenBook").d(16));
		a(388, "emerald", (new Item()).c("emerald").a(class_abp.l));
		a(389, "item_frame", (new class_ack(class_wu.class)).c("frame"));
		a(390, "flower_pot", (new class_abc(Blocks.ca)).c("flowerPot").a(class_abp.c));
		a(391, "carrot", (new class_adg(3, 0.6F, Blocks.cb, Blocks.ak)).c("carrots"));
		a(392, "potato", (new class_adg(1, 0.3F, Blocks.cc, Blocks.ak)).c("potato"));
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
		a(404, "comparator", (new class_abc(Blocks.cj)).c("comparator").a(class_abp.d));
		a(405, "netherbrick", (new Item()).c("netherbrick").a(class_abp.l));
		a(406, "quartz", (new Item()).c("netherquartz").a(class_abp.l));
		a(407, "tnt_minecart", (new class_acw(class_xh.class_a_in_class_xh.d)).c("minecartTnt"));
		a(408, "hopper_minecart", (new class_acw(class_xh.class_a_in_class_xh.f)).c("minecartHopper"));
		a(409, "prismarine_shard", (new Item()).c("prismarineShard").a(class_abp.l));
		a(410, "prismarine_crystals", (new Item()).c("prismarineCrystals").a(class_abp.l));
		a(411, "rabbit", (new class_aci(3, 0.3F, true)).c("rabbitRaw"));
		a(412, "cooked_rabbit", (new class_aci(5, 0.6F, true)).c("rabbitCooked"));
		a(413, "rabbit_stew", (new class_abh(10)).c("rabbitStew"));
		a(414, "rabbit_foot", (new Item()).c("rabbitFoot").a(class_abp.k));
		a(415, "rabbit_hide", (new Item()).c("rabbitHide").a(class_abp.l));
		a(416, "armor_stand", (new class_aaw()).c("armorStand").d(16));
		a(417, "iron_horse_armor", (new Item()).c("horsearmormetal").d(1).a(class_abp.f));
		a(418, "golden_horse_armor", (new Item()).c("horsearmorgold").d(1).a(class_abp.f));
		a(419, "diamond_horse_armor", (new Item()).c("horsearmordiamond").d(1).a(class_abp.f));
		a(420, "lead", (new class_acr()).c("leash"));
		a(421, "name_tag", (new class_acy()).c("nameTag"));
		a(422, "command_block_minecart", (new class_acw(class_xh.class_a_in_class_xh.g)).c("minecartCommandBlock").a((class_abp) null));
		a(423, "mutton", (new class_aci(2, 0.3F, true)).c("muttonRaw"));
		a(424, "cooked_mutton", (new class_aci(6, 0.8F, true)).c("muttonCooked"));
		a(425, "banner", (new class_aaz()).b("banner"));
		a(427, "spruce_door", (new class_abr(Blocks.ap)).c("doorSpruce"));
		a(428, "birch_door", (new class_abr(Blocks.aq)).c("doorBirch"));
		a(429, "jungle_door", (new class_abr(Blocks.ar)).c("doorJungle"));
		a(430, "acacia_door", (new class_abr(Blocks.as)).c("doorAcacia"));
		a(431, "dark_oak_door", (new class_abr(Blocks.at)).c("doorDarkOak"));
		a(432, "chorus_fruit", (new class_abk(4, 0.3F)).h().c("chorusFruit").a(class_abp.l));
		a(433, "chorus_fruit_popped", (new Item()).c("chorusFruitPopped").a(class_abp.l));
		a(434, "beetroot", (new class_aci(1, 0.6F, false)).c("beetroot"));
		a(435, "beetroot_seeds", (new class_adh(Blocks.cZ, Blocks.ak)).c("beetroot_seeds"));
		a(436, "beetroot_soup", (new class_abh(6)).c("beetroot_soup"));
		a(437, "dragon_breath", (new Item()).a(class_abp.k).c("dragon_breath").c(var1));
		a(438, "splash_potion", (new class_adu()).c("splash_potion"));
		a(439, "spectral_arrow", (new class_adt()).c("spectral_arrow"));
		a(440, "tipped_arrow", (new class_adx()).c("tipped_arrow"));
		a(441, "lingering_potion", (new class_act()).c("lingering_potion"));
		a(442, "shield", (new ItemShield()).c("shield"));
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

	private static void c(Block var0) {
		a(var0, (new class_abb(var0)));
	}

	protected static void a(Block var0, Item var1) {
		a(Block.a(var0), (class_ke) Block.c.b(var0), var1);
		a.put(var0, var1);
	}

	private static void a(int var0, String var1, Item var2) {
		a(var0, new class_ke(var1), var2);
	}

	private static void a(int var0, class_ke var1, Item var2) {
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

		public Item f() {
			return this == a ? Item.a(Blocks.PLANKS) : (this == b ? Item.a(Blocks.COBBLESTONE) : (this == e ? Items.m : (this == c ? Items.l : (this == d ? Items.k : null))));
		}
	}
}
