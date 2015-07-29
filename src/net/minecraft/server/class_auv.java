package net.minecraft.server;

import net.minecraft.server.class_aut;
import net.minecraft.server.class_awh;
import net.minecraft.server.class_pr;

public class class_auv {
   private final class_aut[] a;
   private int b;
   private int c;

   public class_auv(class_aut[] var1) {
      this.a = var1;
      this.c = var1.length;
   }

   public void a() {
      ++this.b;
   }

   public boolean b() {
      return this.b >= this.c;
   }

   public class_aut c() {
      return this.c > 0?this.a[this.c - 1]:null;
   }

   public class_aut a(int var1) {
      return this.a[var1];
   }

   public int d() {
      return this.c;
   }

   public void b(int var1) {
      this.c = var1;
   }

   public int e() {
      return this.b;
   }

   public void c(int var1) {
      this.b = var1;
   }

   public class_awh a(class_pr var1, int var2) {
      double var3 = (double)this.a[var2].a + (double)((int)(var1.J + 1.0F)) * 0.5D;
      double var5 = (double)this.a[var2].b;
      double var7 = (double)this.a[var2].c + (double)((int)(var1.J + 1.0F)) * 0.5D;
      return new class_awh(var3, var5, var7);
   }

   public class_awh a(class_pr var1) {
      return this.a(var1, this.b);
   }

   public class_awh f() {
      class_aut var1 = this.a[this.b];
      return new class_awh((double)var1.a, (double)var1.b, (double)var1.c);
   }

   public boolean a(class_auv var1) {
      if(var1 == null) {
         return false;
      } else if(var1.a.length != this.a.length) {
         return false;
      } else {
         for(int var2 = 0; var2 < this.a.length; ++var2) {
            if(this.a[var2].a != var1.a[var2].a || this.a[var2].b != var1.a[var2].b || this.a[var2].c != var1.a[var2].c) {
               return false;
            }
         }

         return true;
      }
   }

   public boolean b(class_awh var1) {
      class_aut var2 = this.c();
      return var2 == null?false:var2.a == (int)var1.a && var2.c == (int)var1.c;
   }
}
