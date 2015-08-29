package net.minecraft.server;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.mojang.authlib.GameProfile;

public abstract class class_yu extends EntityLiving {
	private static final class_jz a;
	private static final class_jz b;
	protected static final class_jz bo;
	protected static final class_jz bp;
	public class_yt bq = new class_yt(this);
	private class_aap c = new class_aap();
	public class_zu br;
	public class_zu bs;
	protected class_zs bt = new class_zs();
	protected int bu;
	public float bv;
	public float bw;
	public int bx;
	public double by;
	public double bz;
	public double bA;
	public double bB;
	public double bC;
	public double bD;
	protected boolean bE;
	public class_cj bF;
	private int d;
	public float bG;
	public float bH;
	private class_cj e;
	private boolean f;
	private class_cj g;
	public class_ys bI = new class_ys();
	public int bJ;
	public int bK;
	public float bL;
	private int h;
	protected float bM = 0.1F;
	protected float bN = 0.02F;
	private int i;
	private final GameProfile bP;
	private boolean bQ = false;
	private class_aco bR = null;
	private final class_acn bS = this.k();
	public class_wy bO;

	protected class_acn k() {
		return new class_acn();
	}

	public class_yu(class_ago var1, GameProfile var2) {
		super(var1);
		aq = a(var2);
		bP = var2;
		br = new class_aak(bq, !var1.D, this);
		bs = br;
		class_cj var3 = var1.O();
		this.b(var3.n() + 0.5D, var3.o() + 1, var3.p() + 0.5D, 0.0F, 0.0F);
		aZ = 180.0F;
		X = 20;
	}

	@Override
	protected void be() {
		super.be();
		bE().b(class_yf.e).a(1.0D);
		this.a(class_yf.d).a(0.10000000149011612D);
		bE().b(class_yf.f);
	}

	@Override
	protected void h() {
		super.h();
		ac.a(a, Float.valueOf(0.0F));
		ac.a(b, Integer.valueOf(0));
		ac.a(bo, Byte.valueOf((byte) 0));
		ac.a(bp, Byte.valueOf((byte) 1));
	}

	@Override
	public void r_() {
		T = w();
		if (w()) {
			C = false;
		}

		if (bx > 0) {
			--bx;
		}

		if (bQ()) {
			++d;
			if (d > 100) {
				d = 100;
			}

			if (!o.D) {
				if (!this.n()) {
					this.a(true, true, false);
				} else if (o.z()) {
					this.a(false, true, true);
				}
			}
		} else if (d > 0) {
			++d;
			if (d >= 110) {
				d = 0;
			}
		}

		super.r_();
		if (!o.D && (bs != null) && !bs.a(this)) {
			this.o();
			bs = br;
		}

		if (ay() && bI.a) {
			P();
		}

		by = bB;
		bz = bC;
		bA = bD;
		double var1 = s - bB;
		double var3 = t - bC;
		double var5 = u - bD;
		double var7 = 10.0D;
		if (var1 > var7) {
			by = bB = s;
		}

		if (var5 > var7) {
			bA = bD = u;
		}

		if (var3 > var7) {
			bz = bC = t;
		}

		if (var1 < -var7) {
			by = bB = s;
		}

		if (var5 < -var7) {
			bA = bD = u;
		}

		if (var3 < -var7) {
			bz = bC = t;
		}

		bB += var1 * 0.25D;
		bD += var5 * 0.25D;
		bC += var3 * 0.25D;
		if (m == null) {
			g = null;
		}

		if (!o.D) {
			bt.a(this);
			this.b(StatisticList.g);
			if (al()) {
				this.b(StatisticList.h);
			}

			if (aA()) {
				this.b(StatisticList.i);
			}
		}

		int var9 = 29999999;
		double var10 = MathHelper.a(s, -2.9999999E7D, 2.9999999E7D);
		double var12 = MathHelper.a(u, -2.9999999E7D, 2.9999999E7D);
		if ((var10 != s) || (var12 != u)) {
			this.b(var10, t, var12);
		}

		++aD;
		class_aco var14 = bG();
		if (!class_aco.b(bR, var14)) {
			bR = var14 == null ? null : var14.k();
			cA();
		}

		bS.a();
	}

	@Override
	public int N() {
		return bI.a ? 0 : 80;
	}

	@Override
	protected String R() {
		return "game.player.swim";
	}

	@Override
	protected String ad() {
		return "game.player.swim.splash";
	}

	@Override
	public int at() {
		return 10;
	}

	@Override
	public void a(String var1, float var2, float var3) {
		o.a(this, var1, var2, var3);
	}

	@Override
	protected boolean bK() {
		return (bu() <= 0.0F) || bQ();
	}

	protected void o() {
		bs = br;
	}

	@Override
	public void an() {
		if (!o.D && aA()) {
			this.a((Entity) null);
			this.c(false);
		} else {
			double var1 = s;
			double var3 = t;
			double var5 = u;
			float var7 = y;
			float var8 = z;
			super.an();
			bv = bw;
			bw = 0.0F;
			this.l(s - var1, t - var3, u - var5);
			if (m instanceof EntityPig) {
				z = var8;
				y = var7;
				aM = ((EntityPig) m).aM;
			}

		}
	}

	@Override
	protected void bR() {
		super.bR();
		bD();
		aO = y;
	}

