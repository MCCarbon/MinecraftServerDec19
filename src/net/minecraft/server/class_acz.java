package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Items;
import net.minecraft.server.class_act;
import net.minecraft.server.Blocks;

public class class_acz {
   private String[][] a = new String[][]{{"X", "X", "#"}};
   private Object[][] b;

   public class_acz() {
      this.b = new Object[][]{{Blocks.PLANKS, Blocks.COBBLESTONE, Items.l, Items.k, Items.m}, {Items.o, Items.s, Items.n, Items.w, Items.D}};
   }

   public void a(class_act var1) {
      for(int var2 = 0; var2 < this.b[0].length; ++var2) {
         Object var3 = this.b[0][var2];

         for(int var4 = 0; var4 < this.b.length - 1; ++var4) {
            Item var5 = (Item)this.b[var4 + 1][var2];
            var1.a(new ItemStack(var5), new Object[]{this.a[var4], Character.valueOf('#'), Items.A, Character.valueOf('X'), var3});
         }
      }

      var1.a(new ItemStack(Items.f, 1), new Object[]{" #X", "# X", " #X", Character.valueOf('X'), Items.H, Character.valueOf('#'), Items.A});
      var1.a(new ItemStack(Items.g, 4), new Object[]{"X", "#", "Y", Character.valueOf('Y'), Items.I, Character.valueOf('X'), Items.am, Character.valueOf('#'), Items.A});
      var1.a(new ItemStack(Items.h, 2), new Object[]{" # ", "#X#", " # ", Character.valueOf('X'), Items.g, Character.valueOf('#'), Items.aV});
   }
}
