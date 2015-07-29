package net.minecraft.server;

import net.minecraft.server.class_aas;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_act;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_zy;

public class class_acr {
   private Object[][] a;

   public class_acr() {
      this.a = new Object[][]{{class_agk.R, new class_aas(class_aau.m, 9)}, {class_agk.S, new class_aas(class_aau.l, 9)}, {class_agk.ah, new class_aas(class_aau.k, 9)}, {class_agk.bT, new class_aas(class_aau.bR, 9)}, {class_agk.y, new class_aas(class_aau.aY, 9, class_zy.l.b())}, {class_agk.cn, new class_aas(class_aau.aE, 9)}, {class_agk.cA, new class_aas(class_aau.j, 9, 0)}, {class_agk.cx, new class_aas(class_aau.Q, 9)}, {class_agk.cE, new class_aas(class_aau.aO, 9)}};
   }

   public void a(class_act var1) {
      for(int var2 = 0; var2 < this.a.length; ++var2) {
         class_agj var3 = (class_agj)this.a[var2][0];
         class_aas var4 = (class_aas)this.a[var2][1];
         var1.a(new class_aas(var3), new Object[]{"###", "###", "###", Character.valueOf('#'), var4});
         var1.a(var4, new Object[]{"#", Character.valueOf('#'), var3});
      }

      var1.a(new class_aas(class_aau.m), new Object[]{"###", "###", "###", Character.valueOf('#'), class_aau.bz});
      var1.a(new class_aas(class_aau.bz, 9), new Object[]{"#", Character.valueOf('#'), class_aau.m});
   }
}
