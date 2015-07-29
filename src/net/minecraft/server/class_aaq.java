package net.minecraft.server;

import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_ahj;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_zu;

public class class_aaq extends class_aar {
   protected class_aar.class_a_in_class_aar a;

   public class_aaq(class_aar.class_a_in_class_aar var1) {
      this.a = var1;
      this.h = 1;
      this.e(var1.a());
      this.a(class_zu.i);
   }

   public class_oq a(class_aas var1, class_xa var2, class_aen var3, class_cj var4, class_oo var5, class_cq var6, float var7, float var8, float var9) {
      if(!var2.a(var4.a(var6), var6, var1)) {
         return class_oq.b;
      } else {
         class_anl var10 = var3.p(var4);
         class_agj var11 = var10.c();
         if(var6 != class_cq.a && var3.p(var4.a()).c().v() == class_atk.a) {
            if(var11 == class_agk.c || var11 == class_agk.da) {
               return this.a(var1, var2, var3, var4, class_agk.ak.S());
            }

            if(var11 == class_agk.d) {
               switch(class_aaq.SyntheticClass_1.a[((class_ahj.class_a_in_class_ahj)var10.b(class_ahj.a)).ordinal()]) {
               case 1:
                  return this.a(var1, var2, var3, var4, class_agk.ak.S());
               case 2:
                  return this.a(var1, var2, var3, var4, class_agk.d.S().a(class_ahj.a, class_ahj.class_a_in_class_ahj.a));
               }
            }
         }

         return class_oq.b;
      }
   }

   protected class_oq a(class_aas var1, class_xa var2, class_aen var3, class_cj var4, class_anl var5) {
      var3.a((double)((float)var4.n() + 0.5F), (double)((float)var4.o() + 0.5F), (double)((float)var4.p() + 0.5F), var5.c().H.c(), (var5.c().H.d() + 1.0F) / 2.0F, var5.c().H.e() * 0.8F);
      if(var3.D) {
         return class_oq.a;
      } else {
         var3.a(var4, var5);
         var1.a(1, (class_qa)var2);
         return class_oq.a;
      }
   }

   public String g() {
      return this.a.toString();
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a = new int[class_ahj.class_a_in_class_ahj.values().length];

      static {
         try {
            a[class_ahj.class_a_in_class_ahj.a.ordinal()] = 1;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[class_ahj.class_a_in_class_ahj.b.ordinal()] = 2;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
