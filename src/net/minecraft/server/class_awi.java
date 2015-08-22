package net.minecraft.server;

import java.util.concurrent.Callable;

public abstract class class_awi {
	private long c;
	protected class_awi a;
	private long d;
	protected long b;

	public static class_awi[] a(long var0, class_agt var2, String var3) {
		class_awh var4 = new class_awh(1L);
		class_awe var13 = new class_awe(2000L, var4);
		class_avw var14 = new class_avw(1L, var13);
		class_awv var15 = new class_awv(2001L, var14);
		var14 = new class_avw(2L, var15);
		var14 = new class_avw(50L, var14);
		var14 = new class_avw(70L, var14);
		class_awl var16 = new class_awl(2L, var14);
		class_avy var17 = new class_avy(2L, var16);
		var14 = new class_avw(3L, var17);
		class_avv var18 = new class_avv(2L, var14, class_avv.class_a_in_class_avv.a);
		var18 = new class_avv(2L, var18, class_avv.class_a_in_class_avv.b);
		var18 = new class_avv(3L, var18, class_avv.class_a_in_class_avv.c);
		var15 = new class_awv(2002L, var18);
		var15 = new class_awv(2003L, var15);
		var14 = new class_avw(4L, var15);
		class_avx var20 = new class_avx(5L, var14);
		class_avu var23 = new class_avu(4L, var20);
		class_awi var26 = class_awv.b(1000L, var23, 0);
		class_arm var5 = null;
		int var6 = 4;
		int var7 = var6;
		if ((var2 == class_agt.f) && !var3.isEmpty()) {
			var5 = class_arm.class_a_in_class_arm.a(var3).b();
			var6 = var5.G;
			var7 = var5.H;
		}

		if (var2 == class_agt.d) {
			var6 = 6;
		}

		class_awi var8 = class_awv.b(1000L, var26, 0);
		class_awm var19 = new class_awm(100L, var8);
		class_awa var9 = new class_awa(200L, var26, var2, var3);
		class_awi var21 = class_awv.b(1000L, var9, 2);
		class_avz var24 = new class_avz(1000L, var21);
		class_awi var10 = class_awv.b(1000L, var19, 2);
		class_awk var27 = new class_awk(1000L, var24, var10);
		var8 = class_awv.b(1000L, var19, 2);
		var8 = class_awv.b(1000L, var8, var7);
		class_awn var22 = new class_awn(1L, var8);
		class_awq var25 = new class_awq(1000L, var22);
		Object var28 = new class_awj(1001L, var27);

		for (int var11 = 0; var11 < var6; ++var11) {
			var28 = new class_awv((long) (1000 + var11), (class_awi) var28);
			if (var11 == 0) {
				var28 = new class_avw(3L, (class_awi) var28);
			}

			if ((var11 == 1) || (var6 == 1)) {
				var28 = new class_awp(1000L, (class_awi) var28);
			}
		}

		class_awq var29 = new class_awq(1000L, (class_awi) var28);
		class_awo var30 = new class_awo(100L, var29, var25);
		class_awu var12 = new class_awu(10L, var30);
		var30.a(var0);
		var12.a(var0);
		return new class_awi[] { var30, var12, var30 };
	}

	public class_awi(long var1) {
		b = var1;
		b *= (b * 6364136223846793005L) + 1442695040888963407L;
		b += var1;
		b *= (b * 6364136223846793005L) + 1442695040888963407L;
		b += var1;
		b *= (b * 6364136223846793005L) + 1442695040888963407L;
		b += var1;
	}

	public void a(long var1) {
		c = var1;
		if (a != null) {
			a.a(var1);
		}

		c *= (c * 6364136223846793005L) + 1442695040888963407L;
		c += b;
		c *= (c * 6364136223846793005L) + 1442695040888963407L;
		c += b;
		c *= (c * 6364136223846793005L) + 1442695040888963407L;
		c += b;
	}

	public void a(long var1, long var3) {
		d = c;
		d *= (d * 6364136223846793005L) + 1442695040888963407L;
		d += var1;
		d *= (d * 6364136223846793005L) + 1442695040888963407L;
		d += var3;
		d *= (d * 6364136223846793005L) + 1442695040888963407L;
		d += var1;
		d *= (d * 6364136223846793005L) + 1442695040888963407L;
		d += var3;
	}

	protected int a(int var1) {
		int var2 = (int) ((d >> 24) % var1);
		if (var2 < 0) {
			var2 += var1;
		}

		d *= (d * 6364136223846793005L) + 1442695040888963407L;
		d += c;
		return var2;
	}

	public abstract int[] a(int var1, int var2, int var3, int var4);

	protected static boolean a(int var0, int var1) {
		if (var0 == var1) {
			return true;
		} else if ((var0 != class_ahb.ab.az) && (var0 != class_ahb.ac.az)) {
			final class_ahb var2 = class_ahb.e(var0);
			final class_ahb var3 = class_ahb.e(var1);

			try {
				return (var2 != null) && (var3 != null) ? var2.a(var3) : false;
			} catch (Throwable var7) {
				class_b var5 = class_b.a(var7, "Comparing biomes");
				class_c var6 = var5.a("Biomes being compared");
				var6.a("Biome A ID", Integer.valueOf(var0));
				var6.a("Biome B ID", Integer.valueOf(var1));
				var6.a("Biome A", new Callable() {
					public String a() throws Exception {
						return String.valueOf(var2);
					}

					// $FF: synthetic method
					@Override
					public Object call() throws Exception {
						return this.a();
					}
				});
				var6.a("Biome B", new Callable() {
					public String a() throws Exception {
						return String.valueOf(var3);
					}

					// $FF: synthetic method
					@Override
					public Object call() throws Exception {
						return this.a();
					}
				});
				throw new class_e(var5);
			}
		} else {
			return (var1 == class_ahb.ab.az) || (var1 == class_ahb.ac.az);
		}
	}

	protected static boolean b(int var0) {
		return (var0 == class_ahb.p.az) || (var0 == class_ahb.N.az) || (var0 == class_ahb.z.az);
	}

	protected int a(int... var1) {
		return var1[this.a(var1.length)];
	}

	protected int b(int var1, int var2, int var3, int var4) {
		return (var2 == var3) && (var3 == var4) ? var2 : ((var1 == var2) && (var1 == var3) ? var1 : ((var1 == var2) && (var1 == var4) ? var1 : ((var1 == var3) && (var1 == var4) ? var1 : ((var1 == var2) && (var3 != var4) ? var1 : ((var1 == var3) && (var2 != var4) ? var1 : ((var1 == var4) && (var2 != var3) ? var1 : ((var2 == var3) && (var1 != var4) ? var2 : ((var2 == var4) && (var1 != var3) ? var2 : ((var3 == var4) && (var1 != var2) ? var3 : this.a(new int[] { var1, var2, var3, var4 }))))))))));
	}
}
