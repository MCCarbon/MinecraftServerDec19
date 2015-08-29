package net.minecraft.server;

import java.util.Iterator;
import java.util.List;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

public class EntityWither extends EntityMonster implements class_ye {
	private static final class_jz a;
	private static final class_jz b;
	private static final class_jz c;
	private static final class_jz[] bt;
	private static final class_jz bu;
	private float[] bv = new float[2];
	private float[] bw = new float[2];
	private float[] bx = new float[2];
	private float[] by = new float[2];
	private int[] bz = new int[2];
	private int[] bA = new int[2];
	private int bB;
	private final class_lj bC;
	private static final Predicate bD;

	public EntityWither(class_ago var1) {
		super(var1);
		bC = new class_lj(f_(), class_pn.class_a_in_class_pn.f, class_pn.class_b_in_class_pn.a, true, false);
		this.c(bB());
		this.a(0.9F, 3.5F);
		ab = true;
		((class_ul) u()).d(true);
		i.a(0, new class_so(this));
		i.a(2, new class_to(this, 1.0D, 40, 20.0F));
		i.a(5, new class_tn(this, 1.0D));
		i.a(6, new class_sw(this, class_yu.class, 8.0F));
		i.a(7, new class_tm(this));
		bo.a(1, new class_uc(this, false, new Class[0]));
		bo.a(2, new class_uf(this, EntityInsentient.class, 0, false, false, bD));
		b_ = 50;
	}

	@Override
	protected void h() {
		super.h();
		ac.a(a, Integer.valueOf(0));
		ac.a(b, Integer.valueOf(0));
		ac.a(c, Integer.valueOf(0));
		ac.a(bu, Integer.valueOf(0));
	}

	@Override
	public void b(class_dn var1) {
		super.b(var1);
		var1.a("Invul", cE());
	}

	@Override
	public void a(class_dn var1) {
		super.a(var1);
		this.k(var1.h("Invul"));
	}

	@Override
	protected String B() {
		return "mob.wither.idle";
	}

	@Override
	protected String bv() {
		return "mob.wither.hurt";
	}

	@Override
	protected String bw() {
		return "mob.wither.death";
	}

	@Override
	public void m() {
		w *= 0.6000000238418579D;
		double var4;
		double var6;
		double var8;
		if (!o.D && (this.l(0) > 0)) {
			Entity var1 = o.a(this.l(0));
			if (var1 != null) {
				if ((t < var1.t) || (!cF() && (t < (var1.t + 5.0D)))) {
					if (w < 0.0D) {
						w = 0.0D;
					}

					w += (0.5D - w) * 0.6000000238418579D;
				}

				double var2 = var1.s - s;
				var4 = var1.u - u;
				var6 = (var2 * var2) + (var4 * var4);
				if (var6 > 9.0D) {
					var8 = MathHelper.a(var6);
					v += (((var2 / var8) * 0.5D) - v) * 0.6000000238418579D;
					x += (((var4 / var8) * 0.5D) - x) * 0.6000000238418579D;
				}
			}
		}

		if (((v * v) + (x * x)) > 0.05000000074505806D) {
			y = ((float) MathHelper.b(x, v) * 57.295776F) - 90.0F;
		}

		super.m();

		int var20;
		for (var20 = 0; var20 < 2; ++var20) {
			by[var20] = bw[var20];
			bx[var20] = bv[var20];
		}

		int var21;
		for (var20 = 0; var20 < 2; ++var20) {
			var21 = this.l(var20 + 1);
			Entity var3 = null;
			if (var21 > 0) {
				var3 = o.a(var21);
			}

			if (var3 != null) {
				var4 = this.m(var20 + 1);
				var6 = this.n(var20 + 1);
				var8 = this.o(var20 + 1);
				double var10 = var3.s - var4;
				double var12 = (var3.t + var3.aY()) - var6;
				double var14 = var3.u - var8;
				double var16 = MathHelper.a((var10 * var10) + (var14 * var14));
				float var18 = (float) ((MathHelper.b(var14, var10) * 180.0D) / 3.1415927410125732D) - 90.0F;
				float var19 = (float) (-((MathHelper.b(var12, var16) * 180.0D) / 3.1415927410125732D));
				bv[var20] = this.b(bv[var20], var19, 40.0F);
				bw[var20] = this.b(bw[var20], var18, 10.0F);
			} else {
				bw[var20] = this.b(bw[var20], aM, 10.0F);
			}
		}

		boolean var22 = cF();

		for (var21 = 0; var21 < 3; ++var21) {
			double var23 = this.m(var21);
			double var5 = this.n(var21);
			double var7 = this.o(var21);
			o.a(class_cy.l, var23 + (V.nextGaussian() * 0.30000001192092896D), var5 + (V.nextGaussian() * 0.30000001192092896D), var7 + (V.nextGaussian() * 0.30000001192092896D), 0.0D, 0.0D, 0.0D, new int[0]);
			if (var22 && (o.s.nextInt(4) == 0)) {
				o.a(class_cy.p, var23 + (V.nextGaussian() * 0.30000001192092896D), var5 + (V.nextGaussian() * 0.30000001192092896D), var7 + (V.nextGaussian() * 0.30000001192092896D), 0.699999988079071D, 0.699999988079071D, 0.5D, new int[0]);
			}
		}

		if (cE() > 0) {
			for (var21 = 0; var21 < 3; ++var21) {
				o.a(class_cy.p, s + (V.nextGaussian() * 1.0D), t + V.nextFloat() * 3.3F, u + (V.nextGaussian() * 1.0D), 0.699999988079071D, 0.699999988079071D, 0.8999999761581421D, new int[0]);
			}
		}

	}

