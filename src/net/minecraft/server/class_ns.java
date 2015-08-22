package net.minecraft.server;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Maps;

public class class_ns implements Map {
	private final Map a = Maps.newLinkedHashMap();

	@Override
	public int size() {
		return a.size();
	}

	@Override
	public boolean isEmpty() {
		return a.isEmpty();
	}

	@Override
	public boolean containsKey(Object var1) {
		return a.containsKey(var1.toString().toLowerCase());
	}

	@Override
	public boolean containsValue(Object var1) {
		return a.containsKey(var1);
	}

	@Override
	public Object get(Object var1) {
		return a.get(var1.toString().toLowerCase());
	}

	public Object a(String var1, Object var2) {
		return a.put(var1.toLowerCase(), var2);
	}

	@Override
	public Object remove(Object var1) {
		return a.remove(var1.toString().toLowerCase());
	}

	@Override
	public void putAll(Map var1) {
		Iterator var2 = var1.entrySet().iterator();

		while (var2.hasNext()) {
			Entry var3 = (Entry) var2.next();
			a((String) var3.getKey(), var3.getValue());
		}

	}

	@Override
	public void clear() {
		a.clear();
	}

	@Override
	public Set keySet() {
		return a.keySet();
	}

	@Override
	public Collection values() {
		return a.values();
	}

	@Override
	public Set entrySet() {
		return a.entrySet();
	}

	// $FF: synthetic method
	@Override
	public Object put(Object var1, Object var2) {
		return a((String) var1, var2);
	}
}
