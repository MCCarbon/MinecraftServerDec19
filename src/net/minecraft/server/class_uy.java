package net.minecraft.server;

import java.util.Arrays;
import java.util.List;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_awh;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cy;
import net.minecraft.server.class_dc;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_du;
import net.minecraft.server.class_eb;
import net.minecraft.server.class_lg;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_pc;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_pw;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_qb;
import net.minecraft.server.class_qi;
import net.minecraft.server.class_vn;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xd;
import net.minecraft.server.class_za;
import net.minecraft.server.class_zg;

public class class_uy extends class_qa {
   private static final class_dc br = new class_dc(0.0F, 0.0F, 0.0F);
   private static final class_dc bs = new class_dc(0.0F, 0.0F, 0.0F);
   private static final class_dc bt = new class_dc(-10.0F, 0.0F, -10.0F);
   private static final class_dc bu = new class_dc(-15.0F, 0.0F, 10.0F);
   private static final class_dc bv = new class_dc(-1.0F, 0.0F, -1.0F);
   private static final class_dc bw = new class_dc(1.0F, 0.0F, 1.0F);
   public static final int a;
   public static final int b;
   public static final int c;
   public static final int d;
   public static final int e;
   public static final int f;
   public static final int g;
   public static final int h;
   public static final int i;
   public static final int bn;
   public static final int bo;
   public static final int bp;
   public static final int bq;
   private final class_aas[] bx;
   private final class_aas[] by;
   private boolean bz;
   private long bA;
   private int bB;
   private boolean bC;
   private class_dc bD;
   private class_dc bE;
   private class_dc bF;
   private class_dc bG;
   private class_dc bH;
   private class_dc bI;

   public class_uy(class_aen var1) {
      super(var1);
      this.bx = new class_aas[2];
      this.by = new class_aas[4];
      this.bD = br;
      this.bE = bs;
      this.bF = bt;
      this.bG = bu;
      this.bH = bv;
      this.bI = bw;
      this.b(true);
      this.T = this.p();
      this.a(0.5F, 1.975F);
   }

   public class_uy(class_aen var1, double var2, double var4, double var6) {
      this(var1);
      this.b(var2, var4, var6);
   }

   public boolean bN() {
      return super.bN() && !this.p();
   }

   protected void h() {
      super.h();
      this.ac.a(g, Byte.valueOf((byte)0));
      this.ac.a(h, br);
      this.ac.a(i, bs);
      this.ac.a(bn, bt);
      this.ac.a(bo, bu);
      this.ac.a(bp, bv);
      this.ac.a(bq, bw);
   }

   public Iterable as() {
      return Arrays.asList(this.bx);
   }

   public Iterable at() {
      return Arrays.asList(this.by);
   }

   public class_aas a(class_pw var1) {
      class_aas var2 = null;
      switch(class_uy.SyntheticClass_1.a[var1.a().ordinal()]) {
      case 1:
         var2 = this.bx[var1.b()];
         break;
      case 2:
         var2 = this.by[var1.b()];
      }

      return var2;
   }

   public void a(class_pw var1, class_aas var2) {
      switch(class_uy.SyntheticClass_1.a[var1.a().ordinal()]) {
      case 1:
         this.bx[var1.b()] = var2;
         break;
      case 2:
         this.by[var1.b()] = var2;
      }

   }

   public boolean c(int var1, class_aas var2) {
      class_pw var3;
      if(var1 == 98) {
         var3 = class_pw.a;
      } else if(var1 == 100 + class_pw.f.b()) {
         var3 = class_pw.f;
      } else if(var1 == 100 + class_pw.e.b()) {
         var3 = class_pw.e;
      } else if(var1 == 100 + class_pw.d.b()) {
         var3 = class_pw.d;
      } else {
         if(var1 != 100 + class_pw.c.b()) {
            return false;
         }

         var3 = class_pw.c;
      }

      if(var2 != null && class_qb.c(var2) != var3 && (var3 != class_pw.f || !(var2.b() instanceof class_zg))) {
         return false;
      } else {
         this.a(var3, var2);
         return true;
      }
   }

