package net.minecraft.server;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Pattern;

public enum class_a {
   a("BLACK", '0', 0),
   b("DARK_BLUE", '1', 1),
   c("DARK_GREEN", '2', 2),
   d("DARK_AQUA", '3', 3),
   e("DARK_RED", '4', 4),
   f("DARK_PURPLE", '5', 5),
   g("GOLD", '6', 6),
   h("GRAY", '7', 7),
   i("DARK_GRAY", '8', 8),
   j("BLUE", '9', 9),
   k("GREEN", 'a', 10),
   l("AQUA", 'b', 11),
   m("RED", 'c', 12),
   n("LIGHT_PURPLE", 'd', 13),
   o("YELLOW", 'e', 14),
   p("WHITE", 'f', 15),
   q("OBFUSCATED", 'k', true),
   r("BOLD", 'l', true),
   s("STRIKETHROUGH", 'm', true),
   t("UNDERLINE", 'n', true),
   u("ITALIC", 'o', true),
   v("RESET", 'r', -1);

   private static final Map w;
   private static final Pattern x;
   private final String y;
   private final char z;
   private final boolean A;
   private final String B;
   private final int C;

   private static String c(String var0) {
      return var0.toLowerCase().replaceAll("[^a-z]", "");
   }

   private class_a(String var3, char var4, int var5) {
      this(var3, var4, false, var5);
   }

   private class_a(String var3, char var4, boolean var5) {
      this(var3, var4, var5, -1);
   }

   private class_a(String var3, char var4, boolean var5, int var6) {
      this.y = var3;
      this.z = var4;
      this.A = var5;
      this.C = var6;
      this.B = "§" + var4;
   }

   public int b() {
      return this.C;
   }

   public boolean c() {
      return this.A;
   }

   public boolean d() {
      return !this.A && this != v;
   }

   public String e() {
      return this.name().toLowerCase();
   }

   public String toString() {
      return this.B;
   }

   public static String a(String var0) {
      return var0 == null?null:x.matcher(var0).replaceAll("");
   }

   public static class_a b(String var0) {
      return var0 == null?null:(class_a)w.get(c(var0));
   }

   public static class_a a(int var0) {
      if(var0 < 0) {
         return v;
      } else {
         class_a[] var1 = values();
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            class_a var4 = var1[var3];
            if(var4.b() == var0) {
               return var4;
            }
         }

         return null;
      }
   }

   public static Collection a(boolean var0, boolean var1) {
      ArrayList var2 = Lists.newArrayList();
      class_a[] var3 = values();
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         class_a var6 = var3[var5];
         if((!var6.d() || var0) && (!var6.c() || var1)) {
            var2.add(var6.e());
         }
      }

      return var2;
   }

   static {
      w = Maps.newHashMap();
      x = Pattern.compile("(?i)" + String.valueOf('§') + "[0-9A-FK-OR]");
      class_a[] var0 = values();
      int var1 = var0.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         class_a var3 = var0[var2];
         w.put(c(var3.y), var3);
      }

   }
}
