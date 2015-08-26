package net.minecraft.server;

import java.util.List;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

public class class_yx extends Entity implements class_zd {
	private static final Predicate f;
	private static final class_jz g;
	private int h;
	private int i;
	private int as;
	private Block at;
	private int au;
	protected boolean a;
	protected int b;
	public int c;
	public int d;
	public Entity e;
	private int av;
	private int aw;
	private double ax;
	private int ay;

	public class_yx(class_ago var1) {
		super(var1);
		h = -1;
		i = -1;
		as = -1;
		ax = 2.0D;
		j = 10.0D;
		this.a(0.5F, 0.5F);
	}

	public class_yx(class_ago var1, double var2, double var4, double var6) {
		this(var1);
		this.b(var2, var4, var6);
	}

	public class_yx(class_ago var1, class_rg var2) {
		this(var1, var2.s, (var2.t + var2.aY()) - 0.10000000149011612D, var2.u);
		e = var2;
		if (var2 instanceof class_yu) {
			c = 1;
		}

	}

	@Override
	protected void h() {
		ac.a(g, Byte.valueOf((byte) 0));
	}

	public void a(float var1, float var2, float var3, float var4, float var5) {
		float var6 = -MathHelper.a(var2 * 0.017453292F) * MathHelper.b(var1 * 0.017453292F);
		float var7 = -MathHelper.a(var1 * 0.017453292F);
		float var8 = MathHelper.b(var2 * 0.017453292F) * MathHelper.b(var1 * 0.017453292F);
		this.c(var6, var7, var8, var4, var5);
	}

	@Override
	public void c(double var1, double var3, double var5, float var7, float var8) {
		float var9 = MathHelper.a((var1 * var1) + (var3 * var3) + (var5 * var5));
		var1 /= var9;
		var3 /= var9;
		var5 /= var9;
		var1 += V.nextGaussian() * 0.007499999832361937D * var8;
		var3 += V.nextGaussian() * 0.007499999832361937D * var8;
		var5 += V.nextGaussian() * 0.007499999832361937D * var8;
		var1 *= var7;
		var3 *= var7;
		var5 *= var7;
		v = var1;
		w = var3;
		x = var5;
		float var10 = MathHelper.a((var1 * var1) + (var5 * var5));
		A = y = (float) ((MathHelper.b(var1, var5) * 180.0D) / 3.1415927410125732D);
		B = z = (float) ((MathHelper.b(var3, var10) * 180.0D) / 3.1415927410125732D);
		av = 0;
	}

