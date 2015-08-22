package net.minecraft.server;

import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

import com.google.common.collect.Maps;

public class class_cw {
	public static Map b(Iterable var0, Iterable var1) {
		return a(var0, var1, Maps.newLinkedHashMap());
	}

	public static Map a(Iterable var0, Iterable var1, Map var2) {
		Iterator var3 = var1.iterator();
		Iterator var4 = var0.iterator();

		while (var4.hasNext()) {
			Object var5 = var4.next();
			var2.put(var5, var3.next());
		}

		if (var3.hasNext()) {
			throw new NoSuchElementException();
		} else {
			return var2;
		}
	}
}
