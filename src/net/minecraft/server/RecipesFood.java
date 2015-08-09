package net.minecraft.server;

public class RecipesFood {
   public void a(CraftingManager var1) {
      var1.registerShapelessRecipe(new ItemStack(Items.MUSHROOM_STEW), new Object[]{Blocks.BROWN_MUSHROOM, Blocks.RED_MUSHROOM, Items.BOWL});
      var1.registerShapedRecipe(new ItemStack(Items.COOKIE, 8), new Object[]{"#X#", Character.valueOf('X'), new ItemStack(Items.DYE, 1, EnumColor.m.b()), Character.valueOf('#'), Items.WHEAT});
      var1.registerShapedRecipe(new ItemStack(Items.RABBIT_STEW), new Object[]{" R ", "CPM", " B ", Character.valueOf('R'), new ItemStack(Items.COOKED_RABBIT), Character.valueOf('C'), Items.CARROT, Character.valueOf('P'), Items.BAKED_POTATO, Character.valueOf('M'), Blocks.BROWN_MUSHROOM, Character.valueOf('B'), Items.BOWL});
      var1.registerShapedRecipe(new ItemStack(Items.RABBIT_STEW), new Object[]{" R ", "CPD", " B ", Character.valueOf('R'), new ItemStack(Items.COOKED_RABBIT), Character.valueOf('C'), Items.CARROT, Character.valueOf('P'), Items.BAKED_POTATO, Character.valueOf('D'), Blocks.RED_MUSHROOM, Character.valueOf('B'), Items.BOWL});
      var1.registerShapedRecipe(new ItemStack(Blocks.MELON_BLOCK), new Object[]{"MMM", "MMM", "MMM", Character.valueOf('M'), Items.MELON});
      var1.registerShapedRecipe(new ItemStack(Items.BEETROOT_SOUP), new Object[]{"OOO", "OOO", " B ", Character.valueOf('O'), Items.BEETROOT, Character.valueOf('B'), Items.BOWL});
      var1.registerShapedRecipe(new ItemStack(Items.MELON_SEEDS), new Object[]{"M", Character.valueOf('M'), Items.MELON});
      var1.registerShapedRecipe(new ItemStack(Items.PUMPKIN_SEEDS, 4), new Object[]{"M", Character.valueOf('M'), Blocks.PUMPKIN});
      var1.registerShapelessRecipe(new ItemStack(Items.PUMPKIN_PIE), new Object[]{Blocks.PUMPKIN, Items.SUGAR, Items.EGG});
      var1.registerShapelessRecipe(new ItemStack(Items.FERMENTED_SPIDER_EYE), new Object[]{Items.SPIDER_EYE, Blocks.BROWN_MUSHROOM, Items.SUGAR});
      var1.registerShapelessRecipe(new ItemStack(Items.BLAZE_POWDER, 2), new Object[]{Items.BLAZE_ROD});
      var1.registerShapelessRecipe(new ItemStack(Items.MAGMA_CREAM), new Object[]{Items.BLAZE_POWDER, Items.SLIME_BALL});
   }
}
