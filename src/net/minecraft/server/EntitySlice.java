package net.minecraft.server;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

public class EntitySlice extends AbstractSet {

	private static final Set a = Sets.newHashSet();
	private final Map b = Maps.newHashMap();
	private final Set c = Sets.newIdentityHashSet();
	private final Class d;
	private final List e = Lists.newArrayList();

	public EntitySlice(Class var1) {
		d = var1;
		c.add(var1);
		b.put(var1, e);
		Iterator var2 = a.iterator();

		while (var2.hasNext()) {
			Class var3 = (Class) var2.next();
			this.a(var3);
		}

	}

	protected void a(Class var1) {
		a.add(var1);
		Iterator var2 = e.iterator();

		while (var2.hasNext()) {
			Object var3 = var2.next();
			if (var1.isAssignableFrom(var3.getClass())) {
				this.a(var3, var1);
			}
		}

		c.add(var1);
	}

	protected Class b(Class var1) {
		if (d.isAssignableFrom(var1)) {
			if (!c.contains(var1)) {
				this.a(var1);
			}

			return var1;
		} else {
			throw new IllegalArgumentException("Don\'t know how to search for " + var1);
		}
	}

	@Override
	public boolean add(Object var1) {
		Iterator var2 = c.iterator();

		while (var2.hasNext()) {
			Class var3 = (Class) var2.next();
			if (var3.isAssignableFrom(var1.getClass())) {
				this.a(var1, var3);
			}
		}

		return true;
	}

	private void a(Object var1, Class var2) {
		List var3 = (List) b.get(var2);
		if (var3 == null) {
			b.put(var2, Lists.newArrayList(new Object[] { var1 }));
		} else {
			var3.add(var1);
		}

	}

	@Override
	public boolean remove(Object var1) {
		Object var2 = var1;
		boolean var3 = false;
		Iterator var4 = c.iterator();

		while (var4.hasNext()) {
			Class var5 = (Class) var4.next();
			if (var5.isAssignableFrom(var2.getClass())) {
				List var6 = (List) b.get(var5);
				if ((var6 != null) && var6.remove(var2)) {
					var3 = true;
				}
			}
		}

		return var3;
	}

	@Override
	public boolean contains(Object var1) {
		return Iterators.contains(c(var1.getClass()).iterator(), var1);
	}

	public Iterable c(final Class var1) {
		return new Iterable() {
			@Override
			public Iterator iterator() {
				List var1x = (List) b.get(EntitySlice.this.b(var1));
				if (var1x == null) {
					return Iterators.emptyIterator();
				} else {
					Iterator var2 = var1x.iterator();
					return Iterators.filter(var2, var1);
				}
			}
		};
	}

	@Override
	public Iterator iterator() {
		return e.isEmpty() ? Iterators.emptyIterator() : Iterators.unmodifiableIterator(e.iterator());
	}

	@Override
	public int size() {
		return e.size();
	}

}
