package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.class_aas;
import net.minecraft.server.Items;
import net.minecraft.server.class_act;
import net.minecraft.server.Blocks;

public class class_acy {
   private String[][] a = new String[][]{{"XXX", " # ", " # "}, {"X", "#", "#"}, {"XX", "X#", " #"}, {"XX", " #", " #"}};
   private Object[][] b;

   public class_acy() {
      this.b = new Object[][]{{Blocks.PLANKS, Blocks.COBBLESTONE, Items.l, Items.k, Items.m}, {Items.q, Items.u, Items.b, Items.y, Items.F}, {Items.p, Items.t, Items.a, Items.x, Items.E}, {Items.r, Items.v, Items.c, Items.z, Items.G}, {Items.K, Items.L, Items.M, Items.N, Items.O}};
   }

   public void a(class_act var1) {
      for(int var2 = 0; var2 < this.b[0].length; ++var2) {
         Object var3 = this.b[0][var2];

         for(int var4 = 0; var4 < this.b.length - 1; ++var4) {
            Item var5 = (Item)this.b[var4 + 1][var2];
            var1.a(new class_aas(var5), new Object[]{this.a[var4], Character.valueOf('#'), Items.A, Character.valueOf('X'), var3});
         }
      }

      var1.a(new class_aas(Items.bg), new Object[]{" #", "# ", Character.valueOf('#'), Items.l});
   }
}
