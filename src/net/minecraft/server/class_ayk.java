package net.minecraft.server;


public class class_ayk {
	public final double a;
	public final double b;
	public final double c;
	public final double d;
	public final double e;
	public final double f;

	public class_ayk(double var1, double var3, double var5, double var7, double var9, double var11) {
		a = Math.min(var1, var7);
		b = Math.min(var3, var9);
		c = Math.min(var5, var11);
		d = Math.max(var1, var7);
		e = Math.max(var3, var9);
		f = Math.max(var5, var11);
	}

	public class_ayk(class_cj var1) {
		a = var1.n();
		b = var1.o();
		c = var1.p();
		d = var1.n() + 1;
		e = var1.o() + 1;
		f = var1.p() + 1;
	}

	public class_ayk(class_cj var1, class_cj var2) {
		a = var1.n();
		b = var1.o();
		c = var1.p();
		d = var2.n();
		e = var2.o();
		f = var2.p();
	}

	public class_ayk a(double var1, double var3, double var5) {
		double var7 = a;
		double var9 = b;
		double var11 = c;
		double var13 = d;
		double var15 = e;
		double var17 = f;
		if (var1 < 0.0D) {
			var7 += var1;
		} else if (var1 > 0.0D) {
			var13 += var1;
		}

		if (var3 < 0.0D) {
			var9 += var3;
		} else if (var3 > 0.0D) {
			var15 += var3;
		}

		if (var5 < 0.0D) {
			var11 += var5;
		} else if (var5 > 0.0D) {
			var17 += var5;
		}

		return new class_ayk(var7, var9, var11, var13, var15, var17);
	}

	public class_ayk b(double var1, double var3, double var5) {
		double var7 = a - var1;
		double var9 = b - var3;
		double var11 = c - var5;
		double var13 = d + var1;
		double var15 = e + var3;
		double var17 = f + var5;
		return new class_ayk(var7, var9, var11, var13, var15, var17);
	}

	public class_ayk a(class_ayk var1) {
		double var2 = Math.min(a, var1.a);
		double var4 = Math.min(b, var1.b);
		double var6 = Math.min(c, var1.c);
		double var8 = Math.max(d, var1.d);
		double var10 = Math.max(e, var1.e);
		double var12 = Math.max(f, var1.f);
		return new class_ayk(var2, var4, var6, var8, var10, var12);
	}

	public static class_ayk a(double var0, double var2, double var4, double var6, double var8, double var10) {
		double var12 = Math.min(var0, var6);
		double var14 = Math.min(var2, var8);
		double var16 = Math.min(var4, var10);
		double var18 = Math.max(var0, var6);
		double var20 = Math.max(var2, var8);
		double var22 = Math.max(var4, var10);
		return new class_ayk(var12, var14, var16, var18, var20, var22);
	}

	public class_ayk c(double var1, double var3, double var5) {
		return new class_ayk(a + var1, b + var3, c + var5, d + var1, e + var3, f + var5);
	}

	public double a(class_ayk var1, double var2) {
		if ((var1.e > b) && (var1.b < e) && (var1.f > c) && (var1.c < f)) {
			double var4;
			if ((var2 > 0.0D) && (var1.d <= a)) {
				var4 = a - var1.d;
				if (var4 < var2) {
					var2 = var4;
				}
			} else if ((var2 < 0.0D) && (var1.a >= d)) {
				var4 = d - var1.a;
				if (var4 > var2) {
					var2 = var4;
				}
			}

			return var2;
		} else {
			return var2;
		}
	}

	public double b(class_ayk var1, double var2) {
		if ((var1.d > a) && (var1.a < d) && (var1.f > c) && (var1.c < f)) {
			double var4;
			if ((var2 > 0.0D) && (var1.e <= b)) {
				var4 = b - var1.e;
				if (var4 < var2) {
					var2 = var4;
				}
			} else if ((var2 < 0.0D) && (var1.b >= e)) {
				var4 = e - var1.b;
				if (var4 > var2) {
					var2 = var4;
				}
			}

			return var2;
		} else {
			return var2;
		}
	}

