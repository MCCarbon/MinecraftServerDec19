package net.minecraft.server;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import com.google.common.base.Optional;
import com.google.common.base.Predicate;

public class class_vf extends class_vc implements class_pq {
	private static final Predicate bz = new Predicate() {
		public boolean a(Entity var1) {
			return (var1 instanceof class_vf) && ((class_vf) var1).cT();
		}

		// $FF: synthetic method
		@Override
		public boolean apply(Object var1) {
			return this.a((Entity) var1);
		}
	};
	private static final class_rp bA = (new class_rx((class_rp) null, "horse.jumpStrength", 0.7D, 0.0D, 2.0D)).a("Jump Strength").a(true);
	private static final class_jz bB;
	private static final class_jz bC;
	private static final class_jz bD;
	private static final class_jz bE;
	private static final class_jz bF;
	private static final String[] bG;
	private static final String[] bH;
	private static final int[] bI;
	private static final String[] bJ;
	private static final String[] bK;
	private static final String[] bL;
	private static final String[] bM;
	private int bN;
	private int bO;
	private int bP;
	public int bt;
	public int bu;
	protected boolean bv;
	private class_zv bQ;
	private boolean bR;
	protected int bx;
	protected float by;
	private boolean bS;
	private float bT;
	private float bU;
	private float bV;
	private float bW;
	private float bX;
	private float bY;
	private int bZ;
	private String ca;
	private String[] cb = new String[3];
	private boolean cc = false;

	public class_vf(class_ago var1) {
		super(var1);
		this.a(1.4F, 1.6F);
		ab = false;
		this.p(false);
		((class_ul) u()).a(true);
		i.a(0, new class_so(this));
		i.a(1, new class_tj(this, 1.2D));
		i.a(1, new class_ts(this, 1.2D));
		i.a(2, new class_sj(this, 1.0D));
		i.a(4, new class_sq(this, 1.0D));
		i.a(6, new class_tn(this, 0.7D));
		i.a(7, new class_sw(this, class_yu.class, 6.0F));
		i.a(8, new class_tm(this));
		dt();
	}

	@Override
	protected void h() {
		super.h();
		ac.a(bB, Byte.valueOf((byte) 0));
		ac.a(bC, Integer.valueOf(0));
		ac.a(bD, Integer.valueOf(0));
		ac.a(bE, Optional.absent());
		ac.a(bF, Integer.valueOf(0));
	}

	public void k(int var1) {
		ac.b(bC, Integer.valueOf(var1));
		dv();
	}

	public int cE() {
		return ((Integer) ac.a(bC)).intValue();
	}

	public void l(int var1) {
		ac.b(bD, Integer.valueOf(var1));
		dv();
	}

	public int cF() {
		return ((Integer) ac.a(bD)).intValue();
	}

	@Override
	public String e_() {
		if (k_()) {
			return aS();
		} else {
			int var1 = cE();
			switch (var1) {
				case 0:
				default:
					return class_di.a("entity.horse.name");
				case 1:
					return class_di.a("entity.donkey.name");
				case 2:
					return class_di.a("entity.mule.name");
				case 3:
					return class_di.a("entity.zombiehorse.name");
				case 4:
					return class_di.a("entity.skeletonhorse.name");
			}
		}
	}

	private boolean p(int var1) {
		return (((Byte) ac.a(bB)).byteValue() & var1) != 0;
	}

	private void c(int var1, boolean var2) {
		byte var3 = ((Byte) ac.a(bB)).byteValue();
		if (var2) {
			ac.b(bB, Byte.valueOf((byte) (var3 | var1)));
		} else {
			ac.b(bB, Byte.valueOf((byte) (var3 & ~var1)));
		}

	}

	public boolean cG() {
		return !i_();
	}

	public boolean cH() {
		return this.p(2);
	}

	public boolean cI() {
		return cG();
	}

	public UUID cM() {
		return (UUID) ((Optional) ac.a(bE)).orNull();
	}

	public void b(UUID var1) {
		ac.b(bE, Optional.fromNullable(var1));
	}

	public float cN() {
		return 0.5F;
	}

