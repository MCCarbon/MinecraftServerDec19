package net.minecraft.server;

public enum class_om {
   a(0, "options.difficulty.peaceful"),
   b(1, "options.difficulty.easy"),
   c(2, "options.difficulty.normal"),
   d(3, "options.difficulty.hard");

   private static final class_om[] e;
   private final int f;
   private final String g;

   private class_om(int var3, String var4) {
      this.f = var3;
      this.g = var4;
   }

   public int a() {
      return this.f;
   }

   public static class_om a(int var0) {
      return e[var0 % e.length];
   }

   public String b() {
      return this.g;
   }

   static {
      e = new class_om[values().length];
      class_om[] var0 = values();
      int var1 = var0.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         class_om var3 = var0[var2];
         e[var3.f] = var3;
      }

   }
}
