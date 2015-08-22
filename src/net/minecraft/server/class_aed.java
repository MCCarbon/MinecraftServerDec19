package net.minecraft.server;

import java.util.Iterator;
import java.util.List;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;

public class class_aed {
	private static final List a = Lists.newArrayList();
	private static final List b = Lists.newArrayList();
	private static final List c = Lists.newArrayList();
	private static final Predicate d = new Predicate() {
		public boolean a(class_aco var1) {
			Iterator var2 = class_aed.c.iterator();

			class_aed.class_a_in_class_aed var3;
			do {
				if (!var2.hasNext()) {
					return false;
				}

				var3 = (class_aed.class_a_in_class_aed) var2.next();
			} while (!var3.a(var1));

			return true;
		}

		// $FF: synthetic method
		@Override
		public boolean apply(Object var1) {
			return this.a((class_aco) var1);
		}
	};

	public static boolean a(class_aco var0) {
		return b(var0) || c(var0);
	}

	protected static boolean b(class_aco var0) {
		int var1 = 0;

		for (int var2 = b.size(); var1 < var2; ++var1) {
			if (((class_aed.class_b_in_class_aed) b.get(var1)).b.apply(var0)) {
				return true;
			}
		}

		return false;
	}

	protected static boolean c(class_aco var0) {
		int var1 = 0;

		for (int var2 = a.size(); var1 < var2; ++var1) {
			if (((class_aed.class_b_in_class_aed) a.get(var1)).b.apply(var0)) {
				return true;
			}
		}

		return false;
	}

	public static boolean a(class_aco var0, class_aco var1) {
		return !d.apply(var0) ? false : b(var0, var1) || c(var0, var1);
	}

	protected static boolean b(class_aco var0, class_aco var1) {
		class_acm var2 = var0.b();
		int var3 = 0;

		for (int var4 = b.size(); var3 < var4; ++var3) {
			class_aed.class_b_in_class_aed var5 = (class_aed.class_b_in_class_aed) b.get(var3);
			if ((var5.a == var2) && var5.b.apply(var1)) {
				return true;
			}
		}

		return false;
	}

	protected static boolean c(class_aco var0, class_aco var1) {
		class_aec var2 = class_adb.i(var0);
		int var3 = 0;

		for (int var4 = a.size(); var3 < var4; ++var3) {
			class_aed.class_b_in_class_aed var5 = (class_aed.class_b_in_class_aed) a.get(var3);
			if ((var5.a == var2) && var5.b.apply(var1)) {
				return true;
			}
		}

		return false;
	}

	public static class_aco d(class_aco var0, class_aco var1) {
		if (var1 != null) {
			class_aec var2 = class_adb.i(var1);
			class_acm var3 = var1.b();
			int var4 = 0;

			int var5;
			class_aed.class_b_in_class_aed var6;
			for (var5 = b.size(); var4 < var5; ++var4) {
				var6 = (class_aed.class_b_in_class_aed) b.get(var4);
				if ((var6.a == var3) && var6.b.apply(var0)) {
					return class_adb.a(new class_aco((class_acm) var6.c), var2);
				}
			}

			var4 = 0;

			for (var5 = a.size(); var4 < var5; ++var4) {
				var6 = (class_aed.class_b_in_class_aed) a.get(var4);
				if ((var6.a == var2) && var6.b.apply(var0)) {
					return class_adb.a(new class_aco(var3), (class_aec) var6.c);
				}
			}
		}

		return var1;
	}

