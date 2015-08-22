package net.minecraft.server;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.apache.commons.lang3.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.collect.Maps;

public class class_dd implements class_db {
	private static final Logger a = LogManager.getLogger();
	protected final Map c = b();
	private Object[] b;

	protected Map b() {
		return Maps.newHashMap();
	}

	public Object c(Object var1) {
		return c.get(var1);
	}

	@Override
	public void a(Object var1, Object var2) {
		Validate.notNull(var1);
		Validate.notNull(var2);
		b = null;
		if (c.containsKey(var1)) {
			a.debug("Adding duplicate key \'" + var1 + "\' to registry");
		}

		c.put(var1, var2);
	}

	public Set c() {
		return Collections.unmodifiableSet(c.keySet());
	}

	public Object a(Random var1) {
		if (b == null) {
			Collection var2 = c.values();
			if (var2.isEmpty()) {
				return null;
			}

			b = var2.toArray(new Object[var2.size()]);
		}

		return b[var1.nextInt(b.length)];
	}

	public boolean d(Object var1) {
		return c.containsKey(var1);
	}

	@Override
	public Iterator iterator() {
		return c.values().iterator();
	}
}
