package net.minecraft.server;

import java.util.Iterator;

public class class_fa extends class_es {
	private final String b;

	public class_fa(String var1) {
		b = var1;
	}

	public String g() {
		return b;
	}

	@Override
	public String e() {
		return b;
	}

	public class_fa h() {
		class_fa var1 = new class_fa(b);
		var1.a(b().m());
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
		} else if (!(var1 instanceof class_fa)) {
			return false;
		} else {
			class_fa var2 = (class_fa) var1;
			return b.equals(var2.g()) && super.equals(var1);
		}
	}

	@Override
	public String toString() {
		return "TextComponent{text=\'" + b + '\'' + ", siblings=" + a + ", style=" + b() + '}';
	}

	// $FF: synthetic method
	@Override
	public class_eu f() {
		return h();
	}
}
