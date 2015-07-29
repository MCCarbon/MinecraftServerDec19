package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_adk;
import net.minecraft.server.class_adm;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_aet;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_aiq;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_nc;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_zu;

public class class_aix extends class_aiq {
   public class_aix() {
      super(class_atk.w, false);
      this.L = 0.98F;
      this.a(true);
      this.a(class_zu.b);
   }

   public void a(class_aen var1, class_xa var2, class_cj var3, class_anl var4, class_amg var5, class_aas var6) {
      var2.b(class_nc.ab[class_agj.a((class_agj)this)]);
      var2.a(0.025F);
      if(this.K() && class_adk.a(class_adm.q, var6) > 0) {
         class_aas var9 = this.i(var4);
         if(var9 != null) {
            a(var1, var3, var9);
         }
      } else {
         if(var1.t.l()) {
            var1.g(var3);
            return;
         }

         int var7 = class_adk.a(class_adm.s, var6);
         this.b(var1, var3, var4, var7);
         class_atk var8 = var1.p(var3.b()).c().v();
         if(var8.c() || var8.d()) {
            var1.a(var3, class_agk.i.S());
         }
      }

   }

   public int a(Random var1) {
      return 0;
   }

   public void b(class_aen var1, class_cj var2, class_anl var3, Random var4) {
      if(var1.b(class_aet.b, var2) > 11 - this.r()) {
         if(var1.t.l()) {
            var1.g(var2);
         } else {
            this.b(var1, var2, var1.p(var2), 0);
            var1.a(var2, class_agk.j.S());
         }
      }
   }

   public int k() {
      return 0;
   }
}
