package net.minecraft.server;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;

public class class_asb extends class_asa {
	private Random k;
	private class_ago l;
	private class_cj m;
	int a;
	int b;
	double c;
	double d;
	double e;
	double f;
	int g;
	int h;
	int i;
	List j;

	public class_asb(boolean var1) {
		super(var1);
		m = class_cj.a;
		c = 0.618D;
		d = 0.381D;
		e = 1.0D;
		f = 1.0D;
		g = 1;
		h = 12;
		i = 4;
	}

	void a() {
		b = (int) (a * c);
		if (b >= a) {
			b = a - 1;
		}

		int var1 = (int) (1.382D + Math.pow((f * a) / 13.0D, 2.0D));
		if (var1 < 1) {
			var1 = 1;
		}

		int var2 = m.o() + b;
		int var3 = a - i;
		j = Lists.newArrayList();
		j.add(new class_asb.class_a_in_class_asb(m.b(var3), var2));

		for (; var3 >= 0; --var3) {
			float var4 = this.a(var3);
			if (var4 >= 0.0F) {
				for (int var5 = 0; var5 < var1; ++var5) {
					double var6 = e * var4 * (k.nextFloat() + 0.328D);
					double var8 = k.nextFloat() * 2.0F * 3.141592653589793D;
					double var10 = (var6 * Math.sin(var8)) + 0.5D;
					double var12 = (var6 * Math.cos(var8)) + 0.5D;
					class_cj var14 = m.a(var10, var3 - 1, var12);
					class_cj var15 = var14.b(i);
					if (this.a(var14, var15) == -1) {
						int var16 = m.n() - var14.n();
						int var17 = m.p() - var14.p();
						double var18 = var14.o() - (Math.sqrt((var16 * var16) + (var17 * var17)) * d);
						int var20 = var18 > var2 ? var2 : (int) var18;
						class_cj var21 = new class_cj(m.n(), var20, m.p());
						if (this.a(var21, var14) == -1) {
							j.add(new class_asb.class_a_in_class_asb(var14, var21.o()));
						}
					}
				}
			}
		}

	}

	void a(class_cj var1, float var2, class_apn var3) {
		int var4 = (int) (var2 + 0.618D);

		for (int var5 = -var4; var5 <= var4; ++var5) {
			for (int var6 = -var4; var6 <= var4; ++var6) {
				if ((Math.pow(Math.abs(var5) + 0.5D, 2.0D) + Math.pow(Math.abs(var6) + 0.5D, 2.0D)) <= var2 * var2) {
					class_cj var7 = var1.a(var5, 0, var6);
					class_avq var8 = l.p(var7).c().v();
					if ((var8 == class_avq.a) || (var8 == class_avq.j)) {
						this.a(l, var7, var3);
					}
				}
			}
		}

	}

	float a(int var1) {
		if (var1 < (a * 0.3F)) {
			return -1.0F;
		} else {
			float var2 = a / 2.0F;
			float var3 = var2 - var1;
			float var4 = class_oa.c((var2 * var2) - (var3 * var3));
			if (var3 == 0.0F) {
				var4 = var2;
			} else if (Math.abs(var3) >= var2) {
				return 0.0F;
			}

			return var4 * 0.5F;
		}
	}

	float b(int var1) {
		return (var1 >= 0) && (var1 < i) ? ((var1 != 0) && (var1 != (i - 1)) ? 3.0F : 2.0F) : -1.0F;
	}

	void a(class_cj var1) {
		for (int var2 = 0; var2 < i; ++var2) {
			this.a(var1.b(var2), this.b(var2), Blocks.LEAVES.S().a(class_alc.b, Boolean.valueOf(false)));
		}

	}

	void a(class_cj var1, class_cj var2, Block var3) {
		class_cj var4 = var2.a(-var1.n(), -var1.o(), -var1.p());
		int var5 = this.b(var4);
		float var6 = (float) var4.n() / (float) var5;
		float var7 = (float) var4.o() / (float) var5;
		float var8 = (float) var4.p() / (float) var5;

		for (int var9 = 0; var9 <= var5; ++var9) {
			class_cj var10 = var1.a(0.5F + (var9 * var6), 0.5F + (var9 * var7), 0.5F + (var9 * var8));
			class_alg.class_a_in_class_alg var11 = this.b(var1, var10);
			this.a(l, var10, var3.S().a(class_alg.a, var11));
		}

	}

