package net.minecraft.server;

import java.util.List;

public class class_aog extends TileEntity {
	private int a;
	private class_du f;
	private boolean g;
	private List h;
	private List i;
	private String j;

	public void a(class_aco var1) {
		f = null;
		if (var1.n() && var1.o().b("BlockEntityTag", 10)) {
			class_dn var2 = var1.o().o("BlockEntityTag");
			if (var2.e("Patterns")) {
				f = (class_du) var2.c("Patterns", 10).b();
			}

			if (var2.b("Base", 99)) {
				a = var2.h("Base");
			} else {
				a = var1.i() & 15;
			}
		} else {
			a = var1.i() & 15;
		}

		h = null;
		i = null;
		j = "";
		g = true;
	}

	@Override
	public void b(class_dn var1) {
		super.b(var1);
		a(var1, a, f);
	}

	public static void a(class_dn var0, int var1, class_du var2) {
		var0.a("Base", var1);
		if (var2 != null) {
			var0.a("Patterns", var2);
		}

	}

	@Override
	public void a(class_dn var1) {
		super.a(var1);
		a = var1.h("Base");
		f = var1.c("Patterns", 10);
		h = null;
		i = null;
		j = null;
		g = true;
	}

	@Override
	public Packet x_() {
		class_dn var1 = new class_dn();
		this.b(var1);
		return new class_ft(c, 6, var1);
	}

	public int b() {
		return a;
	}

	public static int b(class_aco var0) {
		class_dn var1 = var0.a("BlockEntityTag", false);
		return (var1 != null) && var1.e("Base") ? var1.h("Base") : var0.i();
	}

	public static int c(class_aco var0) {
		class_dn var1 = var0.a("BlockEntityTag", false);
		return (var1 != null) && var1.e("Patterns") ? var1.c("Patterns", 10).c() : 0;
	}

	public class_du d() {
		return f;
	}

	public static void a(class_aco var0, class_abt var1) {
		class_dn var2 = var0.a("BlockEntityTag", true);
		var2.a("Base", var1.b());
	}

	public static void e(class_aco var0) {
		class_dn var1 = var0.a("BlockEntityTag", false);
		if ((var1 != null) && var1.b("Patterns", 9)) {
			class_du var2 = var1.c("Patterns", 10);
			if (var2.c() > 0) {
				var2.a(var2.c() - 1);
				if (var2.c_()) {
					var0.o().q("BlockEntityTag");
					if (var0.o().c_()) {
						var0.d((class_dn) null);
					}
				}

			}
		}
	}

	public static enum class_a_in_class_aog {
		a("base", "b"),
		b("square_bottom_left", "bl", "   ", "   ", "#  "),
		c("square_bottom_right", "br", "   ", "   ", "  #"),
		d("square_top_left", "tl", "#  ", "   ", "   "),
		e("square_top_right", "tr", "  #", "   ", "   "),
		f("stripe_bottom", "bs", "   ", "   ", "###"),
		g("stripe_top", "ts", "###", "   ", "   "),
		h("stripe_left", "ls", "#  ", "#  ", "#  "),
		i("stripe_right", "rs", "  #", "  #", "  #"),
		j("stripe_center", "cs", " # ", " # ", " # "),
		k("stripe_middle", "ms", "   ", "###", "   "),
		l("stripe_downright", "drs", "#  ", " # ", "  #"),
		m("stripe_downleft", "dls", "  #", " # ", "#  "),
		n("small_stripes", "ss", "# #", "# #", "   "),
		o("cross", "cr", "# #", " # ", "# #"),
		p("straight_cross", "sc", " # ", "###", " # "),
		q("triangle_bottom", "bt", "   ", " # ", "# #"),
		r("triangle_top", "tt", "# #", " # ", "   "),
		s("triangles_bottom", "bts", "   ", "# #", " # "),
		t("triangles_top", "tts", " # ", "# #", "   "),
		u("diagonal_left", "ld", "## ", "#  ", "   "),
		v("diagonal_up_right", "rd", "   ", "  #", " ##"),
		w("diagonal_up_left", "lud", "   ", "#  ", "## "),
		x("diagonal_right", "rud", " ##", "  #", "   "),
		y("circle", "mc", "   ", " # ", "   "),
		z("rhombus", "mr", " # ", "# #", " # "),
		A("half_vertical", "vh", "## ", "## ", "## "),
		B("half_horizontal", "hh", "###", "###", "   "),
		C("half_vertical_right", "vhr", " ##", " ##", " ##"),
		D("half_horizontal_bottom", "hhb", "   ", "###", "###"),
		E("border", "bo", "###", "# #", "###"),
		F("curly_border", "cbo", new class_aco(Blocks.VINE)),
		G("creeper", "cre", new class_aco(Items.cc, 1, 4)),
		H("gradient", "gra", "# #", " # ", " # "),
		I("gradient_up", "gru", " # ", " # ", "# #"),
		J("bricks", "bri", new class_aco(Blocks.BRICK_BLOCK)),
		K("skull", "sku", new class_aco(Items.cc, 1, 1)),
		L("flower", "flo", new class_aco(Blocks.RED_FLOWER, 1, BlockFlowers.class_a_in_class_ake.j.b())),
		M("mojang", "moj", new class_aco(Items.aq, 1, 1));

		private String N;
		private String O;
		private String[] P;
		private class_aco Q;

		private class_a_in_class_aog(String var3, String var4) {
			P = new String[3];
			N = var3;
			O = var4;
		}

		private class_a_in_class_aog(String var3, String var4, class_aco var5) {
			this(var3, var4);
			Q = var5;
		}

		private class_a_in_class_aog(String var3, String var4, String var5, String var6, String var7) {
			this(var3, var4);
			P[0] = var5;
			P[1] = var6;
			P[2] = var7;
		}

		public String b() {
			return O;
		}

		public String[] c() {
			return P;
		}

		public boolean d() {
			return (Q != null) || (P[0] != null);
		}

		public boolean e() {
			return Q != null;
		}

		public class_aco f() {
			return Q;
		}

	}
}
