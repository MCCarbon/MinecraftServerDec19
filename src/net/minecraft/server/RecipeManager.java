package net.minecraft.server;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class RecipeManager {
   private static final RecipeManager a = new RecipeManager();
   private final List b = Lists.newArrayList();

   public static RecipeManager a() {
      return a;
   }

   private RecipeManager() {
      (new class_acy()).a(this);
      (new class_acz()).a(this);
      (new class_acr()).a(this);
      (new class_acn()).a(this);
      (new class_acx()).a(this);
      (new class_aci()).a(this);
      (new class_acl()).a(this);
      this.b.add(new class_ach());
      this.b.add(new class_ack());
      this.b.add(new class_acp());
      this.b.add(new class_acq());
      this.b.add(new class_acm());
      this.b.add(new class_acu());
      (new class_acj()).a(this);
      this.a(new ItemStack(Items.PAPER, 3), "###", Character.valueOf('#'), Items.REEDS);
      this.b(new ItemStack(Items.BOOK, 1), Items.PAPER, Items.PAPER, Items.PAPER, Items.LEATHER);
      this.b(new ItemStack(Items.WRITABLE_BOOK, 1), Items.BOOK, new ItemStack(Items.DYE, 1, EnumColor.p.b()), Items.FEATHER);
      this.a(new ItemStack(Blocks.FENCE, 3), "W#W", "W#W", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(Blocks.PLANKS, 1, BlockWood.EnumLogVariant.OAK.getId()));
      this.a(new ItemStack(Blocks.BIRCH_FENCE, 3), "W#W", "W#W", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(Blocks.PLANKS, 1, BlockWood.EnumLogVariant.BIRCH.getId()));
      this.a(new ItemStack(Blocks.SPRUCE_FENCE, 3), "W#W", "W#W", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(Blocks.PLANKS, 1, BlockWood.EnumLogVariant.SPRUCE.getId()));
      this.a(new ItemStack(Blocks.JUNGLE_FENCE, 3), "W#W", "W#W", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(Blocks.PLANKS, 1, BlockWood.EnumLogVariant.JUNGLE.getId()));
      this.a(new ItemStack(Blocks.ACACIA_FENCE, 3), "W#W", "W#W", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(Blocks.PLANKS, 1, 4 + BlockWood.EnumLogVariant.ACACIA.getId() - 4));
      this.a(new ItemStack(Blocks.DARK_OAK_FENCE, 3), "W#W", "W#W", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(Blocks.PLANKS, 1, 4 + BlockWood.EnumLogVariant.DARK_OAK.getId() - 4));
      this.a(new ItemStack(Blocks.COBBLESTONE_WALL, 6, BlockCobbleWall.class_a_in_class_alv.a.a()), "###", "###", Character.valueOf('#'), Blocks.COBBLESTONE);
      this.a(new ItemStack(Blocks.COBBLESTONE_WALL, 6, BlockCobbleWall.class_a_in_class_alv.b.a()), "###", "###", Character.valueOf('#'), Blocks.MOSSY_COBBLESTONE);
      this.a(new ItemStack(Blocks.NETHER_BRICK_FENCE, 6), "###", "###", Character.valueOf('#'), Blocks.NETHER_BRICK);
      this.a(new ItemStack(Blocks.FENCE_GATE, 1), "#W#", "#W#", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(Blocks.PLANKS, 1, BlockWood.EnumLogVariant.OAK.getId()));
      this.a(new ItemStack(Blocks.BIRCH_FENCE_GATE, 1), "#W#", "#W#", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(Blocks.PLANKS, 1, BlockWood.EnumLogVariant.BIRCH.getId()));
      this.a(new ItemStack(Blocks.SPRUCE_FENCE_GATE, 1), "#W#", "#W#", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(Blocks.PLANKS, 1, BlockWood.EnumLogVariant.SPRUCE.getId()));
      this.a(new ItemStack(Blocks.JUGLE_FENCE_GATE, 1), "#W#", "#W#", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(Blocks.PLANKS, 1, BlockWood.EnumLogVariant.JUNGLE.getId()));
      this.a(new ItemStack(Blocks.ACACIA_FENCE_GATE, 1), "#W#", "#W#", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(Blocks.PLANKS, 1, 4 + BlockWood.EnumLogVariant.ACACIA.getId() - 4));
      this.a(new ItemStack(Blocks.DARK_OAK_FENCE_GATE, 1), "#W#", "#W#", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(Blocks.PLANKS, 1, 4 + BlockWood.EnumLogVariant.DARK_OAK.getId() - 4));
      this.a(new ItemStack(Blocks.JUKEBOX, 1), "###", "#X#", "###", Character.valueOf('#'), Blocks.PLANKS, Character.valueOf('X'), Items.DIAMOND);
      this.a(new ItemStack(Items.LEAD, 2), "~~ ", "~O ", "  ~", Character.valueOf('~'), Items.STRING, Character.valueOf('O'), Items.SLIME_BALL);
      this.a(new ItemStack(Blocks.NOTEBLOCK, 1), "###", "#X#", "###", Character.valueOf('#'), Blocks.PLANKS, Character.valueOf('X'), Items.REDSTONE);
      this.a(new ItemStack(Blocks.BOOKSHELF, 1), "###", "XXX", "###", Character.valueOf('#'), Blocks.PLANKS, Character.valueOf('X'), Items.BOOK);
      this.a(new ItemStack(Blocks.SNOW, 1), "##", "##", Character.valueOf('#'), Items.SNOWBALL);
      this.a(new ItemStack(Blocks.SNOW_LAYER, 6), "###", Character.valueOf('#'), Blocks.SNOW);
      this.a(new ItemStack(Blocks.CLAY, 1), "##", "##", Character.valueOf('#'), Items.CLAY_BALL);
      this.a(new ItemStack(Blocks.BRICK_BLOCK, 1), "##", "##", Character.valueOf('#'), Items.BRICK);
      this.a(new ItemStack(Blocks.GLOWSTONE, 1), "##", "##", Character.valueOf('#'), Items.GLOWSTONE_DUST);
      this.a(new ItemStack(Blocks.QUARTZ_BLOCK, 1), "##", "##", Character.valueOf('#'), Items.QUARTZ);
      this.a(new ItemStack(Blocks.WOOL, 1), "##", "##", Character.valueOf('#'), Items.STRING);
      this.a(new ItemStack(Blocks.TNT, 1), "X#X", "#X#", "X#X", Character.valueOf('X'), Items.GUNPOWDER, Character.valueOf('#'), Blocks.SAND);
      this.a(new ItemStack(Blocks.STONE_SLAB, 6, BlockDoubleStepAbstract.EnumStoneSlabVariant.COBBLESTONE.getId()), "###", Character.valueOf('#'), Blocks.COBBLESTONE);
      this.a(new ItemStack(Blocks.STONE_SLAB, 6, BlockDoubleStepAbstract.EnumStoneSlabVariant.STONE.getId()), "###", Character.valueOf('#'), new ItemStack(Blocks.STONE, 1, BlockStone.EnumStoneVariant.STONE.getData()));
      this.a(new ItemStack(Blocks.STONE_SLAB, 6, BlockDoubleStepAbstract.EnumStoneSlabVariant.SAND.getId()), "###", Character.valueOf('#'), Blocks.SANDSTONE);
      this.a(new ItemStack(Blocks.STONE_SLAB, 6, BlockDoubleStepAbstract.EnumStoneSlabVariant.BRICK.getId()), "###", Character.valueOf('#'), Blocks.BRICK_BLOCK);
      this.a(new ItemStack(Blocks.STONE_SLAB, 6, BlockDoubleStepAbstract.EnumStoneSlabVariant.SMOOTHBRICK.getId()), "###", Character.valueOf('#'), Blocks.STONEBRICK);
      this.a(new ItemStack(Blocks.STONE_SLAB, 6, BlockDoubleStepAbstract.EnumStoneSlabVariant.NETHERBRICK.getId()), "###", Character.valueOf('#'), Blocks.NETHER_BRICK);
      this.a(new ItemStack(Blocks.STONE_SLAB, 6, BlockDoubleStepAbstract.EnumStoneSlabVariant.QUARTZ.getId()), "###", Character.valueOf('#'), Blocks.QUARTZ_BLOCK);
      this.a(new ItemStack(Blocks.STONE_SLAB2, 6, class_ajp.class_a_in_class_ajp.a.a()), "###", Character.valueOf('#'), Blocks.RED_SANDSTONE);
      this.a(new ItemStack(Blocks.PURPUR_SLAB, 6, 0), "###", Character.valueOf('#'), Blocks.PURPUR_BLOCK);
      this.a(new ItemStack(Blocks.WOODEN_SLAB, 6, 0), "###", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, BlockWood.EnumLogVariant.OAK.getId()));
      this.a(new ItemStack(Blocks.WOODEN_SLAB, 6, BlockWood.EnumLogVariant.BIRCH.getId()), "###", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, BlockWood.EnumLogVariant.BIRCH.getId()));
      this.a(new ItemStack(Blocks.WOODEN_SLAB, 6, BlockWood.EnumLogVariant.SPRUCE.getId()), "###", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, BlockWood.EnumLogVariant.SPRUCE.getId()));
      this.a(new ItemStack(Blocks.WOODEN_SLAB, 6, BlockWood.EnumLogVariant.JUNGLE.getId()), "###", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, BlockWood.EnumLogVariant.JUNGLE.getId()));
      this.a(new ItemStack(Blocks.WOODEN_SLAB, 6, 4 + BlockWood.EnumLogVariant.ACACIA.getId() - 4), "###", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, 4 + BlockWood.EnumLogVariant.ACACIA.getId() - 4));
      this.a(new ItemStack(Blocks.WOODEN_SLAB, 6, 4 + BlockWood.EnumLogVariant.DARK_OAK.getId() - 4), "###", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, 4 + BlockWood.EnumLogVariant.DARK_OAK.getId() - 4));
      this.a(new ItemStack(Blocks.LADDER, 3), "# #", "###", "# #", Character.valueOf('#'), Items.STICK);
      this.a(new ItemStack(Items.WOODEN_DOOR, 3), "##", "##", "##", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, BlockWood.EnumLogVariant.OAK.getId()));
      this.a(new ItemStack(Items.SPRUCE_DOOR, 3), "##", "##", "##", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, BlockWood.EnumLogVariant.SPRUCE.getId()));
      this.a(new ItemStack(Items.BIRCH_DOOR, 3), "##", "##", "##", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, BlockWood.EnumLogVariant.BIRCH.getId()));
      this.a(new ItemStack(Items.JUNGLE_DOOR, 3), "##", "##", "##", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, BlockWood.EnumLogVariant.JUNGLE.getId()));
      this.a(new ItemStack(Items.ACACIA_DOOR, 3), "##", "##", "##", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, BlockWood.EnumLogVariant.ACACIA.getId()));
      this.a(new ItemStack(Items.DARK_OAK_DOOR, 3), "##", "##", "##", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, BlockWood.EnumLogVariant.DARK_OAK.getId()));
      this.a(new ItemStack(Blocks.TRAPDOOR, 2), "###", "###", Character.valueOf('#'), Blocks.PLANKS);
      this.a(new ItemStack(Items.IRON_DOOR, 3), "##", "##", "##", Character.valueOf('#'), Items.IRON_INGOT);
      this.a(new ItemStack(Blocks.IRON_TRAPDOOR, 1), "##", "##", Character.valueOf('#'), Items.IRON_INGOT);
      this.a(new ItemStack(Items.SIGN, 3), "###", "###", " X ", Character.valueOf('#'), Blocks.PLANKS, Character.valueOf('X'), Items.STICK);
      this.a(new ItemStack(Items.CAKE, 1), "AAA", "BEB", "CCC", Character.valueOf('A'), Items.MILK_BUCKET, Character.valueOf('B'), Items.SUGAR, Character.valueOf('C'), Items.WHEAT, Character.valueOf('E'), Items.EGG);
      this.a(new ItemStack(Items.SUGAR, 1), "#", Character.valueOf('#'), Items.REEDS);
      this.a(new ItemStack(Blocks.PLANKS, 4, BlockWood.EnumLogVariant.OAK.getId()), "#", Character.valueOf('#'), new ItemStack(Blocks.LOG, 1, BlockWood.EnumLogVariant.OAK.getId()));
      this.a(new ItemStack(Blocks.PLANKS, 4, BlockWood.EnumLogVariant.SPRUCE.getId()), "#", Character.valueOf('#'), new ItemStack(Blocks.LOG, 1, BlockWood.EnumLogVariant.SPRUCE.getId()));
      this.a(new ItemStack(Blocks.PLANKS, 4, BlockWood.EnumLogVariant.BIRCH.getId()), "#", Character.valueOf('#'), new ItemStack(Blocks.LOG, 1, BlockWood.EnumLogVariant.BIRCH.getId()));
      this.a(new ItemStack(Blocks.PLANKS, 4, BlockWood.EnumLogVariant.JUNGLE.getId()), "#", Character.valueOf('#'), new ItemStack(Blocks.LOG, 1, BlockWood.EnumLogVariant.JUNGLE.getId()));
      this.a(new ItemStack(Blocks.PLANKS, 4, 4 + BlockWood.EnumLogVariant.ACACIA.getId() - 4), "#", Character.valueOf('#'), new ItemStack(Blocks.LOG2, 1, BlockWood.EnumLogVariant.ACACIA.getId() - 4));
      this.a(new ItemStack(Blocks.PLANKS, 4, 4 + BlockWood.EnumLogVariant.DARK_OAK.getId() - 4), "#", Character.valueOf('#'), new ItemStack(Blocks.LOG2, 1, BlockWood.EnumLogVariant.DARK_OAK.getId() - 4));
      this.a(new ItemStack(Items.STICK, 4), "#", "#", Character.valueOf('#'), Blocks.PLANKS);
      this.a(new ItemStack(Blocks.TORCH, 4), "X", "#", Character.valueOf('X'), Items.COAL, Character.valueOf('#'), Items.STICK);
      this.a(new ItemStack(Blocks.TORCH, 4), "X", "#", Character.valueOf('X'), new ItemStack(Items.COAL, 1, 1), Character.valueOf('#'), Items.STICK);
      this.a(new ItemStack(Items.BOWL, 4), "# #", " # ", Character.valueOf('#'), Blocks.PLANKS);
      this.a(new ItemStack(Items.GLASS_BOTTLE, 3), "# #", " # ", Character.valueOf('#'), Blocks.GLASS);
      this.a(new ItemStack(Blocks.RAIL, 16), "X X", "X#X", "X X", Character.valueOf('X'), Items.IRON_INGOT, Character.valueOf('#'), Items.STICK);
      this.a(new ItemStack(Blocks.GOLDEN_RAIL, 6), "X X", "X#X", "XRX", Character.valueOf('X'), Items.GOLD_INGOT, Character.valueOf('R'), Items.REDSTONE, Character.valueOf('#'), Items.STICK);
      this.a(new ItemStack(Blocks.ACTIVATOR_RAIL, 6), "XSX", "X#X", "XSX", Character.valueOf('X'), Items.IRON_INGOT, Character.valueOf('#'), Blocks.REDSTONE_TORCH, Character.valueOf('S'), Items.STICK);
      this.a(new ItemStack(Blocks.DETECTOR_RAIL, 6), "X X", "X#X", "XRX", Character.valueOf('X'), Items.IRON_INGOT, Character.valueOf('R'), Items.REDSTONE, Character.valueOf('#'), Blocks.STONE_PRESSURE_PLATE);
      this.a(new ItemStack(Items.MINECART, 1), "# #", "###", Character.valueOf('#'), Items.IRON_INGOT);
      this.a(new ItemStack(Items.CAULDRON, 1), "# #", "# #", "###", Character.valueOf('#'), Items.IRON_INGOT);
      this.a(new ItemStack(Items.BREWING_STAND, 1), " B ", "###", Character.valueOf('#'), Blocks.COBBLESTONE, Character.valueOf('B'), Items.BLAZE_ROD);
      this.a(new ItemStack(Blocks.LIT_PUMPKIN, 1), "A", "B", Character.valueOf('A'), Blocks.PUMPKIN, Character.valueOf('B'), Blocks.TORCH);
      this.a(new ItemStack(Items.CHEST_MINECART, 1), "A", "B", Character.valueOf('A'), Blocks.CHEST, Character.valueOf('B'), Items.MINECART);
      this.a(new ItemStack(Items.FURNACE_MINECART, 1), "A", "B", Character.valueOf('A'), Blocks.FURNACE, Character.valueOf('B'), Items.MINECART);
      this.a(new ItemStack(Items.TNT_MINECART, 1), "A", "B", Character.valueOf('A'), Blocks.TNT, Character.valueOf('B'), Items.MINECART);
      this.a(new ItemStack(Items.HOPPER_MINECART, 1), "A", "B", Character.valueOf('A'), Blocks.HOPPER, Character.valueOf('B'), Items.MINECART);
      this.a(new ItemStack(Items.BOAT, 1), "# #", "###", Character.valueOf('#'), Blocks.PLANKS);
      this.a(new ItemStack(Items.BUCKET, 1), "# #", " # ", Character.valueOf('#'), Items.IRON_INGOT);
      this.a(new ItemStack(Items.FLOWER_POT, 1), "# #", " # ", Character.valueOf('#'), Items.BRICK);
      this.b(new ItemStack(Items.FLINT_AND_STEEL, 1), new ItemStack(Items.IRON_INGOT, 1), new ItemStack(Items.FLINT, 1));
      this.a(new ItemStack(Items.BREAD, 1), "###", Character.valueOf('#'), Items.WHEAT);
      this.a(new ItemStack(Blocks.OAK_STAIRS, 4), "#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, BlockWood.EnumLogVariant.OAK.getId()));
      this.a(new ItemStack(Blocks.BIRCH_STAIRS, 4), "#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, BlockWood.EnumLogVariant.BIRCH.getId()));
      this.a(new ItemStack(Blocks.SPRUCE_STAIRS, 4), "#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, BlockWood.EnumLogVariant.SPRUCE.getId()));
      this.a(new ItemStack(Blocks.JUNGKE_STAIRS, 4), "#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, BlockWood.EnumLogVariant.JUNGLE.getId()));
      this.a(new ItemStack(Blocks.ACACIA_STAIRS, 4), "#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, 4 + BlockWood.EnumLogVariant.ACACIA.getId() - 4));
      this.a(new ItemStack(Blocks.DARK_OAK_STAIRS, 4), "#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, 4 + BlockWood.EnumLogVariant.DARK_OAK.getId() - 4));
      this.a(new ItemStack(Items.FISHING_ROD, 1), "  #", " #X", "# X", Character.valueOf('#'), Items.STICK, Character.valueOf('X'), Items.STRING);
      this.a(new ItemStack(Items.CARROT_ON_A_STICK, 1), "# ", " X", Character.valueOf('#'), Items.FISHING_ROD, Character.valueOf('X'), Items.CARROT);
      this.a(new ItemStack(Blocks.STONE_STAIRS, 4), "#  ", "## ", "###", Character.valueOf('#'), Blocks.COBBLESTONE);
      this.a(new ItemStack(Blocks.BRICK_STAIRS, 4), "#  ", "## ", "###", Character.valueOf('#'), Blocks.BRICK_BLOCK);
      this.a(new ItemStack(Blocks.STONE_BRICK_STAIRS, 4), "#  ", "## ", "###", Character.valueOf('#'), Blocks.STONEBRICK);
      this.a(new ItemStack(Blocks.NETHER_BTICK_STAIRS, 4), "#  ", "## ", "###", Character.valueOf('#'), Blocks.NETHER_BRICK);
      this.a(new ItemStack(Blocks.SANDSTONE_STAIRS, 4), "#  ", "## ", "###", Character.valueOf('#'), Blocks.SANDSTONE);
      this.a(new ItemStack(Blocks.RED_SANDSTONE_STAIRS, 4), "#  ", "## ", "###", Character.valueOf('#'), Blocks.RED_SANDSTONE);
      this.a(new ItemStack(Blocks.QUARTZ_STAIRS, 4), "#  ", "## ", "###", Character.valueOf('#'), Blocks.QUARTZ_BLOCK);
      this.a(new ItemStack(Items.PAINTING, 1), "###", "#X#", "###", Character.valueOf('#'), Items.STICK, Character.valueOf('X'), Blocks.WOOL);
      this.a(new ItemStack(Items.ITEM_FRAME, 1), "###", "#X#", "###", Character.valueOf('#'), Items.STICK, Character.valueOf('X'), Items.LEATHER);
      this.a(new ItemStack(Items.GOLDEN_APPLE), "###", "#X#", "###", Character.valueOf('#'), Items.GOLD_INGOT, Character.valueOf('X'), Items.APPLE);
      this.a(new ItemStack(Items.GOLDEN_APPLE, 1, 1), "###", "#X#", "###", Character.valueOf('#'), Blocks.GOLD_BLOCK, Character.valueOf('X'), Items.APPLE);
      this.a(new ItemStack(Items.GOLDEN_CARROT), "###", "#X#", "###", Character.valueOf('#'), Items.GOLD_NUGGEST, Character.valueOf('X'), Items.CARROT);
      this.a(new ItemStack(Items.SPECKLED_MELON, 1), "###", "#X#", "###", Character.valueOf('#'), Items.GOLD_NUGGEST, Character.valueOf('X'), Items.MELON);
      this.a(new ItemStack(Blocks.LEVER, 1), "X", "#", Character.valueOf('#'), Blocks.COBBLESTONE, Character.valueOf('X'), Items.STICK);
      this.a(new ItemStack(Blocks.TRIPWIRE_HOOK, 2), "I", "S", "#", Character.valueOf('#'), Blocks.PLANKS, Character.valueOf('S'), Items.STICK, Character.valueOf('I'), Items.IRON_INGOT);
      this.a(new ItemStack(Blocks.REDSTONE_TORCH, 1), "X", "#", Character.valueOf('#'), Items.STICK, Character.valueOf('X'), Items.REDSTONE);
      this.a(new ItemStack(Items.REPEATER, 1), "#X#", "III", Character.valueOf('#'), Blocks.REDSTONE_TORCH, Character.valueOf('X'), Items.REDSTONE, Character.valueOf('I'), new ItemStack(Blocks.STONE, 1, BlockStone.EnumStoneVariant.STONE.getData()));
      this.a(new ItemStack(Items.COMPARATOR, 1), " # ", "#X#", "III", Character.valueOf('#'), Blocks.REDSTONE_TORCH, Character.valueOf('X'), Items.QUARTZ, Character.valueOf('I'), new ItemStack(Blocks.STONE, 1, BlockStone.EnumStoneVariant.STONE.getData()));
      this.a(new ItemStack(Items.CLOCK, 1), " # ", "#X#", " # ", Character.valueOf('#'), Items.GOLD_INGOT, Character.valueOf('X'), Items.REDSTONE);
      this.a(new ItemStack(Items.COMPASS, 1), " # ", "#X#", " # ", Character.valueOf('#'), Items.IRON_INGOT, Character.valueOf('X'), Items.REDSTONE);
      this.a(new ItemStack(Items.MAP, 1), "###", "#X#", "###", Character.valueOf('#'), Items.PAPER, Character.valueOf('X'), Items.COMPASS);
      this.a(new ItemStack(Blocks.STONE_BUTTON, 1), "#", Character.valueOf('#'), new ItemStack(Blocks.STONE, 1, BlockStone.EnumStoneVariant.STONE.getData()));
      this.a(new ItemStack(Blocks.WOODEN_BUTTON, 1), "#", Character.valueOf('#'), Blocks.PLANKS);
      this.a(new ItemStack(Blocks.STONE_PRESSURE_PLATE, 1), "##", Character.valueOf('#'), new ItemStack(Blocks.STONE, 1, BlockStone.EnumStoneVariant.STONE.getData()));
      this.a(new ItemStack(Blocks.WOODEN_PRESSURE_PLATE, 1), "##", Character.valueOf('#'), Blocks.PLANKS);
      this.a(new ItemStack(Blocks.HEAVY_W_PRESSURE_PLATE, 1), "##", Character.valueOf('#'), Items.IRON_INGOT);
      this.a(new ItemStack(Blocks.LIGHT_W_PRESSURE_PLATE, 1), "##", Character.valueOf('#'), Items.GOLD_INGOT);
      this.a(new ItemStack(Blocks.DISPENSER, 1), "###", "#X#", "#R#", Character.valueOf('#'), Blocks.COBBLESTONE, Character.valueOf('X'), Items.BOW, Character.valueOf('R'), Items.REDSTONE);
      this.a(new ItemStack(Blocks.DROPPER, 1), "###", "# #", "#R#", Character.valueOf('#'), Blocks.COBBLESTONE, Character.valueOf('R'), Items.REDSTONE);
      this.a(new ItemStack(Blocks.PISTON, 1), "TTT", "#X#", "#R#", Character.valueOf('#'), Blocks.COBBLESTONE, Character.valueOf('X'), Items.IRON_INGOT, Character.valueOf('R'), Items.REDSTONE, Character.valueOf('T'), Blocks.PLANKS);
      this.a(new ItemStack(Blocks.STICKY_PISTON, 1), "S", "P", Character.valueOf('S'), Items.SLIME_BALL, Character.valueOf('P'), Blocks.PISTON);
      this.a(new ItemStack(Items.BED, 1), "###", "XXX", Character.valueOf('#'), Blocks.WOOL, Character.valueOf('X'), Blocks.PLANKS);
      this.a(new ItemStack(Blocks.ENCHANTING_TABLE, 1), " B ", "D#D", "###", Character.valueOf('#'), Blocks.OBSIDIAN, Character.valueOf('B'), Items.BOOK, Character.valueOf('D'), Items.DIAMOND);
      this.a(new ItemStack(Blocks.ANVIL, 1), "III", " i ", "iii", Character.valueOf('I'), Blocks.IRON_BLOCK, Character.valueOf('i'), Items.IRON_INGOT);
      this.a(new ItemStack(Items.LEATHER), "##", "##", Character.valueOf('#'), Items.RABBIT_HIDE);
      this.b(new ItemStack(Items.ENDER_EYE, 1), Items.ENDER_PEARL, Items.BLAZE_POWDER);
      this.b(new ItemStack(Items.FIRE_CHARGE, 3), Items.GUNPOWDER, Items.BLAZE_POWDER, Items.COAL);
      this.b(new ItemStack(Items.FIRE_CHARGE, 3), Items.GUNPOWDER, Items.BLAZE_POWDER, new ItemStack(Items.COAL, 1, 1));
      this.a(new ItemStack(Blocks.DAYLIGHT_DETECTOR), "GGG", "QQQ", "WWW", Character.valueOf('G'), Blocks.GLASS, Character.valueOf('Q'), Items.QUARTZ, Character.valueOf('W'), Blocks.WOODEN_SLAB);
      this.a(new ItemStack(Blocks.HOPPER), "I I", "ICI", " I ", Character.valueOf('I'), Items.IRON_INGOT, Character.valueOf('C'), Blocks.CHEST);
      this.a(new ItemStack(Items.ARMOR_STAND, 1), "///", " / ", "/_/", Character.valueOf('/'), Items.STICK, Character.valueOf('_'), new ItemStack(Blocks.STONE_SLAB, 1, BlockDoubleStepAbstract.EnumStoneSlabVariant.STONE.getId()));
      Collections.sort(this.b, new Comparator() {
         public int a(class_acs var1, class_acs var2) {
            return var1 instanceof class_acw && var2 instanceof class_acv?1:(var2 instanceof class_acw && var1 instanceof class_acv?-1:(var2.a() < var1.a()?-1:(var2.a() > var1.a()?1:0)));
         }

         // $FF: synthetic method
         public int compare(Object var1, Object var2) {
            return this.a((class_acs)var1, (class_acs)var2);
         }
      });
   }

   public class_acv a(ItemStack var1, Object... var2) {
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

   public void b(ItemStack var1, Object... var2) {
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

   public void a(class_acs var1) {
      this.b.add(var1);
   }

   public ItemStack a(class_yg var1, World var2) {
      Iterator var3 = this.b.iterator();

      class_acs var4;
      do {
         if(!var3.hasNext()) {
            return null;
         }

         var4 = (class_acs)var3.next();
      } while(!var4.a(var1, var2));

      return var4.a(var1);
   }

   public ItemStack[] b(class_yg var1, World var2) {
      Iterator var3 = this.b.iterator();

      while(var3.hasNext()) {
         class_acs var4 = (class_acs)var3.next();
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

   public List b() {
      return this.b;
   }
}
