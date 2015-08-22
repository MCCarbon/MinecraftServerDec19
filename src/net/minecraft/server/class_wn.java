package net.minecraft.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_wn {
	private static final Logger a = LogManager.getLogger();
	private final class_vx b;
	private final class_wg[] c = new class_wg[class_wm.c()];
	private class_wg d;

	public class_wn(class_vx var1) {
		b = var1;
		this.a(class_wm.a);
	}

	public void a(class_wm var1) {
		if ((d == null) || (var1 != d.i())) {
			if (d != null) {
				d.e();
			}

			d = b(var1);
			if (!b.o.D) {
				b.J().b(class_vx.a, Integer.valueOf(var1.b()));
			}

			a.debug("Dragon is now in phase {} on the {}", new Object[] { var1, b.o.D ? "client" : "server" });
			d.d();
		}
	}

	public class_wg a() {
		return d;
	}

	public class_wg b(class_wm var1) {
		int var2 = var1.b();
		if (c[var2] == null) {
			c[var2] = var1.a(b);
		}

		return c[var2];
	}
}
