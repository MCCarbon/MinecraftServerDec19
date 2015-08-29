package net.minecraft.server;

import java.util.Random;

public class class_ajp extends Block {
	public class_ajp() {
		super(class_avq.D, class_avr.E);
		this.a(0.0625F, 0.0F, 0.0625F, 0.9375F, 1.0F, 0.9375F);
	}

	@Override
	public void d(class_ago var1, class_cj var2, class_apn var3) {
		var1.a(var2, this, this.a(var1));
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, Block var4) {
		var1.a(var2, this, this.a(var1));
	}

	@Override
	public void b(class_ago var1, class_cj var2, class_apn var3, Random var4) {
		this.d(var1, var2);
	}

	private void d(class_ago var1, class_cj var2) {
		if (class_ajz.d(var1, var2.b()) && (var2.o() >= 0)) {
			byte var3 = 32;
			if (!class_ajz.N && var1.a(var2.a(-var3, -var3, -var3), var2.a(var3, var3, var3))) {
				var1.a((new EntityFallingBlock(var1, var2.n() + 0.5F, var2.o(), var2.p() + 0.5F, getBlockData())));
			} else {
				var1.g(var2);

				class_cj var4;
				for (var4 = var2; class_ajz.d(var1, var4) && (var4.o() > 0); var4 = var4.b()) {
					;
				}

				if (var4.o() > 0) {
					var1.a(var4, getBlockData(), 2);
				}
			}

		}
	}

	@Override
	public boolean a(class_ago var1, class_cj var2, class_apn var3, class_yu var4, class_pu var5, class_aco var6, class_cq var7, float var8, float var9, float var10) {
		this.e(var1, var2);
		return true;
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_yu var3) {
		this.e(var1, var2);
	}

	private void e(class_ago var1, class_cj var2) {
		class_apn var3 = var1.p(var2);
		if (var3.c() == this) {
			for (int var4 = 0; var4 < 1000; ++var4) {
				class_cj var5 = var2.a(var1.s.nextInt(16) - var1.s.nextInt(16), var1.s.nextInt(8) - var1.s.nextInt(8), var1.s.nextInt(16) - var1.s.nextInt(16));
				if (var1.p(var5).c().J == class_avq.a) {
					if (var1.D) {
						for (int var6 = 0; var6 < 128; ++var6) {
							double var7 = var1.s.nextDouble();
							float var9 = (var1.s.nextFloat() - 0.5F) * 0.2F;
							float var10 = (var1.s.nextFloat() - 0.5F) * 0.2F;
							float var11 = (var1.s.nextFloat() - 0.5F) * 0.2F;
							double var12 = var5.n() + ((var2.n() - var5.n()) * var7) + ((var1.s.nextDouble() - 0.5D) * 1.0D) + 0.5D;
							double var14 = (var5.o() + ((var2.o() - var5.o()) * var7) + (var1.s.nextDouble() * 1.0D)) - 0.5D;
							double var16 = var5.p() + ((var2.p() - var5.p()) * var7) + ((var1.s.nextDouble() - 0.5D) * 1.0D) + 0.5D;
							var1.a(class_cy.y, var12, var14, var16, var9, var10, var11, new int[0]);
						}
					} else {
						var1.a(var5, var3, 2);
						var1.g(var2);
					}

					return;
				}
			}

		}
	}

	@Override
	public int a(class_ago var1) {
		return 5;
	}

	@Override
	public boolean c() {
		return false;
	}

	@Override
	public boolean d() {
		return false;
	}

	@Override
	public class_aco b(class_ago var1, class_cj var2, class_apn var3) {
		return null;
	}
}
