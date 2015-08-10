package net.minecraft.server;

public class EntitySmallFireball extends EntityFireball {
   public EntitySmallFireball(World var1) {
      super(var1);
      this.setSize(0.3125F, 0.3125F);
   }

   public EntitySmallFireball(World var1, EntityLiving var2, double var3, double var5, double var7) {
      super(var1, var2, var3, var5, var7);
      this.setSize(0.3125F, 0.3125F);
   }

   public EntitySmallFireball(World var1, double var2, double var4, double var6, double var8, double var10, double var12) {
      super(var1, var2, var4, var6, var8, var10, var12);
      this.setSize(0.3125F, 0.3125F);
   }

   protected void a(MovingObjectPosition var1) {
      if(!this.world.isClientSide) {
         boolean var2;
         if(var1.entity != null) {
            var2 = var1.entity.damageEntity(DamageSource.fireball((EntityFireball) this, (Entity) this.a), 5.0F);
            if(var2) {
               this.a(this.a, var1.entity);
               if(!var1.entity.T()) {
                  var1.entity.f(5);
               }
            }
         } else {
            var2 = true;
            if(this.a != null && this.a instanceof EntityInsentient) {
               var2 = this.world.R().getBooleanValue("mobGriefing");
            }

            if(var2) {
               BlockPosition var3 = var1.a().shift(var1.direction);
               if(this.world.isEmpty(var3)) {
                  this.world.setTypeUpdate(var3, Blocks.FIRE.getBlockData());
               }
            }
         }

         this.die();
      }

   }

   public boolean ad() {
      return false;
   }

   public boolean damageEntity(DamageSource var1, float var2) {
      return false;
   }
}