	@Override
	public void m() {
		if (bu > 0) {
			--bu;
		}

		if ((o.ac() == class_ps.a) && o.S().b("naturalRegeneration")) {
			if ((bu() < bB()) && ((W % 20) == 0)) {
				this.b(1.0F);
			}

			if (bt.c() && ((W % 10) == 0)) {
				bt.a(bt.a() + 1);
			}
		}

		bq.k();
		bv = bw;
		super.m();
		class_rq var1 = this.a(class_yf.d);
		if (!o.D) {
			var1.a(bI.b());
		}

		aQ = bN;
		if (aB()) {
			aQ = (float) (aQ + (bN * 0.3D));
		}

		this.l((float) var1.e());
		float var2 = MathHelper.a((v * v) + (x * x));
		float var3 = (float) (Math.atan(-w * 0.20000000298023224D) * 15.0D);
		if (var2 > 0.1F) {
			var2 = 0.1F;
		}

		if (!C || (bu() <= 0.0F)) {
			var2 = 0.0F;
		}

		if (C || (bu() <= 0.0F)) {
			var3 = 0.0F;
		}

		bw += (var2 - bw) * 0.4F;
		aJ += (var3 - aJ) * 0.8F;
		if ((bu() > 0.0F) && !w()) {
			class_ayk var4 = null;
			if ((m != null) && !m.I) {
				var4 = aX().a(m.aX()).b(1.0D, 0.0D, 1.0D);
			} else {
				var4 = aX().b(1.0D, 0.5D, 1.0D);
			}

			List var5 = o.b(this, var4);

			for (int var6 = 0; var6 < var5.size(); ++var6) {
				Entity var7 = (Entity) var5.get(var6);
				if (!var7.I) {
					this.d(var7);
				}
			}
		}

	}

	private void d(Entity var1) {
		var1.d(this);
	}

	public int cg() {
		return ((Integer) ac.a(b)).intValue();
	}

	public void k(int var1) {
		ac.b(b, Integer.valueOf(var1));
	}

	public void l(int var1) {
		int var2 = cg();
		ac.b(b, Integer.valueOf(var2 + var1));
	}

	@Override
	public void a(class_qi var1) {
		super.a(var1);
		this.a(0.2F, 0.2F);
		this.b(s, t, u);
		w = 0.10000000149011612D;
		if (e_().equals("Notch")) {
			this.a(new class_aco(Items.e, 1), true, false);
		}

		if (!o.S().b("keepInventory")) {
			bq.m();
		}

		if (var1 != null) {
			v = -MathHelper.b(((az + y) * 3.1415927F) / 180.0F) * 0.1F;
			x = -MathHelper.a(((az + y) * 3.1415927F) / 180.0F) * 0.1F;
		} else {
			v = x = 0.0D;
		}

		this.b(StatisticList.z);
		this.a(StatisticList.h);
	}

	@Override
	protected String bv() {
		return "game.player.hurt";
	}

	@Override
	protected String bw() {
		return "game.player.die";
	}

	@Override
	public void b(Entity var1, int var2) {
		this.l(var2);
		Collection var3 = cx().a(class_ayy.f);
		if (var1 instanceof class_yu) {
			this.b(StatisticList.C);
			var3.addAll(cx().a(class_ayy.e));
			var3.addAll(this.e(var1));
		} else {
			this.b(StatisticList.A);
		}

		Iterator var4 = var3.iterator();

		while (var4.hasNext()) {
			class_ayo var5 = (class_ayo) var4.next();
			class_ayq var6 = cx().c(e_(), var5);
			var6.a();
		}

	}

	private Collection e(Entity var1) {
		class_ayp var2 = cx().h(e_());
		if (var2 != null) {
			int var3 = var2.l().getId();
			if ((var3 >= 0) && (var3 < class_ayy.n.length)) {
				Iterator var4 = cx().a(class_ayy.n[var3]).iterator();

				while (var4.hasNext()) {
					class_ayo var5 = (class_ayo) var4.next();
					class_ayq var6 = cx().c(var1.e_(), var5);
					var6.a();
				}
			}
		}

		class_ayp var7 = cx().h(var1.e_());
		if (var7 != null) {
			int var8 = var7.l().getId();
			if ((var8 >= 0) && (var8 < class_ayy.m.length)) {
				return cx().a(class_ayy.m[var8]);
			}
		}

		return Lists.newArrayList();
	}

	public EntityItem a(boolean var1) {
		return this.a(bq.a(bq.d, var1 && (bq.h() != null) ? bq.h().b : 1), false, true);
	}

	public EntityItem a(class_aco var1, boolean var2) {
		return this.a(var1, false, false);
	}

