package net.minecraft.server;

import java.util.Iterator;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_aja;
import net.minecraft.server.class_akp;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_any;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_ny;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_zu;

public abstract class class_aje extends class_akp {
   public static final class_any a = class_any.a("axis", class_aje.class_a_in_class_aje.class);

   public class_aje() {
      super(class_atk.d);
      this.a(class_zu.b);
      this.c(2.0F);
      this.a(f);
   }

   public void b(class_aen var1, class_cj var2, class_anl var3) {
      byte var4 = 4;
      int var5 = var4 + 1;
      if(var1.a(var2.a(-var5, -var5, -var5), var2.a(var5, var5, var5))) {
         Iterator var6 = class_cj.a(var2.a(-var4, -var4, -var4), var2.a(var4, var4, var4)).iterator();

         while(var6.hasNext()) {
            class_cj var7 = (class_cj)var6.next();
            class_anl var8 = var1.p(var7);
            if(var8.c().v() == class_atk.j && !((Boolean)var8.b(class_aja.b)).booleanValue()) {
               var1.a((class_cj)var7, (class_anl)var8.a(class_aja.b, Boolean.valueOf(true)), 4);
            }
         }

      }
   }

   public class_anl a(class_aen var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, class_qa var8) {
      return this.a(var7).a(a, class_aje.class_a_in_class_aje.a(var3.k()));
   }

   public class_anl a(class_anl var1, class_agj.class_c_in_class_agj var2) {
      if(var1.c() != this) {
         return var1;
      } else {
         switch(class_aje.SyntheticClass_1.b[var2.ordinal()]) {
         case 1:
         case 2:
            switch(class_aje.SyntheticClass_1.a[((class_aje.class_a_in_class_aje)var1.b(a)).ordinal()]) {
            case 1:
               return var1.a(a, class_aje.class_a_in_class_aje.c);
            case 2:
               return var1.a(a, class_aje.class_a_in_class_aje.a);
            default:
               return var1;
            }
         default:
            return var1;
         }
      }
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a;
      // $FF: synthetic field
      static final int[] b;
      // $FF: synthetic field
      static final int[] c = new int[class_cq.class_a_in_class_cq.values().length];

      static {
         try {
            c[class_cq.class_a_in_class_cq.a.ordinal()] = 1;
         } catch (NoSuchFieldError var7) {
            ;
         }

         try {
            c[class_cq.class_a_in_class_cq.b.ordinal()] = 2;
         } catch (NoSuchFieldError var6) {
            ;
         }

         try {
            c[class_cq.class_a_in_class_cq.c.ordinal()] = 3;
         } catch (NoSuchFieldError var5) {
            ;
         }

         b = new int[class_agj.class_c_in_class_agj.values().length];

         try {
            b[class_agj.class_c_in_class_agj.d.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            b[class_agj.class_c_in_class_agj.b.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
            ;
         }

         a = new int[class_aje.class_a_in_class_aje.values().length];

         try {
            a[class_aje.class_a_in_class_aje.a.ordinal()] = 1;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[class_aje.class_a_in_class_aje.c.ordinal()] = 2;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }

   public static enum class_a_in_class_aje implements class_ny {
      a("x"),
      b("y"),
      c("z"),
      d("none");

      private final String e;

      private class_a_in_class_aje(String var3) {
         this.e = var3;
      }

      public String toString() {
         return this.e;
      }

      public static class_aje.class_a_in_class_aje a(class_cq.class_a_in_class_cq var0) {
         switch(class_aje.SyntheticClass_1.c[var0.ordinal()]) {
         case 1:
            return a;
         case 2:
            return b;
         case 3:
            return c;
         default:
            return d;
         }
      }

      public String l() {
         return this.e;
      }
   }
}
