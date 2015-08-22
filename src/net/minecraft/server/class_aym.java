package net.minecraft.server;


public class class_aym {
	public final double a;
	public final double b;
	public final double c;

	public class_aym(double var1, double var3, double var5) {
		if (var1 == -0.0D) {
			var1 = 0.0D;
		}

		if (var3 == -0.0D) {
			var3 = 0.0D;
		}

		if (var5 == -0.0D) {
			var5 = 0.0D;
		}

		a = var1;
		b = var3;
		c = var5;
	}

	public class_aym(class_df var1) {
		this(var1.n(), var1.o(), var1.p());
	}

	public class_aym a(class_aym var1) {
		return new class_aym(var1.a - a, var1.b - b, var1.c - c);
	}

	public class_aym a() {
		double var1 = class_oa.a((a * a) + (b * b) + (c * c));
		return var1 < 1.0E-4D ? new class_aym(0.0D, 0.0D, 0.0D) : new class_aym(a / var1, b / var1, c / var1);
	}

	public double b(class_aym var1) {
		return (a * var1.a) + (b * var1.b) + (c * var1.c);
	}

	public class_aym d(class_aym var1) {
		return this.a(var1.a, var1.b, var1.c);
	}

	public class_aym a(double var1, double var3, double var5) {
		return this.b(-var1, -var3, -var5);
	}

	public class_aym e(class_aym var1) {
		return this.b(var1.a, var1.b, var1.c);
	}

	public class_aym b(double var1, double var3, double var5) {
		return new class_aym(a + var1, b + var3, c + var5);
	}

	public double g(class_aym var1) {
		double var2 = var1.a - a;
		double var4 = var1.b - b;
		double var6 = var1.c - c;
		return (var2 * var2) + (var4 * var4) + (var6 * var6);
	}

	public double c(double var1, double var3, double var5) {
		double var7 = var1 - a;
		double var9 = var3 - b;
		double var11 = var5 - c;
		return (var7 * var7) + (var9 * var9) + (var11 * var11);
	}

	public class_aym a(double var1) {
		return new class_aym(a * var1, b * var1, c * var1);
	}

	public double b() {
		return class_oa.a((a * a) + (b * b) + (c * c));
	}

	public class_aym a(class_aym var1, double var2) {
		double var4 = var1.a - a;
		double var6 = var1.b - b;
		double var8 = var1.c - c;
		if ((var4 * var4) < 1.0000000116860974E-7D) {
			return null;
		} else {
			double var10 = (var2 - a) / var4;
			return (var10 >= 0.0D) && (var10 <= 1.0D) ? new class_aym(a + (var4 * var10), b + (var6 * var10), c + (var8 * var10)) : null;
		}
	}

	public class_aym b(class_aym var1, double var2) {
		double var4 = var1.a - a;
		double var6 = var1.b - b;
		double var8 = var1.c - c;
		if ((var6 * var6) < 1.0000000116860974E-7D) {
			return null;
		} else {
			double var10 = (var2 - b) / var6;
			return (var10 >= 0.0D) && (var10 <= 1.0D) ? new class_aym(a + (var4 * var10), b + (var6 * var10), c + (var8 * var10)) : null;
		}
	}

	public class_aym c(class_aym var1, double var2) {
		double var4 = var1.a - a;
		double var6 = var1.b - b;
		double var8 = var1.c - c;
		if ((var8 * var8) < 1.0000000116860974E-7D) {
			return null;
		} else {
			double var10 = (var2 - c) / var8;
			return (var10 >= 0.0D) && (var10 <= 1.0D) ? new class_aym(a + (var4 * var10), b + (var6 * var10), c + (var8 * var10)) : null;
		}
	}

	@Override
	public String toString() {
		return "(" + a + ", " + b + ", " + c + ")";
	}

	public class_aym a(float var1) {
		float var2 = class_oa.b(var1);
		float var3 = class_oa.a(var1);
		double var4 = a;
		double var6 = (b * var2) + (c * var3);
		double var8 = (c * var2) - (b * var3);
		return new class_aym(var4, var6, var8);
	}

	public class_aym b(float var1) {
		float var2 = class_oa.b(var1);
		float var3 = class_oa.a(var1);
		double var4 = (a * var2) + (c * var3);
		double var6 = b;
		double var8 = (c * var2) - (a * var3);
		return new class_aym(var4, var6, var8);
	}
}
