package net.minecraft.server;


public class class_axe extends class_axb {
	@Override
	public void a(class_ags var1, class_qx var2) {
		super.a(var1, var2);
	}

	@Override
	public void a() {
		super.a();
	}

	@Override
	public class_axa b() {
		return this.a(class_oa.c(b.aX().a), class_oa.c(b.aX().b + 0.5D), class_oa.c(b.aX().c));
	}

	@Override
	public class_axa a(double var1, double var3, double var5) {
		return this.a(class_oa.c(var1 - b.J / 2.0F), class_oa.c(var3 + 0.5D), class_oa.c(var5 - b.J / 2.0F));
	}

	@Override
	public int a(class_axa[] var1, class_axa var2, class_axa var3, float var4) {
		int var5 = 0;
		class_cq[] var6 = class_cq.values();
		int var7 = var6.length;

		for (int var8 = 0; var8 < var7; ++var8) {
			class_cq var9 = var6[var8];
			class_axa var10 = this.b(var2.a + var9.g(), var2.b + var9.h(), var2.c + var9.i());
			if ((var10 != null) && !var10.i && (var10.a(var3) < var4)) {
				var1[var5++] = var10;
			}
		}

		return var5;
	}

	private class_axa b(int var1, int var2, int var3) {
		class_awz var4 = c(var1, var2, var3);
		return var4 == class_awz.d ? this.a(var1, var2, var3) : null;
	}

	private class_awz c(int var1, int var2, int var3) {
		class_cj.class_a_in_class_cj var4 = new class_cj.class_a_in_class_cj();

		for (int var5 = var1; var5 < (var1 + d); ++var5) {
			for (int var6 = var2; var6 < (var2 + e); ++var6) {
				for (int var7 = var3; var7 < (var3 + f); ++var7) {
					class_ail var8 = a.p(var4.c(var5, var6, var7)).c();
					if (var8.v() != class_avq.h) {
						return class_awz.e;
					}
				}
			}
		}

		return class_awz.d;
	}
}
