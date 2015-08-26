package net.minecraft.server;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Maps;

public class class_acn {
	private final Map a = Maps.newHashMap();
	private int b;

	public boolean a(Item var1) {
		return this.a(var1, 0.0F) > 0.0F;
	}

	public float a(Item var1, float var2) {
		class_acn.class_a_in_class_acn var3 = (class_acn.class_a_in_class_acn) a.get(var1);
		if (var3 != null) {
			float var4 = var3.b - var3.a;
			float var5 = var3.b - (b + var2);
			return MathHelper.a(var5 / var4, 0.0F, 1.0F);
		} else {
			return 0.0F;
		}
	}

	public void a() {
		++b;
		if (!a.isEmpty()) {
			Iterator var1 = a.entrySet().iterator();

			while (var1.hasNext()) {
				Entry var2 = (Entry) var1.next();
				if (((class_acn.class_a_in_class_acn) var2.getValue()).b <= b) {
					var1.remove();
					c((Item) var2.getKey());
				}
			}
		}

	}

	public void a(Item var1, int var2) {
		a.put(var1, new class_acn.class_a_in_class_acn(b, b + var2));
		b(var1, var2);
	}

	protected void b(Item var1, int var2) {
	}

	protected void c(Item var1) {
	}

	class class_a_in_class_acn {
		final int a;
		final int b;

		private class_a_in_class_acn(int var2, int var3) {
			a = var2;
			b = var3;
		}

	}
}
