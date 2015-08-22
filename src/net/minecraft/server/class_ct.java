package net.minecraft.server;

import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;

import com.google.common.base.Predicates;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;

public class class_ct implements class_cs {
	private final IdentityHashMap a;
	private final List b;

	public class_ct() {
		this(512);
	}

	public class_ct(int var1) {
		b = Lists.newArrayListWithExpectedSize(var1);
		a = new IdentityHashMap(var1);
	}

	public void a(Object var1, int var2) {
		a.put(var1, Integer.valueOf(var2));

		while (b.size() <= var2) {
			b.add((Object) null);
		}

		b.set(var2, var1);
	}

	public int a(Object var1) {
		Integer var2 = (Integer) a.get(var1);
		return var2 == null ? -1 : var2.intValue();
	}

	public final Object a(int var1) {
		return (var1 >= 0) && (var1 < b.size()) ? b.get(var1) : null;
	}

	@Override
	public Iterator iterator() {
		return Iterators.filter(b.iterator(), Predicates.notNull());
	}

	public int a() {
		return a.size();
	}
}
