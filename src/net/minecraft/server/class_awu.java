package net.minecraft.server;


public class class_awu extends class_awi {
	public class_awu(long var1, class_awi var3) {
		super(var1);
		super.a = var3;
	}

	@Override
	public int[] a(int var1, int var2, int var3, int var4) {
		var1 -= 2;
		var2 -= 2;
		int var5 = var1 >> 2;
		int var6 = var2 >> 2;
		int var7 = (var3 >> 2) + 2;
		int var8 = (var4 >> 2) + 2;
		int[] var9 = a.a(var5, var6, var7, var8);
		int var10 = (var7 - 1) << 2;
		int var11 = (var8 - 1) << 2;
		int[] var12 = class_awg.a(var10 * var11);

		int var14;
		for (int var13 = 0; var13 < (var8 - 1); ++var13) {
			var14 = 0;
			int var15 = var9[var14 + 0 + ((var13 + 0) * var7)];

			for (int var16 = var9[var14 + 0 + ((var13 + 1) * var7)]; var14 < (var7 - 1); ++var14) {
				double var17 = 3.6D;
				this.a((long) ((var14 + var5) << 2), (long) ((var13 + var6) << 2));
				double var19 = ((this.a(1024) / 1024.0D) - 0.5D) * 3.6D;
				double var21 = ((this.a(1024) / 1024.0D) - 0.5D) * 3.6D;
				this.a((long) ((var14 + var5 + 1) << 2), (long) ((var13 + var6) << 2));
				double var23 = (((this.a(1024) / 1024.0D) - 0.5D) * 3.6D) + 4.0D;
				double var25 = ((this.a(1024) / 1024.0D) - 0.5D) * 3.6D;
				this.a((long) ((var14 + var5) << 2), (long) ((var13 + var6 + 1) << 2));
				double var27 = ((this.a(1024) / 1024.0D) - 0.5D) * 3.6D;
				double var29 = (((this.a(1024) / 1024.0D) - 0.5D) * 3.6D) + 4.0D;
				this.a((long) ((var14 + var5 + 1) << 2), (long) ((var13 + var6 + 1) << 2));
				double var31 = (((this.a(1024) / 1024.0D) - 0.5D) * 3.6D) + 4.0D;
				double var33 = (((this.a(1024) / 1024.0D) - 0.5D) * 3.6D) + 4.0D;
				int var35 = var9[var14 + 1 + ((var13 + 0) * var7)] & 255;
				int var36 = var9[var14 + 1 + ((var13 + 1) * var7)] & 255;

				for (int var37 = 0; var37 < 4; ++var37) {
					int var38 = (((var13 << 2) + var37) * var10) + (var14 << 2);

					for (int var39 = 0; var39 < 4; ++var39) {
						double var40 = ((var37 - var21) * (var37 - var21)) + ((var39 - var19) * (var39 - var19));
						double var42 = ((var37 - var25) * (var37 - var25)) + ((var39 - var23) * (var39 - var23));
						double var44 = ((var37 - var29) * (var37 - var29)) + ((var39 - var27) * (var39 - var27));
						double var46 = ((var37 - var33) * (var37 - var33)) + ((var39 - var31) * (var39 - var31));
						if ((var40 < var42) && (var40 < var44) && (var40 < var46)) {
							var12[var38++] = var15;
						} else if ((var42 < var40) && (var42 < var44) && (var42 < var46)) {
							var12[var38++] = var35;
						} else if ((var44 < var40) && (var44 < var42) && (var44 < var46)) {
							var12[var38++] = var16;
						} else {
							var12[var38++] = var36;
						}
					}
				}

				var15 = var35;
				var16 = var36;
			}
		}

		int[] var48 = class_awg.a(var3 * var4);

		for (var14 = 0; var14 < var4; ++var14) {
			System.arraycopy(var12, ((var14 + (var2 & 3)) * var10) + (var1 & 3), var48, var14 * var3, var3);
		}

		return var48;
	}
}
