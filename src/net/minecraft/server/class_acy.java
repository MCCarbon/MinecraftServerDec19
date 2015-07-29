package net.minecraft.server;

import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_act;
import net.minecraft.server.class_agk;

public class class_acy {
   private String[][] a = new String[][]{{"XXX", " # ", " # "}, {"X", "#", "#"}, {"XX", "X#", " #"}, {"XX", " #", " #"}};
   private Object[][] b;

   public class_acy() {
      this.b = new Object[][]{{class_agk.f, class_agk.e, class_aau.l, class_aau.k, class_aau.m}, {class_aau.q, class_aau.u, class_aau.b, class_aau.y, class_aau.F}, {class_aau.p, class_aau.t, class_aau.a, class_aau.x, class_aau.E}, {class_aau.r, class_aau.v, class_aau.c, class_aau.z, class_aau.G}, {class_aau.K, class_aau.L, class_aau.M, class_aau.N, class_aau.O}};
   }

   public void a(class_act var1) {
      for(int var2 = 0; var2 < this.b[0].length; ++var2) {
         Object var3 = this.b[0][var2];

         for(int var4 = 0; var4 < this.b.length - 1; ++var4) {
            class_aar var5 = (class_aar)this.b[var4 + 1][var2];
            var1.a(new class_aas(var5), new Object[]{this.a[var4], Character.valueOf('#'), class_aau.A, Character.valueOf('X'), var3});
         }
      }

      var1.a(new class_aas(class_aau.bg), new Object[]{" #", "# ", Character.valueOf('#'), class_aau.l});
   }
}
