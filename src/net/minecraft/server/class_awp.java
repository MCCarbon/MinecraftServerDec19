package net.minecraft.server;

import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Map;

public abstract class class_awp {
   public boolean a(class_awp var1) {
      return var1 == null?false:this == var1;
   }

   public abstract String b();

   public abstract String d(String var1);

   public abstract boolean g();

   public abstract Collection d();

   public abstract class_awp.class_a_in_class_awp j();

   public static enum class_a_in_class_awp {
      a("always", 0),
      b("never", 1),
      c("hideForOtherTeams", 2),
      d("hideForOwnTeam", 3);

      private static Map g;
      public final String e;
      public final int f;

      public static String[] a() {
         return (String[])g.keySet().toArray(new String[g.size()]);
      }

      public static class_awp.class_a_in_class_awp a(String var0) {
         return (class_awp.class_a_in_class_awp)g.get(var0);
      }

      private class_a_in_class_awp(String var3, int var4) {
         this.e = var3;
         this.f = var4;
      }

      static {
         g = Maps.newHashMap();
         class_awp.class_a_in_class_awp[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            class_awp.class_a_in_class_awp var3 = var0[var2];
            g.put(var3.e, var3);
         }

      }
   }
}
