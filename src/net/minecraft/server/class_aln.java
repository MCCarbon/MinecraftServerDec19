package net.minecraft.server;

import java.util.Random;

public class class_aln extends BlockPlant {
	public static final class_aqb a = class_aqb.a("age", 0, 3);

	protected class_aln() {
		super(class_avq.k, class_avr.D);
		this.j(M.b().a(a, Integer.valueOf(0)));
		this.a(true);
		float var1 = 0.5F;
		this.a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, 0.25F, 0.5F + var1);
		this.a((class_abp) null);
	}

	@Override
	protected boolean c(Block var1) {
		return var1 == Blocks.SOUL_SAND;
	}

	@Override
	public boolean g(class_ago var1, class_cj var2, class_apn var3) {
		return this.c(var1.p(var2.b()).c());
	}

	@Override
	public void b(class_ago var1, class_cj var2, class_apn var3, Random var4) {
		int var5 = ((Integer) var3.b(a)).intValue();
		if ((var5 < 3) && (var4.nextInt(10) == 0)) {
			var3 = var3.a(a, Integer.valueOf(var5 + 1));
			var1.a(var2, var3, 2);
		}

		super.b(var1, var2, var3, var4);
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, float var4, int var5) {
		if (!var1.D) {
			int var6 = 1;
			if (((Integer) var3.b(a)).intValue() >= 3) {
				var6 = 2 + var1.s.nextInt(3);
				if (var5 > 0) {
					var6 += var1.s.nextInt(var5 + 1);
				}
			}

			for (int var7 = 0; var7 < var6; ++var7) {
				a(var1, var2, new class_aco(Items.bA));
			}

		}
	}

	@Override
	public Item a(class_apn var1, Random var2, int var3) {
		return null;
	}

	@Override
	public int a(Random var1) {
		return 0;
	}

	@Override
	public class_aco b(class_ago var1, class_cj var2, class_apn var3) {
		return new class_aco(Items.bA);
	}

	@Override
	public class_apn a(int var1) {
		return getBlockData().a(a, Integer.valueOf(var1));
	}

	@Override
	public int c(class_apn var1) {
		return ((Integer) var1.b(a)).intValue();
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { a });
	}
}
