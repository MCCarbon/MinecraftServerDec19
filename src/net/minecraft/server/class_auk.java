package net.minecraft.server;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import com.google.common.collect.Lists;

public class class_auk extends class_auo {
	private static final List d;
	private List f;
	private int g;
	private int h;

	public class_auk() {
		f = Lists.newArrayList();
		g = 32;
		h = 8;
		f.add(new class_ahb.class_c_in_class_ahb(class_yk.class, 1, 1, 1));
	}

	public class_auk(Map var1) {
		this();
		Iterator var2 = var1.entrySet().iterator();

		while (var2.hasNext()) {
			Entry var3 = (Entry) var2.next();
			if (((String) var3.getKey()).equals("distance")) {
				g = class_oa.a((String) var3.getValue(), g, h + 1);
			}
		}

	}

	@Override
	public String a() {
		return "Temple";
	}

	@Override
	protected boolean a(int var1, int var2) {
		int var3 = var1;
		int var4 = var2;
		if (var1 < 0) {
			var1 -= g - 1;
		}

		if (var2 < 0) {
			var2 -= g - 1;
		}

		int var5 = var1 / g;
		int var6 = var2 / g;
		Random var7 = c.a(var5, var6, 14357617);
		var5 *= g;
		var6 *= g;
		var5 += var7.nextInt(g - h);
		var6 += var7.nextInt(g - h);
		if ((var3 == var5) && (var4 == var6)) {
			class_ahb var8 = c.y().a(new class_cj((var3 * 16) + 8, 0, (var4 * 16) + 8));
			if (var8 == null) {
				return false;
			}

			Iterator var9 = d.iterator();

			while (var9.hasNext()) {
				class_ahb var10 = (class_ahb) var9.next();
				if (var8 == var10) {
					return true;
				}
			}
		}

		return false;
	}

	@Override
	protected class_aus b(int var1, int var2) {
		return new class_auk.class_a_in_class_auk(c, b, var1, var2);
	}

	public boolean a(class_cj var1) {
		class_aus var2 = c(var1);
		if ((var2 != null) && (var2 instanceof class_auk.class_a_in_class_auk) && !var2.a.isEmpty()) {
			class_aur var3 = (class_aur) var2.a.get(0);
			return var3 instanceof class_aul.class_d_in_class_aul;
		} else {
			return false;
		}
	}

	public List b() {
		return f;
	}

	static {
		d = Arrays.asList(new class_ahb[] { class_ahb.r, class_ahb.G, class_ahb.K, class_ahb.L, class_ahb.v });
	}

	public static class class_a_in_class_auk extends class_aus {
		public class_a_in_class_auk() {
		}

		public class_a_in_class_auk(class_ago var1, Random var2, int var3, int var4) {
			this(var1, var2, var3, var4, var1.b(new class_cj((var3 * 16) + 8, 0, (var4 * 16) + 8)));
		}

		public class_a_in_class_auk(class_ago var1, Random var2, int var3, int var4, class_ahb var5) {
			super(var3, var4);
			if ((var5 != class_ahb.K) && (var5 != class_ahb.L)) {
				if (var5 == class_ahb.v) {
					class_aul.class_d_in_class_aul var7 = new class_aul.class_d_in_class_aul(var2, var3 * 16, var4 * 16);
					a.add(var7);
				} else if ((var5 == class_ahb.r) || (var5 == class_ahb.G)) {
					class_aul.class_a_in_class_aul var8 = new class_aul.class_a_in_class_aul(var2, var3 * 16, var4 * 16);
					a.add(var8);
				}
			} else {
				class_aul.class_b_in_class_aul var6 = new class_aul.class_b_in_class_aul(var2, var3 * 16, var4 * 16);
				a.add(var6);
			}

			d();
		}
	}
}
