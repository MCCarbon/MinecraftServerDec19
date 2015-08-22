package net.minecraft.server;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class class_aqa extends class_apx {
	private final ImmutableSet a;
	private final Map b = Maps.newHashMap();

	protected class_aqa(String var1, Class var2, Collection var3) {
		super(var1, var2);
		a = ImmutableSet.copyOf(var3);
		Iterator var4 = var3.iterator();

		while (var4.hasNext()) {
			Enum var5 = (Enum) var4.next();
			String var6 = ((class_oe) var5).l();
			if (b.containsKey(var6)) {
				throw new IllegalArgumentException("Multiple values have the same name \'" + var6 + "\'");
			}

			b.put(var6, var5);
		}

	}

	@Override
	public Collection c() {
		return a;
	}

	public String a(Enum var1) {
		return ((class_oe) var1).l();
	}

	@Override
	public boolean equals(Object var1) {
		if (this == var1) {
			return true;
		} else if ((var1 instanceof class_aqa) && super.equals(var1)) {
			class_aqa var2 = (class_aqa) var1;
			return a.equals(var2.a) && b.equals(var2.b);
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int var1 = super.hashCode();
		var1 = (31 * var1) + a.hashCode();
		var1 = (31 * var1) + b.hashCode();
		return var1;
	}

	public static class_aqa a(String var0, Class var1) {
		return a(var0, var1, Predicates.alwaysTrue());
	}

	public static class_aqa a(String var0, Class var1, Predicate var2) {
		return a(var0, var1, Collections2.filter(Lists.newArrayList(var1.getEnumConstants()), var2));
	}

	public static class_aqa a(String var0, Class var1, Enum... var2) {
		return a(var0, var1, Lists.newArrayList((Object[]) var2));
	}

	public static class_aqa a(String var0, Class var1, Collection var2) {
		return new class_aqa(var0, var1, var2);
	}

	// $FF: synthetic method
	// $FF: bridge method
	@Override
	public String a(Comparable var1) {
		return this.a((Enum) var1);
	}
}