	@Override
	public void r_() {
		super.r_();
		if ((B == 0.0F) && (A == 0.0F)) {
			float var1 = MathHelper.a((v * v) + (x * x));
			A = y = (float) ((MathHelper.b(v, x) * 180.0D) / 3.1415927410125732D);
			B = z = (float) ((MathHelper.b(w, var1) * 180.0D) / 3.1415927410125732D);
		}

		class_cj var13 = new class_cj(h, i, as);
		class_apn var2 = o.p(var13);
		Block var3 = var2.c();
		if (var3.v() != class_avq.a) {
			var3.a((class_ags) o, var13);
			class_ayk var4 = var3.a(o, var13, var2);
			if ((var4 != null) && var4.a(new class_aym(s, t, u))) {
				a = true;
			}
		}

		if (d > 0) {
			--d;
		}

		if (a) {
			int var15 = var3.c(var2);
			if ((var3 == at) && (var15 == au)) {
				++av;
				if (av >= 1200) {
					L();
				}
			} else {
				a = false;
				v *= V.nextFloat() * 0.2F;
				w *= V.nextFloat() * 0.2F;
				x *= V.nextFloat() * 0.2F;
				av = 0;
				aw = 0;
			}

			++b;
		} else {
			b = 0;
			++aw;
			class_aym var14 = new class_aym(s, t, u);
			class_aym var5 = new class_aym(s + v, t + w, u + x);
			class_ayl var6 = o.a(var14, var5, false, true, false);
			var14 = new class_aym(s, t, u);
			var5 = new class_aym(s + v, t + w, u + x);
			if (var6 != null) {
				var5 = new class_aym(var6.c.a, var6.c.b, var6.c.c);
			}

			Entity var7 = this.a(var14, var5);
			if (var7 != null) {
				var6 = new class_ayl(var7);
			}

			if ((var6 != null) && (var6.d != null) && (var6.d instanceof class_yu)) {
				class_yu var8 = (class_yu) var6.d;
				if (var8.bI.a || ((e instanceof class_yu) && !((class_yu) e).a(var8))) {
					var6 = null;
				}
			}

			if (var6 != null) {
				this.a(var6);
			}

			if (this.k()) {
				for (int var16 = 0; var16 < 4; ++var16) {
					o.a(class_cy.j, s + ((v * var16) / 4.0D), t + ((w * var16) / 4.0D), u + ((x * var16) / 4.0D), -v, -w + 0.2D, -x, new int[0]);
				}
			}

			s += v;
			t += w;
			u += x;
			float var17 = MathHelper.a((v * v) + (x * x));
			y = (float) ((MathHelper.b(v, x) * 180.0D) / 3.1415927410125732D);

			for (z = (float) ((MathHelper.b(w, var17) * 180.0D) / 3.1415927410125732D); (z - B) < -180.0F; B -= 360.0F) {
				;
			}

			while ((z - B) >= 180.0F) {
				B += 360.0F;
			}

			while ((y - A) < -180.0F) {
				A -= 360.0F;
			}

			while ((y - A) >= 180.0F) {
				A += 360.0F;
			}

			z = B + ((z - B) * 0.2F);
			y = A + ((y - A) * 0.2F);
			float var9 = 0.99F;
			float var10 = 0.05F;
			if (Y()) {
				for (int var11 = 0; var11 < 4; ++var11) {
					float var12 = 0.25F;
					o.a(class_cy.e, s - (v * var12), t - (w * var12), u - (x * var12), v, w, x, new int[0]);
				}

				var9 = 0.6F;
			}

			if (X()) {
				P();
			}

			v *= var9;
			w *= var9;
			x *= var9;
			w -= var10;
			this.b(s, t, u);
			S();
		}
	}

	protected void a(class_ayl var1) {
		Entity var2 = var1.d;
		if (var2 != null) {
			float var3 = MathHelper.a((v * v) + (w * w) + (x * x));
			int var4 = MathHelper.f(var3 * ax);
			if (this.k()) {
				var4 += V.nextInt((var4 / 2) + 2);
			}

			class_qi var5;
			if (e == null) {
				var5 = class_qi.a(this, this);
			} else {
				var5 = class_qi.a(this, e);
			}

			if (ay() && !(var2 instanceof class_xv)) {
				var2.e(5);
			}

			if (var2.a(var5, var4)) {
				if (var2 instanceof class_rg) {
					class_rg var6 = (class_rg) var2;
					if (!o.D) {
						var6.j(var6.bC() + 1);
					}

					if (ay > 0) {
						float var7 = MathHelper.a((v * v) + (x * x));
						if (var7 > 0.0F) {
							var6.g((v * ay * 0.6000000238418579D) / var7, 0.1D, (x * ay * 0.6000000238418579D) / var7);
						}
					}

					if (e instanceof class_rg) {
						class_afl.a(var6, e);
						class_afl.b(((class_rg) e), var6);
					}

					this.a(var6);
					if ((e != null) && (var6 != e) && (var6 instanceof class_yu) && (e instanceof class_lm)) {
						((class_lm) e).a.a((new class_gn(6, 0.0F)));
					}
				}

				this.a("random.bowhit", 1.0F, 1.2F / ((V.nextFloat() * 0.2F) + 0.9F));
				if (!(var2 instanceof class_xv)) {
					L();
				}
			} else {
				v *= -0.10000000149011612D;
				w *= -0.10000000149011612D;
				x *= -0.10000000149011612D;
				y += 180.0F;
				A += 180.0F;
				aw = 0;
			}
		} else {
			class_cj var8 = var1.a();
			h = var8.n();
			i = var8.o();
			as = var8.p();
			class_apn var9 = o.p(var8);
			at = var9.c();
			au = at.c(var9);
			v = ((float) (var1.c.a - s));
			w = ((float) (var1.c.b - t));
			x = ((float) (var1.c.c - u));
			float var10 = MathHelper.a((v * v) + (w * w) + (x * x));
			s -= (v / var10) * 0.05000000074505806D;
			t -= (w / var10) * 0.05000000074505806D;
			u -= (x / var10) * 0.05000000074505806D;
			this.a("random.bowhit", 1.0F, 1.2F / ((V.nextFloat() * 0.2F) + 0.9F));
			a = true;
			d = 7;
			this.a(false);
			if (at.v() != class_avq.a) {
				at.a(o, var8, var9, this);
			}
		}

	}

