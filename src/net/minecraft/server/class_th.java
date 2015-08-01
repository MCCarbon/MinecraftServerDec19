package net.minecraft.server;

import net.minecraft.server.World;
import net.minecraft.server.class_auv;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.MathHelper;
import net.minecraft.server.Entity;
import net.minecraft.server.class_qb;
import net.minecraft.server.class_tf;

public class class_th extends class_tf {
   private BlockPosition f;

   public class_th(class_qb var1, World var2) {
      super(var1, var2);
   }

   public class_auv a(BlockPosition var1) {
      this.f = var1;
      return super.a(var1);
   }

   public class_auv a(Entity var1) {
      this.f = new BlockPosition(var1);
      return super.a(var1);
   }

   public boolean a(Entity var1, double var2) {
      class_auv var4 = this.a(var1);
      if(var4 != null) {
         return this.a(var4, var2);
      } else {
         this.f = new BlockPosition(var1);
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
            if(this.b.c(this.f) >= var1 && (this.b.t <= (double)this.f.getY() || this.b.c(new BlockPosition(this.f.getX(), MathHelper.floor(this.b.t), this.f.getZ())) >= var1)) {
               this.b.r().a((double)this.f.getX(), (double)this.f.getY(), (double)this.f.getZ(), this.e);
            } else {
               this.f = null;
            }
         }

      }
   }
}
