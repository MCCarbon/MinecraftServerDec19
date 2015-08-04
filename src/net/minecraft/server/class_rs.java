package net.minecraft.server;

public class class_rs extends class_rr {
   private final EntityVillager e;

   public class_rs(EntityVillager var1) {
      super(var1, EntityHuman.class, 8.0F);
      this.e = var1;
   }

   public boolean a() {
      if(this.e.cD()) {
         this.b = this.e.v_();
         return true;
      } else {
         return false;
      }
   }
}
