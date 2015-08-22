package net.minecraft.server;

import java.util.Iterator;
import java.util.List;

import com.google.common.collect.Lists;

public class class_ux extends class_axj {
	private class_ago b;
	private final List c = Lists.newArrayList();
	private final List d = Lists.newArrayList();
	private final List e = Lists.newArrayList();
	private int f;

	public class_ux(String var1) {
		super(var1);
	}

	public class_ux(class_ago var1) {
		super(a(var1.t));
		b = var1;
		this.c();
	}

	public void a(class_ago var1) {
		b = var1;
		Iterator var2 = e.iterator();

		while (var2.hasNext()) {
			class_uv var3 = (class_uv) var2.next();
			var3.a(var1);
		}

	}

	public void a(class_cj var1) {
		if (c.size() <= 64) {
			if (!this.e(var1)) {
				c.add(var1);
			}

		}
	}

	public void a() {
		++f;
		Iterator var1 = e.iterator();

		while (var1.hasNext()) {
			class_uv var2 = (class_uv) var1.next();
			var2.a(f);
		}

		this.e();
		this.f();
		g();
		if ((f % 400) == 0) {
			this.c();
		}

	}

	private void e() {
		Iterator var1 = e.iterator();

		while (var1.hasNext()) {
			class_uv var2 = (class_uv) var1.next();
			if (var2.g()) {
				var1.remove();
				this.c();
			}
		}

	}

	public List b() {
		return e;
	}

	public class_uv a(class_cj var1, int var2) {
		class_uv var3 = null;
		double var4 = 3.4028234663852886E38D;
		Iterator var6 = e.iterator();

		while (var6.hasNext()) {
			class_uv var7 = (class_uv) var6.next();
			double var8 = var7.a().i(var1);
			if (var8 < var4) {
				float var10 = var2 + var7.b();
				if (var8 <= var10 * var10) {
					var3 = var7;
					var4 = var8;
				}
			}
		}

		return var3;
	}

	private void f() {
		if (!c.isEmpty()) {
			this.b((class_cj) c.remove(0));
		}
	}

	private void g() {
		for (int var1 = 0; var1 < d.size(); ++var1) {
			class_uu var2 = (class_uu) d.get(var1);
			class_uv var3 = this.a(var2.d(), 32);
			if (var3 == null) {
				var3 = new class_uv(b);
				e.add(var3);
				this.c();
			}

			var3.a(var2);
		}

		d.clear();
	}

	private void b(class_cj var1) {
		byte var2 = 16;
		byte var3 = 4;
		byte var4 = 16;

		for (int var5 = -var2; var5 < var2; ++var5) {
			for (int var6 = -var3; var6 < var3; ++var6) {
				for (int var7 = -var4; var7 < var4; ++var7) {
					class_cj var8 = var1.a(var5, var6, var7);
					if (this.f(var8)) {
						class_uu var9 = this.c(var8);
						if (var9 == null) {
							this.d(var8);
						} else {
							var9.a(f);
						}
					}
				}
			}
		}

	}

	private class_uu c(class_cj var1) {
		Iterator var2 = d.iterator();

		class_uu var3;
		do {
			if (!var2.hasNext()) {
				var2 = e.iterator();

				class_uu var4;
				do {
					if (!var2.hasNext()) {
						return null;
					}

					class_uv var5 = (class_uv) var2.next();
					var4 = var5.e(var1);
				} while (var4 == null);

				return var4;
			}

			var3 = (class_uu) var2.next();
		} while ((var3.d().n() != var1.n()) || (var3.d().p() != var1.p()) || (Math.abs(var3.d().o() - var1.o()) > 1));

		return var3;
	}

	private void d(class_cj var1) {
		class_cq var2 = class_ajn.h(b, var1);
		class_cq var3 = var2.d();
		int var4 = this.a(var1, var2, 5);
		int var5 = this.a(var1, var3, var4 + 1);
		if (var4 != var5) {
			d.add(new class_uu(var1, var4 < var5 ? var2 : var3, f));
		}

	}

	private int a(class_cj var1, class_cq var2, int var3) {
		int var4 = 0;

		for (int var5 = 1; var5 <= 5; ++var5) {
			if (b.i(var1.a(var2, var5))) {
				++var4;
				if (var4 >= var3) {
					return var4;
				}
			}
		}

		return var4;
	}

	private boolean e(class_cj var1) {
		Iterator var2 = c.iterator();

		class_cj var3;
		do {
			if (!var2.hasNext()) {
				return false;
			}

			var3 = (class_cj) var2.next();
		} while (!var3.equals(var1));

		return true;
	}

	private boolean f(class_cj var1) {
		Block var2 = b.p(var1).c();
		return var2 instanceof class_ajn ? var2.v() == class_avq.d : false;
	}

	@Override
	public void a(class_dn var1) {
		f = var1.h("Tick");
		class_du var2 = var1.c("Villages", 10);

		for (int var3 = 0; var3 < var2.c(); ++var3) {
			class_dn var4 = var2.b(var3);
			class_uv var5 = new class_uv();
			var5.a(var4);
			e.add(var5);
		}

	}

	@Override
	public void b(class_dn var1) {
		var1.a("Tick", f);
		class_du var2 = new class_du();
		Iterator var3 = e.iterator();

		while (var3.hasNext()) {
			class_uv var4 = (class_uv) var3.next();
			class_dn var5 = new class_dn();
			var4.b(var5);
			var2.a(var5);
		}

		var1.a("Villages", var2);
	}

	public static String a(class_arc var0) {
		return "villages" + var0.p().c();
	}
}
