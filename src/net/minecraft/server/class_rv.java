package net.minecraft.server;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

public class class_rv implements class_rq {
	private final class_rt a;
	private final class_rp b;
	private final Map c = Maps.newHashMap();
	private final Map d = Maps.newHashMap();
	private final Map e = Maps.newHashMap();
	private double f;
	private boolean g = true;
	private double h;

	public class_rv(class_rt var1, class_rp var2) {
		a = var1;
		b = var2;
		f = var2.b();

		for (int var3 = 0; var3 < 3; ++var3) {
			c.put(Integer.valueOf(var3), Sets.newHashSet());
		}

	}

	@Override
	public class_rp a() {
		return b;
	}

	@Override
	public double b() {
		return f;
	}

	@Override
	public void a(double var1) {
		if (var1 != this.b()) {
			f = var1;
			f();
		}
	}

	@Override
	public Collection a(int var1) {
		return (Collection) c.get(Integer.valueOf(var1));
	}

	@Override
	public Collection c() {
		HashSet var1 = Sets.newHashSet();

		for (int var2 = 0; var2 < 3; ++var2) {
			var1.addAll(this.a(var2));
		}

		return var1;
	}

	@Override
	public class_rr a(UUID var1) {
		return (class_rr) e.get(var1);
	}

	@Override
	public boolean a(class_rr var1) {
		return e.get(var1.a()) != null;
	}

	@Override
	public void b(class_rr var1) {
		if (this.a(var1.a()) != null) {
			throw new IllegalArgumentException("Modifier is already applied on this attribute!");
		} else {
			Object var2 = d.get(var1.b());
			if (var2 == null) {
				var2 = Sets.newHashSet();
				d.put(var1.b(), var2);
			}

			((Set) c.get(Integer.valueOf(var1.c()))).add(var1);
			((Set) var2).add(var1);
			e.put(var1.a(), var1);
			f();
		}
	}

	protected void f() {
		g = true;
		a.a(this);
	}

	@Override
	public void c(class_rr var1) {
		for (int var2 = 0; var2 < 3; ++var2) {
			Set var3 = (Set) c.get(Integer.valueOf(var2));
			var3.remove(var1);
		}

		Set var4 = (Set) d.get(var1.b());
		if (var4 != null) {
			var4.remove(var1);
			if (var4.isEmpty()) {
				d.remove(var1.b());
			}
		}

		e.remove(var1.a());
		f();
	}

	@Override
	public double e() {
		if (g) {
			h = g();
			g = false;
		}

		return h;
	}

	private double g() {
		double var1 = this.b();

		class_rr var4;
		for (Iterator var3 = this.b(0).iterator(); var3.hasNext(); var1 += var4.d()) {
			var4 = (class_rr) var3.next();
		}

		double var7 = var1;

		Iterator var5;
		class_rr var6;
		for (var5 = this.b(1).iterator(); var5.hasNext(); var7 += var1 * var6.d()) {
			var6 = (class_rr) var5.next();
		}

		for (var5 = this.b(2).iterator(); var5.hasNext(); var7 *= 1.0D + var6.d()) {
			var6 = (class_rr) var5.next();
		}

		return b.a(var7);
	}

	private Collection b(int var1) {
		HashSet var2 = Sets.newHashSet((Iterable) this.a(var1));

		for (class_rp var3 = b.d(); var3 != null; var3 = var3.d()) {
			class_rq var4 = a.a(var3);
			if (var4 != null) {
				var2.addAll(var4.a(var1));
			}
		}

		return var2;
	}
}
