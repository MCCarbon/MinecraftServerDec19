package net.minecraft.server;

import net.minecraft.server.class_aut;

public class class_aus {
   private class_aut[] a = new class_aut[1024];
   private int b;

   public class_aut a(class_aut var1) {
      if(var1.d >= 0) {
         throw new IllegalStateException("OW KNOWS!");
      } else {
         if(this.b == this.a.length) {
            class_aut[] var2 = new class_aut[this.b << 1];
            System.arraycopy(this.a, 0, var2, 0, this.b);
            this.a = var2;
         }

         this.a[this.b] = var1;
         var1.d = this.b;
         this.a(this.b++);
         return var1;
      }
   }

   public void a() {
      this.b = 0;
   }

   public class_aut c() {
      class_aut var1 = this.a[0];
      this.a[0] = this.a[--this.b];
      this.a[this.b] = null;
      if(this.b > 0) {
         this.b(0);
      }

      var1.d = -1;
      return var1;
   }

   public void a(class_aut var1, float var2) {
      float var3 = var1.g;
      var1.g = var2;
      if(var2 < var3) {
         this.a(var1.d);
      } else {
         this.b(var1.d);
      }

   }

   private void a(int var1) {
      class_aut var2 = this.a[var1];

      int var4;
      for(float var3 = var2.g; var1 > 0; var1 = var4) {
         var4 = var1 - 1 >> 1;
         class_aut var5 = this.a[var4];
         if(var3 >= var5.g) {
            break;
         }

         this.a[var1] = var5;
         var5.d = var1;
      }

      this.a[var1] = var2;
      var2.d = var1;
   }

   private void b(int var1) {
      class_aut var2 = this.a[var1];
      float var3 = var2.g;

      while(true) {
         int var4 = 1 + (var1 << 1);
         int var5 = var4 + 1;
         if(var4 >= this.b) {
            break;
         }

         class_aut var6 = this.a[var4];
         float var7 = var6.g;
         class_aut var8;
         float var9;
         if(var5 >= this.b) {
            var8 = null;
            var9 = Float.POSITIVE_INFINITY;
         } else {
            var8 = this.a[var5];
            var9 = var8.g;
         }

         if(var7 < var9) {
            if(var7 >= var3) {
               break;
            }

            this.a[var1] = var6;
            var6.d = var1;
            var1 = var4;
         } else {
            if(var9 >= var3) {
               break;
            }

            this.a[var1] = var8;
            var8.d = var1;
            var1 = var5;
         }
      }

      this.a[var1] = var2;
      var2.d = var1;
   }

   public boolean e() {
      return this.b == 0;
   }
}
