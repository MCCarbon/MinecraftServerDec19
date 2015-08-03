package net.minecraft.server;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Items;
import net.minecraft.server.class_ach;
import net.minecraft.server.class_aci;
import net.minecraft.server.class_acj;
import net.minecraft.server.class_ack;
import net.minecraft.server.class_acl;
import net.minecraft.server.class_acm;
import net.minecraft.server.class_acn;
import net.minecraft.server.class_acp;
import net.minecraft.server.class_acq;
import net.minecraft.server.class_acr;
import net.minecraft.server.class_acs;
import net.minecraft.server.class_acu;
import net.minecraft.server.class_acv;
import net.minecraft.server.class_acw;
import net.minecraft.server.class_acx;
import net.minecraft.server.class_acy;
import net.minecraft.server.class_acz;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.BlockStainedGlassPane;
import net.minecraft.server.class_ajp;
import net.minecraft.server.BlockWood;
import net.minecraft.server.BlockStone;
import net.minecraft.server.BlockDoubleStepAbstract;
import net.minecraft.server.class_alv;
import net.minecraft.server.class_yg;
import net.minecraft.server.EnumColor;

public class class_act {
   private static final class_act a = new class_act();
   private final List b = Lists.newArrayList();

   public static class_act a() {
      return a;
   }

