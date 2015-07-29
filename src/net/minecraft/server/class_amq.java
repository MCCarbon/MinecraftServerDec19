package net.minecraft.server;

import net.minecraft.server.class_aar;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_ft;
import net.minecraft.server.class_jz;

public class class_amq extends class_amg {
   private class_aar a;
   private int f;

   public class_amq() {
   }

   public class_amq(class_aar var1, int var2) {
      this.a = var1;
      this.f = var2;
   }

   public void b(class_dn var1) {
      super.b(var1);
      class_jz var2 = (class_jz)class_aar.e.b(this.a);
      var1.a("Item", var2 == null?"":var2.toString());
      var1.a("Data", this.f);
   }

   public void a(class_dn var1) {
      super.a(var1);
      if(var1.b("Item", 8)) {
         this.a = class_aar.d(var1.k("Item"));
      } else {
         this.a = class_aar.c(var1.g("Item"));
      }

      this.f = var1.g("Data");
   }

   public class_ff z_() {
      class_dn var1 = new class_dn();
      this.b(var1);
      var1.p("Item");
      var1.a("Item", class_aar.b(this.a));
      return new class_ft(this.c, 5, var1);
   }

   public void a(class_aar var1, int var2) {
      this.a = var1;
      this.f = var2;
   }

   public class_aar b() {
      return this.a;
   }

   public int c() {
      return this.f;
   }
}
