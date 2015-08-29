package net.minecraft.server;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class class_afl {
	private static final Random a = new Random();
	private static final class_afl.class_e_in_class_afl b = new class_afl.class_e_in_class_afl();
	private static final class_afl.class_d_in_class_afl c = new class_afl.class_d_in_class_afl();
	private static final class_afl.class_b_in_class_afl d = new class_afl.class_b_in_class_afl();
	private static final class_afl.class_a_in_class_afl e = new class_afl.class_a_in_class_afl();

	public static int a(class_afj var0, class_aco var1) {
		if (var1 == null) {
			return 0;
		} else {
			class_du var2 = var1.p();
			if (var2 == null) {
				return 0;
			} else {
				for (int var3 = 0; var3 < var2.c(); ++var3) {
					class_afj var4 = class_afj.c(var2.b(var3).g("id"));
					short var5 = var2.b(var3).g("lvl");
					if (var4 == var0) {
						return var5;
					}
				}

				return 0;
			}
		}
	}

	public static Map a(class_aco var0) {
		LinkedHashMap var1 = Maps.newLinkedHashMap();
		class_du var2 = var0.b() == Items.ci ? Items.ci.h(var0) : var0.p();
		if (var2 != null) {
			for (int var3 = 0; var3 < var2.c(); ++var3) {
				class_afj var4 = class_afj.c(var2.b(var3).g("id"));
				short var5 = var2.b(var3).g("lvl");
				var1.put(var4, Integer.valueOf(var5));
			}
		}

		return var1;
	}

	public static void a(Map var0, class_aco var1) {
		class_du var2 = new class_du();
		Iterator var3 = var0.entrySet().iterator();

		while (var3.hasNext()) {
			Entry var4 = (Entry) var3.next();
			class_afj var5 = (class_afj) var4.getKey();
			if (var5 != null) {
				int var6 = ((Integer) var4.getValue()).intValue();
				class_dn var7 = new class_dn();
				var7.a("id", (short) class_afj.b(var5));
				var7.a("lvl", (short) var6);
				var2.a(var7);
				if (var1.b() == Items.ci) {
					Items.ci.a(var1, new class_afm(var5, var6));
				}
			}
		}

		if (var2.c_()) {
			if (var1.n()) {
				var1.o().q("ench");
			}
		} else if (var1.b() != Items.ci) {
			var1.a("ench", var2);
		}

	}

	private static void a(class_afl.class_c_in_class_afl var0, class_aco var1) {
		if (var1 != null) {
			class_du var2 = var1.p();
			if (var2 != null) {
				for (int var3 = 0; var3 < var2.c(); ++var3) {
					short var4 = var2.b(var3).g("id");
					short var5 = var2.b(var3).g("lvl");
					if (class_afj.c(var4) != null) {
						var0.a(class_afj.c(var4), var5);
					}
				}

			}
		}
	}

	private static void a(class_afl.class_c_in_class_afl var0, Iterable var1) {
		Iterator var2 = var1.iterator();

		while (var2.hasNext()) {
			class_aco var3 = (class_aco) var2.next();
			a(var0, var3);
		}

	}

	public static int a(Iterable var0, class_qi var1) {
		b.a = 0;
		b.b = var1;
		a(b, var0);
		if (b.a > 25) {
			b.a = 25;
		} else if (b.a < 0) {
			b.a = 0;
		}

		return ((b.a + 1) >> 1) + a.nextInt((b.a >> 1) + 1);
	}

	public static float a(class_aco var0, class_rl var1) {
		c.a = 0.0F;
		c.b = var1;
		a(c, var0);
		return c.a;
	}

	public static void a(EntityLiving var0, Entity var1) {
		d.b = var1;
		d.a = var0;
		if (var0 != null) {
			a(d, var0.ax());
		}

		if (var1 instanceof class_yu) {
			a(d, var0.bG());
		}

	}

	public static void b(EntityLiving var0, Entity var1) {
		e.a = var0;
		e.b = var1;
		if (var0 != null) {
			a(e, var0.ax());
		}

		if (var0 instanceof class_yu) {
			a(e, var0.bG());
		}

	}

	public static int a(class_afj var0, EntityLiving var1) {
		Iterable var2 = var0.a(var1);
		if (var2 == null) {
			return 0;
		} else {
			int var3 = 0;
			Iterator var4 = var2.iterator();

			while (var4.hasNext()) {
				class_aco var5 = (class_aco) var4.next();
				int var6 = a(var0, var5);
				if (var6 > var3) {
					var3 = var6;
				}
			}

			return var3;
		}
	}

	public static int a(EntityLiving var0) {
		return a(class_afn.m, var0);
	}

	public static int b(EntityLiving var0) {
		return a(class_afn.n, var0);
	}

	public static int c(EntityLiving var0) {
		return a(class_afn.f, var0);
	}

	public static int d(EntityLiving var0) {
		return a(class_afn.i, var0);
	}

	public static int e(EntityLiving var0) {
		return a(class_afn.p, var0);
	}

	public static int f(EntityLiving var0) {
		return a(class_afn.x, var0);
	}

	public static int g(EntityLiving var0) {
		return a(class_afn.y, var0);
	}

	public static int h(EntityLiving var0) {
		return a(class_afn.o, var0);
	}

	public static boolean i(EntityLiving var0) {
		return a(class_afn.g, var0) > 0;
	}

	public static class_aco b(class_afj var0, EntityLiving var1) {
		Iterable var2 = var0.a(var1);
		if (var2 == null) {
			return null;
		} else {
			Iterator var3 = var2.iterator();

			class_aco var4;
			do {
				if (!var3.hasNext()) {
					return null;
				}

				var4 = (class_aco) var3.next();
			} while ((var4 == null) || (a(var0, var4) <= 0));

			return var4;
		}
	}

	public static int a(Random var0, int var1, int var2, class_aco var3) {
		Item var4 = var3.b();
		int var5 = var4.c();
		if (var5 <= 0) {
			return 0;
		} else {
			if (var2 > 15) {
				var2 = 15;
			}

			int var6 = var0.nextInt(8) + 1 + (var2 >> 1) + var0.nextInt(var2 + 1);
			return var1 == 0 ? Math.max(var6 / 3, 1) : (var1 == 1 ? ((var6 * 2) / 3) + 1 : Math.max(var6, var2 * 2));
		}
	}

	public static class_aco a(Random var0, class_aco var1, int var2) {
		boolean var3 = var1.b() == Items.aN;
		if (var3) {
			var1.a(Items.ci);
		}

		List var4 = b(var0, var1, var2);
		Iterator var5 = var4.iterator();

		while (var5.hasNext()) {
			class_afm var6 = (class_afm) var5.next();
			if (var3) {
				Items.ci.a(var1, var6);
			} else {
				var1.a(var6.b, var6.c);
			}
		}

		return var1;
	}

	public static List b(Random var0, class_aco var1, int var2) {
		ArrayList var3 = Lists.newArrayList();
		Item var4 = var1.b();
		int var5 = var4.c();
		if (var5 <= 0) {
			return var3;
		} else {
			var2 += 1 + var0.nextInt((var5 / 4) + 1) + var0.nextInt((var5 / 4) + 1);
			float var6 = ((var0.nextFloat() + var0.nextFloat()) - 1.0F) * 0.15F;
			var2 = MathHelper.a(Math.round(var2 + (var2 * var6)), 1, Integer.MAX_VALUE);
			List var7 = a(var2, var1);
			if (!var7.isEmpty()) {
				var3.add(class_oi.a(var0, var7));

				while (var0.nextInt(50) <= var2) {
					a(var7, (class_afm) class_g.a(var3));
					if (var7.isEmpty()) {
						break;
					}

					var3.add(class_oi.a(var0, var7));
					var2 /= 2;
				}
			}

			return var3;
		}
	}

	public static void a(List var0, class_afm var1) {
		Iterator var2 = var0.iterator();

		while (var2.hasNext()) {
			if (!var1.b.a(((class_afm) var2.next()).b)) {
				var2.remove();
			}
		}

	}

	public static List a(int var0, class_aco var1) {
		ArrayList var2 = Lists.newArrayList();
		Item var3 = var1.b();
		boolean var4 = var1.b() == Items.aN;
		Iterator var5 = class_afj.b.iterator();

		while (true) {
			while (true) {
				class_afj var6;
				do {
					if (!var5.hasNext()) {
						return var2;
					}

					var6 = (class_afj) var5.next();
				} while (!var6.c.a(var3) && !var4);

				for (int var7 = var6.b(); var7 > (var6.d() - 1); --var7) {
					if ((var0 >= var6.a(var7)) && (var0 <= var6.b(var7))) {
						var2.add(new class_afm(var6, var7));
						break;
					}
				}
			}
		}
	}

	// $FF: synthetic class
	static class SyntheticClass_1 {
	}

	static final class class_a_in_class_afl implements class_afl.class_c_in_class_afl {
		public EntityLiving a;
		public Entity b;

		private class_a_in_class_afl() {
		}

		@Override
		public void a(class_afj var1, int var2) {
			var1.a(a, b, var2);
		}

		// $FF: synthetic method
		class_a_in_class_afl(class_afl.SyntheticClass_1 var1) {
			this();
		}
	}

	static final class class_b_in_class_afl implements class_afl.class_c_in_class_afl {
		public EntityLiving a;
		public Entity b;

		private class_b_in_class_afl() {
		}

		@Override
		public void a(class_afj var1, int var2) {
			var1.b(a, b, var2);
		}

		// $FF: synthetic method
		class_b_in_class_afl(class_afl.SyntheticClass_1 var1) {
			this();
		}
	}

	static final class class_d_in_class_afl implements class_afl.class_c_in_class_afl {
		public float a;
		public class_rl b;

		private class_d_in_class_afl() {
		}

		@Override
		public void a(class_afj var1, int var2) {
			a += var1.a(var2, b);
		}

		// $FF: synthetic method
		class_d_in_class_afl(class_afl.SyntheticClass_1 var1) {
			this();
		}
	}

	static final class class_e_in_class_afl implements class_afl.class_c_in_class_afl {
		public int a;
		public class_qi b;

		private class_e_in_class_afl() {
		}

		@Override
		public void a(class_afj var1, int var2) {
			a += var1.a(var2, b);
		}

		// $FF: synthetic method
		class_e_in_class_afl(class_afl.SyntheticClass_1 var1) {
			this();
		}
	}

	interface class_c_in_class_afl {
		void a(class_afj var1, int var2);
	}
}
