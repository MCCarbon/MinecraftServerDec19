package net.minecraft.server;

public class class_acx {
   public void a(RecipeManager var1) {
      var1.a(new ItemStack(Blocks.CHEST), new Object[]{"###", "# #", "###", Character.valueOf('#'), Blocks.PLANKS});
      var1.a(new ItemStack(Blocks.TRAPPED_CHEST), new Object[]{"#-", Character.valueOf('#'), Blocks.CHEST, Character.valueOf('-'), Blocks.TRIPWIRE_HOOK});
      var1.a(new ItemStack(Blocks.ENDER_CHEST), new Object[]{"###", "#E#", "###", Character.valueOf('#'), Blocks.OBSIDIAN, Character.valueOf('E'), Items.ENDER_EYE});
      var1.a(new ItemStack(Blocks.FURNACE), new Object[]{"###", "# #", "###", Character.valueOf('#'), Blocks.COBBLESTONE});
      var1.a(new ItemStack(Blocks.CRAFTING_TABLE), new Object[]{"##", "##", Character.valueOf('#'), Blocks.PLANKS});
      var1.a(new ItemStack(Blocks.SANDSTONE), new Object[]{"##", "##", Character.valueOf('#'), new ItemStack(Blocks.SAND, 1, BlockSand.EnumSandVariant.SAND.getId())});
      var1.a(new ItemStack(Blocks.RED_SANDSTONE), new Object[]{"##", "##", Character.valueOf('#'), new ItemStack(Blocks.SAND, 1, BlockSand.EnumSandVariant.RED_SAND.getId())});
      var1.a(new ItemStack(Blocks.SANDSTONE, 4, BlockSandStone.EnumSandstoneVariant.SMOOTH.getId()), new Object[]{"##", "##", Character.valueOf('#'), new ItemStack(Blocks.SANDSTONE, 1, BlockSandStone.EnumSandstoneVariant.DEFAULT.getId())});
      var1.a(new ItemStack(Blocks.RED_SANDSTONE, 4, class_aki.class_a_in_class_aki.c.a()), new Object[]{"##", "##", Character.valueOf('#'), new ItemStack(Blocks.RED_SANDSTONE, 1, class_aki.class_a_in_class_aki.a.a())});
      var1.a(new ItemStack(Blocks.SANDSTONE, 1, BlockSandStone.EnumSandstoneVariant.CHISELED.getId()), new Object[]{"#", "#", Character.valueOf('#'), new ItemStack(Blocks.STONE_SLAB, 1, BlockDoubleStepAbstract.EnumStoneSlabVariant.SAND.getId())});
      var1.a(new ItemStack(Blocks.RED_SANDSTONE, 1, class_aki.class_a_in_class_aki.b.a()), new Object[]{"#", "#", Character.valueOf('#'), new ItemStack(Blocks.STONE_SLAB2, 1, class_ajp.class_a_in_class_ajp.a.a())});
      var1.a(new ItemStack(Blocks.QUARTZ_BLOCK, 1, class_akf.class_a_in_class_akf.b.a()), new Object[]{"#", "#", Character.valueOf('#'), new ItemStack(Blocks.STONE_SLAB, 1, BlockDoubleStepAbstract.EnumStoneSlabVariant.QUARTZ.getId())});
      var1.a(new ItemStack(Blocks.QUARTZ_BLOCK, 2, class_akf.class_a_in_class_akf.c.a()), new Object[]{"#", "#", Character.valueOf('#'), new ItemStack(Blocks.QUARTZ_BLOCK, 1, class_akf.class_a_in_class_akf.a.a())});
      var1.a(new ItemStack(Blocks.STONEBRICK, 4), new Object[]{"##", "##", Character.valueOf('#'), new ItemStack(Blocks.STONE, 1, BlockStone.EnumStoneVariant.STONE.getData())});
      var1.a(new ItemStack(Blocks.STONEBRICK, 1, BlockSmoothBrick.P), new Object[]{"#", "#", Character.valueOf('#'), new ItemStack(Blocks.STONE_SLAB, 1, BlockDoubleStepAbstract.EnumStoneSlabVariant.SMOOTHBRICK.getId())});
      var1.b(new ItemStack(Blocks.STONEBRICK, 1, BlockSmoothBrick.N), new Object[]{Blocks.STONEBRICK, Blocks.VINE});
      var1.b(new ItemStack(Blocks.MOSSY_COBBLESTONE, 1), new Object[]{Blocks.COBBLESTONE, Blocks.VINE});
      var1.a(new ItemStack(Blocks.IRON_BARS, 16), new Object[]{"###", "###", Character.valueOf('#'), Items.IRON_INGOT});
      var1.a(new ItemStack(Blocks.GLASS_PANE, 16), new Object[]{"###", "###", Character.valueOf('#'), Blocks.GLASS});
      var1.a(new ItemStack(Blocks.REDSTONE_LAMP, 1), new Object[]{" R ", "RGR", " R ", Character.valueOf('R'), Items.REDSTONE, Character.valueOf('G'), Blocks.GLOWSTONE});
      var1.a(new ItemStack(Blocks.BEACON, 1), new Object[]{"GGG", "GSG", "OOO", Character.valueOf('G'), Blocks.GLASS, Character.valueOf('S'), Items.NETHER_STAR, Character.valueOf('O'), Blocks.OBSIDIAN});
      var1.a(new ItemStack(Blocks.NETHER_BRICK, 1), new Object[]{"NN", "NN", Character.valueOf('N'), Items.NETHERBRICK});
      var1.a(new ItemStack(Blocks.STONE, 2, BlockStone.EnumStoneVariant.DIORITE.getData()), new Object[]{"CQ", "QC", Character.valueOf('C'), Blocks.COBBLESTONE, Character.valueOf('Q'), Items.QUARTZ});
      var1.b(new ItemStack(Blocks.STONE, 1, BlockStone.EnumStoneVariant.GRANITE.getData()), new Object[]{new ItemStack(Blocks.STONE, 1, BlockStone.EnumStoneVariant.DIORITE.getData()), Items.QUARTZ});
      var1.b(new ItemStack(Blocks.STONE, 2, BlockStone.EnumStoneVariant.ANDESITE.getData()), new Object[]{new ItemStack(Blocks.STONE, 1, BlockStone.EnumStoneVariant.DIORITE.getData()), Blocks.COBBLESTONE});
      var1.a(new ItemStack(Blocks.DIRT, 4, BlockDirt.EnumDirtVariant.COARSE_DIRT.getId()), new Object[]{"DG", "GD", Character.valueOf('D'), new ItemStack(Blocks.DIRT, 1, BlockDirt.EnumDirtVariant.DIRT.getId()), Character.valueOf('G'), Blocks.GRAVEL});
      var1.a(new ItemStack(Blocks.STONE, 4, BlockStone.EnumStoneVariant.DIORITE_SMOOTH.getData()), new Object[]{"SS", "SS", Character.valueOf('S'), new ItemStack(Blocks.STONE, 1, BlockStone.EnumStoneVariant.DIORITE.getData())});
      var1.a(new ItemStack(Blocks.STONE, 4, BlockStone.EnumStoneVariant.GRANITE_SMOOTH.getData()), new Object[]{"SS", "SS", Character.valueOf('S'), new ItemStack(Blocks.STONE, 1, BlockStone.EnumStoneVariant.GRANITE.getData())});
      var1.a(new ItemStack(Blocks.STONE, 4, BlockStone.EnumStoneVariant.ANDESITE_SMOOTH.getData()), new Object[]{"SS", "SS", Character.valueOf('S'), new ItemStack(Blocks.STONE, 1, BlockStone.EnumStoneVariant.ANDESITE.getData())});
      var1.a(new ItemStack(Blocks.PRISMARINE, 1, class_akc.b), new Object[]{"SS", "SS", Character.valueOf('S'), Items.PRISMARINE_SHARD});
      var1.a(new ItemStack(Blocks.PRISMARINE, 1, class_akc.N), new Object[]{"SSS", "SSS", "SSS", Character.valueOf('S'), Items.PRISMARINE_SHARD});
      var1.a(new ItemStack(Blocks.PRISMARINE, 1, class_akc.O), new Object[]{"SSS", "SIS", "SSS", Character.valueOf('S'), Items.PRISMARINE_SHARD, Character.valueOf('I'), new ItemStack(Items.DYE, 1, EnumColor.p.b())});
      var1.a(new ItemStack(Blocks.SEA_LANTERN, 1, 0), new Object[]{"SCS", "CCC", "SCS", Character.valueOf('S'), Items.PRISMARINE_SHARD, Character.valueOf('C'), Items.PRISMARINE_CRYSTALS});
      var1.a(new ItemStack(Blocks.PURPUR_BLOCK, 4, 0), new Object[]{"FF", "FF", Character.valueOf('F'), Items.CHORUS_FRUIT_POPPED});
      var1.a(new ItemStack(Blocks.PURPUR_STAIRS, 4, 0), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), Blocks.PURPUR_BLOCK});
      var1.a(new ItemStack(Blocks.PURPUR_PILLAR, 1, 0), new Object[]{"#", "#", Character.valueOf('#'), Blocks.PURPUR_SLAB});
      var1.a(new ItemStack(Blocks.END_BRICKS, 4, 0), new Object[]{"##", "##", Character.valueOf('#'), Blocks.END_STONE});
   }
}
