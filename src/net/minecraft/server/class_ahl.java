package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_aer;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_aiv;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_anw;
import net.minecraft.server.class_anx;
import net.minecraft.server.class_any;
import net.minecraft.server.class_aoa;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_awg;
import net.minecraft.server.class_awh;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_di;
import net.minecraft.server.class_ny;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_xa;

public class class_ahl extends class_agj {
   public static final class_anx a;
   public static final class_anw b;
   public static final class_any N;
   public static final class_anw O;
   public static final class_any P;

   protected class_ahl(class_atk var1) {
      super(var1);
      this.j(this.M.b().a(a, class_cq.c).a(b, Boolean.valueOf(false)).a(N, class_ahl.class_b_in_class_ahl.a).a(O, Boolean.valueOf(false)).a(P, class_ahl.class_a_in_class_ahl.b));
   }

   public String f() {
      return class_di.a((this.a() + ".name").replaceAll("tile", "item"));
   }

   public boolean c() {
      return false;
   }

   public boolean b(class_aer var1, class_cj var2) {
      return g(e(var1, var2));
   }

   public boolean d() {
      return false;
   }

   public class_awf a(class_aen var1, class_cj var2, class_anl var3) {
      this.a((class_aer)var1, (class_cj)var2);
      return super.a(var1, var2, var3);
   }

   public void a(class_aer var1, class_cj var2) {
      this.k(e(var1, var2));
   }

