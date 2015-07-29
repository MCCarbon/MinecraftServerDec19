package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agd;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_ahi;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_amm;
import net.minecraft.server.class_amn;
import net.minecraft.server.class_ane;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_anw;
import net.minecraft.server.class_anx;
import net.minecraft.server.class_aoa;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_ck;
import net.minecraft.server.class_cl;
import net.minecraft.server.class_cn;
import net.minecraft.server.class_cp;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_cr;
import net.minecraft.server.class_cz;
import net.minecraft.server.class_da;
import net.minecraft.server.class_nc;
import net.minecraft.server.class_oj;
import net.minecraft.server.class_ol;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xz;
import net.minecraft.server.class_zu;

public class class_ahk extends class_agd {
   public static final class_anx a;
   public static final class_anw b;
   public static final class_cp N;
   protected Random O = new Random();

   protected class_ahk() {
      super(class_atk.e);
      this.j(this.M.b().a(a, class_cq.c).a(b, Boolean.valueOf(false)));
      this.a((class_zu)class_zu.d);
   }

   public int a(class_aen var1) {
      return 4;
   }

   public void c(class_aen var1, class_cj var2, class_anl var3) {
      super.c(var1, var2, var3);
      this.e(var1, var2, var3);
   }

   private void e(class_aen var1, class_cj var2, class_anl var3) {
      if(!var1.D) {
         class_cq var4 = (class_cq)var3.b(a);
         boolean var5 = var1.p(var2.c()).c().q();
         boolean var6 = var1.p(var2.d()).c().q();
         if(var4 == class_cq.c && var5 && !var6) {
            var4 = class_cq.d;
         } else if(var4 == class_cq.d && var6 && !var5) {
            var4 = class_cq.c;
         } else {
            boolean var7 = var1.p(var2.e()).c().q();
            boolean var8 = var1.p(var2.f()).c().q();
            if(var4 == class_cq.e && var7 && !var8) {
               var4 = class_cq.f;
            } else if(var4 == class_cq.f && var8 && !var7) {
               var4 = class_cq.e;
            }
         }

         var1.a((class_cj)var2, (class_anl)var3.a(a, var4).a(b, Boolean.valueOf(false)), 2);
      }
   }

   public boolean a(class_aen var1, class_cj var2, class_anl var3, class_xa var4, class_oo var5, class_aas var6, class_cq var7, float var8, float var9, float var10) {
      if(var1.D) {
         return true;
      } else {
         class_amg var11 = var1.s(var2);
         if(var11 instanceof class_amm) {
            var4.a((class_oj)((class_amm)var11));
            if(var11 instanceof class_amn) {
               var4.b(class_nc.O);
            } else {
               var4.b(class_nc.Q);
            }
         }

         return true;
      }
   }

   protected void f(class_aen var1, class_cj var2) {
      class_cl var3 = new class_cl(var1, var2);
      class_amm var4 = (class_amm)var3.h();
      if(var4 != null) {
         int var5 = var4.m();
         if(var5 < 0) {
            var1.b(1001, var2, 0);
         } else {
            class_aas var6 = var4.a(var5);
            class_cr var7 = this.a(var6);
            if(var7 != class_cr.a) {
               class_aas var8 = var7.a(var3, var6);
               var4.a(var5, var8.b <= 0?null:var8);
            }

         }
      }
   }

   protected class_cr a(class_aas var1) {
      return (class_cr)N.c(var1 == null?null:var1.b());
   }

   public void a(class_aen var1, class_cj var2, class_anl var3, class_agj var4) {
      boolean var5 = var1.z(var2) || var1.z(var2.a());
      boolean var6 = ((Boolean)var3.b(b)).booleanValue();
      if(var5 && !var6) {
         var1.a((class_cj)var2, (class_agj)this, this.a(var1));
         var1.a((class_cj)var2, (class_anl)var3.a(b, Boolean.valueOf(true)), 4);
      } else if(!var5 && var6) {
         var1.a((class_cj)var2, (class_anl)var3.a(b, Boolean.valueOf(false)), 4);
      }

   }

   public void b(class_aen var1, class_cj var2, class_anl var3, Random var4) {
      if(!var1.D) {
         this.f(var1, var2);
      }

   }

   public class_amg a(class_aen var1, int var2) {
      return new class_amm();
   }

   public class_anl a(class_aen var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, class_qa var8) {
      return this.S().a(a, class_ane.a(var1, var2, var8)).a(b, Boolean.valueOf(false));
   }

   public void a(class_aen var1, class_cj var2, class_anl var3, class_qa var4, class_aas var5) {
      var1.a((class_cj)var2, (class_anl)var3.a(a, class_ane.a(var1, var2, var4)), 2);
      if(var5.s()) {
         class_amg var6 = var1.s(var2);
         if(var6 instanceof class_amm) {
            ((class_amm)var6).a(var5.q());
         }
      }

   }

   public void b(class_aen var1, class_cj var2, class_anl var3) {
      class_amg var4 = var1.s(var2);
      if(var4 instanceof class_amm) {
         class_ol.a(var1, (class_cj)var2, (class_amm)var4);
         var1.e(var2, this);
      }

      super.b(var1, var2, var3);
   }

   public static class_cz a(class_ck var0) {
      class_cq var1 = b(var0.f());
      double var2 = var0.a() + 0.7D * (double)var1.g();
      double var4 = var0.b() + 0.7D * (double)var1.h();
      double var6 = var0.c() + 0.7D * (double)var1.i();
      return new class_da(var2, var4, var6);
   }

   public static class_cq b(int var0) {
      return class_cq.a(var0 & 7);
   }

   public boolean Q() {
      return true;
   }

   public int l(class_aen var1, class_cj var2) {
      return class_xz.a(var1.s(var2));
   }

   public int b() {
      return 3;
   }

   public class_anl a(int var1) {
      return this.S().a(a, b(var1)).a(b, Boolean.valueOf((var1 & 8) > 0));
   }

   public int c(class_anl var1) {
      byte var2 = 0;
      int var3 = var2 | ((class_cq)var1.b(a)).a();
      if(((Boolean)var1.b(b)).booleanValue()) {
         var3 |= 8;
      }

      return var3;
   }

   public class_anl a(class_anl var1, class_agj.class_c_in_class_agj var2) {
      return var1.c() != this?var1:var1.a(a, var2.a((class_cq)var1.b(a)));
   }

   public class_anl a(class_anl var1, class_agj.class_a_in_class_agj var2) {
      return var1.c() != this?var1:this.a(var1, var2.a((class_cq)var1.b(a)));
   }

   protected class_anm e() {
      return new class_anm(this, new class_aoa[]{a, b});
   }

   static {
      a = class_ahi.b;
      b = class_anw.a("triggered");
      N = new class_cp(new class_cn());
   }
}