	public EntityItem a(class_aco var1, boolean var2, boolean var3) {
		if (var1 == null) {
			return null;
		} else if (var1.b == 0) {
			return null;
		} else {
			double var4 = (t - 0.30000001192092896D) + aY();
			EntityItem var6 = new EntityItem(o, s, var4, u, var1);
			var6.a(40);
			if (var3) {
				var6.e(e_());
			}

			float var7;
			float var8;
			if (var2) {
				var7 = V.nextFloat() * 0.5F;
				var8 = V.nextFloat() * 3.1415927F * 2.0F;
				var6.v = -MathHelper.a(var8) * var7;
				var6.x = MathHelper.b(var8) * var7;
				var6.w = 0.20000000298023224D;
			} else {
				var7 = 0.3F;
				var6.v = -MathHelper.a((y / 180.0F) * 3.1415927F) * MathHelper.b((z / 180.0F) * 3.1415927F) * var7;
				var6.x = MathHelper.b((y / 180.0F) * 3.1415927F) * MathHelper.b((z / 180.0F) * 3.1415927F) * var7;
				var6.w = (-MathHelper.a((z / 180.0F) * 3.1415927F) * var7) + 0.1F;
				var8 = V.nextFloat() * 3.1415927F * 2.0F;
				var7 = 0.02F * V.nextFloat();
				var6.v += Math.cos(var8) * var7;
				var6.w += (V.nextFloat() - V.nextFloat()) * 0.1F;
				var6.x += Math.sin(var8) * var7;
			}

			this.a(var6);
			if (var3) {
				this.b(StatisticList.w);
			}

			return var6;
		}
	}

	protected void a(EntityItem var1) {
		o.a(var1);
		class_aco var2 = var1.j();
		this.a(StatisticList.f(Item.b(var2.b())), var2.b);
	}

	public float a(Block var1) {
		float var2 = bq.a(var1);
		if (var2 > 1.0F) {
			int var3 = class_afl.e(this);
			class_aco var4 = bG();
			if ((var3 > 0) && (var4 != null)) {
				var2 += (var3 * var3) + 1;
			}
		}

		if (this.a(class_qs.c)) {
			var2 *= 1.0F + ((this.b(class_qs.c).c() + 1) * 0.2F);
		}

		if (this.a(class_qs.d)) {
			float var5 = 1.0F;
			switch (this.b(class_qs.d).c()) {
				case 0:
					var5 = 0.3F;
					break;
				case 1:
					var5 = 0.09F;
					break;
				case 2:
					var5 = 0.0027F;
					break;
				case 3:
				default:
					var5 = 8.1E-4F;
			}

			var2 *= var5;
		}

		if (this.a(class_avq.h) && !class_afl.i(this)) {
			var2 /= 5.0F;
		}

		if (!C) {
			var2 /= 5.0F;
		}

		return var2;
	}

	public boolean b(Block var1) {
		return bq.b(var1);
	}

	@Override
	public void a(class_dn var1) {
		super.a(var1);
		aq = a(bP);
		class_du var2 = var1.c("Inventory", 10);
		bq.b(var2);
		bq.d = var1.h("SelectedItemSlot");
		bE = var1.p("Sleeping");
		d = var1.g("SleepTimer");
		bL = var1.j("XpP");
		bJ = var1.h("XpLevel");
		bK = var1.h("XpTotal");
		h = var1.h("XpSeed");
		if (h == 0) {
			h = V.nextInt();
		}

		this.k(var1.h("Score"));
		if (bE) {
			bF = new class_cj(this);
			this.a(true, true, false);
		}

		if (var1.b("SpawnX", 99) && var1.b("SpawnY", 99) && var1.b("SpawnZ", 99)) {
			e = new class_cj(var1.h("SpawnX"), var1.h("SpawnY"), var1.h("SpawnZ"));
			f = var1.p("SpawnForced");
		}

		bt.a(var1);
		bI.b(var1);
		if (var1.b("EnderItems", 9)) {
			class_du var3 = var1.c("EnderItems", 10);
			c.a(var3);
		}

	}

	@Override
	public void b(class_dn var1) {
		super.b(var1);
		var1.a("DataVersion", 117);
		var1.a("Inventory", bq.a(new class_du()));
		var1.a("SelectedItemSlot", bq.d);
		var1.a("Sleeping", bE);
		var1.a("SleepTimer", (short) d);
		var1.a("XpP", bL);
		var1.a("XpLevel", bJ);
		var1.a("XpTotal", bK);
		var1.a("XpSeed", h);
		var1.a("Score", cg());
		if (e != null) {
			var1.a("SpawnX", e.n());
			var1.a("SpawnY", e.o());
			var1.a("SpawnZ", e.p());
			var1.a("SpawnForced", f);
		}

		bt.b(var1);
		bI.a(var1);
		var1.a("EnderItems", c.h());
	}

	@Override
	public boolean a(class_qi var1, float var2) {
		if (this.b(var1)) {
			return false;
		} else if (bI.a && !var1.g()) {
			return false;
		} else {
			aU = 0;
			if (bu() <= 0.0F) {
				return false;
			} else {
				if (bQ() && !o.D) {
					this.a(true, true, false);
				}

				if (var1.r()) {
					if (o.ac() == class_ps.a) {
						var2 = 0.0F;
					}

					if (o.ac() == class_ps.b) {
						var2 = (var2 / 2.0F) + 1.0F;
					}

					if (o.ac() == class_ps.d) {
						var2 = (var2 * 3.0F) / 2.0F;
					}
				}

				if (var2 == 0.0F) {
					return false;
				} else {
					Entity var3 = var1.j();
					if ((var3 instanceof EntityArrow) && (((EntityArrow) var3).e != null)) {
						var3 = ((EntityArrow) var3).e;
					}

					return super.a(var1, var2);
				}
			}
		}
	}

	public boolean a(class_yu var1) {
		class_ayu var2 = aE();
		class_ayu var3 = var1.aE();
		return var2 == null ? true : (!var2.a(var3) ? true : var2.g());
	}

	@Override
	protected void d(float var1) {
		bq.a(var1);
	}

