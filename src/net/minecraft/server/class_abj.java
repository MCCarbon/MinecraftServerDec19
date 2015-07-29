package net.minecraft.server;

import net.minecraft.server.class_aan;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_xa;

public class class_abj extends class_aan {
   private class_agj b;
   private class_agj c;

   public class_abj(int var1, float var2, class_agj var3, class_agj var4) {
      super(var1, var2, false);
      this.b = var3;
      this.c = var4;
   }

   public class_oq a(class_aas var1, class_xa var2, class_aen var3, class_cj var4, class_oo var5, class_cq var6, float var7, float var8, float var9) {
      if(var6 != class_cq.b) {
         return class_oq.b;
      } else if(!var2.a(var4.a(var6), var6, var1)) {
         return class_oq.b;
      } else if(var3.p(var4).c() == this.c && var3.d(var4.a())) {
         var3.a(var4.a(), this.b.S());
         --var1.b;
         return class_oq.a;
      } else {
         return class_oq.b;
      }
   }
}
