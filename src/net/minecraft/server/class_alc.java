package net.minecraft.server;

import net.minecraft.server.class_aen;
import net.minecraft.server.class_agg;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_aln;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_any;
import net.minecraft.server.class_aoa;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_atl;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_zu;
import net.minecraft.server.class_zy;

public class class_alc extends class_aln {
   public static final class_any a = class_any.a("color", class_zy.class);

   public class_alc() {
      super(class_atk.s, false);
      this.j(this.M.b().a(b, Boolean.valueOf(false)).a(N, Boolean.valueOf(false)).a(O, Boolean.valueOf(false)).a(P, Boolean.valueOf(false)).a(a, class_zy.a));
      this.a(class_zu.c);
   }

   public int a(class_anl var1) {
      return ((class_zy)var1.b(a)).a();
   }

   public class_atl g(class_anl var1) {
      return ((class_zy)var1.b(a)).e();
   }

   public class_anl a(int var1) {
      return this.S().a(a, class_zy.b(var1));
   }

   public int c(class_anl var1) {
      return ((class_zy)var1.b(a)).a();
   }

   public class_anl a(class_anl var1, class_agj.class_c_in_class_agj var2) {
      if(var1.c() != this) {
         return var1;
      } else {
         switch(class_alc.SyntheticClass_1.a[var2.ordinal()]) {
         case 1:
            return var1.a(b, var1.b(O)).a(N, var1.b(P)).a(O, var1.b(b)).a(P, var1.b(N));
         case 2:
            return var1.a(b, var1.b(N)).a(N, var1.b(O)).a(O, var1.b(P)).a(P, var1.b(b));
         case 3:
            return var1.a(b, var1.b(P)).a(N, var1.b(b)).a(O, var1.b(N)).a(P, var1.b(O));
         default:
            return var1;
         }
      }
   }

   public class_anl a(class_anl var1, class_agj.class_a_in_class_agj var2) {
      if(var1.c() != this) {
         return var1;
      } else {
         switch(class_alc.SyntheticClass_1.b[var2.ordinal()]) {
         case 1:
            return var1.a(b, var1.b(O)).a(O, var1.b(b));
         case 2:
            return var1.a(N, var1.b(P)).a(P, var1.b(N));
         default:
            return super.a(var1, var2);
         }
      }
   }

   protected class_anm e() {
      return new class_anm(this, new class_aoa[]{b, N, P, O, a});
   }

   public void c(class_aen var1, class_cj var2, class_anl var3) {
      if(!var1.D) {
         class_agg.f(var1, var2);
      }

   }

   public void b(class_aen var1, class_cj var2, class_anl var3) {
      if(!var1.D) {
         class_agg.f(var1, var2);
      }

   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a;
      // $FF: synthetic field
      static final int[] b = new int[class_agj.class_a_in_class_agj.values().length];

      static {
         try {
            b[class_agj.class_a_in_class_agj.b.ordinal()] = 1;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            b[class_agj.class_a_in_class_agj.c.ordinal()] = 2;
         } catch (NoSuchFieldError var4) {
            ;
         }

         a = new int[class_agj.class_c_in_class_agj.values().length];

         try {
            a[class_agj.class_c_in_class_agj.c.ordinal()] = 1;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[class_agj.class_c_in_class_agj.d.ordinal()] = 2;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[class_agj.class_c_in_class_agj.b.ordinal()] = 3;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
