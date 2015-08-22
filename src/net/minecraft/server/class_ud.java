package net.minecraft.server;

import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.base.Predicate;

public class class_ud extends class_sr {
	private static final Logger a = LogManager.getLogger();
	private class_rh b;
	private final Predicate c;
	private final class_uf.class_a_in_class_uf d;
	private class_rg e;
	private Class f;

	public class_ud(class_rh var1, Class var2) {
		b = var1;
		f = var2;
		if (var1 instanceof class_rn) {
			a.warn("Use NearestAttackableTargetGoal.class for PathfinerMob mobs!");
		}

		c = new Predicate() {
			public boolean a(class_rg var1) {
				double var2 = class_ud.this.f();
				if (var1.aA()) {
					var2 *= 0.800000011920929D;
				}

				return var1.aD() ? false : (var1.g(b) > var2 ? false : class_uj.a(b, var1, false, true));
			}

			// $FF: synthetic method
			@Override
			public boolean apply(Object var1) {
				return this.a((class_rg) var1);
			}
		};
		d = new class_uf.class_a_in_class_uf(var1);
	}

	@Override
	public boolean a() {
		double var1 = f();
		List var3 = b.o.a(f, b.aX().b(var1, 4.0D, var1), c);
		Collections.sort(var3, d);
		if (var3.isEmpty()) {
			return false;
		} else {
			e = (class_rg) var3.get(0);
			return true;
		}
	}

	@Override
	public boolean b() {
		class_rg var1 = b.w();
		if (var1 == null) {
			return false;
		} else if (!var1.al()) {
			return false;
		} else {
			double var2 = f();
			return b.h(var1) > (var2 * var2) ? false : !(var1 instanceof class_lm) || !((class_lm) var1).c.d();
		}
	}

	@Override
	public void c() {
		b.c(e);
		super.c();
	}

	@Override
	public void d() {
		b.c((class_rg) null);
		super.c();
	}

	protected double f() {
		class_rq var1 = b.a(class_yf.b);
		return var1 == null ? 16.0D : var1.e();
	}
}
