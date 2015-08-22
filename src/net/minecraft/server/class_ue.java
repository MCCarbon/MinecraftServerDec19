package net.minecraft.server;

import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.base.Predicate;

public class class_ue extends class_sr {
	private static final Logger a = LogManager.getLogger();
	private class_rh b;
	private final Predicate c;
	private final class_uf.class_a_in_class_uf d;
	private class_rg e;

	public class_ue(class_rh var1) {
		b = var1;
		if (var1 instanceof class_rn) {
			a.warn("Use NearestAttackableTargetGoal.class for PathfinerMob mobs!");
		}

		c = new Predicate() {
			public boolean a(Entity var1) {
				if (!(var1 instanceof class_yu)) {
					return false;
				} else if (((class_yu) var1).bI.a) {
					return false;
				} else {
					double var2 = class_ue.this.f();
					if (var1.aA()) {
						var2 *= 0.800000011920929D;
					}

					if (var1.aD()) {
						float var4 = ((class_yu) var1).ch();
						if (var4 < 0.1F) {
							var4 = 0.1F;
						}

						var2 *= 0.7F * var4;
					}

					return var1.g(b) > var2 ? false : class_uj.a(b, (class_rg) var1, false, true);
				}
			}

			// $FF: synthetic method
			@Override
			public boolean apply(Object var1) {
				return this.a((Entity) var1);
			}
		};
		d = new class_uf.class_a_in_class_uf(var1);
	}

	@Override
	public boolean a() {
		double var1 = f();
		List var3 = b.o.a(class_yu.class, b.aX().b(var1, 4.0D, var1), c);
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
		} else if ((var1 instanceof class_yu) && ((class_yu) var1).bI.a) {
			return false;
		} else {
			class_ayu var2 = b.aE();
			class_ayu var3 = var1.aE();
			if ((var2 != null) && (var3 == var2)) {
				return false;
			} else {
				double var4 = f();
				return b.h(var1) > (var4 * var4) ? false : !(var1 instanceof class_lm) || !((class_lm) var1).c.d();
			}
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
