package net.minecraft.server;

import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import java.util.UUID;

import com.google.common.collect.Lists;
import com.mojang.authlib.GameProfile;

public class class_uv {
	private class_ago a;
	private final List b = Lists.newArrayList();
	private class_cj c;
	private class_cj d;
	private int e;
	private int f;
	private int g;
	private int h;
	private int i;
	private TreeMap j;
	private List k;
	private int l;

	public class_uv() {
		c = class_cj.a;
		d = class_cj.a;
		j = new TreeMap();
		k = Lists.newArrayList();
	}

	public class_uv(class_ago var1) {
		c = class_cj.a;
		d = class_cj.a;
		j = new TreeMap();
		k = Lists.newArrayList();
		a = var1;
	}

	public void a(class_ago var1) {
		a = var1;
	}

	public void a(int var1) {
		g = var1;
		m();
		l();
		if ((var1 % 20) == 0) {
			k();
		}

		if ((var1 % 30) == 0) {
			j();
		}

		int var2 = h / 10;
		if ((l < var2) && (b.size() > 20) && (a.s.nextInt(7000) == 0)) {
			class_aym var3 = this.a(d, 2, 4, 2);
			if (var3 != null) {
				EntityVillagerGolem var4 = new EntityVillagerGolem(a);
				var4.b(var3.a, var3.b, var3.c);
				a.a(var4);
				++l;
			}
		}

	}

	private class_aym a(class_cj var1, int var2, int var3, int var4) {
		for (int var5 = 0; var5 < 10; ++var5) {
			class_cj var6 = var1.a(a.s.nextInt(16) - 8, a.s.nextInt(6) - 3, a.s.nextInt(16) - 8);
			if (this.a(var6) && this.a(new class_cj(var2, var3, var4), var6)) {
				return new class_aym(var6.n(), var6.o(), var6.p());
			}
		}

		return null;
	}

	private boolean a(class_cj var1, class_cj var2) {
		if (!class_ago.a(a, var2.b())) {
			return false;
		} else {
			int var3 = var2.n() - (var1.n() / 2);
			int var4 = var2.p() - (var1.p() / 2);

			for (int var5 = var3; var5 < (var3 + var1.n()); ++var5) {
				for (int var6 = var2.o(); var6 < (var2.o() + var1.o()); ++var6) {
					for (int var7 = var4; var7 < (var4 + var1.p()); ++var7) {
						if (a.p(new class_cj(var5, var6, var7)).c().x()) {
							return false;
						}
					}
				}
			}

			return true;
		}
	}

	private void j() {
		List var1 = a.a(EntityVillagerGolem.class, new class_ayk(d.n() - e, d.o() - 4, d.p() - e, d.n() + e, d.o() + 4, d.p() + e));
		l = var1.size();
	}

	private void k() {
		List var1 = a.a(EntityVillager.class, new class_ayk(d.n() - e, d.o() - 4, d.p() - e, d.n() + e, d.o() + 4, d.p() + e));
		h = var1.size();
		if (h == 0) {
			j.clear();
		}

	}

	public class_cj a() {
		return d;
	}

	public int b() {
		return e;
	}

	public int c() {
		return b.size();
	}

	public int d() {
		return g - f;
	}

	public int e() {
		return h;
	}

	public boolean a(class_cj var1) {
		return d.i(var1) < e * e;
	}

	public List f() {
		return b;
	}

	public class_uu b(class_cj var1) {
		class_uu var2 = null;
		int var3 = Integer.MAX_VALUE;
		Iterator var4 = b.iterator();

		while (var4.hasNext()) {
			class_uu var5 = (class_uu) var4.next();
			int var6 = var5.a(var1);
			if (var6 < var3) {
				var2 = var5;
				var3 = var6;
			}
		}

		return var2;
	}

