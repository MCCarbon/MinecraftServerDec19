package net.minecraft.server;

import net.minecraft.server.class_qb;

public class class_qx {
   private class_qb b;
   protected boolean a;

   public class_qx(class_qb var1) {
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
