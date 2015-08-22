package net.minecraft.server;

import java.util.List;

import com.google.common.collect.Lists;

public class class_awg {
	private static int a = 256;
	private static List b = Lists.newArrayList();
	private static List c = Lists.newArrayList();
	private static List d = Lists.newArrayList();
	private static List e = Lists.newArrayList();

	public static synchronized int[] a(int var0) {
		int[] var1;
		if (var0 <= 256) {
			if (b.isEmpty()) {
				var1 = new int[256];
				c.add(var1);
				return var1;
			} else {
				var1 = (int[]) b.remove(b.size() - 1);
				c.add(var1);
				return var1;
			}
		} else if (var0 > a) {
			a = var0;
			d.clear();
			e.clear();
			var1 = new int[a];
			e.add(var1);
			return var1;
		} else if (d.isEmpty()) {
			var1 = new int[a];
			e.add(var1);
			return var1;
		} else {
			var1 = (int[]) d.remove(d.size() - 1);
			e.add(var1);
			return var1;
		}
	}

	public static synchronized void a() {
		if (!d.isEmpty()) {
			d.remove(d.size() - 1);
		}

		if (!b.isEmpty()) {
			b.remove(b.size() - 1);
		}

		d.addAll(e);
		b.addAll(c);
		e.clear();
		c.clear();
	}

	public static synchronized String b() {
		return "cache: " + d.size() + ", tcache: " + b.size() + ", allocated: " + e.size() + ", tallocated: " + c.size();
	}
}
