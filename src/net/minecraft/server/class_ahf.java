package net.minecraft.server;

import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;

public class class_ahf {
	private class_awi b;
	private class_awi c;
	private class_ahc d;
	private List e;
	private String f;

	protected class_ahf() {
		d = new class_ahc(this);
		f = "";
		e = Lists.newArrayList();
		e.add(class_ahb.t);
		e.add(class_ahb.q);
		e.add(class_ahb.u);
		e.add(class_ahb.I);
		e.add(class_ahb.H);
		e.add(class_ahb.K);
		e.add(class_ahb.L);
	}

	public class_ahf(long var1, class_agt var3, String var4) {
		this();
		f = var4;
		class_awi[] var5 = class_awi.a(var1, var3, var4);
		b = var5[0];
		c = var5[1];
	}

	public class_ahf(class_ago var1) {
		this(var1.L(), var1.R().t(), var1.R().A());
	}

	public List a() {
		return e;
	}

	public class_ahb a(class_cj var1) {
		return this.a(var1, (class_ahb) null);
	}

	public class_ahb a(class_cj var1, class_ahb var2) {
		return d.a(var1.n(), var1.p(), var2);
	}

	public float[] a(float[] var1, int var2, int var3, int var4, int var5) {
		class_awg.a();
		if ((var1 == null) || (var1.length < (var4 * var5))) {
			var1 = new float[var4 * var5];
		}

		int[] var6 = c.a(var2, var3, var4, var5);

		for (int var7 = 0; var7 < (var4 * var5); ++var7) {
			try {
				float var8 = class_ahb.a(var6[var7], class_ahb.ad).h() / 65536.0F;
				if (var8 > 1.0F) {
					var8 = 1.0F;
				}

				var1[var7] = var8;
			} catch (Throwable var11) {
				class_b var9 = class_b.a(var11, "Invalid Biome id");
				class_c var10 = var9.a("DownfallBlock");
				var10.a("biome id", Integer.valueOf(var7));
				var10.a("downfalls[] size", Integer.valueOf(var1.length));
				var10.a("x", Integer.valueOf(var2));
				var10.a("z", Integer.valueOf(var3));
				var10.a("w", Integer.valueOf(var4));
				var10.a("h", Integer.valueOf(var5));
				throw new class_e(var9);
			}
		}

		return var1;
	}

	public class_ahb[] a(class_ahb[] var1, int var2, int var3, int var4, int var5) {
		class_awg.a();
		if ((var1 == null) || (var1.length < (var4 * var5))) {
			var1 = new class_ahb[var4 * var5];
		}

		int[] var6 = b.a(var2, var3, var4, var5);

		try {
			for (int var7 = 0; var7 < (var4 * var5); ++var7) {
				var1[var7] = class_ahb.a(var6[var7], class_ahb.ad);
			}

			return var1;
		} catch (Throwable var10) {
			class_b var8 = class_b.a(var10, "Invalid Biome id");
			class_c var9 = var8.a("RawBiomeBlock");
			var9.a("biomes[] size", Integer.valueOf(var1.length));
			var9.a("x", Integer.valueOf(var2));
			var9.a("z", Integer.valueOf(var3));
			var9.a("w", Integer.valueOf(var4));
			var9.a("h", Integer.valueOf(var5));
			throw new class_e(var8);
		}
	}

	public class_ahb[] b(class_ahb[] var1, int var2, int var3, int var4, int var5) {
		return this.a(var1, var2, var3, var4, var5, true);
	}

	public class_ahb[] a(class_ahb[] var1, int var2, int var3, int var4, int var5, boolean var6) {
		class_awg.a();
		if ((var1 == null) || (var1.length < (var4 * var5))) {
			var1 = new class_ahb[var4 * var5];
		}

		if (var6 && (var4 == 16) && (var5 == 16) && ((var2 & 15) == 0) && ((var3 & 15) == 0)) {
			class_ahb[] var9 = d.c(var2, var3);
			System.arraycopy(var9, 0, var1, 0, var4 * var5);
			return var1;
		} else {
			int[] var7 = c.a(var2, var3, var4, var5);

			for (int var8 = 0; var8 < (var4 * var5); ++var8) {
				var1[var8] = class_ahb.a(var7[var8], class_ahb.ad);
			}

			return var1;
		}
	}

	public boolean a(int var1, int var2, int var3, List var4) {
		class_awg.a();
		int var5 = (var1 - var3) >> 2;
			int var6 = (var2 - var3) >> 2;
			int var7 = (var1 + var3) >> 2;
		int var8 = (var2 + var3) >> 2;
		int var9 = (var7 - var5) + 1;
		int var10 = (var8 - var6) + 1;
		int[] var11 = b.a(var5, var6, var9, var10);

		try {
			for (int var12 = 0; var12 < (var9 * var10); ++var12) {
				class_ahb var16 = class_ahb.e(var11[var12]);
				if (!var4.contains(var16)) {
					return false;
				}
			}

			return true;
		} catch (Throwable var15) {
			class_b var13 = class_b.a(var15, "Invalid Biome id");
			class_c var14 = var13.a("Layer");
			var14.a("Layer", b.toString());
			var14.a("x", Integer.valueOf(var1));
			var14.a("z", Integer.valueOf(var2));
			var14.a("radius", Integer.valueOf(var3));
			var14.a("allowed", var4);
			throw new class_e(var13);
		}
	}

	public class_cj a(int var1, int var2, int var3, List var4, Random var5) {
		class_awg.a();
		int var6 = (var1 - var3) >> 2;
			int var7 = (var2 - var3) >> 2;
			int var8 = (var1 + var3) >> 2;
			int var9 = (var2 + var3) >> 2;
			int var10 = (var8 - var6) + 1;
			int var11 = (var9 - var7) + 1;
			int[] var12 = b.a(var6, var7, var10, var11);
			class_cj var13 = null;
			int var14 = 0;

			for (int var15 = 0; var15 < (var10 * var11); ++var15) {
				int var16 = (var6 + (var15 % var10)) << 2;
				int var17 = (var7 + (var15 / var10)) << 2;
				class_ahb var18 = class_ahb.e(var12[var15]);
				if (var4.contains(var18) && ((var13 == null) || (var5.nextInt(var14 + 1) == 0))) {
					var13 = new class_cj(var16, 0, var17);
					++var14;
				}
			}

			return var13;
	}

	public void b() {
		d.a();
	}
}
