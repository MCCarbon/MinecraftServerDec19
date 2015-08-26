package net.minecraft.server;


public class class_adp extends class_abb {
	private final BlockStepAbstract b;
	private final BlockStepAbstract c;

	public class_adp(Block var1, BlockStepAbstract var2, BlockStepAbstract var3) {
		super(var1);
		b = var2;
		c = var3;
		this.e(0);
		this.a(true);
	}

	@Override
	public int a(int var1) {
		return var1;
	}

	@Override
	public String e_(class_aco var1) {
		return b.b(var1.i());
	}

	@Override
	public class_pw a(class_aco var1, class_yu var2, class_ago var3, class_cj var4, class_pu var5, class_cq var6, float var7, float var8, float var9) {
		if ((var1.b != 0) && var2.a(var4.a(var6), var6, var1)) {
			Object var10 = b.a(var1);
			class_apn var11 = var3.p(var4);
			if (var11.c() == b) {
				class_aqc var12 = b.n();
				Comparable var13 = var11.b(var12);
				BlockStepAbstract.class_a_in_class_akq var14 = (BlockStepAbstract.class_a_in_class_akq) var11.b(BlockStepAbstract.a);
				if ((((var6 == class_cq.b) && (var14 == BlockStepAbstract.class_a_in_class_akq.b)) || ((var6 == class_cq.a) && (var14 == BlockStepAbstract.class_a_in_class_akq.a))) && (var13 == var10)) {
					class_apn var15 = c.S().a(var12, var13);
					if (var3.b(c.a(var3, var4, var15)) && var3.a(var4, var15, 3)) {
						var3.a(var4.n() + 0.5F, var4.o() + 0.5F, var4.p() + 0.5F, c.H.b(), (c.H.d() + 1.0F) / 2.0F, c.H.e() * 0.8F);
						--var1.b;
					}

					return class_pw.a;
				}
			}

			return this.a(var1, var3, var4.a(var6), var10) ? class_pw.a : super.a(var1, var2, var3, var4, var5, var6, var7, var8, var9);
		} else {
			return class_pw.c;
		}
	}

	private boolean a(class_aco var1, class_ago var2, class_cj var3, Object var4) {
		class_apn var5 = var2.p(var3);
		if (var5.c() == b) {
			Comparable var6 = var5.b(b.n());
			if (var6 == var4) {
				class_apn var7 = c.S().a(b.n(), var6);
				if (var2.b(c.a(var2, var3, var7)) && var2.a(var3, var7, 3)) {
					var2.a(var3.n() + 0.5F, var3.o() + 0.5F, var3.p() + 0.5F, c.H.b(), (c.H.d() + 1.0F) / 2.0F, c.H.e() * 0.8F);
					--var1.b;
				}

				return true;
			}
		}

		return false;
	}
}
