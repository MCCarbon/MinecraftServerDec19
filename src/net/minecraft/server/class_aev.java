package net.minecraft.server;


public class class_aev implements class_aes {
	private final int a;
	private final int b;
	private final class_aco[] c;
	private final class_aco d;
	private boolean e;

	public class_aev(int var1, int var2, class_aco[] var3, class_aco var4) {
		a = var1;
		b = var2;
		c = var3;
		d = var4;
	}

	@Override
	public class_aco b() {
		return d;
	}

	@Override
	public class_aco[] b(class_aab var1) {
		class_aco[] var2 = new class_aco[var1.n_()];

		for (int var3 = 0; var3 < var2.length; ++var3) {
			class_aco var4 = var1.a(var3);
			if ((var4 != null) && var4.b().r()) {
				var2[var3] = new class_aco(var4.b().q());
			}
		}

		return var2;
	}

	@Override
	public boolean a(class_aab var1, class_ago var2) {
		for (int var3 = 0; var3 <= (3 - a); ++var3) {
			for (int var4 = 0; var4 <= (3 - b); ++var4) {
				if (this.a(var1, var3, var4, true)) {
					return true;
				}

				if (this.a(var1, var3, var4, false)) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean a(class_aab var1, int var2, int var3, boolean var4) {
		for (int var5 = 0; var5 < 3; ++var5) {
			for (int var6 = 0; var6 < 3; ++var6) {
				int var7 = var5 - var2;
				int var8 = var6 - var3;
				class_aco var9 = null;
				if ((var7 >= 0) && (var8 >= 0) && (var7 < a) && (var8 < b)) {
					if (var4) {
						var9 = c[(a - var7 - 1) + (var8 * a)];
					} else {
						var9 = c[var7 + (var8 * a)];
					}
				}

				class_aco var10 = var1.c(var5, var6);
				if ((var10 != null) || (var9 != null)) {
					if (((var10 == null) && (var9 != null)) || ((var10 != null) && (var9 == null))) {
						return false;
					}

					if (var9.b() != var10.b()) {
						return false;
					}

					if ((var9.i() != 32767) && (var9.i() != var10.i())) {
						return false;
					}
				}
			}
		}

		return true;
	}

	@Override
	public class_aco a(class_aab var1) {
		class_aco var2 = this.b().k();
		if (e) {
			for (int var3 = 0; var3 < var1.n_(); ++var3) {
				class_aco var4 = var1.a(var3);
				if ((var4 != null) && var4.n()) {
					var2.d((class_dn) var4.o().b());
				}
			}
		}

		return var2;
	}

	@Override
	public int a() {
		return a * b;
	}
}
