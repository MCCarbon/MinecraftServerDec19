package net.minecraft.server;

import java.util.List;

import com.google.common.collect.Lists;

public class class_uq {
	class_rh a;
	List b = Lists.newArrayList();
	List c = Lists.newArrayList();

	public class_uq(class_rh var1) {
		a = var1;
	}

	public void a() {
		b.clear();
		c.clear();
	}

	public boolean a(Entity var1) {
		if (b.contains(var1)) {
			return true;
		} else if (c.contains(var1)) {
			return false;
		} else {
			a.o.B.a("canSee");
			boolean var2 = a.t(var1);
			a.o.B.b();
			if (var2) {
				b.add(var1);
			} else {
				c.add(var1);
			}

			return var2;
		}
	}
}
