package net.minecraft.server;

import net.minecraft.server.class_aas;
import net.minecraft.server.Items;
import net.minecraft.server.class_act;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_zy;

public class class_acr {
   private Object[][] a;

   public class_acr() {
      this.a = new Object[][]{{Blocks.GOLD_BLOCK, new class_aas(Items.m, 9)}, {Blocks.IRON_BLOCK, new class_aas(Items.l, 9)}, {Blocks.DIAMOND_BLOCK, new class_aas(Items.k, 9)}, {Blocks.EMERALD_BLOCK, new class_aas(Items.bR, 9)}, {Blocks.LAPIS_BLOCK, new class_aas(Items.aY, 9, class_zy.l.b())}, {Blocks.REDSTONE_BLOCK, new class_aas(Items.aE, 9)}, {Blocks.COAL_BLOCK, new class_aas(Items.j, 9, 0)}, {Blocks.HAY_BLOCK, new class_aas(Items.Q, 9)}, {Blocks.SLINE, new class_aas(Items.aO, 9)}};
   }

   public void a(class_act var1) {
      for(int var2 = 0; var2 < this.a.length; ++var2) {
         Block var3 = (Block)this.a[var2][0];
         class_aas var4 = (class_aas)this.a[var2][1];
         var1.a(new class_aas(var3), new Object[]{"###", "###", "###", Character.valueOf('#'), var4});
         var1.a(var4, new Object[]{"#", Character.valueOf('#'), var3});
      }

      var1.a(new class_aas(Items.m), new Object[]{"###", "###", "###", Character.valueOf('#'), Items.bz});
      var1.a(new class_aas(Items.bz, 9), new Object[]{"#", Character.valueOf('#'), Items.m});
   }
}
