package net.minecraft.server;

public class class_qx {
   private EntityInsentient b;
   protected boolean a;

   public class_qx(EntityInsentient var1) {
      this.b = var1;
   }

   public void a() {
      this.a = true;
   }

   public void b() {
      this.b.i(this.a);
      this.a = false;
   }
}
