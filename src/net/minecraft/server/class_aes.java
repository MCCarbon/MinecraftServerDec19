package net.minecraft.server;

public class class_aes {
   public static final class_aes[] a = new class_aes[16];
   public static final class_aes b = (new class_aes(0, "default", 1)).i();
   public static final class_aes c = new class_aes(1, "flat");
   public static final class_aes d = new class_aes(2, "largeBiomes");
   public static final class_aes e = (new class_aes(3, "amplified")).j();
   public static final class_aes f = new class_aes(4, "customized");
   public static final class_aes g = new class_aes(5, "debug_all_block_states");
   public static final class_aes h = (new class_aes(8, "default_1_1", 0)).a(false);
   private final int i;
   private final String j;
   private final int k;
   private boolean l;
   private boolean m;
   private boolean n;

   private class_aes(int var1, String var2) {
      this(var1, var2, 0);
   }

   private class_aes(int var1, String var2, int var3) {
      this.j = var2;
      this.k = var3;
      this.l = true;
      this.i = var1;
      a[var1] = this;
   }

   public String a() {
      return this.j;
   }

   public int d() {
      return this.k;
   }

   public class_aes a(int var1) {
      return this == b && var1 == 0?h:this;
   }

   private class_aes a(boolean var1) {
      this.l = var1;
      return this;
   }

   private class_aes i() {
      this.m = true;
      return this;
   }

   public boolean f() {
      return this.m;
   }

   public static class_aes a(String var0) {
      for(int var1 = 0; var1 < a.length; ++var1) {
         if(a[var1] != null && a[var1].j.equalsIgnoreCase(var0)) {
            return a[var1];
         }
      }

      return null;
   }

   public int g() {
      return this.i;
   }

   private class_aes j() {
      this.n = true;
      return this;
   }
}