   private void k(int var1) {
      float var2 = 0.1875F;
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F);
      class_cq var3 = f(var1);
      boolean var4 = g(var1);
      boolean var5 = j(var1);
      if(var4) {
         if(var3 == class_cq.f) {
            if(!var5) {
               this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var2);
            } else {
               this.a(0.0F, 0.0F, 1.0F - var2, 1.0F, 1.0F, 1.0F);
            }
         } else if(var3 == class_cq.d) {
            if(!var5) {
               this.a(1.0F - var2, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            } else {
               this.a(0.0F, 0.0F, 0.0F, var2, 1.0F, 1.0F);
            }
         } else if(var3 == class_cq.e) {
            if(!var5) {
               this.a(0.0F, 0.0F, 1.0F - var2, 1.0F, 1.0F, 1.0F);
            } else {
               this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var2);
            }
         } else if(var3 == class_cq.c) {
            if(!var5) {
               this.a(0.0F, 0.0F, 0.0F, var2, 1.0F, 1.0F);
            } else {
               this.a(1.0F - var2, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            }
         }
      } else if(var3 == class_cq.f) {
         this.a(0.0F, 0.0F, 0.0F, var2, 1.0F, 1.0F);
      } else if(var3 == class_cq.d) {
         this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var2);
      } else if(var3 == class_cq.e) {
         this.a(1.0F - var2, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      } else if(var3 == class_cq.c) {
         this.a(0.0F, 0.0F, 1.0F - var2, 1.0F, 1.0F, 1.0F);
      }

   }

   public boolean a(class_aen var1, class_cj var2, class_anl var3, class_xa var4, class_oo var5, class_aas var6, class_cq var7, float var8, float var9, float var10) {
      if(this.J == class_atk.f) {
         return true;
      } else {
         class_cj var11 = var3.b(P) == class_ahl.class_a_in_class_ahl.b?var2:var2.b();
         class_anl var12 = var2.equals(var11)?var3:var1.p(var11);
         if(var12.c() != this) {
            return false;
         } else {
            var3 = var12.a(b);
            var1.a((class_cj)var11, (class_anl)var3, 2);
            var1.b(var11, var2);
            var1.a(var4, ((Boolean)var3.b(b)).booleanValue()?1003:1006, var2, 0);
            return true;
         }
      }
   }

   public void a(class_aen var1, class_cj var2, boolean var3) {
      class_anl var4 = var1.p(var2);
      if(var4.c() == this) {
         class_cj var5 = var4.b(P) == class_ahl.class_a_in_class_ahl.b?var2:var2.b();
         class_anl var6 = var2 == var5?var4:var1.p(var5);
         if(var6.c() == this && ((Boolean)var6.b(b)).booleanValue() != var3) {
            var1.a((class_cj)var5, (class_anl)var6.a(b, Boolean.valueOf(var3)), 2);
            var1.b(var5, var2);
            var1.a((class_xa)null, var3?1003:1006, var2, 0);
         }

      }
   }

   public void a(class_aen var1, class_cj var2, class_anl var3, class_agj var4) {
      if(var3.b(P) == class_ahl.class_a_in_class_ahl.a) {
         class_cj var5 = var2.b();
         class_anl var6 = var1.p(var5);
         if(var6.c() != this) {
            var1.g(var2);
         } else if(var4 != this) {
            this.a(var1, var5, var6, var4);
         }
      } else {
         boolean var9 = false;
         class_cj var10 = var2.a();
         class_anl var7 = var1.p(var10);
         if(var7.c() != this) {
            var1.g(var2);
            var9 = true;
         }

         if(!class_aen.a((class_aer)var1, (class_cj)var2.b())) {
            var1.g(var2);
            var9 = true;
            if(var7.c() == this) {
               var1.g(var10);
            }
         }

         if(var9) {
            if(!var1.D) {
               this.b(var1, var2, var3, 0);
            }
         } else {
            boolean var8 = var1.z(var2) || var1.z(var10);
            if((var8 || var4.i()) && var4 != this && var8 != ((Boolean)var7.b(O)).booleanValue()) {
               var1.a((class_cj)var10, (class_anl)var7.a(O, Boolean.valueOf(var8)), 2);
               if(var8 != ((Boolean)var3.b(b)).booleanValue()) {
                  var1.a((class_cj)var2, (class_anl)var3.a(b, Boolean.valueOf(var8)), 2);
                  var1.b(var2, var2);
                  var1.a((class_xa)null, var8?1003:1006, var2, 0);
               }
            }
         }
      }

   }

   public class_aar a(class_anl var1, Random var2, int var3) {
      return var1.b(P) == class_ahl.class_a_in_class_ahl.a?null:this.l();
   }

   public class_awg a(class_aen var1, class_cj var2, class_awh var3, class_awh var4) {
      this.a((class_aer)var1, (class_cj)var2);
      return super.a(var1, var2, var3, var4);
   }

   public boolean d(class_aen var1, class_cj var2) {
      return var2.o() >= 255?false:class_aen.a((class_aer)var1, (class_cj)var2.b()) && super.d(var1, var2) && super.d(var1, var2.a());
   }

   public int k() {
      return 1;
   }

   public static int e(class_aer var0, class_cj var1) {
      class_anl var2 = var0.p(var1);
      int var3 = var2.c().c(var2);
      boolean var4 = i(var3);
      class_anl var5 = var0.p(var1.b());
      int var6 = var5.c().c(var5);
      int var7 = var4?var6:var3;
      class_anl var8 = var0.p(var1.a());
      int var9 = var8.c().c(var8);
      int var10 = var4?var3:var9;
      boolean var11 = (var10 & 1) != 0;
      boolean var12 = (var10 & 2) != 0;
      return b(var7) | (var4?8:0) | (var11?16:0) | (var12?32:0);
   }

   private class_aar l() {
      return this == class_agk.aA?class_aau.aD:(this == class_agk.ap?class_aau.at:(this == class_agk.aq?class_aau.au:(this == class_agk.ar?class_aau.av:(this == class_agk.as?class_aau.aw:(this == class_agk.at?class_aau.ax:class_aau.as)))));
   }

   public void a(class_aen var1, class_cj var2, class_anl var3, class_xa var4) {
      class_cj var5 = var2.b();
      if(var4.bH.d && var3.b(P) == class_ahl.class_a_in_class_ahl.a && var1.p(var5).c() == this) {
         var1.g(var5);
      }

   }

   public class_anl a(class_anl var1, class_aer var2, class_cj var3) {
      class_anl var4;
      if(var1.b(P) == class_ahl.class_a_in_class_ahl.b) {
         var4 = var2.p(var3.a());
         if(var4.c() == this) {
            var1 = var1.a(N, var4.b(N)).a(O, var4.b(O));
         }
      } else {
         var4 = var2.p(var3.b());
         if(var4.c() == this) {
            var1 = var1.a(a, var4.b(a)).a(b, var4.b(b));
         }
      }

      return var1;
   }

   public class_anl a(class_anl var1, class_agj.class_c_in_class_agj var2) {
      return var1.c() == this && var1.b(P) == class_ahl.class_a_in_class_ahl.b?var1.a(a, var2.a((class_cq)var1.b(a))):var1;
   }

   public class_anl a(class_anl var1, class_agj.class_a_in_class_agj var2) {
      return var1.c() == this && var1.b(P) == class_ahl.class_a_in_class_ahl.b?this.a(var1, var2.a((class_cq)var1.b(a))):var1;
   }

   public class_anl a(int var1) {
      return (var1 & 8) > 0?this.S().a(P, class_ahl.class_a_in_class_ahl.a).a(N, (var1 & 1) > 0?class_ahl.class_b_in_class_ahl.b:class_ahl.class_b_in_class_ahl.a).a(O, Boolean.valueOf((var1 & 2) > 0)):this.S().a(P, class_ahl.class_a_in_class_ahl.b).a(a, class_cq.b(var1 & 3).f()).a(b, Boolean.valueOf((var1 & 4) > 0));
   }

   public int c(class_anl var1) {
      byte var2 = 0;
      int var3;
      if(var1.b(P) == class_ahl.class_a_in_class_ahl.a) {
         var3 = var2 | 8;
         if(var1.b(N) == class_ahl.class_b_in_class_ahl.b) {
            var3 |= 1;
         }

         if(((Boolean)var1.b(O)).booleanValue()) {
            var3 |= 2;
         }
      } else {
         var3 = var2 | ((class_cq)var1.b(a)).e().b();
         if(((Boolean)var1.b(b)).booleanValue()) {
            var3 |= 4;
         }
      }

      return var3;
   }

   protected static int b(int var0) {
      return var0 & 7;
   }

   public static boolean f(class_aer var0, class_cj var1) {
      return g(e(var0, var1));
   }

   public static class_cq h(class_aer var0, class_cj var1) {
      return f(e(var0, var1));
   }

   public static class_cq f(int var0) {
      return class_cq.b(var0 & 3).f();
   }

   protected static boolean g(int var0) {
      return (var0 & 4) != 0;
   }

   protected static boolean i(int var0) {
      return (var0 & 8) != 0;
   }

   protected static boolean j(int var0) {
      return (var0 & 16) != 0;
   }

   protected class_anm e() {
      return new class_anm(this, new class_aoa[]{P, a, b, N, O});
   }

   static {
      a = class_aiv.O;
      b = class_anw.a("open");
      N = class_any.a("hinge", class_ahl.class_b_in_class_ahl.class);
      O = class_anw.a("powered");
      P = class_any.a("half", class_ahl.class_a_in_class_ahl.class);
   }

   public static enum class_b_in_class_ahl implements class_ny {
      a,
      b;

      public String toString() {
         return this.l();
      }

      public String l() {
         return this == a?"left":"right";
      }
   }

   public static enum class_a_in_class_ahl implements class_ny {
      a,
      b;

      public String toString() {
         return this.l();
      }

      public String l() {
         return this == a?"upper":"lower";
      }
   }
}
