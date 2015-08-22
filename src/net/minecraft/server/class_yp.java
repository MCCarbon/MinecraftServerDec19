package net.minecraft.server;

import java.util.Iterator;
import java.util.Random;

public class class_yp extends class_qu implements class_aga, class_yo {
	private static final class_jz bu;
	private int bv;
	private boolean bw;
	private boolean bx;
	class_uv bt;
	private class_yu by;
	private class_agc bz;
	private int bA;
	private boolean bB;
	private boolean bC;
	private int bD;
	private String bE;
	private int bF;
	private int bG;
	private boolean bH;
	private boolean bI;
	private class_qc bJ;
	private static final class_yp.class_f_in_class_yp[][][][] bK;

	public class_yp(class_ago var1) {
		this(var1, 0);
	}

	public class_yp(class_ago var1, int var2) {
		super(var1);
		bJ = new class_qc("Items", false, 8);
		this.k(var2);
		this.a(0.6F, 1.8F);
		((class_ul) u()).b(true);
		((class_ul) u()).a(true);
		i.a(0, new class_so(this));
		i.a(1, new class_sg(this, class_yl.class, 8.0F, 0.6D, 0.6D));
		i.a(1, new class_tx(this));
		i.a(1, new class_sx(this));
		i.a(2, new class_ta(this));
		i.a(3, new class_tq(this));
		i.a(4, new class_ti(this, true));
		i.a(5, new class_td(this, 0.6D));
		i.a(6, new class_sy(this));
		i.a(7, new class_tv(this));
		i.a(9, new class_su(this, class_yu.class, 3.0F, 1.0F));
		i.a(9, new class_ty(this));
		i.a(9, new class_tn(this, 0.6D));
		i.a(10, new class_sw(this, class_rh.class, 8.0F));
		this.j(true);
	}

	private void cO() {
		if (!bI) {
			bI = true;
			if (i_()) {
				i.a(8, new class_tk(this, 0.32D));
			} else if (cE() == 0) {
				i.a(6, new class_st(this, 0.6D));
			}

		}
	}

	@Override
	protected void n() {
		if (cE() == 0) {
			i.a(8, new class_st(this, 0.6D));
		}

		super.n();
	}

	@Override
	protected void be() {
		super.be();
		this.a(class_yf.d).a(0.5D);
	}

	@Override
	protected void cg() {
		if (--bv <= 0) {
			class_cj var1 = new class_cj(this);
			o.ag().a(var1);
			bv = 70 + V.nextInt(50);
			bt = o.ag().a(var1, 32);
			if (bt == null) {
				cC();
			} else {
				class_cj var2 = bt.a();
				this.a(var2, (int) (bt.b() * 1.0F));
				if (bH) {
					bH = false;
					bt.b(5);
				}
			}
		}

		if (!cH() && (bA > 0)) {
			--bA;
			if (bA <= 0) {
				if (bB) {
					Iterator var3 = bz.iterator();

					while (var3.hasNext()) {
						class_agb var4 = (class_agb) var3.next();
						if (var4.h()) {
							var4.a(V.nextInt(6) + V.nextInt(6) + 2);
						}
					}

					cP();
					bB = false;
					if ((bt != null) && (bE != null)) {
						o.a(this, (byte) 14);
						bt.a(bE, 1);
					}
				}

				this.c(new class_qr(class_qs.j, 200, 0));
			}
		}

		super.cg();
	}

	@Override
	public boolean a(class_yu var1, class_pu var2, class_aco var3) {
		boolean var4 = (var3 != null) && (var3.b() == Items.bO);
		if (!var4 && al() && !cH() && !i_()) {
			if (!o.D && ((bz == null) || !bz.isEmpty())) {
				this.a(var1);
				var1.a((class_aga) this);
			}

			var1.b(class_nh.G);
			return true;
		} else {
			return super.a(var1, var2, var3);
		}
	}

	@Override
	protected void h() {
		super.h();
		ac.a(bu, Integer.valueOf(0));
	}

	@Override
	public void b(class_dn var1) {
		super.b(var1);
		var1.a("Profession", cE());
		var1.a("Riches", bD);
		var1.a("Career", bF);
		var1.a("CareerLevel", bG);
		var1.a("Willing", bC);
		if (bz != null) {
			var1.a("Offers", bz.a());
		}

		class_du var2 = new class_du();

		for (int var3 = 0; var3 < bJ.n_(); ++var3) {
			class_aco var4 = bJ.a(var3);
			if (var4 != null) {
				var2.a(var4.b(new class_dn()));
			}
		}

		var1.a("Inventory", var2);
	}

