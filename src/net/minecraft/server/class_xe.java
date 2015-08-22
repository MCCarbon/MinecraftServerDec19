package net.minecraft.server;

import java.util.List;

public class class_xe extends Entity {
	private static final class_jz a;
	private static final class_jz b;
	private static final class_jz c;
	private boolean d;
	private double e;
	private int f;
	private double g;
	private double h;
	private double i;
	private double as;
	private double at;

	public class_xe(class_ago var1) {
		super(var1);
		d = true;
		e = 0.07D;
		k = true;
		this.a(1.5F, 0.6F);
	}

	@Override
	protected boolean U() {
		return false;
	}

	@Override
	protected void h() {
		ac.a(a, Integer.valueOf(0));
		ac.a(b, Integer.valueOf(1));
		ac.a(c, Float.valueOf(0.0F));
	}

	@Override
	public class_ayk j(Entity var1) {
		return var1.aX();
	}

	@Override
	public class_ayk V() {
		return aX();
	}

	@Override
	public boolean ah() {
		return true;
	}

	public class_xe(class_ago var1, double var2, double var4, double var6) {
		this(var1);
		this.b(var2, var4, var6);
		v = 0.0D;
		w = 0.0D;
		x = 0.0D;
		p = var2;
		q = var4;
		r = var6;
	}

	@Override
	public double aq() {
		return -0.3D;
	}

	@Override
	public boolean a(class_qi var1, float var2) {
		if (this.b(var1)) {
			return false;
		} else if (!o.D && !I) {
			if ((l != null) && (l == var1.j()) && (var1 instanceof class_qk)) {
				return false;
			} else {
				this.b(-this.k());
				this.a(10);
				this.a(this.i() + (var2 * 10.0F));
				af();
				boolean var3 = (var1.j() instanceof class_yu) && ((class_yu) var1.j()).bI.d;
				if (var3 || (this.i() > 40.0F)) {
					if (l != null) {
						l.a(this);
					}

					if (!var3 && o.S().b("doEntityDrops")) {
						this.a(Items.aG, 1, 0.0F);
					}

					L();
				}

				return true;
			}
		} else {
			return true;
		}
	}

	@Override
	public boolean ag() {
		return !I;
	}