	public class_uu c(class_cj var1) {
		class_uu var2 = null;
		int var3 = Integer.MAX_VALUE;
		Iterator var4 = b.iterator();

		while (var4.hasNext()) {
			class_uu var5 = (class_uu) var4.next();
			int var6 = var5.a(var1);
			if (var6 > 256) {
				var6 *= 1000;
			} else {
				var6 = var5.c();
			}

			if (var6 < var3) {
				var2 = var5;
				var3 = var6;
			}
		}

		return var2;
	}

	public class_uu e(class_cj var1) {
		if (d.i(var1) > e * e) {
			return null;
		} else {
			Iterator var2 = b.iterator();

			class_uu var3;
			do {
				if (!var2.hasNext()) {
					return null;
				}

				var3 = (class_uu) var2.next();
			} while ((var3.d().n() != var1.n()) || (var3.d().p() != var1.p()) || (Math.abs(var3.d().o() - var1.o()) > 1));

			return var3;
		}
	}

	public void a(class_uu var1) {
		b.add(var1);
		c = c.a(var1.d());
		n();
		f = var1.h();
	}

	public boolean g() {
		return b.isEmpty();
	}

	public void a(EntityLiving var1) {
		Iterator var2 = k.iterator();

		class_uv.class_a_in_class_uv var3;
		do {
			if (!var2.hasNext()) {
				k.add(new class_uv.class_a_in_class_uv(var1, g));
				return;
			}

			var3 = (class_uv.class_a_in_class_uv) var2.next();
		} while (var3.a != var1);

		var3.b = g;
	}

	public EntityLiving b(EntityLiving var1) {
		double var2 = Double.MAX_VALUE;
		class_uv.class_a_in_class_uv var4 = null;

		for (int var5 = 0; var5 < k.size(); ++var5) {
			class_uv.class_a_in_class_uv var6 = (class_uv.class_a_in_class_uv) k.get(var5);
			double var7 = var6.a.h(var1);
			if (var7 <= var2) {
				var4 = var6;
				var2 = var7;
			}
		}

		return var4 != null ? var4.a : null;
	}

	public class_yu c(EntityLiving var1) {
		double var2 = Double.MAX_VALUE;
		class_yu var4 = null;
		Iterator var5 = j.keySet().iterator();

		while (var5.hasNext()) {
			String var6 = (String) var5.next();
			if (this.d(var6)) {
				class_yu var7 = a.a(var6);
				if (var7 != null) {
					double var8 = var7.h(var1);
					if (var8 <= var2) {
						var4 = var7;
						var2 = var8;
					}
				}
			}
		}

		return var4;
	}

	private void l() {
		Iterator var1 = k.iterator();

		while (true) {
			class_uv.class_a_in_class_uv var2;
			do {
				if (!var1.hasNext()) {
					return;
				}

				var2 = (class_uv.class_a_in_class_uv) var1.next();
			} while (var2.a.al() && (Math.abs(g - var2.b) <= 300));

			var1.remove();
		}
	}

	private void m() {
		boolean var1 = false;
		boolean var2 = a.s.nextInt(50) == 0;
		Iterator var3 = b.iterator();

		while (true) {
			class_uu var4;
			do {
				if (!var3.hasNext()) {
					if (var1) {
						n();
					}

					return;
				}

				var4 = (class_uu) var3.next();
				if (var2) {
					var4.a();
				}
			} while (this.f(var4.d()) && (Math.abs(g - var4.h()) <= 1200));

			c = c.b(var4.d());
			var1 = true;
			var4.a(true);
			var3.remove();
		}
	}

	private boolean f(class_cj var1) {
		Block var2 = a.p(var1).c();
		return var2 instanceof class_ajn ? var2.v() == class_avq.d : false;
	}

	private void n() {
		int var1 = b.size();
		if (var1 == 0) {
			d = new class_cj(0, 0, 0);
			e = 0;
		} else {
			d = new class_cj(c.n() / var1, c.o() / var1, c.p() / var1);
			int var2 = 0;

			class_uu var4;
			for (Iterator var3 = b.iterator(); var3.hasNext(); var2 = Math.max(var4.a(d), var2)) {
				var4 = (class_uu) var3.next();
			}

			e = Math.max(32, (int) Math.sqrt(var2) + 1);
		}
	}

