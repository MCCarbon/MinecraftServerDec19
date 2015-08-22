package net.minecraft.server;

import java.util.Random;

public class class_all extends class_ail {
	public static final class_apy a = class_apy.a("snowy");

	protected class_all() {
		super(class_avq.b, class_avr.z);
		this.j(M.b().a(a, Boolean.valueOf(false)));
		this.a(true);
		this.a(class_abp.b);
	}

	@Override
	public class_apn a(class_apn var1, class_ags var2, class_cj var3) {
		class_ail var4 = var2.p(var3.a()).c();
		return var1.a(a, Boolean.valueOf((var4 == class_aim.aJ) || (var4 == class_aim.aH)));
	}

	@Override
	public void b(class_ago var1, class_cj var2, class_apn var3, Random var4) {
		if (!var1.D) {
			if ((var1.l(var2.a()) < 4) && (var1.p(var2.a()).c().r() > 2)) {
				var1.a(var2, class_aim.d.S().a(class_ajl.a, class_ajl.class_a_in_class_ajl.a));
			} else {
				if (var1.l(var2.a()) >= 9) {
					for (int var5 = 0; var5 < 4; ++var5) {
						class_cj var6 = var2.a(var4.nextInt(3) - 1, var4.nextInt(5) - 3, var4.nextInt(3) - 1);
						class_apn var7 = var1.p(var6);
						class_ail var8 = var1.p(var6.a()).c();
						if ((var7.c() == class_aim.d) && (var7.b(class_ajl.a) == class_ajl.class_a_in_class_ajl.a) && (var1.l(var6.a()) >= 4) && (var8.r() <= 2)) {
							var1.a(var6, S());
						}
					}
				}

			}
		}
	}

	@Override
	public class_acm a(class_apn var1, Random var2, int var3) {
		return class_aim.d.a(class_aim.d.S().a(class_ajl.a, class_ajl.class_a_in_class_ajl.a), var2, var3);
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
