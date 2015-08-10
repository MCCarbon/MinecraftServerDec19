package net.minecraft.server;

public class EntitySnowball extends class_xo {
   public EntitySnowball(World var1) {
      super(var1);
   }

   public EntitySnowball(World var1, EntityLiving var2) {
      super(var1, var2);
   }

   public EntitySnowball(World var1, double var2, double var4, double var6) {
      super(var1, var2, var4, var6);
   }

   protected void a(MovingObjectPosition var1) {
      if(var1.entity != null) {
         byte var2 = 0;
         if(var1.entity instanceof EntityBlaze) {
            var2 = 3;
         }

         var1.entity.damageEntity(DamageSource.projectile((Entity) this, (Entity) this.l()), (float)var2);
      }

      for(int var3 = 0; var3 < 8; ++var3) {
         this.world.addParticle(EnumParticle.F, this.locX, this.locY, this.locZ, 0.0D, 0.0D, 0.0D, new int[0]);
      }

      if(!this.world.isClientSide) {
         this.die();
      }

   }
}
