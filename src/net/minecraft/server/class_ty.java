package net.minecraft.server;


public class class_ty extends class_su {
	private int e;
	private class_yp f;

	public class_ty(class_yp var1) {
		super(var1, class_yp.class, 3.0F, 0.02F);
		f = var1;
	}

	@Override
	public void c() {
		super.c();
		if (f.cL() && (b instanceof class_yp) && ((class_yp) b).cM()) {
			e = 10;
		} else {
			e = 0;
		}

	}

	@Override
	public void e() {
		super.e();
		if (e > 0) {
			--e;
			if (e == 0) {
				class_qc var1 = f.cJ();

				for (int var2 = 0; var2 < var1.n_(); ++var2) {
					class_aco var3 = var1.a(var2);
					class_aco var4 = null;
					if (var3 != null) {
						Item var5 = var3.b();
						int var6;
						if (((var5 == Items.R) || (var5 == Items.bX) || (var5 == Items.bW)) && (var3.b > 3)) {
							var6 = var3.b / 2;
							var3.b -= var6;
							var4 = new class_aco(var5, var6, var3.i());
						} else if ((var5 == Items.Q) && (var3.b > 5)) {
							var6 = (var3.b / 2 / 3) * 3;
							int var7 = var6 / 3;
							var3.b -= var6;
							var4 = new class_aco(Items.R, var7, 0);
						}

						if (var3.b <= 0) {
							var1.a(var2, (class_aco) null);
						}
					}

					if (var4 != null) {
						double var11 = (f.t - 0.30000001192092896D) + f.aY();
						class_xg var12 = new class_xg(f.o, f.s, var11, f.u, var4);
						float var8 = 0.3F;
						float var9 = f.aO;
						float var10 = f.z;
						var12.v = -class_oa.a((var9 / 180.0F) * 3.1415927F) * class_oa.b((var10 / 180.0F) * 3.1415927F) * var8;
						var12.x = class_oa.b((var9 / 180.0F) * 3.1415927F) * class_oa.b((var10 / 180.0F) * 3.1415927F) * var8;
						var12.w = (-class_oa.a((var10 / 180.0F) * 3.1415927F) * var8) + 0.1F;
						var12.o();
						f.o.a(var12);
						break;
					}
				}
			}
		}

	}
}
