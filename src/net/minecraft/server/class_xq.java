package net.minecraft.server;

import net.minecraft.server.class_aen;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_ana;
import net.minecraft.server.class_awg;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cy;
import net.minecraft.server.class_lh;
import net.minecraft.server.class_pc;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_wc;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xo;

public class class_xq extends class_xo {
   private class_qa d;

   public class_xq(class_aen var1) {
      super(var1);
   }

   public class_xq(class_aen var1, class_qa var2) {
      super(var1, var2);
      this.d = var2;
   }

   protected void a(class_awg var1) {
      class_qa var2 = this.l();
      if(var1.d != null) {
         if(var1.d == this.d) {
            return;
         }

         var1.d.a(class_pc.a((class_pr)this, (class_pr)var2), 0.0F);
      }

      if(var1.a == class_awg.class_a_in_class_awg.b) {
         class_cj var3 = var1.a();
         class_amg var4 = this.o.s(var3);
         if(var4 instanceof class_ana) {
            class_ana var5 = (class_ana)var4;
            if(var2 != null) {
               var5.a((class_pr)var2);
               this.J();
               return;
            }

            var5.a((class_pr)this);
            return;
         }
      }

      for(int var6 = 0; var6 < 32; ++var6) {
         this.o.a(class_cy.y, this.s, this.t + this.V.nextDouble() * 2.0D, this.u, this.V.nextGaussian(), 0.0D, this.V.nextGaussian(), new int[0]);
      }

      if(!this.o.D) {
         if(var2 instanceof class_lh) {
            class_lh var7 = (class_lh)var2;
            if(var7.a.a().g() && var7.o == this.o && !var7.bK()) {
               if(this.V.nextFloat() < 0.05F && this.o.R().b("doMobSpawning")) {
                  class_wc var8 = new class_wc(this.o);
                  var8.a(true);
                  var8.b(var2.s, var2.t, var2.u, var2.y, var2.z);
                  this.o.a((class_pr)var8);
               }

               if(var2.aw()) {
                  var2.a((class_pr)null);
               }

               var2.a(this.s, this.t, this.u);
               var2.O = 0.0F;
               var2.a(class_pc.i, 5.0F);
            }
         } else if(var2 != null) {
            var2.a(this.s, this.t, this.u);
            var2.O = 0.0F;
         }

         this.J();
      }

   }

   public void t_() {
      class_qa var1 = this.l();
      if(var1 != null && var1 instanceof class_xa && !var1.ai()) {
         this.J();
      } else {
         super.t_();
      }

   }
}
