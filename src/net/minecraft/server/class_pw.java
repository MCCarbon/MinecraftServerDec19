package net.minecraft.server;

public enum class_pw {
    a(class_pw.class_a_in_class_pw.a, 0, 0, "mainhand"),
    b(class_pw.class_a_in_class_pw.a, 1, 5, "offhand"),
    c(class_pw.class_a_in_class_pw.b, 0, 1, "feet"),
    d(class_pw.class_a_in_class_pw.b, 1, 2, "legs"),
    e(class_pw.class_a_in_class_pw.b, 2, 3, "torso"),
    f(class_pw.class_a_in_class_pw.b, 3, 4, "head");

   private final class_pw.class_a_in_class_pw g;
   private final int h;
   private final int i;
   private final String j;

   private class_pw(class_pw.class_a_in_class_pw var3, int var4, int var5, String var6) {
      this.g = var3;
      this.h = var4;
      this.i = var5;
      this.j = var6;
   }

   public class_pw.class_a_in_class_pw a() {
      return this.g;
   }

   public int b() {
      return this.h;
   }

   public int c() {
      return this.i;
   }

   public static enum class_a_in_class_pw {
      a,
      b;
   }
}
