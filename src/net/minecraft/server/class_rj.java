package net.minecraft.server;

public class class_rj extends class_rm {
   private EntityInsentient a;

   public class_rj(EntityInsentient var1) {
      this.a = var1;
      this.a(4);
      ((class_tf)var1.u()).d(true);
   }

   public boolean a() {
      return this.a.V() || this.a.ab();
   }

   public void e() {
      if(this.a.getRandom().nextFloat() < 0.8F) {
         this.a.t().a();
      }

   }
}
