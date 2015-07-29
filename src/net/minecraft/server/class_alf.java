package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_ahp;
import net.minecraft.server.class_ajd;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;

public class class_alf extends class_ajd {
   protected class_alf(class_atk var1) {
      super(var1);
      this.a(false);
      if(var1 == class_atk.i) {
         this.a(true);
      }

   }

   public void a(class_aen var1, class_cj var2, class_anl var3, class_agj var4) {
      if(!this.e(var1, var2, var3)) {
         this.f(var1, var2, var3);
      }

   }

   private void f(class_aen var1, class_cj var2, class_anl var3) {
      class_ahp var4 = a(this.J);
      var1.a((class_cj)var2, (class_anl)var4.S().a(b, var3.b(b)), 2);
      var1.a((class_cj)var2, (class_agj)var4, this.a(var1));
   }

   public void b(class_aen var1, class_cj var2, class_anl var3, Random var4) {
      if(this.J == class_atk.i) {
         if(var1.R().b("doFireTick")) {
            int var5 = var4.nextInt(3);
            if(var5 > 0) {
               class_cj var6 = var2;

               for(int var7 = 0; var7 < var5; ++var7) {
                  var6 = var6.a(var4.nextInt(3) - 1, 1, var4.nextInt(3) - 1);
                  class_agj var8 = var1.p(var6).c();
                  if(var8.J == class_atk.a) {
                     if(this.f(var1, var6)) {
                        var1.a(var6, class_agk.ab.S());
                        return;
                     }
                  } else if(var8.J.c()) {
                     return;
                  }
               }
            } else {
               for(int var9 = 0; var9 < 3; ++var9) {
                  class_cj var10 = var2.a(var4.nextInt(3) - 1, 0, var4.nextInt(3) - 1);
                  if(var1.d(var10.a()) && this.m(var1, var10)) {
                     var1.a(var10.a(), class_agk.ab.S());
                  }
               }
            }

         }
      }
   }

   protected boolean f(class_aen var1, class_cj var2) {
      class_cq[] var3 = class_cq.values();
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         class_cq var6 = var3[var5];
         if(this.m(var1, var2.a(var6))) {
            return true;
         }
      }

      return false;
   }

   private boolean m(class_aen var1, class_cj var2) {
      return var1.p(var2).c().v().h();
   }
}
