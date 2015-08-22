package net.minecraft.server;


public class class_awo extends class_awi {
	private class_awi c;
	private class_awi d;

	public class_awo(long var1, class_awi var3, class_awi var4) {
		super(var1);
		c = var3;
		d = var4;
	}

	@Override
	public void a(long var1) {
		c.a(var1);
		d.a(var1);
		super.a(var1);
	}

	@Override
	public int[] a(int var1, int var2, int var3, int var4) {
		int[] var5 = c.a(var1, var2, var3, var4);
		int[] var6 = d.a(var1, var2, var3, var4);
		int[] var7 = class_awg.a(var3 * var4);

		for (int var8 = 0; var8 < (var3 * var4); ++var8) {
			if ((var5[var8] != class_ahb.p.az) && (var5[var8] != class_ahb.N.az)) {
				if (var6[var8] == class_ahb.w.az) {
					if (var5[var8] == class_ahb.B.az) {
						var7[var8] = class_ahb.A.az;
					} else if ((var5[var8] != class_ahb.D.az) && (var5[var8] != class_ahb.E.az)) {
						var7[var8] = var6[var8] & 255;
					} else {
						var7[var8] = class_ahb.E.az;
					}
				} else {
					var7[var8] = var5[var8];
				}
			} else {
				var7[var8] = var5[var8];
			}
		}

		return var7;
	}
}
