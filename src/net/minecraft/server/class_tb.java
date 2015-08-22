package net.minecraft.server;

import java.util.Iterator;
import java.util.List;

import com.google.common.collect.Lists;

public class class_tb extends class_sr {
	private class_rn a;
	private double b;
	private class_axc c;
	private class_uu d;
	private boolean e;
	private List f = Lists.newArrayList();

	public class_tb(class_rn var1, double var2, boolean var4) {
		a = var1;
		b = var2;
		e = var4;
		this.a(1);
		if (!(var1.u() instanceof class_ul)) {
			throw new IllegalArgumentException("Unsupported mob for MoveThroughVillageGoal");
		}
	}

	@Override
	public boolean a() {
		f();
		if (e && a.o.z()) {
			return false;
		} else {
			class_uv var1 = a.o.ag().a(new class_cj(a), 0);
			if (var1 == null) {
				return false;
			} else {
				d = this.a(var1);
				if (d == null) {
					return false;
				} else {
					class_ul var2 = (class_ul) a.u();
					boolean var3 = var2.g();
					var2.b(false);
					c = var2.a(d.d());
					var2.b(var3);
					if (c != null) {
						return true;
					} else {
						class_aym var4 = class_us.a(a, 10, 7, new class_aym(d.d().n(), d.d().o(), d.d().p()));
						if (var4 == null) {
							return false;
						} else {
							var2.b(false);
							c = a.u().a(var4.a, var4.b, var4.c);
							var2.b(var3);
							return c != null;
						}
					}
				}
			}
		}
	}

	@Override
	public boolean b() {
		if (a.u().m()) {
			return false;
		} else {
			float var1 = a.J + 4.0F;
			return a.b(d.d()) > var1 * var1;
		}
	}

	@Override
	public void c() {
		a.u().a(c, b);
	}

	@Override
	public void d() {
		if (a.u().m() || (a.b(d.d()) < 16.0D)) {
			f.add(d);
		}

	}

	private class_uu a(class_uv var1) {
		class_uu var2 = null;
		int var3 = Integer.MAX_VALUE;
		List var4 = var1.f();
		Iterator var5 = var4.iterator();

		while (var5.hasNext()) {
			class_uu var6 = (class_uu) var5.next();
			int var7 = var6.b(class_oa.c(a.s), class_oa.c(a.t), class_oa.c(a.u));
			if ((var7 < var3) && !this.a(var6)) {
				var2 = var6;
				var3 = var7;
			}
		}

		return var2;
	}

	private boolean a(class_uu var1) {
		Iterator var2 = f.iterator();

		class_uu var3;
		do {
			if (!var2.hasNext()) {
				return false;
			}

			var3 = (class_uu) var2.next();
		} while (!var1.d().equals(var3.d()));

		return true;
	}

	private void f() {
		if (f.size() > 15) {
			f.remove(0);
		}

	}
}