   public void b(class_dn var1) {
      super.b(var1);
      class_du var2 = new class_du();

      for(int var3 = 0; var3 < this.by.length; ++var3) {
         class_dn var4 = new class_dn();
         if(this.by[var3] != null) {
            this.by[var3].b(var4);
         }

         var2.a((class_eb)var4);
      }

      var1.a((String)"ArmorItems", (class_eb)var2);
      class_du var6 = new class_du();

      for(int var7 = 0; var7 < this.bx.length; ++var7) {
         class_dn var5 = new class_dn();
         if(this.bx[var7] != null) {
            this.bx[var7].b(var5);
         }

         var6.a((class_eb)var5);
      }

      var1.a((String)"HandItems", (class_eb)var6);
      if(this.aP() && (this.aO() == null || this.aO().isEmpty())) {
         var1.a("CustomNameVisible", this.aP());
      }

      var1.a("Invisible", this.aA());
      var1.a("Small", this.n());
      var1.a("ShowArms", this.q());
      var1.a("DisabledSlots", this.bB);
      var1.a("NoGravity", this.p());
      var1.a("NoBasePlate", this.r());
      if(this.t()) {
         var1.a("Marker", this.t());
      }

      var1.a((String)"Pose", (class_eb)this.A());
   }

   public void a(class_dn var1) {
      super.a(var1);
      if(var1.b("Equipment", 9)) {
         class_aas[] var2 = new class_aas[5];
         class_du var3 = var1.c("Equipment", 10);

         for(int var4 = 0; var4 < var2.length; ++var4) {
            var2[var4] = class_aas.a(var3.b(var4));
         }

         this.bx[class_pw.a.b()] = var2[0];
         this.by[class_pw.c.b()] = var2[1];
         this.by[class_pw.d.b()] = var2[2];
         this.by[class_pw.e.b()] = var2[3];
         this.by[class_pw.f.b()] = var2[4];
      } else {
         class_du var5;
         int var7;
         if(var1.b("ArmorItems", 9)) {
            var5 = var1.c("ArmorItems", 10);

            for(var7 = 0; var7 < this.by.length; ++var7) {
               this.by[var7] = class_aas.a(var5.b(var7));
            }
         }

         if(var1.b("HandItems", 9)) {
            var5 = var1.c("HandItems", 10);

            for(var7 = 0; var7 < this.bx.length; ++var7) {
               this.bx[var7] = class_aas.a(var5.b(var7));
            }
         }
      }

      this.f(var1.o("Invisible"));
      this.j(var1.o("Small"));
      this.l(var1.o("ShowArms"));
      this.bB = var1.g("DisabledSlots");
      this.k(var1.o("NoGravity"));
      this.m(var1.o("NoBasePlate"));
      this.n(var1.o("Marker"));
      this.bC = !this.t();
      this.T = this.p();
      class_dn var6 = var1.n("Pose");
      this.g(var6);
   }

   private void g(class_dn var1) {
      class_du var2 = var1.c("Head", 5);
      if(!var2.c_()) {
         this.a(new class_dc(var2));
      } else {
         this.a(br);
      }

      class_du var3 = var1.c("Body", 5);
      if(!var3.c_()) {
         this.b(new class_dc(var3));
      } else {
         this.b(bs);
      }

      class_du var4 = var1.c("LeftArm", 5);
      if(!var4.c_()) {
         this.c(new class_dc(var4));
      } else {
         this.c(bt);
      }

      class_du var5 = var1.c("RightArm", 5);
      if(!var5.c_()) {
         this.d(new class_dc(var5));
      } else {
         this.d(bu);
      }

      class_du var6 = var1.c("LeftLeg", 5);
      if(!var6.c_()) {
         this.e(new class_dc(var6));
      } else {
         this.e(bv);
      }

      class_du var7 = var1.c("RightLeg", 5);
      if(!var7.c_()) {
         this.f(new class_dc(var7));
      } else {
         this.f(bw);
      }

   }

