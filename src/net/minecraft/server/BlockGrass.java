package net.minecraft.server;

import java.util.Random;

public class BlockGrass extends Block implements class_ain {
	public static final class_apy a = class_apy.a("snowy");

	protected BlockGrass() {
		super(class_avq.b);
		this.j(M.b().a(a, Boolean.valueOf(false)));
		this.a(true);
		this.a(class_abp.b);
	}

	@Override
	public class_apn a(class_apn var1, class_ags var2, class_cj var3) {
		Block var4 = var2.p(var3.a()).c();
		return var1.a(a, Boolean.valueOf((var4 == Blocks.SNOW) || (var4 == Blocks.SNOW_LAYER)));
	}

	@Override
	public void b(class_ago var1, class_cj var2, class_apn var3, Random var4) {
		if (!var1.D) {
			if ((var1.l(var2.a()) < 4) && (var1.p(var2.a()).c().r() > 2)) {
				var1.a(var2, Blocks.DIRT.S());
			} else {
				if (var1.l(var2.a()) >= 9) {
					for (int var5 = 0; var5 < 4; ++var5) {
						class_cj var6 = var2.a(var4.nextInt(3) - 1, var4.nextInt(5) - 3, var4.nextInt(3) - 1);
						Block var7 = var1.p(var6.a()).c();
						class_apn var8 = var1.p(var6);
						if ((var8.c() == Blocks.DIRT) && (var8.b(class_ajl.a) == class_ajl.class_a_in_class_ajl.a) && (var1.l(var6.a()) >= 4) && (var7.r() <= 2)) {
							var1.a(var6, Blocks.GRASS.S());
						}
					}
				}

			}
		}
	}

	@Override
	public Item a(class_apn var1, Random var2, int var3) {
		return Blocks.DIRT.a(Blocks.DIRT.S().a(class_ajl.a, class_ajl.class_a_in_class_ajl.a), var2, var3);
	}

	@Override
	public boolean a(class_ago var1, class_cj var2, class_apn var3, boolean var4) {
		return true;
	}

	@Override
	public boolean a(class_ago var1, Random var2, class_cj var3, class_apn var4) {
		return true;
	}

	@Override
	public void b(class_ago var1, Random var2, class_cj var3, class_apn var4) {
		class_cj var5 = var3.a();

		label38: for (int var6 = 0; var6 < 128; ++var6) {
			class_cj var7 = var5;

			for (int var8 = 0; var8 < (var6 / 16); ++var8) {
				var7 = var7.a(var2.nextInt(3) - 1, ((var2.nextInt(3) - 1) * var2.nextInt(3)) / 2, var2.nextInt(3) - 1);
				if ((var1.p(var7.b()).c() != Blocks.GRASS) || var1.p(var7).c().x()) {
					continue label38;
				}
			}

			if (var1.p(var7).c().J == class_avq.a) {
				if (var2.nextInt(8) == 0) {
					BlockFlowers.class_a_in_class_ake var11 = var1.b(var7).a(var2, var7);
					BlockFlowers var9 = var11.a().a();
					class_apn var10 = var9.S().a(var9.n(), var11);
					if (var9.g(var1, var7, var10)) {
						var1.a(var7, var10, 3);
					}
				} else {
					class_apn var12 = Blocks.TALLGRASS.S().a(BlockLongGrass.a, BlockLongGrass.class_a_in_class_ano.b);
					if (Blocks.TALLGRASS.g(var1, var7, var12)) {
						var1.a(var7, var12, 3);
					}
				}
			}
		}

	}

	@Override
	public int c(class_apn var1) {
		return 0;
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { a });
	}
}
