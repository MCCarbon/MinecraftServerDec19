package net.minecraft.server;

import com.google.common.base.Predicate;

public final class class_rb {
	public static final Predicate a = new Predicate() {
		public boolean a(Entity var1) {
			return var1.al();
		}

		// $FF: synthetic method
		@Override
		public boolean apply(Object var1) {
			return this.a((Entity) var1);
		}
	};
	public static final Predicate b = new Predicate() {
		public boolean a(Entity var1) {
			return var1.al() && (var1.l == null) && (var1.m == null);
		}

		// $FF: synthetic method
		@Override
		public boolean apply(Object var1) {
			return this.a((Entity) var1);
		}
	};
	public static final Predicate c = new Predicate() {
		public boolean a(Entity var1) {
			return (var1 instanceof class_pp) && var1.al();
		}

		// $FF: synthetic method
		@Override
		public boolean apply(Object var1) {
			return this.a((Entity) var1);
		}
	};
	public static final Predicate d = new Predicate() {
		public boolean a(Entity var1) {
			return !(var1 instanceof class_yu) || !((class_yu) var1).w();
		}

		// $FF: synthetic method
		@Override
		public boolean apply(Object var1) {
			return this.a((Entity) var1);
		}
	};

	public static Predicate a(final double var0, final double var2, final double var4, double var6) {
		final double var8 = var6 * var6;
		return new Predicate() {
			public boolean a(Entity var1) {
				return (var1 != null) && (var1.e(var0, var2, var4) <= var8);
			}

			// $FF: synthetic method
			@Override
			public boolean apply(Object var1) {
				return this.a((Entity) var1);
			}
		};
	}

	public static class class_a_in_class_rb implements Predicate {
		private final class_aco a;

		public class_a_in_class_rb(class_aco var1) {
			a = var1;
		}

		public boolean a(Entity var1) {
			if (!var1.al()) {
				return false;
			} else if (!(var1 instanceof class_rg)) {
				return false;
			} else {
				class_rg var2 = (class_rg) var1;
				return var2.a(class_rh.c(a)) != null ? false : (var2 instanceof class_rh ? ((class_rh) var2).cq() : (var2 instanceof class_ws ? true : var2 instanceof class_yu));
			}
		}

		// $FF: synthetic method
		@Override
		public boolean apply(Object var1) {
			return this.a((Entity) var1);
		}
	}
}
