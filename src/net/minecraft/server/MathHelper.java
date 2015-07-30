package net.minecraft.server;

import java.util.Random;
import java.util.UUID;

public class MathHelper {

	public static final float SQRT_2 = sqrt(2.0F);

	private static final float[] SIN_COS = new float[65536];
	private static final Random RANDOM = new Random();
	private static final int[] MULTIPLY_DEBRUIJIN_BIT_POSITION = new int[] { 0, 1, 28, 2, 29, 14, 24, 3, 30, 22, 20, 15, 25, 17, 4, 8, 31, 27, 13, 23, 21, 19, 16, 7, 26, 12, 18, 6, 11, 5, 10, 9 };
	private static final double POW_2_44 = Double.longBitsToDouble(4805340802404319232L);
	private static final double[] f = new double[257];
	private static final double[] g = new double[257];

	static {
		for (int i = 0; i < 65536; ++i) {
			SIN_COS[i] = (float) Math.sin((double) i * 3.141592653589793D * 2.0D / 65536.0D);
		}

		for (int i = 0; i < 257; ++i) {
			double var1 = (double) i / 256.0D;
			double var3 = Math.asin(var1);
			g[i] = Math.cos(var3);
			f[i] = var3;
		}
	}

	public static float sin(float var0) {
		return SIN_COS[(int) (var0 * 10430.378F) & '\uffff'];
	}

	public static float cos(float var0) {
		return SIN_COS[(int) (var0 * 10430.378F + 16384.0F) & '\uffff'];
	}

	public static float sqrt(float f) {
		return (float) Math.sqrt((double) f);
	}

	public static float sqrt(double d) {
		return (float) Math.sqrt(d);
	}

	public static int floor(float f) {
		int i = (int) f;
		return f < (float) i ? i - 1 : i;
	}

	public static int floor(double d) {
		int i = (int) d;
		return d < (double) i ? i - 1 : i;
	}

	public static long floorL(double d) {
		long l = (long) d;
		return d < (double) l ? l - 1L : l;
	}

	public static float abs(float f) {
		return f >= 0.0F ? f : -f;
	}

	public static int abs(int i) {
		return i >= 0 ? i : -i;
	}

	public static int ceil(float f) {
		int i = (int) f;
		return f > (float) i ? i + 1 : i;
	}

	public static int ceil(double d) {
		int i = (int) d;
		return d > (double) i ? i + 1 : i;
	}

	public static int clamp(int i, int min, int max) {
		return i < min ? min : (i > max ? max : i);
	}

	public static float clamp(float f, float min, float max) {
		return f < min ? min : (f > max ? max : f);
	}

	public static double clamp(double d, double min, double max) {
		return d < min ? min : (d > max ? max : d);
	}

	public static double denormalizeClamp(double d, double min, double max) {
		return max < 0.0D ? d : (max > 1.0D ? min : d + (min - d) * max);
	}

	public static double maxAbs(double d1, double d2) {
		if (d1 < 0.0D) {
			d1 = -d1;
		}
		if (d2 < 0.0D) {
			d2 = -d2;
		}
		return d1 > d2 ? d1 : d2;
	}

	public static int getRandomIntInRange(Random rnd, int min, int max) {
		return min >= max ? min : rnd.nextInt(max - min + 1) + min;
	}

	public static float getRandomFloatInRange(Random rnd, float f1, float f2) {
		return f1 >= f2 ? f1 : rnd.nextFloat() * (f2 - f1) + f1;
	}

	public static double getRandomDoubleInRange(Random rnd, double d1, double d2) {
		return d1 >= d2 ? d1 : rnd.nextDouble() * (d2 - d1) + d1;
	}

	public static double getAverage(long[] numbers) {
		long sum = 0L;
		for (long number : numbers) {
			sum += number;
		}
		return (double) sum / (double) numbers.length;
	}

	public static float clampAngle(float angle) {
		angle %= 360.0F;
		if (angle >= 180.0F) {
			angle -= 360.0F;
		}
		if (angle < -180.0F) {
			angle += 360.0F;
		}
		return angle;
	}

