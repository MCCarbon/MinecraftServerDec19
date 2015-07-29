package net.minecraft.server;

import net.minecraft.server.class_aen;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_nu;
import net.minecraft.server.class_qb;

public abstract class class_py extends class_qb {
   public class_py(class_aen var1) {
      super(var1);
   }

   public void e(float var1, float var2) {
   }

   protected void a(double var1, boolean var3, class_agj var4, class_cj var5) {
   }

   public void g(float var1, float var2) {
      if(this.V()) {
         this.a(var1, var2, 0.02F);
         this.d(this.v, this.w, this.x);
         this.v *= 0.800000011920929D;
         this.w *= 0.800000011920929D;
         this.x *= 0.800000011920929D;
      } else if(this.ab()) {
         this.a(var1, var2, 0.02F);
         this.d(this.v, this.w, this.x);
         this.v *= 0.5D;
         this.w *= 0.5D;
         this.x *= 0.5D;
      } else {
         float var3 = 0.91F;
         if(this.C) {
            var3 = this.o.p(new class_cj(class_nu.c(this.s), class_nu.c(this.aT().b) - 1, class_nu.c(this.u))).c().L * 0.91F;
         }

         float var4 = 0.16277136F / (var3 * var3 * var3);
         this.a(var1, var2, this.C?0.1F * var4:0.02F);
         var3 = 0.91F;
         if(this.C) {
            var3 = this.o.p(new class_cj(class_nu.c(this.s), class_nu.c(this.aT().b) - 1, class_nu.c(this.u))).c().L * 0.91F;
         }

         this.d(this.v, this.w, this.x);
         this.v *= (double)var3;
         this.w *= (double)var3;
         this.x *= (double)var3;
      }

      this.aD = this.aE;
      double var8 = this.s - this.p;
      double var5 = this.u - this.r;
      float var7 = class_nu.a(var8 * var8 + var5 * var5) * 4.0F;
      if(var7 > 1.0F) {
         var7 = 1.0F;
      }

      this.aE += (var7 - this.aE) * 0.4F;
      this.aF += this.aE;
   }

   public boolean k_() {
      return false;
   }
}
