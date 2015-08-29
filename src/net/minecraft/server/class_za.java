package net.minecraft.server;


public abstract class class_za extends Entity {
	private int a = -1;
	private int f = -1;
	private int g = -1;
	private Block h;
	private boolean i;
	public EntityLiving b;
	private int as;
	private int at;
	public double c;
	public double d;
	public double e;

	public class_za(class_ago var1) {
		super(var1);
		this.a(1.0F, 1.0F);
	}

	@Override
	protected void h() {
	}

	public class_za(class_ago var1, double var2, double var4, double var6, double var8, double var10, double var12) {
		super(var1);
		this.a(1.0F, 1.0F);
		this.b(var2, var4, var6, y, z);
		this.b(var2, var4, var6);
		double var14 = MathHelper.a((var8 * var8) + (var10 * var10) + (var12 * var12));
		c = (var8 / var14) * 0.1D;
		d = (var10 / var14) * 0.1D;
		e = (var12 / var14) * 0.1D;
	}

	public class_za(class_ago var1, EntityLiving var2, double var3, double var5, double var7) {
		super(var1);
		b = var2;
		this.a(1.0F, 1.0F);
		this.b(var2.s, var2.t, var2.u, var2.y, var2.z);
		this.b(s, t, u);
		v = w = x = 0.0D;
		var3 += V.nextGaussian() * 0.4D;
		var5 += V.nextGaussian() * 0.4D;
		var7 += V.nextGaussian() * 0.4D;
		double var9 = MathHelper.a((var3 * var3) + (var5 * var5) + (var7 * var7));
		c = (var3 / var9) * 0.1D;
		d = (var5 / var9) * 0.1D;
		e = (var7 / var9) * 0.1D;
	}

	@Override
	public void r_() {
		if (!o.D && (((b != null) && b.I) || !o.e(new class_cj(this)))) {
			L();
		} else {
			super.r_();
			if (this.j()) {
				this.e(1);
			}

			if (i) {
				if (o.p(new class_cj(a, f, g)).c() == h) {
					++as;
					if (as == 600) {
						L();
					}

					return;
				}

				i = false;
				v *= V.nextFloat() * 0.2F;
				w *= V.nextFloat() * 0.2F;
				x *= V.nextFloat() * 0.2F;
				as = 0;
				at = 0;
			} else {
				++at;
			}

			class_ayl var1 = class_ze.a(this, true, at >= 25, b);
			if (var1 != null) {
				this.a(var1);
			}

			s += v;
			t += w;
			u += x;
			class_ze.a(this, 0.2F);
			float var2 = this.k();
			if (Y()) {
				for (int var3 = 0; var3 < 4; ++var3) {
					float var4 = 0.25F;
					o.a(class_cy.e, s - (v * var4), t - (w * var4), u - (x * var4), v, w, x, new int[0]);
				}

				var2 = 0.8F;
			}

			v += c;
			w += d;
			x += e;
			v *= var2;
			w *= var2;
			x *= var2;
			o.a(this.i(), s, t + 0.5D, u, 0.0D, 0.0D, 0.0D, new int[0]);
			this.b(s, t, u);
		}
	}

	protected boolean j() {
		return true;
	}

	protected class_cy i() {
		return class_cy.l;
	}

	protected float k() {
		return 0.95F;
	}

	protected abstract void a(class_ayl var1);

	@Override
	public void b(class_dn var1) {
		var1.a("xTile", a);
		var1.a("yTile", f);
		var1.a("zTile", g);
		class_ke var2 = (class_ke) Block.c.b(h);
		var1.a("inTile", var2 == null ? "" : var2.toString());
		var1.a("inGround", (byte) (i ? 1 : 0));
		var1.a("direction", this.a((new double[] { v, w, x })));
		var1.a("power", this.a((new double[] { c, d, e })));
		var1.a("life", as);
	}

	@Override
	public void a(class_dn var1) {
		a = var1.h("xTile");
		f = var1.h("yTile");
		g = var1.h("zTile");
		if (var1.b("inTile", 8)) {
			h = Block.b(var1.l("inTile"));
		} else {
			h = Block.c(var1.f("inTile") & 255);
		}

		i = var1.f("inGround") == 1;
		class_du var2;
		if (var1.b("power", 9)) {
			var2 = var1.c("power", 6);
			if (var2.c() == 3) {
				c = var2.e(0);
				d = var2.e(1);
				e = var2.e(2);
			}
		}

		as = var1.h("life");
		if (var1.b("direction", 9) && (var1.c("direction", 6).c() == 3)) {
			var2 = var1.c("direction", 6);
			v = var2.e(0);
			w = var2.e(1);
			x = var2.e(2);
		} else {
			L();
		}

	}

	@Override
	public boolean ag() {
		return true;
	}

	@Override
	public float ar() {
		return 1.0F;
	}

	@Override
	public boolean a(class_qi var1, float var2) {
		if (this.b(var1)) {
			return false;
		} else {
			af();
			if (var1.j() != null) {
				class_aym var3 = var1.j().as();
				if (var3 != null) {
					v = var3.a;
					w = var3.b;
					x = var3.c;
					c = v * 0.1D;
					d = w * 0.1D;
					e = x * 0.1D;
				}

				if (var1.j() instanceof EntityLiving) {
					b = (EntityLiving) var1.j();
				}

				return true;
			} else {
				return false;
			}
		}
	}

	@Override
	public float f(float var1) {
		return 1.0F;
	}
}
