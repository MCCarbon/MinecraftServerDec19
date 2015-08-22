package net.minecraft.server;


public class class_awa extends class_awi {
	private class_ahb[] c;
	private class_ahb[] d;
	private class_ahb[] e;
	private class_ahb[] f;
	private final class_arm g;

	public class_awa(long var1, class_awi var3, class_agt var4, String var5) {
		super(var1);
		c = new class_ahb[] { class_ahb.r, class_ahb.r, class_ahb.r, class_ahb.Y, class_ahb.Y, class_ahb.q };
		d = new class_ahb[] { class_ahb.t, class_ahb.S, class_ahb.s, class_ahb.q, class_ahb.Q, class_ahb.v };
		e = new class_ahb[] { class_ahb.t, class_ahb.s, class_ahb.u, class_ahb.q };
		f = new class_ahb[] { class_ahb.B, class_ahb.B, class_ahb.B, class_ahb.T };
		a = var3;
		if (var4 == class_agt.h) {
			c = new class_ahb[] { class_ahb.r, class_ahb.t, class_ahb.s, class_ahb.v, class_ahb.q, class_ahb.u };
			g = null;
		} else if (var4 == class_agt.f) {
			g = class_arm.class_a_in_class_arm.a(var5).b();
		} else {
			g = null;
		}

	}

	@Override
	public int[] a(int var1, int var2, int var3, int var4) {
		int[] var5 = a.a(var1, var2, var3, var4);
		int[] var6 = class_awg.a(var3 * var4);

		for (int var7 = 0; var7 < var4; ++var7) {
			for (int var8 = 0; var8 < var3; ++var8) {
				this.a((long) (var8 + var1), (long) (var7 + var2));
				int var9 = var5[var8 + (var7 * var3)];
				int var10 = (var9 & 3840) >> 8;
			var9 &= -3841;
			if ((g != null) && (g.F >= 0)) {
				var6[var8 + (var7 * var3)] = g.F;
			} else if (b(var9)) {
				var6[var8 + (var7 * var3)] = var9;
			} else if (var9 == class_ahb.D.az) {
				var6[var8 + (var7 * var3)] = var9;
			} else if (var9 == 1) {
				if (var10 > 0) {
					if (this.a(3) == 0) {
						var6[var8 + (var7 * var3)] = class_ahb.ac.az;
					} else {
						var6[var8 + (var7 * var3)] = class_ahb.ab.az;
					}
				} else {
					var6[var8 + (var7 * var3)] = c[this.a(c.length)].az;
				}
			} else if (var9 == 2) {
				if (var10 > 0) {
					var6[var8 + (var7 * var3)] = class_ahb.K.az;
				} else {
					var6[var8 + (var7 * var3)] = d[this.a(d.length)].az;
				}
			} else if (var9 == 3) {
				if (var10 > 0) {
					var6[var8 + (var7 * var3)] = class_ahb.V.az;
				} else {
					var6[var8 + (var7 * var3)] = e[this.a(e.length)].az;
				}
			} else if (var9 == 4) {
				var6[var8 + (var7 * var3)] = f[this.a(f.length)].az;
			} else {
				var6[var8 + (var7 * var3)] = class_ahb.D.az;
			}
			}
		}

		return var6;
	}
}
