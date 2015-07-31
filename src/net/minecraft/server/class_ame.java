package net.minecraft.server;

import java.util.List;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Items;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_aic;
import net.minecraft.server.class_amg;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.NBTTagList;
import net.minecraft.server.NBTTag;
import net.minecraft.server.Packet;
import net.minecraft.server.class_ft;

public class class_ame extends class_amg {
	private int a;
	private NBTTagList f;
	private boolean g;
	private List h;
	private List i;
	private String j;

	public void a(ItemStack var1) {
		this.f = null;
		if (var1.hasTag() && var1.getTag().hasOfType("BlockEntityTag", 10)) {
			NBTTagCompound var2 = var1.getTag().getCompound("BlockEntityTag");
			if (var2.has("Patterns")) {
				this.f = (NBTTagList) var2.getList("Patterns", 10).clone();
			}

			if (var2.hasOfType("Base", 99)) {
				this.a = var2.getInt("Base");
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

	public void b(NBTTagCompound var1) {
		super.b(var1);
		a(var1, this.a, this.f);
	}

	public static void a(NBTTagCompound var0, int var1, NBTTagList var2) {
		var0.put("Base", var1);
		if (var2 != null) {
			var0.put((String) "Patterns", (NBTTag) var2);
		}

	}

	public void a(NBTTagCompound var1) {
		super.a(var1);
		this.a = var1.getInt("Base");
		this.f = var1.getList("Patterns", 10);
		this.h = null;
		this.i = null;
		this.j = null;
		this.g = true;
	}

	public Packet z_() {
		NBTTagCompound var1 = new NBTTagCompound();
		this.b(var1);
		return new class_ft(this.c, 6, var1);
	}

	public int b() {
		return this.a;
	}

	public static int b(ItemStack var0) {
		NBTTagCompound var1 = var0.getCompound("BlockEntityTag", false);
		return var1 != null && var1.has("Base") ? var1.getInt("Base") : var0.i();
	}

	public static int c(ItemStack var0) {
		NBTTagCompound var1 = var0.getCompound("BlockEntityTag", false);
		return var1 != null && var1.has("Patterns") ? var1.getList("Patterns", 10).getSize() : 0;
	}

	public NBTTagList d() {
		return this.f;
	}

	public static void e(ItemStack var0) {
		NBTTagCompound var1 = var0.getCompound("BlockEntityTag", false);
		if (var1 != null && var1.hasOfType("Patterns", 9)) {
			NBTTagList var2 = var1.getList("Patterns", 10);
			if (var2.getSize() > 0) {
				var2.remove(var2.getSize() - 1);
				if (var2.isEmpty()) {
					var0.getTag().remove("BlockEntityTag");
					if (var0.getTag().isEmpty()) {
						var0.setTag((NBTTagCompound) null);
					}
				}

			}
		}
	}

	public static enum class_a_in_class_ame {
		a("base", "b"), b("square_bottom_left", "bl", "   ", "   ", "#  "), c("square_bottom_right", "br", "   ", "   ", "  #"), d("square_top_left", "tl", "#  ", "   ", "   "), e("square_top_right", "tr", "  #", "   ", "   "), f("stripe_bottom", "bs", "   ", "   ", "###"), g("stripe_top", "ts", "###", "   ", "   "), h("stripe_left", "ls", "#  ", "#  ", "#  "), i("stripe_right", "rs", "  #", "  #", "  #"), j("stripe_center", "cs", " # ", " # ", " # "), k("stripe_middle", "ms", "   ", "###",
				"   "), l("stripe_downright", "drs", "#  ", " # ", "  #"), m("stripe_downleft", "dls", "  #", " # ", "#  "), n("small_stripes", "ss", "# #", "# #", "   "), o("cross", "cr", "# #", " # ", "# #"), p("straight_cross", "sc", " # ", "###", " # "), q("triangle_bottom", "bt", "   ", " # ", "# #"), r("triangle_top", "tt", "# #", " # ", "   "), s("triangles_bottom", "bts", "   ", "# #", " # "), t("triangles_top", "tts", " # ", "# #", "   "), u("diagonal_left", "ld", "## ", "#  ", "   "), v(
				"diagonal_up_right", "rd", "   ", "  #", " ##"), w("diagonal_up_left", "lud", "   ", "#  ", "## "), x("diagonal_right", "rud", " ##", "  #", "   "), y("circle", "mc", "   ", " # ", "   "), z("rhombus", "mr", " # ", "# #", " # "), A("half_vertical", "vh", "## ", "## ", "## "), B("half_horizontal", "hh", "###", "###", "   "), C("half_vertical_right", "vhr", " ##", " ##", " ##"), D("half_horizontal_bottom", "hhb", "   ", "###", "###"), E("border", "bo", "###", "# #", "###"), F(
				"curly_border", "cbo", new ItemStack(Blocks.VINE)), G("creeper", "cre", new ItemStack(Items.ca, 1, 4)), H("gradient", "gra", "# #", " # ", " # "), I("gradient_up", "gru", " # ", " # ", "# #"), J("bricks", "bri", new ItemStack(Blocks.BRICK_BLOCK)), K("skull", "sku", new ItemStack(Items.ca, 1, 1)), L("flower", "flo", new ItemStack(Blocks.RED_FLOWER, 1, class_aic.class_a_in_class_aic.j.b())), M("mojang", "moj", new ItemStack(Items.aq, 1, 1));

		private String N;
		private String O;
		private String[] P;
		private ItemStack Q;

		private class_a_in_class_ame(String var3, String var4) {
			this.P = new String[3];
			this.N = var3;
			this.O = var4;
		}

		private class_a_in_class_ame(String var3, String var4, ItemStack var5) {
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

		public ItemStack f() {
			return this.Q;
		}

	}
}
