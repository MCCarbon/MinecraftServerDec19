package net.minecraft.server;

import java.util.List;

import com.google.common.base.Predicates;

public class class_aav extends Item {
	private static final int[] l = new int[] { 13, 15, 16, 11 };
	public static final String[] a = new String[] { "minecraft:items/empty_armor_slot_boots", "minecraft:items/empty_armor_slot_leggings", "minecraft:items/empty_armor_slot_chestplate", "minecraft:items/empty_armor_slot_helmet" };
	private static final class_cr m = new class_cn() {
		@Override
		protected class_aco b(class_ck var1, class_aco var2) {
			class_cj var3 = var1.d().a(class_ajm.b(var1.f()));
			int var4 = var3.n();
			int var5 = var3.o();
			int var6 = var3.p();
			class_ayk var7 = new class_ayk(var4, var5, var6, var4 + 1, var5 + 1, var6 + 1);
			List var8 = var1.i().a(class_rg.class, var7, Predicates.and(class_rb.d, new class_rb.class_a_in_class_rb(var2)));
			if (!var8.isEmpty()) {
				class_rg var9 = (class_rg) var8.get(0);
				class_rc var10 = class_rh.c(var2);
				class_aco var11 = var2.k();
				var11.b = 1;
				var9.a(var10, var11);
				if (var9 instanceof class_rh) {
					((class_rh) var9).a(var10, 2.0F);
				}

				--var2.b;
				return var2;
			} else {
				return super.b(var1, var2);
			}
		}
	};
	public final class_rc b;
	public final int c;
	public final int d;
	private final class_aav.class_a_in_class_aav n;

	public class_aav(class_aav.class_a_in_class_aav var1, int var2, class_rc var3) {
		n = var1;
		b = var3;
		d = var2;
		c = var1.b(var3);
		this.e(var1.a(var3));
		i = 1;
		this.a(class_abp.j);
		class_ajm.N.a(this, m);
	}

	@Override
	public int c() {
		return n.a();
	}

	public class_aav.class_a_in_class_aav d() {
		return n;
	}

	public boolean d_(class_aco var1) {
		return n != class_aav.class_a_in_class_aav.a ? false : (!var1.n() ? false : (!var1.o().b("display", 10) ? false : var1.o().o("display").b("color", 3)));
	}

	public int b(class_aco var1) {
		if (n != class_aav.class_a_in_class_aav.a) {
			return -1;
		} else {
			class_dn var2 = var1.o();
			if (var2 != null) {
				class_dn var3 = var2.o("display");
				if ((var3 != null) && var3.b("color", 3)) {
					return var3.h("color");
				}
			}

			return 10511680;
		}
	}

	public void c(class_aco var1) {
		if (n == class_aav.class_a_in_class_aav.a) {
			class_dn var2 = var1.o();
			if (var2 != null) {
				class_dn var3 = var2.o("display");
				if (var3.e("color")) {
					var3.q("color");
				}

			}
		}
	}

	public void b(class_aco var1, int var2) {
		if (n != class_aav.class_a_in_class_aav.a) {
			throw new UnsupportedOperationException("Can\'t dye non-leather!");
		} else {
			class_dn var3 = var1.o();
			if (var3 == null) {
				var3 = new class_dn();
				var1.d(var3);
			}

			class_dn var4 = var3.o("display");
			if (!var3.b("display", 10)) {
				var3.a("display", var4);
			}

			var4.a("color", var2);
		}
	}

	@Override
	public boolean a(class_aco var1, class_aco var2) {
		return n.b() == var2.b() ? true : super.a(var1, var2);
	}

	@Override
	public class_px a(class_aco var1, class_ago var2, class_yu var3, class_pu var4) {
		class_rc var5 = class_rh.c(var1);
		class_aco var6 = var3.a(var5);
		if (var6 == null) {
			var3.a(var5, var1.k());
			var1.b = 0;
			return new class_px(class_pw.a, var1);
		} else {
			return new class_px(class_pw.c, var1);
		}
	}

	public static enum class_a_in_class_aav {
		a("leather", 5, new int[] { 1, 2, 3, 1 }, 15),
		b("chainmail", 15, new int[] { 1, 4, 5, 2 }, 12),
		c("iron", 15, new int[] { 2, 5, 6, 2 }, 9),
		d("gold", 7, new int[] { 1, 3, 5, 2 }, 25),
		e("diamond", 33, new int[] { 3, 6, 8, 3 }, 10);

		private final String f;
		private final int g;
		private final int[] h;
		private final int i;

		private class_a_in_class_aav(String var3, int var4, int[] var5, int var6) {
			f = var3;
			g = var4;
			h = var5;
			i = var6;
		}

		public int a(class_rc var1) {
			return class_aav.l[var1.b()] * g;
		}

		public int b(class_rc var1) {
			return h[var1.b()];
		}

		public int a() {
			return i;
		}

		public Item b() {
			return this == a ? Items.aH : (this == b ? Items.l : (this == d ? Items.m : (this == c ? Items.l : (this == e ? Items.k : null))));
		}
	}
}
