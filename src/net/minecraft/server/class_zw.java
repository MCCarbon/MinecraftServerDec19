package net.minecraft.server;

import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_ahl;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_zu;

public class class_zw extends class_aar {
   private class_agj a;

   public class_zw(class_agj var1) {
      this.a = var1;
      this.a(class_zu.d);
   }

   public class_oq a(class_aas var1, class_xa var2, class_aen var3, class_cj var4, class_oo var5, class_cq var6, float var7, float var8, float var9) {
      if(var6 != class_cq.b) {
         return class_oq.b;
      } else {
         class_anl var10 = var3.p(var4);
         class_agj var11 = var10.c();
         if(!var11.a(var3, var4)) {
            var4 = var4.a(var6);
         }

         if(!var2.a(var4, var6, var1)) {
            return class_oq.b;
         } else if(!this.a.d(var3, var4)) {
            return class_oq.b;
         } else {
            a(var3, var4, class_cq.a((double)var2.y), this.a);
            --var1.b;
            return class_oq.a;
         }
      }
   }

   public static void a(class_aen var0, class_cj var1, class_cq var2, class_agj var3) {
      class_cj var4 = var1.a(var2.e());
      class_cj var5 = var1.a(var2.f());
      int var6 = (var0.p(var5).c().x()?1:0) + (var0.p(var5.a()).c().x()?1:0);
      int var7 = (var0.p(var4).c().x()?1:0) + (var0.p(var4.a()).c().x()?1:0);
      boolean var8 = var0.p(var5).c() == var3 || var0.p(var5.a()).c() == var3;
      boolean var9 = var0.p(var4).c() == var3 || var0.p(var4.a()).c() == var3;
      boolean var10 = false;
      if(var8 && !var9 || var7 > var6) {
         var10 = true;
      }

      class_cj var11 = var1.a();
      class_anl var12 = var3.S().a(class_ahl.a, var2).a(class_ahl.N, var10?class_ahl.class_b_in_class_ahl.b:class_ahl.class_b_in_class_ahl.a);
      var0.a((class_cj)var1, (class_anl)var12.a(class_ahl.P, class_ahl.class_a_in_class_ahl.b), 2);
      var0.a((class_cj)var11, (class_anl)var12.a(class_ahl.P, class_ahl.class_a_in_class_ahl.a), 2);
      var0.c(var1, var3);
      var0.c(var11, var3);
   }
}