	@Override
	public void a(boolean var1) {
		if (var1) {
			this.a(cN());
		} else {
			this.a(1.0F);
		}

	}

	public boolean cO() {
		return bv;
	}

	public void m(boolean var1) {
		this.c(2, var1);
	}

	public void n(boolean var1) {
		bv = var1;
	}

	@Override
	public boolean ct() {
		return !dk() && super.ct();
	}

	@Override
	protected void p(float var1) {
		if ((var1 > 6.0F) && cR()) {
			this.s(false);
		}

	}

	public boolean cP() {
		return this.p(8);
	}

	public int cQ() {
		return ((Integer) ac.a(bF)).intValue();
	}

	private int f(class_aco var1) {
		if (var1 == null) {
			return 0;
		} else {
			Item var2 = var1.b();
			return var2 == Items.cp ? 1 : (var2 == Items.cq ? 2 : (var2 == Items.cr ? 3 : 0));
		}
	}

	public boolean cR() {
		return this.p(32);
	}

	public boolean cS() {
		return this.p(64);
	}

	public boolean cT() {
		return this.p(16);
	}

	public boolean cU() {
		return bR;
	}

	public void e(class_aco var1) {
		ac.b(bF, Integer.valueOf(this.f(var1)));
		dv();
	}

	public void o(boolean var1) {
		this.c(16, var1);
	}

	public void p(boolean var1) {
		this.c(8, var1);
	}

	public void q(boolean var1) {
		bR = var1;
	}

	public void r(boolean var1) {
		this.c(4, var1);
	}

	public int cV() {
		return bx;
	}

	public void m(int var1) {
		bx = var1;
	}

	public int n(int var1) {
		int var2 = class_oa.a(cV() + var1, 0, db());
		this.m(var2);
		return var2;
	}

	@Override
	public boolean a(class_qi var1, float var2) {
		Entity var3 = var1.j();
		return (l != null) && l.equals(var3) ? false : super.a(var1, var2);
	}

	@Override
	public int by() {
		return bI[cQ()];
	}

	@Override
	public boolean ah() {
		return l == null;
	}

	public boolean cW() {
		int var1 = class_oa.c(s);
		int var2 = class_oa.c(u);
		o.b(new class_cj(var1, 0, var2));
		return true;
	}

	public void cX() {
		if (!o.D && cP()) {
			this.a(Item.a(Blocks.CHEST), 1);
			this.p(false);
		}
	}

	private void dr() {
		dy();
		if (!T()) {
			o.a(this, "eating", 1.0F, 1.0F + ((V.nextFloat() - V.nextFloat()) * 0.2F));
		}

	}

	@Override
	public void e(float var1, float var2) {
		if (var1 > 1.0F) {
			this.a("mob.horse.land", 0.4F, 1.0F);
		}

		int var3 = class_oa.f(((var1 * 0.5F) - 3.0F) * var2);
		if (var3 > 0) {
			this.a(class_qi.i, var3);
			if (l != null) {
				l.a(class_qi.i, var3);
			}

			Block var4 = o.p(new class_cj(s, t - 0.2D - A, u)).c();
			if ((var4.v() != class_avq.a) && !T()) {
				Block.class_d_in_class_ail var5 = var4.H;
				o.a(this, var5.c(), var5.d() * 0.5F, var5.e() * 0.75F);
			}

		}
	}

	private int ds() {
		int var1 = cE();
		return !cP() || ((var1 != 1) && (var1 != 2)) ? 2 : 17;
	}

	private void dt() {
		class_zv var1 = bQ;
		bQ = new class_zv("HorseChest", ds());
		bQ.a(e_());
		if (var1 != null) {
			var1.b(this);
			int var2 = Math.min(var1.n_(), bQ.n_());

			for (int var3 = 0; var3 < var2; ++var3) {
				class_aco var4 = var1.a(var3);
				if (var4 != null) {
					bQ.a(var3, var4.k());
				}
			}
		}

		bQ.a(this);
		du();
	}

	private void du() {
		if (!o.D) {
			this.r(bQ.a(0) != null);
			if (dh()) {
				this.e(bQ.a(1));
			}
		}

	}

