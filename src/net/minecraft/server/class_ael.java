package net.minecraft.server;

import java.util.ArrayList;

import com.google.common.collect.Lists;

public class class_ael implements class_aes {
	private class_aco a;

	@Override
	public boolean a(class_aab var1, class_ago var2) {
		a = null;
		int var3 = 0;
		int var4 = 0;
		int var5 = 0;
		int var6 = 0;
		int var7 = 0;
		int var8 = 0;

		for (int var9 = 0; var9 < var1.n_(); ++var9) {
			class_aco var10 = var1.a(var9);
			if (var10 != null) {
				if (var10.b() == class_acq.J) {
					++var4;
				} else if (var10.b() == class_acq.ch) {
					++var6;
				} else if (var10.b() == class_acq.aY) {
					++var5;
				} else if (var10.b() == class_acq.aM) {
					++var3;
				} else if (var10.b() == class_acq.aV) {
					++var7;
				} else if (var10.b() == class_acq.k) {
					++var7;
				} else if (var10.b() == class_acq.bQ) {
					++var8;
				} else if (var10.b() == class_acq.I) {
					++var8;
				} else if (var10.b() == class_acq.bz) {
					++var8;
				} else {
					if (var10.b() != class_acq.cc) {
						return false;
					}

					++var8;
				}
			}
		}

		var7 += var5 + var8;
		if ((var4 <= 3) && (var3 <= 1)) {
			class_dn var16;
			class_dn var19;
			if ((var4 >= 1) && (var3 == 1) && (var7 == 0)) {
				a = new class_aco(class_acq.cg);
				if (var6 > 0) {
					var16 = new class_dn();
					var19 = new class_dn();
					class_du var25 = new class_du();

					for (int var22 = 0; var22 < var1.n_(); ++var22) {
						class_aco var26 = var1.a(var22);
						if ((var26 != null) && (var26.b() == class_acq.ch) && var26.n() && var26.o().b("Explosion", 10)) {
							var25.a(var26.o().o("Explosion"));
						}
					}

					var19.a("Explosions", var25);
					var19.a("Flight", (byte) var4);
					var16.a("Fireworks", var19);
					a.d(var16);
				}

				return true;
			} else if ((var4 == 1) && (var3 == 0) && (var6 == 0) && (var5 > 0) && (var8 <= 1)) {
				a = new class_aco(class_acq.ch);
				var16 = new class_dn();
				var19 = new class_dn();
				byte var23 = 0;
				ArrayList var12 = Lists.newArrayList();

				for (int var13 = 0; var13 < var1.n_(); ++var13) {
					class_aco var14 = var1.a(var13);
					if (var14 != null) {
						if (var14.b() == class_acq.aY) {
							var12.add(Integer.valueOf(class_abu.a[var14.i() & 15]));
						} else if (var14.b() == class_acq.aV) {
							var19.a("Flicker", true);
						} else if (var14.b() == class_acq.k) {
							var19.a("Trail", true);
						} else if (var14.b() == class_acq.bQ) {
							var23 = 1;
						} else if (var14.b() == class_acq.I) {
							var23 = 4;
						} else if (var14.b() == class_acq.bz) {
							var23 = 2;
						} else if (var14.b() == class_acq.cc) {
							var23 = 3;
						}
					}
				}

				int[] var24 = new int[var12.size()];

				for (int var27 = 0; var27 < var24.length; ++var27) {
					var24[var27] = ((Integer) var12.get(var27)).intValue();
				}

				var19.a("Colors", var24);
				var19.a("Type", var23);
				var16.a("Explosion", var19);
				a.d(var16);
				return true;
			} else if ((var4 == 0) && (var3 == 0) && (var6 == 1) && (var5 > 0) && (var5 == var7)) {
				ArrayList var15 = Lists.newArrayList();

				for (int var17 = 0; var17 < var1.n_(); ++var17) {
					class_aco var11 = var1.a(var17);
					if (var11 != null) {
						if (var11.b() == class_acq.aY) {
							var15.add(Integer.valueOf(class_abu.a[var11.i() & 15]));
						} else if (var11.b() == class_acq.ch) {
							a = var11.k();
							a.b = 1;
						}
					}
				}

				int[] var18 = new int[var15.size()];

				for (int var20 = 0; var20 < var18.length; ++var20) {
					var18[var20] = ((Integer) var15.get(var20)).intValue();
				}

				if ((a != null) && a.n()) {
					class_dn var21 = a.o().o("Explosion");
					if (var21 == null) {
						return false;
					} else {
						var21.a("FadeColors", var18);
						return true;
					}
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	public class_aco a(class_aab var1) {
		return a.k();
	}

	@Override
	public int a() {
		return 10;
	}

	@Override
	public class_aco b() {
		return a;
	}

	@Override
	public class_aco[] b(class_aab var1) {
		class_aco[] var2 = new class_aco[var1.n_()];

		for (int var3 = 0; var3 < var2.length; ++var3) {
			class_aco var4 = var1.a(var3);
			if ((var4 != null) && var4.b().r()) {
				var2[var3] = new class_aco(var4.b().q());
			}
		}

		return var2;
	}
}
