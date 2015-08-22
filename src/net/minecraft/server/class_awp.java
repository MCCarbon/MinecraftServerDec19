package net.minecraft.server;


public class class_awp extends class_awi {
	public class_awp(long var1, class_awi var3) {
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
				class_ahb var10 = class_ahb.e(var9);
				int var11;
				int var12;
				int var13;
				int var14;
				if (var9 == class_ahb.D.az) {
					var11 = var5[var8 + 1 + (((var7 + 1) - 1) * (var3 + 2))];
					var12 = var5[var8 + 1 + 1 + ((var7 + 1) * (var3 + 2))];
					var13 = var5[((var8 + 1) - 1) + ((var7 + 1) * (var3 + 2))];
					var14 = var5[var8 + 1 + ((var7 + 1 + 1) * (var3 + 2))];
					if ((var11 != class_ahb.p.az) && (var12 != class_ahb.p.az) && (var13 != class_ahb.p.az) && (var14 != class_ahb.p.az)) {
						var6[var8 + (var7 * var3)] = var9;
					} else {
						var6[var8 + (var7 * var3)] = class_ahb.E.az;
					}
				} else if ((var10 != null) && (var10.l() == class_ahm.class)) {
					var11 = var5[var8 + 1 + (((var7 + 1) - 1) * (var3 + 2))];
					var12 = var5[var8 + 1 + 1 + ((var7 + 1) * (var3 + 2))];
					var13 = var5[((var8 + 1) - 1) + ((var7 + 1) * (var3 + 2))];
					var14 = var5[var8 + 1 + ((var7 + 1 + 1) * (var3 + 2))];
					if (c(var11) && c(var12) && c(var13) && c(var14)) {
						if (!b(var11) && !b(var12) && !b(var13) && !b(var14)) {
							var6[var8 + (var7 * var3)] = var9;
						} else {
							var6[var8 + (var7 * var3)] = class_ahb.F.az;
						}
					} else {
						var6[var8 + (var7 * var3)] = class_ahb.M.az;
					}
				} else if ((var9 != class_ahb.s.az) && (var9 != class_ahb.X.az) && (var9 != class_ahb.J.az)) {
					if ((var10 != null) && var10.j()) {
						this.a(var5, var6, var8, var7, var3, var9, class_ahb.P.az);
					} else if ((var9 != class_ahb.aa.az) && (var9 != class_ahb.ab.az)) {
						if ((var9 != class_ahb.p.az) && (var9 != class_ahb.N.az) && (var9 != class_ahb.w.az) && (var9 != class_ahb.v.az)) {
							var11 = var5[var8 + 1 + (((var7 + 1) - 1) * (var3 + 2))];
							var12 = var5[var8 + 1 + 1 + ((var7 + 1) * (var3 + 2))];
							var13 = var5[((var8 + 1) - 1) + ((var7 + 1) * (var3 + 2))];
							var14 = var5[var8 + 1 + ((var7 + 1 + 1) * (var3 + 2))];
							if (!b(var11) && !b(var12) && !b(var13) && !b(var14)) {
								var6[var8 + (var7 * var3)] = var9;
							} else {
								var6[var8 + (var7 * var3)] = class_ahb.F.az;
							}
						} else {
							var6[var8 + (var7 * var3)] = var9;
						}
					} else {
						var11 = var5[var8 + 1 + (((var7 + 1) - 1) * (var3 + 2))];
						var12 = var5[var8 + 1 + 1 + ((var7 + 1) * (var3 + 2))];
						var13 = var5[((var8 + 1) - 1) + ((var7 + 1) * (var3 + 2))];
						var14 = var5[var8 + 1 + ((var7 + 1 + 1) * (var3 + 2))];
						if (!b(var11) && !b(var12) && !b(var13) && !b(var14)) {
							if (d(var11) && d(var12) && d(var13) && d(var14)) {
								var6[var8 + (var7 * var3)] = var9;
							} else {
								var6[var8 + (var7 * var3)] = class_ahb.r.az;
							}
						} else {
							var6[var8 + (var7 * var3)] = var9;
						}
					}
				} else {
					this.a(var5, var6, var8, var7, var3, var9, class_ahb.O.az);
				}
			}
		}

		return var6;
	}

	private void a(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7) {
		if (b(var6)) {
			var2[var3 + (var4 * var5)] = var6;
		} else {
			int var8 = var1[var3 + 1 + (((var4 + 1) - 1) * (var5 + 2))];
			int var9 = var1[var3 + 1 + 1 + ((var4 + 1) * (var5 + 2))];
			int var10 = var1[((var3 + 1) - 1) + ((var4 + 1) * (var5 + 2))];
			int var11 = var1[var3 + 1 + ((var4 + 1 + 1) * (var5 + 2))];
			if (!b(var8) && !b(var9) && !b(var10) && !b(var11)) {
				var2[var3 + (var4 * var5)] = var6;
			} else {
				var2[var3 + (var4 * var5)] = var7;
			}

		}
	}

	private boolean c(int var1) {
		return (class_ahb.e(var1) != null) && (class_ahb.e(var1).l() == class_ahm.class) ? true : (var1 == class_ahb.M.az) || (var1 == class_ahb.K.az) || (var1 == class_ahb.L.az) || (var1 == class_ahb.t.az) || (var1 == class_ahb.u.az) || b(var1);
	}

	private boolean d(int var1) {
		return class_ahb.e(var1) instanceof class_ahn;
	}
}
