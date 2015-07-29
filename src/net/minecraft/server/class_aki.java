package net.minecraft.server;

import net.minecraft.server.class_agj;
import net.minecraft.server.class_akq;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_any;
import net.minecraft.server.class_aoa;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_ny;
import net.minecraft.server.class_zu;

public class class_aki extends class_agj {
   public static final class_any a = class_any.a("type", class_aki.class_a_in_class_aki.class);

   public class_aki() {
      super(class_atk.e, class_akq.class_a_in_class_akq.b.c());
      this.j(this.M.b().a(a, class_aki.class_a_in_class_aki.a));
      this.a(class_zu.b);
   }

   public int a(class_anl var1) {
      return ((class_aki.class_a_in_class_aki)var1.b(a)).a();
   }

   public class_anl a(int var1) {
      return this.S().a(a, class_aki.class_a_in_class_aki.a(var1));
   }

   public int c(class_anl var1) {
      return ((class_aki.class_a_in_class_aki)var1.b(a)).a();
   }

   protected class_anm e() {
      return new class_anm(this, new class_aoa[]{a});
   }

   public static enum class_a_in_class_aki implements class_ny {
      a(0, "red_sandstone", "default"),
      b(1, "chiseled_red_sandstone", "chiseled"),
      c(2, "smooth_red_sandstone", "smooth");

      private static final class_aki.class_a_in_class_aki[] d;
      private final int e;
      private final String f;
      private final String g;

      private class_a_in_class_aki(int var3, String var4, String var5) {
         this.e = var3;
         this.f = var4;
         this.g = var5;
      }

      public int a() {
         return this.e;
      }

      public String toString() {
         return this.f;
      }

      public static class_aki.class_a_in_class_aki a(int var0) {
         if(var0 < 0 || var0 >= d.length) {
            var0 = 0;
         }

         return d[var0];
      }

      public String l() {
         return this.f;
      }

      public String c() {
         return this.g;
      }

      static {
         d = new class_aki.class_a_in_class_aki[values().length];
         class_aki.class_a_in_class_aki[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            class_aki.class_a_in_class_aki var3 = var0[var2];
            d[var3.a()] = var3;
         }

      }
   }
}
