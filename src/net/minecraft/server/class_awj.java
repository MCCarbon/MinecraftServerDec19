package net.minecraft.server;


public class class_awj extends class_awi {
	public class_awj(long var1, class_awi var3) {
		super(var1);
		a = var3;
	}

	@Override
	public int[] a(int var1, int var2, int var3, int var4) {
		int[] var5 = a.a(var1 - 1, var2 - 1, var3 + 2, var4 + 2);
		int[] var6 = class_awg.a(var3 * var4);

		for (int var7 = 0; var7 < var4; ++var7) {
			for (int var8 = 0; var8 < var3; ++var8) {
				this.a((long) (var8 + var1), (long) (var7 + var2));
				int var9 = var5[var8 + 1 + ((var7 + 1) * (var3 + 2))];
				if (this.a(57) == 0) {
					if (var9 == class_ahb.q.az) {
						var6[var8 + (var7 * var3)] = class_ahb.q.az + 128;
					} else {
						var6[var8 + (var7 * var3)] = var9;
					}
				} else {
					var6[var8 + (var7 * var3)] = var9;
				}
			}
		}

		return var6;
	}
}
