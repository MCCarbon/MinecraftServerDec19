package net.minecraft.server;

public class RecipesArmor {
   private String[][] a = new String[][]{{"XXX", "X X"}, {"X X", "XXX", "XXX"}, {"XXX", "X X", "X X"}, {"X X", "X X"}};
   private Item[][] b;

   public RecipesArmor() {
      this.b = new Item[][]{{Items.LEATHER, Items.IRON_INGOT, Items.DIAMOND, Items.GOLD_INGOT}, {Items.LEATHER_HELMET, Items.IRON_HELMET, Items.DIAMOND_HELMET, Items.GOLDEN_HELMET}, {Items.LEATHER_CHESTPLATE, Items.IRON_CHESTPLATE, Items.DIAMOND_CHESTPLATE, Items.GOLDEN_CHESTPLATE}, {Items.LEATHER_LEGGINGS, Items.IRON_LEGGINGS, Items.DIAMOND_LEGGINGS, Items.GOLDEN_LEGGINGS}, {Items.LEATHER_BOOTS, Items.IRON_BOOTS, Items.DIAMOND_BOOTS, Items.GOLDEN_BOOTS}};
   }

   public void a(CraftingManager var1) {
      for(int var2 = 0; var2 < this.b[0].length; ++var2) {
         Item var3 = this.b[0][var2];

         for(int var4 = 0; var4 < this.b.length - 1; ++var4) {
            Item var5 = this.b[var4 + 1][var2];
            var1.registerShapedRecipe(new ItemStack(var5), new Object[]{this.a[var4], Character.valueOf('X'), var3});
         }
      }

   }
}
