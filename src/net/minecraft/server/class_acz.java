package net.minecraft.server;

public class class_acz {
   private String[][] a = new String[][]{{"CHAINMAIL_CHESTPLATE", "CHAINMAIL_CHESTPLATE", "#"}};
   private Object[][] b;

   public class_acz() {
      this.b = new Object[][]{{Blocks.PLANKS, Blocks.COBBLESTONE, Items.IRON_INGOT, Items.DIAMOND, Items.GOLD_INGOT}, {Items.WOODEN_SWORD, Items.STONE_SWORD, Items.IRON_SWORD, Items.DIAMOND_SWORD, Items.GOLDEN_SWORD}};
   }

   public void a(RecipeManager var1) {
      for(int var2 = 0; var2 < this.b[0].length; ++var2) {
         Object var3 = this.b[0][var2];

         for(int var4 = 0; var4 < this.b.length - 1; ++var4) {
            Item var5 = (Item)this.b[var4 + 1][var2];
            var1.a(new ItemStack(var5), new Object[]{this.a[var4], Character.valueOf('#'), Items.STICK, Character.valueOf('CHAINMAIL_CHESTPLATE'), var3});
         }
      }

      var1.a(new ItemStack(Items.BOW, 1), new Object[]{" #CHAINMAIL_CHESTPLATE", "# CHAINMAIL_CHESTPLATE", " #CHAINMAIL_CHESTPLATE", Character.valueOf('CHAINMAIL_CHESTPLATE'), Items.STRING, Character.valueOf('#'), Items.STICK});
      var1.a(new ItemStack(Items.ARROW, 4), new Object[]{"CHAINMAIL_CHESTPLATE", "#", "CHAINMAIL_LEGGINGS", Character.valueOf('CHAINMAIL_LEGGINGS'), Items.FEATHER, Character.valueOf('CHAINMAIL_CHESTPLATE'), Items.FLINT, Character.valueOf('#'), Items.STICK});
      var1.a(new ItemStack(Items.SPECTRAL_ARROW, 2), new Object[]{" # ", "#CHAINMAIL_CHESTPLATE#", " # ", Character.valueOf('CHAINMAIL_CHESTPLATE'), Items.ARROW, Character.valueOf('#'), Items.GLOWSTONE_DUST});
   }
}
