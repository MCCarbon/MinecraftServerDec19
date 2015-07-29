package net.minecraft.server;

import com.google.common.cache.LoadingCache;
import java.util.Random;
import net.minecraft.server.class_abt;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_aer;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_aiq;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_ano;
import net.minecraft.server.class_anp;
import net.minecraft.server.class_any;
import net.minecraft.server.class_aoa;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_pr;

public class class_ajx extends class_aiq {
   public static final class_any a;

   public class_ajx() {
      super(class_atk.E, false);
      this.j(this.M.b().a(a, class_cq.class_a_in_class_cq.a));
      this.a(true);
   }

   public void b(class_aen var1, class_cj var2, class_anl var3, Random var4) {
      super.b(var1, var2, var3, var4);
      if(var1.t.d() && var1.R().b("doMobSpawning") && var4.nextInt(2000) < var1.ab().a()) {
         int var5 = var2.o();

         class_cj var6;
         for(var6 = var2; !class_aen.a((class_aer)var1, (class_cj)var6) && var6.o() > 0; var6 = var6.b()) {
            ;
         }

         if(var5 > 0 && !var1.p(var6.a()).c().x()) {
            class_pr var7 = class_abt.a(var1, 57, (double)var6.n() + 0.5D, (double)var6.o() + 1.1D, (double)var6.p() + 0.5D);
            if(var7 != null) {
               var7.aj = var7.aq();
            }
         }
      }

   }

   public class_awf a(class_aen var1, class_cj var2, class_anl var3) {
      return null;
   }

   public void a(class_aer var1, class_cj var2) {
      class_cq.class_a_in_class_cq var3 = (class_cq.class_a_in_class_cq)var1.p(var2).b(a);
      float var4 = 0.125F;
      float var5 = 0.125F;
      if(var3 == class_cq.class_a_in_class_cq.a) {
         var4 = 0.5F;
      }

      if(var3 == class_cq.class_a_in_class_cq.c) {
         var5 = 0.5F;
      }

      this.a(0.5F - var4, 0.0F, 0.5F - var5, 0.5F + var4, 1.0F, 0.5F + var5);
   }

   public static int a(class_cq.class_a_in_class_cq var0) {
      return var0 == class_cq.class_a_in_class_cq.a?1:(var0 == class_cq.class_a_in_class_cq.c?2:0);
   }

   public boolean d() {
      return false;
   }

   public boolean e(class_aen var1, class_cj var2) {
      class_ajx.class_a_in_class_ajx var3 = new class_ajx.class_a_in_class_ajx(var1, var2, class_cq.class_a_in_class_cq.a);
      if(var3.d() && var3.e == 0) {
         var3.e();
         return true;
      } else {
         class_ajx.class_a_in_class_ajx var4 = new class_ajx.class_a_in_class_ajx(var1, var2, class_cq.class_a_in_class_cq.c);
         if(var4.d() && var4.e == 0) {
            var4.e();
            return true;
         } else {
            return false;
         }
      }
   }

   public void a(class_aen var1, class_cj var2, class_anl var3, class_agj var4) {
      class_cq.class_a_in_class_cq var5 = (class_cq.class_a_in_class_cq)var3.b(a);
      class_ajx.class_a_in_class_ajx var6;
      if(var5 == class_cq.class_a_in_class_cq.a) {
         var6 = new class_ajx.class_a_in_class_ajx(var1, var2, class_cq.class_a_in_class_cq.a);
         if(!var6.d() || var6.e < var6.h * var6.g) {
            var1.a(var2, class_agk.a.S());
         }
      } else if(var5 == class_cq.class_a_in_class_cq.c) {
         var6 = new class_ajx.class_a_in_class_ajx(var1, var2, class_cq.class_a_in_class_cq.c);
         if(!var6.d() || var6.e < var6.h * var6.g) {
            var1.a(var2, class_agk.a.S());
         }
      }

   }

   public int a(Random var1) {
      return 0;
   }