	@Override
	public void a(class_qc var1) {
		int var2 = cQ();
		boolean var3 = cZ();
		du();
		if (W > 20) {
			if ((var2 == 0) && (var2 != cQ())) {
				this.a("mob.horse.armor", 0.5F, 1.0F);
			} else if (var2 != cQ()) {
				this.a("mob.horse.armor", 0.5F, 1.0F);
			}

			if (!var3 && cZ()) {
				this.a("mob.horse.leather", 0.5F, 1.0F);
			}
		}

	}

	@Override
	public boolean cj() {
		cW();
		return super.cj();
	}

	protected class_vf a(Entity var1, double var2) {
		double var4 = Double.MAX_VALUE;
		Entity var6 = null;
		List var7 = o.a(var1, var1.aX().a(var2, var2, var2), bz);
		Iterator var8 = var7.iterator();

		while (var8.hasNext()) {
			Entity var9 = (Entity) var8.next();
			double var10 = var9.e(var1.s, var1.t, var1.u);
			if (var10 < var4) {
				var6 = var9;
				var4 = var10;
			}
		}

		return (class_vf) var6;
	}

	public double cY() {
		return this.a(bA).e();
	}

	@Override
	protected String bw() {
		dy();
		int var1 = cE();
		return var1 == 3 ? "mob.horse.zombie.death" : (var1 == 4 ? "mob.horse.skeleton.death" : ((var1 != 1) && (var1 != 2) ? "mob.horse.death" : "mob.horse.donkey.death"));
	}

	@Override
	protected Item D() {
		boolean var1 = V.nextInt(4) == 0;
		int var2 = cE();
		return var2 == 4 ? Items.aZ : (var2 == 3 ? (var1 ? null : Items.bv) : Items.aH);
	}

	@Override
	protected String bv() {
		dy();
		if (V.nextInt(3) == 0) {
			dA();
		}

		int var1 = cE();
		return var1 == 3 ? "mob.horse.zombie.hit" : (var1 == 4 ? "mob.horse.skeleton.hit" : ((var1 != 1) && (var1 != 2) ? "mob.horse.hit" : "mob.horse.donkey.hit"));
	}

	public boolean cZ() {
		return this.p(4);
	}

	@Override
	protected String B() {
		dy();
		if ((V.nextInt(10) == 0) && !bK()) {
			dA();
		}

		int var1 = cE();
		return var1 == 3 ? "mob.horse.zombie.idle" : (var1 == 4 ? "mob.horse.skeleton.idle" : ((var1 != 1) && (var1 != 2) ? "mob.horse.idle" : "mob.horse.donkey.idle"));
	}

	protected String da() {
		dy();
		dA();
		int var1 = cE();
		return (var1 != 3) && (var1 != 4) ? ((var1 != 1) && (var1 != 2) ? "mob.horse.angry" : "mob.horse.donkey.angry") : null;
	}

	@Override
	protected void a(class_cj var1, Block var2) {
		Block.class_d_in_class_ail var3 = var2.H;
		if (o.p(var1.a()).c() == Blocks.SNOW_LAYER) {
			var3 = Blocks.SNOW_LAYER.H;
		}

		if (!var2.v().d()) {
			int var4 = cE();
			if ((l != null) && (var4 != 1) && (var4 != 2)) {
				++bZ;
				if ((bZ > 5) && ((bZ % 3) == 0)) {
					this.a("mob.horse.gallop", var3.d() * 0.15F, var3.e());
					if ((var4 == 0) && (V.nextInt(10) == 0)) {
						this.a("mob.horse.breathe", var3.d() * 0.6F, var3.e());
					}
				} else if (bZ <= 5) {
					this.a("mob.horse.wood", var3.d() * 0.15F, var3.e());
				}
			} else if (var3 == Block.f) {
				this.a("mob.horse.wood", var3.d() * 0.15F, var3.e());
			} else {
				this.a("mob.horse.soft", var3.d() * 0.15F, var3.e());
			}
		}

	}

	@Override
	protected void be() {
		super.be();
		bE().b(bA);
		this.a(class_yf.a).a(53.0D);
		this.a(class_yf.d).a(0.22499999403953552D);
	}

	@Override
	public int cn() {
		return 6;
	}

	public int db() {
		return 100;
	}

