package net.minecraft.server;

import net.minecraft.server.class_dn;

public class class_ot {
   public static final class_ot a = new class_ot("");
   private final String b;

   public class_ot(String var1) {
      this.b = var1;
   }

   public boolean a() {
      return this.b == null || this.b.isEmpty();
   }

   public String b() {
      return this.b;
   }

   public void a(class_dn var1) {
      var1.a("Lock", this.b);
   }

   public static class_ot b(class_dn var0) {
      if(var0.b("Lock", 8)) {
         String var1 = var0.k("Lock");
         return new class_ot(var1);
      } else {
         return a;
      }
   }
}