	protected void a(class_rg var1) {
	}

	protected Entity a(class_aym var1, class_aym var2) {
		Entity var3 = null;
		List var4 = o.a(this, aX().a(v, w, x).b(1.0D, 1.0D, 1.0D), f);
		double var5 = 0.0D;

		for (int var7 = 0; var7 < var4.size(); ++var7) {
			Entity var8 = (Entity) var4.get(var7);
			if ((var8 != e) || (aw >= 5)) {
				float var9 = 0.3F;
				class_ayk var10 = var8.aX().b(var9, var9, var9);
				class_ayl var11 = var10.a(var1, var2);
				if (var11 != null) {
					double var12 = var1.g(var11.c);
					if ((var12 < var5) || (var5 == 0.0D)) {
						var3 = var8;
						var5 = var12;
					}
				}
			}
		}

		return var3;
	}

	@Override
	public void b(class_dn var1) {
		var1.a("xTile", h);
		var1.a("yTile", i);
		var1.a("zTile", as);
		var1.a("life", (short) av);
		class_ke var2 = (class_ke) Block.c.b(at);
		var1.a("inTile", var2 == null ? "" : var2.toString());
		var1.a("inData", (byte) au);
		var1.a("shake", (byte) d);
		var1.a("inGround", (byte) (a ? 1 : 0));
		var1.a("pickup", (byte) c);
		var1.a("damage", ax);
	}

	@Override
	public void a(class_dn var1) {
		h = var1.h("xTile");
		i = var1.h("yTile");
		as = var1.h("zTile");
		av = var1.g("life");
		if (var1.b("inTile", 8)) {
			at = Block.b(var1.l("inTile"));
		} else {
			at = Block.c(var1.f("inTile") & 255);
		}

		au = var1.f("inData") & 255;
		d = var1.f("shake") & 255;
		a = var1.f("inGround") == 1;
		if (var1.b("damage", 99)) {
			ax = var1.k("damage");
		}

		if (var1.b("pickup", 99)) {
			c = var1.f("pickup");
		} else if (var1.b("player", 99)) {
			c = var1.p("player") ? 1 : 0;
		}

	}

	@Override
	public void d(class_yu var1) {
		if (!o.D && a && (d <= 0)) {
			boolean var2 = (c == 1) || ((c == 2) && var1.bI.d);
			if ((c == 1) && !var1.bq.a(this.i())) {
				var2 = false;
			}

			if (var2) {
				this.a("random.pop", 0.2F, (((V.nextFloat() - V.nextFloat()) * 0.7F) + 1.0F) * 2.0F);
				var1.a(this, 1);
				L();
			}

		}
	}

	protected class_aco i() {
		return new class_aco(Items.g);
	}

	@Override
	protected boolean U() {
		return false;
	}

	public void b(double var1) {
		ax = var1;
	}

	public double j() {
		return ax;
	}

	public void a(int var1) {
		ay = var1;
	}

	@Override
	public boolean aJ() {
		return false;
	}

	@Override
	public float aY() {
		return 0.0F;
	}

	public void a(boolean var1) {
		byte var2 = ((Byte) ac.a(g)).byteValue();
		if (var1) {
			ac.b(g, Byte.valueOf((byte) (var2 | 1)));
		} else {
			ac.b(g, Byte.valueOf((byte) (var2 & -2)));
		}

	}

	public boolean k() {
		byte var1 = ((Byte) ac.a(g)).byteValue();
		return (var1 & 1) != 0;
	}

	static {
		f = Predicates.and(new Predicate[] { class_rb.d, class_rb.a, new Predicate() {
			public boolean a(Entity var1) {
				return var1.ag();
			}

			// $FF: synthetic method
			@Override
			public boolean apply(Object var1) {
				return this.a((Entity) var1);
			}
		} });
		g = class_kc.a(class_yx.class, class_kb.a);
	}
}
