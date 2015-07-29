package net.minecraft.server;

import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_eb;

public class class_aea {
   private class_aas a;
   private class_aas b;
   private class_aas c;
   private int d;
   private int e;
   private boolean f;

   public class_aea(class_dn var1) {
      this.a(var1);
   }

   public class_aea(class_aas var1, class_aas var2, class_aas var3) {
      this(var1, var2, var3, 0, 7);
   }

   public class_aea(class_aas var1, class_aas var2, class_aas var3, int var4, int var5) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
      this.f = true;
   }

   public class_aea(class_aas var1, class_aas var2) {
      this(var1, (class_aas)null, var2);
   }

   public class_aea(class_aas var1, class_aar var2) {
      this(var1, new class_aas(var2));
   }

   public class_aas a() {
      return this.a;
   }

   public class_aas b() {
      return this.b;
   }

   public boolean c() {
      return this.b != null;
   }

   public class_aas d() {
      return this.c;
   }

   public int e() {
      return this.d;
   }

   public int f() {
      return this.e;
   }

   public void g() {
      ++this.d;
   }

   public void a(int var1) {
      this.e += var1;
   }

   public boolean h() {
      return this.d >= this.e;
   }

   public boolean j() {
      return this.f;
   }

   public void a(class_dn var1) {
      class_dn var2 = var1.n("buy");
      this.a = class_aas.a(var2);
      class_dn var3 = var1.n("sell");
      this.c = class_aas.a(var3);
      if(var1.b("buyB", 10)) {
         this.b = class_aas.a(var1.n("buyB"));
      }

      if(var1.b("uses", 99)) {
         this.d = var1.g("uses");
      }

      if(var1.b("maxUses", 99)) {
         this.e = var1.g("maxUses");
      } else {
         this.e = 7;
      }

      if(var1.b("rewardExp", 1)) {
         this.f = var1.o("rewardExp");
      } else {
         this.f = true;
      }

   }

   public class_dn k() {
      class_dn var1 = new class_dn();
      var1.a((String)"buy", (class_eb)this.a.b(new class_dn()));
      var1.a((String)"sell", (class_eb)this.c.b(new class_dn()));
      if(this.b != null) {
         var1.a((String)"buyB", (class_eb)this.b.b(new class_dn()));
      }

      var1.a("uses", this.d);
      var1.a("maxUses", this.e);
      var1.a("rewardExp", this.f);
      return var1;
   }
}
