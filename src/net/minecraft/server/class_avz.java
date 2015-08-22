package net.minecraft.server;


public class class_avz extends class_awi {
	public class_avz(long var1, class_awi var3) {
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
				if (!this.a(var5, var6, var8, var7, var3, var9, class_ahb.s.az, class_ahb.J.az) && !this.b(var5, var6, var8, var7, var3, var9, class_ahb.ab.az, class_ahb.aa.az) && !this.b(var5, var6, var8, var7, var3, var9, class_ahb.ac.az, class_ahb.aa.az) && !this.b(var5, var6, var8, var7, var3, var9, class_ahb.V.az, class_ahb.u.az)) {
					int var10;
					int var11;
					int var12;
					int var13;
					if (var9 == class_ahb.r.az) {
						var10 = var5[var8 + 1 + (((var7 + 1) - 1) * (var3 + 2))];
						var11 = var5[var8 + 1 + 1 + ((var7 + 1) * (var3 + 2))];
						var12 = var5[((var8 + 1) - 1) + ((var7 + 1) * (var3 + 2))];
						var13 = var5[var8 + 1 + ((var7 + 1 + 1) * (var3 + 2))];
						if ((var10 != class_ahb.B.az) && (var11 != class_ahb.B.az) && (var12 != class_ahb.B.az) && (var13 != class_ahb.B.az)) {
							var6[var8 + (var7 * var3)] = var9;
						} else {
							var6[var8 + (var7 * var3)] = class_ahb.X.az;
						}
					} else if (var9 == class_ahb.v.az) {
						var10 = var5[var8 + 1 + (((var7 + 1) - 1) * (var3 + 2))];
						var11 = var5[var8 + 1 + 1 + ((var7 + 1) * (var3 + 2))];
						var12 = var5[((var8 + 1) - 1) + ((var7 + 1) * (var3 + 2))];
						var13 = var5[var8 + 1 + ((var7 + 1 + 1) * (var3 + 2))];
						if ((var10 != class_ahb.r.az) && (var11 != class_ahb.r.az) && (var12 != class_ahb.r.az) && (var13 != class_ahb.r.az) && (var10 != class_ahb.T.az) && (var11 != class_ahb.T.az) && (var12 != class_ahb.T.az) && (var13 != class_ahb.T.az) && (var10 != class_ahb.B.az) && (var11 != class_ahb.B.az) && (var12 != class_ahb.B.az) && (var13 != class_ahb.B.az)) {
							if ((var10 != class_ahb.K.az) && (var13 != class_ahb.K.az) && (var11 != class_ahb.K.az) && (var12 != class_ahb.K.az)) {
								var6[var8 + (var7 * var3)] = var9;
							} else {
								var6[var8 + (var7 * var3)] = class_ahb.M.az;
							}
						} else {
							var6[var8 + (var7 * var3)] = class_ahb.q.az;
						}
					} else {
						var6[var8 + (var7 * var3)] = var9;
					}
				}
			}
		}

		return var6;
	}

	private boolean a(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8) {
		if (!a(var6, var7)) {
			return false;
		} else {
			int var9 = var1[var3 + 1 + (((var4 + 1) - 1) * (var5 + 2))];
			int var10 = var1[var3 + 1 + 1 + ((var4 + 1) * (var5 + 2))];
			int var11 = var1[((var3 + 1) - 1) + ((var4 + 1) * (var5 + 2))];
			int var12 = var1[var3 + 1 + ((var4 + 1 + 1) * (var5 + 2))];
			if (this.b(var9, var7) && this.b(var10, var7) && this.b(var11, var7) && this.b(var12, var7)) {
				var2[var3 + (var4 * var5)] = var6;
			} else {
				var2[var3 + (var4 * var5)] = var8;
			}

			return true;
		}
	}

	private boolean b(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8) {
		if (var6 != var7) {
			return false;
		} else {
			int var9 = var1[var3 + 1 + (((var4 + 1) - 1) * (var5 + 2))];
			int var10 = var1[var3 + 1 + 1 + ((var4 + 1) * (var5 + 2))];
			int var11 = var1[((var3 + 1) - 1) + ((var4 + 1) * (var5 + 2))];
			int var12 = var1[var3 + 1 + ((var4 + 1 + 1) * (var5 + 2))];
			if (a(var9, var7) && a(var10, var7) && a(var11, var7) && a(var12, var7)) {
				var2[var3 + (var4 * var5)] = var6;
			} else {
				var2[var3 + (var4 * var5)] = var8;
			}

			return true;
		}
	}

	private boolean b(int var1, int var2) {
		if (a(var1, var2)) {
			return true;
		} else {
			class_ahb var3 = class_ahb.e(var1);
			class_ahb var4 = class_ahb.e(var2);
			if ((var3 != null) && (var4 != null)) {
				class_ahb.class_b_in_class_ahb var5 = var3.m();
				class_ahb.class_b_in_class_ahb var6 = var4.m();
				return (var5 == var6) || (var5 == class_ahb.class_b_in_class_ahb.c) || (var6 == class_ahb.class_b_in_class_ahb.c);
			} else {
				return false;
			}
		}
	}
}
