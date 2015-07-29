package net.minecraft.server;

import com.google.common.base.Predicate;
import java.util.List;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_aer;
import net.minecraft.server.class_agd;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_amt;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_anm;
import net.minecraft.server.class_anw;
import net.minecraft.server.class_anx;
import net.minecraft.server.class_aoa;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_atl;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_nc;
import net.minecraft.server.class_oj;
import net.minecraft.server.class_ol;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xz;
import net.minecraft.server.class_zu;

public class class_aiu extends class_agd {
   public static final class_anx a = class_anx.a("facing", new Predicate() {
      public boolean a(class_cq var1) {
         return var1 != class_cq.b;
      }

      // $FF: synthetic method
      public boolean apply(Object var1) {
         return this.a((class_cq)var1);
      }
   });
   public static final class_anw b = class_anw.a("enabled");

   public class_aiu() {
      super(class_atk.f, class_atl.m);
      this.j(this.M.b().a(a, class_cq.a).a(b, Boolean.valueOf(true)));
      this.a(class_zu.d);
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public void a(class_aer var1, class_cj var2) {
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public void a(class_aen var1, class_cj var2, class_anl var3, class_awf var4, List var5, class_pr var6) {
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.625F, 1.0F);
      super.a(var1, var2, var3, var4, var5, var6);
      float var7 = 0.125F;
      this.a(0.0F, 0.0F, 0.0F, var7, 1.0F, 1.0F);
      super.a(var1, var2, var3, var4, var5, var6);
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var7);
      super.a(var1, var2, var3, var4, var5, var6);
      this.a(1.0F - var7, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      super.a(var1, var2, var3, var4, var5, var6);
      this.a(0.0F, 0.0F, 1.0F - var7, 1.0F, 1.0F, 1.0F);
      super.a(var1, var2, var3, var4, var5, var6);
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public class_anl a(class_aen var1, class_cj var2, class_cq var3, float var4, float var5, float var6, int var7, class_qa var8) {
      class_cq var9 = var3.d();
      if(var9 == class_cq.b) {
         var9 = class_cq.a;
      }

      return this.S().a(a, var9).a(b, Boolean.valueOf(true));
   }

   public class_amg a(class_aen var1, int var2) {
      return new class_amt();
   }

   public void a(class_aen var1, class_cj var2, class_anl var3, class_qa var4, class_aas var5) {
      super.a(var1, var2, var3, var4, var5);
      if(var5.s()) {
         class_amg var6 = var1.s(var2);
         if(var6 instanceof class_amt) {
            ((class_amt)var6).a(var5.q());
         }
      }

   }

   public void c(class_aen var1, class_cj var2, class_anl var3) {
      this.e(var1, var2, var3);
   }

   public boolean a(class_aen var1, class_cj var2, class_anl var3, class_xa var4, class_oo var5, class_aas var6, class_cq var7, float var8, float var9, float var10) {
      if(var1.D) {
         return true;
      } else {
         class_amg var11 = var1.s(var2);
         if(var11 instanceof class_amt) {
            var4.a((class_oj)((class_amt)var11));
            var4.b(class_nc.P);
         }

         return true;
      }
   }

   public void a(class_aen var1, class_cj var2, class_anl var3, class_agj var4) {
      this.e(var1, var2, var3);
   }

   private void e(class_aen var1, class_cj var2, class_anl var3) {
      boolean var4 = !var1.z(var2);
      if(var4 != ((Boolean)var3.b(b)).booleanValue()) {
         var1.a((class_cj)var2, (class_anl)var3.a(b, Boolean.valueOf(var4)), 4);
      }

   }

   public void b(class_aen var1, class_cj var2, class_anl var3) {
      class_amg var4 = var1.s(var2);
      if(var4 instanceof class_amt) {
         class_ol.a(var1, (class_cj)var2, (class_amt)var4);
         var1.e(var2, this);
      }

      super.b(var1, var2, var3);
   }

   public int b() {
      return 3;
   }

   public boolean d() {
      return false;
   }

   public boolean c() {
      return false;
   }

   public static class_cq b(int var0) {
      return class_cq.a(var0 & 7);
   }

   public static boolean f(int var0) {
      return (var0 & 8) != 8;
   }

   public boolean Q() {
      return true;
   }

   public int l(class_aen var1, class_cj var2) {
      return class_xz.a(var1.s(var2));
   }

   public class_anl a(int var1) {
      return this.S().a(a, b(var1)).a(b, Boolean.valueOf(f(var1)));
   }

   public int c(class_anl var1) {
      byte var2 = 0;
      int var3 = var2 | ((class_cq)var1.b(a)).a();
      if(!((Boolean)var1.b(b)).booleanValue()) {
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
}