	@Override
	public void a(class_dn var1) {
		super.a(var1);
		this.k(var1.h("Profession"));
		bD = var1.h("Riches");
		bF = var1.h("Career");
		bG = var1.h("CareerLevel");
		bC = var1.p("Willing");
		if (var1.b("Offers", 10)) {
			class_dn var2 = var1.o("Offers");
			bz = new class_agc(var2);
		}

		class_du var5 = var1.c("Inventory", 10);

		for (int var3 = 0; var3 < var5.c(); ++var3) {
			class_aco var4 = class_aco.a(var5.b(var3));
			if (var4 != null) {
				bJ.a(var4);
			}
		}

		this.j(true);
		cO();
	}

	@Override
	protected boolean E() {
		return false;
	}

	@Override
	protected String B() {
		return cH() ? "mob.villager.haggle" : "mob.villager.idle";
	}

	@Override
	protected String bv() {
		return "mob.villager.hit";
	}

	@Override
	protected String bw() {
		return "mob.villager.death";
	}

	public void k(int var1) {
		ac.b(bu, Integer.valueOf(var1));
	}

	public int cE() {
		return Math.max(((Integer) ac.a(bu)).intValue() % 5, 0);
	}

	public boolean cF() {
		return bw;
	}

	public void m(boolean var1) {
		bw = var1;
	}

	public void n(boolean var1) {
		bx = var1;
	}

	public boolean cG() {
		return bx;
	}

	@Override
	public void a(class_rg var1) {
		super.a(var1);
		if ((bt != null) && (var1 != null)) {
			bt.a(var1);
			if (var1 instanceof class_yu) {
				byte var2 = -1;
				if (i_()) {
					var2 = -3;
				}

				bt.a(var1.e_(), var2);
				if (al()) {
					o.a(this, (byte) 13);
				}
			}
		}

	}

	@Override
	public void a(class_qi var1) {
		if (bt != null) {
			Entity var2 = var1.j();
			if (var2 != null) {
				if (var2 instanceof class_yu) {
					bt.a(var2.e_(), -2);
				} else if (var2 instanceof class_xx) {
					bt.h();
				}
			} else {
				class_yu var3 = o.a(this, 16.0D);
				if (var3 != null) {
					bt.h();
				}
			}
		}

		super.a(var1);
	}

	@Override
	public void a(class_yu var1) {
		by = var1;
	}

	@Override
	public class_yu t_() {
		return by;
	}

	public boolean cH() {
		return by != null;
	}

	public boolean o(boolean var1) {
		if (!bC && var1 && cK()) {
			boolean var2 = false;

			for (int var3 = 0; var3 < bJ.n_(); ++var3) {
				class_aco var4 = bJ.a(var3);
				if (var4 != null) {
					if ((var4.b() == Items.R) && (var4.b >= 3)) {
						var2 = true;
						bJ.a(var3, 3);
					} else if (((var4.b() == Items.bX) || (var4.b() == Items.bW)) && (var4.b >= 12)) {
						var2 = true;
						bJ.a(var3, 12);
					}
				}

				if (var2) {
					o.a(this, (byte) 18);
					bC = true;
					break;
				}
			}
		}

		return bC;
	}

	public void p(boolean var1) {
		bC = var1;
	}

	@Override
	public void a(class_agb var1) {
		var1.g();
		a_ = -y();
		this.a("mob.villager.yes", bI(), bJ());
		int var2 = 3 + V.nextInt(4);
		if ((var1.e() == 1) || (V.nextInt(5) == 0)) {
			bA = 40;
			bB = true;
			bC = true;
			if (by != null) {
				bE = by.e_();
			} else {
				bE = null;
			}

			var2 += 5;
		}

		if (var1.a().b() == Items.bT) {
			bD += var1.a().b;
		}

		if (var1.j()) {
			o.a((new class_rd(o, s, t + 0.5D, u, var2)));
		}

	}

	@Override
	public void a_(class_aco var1) {
		if (!o.D && (a_ > (-y() + 20))) {
			a_ = -y();
			if (var1 != null) {
				this.a("mob.villager.yes", bI(), bJ());
			} else {
				this.a("mob.villager.no", bI(), bJ());
			}
		}

	}