	@Override
	protected float bI() {
		return 0.8F;
	}

	@Override
	public int y() {
		return 400;
	}

	private void dv() {
		ca = null;
	}

	public void c(class_yu var1) {
		if (!o.D && ((l == null) || (l == var1)) && cH()) {
			bQ.a(e_());
			var1.a(this, bQ);
		}

	}

	@Override
	public boolean a(class_yu var1, class_pu var2, class_aco var3) {
		if ((var3 != null) && (var3.b() == Items.bO)) {
			return super.a(var1, var2, var3);
		} else if (!cH() && dk()) {
			return false;
		} else if (cH() && cG() && var1.aA()) {
			this.c(var1);
			return true;
		} else if (cI() && (l != null)) {
			return super.a(var1, var2, var3);
		} else {
			if (var3 != null) {
				if (dh()) {
					byte var4 = -1;
					if (var3.b() == Items.cp) {
						var4 = 1;
					} else if (var3.b() == Items.cq) {
						var4 = 2;
					} else if (var3.b() == Items.cr) {
						var4 = 3;
					}

					if (var4 >= 0) {
						if (!cH()) {
							dp();
							return true;
						}

						this.c(var1);
						return true;
					}
				}

				boolean var8 = false;
				if (!dk()) {
					float var5 = 0.0F;
					short var6 = 0;
					byte var7 = 0;
					if (var3.b() == Items.Q) {
						var5 = 2.0F;
						var6 = 20;
						var7 = 3;
					} else if (var3.b() == Items.ba) {
						var5 = 1.0F;
						var6 = 30;
						var7 = 3;
					} else if (Block.a(var3.b()) == Blocks.HAY_BLOCK) {
						var5 = 20.0F;
						var6 = 180;
					} else if (var3.b() == Items.e) {
						var5 = 3.0F;
						var6 = 60;
						var7 = 3;
					} else if (var3.b() == Items.cb) {
						var5 = 4.0F;
						var6 = 60;
						var7 = 5;
						if (cH() && (this.k() == 0)) {
							var8 = true;
							this.a(var1);
						}
					} else if (var3.b() == Items.aq) {
						var5 = 10.0F;
						var6 = 240;
						var7 = 10;
						if (cH() && (this.k() == 0)) {
							var8 = true;
							this.a(var1);
						}
					}

					if ((bu() < bB()) && (var5 > 0.0F)) {
						this.b(var5);
						var8 = true;
					}

					if (!cG() && (var6 > 0)) {
						this.a(var6);
						var8 = true;
					}

					if ((var7 > 0) && (var8 || !cH()) && (var7 < db())) {
						var8 = true;
						this.n(var7);
					}

					if (var8) {
						dr();
					}
				}

				if (!cH() && !var8) {
					if (var3.a(var1, this, var2)) {
						return true;
					}

					dp();
					return true;
				}

				if (!var8 && di() && !cP() && (var3.b() == Item.a(Blocks.CHEST))) {
					this.p(true);
					this.a("mob.chickenplop", 1.0F, ((V.nextFloat() - V.nextFloat()) * 0.2F) + 1.0F);
					var8 = true;
					dt();
				}

				if (!var8 && cI() && !cZ() && (var3.b() == Items.aC)) {
					this.c(var1);
					return true;
				}

				if (var8) {
					if (!var1.bI.d) {
						--var3.b;
					}

					return true;
				}
			}

			if (cI() && (l == null)) {
				if ((var3 != null) && var3.a(var1, this, var2)) {
					return true;
				} else {
					this.g(var1);
					return true;
				}
			} else {
				return super.a(var1, var2, var3);
			}
		}
	}

	private void g(class_yu var1) {
		var1.y = y;
		var1.z = z;
		this.s(false);
		this.t(false);
		if (!o.D) {
			var1.a((Entity) this);
		}

	}

	public boolean dh() {
		return cE() == 0;
	}

	public boolean di() {
		int var1 = cE();
		return (var1 == 2) || (var1 == 1);
	}

	@Override
	protected boolean bK() {
		return (l != null) && cZ() ? true : cR() || cS();
	}

