package net.minecraft.server;

public class class_aom {
   public final byte[] a;
   private final int b;
   private final int c;

   public class_aom(byte[] var1, int var2) {
      this.a = var1;
      this.b = var2;
      this.c = var2 + 4;
   }

   public int a(int var1, int var2, int var3) {
      int var4 = var1 << this.c | var3 << this.b | var2;
      int var5 = var4 >> 1;
      int var6 = var4 & 1;
      return var6 == 0?this.a[var5] & 15:this.a[var5] >> 4 & 15;
   }
}
