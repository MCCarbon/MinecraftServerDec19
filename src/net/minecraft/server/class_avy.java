package net.minecraft.server;


public class class_avy extends class_awi {
	public class_avy(long var1, class_awi var3) {
		super(var1);
		a = var3;
	}

	@Override
	public int[] a(int var1, int var2, int var3, int var4) {
		int var5 = var1 - 1;
		int var6 = var2 - 1;
		int var7 = var3 + 2;
		int var8 = var4 + 2;
		int[] var9 = a.a(var5, var6, var7, var8);
		int[] var10 = class_awg.a(var3 * var4);

		for (int var11 = 0; var11 < var4; ++var11) {
			for (int var12 = 0; var12 < var3; ++var12) {
				int var13 = var9[var12 + 1 + ((var11 + 1) * var7)];
				this.a((long) (var12 + var1), (long) (var11 + var2));
				if (var13 == 0) {
					var10[var12 + (var11 * var3)] = 0;
				} else {
					int var14 = this.a(6);
					byte var15;
					if (var14 == 0) {
						var15 = 4;
					} else if (var14 <= 1) {
						var15 = 3;
					} else {
						var15 = 1;
					}

					var10[var12 + (var11 * var3)] = var15;
				}
			}
		}

		return var10;
	}
}