	@Override
	public class_agc a_(class_yu var1) {
		if (bz == null) {
			cP();
		}

		return bz;
	}

	private void cP() {
		class_yp.class_f_in_class_yp[][][] var1 = bK[cE()];
		if ((bF != 0) && (bG != 0)) {
			++bG;
		} else {
			bF = V.nextInt(var1.length) + 1;
			bG = 1;
		}

		if (bz == null) {
			bz = new class_agc();
		}

		int var2 = bF - 1;
		int var3 = bG - 1;
		class_yp.class_f_in_class_yp[][] var4 = var1[var2];
		if ((var3 >= 0) && (var3 < var4.length)) {
			class_yp.class_f_in_class_yp[] var5 = var4[var3];
			class_yp.class_f_in_class_yp[] var6 = var5;
			int var7 = var5.length;

			for (int var8 = 0; var8 < var7; ++var8) {
				class_yp.class_f_in_class_yp var9 = var6[var8];
				var9.a(bz, V);
			}
		}

	}

	@Override
	public class_eu f_() {
		class_ayu var1 = aE();
		String var2 = aS();
		if ((var2 != null) && !var2.isEmpty()) {
			class_fa var5 = new class_fa(class_ayp.a(var1, var2));
			var5.b().a(aW());
			var5.b().a(aQ().toString());
			return var5;
		} else {
			if (bz == null) {
				cP();
			}

			String var3 = null;
			switch (cE()) {
				case 0:
					if (bF == 1) {
						var3 = "farmer";
					} else if (bF == 2) {
						var3 = "fisherman";
					} else if (bF == 3) {
						var3 = "shepherd";
					} else if (bF == 4) {
						var3 = "fletcher";
					}
					break;
				case 1:
					var3 = "librarian";
					break;
				case 2:
					var3 = "cleric";
					break;
				case 3:
					if (bF == 1) {
						var3 = "armor";
					} else if (bF == 2) {
						var3 = "weapon";
					} else if (bF == 3) {
						var3 = "tool";
					}
					break;
				case 4:
					if (bF == 1) {
						var3 = "butcher";
					} else if (bF == 2) {
						var3 = "leather";
					}
			}

			if (var3 != null) {
				class_fb var4 = new class_fb("entity.Villager." + var3, new Object[0]);
				var4.b().a(aW());
				var4.b().a(aQ().toString());
				if (var1 != null) {
					var4.b().a(var1.l());
				}

				return var4;
			} else {
				return super.f_();
			}
		}
	}

	@Override
	public float aY() {
		float var1 = 1.62F;
		if (i_()) {
			var1 = (float) (var1 - 0.81D);
		}

		return var1;
	}

	@Override
	public class_rj a(class_pt var1, class_rj var2) {
		var2 = super.a(var1, var2);
		this.k(o.s.nextInt(5));
		cO();
		return var2;
	}

	public void cI() {
		bH = true;
	}

	public class_yp b(class_qu var1) {
		class_yp var2 = new class_yp(o);
		var2.a(o.E(new class_cj(var2)), (class_rj) null);
		return var2;
	}

	@Override
	public boolean ct() {
		return false;
	}

	@Override
	public void a(class_xc var1) {
		if (!o.D && !I) {
			class_yk var2 = new class_yk(o);
			var2.b(s, t, u, y, z);
			var2.a(o.E(new class_cj(var2)), (class_rj) null);
			var2.k(cw());
			if (k_()) {
				var2.c(aS());
				var2.g(aT());
			}

			o.a(var2);
			L();
		}
	}

	public class_qc cJ() {
		return bJ;
	}

	@Override
	protected void a(class_xg var1) {
		class_aco var2 = var1.j();
		Item var3 = var2.b();
		if (this.a(var3)) {
			class_aco var4 = bJ.a(var2);
			if (var4 == null) {
				var1.L();
			} else {
				var2.b = var4.b;
			}
		}

	}

	private boolean a(Item var1) {
		return (var1 == Items.R) || (var1 == Items.bX) || (var1 == Items.bW) || (var1 == Items.Q) || (var1 == Items.P);
	}

	public boolean cK() {
		return this.l(1);
	}

	public boolean cL() {
		return this.l(2);
	}

