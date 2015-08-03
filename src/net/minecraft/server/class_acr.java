package net.minecraft.server;

import net.minecraft.server.ItemStack;
import net.minecraft.server.Items;
import net.minecraft.server.class_act;
import net.minecraft.server.Block;
import net.minecraft.server.BlockStainedGlassPane;
import net.minecraft.server.EnumColor;

public class class_acr {
   private Object[][] a;

   public class_acr() {
      this.a = new Object[][]{{BlockStainedGlassPane.GOLD_BLOCK, new ItemStack(Items.GOLD_INGOT, 9)}, {BlockStainedGlassPane.IRON_BLOCK, new ItemStack(Items.IRON_INGOT, 9)}, {BlockStainedGlassPane.DIAMOND_BLOCK, new ItemStack(Items.DIAMOND, 9)}, {BlockStainedGlassPane.EMERALD_BLOCK, new ItemStack(Items.bR, 9)}, {BlockStainedGlassPane.LAPIS_BLOCK, new ItemStack(Items.aY, 9, EnumColor.l.b())}, {BlockStainedGlassPane.REDSTONE_BLOCK, new ItemStack(Items.aE, 9)}, {BlockStainedGlassPane.COAL_BLOCK, new ItemStack(Items.COAL, 9, 0)}, {BlockStainedGlassPane.HAY_BLOCK, new ItemStack(Items.Q, 9)}, {BlockStainedGlassPane.SLINE, new ItemStack(Items.aO, 9)}};
   }

   public void a(class_act var1) {
      for(int var2 = 0; var2 < this.a.length; ++var2) {
         Block var3 = (Block)this.a[var2][0];
         ItemStack var4 = (ItemStack)this.a[var2][1];
         var1.a(new ItemStack(var3), new Object[]{"###", "###", "###", Character.valueOf('#'), var4});
         var1.a(var4, new Object[]{"#", Character.valueOf('#'), var3});
      }

      var1.a(new ItemStack(Items.GOLD_INGOT), new Object[]{"###", "###", "###", Character.valueOf('#'), Items.bz});
      var1.a(new ItemStack(Items.bz, 9), new Object[]{"#", Character.valueOf('#'), Items.GOLD_INGOT});
   }
}
