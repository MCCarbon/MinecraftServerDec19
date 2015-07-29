package net.minecraft.server;

import net.minecraft.server.class_b;

public class class_e extends RuntimeException {
   private final class_b a;

   public class_e(class_b var1) {
      this.a = var1;
   }

   public class_b a() {
      return this.a;
   }

   public Throwable getCause() {
      return this.a.b();
   }

   public String getMessage() {
      return this.a.a();
   }
}
