package net.minecraft.server;

import net.minecraft.server.class_aer;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_aut;
import net.minecraft.server.class_auu;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_nu;
import net.minecraft.server.class_pr;

public class class_auy extends class_auu {
   public void a(class_aer var1, class_pr var2) {
      super.a(var1, var2);
   }

   public void a() {
      super.a();
   }

   public class_aut a(class_pr var1) {
      return this.a(class_nu.c(var1.aT().a), class_nu.c(var1.aT().b + 0.5D), class_nu.c(var1.aT().c));
   }

   public class_aut a(class_pr var1, double var2, double var4, double var6) {
      return this.a(class_nu.c(var2 - (double)(var1.J / 2.0F)), class_nu.c(var4 + 0.5D), class_nu.c(var6 - (double)(var1.J / 2.0F)));
   }

   public int a(class_aut[] var1, class_pr var2, class_aut var3, class_aut var4, float var5) {
      int var6 = 0;
      class_cq[] var7 = class_cq.values();
      int var8 = var7.length;

      for(int var9 = 0; var9 < var8; ++var9) {
         class_cq var10 = var7[var9];
         class_aut var11 = this.a(var2, var3.a + var10.g(), var3.b + var10.h(), var3.c + var10.i());
         if(var11 != null && !var11.i && var11.a(var4) < var5) {
            var1[var6++] = var11;
         }
      }

      return var6;
   }

   private class_aut a(class_pr var1, int var2, int var3, int var4) {
      int var5 = this.b(var1, var2, var3, var4);
      return var5 == -1?this.a(var2, var3, var4):null;
   }

   private int b(class_pr var1, int var2, int var3, int var4) {
      class_cj.class_a_in_class_cj var5 = new class_cj.class_a_in_class_cj();

      for(int var6 = var2; var6 < var2 + this.c; ++var6) {
         for(int var7 = var3; var7 < var3 + this.d; ++var7) {
            for(int var8 = var4; var8 < var4 + this.e; ++var8) {
               class_agj var9 = this.a.p(var5.c(var6, var7, var8)).c();
               if(var9.v() != class_atk.h) {
                  return 0;
               }
            }
         }
      }

      return -1;
   }
}
