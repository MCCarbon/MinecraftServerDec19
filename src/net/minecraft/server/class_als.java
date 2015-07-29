package net.minecraft.server;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_aer;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_alt;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_anw;
import net.minecraft.server.class_aoa;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_xa;

public class class_als extends class_agj {
   public static final class_anw a = class_anw.a("powered");
   public static final class_anw b = class_anw.a("suspended");
   public static final class_anw N = class_anw.a("attached");
   public static final class_anw O = class_anw.a("disarmed");
   public static final class_anw P = class_anw.a("north");
   public static final class_anw Q = class_anw.a("east");
   public static final class_anw R = class_anw.a("south");
   public static final class_anw S = class_anw.a("west");

   public class_als() {
      super(class_atk.q);
      this.j(this.M.b().a(a, Boolean.valueOf(false)).a(b, Boolean.valueOf(false)).a(N, Boolean.valueOf(false)).a(O, Boolean.valueOf(false)).a(P, Boolean.valueOf(false)).a(Q, Boolean.valueOf(false)).a(R, Boolean.valueOf(false)).a(S, Boolean.valueOf(false)));
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.15625F, 1.0F);
      this.a(true);
   }

   public class_anl a(class_anl var1, class_aer var2, class_cj var3) {
      return var1.a(P, Boolean.valueOf(c(var2, var3, var1, class_cq.c))).a(Q, Boolean.valueOf(c(var2, var3, var1, class_cq.f))).a(R, Boolean.valueOf(c(var2, var3, var1, class_cq.d))).a(S, Boolean.valueOf(c(var2, var3, var1, class_cq.e)));
   }

   public class_awf a(class_aen var1, class_cj var2, class_anl var3) {
      return null;
   }

   public boolean c() {
      return false;
   }

   public boolean d() {
      return false;
   }

   public class_aar a(class_anl var1, Random var2, int var3) {
      return class_aau.H;
   }

   public void a(class_aen var1, class_cj var2, class_anl var3, class_agj var4) {
      boolean var5 = ((Boolean)var3.b(b)).booleanValue();
      boolean var6 = !class_aen.a((class_aer)var1, (class_cj)var2.b());
      if(var5 != var6) {
         this.b(var1, var2, var3, 0);
         var1.g(var2);
      }

   }

   public void a(class_aer var1, class_cj var2) {
      class_anl var3 = var1.p(var2);
      boolean var4 = ((Boolean)var3.b(N)).booleanValue();
      boolean var5 = ((Boolean)var3.b(b)).booleanValue();
      if(!var5) {
         this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.09375F, 1.0F);
      } else if(!var4) {
         this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
      } else {
         this.a(0.0F, 0.0625F, 0.0F, 1.0F, 0.15625F, 1.0F);
      }

   }

   public void c(class_aen var1, class_cj var2, class_anl var3) {
      var3 = var3.a(b, Boolean.valueOf(!class_aen.a((class_aer)var1, (class_cj)var2.b())));
      var1.a((class_cj)var2, (class_anl)var3, 3);
      this.e(var1, var2, var3);
   }

   public void b(class_aen var1, class_cj var2, class_anl var3) {
      this.e(var1, var2, var3.a(a, Boolean.valueOf(true)));
   }

   public void a(class_aen var1, class_cj var2, class_anl var3, class_xa var4) {
      if(!var1.D) {
         if(var4.bA() != null && var4.bA().b() == class_aau.bg) {
            var1.a((class_cj)var2, (class_anl)var3.a(O, Boolean.valueOf(true)), 4);
         }

      }
   }

   private void e(class_aen var1, class_cj var2, class_anl var3) {
      class_cq[] var4 = new class_cq[]{class_cq.d, class_cq.e};
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         class_cq var7 = var4[var6];

         for(int var8 = 1; var8 < 42; ++var8) {
            class_cj var9 = var2.a(var7, var8);
            class_anl var10 = var1.p(var9);
            if(var10.c() == class_agk.bR) {
               if(var10.b(class_alt.a) == var7.d()) {
                  class_agk.bR.a(var1, var9, var10, false, true, var8, var3);
               }
               break;
            }

            if(var10.c() != class_agk.bS) {
               break;
            }
         }
      }

   }

   public void a(class_aen var1, class_cj var2, class_anl var3, class_pr var4) {
      if(!var1.D) {
         if(!((Boolean)var3.b(a)).booleanValue()) {
            this.e(var1, var2);
         }
      }
   }

   public void a(class_aen var1, class_cj var2, class_anl var3, Random var4) {
   }

   public void b(class_aen var1, class_cj var2, class_anl var3, Random var4) {
      if(!var1.D) {
         if(((Boolean)var1.p(var2).b(a)).booleanValue()) {
            this.e(var1, var2);
         }
      }
   }

   private void e(class_aen var1, class_cj var2) {
      class_anl var3 = var1.p(var2);
      boolean var4 = ((Boolean)var3.b(a)).booleanValue();
      boolean var5 = false;
      List var6 = var1.b((class_pr)null, (class_awf)(new class_awf((double)var2.n() + this.B, (double)var2.o() + this.C, (double)var2.p() + this.D, (double)var2.n() + this.E, (double)var2.o() + this.F, (double)var2.p() + this.G)));
      if(!var6.isEmpty()) {
         Iterator var7 = var6.iterator();

         while(var7.hasNext()) {
            class_pr var8 = (class_pr)var7.next();
            if(!var8.aK()) {
               var5 = true;
               break;
            }
         }
      }

      if(var5 != var4) {
         var3 = var3.a(a, Boolean.valueOf(var5));
         var1.a((class_cj)var2, (class_anl)var3, 3);
         this.e(var1, var2, var3);
      }

      if(var5) {
         var1.a((class_cj)var2, (class_agj)this, this.a(var1));
      }

   }

   public static boolean c(class_aer var0, class_cj var1, class_anl var2, class_cq var3) {
      class_cj var4 = var1.a(var3);
      class_anl var5 = var0.p(var4);
      class_agj var6 = var5.c();
      if(var6 == class_agk.bR) {
         class_cq var9 = var3.d();
         return var5.b(class_alt.a) == var9;
      } else if(var6 == class_agk.bS) {
         boolean var7 = ((Boolean)var2.b(b)).booleanValue();
         boolean var8 = ((Boolean)var5.b(b)).booleanValue();
         return var7 == var8;
      } else {
         return false;
      }
   }

   public class_anl a(int var1) {
      return this.S().a(a, Boolean.valueOf((var1 & 1) > 0)).a(b, Boolean.valueOf((var1 & 2) > 0)).a(N, Boolean.valueOf((var1 & 4) > 0)).a(O, Boolean.valueOf((var1 & 8) > 0));
   }

   public int c(class_anl var1) {
      int var2 = 0;
      if(((Boolean)var1.b(a)).booleanValue()) {
         var2 |= 1;
      }

      if(((Boolean)var1.b(b)).booleanValue()) {
         var2 |= 2;
      }

      if(((Boolean)var1.b(N)).booleanValue()) {
         var2 |= 4;
      }

      if(((Boolean)var1.b(O)).booleanValue()) {
         var2 |= 8;
      }

      return var2;
   }

   public class_anl a(class_anl var1, class_agj.class_c_in_class_agj var2) {
      if(var1.c() != this) {
         return var1;
      } else {
         switch(class_als.SyntheticClass_1.a[var2.ordinal()]) {
         case 1:
            return var1.a(P, var1.b(R)).a(Q, var1.b(S)).a(R, var1.b(P)).a(S, var1.b(Q));
         case 2:
            return var1.a(P, var1.b(Q)).a(Q, var1.b(R)).a(R, var1.b(S)).a(S, var1.b(P));
         case 3:
            return var1.a(P, var1.b(S)).a(Q, var1.b(P)).a(R, var1.b(Q)).a(S, var1.b(R));
         default:
            return var1;
         }
      }
   }

   public class_anl a(class_anl var1, class_agj.class_a_in_class_agj var2) {
      if(var1.c() != this) {
         return var1;
      } else {
         switch(class_als.SyntheticClass_1.b[var2.ordinal()]) {
         case 1:
            return var1.a(P, var1.b(R)).a(R, var1.b(P));
         case 2:
            return var1.a(Q, var1.b(S)).a(S, var1.b(Q));
         default:
            return super.a(var1, var2);
         }
      }
   }

   protected class_anm e() {
      return new class_anm(this, new class_aoa[]{a, b, N, O, P, Q, S, R});
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
