package net.minecraft.server;


public class class_sk extends class_sr {
	private final EntityInsentient a;
	private final float b;
	private float c;
	private boolean d;
	private int e;
	private int f;

	public class_sk(EntityInsentient var1, float var2) {
		a = var1;
		b = var2;
		this.a(7);
	}

	@Override
	public void c() {
		c = 0.0F;
	}

	@Override
	public void d() {
		d = false;
		c = 0.0F;
	}

	@Override
	public boolean a() {
		return a.al() && (a.l != null) && (a.l instanceof class_yu) && (d || a.co());
	}

	@Override
	public void e() {
		class_yu var1 = (class_yu) a.l;
		EntityCreature var2 = (EntityCreature) a;
		float var3 = MathHelper.g(var1.y - a.y) * 0.5F;
		if (var3 > 5.0F) {
			var3 = 5.0F;
		}

		if (var3 < -5.0F) {
			var3 = -5.0F;
		}

		a.y = MathHelper.g(a.y + var3);
		if (c < b) {
			c += (b - c) * 0.01F;
		}

		if (c > b) {
			c = b;
		}

		int var4 = MathHelper.c(a.s);
		int var5 = MathHelper.c(a.t);
		int var6 = MathHelper.c(a.u);
		float var7 = c;
		if (d) {
			if (e++ > f) {
				d = false;
			}

			var7 += var7 * 1.15F * MathHelper.a(((float) e / (float) f) * 3.1415927F);
		}

		float var8 = 0.91F;
		if (a.C) {
			var8 = a.o.p(new class_cj(MathHelper.d((float) var4), MathHelper.d((float) var5) - 1, MathHelper.d((float) var6))).c().L * 0.91F;
		}

		float var9 = 0.16277136F / (var8 * var8 * var8);
		float var10 = MathHelper.a((var2.y * 3.1415927F) / 180.0F);
		float var11 = MathHelper.b((var2.y * 3.1415927F) / 180.0F);
		float var12 = var2.bP() * var9;
		float var13 = Math.max(var7, 1.0F);
		var13 = var12 / var13;
		float var14 = var7 * var13;
		float var15 = -(var14 * var10);
		float var16 = var14 * var11;
		if (MathHelper.e(var15) > MathHelper.e(var16)) {
			if (var15 < 0.0F) {
				var15 -= a.J / 2.0F;
			}

			if (var15 > 0.0F) {
				var15 += a.J / 2.0F;
			}

			var16 = 0.0F;
		} else {
			var15 = 0.0F;
			if (var16 < 0.0F) {
				var16 -= a.J / 2.0F;
			}

			if (var16 > 0.0F) {
				var16 += a.J / 2.0F;
			}
		}

		int var17 = MathHelper.c(a.s + var15);
		int var18 = MathHelper.c(a.u + var16);
		int var19 = MathHelper.d(a.J + 1.0F);
		int var20 = MathHelper.d(a.K + var1.K + 1.0F);
		int var21 = MathHelper.d(a.J + 1.0F);
		if ((var4 != var17) || (var6 != var18)) {
			Block var22 = a.o.p(new class_cj(var4, var5, var6)).c();
			boolean var23 = !this.a(var22) && ((var22.v() != class_avq.a) || !this.a(a.o.p(new class_cj(var4, var5 - 1, var6)).c()));
			if (var23 && (class_awz.e == class_axf.a(a.o, a, var17, var5, var18, var19, var20, var21, false, false, true)) && (class_awz.f == class_axf.a(a.o, a, var4, var5 + 1, var6, var19, var20, var21, false, false, true)) && (class_awz.f == class_axf.a(a.o, a, var17, var5 + 1, var18, var19, var20, var21, false, false, true))) {
				var2.s().a();
			}
		}

		if (!var1.bI.d && (c >= (b * 0.5F)) && (a.bj().nextFloat() < 0.006F) && !d) {
			class_pu var25 = this.a(var1);
			if (var25 != null) {
				class_aco var26 = var1.b(var25);
				if ((var26 != null) && (var26.b() == Items.cd)) {
					var26.a(1, var1);
					if (var26.b == 0) {
						class_aco var24 = new class_aco(Items.aT);
						var24.d(var26.o());
						var1.a(var25, var24);
					}
				}
			}
		}

		a.g(0.0F, var7);
	}

	protected class_pu a(class_yu var1) {
		class_pu[] var2 = class_pu.values();
		int var3 = var2.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			class_pu var5 = var2[var4];
			class_aco var6 = var1.b(var5);
			if ((var6 != null) && (var6.b() == Items.cd)) {
				return var5;
			}
		}

		return null;
	}

	private boolean a(Block var1) {
		return (var1 instanceof class_anf) || (var1 instanceof BlockStepAbstract);
	}

	public boolean f() {
		return d;
	}

	public void g() {
		d = true;
		e = 0;
		f = a.bj().nextInt(841) + 140;
	}

	public boolean h() {
		return !f() && (c > (b * 0.3F));
	}
}
