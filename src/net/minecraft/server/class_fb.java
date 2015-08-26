package net.minecraft.server;

import java.util.Arrays;
import java.util.IllegalFormatException;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;

public class class_fb extends class_es {
	private final String d;
	private final Object[] e;
	private final Object f = new Object();
	private long g = -1L;
	List b = Lists.newArrayList();
	public static final Pattern c = Pattern.compile("%(?:(\\d+)\\$)?([A-Za-z%]|$)");

	public class_fb(String var1, Object... var2) {
		d = var1;
		e = var2;
		Object[] var3 = var2;
		int var4 = var2.length;

		for (int var5 = 0; var5 < var4; ++var5) {
			Object var6 = var3[var5];
			if (var6 instanceof IChatBaseComponent) {
				((IChatBaseComponent) var6).b().a(this.b());
			}
		}

	}

	synchronized void g() {
		Object var1 = f;
		synchronized (f) {
			long var2 = class_di.a();
			if (var2 == g) {
				return;
			}

			g = var2;
			b.clear();
		}

		try {
			this.b(class_di.a(d));
		} catch (class_fc var6) {
			b.clear();

			try {
				this.b(class_di.b(d));
			} catch (class_fc var5) {
				throw var6;
			}
		}

	}

	protected void b(String var1) {
		boolean var2 = false;
		Matcher var3 = c.matcher(var1);
		int var4 = 0;
		int var5 = 0;

		try {
			int var7;
			for (; var3.find(var5); var5 = var7) {
				int var6 = var3.start();
				var7 = var3.end();
				if (var6 > var5) {
					class_fa var8 = new class_fa(String.format(var1.substring(var5, var6), new Object[0]));
					var8.b().a(this.b());
					b.add(var8);
				}

				String var14 = var3.group(2);
				String var9 = var1.substring(var6, var7);
				if ("%".equals(var14) && "%%".equals(var9)) {
					class_fa var15 = new class_fa("%");
					var15.b().a(this.b());
					b.add(var15);
				} else {
					if (!"s".equals(var14)) {
						throw new class_fc(this, "Unsupported format: \'" + var9 + "\'");
					}

					String var10 = var3.group(1);
					int var11 = var10 != null ? Integer.parseInt(var10) - 1 : var4++;
					if (var11 < e.length) {
						b.add(this.a(var11));
					}
				}
			}

			if (var5 < var1.length()) {
				class_fa var13 = new class_fa(String.format(var1.substring(var5), new Object[0]));
				var13.b().a(this.b());
				b.add(var13);
			}

		} catch (IllegalFormatException var12) {
			throw new class_fc(this, var12);
		}
	}

	private IChatBaseComponent a(int var1) {
		if (var1 >= e.length) {
			throw new class_fc(this, var1);
		} else {
			Object var2 = e[var1];
			Object var3;
			if (var2 instanceof IChatBaseComponent) {
				var3 = var2;
			} else {
				var3 = new class_fa(var2 == null ? "null" : var2.toString());
				((IChatBaseComponent) var3).b().a(this.b());
			}

			return (IChatBaseComponent) var3;
		}
	}

	@Override
	public IChatBaseComponent a(class_ez var1) {
		super.a(var1);
		Object[] var2 = e;
		int var3 = var2.length;

		for (int var4 = 0; var4 < var3; ++var4) {
			Object var5 = var2[var4];
			if (var5 instanceof IChatBaseComponent) {
				((IChatBaseComponent) var5).b().a(this.b());
			}
		}

		if (g > -1L) {
			Iterator var6 = b.iterator();

			while (var6.hasNext()) {
				IChatBaseComponent var7 = (IChatBaseComponent) var6.next();
				var7.b().a(var1);
			}
		}

		return this;
	}

	@Override
	public Iterator iterator() {
		g();
		return Iterators.concat(a(b), a(a));
	}

	@Override
	public String e() {
		g();
		StringBuilder var1 = new StringBuilder();
		Iterator var2 = b.iterator();

		while (var2.hasNext()) {
			IChatBaseComponent var3 = (IChatBaseComponent) var2.next();
			var1.append(var3.e());
		}

		return var1.toString();
	}

	public class_fb h() {
		Object[] var1 = new Object[e.length];

		for (int var2 = 0; var2 < e.length; ++var2) {
			if (e[var2] instanceof IChatBaseComponent) {
				var1[var2] = ((IChatBaseComponent) e[var2]).f();
			} else {
				var1[var2] = e[var2];
			}
		}

		class_fb var5 = new class_fb(d, var1);
		var5.a(this.b().m());
		Iterator var3 = this.a().iterator();

		while (var3.hasNext()) {
			IChatBaseComponent var4 = (IChatBaseComponent) var3.next();
			var5.a(var4.f());
		}

		return var5;
	}

	@Override
	public boolean equals(Object var1) {
		if (this == var1) {
			return true;
		} else if (!(var1 instanceof class_fb)) {
			return false;
		} else {
			class_fb var2 = (class_fb) var1;
			return Arrays.equals(e, var2.e) && d.equals(var2.d) && super.equals(var1);
		}
	}

	@Override
	public int hashCode() {
		int var1 = super.hashCode();
		var1 = (31 * var1) + d.hashCode();
		var1 = (31 * var1) + Arrays.hashCode(e);
		return var1;
	}

	@Override
	public String toString() {
		return "TranslatableComponent{key=\'" + d + '\'' + ", args=" + Arrays.toString(e) + ", siblings=" + a + ", style=" + this.b() + '}';
	}

	public String i() {
		return d;
	}

	public Object[] j() {
		return e;
	}

	// $FF: synthetic method
	@Override
	public IChatBaseComponent f() {
		return h();
	}
}
