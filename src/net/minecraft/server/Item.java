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
	private static final ItemState b = new ItemState() {
	};
	private static final ItemState c = new ItemState() {
	};
	private static final ItemState d = new ItemState() {
	};

	private final IRegistry<MinecraftKey, ItemState> stateRegistry = new RegistrySimple<MinecraftKey, ItemState>();
	protected static final UUID uuid = UUID.fromString("CB3F55D3-645C-4F38-A497-9C13A33DB5CF");
	protected static Random random = new Random();

	protected int maxStackSize = 64;
	private int durability;
	protected boolean usesData;
	private Item craftingResult;
	private String name;

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

	public final void registerItemState(MinecraftKey key, ItemState state) {
		this.stateRegistry.register(key, state);
	}

	public boolean updateNBT(NBTTagCompound var1) {
		return false;
	}

	public Item() {
		this.registerItemState(new MinecraftKey("lefthanded"), d);
	}

	public Item d(int var1) {
		this.maxStackSize = var1;
		return this;
	}

	public UseResult interactWith(ItemStack var1, EntityHuman var2, World var3, BlockPosition var4, EnumUsedHand var5, EnumDirection var6, float var7, float var8, float var9) {
		return UseResult.CANT_USE;
	}

	public float getDestroySpeed(ItemStack var1, Block var2) {
		return 1.0F;
	}

	public UseResultWithValue onUse(ItemStack itemstack, World world, EntityHuman player, EnumUsedHand hand) {
		return new UseResultWithValue(UseResult.CANT_USE, itemstack);
	}

	public ItemStack onUseFinish(ItemStack itemstack, World world, EntityLiving player) {
		return itemstack;
	}

	public int getMaxStackSize() {
		return this.maxStackSize;
	}

	public int filterData(int data) {
		return 0;
	}

	public boolean usesData() {
		return this.usesData;
	}

	protected Item setUsesData(boolean usesData) {
		this.usesData = usesData;
		return this;
	}

	public int getMaxDurability() {
		return this.durability;
	}

	protected Item setMaxDurability(int durability) {
		this.durability = durability;
		if (durability > 0) {
			this.registerItemState(new MinecraftKey("damaged"), b);
			this.registerItemState(new MinecraftKey("damage"), c);
		}

		return this;
	}

	public boolean usesDurability() {
		return this.durability > 0 && !this.usesData;
	}

	public boolean hitEntity(ItemStack itemstack, EntityLiving target, EntityLiving attacker) {
		return false;
	}

	public boolean onBlockDestroyed(ItemStack itemstack, World world, Block block, BlockPosition position, EntityLiving player) {
		return false;
	}

	public boolean canDestroySpecialBlock(Block block) {
		return false;
	}

	public boolean canUseOn(ItemStack itemstack, EntityHuman player, EntityLiving target, EnumUsedHand hand) {
		return false;
	}

	public Item setUnusedField() {
		return this;
	}

	public Item setName(String name) {
		this.name = name;
		return this;
	}

	public String getNameOrLocalized(ItemStack var1) {
		String var2 = this.getName(var1);
		return var2 == null ? "" : LocaleI18n.get(var2);
	}

	public String getName() {
		return "item." + this.name;
	}

	public String getName(ItemStack var1) {
		return "item." + this.name;
	}

	public Item setCraftingResult(Item var1) {
		this.craftingResult = var1;
		return this;
	}

	public boolean shouldSendNBT() {
		return true;
	}

	public Item getCraftingResult() {
		return this.craftingResult;
	}

	public boolean hasCraftingResult() {
		return this.craftingResult != null;
	}

	public void tick(ItemStack itemstack, World world, Entity entity, int var4, boolean var5) {
	}

	public void onCrafted(ItemStack itemstack, World world, EntityHuman player) {
	}

	public boolean isMap() {
		return false;
	}

	public EnumAnimation getAnimation(ItemStack itemstack) {
		return EnumAnimation.NONE;
	}

	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}

	public void onStopUse(ItemStack itemstack, World world, EntityLiving player, int untilComplete) {
	}

	public String getLocalizedName(ItemStack itemstack) {
		return ("" + LocaleI18n.get(this.getNameOrLocalized(itemstack) + ".name")).trim();
	}

	public EnumItemRarity getRarity(ItemStack var1) {
		return var1.hasEnchantments() ? EnumItemRarity.RARE : EnumItemRarity.COMMON;
	}

	public boolean isTool(ItemStack var1) {
		return this.getMaxStackSize() == 1 && this.usesDurability();
	}

	protected MovingObjectPosition getMovingObjectPositionFromPlayer(World world, EntityHuman player, boolean var3) {
		float var4 = player.pitch;
		float var5 = player.yaw;
		double var6 = player.locX;
		double var8 = player.locY + (double) player.getHeadHeight();
		double var10 = player.locZ;
		Vec3D var12 = new Vec3D(var6, var8, var10);
		float var13 = MathHelper.cos(-var5 * 0.017453292F - 3.1415927F);
		float var14 = MathHelper.sin(-var5 * 0.017453292F - 3.1415927F);
		float var15 = -MathHelper.cos(-var4 * 0.017453292F);
		float var16 = MathHelper.sin(-var4 * 0.017453292F);
		float var17 = var14 * var15;
		float var19 = var13 * var15;
		double var20 = 5.0D;
		Vec3D var22 = var12.add((double) var17 * var20, (double) var16 * var20, (double) var19 * var20);
		return world.rayTrace(var12, var22, var3, !var3, false);
	}

	public int getItemEnchantability() {
		return 0;
	}

	public Item setCreativeTab(CreativeTab tab) {
		return this;
	}

	public boolean canEditBlocks() {
		return false;
	}

	public boolean canRepairWith(ItemStack itemstack, ItemStack repairresource) {
		return false;
	}

	public Multimap<?, ?> getAttributeModifiers(EnumWearable var1) {
		return HashMultimap.create();
	}

	public static void init() {
		registerItemBlock(Blocks.STONE, (new ItemMultiTexture(Blocks.STONE, Blocks.STONE, new Function<ItemStack, String>() {
            public String apply(ItemStack var1) {
                return BlockStone.EnumStoneVariant.getByData(var1.i()).getILocaleName();
            }
        })).b("stone"));
		registerItemBlock(Blocks.GRASS, new ItemWithAuxData(Blocks.GRASS, false));
		registerItemBlock(Blocks.DIRT, (new ItemMultiTexture(Blocks.DIRT, Blocks.DIRT, new Function<ItemStack, String>() {
            public String apply(ItemStack var1) {
                return BlockDirt.EnumDirtVariant.getById(var1.i()).c();
            }
        })).b("dirt"));
		registerItemBlock(Blocks.COBBLESTONE);
		registerItemBlock(Blocks.PLANKS, (new ItemMultiTexture(Blocks.PLANKS, Blocks.PLANKS, new Function<ItemStack, String>() {
            public String apply(ItemStack var1) {
                return BlockWood.EnumLogVariant.getById(var1.i()).d();
            }
        })).b("wood"));
		registerItemBlock(Blocks.SAPLING, (new ItemMultiTexture(Blocks.SAPLING, Blocks.SAPLING, new Function<ItemStack, String>() {
            public String apply(ItemStack var1) {
                return BlockWood.EnumLogVariant.getById(var1.i()).d();
            }
        })).b("sapling"));
		registerItemBlock(Blocks.BEDROCK);
		registerItemBlock(Blocks.SAND, (new ItemMultiTexture(Blocks.SAND, Blocks.SAND, new Function<ItemStack, String>() {
            public String apply(ItemStack var1) {
                return BlockSand.EnumSandVariant.getById(var1.i()).d();
            }
        })).b("sand"));
		registerItemBlock(Blocks.GRAVEL);
		registerItemBlock(Blocks.GOLD_ORE);
		registerItemBlock(Blocks.IRON_ORE);
		registerItemBlock(Blocks.COAL_ORE);
		registerItemBlock(Blocks.LOG, (new ItemMultiTexture(Blocks.LOG, Blocks.LOG, new Function<ItemStack, String>() {
            public String apply(ItemStack var1) {
                return BlockWood.EnumLogVariant.getById(var1.i()).d();
            }
        })).b("log"));
		registerItemBlock(Blocks.LOG2, (new ItemMultiTexture(Blocks.LOG2, Blocks.LOG2, new Function<ItemStack, String>() {
            public String apply(ItemStack var1) {
                return BlockWood.EnumLogVariant.getById(var1.i() + 4).d();
            }
        })).b("log"));
		registerItemBlock(Blocks.LEAVES, (new ItemLeaves(Blocks.LEAVES)).b("leaves"));
		registerItemBlock(Blocks.LEAVES2, (new ItemLeaves(Blocks.LEAVES2)).b("leaves"));
		registerItemBlock(Blocks.SPONGE, (new ItemMultiTexture(Blocks.SPONGE, Blocks.SPONGE, new Function<ItemStack, String>() {
            public String apply(ItemStack var1) {
                return (var1.i() & 1) == 1 ? "wet" : "dry";
            }
        })).b("sponge"));
		registerItemBlock(Blocks.GLASS);
		registerItemBlock(Blocks.LAPIS_ORE);
		registerItemBlock(Blocks.LAPIS_BLOCK);
		registerItemBlock(Blocks.DISPENSER);
		registerItemBlock(Blocks.SANDSTONE, (new ItemMultiTexture(Blocks.SANDSTONE, Blocks.SANDSTONE, new Function<ItemStack, String>() {
            public String apply(ItemStack var1) {
                return BlockSandStone.EnumSandstoneVariant.getById(var1.i()).c();
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
		registerItemBlock(Blocks.YELLOW_FLOWER, (new ItemMultiTexture(Blocks.YELLOW_FLOWER, Blocks.YELLOW_FLOWER, new Function<ItemStack, String>() {
            public String apply(ItemStack var1) {
                return BlockFlowers.EnumFlowerVarient.getById(BlockFlowers.EnumFlowerType.YELLOW, var1.i()).d();
            }
        })).b("flower"));
		registerItemBlock(Blocks.RED_FLOWER, (new ItemMultiTexture(Blocks.RED_FLOWER, Blocks.RED_FLOWER, new Function<ItemStack, String>() {
            public String apply(ItemStack var1) {
                return BlockFlowers.EnumFlowerVarient.getById(BlockFlowers.EnumFlowerType.RED, var1.i()).d();
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
		//========= New stuff start ======
		registerItemBlock(Blocks.END_ROD);
		registerItemBlock(Blocks.CHORUS_PLANT);
		registerItemBlock(Blocks.CHORUS_FLOWER);
		registerItemBlock(Blocks.PURPUR_BLOCK);
		registerItemBlock(Blocks.PURPUR_PILLAR);
		registerItemBlock(Blocks.PURPUR_STAIRS);
		registerItemBlock(Blocks.PURPUR_SLAB, (new ItemStep(Blocks.PURPUR_SLAB, Blocks.PURPUR_SLAB, Blocks.PURPUR_DOUBLE_SLAB)).b("purpurSlab"));
        //========= New stuff end ========
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
		registerItemBlock(Blocks.MONSTER_EGG, (new ItemMultiTexture(Blocks.MONSTER_EGG, Blocks.MONSTER_EGG, new Function<ItemStack, String>() {
            public String apply(ItemStack var1) {
                return BlockMonsterEggs.EnumMonsterEggVariant.a(var1.i()).c();
            }
        })).b("monsterStoneEgg"));
		registerItemBlock(Blocks.STONEBRICK, (new ItemMultiTexture(Blocks.STONEBRICK, Blocks.STONEBRICK, new Function<ItemStack, String>() {
            public String apply(ItemStack var1) {
                return BlockSmoothBrick.EnumSmoothBrickType.a(var1.i()).c();
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
		registerItemBlock(Blocks.COBBLESTONE_WALL, (new ItemMultiTexture(Blocks.COBBLESTONE_WALL, Blocks.COBBLESTONE_WALL, new Function<ItemStack, String>() {
            public String apply(ItemStack var1) {
                return BlockCobbleWall.class_a_in_class_alv.a(var1.i()).c();
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
		registerItemBlock(Blocks.SLIME);
		registerItemBlock(Blocks.GRASS_PATH);
		registerItemBlock(Blocks.DOUBLE_PLANT, (new class_zx(Blocks.DOUBLE_PLANT, Blocks.DOUBLE_PLANT, new Function<ItemStack, String>() {
            public String apply(ItemStack var1) {
                return BlockTallPlant.class_b_in_class_ahm.a(var1.i()).c();
            }
        })).b("doublePlant"));
		registerItemBlock(Blocks.STAINED_GLASS, (new class_aaa(Blocks.STAINED_GLASS)).b("stainedGlass"));
		registerItemBlock(Blocks.STAINED_GLASS_PANE, (new class_aaa(Blocks.STAINED_GLASS_PANE)).b("stainedGlassPane"));
		registerItemBlock(Blocks.PRISMARINE, (new ItemMultiTexture(Blocks.PRISMARINE, Blocks.PRISMARINE, new Function<ItemStack, String>() {
            public String apply(ItemStack var1) {
                return BlockPrismarine.class_a_in_class_akc.a(var1.i()).c();
            }
        })).b("prismarine"));
		registerItemBlock(Blocks.SEA_LANTERN);
		registerItemBlock(Blocks.RED_SANDSTONE, (new ItemMultiTexture(Blocks.RED_SANDSTONE, Blocks.RED_SANDSTONE, new Function<ItemStack, String>() {
            public String apply(ItemStack var1) {
                return BlockRedSandstone.class_a_in_class_aki.a(var1.i()).c();
            }
        })).b("redSandStone"));
		registerItemBlock(Blocks.RED_SANDSTONE_STAIRS);
		registerItemBlock(Blocks.STONE_SLAB2, (new ItemStep(Blocks.STONE_SLAB2, Blocks.STONE_SLAB2, Blocks.DOUBLE_STONE_SLAB2)).b("stoneSlab2"));
		registerItem(256, "iron_shovel", (new ItemSpade(EnumToolMaterial.IRON)).setName("shovelIron"));
		registerItem(257, "iron_pickaxe", (new ItemPickaxe(EnumToolMaterial.IRON)).setName("pickaxeIron"));
		registerItem(258, "iron_axe", (new ItemAxe(EnumToolMaterial.IRON)).setName("hatchetIron"));
		registerItem(259, "flint_and_steel", (new class_aam()).setName("flintAndSteel"));
		registerItem(260, "apple", (new ItemFood(4, 0.3F, false)).setName("apple"));
		registerItem(261, "bow", (new ItemBow()).setName("bow"));
		registerItem(262, "arrow", (new ItemArrow()).setName("arrow"));
		registerItem(263, "coal", (new ItemCoal()).setName("coal"));
		registerItem(264, "diamond", (new Item()).setName("diamond").setCreativeTab(CreativeTab.MATERIALS));
		registerItem(265, "iron_ingot", (new Item()).setName("ingotIron").setCreativeTab(CreativeTab.MATERIALS));
		registerItem(266, "gold_ingot", (new Item()).setName("ingotGold").setCreativeTab(CreativeTab.MATERIALS));
		registerItem(267, "iron_sword", (new ItemSword(EnumToolMaterial.IRON)).setName("swordIron"));
		registerItem(268, "wooden_sword", (new ItemSword(EnumToolMaterial.WOOD)).setName("swordWood"));
		registerItem(269, "wooden_shovel", (new ItemSpade(EnumToolMaterial.WOOD)).setName("shovelWood"));
		registerItem(270, "wooden_pickaxe", (new ItemPickaxe(EnumToolMaterial.WOOD)).setName("pickaxeWood"));
		registerItem(271, "wooden_axe", (new ItemAxe(EnumToolMaterial.WOOD)).setName("hatchetWood"));
		registerItem(272, "stone_sword", (new ItemSword(EnumToolMaterial.STONE)).setName("swordStone"));
		registerItem(273, "stone_shovel", (new ItemSpade(EnumToolMaterial.STONE)).setName("shovelStone"));
		registerItem(274, "stone_pickaxe", (new ItemPickaxe(EnumToolMaterial.STONE)).setName("pickaxeStone"));
		registerItem(275, "stone_axe", (new ItemAxe(EnumToolMaterial.STONE)).setName("hatchetStone"));
		registerItem(276, "diamond_sword", (new ItemSword(EnumToolMaterial.EMERALD)).setName("swordDiamond"));
		registerItem(277, "diamond_shovel", (new ItemSpade(EnumToolMaterial.EMERALD)).setName("shovelDiamond"));
		registerItem(278, "diamond_pickaxe", (new ItemPickaxe(EnumToolMaterial.EMERALD)).setName("pickaxeDiamond"));
		registerItem(279, "diamond_axe", (new ItemAxe(EnumToolMaterial.EMERALD)).setName("hatchetDiamond"));
		registerItem(280, "stick", (new Item()).setUnusedField().setName("stick").setCreativeTab(CreativeTab.MATERIALS));
		registerItem(281, "bowl", (new Item()).setName("bowl").setCreativeTab(CreativeTab.MATERIALS));
		registerItem(282, "mushroom_stew", (new ItemSoup(6)).setName("mushroomStew"));
		registerItem(283, "golden_sword", (new ItemSword(EnumToolMaterial.GOLD)).setName("swordGold"));
		registerItem(284, "golden_shovel", (new ItemSpade(EnumToolMaterial.GOLD)).setName("shovelGold"));
		registerItem(285, "golden_pickaxe", (new ItemPickaxe(EnumToolMaterial.GOLD)).setName("pickaxeGold"));
		registerItem(286, "golden_axe", (new ItemAxe(EnumToolMaterial.GOLD)).setName("hatchetGold"));
		registerItem(287, "string", (new ItemReed(Blocks.TRIPWIRE)).setName("string").setCreativeTab(CreativeTab.MATERIALS));
		registerItem(288, "feather", (new Item()).setName("feather").setCreativeTab(CreativeTab.MATERIALS));
		registerItem(289, "gunpowder", (new Item()).setName("sulphur").setCreativeTab(CreativeTab.MATERIALS));
		registerItem(290, "wooden_hoe", (new ItemHoe(EnumToolMaterial.WOOD)).setName("hoeWood"));
		registerItem(291, "stone_hoe", (new ItemHoe(EnumToolMaterial.STONE)).setName("hoeStone"));
		registerItem(292, "iron_hoe", (new ItemHoe(EnumToolMaterial.IRON)).setName("hoeIron"));
		registerItem(293, "diamond_hoe", (new ItemHoe(EnumToolMaterial.EMERALD)).setName("hoeDiamond"));
		registerItem(294, "golden_hoe", (new ItemHoe(EnumToolMaterial.GOLD)).setName("hoeGold"));
		registerItem(295, "wheat_seeds", (new ItemSeeds(Blocks.WHEAT, Blocks.FARMLAND)).setName("seeds"));
		registerItem(296, "wheat", (new Item()).setName("wheat").setCreativeTab(CreativeTab.MATERIALS));
		registerItem(297, "bread", (new ItemFood(5, 0.6F, false)).setName("bread"));
		registerItem(298, "leather_helmet", (new ItemArmor(ItemArmor.EnumArmorMaterial.LEATHER, 0, EnumWearable.HEAD)).setName("helmetCloth"));
		registerItem(299, "leather_chestplate", (new ItemArmor(ItemArmor.EnumArmorMaterial.LEATHER, 0, EnumWearable.TORSO)).setName("chestplateCloth"));
		registerItem(300, "leather_leggings", (new ItemArmor(ItemArmor.EnumArmorMaterial.LEATHER, 0, EnumWearable.LEGS)).setName("leggingsCloth"));
		registerItem(301, "leather_boots", (new ItemArmor(ItemArmor.EnumArmorMaterial.LEATHER, 0, EnumWearable.FEET)).setName("bootsCloth"));
		registerItem(302, "chainmail_helmet", (new ItemArmor(ItemArmor.EnumArmorMaterial.CHAIN, 1, EnumWearable.HEAD)).setName("helmetChain"));
		registerItem(303, "chainmail_chestplate", (new ItemArmor(ItemArmor.EnumArmorMaterial.CHAIN, 1, EnumWearable.TORSO)).setName("chestplateChain"));
		registerItem(304, "chainmail_leggings", (new ItemArmor(ItemArmor.EnumArmorMaterial.CHAIN, 1, EnumWearable.LEGS)).setName("leggingsChain"));
		registerItem(305, "chainmail_boots", (new ItemArmor(ItemArmor.EnumArmorMaterial.CHAIN, 1, EnumWearable.FEET)).setName("bootsChain"));
		registerItem(306, "iron_helmet", (new ItemArmor(ItemArmor.EnumArmorMaterial.IRON, 2, EnumWearable.HEAD)).setName("helmetIron"));
		registerItem(307, "iron_chestplate", (new ItemArmor(ItemArmor.EnumArmorMaterial.IRON, 2, EnumWearable.TORSO)).setName("chestplateIron"));
		registerItem(308, "iron_leggings", (new ItemArmor(ItemArmor.EnumArmorMaterial.IRON, 2, EnumWearable.LEGS)).setName("leggingsIron"));
		registerItem(309, "iron_boots", (new ItemArmor(ItemArmor.EnumArmorMaterial.IRON, 2, EnumWearable.FEET)).setName("bootsIron"));
		registerItem(310, "diamond_helmet", (new ItemArmor(ItemArmor.EnumArmorMaterial.DIAMOND, 3, EnumWearable.HEAD)).setName("helmetDiamond"));
		registerItem(311, "diamond_chestplate", (new ItemArmor(ItemArmor.EnumArmorMaterial.DIAMOND, 3, EnumWearable.TORSO)).setName("chestplateDiamond"));
		registerItem(312, "diamond_leggings", (new ItemArmor(ItemArmor.EnumArmorMaterial.DIAMOND, 3, EnumWearable.LEGS)).setName("leggingsDiamond"));
		registerItem(313, "diamond_boots", (new ItemArmor(ItemArmor.EnumArmorMaterial.DIAMOND, 3, EnumWearable.FEET)).setName("bootsDiamond"));
		registerItem(314, "golden_helmet", (new ItemArmor(ItemArmor.EnumArmorMaterial.GOLD, 4, EnumWearable.HEAD)).setName("helmetGold"));
		registerItem(315, "golden_chestplate", (new ItemArmor(ItemArmor.EnumArmorMaterial.GOLD, 4, EnumWearable.TORSO)).setName("chestplateGold"));
		registerItem(316, "golden_leggings", (new ItemArmor(ItemArmor.EnumArmorMaterial.GOLD, 4, EnumWearable.LEGS)).setName("leggingsGold"));
		registerItem(317, "golden_boots", (new ItemArmor(ItemArmor.EnumArmorMaterial.GOLD, 4, EnumWearable.FEET)).setName("bootsGold"));
		registerItem(318, "flint", (new Item()).setName("flint").setCreativeTab(CreativeTab.MATERIALS));
		registerItem(319, "porkchop", (new ItemFood(3, 0.3F, true)).setName("porkchopRaw"));
		registerItem(320, "cooked_porkchop", (new ItemFood(8, 0.8F, true)).setName("porkchopCooked"));
		registerItem(321, "painting", (new EntityHanging(EntityPainting.class)).setName("painting"));
		registerItem(322, "golden_apple", (new ItemGoldenApple(4, 1.2F, false)).h().a(new MobEffect(MobEffectList.REGENERATION, 100, 1), 1.0F).setName("appleGold"));
		registerItem(323, "sign", (new ItemSign()).setName("sign"));
		registerItem(324, "wooden_door", (new ItemDoor(Blocks.WOODEN_DOOR)).setName("doorOak"));
		Item bucket = (new ItemBucket(Blocks.AIR)).setName("bucket").d(16);
		registerItem(325, "bucket", bucket);
		registerItem(326, "water_bucket", (new ItemBucket(Blocks.FLOWING_WATER)).setName("bucketWater").setCraftingResult(bucket));
		registerItem(327, "lava_bucket", (new ItemBucket(Blocks.FLOWING_LAVA)).setName("bucketLava").setCraftingResult(bucket));
		registerItem(328, "minecart", (new ItemMinecart(EntityMinecartAbstract.EnumMinecartType.RIDEABLE)).setName("minecart"));
		registerItem(329, "saddle", (new ItemSaddle()).setName("saddle"));
		registerItem(330, "iron_door", (new ItemDoor(Blocks.IRON_DOOR)).setName("doorIron"));
		registerItem(331, "redstone", (new ItemRedstone()).setName("redstone"));
		registerItem(332, "snowball", (new ItemSnowball()).setName("snowball"));
		registerItem(333, "boat", (new ItemBoat()).setName("boat"));
		registerItem(334, "leather", (new Item()).setName("leather").setCreativeTab(CreativeTab.MATERIALS));
		registerItem(335, "milk_bucket", (new ItemMilkBucket()).setName("milk").setCraftingResult(bucket));
		registerItem(336, "brick", (new Item()).setName("brick").setCreativeTab(CreativeTab.MATERIALS));
		registerItem(337, "clay_ball", (new Item()).setName("clay").setCreativeTab(CreativeTab.MATERIALS));
		registerItem(338, "reeds", (new ItemReed(Blocks.REEDS)).setName("reeds").setCreativeTab(CreativeTab.MATERIALS));
		registerItem(339, "paper", (new Item()).setName("paper").setCreativeTab(CreativeTab.MISC));
		registerItem(340, "book", (new ItemBook()).setName("book").setCreativeTab(CreativeTab.MISC));
		registerItem(341, "slime_ball", (new Item()).setName("slimeball").setCreativeTab(CreativeTab.MISC));
		registerItem(342, "chest_minecart", (new ItemMinecart(EntityMinecartAbstract.EnumMinecartType.CHEST)).setName("minecartChest"));
		registerItem(343, "furnace_minecart", (new ItemMinecart(EntityMinecartAbstract.EnumMinecartType.FURNACE)).setName("minecartFurnace"));
		registerItem(344, "egg", (new ItemEgg()).setName("egg"));
		registerItem(345, "compass", (new ItemCompass()).setName("compass").setCreativeTab(CreativeTab.TOOLS));
		registerItem(346, "fishing_rod", (new ItemFishingRod()).setName("fishingRod"));
		registerItem(347, "clock", (new ItemClock()).setName("clock").setCreativeTab(CreativeTab.TOOLS));
		registerItem(348, "glowstone_dust", (new Item()).setName("yellowDust").setCreativeTab(CreativeTab.MATERIALS));
		registerItem(349, "fish", (new ItemFish(false)).setName("fish").setUsesData(true));
		registerItem(350, "cooked_fish", (new ItemFish(true)).setName("fish").setUsesData(true));
		registerItem(351, "dye", (new ItemDye()).setName("dyePowder"));
		registerItem(352, "bone", (new Item()).setName("bone").setUnusedField().setCreativeTab(CreativeTab.MISC));
		registerItem(353, "sugar", (new Item()).setName("sugar").setCreativeTab(CreativeTab.MATERIALS));
		registerItem(354, "cake", (new ItemReed(Blocks.CAKE)).d(1).setName("cake").setCreativeTab(CreativeTab.FOOD));
		registerItem(355, "bed", (new ItemBed()).d(1).setName("bed"));
		registerItem(356, "repeater", (new ItemReed(Blocks.UNPOWERED_REPEATER)).setName("diode").setCreativeTab(CreativeTab.REDSTONE));
		registerItem(357, "cookie", (new ItemFood(2, 0.1F, false)).setName("cookie"));
		registerItem(358, "filled_map", (new ItemWorldMap()).setName("map"));
		registerItem(359, "shears", (new ItemShears()).setName("shears"));
		registerItem(360, "melon", (new ItemFood(2, 0.3F, false)).setName("melon"));
		registerItem(361, "pumpkin_seeds", (new ItemSeeds(Blocks.PUMPKIN_STEM, Blocks.FARMLAND)).setName("seeds_pumpkin"));
		registerItem(362, "melon_seeds", (new ItemSeeds(Blocks.MELON_STEM, Blocks.FARMLAND)).setName("seeds_melon"));
		registerItem(363, "beef", (new ItemFood(3, 0.3F, true)).setName("beefRaw"));
		registerItem(364, "cooked_beef", (new ItemFood(8, 0.8F, true)).setName("beefCooked"));
		registerItem(365, "chicken", (new ItemFood(2, 0.3F, true)).a(new MobEffect(MobEffectList.HUNGER, 600, 0), 0.3F).setName("chickenRaw"));
		registerItem(366, "cooked_chicken", (new ItemFood(6, 0.6F, true)).setName("chickenCooked"));
		registerItem(367, "rotten_flesh", (new ItemFood(4, 0.1F, true)).a(new MobEffect(MobEffectList.HUNGER, 600, 0), 0.8F).setName("rottenFlesh"));
		registerItem(368, "ender_pearl", (new ItemEnderPearl()).setName("enderPearl"));
		registerItem(369, "blaze_rod", (new Item()).setName("blazeRod").setCreativeTab(CreativeTab.MATERIALS).setUnusedField());
		registerItem(370, "ghast_tear", (new Item()).setName("ghastTear").setCreativeTab(CreativeTab.BREWING));
		registerItem(371, "gold_nugget", (new Item()).setName("goldNugget").setCreativeTab(CreativeTab.MATERIALS));
		registerItem(372, "nether_wart", (new ItemSeeds(Blocks.NETHER_WART, Blocks.SOUL_SAND)).setName("netherStalkSeeds"));
		registerItem(373, "potion", (new ItemPotion()).setName("potion"));
		registerItem(374, "glass_bottle", (new ItemGlassBottle()).setName("glassBottle"));
		registerItem(375, "spider_eye", (new ItemFood(2, 0.8F, false)).a(new MobEffect(MobEffectList.POISON, 100, 0), 1.0F).setName("spiderEye"));
		registerItem(376, "fermented_spider_eye", (new Item()).setName("fermentedSpiderEye").setCreativeTab(CreativeTab.BREWING));
		registerItem(377, "blaze_powder", (new Item()).setName("blazePowder").setCreativeTab(CreativeTab.BREWING));
		registerItem(378, "magma_cream", (new Item()).setName("magmaCream").setCreativeTab(CreativeTab.BREWING));
		registerItem(379, "brewing_stand", (new ItemReed(Blocks.BREWING_STAND)).setName("brewingStand").setCreativeTab(CreativeTab.BREWING));
		registerItem(380, "cauldron", (new ItemReed(Blocks.CAULDRON)).setName("cauldron").setCreativeTab(CreativeTab.BREWING));
		registerItem(381, "ender_eye", (new ItemEnderEye()).setName("eyeOfEnder"));
		registerItem(382, "speckled_melon", (new Item()).setName("speckledMelon").setCreativeTab(CreativeTab.BREWING));
		registerItem(383, "spawn_egg", (new ItemMonsterEgg()).setName("monsterPlacer"));
		registerItem(384, "experience_bottle", (new ItemExpBottle()).setName("expBottle"));
		registerItem(385, "fire_charge", (new ItemFireball()).setName("fireball"));
		registerItem(386, "writable_book", (new ItemBookAndQuill()).setName("writingBook").setCreativeTab(CreativeTab.MISC));
		registerItem(387, "written_book", (new ItemWrittenBook()).setName("writtenBook").d(16));
		registerItem(388, "emerald", (new Item()).setName("emerald").setCreativeTab(CreativeTab.MATERIALS));
		registerItem(389, "item_frame", (new EntityHanging(EntityItemFrame.class)).setName("frame"));
		registerItem(390, "flower_pot", (new ItemReed(Blocks.FLOWER_POT)).setName("flowerPot").setCreativeTab(CreativeTab.DECORATIONS));
		registerItem(391, "carrot", (new ItemSeedFood(3, 0.6F, Blocks.CARROTS, Blocks.FARMLAND)).setName("carrots"));
		registerItem(392, "potato", (new ItemSeedFood(1, 0.3F, Blocks.POTATOES, Blocks.FARMLAND)).setName("potato"));
		registerItem(393, "baked_potato", (new ItemFood(5, 0.6F, false)).setName("potatoBaked"));
		registerItem(394, "poisonous_potato", (new ItemFood(2, 0.3F, false)).a(new MobEffect(MobEffectList.POISON, 100, 0), 0.6F).setName("potatoPoisonous"));
		registerItem(395, "map", (new ItemMapEmpty()).setName("emptyMap"));
		registerItem(396, "golden_carrot", (new ItemFood(6, 1.2F, false)).setName("carrotGolden").setCreativeTab(CreativeTab.BREWING));
		registerItem(397, "skull", (new ItemSkull()).setName("skull"));
		registerItem(398, "carrot_on_a_stick", (new ItemCarrotStick()).setName("carrotOnAStick"));
		registerItem(399, "nether_star", (new ItemNetherStar()).setName("netherStar").setCreativeTab(CreativeTab.MATERIALS));
		registerItem(400, "pumpkin_pie", (new ItemFood(8, 0.3F, false)).setName("pumpkinPie").setCreativeTab(CreativeTab.FOOD));
		registerItem(401, "fireworks", (new ItemFireworks()).setName("fireworks"));
		registerItem(402, "firework_charge", (new ItemFireworksCharge()).setName("fireworksCharge").setCreativeTab(CreativeTab.MISC));
		registerItem(403, "enchanted_book", (new ItemEnchantedBook()).d(1).setName("enchantedBook"));
		registerItem(404, "comparator", (new ItemReed(Blocks.UNPOWERED_COMPARATOR)).setName("comparator").setCreativeTab(CreativeTab.REDSTONE));
		registerItem(405, "netherbrick", (new Item()).setName("netherbrick").setCreativeTab(CreativeTab.MATERIALS));
		registerItem(406, "quartz", (new Item()).setName("netherquartz").setCreativeTab(CreativeTab.MATERIALS));
		registerItem(407, "tnt_minecart", (new ItemMinecart(EntityMinecartAbstract.EnumMinecartType.TNT)).setName("minecartTnt"));
		registerItem(408, "hopper_minecart", (new ItemMinecart(EntityMinecartAbstract.EnumMinecartType.HOPPER)).setName("minecartHopper"));
		registerItem(409, "prismarine_shard", (new Item()).setName("prismarineShard").setCreativeTab(CreativeTab.MATERIALS));
		registerItem(410, "prismarine_crystals", (new Item()).setName("prismarineCrystals").setCreativeTab(CreativeTab.MATERIALS));
		registerItem(411, "rabbit", (new ItemFood(3, 0.3F, true)).setName("rabbitRaw"));
		registerItem(412, "cooked_rabbit", (new ItemFood(5, 0.6F, true)).setName("rabbitCooked"));
		registerItem(413, "rabbit_stew", (new ItemSoup(10)).setName("rabbitStew"));
		registerItem(414, "rabbit_foot", (new Item()).setName("rabbitFoot").setCreativeTab(CreativeTab.BREWING));
		registerItem(415, "rabbit_hide", (new Item()).setName("rabbitHide").setCreativeTab(CreativeTab.MATERIALS));
		registerItem(416, "armor_stand", (new ItemArmorStand()).setName("armorStand").d(16));
		registerItem(417, "iron_horse_armor", (new Item()).setName("horsearmormetal").d(1).setCreativeTab(CreativeTab.MISC));
		registerItem(418, "golden_horse_armor", (new Item()).setName("horsearmorgold").d(1).setCreativeTab(CreativeTab.MISC));
		registerItem(419, "diamond_horse_armor", (new Item()).setName("horsearmordiamond").d(1).setCreativeTab(CreativeTab.MISC));
		registerItem(420, "lead", (new ItemLeash()).setName("leash"));
		registerItem(421, "name_tag", (new ItemNameTage()).setName("nameTag"));
		registerItem(422, "command_block_minecart", (new ItemMinecart(EntityMinecartAbstract.EnumMinecartType.COMMAND_BLOCK)).setName("minecartCommandBlock").setCreativeTab((CreativeTab) null));
		registerItem(423, "mutton", (new ItemFood(2, 0.3F, true)).setName("muttonRaw"));
		registerItem(424, "cooked_mutton", (new ItemFood(6, 0.8F, true)).setName("muttonCooked"));
		registerItem(425, "banner", (new ItemBanner()).b("banner"));
		registerItem(427, "spruce_door", (new ItemDoor(Blocks.SPRUCE_DOOR)).setName("doorSpruce"));
		registerItem(428, "birch_door", (new ItemDoor(Blocks.BIRCH_DOOR)).setName("doorBirch"));
		registerItem(429, "jungle_door", (new ItemDoor(Blocks.JUNGLE_DOOR)).setName("doorJungle"));
		registerItem(430, "acacia_door", (new ItemDoor(Blocks.ACACIA_DOOR)).setName("doorAcacia"));
		registerItem(431, "dark_oak_door", (new ItemDoor(Blocks.DARK_OAK_DOOR)).setName("doorDarkOak"));
		//======== New items =========
		registerItem(432, "chorus_fruit", (new ItemChorusFruit(4, 0.3F)).h().setName("chorusFruit").setCreativeTab(CreativeTab.MATERIALS));
		registerItem(433, "chorus_fruit_popped", (new Item()).setName("chorusFruitPopped").setCreativeTab(CreativeTab.MATERIALS));
		registerItem(434, "beetroot", (new ItemFood(1, 0.6F, false)).setName("beetroot"));
		registerItem(435, "beetroot_seeds", (new ItemSeeds(Blocks.BEETROOTS, Blocks.FARMLAND)).setName("beetroot_seeds"));
		registerItem(436, "beetroot_soup", (new ItemSoup(6)).setName("beetroot_soup"));
		registerItem(438, "splash_potion", (new ItemSplashPotion()).setName("splash_potion"));
		registerItem(439, "spectral_arrow", (new ItemSpectralArrow()).setName("spectral_arrow"));
		registerItem(440, "tipped_arrow", (new ItemTippedArrow()).setName("tipped_arrow"));
		//======== End new items =========
		registerItem(2256, "record_13", (new ItemRecord("13")).setName("record"));
		registerItem(2257, "record_cat", (new ItemRecord("cat")).setName("record"));
		registerItem(2258, "record_blocks", (new ItemRecord("blocks")).setName("record"));
		registerItem(2259, "record_chirp", (new ItemRecord("chirp")).setName("record"));
		registerItem(2260, "record_far", (new ItemRecord("far")).setName("record"));
		registerItem(2261, "record_mall", (new ItemRecord("mall")).setName("record"));
		registerItem(2262, "record_mellohi", (new ItemRecord("mellohi")).setName("record"));
		registerItem(2263, "record_stal", (new ItemRecord("stal")).setName("record"));
		registerItem(2264, "record_strad", (new ItemRecord("strad")).setName("record"));
		registerItem(2265, "record_ward", (new ItemRecord("ward")).setName("record"));
		registerItem(2266, "record_11", (new ItemRecord("11")).setName("record"));
		registerItem(2267, "record_wait", (new ItemRecord("wait")).setName("record"));
	}

	private static void registerItemBlock(Block block) {
		registerItemBlock(block, new ItemBlock(block));
	}

	protected static void registerItemBlock(Block block, Item item) {
		registerItem(Block.getId(block), Block.BLOCK_REGISTRY.getKey(block), item);
		BLOCK_TO_ITEM.put(block, item);
	}

	private static void registerItem(int id, String name, Item item) {
		registerItem(id, new MinecraftKey(name), item);
	}

	private static void registerItem(int id, MinecraftKey name, Item item) {
		ITEM_REGISTRY.register(id, name, item);
	}

	public enum EnumToolMaterial {
		WOOD(0, 59, 2.0F, 0.0F, 15), STONE(1, 131, 4.0F, 1.0F, 5), IRON(2, 250, 6.0F, 2.0F, 14), EMERALD(3, 1561, 8.0F, 3.0F, 10), GOLD(0, 32, 12.0F, 0.0F, 22);

		private final int harvestLevel;
		private final int maxUses;
		private final float efficiency;
		private final float entityDamage;
		private final int enchantability;

		EnumToolMaterial(int harvestLevel, int maxUses, float efficiency, float entityDamage, int enchantability) {
			this.harvestLevel = harvestLevel;
			this.maxUses = maxUses;
			this.efficiency = efficiency;
			this.entityDamage = entityDamage;
			this.enchantability = enchantability;
		}

		public int getMaxUses() {
			return this.maxUses;
		}

		public float getEfficiency() {
			return this.efficiency;
		}

		public float getEntityDamage() {
			return this.entityDamage;
		}

		public int getHarvestLevel() {
			return this.harvestLevel;
		}

		public int getEnchantability() {
			return this.enchantability;
		}

		public Item getRepairResource() {
			return this == WOOD ? Item.getItemOf(Blocks.PLANKS) : (this == STONE ? Item.getItemOf(Blocks.COBBLESTONE) : (this == GOLD ? Items.GOLD_INGOT : (this == IRON ? Items.IRON_INGOT : (this == EMERALD ? Items.DIAMOND : null))));
		}
	}

}
