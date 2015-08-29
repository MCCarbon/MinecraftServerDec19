package net.minecraft.server;


public class class_abg extends Item {
	public class_abg() {
		i = 1;
		this.e(384);
		this.a(class_abp.j);
		this.a(new class_ke("pull"), new class_acp() {
		});
		this.a(new class_ke("pulling"), new class_acp() {
		});
	}

	private int a(class_yt var1) {
		if (g_(var1.a(40))) {
			return 40;
		} else {
			for (int var2 = 0; var2 < var1.n_(); ++var2) {
				class_aco var3 = var1.a(var2);
				if (g_(var3)) {
					return var2;
				}
			}

			return -1;
		}
	}

	protected boolean g_(class_aco var1) {
		return (var1 != null) && (var1.b() instanceof class_aax);
	}

	@Override
	public void a(class_aco var1, class_ago var2, EntityLiving var3, int var4) {
		if (var3 instanceof class_yu) {
			class_yu var5 = (class_yu) var3;
			boolean var6 = var5.bI.d || (class_afl.a(class_afn.w, var1) > 0);
			int var7 = this.a(var5.bq);
			if (var6 || (var7 > -1)) {
				class_aco var8 = var7 > -1 ? var5.bq.a(var7) : null;
				if (var8 == null) {
					var8 = new class_aco(Items.g);
				}

				class_aax var9 = ((class_aax) (var8.b() instanceof class_aax ? var8.b() : Items.g));
				int var10 = this.e(var1) - var4;
				float var11 = b(var10);
				if (var11 >= 0.1D) {
					EntityArrow var12 = var9.a(var2, var8, var5);
					var12.a(var5.z, var5.y, 0.0F, var11 * 3.0F, 1.0F);
					if (var11 == 1.0F) {
						var12.a(true);
					}

					int var13 = class_afl.a(class_afn.t, var1);
					if (var13 > 0) {
						var12.b(var12.j() + (var13 * 0.5D) + 0.5D);
					}

					int var14 = class_afl.a(class_afn.u, var1);
					if (var14 > 0) {
						var12.a(var14);
					}

					if (class_afl.a(class_afn.v, var1) > 0) {
						var12.e(100);
					}

					var1.a(1, var5);
					var2.a((Entity) var5, "random.bow", 1.0F, (1.0F / ((h.nextFloat() * 0.4F) + 1.2F)) + (var11 * 0.5F));
					if (var6) {
						var12.c = 2;
					} else {
						var5.bq.a(var7, 1);
					}

					var5.b(StatisticList.c(Item.b(this)));
					if (!var2.D) {
						var2.a(var12);
					}

				}
			}
		}
	}

	public static float b(int var0) {
		float var1 = var0 / 20.0F;
		var1 = ((var1 * var1) + (var1 * 2.0F)) / 3.0F;
		if (var1 > 1.0F) {
			var1 = 1.0F;
		}

		return var1;
	}

	@Override
	public int e(class_aco var1) {
		return 72000;
	}

	@Override
	public class_ady f(class_aco var1) {
		return class_ady.e;
	}

	@Override
	public class_px a(class_aco var1, class_ago var2, class_yu var3, class_pu var4) {
		boolean var5 = this.a(var3.bq) > -1;
		if ((var3.bI.d || var5) && (var4 == class_pu.a)) {
			var3.c(var4);
			return new class_px(class_pw.a, var1);
		} else {
			return !var5 ? new class_px(class_pw.c, var1) : new class_px(class_pw.b, var1);
		}
	}

	@Override
	public int c() {
		return 1;
	}
}
