package net.minecraft.server;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.common.collect.Lists;

public class class_aew implements class_aes {
	private final class_aco a;
	private final List b;

	public class_aew(class_aco var1, List var2) {
		a = var1;
		b = var2;
	}

	@Override
	public class_aco b() {
		return a;
	}

	@Override
	public class_aco[] b(class_aab var1) {
		class_aco[] var2 = new class_aco[var1.n_()];

		for (int var3 = 0; var3 < var2.length; ++var3) {
			class_aco var4 = var1.a(var3);
			if ((var4 != null) && var4.b().r()) {
				var2[var3] = new class_aco(var4.b().q());
			}
		}

		return var2;
	}

	@Override
	public boolean a(class_aab var1, class_ago var2) {
		ArrayList var3 = Lists.newArrayList((Iterable) b);

		for (int var4 = 0; var4 < var1.h(); ++var4) {
			for (int var5 = 0; var5 < var1.i(); ++var5) {
				class_aco var6 = var1.c(var5, var4);
				if (var6 != null) {
					boolean var7 = false;
					Iterator var8 = var3.iterator();

					while (var8.hasNext()) {
						class_aco var9 = (class_aco) var8.next();
						if ((var6.b() == var9.b()) && ((var9.i() == 32767) || (var6.i() == var9.i()))) {
							var7 = true;
							var3.remove(var9);
							break;
						}
					}

					if (!var7) {
						return false;
					}
				}
			}
		}

		return var3.isEmpty();
	}

	@Override
	public class_aco a(class_aab var1) {
		return a.k();
	}

	@Override
	public int a() {
		return b.size();
	}
}
