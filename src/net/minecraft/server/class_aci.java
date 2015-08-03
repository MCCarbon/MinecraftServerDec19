package net.minecraft.server;

public class class_aci {
   private String[][] a = new String[][]{{"XXX", "CHAINMAIL_CHESTPLATE CHAINMAIL_CHESTPLATE"}, {"CHAINMAIL_CHESTPLATE CHAINMAIL_CHESTPLATE", "XXX", "XXX"}, {"XXX", "CHAINMAIL_CHESTPLATE CHAINMAIL_CHESTPLATE", "CHAINMAIL_CHESTPLATE CHAINMAIL_CHESTPLATE"}, {"CHAINMAIL_CHESTPLATE CHAINMAIL_CHESTPLATE", "CHAINMAIL_CHESTPLATE CHAINMAIL_CHESTPLATE"}};
   private Item[][] b;

   public class_aci() {
      this.b = new Item[][]{{Items.LEATHER, Items.IRON_INGOT, Items.DIAMOND, Items.GOLD_INGOT}, {Items.LEATHER_HELMET, Items.IRON_HELMET, Items.DIAMOND_HELMET, Items.GOLDEN_HELMET}, {Items.LEATHER_CHESTPLATE, Items.ab, Items.DIAMOND_CHESTPLATE, Items.GOLDEN_CHESTPLATE}, {Items.LEATHER_LEGGINGS, Items.IRON_LEGGINGS, Items.DIAMOND_LEGGINGS, Items.GOLDEN_LEGGINGS}, {Items.LEATHER_BOOTS, Items.IRON_BOOTS, Items.DIAMOND_BOOTS, Items.GOLDEN_BOOTS}};
   }

   public void a(RecipeManager var1) {
      for(int var2 = 0; var2 < this.b[0].length; ++var2) {
         Item var3 = this.b[0][var2];

         for(int var4 = 0; var4 < this.b.length - 1; ++var4) {
            Item var5 = this.b[var4 + 1][var2];
            var1.a(new ItemStack(var5), new Object[]{this.a[var4], Character.valueOf('CHAINMAIL_CHESTPLATE'), var3});
         }
      }

   }
}
