package net.minecraft.server;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class class_kq extends class_ays {
	private final MinecraftServer a;
	private final Set b = Sets.newHashSet();
	private class_ayt c;

	public class_kq(MinecraftServer var1) {
		a = var1;
	}

	@Override
	public void a(class_ayq var1) {
		super.a(var1);
		if (b.contains(var1.d())) {
			a.ar().a((new class_ht(var1)));
		}

		this.b();
	}

	@Override
	public void a(String var1) {
		super.a(var1);
		a.ar().a((new class_ht(var1)));
		this.b();
	}

	@Override
	public void a(String var1, class_ayo var2) {
		super.a(var1, var2);
		a.ar().a((new class_ht(var1, var2)));
		this.b();
	}

	@Override
	public void a(int var1, class_ayo var2) {
		class_ayo var3 = this.a(var1);
		super.a(var1, var2);
		if ((var3 != var2) && (var3 != null)) {
			if (this.h(var3) > 0) {
				a.ar().a((new class_hk(var1, var2)));
			} else {
				this.g(var3);
			}
		}

		if (var2 != null) {
			if (b.contains(var2)) {
				a.ar().a((new class_hk(var1, var2)));
			} else {
				this.e(var2);
			}
		}

		this.b();
	}

	@Override
	public boolean a(String var1, String var2) {
		if (super.a(var1, var2)) {
			class_ayp var3 = this.d(var2);
			a.ar().a((new class_hs(var3, Arrays.asList(new String[] { var1 }), 3)));
			this.b();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void a(String var1, class_ayp var2) {
		super.a(var1, var2);
		a.ar().a((new class_hs(var2, Arrays.asList(new String[] { var1 }), 4)));
		this.b();
	}

	@Override
	public void a(class_ayo var1) {
		super.a(var1);
		this.b();
	}

	@Override
	public void b(class_ayo var1) {
		super.b(var1);
		if (b.contains(var1)) {
			a.ar().a((new class_hr(var1, 2)));
		}

		this.b();
	}

	@Override
	public void c(class_ayo var1) {
		super.c(var1);
		if (b.contains(var1)) {
			this.g(var1);
		}

		this.b();
	}

	@Override
	public void a(class_ayp var1) {
		super.a(var1);
		a.ar().a((new class_hs(var1, 0)));
		this.b();
	}

	@Override
	public void b(class_ayp var1) {
		super.b(var1);
		a.ar().a((new class_hs(var1, 2)));
		this.b();
	}

	@Override
	public void c(class_ayp var1) {
		super.c(var1);
		a.ar().a((new class_hs(var1, 1)));
		this.b();
	}

	public void a(class_ayt var1) {
		c = var1;
	}

	protected void b() {
		if (c != null) {
			c.c();
		}

	}

	public List d(class_ayo var1) {
		ArrayList var2 = Lists.newArrayList();
		var2.add(new class_hr(var1, 0));

		for (int var3 = 0; var3 < 19; ++var3) {
			if (this.a(var3) == var1) {
				var2.add(new class_hk(var3, var1));
			}
		}

		Iterator var5 = this.i(var1).iterator();

		while (var5.hasNext()) {
			class_ayq var4 = (class_ayq) var5.next();
			var2.add(new class_ht(var4));
		}

		return var2;
	}

	public void e(class_ayo var1) {
		List var2 = this.d(var1);
		Iterator var3 = a.ar().v().iterator();

		while (var3.hasNext()) {
			class_lm var4 = (class_lm) var3.next();
			Iterator var5 = var2.iterator();

			while (var5.hasNext()) {
				class_ff var6 = (class_ff) var5.next();
				var4.a.a(var6);
			}
		}

		b.add(var1);
	}

	public List f(class_ayo var1) {
		ArrayList var2 = Lists.newArrayList();
		var2.add(new class_hr(var1, 1));

		for (int var3 = 0; var3 < 19; ++var3) {
			if (this.a(var3) == var1) {
				var2.add(new class_hk(var3, var1));
			}
		}

		return var2;
	}

	public void g(class_ayo var1) {
		List var2 = this.f(var1);
		Iterator var3 = a.ar().v().iterator();

		while (var3.hasNext()) {
			class_lm var4 = (class_lm) var3.next();
			Iterator var5 = var2.iterator();

			while (var5.hasNext()) {
				class_ff var6 = (class_ff) var5.next();
				var4.a.a(var6);
			}
		}

		b.remove(var1);
	}

	public int h(class_ayo var1) {
		int var2 = 0;

		for (int var3 = 0; var3 < 19; ++var3) {
			if (this.a(var3) == var1) {
				++var2;
			}
		}

		return var2;
	}
}
