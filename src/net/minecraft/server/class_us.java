package net.minecraft.server;

public enum class_us {
   a,
   b,
   c,
   d,
   e,
   f,
   g,
   h;

   public int a() {
      return this.ordinal();
   }

   public boolean b() {
      return this == f || this == h || this == g;
   }

   public static class_us a(int var0) {
      return var0 >= 0 && var0 < values().length?values()[var0]:a;
   }
}
