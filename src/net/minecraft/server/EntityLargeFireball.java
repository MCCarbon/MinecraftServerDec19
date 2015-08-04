package net.minecraft.server;

public class EntityLargeFireball extends class_xf {
   public int e = 1;

   public EntityLargeFireball(World var1) {
      super(var1);
   }

   public EntityLargeFireball(World var1, EntityLiving var2, double var3, double var5, double var7) {
      super(var1, var2, var3, var5, var7);
   }

   protected void a(MovingObjectPosition var1) {
      if(!this.o.isClientSide) {
         if(var1.d != null) {
            var1.d.damageEntity(DamageSource.a((class_xf) this, (Entity) this.a), 6.0F);
            this.a(this.a, var1.d);
         }

         boolean var2 = this.o.R().b("mobGriefing");
         this.o.createExplosion((Entity)null, this.s, this.t, this.u, (float)this.e, var2, var2);
         this.J();
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
