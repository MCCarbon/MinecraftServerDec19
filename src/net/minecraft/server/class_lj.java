package net.minecraft.server;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import com.google.common.collect.Sets;

public class class_lj extends class_pn {
	private final Set g = Sets.newHashSet();
	private final Set h;
	private boolean i;

	public class_lj(IChatBaseComponent var1, class_pn.class_a_in_class_pn var2, class_pn.class_b_in_class_pn var3, boolean var4, boolean var5) {
		super(MathHelper.a(), var1, var2, var3, var4, var5);
		h = Collections.unmodifiableSet(g);
		i = true;
	}

	@Override
	public void a(float var1) {
		if (var1 != b) {
			super.a(var1);
			this.a(class_fw.class_a_in_class_fw.c);
		}

	}

	private void a(class_fw.class_a_in_class_fw var1) {
		if (i) {
			class_fw var2 = new class_fw(var1, this);
			Iterator var3 = g.iterator();

			while (var3.hasNext()) {
				class_lm var4 = (class_lm) var3.next();
				var4.a.a(var2);
			}
		}

	}

	public void a(class_lm var1) {
		if (g.add(var1) && i) {
			var1.a.a((new class_fw(class_fw.class_a_in_class_fw.a, this)));
		}

	}

	public void b(class_lm var1) {
		if (g.remove(var1) && i) {
			var1.a.a((new class_fw(class_fw.class_a_in_class_fw.b, this)));
		}

	}

	public void c(boolean var1) {
		if (var1 != i) {
			i = var1;
			Iterator var2 = g.iterator();

			while (var2.hasNext()) {
				class_lm var3 = (class_lm) var2.next();
				var3.a.a((new class_fw(var1 ? class_fw.class_a_in_class_fw.a : class_fw.class_a_in_class_fw.b, this)));
			}
		}

	}

	public Collection c() {
		return h;
	}
}
