package net.minecraft.server;

import net.minecraft.server.class_aas;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agd;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_amf;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_aok;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_atl;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_lg;
import net.minecraft.server.class_nc;
import net.minecraft.server.class_nl;
import net.minecraft.server.class_oj;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_zu;

public class class_agg extends class_agd {
   public class_agg() {
      super(class_atk.s, class_atl.G);
      this.c(3.0F);
      this.a(class_zu.f);
   }

   public class_amg a(class_aen var1, int var2) {
      return new class_amf();
   }

   public boolean a(class_aen var1, class_cj var2, class_anl var3, class_xa var4, class_oo var5, class_aas var6, class_cq var7, float var8, float var9, float var10) {
      if(var1.D) {
         return true;
      } else {
         class_amg var11 = var1.s(var2);
         if(var11 instanceof class_amf) {
            var4.a((class_oj)((class_amf)var11));
            var4.b(class_nc.N);
         }

         return true;
      }
   }

   public boolean c() {
      return false;
   }

   public boolean d() {
      return false;
   }

   public int b() {
      return 3;
   }

   public void a(class_aen var1, class_cj var2, class_anl var3, class_qa var4, class_aas var5) {
      super.a(var1, var2, var3, var4, var5);
      if(var5.s()) {
         class_amg var6 = var1.s(var2);
         if(var6 instanceof class_amf) {
            ((class_amf)var6).a(var5.q());
         }
      }

   }

   public void a(class_aen var1, class_cj var2, class_anl var3, class_agj var4) {
      class_amg var5 = var1.s(var2);
      if(var5 instanceof class_amf) {
         ((class_amf)var5).m();
         var1.c(var2, this, 1, 0);
      }

   }

   public static void f(final class_aen var0, final class_cj var1) {
      class_nl.a.submit(new Runnable() {
         public void run() {
            class_aok var1x = var0.f(var1);

            for(int var2 = var1.o() - 1; var2 >= 0; --var2) {
               final class_cj var3 = new class_cj(var1.n(), var2, var1.p());
               if(!var1x.d(var3)) {
                  break;
               }

               class_anl var4 = var0.p(var3);
               if(var4.c() == class_agk.bY) {
                  ((class_lg)var0).a(new Runnable() {
                     public void run() {
                        class_amg var1x = var0.s(var3);
                        if(var1x instanceof class_amf) {
                           ((class_amf)var1x).m();
                           var0.c(var3, class_agk.bY, 1, 0);
                        }

                     }
                  });
               }
            }

         }
      });
   }
}