	public boolean cM() {
		boolean var1 = cE() == 0;
		return var1 ? !this.l(5) : !this.l(1);
	}

	private boolean l(int var1) {
		boolean var2 = cE() == 0;

		for (int var3 = 0; var3 < bJ.n_(); ++var3) {
			class_aco var4 = bJ.a(var3);
			if (var4 != null) {
				if (((var4.b() == Items.R) && (var4.b >= (3 * var1))) || ((var4.b() == Items.bX) && (var4.b >= (12 * var1))) || ((var4.b() == Items.bW) && (var4.b >= (12 * var1)))) {
					return true;
				}

				if (var2 && (var4.b() == Items.Q) && (var4.b >= (9 * var1))) {
					return true;
				}
			}
		}

		return false;
	}

	public boolean cN() {
		for (int var1 = 0; var1 < bJ.n_(); ++var1) {
			class_aco var2 = bJ.a(var1);
			if ((var2 != null) && ((var2.b() == Items.P) || (var2.b() == Items.bX) || (var2.b() == Items.bW))) {
				return true;
			}
		}

		return false;
	}

	@Override
	public boolean c(int var1, class_aco var2) {
		if (super.c(var1, var2)) {
			return true;
		} else {
			int var3 = var1 - 300;
			if ((var3 >= 0) && (var3 < bJ.n_())) {
				bJ.a(var3, var2);
				return true;
			} else {
				return false;
			}
		}
	}

	// $FF: synthetic method
	@Override
	public class_qu a(class_qu var1) {
		return this.b(var1);
	}

