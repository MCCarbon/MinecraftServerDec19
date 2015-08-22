package net.minecraft.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_awk extends class_awi {
	private static final Logger c = LogManager.getLogger();
	private class_awi d;

	public class_awk(long var1, class_awi var3, class_awi var4) {
		super(var1);
		a = var3;
		d = var4;
	}

	@Override
	public int[] a(int var1, int var2, int var3, int var4) {
		int[] var5 = a.a(var1 - 1, var2 - 1, var3 + 2, var4 + 2);
		int[] var6 = d.a(var1 - 1, var2 - 1, var3 + 2, var4 + 2);
		int[] var7 = class_awg.a(var3 * var4);

		for (int var8 = 0; var8 < var4; ++var8) {
			for (int var9 = 0; var9 < var3; ++var9) {
				this.a((long) (var9 + var1), (long) (var8 + var2));
				int var10 = var5[var9 + 1 + ((var8 + 1) * (var3 + 2))];
				int var11 = var6[var9 + 1 + ((var8 + 1) * (var3 + 2))];
				boolean var12 = ((var11 - 2) % 29) == 0;
				if (var10 > 255) {
					c.debug("old! " + var10);
				}

				if ((var10 != 0) && (var11 >= 2) && (((var11 - 2) % 29) == 1) && (var10 < 128)) {
					if (class_ahb.e(var10 + 128) != null) {
						var7[var9 + (var8 * var3)] = var10 + 128;
					} else {
						var7[var9 + (var8 * var3)] = var10;
					}
				} else if ((this.a(3) != 0) && !var12) {
					var7[var9 + (var8 * var3)] = var10;
				} else {
					int var13 = var10;
					int var14;
					if (var10 == class_ahb.r.az) {
						var13 = class_ahb.G.az;
					} else if (var10 == class_ahb.t.az) {
						var13 = class_ahb.H.az;
					} else if (var10 == class_ahb.Q.az) {
						var13 = class_ahb.R.az;
					} else if (var10 == class_ahb.S.az) {
						var13 = class_ahb.q.az;
					} else if (var10 == class_ahb.u.az) {
						var13 = class_ahb.I.az;
					} else if (var10 == class_ahb.V.az) {
						var13 = class_ahb.W.az;
					} else if (var10 == class_ahb.T.az) {
						var13 = class_ahb.U.az;
					} else if (var10 == class_ahb.q.az) {
						if (this.a(3) == 0) {
							var13 = class_ahb.H.az;
						} else {
							var13 = class_ahb.t.az;
						}
					} else if (var10 == class_ahb.B.az) {
						var13 = class_ahb.C.az;
					} else if (var10 == class_ahb.K.az) {
						var13 = class_ahb.L.az;
					} else if (var10 == class_ahb.p.az) {
						var13 = class_ahb.N.az;
					} else if (var10 == class_ahb.s.az) {
						var13 = class_ahb.X.az;
					} else if (var10 == class_ahb.Y.az) {
						var13 = class_ahb.Z.az;
					} else if (a(var10, class_ahb.ab.az)) {
						var13 = class_ahb.aa.az;
					} else if ((var10 == class_ahb.N.az) && (this.a(3) == 0)) {
						var14 = this.a(2);
						if (var14 == 0) {
							var13 = class_ahb.q.az;
						} else {
							var13 = class_ahb.t.az;
						}
					}

					if (var12 && (var13 != var10)) {
						if (class_ahb.e(var13 + 128) != null) {
							var13 += 128;
						} else {
							var13 = var10;
						}
					}

					if (var13 == var10) {
						var7[var9 + (var8 * var3)] = var10;
					} else {
						var14 = var5[var9 + 1 + (((var8 + 1) - 1) * (var3 + 2))];
						int var15 = var5[var9 + 1 + 1 + ((var8 + 1) * (var3 + 2))];
						int var16 = var5[((var9 + 1) - 1) + ((var8 + 1) * (var3 + 2))];
						int var17 = var5[var9 + 1 + ((var8 + 1 + 1) * (var3 + 2))];
						int var18 = 0;
						if (a(var14, var10)) {
							++var18;
						}

						if (a(var15, var10)) {
							++var18;
						}

						if (a(var16, var10)) {
							++var18;
						}

						if (a(var17, var10)) {
							++var18;
						}

						if (var18 >= 3) {
							var7[var9 + (var8 * var3)] = var13;
						} else {
							var7[var9 + (var8 * var3)] = var10;
						}
					}
				}
			}
		}

		return var7;
	}
}
