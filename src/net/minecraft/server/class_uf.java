package net.minecraft.server;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

public class class_uf extends class_uj {
	protected final Class a;
	private final int g;
	protected final class_uf.class_a_in_class_uf b;
	protected Predicate c;
	protected class_rg d;

	public class_uf(class_rn var1, Class var2, boolean var3) {
		this(var1, var2, var3, false);
	}

	public class_uf(class_rn var1, Class var2, boolean var3, boolean var4) {
		this(var1, var2, 10, var3, var4, (Predicate) null);
	}

	public class_uf(final class_rn var1, Class var2, int var3, boolean var4, boolean var5, final Predicate var6) {
		super(var1, var4, var5);
		a = var2;
		g = var3;
		b = new class_uf.class_a_in_class_uf(var1);
		this.a(1);
		c = new Predicate() {
			public boolean a(class_rg var1x) {
				if ((var6 != null) && !var6.apply(var1x)) {
					return false;
				} else {
					if (var1x instanceof class_yu) {
						double var2 = class_uf.this.f();
						if (var1x.aA()) {
							var2 *= 0.800000011920929D;
						}

						if (var1x.aD()) {
							float var4 = ((class_yu) var1x).ch();
							if (var4 < 0.1F) {
								var4 = 0.1F;
							}

							var2 *= 0.7F * var4;
						}

						class_aco var9 = var1x.a(class_rc.f);
						if ((var9 != null) && (var9.b() == class_acq.cc)) {
							int var5 = var9.h();
							boolean var6x = (var1 instanceof class_yh) && (((class_yh) var1).cF() == 0) && (var5 == 0);
							boolean var7 = (var1 instanceof class_yl) && (var5 == 2);
							boolean var8 = (var1 instanceof class_xu) && (var5 == 4);
							if (var6x || var7 || var8) {
								var2 *= 0.375D;
							}
						}

						if (var1x.g(class_uf.this.e) > var2) {
							return false;
						}
					}

					return class_uf.this.a(var1x, false);
				}
			}

			// $FF: synthetic method
			@Override
			public boolean apply(Object var1x) {
				return this.a((class_rg) var1x);
			}
		};
	}

	@Override
	public boolean a() {
		if ((g > 0) && (e.bj().nextInt(g) != 0)) {
			return false;
		} else {
			double var1 = f();
			List var3 = e.o.a(a, this.a(var1), Predicates.and(c, class_rb.d));
			Collections.sort(var3, b);
			if (var3.isEmpty()) {
				return false;
			} else {
				d = (class_rg) var3.get(0);
				return true;
			}
		}
	}

	protected class_ayk a(double var1) {
		return e.aX().b(var1, 4.0D, var1);
	}

	@Override
	public void c() {
		e.c(d);
		super.c();
	}

	public static class class_a_in_class_uf implements Comparator {
		private final class_qx a;

		public class_a_in_class_uf(class_qx var1) {
			a = var1;
		}

		public int a(class_qx var1, class_qx var2) {
			double var3 = a.h(var1);
			double var5 = a.h(var2);
			return var3 < var5 ? -1 : (var3 > var5 ? 1 : 0);
		}

		// $FF: synthetic method
		@Override
		public int compare(Object var1, Object var2) {
			return this.a((class_qx) var1, (class_qx) var2);
		}
	}
}
