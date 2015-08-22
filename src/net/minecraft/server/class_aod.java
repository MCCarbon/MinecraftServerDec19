package net.minecraft.server;

import java.util.Random;

public abstract class class_aod extends class_akq {
	public static final class_aqa b = class_aqa.a("variant", class_aly.class_a_in_class_aly.class);

	public class_aod() {
		super(class_avq.d);
		class_apn var1 = M.b();
		if (!l()) {
			var1 = var1.a(a, class_akq.class_a_in_class_akq.b);
		}

		this.j(var1.a(b, class_aly.class_a_in_class_aly.a));
		this.a(class_abp.b);
	}

	@Override
	public class_avr g(class_apn var1) {
		return ((class_aly.class_a_in_class_aly) var1.b(b)).c();
	}

	@Override
	public class_acm a(class_apn var1, Random var2, int var3) {
		return class_acm.a(class_aim.bM);
	}

	@Override
	public class_aco b(class_ago var1, class_cj var2, class_apn var3) {
		return new class_aco(class_aim.bM, 1, ((class_aly.class_a_in_class_aly) var3.b(b)).a());
	}

	@Override
	public String b(int var1) {
		return super.a() + "." + class_aly.class_a_in_class_aly.a(var1).d();
	}

	@Override
	public class_aqc n() {
		return b;
	}

	@Override
	public Object a(class_aco var1) {
		return class_aly.class_a_in_class_aly.a(var1.i() & 7);
	}

	@Override
	public class_apn a(int var1) {
		class_apn var2 = S().a(b, class_aly.class_a_in_class_aly.a(var1 & 7));
		if (!l()) {
			var2 = var2.a(a, (var1 & 8) == 0 ? class_akq.class_a_in_class_akq.b : class_akq.class_a_in_class_akq.a);
		}

		return var2;
	}

	@Override
	public int c(class_apn var1) {
		byte var2 = 0;
		int var3 = var2 | ((class_aly.class_a_in_class_aly) var1.b(b)).a();
		if (!l() && (var1.b(a) == class_akq.class_a_in_class_akq.a)) {
			var3 |= 8;
		}

		return var3;
	}

	@Override
	protected class_apo e() {
		return l() ? new class_apo(this, new class_aqc[] { b }) : new class_apo(this, new class_aqc[] { a, b });
	}

	@Override
	public int a(class_apn var1) {
		return ((class_aly.class_a_in_class_aly) var1.b(b)).a();
	}
}
