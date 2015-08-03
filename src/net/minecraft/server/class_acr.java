package net.minecraft.server;

import net.minecraft.server.ItemStack;
import net.minecraft.server.Items;
import net.minecraft.server.class_act;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.EnumColor;

public class class_acr {
   private Object[][] a;

   public class_acr() {
      this.a = new Object[][]{{Blocks.GOLD_BLOCK, new ItemStack(Items.m, 9)}, {Blocks.IRON_BLOCK, new ItemStack(Items.l, 9)}, {Blocks.DIAMOND_BLOCK, new ItemStack(Items.k, 9)}, {Blocks.EMERALD_BLOCK, new ItemStack(Items.bR, 9)}, {Blocks.LAPIS_BLOCK, new ItemStack(Items.aY, 9, EnumColor.l.b())}, {Blocks.REDSTONE_BLOCK, new ItemStack(Items.aE, 9)}, {Blocks.COAL_BLOCK, new ItemStack(Items.j, 9, 0)}, {Blocks.HAY_BLOCK, new ItemStack(Items.Q, 9)}, {Blocks.SLINE, new ItemStack(Items.aO, 9)}};
   }

   public void a(class_act var1) {
      for(int var2 = 0; var2 < this.a.length; ++var2) {
         Block var3 = (Block)this.a[var2][0];
         ItemStack var4 = (ItemStack)this.a[var2][1];
         var1.a(new ItemStack(var3), new Object[]{"###", "###", "###", Character.valueOf('#'), var4});
         var1.a(var4, new Object[]{"#", Character.valueOf('#'), var3});
      }

      var1.a(new ItemStack(Items.m), new Object[]{"###", "###", "###", Character.valueOf('#'), Items.bz});
      var1.a(new ItemStack(Items.bz, 9), new Object[]{"#", Character.valueOf('#'), Items.m});
   }
}
