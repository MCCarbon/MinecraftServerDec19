package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Items;
import net.minecraft.server.class_act;
import net.minecraft.server.BlockStainedGlassPane;

public class class_acz {
   private String[][] a = new String[][]{{"X", "X", "#"}};
   private Object[][] b;

   public class_acz() {
      this.b = new Object[][]{{BlockStainedGlassPane.PLANKS, BlockStainedGlassPane.COBBLESTONE, Items.IRON_INGOT, Items.DIAMOND, Items.GOLD_INGOT}, {Items.WOODEN_SWORD, Items.STONE_SWORD, Items.IRON_SWORD, Items.DIAMOND_SWORD, Items.GOLDEN_SWORD}};
   }

   public void a(class_act var1) {
      for(int var2 = 0; var2 < this.b[0].length; ++var2) {
         Object var3 = this.b[0][var2];

         for(int var4 = 0; var4 < this.b.length - 1; ++var4) {
            Item var5 = (Item)this.b[var4 + 1][var2];
            var1.a(new ItemStack(var5), new Object[]{this.a[var4], Character.valueOf('#'), Items.STICK, Character.valueOf('X'), var3});
         }
      }

      var1.a(new ItemStack(Items.BOW, 1), new Object[]{" #X", "# X", " #X", Character.valueOf('X'), Items.H, Character.valueOf('#'), Items.STICK});
      var1.a(new ItemStack(Items.ARROW, 4), new Object[]{"X", "#", "Y", Character.valueOf('Y'), Items.I, Character.valueOf('X'), Items.am, Character.valueOf('#'), Items.STICK});
      var1.a(new ItemStack(Items.SPECTRAL_ARROW, 2), new Object[]{" # ", "#X#", " # ", Character.valueOf('X'), Items.ARROW, Character.valueOf('#'), Items.aV});
   }
}
