package net.minecraft.server;

import java.util.Set;

import com.google.common.collect.Sets;

public class class_tw extends class_sr {
	private class_rn a;
	private double b;
	private double c;
	private double d;
	private double e;
	private double f;
	private double g;
	private class_yu h;
	private int i;
	private boolean j;
	private Set k;
	private boolean l;
	private boolean m;

	public class_tw(class_rn var1, double var2, Item var4, boolean var5) {
		this(var1, var2, var5, Sets.newHashSet((Object[]) (new Item[] { var4 })));
	}

	public class_tw(class_rn var1, double var2, boolean var4, Set var5) {
		a = var1;
		b = var2;
		k = var5;
		l = var4;
		this.a(3);
		if (!(var1.u() instanceof class_ul)) {
			throw new IllegalArgumentException("Unsupported mob type for TemptGoal");
		}
	}

	@Override
	public boolean a() {
		if (i > 0) {
			--i;
			return false;
		} else {
			h = a.o.a(a, 10.0D);
			return h == null ? false : this.a(h.bG()) || this.a(h.bH());
		}
	}

	protected boolean a(class_aco var1) {
		return var1 == null ? false : k.contains(var1.b());
	}

	@Override
	public boolean b() {
		if (l) {
			if (a.h(h) < 36.0D) {
				if (h.e(c, d, e) > 0.010000000000000002D) {
					return false;
				}

				if ((Math.abs(h.z - f) > 5.0D) || (Math.abs(h.y - g) > 5.0D)) {
					return false;
				}
			} else {
				c = h.s;
				d = h.t;
				e = h.u;
			}

			f = h.z;
			g = h.y;
		}

		return this.a();
	}

	@Override
	public void c() {
		c = h.s;
		d = h.t;
		e = h.u;
		j = true;
		m = ((class_ul) a.u()).e();
		((class_ul) a.u()).a(false);
	}

	@Override
	public void d() {
		h = null;
		a.u().n();
		i = 100;
		j = false;
		((class_ul) a.u()).a(m);
	}

	@Override
	public void e() {
		a.q().a(h, a.ci() + 20, a.ch());
		if (a.h(h) < 6.25D) {
			a.u().n();
		} else {
			a.u().a(h, b);
		}

	}

	public boolean f() {
		return j;
	}
}