	static {
		bu = class_kc.a(class_yp.class, class_kb.b);
		bK = new class_yp.class_f_in_class_yp[][][][] {
				{
					{ { new class_yp.class_a_in_class_yp(Items.Q, new class_yp.class_g_in_class_yp(18, 22)), new class_yp.class_a_in_class_yp(Items.bX, new class_yp.class_g_in_class_yp(15, 19)), new class_yp.class_a_in_class_yp(Items.bW, new class_yp.class_g_in_class_yp(15, 19)), new class_yp.class_e_in_class_yp(Items.R, new class_yp.class_g_in_class_yp(-4, -2)) },
						{ new class_yp.class_a_in_class_yp(Item.a(Blocks.aU), new class_yp.class_g_in_class_yp(8, 13)), new class_yp.class_e_in_class_yp(Items.cf, new class_yp.class_g_in_class_yp(-3, -2)) }, { new class_yp.class_a_in_class_yp(Item.a(Blocks.bk), new class_yp.class_g_in_class_yp(7, 12)), new class_yp.class_e_in_class_yp(Items.e, new class_yp.class_g_in_class_yp(-5, -7)) },
						{ new class_yp.class_e_in_class_yp(Items.be, new class_yp.class_g_in_class_yp(-6, -10)), new class_yp.class_e_in_class_yp(Items.bb, new class_yp.class_g_in_class_yp(1, 1)) } },
						{ { new class_yp.class_a_in_class_yp(Items.H, new class_yp.class_g_in_class_yp(15, 20)), new class_yp.class_a_in_class_yp(Items.j, new class_yp.class_g_in_class_yp(16, 24)), new class_yp.class_d_in_class_yp(Items.aW, new class_yp.class_g_in_class_yp(6, 6), Items.aX, new class_yp.class_g_in_class_yp(6, 6)) }, { new class_yp.class_c_in_class_yp(Items.aT, new class_yp.class_g_in_class_yp(7, 8)) } },
						{
							{ new class_yp.class_a_in_class_yp(Item.a(Blocks.L), new class_yp.class_g_in_class_yp(16, 22)), new class_yp.class_e_in_class_yp(Items.bg, new class_yp.class_g_in_class_yp(3, 4)) },
							{ new class_yp.class_e_in_class_yp(new class_aco(Item.a(Blocks.L)), new class_yp.class_g_in_class_yp(1, 2)), new class_yp.class_e_in_class_yp(new class_aco(Item.a(Blocks.L), 1, 1), new class_yp.class_g_in_class_yp(1, 2)), new class_yp.class_e_in_class_yp(new class_aco(Item.a(Blocks.L), 1, 2), new class_yp.class_g_in_class_yp(1, 2)),
								new class_yp.class_e_in_class_yp(new class_aco(Item.a(Blocks.L), 1, 3), new class_yp.class_g_in_class_yp(1, 2)), new class_yp.class_e_in_class_yp(new class_aco(Item.a(Blocks.L), 1, 4), new class_yp.class_g_in_class_yp(1, 2)), new class_yp.class_e_in_class_yp(new class_aco(Item.a(Blocks.L), 1, 5), new class_yp.class_g_in_class_yp(1, 2)),
								new class_yp.class_e_in_class_yp(new class_aco(Item.a(Blocks.L), 1, 6), new class_yp.class_g_in_class_yp(1, 2)), new class_yp.class_e_in_class_yp(new class_aco(Item.a(Blocks.L), 1, 7), new class_yp.class_g_in_class_yp(1, 2)), new class_yp.class_e_in_class_yp(new class_aco(Item.a(Blocks.L), 1, 8), new class_yp.class_g_in_class_yp(1, 2)),
								new class_yp.class_e_in_class_yp(new class_aco(Item.a(Blocks.L), 1, 9), new class_yp.class_g_in_class_yp(1, 2)), new class_yp.class_e_in_class_yp(new class_aco(Item.a(Blocks.L), 1, 10), new class_yp.class_g_in_class_yp(1, 2)), new class_yp.class_e_in_class_yp(new class_aco(Item.a(Blocks.L), 1, 11), new class_yp.class_g_in_class_yp(1, 2)),
								new class_yp.class_e_in_class_yp(new class_aco(Item.a(Blocks.L), 1, 12), new class_yp.class_g_in_class_yp(1, 2)), new class_yp.class_e_in_class_yp(new class_aco(Item.a(Blocks.L), 1, 13), new class_yp.class_g_in_class_yp(1, 2)), new class_yp.class_e_in_class_yp(new class_aco(Item.a(Blocks.L), 1, 14), new class_yp.class_g_in_class_yp(1, 2)),
								new class_yp.class_e_in_class_yp(new class_aco(Item.a(Blocks.L), 1, 15), new class_yp.class_g_in_class_yp(1, 2)) } },
								{ { new class_yp.class_a_in_class_yp(Items.H, new class_yp.class_g_in_class_yp(15, 20)), new class_yp.class_e_in_class_yp(Items.g, new class_yp.class_g_in_class_yp(-12, -8)) }, { new class_yp.class_e_in_class_yp(Items.f, new class_yp.class_g_in_class_yp(2, 3)), new class_yp.class_d_in_class_yp(Item.a(Blocks.n), new class_yp.class_g_in_class_yp(10, 10), Items.am, new class_yp.class_g_in_class_yp(6, 10)) } } },
								{ { { new class_yp.class_a_in_class_yp(Items.aM, new class_yp.class_g_in_class_yp(24, 36)), new class_yp.class_b_in_class_yp() }, { new class_yp.class_a_in_class_yp(Items.aN, new class_yp.class_g_in_class_yp(8, 10)), new class_yp.class_e_in_class_yp(Items.aS, new class_yp.class_g_in_class_yp(10, 12)), new class_yp.class_e_in_class_yp(Item.a(Blocks.X), new class_yp.class_g_in_class_yp(3, 4)) },
									{ new class_yp.class_a_in_class_yp(Items.bS, new class_yp.class_g_in_class_yp(2, 2)), new class_yp.class_e_in_class_yp(Items.aU, new class_yp.class_g_in_class_yp(10, 12)), new class_yp.class_e_in_class_yp(Item.a(Blocks.w), new class_yp.class_g_in_class_yp(-5, -3)) }, { new class_yp.class_b_in_class_yp() }, { new class_yp.class_b_in_class_yp() }, { new class_yp.class_e_in_class_yp(Items.ct, new class_yp.class_g_in_class_yp(20, 22)) } } },
									{ { { new class_yp.class_a_in_class_yp(Items.bv, new class_yp.class_g_in_class_yp(36, 40)), new class_yp.class_a_in_class_yp(Items.m, new class_yp.class_g_in_class_yp(8, 10)) }, { new class_yp.class_e_in_class_yp(Items.aE, new class_yp.class_g_in_class_yp(-4, -1)), new class_yp.class_e_in_class_yp(new class_aco(Items.aY, 1, class_abt.l.b()), new class_yp.class_g_in_class_yp(-2, -1)) },
										{ new class_yp.class_e_in_class_yp(Items.bM, new class_yp.class_g_in_class_yp(7, 11)), new class_yp.class_e_in_class_yp(Item.a(Blocks.aX), new class_yp.class_g_in_class_yp(-3, -1)) }, { new class_yp.class_e_in_class_yp(Items.bP, new class_yp.class_g_in_class_yp(3, 11)) } } },
										{
											{ { new class_yp.class_a_in_class_yp(Items.j, new class_yp.class_g_in_class_yp(16, 24)), new class_yp.class_e_in_class_yp(Items.aa, new class_yp.class_g_in_class_yp(4, 6)) }, { new class_yp.class_a_in_class_yp(Items.l, new class_yp.class_g_in_class_yp(7, 9)), new class_yp.class_e_in_class_yp(Items.ab, new class_yp.class_g_in_class_yp(10, 14)) },
												{ new class_yp.class_a_in_class_yp(Items.k, new class_yp.class_g_in_class_yp(3, 4)), new class_yp.class_c_in_class_yp(Items.af, new class_yp.class_g_in_class_yp(16, 19)) },
												{ new class_yp.class_e_in_class_yp(Items.Z, new class_yp.class_g_in_class_yp(5, 7)), new class_yp.class_e_in_class_yp(Items.Y, new class_yp.class_g_in_class_yp(9, 11)), new class_yp.class_e_in_class_yp(Items.W, new class_yp.class_g_in_class_yp(5, 7)), new class_yp.class_e_in_class_yp(Items.X, new class_yp.class_g_in_class_yp(11, 15)) } },
												{ { new class_yp.class_a_in_class_yp(Items.j, new class_yp.class_g_in_class_yp(16, 24)), new class_yp.class_e_in_class_yp(Items.c, new class_yp.class_g_in_class_yp(6, 8)) }, { new class_yp.class_a_in_class_yp(Items.l, new class_yp.class_g_in_class_yp(7, 9)), new class_yp.class_c_in_class_yp(Items.n, new class_yp.class_g_in_class_yp(9, 10)) },
													{ new class_yp.class_a_in_class_yp(Items.k, new class_yp.class_g_in_class_yp(3, 4)), new class_yp.class_c_in_class_yp(Items.w, new class_yp.class_g_in_class_yp(12, 15)), new class_yp.class_c_in_class_yp(Items.z, new class_yp.class_g_in_class_yp(9, 12)) } },
													{ { new class_yp.class_a_in_class_yp(Items.j, new class_yp.class_g_in_class_yp(16, 24)), new class_yp.class_c_in_class_yp(Items.a, new class_yp.class_g_in_class_yp(5, 7)) }, { new class_yp.class_a_in_class_yp(Items.l, new class_yp.class_g_in_class_yp(7, 9)), new class_yp.class_c_in_class_yp(Items.b, new class_yp.class_g_in_class_yp(9, 11)) },
														{ new class_yp.class_a_in_class_yp(Items.k, new class_yp.class_g_in_class_yp(3, 4)), new class_yp.class_c_in_class_yp(Items.y, new class_yp.class_g_in_class_yp(12, 15)) } } },
														{ { { new class_yp.class_a_in_class_yp(Items.an, new class_yp.class_g_in_class_yp(14, 18)), new class_yp.class_a_in_class_yp(Items.bm, new class_yp.class_g_in_class_yp(14, 18)) }, { new class_yp.class_a_in_class_yp(Items.j, new class_yp.class_g_in_class_yp(16, 24)), new class_yp.class_e_in_class_yp(Items.ao, new class_yp.class_g_in_class_yp(-7, -5)), new class_yp.class_e_in_class_yp(Items.bn, new class_yp.class_g_in_class_yp(-8, -6)) } },
															{ { new class_yp.class_a_in_class_yp(Items.aH, new class_yp.class_g_in_class_yp(9, 12)), new class_yp.class_e_in_class_yp(Items.U, new class_yp.class_g_in_class_yp(2, 4)) }, { new class_yp.class_c_in_class_yp(Items.T, new class_yp.class_g_in_class_yp(7, 12)) }, { new class_yp.class_e_in_class_yp(Items.aC, new class_yp.class_g_in_class_yp(8, 10)) } } } };
	}

