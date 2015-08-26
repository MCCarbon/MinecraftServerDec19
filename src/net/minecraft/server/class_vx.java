package net.minecraft.server;

import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_vx extends class_rh implements class_vu, class_xx {
	private static final Logger bF = LogManager.getLogger();
	public static final class_jz a;
	public double[][] b = new double[64][3];
	public int c = -1;
	public class_vv[] br;
	public class_vv bs;
	public class_vv bt;
	public class_vv bu;
	public class_vv bv;
	public class_vv bw;
	public class_vv bx;
	public class_vv by;
	public class_vv bz;
	public float bA;
	public float bB;
	public boolean bC;
	public int bD;
	public class_vw bE;
	private final class_arg bG;
	private final class_wn bH;
	private int bI = 200;
	private int bJ;
	private final class_axa[] bK = new class_axa[24];
	private final int[] bL = new int[24];
	private final class_awy bM = new class_awy();

	public class_vx(class_ago var1) {
		super(var1);
		br = new class_vv[] { bs = new class_vv(this, "head", 6.0F, 6.0F), bt = new class_vv(this, "neck", 6.0F, 6.0F), bu = new class_vv(this, "body", 8.0F, 8.0F), bv = new class_vv(this, "tail", 4.0F, 4.0F), bw = new class_vv(this, "tail", 4.0F, 4.0F), bx = new class_vv(this, "tail", 4.0F, 4.0F), by = new class_vv(this, "wing", 4.0F, 4.0F), bz = new class_vv(this, "wing", 4.0F, 4.0F) };
		this.c(bB());
		this.a(16.0F, 8.0F);
		T = true;
		ab = true;
		bI = 100;
		ah = true;
		if (!var1.D && (var1.t instanceof class_arh)) {
			bG = ((class_arh) var1.t).s();
		} else {
			bG = null;
		}

		bH = new class_wn(this);
	}

	@Override
	protected void be() {
		super.be();
		this.a(class_yf.a).a(200.0D);
	}

	@Override
	protected void h() {
		super.h();
		J().a(a, Integer.valueOf(class_wm.a.b()));
	}

	public double[] a(int var1, float var2) {
		if (bu() <= 0.0F) {
			var2 = 0.0F;
		}

		var2 = 1.0F - var2;
		int var3 = (c - (var1 * 1)) & 63;
		int var4 = (c - (var1 * 1) - 1) & 63;
		double[] var5 = new double[3];
		double var6 = b[var3][0];
		double var8 = class_oa.g(b[var4][0] - var6);
		var5[0] = var6 + (var8 * var2);
		var6 = b[var3][1];
		var8 = b[var4][1] - var6;
		var5[1] = var6 + (var8 * var2);
		var5[2] = b[var3][2] + ((b[var4][2] - b[var3][2]) * var2);
		return var5;
	}

	@Override
	public void m() {
		float var1;
		float var2;
		if (o.D) {
			this.c(bu());
			if (!T()) {
				var1 = class_oa.b(bB * 3.1415927F * 2.0F);
				var2 = class_oa.b(bA * 3.1415927F * 2.0F);
				if ((var2 <= -0.3F) && (var1 >= -0.3F)) {
					o.a(s, t, u, "mob.enderdragon.wings", 5.0F, 0.8F + (V.nextFloat() * 0.3F), false);
				}

				if (!bH.a().a() && (--bI < 0)) {
					o.a(s, t, u, "mob.enderdragon.growl", 2.5F, 0.8F + (V.nextFloat() * 0.3F), false);
					bI = 200 + V.nextInt(200);
				}
			}
		}

		bA = bB;
		float var25;
		if (bu() <= 0.0F) {
			var1 = (V.nextFloat() - 0.5F) * 8.0F;
			var2 = (V.nextFloat() - 0.5F) * 4.0F;
			var25 = (V.nextFloat() - 0.5F) * 8.0F;
			o.a(class_cy.b, s + var1, t + 2.0D + var2, u + var25, 0.0D, 0.0D, 0.0D, new int[0]);
		} else {
			cA();
			var1 = 0.2F / ((class_oa.a((v * v) + (x * x)) * 10.0F) + 1.0F);
			var1 *= (float) Math.pow(2.0D, w);
			if (bH.a().a()) {
				bB += 0.1F;
			} else if (bC) {
				bB += var1 * 0.5F;
			} else {
				bB += var1;
			}

			y = class_oa.g(y);
			if (cw()) {
				bB = 0.5F;
			} else {
				if (c < 0) {
					for (int var22 = 0; var22 < b.length; ++var22) {
						b[var22][0] = y;
						b[var22][1] = t;
					}
				}

				if (++c == b.length) {
					c = 0;
				}

				b[c][0] = y;
				b[c][1] = t;
				double var4;
				double var6;
				double var8;
				float var12;
				if (o.D) {
					if (bg > 0) {
						double var23 = s + ((bh - s) / bg);
						var4 = t + ((bi - t) / bg);
						var6 = u + ((bj - u) / bg);
						var8 = class_oa.g(bk - y);
						y = (float) (y + (var8 / bg));
						z = (float) (z + ((bl - z) / bg));
						--bg;
						this.b(var23, var4, var6);
						this.b(y, z);
					}

					bH.a().b();
				} else {
					class_wg var24 = bH.a();
					var24.c();
					if (bH.a() != var24) {
						var24 = bH.a();
						var24.c();
					}

					class_aym var3 = var24.g();
					if (var3 != null) {
						var4 = var3.a - s;
						var6 = var3.b - t;
						var8 = var3.c - u;
						double var10 = (var4 * var4) + (var6 * var6) + (var8 * var8);
						var12 = var24.f();
						var6 = class_oa.a(var6 / class_oa.a((var4 * var4) + (var8 * var8)), (-var12), var12);
						w += var6 * 0.10000000149011612D;
						y = class_oa.g(y);
						double var13 = class_oa.a(class_oa.g(180.0D - ((class_oa.b(var4, var8) * 180.0D) / 3.1415927410125732D) - y), -50.0D, 50.0D);
						class_aym var15 = (new class_aym(var3.a - s, var3.b - t, var3.c - u)).a();
						class_aym var16 = (new class_aym(class_oa.a((y * 3.1415927F) / 180.0F), w, (-class_oa.b((y * 3.1415927F) / 180.0F)))).a();
						float var17 = Math.max(((float) var16.b(var15) + 0.5F) / 1.5F, 0.0F);
						bf *= 0.8F;
						bf = (float) (bf + (var13 * var24.h()));
						y += bf * 0.1F;
						float var18 = (float) (2.0D / (var10 + 1.0D));
						float var19 = 0.06F;
						this.a(0.0F, -1.0F, var19 * ((var17 * var18) + (1.0F - var18)));
						if (bC) {
							this.d(v * 0.800000011920929D, w * 0.800000011920929D, x * 0.800000011920929D);
						} else {
							this.d(v, w, x);
						}

						class_aym var20 = (new class_aym(v, w, x)).a();
						float var21 = ((float) var20.b(var16) + 1.0F) / 2.0F;
						var21 = 0.8F + (0.15F * var21);
						v *= var21;
						x *= var21;
						w *= 0.9100000262260437D;
					}
				}

				aM = y;
				bs.J = bs.K = 1.0F;
				bt.J = bt.K = 3.0F;
				bv.J = bv.K = 2.0F;
				bw.J = bw.K = 2.0F;
				bx.J = bx.K = 2.0F;
				bu.K = 3.0F;
				bu.J = 5.0F;
				by.K = 2.0F;
				by.J = 4.0F;
				bz.K = 3.0F;
				bz.J = 4.0F;
				var2 = (((float) (this.a(5, 1.0F)[1] - this.a(10, 1.0F)[1]) * 10.0F) / 180.0F) * 3.1415927F;
				var25 = class_oa.b(var2);
				float var26 = class_oa.a(var2);
				float var5 = (y * 3.1415927F) / 180.0F;
				float var27 = class_oa.a(var5);
				float var7 = class_oa.b(var5);
				bu.r_();
				bu.b(s + var27 * 0.5F, t, u - var7 * 0.5F, 0.0F, 0.0F);
				by.r_();
				by.b(s + var7 * 4.5F, t + 2.0D, u + var27 * 4.5F, 0.0F, 0.0F);
				bz.r_();
				bz.b(s - var7 * 4.5F, t + 2.0D, u - var27 * 4.5F, 0.0F, 0.0F);
				if (!o.D && (ax == 0)) {
					this.a(o.b(this, by.aX().b(4.0D, 2.0D, 4.0D).c(0.0D, -2.0D, 0.0D)));
					this.a(o.b(this, bz.aX().b(4.0D, 2.0D, 4.0D).c(0.0D, -2.0D, 0.0D)));
					this.b(o.b(this, bs.aX().b(1.0D, 1.0D, 1.0D)));
					this.b(o.b(this, bt.aX().b(1.0D, 1.0D, 1.0D)));
				}

				double[] var28 = this.a(5, 1.0F);
				float var9 = class_oa.a(((y * 3.1415927F) / 180.0F) - (bf * 0.01F));
				float var30 = class_oa.b(((y * 3.1415927F) / 180.0F) - (bf * 0.01F));
				bs.r_();
				bt.r_();
				float var11 = this.p(1.0F);
				bs.b(s + var9 * 6.5F * var25, t + var11 + var26 * 6.5F, u - var30 * 6.5F * var25, 0.0F, 0.0F);
				bt.b(s + var9 * 5.5F * var25, t + var11 + var26 * 5.5F, u - var30 * 5.5F * var25, 0.0F, 0.0F);

				for (int var29 = 0; var29 < 3; ++var29) {
					class_vv var31 = null;
					if (var29 == 0) {
						var31 = bv;
					}

					if (var29 == 1) {
						var31 = bw;
					}

					if (var29 == 2) {
						var31 = bx;
					}

					double[] var32 = this.a(12 + (var29 * 2), 1.0F);
					var12 = ((y * 3.1415927F) / 180.0F) + (((this.b(var32[0] - var28[0]) * 3.1415927F) / 180.0F) * 1.0F);
					float var33 = class_oa.a(var12);
					float var14 = class_oa.b(var12);
					float var34 = 1.5F;
					float var35 = (var29 + 1) * 2.0F;
					var31.r_();
					var31.b(s - ((var27 * var34) + (var33 * var35)) * var25, ((t + ((var32[1] - var28[1]) * 1.0D)) - (var35 + var34) * var26) + 1.5D, u + ((var7 * var34) + (var14 * var35)) * var25, 0.0F, 0.0F);
				}

				if (!o.D) {
					bC = this.b(bs.aX()) | this.b(bt.aX()) | this.b(bu.aX());
					if (bG != null) {
						bG.b(this);
					}
				}

			}
		}
	}

	private float p(float var1) {
		double var2 = 0.0D;
		if (bH.a().a()) {
			var2 = -1.0D;
		} else {
			double[] var4 = this.a(5, 1.0F);
			double[] var5 = this.a(0, 1.0F);
			var2 = (var4[1] - var5[0]) * 1.0D;
		}

		return (float) var2;
	}

	private void cA() {
		if (bE != null) {
			if (bE.I) {
				bE = null;
			} else if (((W % 10) == 0) && (bu() < bB())) {
				this.c(bu() + 1.0F);
			}
		}

		if (V.nextInt(10) == 0) {
			float var1 = 32.0F;
			List var2 = o.a(class_vw.class, aX().b(var1, var1, var1));
			class_vw var3 = null;
			double var4 = Double.MAX_VALUE;
			Iterator var6 = var2.iterator();

			while (var6.hasNext()) {
				class_vw var7 = (class_vw) var6.next();
				double var8 = var7.h(this);
				if (var8 < var4) {
					var4 = var8;
					var3 = var7;
				}
			}

			bE = var3;
		}

	}

	private void a(List var1) {
		double var2 = (bu.aX().a + bu.aX().d) / 2.0D;
		double var4 = (bu.aX().c + bu.aX().f) / 2.0D;
		Iterator var6 = var1.iterator();

		while (var6.hasNext()) {
			Entity var7 = (Entity) var6.next();
			if (var7 instanceof class_rg) {
				double var8 = var7.s - var2;
				double var10 = var7.u - var4;
				double var12 = (var8 * var8) + (var10 * var10);
				var7.g((var8 / var12) * 4.0D, 0.20000000298023224D, (var10 / var12) * 4.0D);
				if (!bH.a().a() && (((class_rg) var7).bl() < (var7.W - 2))) {
					var7.a(class_qi.a(this), 5.0F);
					this.a(this, var7);
				}
			}
		}

	}

	private void b(List var1) {
		for (int var2 = 0; var2 < var1.size(); ++var2) {
			Entity var3 = (Entity) var1.get(var2);
			if (var3 instanceof class_rg) {
				var3.a(class_qi.a(this), 10.0F);
				this.a(this, var3);
			}
		}

	}

	private float b(double var1) {
		return (float) class_oa.g(var1);
	}

	private boolean b(class_ayk var1) {
		int var2 = class_oa.c(var1.a);
		int var3 = class_oa.c(var1.b);
		int var4 = class_oa.c(var1.c);
		int var5 = class_oa.c(var1.d);
		int var6 = class_oa.c(var1.e);
		int var7 = class_oa.c(var1.f);
		boolean var8 = false;
		boolean var9 = false;

		for (int var10 = var2; var10 <= var5; ++var10) {
			for (int var11 = var3; var11 <= var6; ++var11) {
				for (int var12 = var4; var12 <= var7; ++var12) {
					class_cj var13 = new class_cj(var10, var11, var12);
					Block var14 = o.p(var13).c();
					if ((var14.v() != class_avq.a) && (var14.v() != class_avq.o)) {
						if (!o.S().b("mobGriefing")) {
							var8 = true;
						} else if ((var14 != Blocks.BARRIER) && (var14 != Blocks.OBSIDIAN) && (var14 != Blocks.END_STONE) && (var14 != Blocks.BEDROCK) && (var14 != Blocks.END_PORTAL) && (var14 != Blocks.END_PORTAL_FRAME)) {
							if ((var14 != Blocks.COMMAND_BLOCK) && (var14 != Blocks.REPEATING_COMMAND_BLOCK) && (var14 != Blocks.CHAIN_COMMAND_BLOCK) && (var14 != Blocks.IRON_BARS) && (var14 != Blocks.END_GATEWAY)) {
								var9 = o.g(var13) || var9;
							} else {
								var8 = true;
							}
						} else {
							var8 = true;
						}
					}
				}
			}
		}

		if (var9) {
			double var16 = var1.a + ((var1.d - var1.a) * V.nextFloat());
			double var17 = var1.b + ((var1.e - var1.b) * V.nextFloat());
			double var18 = var1.c + ((var1.f - var1.c) * V.nextFloat());
			o.a(class_cy.b, var16, var17, var18, 0.0D, 0.0D, 0.0D, new int[0]);
		}

		return var8;
	}

	@Override
	public boolean a(class_vv var1, class_qi var2, float var3) {
		var3 = bH.a().a(var1, var2, var3);
		if (var1 != bs) {
			var3 = (var3 / 4.0F) + Math.min(var3, 1.0F);
		}

		if (var3 < 0.01F) {
			return false;
		} else {
			if ((var2.j() instanceof class_yu) || var2.c()) {
				float var4 = bu();
				this.e(var2, var3);
				if ((bu() <= 0.0F) && !bH.a().a()) {
					this.c(1.0F);
					bH.a(class_wm.j);
				}

				if (bH.a().a()) {
					bJ = (int) (bJ + (var4 - bu()));
					if (bJ > (0.25F * bB())) {
						bJ = 0;
						bH.a(class_wm.e);
					}
				}
			}

			return true;
		}
	}

	@Override
	public boolean a(class_qi var1, float var2) {
		if ((var1 instanceof class_qj) && ((class_qj) var1).x()) {
			this.a(bu, var1, var2);
		}

		return false;
	}

	protected boolean e(class_qi var1, float var2) {
		return super.a(var1, var2);
	}

	@Override
	public void I() {
		L();
		if (bG != null) {
			bG.b(this);
			bG.a(this);
		}

	}

	@Override
	protected void bg() {
		if (bG != null) {
			bG.b(this);
		}

		++bD;
		if ((bD >= 180) && (bD <= 200)) {
			float var1 = (V.nextFloat() - 0.5F) * 8.0F;
			float var2 = (V.nextFloat() - 0.5F) * 4.0F;
			float var3 = (V.nextFloat() - 0.5F) * 8.0F;
			o.a(class_cy.c, s + var1, t + 2.0D + var2, u + var3, 0.0D, 0.0D, 0.0D, new int[0]);
		}

		boolean var4 = o.S().b("doMobLoot");
		short var5 = 500;
		if ((bG != null) && !bG.d()) {
			var5 = 12000;
		}

		if (!o.D) {
			if ((bD > 150) && ((bD % 5) == 0) && var4) {
				this.a(class_oa.d(var5 * 0.08F));
			}

			if (bD == 1) {
				o.a(1018, new class_cj(this), 0);
			}
		}

		this.d(0.0D, 0.10000000149011612D, 0.0D);
		aM = y += 20.0F;
		if ((bD == 200) && !o.D) {
			if (var4) {
				this.a(class_oa.d(var5 * 0.2F));
			}

			if (bG != null) {
				bG.a(this);
			}

			L();
		}

	}

	private void a(int var1) {
		while (var1 > 0) {
			int var2 = class_rd.a(var1);
			var1 -= var2;
			o.a((new class_rd(o, s, t, u, var2)));
		}

	}

	public int n() {
		if (bK[0] == null) {
			boolean var1 = false;
			boolean var2 = false;
			boolean var3 = false;
			boolean var4 = false;

			for (int var5 = 0; var5 < 24; ++var5) {
				int var6 = 5;
				int var7;
				int var9;
				if (var5 < 12) {
					var7 = (int) (60.0F * class_oa.b(2.0F * (-3.1415927F + (0.2617994F * var5))));
					var9 = (int) (60.0F * class_oa.a(2.0F * (-3.1415927F + (0.2617994F * var5))));
				} else {
					int var10;
					if (var5 < 20) {
						var10 = var5 - 12;
						var7 = (int) (40.0F * class_oa.b(2.0F * (-3.1415927F + (0.3926991F * var10))));
						var9 = (int) (40.0F * class_oa.a(2.0F * (-3.1415927F + (0.3926991F * var10))));
						var6 += 10;
					} else {
						var10 = var5 - 20;
						var7 = (int) (20.0F * class_oa.b(2.0F * (-3.1415927F + (0.7853982F * var10))));
						var9 = (int) (20.0F * class_oa.a(2.0F * (-3.1415927F + (0.7853982F * var10))));
					}
				}

				int var8 = Math.max(o.H() + 10, o.r(new class_cj(var7, 0, var9)).o() + var6);
				bK[var5] = new class_axa(var7, var8, var9);
			}

			bL[0] = 6146;
			bL[1] = 8197;
			bL[2] = 8202;
			bL[3] = 16404;
			bL[4] = 'è€¨';
			bL[5] = 'è��';
			bL[6] = 65696;
			bL[7] = 131392;
			bL[8] = 131712;
			bL[9] = 263424;
			bL[10] = 526848;
			bL[11] = 525313;
			bL[12] = 1581057;
			bL[13] = 3166214;
			bL[14] = 2138120;
			bL[15] = 6373424;
			bL[16] = 4358208;
			bL[17] = 12910976;
			bL[18] = 9044480;
			bL[19] = 9706496;
			bL[20] = 15216640;
			bL[21] = 13688832;
			bL[22] = 11763712;
			bL[23] = 8257536;
		}

		return this.k(s, t, u);
	}

	public int k(double var1, double var3, double var5) {
		float var7 = 10000.0F;
		int var8 = 0;
		class_axa var9 = new class_axa(class_oa.c(var1), class_oa.c(var3), class_oa.c(var5));
		byte var10 = 0;
		if ((bG == null) || (bG.c() == 0)) {
			var10 = 12;
		}

		for (int var11 = var10; var11 < 24; ++var11) {
			if (bK[var11] != null) {
				float var12 = bK[var11].b(var9);
				if (var12 < var7) {
					var7 = var12;
					var8 = var11;
				}
			}
		}

		return var8;
	}

	public class_axc a(int var1, int var2, class_axa var3) {
		class_axa var5;
		for (int var4 = 0; var4 < 24; ++var4) {
			var5 = bK[var4];
			var5.i = false;
			var5.g = 0.0F;
			var5.e = 0.0F;
			var5.f = 0.0F;
			var5.h = null;
			var5.d = -1;
		}

		class_axa var13 = bK[var1];
		var5 = bK[var2];
		var13.e = 0.0F;
		var13.f = var13.a(var5);
		var13.g = var13.f;
		bM.a();
		bM.a(var13);
		class_axa var6 = var13;
		byte var7 = 0;
		if ((bG == null) || (bG.c() == 0)) {
			var7 = 12;
		}

		while (!bM.e()) {
			class_axa var8 = bM.c();
			if (var8.equals(var5)) {
				if (var3 != null) {
					var3.h = var5;
					var5 = var3;
				}

				return this.a(var13, var5);
			}

			if (var8.a(var5) < var6.a(var5)) {
				var6 = var8;
			}

			var8.i = true;
			int var9 = 0;

			int var10;
			for (var10 = 0; var10 < 24; ++var10) {
				if (bK[var10] == var8) {
					var9 = var10;
					break;
				}
			}

			for (var10 = var7; var10 < 24; ++var10) {
				if ((bL[var9] & (1 << var10)) > 0) {
					class_axa var11 = bK[var10];
					if (!var11.i) {
						float var12 = var8.e + var8.a(var11);
						if (!var11.a() || (var12 < var11.e)) {
							var11.h = var8;
							var11.e = var12;
							var11.f = var11.a(var5);
							if (var11.a()) {
								bM.a(var11, var11.e + var11.f);
							} else {
								var11.g = var11.e + var11.f;
								bM.a(var11);
							}
						}
					}
				}
			}
		}

		if (var6 == var13) {
			return null;
		} else {
			bF.debug("Failed to find path from {} to {}", new Object[] { Integer.valueOf(var1), Integer.valueOf(var2) });
			if (var3 != null) {
				var3.h = var6;
				var6 = var3;
			}

			return this.a(var13, var6);
		}
	}

	private class_axc a(class_axa var1, class_axa var2) {
		int var3 = 1;

		class_axa var4;
		for (var4 = var2; var4.h != null; var4 = var4.h) {
			++var3;
		}

		class_axa[] var5 = new class_axa[var3];
		var4 = var2;
		--var3;

		for (var5[var3] = var2; var4.h != null; var5[var3] = var4) {
			var4 = var4.h;
			--var3;
		}

		return new class_axc(var5);
	}

	@Override
	public void b(class_dn var1) {
		super.b(var1);
		var1.a("DragonPhase", bH.a().i().b());
	}

	@Override
	public void a(class_dn var1) {
		super.a(var1);
		bH.a(class_wm.a(var1.h("DragonPhase")));
	}

	@Override
	protected void F() {
	}

	@Override
	public Entity[] aH() {
		return br;
	}

	@Override
	public boolean ag() {
		return false;
	}

	@Override
	public class_ago a() {
		return o;
	}

	@Override
	protected String B() {
		return "mob.enderdragon.growl";
	}

	@Override
	protected String bv() {
		return "mob.enderdragon.hit";
	}

	@Override
	protected float bI() {
		return 5.0F;
	}

	public class_aym a(float var1) {
		class_wg var2 = bH.a();
		class_wm var3 = var2.i();
		class_aym var4;
		float var6;
		if ((var3 != class_wm.d) && (var3 != class_wm.e)) {
			if (var2.a()) {
				float var10 = z;
				var6 = 1.5F;
				z = -6.0F * var6 * 5.0F;
				var4 = this.g(var1);
				z = var10;
			} else {
				var4 = this.g(var1);
			}
		} else {
			class_cj var5 = o.r(class_aso.a);
			var6 = Math.max(class_oa.a(this.c(var5)) / 4.0F, 1.0F);
			float var7 = 6.0F / var6;
			float var8 = z;
			float var9 = 1.5F;
			z = -var7 * var9 * 5.0F;
			var4 = this.g(var1);
			z = var8;
		}

		return var4;
	}

	public void a(class_vw var1, class_cj var2, class_qi var3) {
		class_yu var4;
		if (var3.j() instanceof class_yu) {
			var4 = (class_yu) var3.j();
		} else {
			var4 = o.a(var2, 64.0D, 64.0D);
		}

		if (var1 == bE) {
			this.a(bs, class_qi.b(var4), 10.0F);
		}

		bH.a().a(var1, var2, var3, var4);
	}

	@Override
	public void a(class_jz var1) {
		if ((var1 == a) && o.D) {
			bH.a(class_wm.a(((Integer) J().a(a)).intValue()));
		}

		super.a(var1);
	}

	public class_wn cy() {
		return bH;
	}

	public class_arg cz() {
		return bG;
	}

	static {
		a = class_kc.a(class_vx.class, class_kb.b);
	}
}
