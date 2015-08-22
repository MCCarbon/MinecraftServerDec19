package net.minecraft.server;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;

public abstract class class_rt {
	protected final Map a = Maps.newHashMap();
	protected final Map b = new class_ns();
	protected final Multimap c = HashMultimap.create();

	public class_rq a(class_rp var1) {
		return (class_rq) a.get(var1);
	}

	public class_rq a(String var1) {
		return (class_rq) b.get(var1);
	}

	public class_rq b(class_rp var1) {
		if (b.containsKey(var1.a())) {
			throw new IllegalArgumentException("Attribute is already registered!");
		} else {
			class_rq var2 = c(var1);
			b.put(var1.a(), var2);
			a.put(var1, var2);

			for (class_rp var3 = var1.d(); var3 != null; var3 = var3.d()) {
				c.put(var3, var1);
			}

			return var2;
		}
	}

	protected abstract class_rq c(class_rp var1);

	public Collection a() {
		return b.values();
	}

	public void a(class_rq var1) {
	}

	public void a(Multimap var1) {
		Iterator var2 = var1.entries().iterator();

		while (var2.hasNext()) {
			Entry var3 = (Entry) var2.next();
			class_rq var4 = this.a((String) var3.getKey());
			if (var4 != null) {
				var4.c((class_rr) var3.getValue());
			}
		}

	}

	public void b(Multimap var1) {
		Iterator var2 = var1.entries().iterator();

		while (var2.hasNext()) {
			Entry var3 = (Entry) var2.next();
			class_rq var4 = this.a((String) var3.getKey());
			if (var4 != null) {
				var4.c((class_rr) var3.getValue());
				var4.b((class_rr) var3.getValue());
			}
		}

	}
}
