package net.minecraft.server;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_apc extends class_aoi implements class_ks {
	private static final Logger a = LogManager.getLogger();
	private long f = 0L;
	private int g = 0;
	private class_cj h;
	private boolean i;

	@Override
	public void b(class_dn var1) {
		super.b(var1);
		var1.a("Age", f);
		if (h != null) {
			var1.a("ExitPortal", class_dy.a(h));
		}

		if (i) {
			var1.a("ExactTeleport", i);
		}

	}

	@Override
	public void a(class_dn var1) {
		super.a(var1);
		f = var1.i("Age");
		if (var1.b("ExitPortal", 10)) {
			h = class_dy.c(var1.o("ExitPortal"));
		}

		i = var1.p("ExactTeleport");
	}

	@Override
	public void c() {
		boolean var1 = this.b();
		boolean var2 = d();
		++f;
		if (var2) {
			--g;
		} else if (!b.D) {
			List var3 = b.a(class_qx.class, new class_ayk(v()));
			if (!var3.isEmpty()) {
				this.a((class_qx) var3.get(0));
			}
		}

		if ((var1 != this.b()) || (var2 != d())) {
			o_();
		}

	}

	public boolean b() {
		return f < 200L;
	}

	public boolean d() {
		return g > 0;
	}

	@Override
	public class_ff x_() {
		class_dn var1 = new class_dn();
		this.b(var1);
		return new class_ft(c, 8, var1);
	}

	public void h() {
		if (!b.D) {
			g = 20;
			b.c(v(), w(), 1, 0);
			o_();
		}

	}

	@Override
	public boolean c(int var1, int var2) {
		if (var1 == 1) {
			g = 20;
			return true;
		} else {
			return super.c(var1, var2);
		}
	}

	public void a(class_qx var1) {
		if (!b.D && !d()) {
			g = 100;
			if ((h == null) && (b.t instanceof class_arh)) {
				k();
			}

			if (h != null) {
				class_cj var2 = i ? h : j();
				var1.a(var2.n() + 0.5D, var2.o() + 0.5D, var2.p() + 0.5D);
			}

			h();
		}
	}

	private class_cj j() {
		class_cj var1 = a(b, h, 5, false);
		a.debug("Best exit position for portal at " + h + " is " + var1);
		return var1.a();
	}

	private void k() {
		class_aym var1 = (new class_aym(v().n(), 0.0D, v().p())).a();
		class_aym var2 = var1.a(1024.0D);

		int var3;
		for (var3 = 16; (a(b, var2).g() > 0) && (var3-- > 0); var2 = var2.e(var1.a(-16.0D))) {
			a.debug("Skipping backwards past nonempty chunk at " + var2);
		}

		for (var3 = 16; (a(b, var2).g() == 0) && (var3-- > 0); var2 = var2.e(var1.a(16.0D))) {
			a.debug("Skipping forward past empty chunk at " + var2);
		}

		a.debug("Found chunk at " + var2);
		class_aqn var4 = a(b, var2);
		h = a(var4);
		if (h == null) {
			h = new class_cj(var2.a + 0.5D, 75.0D, var2.c + 0.5D);
			a.debug("Failed to find suitable block, settling on " + h);
			(new class_asn()).b(b, new Random(h.g()), h);
		} else {
			a.debug("Found block at " + h);
		}

		h = a(b, h, 16, true);
		a.debug("Creating portal at " + h);
		h = h.b(10);
		this.b(h);
		o_();
	}

	private static class_cj a(class_ago var0, class_cj var1, int var2, boolean var3) {
		class_cj var4 = null;

		for (int var5 = -var2; var5 <= var2; ++var5) {
			for (int var6 = -var2; var6 <= var2; ++var6) {
				if ((var5 != 0) || (var6 != 0) || var3) {
					for (int var7 = 255; var7 > (var4 == null ? 0 : var4.o()); --var7) {
						class_cj var8 = new class_cj(var1.n() + var5, var7, var1.p() + var6);
						class_apn var9 = var0.p(var8);
						if (var9.c().w() && (var3 || (var9.c() != class_aim.h))) {
							var4 = var8;
							break;
						}
					}
				}
			}
		}

		return var4 == null ? var1 : var4;
	}

	private static class_aqn a(class_ago var0, class_aym var1) {
		return var0.a(class_oa.c(var1.a / 16.0D), class_oa.c(var1.c / 16.0D));
	}

	private static class_cj a(class_aqn var0) {
		class_cj var1 = new class_cj(var0.b * 16, 30, var0.c * 16);
		int var2 = (var0.g() + 16) - 1;
		class_cj var3 = new class_cj(((var0.b * 16) + 16) - 1, var2, ((var0.c * 16) + 16) - 1);
		class_cj var4 = null;
		double var5 = 0.0D;
		Iterator var7 = class_cj.a(var1, var3).iterator();

		while (true) {
			class_cj var8;
			double var10;
			do {
				do {
					class_apn var9;
					do {
						do {
							if (!var7.hasNext()) {
								return var4;
							}

							var8 = (class_cj) var7.next();
							var9 = var0.g(var8);
						} while (var9.c() != class_aim.bH);
					} while (var0.a(var8.b(1)).w());
				} while (var0.a(var8.b(2)).w());

				var10 = var8.d(0.0D, 0.0D, 0.0D);
			} while ((var4 != null) && (var10 >= var5));

			var4 = var8;
			var5 = var10;
		}
	}

	private void b(class_cj var1) {
		(new class_asm()).b(b, new Random(), var1);
		class_aoi var2 = b.s(var1);
		if (var2 instanceof class_apc) {
			class_apc var3 = (class_apc) var2;
			var3.h = new class_cj(v());
			var3.o_();
		} else {
			a.warn("Couldn\'t save exit portal at " + var1);
		}

	}
}
