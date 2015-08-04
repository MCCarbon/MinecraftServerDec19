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

	public final void registerItemKey(MinecraftKey var1, class_aat var2) {
		this.k.register(var1, var2);
	}

	public boolean registerItemKey(NBTTagCompound var1) {
		return false;
	}

	public Item() {
		this.registerItemKey(new MinecraftKey("lefthanded"), d);
	}

	public Item d(int var1) {
		this.h = var1;
		return this;
	}

	public UseResult registerItemKey(ItemStack var1, EntityHuman var2, World var3, BlockPosition var4, EnumUsedHand var5, EnumDirection var6, float var7, float var8, float var9) {
		return UseResult.CANT_USE;
	}

	public float registerItemKey(ItemStack var1, Block var2) {
		return 1.0F;
	}

	public class_or registerItemKey(ItemStack var1, World var2, EntityHuman var3, EnumUsedHand var4) {
		return new class_or(UseResult.CANT_USE, var1);
	}

	public ItemStack registerItemKey(ItemStack var1, World var2, EntityLiving var3) {
		return var1;
	}

	public int j() {
		return this.h;
	}

	public int registerItemKey(int var1) {
		return 0;
	}

	public boolean k() {
		return this.j;
	}

	protected Item registerItemKey(boolean var1) {
		this.j = var1;
		return this;
	}

	public int l() {
		return this.m;
	}

	protected Item e(int var1) {
		this.m = var1;
		if (var1 > 0) {
			this.registerItemKey(new MinecraftKey("damaged"), b);
			this.registerItemKey(new MinecraftKey("damage"), c);
		}

		return this;
	}

	public boolean m() {
		return this.m > 0 && !this.j;
	}

	public boolean registerItemKey(ItemStack var1, EntityLiving var2, EntityLiving var3) {
		return false;
	}

	public boolean registerItemKey(ItemStack var1, World var2, Block var3, BlockPosition var4, EntityLiving var5) {
		return false;
	}

	public boolean b(Block var1) {
		return false;
	}

	public boolean registerItemKey(ItemStack var1, EntityHuman var2, EntityLiving var3, EnumUsedHand var4) {
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

	public String registerItemKey() {
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

	public void registerItemKey(ItemStack var1, World var2, Entity var3, int var4, boolean var5) {
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

	public void registerItemKey(ItemStack var1, World var2, EntityLiving var3, int var4) {
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

	protected MovingObjectPosition registerItemKey(World var1, EntityHuman var2, boolean var3) {
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

	public Item registerItemKey(CreativeTab var1) {
		return this;
	}

	public boolean s() {
		return false;
	}

	public boolean registerItemKey(ItemStack var1, ItemStack var2) {
		return false;
	}

	public Multimap<?, ?> registerItemKey(EnumWearable var1) {
		return HashMultimap.create();
	}

	public static void init() {
		registerItemBlock(Blocks.STONE, (new ItemMultiTexture(Blocks.STONE, Blocks.STONE, new Function<Object, Object>() {
            public String a(ItemStack var1) {
                return BlockStone.EnumStoneVariant.getByData(var1.i()).getILocaleName();
            }

            // $FF: synthetic method
            public Object apply(Object var1) {
                return this.a((ItemStack) var1);
            }
        })).b("stone"));
		registerItemBlock(Blocks.GRASS, new ItemWithAuxData(Blocks.GRASS, false));
		registerItemBlock(Blocks.DIRT, (new ItemMultiTexture(Blocks.DIRT, Blocks.DIRT, new Function<Object, Object>() {
            public String a(ItemStack var1) {
                return BlockDirt.EnumDirtVariant.getById(var1.i()).c();
            }

            // $FF: synthetic method
            public Object apply(Object var1) {
                return this.a((ItemStack) var1);
            }
        })).b("dirt"));
		registerItemBlock(Blocks.COBBLESTONE);
		registerItemBlock(Blocks.PLANKS, (new ItemMultiTexture(Blocks.PLANKS, Blocks.PLANKS, new Function<Object, Object>() {
            public String a(ItemStack var1) {
                return BlockWood.EnumLogVariant.getById(var1.i()).d();
            }

            // $FF: synthetic method
            public Object apply(Object var1) {
                return this.a((ItemStack) var1);
            }
        })).b("wood"));
		registerItemBlock(Blocks.SAPLING, (new ItemMultiTexture(Blocks.SAPLING, Blocks.SAPLING, new Function<Object, Object>() {
            public String a(ItemStack var1) {
                return BlockWood.EnumLogVariant.getById(var1.i()).d();
            }

            // $FF: synthetic method
            public Object apply(Object var1) {
                return this.a((ItemStack) var1);
            }
        })).b("sapling"));
		registerItemBlock(Blocks.BEDROCK);
		registerItemBlock(Blocks.SAND, (new ItemMultiTexture(Blocks.SAND, Blocks.SAND, new Function<Object, Object>() {
            public String a(ItemStack var1) {
                return BlockSand.EnumSandVariant.getById(var1.i()).d();
            }

            // $FF: synthetic method
            public Object apply(Object var1) {
                return this.a((ItemStack) var1);
            }
        })).b("sand"));
		registerItemBlock(Blocks.GRAVEL);
		registerItemBlock(Blocks.GOLD_ORE);
		registerItemBlock(Blocks.IRON_ORE);
		registerItemBlock(Blocks.COAL_ORE);
		registerItemBlock(Blocks.LOG, (new ItemMultiTexture(Blocks.LOG, Blocks.LOG, new Function<Object, Object>() {
            public String a(ItemStack var1) {
                return BlockWood.EnumLogVariant.getById(var1.i()).d();
            }

            // $FF: synthetic method
            public Object apply(Object var1) {
                return this.a((ItemStack) var1);
            }
        })).b("log"));
		registerItemBlock(Blocks.LOG2, (new ItemMultiTexture(Blocks.LOG2, Blocks.LOG2, new Function<Object, Object>() {
            public String a(ItemStack var1) {
                return BlockWood.EnumLogVariant.getById(var1.i() + 4).d();
            }

            // $FF: synthetic method
            public Object apply(Object var1) {
                return this.a((ItemStack) var1);
            }
        })).b("log"));
		registerItemBlock(Blocks.LEAVES, (new ItemLeaves(Blocks.LEAVES)).b("leaves"));
		registerItemBlock(Blocks.LEAVES2, (new ItemLeaves(Blocks.LEAVES2)).b("leaves"));
		registerItemBlock(Blocks.SPONGE, (new ItemMultiTexture(Blocks.SPONGE, Blocks.SPONGE, new Function<Object, Object>() {
            public String a(ItemStack var1) {
                return (var1.i() & 1) == 1 ? "wet" : "dry";
            }

            // $FF: synthetic method
            public Object apply(Object var1) {
                return this.a((ItemStack) var1);
            }
        })).b("sponge"));
		registerItemBlock(Blocks.GLASS);
		registerItemBlock(Blocks.LAPIS_ORE);
		registerItemBlock(Blocks.LAPIS_BLOCK);
		registerItemBlock(Blocks.DISPENSER);
		registerItemBlock(Blocks.SANDSTONE, (new ItemMultiTexture(Blocks.SANDSTONE, Blocks.SANDSTONE, new Function<Object, Object>() {
            public String a(ItemStack var1) {
                return BlockSandStone.EnumSandstoneVariant.getById(var1.i()).c();
            }

            // $FF: synthetic method
            public Object apply(Object var1) {
                return this.a((ItemStack) var1);
            }
        })).b("sandStone"));
		registerItemBlock(Blocks.NOTEBLOCK);
		registerItemBlock(Blocks.GOLDEN_RAIL);
		registerItemBlock(Blocks.DETECTOR_RAIL);
		registerItemBlock(Blocks.STICKY_PISTON, new class_abd(Blocks.STICKY_PISTON));
		registerItemBlock(Blocks.WEB);
		registerItemBlock(Blocks.TALLGRASS, (new ItemWithAuxData(Blocks.TALLGRASS, true)).a(new String[]{"shrub", "grass", "fern"}));
		registerItemBlock(Blocks.DEADBUSH);
		registerItemBlock(Blocks.PISTON, new class_abd(Blocks.PISTON));
		registerItemBlock(Blocks.WOOL, (new class_aaa(Blocks.WOOL)).b("cloth"));
		registerItemBlock(Blocks.YELLOW_FLOWER, (new ItemMultiTexture(Blocks.YELLOW_FLOWER, Blocks.YELLOW_FLOWER, new Function<Object, Object>() {
            public String a(ItemStack var1) {
                return BlockFlowers.EnumFlowerVarient.getById(BlockFlowers.EnumFlowerType.YELLOW, var1.i()).d();
            }

            // $FF: synthetic method
            public Object apply(Object var1) {
                return this.a((ItemStack) var1);
            }
        })).b("flower"));
		registerItemBlock(Blocks.RED_FLOWER, (new ItemMultiTexture(Blocks.RED_FLOWER, Blocks.RED_FLOWER, new Function<Object, Object>() {
            public String a(ItemStack var1) {
                return BlockFlowers.EnumFlowerVarient.getById(BlockFlowers.EnumFlowerType.RED, var1.i()).d();
            }

            // $FF: synthetic method
            public Object apply(Object var1) {
                return this.a((ItemStack) var1);
            }
        })).b("rose"));
		registerItemBlock(Blocks.BROWN_MUSHROOM);
		registerItemBlock(Blocks.RED_MUSHROOM);
		registerItemBlock(Blocks.GOLD_BLOCK);
		registerItemBlock(Blocks.IRON_BLOCK);
		registerItemBlock(Blocks.STONE_SLAB, (new ItemStep(Blocks.STONE_SLAB, Blocks.STONE_SLAB, Blocks.DOUBLE_SANDSTONE_SLAB)).b("stoneSlab"));
		registerItemBlock(Blocks.BRICK_BLOCK);
		registerItemBlock(Blocks.TNT);
		registerItemBlock(Blocks.BOOKSHELF);
		registerItemBlock(Blocks.MOSSY_COBBLESTONE);
		registerItemBlock(Blocks.OBSIDIAN);
		registerItemBlock(Blocks.TORCH);
		//New stuff
		registerItemBlock(Blocks.END_ROD);
		registerItemBlock(Blocks.CHORUS_PLANT);
		registerItemBlock(Blocks.CHORUS_FLOWER);
		registerItemBlock(Blocks.PURPUR_BLOCK);
		registerItemBlock(Blocks.PURPUR_PILLAR);
		registerItemBlock(Blocks.PURPUR_STAIRS);
		registerItemBlock(Blocks.PURPUR_SLAB, (new ItemStep(Blocks.PURPUR_SLAB, Blocks.PURPUR_SLAB, Blocks.PURPUR_DOUBLE_SLAB)).b("purpurSlab"));
        //New stuff
		registerItemBlock(Blocks.MOB_SPAWNER);
		registerItemBlock(Blocks.OAK_STAIRS);
		registerItemBlock(Blocks.CHEST);
		registerItemBlock(Blocks.DIAMOND_ORE);
		registerItemBlock(Blocks.DIAMOND_BLOCK);
		registerItemBlock(Blocks.CRAFTING_TABLE);
		registerItemBlock(Blocks.FARMLAND);
		registerItemBlock(Blocks.FURNACE);
		registerItemBlock(Blocks.LIT_FURNACE);
		registerItemBlock(Blocks.LADDER);
		registerItemBlock(Blocks.RAIL);
		registerItemBlock(Blocks.STONE_STAIRS);
		registerItemBlock(Blocks.LEVER);
		registerItemBlock(Blocks.STONE_PRESSURE_PLATE);
		registerItemBlock(Blocks.WOODEN_PRESSURE_PLATE);
		registerItemBlock(Blocks.REDSTONE_ORE);
		registerItemBlock(Blocks.REDSTONE_TORCH);
		registerItemBlock(Blocks.STONE_BUTTON);
		registerItemBlock(Blocks.SNOW_LAYER, new ItemSnow(Blocks.SNOW_LAYER));
		registerItemBlock(Blocks.ICE);
		registerItemBlock(Blocks.SNOW);
		registerItemBlock(Blocks.CACTUS);
		registerItemBlock(Blocks.CLAY);
		registerItemBlock(Blocks.JUKEBOX);
		registerItemBlock(Blocks.FENCE);
		registerItemBlock(Blocks.SPRUCE_FENCE);
		registerItemBlock(Blocks.BIRCH_FENCE);
		registerItemBlock(Blocks.JUNGLE_FENCE);
		registerItemBlock(Blocks.DARK_OAK_FENCE);
		registerItemBlock(Blocks.ACACIA_FENCE);
		registerItemBlock(Blocks.PUMPKIN);
		registerItemBlock(Blocks.NETHERRACK);
		registerItemBlock(Blocks.SOUL_SAND);
		registerItemBlock(Blocks.GLOWSTONE);
		registerItemBlock(Blocks.LIT_PUMPKIN);
		registerItemBlock(Blocks.TRAPDOOR);
		registerItemBlock(Blocks.MONSTER_EGG, (new ItemMultiTexture(Blocks.MONSTER_EGG, Blocks.MONSTER_EGG, new Function<Object, Object>() {
            public String a(ItemStack var1) {
                return BlockMonsterEggs.EnumMonsterEggVariant.a(var1.i()).c();
            }

            // $FF: synthetic method
            public Object apply(Object var1) {
                return this.a((ItemStack) var1);
            }
        })).b("monsterStoneEgg"));
		registerItemBlock(Blocks.STONEBRICK, (new ItemMultiTexture(Blocks.STONEBRICK, Blocks.STONEBRICK, new Function<Object, Object>() {
            public String a(ItemStack var1) {
                return BlockSmoothBrick.EnumSmoothBrickType.a(var1.i()).c();
            }

            // $FF: synthetic method
            public Object apply(Object var1) {
                return this.a((ItemStack) var1);
            }
        })).b("stonebricksmooth"));
		registerItemBlock(Blocks.BROWN_MUSHROOM_BLOCK);
		registerItemBlock(Blocks.RED_MUSHROOM_BLOCK);
		registerItemBlock(Blocks.IRON_BARS);
		registerItemBlock(Blocks.GLASS_PANE);
		registerItemBlock(Blocks.MELON_BLOCK);
		registerItemBlock(Blocks.VINE, new ItemWithAuxData(Blocks.VINE, false));
		registerItemBlock(Blocks.FENCE_GATE);
		registerItemBlock(Blocks.SPRUCE_FENCE_GATE);
		registerItemBlock(Blocks.BIRCH_FENCE_GATE);
		registerItemBlock(Blocks.JUGLE_FENCE_GATE);
		registerItemBlock(Blocks.DARK_OAK_FENCE_GATE);
		registerItemBlock(Blocks.ACACIA_FENCE_GATE);
		registerItemBlock(Blocks.BRICK_STAIRS);
		registerItemBlock(Blocks.STONE_BRICK_STAIRS);
		registerItemBlock(Blocks.MYCELIM);
		registerItemBlock(Blocks.WATERLILY, new ItemWaterLily(Blocks.WATERLILY));
		registerItemBlock(Blocks.NETHER_BRICK);
		registerItemBlock(Blocks.NETHER_BRICK_FENCE);
		registerItemBlock(Blocks.NETHER_BTICK_STAIRS);
		registerItemBlock(Blocks.ENCHANTING_TABLE);
		registerItemBlock(Blocks.END_PORTAL_FRAME);
		registerItemBlock(Blocks.END_STONE);
		registerItemBlock(Blocks.END_BRICKS);
		registerItemBlock(Blocks.DRAGON_EGG);
		registerItemBlock(Blocks.REDSTONE_LAMP);
		registerItemBlock(Blocks.WOODEN_SLAB, (new ItemStep(Blocks.WOODEN_SLAB, Blocks.WOODEN_SLAB, Blocks.DOUBLE_WOODEN_SLAB)).b("woodSlab"));
		registerItemBlock(Blocks.SANDSTONE_STAIRS);
		registerItemBlock(Blocks.EMERALD_ORE);
		registerItemBlock(Blocks.ENDER_CHEST);
		registerItemBlock(Blocks.TRIPWIRE_HOOK);
		registerItemBlock(Blocks.EMERALD_BLOCK);
		registerItemBlock(Blocks.SPRUCE_STAIRS);
		registerItemBlock(Blocks.BIRCH_STAIRS);
		registerItemBlock(Blocks.JUNGKE_STAIRS);
		registerItemBlock(Blocks.COMMAND_BLOCK);
		registerItemBlock(Blocks.BEACON);
		registerItemBlock(Blocks.COBBLESTONE_WALL, (new ItemMultiTexture(Blocks.COBBLESTONE_WALL, Blocks.COBBLESTONE_WALL, new Function<Object, Object>() {
            public String a(ItemStack var1) {
                return BlockCobbleWall.class_a_in_class_alv.a(var1.i()).c();
            }

            // $FF: synthetic method
            public Object apply(Object var1) {
                return this.a((ItemStack) var1);
            }
        })).b("cobbleWall"));
		registerItemBlock(Blocks.WOODEN_BUTTON);
		registerItemBlock(Blocks.ANVIL, (new class_yz(Blocks.ANVIL)).b("anvil"));
		registerItemBlock(Blocks.TRAPPED_CHEST);
		registerItemBlock(Blocks.LIGHT_W_PRESSURE_PLATE);
		registerItemBlock(Blocks.HEAVY_W_PRESSURE_PLATE);
		registerItemBlock(Blocks.DAYLIGHT_DETECTOR);
		registerItemBlock(Blocks.REDSTONE_BLOCK);
		registerItemBlock(Blocks.QUARTZ_ORE);
		registerItemBlock(Blocks.HOPPER);
		registerItemBlock(Blocks.QUARTZ_BLOCK, (new ItemMultiTexture(Blocks.QUARTZ_BLOCK, Blocks.QUARTZ_BLOCK, new String[]{"default", "chiseled", "lines"})).b("quartzBlock"));
		registerItemBlock(Blocks.QUARTZ_STAIRS);
		registerItemBlock(Blocks.ACTIVATOR_RAIL);
		registerItemBlock(Blocks.DROPPER);
		registerItemBlock(Blocks.STAINED_HARDENED_CLAY, (new class_aaa(Blocks.STAINED_HARDENED_CLAY)).b("clayHardenedStained"));
		registerItemBlock(Blocks.BARRIER);
		registerItemBlock(Blocks.IRON_TRAPDOOR);
		registerItemBlock(Blocks.HAY_BLOCK);
		registerItemBlock(Blocks.CARPET, (new class_aaa(Blocks.CARPET)).b("woolCarpet"));
		registerItemBlock(Blocks.HARDENED_CLAY);
		registerItemBlock(Blocks.COAL_BLOCK);
		registerItemBlock(Blocks.PACKED_ICE);
		registerItemBlock(Blocks.ACACIA_STAIRS);
		registerItemBlock(Blocks.DARK_OAK_STAIRS);
		registerItemBlock(Blocks.SLINE);
		registerItemBlock(Blocks.GRASS_PATH);
		registerItemBlock(Blocks.DOUBLE_PLANT, (new class_zx(Blocks.DOUBLE_PLANT, Blocks.DOUBLE_PLANT, new Function<Object, Object>() {
            public String a(ItemStack var1) {
                return BlockTallPlant.class_b_in_class_ahm.a(var1.i()).c();
            }

            // $FF: synthetic method
            public Object apply(Object var1) {
                return this.a((ItemStack) var1);
            }
        })).b("doublePlant"));
		registerItemBlock(Blocks.STAINED_GLASS, (new class_aaa(Blocks.STAINED_GLASS)).b("stainedGlass"));
		registerItemBlock(Blocks.STAINED_GLASS_PANE, (new class_aaa(Blocks.STAINED_GLASS_PANE)).b("stainedGlassPane"));
		registerItemBlock(Blocks.PRISMARINE, (new ItemMultiTexture(Blocks.PRISMARINE, Blocks.PRISMARINE, new Function<Object, Object>() {
            public String a(ItemStack var1) {
                return BlockPrismarine.class_a_in_class_akc.a(var1.i()).c();
            }

            // $FF: synthetic method
            public Object apply(Object var1) {
                return this.a((ItemStack) var1);
            }
        })).b("prismarine"));
		registerItemBlock(Blocks.SEA_LANTERN);
		registerItemBlock(Blocks.RED_SANDSTONE, (new ItemMultiTexture(Blocks.RED_SANDSTONE, Blocks.RED_SANDSTONE, new Function<Object, Object>() {
            public String a(ItemStack var1) {
                return BlockRedSandstone.class_a_in_class_aki.a(var1.i()).c();
            }

            // $FF: synthetic method
            public Object apply(Object var1) {
                return this.a((ItemStack) var1);
            }
        })).b("redSandStone"));
		registerItemBlock(Blocks.RED_SANDSTONE_STAIRS);
		registerItemBlock(Blocks.STONE_SLAB2, (new ItemStep(Blocks.STONE_SLAB2, Blocks.STONE_SLAB2, Blocks.DOUBLE_STONE_SLAB2)).b("stoneSlab2"));
		registerItem(256, "iron_shovel", (new ItemSpade(EnumToolMaterial.IRON)).c("shovelIron"));
		registerItem(257, "iron_pickaxe", (new ItemPickaxe(EnumToolMaterial.IRON)).c("pickaxeIron"));
		registerItem(258, "iron_axe", (new ItemAxe(EnumToolMaterial.IRON)).c("hatchetIron"));
		registerItem(259, "flint_and_steel", (new class_aam()).c("flintAndSteel"));
		registerItem(260, "apple", (new ItemFood(4, 0.3F, false)).c("apple"));
		registerItem(261, "bow", (new ItemBow()).c("bow"));
		registerItem(262, "arrow", (new ItemArrow()).c("arrow"));
		registerItem(263, "coal", (new ItemCoal()).c("coal"));
		registerItem(264, "diamond", (new Item()).c("diamond").registerItemKey(CreativeTab.MATERIALS));
		registerItem(265, "iron_ingot", (new Item()).c("ingotIron").registerItemKey(CreativeTab.MATERIALS));
		registerItem(266, "gold_ingot", (new Item()).c("ingotGold").registerItemKey(CreativeTab.MATERIALS));
		registerItem(267, "iron_sword", (new ItemSword(EnumToolMaterial.IRON)).c("swordIron"));
		registerItem(268, "wooden_sword", (new ItemSword(EnumToolMaterial.WOOD)).c("swordWood"));
		registerItem(269, "wooden_shovel", (new ItemSpade(EnumToolMaterial.WOOD)).c("shovelWood"));
		registerItem(270, "wooden_pickaxe", (new ItemPickaxe(EnumToolMaterial.WOOD)).c("pickaxeWood"));
		registerItem(271, "wooden_axe", (new ItemAxe(EnumToolMaterial.WOOD)).c("hatchetWood"));
		registerItem(272, "stone_sword", (new ItemSword(EnumToolMaterial.STONE)).c("swordStone"));
		registerItem(273, "stone_shovel", (new ItemSpade(EnumToolMaterial.STONE)).c("shovelStone"));
		registerItem(274, "stone_pickaxe", (new ItemPickaxe(EnumToolMaterial.STONE)).c("pickaxeStone"));
		registerItem(275, "stone_axe", (new ItemAxe(EnumToolMaterial.STONE)).c("hatchetStone"));
		registerItem(276, "diamond_sword", (new ItemSword(EnumToolMaterial.EMERALD)).c("swordDiamond"));
		registerItem(277, "diamond_shovel", (new ItemSpade(EnumToolMaterial.EMERALD)).c("shovelDiamond"));
		registerItem(278, "diamond_pickaxe", (new ItemPickaxe(EnumToolMaterial.EMERALD)).c("pickaxeDiamond"));
		registerItem(279, "diamond_axe", (new ItemAxe(EnumToolMaterial.EMERALD)).c("hatchetDiamond"));
		registerItem(280, "stick", (new Item()).n().c("stick").registerItemKey(CreativeTab.MATERIALS));
		registerItem(281, "bowl", (new Item()).c("bowl").registerItemKey(CreativeTab.MATERIALS));
		registerItem(282, "mushroom_stew", (new ItemSoup(6)).c("mushroomStew"));
		registerItem(283, "golden_sword", (new ItemSword(EnumToolMaterial.GOLD)).c("swordGold"));
		registerItem(284, "golden_shovel", (new ItemSpade(EnumToolMaterial.GOLD)).c("shovelGold"));
		registerItem(285, "golden_pickaxe", (new ItemPickaxe(EnumToolMaterial.GOLD)).c("pickaxeGold"));
		registerItem(286, "golden_axe", (new ItemAxe(EnumToolMaterial.GOLD)).c("hatchetGold"));
		registerItem(287, "string", (new ItemReed(Blocks.TRIPWIRE)).c("string").registerItemKey(CreativeTab.MATERIALS));
		registerItem(288, "feather", (new Item()).c("feather").registerItemKey(CreativeTab.MATERIALS));
		registerItem(289, "gunpowder", (new Item()).c("sulphur").registerItemKey(CreativeTab.MATERIALS));
		registerItem(290, "wooden_hoe", (new ItemHoe(EnumToolMaterial.WOOD)).c("hoeWood"));
		registerItem(291, "stone_hoe", (new ItemHoe(EnumToolMaterial.STONE)).c("hoeStone"));
		registerItem(292, "iron_hoe", (new ItemHoe(EnumToolMaterial.IRON)).c("hoeIron"));
		registerItem(293, "diamond_hoe", (new ItemHoe(EnumToolMaterial.EMERALD)).c("hoeDiamond"));
		registerItem(294, "golden_hoe", (new ItemHoe(EnumToolMaterial.GOLD)).c("hoeGold"));
		registerItem(295, "wheat_seeds", (new ItemSeeds(Blocks.WHEAT, Blocks.FARMLAND)).c("seeds"));
		registerItem(296, "wheat", (new Item()).c("wheat").registerItemKey(CreativeTab.MATERIALS));
		registerItem(297, "bread", (new ItemFood(5, 0.6F, false)).c("bread"));
		registerItem(298, "leather_helmet", (new ItemArmor(ItemArmor.EnumArmorMaterial.LEATHER, 0, EnumWearable.HEAD)).c("helmetCloth"));
		registerItem(299, "leather_chestplate", (new ItemArmor(ItemArmor.EnumArmorMaterial.LEATHER, 0, EnumWearable.TORSO)).c("chestplateCloth"));
		registerItem(300, "leather_leggings", (new ItemArmor(ItemArmor.EnumArmorMaterial.LEATHER, 0, EnumWearable.LEGS)).c("leggingsCloth"));
		registerItem(301, "leather_boots", (new ItemArmor(ItemArmor.EnumArmorMaterial.LEATHER, 0, EnumWearable.FEET)).c("bootsCloth"));
		registerItem(302, "chainmail_helmet", (new ItemArmor(ItemArmor.EnumArmorMaterial.CHAIN, 1, EnumWearable.HEAD)).c("helmetChain"));
		registerItem(303, "chainmail_chestplate", (new ItemArmor(ItemArmor.EnumArmorMaterial.CHAIN, 1, EnumWearable.TORSO)).c("chestplateChain"));
		registerItem(304, "chainmail_leggings", (new ItemArmor(ItemArmor.EnumArmorMaterial.CHAIN, 1, EnumWearable.LEGS)).c("leggingsChain"));
		registerItem(305, "chainmail_boots", (new ItemArmor(ItemArmor.EnumArmorMaterial.CHAIN, 1, EnumWearable.FEET)).c("bootsChain"));
		registerItem(306, "iron_helmet", (new ItemArmor(ItemArmor.EnumArmorMaterial.IRON, 2, EnumWearable.HEAD)).c("helmetIron"));
		registerItem(307, "iron_chestplate", (new ItemArmor(ItemArmor.EnumArmorMaterial.IRON, 2, EnumWearable.TORSO)).c("chestplateIron"));
		registerItem(308, "iron_leggings", (new ItemArmor(ItemArmor.EnumArmorMaterial.IRON, 2, EnumWearable.LEGS)).c("leggingsIron"));
		registerItem(309, "iron_boots", (new ItemArmor(ItemArmor.EnumArmorMaterial.IRON, 2, EnumWearable.FEET)).c("bootsIron"));
		registerItem(310, "diamond_helmet", (new ItemArmor(ItemArmor.EnumArmorMaterial.DIAMOND, 3, EnumWearable.HEAD)).c("helmetDiamond"));
		registerItem(311, "diamond_chestplate", (new ItemArmor(ItemArmor.EnumArmorMaterial.DIAMOND, 3, EnumWearable.TORSO)).c("chestplateDiamond"));
		registerItem(312, "diamond_leggings", (new ItemArmor(ItemArmor.EnumArmorMaterial.DIAMOND, 3, EnumWearable.LEGS)).c("leggingsDiamond"));
		registerItem(313, "diamond_boots", (new ItemArmor(ItemArmor.EnumArmorMaterial.DIAMOND, 3, EnumWearable.FEET)).c("bootsDiamond"));
		registerItem(314, "golden_helmet", (new ItemArmor(ItemArmor.EnumArmorMaterial.GOLD, 4, EnumWearable.HEAD)).c("helmetGold"));
		registerItem(315, "golden_chestplate", (new ItemArmor(ItemArmor.EnumArmorMaterial.GOLD, 4, EnumWearable.TORSO)).c("chestplateGold"));
		registerItem(316, "golden_leggings", (new ItemArmor(ItemArmor.EnumArmorMaterial.GOLD, 4, EnumWearable.LEGS)).c("leggingsGold"));
		registerItem(317, "golden_boots", (new ItemArmor(ItemArmor.EnumArmorMaterial.GOLD, 4, EnumWearable.FEET)).c("bootsGold"));
		registerItem(318, "flint", (new Item()).c("flint").registerItemKey(CreativeTab.MATERIALS));
		registerItem(319, "porkchop", (new ItemFood(3, 0.3F, true)).c("porkchopRaw"));
		registerItem(320, "cooked_porkchop", (new ItemFood(8, 0.8F, true)).c("porkchopCooked"));
		registerItem(321, "painting", (new EntityHanging(EntityPainting.class)).c("painting"));
		registerItem(322, "golden_apple", (new ItemGoldenApple(4, 1.2F, false)).h().a(new MobEffect(MobEffectList.j, 100, 1), 1.0F).c("appleGold"));
		registerItem(323, "sign", (new ItemSign()).c("sign"));
		registerItem(324, "wooden_door", (new ItemDoor(Blocks.WOODEN_DOOR)).c("doorOak"));
		Item bucket = (new ItemBucket(Blocks.AIR)).c("bucket").d(16);
		registerItem(325, "bucket", bucket);
		registerItem(326, "water_bucket", (new ItemBucket(Blocks.FLOWING_WATER)).c("bucketWater").c(bucket));
		registerItem(327, "lava_bucket", (new ItemBucket(Blocks.FLOWING_LAVA)).c("bucketLava").c(bucket));
		registerItem(328, "minecart", (new ItemMinecart(EntityMinecartAbstract.EnumMinecartType.RIDEABLE)).c("minecart"));
		registerItem(329, "saddle", (new ItemSaddle()).c("saddle"));
		registerItem(330, "iron_door", (new ItemDoor(Blocks.IRON_DOOR)).c("doorIron"));
		registerItem(331, "redstone", (new ItemRedstone()).c("redstone"));
		registerItem(332, "snowball", (new ItemSnowball()).c("snowball"));
		registerItem(333, "boat", (new ItemBoat()).c("boat"));
		registerItem(334, "leather", (new Item()).c("leather").registerItemKey(CreativeTab.MATERIALS));
		registerItem(335, "milk_bucket", (new ItemMilkBucket()).c("milk").c(bucket));
		registerItem(336, "brick", (new Item()).c("brick").registerItemKey(CreativeTab.MATERIALS));
		registerItem(337, "clay_ball", (new Item()).c("clay").registerItemKey(CreativeTab.MATERIALS));
		registerItem(338, "reeds", (new ItemReed(Blocks.REEDS)).c("reeds").registerItemKey(CreativeTab.MATERIALS));
		registerItem(339, "paper", (new Item()).c("paper").registerItemKey(CreativeTab.MISC));
		registerItem(340, "book", (new ItemBook()).c("book").registerItemKey(CreativeTab.MISC));
		registerItem(341, "slime_ball", (new Item()).c("slimeball").registerItemKey(CreativeTab.MISC));
		registerItem(342, "chest_minecart", (new ItemMinecart(EntityMinecartAbstract.EnumMinecartType.CHEST)).c("minecartChest"));
		registerItem(343, "furnace_minecart", (new ItemMinecart(EntityMinecartAbstract.EnumMinecartType.FURNACE)).c("minecartFurnace"));
		registerItem(344, "egg", (new ItemEgg()).c("egg"));
		registerItem(345, "compass", (new ItemCompass()).c("compass").registerItemKey(CreativeTab.TOOLS));
		registerItem(346, "fishing_rod", (new ItemFishingRod()).c("fishingRod"));
		registerItem(347, "clock", (new ItemClock()).c("clock").registerItemKey(CreativeTab.TOOLS));
		registerItem(348, "glowstone_dust", (new Item()).c("yellowDust").registerItemKey(CreativeTab.MATERIALS));
		registerItem(349, "fish", (new ItemFish(false)).c("fish").registerItemKey(true));
		registerItem(350, "cooked_fish", (new ItemFish(true)).c("fish").registerItemKey(true));
		registerItem(351, "dye", (new ItemDye()).c("dyePowder"));
		registerItem(352, "bone", (new Item()).c("bone").n().registerItemKey(CreativeTab.MISC));
		registerItem(353, "sugar", (new Item()).c("sugar").registerItemKey(CreativeTab.MATERIALS));
		registerItem(354, "cake", (new ItemReed(Blocks.CAKE)).d(1).c("cake").registerItemKey(CreativeTab.FOOD));
		registerItem(355, "bed", (new ItemBed()).d(1).c("bed"));
		registerItem(356, "repeater", (new ItemReed(Blocks.UNPOWERED_REPEATER)).c("diode").registerItemKey(CreativeTab.REDSTONE));
		registerItem(357, "cookie", (new ItemFood(2, 0.1F, false)).c("cookie"));
		registerItem(358, "filled_map", (new ItemWorldMap()).c("map"));
		registerItem(359, "shears", (new ItemShears()).c("shears"));
		registerItem(360, "melon", (new ItemFood(2, 0.3F, false)).c("melon"));
		registerItem(361, "pumpkin_seeds", (new ItemSeeds(Blocks.PUMPKIN_STEM, Blocks.FARMLAND)).c("seeds_pumpkin"));
		registerItem(362, "melon_seeds", (new ItemSeeds(Blocks.MELON_STEM, Blocks.FARMLAND)).c("seeds_melon"));
		registerItem(363, "beef", (new ItemFood(3, 0.3F, true)).c("beefRaw"));
		registerItem(364, "cooked_beef", (new ItemFood(8, 0.8F, true)).c("beefCooked"));
		registerItem(365, "chicken", (new ItemFood(2, 0.3F, true)).a(new MobEffect(MobEffectList.q, 600, 0), 0.3F).c("chickenRaw"));
		registerItem(366, "cooked_chicken", (new ItemFood(6, 0.6F, true)).c("chickenCooked"));
		registerItem(367, "rotten_flesh", (new ItemFood(4, 0.1F, true)).a(new MobEffect(MobEffectList.q, 600, 0), 0.8F).c("rottenFlesh"));
		registerItem(368, "ender_pearl", (new ItemEnderPearl()).c("enderPearl"));
		registerItem(369, "blaze_rod", (new Item()).c("blazeRod").registerItemKey(CreativeTab.MATERIALS).n());
		registerItem(370, "ghast_tear", (new Item()).c("ghastTear").registerItemKey(CreativeTab.BREWING));
		registerItem(371, "gold_nugget", (new Item()).c("goldNugget").registerItemKey(CreativeTab.MATERIALS));
		registerItem(372, "nether_wart", (new ItemSeeds(Blocks.NETHER_WART, Blocks.SOUL_SAND)).c("netherStalkSeeds"));
		registerItem(373, "potion", (new ItemPotion()).c("potion"));
		registerItem(374, "glass_bottle", (new ItemGlassBottle()).c("glassBottle"));
		registerItem(375, "spider_eye", (new ItemFood(2, 0.8F, false)).a(new MobEffect(MobEffectList.s, 100, 0), 1.0F).c("spiderEye"));
		registerItem(376, "fermented_spider_eye", (new Item()).c("fermentedSpiderEye").registerItemKey(CreativeTab.BREWING));
		registerItem(377, "blaze_powder", (new Item()).c("blazePowder").registerItemKey(CreativeTab.BREWING));
		registerItem(378, "magma_cream", (new Item()).c("magmaCream").registerItemKey(CreativeTab.BREWING));
		registerItem(379, "brewing_stand", (new ItemReed(Blocks.BREWING_STAND)).c("brewingStand").registerItemKey(CreativeTab.BREWING));
		registerItem(380, "cauldron", (new ItemReed(Blocks.CAULDRON)).c("cauldron").registerItemKey(CreativeTab.BREWING));
		registerItem(381, "ender_eye", (new ItemEnderEye()).c("eyeOfEnder"));
		registerItem(382, "speckled_melon", (new Item()).c("speckledMelon").registerItemKey(CreativeTab.BREWING));
		registerItem(383, "spawn_egg", (new ItemMonsterEgg()).c("monsterPlacer"));
		registerItem(384, "experience_bottle", (new ItemExpBottle()).c("expBottle"));
		registerItem(385, "fire_charge", (new ItemFireball()).c("fireball"));
		registerItem(386, "writable_book", (new ItemBookAndQuill()).c("writingBook").registerItemKey(CreativeTab.MISC));
		registerItem(387, "written_book", (new ItemWrittenBook()).c("writtenBook").d(16));
		registerItem(388, "emerald", (new Item()).c("emerald").registerItemKey(CreativeTab.MATERIALS));
		registerItem(389, "item_frame", (new EntityHanging(EntityItemFrame.class)).c("frame"));
		registerItem(390, "flower_pot", (new ItemReed(Blocks.FLOWER_POT)).c("flowerPot").registerItemKey(CreativeTab.DECORATIONS));
		registerItem(391, "carrot", (new ItemSeedFood(3, 0.6F, Blocks.CARROTS, Blocks.FARMLAND)).c("carrots"));
		registerItem(392, "potato", (new ItemSeedFood(1, 0.3F, Blocks.POTATOES, Blocks.FARMLAND)).c("potato"));
		registerItem(393, "baked_potato", (new ItemFood(5, 0.6F, false)).c("potatoBaked"));
		registerItem(394, "poisonous_potato", (new ItemFood(2, 0.3F, false)).a(new MobEffect(MobEffectList.s, 100, 0), 0.6F).c("potatoPoisonous"));
		registerItem(395, "map", (new ItemMapEmpty()).c("emptyMap"));
		registerItem(396, "golden_carrot", (new ItemFood(6, 1.2F, false)).c("carrotGolden").registerItemKey(CreativeTab.BREWING));
		registerItem(397, "skull", (new ItemSkull()).c("skull"));
		registerItem(398, "carrot_on_a_stick", (new ItemCarrotStick()).c("carrotOnAStick"));
		registerItem(399, "nether_star", (new ItemNetherStar()).c("netherStar").registerItemKey(CreativeTab.MATERIALS));
		registerItem(400, "pumpkin_pie", (new ItemFood(8, 0.3F, false)).c("pumpkinPie").registerItemKey(CreativeTab.FOOD));
		registerItem(401, "fireworks", (new ItemFireworks()).c("fireworks"));
		registerItem(402, "firework_charge", (new ItemFireworksCharge()).c("fireworksCharge").registerItemKey(CreativeTab.MISC));
		registerItem(403, "enchanted_book", (new ItemEnchantedBook()).d(1).c("enchantedBook"));
		registerItem(404, "comparator", (new ItemReed(Blocks.UNPOWERED_COMPARATOR)).c("comparator").registerItemKey(CreativeTab.REDSTONE));
		registerItem(405, "netherbrick", (new Item()).c("netherbrick").registerItemKey(CreativeTab.MATERIALS));
		registerItem(406, "quartz", (new Item()).c("netherquartz").registerItemKey(CreativeTab.MATERIALS));
		registerItem(407, "tnt_minecart", (new ItemMinecart(EntityMinecartAbstract.EnumMinecartType.TNT)).c("minecartTnt"));
		registerItem(408, "hopper_minecart", (new ItemMinecart(EntityMinecartAbstract.EnumMinecartType.HOPPER)).c("minecartHopper"));
		registerItem(409, "prismarine_shard", (new Item()).c("prismarineShard").registerItemKey(CreativeTab.MATERIALS));
		registerItem(410, "prismarine_crystals", (new Item()).c("prismarineCrystals").registerItemKey(CreativeTab.MATERIALS));
		registerItem(411, "rabbit", (new ItemFood(3, 0.3F, true)).c("rabbitRaw"));
		registerItem(412, "cooked_rabbit", (new ItemFood(5, 0.6F, true)).c("rabbitCooked"));
		registerItem(413, "rabbit_stew", (new ItemSoup(10)).c("rabbitStew"));
		registerItem(414, "rabbit_foot", (new Item()).c("rabbitFoot").registerItemKey(CreativeTab.BREWING));
		registerItem(415, "rabbit_hide", (new Item()).c("rabbitHide").registerItemKey(CreativeTab.MATERIALS));
		registerItem(416, "armor_stand", (new ItemArmorStand()).c("armorStand").d(16));
		registerItem(417, "iron_horse_armor", (new Item()).c("horsearmormetal").d(1).registerItemKey(CreativeTab.MISC));
		registerItem(418, "golden_horse_armor", (new Item()).c("horsearmorgold").d(1).registerItemKey(CreativeTab.MISC));
		registerItem(419, "diamond_horse_armor", (new Item()).c("horsearmordiamond").d(1).registerItemKey(CreativeTab.MISC));
		registerItem(420, "lead", (new ItemLeash()).c("leash"));
		registerItem(421, "name_tag", (new ItemNameTage()).c("nameTag"));
		registerItem(422, "command_block_minecart", (new ItemMinecart(EntityMinecartAbstract.EnumMinecartType.COMMAND_BLOCK)).c("minecartCommandBlock").registerItemKey((CreativeTab) null));
		registerItem(423, "mutton", (new ItemFood(2, 0.3F, true)).c("muttonRaw"));
		registerItem(424, "cooked_mutton", (new ItemFood(6, 0.8F, true)).c("muttonCooked"));
		registerItem(425, "banner", (new ItemBanner()).b("banner"));
		registerItem(427, "spruce_door", (new ItemDoor(Blocks.SPRUCE_DOOR)).c("doorSpruce"));
		registerItem(428, "birch_door", (new ItemDoor(Blocks.BIRCH_DOOR)).c("doorBirch"));
		registerItem(429, "jungle_door", (new ItemDoor(Blocks.JUNGLE_DOOR)).c("doorJungle"));
		registerItem(430, "acacia_door", (new ItemDoor(Blocks.ACACIA_DOOR)).c("doorAcacia"));
		registerItem(431, "dark_oak_door", (new ItemDoor(Blocks.DARK_OAK_DOOR)).c("doorDarkOak"));
		//New items
		registerItem(432, "chorus_fruit", (new ItemChorusFruit(4, 0.3F)).h().c("chorusFruit").registerItemKey(CreativeTab.MATERIALS));
		registerItem(433, "chorus_fruit_popped", (new Item()).c("chorusFruitPopped").registerItemKey(CreativeTab.MATERIALS));
		registerItem(434, "beetroot", (new ItemFood(1, 0.6F, false)).c("beetroot"));
		registerItem(435, "beetroot_seeds", (new ItemSeeds(Blocks.BEETROOTS, Blocks.FARMLAND)).c("beetroot_seeds"));
		registerItem(436, "beetroot_soup", (new ItemSoup(6)).c("beetroot_soup"));
		registerItem(438, "splash_potion", (new ItemSplashPotion()).c("splash_potion"));
		registerItem(439, "spectral_arrow", (new ItemSpectralArrow()).c("spectral_arrow"));
		registerItem(440, "tipped_arrow", (new ItemTippedArrow()).c("tipped_arrow"));
		//End new items
		registerItem(2256, "record_13", (new ItemRecord("13")).c("record"));
		registerItem(2257, "record_cat", (new ItemRecord("cat")).c("record"));
		registerItem(2258, "record_blocks", (new ItemRecord("blocks")).c("record"));
		registerItem(2259, "record_chirp", (new ItemRecord("chirp")).c("record"));
		registerItem(2260, "record_far", (new ItemRecord("far")).c("record"));
		registerItem(2261, "record_mall", (new ItemRecord("mall")).c("record"));
		registerItem(2262, "record_mellohi", (new ItemRecord("mellohi")).c("record"));
		registerItem(2263, "record_stal", (new ItemRecord("stal")).c("record"));
		registerItem(2264, "record_strad", (new ItemRecord("strad")).c("record"));
		registerItem(2265, "record_ward", (new ItemRecord("ward")).c("record"));
		registerItem(2266, "record_11", (new ItemRecord("11")).c("record"));
		registerItem(2267, "record_wait", (new ItemRecord("wait")).c("record"));
	}

	private static void registerItemBlock(Block var0) {
		registerItemBlock(var0, new ItemBlock(var0));
	}

	protected static void registerItemBlock(Block var0, Item var1) {
		registerItemKey(Block.getId(var0), Block.BLOCK_REGISTRY.getKey(var0), var1);
		BLOCK_TO_ITEM.put(var0, var1);
	}

	private static void registerItem(int var0, String var1, Item var2) {
		registerItemKey(var0, new MinecraftKey(var1), var2);
	}

	private static void registerItemKey(int var0, MinecraftKey var1, Item var2) {
		ITEM_REGISTRY.register(var0, var1, var2);
	}

	public enum EnumToolMaterial {
		WOOD(0, 59, 2.0F, 0.0F, 15), STONE(1, 131, 4.0F, 1.0F, 5), IRON(2, 250, 6.0F, 2.0F, 14), EMERALD(3, 1561, 8.0F, 3.0F, 10), GOLD(0, 32, 12.0F, 0.0F, 22);

		private final int f;
		private final int g;
		private final float h;
		private final float i;
		private final int j;

		EnumToolMaterial(int var3, int var4, float var5, float var6, int var7) {
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
			return this == WOOD ? Item.getItemOf(Blocks.PLANKS) : (this == STONE ? Item.getItemOf(Blocks.COBBLESTONE) : (this == GOLD ? Items.GOLD_INGOT : (this == IRON ? Items.IRON_INGOT : (this == EMERALD ? Items.DIAMOND : null))));
		}
	}
}
