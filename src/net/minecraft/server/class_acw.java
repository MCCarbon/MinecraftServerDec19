package net.minecraft.server;


public class class_acw extends Item {
	private static final class_cr a = new class_cn() {
		private final class_cn b = new class_cn();

		@Override
		public class_aco b(class_ck var1, class_aco var2) {
			class_cq var3 = class_ajm.b(var1.f());
			class_ago var4 = var1.i();
			double var5 = var1.a() + (var3.g() * 1.125D);
			double var7 = Math.floor(var1.b()) + var3.h();
			double var9 = var1.c() + (var3.i() * 1.125D);
			class_cj var11 = var1.d().a(var3);
			class_apn var12 = var4.p(var11);
			class_aih.class_b_in_class_aih var13 = var12.c() instanceof class_aih ? (class_aih.class_b_in_class_aih) var12.b(((class_aih) var12.c()).n()) : class_aih.class_b_in_class_aih.a;
			double var14;
			if (class_aih.d(var12)) {
				if (var13.c()) {
					var14 = 0.6D;
				} else {
					var14 = 0.1D;
				}
			} else {
				if ((var12.c().v() != class_avq.a) || !class_aih.d(var4.p(var11.b()))) {
					return b.a(var1, var2);
				}

				class_apn var16 = var4.p(var11.b());
				class_aih.class_b_in_class_aih var17 = var16.c() instanceof class_aih ? (class_aih.class_b_in_class_aih) var16.b(((class_aih) var16.c()).n()) : class_aih.class_b_in_class_aih.a;
				if ((var3 != class_cq.a) && var17.c()) {
					var14 = -0.4D;
				} else {
					var14 = -0.9D;
				}
			}

			EntityMinecartAbstract var18 = EntityMinecartAbstract.a(var4, var5, var7 + var14, var9, ((class_acw) var2.b()).b);
			if (var2.s()) {
				var18.c(var2.q());
			}

			var4.a(var18);
			var2.a(1);
			return var2;
		}

		@Override
		protected void a(class_ck var1) {
			var1.i().b(1000, var1.d(), 0);
		}
	};
	private final EntityMinecartAbstract.EnumMinecartType b;

	public class_acw(EntityMinecartAbstract.EnumMinecartType var1) {
		i = 1;
		b = var1;
		this.a(class_abp.e);
		class_ajm.N.a(this, a);
	}

	@Override
	public class_pw a(class_aco var1, class_yu var2, class_ago var3, class_cj var4, class_pu var5, class_cq var6, float var7, float var8, float var9) {
		class_apn var10 = var3.p(var4);
		if (!class_aih.d(var10)) {
			return class_pw.c;
		} else {
			if (!var3.D) {
				class_aih.class_b_in_class_aih var11 = var10.c() instanceof class_aih ? (class_aih.class_b_in_class_aih) var10.b(((class_aih) var10.c()).n()) : class_aih.class_b_in_class_aih.a;
				double var12 = 0.0D;
				if (var11.c()) {
					var12 = 0.5D;
				}

				EntityMinecartAbstract var14 = EntityMinecartAbstract.a(var3, var4.n() + 0.5D, var4.o() + 0.0625D + var12, var4.p() + 0.5D, b);
				if (var1.s()) {
					var14.c(var1.q());
				}

				var3.a(var14);
			}

			--var1.b;
			return class_pw.a;
		}
	}
}
