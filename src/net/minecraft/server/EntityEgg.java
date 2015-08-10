package net.minecraft.server;

public class EntityEgg extends class_xo {
   public EntityEgg(World var1) {
      super(var1);
   }

   public EntityEgg(World var1, EntityLiving var2) {
      super(var1, var2);
   }

   public EntityEgg(World var1, double var2, double var4, double var6) {
      super(var1, var2, var4, var6);
   }

   protected void a(MovingObjectPosition var1) {
      if(var1.entity != null) {
         var1.entity.damageEntity(DamageSource.projectile((Entity) this, (Entity) this.l()), 0.0F);
      }

      if(!this.world.isClientSide && this.random.nextInt(8) == 0) {
         byte var2 = 1;
         if(this.random.nextInt(32) == 0) {
            var2 = 4;
         }

         for(int var3 = 0; var3 < var2; ++var3) {
            EntityChicken var4 = new EntityChicken(this.world);
            var4.b(-24000);
            var4.b(this.locX, this.locY, this.locZ, this.yaw, 0.0F);
            this.world.addEntity((Entity)var4);
         }
      }

      double var5 = 0.08D;

      for(int var6 = 0; var6 < 8; ++var6) {
         this.world.addParticle(EnumParticle.K, this.locX, this.locY, this.locZ, ((double)this.random.nextFloat() - 0.5D) * 0.08D, ((double)this.random.nextFloat() - 0.5D) * 0.08D, ((double)this.random.nextFloat() - 0.5D) * 0.08D, new int[]{Item.getId(Items.EGG)});
      }

      if(!this.world.isClientSide) {
         this.die();
      }

   }
}