	public static void a() {
		class_aed.class_a_in_class_aed var0 = new class_aed.class_a_in_class_aed(class_acq.bA);
		class_aed.class_a_in_class_aed var1 = new class_aed.class_a_in_class_aed(class_acq.cb);
		class_aed.class_a_in_class_aed var2 = new class_aed.class_a_in_class_aed(class_acq.aE);
		class_aed.class_a_in_class_aed var3 = new class_aed.class_a_in_class_aed(class_acq.bH);
		class_aed.class_a_in_class_aed var4 = new class_aed.class_a_in_class_aed(class_acq.bt);
		class_aed.class_a_in_class_aed var5 = new class_aed.class_a_in_class_aed(class_acq.aV);
		class_aed.class_a_in_class_aed var6 = new class_aed.class_a_in_class_aed(class_acq.bJ);
		class_aed.class_a_in_class_aed var7 = new class_aed.class_a_in_class_aed(class_acq.ba);
		class_aed.class_a_in_class_aed var8 = new class_aed.class_a_in_class_aed(class_acq.aW, class_acf.class_a_in_class_acf.d.a());
		class_aed.class_a_in_class_aed var9 = new class_aed.class_a_in_class_aed(class_acq.bN);
		class_aed.class_a_in_class_aed var10 = new class_aed.class_a_in_class_aed(class_acq.bG);
		class_aed.class_a_in_class_aed var11 = new class_aed.class_a_in_class_aed(class_acq.by);
		class_aed.class_a_in_class_aed var12 = new class_aed.class_a_in_class_aed(class_acq.bI);
		a(new class_aed.class_a_in_class_aed(class_acq.bB));
		a(new class_aed.class_a_in_class_aed(class_acq.bC));
		a(class_acq.bB, new class_aed.class_a_in_class_aed(class_acq.J), class_acq.bC);
		a(class_acq.bC, new class_aed.class_a_in_class_aed(class_acq.bF), class_acq.bD);
		a(class_aee.a, var9, class_aee.b);
		a(class_aee.a, var11, class_aee.b);
		a(class_aee.a, var4, class_aee.b);
		a(class_aee.a, var12, class_aee.b);
		a(class_aee.a, var10, class_aee.b);
		a(class_aee.a, var7, class_aee.b);
		a(class_aee.a, var6, class_aee.b);
		a(class_aee.a, var5, class_aee.c);
		a(class_aee.a, var2, class_aee.b);
		a(class_aee.a, var0, class_aee.d);
		a(class_aee.d, var1, class_aee.e);
		a(class_aee.e, var2, class_aee.f);
		a(class_aee.e, var3, class_aee.g);
		a(class_aee.f, var3, class_aee.h);
		a(class_aee.g, var2, class_aee.h);
		a(class_aee.d, var6, class_aee.l);
		a(class_aee.l, var2, class_aee.m);
		a(class_aee.d, var4, class_aee.i);
		a(class_aee.i, var2, class_aee.j);
		a(class_aee.i, var5, class_aee.k);
		a(class_aee.i, var3, class_aee.q);
		a(class_aee.j, var3, class_aee.r);
		a(class_aee.q, var2, class_aee.r);
		a(class_aee.n, var3, class_aee.q);
		a(class_aee.o, var3, class_aee.r);
		a(class_aee.d, var7, class_aee.n);
		a(class_aee.n, var2, class_aee.o);
		a(class_aee.n, var5, class_aee.p);
		a(class_aee.d, var8, class_aee.s);
		a(class_aee.s, var2, class_aee.t);
		a(class_aee.d, var9, class_aee.u);
		a(class_aee.u, var5, class_aee.v);
		a(class_aee.u, var3, class_aee.w);
		a(class_aee.v, var3, class_aee.x);
		a(class_aee.w, var5, class_aee.x);
		a(class_aee.y, var3, class_aee.w);
		a(class_aee.z, var3, class_aee.w);
		a(class_aee.A, var3, class_aee.x);
		a(class_aee.d, var10, class_aee.y);
		a(class_aee.y, var2, class_aee.z);
		a(class_aee.y, var5, class_aee.A);
		a(class_aee.d, var11, class_aee.B);
		a(class_aee.B, var2, class_aee.C);
		a(class_aee.B, var5, class_aee.D);
		a(class_aee.d, var12, class_aee.E);
		a(class_aee.E, var2, class_aee.F);
		a(class_aee.E, var5, class_aee.G);
		a(class_aee.a, var3, class_aee.H);
		a(class_aee.H, var2, class_aee.I);
	}

	private static void a(class_adb var0, class_aed.class_a_in_class_aed var1, class_adb var2) {
		b.add(new class_aed.class_b_in_class_aed(var0, var1, var2));
	}

	private static void a(class_aed.class_a_in_class_aed var0) {
		c.add(var0);
	}

	private static void a(class_aec var0, Predicate var1, class_aec var2) {
		a.add(new class_aed.class_b_in_class_aed(var0, var1, var2));
	}

	static class class_a_in_class_aed implements Predicate {
		private final class_acm a;
		private final int b;

		public class_a_in_class_aed(class_acm var1) {
			this(var1, -1);
		}

		public class_a_in_class_aed(class_acm var1, int var2) {
			a = var1;
			b = var2;
		}

		public boolean a(class_aco var1) {
			return (var1 != null) && (var1.b() == a) && ((b == -1) || (b == var1.i()));
		}

		// $FF: synthetic method
		@Override
		public boolean apply(Object var1) {
			return this.a((class_aco) var1);
		}
	}

	static class class_b_in_class_aed {
		final Object a;
		final Predicate b;
		final Object c;

		public class_b_in_class_aed(Object var1, Predicate var2, Object var3) {
			a = var1;
			b = var2;
			c = var3;
		}
	}
}
