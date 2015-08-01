package net.minecraft.server;

import net.minecraft.server.class_adj;

public abstract class CreativeTab {

	public static final CreativeTab[] ALL = new CreativeTab[12];
	public static final CreativeTab BUILDING_BLOCKS = new CreativeTab(0, "buildingBlocks") {};
	public static final CreativeTab DECORATIONS = new CreativeTab(1, "decorations") {};
	public static final CreativeTab REDSTONE = new CreativeTab(2, "redstone") {};
	public static final CreativeTab TRANSPORTATION = new CreativeTab(3, "transportation") {};
	public static final CreativeTab MISC = (new CreativeTab(4, "misc") {}).a(new class_adj[] { class_adj.a });
	public static final CreativeTab SEARCH = (new CreativeTab(5, "search") {}).a("item_search.png");
	public static final CreativeTab FOOD = new CreativeTab(6, "food") {};
	public static final CreativeTab TOOLS = (new CreativeTab(7, "tools") {}).a(new class_adj[] { class_adj.h, class_adj.i, class_adj.j });
	public static final CreativeTab COMBAT = (new CreativeTab(8, "combat") {}).a(new class_adj[] { class_adj.b, class_adj.c, class_adj.f, class_adj.d, class_adj.e, class_adj.k, class_adj.g });
	public static final CreativeTab BREWING = new CreativeTab(9, "brewing") {};
	public static final CreativeTab MATERIALS = new CreativeTab(10, "materials") {};
	public static final CreativeTab INVENTORY = (new CreativeTab(11, "inventory") {}).a("inventory.png").k().i();

	private final int n;
	private final String o;
	private String p = "items.png";
	private boolean q = true;
	private boolean r = true;
	private class_adj[] s;

	public CreativeTab(int var1, String var2) {
		this.n = var1;
		this.o = var2;
		ALL[var1] = this;
	}

	public CreativeTab a(String var1) {
		this.p = var1;
		return this;
	}

	public CreativeTab i() {
		this.r = false;
		return this;
	}

	public CreativeTab k() {
		this.q = false;
		return this;
	}

	public CreativeTab a(class_adj... var1) {
		this.s = var1;
		return this;
	}

}
