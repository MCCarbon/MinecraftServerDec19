package net.minecraft.server;

import java.util.Iterator;

public class class_ex extends class_es {
	private final String b;
	private final String c;
	private String d = "";

	public class_ex(String var1, String var2) {
		b = var1;
		c = var2;
	}

	public String g() {
		return b;
	}

	public String h() {
		return c;
	}

	public void b(String var1) {
		d = var1;
	}

	@Override
	public String e() {
		MinecraftServer var1 = MinecraftServer.P();
		if ((var1 != null) && var1.Q() && class_of.b(d)) {
			class_ays var2 = var1.a(0).ab();
			class_ayo var3 = var2.b(c);
			if (var2.b(b, var3)) {
				class_ayq var4 = var2.c(b, var3);
				this.b(String.format("%d", new Object[] { Integer.valueOf(var4.c()) }));
			} else {
				d = "";
			}
		}

		return d;
	}

	public class_ex i() {
		class_ex var1 = new class_ex(b, c);
		var1.b(d);
		var1.a(this.b().m());
		Iterator var2 = this.a().iterator();

		while (var2.hasNext()) {
			class_eu var3 = (class_eu) var2.next();
			var1.a(var3.f());
		}

		return var1;
	}

	@Override
	public boolean equals(Object var1) {
		if (this == var1) {
			return true;
		} else if (!(var1 instanceof class_ex)) {
			return false;
		} else {
			class_ex var2 = (class_ex) var1;
			return b.equals(var2.b) && c.equals(var2.c) && super.equals(var1);
		}
	}

	@Override
	public String toString() {
		return "ScoreComponent{name=\'" + b + '\'' + "objective=\'" + c + '\'' + ", siblings=" + a + ", style=" + this.b() + '}';
	}

	// $FF: synthetic method
	@Override
	public class_eu f() {
		return i();
	}
}
