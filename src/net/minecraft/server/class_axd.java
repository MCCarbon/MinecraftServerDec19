package net.minecraft.server;


public class class_axd {
	private final class_awy a = new class_awy();
	private final class_axa[] b = new class_axa[32];
	private final class_axb c;

	public class_axd(class_axb var1) {
		c = var1;
	}

	public class_axc a(class_ags var1, class_qx var2, class_qx var3, float var4) {
		return this.a(var1, var2, var3.s, var3.aX().b, var3.u, var4);
	}

	public class_axc a(class_ags var1, class_qx var2, class_cj var3, float var4) {
		return this.a(var1, var2, var3.n() + 0.5F, var3.o() + 0.5F, var3.p() + 0.5F, var4);
	}

	private class_axc a(class_ags var1, class_qx var2, double var3, double var5, double var7, float var9) {
		a.a();
		c.a(var1, var2);
		class_axa var10 = c.b();
		class_axa var11 = c.a(var3, var5, var7);
		class_axc var12 = this.a(var10, var11, var9);
		c.a();
		return var12;
	}

	private class_axc a(class_axa var1, class_axa var2, float var3) {
		var1.e = 0.0F;
		var1.f = var1.b(var2);
		var1.g = var1.f;
		a.a();
		a.a(var1);
		class_axa var4 = var1;
		int var5 = 0;

		while (!a.e()) {
			++var5;
			if (var5 >= 200) {
				break;
			}

			class_axa var6 = a.c();
			if (var6.equals(var2)) {
				return this.a(var1, var2);
			}

			if (var6.b(var2) < var4.b(var2)) {
				var4 = var6;
			}

			var6.i = true;
			int var7 = c.a(b, var6, var2, var3);

			for (int var8 = 0; var8 < var7; ++var8) {
				class_axa var9 = b[var8];
				float var10 = var6.e + var6.b(var9);
				if ((var10 < (var3 * 2.0F)) && (!var9.a() || (var10 < var9.e))) {
					var9.h = var6;
					var9.e = var10;
					var9.f = var9.b(var2);
					if (var9.a()) {
						a.a(var9, var9.e + var9.f);
					} else {
						var9.g = var9.e + var9.f;
						a.a(var9);
					}
				}
			}
		}

		return var4 == var1 ? null : this.a(var1, var4);
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
}
