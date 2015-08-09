package net.minecraft.server;

public class EntityWitherSkull extends class_xf {
   private static final int e = DataWathcer.claimId(EntityWitherSkull.class);

   public EntityWitherSkull(World var1) {
      super(var1);
      this.setSize(0.3125F, 0.3125F);
   }

   public EntityWitherSkull(World var1, EntityLiving var2, double var3, double var5, double var7) {
      super(var1, var2, var3, var5, var7);
      this.setSize(0.3125F, 0.3125F);
   }

   protected float j() {
      return this.l()?0.73F:super.j();
   }

   public boolean av() {
      return false;
   }

   public float a(Explosion var1, World var2, BlockPosition var3, IBlockData var4) {
      float var5 = super.a(var1, var2, var3, var4);
      Block var6 = var4.getBlock();
      if(this.l() && EntityWither.a(var6)) {
         var5 = Math.min(0.8F, var5);
      }

      return var5;
   }

   protected void a(MovingObjectPosition var1) {
      if(!this.world.isClientSide) {
         if(var1.d != null) {
            if(this.a != null) {
               if(var1.d.damageEntity(DamageSource.a(this.a), 8.0F)) {
                  if(!var1.d.isAlive()) {
                     this.a.h(5.0F);
                  } else {
                     this.a(this.a, var1.d);
                  }
               }
            } else {
               var1.d.damageEntity(DamageSource.l, 5.0F);
            }

            if(var1.d instanceof EntityLiving) {
               byte var2 = 0;
               if(this.world.ab() == class_om.c) {
                  var2 = 10;
               } else if(this.world.ab() == class_om.d) {
                  var2 = 40;
               }

               if(var2 > 0) {
                  ((EntityLiving)var1.d).addEffect(new MobEffect(MobEffectList.t, 20 * var2, 1));
               }
            }
         }

         this.world.createExplosion(this, this.locX, this.locY, this.locZ, 1.0F, false, this.world.R().getBooleanValue("mobGriefing"));
         this.die();
      }

   }

   public boolean ad() {
      return false;
   }

   public boolean damageEntity(DamageSource var1, float var2) {
      return false;
   }

   protected void initDatawatcher() {
      this.datawatcher.add(e, Byte.valueOf((byte)0));
   }

   public boolean l() {
      return this.datawatcher.getByte(e) == 1;
   }

   public void a(boolean var1) {
      this.datawatcher.update(e, Byte.valueOf((byte)(var1?1:0)));
   }
}
