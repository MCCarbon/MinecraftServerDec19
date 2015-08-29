package net.minecraft.server;

import java.util.List;
import java.util.UUID;

public abstract class class_zj extends Entity implements class_zd {
	private int d;
	private int e;
	private int f;
	private Block g;
	protected boolean a;
	public int b;
	private EntityLiving h;
	private String i;
	private int as;
	private int at;
	public Entity c;
	private int au;

	public class_zj(class_ago var1) {
		super(var1);
		d = -1;
		e = -1;
		f = -1;
		this.a(0.25F, 0.25F);
	}

	public class_zj(class_ago var1, double var2, double var4, double var6) {
		this(var1);
		this.b(var2, var4, var6);
	}

	public class_zj(class_ago var1, EntityLiving var2) {
		this(var1, var2.s, (var2.t + var2.aY()) - 0.10000000149011612D, var2.u);
		h = var2;
	}

	@Override
	protected void h() {
	}

	public void a(float var1, float var2, float var3, float var4, float var5) {
		float var6 = -MathHelper.a(var2 * 0.017453292F) * MathHelper.b(var1 * 0.017453292F);
		float var7 = -MathHelper.a((var1 + var3) * 0.017453292F);
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
		as = 0;
	}

	@Override
	public void r_() {
		P = s;
		Q = t;
		R = u;
		super.r_();
		if (b > 0) {
			--b;
		}

		if (a) {
			if (o.p(new class_cj(d, e, f)).c() == g) {
				++as;
				if (as == 1200) {
					L();
				}

				return;
			}

			a = false;
			v *= V.nextFloat() * 0.2F;
			w *= V.nextFloat() * 0.2F;
			x *= V.nextFloat() * 0.2F;
			as = 0;
			at = 0;
		} else {
			++at;
		}

		class_aym var1 = new class_aym(s, t, u);
		class_aym var2 = new class_aym(s + v, t + w, u + x);
		class_ayl var3 = o.a(var1, var2);
		var1 = new class_aym(s, t, u);
		var2 = new class_aym(s + v, t + w, u + x);
		if (var3 != null) {
			var2 = new class_aym(var3.c.a, var3.c.b, var3.c.c);
		}

		if (!o.D) {
			Entity var4 = null;
			List var5 = o.b(this, aX().a(v, w, x).b(1.0D, 1.0D, 1.0D));
			double var6 = 0.0D;
			boolean var8 = false;

			for (int var9 = 0; var9 < var5.size(); ++var9) {
				Entity var10 = (Entity) var5.get(var9);
				if (var10.ag()) {
					if (var10 == c) {
						var8 = true;
					} else if ((W < 2) && (c == null)) {
						c = var10;
						var8 = true;
					} else {
						var8 = false;
						float var11 = 0.3F;
						class_ayk var12 = var10.aX().b(var11, var11, var11);
						class_ayl var13 = var12.a(var1, var2);
						if (var13 != null) {
							double var14 = var1.g(var13.c);
							if ((var14 < var6) || (var6 == 0.0D)) {
								var4 = var10;
								var6 = var14;
							}
						}
					}
				}
			}

			if (c != null) {
				if (var8) {
					au = 2;
				} else if (au-- <= 0) {
					c = null;
				}
			}

			if (var4 != null) {
				var3 = new class_ayl(var4);
			}
		}

		if (var3 != null) {
			if ((var3.a == class_ayl.class_a_in_class_ayl.b) && (o.p(var3.a()).c() == Blocks.PORTAL)) {
				this.d(var3.a());
			} else {
				this.a(var3);
			}
		}

		s += v;
		t += w;
		u += x;
		float var16 = MathHelper.a((v * v) + (x * x));
		y = (float) ((MathHelper.b(v, x) * 180.0D) / 3.1415927410125732D);

		for (z = (float) ((MathHelper.b(w, var16) * 180.0D) / 3.1415927410125732D); (z - B) < -180.0F; B -= 360.0F) {
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
		float var17 = 0.99F;
		float var18 = this.i();
		if (Y()) {
			for (int var7 = 0; var7 < 4; ++var7) {
				float var19 = 0.25F;
				o.a(class_cy.e, s - (v * var19), t - (w * var19), u - (x * var19), v, w, x, new int[0]);
			}

			var17 = 0.8F;
		}

		v *= var17;
		w *= var17;
		x *= var17;
		w -= var18;
		this.b(s, t, u);
	}

	protected float i() {
		return 0.03F;
	}

	protected abstract void a(class_ayl var1);

	@Override
	public void b(class_dn var1) {
		var1.a("xTile", d);
		var1.a("yTile", e);
		var1.a("zTile", f);
		class_ke var2 = (class_ke) Block.c.b(g);
		var1.a("inTile", var2 == null ? "" : var2.toString());
		var1.a("shake", (byte) b);
		var1.a("inGround", (byte) (a ? 1 : 0));
		if (((i == null) || i.isEmpty()) && (h instanceof class_yu)) {
			i = h.e_();
		}

		var1.a("ownerName", i == null ? "" : i);
	}

	@Override
	public void a(class_dn var1) {
		d = var1.h("xTile");
		e = var1.h("yTile");
		f = var1.h("zTile");
		if (var1.b("inTile", 8)) {
			g = Block.b(var1.l("inTile"));
		} else {
			g = Block.c(var1.f("inTile") & 255);
		}

		b = var1.f("shake") & 255;
		a = var1.f("inGround") == 1;
		h = null;
		i = var1.l("ownerName");
		if ((i != null) && i.isEmpty()) {
			i = null;
		}

		h = this.j();
	}

	public EntityLiving j() {
		if ((h == null) && (i != null) && !i.isEmpty()) {
			h = o.a(i);
			if ((h == null) && (o instanceof class_ll)) {
				try {
					Entity var1 = ((class_ll) o).a(UUID.fromString(i));
					if (var1 instanceof EntityLiving) {
						h = (EntityLiving) var1;
					}
				} catch (Throwable var2) {
					h = null;
				}
			}
		}

		return h;
	}
}