	@Override
	public void r_() {
		super.r_();
		if (this.j() > 0) {
			this.a(this.j() - 1);
		}

		if (this.i() > 0.0F) {
			this.a(this.i() - 1.0F);
		}

		p = s;
		q = t;
		r = u;
		byte var1 = 5;
		double var2 = 0.0D;

		for (int var4 = 0; var4 < var1; ++var4) {
			double var5 = (aX().b + (((aX().e - aX().b) * (var4 + 0)) / var1)) - 0.125D;
			double var7 = (aX().b + (((aX().e - aX().b) * (var4 + 1)) / var1)) - 0.125D;
			class_ayk var9 = new class_ayk(aX().a, var5, aX().c, aX().d, var7, aX().f);
			if (o.b(var9, class_avq.h)) {
				var2 += 1.0D / var1;
			}
		}

		double var19 = Math.sqrt((v * v) + (x * x));
		double var6;
		double var8;
		int var10;
		if (var19 > 0.2975D) {
			var6 = Math.cos((y * 3.141592653589793D) / 180.0D);
			var8 = Math.sin((y * 3.141592653589793D) / 180.0D);

			for (var10 = 0; var10 < (1.0D + (var19 * 60.0D)); ++var10) {
				double var11 = (V.nextFloat() * 2.0F) - 1.0F;
				double var13 = ((V.nextInt(2) * 2) - 1) * 0.7D;
				double var15;
				double var17;
				if (V.nextBoolean()) {
					var15 = (s - (var6 * var11 * 0.8D)) + (var8 * var13);
					var17 = u - (var8 * var11 * 0.8D) - (var6 * var13);
					o.a(class_cy.f, var15, t - 0.125D, var17, v, w, x, new int[0]);
				} else {
					var15 = s + var6 + (var8 * var11 * 0.7D);
					var17 = (u + var8) - (var6 * var11 * 0.7D);
					o.a(class_cy.f, var15, t - 0.125D, var17, v, w, x, new int[0]);
				}
			}
		}

		double var24;
		double var26;
		if (o.D && d) {
			if (f > 0) {
				var6 = s + ((g - s) / f);
				var8 = t + ((h - t) / f);
				var24 = u + ((i - u) / f);
				var26 = class_oa.g(as - y);
				y = (float) (y + (var26 / f));
				z = (float) (z + ((at - z) / f));
				--f;
				this.b(var6, var8, var24);
				this.b(y, z);
			} else {
				var6 = s + v;
				var8 = t + w;
				var24 = u + x;
				this.b(var6, var8, var24);
				if (C) {
					v *= 0.5D;
					w *= 0.5D;
					x *= 0.5D;
				}

				v *= 0.9900000095367432D;
				w *= 0.949999988079071D;
				x *= 0.9900000095367432D;
			}

		} else {
			if (var2 < 1.0D) {
				var6 = (var2 * 2.0D) - 1.0D;
				w += 0.03999999910593033D * var6;
			} else {
				if (w < 0.0D) {
					w /= 2.0D;
				}

				w += 0.007000000216066837D;
			}

			if (l instanceof class_rg) {
				class_rg var20 = (class_rg) l;
				float var21 = l.y + (-var20.bd * 90.0F);
				v += -Math.sin((var21 * 3.1415927F) / 180.0F) * e * var20.be * 0.05000000074505806D;
				x += Math.cos((var21 * 3.1415927F) / 180.0F) * e * var20.be * 0.05000000074505806D;
			}

			var6 = Math.sqrt((v * v) + (x * x));
			if (var6 > 0.35D) {
				var8 = 0.35D / var6;
				v *= var8;
				x *= var8;
				var6 = 0.35D;
			}

			if ((var6 > var19) && (e < 0.35D)) {
				e += (0.35D - e) / 35.0D;
				if (e > 0.35D) {
					e = 0.35D;
				}
			} else {
				e -= (e - 0.07D) / 35.0D;
				if (e < 0.07D) {
					e = 0.07D;
				}
			}

			int var22;
			for (var22 = 0; var22 < 4; ++var22) {
				int var23 = class_oa.c(s + ((var22 % 2 - 0.5D) * 0.8D));
				var10 = class_oa.c(u + ((var22 / 2 - 0.5D) * 0.8D));

				for (int var25 = 0; var25 < 2; ++var25) {
					int var12 = class_oa.c(t) + var25;
					class_cj var27 = new class_cj(var23, var12, var10);
					Block var14 = o.p(var27).c();
					if (var14 == Blocks.aH) {
						o.g(var27);
						D = false;
					} else if (var14 == Blocks.bx) {
						o.b(var27, true);
						D = false;
					}
				}
			}

			if (C) {
				v *= 0.5D;
				w *= 0.5D;
				x *= 0.5D;
			}

			this.d(v, w, x);
			if (D && (var19 > 0.2975D)) {
				if (!o.D && !I) {
					L();
					if (o.S().b("doEntityDrops")) {
						for (var22 = 0; var22 < 3; ++var22) {
							this.a(Item.a(Blocks.f), 1, 0.0F);
						}

						for (var22 = 0; var22 < 2; ++var22) {
							this.a(Items.A, 1, 0.0F);
						}
					}
				}
			} else {
				v *= 0.9900000095367432D;
				w *= 0.949999988079071D;
				x *= 0.9900000095367432D;
			}

			z = 0.0F;
			var8 = y;
			var24 = p - s;
			var26 = r - u;
			if (((var24 * var24) + (var26 * var26)) > 0.001D) {
				var8 = ((float) ((class_oa.b(var26, var24) * 180.0D) / 3.141592653589793D));
			}

			double var28 = class_oa.g(var8 - y);
			if (var28 > 20.0D) {
				var28 = 20.0D;
			}

			if (var28 < -20.0D) {
				var28 = -20.0D;
			}

			y = (float) (y + var28);
			this.b(y, z);
			if (!o.D) {
				List var16 = o.b(this, aX().b(0.20000000298023224D, 0.0D, 0.20000000298023224D));
				if ((var16 != null) && !var16.isEmpty()) {
					for (int var29 = 0; var29 < var16.size(); ++var29) {
						Entity var18 = (Entity) var16.get(var29);
						if ((var18 != l) && var18.ah() && (var18 instanceof class_xe)) {
							var18.i(this);
						}
					}
				}

				if ((l != null) && l.I) {
					l = null;
				}

			}
		}
	}

	@Override
	public void ao() {
		if (l != null) {
			double var1 = Math.cos((y * 3.141592653589793D) / 180.0D) * 0.4D;
			double var3 = Math.sin((y * 3.141592653589793D) / 180.0D) * 0.4D;
			l.b(s + var1, t + aq() + l.ap(), u + var3);
		}
	}

	@Override
	protected void b(class_dn var1) {
	}

	@Override
	protected void a(class_dn var1) {
	}

	@Override
	public boolean a(class_yu var1, class_aco var2, class_pu var3) {
		if ((l != null) && (l instanceof class_yu) && (l != var1)) {
			return true;
		} else {
			if (!o.D) {
				var1.a(this);
			}

			return true;
		}
	}

	@Override
	protected void a(double var1, boolean var3, Block var4, class_cj var5) {
		if (var3) {
			if (O > 3.0F) {
				this.e(O, 1.0F);
				if (!o.D && !I) {
					L();
					if (o.S().b("doEntityDrops")) {
						int var6;
						for (var6 = 0; var6 < 3; ++var6) {
							this.a(Item.a(Blocks.f), 1, 0.0F);
						}

						for (var6 = 0; var6 < 2; ++var6) {
							this.a(Items.A, 1, 0.0F);
						}
					}
				}

				O = 0.0F;
			}
		} else if ((o.p((new class_cj(this)).b()).c().v() != class_avq.h) && (var1 < 0.0D)) {
			O = (float) (O - var1);
		}

	}

	public void a(float var1) {
		ac.b(c, Float.valueOf(var1));
	}

	public float i() {
		return ((Float) ac.a(c)).floatValue();
	}

	public void a(int var1) {
		ac.b(a, Integer.valueOf(var1));
	}

	public int j() {
		return ((Integer) ac.a(a)).intValue();
	}

	public void b(int var1) {
		ac.b(b, Integer.valueOf(var1));
	}

	public int k() {
		return ((Integer) ac.a(b)).intValue();
	}

	static {
		a = class_kc.a(class_xe.class, class_kb.b);
		b = class_kc.a(class_xe.class, class_kb.b);
		c = class_kc.a(class_xe.class, class_kb.c);
	}
}
