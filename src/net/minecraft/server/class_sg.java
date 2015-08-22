package net.minecraft.server;

import java.util.List;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

public class class_sg extends class_sr {
	private final Predicate c;
	protected class_rn a;
	private double d;
	private double e;
	protected Entity b;
	private float f;
	private class_axc g;
	private class_um h;
	private Class i;
	private Predicate j;

	public class_sg(class_rn var1, Class var2, float var3, double var4, double var6) {
		this(var1, var2, Predicates.alwaysTrue(), var3, var4, var6);
	}

	public class_sg(class_rn var1, Class var2, Predicate var3, float var4, double var5, double var7) {
		c = new Predicate() {
			public boolean a(Entity var1) {
				return var1.al() && a.v().a(var1);
			}

			// $FF: synthetic method
			@Override
			public boolean apply(Object var1) {
				return this.a((Entity) var1);
			}
		};
		a = var1;
		i = var2;
		j = var3;
		f = var4;
		d = var5;
		e = var7;
		h = var1.u();
		this.a(1);
	}

	@Override
	public boolean a() {
		List var1 = a.o.a(i, a.aX().b(f, 3.0D, f), Predicates.and(new Predicate[] { class_rb.d, c, j }));
		if (var1.isEmpty()) {
			return false;
		} else {
			b = (Entity) var1.get(0);
			class_aym var2 = class_us.b(a, 16, 7, new class_aym(b.s, b.t, b.u));
			if (var2 == null) {
				return false;
			} else if (b.e(var2.a, var2.b, var2.c) < b.h(a)) {
				return false;
			} else {
				g = h.a(var2.a, var2.b, var2.c);
				return g == null ? false : g.b(var2);
			}
		}
	}

	@Override
	public boolean b() {
		return !h.m();
	}

	@Override
	public void c() {
		h.a(g, d);
	}

	@Override
	public void d() {
		b = null;
	}

	@Override
	public void e() {
		if (a.h(b) < 49.0D) {
			a.u().a(e);
		} else {
			a.u().a(d);
		}

	}
}
