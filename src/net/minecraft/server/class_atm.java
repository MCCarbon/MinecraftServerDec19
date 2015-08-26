package net.minecraft.server;

import java.util.Iterator;
import java.util.Random;

public class class_atm extends class_asp {
	private boolean a = true;
	private class_atm.class_a_in_class_atm b = null;

	public void a(class_atm.class_a_in_class_atm var1) {
		b = var1;
	}

	public void a(boolean var1) {
		a = var1;
	}

	@Override
	public boolean b(class_ago var1, Random var2, class_cj var3) {
		if (b == null) {
			throw new IllegalStateException("Decoration requires priming with a spike");
		} else {
			int var4 = b.c();
			Iterator var5 = class_cj.b(new class_cj(var3.n() - var4, 0, var3.p() - var4), new class_cj(var3.n() + var4, b.d() + 10, var3.p() + var4)).iterator();

			while (true) {
				while (var5.hasNext()) {
					class_cj.class_a_in_class_cj var6 = (class_cj.class_a_in_class_cj) var5.next();
					if ((var6.c((double) var3.n(), (double) var6.o(), (double) var3.p()) <= (var4 * var4) + 1) && (var6.o() < b.d())) {
						this.a(var1, var6, Blocks.OBSIDIAN.S());
					} else if (var6.o() > 65) {
						this.a(var1, var6, Blocks.AIR.S());
					}
				}

				if (b.e()) {
					for (int var7 = -2; var7 <= 2; ++var7) {
						for (int var9 = -2; var9 <= 2; ++var9) {
							if ((class_oa.a(var7) == 2) || (class_oa.a(var9) == 2)) {
								this.a(var1, new class_cj(var3.n() + var7, b.d(), var3.p() + var9), Blocks.IRON_BARS.S());
								this.a(var1, new class_cj(var3.n() + var7, b.d() + 1, var3.p() + var9), Blocks.IRON_BARS.S());
								this.a(var1, new class_cj(var3.n() + var7, b.d() + 2, var3.p() + var9), Blocks.IRON_BARS.S());
							}

							this.a(var1, new class_cj(var3.n() + var7, b.d() + 3, var3.p() + var9), Blocks.IRON_BARS.S());
						}
					}
				}

				if (a) {
					class_vw var8 = new class_vw(var1);
					var8.b(var3.n() + 0.5F, b.d() + 1, var3.p() + 0.5F, var2.nextFloat() * 360.0F, 0.0F);
					var1.a(var8);
				}

				this.a(var1, new class_cj(var3.n(), b.d(), var3.p()), Blocks.BEDROCK.S());
				return true;
			}
		}
	}

	public static class class_a_in_class_atm {
		private final int a;
		private final int b;
		private final int c;
		private final int d;
		private final boolean e;
		private final class_ayk f;

		public class_a_in_class_atm(int var1, int var2, int var3, int var4, boolean var5) {
			a = var1;
			b = var2;
			c = var3;
			d = var4;
			e = var5;
			f = new class_ayk(var1 - var3, 0.0D, var2 - var3, var1 + var3, 256.0D, var2 + var3);
		}

		public boolean a(class_cj var1) {
			int var2 = a - c;
			int var3 = b - c;
			return (var1.n() == (var2 & -16)) && (var1.p() == (var3 & -16));
		}

		public int a() {
			return a;
		}

		public int b() {
			return b;
		}

		public int c() {
			return c;
		}

		public int d() {
			return d;
		}

		public boolean e() {
			return e;
		}

		public class_ayk f() {
			return f;
		}
	}
}
