package net.minecraft.server;


public class class_anx extends Block {
	public static final class_apy a = class_apy.a("up");
	public static final class_apy b = class_apy.a("north");
	public static final class_apy N = class_apy.a("east");
	public static final class_apy O = class_apy.a("south");
	public static final class_apy P = class_apy.a("west");
	public static final class_aqa Q = class_aqa.a("variant", class_anx.class_a_in_class_anx.class);

	public class_anx(Block var1) {
		super(var1.J);
		this.j(M.b().a(a, Boolean.valueOf(false)).a(b, Boolean.valueOf(false)).a(N, Boolean.valueOf(false)).a(O, Boolean.valueOf(false)).a(P, Boolean.valueOf(false)).a(Q, class_anx.class_a_in_class_anx.a));
		this.c(var1.w);
		this.b(var1.x / 3.0F);
		this.a(var1.H);
		this.a(class_abp.b);
	}

	@Override
	public String f() {
		return class_di.a(this.a() + "." + class_anx.class_a_in_class_anx.a.c() + ".name");
	}

	@Override
	public boolean d() {
		return false;
	}

	@Override
	public boolean b(class_ags var1, class_cj var2) {
		return false;
	}

	@Override
	public boolean c() {
		return false;
	}

	@Override
	public void a(class_ags var1, class_cj var2) {
		boolean var3 = this.e(var1, var2.c());
		boolean var4 = this.e(var1, var2.d());
		boolean var5 = this.e(var1, var2.e());
		boolean var6 = this.e(var1, var2.f());
		float var7 = 0.25F;
		float var8 = 0.75F;
		float var9 = 0.25F;
		float var10 = 0.75F;
		float var11 = 1.0F;
		if (var3) {
			var9 = 0.0F;
		}

		if (var4) {
			var10 = 1.0F;
		}

		if (var5) {
			var7 = 0.0F;
		}

		if (var6) {
			var8 = 1.0F;
		}

		if (var3 && var4 && !var5 && !var6) {
			var11 = 0.8125F;
			var7 = 0.3125F;
			var8 = 0.6875F;
		} else if (!var3 && !var4 && var5 && var6) {
			var11 = 0.8125F;
			var9 = 0.3125F;
			var10 = 0.6875F;
		}

		this.a(var7, 0.0F, var9, var8, var11, var10);
	}

	@Override
	public class_ayk a(class_ago var1, class_cj var2, class_apn var3) {
		this.a(var1, var2);
		F = 1.5D;
		return super.a(var1, var2, var3);
	}

	public boolean e(class_ags var1, class_cj var2) {
		Block var3 = var1.p(var2).c();
		return var3 == Blocks.BARRIER ? false : ((var3 != this) && !(var3 instanceof class_akc) ? (var3.J.k() && var3.d() ? var3.J != class_avq.C : false) : true);
	}

	@Override
	public int a(class_apn var1) {
		return ((class_anx.class_a_in_class_anx) var1.b(Q)).a();
	}

	@Override
	public class_apn a(int var1) {
		return getBlockData().a(Q, class_anx.class_a_in_class_anx.a(var1));
	}

	@Override
	public int c(class_apn var1) {
		return ((class_anx.class_a_in_class_anx) var1.b(Q)).a();
	}

	@Override
	public class_apn a(class_apn var1, class_ags var2, class_cj var3) {
		boolean var4 = this.e(var2, var3.c());
		boolean var5 = this.e(var2, var3.f());
		boolean var6 = this.e(var2, var3.d());
		boolean var7 = this.e(var2, var3.e());
		boolean var8 = (var4 && !var5 && var6 && !var7) || (!var4 && var5 && !var6 && var7);
		return var1.a(a, Boolean.valueOf(!var8 || !var2.d(var3.a()))).a(b, Boolean.valueOf(var4)).a(N, Boolean.valueOf(var5)).a(O, Boolean.valueOf(var6)).a(P, Boolean.valueOf(var7));
	}

	@Override
	protected class_apo e() {
		return new class_apo(this, new class_aqc[] { a, b, N, P, O, Q });
	}

	public static enum class_a_in_class_anx implements class_oe {
		a(0, "cobblestone", "normal"),
		b(1, "mossy_cobblestone", "mossy");

		private static final class_anx.class_a_in_class_anx[] c;
		private final int d;
		private final String e;
		private String f;

		private class_a_in_class_anx(int var3, String var4, String var5) {
			d = var3;
			e = var4;
			f = var5;
		}

		public int a() {
			return d;
		}

		@Override
		public String toString() {
			return e;
		}

		public static class_anx.class_a_in_class_anx a(int var0) {
			if ((var0 < 0) || (var0 >= c.length)) {
				var0 = 0;
			}

			return c[var0];
		}

		@Override
		public String l() {
			return e;
		}

		public String c() {
			return f;
		}

		static {
			c = new class_anx.class_a_in_class_anx[values().length];
			class_anx.class_a_in_class_anx[] var0 = values();
			int var1 = var0.length;

			for (int var2 = 0; var2 < var1; ++var2) {
				class_anx.class_a_in_class_anx var3 = var0[var2];
				c[var3.a()] = var3;
			}

		}
	}
}
