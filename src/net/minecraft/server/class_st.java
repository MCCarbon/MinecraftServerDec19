package net.minecraft.server;


public class class_st extends class_tc {
	private final class_yp c;
	private boolean d;
	private boolean e;
	private int f;

	public class_st(class_yp var1, double var2) {
		super(var1, var2, 16);
		c = var1;
	}

	@Override
	public boolean a() {
		if (a <= 0) {
			if (!c.o.S().b("mobGriefing")) {
				return false;
			}

			f = -1;
			d = c.cN();
			e = c.cM();
		}

		return super.a();
	}

	@Override
	public boolean b() {
		return (f >= 0) && super.b();
	}

	@Override
	public void c() {
		super.c();
	}

	@Override
	public void d() {
		super.d();
	}

	@Override
	public void e() {
		super.e();
		c.q().a(b.n() + 0.5D, b.o() + 1, b.p() + 0.5D, 10.0F, c.ch());
		if (f()) {
			class_ago var1 = c.o;
			class_cj var2 = b.a();
			class_apn var3 = var1.p(var2);
			class_ail var4 = var3.c();
			if ((f == 0) && (var4 instanceof class_ajf) && ((class_ajf) var4).e(var3)) {
				var1.b(var2, true);
			} else if ((f == 1) && (var4 == class_aim.a)) {
				class_qc var5 = c.cJ();

				for (int var6 = 0; var6 < var5.n_(); ++var6) {
					class_aco var7 = var5.a(var6);
					boolean var8 = false;
					if (var7 != null) {
						if (var7.b() == class_acq.P) {
							var1.a(var2, class_aim.aj.S(), 3);
							var8 = true;
						} else if (var7.b() == class_acq.bX) {
							var1.a(var2, class_aim.cc.S(), 3);
							var8 = true;
						} else if (var7.b() == class_acq.bW) {
							var1.a(var2, class_aim.cb.S(), 3);
							var8 = true;
						}
					}

					if (var8) {
						--var7.b;
						if (var7.b <= 0) {
							var5.a(var6, (class_aco) null);
						}
						break;
					}
				}
			}

			f = -1;
			a = 10;
		}

	}

	@Override
	protected boolean a(class_ago var1, class_cj var2) {
		class_ail var3 = var1.p(var2).c();
		if (var3 == class_aim.ak) {
			var2 = var2.a();
			class_apn var4 = var1.p(var2);
			var3 = var4.c();
			if ((var3 instanceof class_ajf) && ((class_ajf) var3).e(var4) && e && ((f == 0) || (f < 0))) {
				f = 0;
				return true;
			}

			if ((var3 == class_aim.a) && d && ((f == 1) || (f < 0))) {
				f = 1;
				return true;
			}
		}

		return false;
	}
}
