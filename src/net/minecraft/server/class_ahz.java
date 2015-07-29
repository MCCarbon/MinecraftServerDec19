package net.minecraft.server;

import java.util.List;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aav;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_aer;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_aia;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_anw;
import net.minecraft.server.class_aoa;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_atl;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_zu;

public class class_ahz extends class_agj {
   public static final class_anw a = class_anw.a("north");
   public static final class_anw b = class_anw.a("east");
   public static final class_anw N = class_anw.a("south");
   public static final class_anw O = class_anw.a("west");

   public class_ahz(class_atk var1) {
      this(var1, var1.r());
   }

   public class_ahz(class_atk var1, class_atl var2) {
      super(var1, var2);
      this.j(this.M.b().a(a, Boolean.valueOf(false)).a(b, Boolean.valueOf(false)).a(N, Boolean.valueOf(false)).a(O, Boolean.valueOf(false)));
      this.a(class_zu.c);
   }

   public void a(class_aen var1, class_cj var2, class_anl var3, class_awf var4, List var5, class_pr var6) {
      boolean var7 = this.e(var1, var2.c());
      boolean var8 = this.e(var1, var2.d());
      boolean var9 = this.e(var1, var2.e());
      boolean var10 = this.e(var1, var2.f());
      float var11 = 0.375F;
      float var12 = 0.625F;
      float var13 = 0.375F;
      float var14 = 0.625F;
      if(var7) {
         var13 = 0.0F;
      }

      if(var8) {
         var14 = 1.0F;
      }

      if(var7 || var8) {
         this.a(var11, 0.0F, var13, var12, 1.5F, var14);
         super.a(var1, var2, var3, var4, var5, var6);
      }

      var13 = 0.375F;
      var14 = 0.625F;
      if(var9) {
         var11 = 0.0F;
      }

      if(var10) {
         var12 = 1.0F;
      }

      if(var9 || var10 || !var7 && !var8) {
         this.a(var11, 0.0F, var13, var12, 1.5F, var14);
         super.a(var1, var2, var3, var4, var5, var6);
      }

      if(var7) {
         var13 = 0.0F;
      }

      if(var8) {
         var14 = 1.0F;
      }

      this.a(var11, 0.0F, var13, var12, 1.0F, var14);
   }

   public void a(class_aer var1, class_cj var2) {
      boolean var3 = this.e(var1, var2.c());
      boolean var4 = this.e(var1, var2.d());
      boolean var5 = this.e(var1, var2.e());
      boolean var6 = this.e(var1, var2.f());
      float var7 = 0.375F;
      float var8 = 0.625F;
      float var9 = 0.375F;
      float var10 = 0.625F;
      if(var3) {
         var9 = 0.0F;
      }

      if(var4) {
         var10 = 1.0F;
      }

      if(var5) {
         var7 = 0.0F;
      }

      if(var6) {
         var8 = 1.0F;
      }

      this.a(var7, 0.0F, var9, var8, 1.0F, var10);
   }

   public boolean c() {
      return false;
   }

   public boolean d() {
      return false;
   }

   public boolean b(class_aer var1, class_cj var2) {
      return false;
   }

   public boolean e(class_aer var1, class_cj var2) {
      class_agj var3 = var1.p(var2).c();
      return var3 == class_agk.cv?false:((!(var3 instanceof class_ahz) || var3.J != this.J) && !(var3 instanceof class_aia)?(var3.J.k() && var3.d()?var3.J != class_atk.C:false):true);
   }

   public boolean a(class_aen var1, class_cj var2, class_anl var3, class_xa var4, class_oo var5, class_aas var6, class_cq var7, float var8, float var9, float var10) {
      return var1.D?true:class_aav.a(var4, var1, var2);
   }

   public int c(class_anl var1) {
      return 0;
   }

   public class_anl a(class_anl var1, class_aer var2, class_cj var3) {
      return var1.a(a, Boolean.valueOf(this.e(var2, var3.c()))).a(b, Boolean.valueOf(this.e(var2, var3.f()))).a(N, Boolean.valueOf(this.e(var2, var3.d()))).a(O, Boolean.valueOf(this.e(var2, var3.e())));
   }

   public class_anl a(class_anl var1, class_agj.class_c_in_class_agj var2) {
      if(var1.c() != this) {
         return var1;
      } else {
         switch(class_ahz.SyntheticClass_1.a[var2.ordinal()]) {
         case 1:
            return var1.a(a, var1.b(N)).a(b, var1.b(O)).a(N, var1.b(a)).a(O, var1.b(b));
         case 2:
            return var1.a(a, var1.b(b)).a(b, var1.b(N)).a(N, var1.b(O)).a(O, var1.b(a));
         case 3:
            return var1.a(a, var1.b(O)).a(b, var1.b(a)).a(N, var1.b(b)).a(O, var1.b(N));
         default:
            return var1;
         }
      }
   }

   public class_anl a(class_anl var1, class_agj.class_a_in_class_agj var2) {
      if(var1.c() != this) {
         return var1;
      } else {
         switch(class_ahz.SyntheticClass_1.b[var2.ordinal()]) {
         case 1:
            return var1.a(a, var1.b(N)).a(N, var1.b(a));
         case 2:
            return var1.a(b, var1.b(O)).a(O, var1.b(b));
         default:
            return super.a(var1, var2);
         }
      }
   }

   protected class_anm e() {
      return new class_anm(this, new class_aoa[]{a, b, O, N});
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
