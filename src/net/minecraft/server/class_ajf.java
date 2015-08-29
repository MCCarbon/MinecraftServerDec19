package net.minecraft.server;

import java.util.Random;

public class class_ajf extends BlockPlant implements class_ain {
	public static final class_aqb b = class_aqb.a("age", 0, 7);

	protected class_ajf() {
		this.j(M.b().a(l(), Integer.valueOf(0)));
		this.a(true);
		float var1 = 0.5F;
		this.a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, 0.25F, 0.5F + var1);
		this.a((class_abp) null);
		this.c(0.0F);
		this.a(h);
		M();
	}

	@Override
	protected boolean c(Block var1) {
		return var1 == Blocks.FARMLAND;
	}

	protected class_aqb l() {
		return b;
	}

	public int n() {
		return 7;
	}

	protected int d(class_apn var1) {
		return ((Integer) var1.b(l())).intValue();
	}

	public class_apn b(int var1) {
		return getBlockData().a(l(), Integer.valueOf(var1));
	}

	public boolean e(class_apn var1) {
		return ((Integer) var1.b(l())).intValue() >= n();
	}

	@Override
	public void b(class_ago var1, class_cj var2, class_apn var3, Random var4) {
		super.b(var1, var2, var3, var4);
		if (var1.l(var2.a()) >= 9) {
			int var5 = this.d(var3);
			if (var5 < n()) {
				float var6 = a(this, var1, var2);
				if (var4.nextInt((int) (25.0F / var6) + 1) == 0) {
					var1.a(var2, this.b(var5 + 1), 2);
				}
			}
		}

	}

	public void h(class_ago var1, class_cj var2, class_apn var3) {
		int var4 = this.d(var3) + this.b(var1);
		int var5 = n();
		if (var4 > var5) {
			var4 = var5;
		}

		var1.a(var2, this.b(var4), 2);
	}

	protected int b(class_ago var1) {
		return MathHelper.a(var1.s, 2, 5);
	}

	protected static float a(Block var0, class_ago var1, class_cj var2) {
		float var3 = 1.0F;
		class_cj var4 = var2.b();

		for (int var5 = -1; var5 <= 1; ++var5) {
			for (int var6 = -1; var6 <= 1; ++var6) {
				float var7 = 0.0F;
				class_apn var8 = var1.p(var4.a(var5, 0, var6));
				if (var8.c() == Blocks.FARMLAND) {
					var7 = 1.0F;
					if (((Integer) var8.b(class_aka.a)).intValue() > 0) {
						var7 = 3.0F;
					}
				}

				if ((var5 != 0) || (var6 != 0)) {
					var7 /= 4.0F;
				}

				var3 += var7;
			}
		}

		class_cj var12 = var2.c();
		class_cj var13 = var2.d();
		class_cj var15 = var2.e();
		class_cj var14 = var2.f();
		boolean var9 = (var0 == var1.p(var15).c()) || (var0 == var1.p(var14).c());
		boolean var10 = (var0 == var1.p(var12).c()) || (var0 == var1.p(var13).c());
		if (var9 && var10) {
			var3 /= 2.0F;
		} else {
			boolean var11 = (var0 == var1.p(var15.c()).c()) || (var0 == var1.p(var14.c()).c()) || (var0 == var1.p(var14.d()).c()) || (var0 == var1.p(var15.d()).c());
			if (var11) {
				var3 /= 2.0F;
			}
		}

		return var3;
	}

	@Override
	public boolean g(class_ago var1, class_cj var2, class_apn var3) {
		return ((var1.k(var2) >= 8) || var1.i(var2)) && this.c(var1.p(var2.b()).c());
	}

	protected Item o() {
		return Items.P;
	}

	protected Item p() {
		return Items.Q;
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, float var4, int var5) {
		super.a(var1, var2, var3, var4, 0);
		if (!var1.D) {
			int var6 = this.d(var3);
			if (var6 >= n()) {
				int var7 = 3 + var5;

				for (int var8 = 0; var8 < var7; ++var8) {
					if (var1.s.nextInt(15) <= var6) {
						a(var1, var2, new class_aco(o()));
					}
				}
			}

		}
	}

	@Override
	public Item a(class_apn var1, Random var2, int var3) {
		return this.e(var1) ? p() : o();
	}

	@Override
	public class_aco b(class_ago var1, class_cj var2, class_apn var3) {
		return new class_aco(o());
	}

	@Override
	public boolean a(class_ago var1, class_cj var2, class_apn var3, boolean var4) {
		return !this.e(var3);
	}

	@Override
	public boolean a(class_ago var1, Random var2, class_cj var3, class_apn var4) {
		return true;
	}

	@Override
	public void b(class_ago var1, Random var2, class_cj var3, class_apn var4) {
		h(var1, var3, var4);
	}

	@Override
	public class_apn a(int var1) {
		return this.b(var1);
	}

	@Override
	public int c(class_apn var1) {
		return this.d(var1);
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { b });
	}
}
