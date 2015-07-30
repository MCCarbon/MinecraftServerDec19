package net.minecraft.server;

import java.util.List;
import net.minecraft.server.class_aas;
import net.minecraft.server.Items;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_aic;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_du;
import net.minecraft.server.class_eb;
import net.minecraft.server.Packet;
import net.minecraft.server.class_ft;

public class class_ame extends class_amg {
	private int a;
	private class_du f;
	private boolean g;
	private List h;
	private List i;
	private String j;

	public void a(class_aas var1) {
		this.f = null;
		if (var1.n() && var1.o().b("BlockEntityTag", 10)) {
			class_dn var2 = var1.o().n("BlockEntityTag");
			if (var2.d("Patterns")) {
				this.f = (class_du) var2.c("Patterns", 10).b();
			}

			if (var2.b("Base", 99)) {
				this.a = var2.g("Base");
			} else {
				this.a = var1.i() & 15;
			}
		} else {
			this.a = var1.i() & 15;
		}

		this.h = null;
		this.i = null;
		this.j = "";
		this.g = true;
	}

	public void b(class_dn var1) {
		super.b(var1);
		a(var1, this.a, this.f);
	}

	public static void a(class_dn var0, int var1, class_du var2) {
		var0.a("Base", var1);
		if (var2 != null) {
			var0.a((String) "Patterns", (class_eb) var2);
		}

	}

	public void a(class_dn var1) {
		super.a(var1);
		this.a = var1.g("Base");
		this.f = var1.c("Patterns", 10);
		this.h = null;
		this.i = null;
		this.j = null;
		this.g = true;
	}

	public Packet z_() {
		class_dn var1 = new class_dn();
		this.b(var1);
		return new class_ft(this.c, 6, var1);
	}

	public int b() {
		return this.a;
	}

	public static int b(class_aas var0) {
		class_dn var1 = var0.a("BlockEntityTag", false);
		return var1 != null && var1.d("Base") ? var1.g("Base") : var0.i();
	}

	public static int c(class_aas var0) {
		class_dn var1 = var0.a("BlockEntityTag", false);
		return var1 != null && var1.d("Patterns") ? var1.c("Patterns", 10).c() : 0;
	}

	public class_du d() {
		return this.f;
	}

	public static void e(class_aas var0) {
		class_dn var1 = var0.a("BlockEntityTag", false);
		if (var1 != null && var1.b("Patterns", 9)) {
			class_du var2 = var1.c("Patterns", 10);
			if (var2.c() > 0) {
				var2.a(var2.c() - 1);
				if (var2.c_()) {
					var0.o().p("BlockEntityTag");
					if (var0.o().c_()) {
						var0.d((class_dn) null);
					}
				}

			}
		}
	}

	public static enum class_a_in_class_ame {
		a("base", "b"), b("square_bottom_left", "bl", "   ", "   ", "#  "), c("square_bottom_right", "br", "   ", "   ", "  #"), d("square_top_left", "tl", "#  ", "   ", "   "), e("square_top_right", "tr", "  #", "   ", "   "), f("stripe_bottom", "bs", "   ", "   ", "###"), g("stripe_top", "ts", "###", "   ", "   "), h("stripe_left", "ls", "#  ", "#  ", "#  "), i("stripe_right", "rs", "  #", "  #", "  #"), j("stripe_center", "cs", " # ", " # ", " # "), k("stripe_middle", "ms", "   ", "###",
				"   "), l("stripe_downright", "drs", "#  ", " # ", "  #"), m("stripe_downleft", "dls", "  #", " # ", "#  "), n("small_stripes", "ss", "# #", "# #", "   "), o("cross", "cr", "# #", " # ", "# #"), p("straight_cross", "sc", " # ", "###", " # "), q("triangle_bottom", "bt", "   ", " # ", "# #"), r("triangle_top", "tt", "# #", " # ", "   "), s("triangles_bottom", "bts", "   ", "# #", " # "), t("triangles_top", "tts", " # ", "# #", "   "), u("diagonal_left", "ld", "## ", "#  ", "   "), v(
				"diagonal_up_right", "rd", "   ", "  #", " ##"), w("diagonal_up_left", "lud", "   ", "#  ", "## "), x("diagonal_right", "rud", " ##", "  #", "   "), y("circle", "mc", "   ", " # ", "   "), z("rhombus", "mr", " # ", "# #", " # "), A("half_vertical", "vh", "## ", "## ", "## "), B("half_horizontal", "hh", "###", "###", "   "), C("half_vertical_right", "vhr", " ##", " ##", " ##"), D("half_horizontal_bottom", "hhb", "   ", "###", "###"), E("border", "bo", "###", "# #", "###"), F(
				"curly_border", "cbo", new class_aas(Blocks.VINE)), G("creeper", "cre", new class_aas(Items.ca, 1, 4)), H("gradient", "gra", "# #", " # ", " # "), I("gradient_up", "gru", " # ", " # ", "# #"), J("bricks", "bri", new class_aas(Blocks.BRICK_BLOCK)), K("skull", "sku", new class_aas(Items.ca, 1, 1)), L("flower", "flo", new class_aas(Blocks.RED_FLOWER, 1, class_aic.class_a_in_class_aic.j.b())), M("mojang", "moj", new class_aas(Items.aq, 1, 1));

		private String N;
		private String O;
		private String[] P;
		private class_aas Q;

		private class_a_in_class_ame(String var3, String var4) {
			this.P = new String[3];
			this.N = var3;
			this.O = var4;
		}

		private class_a_in_class_ame(String var3, String var4, class_aas var5) {
			this(var3, var4);
			this.Q = var5;
		}

		private class_a_in_class_ame(String var3, String var4, String var5, String var6, String var7) {
			this(var3, var4);
			this.P[0] = var5;
			this.P[1] = var6;
			this.P[2] = var7;
		}

		public String b() {
			return this.O;
		}

		public String[] c() {
			return this.P;
		}

		public boolean d() {
			return this.Q != null || this.P[0] != null;
		}

		public boolean e() {
			return this.Q != null;
		}

		public class_aas f() {
			return this.Q;
		}

	}
}
