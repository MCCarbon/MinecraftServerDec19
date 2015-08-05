package net.minecraft.server;

public class EntitySmallFireball extends class_xf {
   public EntitySmallFireball(World var1) {
      super(var1);
      this.a(0.3125F, 0.3125F);
   }

   public EntitySmallFireball(World var1, EntityLiving var2, double var3, double var5, double var7) {
      super(var1, var2, var3, var5, var7);
      this.a(0.3125F, 0.3125F);
   }

   public EntitySmallFireball(World var1, double var2, double var4, double var6, double var8, double var10, double var12) {
      super(var1, var2, var4, var6, var8, var10, var12);
      this.a(0.3125F, 0.3125F);
   }

   protected void a(MovingObjectPosition var1) {
      if(!this.o.isClientSide) {
         boolean var2;
         if(var1.d != null) {
            var2 = var1.d.damageEntity(DamageSource.a((class_xf) this, (Entity) this.a), 5.0F);
            if(var2) {
               this.a(this.a, var1.d);
               if(!var1.d.T()) {
                  var1.d.f(5);
               }
            }
         } else {
            var2 = true;
            if(this.a != null && this.a instanceof EntityInsentient) {
               var2 = this.o.R().getBooleanValue("mobGriefing");
            }

            if(var2) {
               BlockPosition var3 = var1.a().shift(var1.b);
               if(this.o.isEmpty(var3)) {
                  this.o.setTypeUpdate(var3, Blocks.FIRE.getBlockData());
               }
            }
         }

         this.J();
      }

   }

   public boolean ad() {
      return false;
   }

   public boolean damageEntity(DamageSource var1, float var2) {
      return false;
   }
}