	public boolean dk() {
		int var1 = cE();
		return (var1 == 3) || (var1 == 4);
	}

	public boolean dl() {
		return dk() || (cE() == 2);
	}

	@Override
	public boolean d(class_aco var1) {
		return false;
	}

	private void dx() {
		bt = 1;
	}

	@Override
	public void a(class_qi var1) {
		super.a(var1);
		if (!o.D) {
			dq();
		}

	}

	@Override
	public void m() {
		if (V.nextInt(200) == 0) {
			dx();
		}

		super.m();
		if (!o.D) {
			if ((V.nextInt(900) == 0) && (aA == 0)) {
				this.b(1.0F);
			}

			if (!cR() && (l == null) && (V.nextInt(300) == 0) && (o.p(new class_cj(class_oa.c(s), class_oa.c(t) - 1, class_oa.c(u))).c() == Blocks.GRASS)) {
				this.s(true);
			}

			if (cR() && (++bN > 50)) {
				bN = 0;
				this.s(false);
			}

			if (cT() && !cG() && !cR()) {
				class_vf var1 = this.a(this, 16.0D);
				if ((var1 != null) && (this.h(var1) > 4.0D)) {
					h.a(var1);
				}
			}
		}

	}

	@Override
	public void r_() {
		super.r_();
		if (o.D && ac.a()) {
			ac.e();
			dv();
		}

		if ((bO > 0) && (++bO > 30)) {
			bO = 0;
			this.c(128, false);
		}

		if (!o.D && (bP > 0) && (++bP > 20)) {
			bP = 0;
			this.t(false);
		}

		if ((bt > 0) && (++bt > 8)) {
			bt = 0;
		}

		if (bu > 0) {
			++bu;
			if (bu > 300) {
				bu = 0;
			}
		}

		bU = bT;
		if (cR()) {
			bT += ((1.0F - bT) * 0.4F) + 0.05F;
			if (bT > 1.0F) {
				bT = 1.0F;
			}
		} else {
			bT += ((0.0F - bT) * 0.4F) - 0.05F;
			if (bT < 0.0F) {
				bT = 0.0F;
			}
		}

		bW = bV;
		if (cS()) {
			bU = bT = 0.0F;
			bV += ((1.0F - bV) * 0.4F) + 0.05F;
			if (bV > 1.0F) {
				bV = 1.0F;
			}
		} else {
			bS = false;
			bV += (((0.8F * bV * bV * bV) - bV) * 0.6F) - 0.05F;
			if (bV < 0.0F) {
				bV = 0.0F;
			}
		}

		bY = bX;
		if (this.p(128)) {
			bX += ((1.0F - bX) * 0.7F) + 0.05F;
			if (bX > 1.0F) {
				bX = 1.0F;
			}
		} else {
			bX += ((0.0F - bX) * 0.7F) - 0.05F;
			if (bX < 0.0F) {
				bX = 0.0F;
			}
		}

	}

	private void dy() {
		if (!o.D) {
			bO = 1;
			this.c(128, true);
		}

	}

	private boolean dz() {
		return (l == null) && (m == null) && cH() && cG() && !dl() && (bu() >= bB()) && cK();
	}

	public void s(boolean var1) {
		this.c(32, var1);
	}

	public void t(boolean var1) {
		if (var1) {
			this.s(false);
		}

		this.c(64, var1);
	}

	private void dA() {
		if (!o.D) {
			bP = 1;
			this.t(true);
		}

	}

	public void dp() {
		dA();
		String var1 = da();
		if (var1 != null) {
			this.a(var1, bI(), bJ());
		}

	}

	public void dq() {
		this.a(this, bQ);
		cX();
	}

	private void a(Entity var1, class_zv var2) {
		if ((var2 != null) && !o.D) {
			for (int var3 = 0; var3 < var2.n_(); ++var3) {
				class_aco var4 = var2.a(var3);
				if (var4 != null) {
					this.a(var4, 0.0F);
				}
			}

		}
	}

	public boolean f(class_yu var1) {
		this.b(var1.aQ());
		this.m(true);
		return true;
	}

