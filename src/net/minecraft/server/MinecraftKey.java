package net.minecraft.server;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

public class MinecraftKey {
   protected final String a;
   protected final String b;

   protected MinecraftKey(int var1, String... var2) {
      this.a = StringUtils.isEmpty(var2[0])?"minecraft":var2[0].toLowerCase();
      this.b = var2[1];
      Validate.notNull(this.b);
   }

   public MinecraftKey(String var1) {
      this(0, a(var1));
   }

   protected static String[] a(String var0) {
      String[] var1 = new String[]{"minecraft", var0};
      int var2 = var0.indexOf(58);
      if(var2 >= 0) {
         var1[1] = var0.substring(var2 + 1, var0.length());
         if(var2 > 1) {
            var1[0] = var0.substring(0, var2);
         }
      }

      return var1;
   }

   public String a() {
      return this.b;
   }

   public String b() {
      return this.a;
   }

   public String toString() {
      return this.a + ':' + this.b;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof MinecraftKey)) {
         return false;
      } else {
         MinecraftKey var2 = (MinecraftKey)var1;
         return this.a.equals(var2.a) && this.b.equals(var2.b);
      }
   }

   public int hashCode() {
      return 31 * this.a.hashCode() + this.b.hashCode();
   }
}