   private class_dn A() {
      class_dn var1 = new class_dn();
      if(!br.equals(this.bD)) {
         var1.a((String)"Head", (class_eb)this.bD.a());
      }

      if(!bs.equals(this.bE)) {
         var1.a((String)"Body", (class_eb)this.bE.a());
      }

      if(!bt.equals(this.bF)) {
         var1.a((String)"LeftArm", (class_eb)this.bF.a());
      }

      if(!bu.equals(this.bG)) {
         var1.a((String)"RightArm", (class_eb)this.bG.a());
      }

      if(!bv.equals(this.bH)) {
         var1.a((String)"LeftLeg", (class_eb)this.bH.a());
      }

      if(!bw.equals(this.bI)) {
         var1.a((String)"RightLeg", (class_eb)this.bI.a());
      }

      return var1;
   }

   public boolean ae() {
      return false;
   }

   protected void s(class_pr var1) {
   }

   protected void bM() {
      List var1 = this.o.b((class_pr)this, (class_awf)this.aT());
      if(var1 != null && !var1.isEmpty()) {
         for(int var2 = 0; var2 < var1.size(); ++var2) {
            class_pr var3 = (class_pr)var1.get(var2);
            if(var3 instanceof class_vn && ((class_vn)var3).s() == class_vn.class_a_in_class_vn.a && this.h(var3) <= 0.2D) {
               var3.i(this);
            }
         }
      }

   }

   public class_oq a(class_xa var1, class_awh var2, class_aas var3, class_oo var4) {
      if(this.t()) {
         return class_oq.b;
      } else if(!this.o.D && !var1.v()) {
         class_pw var5 = class_pw.a;
         boolean var6 = var3 != null;
         class_aar var7 = var6?var3.b():null;
         if(var6 && var7 instanceof class_za) {
            var5 = ((class_za)var7).b;
         }

         if(var6 && (var7 == class_aau.ca || var7 == class_aar.a(class_agk.aU))) {
            var5 = class_pw.f;
         }

         double var8 = 0.1D;
         double var10 = 0.9D;
         double var12 = 0.4D;
         double var14 = 1.6D;
         class_pw var16 = class_pw.a;
         boolean var17 = this.n();
         double var18 = var17?var2.b * 2.0D:var2.b;
         if(var18 >= 0.1D && var18 < 0.1D + (var17?0.8D:0.45D) && this.a(class_pw.c) != null) {
            var16 = class_pw.c;
         } else if(var18 >= 0.9D + (var17?0.3D:0.0D) && var18 < 0.9D + (var17?1.0D:0.7D) && this.a(class_pw.e) != null) {
            var16 = class_pw.e;
         } else if(var18 >= 0.4D && var18 < 0.4D + (var17?1.0D:0.8D) && this.a(class_pw.d) != null) {
            var16 = class_pw.d;
         } else if(var18 >= 1.6D && this.a(class_pw.f) != null) {
            var16 = class_pw.f;
         }

         boolean var20 = this.a(var16) != null;
         if((this.bB & 1 << var16.c()) != 0 || (this.bB & 1 << var5.c()) != 0) {
            var16 = var5;
            if((this.bB & 1 << var5.c()) != 0) {
               if((this.bB & a) != 0) {
                  return class_oq.c;
               }

               var16 = class_pw.a;
            }
         }

         if(var6 && var5 == class_pw.a && !this.q()) {
            return class_oq.c;
         } else {
            if(var6) {
               this.a(var1, var5, var3, var4);
            } else if(var20) {
               this.a(var1, var16, var3, var4);
            }

            return class_oq.a;
         }
      } else {
         return class_oq.a;
      }
   }

   private void a(class_xa var1, class_pw var2, class_aas var3, class_oo var4) {
      class_aas var5 = this.a(var2);
      if(var5 == null || (this.bB & 1 << var2.c() + 8) == 0) {
         if(var5 != null || (this.bB & 1 << var2.c() + 16) == 0) {
            class_aas var6;
            if(var1.bH.d && (var5 == null || var5.b() == class_aar.a(class_agk.a)) && var3 != null) {
               var6 = var3.k();
               var6.b = 1;
               this.a(var2, var6);
            } else if(var3 != null && var3.b > 1) {
               if(var5 == null) {
                  var6 = var3.k();
                  var6.b = 1;
                  this.a(var2, var6);
                  --var3.b;
               }
            } else {
               this.a(var2, var3);
               var1.a((class_oo)var4, (class_aas)var5);
            }
         }
      }
   }