	@Override
	public void g(float var1, float var2) {
		if ((l != null) && (l instanceof class_rg) && cZ()) {
			A = y = l.y;
			z = l.z * 0.5F;
			this.b(y, z);
			aO = aM = y;
			var1 = ((class_rg) l).bd * 0.5F;
			var2 = ((class_rg) l).be;
			if (var2 <= 0.0F) {
				var2 *= 0.25F;
				bZ = 0;
			}

			if (C && (by == 0.0F) && cS() && !bS) {
				var1 = 0.0F;
				var2 = 0.0F;
			}

			if ((by > 0.0F) && !cO() && C) {
				w = cY() * by;
				if (this.a(class_qs.h)) {
					w += (this.b(class_qs.h).c() + 1) * 0.1F;
				}

				this.n(true);
				ai = true;
				if (var2 > 0.0F) {
					float var3 = class_oa.a((y * 3.1415927F) / 180.0F);
					float var4 = class_oa.b((y * 3.1415927F) / 180.0F);
					v += -0.4F * var3 * by;
					x += 0.4F * var4 * by;
					this.a("mob.horse.jump", 0.4F, 1.0F);
				}

				by = 0.0F;
			}

			S = 1.0F;
			aQ = bP() * 0.1F;
			if (!o.D) {
				this.l((float) this.a(class_yf.d).e());
				super.g(var1, var2);
			}

			if (C) {
				by = 0.0F;
				this.n(false);
			}

			aE = aF;
			double var8 = s - p;
			double var5 = u - r;
			float var7 = class_oa.a((var8 * var8) + (var5 * var5)) * 4.0F;
			if (var7 > 1.0F) {
				var7 = 1.0F;
			}

			aF += (var7 - aF) * 0.4F;
			aG += aF;
		} else {
			S = 0.5F;
			aQ = 0.02F;
			super.g(var1, var2);
		}
	}

	@Override
	public void b(class_dn var1) {
		super.b(var1);
		var1.a("EatingHaystack", cR());
		var1.a("ChestedHorse", cP());
		var1.a("HasReproduced", cU());
		var1.a("Bred", cT());
		var1.a("Type", cE());
		var1.a("Variant", cF());
		var1.a("Temper", cV());
		var1.a("Tame", cH());
		if (cM() != null) {
			var1.a("OwnerUUID", cM().toString());
		}

		if (cP()) {
			class_du var2 = new class_du();

			for (int var3 = 2; var3 < bQ.n_(); ++var3) {
				class_aco var4 = bQ.a(var3);
				if (var4 != null) {
					class_dn var5 = new class_dn();
					var5.a("Slot", (byte) var3);
					var4.b(var5);
					var2.a(var5);
				}
			}

			var1.a("Items", var2);
		}

		if (bQ.a(1) != null) {
			var1.a("ArmorItem", bQ.a(1).b(new class_dn()));
		}

		if (bQ.a(0) != null) {
			var1.a("SaddleItem", bQ.a(0).b(new class_dn()));
		}

	}

	@Override
	public void a(class_dn var1) {
		super.a(var1);
		this.s(var1.p("EatingHaystack"));
		this.o(var1.p("Bred"));
		this.p(var1.p("ChestedHorse"));
		this.q(var1.p("HasReproduced"));
		this.k(var1.h("Type"));
		this.l(var1.h("Variant"));
		this.m(var1.h("Temper"));
		this.m(var1.p("Tame"));
		String var2 = "";
		if (var1.b("OwnerUUID", 8)) {
			var2 = var1.l("OwnerUUID");
		} else {
			String var3 = var1.l("Owner");
			var2 = class_md.a(var3);
		}

		if (!var2.isEmpty()) {
			this.b(UUID.fromString(var2));
		}

		class_rq var8 = bE().a("Speed");
		if (var8 != null) {
			this.a(class_yf.d).a(var8.b() * 0.25D);
		}

		if (cP()) {
			class_du var4 = var1.c("Items", 10);
			dt();

			for (int var5 = 0; var5 < var4.c(); ++var5) {
				class_dn var6 = var4.b(var5);
				int var7 = var6.f("Slot") & 255;
				if ((var7 >= 2) && (var7 < bQ.n_())) {
					bQ.a(var7, class_aco.a(var6));
				}
			}
		}

		class_aco var9;
		if (var1.b("ArmorItem", 10)) {
			var9 = class_aco.a(var1.o("ArmorItem"));
			if ((var9 != null) && a(var9.b())) {
				bQ.a(1, var9);
			}
		}

		if (var1.b("SaddleItem", 10)) {
			var9 = class_aco.a(var1.o("SaddleItem"));
			if ((var9 != null) && (var9.b() == Items.aC)) {
				bQ.a(0, var9);
			}
		}

		du();
	}