	public double c(class_ayk var1, double var2) {
		if ((var1.d > a) && (var1.a < d) && (var1.e > b) && (var1.b < e)) {
			double var4;
			if ((var2 > 0.0D) && (var1.f <= c)) {
				var4 = c - var1.f;
				if (var4 < var2) {
					var2 = var4;
				}
			} else if ((var2 < 0.0D) && (var1.c >= f)) {
				var4 = f - var1.c;
				if (var4 > var2) {
					var2 = var4;
				}
			}

			return var2;
		} else {
			return var2;
		}
	}

	public boolean b(class_ayk var1) {
		return (var1.d > a) && (var1.a < d) ? ((var1.e > b) && (var1.b < e) ? (var1.f > c) && (var1.c < f) : false) : false;
	}

	public boolean a(class_aym var1) {
		return (var1.a > a) && (var1.a < d) ? ((var1.b > b) && (var1.b < e) ? (var1.c > c) && (var1.c < f) : false) : false;
	}

	public double a() {
		double var1 = d - a;
		double var3 = e - b;
		double var5 = f - c;
		return (var1 + var3 + var5) / 3.0D;
	}

	public class_ayk d(double var1, double var3, double var5) {
		double var7 = a + var1;
		double var9 = b + var3;
		double var11 = c + var5;
		double var13 = d - var1;
		double var15 = e - var3;
		double var17 = f - var5;
		return new class_ayk(var7, var9, var11, var13, var15, var17);
	}

	public class_ayl a(class_aym var1, class_aym var2) {
		class_aym var3 = var1.a(var2, a);
		class_aym var4 = var1.a(var2, d);
		class_aym var5 = var1.b(var2, b);
		class_aym var6 = var1.b(var2, e);
		class_aym var7 = var1.c(var2, c);
		class_aym var8 = var1.c(var2, f);
		if (!this.b(var3)) {
			var3 = null;
		}

		if (!this.b(var4)) {
			var4 = null;
		}

		if (!this.c(var5)) {
			var5 = null;
		}

		if (!this.c(var6)) {
			var6 = null;
		}

		if (!this.d(var7)) {
			var7 = null;
		}

		if (!this.d(var8)) {
			var8 = null;
		}

		class_aym var9 = null;
		if (var3 != null) {
			var9 = var3;
		}

		if ((var4 != null) && ((var9 == null) || (var1.g(var4) < var1.g(var9)))) {
			var9 = var4;
		}

		if ((var5 != null) && ((var9 == null) || (var1.g(var5) < var1.g(var9)))) {
			var9 = var5;
		}

		if ((var6 != null) && ((var9 == null) || (var1.g(var6) < var1.g(var9)))) {
			var9 = var6;
		}

		if ((var7 != null) && ((var9 == null) || (var1.g(var7) < var1.g(var9)))) {
			var9 = var7;
		}

		if ((var8 != null) && ((var9 == null) || (var1.g(var8) < var1.g(var9)))) {
			var9 = var8;
		}

		if (var9 == null) {
			return null;
		} else {
			class_cq var10 = null;
			if (var9 == var3) {
				var10 = class_cq.e;
			} else if (var9 == var4) {
				var10 = class_cq.f;
			} else if (var9 == var5) {
				var10 = class_cq.a;
			} else if (var9 == var6) {
				var10 = class_cq.b;
			} else if (var9 == var7) {
				var10 = class_cq.c;
			} else {
				var10 = class_cq.d;
			}

			return new class_ayl(var9, var10);
		}
	}

	private boolean b(class_aym var1) {
		return var1 == null ? false : (var1.b >= b) && (var1.b <= e) && (var1.c >= c) && (var1.c <= f);
	}

	private boolean c(class_aym var1) {
		return var1 == null ? false : (var1.a >= a) && (var1.a <= d) && (var1.c >= c) && (var1.c <= f);
	}

	private boolean d(class_aym var1) {
		return var1 == null ? false : (var1.a >= a) && (var1.a <= d) && (var1.b >= b) && (var1.b <= e);
	}

	@Override
	public String toString() {
		return "box[" + a + ", " + b + ", " + c + " -> " + d + ", " + e + ", " + f + "]";
	}
}
