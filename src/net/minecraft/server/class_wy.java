package net.minecraft.server;

import net.minecraft.server.class_dn;
import net.minecraft.server.class_eb;

public class class_wy {
   public boolean a;
   public boolean b;
   public boolean c;
   public boolean d;
   public boolean e = true;
   private float f = 0.05F;
   private float g = 0.1F;

   public void a(class_dn var1) {
      class_dn var2 = new class_dn();
      var2.a("invulnerable", this.a);
      var2.a("flying", this.b);
      var2.a("mayfly", this.c);
      var2.a("instabuild", this.d);
      var2.a("mayBuild", this.e);
      var2.a("flySpeed", this.f);
      var2.a("walkSpeed", this.g);
      var1.a((String)"abilities", (class_eb)var2);
   }

   public void b(class_dn var1) {
      if(var1.b("abilities", 10)) {
         class_dn var2 = var1.n("abilities");
         this.a = var2.o("invulnerable");
         this.b = var2.o("flying");
         this.c = var2.o("mayfly");
         this.d = var2.o("instabuild");
         if(var2.b("flySpeed", 99)) {
            this.f = var2.i("flySpeed");
            this.g = var2.i("walkSpeed");
         }

         if(var2.b("mayBuild", 1)) {
            this.e = var2.o("mayBuild");
         }
      }

   }

   public float a() {
      return this.f;
   }

   public float b() {
      return this.g;
   }
}
