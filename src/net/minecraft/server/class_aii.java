package net.minecraft.server;


public class class_aii extends class_aif {
	public class_aii() {
		super(class_avq.s, class_avr.G);
		this.c(3.0F);
		this.a(class_abp.f);
	}

	@Override
	public class_aoi a(class_ago var1, int var2) {
		return new class_aoh();
	}

	@Override
	public boolean a(class_ago var1, class_cj var2, class_apn var3, class_yu var4, class_pu var5, class_aco var6, class_cq var7, float var8, float var9, float var10) {
		if (var1.D) {
			return true;
		} else {
			class_aoi var11 = var1.s(var2);
			if (var11 instanceof class_aoh) {
				var4.a((class_pp) ((class_aoh) var11));
				var4.b(class_nh.O);
			}

			return true;
		}
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
	public int b() {
		return 3;
	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, class_rg var4, class_aco var5) {
		super.a(var1, var2, var3, var4, var5);
		if (var5.s()) {
			class_aoi var6 = var1.s(var2);
			if (var6 instanceof class_aoh) {
				((class_aoh) var6).a(var5.q());
			}
		}

	}

	@Override
	public void a(class_ago var1, class_cj var2, class_apn var3, class_ail var4) {
		class_aoi var5 = var1.s(var2);
		if (var5 instanceof class_aoh) {
			((class_aoh) var5).m();
			var1.c(var2, this, 1, 0);
		}

	}

	public static void e(final class_ago var0, final class_cj var1) {
		class_nr.a.submit(new Runnable() {
			@Override
			public void run() {
				class_aqn var1x = var0.f(var1);

				for (int var2 = var1.o() - 1; var2 >= 0; --var2) {
					final class_cj var3 = new class_cj(var1.n(), var2, var1.p());
					if (!var1x.d(var3)) {
						break;
					}

					class_apn var4 = var0.p(var3);
					if (var4.c() == class_aim.bY) {
						((class_ll) var0).a(new Runnable() {
							@Override
							public void run() {
								class_aoi var1x = var0.s(var3);
								if (var1x instanceof class_aoh) {
									((class_aoh) var1x).m();
									var0.c(var3, class_aim.bY, 1, 0);
								}

							}
						});
					}
				}

			}
		});
	}
}
