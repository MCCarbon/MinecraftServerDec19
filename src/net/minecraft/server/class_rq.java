package net.minecraft.server;

import net.minecraft.server.MathHelper;
import net.minecraft.server.EntityLiving;
import net.minecraft.server.class_qb;
import net.minecraft.server.class_rm;

public class class_rq extends class_rm {
   class_qb a;
   EntityLiving b;
   float c;

   public class_rq(class_qb var1, float var2) {
      this.a = var1;
      this.c = var2;
      this.a(5);
   }

   public boolean a() {
      this.b = this.a.w();
      if(this.b == null) {
         return false;
      } else {
         double var1 = this.a.h(this.b);
         return var1 >= 4.0D && var1 <= 16.0D?(!this.a.C?false:this.a.bd().nextInt(5) == 0):false;
      }
   }

   public boolean b() {
      return !this.a.C;
   }

   public void c() {
      double var1 = this.b.s - this.a.s;
      double var3 = this.b.u - this.a.u;
      float var5 = MathHelper.sqrt(var1 * var1 + var3 * var3);
      this.a.v += var1 / (double)var5 * 0.5D * 0.800000011920929D + this.a.v * 0.20000000298023224D;
      this.a.x += var3 / (double)var5 * 0.5D * 0.800000011920929D + this.a.x * 0.20000000298023224D;
      this.a.motY = (double)this.c;
   }
}
