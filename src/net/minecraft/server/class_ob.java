package net.minecraft.server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class class_ob {
	private static final Logger b = LogManager.getLogger();
	private final List c = Lists.newArrayList();
	private final List d = Lists.newArrayList();
	public boolean a;
	private String e = "";
	private final Map f = Maps.newHashMap();

	public void a() {
		f.clear();
		e = "";
		c.clear();
	}

	public void a(String var1) {
		if (a) {
			if (e.length() > 0) {
				e = e + ".";
			}

			e = e + var1;
			c.add(e);
			d.add(Long.valueOf(System.nanoTime()));
		}
	}

	public void b() {
		if (a) {
			long var1 = System.nanoTime();
			long var3 = ((Long) d.remove(d.size() - 1)).longValue();
			c.remove(c.size() - 1);
			long var5 = var1 - var3;
			if (f.containsKey(e)) {
				f.put(e, Long.valueOf(((Long) f.get(e)).longValue() + var5));
			} else {
				f.put(e, Long.valueOf(var5));
			}

			if (var5 > 100000000L) {
				b.warn("Something\'s taking too long! \'" + e + "\' took aprox " + (var5 / 1000000.0D) + " ms");
			}

			e = !c.isEmpty() ? (String) c.get(c.size() - 1) : "";
		}
	}

	public List b(String var1) {
		if (!a) {
			return null;
		} else {
			long var3 = f.containsKey("root") ? ((Long) f.get("root")).longValue() : 0L;
			long var5 = f.containsKey(var1) ? ((Long) f.get(var1)).longValue() : -1L;
			ArrayList var7 = Lists.newArrayList();
			if (var1.length() > 0) {
				var1 = var1 + ".";
			}

			long var8 = 0L;
			Iterator var10 = f.keySet().iterator();

			while (var10.hasNext()) {
				String var11 = (String) var10.next();
				if ((var11.length() > var1.length()) && var11.startsWith(var1) && (var11.indexOf(".", var1.length() + 1) < 0)) {
					var8 += ((Long) f.get(var11)).longValue();
				}
			}

			float var20 = var8;
			if (var8 < var5) {
				var8 = var5;
			}

			if (var3 < var8) {
				var3 = var8;
			}

			Iterator var21 = f.keySet().iterator();

			String var12;
			while (var21.hasNext()) {
				var12 = (String) var21.next();
				if ((var12.length() > var1.length()) && var12.startsWith(var1) && (var12.indexOf(".", var1.length() + 1) < 0)) {
					long var13 = ((Long) f.get(var12)).longValue();
					double var15 = (var13 * 100.0D) / var8;
					double var17 = (var13 * 100.0D) / var3;
					String var19 = var12.substring(var1.length());
					var7.add(new class_ob.class_a_in_class_ob(var19, var15, var17));
				}
			}

			var21 = f.keySet().iterator();

			while (var21.hasNext()) {
				var12 = (String) var21.next();
				f.put(var12, Long.valueOf((((Long) f.get(var12)).longValue() * 999L) / 1000L));
			}

			if (var8 > var20) {
				var7.add(new class_ob.class_a_in_class_ob("unspecified", ((var8 - var20) * 100.0D) / var8, ((var8 - var20) * 100.0D) / var3));
			}

			Collections.sort(var7);
			var7.add(0, new class_ob.class_a_in_class_ob(var1, 100.0D, (var8 * 100.0D) / var3));
			return var7;
		}
	}

	public void c(String var1) {
		this.b();
		this.a(var1);
	}

	public String c() {
		return c.size() == 0 ? "[UNKNOWN]" : (String) c.get(c.size() - 1);
	}

	public static final class class_a_in_class_ob implements Comparable {
		public double a;
		public double b;
		public String c;

		public class_a_in_class_ob(String var1, double var2, double var4) {
			c = var1;
			a = var2;
			b = var4;
		}

		public int a(class_ob.class_a_in_class_ob var1) {
			return var1.a < a ? -1 : (var1.a > a ? 1 : var1.c.compareTo(c));
		}

		// $FF: synthetic method
		@Override
		public int compareTo(Object var1) {
			return this.a((class_ob.class_a_in_class_ob) var1);
		}
	}
}
