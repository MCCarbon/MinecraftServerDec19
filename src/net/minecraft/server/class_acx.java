package net.minecraft.server;

import net.minecraft.server.ItemStack;
import net.minecraft.server.Items;
import net.minecraft.server.class_act;
import net.minecraft.server.BlockStainedGlassPane;
import net.minecraft.server.BlockDirt;
import net.minecraft.server.class_ajp;
import net.minecraft.server.class_akc;
import net.minecraft.server.class_akf;
import net.minecraft.server.class_aki;
import net.minecraft.server.BlockSand;
import net.minecraft.server.BlockSandStone;
import net.minecraft.server.BlockStone;
import net.minecraft.server.class_ali;
import net.minecraft.server.BlockDoubleStepAbstract;
import net.minecraft.server.EnumColor;

public class class_acx {
   public void a(class_act var1) {
      var1.a(new ItemStack(BlockStainedGlassPane.CHEST), new Object[]{"###", "# #", "###", Character.valueOf('#'), BlockStainedGlassPane.PLANKS});
      var1.a(new ItemStack(BlockStainedGlassPane.TRAPPED_CHEST), new Object[]{"#-", Character.valueOf('#'), BlockStainedGlassPane.CHEST, Character.valueOf('-'), BlockStainedGlassPane.TRIPWIRE_HOOK});
      var1.a(new ItemStack(BlockStainedGlassPane.ENDER_CHEST), new Object[]{"###", "#E#", "###", Character.valueOf('#'), BlockStainedGlassPane.OBSIDIAN, Character.valueOf('E'), Items.bK});
      var1.a(new ItemStack(BlockStainedGlassPane.FURNACE), new Object[]{"###", "# #", "###", Character.valueOf('#'), BlockStainedGlassPane.COBBLESTONE});
      var1.a(new ItemStack(BlockStainedGlassPane.CRAFTING_TABLE), new Object[]{"##", "##", Character.valueOf('#'), BlockStainedGlassPane.PLANKS});
      var1.a(new ItemStack(BlockStainedGlassPane.SANDSTONE), new Object[]{"##", "##", Character.valueOf('#'), new ItemStack(BlockStainedGlassPane.SAND, 1, BlockSand.EnumSandVariant.SAND.getId())});
      var1.a(new ItemStack(BlockStainedGlassPane.RED_SANDSTONE), new Object[]{"##", "##", Character.valueOf('#'), new ItemStack(BlockStainedGlassPane.SAND, 1, BlockSand.EnumSandVariant.RED_SAND.getId())});
      var1.a(new ItemStack(BlockStainedGlassPane.SANDSTONE, 4, BlockSandStone.EnumSandstoneVariant.SMOOTH.getId()), new Object[]{"##", "##", Character.valueOf('#'), new ItemStack(BlockStainedGlassPane.SANDSTONE, 1, BlockSandStone.EnumSandstoneVariant.DEFAULT.getId())});
      var1.a(new ItemStack(BlockStainedGlassPane.RED_SANDSTONE, 4, class_aki.class_a_in_class_aki.c.a()), new Object[]{"##", "##", Character.valueOf('#'), new ItemStack(BlockStainedGlassPane.RED_SANDSTONE, 1, class_aki.class_a_in_class_aki.a.a())});
      var1.a(new ItemStack(BlockStainedGlassPane.SANDSTONE, 1, BlockSandStone.EnumSandstoneVariant.CHISELED.getId()), new Object[]{"#", "#", Character.valueOf('#'), new ItemStack(BlockStainedGlassPane.STONE_SLAB, 1, BlockDoubleStepAbstract.EnumStoneSlabVariant.SAND.getId())});
      var1.a(new ItemStack(BlockStainedGlassPane.RED_SANDSTONE, 1, class_aki.class_a_in_class_aki.b.a()), new Object[]{"#", "#", Character.valueOf('#'), new ItemStack(BlockStainedGlassPane.STONE_SLAB2, 1, class_ajp.class_a_in_class_ajp.a.a())});
      var1.a(new ItemStack(BlockStainedGlassPane.QUARTZ_BLOCK, 1, class_akf.class_a_in_class_akf.b.a()), new Object[]{"#", "#", Character.valueOf('#'), new ItemStack(BlockStainedGlassPane.STONE_SLAB, 1, BlockDoubleStepAbstract.EnumStoneSlabVariant.QUARTZ.getId())});
      var1.a(new ItemStack(BlockStainedGlassPane.QUARTZ_BLOCK, 2, class_akf.class_a_in_class_akf.c.a()), new Object[]{"#", "#", Character.valueOf('#'), new ItemStack(BlockStainedGlassPane.QUARTZ_BLOCK, 1, class_akf.class_a_in_class_akf.a.a())});
      var1.a(new ItemStack(BlockStainedGlassPane.STONEBRICK, 4), new Object[]{"##", "##", Character.valueOf('#'), new ItemStack(BlockStainedGlassPane.STONE, 1, BlockStone.EnumStoneVariant.STONE.getData())});
      var1.a(new ItemStack(BlockStainedGlassPane.STONEBRICK, 1, class_ali.P), new Object[]{"#", "#", Character.valueOf('#'), new ItemStack(BlockStainedGlassPane.STONE_SLAB, 1, BlockDoubleStepAbstract.EnumStoneSlabVariant.SMOOTHBRICK.getId())});
      var1.b(new ItemStack(BlockStainedGlassPane.STONEBRICK, 1, class_ali.N), new Object[]{BlockStainedGlassPane.STONEBRICK, BlockStainedGlassPane.VINE});
      var1.b(new ItemStack(BlockStainedGlassPane.MOSSY_COBBLESTONE, 1), new Object[]{BlockStainedGlassPane.COBBLESTONE, BlockStainedGlassPane.VINE});
      var1.a(new ItemStack(BlockStainedGlassPane.IRON_BARS, 16), new Object[]{"###", "###", Character.valueOf('#'), Items.IRON_INGOT});
      var1.a(new ItemStack(BlockStainedGlassPane.GLASS_PANE, 16), new Object[]{"###", "###", Character.valueOf('#'), BlockStainedGlassPane.GLASS});
      var1.a(new ItemStack(BlockStainedGlassPane.REDSTONE_LAMP, 1), new Object[]{" R ", "RGR", " R ", Character.valueOf('R'), Items.aE, Character.valueOf('G'), BlockStainedGlassPane.GLOWSTONE});
      var1.a(new ItemStack(BlockStainedGlassPane.BEACON, 1), new Object[]{"GGG", "GSG", "OOO", Character.valueOf('G'), BlockStainedGlassPane.GLASS, Character.valueOf('S'), Items.cc, Character.valueOf('O'), BlockStainedGlassPane.OBSIDIAN});
      var1.a(new ItemStack(BlockStainedGlassPane.NETHER_BRICK, 1), new Object[]{"NN", "NN", Character.valueOf('N'), Items.ci});
      var1.a(new ItemStack(BlockStainedGlassPane.STONE, 2, BlockStone.EnumStoneVariant.DIORITE.getData()), new Object[]{"CQ", "QC", Character.valueOf('C'), BlockStainedGlassPane.COBBLESTONE, Character.valueOf('Q'), Items.cj});
      var1.b(new ItemStack(BlockStainedGlassPane.STONE, 1, BlockStone.EnumStoneVariant.GRANITE.getData()), new Object[]{new ItemStack(BlockStainedGlassPane.STONE, 1, BlockStone.EnumStoneVariant.DIORITE.getData()), Items.cj});
      var1.b(new ItemStack(BlockStainedGlassPane.STONE, 2, BlockStone.EnumStoneVariant.ANDESITE.getData()), new Object[]{new ItemStack(BlockStainedGlassPane.STONE, 1, BlockStone.EnumStoneVariant.DIORITE.getData()), BlockStainedGlassPane.COBBLESTONE});
      var1.a(new ItemStack(BlockStainedGlassPane.DIRT, 4, BlockDirt.EnumDirtVariant.COARSE_DIRT.getId()), new Object[]{"DG", "GD", Character.valueOf('D'), new ItemStack(BlockStainedGlassPane.DIRT, 1, BlockDirt.EnumDirtVariant.DIRT.getId()), Character.valueOf('G'), BlockStainedGlassPane.GRAVEL});
      var1.a(new ItemStack(BlockStainedGlassPane.STONE, 4, BlockStone.EnumStoneVariant.DIORITE_SMOOTH.getData()), new Object[]{"SS", "SS", Character.valueOf('S'), new ItemStack(BlockStainedGlassPane.STONE, 1, BlockStone.EnumStoneVariant.DIORITE.getData())});
      var1.a(new ItemStack(BlockStainedGlassPane.STONE, 4, BlockStone.EnumStoneVariant.GRANITE_SMOOTH.getData()), new Object[]{"SS", "SS", Character.valueOf('S'), new ItemStack(BlockStainedGlassPane.STONE, 1, BlockStone.EnumStoneVariant.GRANITE.getData())});
      var1.a(new ItemStack(BlockStainedGlassPane.STONE, 4, BlockStone.EnumStoneVariant.ANDESITE_SMOOTH.getData()), new Object[]{"SS", "SS", Character.valueOf('S'), new ItemStack(BlockStainedGlassPane.STONE, 1, BlockStone.EnumStoneVariant.ANDESITE.getData())});
      var1.a(new ItemStack(BlockStainedGlassPane.PRISMARINE, 1, class_akc.b), new Object[]{"SS", "SS", Character.valueOf('S'), Items.cF});
      var1.a(new ItemStack(BlockStainedGlassPane.PRISMARINE, 1, class_akc.N), new Object[]{"SSS", "SSS", "SSS", Character.valueOf('S'), Items.cF});
      var1.a(new ItemStack(BlockStainedGlassPane.PRISMARINE, 1, class_akc.O), new Object[]{"SSS", "SIS", "SSS", Character.valueOf('S'), Items.cF, Character.valueOf('I'), new ItemStack(Items.aY, 1, EnumColor.p.b())});
      var1.a(new ItemStack(BlockStainedGlassPane.SEA_LANTERN, 1, 0), new Object[]{"SCS", "CCC", "SCS", Character.valueOf('S'), Items.cF, Character.valueOf('C'), Items.cG});
      var1.a(new ItemStack(BlockStainedGlassPane.PURPUR_BLOCK, 4, 0), new Object[]{"FF", "FF", Character.valueOf('F'), Items.cJ});
      var1.a(new ItemStack(BlockStainedGlassPane.PURPUR_STAIRS, 4, 0), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), BlockStainedGlassPane.PURPUR_BLOCK});
      var1.a(new ItemStack(BlockStainedGlassPane.PURPUR_PILLAR, 1, 0), new Object[]{"#", "#", Character.valueOf('#'), BlockStainedGlassPane.PURPUR_SLAB});
      var1.a(new ItemStack(BlockStainedGlassPane.END_BRICKS, 4, 0), new Object[]{"##", "##", Character.valueOf('#'), BlockStainedGlassPane.END_STONE});
   }
}
