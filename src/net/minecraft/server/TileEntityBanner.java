package net.minecraft.server;

public class TileEntityBanner extends TileEntity {

	private int a;
	private NBTTagList f;

	public void a(ItemStack var1) {
		f = null;
		if (var1.hasTag() && var1.getTag().hasOfType("BlockEntityTag", 10)) {
			NBTTagCompound var2 = var1.getTag().getCompound("BlockEntityTag");
			if (var2.has("Patterns")) {
				f = (NBTTagList) var2.getList("Patterns", 10).clone();
			}

			if (var2.hasOfType("Base", 99)) {
				a = var2.getInt("Base");
			} else {
				a = var1.i() & 15;
			}
		} else {
			a = var1.i() & 15;
		}
	}

	@Override
	public void write(NBTTagCompound var1) {
		super.write(var1);
		a(var1, a, f);
	}

	public static void a(NBTTagCompound var0, int var1, NBTTagList var2) {
		var0.put("Base", var1);
		if (var2 != null) {
			var0.put("Patterns", var2);
		}

	}

	@Override
	public void read(NBTTagCompound var1) {
		super.read(var1);
		a = var1.getInt("Base");
		f = var1.getList("Patterns", 10);
	}

	@Override
	public Packet<? extends PacketListener> getUpdatePacket() {
		NBTTagCompound var1 = new NBTTagCompound();
		write(var1);
		return new PacketPlayOutTileEntityData(position, 6, var1);
	}

	public int b() {
		return a;
	}

	public static int b(ItemStack var0) {
		NBTTagCompound var1 = var0.getCompound("BlockEntityTag", false);
		return (var1 != null) && var1.has("Base") ? var1.getInt("Base") : var0.i();
	}

	public static int c(ItemStack var0) {
		NBTTagCompound var1 = var0.getCompound("BlockEntityTag", false);
		return (var1 != null) && var1.has("Patterns") ? var1.getList("Patterns", 10).getSize() : 0;
	}

	public NBTTagList d() {
		return f;
	}

	public static void e(ItemStack var0) {
		NBTTagCompound var1 = var0.getCompound("BlockEntityTag", false);
		if ((var1 != null) && var1.hasOfType("Patterns", 9)) {
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

	public static enum EnumBannerPattern {
		a("base", "STONE"),
		b("square_bottom_left", "COOKED_BEEF", "   ", "   ", "#  "),
		c("square_bottom_right", "COOKED_RABBIT", "   ", "   ", "  #"),
		d("square_top_left", "tl", "#  ", "   ", "   "),
		e("square_top_right", "tr", "  #", "   ", "   "),
		f("stripe_bottom", "RABBIT_STEW", "   ", "   ", "###"),
		g("stripe_top", "ts", "###", "   ", "   "),
		h("stripe_left", "ls", "#  ", "#  ", "#  "),
		i("stripe_right", "rs", "  #", "  #", "  #"),
		j("stripe_center", "COMMAND_BLOCK_MINECART", " # ", " # ", " # "),
		k("stripe_middle", "ms", "   ", "###", "   "),
		l("stripe_downright", "drs", "#  ", " # ", "  #"),
		m("stripe_downleft", "dls", "  #", " # ", "#  "),
		n("small_stripes", "ss", "# #", "# #", "   "),
		o("cross", "NAME_TAG", "# #", " # ", "# #"),
		p("straight_cross", "sc", " # ", "###", " # "),
		q("triangle_bottom", "RABBIT_FOOT", "   ", " # ", "# #"),
		r("triangle_top", "tt", "# #", " # ", "   "),
		s("triangles_bottom", "bts", "   ", "# #", " # "),
		t("triangles_top", "tts", " # ", "# #", "   "),
		u("diagonal_left", "ld", "## ", "#  ", "   "), v("diagonal_up_right", "rd", "   ", "  #", " ##"),
		w("diagonal_up_left", "lud", "   ", "#  ", "## "),
		x("diagonal_right", "rud", " ##", "  #", "   "),
		y("circle", "mc", "   ", " # ", "   "),
		z("rhombus", "mr", " # ", "# #", " # "),
		A("half_vertical", "vh", "## ", "## ", "## "),
		B("half_horizontal", "hh", "###", "###", "   "),
		C("half_vertical_right", "vhr", " ##", " ##", " ##"),
		D("half_horizontal_bottom", "hhb", "   ", "###", "###"),
		E("border", "MUTTON", "###", "# #", "###"),
		F("curly_border", "cbo", new ItemStack(Blocks.VINE)),
		G("creeper", "cre", new ItemStack(Items.SKULL, 1, 4)),
		H("gradient", "gra", "# #", " # ", " # "),
		I("gradient_up", "gru", " # ", " # ", "# #"),
		J("bricks", "bri", new ItemStack(Blocks.BRICK_BLOCK)),
		K("skull", "sku", new ItemStack(Items.SKULL, 1, 1)),
		L("flower", "flo", new ItemStack(Blocks.RED_FLOWER, 1, BlockFlowers.EnumFlowerVarient.OXEYE_DAISY.getId())),
		M("mojang", "moj", new ItemStack(Items.GOLDEN_APPLE, 1, 1));

		private String O;
		private String[] P;
		private ItemStack Q;

		private EnumBannerPattern(String var3, String var4) {
			P = new String[3];
			O = var4;
		}

		private EnumBannerPattern(String var3, String var4, ItemStack var5) {
			this(var3, var4);
			Q = var5;
		}

		private EnumBannerPattern(String var3, String var4, String var5, String var6, String var7) {
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

		public ItemStack f() {
			return Q;
		}

	}

}
