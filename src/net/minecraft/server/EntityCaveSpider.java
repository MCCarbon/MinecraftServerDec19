package net.minecraft.server;

public class EntityCaveSpider extends EntitySpider {
   public EntityCaveSpider(World var1) {
      super(var1);
      this.setSize(0.7F, 0.5F);
   }

   protected void aY() {
      super.aY();
      this.a(class_wl.a).a(12.0D);
   }

   public boolean r(Entity var1) {
      if(super.r(var1)) {
         if(var1 instanceof EntityLiving) {
            byte var2 = 0;
            if(this.world.ab() == class_om.c) {
               var2 = 7;
            } else if(this.world.ab() == class_om.d) {
               var2 = 15;
            }

            if(var2 > 0) {
               ((EntityLiving)var1).addEffect(new MobEffect(MobEffectList.s, var2 * 20, 0));
            }
         }

         return true;
      } else {
         return false;
      }
   }

   public class_qd a(class_on var1, class_qd var2) {
      return var2;
   }

   public float getHeadHeight() {
      return 0.45F;
   }
}