	@Override
	protected void cg() {
		int var1;
		if (cE() > 0) {
			var1 = cE() - 1;
			if (var1 <= 0) {
				o.a(this, s, t + aY(), u, 7.0F, false, o.S().b("mobGriefing"));
				o.a(1013, new class_cj(this), 0);
			}

			this.k(var1);
			if ((W % 10) == 0) {
				this.b(10.0F);
			}

		} else {
			super.cg();

			int var13;
			for (var1 = 1; var1 < 3; ++var1) {
				if (W >= bz[var1 - 1]) {
					bz[var1 - 1] = W + 10 + V.nextInt(10);
					if ((o.ac() == class_ps.c) || (o.ac() == class_ps.d)) {
						int var10001 = var1 - 1;
						int var10003 = bA[var1 - 1];
						bA[var10001] = bA[var1 - 1] + 1;
						if (var10003 > 15) {
							float var2 = 10.0F;
							float var3 = 5.0F;
							double var4 = MathHelper.a(V, s - var2, s + var2);
							double var6 = MathHelper.a(V, t - var3, t + var3);
							double var8 = MathHelper.a(V, u - var2, u + var2);
							this.a(var1 + 1, var4, var6, var8, true);
							bA[var1 - 1] = 0;
						}
					}

					var13 = this.l(var1);
					if (var13 > 0) {
						Entity var15 = o.a(var13);
						if ((var15 != null) && var15.al() && (this.h(var15) <= 900.0D) && this.t(var15)) {
							if ((var15 instanceof class_yu) && ((class_yu) var15).bI.a) {
								this.a(var1, 0);
							} else {
								this.a(var1 + 1, (EntityLiving) var15);
								bz[var1 - 1] = W + 40 + V.nextInt(20);
								bA[var1 - 1] = 0;
							}
						} else {
							this.a(var1, 0);
						}
					} else {
						List var14 = o.a(EntityLiving.class, aX().b(20.0D, 8.0D, 20.0D), Predicates.and(bD, class_rb.d));

						for (int var17 = 0; (var17 < 10) && !var14.isEmpty(); ++var17) {
							EntityLiving var5 = (EntityLiving) var14.get(V.nextInt(var14.size()));
							if ((var5 != this) && var5.al() && this.t(var5)) {
								if (var5 instanceof class_yu) {
									if (!((class_yu) var5).bI.a) {
										this.a(var1, var5.G());
									}
								} else {
									this.a(var1, var5.G());
								}
								break;
							}

							var14.remove(var5);
						}
					}
				}
			}

			if (w() != null) {
				this.a(0, w().G());
			} else {
				this.a(0, 0);
			}

			if (bB > 0) {
				--bB;
				if ((bB == 0) && o.S().b("mobGriefing")) {
					var1 = MathHelper.c(t);
					var13 = MathHelper.c(s);
					int var16 = MathHelper.c(u);
					boolean var18 = false;

					for (int var19 = -1; var19 <= 1; ++var19) {
						for (int var20 = -1; var20 <= 1; ++var20) {
							for (int var7 = 0; var7 <= 3; ++var7) {
								int var21 = var13 + var19;
								int var9 = var1 + var7;
								int var10 = var16 + var20;
								class_cj var11 = new class_cj(var21, var9, var10);
								Block var12 = o.p(var11).c();
								if ((var12.v() != class_avq.a) && a(var12)) {
									var18 = o.b(var11, true) || var18;
								}
							}
						}
					}

					if (var18) {
						o.a((class_yu) null, 1012, new class_cj(this), 0);
					}
				}
			}

			if ((W % 20) == 0) {
				this.b(1.0F);
			}

			bC.a(bu() / bB());
		}
	}

	public static boolean a(Block var0) {
		return (var0 != Blocks.BEDROCK) && (var0 != Blocks.END_PORTAL) && (var0 != Blocks.END_PORTAL_FRAME) && (var0 != Blocks.COMMAND_BLOCK) && (var0 != Blocks.REPEATING_COMMAND_BLOCK) && (var0 != Blocks.CHAIN_COMMAND_BLOCK) && (var0 != Blocks.BARRIER);
	}

	public void n() {
		this.k(220);
		this.c(bB() / 3.0F);
	}

	@Override
	public void aG() {
	}

	@Override
	public void b(class_lm var1) {
		super.b(var1);
		bC.a(var1);
	}

