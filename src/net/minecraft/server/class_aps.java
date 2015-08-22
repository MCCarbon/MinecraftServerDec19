package net.minecraft.server;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class class_aps {
	private static final Joiner a = Joiner.on(",");
	private final List b = Lists.newArrayList();
	private final Map c = Maps.newHashMap();
	private int d;
	private int e;

	private class_aps() {
		c.put(Character.valueOf(' '), Predicates.alwaysTrue());
	}

	public class_aps a(String... var1) {
		if (!ArrayUtils.isEmpty(var1) && !StringUtils.isEmpty(var1[0])) {
			if (b.isEmpty()) {
				d = var1.length;
				e = var1[0].length();
			}

			if (var1.length != d) {
				throw new IllegalArgumentException("Expected aisle with height of " + d + ", but was given one with a height of " + var1.length + ")");
			} else {
				String[] var2 = var1;
				int var3 = var1.length;

				for (int var4 = 0; var4 < var3; ++var4) {
					String var5 = var2[var4];
					if (var5.length() != e) {
						throw new IllegalArgumentException("Not all rows in the given aisle are the correct width (expected " + e + ", found one with " + var5.length() + ")");
					}

					char[] var6 = var5.toCharArray();
					int var7 = var6.length;

					for (int var8 = 0; var8 < var7; ++var8) {
						char var9 = var6[var8];
						if (!c.containsKey(Character.valueOf(var9))) {
							c.put(Character.valueOf(var9), (Object) null);
						}
					}
				}

				b.add(var1);
				return this;
			}
		} else {
			throw new IllegalArgumentException("Empty pattern for aisle");
		}
	}

	public static class_aps a() {
		return new class_aps();
	}

	public class_aps a(char var1, Predicate var2) {
		c.put(Character.valueOf(var1), var2);
		return this;
	}

	public class_apr b() {
		return new class_apr(c());
	}

	private Predicate[][][] c() {
		d();
		Predicate[][][] var1 = ((Predicate[][][]) Array.newInstance(Predicate.class, new int[] { b.size(), d, e }));

		for (int var2 = 0; var2 < b.size(); ++var2) {
			for (int var3 = 0; var3 < d; ++var3) {
				for (int var4 = 0; var4 < e; ++var4) {
					var1[var2][var3][var4] = (Predicate) c.get(Character.valueOf(((String[]) b.get(var2))[var3].charAt(var4)));
				}
			}
		}

		return var1;
	}

	private void d() {
		ArrayList var1 = Lists.newArrayList();
		Iterator var2 = c.entrySet().iterator();

		while (var2.hasNext()) {
			Entry var3 = (Entry) var2.next();
			if (var3.getValue() == null) {
				var1.add(var3.getKey());
			}
		}

		if (!var1.isEmpty()) {
			throw new IllegalStateException("Predicates for character(s) " + a.join(var1) + " are missing");
		}
	}
}
