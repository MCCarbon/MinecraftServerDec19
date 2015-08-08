package net.minecraft.server;

public class class_ss extends class_rm {
   private EntityVillager a;

   public class_ss(EntityVillager var1) {
      this.a = var1;
      this.a(5);
   }

   public boolean a() {
      if(!this.a.isAlive()) {
         return false;
      } else if(this.a.V()) {
         return false;
      } else if(!this.a.onGround) {
         return false;
      } else if(this.a.velocityChanged) {
         return false;
      } else {
         EntityHuman var1 = this.a.v_();
         return var1 == null?false:(this.a.h(var1) > 16.0D?false:var1.br instanceof Container);
      }
   }

   public void c() {
      this.a.u().n();
   }

   public void d() {
      this.a.a((EntityHuman)null);
   }
}