	@Override
	protected void k(float var1) {
		if ((var1 > 0.0F) && (bm != null) && (bm.b() == Items.cK)) {
			int var2 = 1 + MathHelper.d(var1);
			bm.a(var2, this);
			if (bm.b == 0) {
				class_pu var3 = bY();
				if (var3 == class_pu.a) {
					this.a(class_rc.a, (class_aco) null);
				} else {
					this.a(class_rc.b, (class_aco) null);
				}

				bm = null;
				this.a("random.break", 0.8F, 0.8F + (o.s.nextFloat() * 0.4F));
			}
		}

	}

	public float ch() {
		int var1 = 0;
		class_aco[] var2 = bq.b;
		int var3 = var2.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			class_aco var5 = var2[var4];
			if (var5 != null) {
				++var1;
			}
		}

		return (float) var1 / (float) bq.b.length;
	}

	@Override
	protected void d(class_qi var1, float var2) {
		if (!this.b(var1)) {
			var2 = this.b(var1, var2);
			var2 = this.c(var1, var2);
			float var3 = var2;
			var2 = Math.max(var2 - bU(), 0.0F);
			this.n(bU() - (var3 - var2));
			if (var2 != 0.0F) {
				this.a(var1.f());
				float var4 = bu();
				this.c(bu() - var2);
				bz().a(var1, var4, var2);
				if (var2 < 3.4028235E37F) {
					this.a(StatisticList.y, Math.round(var2 * 10.0F));
				}

			}
		}
	}

	public void a(class_aoz var1) {
	}

	public void a(class_age var1) {
	}

	public void a(class_aol var1) {
	}

	public void a(class_aga var1) {
	}

	public void a(class_pp var1) {
	}

	public void a(EntityHorse var1, class_pp var2) {
	}

	public void a(class_pv var1) {
	}

	public void a(class_aco var1) {
	}

	public class_pw a(Entity var1, class_aco var2, class_pu var3) {
		if (w()) {
			if (var1 instanceof class_pp) {
				this.a((class_pp) var1);
			}

			return class_pw.b;
		} else {
			class_aco var4 = var2 != null ? var2.k() : null;
			if (!var1.a(this, var2, var3)) {
				if ((var2 != null) && (var1 instanceof EntityLiving)) {
					if (bI.d) {
						var2 = var4;
					}

					if (var2.a(this, (EntityLiving) var1, var3)) {
						if ((var2.b <= 0) && !bI.d) {
							this.a(var3, (class_aco) null);
						}

						return class_pw.a;
					}
				}

				return class_pw.b;
			} else {
				if ((var2 != null) && (var2 == this.b(var3))) {
					if ((var2.b <= 0) && !bI.d) {
						this.a(var3, (class_aco) null);
					} else if ((var2.b < var4.b) && bI.d) {
						var2.b = var4.b;
					}
				}

				return class_pw.a;
			}
		}
	}

	@Override
	public double ap() {
		return -0.35D;
	}

	public void f(Entity var1) {
		if (var1.aJ()) {
			if (!var1.m(this)) {
				float var2 = (float) this.a(class_yf.e).e();
				float var3 = 0.0F;
				if (var1 instanceof EntityLiving) {
					var3 = class_afl.a(bG(), ((EntityLiving) var1).bF());
				} else {
					var3 = class_afl.a(bG(), class_rl.a);
				}

				float var4 = this.o(0.5F);
				var2 *= var4 * var4;
				var3 *= var4;
				cA();
				if ((var2 > 0.0F) || (var3 > 0.0F)) {
					boolean var5 = var4 > 0.9F;
					boolean var6 = false;
					boolean var7 = false;
					boolean var8 = false;
					byte var9 = 0;
					int var26 = var9 + class_afl.a(this);
					if (aB() && var5) {
						++var26;
						var6 = true;
					}

					var7 = var5 && (O > 0.0F) && !C && !j_() && !Y() && !this.a(class_qs.o) && (m == null) && (var1 instanceof EntityLiving);
					var7 = var7 && !aB();
					if (var7) {
						var2 *= 1.5F;
					}

					var2 += var3;
					double var10 = M - L;
					if (var5 && !var7 && !var6 && C && (var10 < bP())) {
						class_aco var12 = this.b(class_pu.a);
						if ((var12 != null) && (var12.b() instanceof class_adv)) {
							var8 = true;
						}
					}

					float var27 = 0.0F;
					boolean var13 = false;
					int var14 = class_afl.b(this);
					if (var1 instanceof EntityLiving) {
						var27 = ((EntityLiving) var1).bu();
						if ((var14 > 0) && !var1.ay()) {
							var13 = true;
							var1.e(1);
						}
					}

					double var15 = var1.v;
					double var17 = var1.w;
					double var19 = var1.x;
					boolean var21 = var1.a(class_qi.a(this), var2);
					if (var21) {
						if (var26 > 0) {
							if (var1 instanceof EntityLiving) {
								((EntityLiving) var1).a(this, var26 * 0.5F, MathHelper.a((y * 3.1415927F) / 180.0F), (-MathHelper.b((y * 3.1415927F) / 180.0F)));
							} else {
								var1.g(-MathHelper.a((y * 3.1415927F) / 180.0F) * var26 * 0.5F, 0.1D, MathHelper.b((y * 3.1415927F) / 180.0F) * var26 * 0.5F);
							}

							v *= 0.6D;
							x *= 0.6D;
							this.d(false);
						}

						if (var8) {
							List var22 = o.a(EntityLiving.class, var1.aX().b(1.0D, 0.25D, 1.0D));
							Iterator var23 = var22.iterator();

							while (var23.hasNext()) {
								EntityLiving var24 = (EntityLiving) var23.next();
								if ((var24 != this) && (var24 != var1) && !this.k(var24) && (this.h(var24) < 9.0D)) {
									var24.a(this, 0.4F, MathHelper.a((y * 3.1415927F) / 180.0F), (-MathHelper.b((y * 3.1415927F) / 180.0F)));
								}
							}

							ci();
						}

						if ((var1 instanceof class_lm) && var1.G) {
							((class_lm) var1).a.a((new PacketPlayOutEntityVelocity(var1)));
							var1.G = false;
							var1.v = var15;
							var1.w = var17;
							var1.x = var19;
						}

						if (var7) {
							this.b(var1);
						}

						if (var3 > 0.0F) {
							this.c(var1);
						}

						if (!o.D && (var1 instanceof class_yu)) {
							class_yu var28 = (class_yu) var1;
							class_aco var30 = bG();
							class_aco var32 = var28.bX() ? var28.ca() : null;
							if ((var30 != null) && (var32 != null) && (var30.b() instanceof class_aay) && (var32.b() == Items.cK)) {
								float var25 = 0.25F + (class_afl.e(this) * 0.05F);
								if (var6) {
									var25 += 0.75F;
								}

								if (V.nextFloat() < var25) {
									var28.cB().a(Items.cK, 100);
									o.a(var28, (byte) 30);
								}
							}
						}

						if (var2 >= 18.0F) {
							this.b(class_my.F);
						}

						p(var1);
						if (var1 instanceof EntityLiving) {
							class_afl.a(((EntityLiving) var1), this);
						}

						class_afl.b(this, var1);
						class_aco var29 = bG();
						Object var31 = var1;
						if (var1 instanceof class_vv) {
							class_vu var33 = ((class_vv) var1).a;
							if (var33 instanceof EntityLiving) {
								var31 = var33;
							}
						}

						if ((var29 != null) && (var31 instanceof EntityLiving)) {
							var29.a((EntityLiving) var31, this);
							if (var29.b <= 0) {
								this.a(class_pu.a, (class_aco) null);
							}
						}

						if (var1 instanceof EntityLiving) {
							float var34 = var27 - ((EntityLiving) var1).bu();
							this.a(StatisticList.x, Math.round(var34 * 10.0F));
							if (var14 > 0) {
								var1.e(var14 * 4);
							}

							if ((o instanceof class_ll) && (var34 > 2.0F)) {
								int var35 = (int) (var34 * 0.5D);
								((class_ll) o).a(class_cy.S, var1.s, var1.t + var1.K * 0.5F, var1.u, var35, 0.1D, 0.0D, 0.1D, 0.2D, new int[0]);
							}
						}

						this.a(0.3F);
					} else if (var13) {
						var1.P();
					}
				}

			}
		}
	}

	public void b(Entity var1) {
	}

	public void c(Entity var1) {
	}

	public void ci() {
		double var1 = (-MathHelper.a((y * 3.1415927F) / 180.0F));
		double var3 = MathHelper.b((y * 3.1415927F) / 180.0F);
		System.out.println("lasdjfhlsdhjflsdij");
		if (o instanceof class_ll) {
			((class_ll) o).a(class_cy.T, s + (var1 * 1.0D), t + (K * 0.5D), u + (var3 * 1.0D), 0, var1, 0.0D, var3, 0.0D, new int[0]);
		}

	}

	@Override
	public void L() {
		super.L();
		br.b(this);
		if (bs != null) {
			bs.b(this);
		}

	}

	@Override
	public boolean am() {
		return !bE && super.am();
	}

	public GameProfile cl() {
		return bP;
	}

	public class_yu.class_a_in_class_yu a(class_cj var1) {
		if (!o.D) {
			if (bQ() || !al()) {
				return class_yu.class_a_in_class_yu.e;
			}

			if (!o.t.d()) {
				return class_yu.class_a_in_class_yu.b;
			}

			if (o.z()) {
				return class_yu.class_a_in_class_yu.c;
			}

			if ((Math.abs(s - var1.n()) > 3.0D) || (Math.abs(t - var1.o()) > 2.0D) || (Math.abs(u - var1.p()) > 3.0D)) {
				return class_yu.class_a_in_class_yu.d;
			}

			double var2 = 8.0D;
			double var4 = 5.0D;
			List var6 = o.a(EntityMonster.class, new class_ayk(var1.n() - var2, var1.o() - var4, var1.p() - var2, var1.n() + var2, var1.o() + var4, var1.p() + var2));
			if (!var6.isEmpty()) {
				return class_yu.class_a_in_class_yu.f;
			}
		}

		if (az()) {
			this.a((Entity) null);
		}

		this.a(0.2F, 0.2F);
		if (o.e(var1)) {
			class_cq var7 = (class_cq) o.p(var1).b(class_akx.O);
			float var3 = 0.5F;
			float var8 = 0.5F;
			switch (class_yu.SyntheticClass_1.a[var7.ordinal()]) {
				case 1:
					var8 = 0.9F;
					break;
				case 2:
					var8 = 0.1F;
					break;
				case 3:
					var3 = 0.1F;
					break;
				case 4:
					var3 = 0.9F;
			}

			this.a(var7);
			this.b(var1.n() + var3, var1.o() + 0.6875F, var1.p() + var8);
		} else {
			this.b(var1.n() + 0.5F, var1.o() + 0.6875F, var1.p() + 0.5F);
		}

		bE = true;
		d = 0;
		bF = var1;
		v = x = w = 0.0D;
		if (!o.D) {
			o.e();
		}

		return class_yu.class_a_in_class_yu.a;
	}

	private void a(class_cq var1) {
		bG = 0.0F;
		bH = 0.0F;
		switch (class_yu.SyntheticClass_1.a[var1.ordinal()]) {
			case 1:
				bH = -1.8F;
				break;
			case 2:
				bH = 1.8F;
				break;
			case 3:
				bG = 1.8F;
				break;
			case 4:
				bG = -1.8F;
		}

	}

	public void a(boolean var1, boolean var2, boolean var3) {
		this.a(0.6F, 1.8F);
		class_apn var4 = o.p(bF);
		if ((bF != null) && (var4.c() == Blocks.BED)) {
			o.a(bF, var4.a(class_aij.b, Boolean.valueOf(false)), 4);
			class_cj var5 = class_aij.a(o, bF, 0);
			if (var5 == null) {
				var5 = bF.a();
			}

			this.b(var5.n() + 0.5F, var5.o() + 0.1F, var5.p() + 0.5F);
		}

		bE = false;
		if (!o.D && var2) {
			o.e();
		}

		d = var1 ? 0 : 100;
		if (var3) {
			this.a(bF, false);
		}

	}

	private boolean n() {
		return o.p(bF).c() == Blocks.BED;
	}

	public static class_cj a(class_ago var0, class_cj var1, boolean var2) {
		Block var3 = var0.p(var1).c();
		if (var3 != Blocks.BED) {
			if (!var2) {
				return null;
			} else {
				boolean var4 = var3.g();
				boolean var5 = var0.p(var1.a()).c().g();
				return var4 && var5 ? var1 : null;
			}
		} else {
			return class_aij.a(var0, var1, 0);
		}
	}

	@Override
	public boolean bQ() {
		return bE;
	}

	public boolean cn() {
		return bE && (d >= 100);
	}

	public void b(IChatBaseComponent var1) {
	}

	public class_cj cp() {
		return e;
	}

	public boolean cq() {
		return f;
	}

	public void a(class_cj var1, boolean var2) {
		if (var1 != null) {
			e = var1;
			f = var2;
		} else {
			e = null;
			f = false;
		}

	}

	public void b(class_nd var1) {
		this.a(var1, 1);
	}

	public void a(class_nd var1, int var2) {
	}

	public void a(class_nd var1) {
	}

	@Override
	public void bM() {
		super.bM();
		this.b(StatisticList.v);
		if (aB()) {
			this.a(0.8F);
		} else {
			this.a(0.2F);
		}

	}

	@Override
	public void g(float var1, float var2) {
		double var3 = s;
		double var5 = t;
		double var7 = u;
		if (bI.b && (m == null)) {
			double var9 = w;
			float var11 = aQ;
			aQ = bI.a() * (aB() ? 2 : 1);
			super.g(var1, var2);
			w = var9 * 0.6D;
			aQ = var11;
		} else {
			super.g(var1, var2);
		}

		this.k(s - var3, t - var5, u - var7);
	}

	@Override
	public float bP() {
		return (float) this.a(class_yf.d).e();
	}

	public void k(double var1, double var3, double var5) {
		if (m == null) {
			int var7;
			if (this.a(class_avq.h)) {
				var7 = Math.round(MathHelper.a((var1 * var1) + (var3 * var3) + (var5 * var5)) * 100.0F);
				if (var7 > 0) {
					this.a(StatisticList.q, var7);
					this.a(0.015F * var7 * 0.01F);
				}
			} else if (Y()) {
				var7 = Math.round(MathHelper.a((var1 * var1) + (var5 * var5)) * 100.0F);
				if (var7 > 0) {
					this.a(StatisticList.m, var7);
					this.a(0.015F * var7 * 0.01F);
				}
			} else if (j_()) {
				if (var3 > 0.0D) {
					this.a(StatisticList.o, (int) Math.round(var3 * 100.0D));
				}
			} else if (C) {
				var7 = Math.round(MathHelper.a((var1 * var1) + (var5 * var5)) * 100.0F);
				if (var7 > 0) {
					this.a(StatisticList.j, var7);
					if (aB()) {
						this.a(StatisticList.l, var7);
						this.a(0.099999994F * var7 * 0.01F);
					} else {
						if (aA()) {
							this.a(StatisticList.k, var7);
						}

						this.a(0.01F * var7 * 0.01F);
					}
				}
			} else {
				var7 = Math.round(MathHelper.a((var1 * var1) + (var5 * var5)) * 100.0F);
				if (var7 > 25) {
					this.a(StatisticList.p, var7);
				}
			}

		}
	}

	private void l(double var1, double var3, double var5) {
		if (m != null) {
			int var7 = Math.round(MathHelper.a((var1 * var1) + (var3 * var3) + (var5 * var5)) * 100.0F);
			if (var7 > 0) {
				if (m instanceof EntityMinecartAbstract) {
					this.a(StatisticList.r, var7);
					if (g == null) {
						g = new class_cj(this);
					} else if (g.c(MathHelper.c(s), MathHelper.c(t), MathHelper.c(u)) >= 1000000.0D) {
						this.b(class_my.q);
					}
				} else if (m instanceof EntityBoat) {
					this.a(StatisticList.s, var7);
				} else if (m instanceof EntityPig) {
					this.a(StatisticList.t, var7);
				} else if (m instanceof EntityHorse) {
					this.a(StatisticList.u, var7);
				}
			}
		}

	}

	@Override
	public void e(float var1, float var2) {
		if (!bI.c) {
			if (var1 >= 2.0F) {
				this.a(StatisticList.n, (int) Math.round(var1 * 100.0D));
			}

			super.e(var1, var2);
		}
	}

	@Override
	protected void aa() {
		if (!w()) {
			super.aa();
		}

	}

	@Override
	protected String i(int var1) {
		return var1 > 4 ? "game.player.hurt.fall.big" : "game.player.hurt.fall.small";
	}

	@Override
	public void b(EntityLiving var1) {
		if (var1 instanceof class_xx) {
			this.b(class_my.s);
		}

		EntityTypes.class_a_in_class_qz var2 = (EntityTypes.class_a_in_class_qz) EntityTypes.a.get(EntityTypes.b(var1));
		if (var2 != null) {
			this.b(var2.d);
		}

	}

	@Override
	public void aG() {
		if (!bI.b) {
			super.aG();
		}

	}

	public void m(int var1) {
		this.l(var1);
		int var2 = Integer.MAX_VALUE - bK;
		if (var1 > var2) {
			var1 = var2;
		}

		bL += (float) var1 / (float) cs();

		for (bK += var1; bL >= 1.0F; bL /= cs()) {
			bL = (bL - 1.0F) * cs();
			this.a(1);
		}

	}

	public int cr() {
		return h;
	}

	public void b(int var1) {
		bJ -= var1;
		if (bJ < 0) {
			bJ = 0;
			bL = 0.0F;
			bK = 0;
		}

		h = V.nextInt();
	}

	public void a(int var1) {
		bJ += var1;
		if (bJ < 0) {
			bJ = 0;
			bL = 0.0F;
			bK = 0;
		}

		if ((var1 > 0) && ((bJ % 5) == 0) && (i < (W - 100.0F))) {
			float var2 = bJ > 30 ? 1.0F : bJ / 30.0F;
			o.a((Entity) this, "random.levelup", var2 * 0.75F, 1.0F);
			i = W;
		}

	}

	public int cs() {
		return bJ >= 30 ? 112 + ((bJ - 30) * 9) : (bJ >= 15 ? 37 + ((bJ - 15) * 5) : 7 + (bJ * 2));
	}

	public void a(float var1) {
		if (!bI.a) {
			if (!o.D) {
				bt.a(var1);
			}

		}
	}

	public class_zs ct() {
		return bt;
	}

	public boolean j(boolean var1) {
		return (var1 || bt.c()) && !bI.a;
	}

	public boolean cu() {
		return (bu() > 0.0F) && (bu() < bB());
	}

	public boolean cv() {
		return bI.e;
	}

	public boolean a(class_cj var1, class_cq var2, class_aco var3) {
		if (bI.e) {
			return true;
		} else if (var3 == null) {
			return false;
		} else {
			class_cj var4 = var1.a(var2.d());
			Block var5 = o.p(var4).c();
			return var3.d(var5) || var3.x();
		}
	}

	@Override
	protected int b(class_yu var1) {
		if (o.S().b("keepInventory")) {
			return 0;
		} else {
			int var2 = bJ * 7;
			return var2 > 100 ? 100 : var2;
		}
	}

	@Override
	protected boolean bi() {
		return true;
	}

	public void a(class_yu var1, boolean var2) {
		if (var2) {
			bq.a(var1.bq);
			this.c(var1.bu());
			bt = var1.bt;
			bJ = var1.bJ;
			bK = var1.bK;
			bL = var1.bL;
			this.k(var1.cg());
			an = var1.an;
			ao = var1.ao;
			ap = var1.ap;
		} else if (o.S().b("keepInventory")) {
			bq.a(var1.bq);
			bJ = var1.bJ;
			bK = var1.bK;
			bL = var1.bL;
			this.k(var1.cg());
		}

		h = var1.h;
		c = var1.c;
		J().b(bo, var1.J().a(bo));
	}

	@Override
	protected boolean U() {
		return !bI.b;
	}

	public void u() {
	}

	public void a(class_agr.class_a_in_class_agr var1) {
	}

	@Override
	public String e_() {
		return bP.getName();
	}

	public class_aap cw() {
		return c;
	}

	@Override
	public class_aco a(class_rc var1) {
		return var1 == class_rc.a ? bq.h() : (var1 == class_rc.b ? bq.c[0] : (var1.a() == class_rc.class_a_in_class_rc.b ? bq.b[var1.b()] : null));
	}

	@Override
	public void a(class_rc var1, class_aco var2) {
		if (var1 == class_rc.a) {
			bq.a[bq.d] = var2;
		} else if (var1 == class_rc.b) {
			bq.c[0] = var2;
		} else if (var1.a() == class_rc.class_a_in_class_rc.b) {
			bq.b[var1.b()] = var2;
		}

	}

	@Override
	public Iterable av() {
		return Lists.newArrayList((Object[]) (new class_aco[] { bG(), bH() }));
	}

	@Override
	public Iterable aw() {
		return Arrays.asList(bq.b);
	}

	public abstract boolean w();

	@Override
	public boolean aR() {
		return !bI.b;
	}

	public class_ays cx() {
		return o.ab();
	}

	@Override
	public class_ayu aE() {
		return cx().h(e_());
	}

	@Override
	public IChatBaseComponent f_() {
		class_fa var1 = new class_fa(class_ayp.a(aE(), e_()));
		var1.b().a(new class_et(class_et.class_a_in_class_et.d, "/msg " + e_() + " "));
		var1.b().a(aW());
		var1.b().a(e_());
		return var1;
	}

	@Override
	public float aY() {
		float var1 = 1.62F;
		if (bQ()) {
			var1 = 0.2F;
		}

		if (aA()) {
			var1 -= 0.08F;
		}

		return var1;
	}

	@Override
	public void n(float var1) {
		if (var1 < 0.0F) {
			var1 = 0.0F;
		}

		J().b(a, Float.valueOf(var1));
	}

	@Override
	public float bU() {
		return ((Float) J().a(a)).floatValue();
	}

	public static UUID a(GameProfile var0) {
		UUID var1 = var0.getId();
		if (var1 == null) {
			var1 = d(var0.getName());
		}

		return var1;
	}

	public static UUID d(String var0) {
		return UUID.nameUUIDFromBytes(("OfflinePlayer:" + var0).getBytes(Charsets.UTF_8));
	}

	public boolean a(class_pz var1) {
		if (var1.a()) {
			return true;
		} else {
			class_aco var2 = bG();
			return (var2 != null) && var2.s() ? var2.q().equals(var1.b()) : false;
		}
	}

	@Override
	public boolean s_() {
		return MinecraftServer.P().d[0].S().b("sendCommandFeedback");
	}

	@Override
	public boolean c(int var1, class_aco var2) {
		if ((var1 >= 0) && (var1 < bq.a.length)) {
			bq.a(var1, var2);
			return true;
		} else {
			class_rc var3;
			if (var1 == (100 + class_rc.f.b())) {
				var3 = class_rc.f;
			} else if (var1 == (100 + class_rc.e.b())) {
				var3 = class_rc.e;
			} else if (var1 == (100 + class_rc.d.b())) {
				var3 = class_rc.d;
			} else if (var1 == (100 + class_rc.c.b())) {
				var3 = class_rc.c;
			} else {
				var3 = null;
			}

			if (var1 == 98) {
				this.a(class_rc.a, var2);
				return true;
			} else if (var1 == 99) {
				this.a(class_rc.b, var2);
				return true;
			} else if (var3 != null) {
				if ((var2 != null) && (var2.b() != null)) {
					if (var2.b() instanceof class_aav) {
						if (EntityInsentient.c(var2) != var3) {
							return false;
						}
					} else if (var3 != class_rc.f) {
						return false;
					}
				}

				bq.a(var3.b() + bq.a.length, var2);
				return true;
			} else {
				int var4 = var1 - 200;
				if ((var4 >= 0) && (var4 < c.n_())) {
					c.a(var4, var2);
					return true;
				} else {
					return false;
				}
			}
		}
	}

	public class_rf bW() {
		return ((Byte) ac.a(bp)).byteValue() == 0 ? class_rf.a : class_rf.b;
	}

	public void a(class_rf var1) {
		ac.b(bp, Byte.valueOf((byte) (var1 == class_rf.a ? 0 : 1)));
	}

	public float cz() {
		return (float) ((1.0D / this.a(class_yf.f).e()) * 20.0D);
	}

	public float o(float var1) {
		return MathHelper.a((aD + var1) / cz(), 0.0F, 1.0F);
	}

	public void cA() {
		aD = 0;
	}

	public class_acn cB() {
		return bS;
	}

	static {
		a = DataWatcher.claimId(class_yu.class, class_kb.c);
		b = DataWatcher.claimId(class_yu.class, class_kb.b);
		bo = DataWatcher.claimId(class_yu.class, class_kb.a);
		bp = DataWatcher.claimId(class_yu.class, class_kb.a);
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a = new int[class_cq.values().length];

		static {
			try {
				a[class_cq.d.ordinal()] = 1;
			} catch (NoSuchFieldError var4) {
				;
			}

			try {
				a[class_cq.c.ordinal()] = 2;
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

	public static enum class_a_in_class_yu {
		a,
		b,
		c,
		d,
		e,
		f;
	}

	public static enum class_b_in_class_yu {
		a(0, "options.chat.visibility.full"),
		b(1, "options.chat.visibility.system"),
		c(2, "options.chat.visibility.hidden");

		private static final class_yu.class_b_in_class_yu[] d;
		private final int e;
		private final String f;

		private class_b_in_class_yu(int var3, String var4) {
			e = var3;
			f = var4;
		}

		static {
			d = new class_yu.class_b_in_class_yu[values().length];
			class_yu.class_b_in_class_yu[] var0 = values();
			int var1 = var0.length;

			for (int var2 = 0; var2 < var1; ++var2) {
				class_yu.class_b_in_class_yu var3 = var0[var2];
				d[var3.e] = var3;
			}

		}
	}
}