	private int b(class_cj var1) {
		int var2 = class_oa.a(var1.n());
		int var3 = class_oa.a(var1.o());
		int var4 = class_oa.a(var1.p());
		return (var4 > var2) && (var4 > var3) ? var4 : (var3 > var2 ? var3 : var2);
	}

	private class_alg.class_a_in_class_alg b(class_cj var1, class_cj var2) {
		class_alg.class_a_in_class_alg var3 = class_alg.class_a_in_class_alg.b;
		int var4 = Math.abs(var2.n() - var1.n());
		int var5 = Math.abs(var2.p() - var1.p());
		int var6 = Math.max(var4, var5);
		if (var6 > 0) {
			if (var4 == var6) {
				var3 = class_alg.class_a_in_class_alg.a;
			} else if (var5 == var6) {
				var3 = class_alg.class_a_in_class_alg.c;
			}
		}

		return var3;
	}

	void b() {
		Iterator var1 = j.iterator();

		while (var1.hasNext()) {
			class_asb.class_a_in_class_asb var2 = (class_asb.class_a_in_class_asb) var1.next();
			this.a(var2);
		}

	}

	boolean c(int var1) {
		return var1 >= (a * 0.2D);
	}

	void c() {
		class_cj var1 = m;
		class_cj var2 = m.b(b);
		Block var3 = Blocks.LOG;
		this.a(var1, var2, var3);
		if (g == 2) {
			this.a(var1.f(), var2.f(), var3);
			this.a(var1.f().d(), var2.f().d(), var3);
			this.a(var1.d(), var2.d(), var3);
		}

	}

	void d() {
		Iterator var1 = j.iterator();

		while (var1.hasNext()) {
			class_asb.class_a_in_class_asb var2 = (class_asb.class_a_in_class_asb) var1.next();
			int var3 = var2.q();
			class_cj var4 = new class_cj(m.n(), var3, m.p());
			if (!var4.equals(var2) && this.c(var3 - m.o())) {
				this.a(var4, var2, Blocks.LOG);
			}
		}

	}

	int a(class_cj var1, class_cj var2) {
		class_cj var3 = var2.a(-var1.n(), -var1.o(), -var1.p());
		int var4 = this.b(var3);
		float var5 = (float) var3.n() / (float) var4;
		float var6 = (float) var3.o() / (float) var4;
		float var7 = (float) var3.p() / (float) var4;
		if (var4 == 0) {
			return -1;
		} else {
			for (int var8 = 0; var8 <= var4; ++var8) {
				class_cj var9 = var1.a(0.5F + (var8 * var5), 0.5F + (var8 * var6), 0.5F + (var8 * var7));
				if (!this.a(l.p(var9).c())) {
					return var8;
				}
			}

			return -1;
		}
	}

	@Override
	public void e() {
		i = 5;
	}

	@Override
	public boolean b(class_ago var1, Random var2, class_cj var3) {
		l = var1;
		m = var3;
		k = new Random(var2.nextLong());
		if (a == 0) {
			a = 5 + k.nextInt(h);
		}

		if (!f()) {
			return false;
		} else {
			this.a();
			this.b();
			this.c();
			d();
			return true;
		}
	}

	private boolean f() {
		Block var1 = l.p(m.b()).c();
		if ((var1 != Blocks.DIRT) && (var1 != Blocks.GRASS) && (var1 != Blocks.ak)) {
			return false;
		} else {
			int var2 = this.a(m, m.b(a - 1));
			if (var2 == -1) {
				return true;
			} else if (var2 < 6) {
				return false;
			} else {
				a = var2;
				return true;
			}
		}
	}

	static class class_a_in_class_asb extends class_cj {
		private final int c;

		public class_a_in_class_asb(class_cj var1, int var2) {
			super(var1.n(), var1.o(), var1.p());
			c = var2;
		}

		public int q() {
			return c;
		}
	}
}