   public void a(class_aen var1, class_cj var2, class_anl var3, class_pr var4) {
      if(var4.m == null && var4.l == null) {
         var4.d(var2);
      }

   }

   public class_anl a(int var1) {
      return this.S().a(a, (var1 & 3) == 2?class_cq.class_a_in_class_cq.c:class_cq.class_a_in_class_cq.a);
   }

   public int c(class_anl var1) {
      return a((class_cq.class_a_in_class_cq)var1.b(a));
   }

   public class_anl a(class_anl var1, class_agj.class_c_in_class_agj var2) {
      if(var1.c() != this) {
         return var1;
      } else {
         switch(class_ajx.SyntheticClass_1.b[var2.ordinal()]) {
         case 1:
         case 2:
            switch(class_ajx.SyntheticClass_1.a[((class_cq.class_a_in_class_cq)var1.b(a)).ordinal()]) {
            case 1:
               return var1.a(a, class_cq.class_a_in_class_cq.c);
            case 2:
               return var1.a(a, class_cq.class_a_in_class_cq.a);
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

   public class_anp.class_b_in_class_anp f(class_aen var1, class_cj var2) {
      class_cq.class_a_in_class_cq var3 = class_cq.class_a_in_class_cq.c;
      class_ajx.class_a_in_class_ajx var4 = new class_ajx.class_a_in_class_ajx(var1, var2, class_cq.class_a_in_class_cq.a);
      LoadingCache var5 = class_anp.a(var1, true);
      if(!var4.d()) {
         var3 = class_cq.class_a_in_class_cq.a;
         var4 = new class_ajx.class_a_in_class_ajx(var1, var2, class_cq.class_a_in_class_cq.c);
      }

      if(!var4.d()) {
         return new class_anp.class_b_in_class_anp(var2, class_cq.c, class_cq.b, var5, 1, 1, 1);
      } else {
         int[] var6 = new int[class_cq.class_b_in_class_cq.values().length];
         class_cq var7 = var4.c.f();
         class_cj var8 = var4.f.b(var4.a() - 1);
         class_cq.class_b_in_class_cq[] var9 = class_cq.class_b_in_class_cq.values();
         int var10 = var9.length;

         int var11;
         for(var11 = 0; var11 < var10; ++var11) {
            class_cq.class_b_in_class_cq var12 = var9[var11];
            class_anp.class_b_in_class_anp var13 = new class_anp.class_b_in_class_anp(var7.c() == var12?var8:var8.a(var4.c, var4.b() - 1), class_cq.a(var12, var3), class_cq.b, var5, var4.b(), var4.a(), 1);

            for(int var14 = 0; var14 < var4.b(); ++var14) {
               for(int var15 = 0; var15 < var4.a(); ++var15) {
                  class_ano var16 = var13.a(var14, var15, 1);
                  if(var16.a() != null && var16.a().c().v() != class_atk.a) {
                     ++var6[var12.ordinal()];
                  }
               }
            }
         }

         class_cq.class_b_in_class_cq var17 = class_cq.class_b_in_class_cq.a;
         class_cq.class_b_in_class_cq[] var18 = class_cq.class_b_in_class_cq.values();
         var11 = var18.length;

         for(int var19 = 0; var19 < var11; ++var19) {
            class_cq.class_b_in_class_cq var20 = var18[var19];
            if(var6[var20.ordinal()] < var6[var17.ordinal()]) {
               var17 = var20;
            }
         }

         return new class_anp.class_b_in_class_anp(var7.c() == var17?var8:var8.a(var4.c, var4.b() - 1), class_cq.a(var17, var3), class_cq.b, var5, var4.b(), var4.a(), 1);
      }
   }

   static {
      a = class_any.a("axis", class_cq.class_a_in_class_cq.class, (Enum[])(new class_cq.class_a_in_class_cq[]{class_cq.class_a_in_class_cq.a, class_cq.class_a_in_class_cq.c}));
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a;
      // $FF: synthetic field
      static final int[] b = new int[class_agj.class_c_in_class_agj.values().length];

      static {
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

         a = new int[class_cq.class_a_in_class_cq.values().length];

         try {
            a[class_cq.class_a_in_class_cq.a.ordinal()] = 1;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[class_cq.class_a_in_class_cq.c.ordinal()] = 2;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }

   public static class class_a_in_class_ajx {
      private final class_aen a;
      private final class_cq.class_a_in_class_cq b;
      private final class_cq c;
      private final class_cq d;
      private int e = 0;
      private class_cj f;
      private int g;
      private int h;

      public class_a_in_class_ajx(class_aen var1, class_cj var2, class_cq.class_a_in_class_cq var3) {
         this.a = var1;
         this.b = var3;
         if(var3 == class_cq.class_a_in_class_cq.a) {
            this.d = class_cq.f;
            this.c = class_cq.e;
         } else {
            this.d = class_cq.c;
            this.c = class_cq.d;
         }

         for(class_cj var4 = var2; var2.o() > var4.o() - 21 && var2.o() > 0 && this.a(var1.p(var2.b()).c()); var2 = var2.b()) {
            ;
         }

         int var5 = this.a(var2, this.d) - 1;
         if(var5 >= 0) {
            this.f = var2.a(this.d, var5);
            this.h = this.a(this.f, this.c);
            if(this.h < 2 || this.h > 21) {
               this.f = null;
               this.h = 0;
            }
         }

         if(this.f != null) {
            this.g = this.c();
         }

      }

      protected int a(class_cj var1, class_cq var2) {
         int var3;
         for(var3 = 0; var3 < 22; ++var3) {
            class_cj var4 = var1.a(var2, var3);
            if(!this.a(this.a.p(var4).c()) || this.a.p(var4.b()).c() != class_agk.Z) {
               break;
            }
         }

         class_agj var5 = this.a.p(var1.a(var2, var3)).c();
         return var5 == class_agk.Z?var3:0;
      }

      public int a() {
         return this.g;
      }

      public int b() {
         return this.h;
      }

      protected int c() {
         int var1;
         label56:
         for(this.g = 0; this.g < 21; ++this.g) {
            for(var1 = 0; var1 < this.h; ++var1) {
               class_cj var2 = this.f.a(this.c, var1).b(this.g);
               class_agj var3 = this.a.p(var2).c();
               if(!this.a(var3)) {
                  break label56;
               }

               if(var3 == class_agk.aY) {
                  ++this.e;
               }

               if(var1 == 0) {
                  var3 = this.a.p(var2.a(this.d)).c();
                  if(var3 != class_agk.Z) {
                     break label56;
                  }
               } else if(var1 == this.h - 1) {
                  var3 = this.a.p(var2.a(this.c)).c();
                  if(var3 != class_agk.Z) {
                     break label56;
                  }
               }
            }
         }

         for(var1 = 0; var1 < this.h; ++var1) {
            if(this.a.p(this.f.a(this.c, var1).b(this.g)).c() != class_agk.Z) {
               this.g = 0;
               break;
            }
         }

         if(this.g <= 21 && this.g >= 3) {
            return this.g;
         } else {
            this.f = null;
            this.h = 0;
            this.g = 0;
            return 0;
         }
      }

      protected boolean a(class_agj var1) {
         return var1.J == class_atk.a || var1 == class_agk.ab || var1 == class_agk.aY;
      }

      public boolean d() {
         return this.f != null && this.h >= 2 && this.h <= 21 && this.g >= 3 && this.g <= 21;
      }

      public void e() {
         for(int var1 = 0; var1 < this.h; ++var1) {
            class_cj var2 = this.f.a(this.c, var1);

            for(int var3 = 0; var3 < this.g; ++var3) {
               this.a.a((class_cj)var2.b(var3), (class_anl)class_agk.aY.S().a(class_ajx.a, this.b), 2);
            }
         }

      }
   }
}