	@Override
	public void c(class_lm var1) {
		super.c(var1);
		bC.b(var1);
	}

	@Override
	public int by() {
		return 4;
	}

	private double m(int var1) {
		if (var1 <= 0) {
			return s;
		} else {
			float var2 = ((aM + 180 * (var1 - 1)) / 180.0F) * 3.1415927F;
			float var3 = MathHelper.b(var2);
			return s + (var3 * 1.3D);
		}
	}

	private double n(int var1) {
		return var1 <= 0 ? t + 3.0D : t + 2.2D;
	}

	private double o(int var1) {
		if (var1 <= 0) {
			return u;
		} else {
			float var2 = ((aM + 180 * (var1 - 1)) / 180.0F) * 3.1415927F;
			float var3 = MathHelper.a(var2);
			return u + (var3 * 1.3D);
		}
	}

	private float b(float var1, float var2, float var3) {
		float var4 = MathHelper.g(var2 - var1);
		if (var4 > var3) {
			var4 = var3;
		}

		if (var4 < -var3) {
			var4 = -var3;
		}

		return var1 + var4;
	}

	private void a(int var1, EntityLiving var2) {
		this.a(var1, var2.s, var2.t + (var2.aY() * 0.5D), var2.u, (var1 == 0) && (V.nextFloat() < 0.001F));
	}

	private void a(int var1, double var2, double var4, double var6, boolean var8) {
		o.a((class_yu) null, 1014, new class_cj(this), 0);
		double var9 = this.m(var1);
		double var11 = this.n(var1);
		double var13 = this.o(var1);
		double var15 = var2 - var9;
		double var17 = var4 - var11;
		double var19 = var6 - var13;
		EntityWitherSkull var21 = new EntityWitherSkull(o, this, var15, var17, var19);
		if (var8) {
			var21.a(true);
		}

		var21.t = var11;
		var21.s = var9;
		var21.u = var13;
		o.a(var21);
	}

	@Override
	public void a(EntityLiving var1, float var2) {
		this.a(0, var1);
	}

	@Override
	public boolean a(class_qi var1, float var2) {
		if (this.b(var1)) {
			return false;
		} else if ((var1 != class_qi.f) && !(var1.j() instanceof EntityWither)) {
			if ((cE() > 0) && (var1 != class_qi.j)) {
				return false;
			} else {
				Entity var3;
				if (cF()) {
					var3 = var1.i();
					if (var3 instanceof EntityArrow) {
						return false;
					}
				}

				var3 = var1.j();
				if ((var3 != null) && !(var3 instanceof class_yu) && (var3 instanceof EntityLiving) && (((EntityLiving) var3).bF() == bF())) {
					return false;
				} else {
					if (bB <= 0) {
						bB = 20;
					}

					for (int var4 = 0; var4 < bA.length; ++var4) {
						bA[var4] += 3;
					}

					return super.a(var1, var2);
				}
			}
		} else {
			return false;
		}
	}

	@Override
	protected void b(boolean var1, int var2) {
		EntityItem var3 = this.a(Items.ce, 1);
		if (var3 != null) {
			var3.t();
		}

		if (!o.D) {
			Iterator var4 = o.a(class_yu.class, aX().b(50.0D, 100.0D, 50.0D)).iterator();

			while (var4.hasNext()) {
				class_yu var5 = (class_yu) var4.next();
				var5.b(class_my.J);
			}
		}

	}

	@Override
	protected void F() {
		aU = 0;
	}

	@Override
	public void e(float var1, float var2) {
	}

	@Override
	public void c(class_qr var1) {
	}

	@Override
	protected void be() {
		super.be();
		this.a(class_yf.a).a(300.0D);
		this.a(class_yf.d).a(0.6000000238418579D);
		this.a(class_yf.b).a(40.0D);
	}

	public int cE() {
		return ((Integer) ac.a(bu)).intValue();
	}

	public void k(int var1) {
		ac.b(bu, Integer.valueOf(var1));
	}

	public int l(int var1) {
		return ((Integer) ac.a(bt[var1])).intValue();
	}

	public void a(int var1, int var2) {
		ac.b(bt[var1], Integer.valueOf(var2));
	}

	public boolean cF() {
		return bu() <= (bB() / 2.0F);
	}

	@Override
	public class_rl bF() {
		return class_rl.b;
	}

	@Override
	public void a(Entity var1) {
		m = null;
	}

	static {
		a = DataWatcher.claimId(EntityWither.class, class_kb.b);
		b = DataWatcher.claimId(EntityWither.class, class_kb.b);
		c = DataWatcher.claimId(EntityWither.class, class_kb.b);
		bt = new class_jz[] { a, b, c };
		bu = DataWatcher.claimId(EntityWither.class, class_kb.b);
		bD = new Predicate() {
			public boolean a(Entity var1) {
				return (var1 instanceof EntityLiving) && (((EntityLiving) var1).bF() != class_rl.b);
			}

			// $FF: synthetic method
			@Override
			public boolean apply(Object var1) {
				return this.a((Entity) var1);
			}
		};
	}
}
