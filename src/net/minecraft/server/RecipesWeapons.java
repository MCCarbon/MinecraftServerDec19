package net.minecraft.server;

public class RecipesWeapons {
   private String[][] a = new String[][]{{"X", "X", "#"}};
   private Object[][] b;

   public RecipesWeapons() {
      this.b = new Object[][]{{Blocks.PLANKS, Blocks.COBBLESTONE, Items.IRON_INGOT, Items.DIAMOND, Items.GOLD_INGOT}, {Items.WOODEN_SWORD, Items.STONE_SWORD, Items.IRON_SWORD, Items.DIAMOND_SWORD, Items.GOLDEN_SWORD}};
   }

   public void a(CraftingManager var1) {
      for(int var2 = 0; var2 < this.b[0].length; ++var2) {
         Object var3 = this.b[0][var2];

         for(int var4 = 0; var4 < this.b.length - 1; ++var4) {
            Item var5 = (Item)this.b[var4 + 1][var2];
            var1.registerShapedRecipe(new ItemStack(var5), new Object[]{this.a[var4], Character.valueOf('#'), Items.STICK, Character.valueOf('X'), var3});
         }
      }

      var1.registerShapedRecipe(new ItemStack(Items.BOW, 1), new Object[]{" #X", "# X", " #X", Character.valueOf('X'), Items.STRING, Character.valueOf('#'), Items.STICK});
      var1.registerShapedRecipe(new ItemStack(Items.ARROW, 4), new Object[]{"X", "#", "Y", Character.valueOf('Y'), Items.FEATHER, Character.valueOf('X'), Items.FLINT, Character.valueOf('#'), Items.STICK});
      var1.registerShapedRecipe(new ItemStack(Items.SPECTRAL_ARROW, 2), new Object[]{" # ", "#X#", " # ", Character.valueOf('X'), Items.ARROW, Character.valueOf('#'), Items.GLOWSTONE_DUST});
   }
}
