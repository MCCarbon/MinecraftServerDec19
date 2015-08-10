package net.minecraft.server;

public class class_pi extends MobEffectType {
   public class_pi(boolean var1, int var2) {
      super(var1, var2);
   }

   public void a(EntityLiving var1, class_qo var2, int var3) {
      super.a(var1, var2, var3);
      if(var1.getHealth() > var1.getMaxHealth()) {
         var1.i(var1.getMaxHealth());
      }

   }
}
