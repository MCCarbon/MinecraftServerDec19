package net.minecraft.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_wb extends class_vz {
	private static final Logger b = LogManager.getLogger();
	private class_aym c;
	private int d = 0;

	public class_wb(class_vx var1) {
		super(var1);
	}

	@Override
	public void c() {
		if (c == null) {
			b.warn("Aborting charge player as no target was set.");
			a.cy().a(class_wm.a);
		} else if ((d > 0) && (d++ >= 10)) {
			a.cy().a(class_wm.a);
		} else {
			double var1 = c.c(a.s, a.t, a.u);
			if ((var1 < 100.0D) || (var1 > 22500.0D) || a.D || a.E) {
				++d;
			}

		}
	}

	@Override
	public void d() {
		c = null;
		d = 0;
	}

	public void a(class_aym var1) {
		c = var1;
	}

	@Override
	public float f() {
		return 3.0F;
	}

	@Override
	public class_aym g() {
		return c;
	}

	@Override
	public class_wm i() {
		return class_wm.i;
	}
}
