package net.minecraft.server;

import net.minecraft.server.class_amg;
import net.minecraft.server.class_dn;

public class class_amk extends class_amg {
   private int a;

   public void b(class_dn var1) {
      super.b(var1);
      var1.a("OutputSignal", this.a);
   }

   public void a(class_dn var1) {
      super.a(var1);
      this.a = var1.g("OutputSignal");
   }

   public int b() {
      return this.a;
   }

   public void a(int var1) {
      this.a = var1;
   }
}
