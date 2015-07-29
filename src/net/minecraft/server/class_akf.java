package net.minecraft.server;

import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_any;
import net.minecraft.server.class_aoa;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_atl;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_ny;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_zu;

public class class_akf extends class_agj {
   public static final class_any a = class_any.a("variant", class_akf.class_a_in_class_akf.class);

   public class_akf() {
      super(class_atk.e);
      this.j(this.M.b().a(a, class_akf.class_a_in_class_akf.a));
      this.a(class_zu.b);
   }

   public class_anl a(class_aen var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, class_qa var8) {
      if(var7 == class_akf.class_a_in_class_akf.c.a()) {
         switch(class_akf.SyntheticClass_1.a[var3.k().ordinal()]) {
         case 1:
            return this.S().a(a, class_akf.class_a_in_class_akf.e);
         case 2:
            return this.S().a(a, class_akf.class_a_in_class_akf.d);
         case 3:
         default:
            return this.S().a(a, class_akf.class_a_in_class_akf.c);
         }
      } else {
         return var7 == class_akf.class_a_in_class_akf.b.a()?this.S().a(a, class_akf.class_a_in_class_akf.b):this.S().a(a, class_akf.class_a_in_class_akf.a);
      }
   }

   public int a(class_anl var1) {
      class_akf.class_a_in_class_akf var2 = (class_akf.class_a_in_class_akf)var1.b(a);
      return var2 != class_akf.class_a_in_class_akf.d && var2 != class_akf.class_a_in_class_akf.e?var2.a():class_akf.class_a_in_class_akf.c.a();
   }

   protected class_aas i(class_anl var1) {
      class_akf.class_a_in_class_akf var2 = (class_akf.class_a_in_class_akf)var1.b(a);
      return var2 != class_akf.class_a_in_class_akf.d && var2 != class_akf.class_a_in_class_akf.e?super.i(var1):new class_aas(class_aar.a((class_agj)this), 1, class_akf.class_a_in_class_akf.c.a());
   }

   public class_atl g(class_anl var1) {
      return class_atl.p;
   }

   public class_anl a(int var1) {
      return this.S().a(a, class_akf.class_a_in_class_akf.a(var1));
   }

   public int c(class_anl var1) {
      return ((class_akf.class_a_in_class_akf)var1.b(a)).a();
   }

   public class_anl a(class_anl var1, class_agj.class_c_in_class_agj var2) {
      if(var1.c() != this) {
         return var1;
      } else {
         switch(class_akf.SyntheticClass_1.c[var2.ordinal()]) {
         case 1:
         case 2:
            switch(class_akf.SyntheticClass_1.b[((class_akf.class_a_in_class_akf)var1.b(a)).ordinal()]) {
            case 1:
               return var1.a(a, class_akf.class_a_in_class_akf.e);
            case 2:
               return var1.a(a, class_akf.class_a_in_class_akf.d);
            default:
               return var1;
            }
         default:
            return var1;
         }
      }
   }

   protected class_anm e() {
      return new class_anm(this, new class_aoa[]{a});
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a;
      // $FF: synthetic field
      static final int[] b;
      // $FF: synthetic field
      static final int[] c = new int[class_agj.class_c_in_class_agj.values().length];

      static {
         try {
            c[class_agj.class_c_in_class_agj.d.ordinal()] = 1;
         } catch (NoSuchFieldError var7) {
            ;
         }

         try {
            c[class_agj.class_c_in_class_agj.b.ordinal()] = 2;
         } catch (NoSuchFieldError var6) {
            ;
         }

         b = new int[class_akf.class_a_in_class_akf.values().length];

         try {
            b[class_akf.class_a_in_class_akf.d.ordinal()] = 1;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            b[class_akf.class_a_in_class_akf.e.ordinal()] = 2;
         } catch (NoSuchFieldError var4) {
            ;
         }

         a = new int[class_cq.class_a_in_class_cq.values().length];

         try {
            a[class_cq.class_a_in_class_cq.c.ordinal()] = 1;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[class_cq.class_a_in_class_cq.a.ordinal()] = 2;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[class_cq.class_a_in_class_cq.b.ordinal()] = 3;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }

   public static enum class_a_in_class_akf implements class_ny {
      a(0, "default", "default"),
      b(1, "chiseled", "chiseled"),
      c(2, "lines_y", "lines"),
      d(3, "lines_x", "lines"),
      e(4, "lines_z", "lines");

      private static final class_akf.class_a_in_class_akf[] f;
      private final int g;
      private final String h;
      private final String i;

      private class_a_in_class_akf(int var3, String var4, String var5) {
         this.g = var3;
         this.h = var4;
         this.i = var5;
      }

      public int a() {
         return this.g;
      }

      public String toString() {
         return this.i;
      }

      public static class_akf.class_a_in_class_akf a(int var0) {
         if(var0 < 0 || var0 >= f.length) {
            var0 = 0;
         }

         return f[var0];
      }

      public String l() {
         return this.h;
      }

      static {
         f = new class_akf.class_a_in_class_akf[values().length];
         class_akf.class_a_in_class_akf[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            class_akf.class_a_in_class_akf var3 = var0[var2];
            f[var3.a()] = var3;
         }

      }
   }
}