	public int a(String var1) {
		Integer var2 = (Integer) j.get(var1);
		return var2 != null ? var2.intValue() : 0;
	}

	public int a(String var1, int var2) {
		int var3 = this.a(var1);
		int var4 = MathHelper.a(var3 + var2, -30, 10);
		j.put(var1, Integer.valueOf(var4));
		return var4;
	}

	public boolean d(String var1) {
		return this.a(var1) <= -15;
	}

	public void a(class_dn var1) {
		h = var1.h("PopSize");
		e = var1.h("Radius");
		l = var1.h("Golems");
		f = var1.h("Stable");
		g = var1.h("Tick");
		i = var1.h("MTick");
		d = new class_cj(var1.h("CX"), var1.h("CY"), var1.h("CZ"));
		c = new class_cj(var1.h("ACX"), var1.h("ACY"), var1.h("ACZ"));
		class_du var2 = var1.c("Doors", 10);

		for (int var3 = 0; var3 < var2.c(); ++var3) {
			class_dn var4 = var2.b(var3);
			class_uu var5 = new class_uu(new class_cj(var4.h("X"), var4.h("Y"), var4.h("Z")), var4.h("IDX"), var4.h("IDZ"), var4.h("TS"));
			b.add(var5);
		}

		class_du var8 = var1.c("Players", 10);

		for (int var9 = 0; var9 < var8.c(); ++var9) {
			class_dn var10 = var8.b(var9);
			if (var10.e("UUID")) {
				class_ma var6 = MinecraftServer.P().aH();
				GameProfile var7 = var6.a(UUID.fromString(var10.l("UUID")));
				if (var7 != null) {
					j.put(var7.getName(), Integer.valueOf(var10.h("S")));
				}
			} else {
				j.put(var10.l("Name"), Integer.valueOf(var10.h("S")));
			}
		}

	}

	public void b(class_dn var1) {
		var1.a("PopSize", h);
		var1.a("Radius", e);
		var1.a("Golems", l);
		var1.a("Stable", f);
		var1.a("Tick", g);
		var1.a("MTick", i);
		var1.a("CX", d.n());
		var1.a("CY", d.o());
		var1.a("CZ", d.p());
		var1.a("ACX", c.n());
		var1.a("ACY", c.o());
		var1.a("ACZ", c.p());
		class_du var2 = new class_du();
		Iterator var3 = b.iterator();

		while (var3.hasNext()) {
			class_uu var4 = (class_uu) var3.next();
			class_dn var5 = new class_dn();
			var5.a("X", var4.d().n());
			var5.a("Y", var4.d().o());
			var5.a("Z", var4.d().p());
			var5.a("IDX", var4.f());
			var5.a("IDZ", var4.g());
			var5.a("TS", var4.h());
			var2.a(var5);
		}

		var1.a("Doors", var2);
		class_du var9 = new class_du();
		Iterator var10 = j.keySet().iterator();

		while (var10.hasNext()) {
			String var11 = (String) var10.next();
			class_dn var6 = new class_dn();
			class_ma var7 = MinecraftServer.P().aH();
			GameProfile var8 = var7.a(var11);
			if (var8 != null) {
				var6.a("UUID", var8.getId().toString());
				var6.a("S", ((Integer) j.get(var11)).intValue());
				var9.a(var6);
			}
		}

		var1.a("Players", var9);
	}

	public void h() {
		i = g;
	}

	public boolean i() {
		return (i == 0) || ((g - i) >= 3600);
	}

	public void b(int var1) {
		Iterator var2 = j.keySet().iterator();

		while (var2.hasNext()) {
			String var3 = (String) var2.next();
			this.a(var3, var1);
		}

	}

	class class_a_in_class_uv {
		public EntityLiving a;
		public int b;

		class_a_in_class_uv(EntityLiving var2, int var3) {
			a = var2;
			b = var3;
		}
	}
}
