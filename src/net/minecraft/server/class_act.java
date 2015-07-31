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
import net.minecraft.server.Blocks;
import net.minecraft.server.class_ajp;
import net.minecraft.server.class_ajw;
import net.minecraft.server.BlockStone;
import net.minecraft.server.class_alk;
import net.minecraft.server.class_alv;
import net.minecraft.server.class_yg;
import net.minecraft.server.class_zy;

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
      this.b(new ItemStack(Items.bP, 1), new Object[]{Items.aN, new ItemStack(Items.aY, 1, class_zy.p.b()), Items.I});
      this.a(new ItemStack(Blocks.FENCE, 3), new Object[]{"W#W", "W#W", Character.valueOf('#'), Items.A, Character.valueOf('W'), new ItemStack(Blocks.PLANKS, 1, class_ajw.class_a_in_class_ajw.a.a())});
      this.a(new ItemStack(Blocks.BIRCH_FENCE, 3), new Object[]{"W#W", "W#W", Character.valueOf('#'), Items.A, Character.valueOf('W'), new ItemStack(Blocks.PLANKS, 1, class_ajw.class_a_in_class_ajw.c.a())});
      this.a(new ItemStack(Blocks.SPRUCE_FENCE, 3), new Object[]{"W#W", "W#W", Character.valueOf('#'), Items.A, Character.valueOf('W'), new ItemStack(Blocks.PLANKS, 1, class_ajw.class_a_in_class_ajw.b.a())});
      this.a(new ItemStack(Blocks.JUNGLE_FENCE, 3), new Object[]{"W#W", "W#W", Character.valueOf('#'), Items.A, Character.valueOf('W'), new ItemStack(Blocks.PLANKS, 1, class_ajw.class_a_in_class_ajw.d.a())});
      this.a(new ItemStack(Blocks.ACACIA_FENCE, 3), new Object[]{"W#W", "W#W", Character.valueOf('#'), Items.A, Character.valueOf('W'), new ItemStack(Blocks.PLANKS, 1, 4 + class_ajw.class_a_in_class_ajw.e.a() - 4)});
      this.a(new ItemStack(Blocks.DARK_OAK_FENCE, 3), new Object[]{"W#W", "W#W", Character.valueOf('#'), Items.A, Character.valueOf('W'), new ItemStack(Blocks.PLANKS, 1, 4 + class_ajw.class_a_in_class_ajw.f.a() - 4)});
      this.a(new ItemStack(Blocks.COBBLESTONE_WALL, 6, class_alv.class_a_in_class_alv.a.a()), new Object[]{"###", "###", Character.valueOf('#'), Blocks.COBBLESTONE});
      this.a(new ItemStack(Blocks.COBBLESTONE_WALL, 6, class_alv.class_a_in_class_alv.b.a()), new Object[]{"###", "###", Character.valueOf('#'), Blocks.MOSSY_COBBLESTONE});
      this.a(new ItemStack(Blocks.NETHER_BRICK_FENCE, 6), new Object[]{"###", "###", Character.valueOf('#'), Blocks.NETHER_BRICK});
      this.a(new ItemStack(Blocks.FENCE_GATE, 1), new Object[]{"#W#", "#W#", Character.valueOf('#'), Items.A, Character.valueOf('W'), new ItemStack(Blocks.PLANKS, 1, class_ajw.class_a_in_class_ajw.a.a())});
      this.a(new ItemStack(Blocks.BIRCH_FENCE_GATE, 1), new Object[]{"#W#", "#W#", Character.valueOf('#'), Items.A, Character.valueOf('W'), new ItemStack(Blocks.PLANKS, 1, class_ajw.class_a_in_class_ajw.c.a())});
      this.a(new ItemStack(Blocks.SPRUCE_FENCE_GATE, 1), new Object[]{"#W#", "#W#", Character.valueOf('#'), Items.A, Character.valueOf('W'), new ItemStack(Blocks.PLANKS, 1, class_ajw.class_a_in_class_ajw.b.a())});
      this.a(new ItemStack(Blocks.JUGLE_FENCE_GATE, 1), new Object[]{"#W#", "#W#", Character.valueOf('#'), Items.A, Character.valueOf('W'), new ItemStack(Blocks.PLANKS, 1, class_ajw.class_a_in_class_ajw.d.a())});
      this.a(new ItemStack(Blocks.ACACIA_FENCE_GATE, 1), new Object[]{"#W#", "#W#", Character.valueOf('#'), Items.A, Character.valueOf('W'), new ItemStack(Blocks.PLANKS, 1, 4 + class_ajw.class_a_in_class_ajw.e.a() - 4)});
      this.a(new ItemStack(Blocks.DARK_OAK_FENCE_GATE, 1), new Object[]{"#W#", "#W#", Character.valueOf('#'), Items.A, Character.valueOf('W'), new ItemStack(Blocks.PLANKS, 1, 4 + class_ajw.class_a_in_class_ajw.f.a() - 4)});
      this.a(new ItemStack(Blocks.JUKEBOX, 1), new Object[]{"###", "#X#", "###", Character.valueOf('#'), Blocks.PLANKS, Character.valueOf('X'), Items.k});
      this.a(new ItemStack(Items.cq, 2), new Object[]{"~~ ", "~O ", "  ~", Character.valueOf('~'), Items.H, Character.valueOf('O'), Items.aO});
      this.a(new ItemStack(Blocks.NOTEBLOCK, 1), new Object[]{"###", "#X#", "###", Character.valueOf('#'), Blocks.PLANKS, Character.valueOf('X'), Items.aE});
      this.a(new ItemStack(Blocks.BOOKSHELF, 1), new Object[]{"###", "XXX", "###", Character.valueOf('#'), Blocks.PLANKS, Character.valueOf('X'), Items.aN});
      this.a(new ItemStack(Blocks.SNOW, 1), new Object[]{"##", "##", Character.valueOf('#'), Items.aF});
      this.a(new ItemStack(Blocks.SNOW_LAYER, 6), new Object[]{"###", Character.valueOf('#'), Blocks.SNOW});
      this.a(new ItemStack(Blocks.CLAY, 1), new Object[]{"##", "##", Character.valueOf('#'), Items.aK});
      this.a(new ItemStack(Blocks.BRICK_BLOCK, 1), new Object[]{"##", "##", Character.valueOf('#'), Items.aJ});
      this.a(new ItemStack(Blocks.GLOWSTONE, 1), new Object[]{"##", "##", Character.valueOf('#'), Items.aV});
      this.a(new ItemStack(Blocks.QUARTZ_BLOCK, 1), new Object[]{"##", "##", Character.valueOf('#'), Items.cj});
      this.a(new ItemStack(Blocks.WOOL, 1), new Object[]{"##", "##", Character.valueOf('#'), Items.H});
      this.a(new ItemStack(Blocks.TNT, 1), new Object[]{"X#X", "#X#", "X#X", Character.valueOf('X'), Items.J, Character.valueOf('#'), Blocks.SAND});
      this.a(new ItemStack(Blocks.STONE_SLAB, 6, class_alk.class_a_in_class_alk.d.a()), new Object[]{"###", Character.valueOf('#'), Blocks.COBBLESTONE});
      this.a(new ItemStack(Blocks.STONE_SLAB, 6, class_alk.class_a_in_class_alk.a.a()), new Object[]{"###", Character.valueOf('#'), new ItemStack(Blocks.STONE, 1, BlockStone.EnumStoneVariant.STONE.getData())});
      this.a(new ItemStack(Blocks.STONE_SLAB, 6, class_alk.class_a_in_class_alk.b.a()), new Object[]{"###", Character.valueOf('#'), Blocks.SANDSTONE});
      this.a(new ItemStack(Blocks.STONE_SLAB, 6, class_alk.class_a_in_class_alk.e.a()), new Object[]{"###", Character.valueOf('#'), Blocks.BRICK_BLOCK});
      this.a(new ItemStack(Blocks.STONE_SLAB, 6, class_alk.class_a_in_class_alk.f.a()), new Object[]{"###", Character.valueOf('#'), Blocks.STONEBRICK});
      this.a(new ItemStack(Blocks.STONE_SLAB, 6, class_alk.class_a_in_class_alk.g.a()), new Object[]{"###", Character.valueOf('#'), Blocks.NETHER_BRICK});
      this.a(new ItemStack(Blocks.STONE_SLAB, 6, class_alk.class_a_in_class_alk.h.a()), new Object[]{"###", Character.valueOf('#'), Blocks.QUARTZ_BLOCK});
      this.a(new ItemStack(Blocks.STONE_SLAB2, 6, class_ajp.class_a_in_class_ajp.a.a()), new Object[]{"###", Character.valueOf('#'), Blocks.RED_SANDSTONE});
      this.a(new ItemStack(Blocks.PURPUR_SLAB, 6, 0), new Object[]{"###", Character.valueOf('#'), Blocks.PURPUR_BLOCK});
      this.a(new ItemStack(Blocks.WOODEN_SLAB, 6, 0), new Object[]{"###", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, class_ajw.class_a_in_class_ajw.a.a())});
      this.a(new ItemStack(Blocks.WOODEN_SLAB, 6, class_ajw.class_a_in_class_ajw.c.a()), new Object[]{"###", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, class_ajw.class_a_in_class_ajw.c.a())});
      this.a(new ItemStack(Blocks.WOODEN_SLAB, 6, class_ajw.class_a_in_class_ajw.b.a()), new Object[]{"###", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, class_ajw.class_a_in_class_ajw.b.a())});
      this.a(new ItemStack(Blocks.WOODEN_SLAB, 6, class_ajw.class_a_in_class_ajw.d.a()), new Object[]{"###", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, class_ajw.class_a_in_class_ajw.d.a())});
      this.a(new ItemStack(Blocks.WOODEN_SLAB, 6, 4 + class_ajw.class_a_in_class_ajw.e.a() - 4), new Object[]{"###", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, 4 + class_ajw.class_a_in_class_ajw.e.a() - 4)});
      this.a(new ItemStack(Blocks.WOODEN_SLAB, 6, 4 + class_ajw.class_a_in_class_ajw.f.a() - 4), new Object[]{"###", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, 4 + class_ajw.class_a_in_class_ajw.f.a() - 4)});
      this.a(new ItemStack(Blocks.LADDER, 3), new Object[]{"# #", "###", "# #", Character.valueOf('#'), Items.A});
      this.a(new ItemStack(Items.as, 3), new Object[]{"##", "##", "##", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, class_ajw.class_a_in_class_ajw.a.a())});
      this.a(new ItemStack(Items.at, 3), new Object[]{"##", "##", "##", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, class_ajw.class_a_in_class_ajw.b.a())});
      this.a(new ItemStack(Items.au, 3), new Object[]{"##", "##", "##", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, class_ajw.class_a_in_class_ajw.c.a())});
      this.a(new ItemStack(Items.av, 3), new Object[]{"##", "##", "##", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, class_ajw.class_a_in_class_ajw.d.a())});
      this.a(new ItemStack(Items.aw, 3), new Object[]{"##", "##", "##", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, class_ajw.class_a_in_class_ajw.e.a())});
      this.a(new ItemStack(Items.ax, 3), new Object[]{"##", "##", "##", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, class_ajw.class_a_in_class_ajw.f.a())});
      this.a(new ItemStack(Blocks.TRAPDOOR, 2), new Object[]{"###", "###", Character.valueOf('#'), Blocks.PLANKS});
      this.a(new ItemStack(Items.aD, 3), new Object[]{"##", "##", "##", Character.valueOf('#'), Items.l});
      this.a(new ItemStack(Blocks.IRON_TRAPDOOR, 1), new Object[]{"##", "##", Character.valueOf('#'), Items.l});
      this.a(new ItemStack(Items.ar, 3), new Object[]{"###", "###", " X ", Character.valueOf('#'), Blocks.PLANKS, Character.valueOf('X'), Items.A});
      this.a(new ItemStack(Items.bb, 1), new Object[]{"AAA", "BEB", "CCC", Character.valueOf('A'), Items.aI, Character.valueOf('B'), Items.ba, Character.valueOf('C'), Items.Q, Character.valueOf('E'), Items.aR});
      this.a(new ItemStack(Items.ba, 1), new Object[]{"#", Character.valueOf('#'), Items.aL});
      this.a(new ItemStack(Blocks.PLANKS, 4, class_ajw.class_a_in_class_ajw.a.a()), new Object[]{"#", Character.valueOf('#'), new ItemStack(Blocks.LOG, 1, class_ajw.class_a_in_class_ajw.a.a())});
      this.a(new ItemStack(Blocks.PLANKS, 4, class_ajw.class_a_in_class_ajw.b.a()), new Object[]{"#", Character.valueOf('#'), new ItemStack(Blocks.LOG, 1, class_ajw.class_a_in_class_ajw.b.a())});
      this.a(new ItemStack(Blocks.PLANKS, 4, class_ajw.class_a_in_class_ajw.c.a()), new Object[]{"#", Character.valueOf('#'), new ItemStack(Blocks.LOG, 1, class_ajw.class_a_in_class_ajw.c.a())});
      this.a(new ItemStack(Blocks.PLANKS, 4, class_ajw.class_a_in_class_ajw.d.a()), new Object[]{"#", Character.valueOf('#'), new ItemStack(Blocks.LOG, 1, class_ajw.class_a_in_class_ajw.d.a())});
      this.a(new ItemStack(Blocks.PLANKS, 4, 4 + class_ajw.class_a_in_class_ajw.e.a() - 4), new Object[]{"#", Character.valueOf('#'), new ItemStack(Blocks.LOG2, 1, class_ajw.class_a_in_class_ajw.e.a() - 4)});
      this.a(new ItemStack(Blocks.PLANKS, 4, 4 + class_ajw.class_a_in_class_ajw.f.a() - 4), new Object[]{"#", Character.valueOf('#'), new ItemStack(Blocks.LOG2, 1, class_ajw.class_a_in_class_ajw.f.a() - 4)});
      this.a(new ItemStack(Items.A, 4), new Object[]{"#", "#", Character.valueOf('#'), Blocks.PLANKS});
      this.a(new ItemStack(Blocks.TORCH, 4), new Object[]{"X", "#", Character.valueOf('X'), Items.j, Character.valueOf('#'), Items.A});
      this.a(new ItemStack(Blocks.TORCH, 4), new Object[]{"X", "#", Character.valueOf('X'), new ItemStack(Items.j, 1, 1), Character.valueOf('#'), Items.A});
      this.a(new ItemStack(Items.B, 4), new Object[]{"# #", " # ", Character.valueOf('#'), Blocks.PLANKS});
      this.a(new ItemStack(Items.bD, 3), new Object[]{"# #", " # ", Character.valueOf('#'), Blocks.GLASS});
      this.a(new ItemStack(Blocks.RAIL, 16), new Object[]{"X X", "X#X", "X X", Character.valueOf('X'), Items.l, Character.valueOf('#'), Items.A});
      this.a(new ItemStack(Blocks.GOLDEN_RAIL, 6), new Object[]{"X X", "X#X", "XRX", Character.valueOf('X'), Items.m, Character.valueOf('R'), Items.aE, Character.valueOf('#'), Items.A});
      this.a(new ItemStack(Blocks.ACTIVATOR_RAIL, 6), new Object[]{"XSX", "X#X", "XSX", Character.valueOf('X'), Items.l, Character.valueOf('#'), Blocks.REDSTONE_TORCH, Character.valueOf('S'), Items.A});
      this.a(new ItemStack(Blocks.DETECTOR_RAIL, 6), new Object[]{"X X", "X#X", "XRX", Character.valueOf('X'), Items.l, Character.valueOf('R'), Items.aE, Character.valueOf('#'), Blocks.STONE_PRESSURE_PLATE});
      this.a(new ItemStack(Items.aB, 1), new Object[]{"# #", "###", Character.valueOf('#'), Items.l});
      this.a(new ItemStack(Items.bJ, 1), new Object[]{"# #", "# #", "###", Character.valueOf('#'), Items.l});
      this.a(new ItemStack(Items.bI, 1), new Object[]{" B ", "###", Character.valueOf('#'), Blocks.COBBLESTONE, Character.valueOf('B'), Items.bx});
      this.a(new ItemStack(Blocks.LIT_PUMPKIN, 1), new Object[]{"A", "B", Character.valueOf('A'), Blocks.PUMPKIN, Character.valueOf('B'), Blocks.TORCH});
      this.a(new ItemStack(Items.aP, 1), new Object[]{"A", "B", Character.valueOf('A'), Blocks.CHEST, Character.valueOf('B'), Items.aB});
      this.a(new ItemStack(Items.aQ, 1), new Object[]{"A", "B", Character.valueOf('A'), Blocks.FURNACE, Character.valueOf('B'), Items.aB});
      this.a(new ItemStack(Items.ck, 1), new Object[]{"A", "B", Character.valueOf('A'), Blocks.TNT, Character.valueOf('B'), Items.aB});
      this.a(new ItemStack(Items.cl, 1), new Object[]{"A", "B", Character.valueOf('A'), Blocks.HOPPER, Character.valueOf('B'), Items.aB});
      this.a(new ItemStack(Items.aG, 1), new Object[]{"# #", "###", Character.valueOf('#'), Blocks.PLANKS});
      this.a(new ItemStack(Items.ay, 1), new Object[]{"# #", " # ", Character.valueOf('#'), Items.l});
      this.a(new ItemStack(Items.bT, 1), new Object[]{"# #", " # ", Character.valueOf('#'), Items.aJ});
      this.b(new ItemStack(Items.d, 1), new Object[]{new ItemStack(Items.l, 1), new ItemStack(Items.am, 1)});
      this.a(new ItemStack(Items.R, 1), new Object[]{"###", Character.valueOf('#'), Items.Q});
      this.a(new ItemStack(Blocks.OAK_STAIRS, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, class_ajw.class_a_in_class_ajw.a.a())});
      this.a(new ItemStack(Blocks.BIRCH_STAIRS, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, class_ajw.class_a_in_class_ajw.c.a())});
      this.a(new ItemStack(Blocks.SPRUCE_STAIRS, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, class_ajw.class_a_in_class_ajw.b.a())});
      this.a(new ItemStack(Blocks.JUNGKE_STAIRS, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, class_ajw.class_a_in_class_ajw.d.a())});
      this.a(new ItemStack(Blocks.ACACIA_STAIRS, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, 4 + class_ajw.class_a_in_class_ajw.e.a() - 4)});
      this.a(new ItemStack(Blocks.DARK_OAK_STAIRS, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Blocks.PLANKS, 1, 4 + class_ajw.class_a_in_class_ajw.f.a() - 4)});
      this.a(new ItemStack(Items.aT, 1), new Object[]{"  #", " #X", "# X", Character.valueOf('#'), Items.A, Character.valueOf('X'), Items.H});
      this.a(new ItemStack(Items.cb, 1), new Object[]{"# ", " X", Character.valueOf('#'), Items.aT, Character.valueOf('X'), Items.bU});
      this.a(new ItemStack(Blocks.STONE_STAIRS, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), Blocks.COBBLESTONE});
      this.a(new ItemStack(Blocks.BRICK_STAIRS, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), Blocks.BRICK_BLOCK});
      this.a(new ItemStack(Blocks.STONE_BRICK_STAIRS, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), Blocks.STONEBRICK});
      this.a(new ItemStack(Blocks.NETHER_BTICK_STAIRS, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), Blocks.NETHER_BRICK});
      this.a(new ItemStack(Blocks.SANDSTONE_STAIRS, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), Blocks.SANDSTONE});
      this.a(new ItemStack(Blocks.RED_SANDSTONE_STAIRS, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), Blocks.RED_SANDSTONE});
      this.a(new ItemStack(Blocks.QUARTZ_STAIRS, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), Blocks.QUARTZ_BLOCK});
      this.a(new ItemStack(Items.ap, 1), new Object[]{"###", "#X#", "###", Character.valueOf('#'), Items.A, Character.valueOf('X'), Blocks.WOOL});
      this.a(new ItemStack(Items.bS, 1), new Object[]{"###", "#X#", "###", Character.valueOf('#'), Items.A, Character.valueOf('X'), Items.aH});
      this.a(new ItemStack(Items.aq), new Object[]{"###", "#X#", "###", Character.valueOf('#'), Items.m, Character.valueOf('X'), Items.e});
      this.a(new ItemStack(Items.aq, 1, 1), new Object[]{"###", "#X#", "###", Character.valueOf('#'), Blocks.GOLD_BLOCK, Character.valueOf('X'), Items.e});
      this.a(new ItemStack(Items.bZ), new Object[]{"###", "#X#", "###", Character.valueOf('#'), Items.bz, Character.valueOf('X'), Items.bU});
      this.a(new ItemStack(Items.bL, 1), new Object[]{"###", "#X#", "###", Character.valueOf('#'), Items.bz, Character.valueOf('X'), Items.bh});
      this.a(new ItemStack(Blocks.LEVER, 1), new Object[]{"X", "#", Character.valueOf('#'), Blocks.COBBLESTONE, Character.valueOf('X'), Items.A});
      this.a(new ItemStack(Blocks.TRIPWIRE_HOOK, 2), new Object[]{"I", "S", "#", Character.valueOf('#'), Blocks.PLANKS, Character.valueOf('S'), Items.A, Character.valueOf('I'), Items.l});
      this.a(new ItemStack(Blocks.REDSTONE_TORCH, 1), new Object[]{"X", "#", Character.valueOf('#'), Items.A, Character.valueOf('X'), Items.aE});
      this.a(new ItemStack(Items.bd, 1), new Object[]{"#X#", "III", Character.valueOf('#'), Blocks.REDSTONE_TORCH, Character.valueOf('X'), Items.aE, Character.valueOf('I'), new ItemStack(Blocks.STONE, 1, BlockStone.EnumStoneVariant.STONE.getData())});
      this.a(new ItemStack(Items.ch, 1), new Object[]{" # ", "#X#", "III", Character.valueOf('#'), Blocks.REDSTONE_TORCH, Character.valueOf('X'), Items.cj, Character.valueOf('I'), new ItemStack(Blocks.STONE, 1, BlockStone.EnumStoneVariant.STONE.getData())});
      this.a(new ItemStack(Items.aU, 1), new Object[]{" # ", "#X#", " # ", Character.valueOf('#'), Items.m, Character.valueOf('X'), Items.aE});
      this.a(new ItemStack(Items.aS, 1), new Object[]{" # ", "#X#", " # ", Character.valueOf('#'), Items.l, Character.valueOf('X'), Items.aE});
      this.a(new ItemStack(Items.bY, 1), new Object[]{"###", "#X#", "###", Character.valueOf('#'), Items.aM, Character.valueOf('X'), Items.aS});
      this.a(new ItemStack(Blocks.STONE_BUTTON, 1), new Object[]{"#", Character.valueOf('#'), new ItemStack(Blocks.STONE, 1, BlockStone.EnumStoneVariant.STONE.getData())});
      this.a(new ItemStack(Blocks.WOODEN_BUTTON, 1), new Object[]{"#", Character.valueOf('#'), Blocks.PLANKS});
      this.a(new ItemStack(Blocks.STONE_PRESSURE_PLATE, 1), new Object[]{"##", Character.valueOf('#'), new ItemStack(Blocks.STONE, 1, BlockStone.EnumStoneVariant.STONE.getData())});
      this.a(new ItemStack(Blocks.WOODEN_PRESSURE_PLATE, 1), new Object[]{"##", Character.valueOf('#'), Blocks.PLANKS});
      this.a(new ItemStack(Blocks.HEAVY_W_PRESSURE_PLATE, 1), new Object[]{"##", Character.valueOf('#'), Items.l});
      this.a(new ItemStack(Blocks.LIGHT_W_PRESSURE_PLATE, 1), new Object[]{"##", Character.valueOf('#'), Items.m});
      this.a(new ItemStack(Blocks.DISPENSER, 1), new Object[]{"###", "#X#", "#R#", Character.valueOf('#'), Blocks.COBBLESTONE, Character.valueOf('X'), Items.f, Character.valueOf('R'), Items.aE});
      this.a(new ItemStack(Blocks.DROPPER, 1), new Object[]{"###", "# #", "#R#", Character.valueOf('#'), Blocks.COBBLESTONE, Character.valueOf('R'), Items.aE});
      this.a(new ItemStack(Blocks.PISTON, 1), new Object[]{"TTT", "#X#", "#R#", Character.valueOf('#'), Blocks.COBBLESTONE, Character.valueOf('X'), Items.l, Character.valueOf('R'), Items.aE, Character.valueOf('T'), Blocks.PLANKS});
      this.a(new ItemStack(Blocks.STICKY_PISTON, 1), new Object[]{"S", "P", Character.valueOf('S'), Items.aO, Character.valueOf('P'), Blocks.PISTON});
      this.a(new ItemStack(Items.bc, 1), new Object[]{"###", "XXX", Character.valueOf('#'), Blocks.WOOL, Character.valueOf('X'), Blocks.PLANKS});
      this.a(new ItemStack(Blocks.ENCHANTING_TABLE, 1), new Object[]{" B ", "D#D", "###", Character.valueOf('#'), Blocks.OBSIDIAN, Character.valueOf('B'), Items.aN, Character.valueOf('D'), Items.k});
      this.a(new ItemStack(Blocks.ANVIL, 1), new Object[]{"III", " i ", "iii", Character.valueOf('I'), Blocks.IRON_BLOCK, Character.valueOf('i'), Items.l});
      this.a(new ItemStack(Items.aH), new Object[]{"##", "##", Character.valueOf('#'), Items.bu});
      this.b(new ItemStack(Items.bK, 1), new Object[]{Items.bw, Items.bG});
      this.b(new ItemStack(Items.bO, 3), new Object[]{Items.J, Items.bG, Items.j});
      this.b(new ItemStack(Items.bO, 3), new Object[]{Items.J, Items.bG, new ItemStack(Items.j, 1, 1)});
      this.a(new ItemStack(Blocks.DAYLIGHT_DETECTOR), new Object[]{"GGG", "QQQ", "WWW", Character.valueOf('G'), Blocks.GLASS, Character.valueOf('Q'), Items.cj, Character.valueOf('W'), Blocks.WOODEN_SLAB});
      this.a(new ItemStack(Blocks.HOPPER), new Object[]{"I I", "ICI", " I ", Character.valueOf('I'), Items.l, Character.valueOf('C'), Blocks.CHEST});
      this.a(new ItemStack(Items.cm, 1), new Object[]{"///", " / ", "/_/", Character.valueOf('/'), Items.A, Character.valueOf('_'), new ItemStack(Blocks.STONE_SLAB, 1, class_alk.class_a_in_class_alk.a.a())});
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

      ItemStack[] var5 = new ItemStack[var1.o_()];

      for(int var6 = 0; var6 < var5.length; ++var6) {
         var5[var6] = var1.a(var6);
      }

      return var5;
   }

   public List b() {
      return this.b;
   }
}
