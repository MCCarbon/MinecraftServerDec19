package net.minecraft.server;


public class class_aft extends class_afj {
	public final class_aft.class_a_in_class_aft a;

	public class_aft(class_afj.class_a_in_class_afj var1, class_aft.class_a_in_class_aft var2, class_rc... var3) {
		super(var1, class_afk.b, var3);
		a = var2;
		if (var2 == class_aft.class_a_in_class_aft.c) {
			c = class_afk.c;
		}

	}

	@Override
	public int a(int var1) {
		return a.b() + ((var1 - 1) * a.c());
	}

	@Override
	public int b(int var1) {
		return this.a(var1) + a.c();
	}

	@Override
	public int b() {
		return 4;
	}

	@Override
	public int a(int var1, class_qi var2) {
		if (var2.g()) {
			return 0;
		} else {
			float var3 = (6 + (var1 * var1)) / 3.0F;
			return a == class_aft.class_a_in_class_aft.a ? MathHelper.d(var3 * 0.75F) : ((a == class_aft.class_a_in_class_aft.b) && var2.o() ? MathHelper.d(var3 * 1.25F) : ((a == class_aft.class_a_in_class_aft.c) && (var2 == class_qi.i) ? MathHelper.d(var3 * 2.5F) : ((a == class_aft.class_a_in_class_aft.d) && var2.c() ? MathHelper.d(var3 * 1.5F) : ((a == class_aft.class_a_in_class_aft.e) && var2.a() ? MathHelper.d(var3 * 1.5F) : 0))));
		}
	}

	@Override
	public String a() {
		return "enchantment.protect." + a.a();
	}

	@Override
	public boolean a(class_afj var1) {
		if (var1 instanceof class_aft) {
			class_aft var2 = (class_aft) var1;
			return a == var2.a ? false : (a == class_aft.class_a_in_class_aft.c) || (var2.a == class_aft.class_a_in_class_aft.c);
		} else {
			return super.a(var1);
		}
	}

	public static int a(EntityLiving var0, int var1) {
		int var2 = class_afl.a(class_afn.b, var0);
		if (var2 > 0) {
			var1 -= MathHelper.d((float) var1 * (float) var2 * 0.15F);
		}

		return var1;
	}

	public static double a(EntityLiving var0, double var1) {
		int var3 = class_afl.a(class_afn.d, var0);
		if (var3 > 0) {
			var1 -= MathHelper.c(var1 * (var3 * 0.15F));
		}

		return var1;
	}

	public static enum class_a_in_class_aft {
		a("all", 1, 11, 20),
		b("fire", 10, 8, 12),
		c("fall", 5, 6, 10),
		d("explosion", 5, 8, 12),
		e("projectile", 3, 6, 15);

		private final String f;
		private final int g;
		private final int h;
		private final int i;

		private class_a_in_class_aft(String var3, int var4, int var5, int var6) {
			f = var3;
			g = var4;
			h = var5;
			i = var6;
		}

		public String a() {
			return f;
		}

		public int b() {
			return g;
		}

		public int c() {
			return h;
		}
	}
}
