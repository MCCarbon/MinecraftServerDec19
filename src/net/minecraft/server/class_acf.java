package net.minecraft.server;

import java.util.Map;

import com.google.common.collect.Maps;

public class class_acf extends class_aci {
	private final boolean b;

	public class_acf(boolean var1) {
		super(0, 0.0F, false);
		b = var1;
	}

	@Override
	public int h(class_aco var1) {
		class_acf.class_a_in_class_acf var2 = class_acf.class_a_in_class_acf.a(var1);
		return b && var2.g() ? var2.e() : var2.c();
	}

	@Override
	public float i(class_aco var1) {
		class_acf.class_a_in_class_acf var2 = class_acf.class_a_in_class_acf.a(var1);
		return b && var2.g() ? var2.f() : var2.d();
	}

	@Override
	protected void a(class_aco var1, class_ago var2, class_yu var3) {
		class_acf.class_a_in_class_acf var4 = class_acf.class_a_in_class_acf.a(var1);
		if (var4 == class_acf.class_a_in_class_acf.d) {
			var3.c(new class_qr(class_qs.s, 1200, 3));
			var3.c(new class_qr(class_qs.q, 300, 2));
			var3.c(new class_qr(class_qs.i, 300, 1));
		}

		super.a(var1, var2, var3);
	}

	@Override
	public String e_(class_aco var1) {
		class_acf.class_a_in_class_acf var2 = class_acf.class_a_in_class_acf.a(var1);
		return this.a() + "." + var2.b() + "." + (b && var2.g() ? "cooked" : "raw");
	}

	public static enum class_a_in_class_acf {
		a(0, "cod", 2, 0.1F, 5, 0.6F),
		b(1, "salmon", 2, 0.1F, 6, 0.8F),
		c(2, "clownfish", 1, 0.1F),
		d(3, "pufferfish", 1, 0.1F);

		private static final Map e;
		private final int f;
		private final String g;
		private final int h;
		private final float i;
		private final int j;
		private final float k;
		private boolean l = false;

		private class_a_in_class_acf(int var3, String var4, int var5, float var6, int var7, float var8) {
			f = var3;
			g = var4;
			h = var5;
			i = var6;
			j = var7;
			k = var8;
			l = true;
		}

		private class_a_in_class_acf(int var3, String var4, int var5, float var6) {
			f = var3;
			g = var4;
			h = var5;
			i = var6;
			j = 0;
			k = 0.0F;
			l = false;
		}

		public int a() {
			return f;
		}

		public String b() {
			return g;
		}

		public int c() {
			return h;
		}

		public float d() {
			return i;
		}

		public int e() {
			return j;
		}

		public float f() {
			return k;
		}

		public boolean g() {
			return l;
		}

		public static class_acf.class_a_in_class_acf a(int var0) {
			class_acf.class_a_in_class_acf var1 = (class_acf.class_a_in_class_acf) e.get(Integer.valueOf(var0));
			return var1 == null ? a : var1;
		}

		public static class_acf.class_a_in_class_acf a(class_aco var0) {
			return var0.b() instanceof class_acf ? a(var0.i()) : a;
		}

		static {
			e = Maps.newHashMap();
			class_acf.class_a_in_class_acf[] var0 = values();
			int var1 = var0.length;

			for (int var2 = 0; var2 < var1; ++var2) {
				class_acf.class_a_in_class_acf var3 = var0[var2];
				e.put(Integer.valueOf(var3.a()), var3);
			}

		}
	}
}
