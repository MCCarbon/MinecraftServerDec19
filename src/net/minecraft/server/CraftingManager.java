package net.minecraft.server;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class CraftingManager {
   private static final CraftingManager a = new CraftingManager();
   private final List b = Lists.newArrayList();

   public static CraftingManager a() {
      return a;
   }

   private CraftingManager() {
      (new RecipesTools()).a(this);
      (new RecipesWeapons()).a(this);
      (new RecipesIngots()).a(this);
      (new RecipesFood()).a(this);
      (new RecipesCrafting()).a(this);
      (new RecipesArmor()).a(this);
      (new RecipesDyes()).a(this);
      this.b.add(new RecipeArmorDye());
      this.b.add(new RecipeBookClone());
      this.b.add(new RecipeMapClone());
      this.b.add(new RecipeMapExtend());
      this.b.add(new RecipeFireworks());
      this.b.add(new class_acu());
      (new RecipeBanners()).a(this);
      this.registerShapedRecipe(new ItemStack(Items.PAPER, 3), "###", Character.valueOf('#'), Items.REEDS);
      this.registerShapelessRecipe(new ItemStack(Items.BOOK, 1), Items.PAPER, Items.PAPER, Items.PAPER, Items.LEATHER);
      this.registerShapelessRecipe(new ItemStack(Items.WRITABLE_BOOK, 1), Items.BOOK, new ItemStack(Items.DYE, 1, EnumColor.p.b()), Items.FEATHER);
      this.registerShapedRecipe(new ItemStack(Blocks.FENCE, 3), "W#W", "W#W", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(Blocks.PLANKS, 1, BlockWood.EnumLogVariant.OAK.getId()));
      this.registerShapedRecipe(new ItemStack(Blocks.BIRCH_FENCE, 3), "W#W", "W#W", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(Blocks.PLANKS, 1, BlockWood.EnumLogVariant.BIRCH.getId()));
      this.registerShapedRecipe(new ItemStack(Blocks.SPRUCE_FENCE, 3), "W#W", "W#W", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(Blocks.PLANKS, 1, BlockWood.EnumLogVariant.SPRUCE.getId()));
      this.registerShapedRecipe(new ItemStack(Blocks.JUNGLE_FENCE, 3), "W#W", "W#W", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(Blocks.PLANKS, 1, BlockWood.EnumLogVariant.JUNGLE.getId()));
      this.registerShapedRecipe(new ItemStack(Blocks.ACACIA_FENCE, 3), "W#W", "W#W", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(Blocks.PLANKS, 1, 4 + BlockWood.EnumLogVariant.ACACIA.getId() - 4));
      this.registerShapedRecipe(new ItemStack(Blocks.DARK_OAK_FENCE, 3), "W#W", "W#W", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(Blocks.PLANKS, 1, 4 + BlockWood.EnumLogVariant.DARK_OAK.getId() - 4));
      this.registerShapedRecipe(new ItemStack(Blocks.COBBLESTONE_WALL, 6, BlockCobbleWall.class_a_in_class_alv.a.a()), "###", "###", Character.valueOf('#'), Blocks.COBBLESTONE);
      this.registerShapedRecipe(new ItemStack(Blocks.COBBLESTONE_WALL, 6, BlockCobbleWall.class_a_in_class_alv.b.a()), "###", "###", Character.valueOf('#'), Blocks.MOSSY_COBBLESTONE);
      this.registerShapedRecipe(new ItemStack(Blocks.NETHER_BRICK_FENCE, 6), "###", "###", Character.valueOf('#'), Blocks.NETHER_BRICK);
      this.registerShapedRecipe(new ItemStack(Blocks.FENCE_GATE, 1), "#W#", "#W#", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(Blocks.PLANKS, 1, BlockWood.EnumLogVariant.OAK.getId()));
      this.registerShapedRecipe(new ItemStack(Blocks.BIRCH_FENCE_GATE, 1), "#W#", "#W#", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(Blocks.PLANKS, 1, BlockWood.EnumLogVariant.BIRCH.getId()));
      this.registerShapedRecipe(new ItemStack(Blocks.SPRUCE_FENCE_GATE, 1), "#W#", "#W#", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(Blocks.PLANKS, 1, BlockWood.EnumLogVariant.SPRUCE.getId()));
      this.registerShapedRecipe(new ItemStack(Blocks.JUGLE_FENCE_GATE, 1), "#W#", "#W#", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(Blocks.PLANKS, 1, BlockWood.EnumLogVariant.JUNGLE.getId()));
      this.registerShapedRecipe(new ItemStack(Blocks.ACACIA_FENCE_GATE, 1), "#W#", "#W#", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(Blocks.PLANKS, 1, 4 + BlockWood.EnumLogVariant.ACACIA.getId() - 4));
      this.registerShapedRecipe(new ItemStack(Blocks.DARK_OAK_FENCE_GATE, 1), "#W#", "#W#", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(Blocks.PLANKS, 1, 4 + BlockWood.EnumLogVariant.DARK_OAK.getId() - 4));
      this.registerShapedRecipe(new ItemStack(Blocks.JUKEBOX, 1), "###", "#X#", "###", Character.valueOf('#'), Blocks.PLANKS, Character.valueOf('X'), Items.DIAMOND);
      this.registerShapedRecipe(new ItemStack(Items.LEAD, 2), "~~ ", "~O ", "  ~", Character.valueOf('~'), Items.STRING, Character.valueOf('O'), Items.SLIME_BALL);
      this.registerShapedRecipe(new ItemStack(Blocks.NOTEBLOCK, 1), "###", "#X#", "###", Character.valueOf('#'), Blocks.PLANKS, Character.valueOf('X'), Items.REDSTONE);
      this.registerShapedRecipe(new ItemStack(Blocks.BOOKSHELF, 1), "###", "XXX", "###", Character.valueOf('#'), Blocks.PLANKS, Character.valueOf('X'), Items.BOOK);
      this.registerShapedRecipe(new ItemStack(Blocks.SNOW, 1), "##", "##", Character.valueOf('#'), Items.SNOWBALL);
      this.registerShapedRecipe(new ItemStack(Blocks.SNOW_LAYER, 6), "###", Character.valueOf('#'), Blocks.SNOW);
      this.registerShapedRecipe(new ItemStack(Blocks.CLAY, 1), "##", "##", Character.valueOf('#'), Items.CLAY_BALL);
      this.registerShapedRecipe(new ItemStack(Blocks.BRICK_BLOCK, 1), "##", "##", Character.valueOf('#'), Items.BRICK);
      this.registerShapedRecipe(new ItemStack(Blocks.GLOWSTONE, 1), "##", "##", Character.valueOf('#'), Items.GLOWSTONE_DUST);
      this.registerShapedRecipe(new ItemStack(Blocks.QUARTZ_BLOCK, 1), "##", "##", Character.valueOf('#'), Items.QUARTZ);
      this.registerShapedRecipe(new ItemStack(Blocks.WOOL, 1), "##", "##", Character.valueOf('#'), Items.STRING);
      this.registerShapedRecipe(new ItemStack(Blocks.TNT, 1), "X#X", "#X#", "X#X", Character.valueOf('X'), Items.GUNPOWDER, Character.valueOf('#'), Blocks.SAND);
      this.registerShapedRecipe(new ItemStack(Blocks.STONE_SLAB, 6, BlockDoubleStepAbstract.EnumStoneSlabVariant.COBBLESTONE.getId()), "###", Character.valueOf('#'), Blocks.COBBLESTONE);
      this.registerShapedRecipe(new ItemStack(Blocks.STONE_SLAB, 6, BlockDoubleStepAbstract.EnumStoneSlabVariant.STONE.getId()), "###", Character.valueOf('#'), new ItemStack(Blocks.STONE, 1, BlockStone.EnumStoneVariant.STONE.getData()));
      this.registerShapedRecipe(new ItemStack(Blocks.STONE_SLAB, 6, BlockDoubleStepAbstract.EnumStoneSlabVariant.SAND.getId()), "###", Character.valueOf('#'), Blocks.SANDSTONE);
      this.registerShapedRecipe(new ItemStack(Blocks.STONE_SLAB, 6, BlockDoubleStepAbstract.EnumStoneSlabVariant.BRICK.getId()), "###", Character.valueOf('#'), Blocks.BRICK_BLOCK);
      this.registerShapedRecipe(new ItemStack(Blocks.STONE_SLAB, 6, BlockDoubleStepAbstract.EnumStoneSlabVariant.SMOOTHBRICK.getId()), "###", Character.valueOf('#'), Blocks.STONEBRICK);
      this.registerShapedRecipe(new ItemStack(Blocks.STONE_SLAB, 6, BlockDoubleStepAbstract.EnumStoneSlabVariant.NETHERBRICK.getId()), "###", Character.valueOf('#'), Blocks.NETHER_BRICK);
      this.registerShapedRecipe(new ItemStack(Blocks.STONE_SLAB, 6, BlockDoubleStepAbstract.EnumStoneSlabVariant.QUARTZ.getId()), "###", Character.valueOf('#'), Blocks.QUARTZ_BLOCK);
      this.registerShapedRecipe(new ItemStack(Blocks.STONE_SLAB2, 6, class_ajp.class_a_in_class_ajp.a.a()), "###", Character.valueOf('#'), Blocks.RED_SANDSTONE);
      this.registerShapedRecipe(new ItemStack(Blocks.PURPUR_SLAB, 6, 0), "###", Character.valueOf('#'), Blocks.PURPUR_BLOCK);
      this.registerShapedRecipe(new ItemStack(Blocks.WOODEN_SLAB, 6, 0), "###", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, BlockWood.EnumLogVariant.OAK.getId()));
      this.registerShapedRecipe(new ItemStack(Blocks.WOODEN_SLAB, 6, BlockWood.EnumLogVariant.BIRCH.getId()), "###", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, BlockWood.EnumLogVariant.BIRCH.getId()));
      this.registerShapedRecipe(new ItemStack(Blocks.WOODEN_SLAB, 6, BlockWood.EnumLogVariant.SPRUCE.getId()), "###", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, BlockWood.EnumLogVariant.SPRUCE.getId()));
      this.registerShapedRecipe(new ItemStack(Blocks.WOODEN_SLAB, 6, BlockWood.EnumLogVariant.JUNGLE.getId()), "###", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, BlockWood.EnumLogVariant.JUNGLE.getId()));
      this.registerShapedRecipe(new ItemStack(Blocks.WOODEN_SLAB, 6, 4 + BlockWood.EnumLogVariant.ACACIA.getId() - 4), "###", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, 4 + BlockWood.EnumLogVariant.ACACIA.getId() - 4));
      this.registerShapedRecipe(new ItemStack(Blocks.WOODEN_SLAB, 6, 4 + BlockWood.EnumLogVariant.DARK_OAK.getId() - 4), "###", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, 4 + BlockWood.EnumLogVariant.DARK_OAK.getId() - 4));
      this.registerShapedRecipe(new ItemStack(Blocks.LADDER, 3), "# #", "###", "# #", Character.valueOf('#'), Items.STICK);
      this.registerShapedRecipe(new ItemStack(Items.WOODEN_DOOR, 3), "##", "##", "##", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, BlockWood.EnumLogVariant.OAK.getId()));
      this.registerShapedRecipe(new ItemStack(Items.SPRUCE_DOOR, 3), "##", "##", "##", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, BlockWood.EnumLogVariant.SPRUCE.getId()));
      this.registerShapedRecipe(new ItemStack(Items.BIRCH_DOOR, 3), "##", "##", "##", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, BlockWood.EnumLogVariant.BIRCH.getId()));
      this.registerShapedRecipe(new ItemStack(Items.JUNGLE_DOOR, 3), "##", "##", "##", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, BlockWood.EnumLogVariant.JUNGLE.getId()));
      this.registerShapedRecipe(new ItemStack(Items.ACACIA_DOOR, 3), "##", "##", "##", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, BlockWood.EnumLogVariant.ACACIA.getId()));
      this.registerShapedRecipe(new ItemStack(Items.DARK_OAK_DOOR, 3), "##", "##", "##", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, BlockWood.EnumLogVariant.DARK_OAK.getId()));
      this.registerShapedRecipe(new ItemStack(Blocks.TRAPDOOR, 2), "###", "###", Character.valueOf('#'), Blocks.PLANKS);
      this.registerShapedRecipe(new ItemStack(Items.IRON_DOOR, 3), "##", "##", "##", Character.valueOf('#'), Items.IRON_INGOT);
      this.registerShapedRecipe(new ItemStack(Blocks.IRON_TRAPDOOR, 1), "##", "##", Character.valueOf('#'), Items.IRON_INGOT);
      this.registerShapedRecipe(new ItemStack(Items.SIGN, 3), "###", "###", " X ", Character.valueOf('#'), Blocks.PLANKS, Character.valueOf('X'), Items.STICK);
      this.registerShapedRecipe(new ItemStack(Items.CAKE, 1), "AAA", "BEB", "CCC", Character.valueOf('A'), Items.MILK_BUCKET, Character.valueOf('B'), Items.SUGAR, Character.valueOf('C'), Items.WHEAT, Character.valueOf('E'), Items.EGG);
      this.registerShapedRecipe(new ItemStack(Items.SUGAR, 1), "#", Character.valueOf('#'), Items.REEDS);
      this.registerShapedRecipe(new ItemStack(Blocks.PLANKS, 4, BlockWood.EnumLogVariant.OAK.getId()), "#", Character.valueOf('#'), new ItemStack(Blocks.LOG, 1, BlockWood.EnumLogVariant.OAK.getId()));
      this.registerShapedRecipe(new ItemStack(Blocks.PLANKS, 4, BlockWood.EnumLogVariant.SPRUCE.getId()), "#", Character.valueOf('#'), new ItemStack(Blocks.LOG, 1, BlockWood.EnumLogVariant.SPRUCE.getId()));
      this.registerShapedRecipe(new ItemStack(Blocks.PLANKS, 4, BlockWood.EnumLogVariant.BIRCH.getId()), "#", Character.valueOf('#'), new ItemStack(Blocks.LOG, 1, BlockWood.EnumLogVariant.BIRCH.getId()));
      this.registerShapedRecipe(new ItemStack(Blocks.PLANKS, 4, BlockWood.EnumLogVariant.JUNGLE.getId()), "#", Character.valueOf('#'), new ItemStack(Blocks.LOG, 1, BlockWood.EnumLogVariant.JUNGLE.getId()));
      this.registerShapedRecipe(new ItemStack(Blocks.PLANKS, 4, 4 + BlockWood.EnumLogVariant.ACACIA.getId() - 4), "#", Character.valueOf('#'), new ItemStack(Blocks.LOG2, 1, BlockWood.EnumLogVariant.ACACIA.getId() - 4));
      this.registerShapedRecipe(new ItemStack(Blocks.PLANKS, 4, 4 + BlockWood.EnumLogVariant.DARK_OAK.getId() - 4), "#", Character.valueOf('#'), new ItemStack(Blocks.LOG2, 1, BlockWood.EnumLogVariant.DARK_OAK.getId() - 4));
      this.registerShapedRecipe(new ItemStack(Items.STICK, 4), "#", "#", Character.valueOf('#'), Blocks.PLANKS);
      this.registerShapedRecipe(new ItemStack(Blocks.TORCH, 4), "X", "#", Character.valueOf('X'), Items.COAL, Character.valueOf('#'), Items.STICK);
      this.registerShapedRecipe(new ItemStack(Blocks.TORCH, 4), "X", "#", Character.valueOf('X'), new ItemStack(Items.COAL, 1, 1), Character.valueOf('#'), Items.STICK);
      this.registerShapedRecipe(new ItemStack(Items.BOWL, 4), "# #", " # ", Character.valueOf('#'), Blocks.PLANKS);
      this.registerShapedRecipe(new ItemStack(Items.GLASS_BOTTLE, 3), "# #", " # ", Character.valueOf('#'), Blocks.GLASS);
      this.registerShapedRecipe(new ItemStack(Blocks.RAIL, 16), "X X", "X#X", "X X", Character.valueOf('X'), Items.IRON_INGOT, Character.valueOf('#'), Items.STICK);
      this.registerShapedRecipe(new ItemStack(Blocks.GOLDEN_RAIL, 6), "X X", "X#X", "XRX", Character.valueOf('X'), Items.GOLD_INGOT, Character.valueOf('R'), Items.REDSTONE, Character.valueOf('#'), Items.STICK);
      this.registerShapedRecipe(new ItemStack(Blocks.ACTIVATOR_RAIL, 6), "XSX", "X#X", "XSX", Character.valueOf('X'), Items.IRON_INGOT, Character.valueOf('#'), Blocks.REDSTONE_TORCH, Character.valueOf('S'), Items.STICK);
      this.registerShapedRecipe(new ItemStack(Blocks.DETECTOR_RAIL, 6), "X X", "X#X", "XRX", Character.valueOf('X'), Items.IRON_INGOT, Character.valueOf('R'), Items.REDSTONE, Character.valueOf('#'), Blocks.STONE_PRESSURE_PLATE);
      this.registerShapedRecipe(new ItemStack(Items.MINECART, 1), "# #", "###", Character.valueOf('#'), Items.IRON_INGOT);
      this.registerShapedRecipe(new ItemStack(Items.CAULDRON, 1), "# #", "# #", "###", Character.valueOf('#'), Items.IRON_INGOT);
      this.registerShapedRecipe(new ItemStack(Items.BREWING_STAND, 1), " B ", "###", Character.valueOf('#'), Blocks.COBBLESTONE, Character.valueOf('B'), Items.BLAZE_ROD);
      this.registerShapedRecipe(new ItemStack(Blocks.LIT_PUMPKIN, 1), "A", "B", Character.valueOf('A'), Blocks.PUMPKIN, Character.valueOf('B'), Blocks.TORCH);
      this.registerShapedRecipe(new ItemStack(Items.CHEST_MINECART, 1), "A", "B", Character.valueOf('A'), Blocks.CHEST, Character.valueOf('B'), Items.MINECART);
      this.registerShapedRecipe(new ItemStack(Items.FURNACE_MINECART, 1), "A", "B", Character.valueOf('A'), Blocks.FURNACE, Character.valueOf('B'), Items.MINECART);
      this.registerShapedRecipe(new ItemStack(Items.TNT_MINECART, 1), "A", "B", Character.valueOf('A'), Blocks.TNT, Character.valueOf('B'), Items.MINECART);
      this.registerShapedRecipe(new ItemStack(Items.HOPPER_MINECART, 1), "A", "B", Character.valueOf('A'), Blocks.HOPPER, Character.valueOf('B'), Items.MINECART);
      this.registerShapedRecipe(new ItemStack(Items.BOAT, 1), "# #", "###", Character.valueOf('#'), Blocks.PLANKS);
      this.registerShapedRecipe(new ItemStack(Items.BUCKET, 1), "# #", " # ", Character.valueOf('#'), Items.IRON_INGOT);
      this.registerShapedRecipe(new ItemStack(Items.FLOWER_POT, 1), "# #", " # ", Character.valueOf('#'), Items.BRICK);
      this.registerShapelessRecipe(new ItemStack(Items.FLINT_AND_STEEL, 1), new ItemStack(Items.IRON_INGOT, 1), new ItemStack(Items.FLINT, 1));
      this.registerShapedRecipe(new ItemStack(Items.BREAD, 1), "###", Character.valueOf('#'), Items.WHEAT);
      this.registerShapedRecipe(new ItemStack(Blocks.OAK_STAIRS, 4), "#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, BlockWood.EnumLogVariant.OAK.getId()));
      this.registerShapedRecipe(new ItemStack(Blocks.BIRCH_STAIRS, 4), "#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, BlockWood.EnumLogVariant.BIRCH.getId()));
      this.registerShapedRecipe(new ItemStack(Blocks.SPRUCE_STAIRS, 4), "#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, BlockWood.EnumLogVariant.SPRUCE.getId()));
      this.registerShapedRecipe(new ItemStack(Blocks.JUNGKE_STAIRS, 4), "#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, BlockWood.EnumLogVariant.JUNGLE.getId()));
      this.registerShapedRecipe(new ItemStack(Blocks.ACACIA_STAIRS, 4), "#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, 4 + BlockWood.EnumLogVariant.ACACIA.getId() - 4));
      this.registerShapedRecipe(new ItemStack(Blocks.DARK_OAK_STAIRS, 4), "#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, 4 + BlockWood.EnumLogVariant.DARK_OAK.getId() - 4));
      this.registerShapedRecipe(new ItemStack(Items.FISHING_ROD, 1), "  #", " #X", "# X", Character.valueOf('#'), Items.STICK, Character.valueOf('X'), Items.STRING);
      this.registerShapedRecipe(new ItemStack(Items.CARROT_ON_A_STICK, 1), "# ", " X", Character.valueOf('#'), Items.FISHING_ROD, Character.valueOf('X'), Items.CARROT);
      this.registerShapedRecipe(new ItemStack(Blocks.STONE_STAIRS, 4), "#  ", "## ", "###", Character.valueOf('#'), Blocks.COBBLESTONE);
      this.registerShapedRecipe(new ItemStack(Blocks.BRICK_STAIRS, 4), "#  ", "## ", "###", Character.valueOf('#'), Blocks.BRICK_BLOCK);
      this.registerShapedRecipe(new ItemStack(Blocks.STONE_BRICK_STAIRS, 4), "#  ", "## ", "###", Character.valueOf('#'), Blocks.STONEBRICK);
      this.registerShapedRecipe(new ItemStack(Blocks.NETHER_BTICK_STAIRS, 4), "#  ", "## ", "###", Character.valueOf('#'), Blocks.NETHER_BRICK);
      this.registerShapedRecipe(new ItemStack(Blocks.SANDSTONE_STAIRS, 4), "#  ", "## ", "###", Character.valueOf('#'), Blocks.SANDSTONE);
      this.registerShapedRecipe(new ItemStack(Blocks.RED_SANDSTONE_STAIRS, 4), "#  ", "## ", "###", Character.valueOf('#'), Blocks.RED_SANDSTONE);
      this.registerShapedRecipe(new ItemStack(Blocks.QUARTZ_STAIRS, 4), "#  ", "## ", "###", Character.valueOf('#'), Blocks.QUARTZ_BLOCK);
      this.registerShapedRecipe(new ItemStack(Items.PAINTING, 1), "###", "#X#", "###", Character.valueOf('#'), Items.STICK, Character.valueOf('X'), Blocks.WOOL);
      this.registerShapedRecipe(new ItemStack(Items.ITEM_FRAME, 1), "###", "#X#", "###", Character.valueOf('#'), Items.STICK, Character.valueOf('X'), Items.LEATHER);
      this.registerShapedRecipe(new ItemStack(Items.GOLDEN_APPLE), "###", "#X#", "###", Character.valueOf('#'), Items.GOLD_INGOT, Character.valueOf('X'), Items.APPLE);
      this.registerShapedRecipe(new ItemStack(Items.GOLDEN_APPLE, 1, 1), "###", "#X#", "###", Character.valueOf('#'), Blocks.GOLD_BLOCK, Character.valueOf('X'), Items.APPLE);
      this.registerShapedRecipe(new ItemStack(Items.GOLDEN_CARROT), "###", "#X#", "###", Character.valueOf('#'), Items.GOLD_NUGGEST, Character.valueOf('X'), Items.CARROT);
      this.registerShapedRecipe(new ItemStack(Items.SPECKLED_MELON, 1), "###", "#X#", "###", Character.valueOf('#'), Items.GOLD_NUGGEST, Character.valueOf('X'), Items.MELON);
      this.registerShapedRecipe(new ItemStack(Blocks.LEVER, 1), "X", "#", Character.valueOf('#'), Blocks.COBBLESTONE, Character.valueOf('X'), Items.STICK);
      this.registerShapedRecipe(new ItemStack(Blocks.TRIPWIRE_HOOK, 2), "I", "S", "#", Character.valueOf('#'), Blocks.PLANKS, Character.valueOf('S'), Items.STICK, Character.valueOf('I'), Items.IRON_INGOT);
      this.registerShapedRecipe(new ItemStack(Blocks.REDSTONE_TORCH, 1), "X", "#", Character.valueOf('#'), Items.STICK, Character.valueOf('X'), Items.REDSTONE);
      this.registerShapedRecipe(new ItemStack(Items.REPEATER, 1), "#X#", "III", Character.valueOf('#'), Blocks.REDSTONE_TORCH, Character.valueOf('X'), Items.REDSTONE, Character.valueOf('I'), new ItemStack(Blocks.STONE, 1, BlockStone.EnumStoneVariant.STONE.getData()));
      this.registerShapedRecipe(new ItemStack(Items.COMPARATOR, 1), " # ", "#X#", "III", Character.valueOf('#'), Blocks.REDSTONE_TORCH, Character.valueOf('X'), Items.QUARTZ, Character.valueOf('I'), new ItemStack(Blocks.STONE, 1, BlockStone.EnumStoneVariant.STONE.getData()));
      this.registerShapedRecipe(new ItemStack(Items.CLOCK, 1), " # ", "#X#", " # ", Character.valueOf('#'), Items.GOLD_INGOT, Character.valueOf('X'), Items.REDSTONE);
      this.registerShapedRecipe(new ItemStack(Items.COMPASS, 1), " # ", "#X#", " # ", Character.valueOf('#'), Items.IRON_INGOT, Character.valueOf('X'), Items.REDSTONE);
      this.registerShapedRecipe(new ItemStack(Items.MAP, 1), "###", "#X#", "###", Character.valueOf('#'), Items.PAPER, Character.valueOf('X'), Items.COMPASS);
      this.registerShapedRecipe(new ItemStack(Blocks.STONE_BUTTON, 1), "#", Character.valueOf('#'), new ItemStack(Blocks.STONE, 1, BlockStone.EnumStoneVariant.STONE.getData()));
      this.registerShapedRecipe(new ItemStack(Blocks.WOODEN_BUTTON, 1), "#", Character.valueOf('#'), Blocks.PLANKS);
      this.registerShapedRecipe(new ItemStack(Blocks.STONE_PRESSURE_PLATE, 1), "##", Character.valueOf('#'), new ItemStack(Blocks.STONE, 1, BlockStone.EnumStoneVariant.STONE.getData()));
      this.registerShapedRecipe(new ItemStack(Blocks.WOODEN_PRESSURE_PLATE, 1), "##", Character.valueOf('#'), Blocks.PLANKS);
      this.registerShapedRecipe(new ItemStack(Blocks.HEAVY_W_PRESSURE_PLATE, 1), "##", Character.valueOf('#'), Items.IRON_INGOT);
      this.registerShapedRecipe(new ItemStack(Blocks.LIGHT_W_PRESSURE_PLATE, 1), "##", Character.valueOf('#'), Items.GOLD_INGOT);
      this.registerShapedRecipe(new ItemStack(Blocks.DISPENSER, 1), "###", "#X#", "#R#", Character.valueOf('#'), Blocks.COBBLESTONE, Character.valueOf('X'), Items.BOW, Character.valueOf('R'), Items.REDSTONE);
      this.registerShapedRecipe(new ItemStack(Blocks.DROPPER, 1), "###", "# #", "#R#", Character.valueOf('#'), Blocks.COBBLESTONE, Character.valueOf('R'), Items.REDSTONE);
      this.registerShapedRecipe(new ItemStack(Blocks.PISTON, 1), "TTT", "#X#", "#R#", Character.valueOf('#'), Blocks.COBBLESTONE, Character.valueOf('X'), Items.IRON_INGOT, Character.valueOf('R'), Items.REDSTONE, Character.valueOf('T'), Blocks.PLANKS);
      this.registerShapedRecipe(new ItemStack(Blocks.STICKY_PISTON, 1), "S", "P", Character.valueOf('S'), Items.SLIME_BALL, Character.valueOf('P'), Blocks.PISTON);
      this.registerShapedRecipe(new ItemStack(Items.BED, 1), "###", "XXX", Character.valueOf('#'), Blocks.WOOL, Character.valueOf('X'), Blocks.PLANKS);
      this.registerShapedRecipe(new ItemStack(Blocks.ENCHANTING_TABLE, 1), " B ", "D#D", "###", Character.valueOf('#'), Blocks.OBSIDIAN, Character.valueOf('B'), Items.BOOK, Character.valueOf('D'), Items.DIAMOND);
      this.registerShapedRecipe(new ItemStack(Blocks.ANVIL, 1), "III", " i ", "iii", Character.valueOf('I'), Blocks.IRON_BLOCK, Character.valueOf('i'), Items.IRON_INGOT);
      this.registerShapedRecipe(new ItemStack(Items.LEATHER), "##", "##", Character.valueOf('#'), Items.RABBIT_HIDE);
      this.registerShapelessRecipe(new ItemStack(Items.ENDER_EYE, 1), Items.ENDER_PEARL, Items.BLAZE_POWDER);
      this.registerShapelessRecipe(new ItemStack(Items.FIRE_CHARGE, 3), Items.GUNPOWDER, Items.BLAZE_POWDER, Items.COAL);
      this.registerShapelessRecipe(new ItemStack(Items.FIRE_CHARGE, 3), Items.GUNPOWDER, Items.BLAZE_POWDER, new ItemStack(Items.COAL, 1, 1));
      this.registerShapedRecipe(new ItemStack(Blocks.DAYLIGHT_DETECTOR), "GGG", "QQQ", "WWW", Character.valueOf('G'), Blocks.GLASS, Character.valueOf('Q'), Items.QUARTZ, Character.valueOf('W'), Blocks.WOODEN_SLAB);
      this.registerShapedRecipe(new ItemStack(Blocks.HOPPER), "I I", "ICI", " I ", Character.valueOf('I'), Items.IRON_INGOT, Character.valueOf('C'), Blocks.CHEST);
      this.registerShapedRecipe(new ItemStack(Items.ARMOR_STAND, 1), "///", " / ", "/_/", Character.valueOf('/'), Items.STICK, Character.valueOf('_'), new ItemStack(Blocks.STONE_SLAB, 1, BlockDoubleStepAbstract.EnumStoneSlabVariant.STONE.getId()));
      Collections.sort(this.b, new Comparator() {
         public int a(IRecipe var1, IRecipe var2) {
            return var1 instanceof class_acw && var2 instanceof class_acv?1:(var2 instanceof class_acw && var1 instanceof class_acv?-1:(var2.a() < var1.a()?-1:(var2.a() > var1.a()?1:0)));
         }

         // $FF: synthetic method
         public int compare(Object var1, Object var2) {
            return this.a((IRecipe)var1, (IRecipe)var2);
         }
      });
   }

   public class_acv registerShapedRecipe(ItemStack var1, Object... var2) {
      String var3 = "";
      int var4 = 0;
      int var5 = 0;
      int var6 = 0;
      if(var2[var4] instanceof String[]) {
         String[] var11 = (String[]) var2[var4++];

         for(int var8 = 0; var8 < var11.length; ++var8) {
            String var9 = var11[var8];
            ++var6;
            var5 = var9.length();
            var3 = var3 + var9;
         }
      } else {
         while(var2[var4] instanceof String) {
            String var7 = (String)var2[var4++];
            ++var6;
            var5 = var7.length();
            var3 = var3 + var7;
         }
      }

      HashMap var12;
      for(var12 = Maps.newHashMap(); var4 < var2.length; var4 += 2) {
         Character var13 = (Character)var2[var4];
         ItemStack var15 = null;
         if(var2[var4 + 1] instanceof Item) {
            var15 = new ItemStack((Item)var2[var4 + 1]);
         } else if(var2[var4 + 1] instanceof Block) {
            var15 = new ItemStack((Block)var2[var4 + 1], 1, 32767);
         } else if(var2[var4 + 1] instanceof ItemStack) {
            var15 = (ItemStack)var2[var4 + 1];
         }

         var12.put(var13, var15);
      }

      ItemStack[] var14 = new ItemStack[var5 * var6];

      for(int var16 = 0; var16 < var5 * var6; ++var16) {
         char var10 = var3.charAt(var16);
         if(var12.containsKey(Character.valueOf(var10))) {
            var14[var16] = ((ItemStack)var12.get(Character.valueOf(var10))).clone();
         } else {
            var14[var16] = null;
         }
      }

      class_acv var17 = new class_acv(var5, var6, var14, var1);
      this.b.add(var17);
      return var17;
   }

   public void registerShapelessRecipe(ItemStack var1, Object... var2) {
      ArrayList var3 = Lists.newArrayList();
      Object[] var4 = var2;
      int var5 = var2.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         Object var7 = var4[var6];
         if(var7 instanceof ItemStack) {
            var3.add(((ItemStack)var7).clone());
         } else if(var7 instanceof Item) {
            var3.add(new ItemStack((Item)var7));
         } else {
            if(!(var7 instanceof Block)) {
               throw new IllegalArgumentException("Invalid shapeless recipe: unknown type " + var7.getClass().getName() + "!");
            }

            var3.add(new ItemStack((Block)var7));
         }
      }

      this.b.add(new class_acw(var1, var3));
   }

   public void a(IRecipe var1) {
      this.b.add(var1);
   }

   public ItemStack craft(InventoryCrafting var1, World var2) {
      Iterator var3 = this.b.iterator();

      IRecipe var4;
      do {
         if(!var3.hasNext()) {
            return null;
         }

         var4 = (IRecipe)var3.next();
      } while(!var4.a(var1, var2));

      return var4.a(var1);
   }

   public ItemStack[] craft1(InventoryCrafting var1, World var2) {
      Iterator var3 = this.b.iterator();

      while(var3.hasNext()) {
         IRecipe var4 = (IRecipe)var3.next();
         if(var4.a(var1, var2)) {
            return var4.b(var1);
         }
      }

      ItemStack[] var5 = new ItemStack[var1.getSize()];

      for(int var6 = 0; var6 < var5.length; ++var6) {
         var5[var6] = var1.getItem(var6);
      }

      return var5;
   }

   public List getRecipes() {
      return this.b;
   }
}