   private class_act() {
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
      this.a(new ItemStack(Items.aM, 3), new Object[]{"###", Character.valueOf('#'), Items.aL});
      this.b(new ItemStack(Items.aN, 1), new Object[]{Items.aM, Items.aM, Items.aM, Items.aH});
      this.b(new ItemStack(Items.bP, 1), new Object[]{Items.aN, new ItemStack(Items.aY, 1, EnumColor.p.b()), Items.I});
      this.a(new ItemStack(BlockStainedGlassPane.FENCE, 3), new Object[]{"W#W", "W#W", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(BlockStainedGlassPane.PLANKS, 1, BlockWood.EnumLogVariant.OAK.getId())});
      this.a(new ItemStack(BlockStainedGlassPane.BIRCH_FENCE, 3), new Object[]{"W#W", "W#W", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(BlockStainedGlassPane.PLANKS, 1, BlockWood.EnumLogVariant.BIRCH.getId())});
      this.a(new ItemStack(BlockStainedGlassPane.SPRUCE_FENCE, 3), new Object[]{"W#W", "W#W", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(BlockStainedGlassPane.PLANKS, 1, BlockWood.EnumLogVariant.SPRUCE.getId())});
      this.a(new ItemStack(BlockStainedGlassPane.JUNGLE_FENCE, 3), new Object[]{"W#W", "W#W", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(BlockStainedGlassPane.PLANKS, 1, BlockWood.EnumLogVariant.JUNGLE.getId())});
      this.a(new ItemStack(BlockStainedGlassPane.ACACIA_FENCE, 3), new Object[]{"W#W", "W#W", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(BlockStainedGlassPane.PLANKS, 1, 4 + BlockWood.EnumLogVariant.ACACIA.getId() - 4)});
      this.a(new ItemStack(BlockStainedGlassPane.DARK_OAK_FENCE, 3), new Object[]{"W#W", "W#W", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(BlockStainedGlassPane.PLANKS, 1, 4 + BlockWood.EnumLogVariant.DARK_OAK.getId() - 4)});
      this.a(new ItemStack(BlockStainedGlassPane.COBBLESTONE_WALL, 6, class_alv.class_a_in_class_alv.a.a()), new Object[]{"###", "###", Character.valueOf('#'), BlockStainedGlassPane.COBBLESTONE});
      this.a(new ItemStack(BlockStainedGlassPane.COBBLESTONE_WALL, 6, class_alv.class_a_in_class_alv.b.a()), new Object[]{"###", "###", Character.valueOf('#'), BlockStainedGlassPane.MOSSY_COBBLESTONE});
      this.a(new ItemStack(BlockStainedGlassPane.NETHER_BRICK_FENCE, 6), new Object[]{"###", "###", Character.valueOf('#'), BlockStainedGlassPane.NETHER_BRICK});
      this.a(new ItemStack(BlockStainedGlassPane.FENCE_GATE, 1), new Object[]{"#W#", "#W#", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(BlockStainedGlassPane.PLANKS, 1, BlockWood.EnumLogVariant.OAK.getId())});
      this.a(new ItemStack(BlockStainedGlassPane.BIRCH_FENCE_GATE, 1), new Object[]{"#W#", "#W#", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(BlockStainedGlassPane.PLANKS, 1, BlockWood.EnumLogVariant.BIRCH.getId())});
      this.a(new ItemStack(BlockStainedGlassPane.SPRUCE_FENCE_GATE, 1), new Object[]{"#W#", "#W#", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(BlockStainedGlassPane.PLANKS, 1, BlockWood.EnumLogVariant.SPRUCE.getId())});
      this.a(new ItemStack(BlockStainedGlassPane.JUGLE_FENCE_GATE, 1), new Object[]{"#W#", "#W#", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(BlockStainedGlassPane.PLANKS, 1, BlockWood.EnumLogVariant.JUNGLE.getId())});
      this.a(new ItemStack(BlockStainedGlassPane.ACACIA_FENCE_GATE, 1), new Object[]{"#W#", "#W#", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(BlockStainedGlassPane.PLANKS, 1, 4 + BlockWood.EnumLogVariant.ACACIA.getId() - 4)});
      this.a(new ItemStack(BlockStainedGlassPane.DARK_OAK_FENCE_GATE, 1), new Object[]{"#W#", "#W#", Character.valueOf('#'), Items.STICK, Character.valueOf('W'), new ItemStack(BlockStainedGlassPane.PLANKS, 1, 4 + BlockWood.EnumLogVariant.DARK_OAK.getId() - 4)});
      this.a(new ItemStack(BlockStainedGlassPane.JUKEBOX, 1), new Object[]{"###", "#X#", "###", Character.valueOf('#'), BlockStainedGlassPane.PLANKS, Character.valueOf('X'), Items.DIAMOND});
      this.a(new ItemStack(Items.cq, 2), new Object[]{"~~ ", "~O ", "  ~", Character.valueOf('~'), Items.H, Character.valueOf('O'), Items.aO});
      this.a(new ItemStack(BlockStainedGlassPane.NOTEBLOCK, 1), new Object[]{"###", "#X#", "###", Character.valueOf('#'), BlockStainedGlassPane.PLANKS, Character.valueOf('X'), Items.aE});
      this.a(new ItemStack(BlockStainedGlassPane.BOOKSHELF, 1), new Object[]{"###", "XXX", "###", Character.valueOf('#'), BlockStainedGlassPane.PLANKS, Character.valueOf('X'), Items.aN});
      this.a(new ItemStack(BlockStainedGlassPane.SNOW, 1), new Object[]{"##", "##", Character.valueOf('#'), Items.aF});
      this.a(new ItemStack(BlockStainedGlassPane.SNOW_LAYER, 6), new Object[]{"###", Character.valueOf('#'), BlockStainedGlassPane.SNOW});
      this.a(new ItemStack(BlockStainedGlassPane.CLAY, 1), new Object[]{"##", "##", Character.valueOf('#'), Items.aK});
      this.a(new ItemStack(BlockStainedGlassPane.BRICK_BLOCK, 1), new Object[]{"##", "##", Character.valueOf('#'), Items.aJ});
      this.a(new ItemStack(BlockStainedGlassPane.GLOWSTONE, 1), new Object[]{"##", "##", Character.valueOf('#'), Items.aV});
      this.a(new ItemStack(BlockStainedGlassPane.QUARTZ_BLOCK, 1), new Object[]{"##", "##", Character.valueOf('#'), Items.cj});
      this.a(new ItemStack(BlockStainedGlassPane.WOOL, 1), new Object[]{"##", "##", Character.valueOf('#'), Items.H});
      this.a(new ItemStack(BlockStainedGlassPane.TNT, 1), new Object[]{"X#X", "#X#", "X#X", Character.valueOf('X'), Items.J, Character.valueOf('#'), BlockStainedGlassPane.SAND});
      this.a(new ItemStack(BlockStainedGlassPane.STONE_SLAB, 6, BlockDoubleStepAbstract.EnumStoneSlabVariant.COBBLESTONE.getId()), new Object[]{"###", Character.valueOf('#'), BlockStainedGlassPane.COBBLESTONE});
      this.a(new ItemStack(BlockStainedGlassPane.STONE_SLAB, 6, BlockDoubleStepAbstract.EnumStoneSlabVariant.STONE.getId()), new Object[]{"###", Character.valueOf('#'), new ItemStack(BlockStainedGlassPane.STONE, 1, BlockStone.EnumStoneVariant.STONE.getData())});
      this.a(new ItemStack(BlockStainedGlassPane.STONE_SLAB, 6, BlockDoubleStepAbstract.EnumStoneSlabVariant.SAND.getId()), new Object[]{"###", Character.valueOf('#'), BlockStainedGlassPane.SANDSTONE});
      this.a(new ItemStack(BlockStainedGlassPane.STONE_SLAB, 6, BlockDoubleStepAbstract.EnumStoneSlabVariant.BRICK.getId()), new Object[]{"###", Character.valueOf('#'), BlockStainedGlassPane.BRICK_BLOCK});
      this.a(new ItemStack(BlockStainedGlassPane.STONE_SLAB, 6, BlockDoubleStepAbstract.EnumStoneSlabVariant.SMOOTHBRICK.getId()), new Object[]{"###", Character.valueOf('#'), BlockStainedGlassPane.STONEBRICK});
      this.a(new ItemStack(BlockStainedGlassPane.STONE_SLAB, 6, BlockDoubleStepAbstract.EnumStoneSlabVariant.NETHERBRICK.getId()), new Object[]{"###", Character.valueOf('#'), BlockStainedGlassPane.NETHER_BRICK});
      this.a(new ItemStack(BlockStainedGlassPane.STONE_SLAB, 6, BlockDoubleStepAbstract.EnumStoneSlabVariant.QUARTZ.getId()), new Object[]{"###", Character.valueOf('#'), BlockStainedGlassPane.QUARTZ_BLOCK});
      this.a(new ItemStack(BlockStainedGlassPane.STONE_SLAB2, 6, class_ajp.class_a_in_class_ajp.a.a()), new Object[]{"###", Character.valueOf('#'), BlockStainedGlassPane.RED_SANDSTONE});
      this.a(new ItemStack(BlockStainedGlassPane.PURPUR_SLAB, 6, 0), new Object[]{"###", Character.valueOf('#'), BlockStainedGlassPane.PURPUR_BLOCK});
      this.a(new ItemStack(BlockStainedGlassPane.WOODEN_SLAB, 6, 0), new Object[]{"###", Character.valueOf('#'), new ItemStack(BlockStainedGlassPane.PLANKS, 1, BlockWood.EnumLogVariant.OAK.getId())});
      this.a(new ItemStack(BlockStainedGlassPane.WOODEN_SLAB, 6, BlockWood.EnumLogVariant.BIRCH.getId()), new Object[]{"###", Character.valueOf('#'), new ItemStack(BlockStainedGlassPane.PLANKS, 1, BlockWood.EnumLogVariant.BIRCH.getId())});
      this.a(new ItemStack(BlockStainedGlassPane.WOODEN_SLAB, 6, BlockWood.EnumLogVariant.SPRUCE.getId()), new Object[]{"###", Character.valueOf('#'), new ItemStack(BlockStainedGlassPane.PLANKS, 1, BlockWood.EnumLogVariant.SPRUCE.getId())});
      this.a(new ItemStack(BlockStainedGlassPane.WOODEN_SLAB, 6, BlockWood.EnumLogVariant.JUNGLE.getId()), new Object[]{"###", Character.valueOf('#'), new ItemStack(BlockStainedGlassPane.PLANKS, 1, BlockWood.EnumLogVariant.JUNGLE.getId())});
      this.a(new ItemStack(BlockStainedGlassPane.WOODEN_SLAB, 6, 4 + BlockWood.EnumLogVariant.ACACIA.getId() - 4), new Object[]{"###", Character.valueOf('#'), new ItemStack(BlockStainedGlassPane.PLANKS, 1, 4 + BlockWood.EnumLogVariant.ACACIA.getId() - 4)});
      this.a(new ItemStack(BlockStainedGlassPane.WOODEN_SLAB, 6, 4 + BlockWood.EnumLogVariant.DARK_OAK.getId() - 4), new Object[]{"###", Character.valueOf('#'), new ItemStack(BlockStainedGlassPane.PLANKS, 1, 4 + BlockWood.EnumLogVariant.DARK_OAK.getId() - 4)});
      this.a(new ItemStack(BlockStainedGlassPane.LADDER, 3), new Object[]{"# #", "###", "# #", Character.valueOf('#'), Items.STICK});
      this.a(new ItemStack(Items.as, 3), new Object[]{"##", "##", "##", Character.valueOf('#'), new ItemStack(BlockStainedGlassPane.PLANKS, 1, BlockWood.EnumLogVariant.OAK.getId())});
      this.a(new ItemStack(Items.at, 3), new Object[]{"##", "##", "##", Character.valueOf('#'), new ItemStack(BlockStainedGlassPane.PLANKS, 1, BlockWood.EnumLogVariant.SPRUCE.getId())});
      this.a(new ItemStack(Items.au, 3), new Object[]{"##", "##", "##", Character.valueOf('#'), new ItemStack(BlockStainedGlassPane.PLANKS, 1, BlockWood.EnumLogVariant.BIRCH.getId())});
      this.a(new ItemStack(Items.av, 3), new Object[]{"##", "##", "##", Character.valueOf('#'), new ItemStack(BlockStainedGlassPane.PLANKS, 1, BlockWood.EnumLogVariant.JUNGLE.getId())});
      this.a(new ItemStack(Items.aw, 3), new Object[]{"##", "##", "##", Character.valueOf('#'), new ItemStack(BlockStainedGlassPane.PLANKS, 1, BlockWood.EnumLogVariant.ACACIA.getId())});
      this.a(new ItemStack(Items.ax, 3), new Object[]{"##", "##", "##", Character.valueOf('#'), new ItemStack(BlockStainedGlassPane.PLANKS, 1, BlockWood.EnumLogVariant.DARK_OAK.getId())});
      this.a(new ItemStack(BlockStainedGlassPane.TRAPDOOR, 2), new Object[]{"###", "###", Character.valueOf('#'), BlockStainedGlassPane.PLANKS});
      this.a(new ItemStack(Items.aD, 3), new Object[]{"##", "##", "##", Character.valueOf('#'), Items.IRON_INGOT});
      this.a(new ItemStack(BlockStainedGlassPane.IRON_TRAPDOOR, 1), new Object[]{"##", "##", Character.valueOf('#'), Items.IRON_INGOT});
      this.a(new ItemStack(Items.ar, 3), new Object[]{"###", "###", " X ", Character.valueOf('#'), BlockStainedGlassPane.PLANKS, Character.valueOf('X'), Items.STICK});
      this.a(new ItemStack(Items.bb, 1), new Object[]{"AAA", "BEB", "CCC", Character.valueOf('A'), Items.aI, Character.valueOf('B'), Items.ba, Character.valueOf('C'), Items.Q, Character.valueOf('E'), Items.aR});
      this.a(new ItemStack(Items.ba, 1), new Object[]{"#", Character.valueOf('#'), Items.aL});
      this.a(new ItemStack(BlockStainedGlassPane.PLANKS, 4, BlockWood.EnumLogVariant.OAK.getId()), new Object[]{"#", Character.valueOf('#'), new ItemStack(BlockStainedGlassPane.LOG, 1, BlockWood.EnumLogVariant.OAK.getId())});
      this.a(new ItemStack(BlockStainedGlassPane.PLANKS, 4, BlockWood.EnumLogVariant.SPRUCE.getId()), new Object[]{"#", Character.valueOf('#'), new ItemStack(BlockStainedGlassPane.LOG, 1, BlockWood.EnumLogVariant.SPRUCE.getId())});
      this.a(new ItemStack(BlockStainedGlassPane.PLANKS, 4, BlockWood.EnumLogVariant.BIRCH.getId()), new Object[]{"#", Character.valueOf('#'), new ItemStack(BlockStainedGlassPane.LOG, 1, BlockWood.EnumLogVariant.BIRCH.getId())});
      this.a(new ItemStack(BlockStainedGlassPane.PLANKS, 4, BlockWood.EnumLogVariant.JUNGLE.getId()), new Object[]{"#", Character.valueOf('#'), new ItemStack(BlockStainedGlassPane.LOG, 1, BlockWood.EnumLogVariant.JUNGLE.getId())});
      this.a(new ItemStack(BlockStainedGlassPane.PLANKS, 4, 4 + BlockWood.EnumLogVariant.ACACIA.getId() - 4), new Object[]{"#", Character.valueOf('#'), new ItemStack(BlockStainedGlassPane.LOG2, 1, BlockWood.EnumLogVariant.ACACIA.getId() - 4)});
      this.a(new ItemStack(BlockStainedGlassPane.PLANKS, 4, 4 + BlockWood.EnumLogVariant.DARK_OAK.getId() - 4), new Object[]{"#", Character.valueOf('#'), new ItemStack(BlockStainedGlassPane.LOG2, 1, BlockWood.EnumLogVariant.DARK_OAK.getId() - 4)});
      this.a(new ItemStack(Items.STICK, 4), new Object[]{"#", "#", Character.valueOf('#'), BlockStainedGlassPane.PLANKS});
      this.a(new ItemStack(BlockStainedGlassPane.TORCH, 4), new Object[]{"X", "#", Character.valueOf('X'), Items.COAL, Character.valueOf('#'), Items.STICK});
      this.a(new ItemStack(BlockStainedGlassPane.TORCH, 4), new Object[]{"X", "#", Character.valueOf('X'), new ItemStack(Items.COAL, 1, 1), Character.valueOf('#'), Items.STICK});
      this.a(new ItemStack(Items.BOWL, 4), new Object[]{"# #", " # ", Character.valueOf('#'), BlockStainedGlassPane.PLANKS});
      this.a(new ItemStack(Items.bD, 3), new Object[]{"# #", " # ", Character.valueOf('#'), BlockStainedGlassPane.GLASS});
      this.a(new ItemStack(BlockStainedGlassPane.RAIL, 16), new Object[]{"X X", "X#X", "X X", Character.valueOf('X'), Items.IRON_INGOT, Character.valueOf('#'), Items.STICK});
      this.a(new ItemStack(BlockStainedGlassPane.GOLDEN_RAIL, 6), new Object[]{"X X", "X#X", "XRX", Character.valueOf('X'), Items.GOLD_INGOT, Character.valueOf('R'), Items.aE, Character.valueOf('#'), Items.STICK});
      this.a(new ItemStack(BlockStainedGlassPane.ACTIVATOR_RAIL, 6), new Object[]{"XSX", "X#X", "XSX", Character.valueOf('X'), Items.IRON_INGOT, Character.valueOf('#'), BlockStainedGlassPane.REDSTONE_TORCH, Character.valueOf('S'), Items.STICK});
      this.a(new ItemStack(BlockStainedGlassPane.DETECTOR_RAIL, 6), new Object[]{"X X", "X#X", "XRX", Character.valueOf('X'), Items.IRON_INGOT, Character.valueOf('R'), Items.aE, Character.valueOf('#'), BlockStainedGlassPane.STONE_PRESSURE_PLATE});
      this.a(new ItemStack(Items.aB, 1), new Object[]{"# #", "###", Character.valueOf('#'), Items.IRON_INGOT});
      this.a(new ItemStack(Items.bJ, 1), new Object[]{"# #", "# #", "###", Character.valueOf('#'), Items.IRON_INGOT});
      this.a(new ItemStack(Items.bI, 1), new Object[]{" B ", "###", Character.valueOf('#'), BlockStainedGlassPane.COBBLESTONE, Character.valueOf('B'), Items.bx});
      this.a(new ItemStack(BlockStainedGlassPane.LIT_PUMPKIN, 1), new Object[]{"A", "B", Character.valueOf('A'), BlockStainedGlassPane.PUMPKIN, Character.valueOf('B'), BlockStainedGlassPane.TORCH});
      this.a(new ItemStack(Items.aP, 1), new Object[]{"A", "B", Character.valueOf('A'), BlockStainedGlassPane.CHEST, Character.valueOf('B'), Items.aB});
      this.a(new ItemStack(Items.aQ, 1), new Object[]{"A", "B", Character.valueOf('A'), BlockStainedGlassPane.FURNACE, Character.valueOf('B'), Items.aB});
      this.a(new ItemStack(Items.ck, 1), new Object[]{"A", "B", Character.valueOf('A'), BlockStainedGlassPane.TNT, Character.valueOf('B'), Items.aB});
      this.a(new ItemStack(Items.cl, 1), new Object[]{"A", "B", Character.valueOf('A'), BlockStainedGlassPane.HOPPER, Character.valueOf('B'), Items.aB});
      this.a(new ItemStack(Items.aG, 1), new Object[]{"# #", "###", Character.valueOf('#'), BlockStainedGlassPane.PLANKS});
      this.a(new ItemStack(Items.ay, 1), new Object[]{"# #", " # ", Character.valueOf('#'), Items.IRON_INGOT});
      this.a(new ItemStack(Items.bT, 1), new Object[]{"# #", " # ", Character.valueOf('#'), Items.aJ});
      this.b(new ItemStack(Items.FLINT_AND_STEEL, 1), new Object[]{new ItemStack(Items.IRON_INGOT, 1), new ItemStack(Items.am, 1)});
      this.a(new ItemStack(Items.R, 1), new Object[]{"###", Character.valueOf('#'), Items.Q});
      this.a(new ItemStack(BlockStainedGlassPane.OAK_STAIRS, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), new ItemStack(BlockStainedGlassPane.PLANKS, 1, BlockWood.EnumLogVariant.OAK.getId())});
      this.a(new ItemStack(BlockStainedGlassPane.BIRCH_STAIRS, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), new ItemStack(BlockStainedGlassPane.PLANKS, 1, BlockWood.EnumLogVariant.BIRCH.getId())});
      this.a(new ItemStack(BlockStainedGlassPane.SPRUCE_STAIRS, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), new ItemStack(BlockStainedGlassPane.PLANKS, 1, BlockWood.EnumLogVariant.SPRUCE.getId())});
      this.a(new ItemStack(BlockStainedGlassPane.JUNGKE_STAIRS, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), new ItemStack(BlockStainedGlassPane.PLANKS, 1, BlockWood.EnumLogVariant.JUNGLE.getId())});
      this.a(new ItemStack(BlockStainedGlassPane.ACACIA_STAIRS, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), new ItemStack(BlockStainedGlassPane.PLANKS, 1, 4 + BlockWood.EnumLogVariant.ACACIA.getId() - 4)});
      this.a(new ItemStack(BlockStainedGlassPane.DARK_OAK_STAIRS, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), new ItemStack(BlockStainedGlassPane.PLANKS, 1, 4 + BlockWood.EnumLogVariant.DARK_OAK.getId() - 4)});
      this.a(new ItemStack(Items.aT, 1), new Object[]{"  #", " #X", "# X", Character.valueOf('#'), Items.STICK, Character.valueOf('X'), Items.H});
      this.a(new ItemStack(Items.cb, 1), new Object[]{"# ", " X", Character.valueOf('#'), Items.aT, Character.valueOf('X'), Items.bU});
      this.a(new ItemStack(BlockStainedGlassPane.STONE_STAIRS, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), BlockStainedGlassPane.COBBLESTONE});
      this.a(new ItemStack(BlockStainedGlassPane.BRICK_STAIRS, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), BlockStainedGlassPane.BRICK_BLOCK});
      this.a(new ItemStack(BlockStainedGlassPane.STONE_BRICK_STAIRS, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), BlockStainedGlassPane.STONEBRICK});
      this.a(new ItemStack(BlockStainedGlassPane.NETHER_BTICK_STAIRS, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), BlockStainedGlassPane.NETHER_BRICK});
      this.a(new ItemStack(BlockStainedGlassPane.SANDSTONE_STAIRS, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), BlockStainedGlassPane.SANDSTONE});
      this.a(new ItemStack(BlockStainedGlassPane.RED_SANDSTONE_STAIRS, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), BlockStainedGlassPane.RED_SANDSTONE});
      this.a(new ItemStack(BlockStainedGlassPane.QUARTZ_STAIRS, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), BlockStainedGlassPane.QUARTZ_BLOCK});
      this.a(new ItemStack(Items.ap, 1), new Object[]{"###", "#X#", "###", Character.valueOf('#'), Items.STICK, Character.valueOf('X'), BlockStainedGlassPane.WOOL});
      this.a(new ItemStack(Items.bS, 1), new Object[]{"###", "#X#", "###", Character.valueOf('#'), Items.STICK, Character.valueOf('X'), Items.aH});
      this.a(new ItemStack(Items.aq), new Object[]{"###", "#X#", "###", Character.valueOf('#'), Items.GOLD_INGOT, Character.valueOf('X'), Items.APPLE});
      this.a(new ItemStack(Items.aq, 1, 1), new Object[]{"###", "#X#", "###", Character.valueOf('#'), BlockStainedGlassPane.GOLD_BLOCK, Character.valueOf('X'), Items.APPLE});
      this.a(new ItemStack(Items.bZ), new Object[]{"###", "#X#", "###", Character.valueOf('#'), Items.bz, Character.valueOf('X'), Items.bU});
      this.a(new ItemStack(Items.bL, 1), new Object[]{"###", "#X#", "###", Character.valueOf('#'), Items.bz, Character.valueOf('X'), Items.bh});
      this.a(new ItemStack(BlockStainedGlassPane.LEVER, 1), new Object[]{"X", "#", Character.valueOf('#'), BlockStainedGlassPane.COBBLESTONE, Character.valueOf('X'), Items.STICK});
      this.a(new ItemStack(BlockStainedGlassPane.TRIPWIRE_HOOK, 2), new Object[]{"I", "S", "#", Character.valueOf('#'), BlockStainedGlassPane.PLANKS, Character.valueOf('S'), Items.STICK, Character.valueOf('I'), Items.IRON_INGOT});
      this.a(new ItemStack(BlockStainedGlassPane.REDSTONE_TORCH, 1), new Object[]{"X", "#", Character.valueOf('#'), Items.STICK, Character.valueOf('X'), Items.aE});
      this.a(new ItemStack(Items.bd, 1), new Object[]{"#X#", "III", Character.valueOf('#'), BlockStainedGlassPane.REDSTONE_TORCH, Character.valueOf('X'), Items.aE, Character.valueOf('I'), new ItemStack(BlockStainedGlassPane.STONE, 1, BlockStone.EnumStoneVariant.STONE.getData())});
      this.a(new ItemStack(Items.ch, 1), new Object[]{" # ", "#X#", "III", Character.valueOf('#'), BlockStainedGlassPane.REDSTONE_TORCH, Character.valueOf('X'), Items.cj, Character.valueOf('I'), new ItemStack(BlockStainedGlassPane.STONE, 1, BlockStone.EnumStoneVariant.STONE.getData())});
      this.a(new ItemStack(Items.aU, 1), new Object[]{" # ", "#X#", " # ", Character.valueOf('#'), Items.GOLD_INGOT, Character.valueOf('X'), Items.aE});
      this.a(new ItemStack(Items.aS, 1), new Object[]{" # ", "#X#", " # ", Character.valueOf('#'), Items.IRON_INGOT, Character.valueOf('X'), Items.aE});
      this.a(new ItemStack(Items.bY, 1), new Object[]{"###", "#X#", "###", Character.valueOf('#'), Items.aM, Character.valueOf('X'), Items.aS});
      this.a(new ItemStack(BlockStainedGlassPane.STONE_BUTTON, 1), new Object[]{"#", Character.valueOf('#'), new ItemStack(BlockStainedGlassPane.STONE, 1, BlockStone.EnumStoneVariant.STONE.getData())});
      this.a(new ItemStack(BlockStainedGlassPane.WOODEN_BUTTON, 1), new Object[]{"#", Character.valueOf('#'), BlockStainedGlassPane.PLANKS});
      this.a(new ItemStack(BlockStainedGlassPane.STONE_PRESSURE_PLATE, 1), new Object[]{"##", Character.valueOf('#'), new ItemStack(BlockStainedGlassPane.STONE, 1, BlockStone.EnumStoneVariant.STONE.getData())});
      this.a(new ItemStack(BlockStainedGlassPane.WOODEN_PRESSURE_PLATE, 1), new Object[]{"##", Character.valueOf('#'), BlockStainedGlassPane.PLANKS});
      this.a(new ItemStack(BlockStainedGlassPane.HEAVY_W_PRESSURE_PLATE, 1), new Object[]{"##", Character.valueOf('#'), Items.IRON_INGOT});
      this.a(new ItemStack(BlockStainedGlassPane.LIGHT_W_PRESSURE_PLATE, 1), new Object[]{"##", Character.valueOf('#'), Items.GOLD_INGOT});
      this.a(new ItemStack(BlockStainedGlassPane.DISPENSER, 1), new Object[]{"###", "#X#", "#R#", Character.valueOf('#'), BlockStainedGlassPane.COBBLESTONE, Character.valueOf('X'), Items.BOW, Character.valueOf('R'), Items.aE});
      this.a(new ItemStack(BlockStainedGlassPane.DROPPER, 1), new Object[]{"###", "# #", "#R#", Character.valueOf('#'), BlockStainedGlassPane.COBBLESTONE, Character.valueOf('R'), Items.aE});
      this.a(new ItemStack(BlockStainedGlassPane.PISTON, 1), new Object[]{"TTT", "#X#", "#R#", Character.valueOf('#'), BlockStainedGlassPane.COBBLESTONE, Character.valueOf('X'), Items.IRON_INGOT, Character.valueOf('R'), Items.aE, Character.valueOf('T'), BlockStainedGlassPane.PLANKS});
      this.a(new ItemStack(BlockStainedGlassPane.STICKY_PISTON, 1), new Object[]{"S", "P", Character.valueOf('S'), Items.aO, Character.valueOf('P'), BlockStainedGlassPane.PISTON});
      this.a(new ItemStack(Items.bc, 1), new Object[]{"###", "XXX", Character.valueOf('#'), BlockStainedGlassPane.WOOL, Character.valueOf('X'), BlockStainedGlassPane.PLANKS});
      this.a(new ItemStack(BlockStainedGlassPane.ENCHANTING_TABLE, 1), new Object[]{" B ", "D#D", "###", Character.valueOf('#'), BlockStainedGlassPane.OBSIDIAN, Character.valueOf('B'), Items.aN, Character.valueOf('D'), Items.DIAMOND});
      this.a(new ItemStack(BlockStainedGlassPane.ANVIL, 1), new Object[]{"III", " i ", "iii", Character.valueOf('I'), BlockStainedGlassPane.IRON_BLOCK, Character.valueOf('i'), Items.IRON_INGOT});
      this.a(new ItemStack(Items.aH), new Object[]{"##", "##", Character.valueOf('#'), Items.bu});
      this.b(new ItemStack(Items.bK, 1), new Object[]{Items.bw, Items.bG});
      this.b(new ItemStack(Items.bO, 3), new Object[]{Items.J, Items.bG, Items.COAL});
      this.b(new ItemStack(Items.bO, 3), new Object[]{Items.J, Items.bG, new ItemStack(Items.COAL, 1, 1)});
      this.a(new ItemStack(BlockStainedGlassPane.DAYLIGHT_DETECTOR), new Object[]{"GGG", "QQQ", "WWW", Character.valueOf('G'), BlockStainedGlassPane.GLASS, Character.valueOf('Q'), Items.cj, Character.valueOf('W'), BlockStainedGlassPane.WOODEN_SLAB});
      this.a(new ItemStack(BlockStainedGlassPane.HOPPER), new Object[]{"I I", "ICI", " I ", Character.valueOf('I'), Items.IRON_INGOT, Character.valueOf('C'), BlockStainedGlassPane.CHEST});
      this.a(new ItemStack(Items.cm, 1), new Object[]{"///", " / ", "/_/", Character.valueOf('/'), Items.STICK, Character.valueOf('_'), new ItemStack(BlockStainedGlassPane.STONE_SLAB, 1, BlockDoubleStepAbstract.EnumStoneSlabVariant.STONE.getId())});
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
         String[] var11 = (String[])((String[])var2[var4++]);

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