   public boolean a(class_pc var1, float var2) {
      if(this.o.D) {
         return false;
      } else if(class_pc.j.equals(var1)) {
         this.J();
         return false;
      } else if(!this.b((class_pc)var1) && !this.bz && !this.t()) {
         if(var1.c()) {
            this.E();
            this.J();
            return false;
         } else if(class_pc.a.equals(var1)) {
            if(!this.av()) {
               this.f(5);
            } else {
               this.a(0.15F);
            }

            return false;
         } else if(class_pc.c.equals(var1) && this.bo() > 0.5F) {
            this.a(4.0F);
            return false;
         } else {
            boolean var3 = "arrow".equals(var1.p());
            boolean var4 = "player".equals(var1.p());
            if(!var4 && !var3) {
               return false;
            } else {
               if(var1.i() instanceof class_xd) {
                  var1.i().J();
               }

               if(var1.j() instanceof class_xa && !((class_xa)var1.j()).bH.e) {
                  return false;
               } else if(var1.u()) {
                  this.C();
                  this.J();
                  return false;
               } else {
                  long var5 = this.o.L();
                  if(var5 - this.bA > 5L && !var3) {
                     this.bA = var5;
                  } else {
                     this.D();
                     this.C();
                     this.J();
                  }

                  return false;
               }
            }
         }
      } else {
         return false;
      }
   }

   private void C() {
      if(this.o instanceof class_lg) {
         ((class_lg)this.o).a(class_cy.M, this.s, this.t + (double)this.K / 1.5D, this.u, 10, (double)(this.J / 4.0F), (double)(this.K / 4.0F), (double)(this.J / 4.0F), 0.05D, new int[]{class_agj.f(class_agk.f.S())});
      }

   }

   private void a(float var1) {
      float var2 = this.bo();
      var2 -= var1;
      if(var2 <= 0.5F) {
         this.E();
         this.J();
      } else {
         this.i(var2);
      }

   }

   private void D() {
      class_agj.a(this.o, new class_cj(this), new class_aas(class_aau.cm));
      this.E();
   }

   private void E() {
      int var1;
      for(var1 = 0; var1 < this.bx.length; ++var1) {
         if(this.bx[var1] != null && this.bx[var1].b > 0) {
            if(this.bx[var1] != null) {
               class_agj.a(this.o, (new class_cj(this)).a(), this.bx[var1]);
            }

            this.bx[var1] = null;
         }
      }

      for(var1 = 0; var1 < this.by.length; ++var1) {
         if(this.by[var1] != null && this.by[var1].b > 0) {
            if(this.by[var1] != null) {
               class_agj.a(this.o, (new class_cj(this)).a(), this.by[var1]);
            }

            this.by[var1] = null;
         }
      }

   }

   protected float h(float var1, float var2) {
      this.aM = this.A;
      this.aL = this.y;
      return 0.0F;
   }

   public float aU() {
      return this.j_()?this.K * 0.5F:this.K * 0.9F;
   }

   public void g(float var1, float var2) {
      if(!this.p()) {
         super.g(var1, var2);
      }
   }

   public void t_() {
      super.t_();
      class_dc var1 = this.ac.h(h);
      if(!this.bD.equals(var1)) {
         this.a(var1);
      }

      class_dc var2 = this.ac.h(i);
      if(!this.bE.equals(var2)) {
         this.b(var2);
      }

      class_dc var3 = this.ac.h(bn);
      if(!this.bF.equals(var3)) {
         this.c(var3);
      }

      class_dc var4 = this.ac.h(bo);
      if(!this.bG.equals(var4)) {
         this.d(var4);
      }

      class_dc var5 = this.ac.h(bp);
      if(!this.bH.equals(var5)) {
         this.e(var5);
      }

      class_dc var6 = this.ac.h(bq);
      if(!this.bI.equals(var6)) {
         this.f(var6);
      }

      boolean var7 = this.t();
      if(!this.bC && var7) {
         this.a(false);
      } else {
         if(!this.bC || var7) {
            return;
         }

         this.a(true);
      }

      this.bC = var7;
   }

