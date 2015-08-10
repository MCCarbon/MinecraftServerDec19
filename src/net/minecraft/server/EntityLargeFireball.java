package net.minecraft.server;

public class EntityLargeFireball extends EntityFireball {
   public int e = 1;

   public EntityLargeFireball(World var1) {
      super(var1);
   }

   public EntityLargeFireball(World var1, EntityLiving var2, double var3, double var5, double var7) {
      super(var1, var2, var3, var5, var7);
   }

   protected void a(MovingObjectPosition var1) {
      if(!this.world.isClientSide) {
         if(var1.entity != null) {
            var1.entity.damageEntity(DamageSource.fireball((EntityFireball) this, (Entity) this.a), 6.0F);
            this.a(this.a, var1.entity);
         }

         boolean var2 = this.world.R().getBooleanValue("mobGriefing");
         this.world.createExplosion((Entity)null, this.locX, this.locY, this.locZ, (float)this.e, var2, var2);
         this.die();
      }

   }

   public void write(NBTTagCompound var1) {
      super.write(var1);
      var1.put("ExplosionPower", this.e);
   }

   public void read(NBTTagCompound var1) {
      super.read(var1);
      if(var1.hasOfType("ExplosionPower", 99)) {
         this.e = var1.getInt("ExplosionPower");
      }

   }
}