	@Override
	public boolean a(class_vc var1) {
		if (var1 == this) {
			return false;
		} else if (var1.getClass() != this.getClass()) {
			return false;
		} else {
			class_vf var2 = (class_vf) var1;
			if (dz() && var2.dz()) {
				int var3 = cE();
				int var4 = var2.cE();
				return (var3 == var4) || ((var3 == 0) && (var4 == 1)) || ((var3 == 1) && (var4 == 0));
			} else {
				return false;
			}
		}
	}

	@Override
	public class_qu a(class_qu var1) {
		class_vf var2 = (class_vf) var1;
		class_vf var3 = new class_vf(o);
		int var4 = cE();
		int var5 = var2.cE();
		int var6 = 0;
		if (var4 == var5) {
			var6 = var4;
		} else if (((var4 == 0) && (var5 == 1)) || ((var4 == 1) && (var5 == 0))) {
			var6 = 2;
		}

		if (var6 == 0) {
			int var8 = V.nextInt(9);
			int var7;
			if (var8 < 4) {
				var7 = cF() & 255;
			} else if (var8 < 8) {
				var7 = var2.cF() & 255;
			} else {
				var7 = V.nextInt(7);
			}

			int var9 = V.nextInt(5);
			if (var9 < 2) {
				var7 |= cF() & '\uff00';
			} else if (var9 < 4) {
				var7 |= var2.cF() & '\uff00';
			} else {
				var7 |= (V.nextInt(5) << 8) & '\uff00';
			}

			var3.l(var7);
		}

		var3.k(var6);
		double var14 = this.a(class_yf.a).b() + var1.a(class_yf.a).b() + dB();
		var3.a(class_yf.a).a(var14 / 3.0D);
		double var13 = this.a(bA).b() + var1.a(bA).b() + dC();
		var3.a(bA).a(var13 / 3.0D);
		double var11 = this.a(class_yf.d).b() + var1.a(class_yf.d).b() + dD();
		var3.a(class_yf.d).a(var11 / 3.0D);
		return var3;
	}

	@Override
	public class_rj a(class_pt var1, class_rj var2) {
		Object var7 = super.a(var1, var2);
		boolean var3 = false;
		int var4 = 0;
		int var8;
		if (var7 instanceof class_vf.class_a_in_class_vf) {
			var8 = ((class_vf.class_a_in_class_vf) var7).a;
			var4 = (((class_vf.class_a_in_class_vf) var7).b & 255) | (V.nextInt(5) << 8);
		} else {
			if (V.nextInt(10) == 0) {
				var8 = 1;
			} else {
				int var5 = V.nextInt(7);
				int var6 = V.nextInt(5);
				var8 = 0;
				var4 = var5 | (var6 << 8);
			}

			var7 = new class_vf.class_a_in_class_vf(var8, var4);
		}

		this.k(var8);
		this.l(var4);
		if (V.nextInt(5) == 0) {
			this.b(-24000);
		}

		if ((var8 != 4) && (var8 != 3)) {
			this.a(class_yf.a).a(dB());
			if (var8 == 0) {
				this.a(class_yf.d).a(dD());
			} else {
				this.a(class_yf.d).a(0.17499999701976776D);
			}
		} else {
			this.a(class_yf.a).a(15.0D);
			this.a(class_yf.d).a(0.20000000298023224D);
		}

		if ((var8 != 2) && (var8 != 1)) {
			this.a(bA).a(dC());
		} else {
			this.a(bA).a(0.5D);
		}

		this.c(bB());
		return (class_rj) var7;
	}

