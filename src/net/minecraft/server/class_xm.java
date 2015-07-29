package net.minecraft.server;

import net.minecraft.server.World;
import net.minecraft.server.class_awg;
import net.minecraft.server.class_cy;
import net.minecraft.server.class_pc;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_vy;
import net.minecraft.server.class_xo;

public class class_xm extends class_xo {
   public class_xm(World var1) {
      super(var1);
   }

   public class_xm(World var1, class_qa var2) {
      super(var1, var2);
   }

   public class_xm(World var1, double var2, double var4, double var6) {
      super(var1, var2, var4, var6);
   }

   protected void a(class_awg var1) {
      if(var1.d != null) {
         byte var2 = 0;
         if(var1.d instanceof class_vy) {
            var2 = 3;
         }

         var1.d.a(class_pc.a((class_pr)this, (class_pr)this.l()), (float)var2);
      }

      for(int var3 = 0; var3 < 8; ++var3) {
         this.o.a(class_cy.F, this.s, this.t, this.u, 0.0D, 0.0D, 0.0D, new int[0]);
      }

      if(!this.o.D) {
         this.J();
      }

   }
}
