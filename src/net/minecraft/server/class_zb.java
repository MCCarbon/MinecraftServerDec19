package net.minecraft.server;

import com.google.common.base.Optional;

public class class_zb extends Entity {
	private static final class_jz a;
	private int b;
	private int c;

	public class_zb(class_ago var1) {
		super(var1);
		this.a(0.25F, 0.25F);
	}

	@Override
	protected void h() {
		ac.a(a, Optional.absent());
	}

	public class_zb(class_ago var1, double var2, double var4, double var6, class_aco var8) {
		super(var1);
		b = 0;
		this.a(0.25F, 0.25F);
		this.b(var2, var4, var6);
		int var9 = 1;
		if ((var8 != null) && var8.n()) {
			ac.b(a, Optional.of(var8));
			class_dn var10 = var8.o();
			class_dn var11 = var10.o("Fireworks");
			var9 += var11.f("Flight");
		}

		v = V.nextGaussian() * 0.001D;
		x = V.nextGaussian() * 0.001D;
		w = 0.05D;
		c = (10 * var9) + V.nextInt(6) + V.nextInt(7);
	}

	@Override
	public void r_() {
		P = s;
		Q = t;
		R = u;
		super.r_();
		v *= 1.15D;
		x *= 1.15D;
		w += 0.04D;
		this.d(v, w, x);
		float var1 = MathHelper.a((v * v) + (x * x));
		y = (float) ((MathHelper.b(v, x) * 180.0D) / 3.1415927410125732D);

		for (z = (float) ((MathHelper.b(w, var1) * 180.0D) / 3.1415927410125732D); (z - B) < -180.0F; B -= 360.0F) {
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
		if ((b == 0) && !T()) {
			o.a(this, "fireworks.launch", 3.0F, 1.0F);
		}

		++b;
		if (o.D && ((b % 2) < 2)) {
			o.a(class_cy.d, s, t - 0.3D, u, V.nextGaussian() * 0.05D, -w * 0.5D, V.nextGaussian() * 0.05D, new int[0]);
		}

		if (!o.D && (b > c)) {
			o.a(this, (byte) 17);
			L();
		}

	}

	@Override
	public void b(class_dn var1) {
		var1.a("Life", b);
		var1.a("LifeTime", c);
		class_aco var2 = (class_aco) ((Optional) ac.a(a)).orNull();
		if (var2 != null) {
			class_dn var3 = new class_dn();
			var2.b(var3);
			var1.a("FireworksItem", var3);
		}

	}

	@Override
	public void a(class_dn var1) {
		b = var1.h("Life");
		c = var1.h("LifeTime");
		class_dn var2 = var1.o("FireworksItem");
		if (var2 != null) {
			class_aco var3 = class_aco.a(var2);
			if (var3 != null) {
				ac.b(a, Optional.of(var3));
			}
		}

	}

	@Override
	public float f(float var1) {
		return super.f(var1);
	}

	@Override
	public boolean aJ() {
		return false;
	}

	static {
		a = class_kc.a(class_zb.class, class_kb.f);
	}
}
