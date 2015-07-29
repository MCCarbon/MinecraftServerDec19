package net.minecraft.server;

import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_aky;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_zg;

public class class_zh extends class_aar {
   private class_agj a;

   public class_zh(class_agj var1) {
      this.a = var1;
   }

   public class_oq a(class_aas var1, class_xa var2, class_aen var3, class_cj var4, class_oo var5, class_cq var6, float var7, float var8, float var9) {
      class_anl var10 = var3.p(var4);
      class_agj var11 = var10.c();
      if(var11 == class_agk.aH && ((Integer)var10.b(class_aky.a)).intValue() < 1) {
         var6 = class_cq.b;
      } else if(!var11.a(var3, var4)) {
         var4 = var4.a(var6);
      }

      if(!var2.a(var4, var6, var1)) {
         return class_oq.b;
      } else if(var1.b == 0) {
         return class_oq.b;
      } else {
         if(var3.a(this.a, var4, false, var6, (class_pr)null, var1)) {
            class_anl var12 = this.a.a(var3, var4, var6, var7, var8, var9, 0, var2);
            if(var3.a((class_cj)var4, (class_anl)var12, 3)) {
               var12 = var3.p(var4);
               if(var12.c() == this.a) {
                  class_zg.a(var3, var2, var4, var1);
                  var12.c().a(var3, var4, var12, var2, var1);
               }

               var3.a((double)((float)var4.n() + 0.5F), (double)((float)var4.o() + 0.5F), (double)((float)var4.p() + 0.5F), this.a.H.b(), (this.a.H.d() + 1.0F) / 2.0F, this.a.H.e() * 0.8F);
               --var1.b;
               return class_oq.a;
            }
         }

         return class_oq.b;
      }
   }
}
