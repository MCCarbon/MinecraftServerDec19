package net.minecraft.server;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class class_apo {
	private static final Pattern a = Pattern.compile("^[a-z0-9_]+$");
	private static final Function b = new Function() {
		public String a(class_aqc var1) {
			return var1 == null ? "<NULL>" : var1.a();
		}

		// $FF: synthetic method
		@Override
		public Object apply(Object var1) {
			return this.a((class_aqc) var1);
		}
	};
	private final class_ail c;
	private final ImmutableSortedMap d;
	private final ImmutableList e;

	public class_apo(class_ail var1, class_aqc... var2) {
		c = var1;
		HashMap var3 = Maps.newHashMap();
		class_aqc[] var4 = var2;
		int var5 = var2.length;

		for (int var6 = 0; var6 < var5; ++var6) {
			class_aqc var7 = var4[var6];
			a(var1, var7);
			var3.put(var7.a(), var7);
		}

		d = ImmutableSortedMap.copyOf(var3);
		LinkedHashMap var11 = Maps.newLinkedHashMap();
		ArrayList var12 = Lists.newArrayList();
		Iterable var13 = class_cm.a(e());
		Iterator var14 = var13.iterator();

		while (var14.hasNext()) {
			List var8 = (List) var14.next();
			Map var9 = class_cw.b(d.values(), var8);
			class_apo.class_a_in_class_apo var10 = new class_apo.class_a_in_class_apo(var1, ImmutableMap.copyOf(var9), null);
			var11.put(var9, var10);
			var12.add(var10);
		}

		var14 = var12.iterator();

		while (var14.hasNext()) {
			class_apo.class_a_in_class_apo var15 = (class_apo.class_a_in_class_apo) var14.next();
			var15.a(var11);
		}

		e = ImmutableList.copyOf((Collection) var12);
	}

	public static String a(class_ail var0, class_aqc var1) {
		String var2 = var1.a();
		if (!a.matcher(var2).matches()) {
			throw new IllegalArgumentException("Block: " + var0.getClass() + " has invalidly named property: " + var2);
		} else {
			Iterator var3 = var1.c().iterator();

			String var5;
			do {
				if (!var3.hasNext()) {
					return var2;
				}

				Comparable var4 = (Comparable) var3.next();
				var5 = var1.a(var4);
			} while (a.matcher(var5).matches());

			throw new IllegalArgumentException("Block: " + var0.getClass() + " has property: " + var2 + " with invalidly named value: " + var5);
		}
	}

	public ImmutableList a() {
		return e;
	}

	private List e() {
		ArrayList var1 = Lists.newArrayList();
		ImmutableCollection var2 = d.values();
		Iterator var3 = var2.iterator();

		while (var3.hasNext()) {
			class_aqc var4 = (class_aqc) var3.next();
			var1.add(var4.c());
		}

		return var1;
	}

	public class_apn b() {
		return (class_apn) e.get(0);
	}

	public class_ail c() {
		return c;
	}

	public Collection d() {
		return d.values();
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("block", class_ail.c.b(c)).add("properties", Iterables.transform(d.values(), b)).toString();
	}

	static class class_a_in_class_apo extends class_apm {
		private final class_ail a;
		private final ImmutableMap b;
		private ImmutableTable c;

		private class_a_in_class_apo(class_ail var1, ImmutableMap var2) {
			a = var1;
			b = var2;
		}

		@Override
		public Collection a() {
			return Collections.unmodifiableCollection(b.keySet());
		}

		@Override
		public Comparable b(class_aqc var1) {
			if (!b.containsKey(var1)) {
				throw new IllegalArgumentException("Cannot get property " + var1 + " as it does not exist in " + a.R());
			} else {
				return (Comparable) var1.b().cast(b.get(var1));
			}
		}

		@Override
		public class_apn a(class_aqc var1, Comparable var2) {
			if (!b.containsKey(var1)) {
				throw new IllegalArgumentException("Cannot set property " + var1 + " as it does not exist in " + a.R());
			} else if (!var1.c().contains(var2)) {
				throw new IllegalArgumentException("Cannot set property " + var1 + " to " + var2 + " on block " + class_ail.c.b(a) + ", it is not an allowed value");
			} else {
				return b.get(var1) == var2 ? this : (class_apn) c.get(var1, var2);
			}
		}

		@Override
		public ImmutableMap b() {
			return b;
		}

		@Override
		public class_ail c() {
			return a;
		}

		@Override
		public boolean equals(Object var1) {
			return this == var1;
		}

		@Override
		public int hashCode() {
			return b.hashCode();
		}

		public void a(Map var1) {
			if (c != null) {
				throw new IllegalStateException();
			} else {
				HashBasedTable var2 = HashBasedTable.create();
				Iterator var3 = b.keySet().iterator();

				while (var3.hasNext()) {
					class_aqc var4 = (class_aqc) var3.next();
					Iterator var5 = var4.c().iterator();

					while (var5.hasNext()) {
						Comparable var6 = (Comparable) var5.next();
						if (var6 != b.get(var4)) {
							var2.put(var4, var6, var1.get(this.b(var4, var6)));
						}
					}
				}

				c = ImmutableTable.copyOf(var2);
			}
		}

		private Map b(class_aqc var1, Comparable var2) {
			HashMap var3 = Maps.newHashMap(b);
			var3.put(var1, var2);
			return var3;
		}

		// $FF: synthetic method
		class_a_in_class_apo(class_ail var1, ImmutableMap var2, Object var3) {
			this(var1, var2);
		}
	}
}
