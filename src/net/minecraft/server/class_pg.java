package net.minecraft.server;

public class class_pg extends MobEffect {
   protected class_pg(boolean var1, int var2) {
      super(var1, var2);
   }

   public void a(EntityLiving var1, class_qo var2, int var3) {
      var1.setAbsorptionHearts(var1.getAbsorptionHearts() - (float)(4 * (var3 + 1)));
      super.a(var1, var2, var3);
   }

   public void b(EntityLiving var1, class_qo var2, int var3) {
      var1.setAbsorptionHearts(var1.getAbsorptionHearts() + (float)(4 * (var3 + 1)));
      super.b(var1, var2, var3);
   }
}
