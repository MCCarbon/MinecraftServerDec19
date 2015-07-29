package net.minecraft.server;

import net.minecraft.server.class_aen;
import net.minecraft.server.class_awg;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_px;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_xo;

public class class_xr extends class_xo {
   public class_xr(class_aen var1) {
      super(var1);
   }

   public class_xr(class_aen var1, class_qa var2) {
      super(var1, var2);
   }

   public class_xr(class_aen var1, double var2, double var4, double var6) {
      super(var1, var2, var4, var6);
   }

   protected float j() {
      return 0.07F;
   }

   protected void a(class_awg var1) {
      if(!this.o.D) {
         this.o.b(2002, new class_cj(this), 0);
         int var2 = 3 + this.o.s.nextInt(5) + this.o.s.nextInt(5);

         while(var2 > 0) {
            int var3 = class_px.a(var2);
            var2 -= var3;
            this.o.a((class_pr)(new class_px(this.o, this.s, this.t, this.u, var3)));
         }

         this.J();
      }

   }
}
