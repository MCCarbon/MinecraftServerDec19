package net.minecraft.server;

import com.google.common.base.Predicate;

public class class_alp extends class_alc {
	public static final class_aqa P = class_aqa.a("variant", class_aly.class_a_in_class_aly.class, new Predicate() {
		public boolean a(class_aly.class_a_in_class_aly var1) {
			return var1.a() >= 4;
		}

		// $FF: synthetic method
		@Override
		public boolean apply(Object var1) {
			return this.a((class_aly.class_a_in_class_aly) var1);
		}
	});

	public class_alp() {
		this.j(M.b().a(P, class_aly.class_a_in_class_aly.e).a(b, Boolean.valueOf(true)).a(a, Boolean.valueOf(true)));
	}

	@Override
	protected void a(class_ago var1, class_cj var2, class_apn var3, int var4) {
		if ((var3.b(P) == class_aly.class_a_in_class_aly.f) && (var1.s.nextInt(var4) == 0)) {
			a(var1, var2, new class_aco(class_acq.e));
		}

	}

	@Override
	public int a(class_apn var1) {
		return ((class_aly.class_a_in_class_aly) var1.b(P)).a();
	}

	@Override
	public class_aco b(class_ago var1, class_cj var2, class_apn var3) {
		return new class_aco(this, var3.c().c(var3) & 3);
	}

	@Override
	protected class_aco i(class_apn var1) {
		return new class_aco(class_acm.a(this), 1, ((class_aly.class_a_in_class_aly) var1.b(P)).a() - 4);
	}

	@Override
	public class_apn a(int var1) {
		return S().a(P, this.b(var1)).a(a, Boolean.valueOf((var1 & 4) == 0)).a(b, Boolean.valueOf((var1 & 8) > 0));
	}

	@Override
	public int c(class_apn var1) {
		byte var2 = 0;
		int var3 = var2 | (((class_aly.class_a_in_class_aly) var1.b(P)).a() - 4);
		if (!((Boolean) var1.b(a)).booleanValue()) {
			var3 |= 4;
		}

		if (((Boolean) var1.b(b)).booleanValue()) {
			var3 |= 8;
		}

		return var3;
	}

	@Override
	public class_aly.class_a_in_class_aly b(int var1) {
		return class_aly.class_a_in_class_aly.a((var1 & 3) + 4);
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { P, b, a });
	}

	@Override
	public void a(class_ago var1, class_yu var2, class_cj var3, class_apn var4, class_aoi var5, class_aco var6) {
		if (!var1.D && (var6 != null) && (var6.b() == class_acq.bg)) {
			var2.b(class_nh.a(class_ail.a(this)));
			a(var1, var3, new class_aco(class_acm.a(this), 1, ((class_aly.class_a_in_class_aly) var4.b(P)).a() - 4));
		} else {
			super.a(var1, var2, var3, var4, var5, var6);
		}
	}
}
