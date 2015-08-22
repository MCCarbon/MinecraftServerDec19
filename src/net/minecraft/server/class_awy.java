package net.minecraft.server;


public class class_awy {
	private class_axa[] a = new class_axa[128];
	private int b;

	public class_axa a(class_axa var1) {
		if (var1.d >= 0) {
			throw new IllegalStateException("OW KNOWS!");
		} else {
			if (b == a.length) {
				class_axa[] var2 = new class_axa[b << 1];
				System.arraycopy(a, 0, var2, 0, b);
				a = var2;
			}

			a[b] = var1;
			var1.d = b;
			this.a(b++);
			return var1;
		}
	}

	public void a() {
		b = 0;
	}

	public class_axa c() {
		class_axa var1 = a[0];
		a[0] = a[--b];
		a[b] = null;
		if (b > 0) {
			b(0);
		}

		var1.d = -1;
		return var1;
	}

	public void a(class_axa var1, float var2) {
		float var3 = var1.g;
		var1.g = var2;
		if (var2 < var3) {
			this.a(var1.d);
		} else {
			b(var1.d);
		}

	}

	private void a(int var1) {
		class_axa var2 = a[var1];

		int var4;
		for (float var3 = var2.g; var1 > 0; var1 = var4) {
			var4 = (var1 - 1) >> 1;
				class_axa var5 = a[var4];
				if (var3 >= var5.g) {
					break;
				}

				a[var1] = var5;
				var5.d = var1;
		}

		a[var1] = var2;
		var2.d = var1;
	}

	private void b(int var1) {
		class_axa var2 = a[var1];
		float var3 = var2.g;

		while (true) {
			int var4 = 1 + (var1 << 1);
			int var5 = var4 + 1;
			if (var4 >= b) {
				break;
			}

			class_axa var6 = a[var4];
			float var7 = var6.g;
			class_axa var8;
			float var9;
			if (var5 >= b) {
				var8 = null;
				var9 = Float.POSITIVE_INFINITY;
			} else {
				var8 = a[var5];
				var9 = var8.g;
			}

			if (var7 < var9) {
				if (var7 >= var3) {
					break;
				}

				a[var1] = var6;
				var6.d = var1;
				var1 = var4;
			} else {
				if (var9 >= var3) {
					break;
				}

				a[var1] = var8;
				var8.d = var1;
				var1 = var5;
			}
		}

		a[var1] = var2;
		var2.d = var1;
	}

	public boolean e() {
		return b == 0;
	}
}
