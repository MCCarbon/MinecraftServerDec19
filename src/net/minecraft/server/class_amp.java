package net.minecraft.server;

import java.util.Iterator;
import java.util.Random;

public class class_amp extends class_ail {
	public static final class_aqb a = class_aqb.a("age", 0, 15);

	protected class_amp() {
		super(class_avq.k);
		this.j(M.b().a(a, Integer.valueOf(0)));
		float var1 = 0.375F;
		this.a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, 1.0F, 0.5F + var1);
		this.a(true);
	}

	@Override
	public void b(class_ago var1, class_cj var2, class_apn var3, Random var4) {
		if ((var1.p(var2.b()).c() == class_aim.aM) || this.f(var1, var2, var3)) {
			if (var1.d(var2.a())) {
				int var5;
				for (var5 = 1; var1.p(var2.c(var5)).c() == this; ++var5) {
					;
				}

				if (var5 < 3) {
					int var6 = ((Integer) var3.b(a)).intValue();
					if (var6 == 15) {
						var1.a(var2.a(), S());
						var1.a(var2, var3.a(a, Integer.valueOf(0)), 4);
					} else {
						var1.a(var2, var3.a(a, Integer.valueOf(var6 + 1)), 4);
					}
				}
			}

		}
	}

	@Override
	public boolean c(class_ago var1, class_cj var2) {
		class_ail var3 = var1.p(var2.b()).c();
		if (var3 == this) {
			return true;
		} else if ((var3 != class_aim.c) && (var3 != class_aim.d) && (var3 != class_aim.m)) {
			return false;
		} else {
			Iterator var4 = class_cq.class_c_in_class_cq.a.iterator();

			class_cq var5;
			do {
				if (!var4.hasNext()) {
					return false;
				}

				var5 = (class_cq) var4.next();
			} while (var1.p(var2.a(var5).b()).c().v() != class_avq.h);

			return true;
		}
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, class_ail var4) {
		this.f(var1, var2, var3);
	}

	protected final boolean f(class_ago var1, class_cj var2, class_apn var3) {
		if (this.d(var1, var2)) {
			return true;
		} else {
			this.b(var1, var2, var3, 0);
			var1.g(var2);
			return false;
		}
	}

	public boolean d(class_ago var1, class_cj var2) {
		return this.c(var1, var2);
	}

	@Override
	public class_ayk a(class_ago var1, class_cj var2, class_apn var3) {
		return null;
	}

	@Override
	public class_acm a(class_apn var1, Random var2, int var3) {
		return class_acq.aL;
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
	public class_aco b(class_ago var1, class_cj var2, class_apn var3) {
		return new class_aco(class_acq.aL);
	}

	@Override
	public class_apn a(int var1) {
		return S().a(a, Integer.valueOf(var1));
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
