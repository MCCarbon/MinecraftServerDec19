package net.minecraft.server;

import net.minecraft.server.World;
import net.minecraft.server.MovingObjectPosition;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.Entity;
import net.minecraft.server.EntityExperienceOrb;
import net.minecraft.server.EntityLiving;
import net.minecraft.server.class_xo;

public class EntityThrownExpBottle extends class_xo {
   public EntityThrownExpBottle(World var1) {
      super(var1);
   }

   public EntityThrownExpBottle(World var1, EntityLiving var2) {
      super(var1, var2);
   }

   public EntityThrownExpBottle(World var1, double var2, double var4, double var6) {
      super(var1, var2, var4, var6);
   }

   protected float j() {
      return 0.07F;
   }

   protected void a(MovingObjectPosition var1) {
      if(!this.world.isClientSide) {
         this.world.b(2002, new BlockPosition(this), 0);
         int var2 = 3 + this.world.random.nextInt(5) + this.world.random.nextInt(5);

         while(var2 > 0) {
            int var3 = EntityExperienceOrb.getOrbValue(var2);
            var2 -= var3;
            this.world.addEntity((Entity)(new EntityExperienceOrb(this.world, this.locX, this.locY, this.locZ, var3)));
         }

         this.die();
      }

   }
}
