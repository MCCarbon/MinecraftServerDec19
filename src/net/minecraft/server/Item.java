package net.minecraft.server;

import com.google.common.base.Function;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;

import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class Item {

	public static final RegistryMaterials<MinecraftKey, Item> ITEM_REGISTRY = new RegistryMaterials<MinecraftKey, Item>();
	private static final Map<Block, Item> BLOCK_TO_ITEM = Maps.newHashMap();
	private static final class_aat b = new class_aat() {
	};
	private static final class_aat c = new class_aat() {
	};
	private static final class_aat d = new class_aat() {
	};
	private IRegistry<MinecraftKey, class_aat> k = new RegistrySimple<MinecraftKey, class_aat>();
	protected static final UUID uuid = UUID.fromString("CB3F55D3-645C-4F38-A497-9C13A33DB5CF");
	protected static Random random = new Random();

	protected int h = 64;
	private int m;
	protected boolean i;
	protected boolean j;
	private Item n;
	private String o;

	public static int getId(Item item) {
		return item == null ? 0 : ITEM_REGISTRY.getId(item);
	}

	public static Item getById(int id) {
		return ITEM_REGISTRY.get(id);
	}

	public static Item getItemOf(Block block) {
		return BLOCK_TO_ITEM.get(block);
	}

	public static Item getByName(String string) {
		Item item = ITEM_REGISTRY.get(new MinecraftKey(string));
		if (item == null) {
			try {
				return getById(Integer.parseInt(string));
			} catch (NumberFormatException var3) {
			}
		}
		return item;
	}

	public final void a(MinecraftKey var1, class_aat var2) {
		this.k.register(var1, var2);
	}

	public boolean a(NBTTagCompound var1) {
		return false;
	}

	public Item() {
		this.a(new MinecraftKey("lefthanded"), d);
	}

	public Item d(int var1) {
		this.h = var1;
		return this;
	}

	public UseResult a(ItemStack var1, EntityHuman var2, World var3, BlockPosition var4, EnumUsedHand var5, EnumDirection var6, float var7, float var8, float var9) {
		return UseResult.CANT_USE;
	}

	public float a(ItemStack var1, Block var2) {
		return 1.0F;
	}

	public class_or a(ItemStack var1, World var2, EntityHuman var3, EnumUsedHand var4) {
		return new class_or(UseResult.CANT_USE, var1);
	}

	public ItemStack a(ItemStack var1, World var2, EntityLiving var3) {
		return var1;
	}

	public int j() {
		return this.h;
	}

	public int a(int var1) {
		return 0;
	}

	public boolean k() {
		return this.j;
	}

	protected Item a(boolean var1) {
		this.j = var1;
		return this;
	}

	public int l() {
		return this.m;
	}

	protected Item e(int var1) {
		this.m = var1;
		if (var1 > 0) {
			this.a(new MinecraftKey("damaged"), b);
			this.a(new MinecraftKey("damage"), c);
		}

		return this;
	}

	public boolean m() {
		return this.m > 0 && !this.j;
	}

	public boolean a(ItemStack var1, EntityLiving var2, EntityLiving var3) {
		return false;
	}

	public boolean a(ItemStack var1, World var2, Block var3, BlockPosition var4, EntityLiving var5) {
		return false;
	}

	public boolean b(Block var1) {
		return false;
	}

	public boolean a(ItemStack var1, EntityHuman var2, EntityLiving var3, EnumUsedHand var4) {
		return false;
	}

	public Item n() {
		this.i = true;
		return this;
	}

	public Item c(String var1) {
		this.o = var1;
		return this;
	}

	public String j(ItemStack var1) {
		String var2 = this.e_(var1);
		return var2 == null ? "" : LocaleI18n.get(var2);
	}

	public String a() {
		return "item." + this.o;
	}

	public String e_(ItemStack var1) {
		return "item." + this.o;
	}

	public Item c(Item var1) {
		this.n = var1;
		return this;
	}

	public boolean p() {
		return true;
	}

	public Item q() {
		return this.n;
	}

	public boolean r() {
		return this.n != null;
	}

	public void a(ItemStack var1, World var2, Entity var3, int var4, boolean var5) {
	}

	public void b(ItemStack var1, World var2, EntityHuman var3) {
	}

	public boolean f() {
		return false;
	}

	public class_abz f(ItemStack var1) {
		return class_abz.NONE;
	}

	public int e(ItemStack var1) {
		return 0;
	}

	public void a(ItemStack var1, World var2, EntityLiving var3, int var4) {
	}

	public String getLocalizedName(ItemStack itemstack) {
		return ("" + LocaleI18n.get(this.j(itemstack) + ".name")).trim();
	}

	public class_abf g(ItemStack var1) {
		return var1.hasEnchantments() ? class_abf.c : class_abf.a;
	}

	public boolean f_(ItemStack var1) {
		return this.j() == 1 && this.m();
	}

	protected MovingObjectPosition a(World var1, EntityHuman var2, boolean var3) {
		float var4 = var2.z;
		float var5 = var2.y;
		double var6 = var2.s;
		double var8 = var2.t + (double) var2.aU();
		double var10 = var2.u;
		Vec3D var12 = new Vec3D(var6, var8, var10);
		float var13 = MathHelper.cos(-var5 * 0.017453292F - 3.1415927F);
		float var14 = MathHelper.sin(-var5 * 0.017453292F - 3.1415927F);
		float var15 = -MathHelper.cos(-var4 * 0.017453292F);
		float var16 = MathHelper.sin(-var4 * 0.017453292F);
		float var17 = var14 * var15;
		float var19 = var13 * var15;
		double var20 = 5.0D;
		Vec3D var22 = var12.add((double) var17 * var20, (double) var16 * var20, (double) var19 * var20);
		return var1.a(var12, var22, var3, !var3, false);
	}

	public int c() {
		return 0;
	}

	public Item a(CreativeTab var1) {
		return this;
	}

	public boolean s() {
		return false;
	}

	public boolean a(ItemStack var1, ItemStack var2) {
		return false;
	}

	public Multimap<?, ?> a(class_pw var1) {
		return HashMultimap.create();
	}

	public static void init() {
		register(Blocks.STONE, (new class_aba(Blocks.STONE, Blocks.STONE, new Function<Object, Object>() {
			public String a(ItemStack var1) {
				return BlockStone.EnumStoneVariant.getByData(var1.i()).getILocaleName();
			}

			// $FF: synthetic method
			public Object apply(Object var1) {
				return this.a((ItemStack) var1);
			}
		})).b("stone"));
		register(Blocks.GRASS, new class_abx(Blocks.GRASS, false));
		register(Blocks.DIRT, (new class_aba(Blocks.DIRT, Blocks.DIRT, new Function<Object, Object>() {
			public String a(ItemStack var1) {
				return BlockDirt.EnumDirtVariant.getById(var1.i()).c();
			}

			// $FF: synthetic method
			public Object apply(Object var1) {
				return this.a((ItemStack) var1);
			}
		})).b("dirt"));
		register(Blocks.COBBLESTONE);
		register(Blocks.PLANKS, (new class_aba(Blocks.PLANKS, Blocks.PLANKS, new Function<Object, Object>() {
			public String a(ItemStack var1) {
				return BlockWood.EnumLogVariant.getById(var1.i()).d();
			}

			// $FF: synthetic method
			public Object apply(Object var1) {
				return this.a((ItemStack) var1);
			}
		})).b("wood"));
		register(Blocks.SAPLING, (new class_aba(Blocks.SAPLING, Blocks.SAPLING, new Function<Object, Object>() {
			public String a(ItemStack var1) {
				return BlockWood.EnumLogVariant.getById(var1.i()).d();
			}

			// $FF: synthetic method
			public Object apply(Object var1) {
				return this.a((ItemStack) var1);
			}
		})).b("sapling"));
		register(Blocks.BEDROCK);
		register(Blocks.SAND, (new class_aba(Blocks.SAND, Blocks.SAND, new Function<Object, Object>() {
			public String a(ItemStack var1) {
				return BlockSand.EnumSandVariant.getById(var1.i()).d();
			}

			// $FF: synthetic method
			public Object apply(Object var1) {
				return this.a((ItemStack) var1);
			}
		})).b("sand"));
		register(Blocks.GRAVEL);
		register(Blocks.GOLD_ORE);
		register(Blocks.IRON_ORE);
		register(Blocks.COAL_ORE);
		register(Blocks.LOG, (new class_aba(Blocks.LOG, Blocks.LOG, new Function<Object, Object>() {
			public String a(ItemStack var1) {
				return BlockWood.EnumLogVariant.getById(var1.i()).d();
			}

			// $FF: synthetic method
			public Object apply(Object var1) {
				return this.a((ItemStack) var1);
			}
		})).b("log"));
		register(Blocks.LOG2, (new class_aba(Blocks.LOG2, Blocks.LOG2, new Function<Object, Object>() {
			public String a(ItemStack var1) {
				return BlockWood.EnumLogVariant.getById(var1.i() + 4).d();
			}

			// $FF: synthetic method
			public Object apply(Object var1) {
				return this.a((ItemStack) var1);
			}
		})).b("log"));
		register(Blocks.LEAVES, (new class_aaw(Blocks.LEAVES)).b("leaves"));
		register(Blocks.LEAVES2, (new class_aaw(Blocks.LEAVES2)).b("leaves"));
		register(Blocks.SPONGE, (new class_aba(Blocks.SPONGE, Blocks.SPONGE, new Function<Object, Object>() {
			public String a(ItemStack var1) {
				return (var1.i() & 1) == 1 ? "wet" : "dry";
			}

			// $FF: synthetic method
			public Object apply(Object var1) {
				return this.a((ItemStack) var1);
			}
		})).b("sponge"));
		register(Blocks.GLASS);
		register(Blocks.LAPIS_ORE);
		register(Blocks.LAPIS_BLOCK);
		register(Blocks.DISPENSER);
		register(Blocks.SANDSTONE, (new class_aba(Blocks.SANDSTONE, Blocks.SANDSTONE, new Function<Object, Object>() {
			public String a(ItemStack var1) {
				return BlockSandStone.EnumSandstoneVariant.getById(var1.i()).c();
			}

			// $FF: synthetic method
			public Object apply(Object var1) {
				return this.a((ItemStack) var1);
			}
		})).b("sandStone"));
		register(Blocks.NOTEBLOCK);
		register(Blocks.GOLDEN_RAIL);
		register(Blocks.DETECTOR_RAIL);
		register(Blocks.STICKY_PISTON, new class_abd(Blocks.STICKY_PISTON));
		register(Blocks.WEB);
		register(Blocks.TALLGRASS, (new class_abx(Blocks.TALLGRASS, true)).a(new String[] { "shrub", "grass", "fern" }));
		register(Blocks.DEADBUSH);
		register(Blocks.PISTON, new class_abd(Blocks.PISTON));
		register(Blocks.WOOL, (new class_aaa(Blocks.WOOL)).b("cloth"));
		register(Blocks.YELLOW_FLOWER, (new class_aba(Blocks.YELLOW_FLOWER, Blocks.YELLOW_FLOWER, new Function<Object, Object>() {
			public String a(ItemStack var1) {
				return BlockFlowers.EnumFlowerVarient.getById(BlockFlowers.EnumFlowerType.YELLOW, var1.i()).d();
			}

			// $FF: synthetic method
			public Object apply(Object var1) {
				return this.a((ItemStack) var1);
			}
		})).b("flower"));
		register(Blocks.RED_FLOWER, (new class_aba(Blocks.RED_FLOWER, Blocks.RED_FLOWER, new Function<Object, Object>() {
			public String a(ItemStack var1) {
				return BlockFlowers.EnumFlowerVarient.getById(BlockFlowers.EnumFlowerType.RED, var1.i()).d();
			}

			// $FF: synthetic method
			public Object apply(Object var1) {
				return this.a((ItemStack) var1);
			}
		})).b("rose"));
		register(Blocks.BROWN_MUSHROOM);
		register(Blocks.RED_MUSHROOM);
		register(Blocks.GOLD_BLOCK);
		register(Blocks.IRON_BLOCK);
		register(Blocks.STONE_SLAB, (new class_abq(Blocks.STONE_SLAB, Blocks.STONE_SLAB, Blocks.DOUBLE_SANDSTONE_SLAB)).b("stoneSlab"));
		register(Blocks.BRICK_BLOCK);
		register(Blocks.TNT);
		register(Blocks.BOOKSHELF);
		register(Blocks.MOSSY_COBBLESTONE);
		register(Blocks.OBSIDIAN);
		register(Blocks.TORCH);
		register(Blocks.END_ROD);
		register(Blocks.CHORUS_PLANT);
		register(Blocks.CHORUS_FLOWER);
		register(Blocks.PURPUR_BLOCK);
		register(Blocks.PURPUR_PILLAR);
		register(Blocks.PURPUR_STAIRS);
		register(Blocks.PURPUR_SLAB, (new class_abq(Blocks.PURPUR_SLAB, Blocks.PURPUR_SLAB, Blocks.PURPUR_DOUBLE_SLAB)).b("purpurSlab"));
		register(Blocks.MOB_SPAWNER);
		register(Blocks.OAK_STAIRS);
		register(Blocks.CHEST);
		register(Blocks.DIAMOND_ORE);
		register(Blocks.DIAMOND_BLOCK);
		register(Blocks.CRAFTING_TABLE);
		register(Blocks.FARMLAND);
		register(Blocks.FURNACE);
		register(Blocks.LIT_FURNACE);
		register(Blocks.LADDER);
		register(Blocks.RAIL);
		register(Blocks.STONE_STAIRS);
		register(Blocks.LEVER);
		register(Blocks.STONE_PRESSURE_PLATE);
		register(Blocks.WOODEN_PRESSURE_PLATE);
		register(Blocks.REDSTONE_ORE);
		register(Blocks.REDSTONE_TORCH);
		register(Blocks.STONE_BUTTON);
		register(Blocks.SNOW_LAYER, new class_abr(Blocks.SNOW_LAYER));
		register(Blocks.ICE);
		register(Blocks.SNOW);
		register(Blocks.CACTUS);
		register(Blocks.CLAY);
		register(Blocks.JUKEBOX);
		register(Blocks.FENCE);
		register(Blocks.SPRUCE_FENCE);
		register(Blocks.BIRCH_FENCE);
		register(Blocks.JUNGLE_FENCE);
		register(Blocks.DARK_OAK_FENCE);
		register(Blocks.ACACIA_FENCE);
		register(Blocks.PUMPKIN);
		register(Blocks.NETHERRACK);
		register(Blocks.SOUL_SAND);
		register(Blocks.GLOWSTONE);
		register(Blocks.LIT_PUMPKIN);
		register(Blocks.TRAPDOOR);
		register(Blocks.MONSTER_EGG, (new class_aba(Blocks.MONSTER_EGG, Blocks.MONSTER_EGG, new Function<Object, Object>() {
			public String a(ItemStack var1) {
				return class_ajh.class_a_in_class_ajh.a(var1.i()).c();
			}

			// $FF: synthetic method
			public Object apply(Object var1) {
				return this.a((ItemStack) var1);
			}
		})).b("monsterStoneEgg"));
		register(Blocks.STONEBRICK, (new class_aba(Blocks.STONEBRICK, Blocks.STONEBRICK, new Function<Object, Object>() {
			public String a(ItemStack var1) {
				return class_ali.class_a_in_class_ali.a(var1.i()).c();
			}

			// $FF: synthetic method
			public Object apply(Object var1) {
				return this.a((ItemStack) var1);
			}
		})).b("stonebricksmooth"));
		register(Blocks.BROWN_MUSHROOM_BLOCK);
		register(Blocks.RED_MUSHROOM_BLOCK);
		register(Blocks.IRON_BARS);
		register(Blocks.GLASS_PANE);
		register(Blocks.MELON_BLOCK);
		register(Blocks.VINE, new class_abx(Blocks.VINE, false));
		register(Blocks.FENCE_GATE);
		register(Blocks.SPRUCE_FENCE_GATE);
		register(Blocks.BIRCH_FENCE_GATE);
		register(Blocks.JUGLE_FENCE_GATE);
		register(Blocks.DARK_OAK_FENCE_GATE);
		register(Blocks.ACACIA_FENCE_GATE);
		register(Blocks.BRICK_STAIRS);
		register(Blocks.STONE_BRICK_STAIRS);
		register(Blocks.MYCELIM);
		register(Blocks.WATERLILY, new class_aca(Blocks.WATERLILY));
		register(Blocks.NETHER_BRICK);
		register(Blocks.NETHER_BRICK_FENCE);
		register(Blocks.NETHER_BTICK_STAIRS);
		register(Blocks.ENCHANTING_TABLE);
		register(Blocks.END_PORTAL_FRAME);
		register(Blocks.END_STONE);
		register(Blocks.END_BRICKS);
		register(Blocks.DRAGON_EGG);
		register(Blocks.REDSTONE_LAMP);
		register(Blocks.WOODEN_SLAB, (new class_abq(Blocks.WOODEN_SLAB, Blocks.WOODEN_SLAB, Blocks.DOUBLE_WOODEN_SLAB)).b("woodSlab"));
		register(Blocks.SANDSTONE_STAIRS);
		register(Blocks.EMERALD_ORE);
		register(Blocks.ENDER_CHEST);
		register(Blocks.TRIPWIRE_HOOK);
		register(Blocks.EMERALD_BLOCK);
		register(Blocks.SPRUCE_STAIRS);
		register(Blocks.BIRCH_STAIRS);
		register(Blocks.JUNGKE_STAIRS);
		register(Blocks.COMMAND_BLOCK);
		register(Blocks.BEACON);
		register(Blocks.COBBLESTONE_WALL, (new class_aba(Blocks.COBBLESTONE_WALL, Blocks.COBBLESTONE_WALL, new Function<Object, Object>() {
			public String a(ItemStack var1) {
				return class_alv.class_a_in_class_alv.a(var1.i()).c();
			}

			// $FF: synthetic method
			public Object apply(Object var1) {
				return this.a((ItemStack) var1);
			}
		})).b("cobbleWall"));
		register(Blocks.WOODEN_BUTTON);
		register(Blocks.ANVIL, (new class_yz(Blocks.ANVIL)).b("anvil"));
		register(Blocks.TRAPPED_CHEST);
		register(Blocks.LIGHT_W_PRESSURE_PLATE);
		register(Blocks.HEAVY_W_PRESSURE_PLATE);
		register(Blocks.DAYLIGHT_DETECTOR);
		register(Blocks.REDSTONE_BLOCK);
		register(Blocks.QUARTZ_ORE);
		register(Blocks.HOPPER);
		register(Blocks.QUARTZ_BLOCK, (new class_aba(Blocks.QUARTZ_BLOCK, Blocks.QUARTZ_BLOCK, new String[] { "default", "chiseled", "lines" })).b("quartzBlock"));
		register(Blocks.QUARTZ_STAIRS);
		register(Blocks.ACTIVATOR_RAIL);
		register(Blocks.DROPPER);
		register(Blocks.STAINED_HARDENED_CLAY, (new class_aaa(Blocks.STAINED_HARDENED_CLAY)).b("clayHardenedStained"));
		register(Blocks.BARRIER);
		register(Blocks.IRON_TRAPDOOR);
		register(Blocks.HAY_BLOCK);
		register(Blocks.CARPET, (new class_aaa(Blocks.CARPET)).b("woolCarpet"));
		register(Blocks.HARDENED_CLAY);
		register(Blocks.COAL_BLOCK);
		register(Blocks.PACKED_ICE);
		register(Blocks.ACACIA_STAIRS);
		register(Blocks.DARK_OAK_STAIRS);
		register(Blocks.SLINE);
		register(Blocks.GRASS_PATH);
		register(Blocks.DOUBLE_PLANT, (new class_zx(Blocks.DOUBLE_PLANT, Blocks.DOUBLE_PLANT, new Function<Object, Object>() {
			public String a(ItemStack var1) {
				return class_ahm.class_b_in_class_ahm.a(var1.i()).c();
			}

			// $FF: synthetic method
			public Object apply(Object var1) {
				return this.a((ItemStack) var1);
			}
		})).b("doublePlant"));
		register(Blocks.STAINED_GLASS, (new class_aaa(Blocks.STAINED_GLASS)).b("stainedGlass"));
		register(Blocks.STAINED_GLASS_PANE, (new class_aaa(Blocks.STAINED_GLASS_PANE)).b("stainedGlassPane"));
		register(Blocks.PRISMARINE, (new class_aba(Blocks.PRISMARINE, Blocks.PRISMARINE, new Function<Object, Object>() {
			public String a(ItemStack var1) {
				return class_akc.class_a_in_class_akc.a(var1.i()).c();
			}

			// $FF: synthetic method
			public Object apply(Object var1) {
				return this.a((ItemStack) var1);
			}
		})).b("prismarine"));
		register(Blocks.SEA_LANTERN);
		register(Blocks.RED_SANDSTONE, (new class_aba(Blocks.RED_SANDSTONE, Blocks.RED_SANDSTONE, new Function<Object, Object>() {
			public String a(ItemStack var1) {
				return class_aki.class_a_in_class_aki.a(var1.i()).c();
			}

			// $FF: synthetic method
			public Object apply(Object var1) {
				return this.a((ItemStack) var1);
			}
		})).b("redSandStone"));
		register(Blocks.RED_SANDSTONE_STAIRS);
		register(Blocks.STONE_SLAB2, (new class_abq(Blocks.STONE_SLAB2, Blocks.STONE_SLAB2, Blocks.DOUBLE_STONE_SLAB2)).b("stoneSlab2"));
		register(256, "iron_shovel", (new class_abm(Item.class_a_in_class_aar.c)).c("shovelIron"));
		register(257, "iron_pickaxe", (new class_abc(Item.class_a_in_class_aar.c)).c("pickaxeIron"));
		register(258, "iron_axe", (new class_zd(Item.class_a_in_class_aar.c)).c("hatchetIron"));
		register(259, "flint_and_steel", (new class_aam()).c("flintAndSteel"));
		register(260, "apple", (new ItemBeetroot(4, 0.3F, false)).c("apple"));
		register(261, "bow", (new ItemBow()).c("bow"));
		register(262, "arrow", (new class_zc()).c("arrow"));
		register(263, "coal", (new class_zr()).c("coal"));
		register(264, "diamond", (new Item()).c("diamond").a(CreativeTab.MATERIALS));
		register(265, "iron_ingot", (new Item()).c("ingotIron").a(CreativeTab.MATERIALS));
		register(266, "gold_ingot", (new Item()).c("ingotGold").a(CreativeTab.MATERIALS));
		register(267, "iron_sword", (new class_abw(Item.class_a_in_class_aar.c)).c("swordIron"));
		register(268, "wooden_sword", (new class_abw(Item.class_a_in_class_aar.a)).c("swordWood"));
		register(269, "wooden_shovel", (new class_abm(Item.class_a_in_class_aar.a)).c("shovelWood"));
		register(270, "wooden_pickaxe", (new class_abc(Item.class_a_in_class_aar.a)).c("pickaxeWood"));
		register(271, "wooden_axe", (new class_zd(Item.class_a_in_class_aar.a)).c("hatchetWood"));
		register(272, "stone_sword", (new class_abw(Item.class_a_in_class_aar.b)).c("swordStone"));
		register(273, "stone_shovel", (new class_abm(Item.class_a_in_class_aar.b)).c("shovelStone"));
		register(274, "stone_pickaxe", (new class_abc(Item.class_a_in_class_aar.b)).c("pickaxeStone"));
		register(275, "stone_axe", (new class_zd(Item.class_a_in_class_aar.b)).c("hatchetStone"));
		register(276, "diamond_sword", (new class_abw(Item.class_a_in_class_aar.d)).c("swordDiamond"));
		register(277, "diamond_shovel", (new class_abm(Item.class_a_in_class_aar.d)).c("shovelDiamond"));
		register(278, "diamond_pickaxe", (new class_abc(Item.class_a_in_class_aar.d)).c("pickaxeDiamond"));
		register(279, "diamond_axe", (new class_zd(Item.class_a_in_class_aar.d)).c("hatchetDiamond"));
		register(280, "stick", (new Item()).n().c("stick").a(CreativeTab.MATERIALS));
		register(281, "bowl", (new Item()).c("bowl").a(CreativeTab.MATERIALS));
		register(282, "mushroom_stew", (new ItemBeetrootSoup(6)).c("mushroomStew"));
		register(283, "golden_sword", (new class_abw(Item.class_a_in_class_aar.e)).c("swordGold"));
		register(284, "golden_shovel", (new class_abm(Item.class_a_in_class_aar.e)).c("shovelGold"));
		register(285, "golden_pickaxe", (new class_abc(Item.class_a_in_class_aar.e)).c("pickaxeGold"));
		register(286, "golden_axe", (new class_zd(Item.class_a_in_class_aar.e)).c("hatchetGold"));
		register(287, "string", (new class_zh(Blocks.TRIPWIRE)).c("string").a(CreativeTab.MATERIALS));
		register(288, "feather", (new Item()).c("feather").a(CreativeTab.MATERIALS));
		register(289, "gunpowder", (new Item()).c("sulphur").a(CreativeTab.MATERIALS));
		register(290, "wooden_hoe", (new class_aaq(Item.class_a_in_class_aar.a)).c("hoeWood"));
		register(291, "stone_hoe", (new class_aaq(Item.class_a_in_class_aar.b)).c("hoeStone"));
		register(292, "iron_hoe", (new class_aaq(Item.class_a_in_class_aar.c)).c("hoeIron"));
		register(293, "diamond_hoe", (new class_aaq(Item.class_a_in_class_aar.d)).c("hoeDiamond"));
		register(294, "golden_hoe", (new class_aaq(Item.class_a_in_class_aar.e)).c("hoeGold"));
		register(295, "wheat_seeds", (new ItemSeeds(Blocks.WHEAT, Blocks.FARMLAND)).c("seeds"));
		register(296, "wheat", (new Item()).c("wheat").a(CreativeTab.MATERIALS));
		register(297, "bread", (new ItemBeetroot(5, 0.6F, false)).c("bread"));
		register(298, "leather_helmet", (new class_za(class_za.class_a_in_class_za.a, 0, class_pw.f)).c("helmetCloth"));
		register(299, "leather_chestplate", (new class_za(class_za.class_a_in_class_za.a, 0, class_pw.e)).c("chestplateCloth"));
		register(300, "leather_leggings", (new class_za(class_za.class_a_in_class_za.a, 0, class_pw.d)).c("leggingsCloth"));
		register(301, "leather_boots", (new class_za(class_za.class_a_in_class_za.a, 0, class_pw.c)).c("bootsCloth"));
		register(302, "chainmail_helmet", (new class_za(class_za.class_a_in_class_za.b, 1, class_pw.f)).c("helmetChain"));
		register(303, "chainmail_chestplate", (new class_za(class_za.class_a_in_class_za.b, 1, class_pw.e)).c("chestplateChain"));
		register(304, "chainmail_leggings", (new class_za(class_za.class_a_in_class_za.b, 1, class_pw.d)).c("leggingsChain"));
		register(305, "chainmail_boots", (new class_za(class_za.class_a_in_class_za.b, 1, class_pw.c)).c("bootsChain"));
		register(306, "iron_helmet", (new class_za(class_za.class_a_in_class_za.c, 2, class_pw.f)).c("helmetIron"));
		register(307, "iron_chestplate", (new class_za(class_za.class_a_in_class_za.c, 2, class_pw.e)).c("chestplateIron"));
		register(308, "iron_leggings", (new class_za(class_za.class_a_in_class_za.c, 2, class_pw.d)).c("leggingsIron"));
		register(309, "iron_boots", (new class_za(class_za.class_a_in_class_za.c, 2, class_pw.c)).c("bootsIron"));
		register(310, "diamond_helmet", (new class_za(class_za.class_a_in_class_za.e, 3, class_pw.f)).c("helmetDiamond"));
		register(311, "diamond_chestplate", (new class_za(class_za.class_a_in_class_za.e, 3, class_pw.e)).c("chestplateDiamond"));
		register(312, "diamond_leggings", (new class_za(class_za.class_a_in_class_za.e, 3, class_pw.d)).c("leggingsDiamond"));
		register(313, "diamond_boots", (new class_za(class_za.class_a_in_class_za.e, 3, class_pw.c)).c("bootsDiamond"));
		register(314, "golden_helmet", (new class_za(class_za.class_a_in_class_za.d, 4, class_pw.f)).c("helmetGold"));
		register(315, "golden_chestplate", (new class_za(class_za.class_a_in_class_za.d, 4, class_pw.e)).c("chestplateGold"));
		register(316, "golden_leggings", (new class_za(class_za.class_a_in_class_za.d, 4, class_pw.d)).c("leggingsGold"));
		register(317, "golden_boots", (new class_za(class_za.class_a_in_class_za.d, 4, class_pw.c)).c("bootsGold"));
		register(318, "flint", (new Item()).c("flint").a(CreativeTab.MATERIALS));
		register(319, "porkchop", (new ItemBeetroot(3, 0.3F, true)).c("porkchopRaw"));
		register(320, "cooked_porkchop", (new ItemBeetroot(8, 0.8F, true)).c("porkchopCooked"));
		register(321, "painting", (new class_aap(class_vc.class)).c("painting"));
		register(322, "golden_apple", (new class_aao(4, 1.2F, false)).h().a(new class_pl(class_pm.j, 100, 1), 1.0F).c("appleGold"));
		register(323, "sign", (new class_abn()).c("sign"));
		register(324, "wooden_door", (new class_zw(Blocks.WOODEN_DOOR)).c("doorOak"));
		Item var0 = (new class_zn(Blocks.AIR)).c("bucket").d(16);
		register(325, "bucket", var0);
		register(326, "water_bucket", (new class_zn(Blocks.FLOWING_WATER)).c("bucketWater").c(var0));
		register(327, "lava_bucket", (new class_zn(Blocks.FLOWING_LAVA)).c("bucketLava").c(var0));
		register(328, "minecart", (new class_aaz(class_vn.class_a_in_class_vn.a)).c("minecart"));
		register(329, "saddle", (new class_abi()).c("saddle"));
		register(330, "iron_door", (new class_zw(Blocks.IRON_DOOR)).c("doorIron"));
		register(331, "redstone", (new class_abh()).c("redstone"));
		register(332, "snowball", (new class_abs()).c("snowball"));
		register(333, "boat", (new class_zi()).c("boat"));
		register(334, "leather", (new Item()).c("leather").a(CreativeTab.MATERIALS));
		register(335, "milk_bucket", (new class_aay()).c("milk").c(var0));
		register(336, "brick", (new Item()).c("brick").a(CreativeTab.MATERIALS));
		register(337, "clay_ball", (new Item()).c("clay").a(CreativeTab.MATERIALS));
		register(338, "reeds", (new class_zh(Blocks.REEDS)).c("reeds").a(CreativeTab.MATERIALS));
		register(339, "paper", (new Item()).c("paper").a(CreativeTab.MISC));
		register(340, "book", (new class_zj()).c("book").a(CreativeTab.MISC));
		register(341, "slime_ball", (new Item()).c("slimeball").a(CreativeTab.MISC));
		register(342, "chest_minecart", (new class_aaz(class_vn.class_a_in_class_vn.b)).c("minecartChest"));
		register(343, "furnace_minecart", (new class_aaz(class_vn.class_a_in_class_vn.c)).c("minecartFurnace"));
		register(344, "egg", (new class_aab()).c("egg"));
		register(345, "compass", (new class_zs()).c("compass").a(CreativeTab.TOOLS));
		register(346, "fishing_rod", (new class_aal()).c("fishingRod"));
		register(347, "clock", (new class_zq()).c("clock").a(CreativeTab.TOOLS));
		register(348, "glowstone_dust", (new Item()).c("yellowDust").a(CreativeTab.MATERIALS));
		register(349, "fish", (new class_aak(false)).c("fish").a(true));
		register(350, "cooked_fish", (new class_aak(true)).c("fish").a(true));
		register(351, "dye", (new class_zz()).c("dyePowder"));
		register(352, "bone", (new Item()).c("bone").n().a(CreativeTab.MISC));
		register(353, "sugar", (new Item()).c("sugar").a(CreativeTab.MATERIALS));
		register(354, "cake", (new class_zh(Blocks.CAKE)).d(1).c("cake").a(CreativeTab.FOOD));
		register(355, "bed", (new class_zf()).d(1).c("bed"));
		register(356, "repeater", (new class_zh(Blocks.UNPOWERED_REPEATER)).c("diode").a(CreativeTab.REDSTONE));
		register(357, "cookie", (new ItemBeetroot(2, 0.1F, false)).c("cookie"));
		register(358, "filled_map", (new class_aax()).c("map"));
		register(359, "shears", (new class_abl()).c("shears"));
		register(360, "melon", (new ItemBeetroot(2, 0.3F, false)).c("melon"));
		register(361, "pumpkin_seeds", (new ItemSeeds(Blocks.PUMPKIN_STEM, Blocks.FARMLAND)).c("seeds_pumpkin"));
		register(362, "melon_seeds", (new ItemSeeds(Blocks.MELON_STEM, Blocks.FARMLAND)).c("seeds_melon"));
		register(363, "beef", (new ItemBeetroot(3, 0.3F, true)).c("beefRaw"));
		register(364, "cooked_beef", (new ItemBeetroot(8, 0.8F, true)).c("beefCooked"));
		register(365, "chicken", (new ItemBeetroot(2, 0.3F, true)).a(new class_pl(class_pm.q, 600, 0), 0.3F).c("chickenRaw"));
		register(366, "cooked_chicken", (new ItemBeetroot(6, 0.6F, true)).c("chickenCooked"));
		register(367, "rotten_flesh", (new ItemBeetroot(4, 0.1F, true)).a(new class_pl(class_pm.q, 600, 0), 0.8F).c("rottenFlesh"));
		register(368, "ender_pearl", (new class_aaf()).c("enderPearl"));
		register(369, "blaze_rod", (new Item()).c("blazeRod").a(CreativeTab.MATERIALS).n());
		register(370, "ghast_tear", (new Item()).c("ghastTear").a(CreativeTab.BREWING));
		register(371, "gold_nugget", (new Item()).c("goldNugget").a(CreativeTab.MATERIALS));
		register(372, "nether_wart", (new ItemSeeds(Blocks.NETHER_WART, Blocks.SOUL_SAND)).c("netherStalkSeeds"));
		register(373, "potion", (new ItemPotion()).c("potion"));
		register(374, "glass_bottle", (new class_zk()).c("glassBottle"));
		register(375, "spider_eye", (new ItemBeetroot(2, 0.8F, false)).a(new class_pl(class_pm.s, 100, 0), 1.0F).c("spiderEye"));
		register(376, "fermented_spider_eye", (new Item()).c("fermentedSpiderEye").a(CreativeTab.BREWING));
		register(377, "blaze_powder", (new Item()).c("blazePowder").a(CreativeTab.BREWING));
		register(378, "magma_cream", (new Item()).c("magmaCream").a(CreativeTab.BREWING));
		register(379, "brewing_stand", (new class_zh(Blocks.BREWING_STAND)).c("brewingStand").a(CreativeTab.BREWING));
		register(380, "cauldron", (new class_zh(Blocks.CAULDRON)).c("cauldron").a(CreativeTab.BREWING));
		register(381, "ender_eye", (new class_aae()).c("eyeOfEnder"));
		register(382, "speckled_melon", (new Item()).c("speckledMelon").a(CreativeTab.BREWING));
		register(383, "spawn_egg", (new class_abt()).c("monsterPlacer"));
		register(384, "experience_bottle", (new class_aag()).c("expBottle"));
		register(385, "fire_charge", (new class_aah()).c("fireball"));
		register(386, "writable_book", (new class_acb()).c("writingBook").a(CreativeTab.MISC));
		register(387, "written_book", (new class_acc()).c("writtenBook").d(16));
		register(388, "emerald", (new Item()).c("emerald").a(CreativeTab.MATERIALS));
		register(389, "item_frame", (new class_aap(class_va.class)).c("frame"));
		register(390, "flower_pot", (new class_zh(Blocks.FLOWER_POT)).c("flowerPot").a(CreativeTab.DECORATIONS));
		register(391, "carrot", (new class_abj(3, 0.6F, Blocks.CARROTS, Blocks.FARMLAND)).c("carrots"));
		register(392, "potato", (new class_abj(1, 0.3F, Blocks.POTATOES, Blocks.FARMLAND)).c("potato"));
		register(393, "baked_potato", (new ItemBeetroot(5, 0.6F, false)).c("potatoBaked"));
		register(394, "poisonous_potato", (new ItemBeetroot(2, 0.3F, false)).a(new class_pl(class_pm.s, 100, 0), 0.6F).c("potatoPoisonous"));
		register(395, "map", (new ItemMapEmpty()).c("emptyMap"));
		register(396, "golden_carrot", (new ItemBeetroot(6, 1.2F, false)).c("carrotGolden").a(CreativeTab.BREWING));
		register(397, "skull", (new class_abp()).c("skull"));
		register(398, "carrot_on_a_stick", (new class_zo()).c("carrotOnAStick"));
		register(399, "nether_star", (new class_abo()).c("netherStar").a(CreativeTab.MATERIALS));
		register(400, "pumpkin_pie", (new ItemBeetroot(8, 0.3F, false)).c("pumpkinPie").a(CreativeTab.FOOD));
		register(401, "fireworks", (new class_aaj()).c("fireworks"));
		register(402, "firework_charge", (new class_aai()).c("fireworksCharge").a(CreativeTab.MISC));
		register(403, "enchanted_book", (new class_aad()).d(1).c("enchantedBook"));
		register(404, "comparator", (new class_zh(Blocks.UNPOWERED_COMPARATOR)).c("comparator").a(CreativeTab.REDSTONE));
		register(405, "netherbrick", (new Item()).c("netherbrick").a(CreativeTab.MATERIALS));
		register(406, "quartz", (new Item()).c("netherquartz").a(CreativeTab.MATERIALS));
		register(407, "tnt_minecart", (new class_aaz(class_vn.class_a_in_class_vn.d)).c("minecartTnt"));
		register(408, "hopper_minecart", (new class_aaz(class_vn.class_a_in_class_vn.f)).c("minecartHopper"));
		register(409, "prismarine_shard", (new Item()).c("prismarineShard").a(CreativeTab.MATERIALS));
		register(410, "prismarine_crystals", (new Item()).c("prismarineCrystals").a(CreativeTab.MATERIALS));
		register(411, "rabbit", (new ItemBeetroot(3, 0.3F, true)).c("rabbitRaw"));
		register(412, "cooked_rabbit", (new ItemBeetroot(5, 0.6F, true)).c("rabbitCooked"));
		register(413, "rabbit_stew", (new ItemBeetrootSoup(10)).c("rabbitStew"));
		register(414, "rabbit_foot", (new Item()).c("rabbitFoot").a(CreativeTab.BREWING));
		register(415, "rabbit_hide", (new Item()).c("rabbitHide").a(CreativeTab.MATERIALS));
		register(416, "armor_stand", (new ItemArmorStand()).c("armorStand").d(16));
		register(417, "iron_horse_armor", (new Item()).c("horsearmormetal").d(1).a(CreativeTab.MISC));
		register(418, "golden_horse_armor", (new Item()).c("horsearmorgold").d(1).a(CreativeTab.MISC));
		register(419, "diamond_horse_armor", (new Item()).c("horsearmordiamond").d(1).a(CreativeTab.MISC));
		register(420, "lead", (new class_aav()).c("leash"));
		register(421, "name_tag", (new class_abb()).c("nameTag"));
		register(422, "command_block_minecart", (new class_aaz(class_vn.class_a_in_class_vn.g)).c("minecartCommandBlock").a((CreativeTab) null));
		register(423, "mutton", (new ItemBeetroot(2, 0.3F, true)).c("muttonRaw"));
		register(424, "cooked_mutton", (new ItemBeetroot(6, 0.8F, true)).c("muttonCooked"));
		register(425, "banner", (new class_ze()).b("banner"));
		register(427, "spruce_door", (new class_zw(Blocks.SPRUCE_DOOR)).c("doorSpruce"));
		register(428, "birch_door", (new class_zw(Blocks.BIRCH_DOOR)).c("doorBirch"));
		register(429, "jungle_door", (new class_zw(Blocks.JUNGLE_DOOR)).c("doorJungle"));
		register(430, "acacia_door", (new class_zw(Blocks.ACACIA_DOOR)).c("doorAcacia"));
		register(431, "dark_oak_door", (new class_zw(Blocks.DARK_OAK_DOOR)).c("doorDarkOak"));
		//New items
		register(432, "chorus_fruit", (new ItemChorusFruit(4, 0.3F)).h().c("chorusFruit").a(CreativeTab.MATERIALS));
		register(433, "chorus_fruit_popped", (new Item()).c("chorusFruitPopped").a(CreativeTab.MATERIALS));
		register(434, "beetroot", (new ItemBeetroot(1, 0.6F, false)).c("beetroot"));
		register(435, "beetroot_seeds", (new ItemSeeds(Blocks.BEETROOTS, Blocks.FARMLAND)).c("beetroot_seeds"));
		register(436, "beetroot_soup", (new ItemBeetrootSoup(6)).c("beetroot_soup"));
		register(438, "splash_potion", (new ItemSplashPotion()).c("splash_potion"));
		register(439, "spectral_arrow", (new ItemSpectralArrow()).c("spectral_arrow"));
		register(440, "tipped_arrow", (new ItemTippedArrow()).c("tipped_arrow"));
		//End new items
		register(2256, "record_13", (new class_abg("13")).c("record"));
		register(2257, "record_cat", (new class_abg("cat")).c("record"));
		register(2258, "record_blocks", (new class_abg("blocks")).c("record"));
		register(2259, "record_chirp", (new class_abg("chirp")).c("record"));
		register(2260, "record_far", (new class_abg("far")).c("record"));
		register(2261, "record_mall", (new class_abg("mall")).c("record"));
		register(2262, "record_mellohi", (new class_abg("mellohi")).c("record"));
		register(2263, "record_stal", (new class_abg("stal")).c("record"));
		register(2264, "record_strad", (new class_abg("strad")).c("record"));
		register(2265, "record_ward", (new class_abg("ward")).c("record"));
		register(2266, "record_11", (new class_abg("11")).c("record"));
		register(2267, "record_wait", (new class_abg("wait")).c("record"));
	}

	private static void register(Block var0) {
		register(var0, new ItemBlock(var0));
	}

	protected static void register(Block var0, Item var1) {
		a(Block.getId(var0), Block.BLOCK_REGISTRY.getKey(var0), var1);
		BLOCK_TO_ITEM.put(var0, var1);
	}

	private static void register(int var0, String var1, Item var2) {
		a(var0, new MinecraftKey(var1), var2);
	}

	private static void a(int var0, MinecraftKey var1, Item var2) {
		ITEM_REGISTRY.register(var0, var1, var2);
	}

	public enum class_a_in_class_aar {
		a(0, 59, 2.0F, 0.0F, 15), b(1, 131, 4.0F, 1.0F, 5), c(2, 250, 6.0F, 2.0F, 14), d(3, 1561, 8.0F, 3.0F, 10), e(0, 32, 12.0F, 0.0F, 22);

		private final int f;
		private final int g;
		private final float h;
		private final float i;
		private final int j;

		class_a_in_class_aar(int var3, int var4, float var5, float var6, int var7) {
			this.f = var3;
			this.g = var4;
			this.h = var5;
			this.i = var6;
			this.j = var7;
		}

		public int a() {
			return this.g;
		}

		public float b() {
			return this.h;
		}

		public float c() {
			return this.i;
		}

		public int d() {
			return this.f;
		}

		public int e() {
			return this.j;
		}

		public Item f() {
			return this == a ? Item.getItemOf(Blocks.PLANKS) : (this == b ? Item.getItemOf(Blocks.COBBLESTONE) : (this == e ? Items.GOLD_INGOT : (this == c ? Items.IRON_INGOT : (this == d ? Items.DIAMOND : null))));
		}
	}
}
