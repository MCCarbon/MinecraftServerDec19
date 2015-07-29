package net.minecraft.server;

import net.minecraft.server.class_agj;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_jz;

public class class_ars {
   private final int a;
   private class_anl b;
   private int c;
   private int d;

   public class_ars(int var1, class_agj var2) {
      this(3, var1, var2);
   }

   public class_ars(int var1, int var2, class_agj var3) {
      this.c = 1;
      this.a = var1;
      this.c = var2;
      this.b = var3.S();
   }

   public class_ars(int var1, int var2, class_agj var3, int var4) {
      this(var1, var2, var3);
      this.b = var3.a(var4);
   }

   public int b() {
      return this.c;
   }

   public class_anl c() {
      return this.b;
   }

   private class_agj e() {
      return this.b.c();
   }

   private int f() {
      return this.b.c().c(this.b);
   }

   public int d() {
      return this.d;
   }

   public void b(int var1) {
      this.d = var1;
   }

   public String toString() {
      String var1;
      if(this.a >= 3) {
         class_jz var2 = (class_jz)class_agj.c.b(this.e());
         var1 = var2 == null?"null":var2.toString();
         if(this.c > 1) {
            var1 = this.c + "*" + var1;
         }
      } else {
         var1 = Integer.toString(class_agj.a(this.e()));
         if(this.c > 1) {
            var1 = this.c + "x" + var1;
         }
      }

      int var3 = this.f();
      if(var3 > 0) {
         var1 = var1 + ":" + var3;
      }

      return var1;
   }
}
