package net.minecraft.server;

import java.util.Random;

public class class_anj extends Block {
	public static final class_aqa a = class_aqa.a("variant", class_anj.class_a_in_class_anj.class);

	public class_anj() {
		super(class_avq.e);
		this.j(M.b().a(a, class_anj.class_a_in_class_anj.a));
		this.a(class_abp.b);
	}

	@Override
	public String f() {
		return class_di.a(this.a() + "." + class_anj.class_a_in_class_anj.a.d() + ".name");
	}

	@Override
	public class_avr g(class_apn var1) {
		return ((class_anj.class_a_in_class_anj) var1.b(a)).c();
	}

	@Override
	public Item a(class_apn var1, Random var2, int var3) {
		return var1.b(a) == class_anj.class_a_in_class_anj.a ? Item.a(Blocks.e) : Item.a(Blocks.b);
	}

	@Override
	public int a(class_apn var1) {
		return ((class_anj.class_a_in_class_anj) var1.b(a)).a();
	}

	@Override
	public class_apn a(int var1) {
		return S().a(a, class_anj.class_a_in_class_anj.a(var1));
	}

	@Override
	public int c(class_apn var1) {
		return ((class_anj.class_a_in_class_anj) var1.b(a)).a();
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { a });
	}

	public static enum class_a_in_class_anj implements class_oe {
		a(0, class_avr.m, "stone"),
		b(1, class_avr.l, "granite"),
		c(2, class_avr.l, "smooth_granite", "graniteSmooth"),
		d(3, class_avr.p, "diorite"),
		e(4, class_avr.p, "smooth_diorite", "dioriteSmooth"),
		f(5, class_avr.m, "andesite"),
		g(6, class_avr.m, "smooth_andesite", "andesiteSmooth");

		private static final class_anj.class_a_in_class_anj[] h;
		private final int i;
		private final String j;
		private final String k;
		private final class_avr l;

		private class_a_in_class_anj(int var3, class_avr var4, String var5) {
			this(var3, var4, var5, var5);
		}

		private class_a_in_class_anj(int var3, class_avr var4, String var5, String var6) {
			i = var3;
			j = var5;
			k = var6;
			l = var4;
		}

		public int a() {
			return i;
		}

		public class_avr c() {
			return l;
		}

		@Override
		public String toString() {
			return j;
		}

		public static class_anj.class_a_in_class_anj a(int var0) {
			if ((var0 < 0) || (var0 >= h.length)) {
				var0 = 0;
			}

			return h[var0];
		}

		@Override
		public String l() {
			return j;
		}

		public String d() {
			return k;
		}

		static {
			h = new class_anj.class_a_in_class_anj[values().length];
			class_anj.class_a_in_class_anj[] var0 = values();
			int var1 = var0.length;

			for (int var2 = 0; var2 < var1; ++var2) {
				class_anj.class_a_in_class_anj var3 = var0[var2];
				h[var3.a()] = var3;
			}

		}
	}
}
