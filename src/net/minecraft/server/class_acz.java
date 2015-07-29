package net.minecraft.server;

import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_act;
import net.minecraft.server.class_agk;

public class class_acz {
   private String[][] a = new String[][]{{"X", "X", "#"}};
   private Object[][] b;

   public class_acz() {
      this.b = new Object[][]{{class_agk.f, class_agk.e, class_aau.l, class_aau.k, class_aau.m}, {class_aau.o, class_aau.s, class_aau.n, class_aau.w, class_aau.D}};
   }

   public void a(class_act var1) {
      for(int var2 = 0; var2 < this.b[0].length; ++var2) {
         Object var3 = this.b[0][var2];

         for(int var4 = 0; var4 < this.b.length - 1; ++var4) {
            class_aar var5 = (class_aar)this.b[var4 + 1][var2];
            var1.a(new class_aas(var5), new Object[]{this.a[var4], Character.valueOf('#'), class_aau.A, Character.valueOf('X'), var3});
         }
      }

      var1.a(new class_aas(class_aau.f, 1), new Object[]{" #X", "# X", " #X", Character.valueOf('X'), class_aau.H, Character.valueOf('#'), class_aau.A});
      var1.a(new class_aas(class_aau.g, 4), new Object[]{"X", "#", "Y", Character.valueOf('Y'), class_aau.I, Character.valueOf('X'), class_aau.am, Character.valueOf('#'), class_aau.A});
      var1.a(new class_aas(class_aau.h, 2), new Object[]{" # ", "#X#", " # ", Character.valueOf('X'), class_aau.g, Character.valueOf('#'), class_aau.aV});
   }
}