	public void o(int var1) {
		if (cZ()) {
			if (var1 < 0) {
				var1 = 0;
			} else {
				bS = true;
				dA();
			}

			if (var1 >= 90) {
				by = 1.0F;
			} else {
				by = 0.4F + ((0.4F * var1) / 90.0F);
			}
		}

	}

	@Override
	public void ao() {
		super.ao();
		if (bW > 0.0F) {
			float var1 = class_oa.a((aM * 3.1415927F) / 180.0F);
			float var2 = class_oa.b((aM * 3.1415927F) / 180.0F);
			float var3 = 0.7F * bW;
			float var4 = 0.15F * bW;
			l.b(s + var3 * var1, t + aq() + l.ap() + var4, u - var3 * var2);
			if (l instanceof class_rg) {
				((class_rg) l).aM = aM;
			}
		}

	}

	private float dB() {
		return 15.0F + V.nextInt(8) + V.nextInt(9);
	}

	private double dC() {
		return 0.4000000059604645D + (V.nextDouble() * 0.2D) + (V.nextDouble() * 0.2D) + (V.nextDouble() * 0.2D);
	}

	private double dD() {
		return (0.44999998807907104D + (V.nextDouble() * 0.3D) + (V.nextDouble() * 0.3D) + (V.nextDouble() * 0.3D)) * 0.25D;
	}

	public static boolean a(Item var0) {
		return (var0 == Items.cp) || (var0 == Items.cq) || (var0 == Items.cr);
	}

	@Override
	public boolean j_() {
		return false;
	}

	@Override
	public float aY() {
		return K;
	}

	@Override
	public boolean c(int var1, class_aco var2) {
		if ((var1 == 499) && di()) {
			if ((var2 == null) && cP()) {
				this.p(false);
				dt();
				return true;
			}

			if ((var2 != null) && (var2.b() == Item.a(Blocks.CHEST)) && !cP()) {
				this.p(true);
				dt();
				return true;
			}
		}

		int var3 = var1 - 400;
		if ((var3 >= 0) && (var3 < 2) && (var3 < bQ.n_())) {
			if ((var3 == 0) && (var2 != null) && (var2.b() != Items.aC)) {
				return false;
			} else if ((var3 != 1) || (((var2 == null) || a(var2.b())) && dh())) {
				bQ.a(var3, var2);
				du();
				return true;
			} else {
				return false;
			}
		} else {
			int var4 = (var1 - 500) + 2;
			if ((var4 >= 2) && (var4 < bQ.n_())) {
				bQ.a(var4, var2);
				return true;
			} else {
				return false;
			}
		}
	}

	static {
		bB = class_kc.a(class_vf.class, class_kb.a);
		bC = class_kc.a(class_vf.class, class_kb.b);
		bD = class_kc.a(class_vf.class, class_kb.b);
		bE = class_kc.a(class_vf.class, class_kb.l);
		bF = class_kc.a(class_vf.class, class_kb.b);
		bG = new String[] { null, "textures/entity/horse/armor/horse_armor_iron.png", "textures/entity/horse/armor/horse_armor_gold.png", "textures/entity/horse/armor/horse_armor_diamond.png" };
		bH = new String[] { "", "meo", "goo", "dio" };
		bI = new int[] { 0, 5, 7, 11 };
		bJ = new String[] { "textures/entity/horse/horse_white.png", "textures/entity/horse/horse_creamy.png", "textures/entity/horse/horse_chestnut.png", "textures/entity/horse/horse_brown.png", "textures/entity/horse/horse_black.png", "textures/entity/horse/horse_gray.png", "textures/entity/horse/horse_darkbrown.png" };
		bK = new String[] { "hwh", "hcr", "hch", "hbr", "hbl", "hgr", "hdb" };
		bL = new String[] { null, "textures/entity/horse/horse_markings_white.png", "textures/entity/horse/horse_markings_whitefield.png", "textures/entity/horse/horse_markings_whitedots.png", "textures/entity/horse/horse_markings_blackdots.png" };
		bM = new String[] { "", "wo_", "wmo", "wdo", "bdo" };
	}

	public static class class_a_in_class_vf implements class_rj {
		public int a;
		public int b;

		public class_a_in_class_vf(int var1, int var2) {
			a = var1;
			b = var2;
		}
	}
}
