package net.minecraft.server;

public class class_acy {
   private String[][] a = new String[][]{{"XXX", " # ", " # "}, {"CHAINMAIL_CHESTPLATE", "#", "#"}, {"XX", "CHAINMAIL_CHESTPLATE#", " #"}, {"XX", " #", " #"}};
   private Object[][] b;

   public class_acy() {
      this.b = new Object[][]{{Blocks.PLANKS, Blocks.COBBLESTONE, Items.IRON_INGOT, Items.DIAMOND, Items.GOLD_INGOT}, {Items.WOODEN_PICKAXE, Items.STONE_PICKAXE, Items.IRON_PICKAXE, Items.DIAMOND_PICKAXE, Items.GOLDEN_PICKAXE}, {Items.WOODEN_SHOVEL, Items.STONE_SHOVEL, Items.IRON_SHOVEL, Items.DIAMOND_SHOVEL, Items.GOLDEN_SHOVEL}, {Items.WOODEN_AXE, Items.STONE_AXE, Items.IRON_AXE, Items.DIAMOND_AXE, Items.GOLDEN_AXE}, {Items.WOODEN_HOE, Items.STONE_HOE, Items.IRON_HOE, Items.DIAMOND_HOE, Items.GOLDEN_HOE}};
   }

   public void a(class_act var1) {
      for(int var2 = 0; var2 < this.b[0].length; ++var2) {
         Object var3 = this.b[0][var2];

         for(int var4 = 0; var4 < this.b.length - 1; ++var4) {
            Item var5 = (Item)this.b[var4 + 1][var2];
            var1.a(new ItemStack(var5), new Object[]{this.a[var4], Character.valueOf('#'), Items.STICK, Character.valueOf('CHAINMAIL_CHESTPLATE'), var3});
         }
      }

      var1.a(new ItemStack(Items.SHEARS), new Object[]{" #", "# ", Character.valueOf('#'), Items.IRON_INGOT});
   }
}
