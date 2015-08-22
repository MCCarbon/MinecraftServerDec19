package net.minecraft.server;

import java.util.Iterator;
import java.util.Random;

public class class_aka extends class_ail {
	public static final class_aqb a = class_aqb.a("moisture", 0, 7);

	protected class_aka() {
		super(class_avq.c);
		this.j(M.b().a(a, Integer.valueOf(0)));
		this.a(true);
		this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.9375F, 1.0F);
		this.e(255);
	}

	@Override
	public class_ayk a(class_ago var1, class_cj var2, class_apn var3) {
		return new class_ayk(var2.n(), var2.o(), var2.p(), var2.n() + 1, var2.o() + 1, var2.p() + 1);
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
	public void b(class_ago var1, class_cj var2, class_apn var3, Random var4) {
		int var5 = ((Integer) var3.b(a)).intValue();
		if (!this.e(var1, var2) && !var1.C(var2.a())) {
			if (var5 > 0) {
				var1.a(var2, var3.a(a, Integer.valueOf(var5 - 1)), 2);
			} else if (!this.d(var1, var2)) {
				var1.a(var2, class_aim.d.S());
			}
		} else if (var5 < 7) {
			var1.a(var2, var3.a(a, Integer.valueOf(7)), 2);
		}

	}

	@Override
	public void a(class_ago var1, class_cj var2, class_qx var3, float var4) {
		if (var3 instanceof class_rg) {
			if (!var1.D && (var1.s.nextFloat() < (var4 - 0.5F))) {
				if (!(var3 instanceof class_yu) && !var1.S().b("mobGriefing")) {
					return;
				}

				var1.a(var2, class_aim.d.S());
			}

			super.a(var1, var2, var3, var4);
		}
	}

	private boolean d(class_ago var1, class_cj var2) {
		class_ail var3 = var1.p(var2.a()).c();
		return (var3 instanceof class_ajf) || (var3 instanceof class_ani);
	}

	private boolean e(class_ago var1, class_cj var2) {
		Iterator var3 = class_cj.b(var2.a(-4, 0, -4), var2.a(4, 1, 4)).iterator();

		class_cj.class_a_in_class_cj var4;
		do {
			if (!var3.hasNext()) {
				return false;
			}

			var4 = (class_cj.class_a_in_class_cj) var3.next();
		} while (var1.p(var4).c().v() != class_avq.h);

		return true;
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, class_ail var4) {
		super.a(var1, var2, var3, var4);
		if (var1.p(var2.a()).c().v().a()) {
			var1.a(var2, class_aim.d.S());
		}

	}

	@Override
	public class_acm a(class_apn var1, Random var2, int var3) {
		return class_aim.d.a(class_aim.d.S().a(class_ajl.a, class_ajl.class_a_in_class_ajl.a), var2, var3);
	}

	@Override
	public class_aco b(class_ago var1, class_cj var2, class_apn var3) {
		return new class_aco(class_aim.d);
	}

	@Override
	public class_apn a(int var1) {
		return S().a(a, Integer.valueOf(var1 & 7));
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