	public static double clampAngle(double angle) {
		angle %= 360.0D;
		if (angle >= 180.0D) {
			angle -= 360.0D;
		}
		if (angle < -180.0D) {
			angle += 360.0D;
		}
		return angle;
	}

	public static int parseIntWithDef(String string, int def) {
		try {
			return Integer.parseInt(string);
		} catch (Throwable e) {
			return def;
		}
	}

	public static int max(String string, int def, int otherint) {
		return Math.max(otherint, parseIntWithDef(string, def));
	}

	public static double parseDoubleWithDef(String string, double def) {
		try {
			return Double.parseDouble(string);
		} catch (Throwable e) {
			return def;
		}
	}

	public static double max(String string, double def, double otherint) {
		return Math.max(otherint, parseDoubleWithDef(string, def));
	}

	public static int roundUpToPowerOfTwo(int value) {
		int var1 = value - 1;
		var1 |= var1 >> 1;
		var1 |= var1 >> 2;
		var1 |= var1 >> 4;
		var1 |= var1 >> 8;
		var1 |= var1 >> 16;
		return var1 + 1;
	}

	private static boolean isPowerOfTwo(int val) {
		return val != 0 && (val & val - 1) == 0;
	}

	private static int calculateLogBaseTwoDeBruijn(int val) {
		val = isPowerOfTwo(val) ? val : roundUpToPowerOfTwo(val);
		return MULTIPLY_DEBRUIJIN_BIT_POSITION[(int) ((long) val * 125613361L >> 27) & 31];
	}

	public static int calculateLogBaseTwo(int var0) {
		return calculateLogBaseTwoDeBruijn(var0) - (isPowerOfTwo(var0) ? 0 : 1);
	}

	public static int ceilByBase(int val, int base) {
		if (base == 0) {
			return 0;
		} else if (val == 0) {
			return base;
		} else {
			if (val < 0) {
				base *= -1;
			}

			int mod = val % base;
			return mod == 0 ? val : val + base - mod;
		}
	}

	public static UUID getRandomUUID(Random rnd) {
		long par1 = rnd.nextLong() & -61441L | 16384L;
		long par2 = rnd.nextLong() & 4611686018427387903L | Long.MIN_VALUE;
		return new UUID(par1, par2);
	}

	public static UUID getRandomUUID() {
		return getRandomUUID(RANDOM);
	}

	public static double c(double var0, double var2, double var4) {
		return (var0 - var2) / (var4 - var2);
	}

	public static double b(double var0, double var2) {
		double var4 = var2 * var2 + var0 * var0;
		if (Double.isNaN(var4)) {
			return Double.NaN;
		} else {
			boolean var6 = var0 < 0.0D;
			if (var6) {
				var0 = -var0;
			}

			boolean var7 = var2 < 0.0D;
			if (var7) {
				var2 = -var2;
			}

			boolean var8 = var0 > var2;
			double var9;
			if (var8) {
				var9 = var2;
				var2 = var0;
				var0 = var9;
			}

			var9 = i(var4);
			var2 *= var9;
			var0 *= var9;
			double var11 = POW_2_44 + var0;
			int var13 = (int) Double.doubleToRawLongBits(var11);
			double var14 = f[var13];
			double var16 = g[var13];
			double var18 = var11 - POW_2_44;
			double var20 = var0 * var16 - var2 * var18;
			double var22 = (6.0D + var20 * var20) * var20 * 0.16666666666666666D;
			double var24 = var14 + var22;
			if (var8) {
				var24 = 1.5707963267948966D - var24;
			}

			if (var7) {
				var24 = 3.141592653589793D - var24;
			}

			if (var6) {
				var24 = -var24;
			}

			return var24;
		}
	}

	public static double i(double var0) {
		double var2 = 0.5D * var0;
		long var4 = Double.doubleToRawLongBits(var0);
		var4 = 6910469410427058090L - (var4 >> 1);
		var0 = Double.longBitsToDouble(var4);
		var0 *= 1.5D - var2 * var0 * var0;
		return var0;
	}

}
