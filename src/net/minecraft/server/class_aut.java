package net.minecraft.server;

import net.minecraft.server.class_nu;

public class class_aut {
   public final int a;
   public final int b;
   public final int c;
   private final int j;
   public int d = -1;
   public float e;
   public float f;
   public float g;
   public class_aut h;
   public boolean i;

   public class_aut(int var1, int var2, int var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.j = a(var1, var2, var3);
   }

   public static int a(int var0, int var1, int var2) {
      return var1 & 255 | (var0 & 32767) << 8 | (var2 & 32767) << 24 | (var0 < 0?Integer.MIN_VALUE:0) | (var2 < 0?'耀':0);
   }

   public float a(class_aut var1) {
      float var2 = (float)(var1.a - this.a);
      float var3 = (float)(var1.b - this.b);
      float var4 = (float)(var1.c - this.c);
      return class_nu.c(var2 * var2 + var3 * var3 + var4 * var4);
   }

   public float b(class_aut var1) {
      float var2 = (float)(var1.a - this.a);
      float var3 = (float)(var1.b - this.b);
      float var4 = (float)(var1.c - this.c);
      return var2 * var2 + var3 * var3 + var4 * var4;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class_aut)) {
         return false;
      } else {
         class_aut var2 = (class_aut)var1;
         return this.j == var2.j && this.a == var2.a && this.b == var2.b && this.c == var2.c;
      }
   }

   public int hashCode() {
      return this.j;
   }

   public boolean a() {
      return this.d >= 0;
   }

   public String toString() {
      return this.a + ", " + this.b + ", " + this.c;
   }
}
