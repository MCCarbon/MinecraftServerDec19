package net.minecraft.server;

public class class_sp extends class_rm {
   EntityCreeper a;
   EntityLiving b;

   public class_sp(EntityCreeper var1) {
      this.a = var1;
      this.a(1);
   }

   public boolean a() {
      EntityLiving var1 = this.a.w();
      return this.a.cB() > 0 || var1 != null && this.a.h(var1) < 9.0D;
   }

   public void c() {
      this.a.u().n();
      this.b = this.a.w();
   }

   public void d() {
      this.b = null;
   }

   public void e() {
      if(this.b == null) {
         this.a.a(-1);
      } else if(this.a.h(this.b) > 49.0D) {
         this.a.a(-1);
      } else if(!this.a.v().a(this.b)) {
         this.a.a(-1);
      } else {
         this.a.a(1);
      }
   }
}
