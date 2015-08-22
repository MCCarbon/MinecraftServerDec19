package net.minecraft.server;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.base.Predicate;
import com.google.common.collect.Maps;

public class class_apv implements Predicate {
	private final class_apo a;
	private final Map b = Maps.newHashMap();

	private class_apv(class_apo var1) {
		a = var1;
	}

	public static class_apv a(class_ail var0) {
		return new class_apv(var0.R());
	}

	public boolean a(class_apn var1) {
		if ((var1 != null) && var1.c().equals(a.c())) {
			Iterator var2 = b.entrySet().iterator();

			Entry var3;
			Comparable var4;
			do {
				if (!var2.hasNext()) {
					return true;
				}

				var3 = (Entry) var2.next();
				var4 = var1.b((class_aqc) var3.getKey());
			} while (((Predicate) var3.getValue()).apply(var4));

			return false;
		} else {
			return false;
		}
	}

	public class_apv a(class_aqc var1, Predicate var2) {
		if (!a.d().contains(var1)) {
			throw new IllegalArgumentException(a + " cannot support property " + var1);
		} else {
			b.put(var1, var2);
			return this;
		}
	}

	// $FF: synthetic method
	@Override
	public boolean apply(Object var1) {
		return this.a((class_apn) var1);
	}
}