	static class class_d_in_class_yp implements class_yp.class_f_in_class_yp {
		public class_aco a;
		public class_yp.class_g_in_class_yp b;
		public class_aco c;
		public class_yp.class_g_in_class_yp d;

		public class_d_in_class_yp(Item var1, class_yp.class_g_in_class_yp var2, Item var3, class_yp.class_g_in_class_yp var4) {
			a = new class_aco(var1);
			b = var2;
			c = new class_aco(var3);
			d = var4;
		}

		@Override
		public void a(class_agc var1, Random var2) {
			int var3 = 1;
			if (b != null) {
				var3 = b.a(var2);
			}

			int var4 = 1;
			if (d != null) {
				var4 = d.a(var2);
			}

			var1.add(new class_agb(new class_aco(a.b(), var3, a.i()), new class_aco(Items.bT), new class_aco(c.b(), var4, c.i())));
		}
	}

	static class class_b_in_class_yp implements class_yp.class_f_in_class_yp {
		@Override
		public void a(class_agc var1, Random var2) {
			class_afj var3 = (class_afj) class_afj.b.a(var2);
			int var4 = class_oa.a(var2, var3.d(), var3.b());
			class_aco var5 = Items.ci.a(new class_afm(var3, var4));
			int var6 = 2 + var2.nextInt(5 + (var4 * 10)) + (3 * var4);
			if (var6 > 64) {
				var6 = 64;
			}

			var1.add(new class_agb(new class_aco(Items.aN), new class_aco(Items.bT, var6), var5));
		}
	}