   private void a(boolean var1) {
      double var2 = this.s;
      double var4 = this.t;
      double var6 = this.u;
      if(var1) {
         this.a(0.5F, 1.975F);
      } else {
         this.a(0.0F, 0.0F);
      }

      this.b(var2, var4, var6);
   }

   protected void B() {
      this.f(this.bz);
   }

   public void f(boolean var1) {
      this.bz = var1;
      super.f(var1);
   }

   public boolean j_() {
      return this.n();
   }

   public void G() {
      this.J();
   }

   public boolean aX() {
      return this.aA();
   }

   private void j(boolean var1) {
      byte var2 = this.ac.a(g);
      if(var1) {
         var2 = (byte)(var2 | 1);
      } else {
         var2 &= -2;
      }

      this.ac.b(g, Byte.valueOf(var2));
   }

   public boolean n() {
      return (this.ac.a(g) & 1) != 0;
   }

   private void k(boolean var1) {
      byte var2 = this.ac.a(g);
      if(var1) {
         var2 = (byte)(var2 | 2);
      } else {
         var2 &= -3;
      }

      this.ac.b(g, Byte.valueOf(var2));
   }

   public boolean p() {
      return (this.ac.a(g) & 2) != 0;
   }

   private void l(boolean var1) {
      byte var2 = this.ac.a(g);
      if(var1) {
         var2 = (byte)(var2 | 4);
      } else {
         var2 &= -5;
      }

      this.ac.b(g, Byte.valueOf(var2));
   }

   public boolean q() {
      return (this.ac.a(g) & 4) != 0;
   }

   private void m(boolean var1) {
      byte var2 = this.ac.a(g);
      if(var1) {
         var2 = (byte)(var2 | 8);
      } else {
         var2 &= -9;
      }

      this.ac.b(g, Byte.valueOf(var2));
   }

   public boolean r() {
      return (this.ac.a(g) & 8) != 0;
   }

   private void n(boolean var1) {
      byte var2 = this.ac.a(g);
      if(var1) {
         var2 = (byte)(var2 | 16);
      } else {
         var2 &= -17;
      }

      this.ac.b(g, Byte.valueOf(var2));
   }

   public boolean t() {
      return (this.ac.a(g) & 16) != 0;
   }

   public void a(class_dc var1) {
      this.bD = var1;
      this.ac.b(h, var1);
   }

   public void b(class_dc var1) {
      this.bE = var1;
      this.ac.b(i, var1);
   }

   public void c(class_dc var1) {
      this.bF = var1;
      this.ac.b(bn, var1);
   }

   public void d(class_dc var1) {
      this.bG = var1;
      this.ac.b(bo, var1);
   }

   public void e(class_dc var1) {
      this.bH = var1;
      this.ac.b(bp, var1);
   }

   public void f(class_dc var1) {
      this.bI = var1;
      this.ac.b(bq, var1);
   }

   public class_dc u() {
      return this.bD;
   }

   public class_dc v() {
      return this.bE;
   }

   public boolean ad() {
      return super.ad() && !this.t();
   }

   static {
      a = 1 << class_pw.a.c();
      b = 1 << class_pw.c.c();
      c = 1 << class_pw.d.c();
      d = 1 << class_pw.e.c();
      e = 1 << class_pw.f.c();
      f = 1 << class_pw.b.c();
      g = class_qi.a(class_uy.class);
      h = class_qi.a(class_uy.class);
      i = class_qi.a(class_uy.class);
      bn = class_qi.a(class_uy.class);
      bo = class_qi.a(class_uy.class);
      bp = class_qi.a(class_uy.class);
      bq = class_qi.a(class_uy.class);
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a = new int[class_pw.class_a_in_class_pw.values().length];

      static {
         try {
            a[class_pw.class_a_in_class_pw.a.ordinal()] = 1;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[class_pw.class_a_in_class_pw.b.ordinal()] = 2;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
