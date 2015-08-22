package net.minecraft.server;

import java.util.Map;

import com.google.common.collect.Maps;

public class class_ni {
	protected final Map a = Maps.newConcurrentMap();

	public boolean a(class_mx var1) {
		return this.a((class_nd) var1) > 0;
	}

	public boolean b(class_mx var1) {
		return (var1.c == null) || this.a(var1.c);
	}

	public void b(class_yu var1, class_nd var2, int var3) {
		if (!var2.d() || this.b((class_mx) var2)) {
			this.a(var1, var2, this.a(var2) + var3);
		}
	}

	public void a(class_yu var1, class_nd var2, int var3) {
		class_nf var4 = (class_nf) a.get(var2);
		if (var4 == null) {
			var4 = new class_nf();
			a.put(var2, var4);
		}

		var4.a(var3);
	}

	public int a(class_nd var1) {
		class_nf var2 = (class_nf) a.get(var1);
		return var2 == null ? 0 : var2.a();
	}

	public class_ng b(class_nd var1) {
		class_nf var2 = (class_nf) a.get(var1);
		return var2 != null ? var2.b() : null;
	}

	public class_ng a(class_nd var1, class_ng var2) {
		class_nf var3 = (class_nf) a.get(var1);
		if (var3 == null) {
			var3 = new class_nf();
			a.put(var1, var3);
		}

		var3.a(var2);
		return var2;
	}
}
