package net.minecraft.server;

import java.util.Random;

public class class_aml extends class_ail {
	private final boolean a;

	public class_aml(boolean var1) {
		super(class_avq.e);
		if (var1) {
			this.a(true);
		}

		a = var1;
	}

	@Override
	public int a(class_ago var1) {
		return 30;
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_yu var3) {
		this.d(var1, var2);
		super.a(var1, var2, var3);
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_qx var3) {
		this.d(var1, var2);
		super.a(var1, var2, var3);
	}

	@Override
	public boolean a(class_ago var1, class_cj var2, class_apn var3, class_yu var4, class_pu var5, class_aco var6, class_cq var7, float var8, float var9, float var10) {
		this.d(var1, var2);
		return super.a(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10);
	}

	private void d(class_ago var1, class_cj var2) {
		this.e(var1, var2);
		if (this == class_aim.aC) {
			var1.a(var2, class_aim.aD.S());
		}

	}

	@Override
	public void b(class_ago var1, class_cj var2, class_apn var3, Random var4) {
		if (this == class_aim.aD) {
			var1.a(var2, class_aim.aC.S());
		}

	}

	@Override
	public class_acm a(class_apn var1, Random var2, int var3) {
		return class_acq.aE;
	}

	@Override
	public int a(int var1, Random var2) {
		return this.a(var2) + var2.nextInt(var1 + 1);
	}

	@Override
	public int a(Random var1) {
		return 4 + var1.nextInt(2);
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, float var4, int var5) {
		super.a(var1, var2, var3, var4, var5);
		if (this.a(var3, var1.s, var5) != class_acm.a(this)) {
			int var6 = 1 + var1.s.nextInt(5);
			this.b(var1, var2, var6);
		}

	}

	private void e(class_ago var1, class_cj var2) {
		Random var3 = var1.s;
		double var4 = 0.0625D;

		for (int var6 = 0; var6 < 6; ++var6) {
			double var7 = var2.n() + var3.nextFloat();
			double var9 = var2.o() + var3.nextFloat();
			double var11 = var2.p() + var3.nextFloat();
			if ((var6 == 0) && !var1.p(var2.a()).c().c()) {
				var9 = var2.o() + var4 + 1.0D;
			}

			if ((var6 == 1) && !var1.p(var2.b()).c().c()) {
				var9 = var2.o() - var4;
			}

			if ((var6 == 2) && !var1.p(var2.d()).c().c()) {
				var11 = var2.p() + var4 + 1.0D;
			}

			if ((var6 == 3) && !var1.p(var2.c()).c().c()) {
				var11 = var2.p() - var4;
			}

			if ((var6 == 4) && !var1.p(var2.f()).c().c()) {
				var7 = var2.n() + var4 + 1.0D;
			}

			if ((var6 == 5) && !var1.p(var2.e()).c().c()) {
				var7 = var2.n() - var4;
			}

			if ((var7 < var2.n()) || (var7 > var2.n() + 1) || (var9 < 0.0D) || (var9 > var2.o() + 1) || (var11 < var2.p()) || (var11 > var2.p() + 1)) {
				var1.a(class_cy.E, var7, var9, var11, 0.0D, 0.0D, 0.0D, new int[0]);
			}
		}

	}

	@Override
	protected class_aco i(class_apn var1) {
		return new class_aco(class_aim.aC);
	}
}
