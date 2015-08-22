package net.minecraft.server;

import java.util.Iterator;
import java.util.Random;

public class class_ais extends class_ail {
	public static final class_aqb a = class_aqb.a("age", 0, 15);

	protected class_ais() {
		super(class_avq.A);
		this.j(M.b().a(a, Integer.valueOf(0)));
		this.a(true);
		this.a(class_abp.c);
	}

	@Override
	public void b(class_ago var1, class_cj var2, class_apn var3, Random var4) {
		class_cj var5 = var2.a();
		if (var1.d(var5)) {
			int var6;
			for (var6 = 1; var1.p(var2.c(var6)).c() == this; ++var6) {
				;
			}

			if (var6 < 3) {
				int var7 = ((Integer) var3.b(a)).intValue();
				if (var7 == 15) {
					var1.a(var5, S());
					class_apn var8 = var3.a(a, Integer.valueOf(0));
					var1.a(var2, var8, 4);
					this.a(var1, var5, var8, this);
				} else {
					var1.a(var2, var3.a(a, Integer.valueOf(var7 + 1)), 4);
				}

			}
		}
	}

	@Override
	public class_ayk a(class_ago var1, class_cj var2, class_apn var3) {
		float var4 = 0.0625F;
		return new class_ayk(var2.n() + var4, var2.o(), var2.p() + var4, var2.n() + 1 - var4, var2.o() + 1 - var4, var2.p() + 1 - var4);
	}

	@Override
	public boolean d() {
		return false;
	}

	@Override
	public boolean c() {
		return false;
	}

	@Override
	public boolean c(class_ago var1, class_cj var2) {
		return super.c(var1, var2) ? this.d(var1, var2) : false;
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, class_ail var4) {
		if (!this.d(var1, var2)) {
			var1.b(var2, true);
		}

	}

	public boolean d(class_ago var1, class_cj var2) {
		Iterator var3 = class_cq.class_c_in_class_cq.a.iterator();

		while (var3.hasNext()) {
			class_cq var4 = (class_cq) var3.next();
			if (var1.p(var2.a(var4)).c().v().a()) {
				return false;
			}
		}

		class_ail var5 = var1.p(var2.b()).c();
		return (var5 == class_aim.aK) || (var5 == class_aim.m);
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, class_qx var4) {
		var4.a(class_qi.h, 1.0F);
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
