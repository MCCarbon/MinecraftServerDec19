package net.minecraft.server;

import net.minecraft.server.World;
import net.minecraft.server.MovingObjectPosition;
import net.minecraft.server.class_cy;
import net.minecraft.server.class_pc;
import net.minecraft.server.Entity;
import net.minecraft.server.EntityLiving;
import net.minecraft.server.class_vy;
import net.minecraft.server.class_xo;

public class class_xm extends class_xo {
   public class_xm(World var1) {
      super(var1);
   }

   public class_xm(World var1, EntityLiving var2) {
      super(var1, var2);
   }

   public class_xm(World var1, double var2, double var4, double var6) {
      super(var1, var2, var4, var6);
   }

   protected void a(MovingObjectPosition var1) {
      if(var1.d != null) {
         byte var2 = 0;
         if(var1.d instanceof class_vy) {
            var2 = 3;
         }

         var1.d.damageEntity(class_pc.a((Entity)this, (Entity)this.l()), (float)var2);
      }

      for(int var3 = 0; var3 < 8; ++var3) {
         this.o.a(class_cy.F, this.s, this.t, this.u, 0.0D, 0.0D, 0.0D, new int[0]);
      }

      if(!this.o.isClientSide) {
         this.J();
      }

   }
}
