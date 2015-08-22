package net.minecraft.server;


public class class_avv extends class_awi {
	private final class_avv.class_a_in_class_avv c;

	public class_avv(long var1, class_awi var3, class_avv.class_a_in_class_avv var4) {
		super(var1);
		a = var3;
		c = var4;
	}

	@Override
	public int[] a(int var1, int var2, int var3, int var4) {
		switch (class_avv.SyntheticClass_1.a[c.ordinal()]) {
			case 1:
			default:
				return c(var1, var2, var3, var4);
			case 2:
				return d(var1, var2, var3, var4);
			case 3:
				return e(var1, var2, var3, var4);
		}
	}

	private int[] c(int var1, int var2, int var3, int var4) {
		int var5 = var1 - 1;
		int var6 = var2 - 1;
		int var7 = 1 + var3 + 1;
		int var8 = 1 + var4 + 1;
		int[] var9 = a.a(var5, var6, var7, var8);
		int[] var10 = class_awg.a(var3 * var4);

		for (int var11 = 0; var11 < var4; ++var11) {
			for (int var12 = 0; var12 < var3; ++var12) {
				this.a((long) (var12 + var1), (long) (var11 + var2));
				int var13 = var9[var12 + 1 + ((var11 + 1) * var7)];
				if (var13 == 1) {
					int var14 = var9[var12 + 1 + (((var11 + 1) - 1) * var7)];
					int var15 = var9[var12 + 1 + 1 + ((var11 + 1) * var7)];
					int var16 = var9[((var12 + 1) - 1) + ((var11 + 1) * var7)];
					int var17 = var9[var12 + 1 + ((var11 + 1 + 1) * var7)];
					boolean var18 = (var14 == 3) || (var15 == 3) || (var16 == 3) || (var17 == 3);
					boolean var19 = (var14 == 4) || (var15 == 4) || (var16 == 4) || (var17 == 4);
					if (var18 || var19) {
						var13 = 2;
					}
				}

				var10[var12 + (var11 * var3)] = var13;
			}
		}

		return var10;
	}

	private int[] d(int var1, int var2, int var3, int var4) {
		int var5 = var1 - 1;
		int var6 = var2 - 1;
		int var7 = 1 + var3 + 1;
		int var8 = 1 + var4 + 1;
		int[] var9 = a.a(var5, var6, var7, var8);
		int[] var10 = class_awg.a(var3 * var4);

		for (int var11 = 0; var11 < var4; ++var11) {
			for (int var12 = 0; var12 < var3; ++var12) {
				int var13 = var9[var12 + 1 + ((var11 + 1) * var7)];
				if (var13 == 4) {
					int var14 = var9[var12 + 1 + (((var11 + 1) - 1) * var7)];
					int var15 = var9[var12 + 1 + 1 + ((var11 + 1) * var7)];
					int var16 = var9[((var12 + 1) - 1) + ((var11 + 1) * var7)];
					int var17 = var9[var12 + 1 + ((var11 + 1 + 1) * var7)];
					boolean var18 = (var14 == 2) || (var15 == 2) || (var16 == 2) || (var17 == 2);
					boolean var19 = (var14 == 1) || (var15 == 1) || (var16 == 1) || (var17 == 1);
					if (var19 || var18) {
						var13 = 3;
					}
				}

				var10[var12 + (var11 * var3)] = var13;
			}
		}

		return var10;
	}

	private int[] e(int var1, int var2, int var3, int var4) {
		int[] var5 = a.a(var1, var2, var3, var4);
		int[] var6 = class_awg.a(var3 * var4);

		for (int var7 = 0; var7 < var4; ++var7) {
			for (int var8 = 0; var8 < var3; ++var8) {
				this.a((long) (var8 + var1), (long) (var7 + var2));
				int var9 = var5[var8 + (var7 * var3)];
				if ((var9 != 0) && (this.a(13) == 0)) {
					var9 |= ((1 + this.a(15)) << 8) & 3840;
				}

				var6[var8 + (var7 * var3)] = var9;
			}
		}

		return var6;
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
		// $FF: synthetic field
		static final int[] a = new int[class_avv.class_a_in_class_avv.values().length];

		static {
			try {
				a[class_avv.class_a_in_class_avv.a.ordinal()] = 1;
			} catch (NoSuchFieldError var3) {
				;
			}

			try {
				a[class_avv.class_a_in_class_avv.b.ordinal()] = 2;
			} catch (NoSuchFieldError var2) {
				;
			}

			try {
				a[class_avv.class_a_in_class_avv.c.ordinal()] = 3;
			} catch (NoSuchFieldError var1) {
				;
			}

		}
	}

	public static enum class_a_in_class_avv {
		a,
		b,
		c;
	}
}
