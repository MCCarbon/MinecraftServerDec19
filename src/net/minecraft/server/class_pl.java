package net.minecraft.server;

import com.google.common.collect.ComparisonChain;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_pk;
import net.minecraft.server.class_qa;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_pl implements Comparable {
   private static final Logger a = LogManager.getLogger();
   private final class_pk b;
   private int c;
   private int d;
   private boolean e;
   private boolean f;
   private boolean h;

   public class_pl(class_pk var1) {
      this(var1, 0, 0);
   }

   public class_pl(class_pk var1, int var2) {
      this(var1, var2, 0);
   }

   public class_pl(class_pk var1, int var2, int var3) {
      this(var1, var2, var3, false, true);
   }

   public class_pl(class_pk var1, int var2, int var3, boolean var4, boolean var5) {
      this.b = var1;
      this.c = var2;
      this.d = var3;
      this.f = var4;
      this.h = var5;
   }

   public class_pl(class_pl var1) {
      this.b = var1.b;
      this.c = var1.c;
      this.d = var1.d;
      this.f = var1.f;
      this.h = var1.h;
   }

   public void a(class_pl var1) {
      if(this.b != var1.b) {
         a.warn("This method should only be called for matching effects!");
      }

      if(var1.d > this.d) {
         this.d = var1.d;
         this.c = var1.c;
      } else if(var1.d == this.d && this.c < var1.c) {
         this.c = var1.c;
      } else if(!var1.f && this.f) {
         this.f = var1.f;
      }

      this.h = var1.h;
   }

   public class_pk a() {
      return this.b;
   }

   public int b() {
      return this.c;
   }

   public int c() {
      return this.d;
   }

   public boolean d() {
      return this.f;
   }

   public boolean e() {
      return this.h;
   }

   public boolean a(class_qa var1) {
      if(this.c > 0) {
         if(this.b.a(this.c, this.d)) {
            this.b(var1);
         }

         this.h();
      }

      return this.c > 0;
   }

   private int h() {
      return --this.c;
   }

   public void b(class_qa var1) {
      if(this.c > 0) {
         this.b.a(var1, this.d);
      }

   }

   public String f() {
      return this.b.a();
   }

   public String toString() {
      String var1 = "";
      if(this.d > 0) {
         var1 = this.f() + " x " + (this.d + 1) + ", Duration: " + this.c;
      } else {
         var1 = this.f() + ", Duration: " + this.c;
      }

      if(this.e) {
         var1 = var1 + ", Splash: true";
      }

      if(!this.h) {
         var1 = var1 + ", Particles: false";
      }

      return var1;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof class_pl)) {
         return false;
      } else {
         class_pl var2 = (class_pl)var1;
         return this.c != var2.c?false:(this.d != var2.d?false:(this.e != var2.e?false:(this.f != var2.f?false:this.b.equals(var2.b))));
      }
   }

   public int hashCode() {
      int var1 = this.b.hashCode();
      var1 = 31 * var1 + this.c;
      var1 = 31 * var1 + this.d;
      var1 = 31 * var1 + (this.e?1:0);
      var1 = 31 * var1 + (this.f?1:0);
      return var1;
   }

   public class_dn a(class_dn var1) {
      var1.a("Id", (byte)class_pk.a(this.a()));
      var1.a("Amplifier", (byte)this.c());
      var1.a("Duration", this.b());
      var1.a("Ambient", this.d());
      var1.a("ShowParticles", this.e());
      return var1;
   }

   public static class_pl b(class_dn var0) {
      byte var1 = var0.e("Id");
      class_pk var2 = class_pk.a(var1);
      if(var2 == null) {
         return null;
      } else {
         byte var3 = var0.e("Amplifier");
         int var4 = var0.g("Duration");
         boolean var5 = var0.o("Ambient");
         boolean var6 = true;
         if(var0.b("ShowParticles", 1)) {
            var6 = var0.o("ShowParticles");
         }

         return new class_pl(var2, var4, var3, var5, var6);
      }
   }

   public int b(class_pl var1) {
      return ComparisonChain.start().compare(this.b(), var1.b()).compare(this.a().g(), var1.a().g()).result();
   }

   // $FF: synthetic method
   public int compareTo(Object var1) {
      return this.b((class_pl)var1);
   }
}
