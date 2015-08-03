package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Items;
import net.minecraft.server.class_act;

public class class_aci {
   private String[][] a = new String[][]{{"XXX", "X X"}, {"X X", "XXX", "XXX"}, {"XXX", "X X", "X X"}, {"X X", "X X"}};
   private Item[][] b;

   public class_aci() {
      this.b = new Item[][]{{Items.aH, Items.IRON_INGOT, Items.DIAMOND, Items.GOLD_INGOT}, {Items.S, Items.aa, Items.ae, Items.ai}, {Items.T, Items.ab, Items.af, Items.aj}, {Items.U, Items.ac, Items.ag, Items.ak}, {Items.V, Items.ad, Items.ah, Items.al}};
   }

   public void a(class_act var1) {
      for(int var2 = 0; var2 < this.b[0].length; ++var2) {
         Item var3 = this.b[0][var2];

         for(int var4 = 0; var4 < this.b.length - 1; ++var4) {
            Item var5 = this.b[var4 + 1][var2];
            var1.a(new ItemStack(var5), new Object[]{this.a[var4], Character.valueOf('X'), var3});
         }
      }

   }
}
