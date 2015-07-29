package net.minecraft.server;

import net.minecraft.server.class_aen;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_awg;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_pc;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_qb;
import net.minecraft.server.class_xf;

public class class_xl extends class_xf {
   public class_xl(class_aen var1) {
      super(var1);
      this.a(0.3125F, 0.3125F);
   }

   public class_xl(class_aen var1, class_qa var2, double var3, double var5, double var7) {
      super(var1, var2, var3, var5, var7);
      this.a(0.3125F, 0.3125F);
   }

   public class_xl(class_aen var1, double var2, double var4, double var6, double var8, double var10, double var12) {
      super(var1, var2, var4, var6, var8, var10, var12);
      this.a(0.3125F, 0.3125F);
   }

   protected void a(class_awg var1) {
      if(!this.o.D) {
         boolean var2;
         if(var1.d != null) {
            var2 = var1.d.a(class_pc.a((class_xf)this, (class_pr)this.a), 5.0F);
            if(var2) {
               this.a(this.a, var1.d);
               if(!var1.d.T()) {
                  var1.d.f(5);
               }
            }
         } else {
            var2 = true;
            if(this.a != null && this.a instanceof class_qb) {
               var2 = this.o.R().b("mobGriefing");
            }

            if(var2) {
               class_cj var3 = var1.a().a(var1.b);
               if(this.o.d(var3)) {
                  this.o.a(var3, class_agk.ab.S());
               }
            }
         }

         this.J();
      }

   }

   public boolean ad() {
      return false;
   }

   public boolean a(class_pc var1, float var2) {
      return false;
   }
}
