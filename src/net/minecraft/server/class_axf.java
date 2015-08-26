package net.minecraft.server;


public class class_axf extends class_axb {
	private boolean g;
	private boolean h;
	private boolean i;
	private boolean j;
	private boolean k;

	@Override
	public void a(class_ags var1, Entity var2) {
		super.a(var1, var2);
		k = i;
	}

	@Override
	public void a() {
		super.a();
		i = k;
	}

	@Override
	public class_axa b() {
		int var1;
		if (j && b.Y()) {
			var1 = (int) b.aX().b;
			class_cj.class_a_in_class_cj var2 = new class_cj.class_a_in_class_cj(MathHelper.c(b.s), var1, MathHelper.c(b.u));

			for (Block var3 = a.p(var2).c(); (var3 == Blocks.FLOWING_WATER) || (var3 == Blocks.WATER); var3 = a.p(var2).c()) {
				++var1;
				var2.c(MathHelper.c(b.s), var1, MathHelper.c(b.u));
			}

			i = false;
		} else {
			var1 = MathHelper.c(b.aX().b + 0.5D);
		}

		return this.a(MathHelper.c(b.aX().a), var1, MathHelper.c(b.aX().c));
	}

	@Override
	public class_axa a(double var1, double var3, double var5) {
		return this.a(MathHelper.c(var1 - b.J / 2.0F), MathHelper.c(var3), MathHelper.c(var5 - b.J / 2.0F));
	}

	@Override
	public int a(class_axa[] var1, class_axa var2, class_axa var3, float var4) {
		int var5 = 0;
		byte var6 = 0;
		if (this.a(b, var2.a, var2.b + 1, var2.c) == class_awz.f) {
			var6 = 1;
		}

		class_axa var7 = this.a(var2.a, var2.b, var2.c + 1, var6);
		class_axa var8 = this.a(var2.a - 1, var2.b, var2.c, var6);
		class_axa var9 = this.a(var2.a + 1, var2.b, var2.c, var6);
		class_axa var10 = this.a(var2.a, var2.b, var2.c - 1, var6);
		if ((var7 != null) && !var7.i && (var7.a(var3) < var4)) {
			var1[var5++] = var7;
		}

		if ((var8 != null) && !var8.i && (var8.a(var3) < var4)) {
			var1[var5++] = var8;
		}

		if ((var9 != null) && !var9.i && (var9.a(var3) < var4)) {
			var1[var5++] = var9;
		}

		if ((var10 != null) && !var10.i && (var10.a(var3) < var4)) {
			var1[var5++] = var10;
		}

		return var5;
	}

	private class_axa a(int var1, int var2, int var3, int var4) {
		class_axa var5 = null;
		class_awz var6 = this.a(b, var1, var2, var3);
		if (var6 == class_awz.g) {
			return this.a(var1, var2, var3);
		} else {
			if (var6 == class_awz.f) {
				var5 = this.a(var1, var2, var3);
			}

			if ((var5 == null) && (var4 > 0) && (var6 != class_awz.b) && (var6 != class_awz.a) && (this.a(b, var1, var2 + var4, var3) == class_awz.f)) {
				var5 = this.a(var1, var2 + var4, var3);
				var2 += var4;
			}

			if (var5 != null) {
				int var7 = 0;

				class_awz var8;
				for (var8 = class_awz.e; var2 > 0; var5 = this.a(var1, var2, var3)) {
					var8 = this.a(b, var1, var2 - 1, var3);
					if (i && (var8 == class_awz.d)) {
						return null;
					}

					if (var8 != class_awz.f) {
						break;
					}

					if (var7++ >= b.aK()) {
						return null;
					}

					--var2;
					if (var2 <= 0) {
						return null;
					}
				}

				if (var8 == class_awz.c) {
					return null;
				}
			}

			return var5;
		}
	}

	private class_awz a(Entity var1, int var2, int var3, int var4) {
		return a(a, var1, var2, var3, var4, d, e, f, i, h, g);
	}

	public static class_awz a(class_ags var0, Entity var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, boolean var9, boolean var10) {
		boolean var11 = false;
		class_cj var12 = new class_cj(var1);
		class_cj.class_a_in_class_cj var13 = new class_cj.class_a_in_class_cj();

		for (int var14 = var2; var14 < (var2 + var5); ++var14) {
			for (int var15 = var3; var15 < (var3 + var6); ++var15) {
				for (int var16 = var4; var16 < (var4 + var7); ++var16) {
					var13.c(var14, var15, var16);
					class_apn var17 = var0.p(var13);
					Block var18 = var17.c();
					if (var18.v() != class_avq.a) {
						if ((var18 != Blocks.TRAPDOOR) && (var18 != Blocks.IRON_TRAPDOOR)) {
							if ((var18 != Blocks.FLOWING_WATER) && (var18 != Blocks.WATER)) {
								if (!var10 && (var18 instanceof class_ajn) && (var18.v() == class_avq.d)) {
									return class_awz.e;
								}
							} else {
								if (var8) {
									return class_awz.d;
								}

								var11 = true;
							}
						} else {
							var11 = true;
						}

						if (var18 instanceof class_aih) {
							if (!(var0.p(var12).c() instanceof class_aih) && !(var0.p(var12.b()).c() instanceof class_aih)) {
								return class_awz.b;
							}
						} else if (!var18.b(var0, var13) && (!var9 || !(var18 instanceof class_ajn) || (var18.v() != class_avq.d))) {
							if ((var18 instanceof class_akb) || (var18 instanceof class_akc) || (var18 instanceof class_anx)) {
								return class_awz.b;
							}

							if ((var18 == Blocks.TRAPDOOR) || (var18 == Blocks.IRON_TRAPDOOR)) {
								return class_awz.a;
							}

							class_avq var19 = var18.v();
							if (var19 != class_avq.i) {
								return class_awz.e;
							}

							if (!var1.ae()) {
								return class_awz.c;
							}
						}
					}
				}
			}
		}

		return var11 ? class_awz.g : class_awz.f;
	}

	public void a(boolean var1) {
		g = var1;
	}

	public void b(boolean var1) {
		h = var1;
	}

	public void c(boolean var1) {
		i = var1;
	}

	public void d(boolean var1) {
		j = var1;
	}

	public boolean c() {
		return g;
	}

	public boolean e() {
		return j;
	}

	public boolean f() {
		return i;
	}
}
