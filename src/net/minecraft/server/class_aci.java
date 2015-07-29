package net.minecraft.server;

import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_act;

public class class_aci {
   private String[][] a = new String[][]{{"XXX", "X X"}, {"X X", "XXX", "XXX"}, {"XXX", "X X", "X X"}, {"X X", "X X"}};
   private class_aar[][] b;

   public class_aci() {
      this.b = new class_aar[][]{{class_aau.aH, class_aau.l, class_aau.k, class_aau.m}, {class_aau.S, class_aau.aa, class_aau.ae, class_aau.ai}, {class_aau.T, class_aau.ab, class_aau.af, class_aau.aj}, {class_aau.U, class_aau.ac, class_aau.ag, class_aau.ak}, {class_aau.V, class_aau.ad, class_aau.ah, class_aau.al}};
   }

   public void a(class_act var1) {
      for(int var2 = 0; var2 < this.b[0].length; ++var2) {
         class_aar var3 = this.b[0][var2];

         for(int var4 = 0; var4 < this.b.length - 1; ++var4) {
            class_aar var5 = this.b[var4 + 1][var2];
            var1.a(new class_aas(var5), new Object[]{this.a[var4], Character.valueOf('X'), var3});
         }
      }

   }
}
