package net.minecraft.server;

import java.util.Random;

public class class_atb extends class_atc {
	private static final class_apn e;
	private static final class_apn f;
	private static final class_apn g;
	private boolean h;

	public class_atb(boolean var1, boolean var2) {
		super(var1, 13, 15, e, f);
		h = var2;
	}

	@Override
	public boolean b(class_ago var1, Random var2, class_cj var3) {
		int var4 = this.a(var2);
		if (!this.a(var1, var2, var3, var4)) {
			return false;
		} else {
			this.a(var1, var3.n(), var3.p(), var3.o() + var4, 0, var2);

			for (int var5 = 0; var5 < var4; ++var5) {
				Block var6 = var1.p(var3.b(var5)).c();
				if ((var6.v() == class_avq.a) || (var6.v() == class_avq.j)) {
					this.a(var1, var3.b(var5), b);
				}

				if (var5 < (var4 - 1)) {
					var6 = var1.p(var3.a(1, var5, 0)).c();
					if ((var6.v() == class_avq.a) || (var6.v() == class_avq.j)) {
						this.a(var1, var3.a(1, var5, 0), b);
					}

					var6 = var1.p(var3.a(1, var5, 1)).c();
					if ((var6.v() == class_avq.a) || (var6.v() == class_avq.j)) {
						this.a(var1, var3.a(1, var5, 1), b);
					}

					var6 = var1.p(var3.a(0, var5, 1)).c();
					if ((var6.v() == class_avq.a) || (var6.v() == class_avq.j)) {
						this.a(var1, var3.a(0, var5, 1), b);
					}
				}
			}

			return true;
		}
	}

	private void a(class_ago var1, int var2, int var3, int var4, int var5, Random var6) {
		int var7 = var6.nextInt(5) + (h ? a : 3);
		int var8 = 0;

		for (int var9 = var4 - var7; var9 <= var4; ++var9) {
			int var10 = var4 - var9;
			int var11 = var5 + MathHelper.d(((float) var10 / (float) var7) * 3.5F);
			this.a(var1, new class_cj(var2, var9, var3), var11 + ((var10 > 0) && (var11 == var8) && ((var9 & 1) == 0) ? 1 : 0));
			var8 = var11;
		}

	}

	@Override
	public void a(class_ago var1, Random var2, class_cj var3) {
		this.b(var1, var3.e().c());
		this.b(var1, var3.g(2).c());
		this.b(var1, var3.e().e(2));
		this.b(var1, var3.g(2).e(2));

		for (int var4 = 0; var4 < 5; ++var4) {
			int var5 = var2.nextInt(64);
			int var6 = var5 % 8;
			int var7 = var5 / 8;
			if ((var6 == 0) || (var6 == 7) || (var7 == 0) || (var7 == 7)) {
				this.b(var1, var3.a(-3 + var6, 0, -3 + var7));
			}
		}

	}

	private void b(class_ago var1, class_cj var2) {
		for (int var3 = -2; var3 <= 2; ++var3) {
			for (int var4 = -2; var4 <= 2; ++var4) {
				if ((Math.abs(var3) != 2) || (Math.abs(var4) != 2)) {
					c(var1, var2.a(var3, 0, var4));
				}
			}
		}

	}

	private void c(class_ago var1, class_cj var2) {
		for (int var3 = 2; var3 >= -3; --var3) {
			class_cj var4 = var2.b(var3);
			Block var5 = var1.p(var4).c();
			if ((var5 == Blocks.GRASS) || (var5 == Blocks.DIRT)) {
				this.a(var1, var4, g);
				break;
			}

			if ((var5.v() != class_avq.a) && (var3 < 0)) {
				break;
			}
		}

	}

	static {
		e = Blocks.LOG.getBlockData().a(class_alv.b, class_aly.class_a_in_class_aly.b);
		f = Blocks.LEAVES.getBlockData().a(class_alu.P, class_aly.class_a_in_class_aly.b).a(class_alc.b, Boolean.valueOf(false));
		g = Blocks.DIRT.getBlockData().a(class_ajl.a, class_ajl.class_a_in_class_ajl.c);
	}
}
