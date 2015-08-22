package net.minecraft.server;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class class_auu extends class_auo {
	public static final List d;
	private int f;
	private int g;
	private int h;

	public class_auu() {
		g = 32;
		h = 8;
	}

	public class_auu(Map var1) {
		this();
		Iterator var2 = var1.entrySet().iterator();

		while (var2.hasNext()) {
			Entry var3 = (Entry) var2.next();
			if (((String) var3.getKey()).equals("size")) {
				f = class_oa.a(((String) var3.getValue()), f, 0);
			} else if (((String) var3.getKey()).equals("distance")) {
				g = class_oa.a((String) var3.getValue(), g, h + 1);
			}
		}

	}

	@Override
	public String a() {
		return "Village";
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
		Random var7 = c.a(var5, var6, 10387312);
		var5 *= g;
		var6 *= g;
		var5 += var7.nextInt(g - h);
		var6 += var7.nextInt(g - h);
		if ((var3 == var5) && (var4 == var6)) {
			boolean var8 = c.y().a((var3 * 16) + 8, (var4 * 16) + 8, 0, d);
			if (var8) {
				return true;
			}
		}

		return false;
	}

	@Override
	protected class_aus b(int var1, int var2) {
		return new class_auu.class_a_in_class_auu(c, b, var1, var2, f);
	}

	static {
		d = Arrays.asList(new class_ahb[] { class_ahb.q, class_ahb.r, class_ahb.Y });
	}

	public static class class_a_in_class_auu extends class_aus {
		private boolean c;

		public class_a_in_class_auu() {
		}

		public class_a_in_class_auu(class_ago var1, Random var2, int var3, int var4, int var5) {
			super(var3, var4);
			List var6 = class_auv.a(var2, var5);
			class_auv.class_k_in_class_auv var7 = new class_auv.class_k_in_class_auv(var1.y(), 0, var2, (var3 << 4) + 2, (var4 << 4) + 2, var6, var5);
			a.add(var7);
			var7.a(var7, a, var2);
			List var8 = var7.g;
			List var9 = var7.f;

			int var10;
			while (!var8.isEmpty() || !var9.isEmpty()) {
				class_aur var11;
				if (var8.isEmpty()) {
					var10 = var2.nextInt(var9.size());
					var11 = (class_aur) var9.remove(var10);
					var11.a(var7, a, var2);
				} else {
					var10 = var2.nextInt(var8.size());
					var11 = (class_aur) var8.remove(var10);
					var11.a(var7, a, var2);
				}
			}

			d();
			var10 = 0;
			Iterator var13 = a.iterator();

			while (var13.hasNext()) {
				class_aur var12 = (class_aur) var13.next();
				if (!(var12 instanceof class_auv.class_o_in_class_auv)) {
					++var10;
				}
			}

			c = var10 > 2;
		}

		@Override
		public boolean a() {
			return c;
		}

		@Override
		public void a(class_dn var1) {
			super.a(var1);
			var1.a("Valid", c);
		}

		@Override
		public void b(class_dn var1) {
			super.b(var1);
			c = var1.p("Valid");
		}
	}
}
