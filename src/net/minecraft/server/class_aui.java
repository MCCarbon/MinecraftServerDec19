package net.minecraft.server;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class class_aui extends class_auo {
	private int f;
	private int g;
	public static final List d;
	private static final List h;

	public class_aui() {
		f = 32;
		g = 5;
	}

	public class_aui(Map var1) {
		this();
		Iterator var2 = var1.entrySet().iterator();

		while (var2.hasNext()) {
			Entry var3 = (Entry) var2.next();
			if (((String) var3.getKey()).equals("spacing")) {
				f = class_oa.a(((String) var3.getValue()), f, 1);
			} else if (((String) var3.getKey()).equals("separation")) {
				g = class_oa.a(((String) var3.getValue()), g, 1);
			}
		}

	}

	@Override
	public String a() {
		return "Monument";
	}

	@Override
	protected boolean a(int var1, int var2) {
		int var3 = var1;
		int var4 = var2;
		if (var1 < 0) {
			var1 -= f - 1;
		}

		if (var2 < 0) {
			var2 -= f - 1;
		}

		int var5 = var1 / f;
		int var6 = var2 / f;
		Random var7 = c.a(var5, var6, 10387313);
		var5 *= f;
		var6 *= f;
		var5 += (var7.nextInt(f - g) + var7.nextInt(f - g)) / 2;
		var6 += (var7.nextInt(f - g) + var7.nextInt(f - g)) / 2;
		if ((var3 == var5) && (var4 == var6)) {
			if (c.y().a(new class_cj((var3 * 16) + 8, 64, (var4 * 16) + 8), (class_ahb) null) != class_ahb.N) {
				return false;
			}

			boolean var8 = c.y().a((var3 * 16) + 8, (var4 * 16) + 8, 29, d);
			if (var8) {
				return true;
			}
		}

		return false;
	}

	@Override
	protected class_aus b(int var1, int var2) {
		return new class_aui.class_a_in_class_aui(c, b, var1, var2);
	}

	public List b() {
		return h;
	}

	static {
		d = Arrays.asList(new class_ahb[] { class_ahb.p, class_ahb.N, class_ahb.w, class_ahb.z, class_ahb.A });
		h = Lists.newArrayList();
		h.add(new class_ahb.class_c_in_class_ahb(class_ya.class, 1, 2, 4));
	}

	public static class class_a_in_class_aui extends class_aus {
		private Set c = Sets.newHashSet();
		private boolean d;

		public class_a_in_class_aui() {
		}

		public class_a_in_class_aui(class_ago var1, Random var2, int var3, int var4) {
			super(var3, var4);
			this.b(var1, var2, var3, var4);
		}

		private void b(class_ago var1, Random var2, int var3, int var4) {
			var2.setSeed(var1.L());
			long var5 = var2.nextLong();
			long var7 = var2.nextLong();
			long var9 = var3 * var5;
			long var11 = var4 * var7;
			var2.setSeed(var9 ^ var11 ^ var1.L());
			int var13 = ((var3 * 16) + 8) - 29;
			int var14 = ((var4 * 16) + 8) - 29;
			class_cq var15 = class_cq.class_c_in_class_cq.a.a(var2);
			a.add(new class_auj.class_h_in_class_auj(var2, var13, var14, var15));
			d();
			d = true;
		}

		@Override
		public void a(class_ago var1, Random var2, class_aua var3) {
			if (!d) {
				a.clear();
				this.b(var1, var2, e(), f());
			}

			super.a(var1, var2, var3);
		}

		@Override
		public boolean a(class_agi var1) {
			return c.contains(var1) ? false : super.a(var1);
		}

		@Override
		public void b(class_agi var1) {
			super.b(var1);
			c.add(var1);
		}

		@Override
		public void a(class_dn var1) {
			super.a(var1);
			class_du var2 = new class_du();
			Iterator var3 = c.iterator();

			while (var3.hasNext()) {
				class_agi var4 = (class_agi) var3.next();
				class_dn var5 = new class_dn();
				var5.a("X", var4.a);
				var5.a("Z", var4.b);
				var2.a(var5);
			}

			var1.a("Processed", var2);
		}

		@Override
		public void b(class_dn var1) {
			super.b(var1);
			if (var1.b("Processed", 9)) {
				class_du var2 = var1.c("Processed", 10);

				for (int var3 = 0; var3 < var2.c(); ++var3) {
					class_dn var4 = var2.b(var3);
					c.add(new class_agi(var4.h("X"), var4.h("Z")));
				}
			}

		}
	}
}