	static class class_c_in_class_yp implements class_yp.class_f_in_class_yp {
		public class_aco a;
		public class_yp.class_g_in_class_yp b;

		public class_c_in_class_yp(Item var1, class_yp.class_g_in_class_yp var2) {
			a = new class_aco(var1);
			b = var2;
		}

		@Override
		public void a(class_agc var1, Random var2) {
			int var3 = 1;
			if (b != null) {
				var3 = b.a(var2);
			}

			class_aco var4 = new class_aco(Items.bT, var3, 0);
			class_aco var5 = new class_aco(a.b(), 1, a.i());
			var5 = class_afl.a(var2, var5, 5 + var2.nextInt(15));
			var1.add(new class_agb(var4, var5));
		}
	}

	static class class_e_in_class_yp implements class_yp.class_f_in_class_yp {
		public class_aco a;
		public class_yp.class_g_in_class_yp b;

		public class_e_in_class_yp(Item var1, class_yp.class_g_in_class_yp var2) {
			a = new class_aco(var1);
			b = var2;
		}

		public class_e_in_class_yp(class_aco var1, class_yp.class_g_in_class_yp var2) {
			a = var1;
			b = var2;
		}

		@Override
		public void a(class_agc var1, Random var2) {
			int var3 = 1;
			if (b != null) {
				var3 = b.a(var2);
			}

			class_aco var4;
			class_aco var5;
			if (var3 < 0) {
				var4 = new class_aco(Items.bT);
				var5 = new class_aco(a.b(), -var3, a.i());
			} else {
				var4 = new class_aco(Items.bT, var3, 0);
				var5 = new class_aco(a.b(), 1, a.i());
			}

			var1.add(new class_agb(var4, var5));
		}
	}

	static class class_a_in_class_yp implements class_yp.class_f_in_class_yp {
		public Item a;
		public class_yp.class_g_in_class_yp b;

		public class_a_in_class_yp(Item var1, class_yp.class_g_in_class_yp var2) {
			a = var1;
			b = var2;
		}

		@Override
		public void a(class_agc var1, Random var2) {
			int var3 = 1;
			if (b != null) {
				var3 = b.a(var2);
			}

			var1.add(new class_agb(new class_aco(a, var3, 0), Items.bT));
		}
	}

	interface class_f_in_class_yp {
		void a(class_agc var1, Random var2);
	}

	static class class_g_in_class_yp extends class_oh {
		public class_g_in_class_yp(int var1, int var2) {
			super(Integer.valueOf(var1), Integer.valueOf(var2));
		}

		public int a(Random var1) {
			return ((Integer) this.a()).intValue() >= ((Integer) this.b()).intValue() ? ((Integer) this.a()).intValue() : ((Integer) this.a()).intValue() + var1.nextInt((((Integer) this.b()).intValue() - ((Integer) this.a()).intValue()) + 1);
		}
	}
}
