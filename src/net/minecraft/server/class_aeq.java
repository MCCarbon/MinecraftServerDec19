package net.minecraft.server;

import net.minecraft.server.class_aes;
import net.minecraft.server.class_avn;
import net.minecraft.server.class_wy;

public final class class_aeq {
   private final long a;
   private final class_aeq.class_a_in_class_aeq b;
   private final boolean c;
   private final boolean d;
   private final class_aes e;
   private boolean f;
   private boolean g;
   private String h;

   public class_aeq(long var1, class_aeq.class_a_in_class_aeq var3, boolean var4, boolean var5, class_aes var6) {
      this.h = "";
      this.a = var1;
      this.b = var3;
      this.c = var4;
      this.d = var5;
      this.e = var6;
   }

   public class_aeq(class_avn var1) {
      this(var1.b(), var1.r(), var1.s(), var1.t(), var1.u());
   }

   public class_aeq a() {
      this.g = true;
      return this;
   }

   public class_aeq a(String var1) {
      this.h = var1;
      return this;
   }

   public boolean c() {
      return this.g;
   }

   public long d() {
      return this.a;
   }

   public class_aeq.class_a_in_class_aeq e() {
      return this.b;
   }

   public boolean f() {
      return this.d;
   }

   public boolean g() {
      return this.c;
   }

   public class_aes h() {
      return this.e;
   }

   public boolean i() {
      return this.f;
   }

   public static class_aeq.class_a_in_class_aeq a(int var0) {
      return class_aeq.class_a_in_class_aeq.a(var0);
   }

   public String j() {
      return this.h;
   }

   public static enum class_a_in_class_aeq {
      a(-1, ""),
      b(0, "survival"),
      c(1, "creative"),
      d(2, "adventure"),
      e(3, "spectator");

      int f;
      String g;

      private class_a_in_class_aeq(int var3, String var4) {
         this.f = var3;
         this.g = var4;
      }

      public int a() {
         return this.f;
      }

      public String b() {
         return this.g;
      }

      public void a(class_wy var1) {
         if(this == c) {
            var1.c = true;
            var1.d = true;
            var1.a = true;
         } else if(this == e) {
            var1.c = true;
            var1.d = false;
            var1.a = true;
            var1.b = true;
         } else {
            var1.c = false;
            var1.d = false;
            var1.a = false;
            var1.b = false;
         }

         var1.e = !this.c();
      }

      public boolean c() {
         return this == d || this == e;
      }

      public boolean d() {
         return this == c;
      }

      public boolean e() {
         return this == b || this == d;
      }

      public static class_aeq.class_a_in_class_aeq a(int var0) {
         class_aeq.class_a_in_class_aeq[] var1 = values();
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            class_aeq.class_a_in_class_aeq var4 = var1[var3];
            if(var4.f == var0) {
               return var4;
            }
         }

         return b;
      }
   }
}
