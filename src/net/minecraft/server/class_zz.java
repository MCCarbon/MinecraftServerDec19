package net.minecraft.server;

import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_agl;
import net.minecraft.server.class_ajw;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_uf;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_zu;
import net.minecraft.server.class_zy;

public class class_zz extends class_aar {
   public static final int[] a = new int[]{1973019, 11743532, 3887386, 5320730, 2437522, 8073150, 2651799, 11250603, 4408131, 14188952, 4312372, 14602026, 6719955, 12801229, 15435844, 15790320};

   public class_zz() {
      this.a(true);
      this.e(0);
      this.a(class_zu.l);
   }

   public String e_(class_aas var1) {
      int var2 = var1.i();
      return super.a() + "." + class_zy.a(var2).d();
   }

   public class_oq a(class_aas var1, class_xa var2, class_aen var3, class_cj var4, class_oo var5, class_cq var6, float var7, float var8, float var9) {
      if(!var2.a(var4.a(var6), var6, var1)) {
         return class_oq.b;
      } else {
         class_zy var10 = class_zy.a(var1.i());
         if(var10 == class_zy.a) {
            if(a(var1, var3, var4)) {
               if(!var3.D) {
                  var3.b(2005, var4, 0);
               }

               return class_oq.a;
            }
         } else if(var10 == class_zy.m) {
            class_anl var11 = var3.p(var4);
            class_agj var12 = var11.c();
            if(var12 == class_agk.r && var11.b(class_ajw.a) == class_ajw.class_a_in_class_ajw.d) {
               if(var6 == class_cq.a) {
                  return class_oq.b;
               }

               if(var6 == class_cq.b) {
                  return class_oq.b;
               }

               var4 = var4.a(var6);
               if(var3.d(var4)) {
                  class_anl var13 = class_agk.bN.a(var3, var4, var6, var7, var8, var9, 0, var2);
                  var3.a((class_cj)var4, (class_anl)var13, 2);
                  if(!var2.bH.d) {
                     --var1.b;
                  }
               }

               return class_oq.a;
            }
         }

         return class_oq.b;
      }
   }

   public static boolean a(class_aas var0, class_aen var1, class_cj var2) {
      class_anl var3 = var1.p(var2);
      if(var3.c() instanceof class_agl) {
         class_agl var4 = (class_agl)var3.c();
         if(var4.a(var1, var2, var3, var1.D)) {
            if(!var1.D) {
               if(var4.a(var1, var1.s, var2, var3)) {
                  var4.b(var1, var1.s, var2, var3);
               }

               --var0.b;
            }

            return true;
         }
      }

      return false;
   }

   public boolean a(class_aas var1, class_xa var2, class_qa var3, class_oo var4) {
      if(var3 instanceof class_uf) {
         class_uf var5 = (class_uf)var3;
         class_zy var6 = class_zy.a(var1.i());
         if(!var5.cB() && var5.cA() != var6) {
            var5.b(var6);
            --var1.b;
         }

         return true;
      } else {
         return false;
      }
   }
}
