package net.minecraft.server;

import net.minecraft.server.class_aen;
import net.minecraft.server.class_auv;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_nu;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qb;
import net.minecraft.server.class_tf;

public class class_th extends class_tf {
   private class_cj f;

   public class_th(class_qb var1, class_aen var2) {
      super(var1, var2);
   }

   public class_auv a(class_cj var1) {
      this.f = var1;
      return super.a(var1);
   }

   public class_auv a(class_pr var1) {
      this.f = new class_cj(var1);
      return super.a(var1);
   }

   public boolean a(class_pr var1, double var2) {
      class_auv var4 = this.a(var1);
      if(var4 != null) {
         return this.a(var4, var2);
      } else {
         this.f = new class_cj(var1);
         this.e = var2;
         return true;
      }
   }

   public void k() {
      if(!this.m()) {
         super.k();
      } else {
         if(this.f != null) {
            double var1 = (double)(this.b.J * this.b.J);
            if(this.b.c(this.f) >= var1 && (this.b.t <= (double)this.f.o() || this.b.c(new class_cj(this.f.n(), class_nu.c(this.b.t), this.f.p())) >= var1)) {
               this.b.r().a((double)this.f.n(), (double)this.f.o(), (double)this.f.p(), this.e);
            } else {
               this.f = null;
            }
         }

      }
   }
}
