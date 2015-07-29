package net.minecraft.server;

import java.util.Calendar;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_adi;
import net.minecraft.server.class_adk;
import net.minecraft.server.class_adm;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_apa;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_mt;
import net.minecraft.server.class_my;
import net.minecraft.server.class_nu;
import net.minecraft.server.class_on;
import net.minecraft.server.class_pc;
import net.minecraft.server.class_pl;
import net.minecraft.server.class_pm;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_pw;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_qd;
import net.minecraft.server.class_qf;
import net.minecraft.server.class_qh;
import net.minecraft.server.class_qi;
import net.minecraft.server.class_qk;
import net.minecraft.server.class_rb;
import net.minecraft.server.class_ri;
import net.minecraft.server.class_rj;
import net.minecraft.server.class_rm;
import net.minecraft.server.class_rr;
import net.minecraft.server.class_ru;
import net.minecraft.server.class_sh;
import net.minecraft.server.class_si;
import net.minecraft.server.class_sk;
import net.minecraft.server.class_sm;
import net.minecraft.server.class_sw;
import net.minecraft.server.class_sz;
import net.minecraft.server.class_uj;
import net.minecraft.server.class_ul;
import net.minecraft.server.class_wa;
import net.minecraft.server.class_wi;
import net.minecraft.server.class_wk;
import net.minecraft.server.class_wl;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xd;

public class class_wn extends class_wi implements class_wk {
   private static final int a = class_qi.a(class_wn.class);
   private static final int b = class_qi.a(class_wn.class);
   private class_sk c = new class_sk(this, 1.0D, 20, 60, 15.0F);
   private class_ru bs = new class_ru(this, class_xa.class, 1.2D, false) {
      public void d() {
         super.d();
         class_wn.this.a(false);
      }

      public void c() {
         super.c();
         class_wn.this.a(true);
      }
   };

   public class_wn(class_aen var1) {
      super(var1);
      this.i.a(1, new class_rj(this));
      this.i.a(2, new class_sm(this));
      this.i.a(3, new class_ri(this, 1.0D));
      this.i.a(3, new class_rb(this, class_ul.class, 6.0F, 1.0D, 1.2D));
      this.i.a(4, new class_si(this, 1.0D));
      this.i.a(6, new class_rr(this, class_xa.class, 8.0F));
      this.i.a(6, new class_sh(this));
      this.bn.a(1, new class_sw(this, false, new Class[0]));
      this.bn.a(2, new class_sz(this, class_xa.class, true));
      this.bn.a(3, new class_sz(this, class_uj.class, true));
      if(var1 != null && !var1.D) {
         this.n();
      }

   }

   protected void aY() {
      super.aY();
      this.a((class_qk)class_wl.d).a(0.25D);
   }

   protected void h() {
      super.h();
      this.ac.a(a, Byte.valueOf((byte)0));
      this.ac.a(b, Byte.valueOf((byte)0));
   }

   protected String C() {
      return "mob.skeleton.say";
   }

   protected String bp() {
      return "mob.skeleton.hurt";
   }

   protected String bq() {
      return "mob.skeleton.death";
   }

   protected void a(class_cj var1, class_agj var2) {
      this.a("mob.skeleton.step", 0.15F, 1.0F);
   }

   public boolean r(class_pr var1) {
      if(super.r(var1)) {
         if(this.cB() == 1 && var1 instanceof class_qa) {
            ((class_qa)var1).c(new class_pl(class_pm.t, 200));
         }

         return true;
      } else {
         return false;
      }
   }

   public class_qf bz() {
      return class_qf.b;
   }

   public void m() {
      if(this.o.x() && !this.o.D) {
         float var1 = this.c(1.0F);
         class_cj var2 = new class_cj(this.s, (double)Math.round(this.t), this.u);
         if(var1 > 0.5F && this.V.nextFloat() * 30.0F < (var1 - 0.4F) * 2.0F && this.o.i(var2)) {
            boolean var3 = true;
            class_aas var4 = this.a((class_pw)class_pw.f);
            if(var4 != null) {
               if(var4.e()) {
                  var4.b(var4.h() + this.V.nextInt(2));
                  if(var4.h() >= var4.j()) {
                     this.b(var4);
                     this.a((class_pw)class_pw.f, (class_aas)null);
                  }
               }

               var3 = false;
            }

            if(var3) {
               this.f(8);
            }
         }
      }

      if(this.o.D && this.cB() == 1) {
         this.a(0.72F, 2.535F);
      }

      super.m();
   }

   public void ak() {
      super.ak();
      if(this.m instanceof class_qh) {
         class_qh var1 = (class_qh)this.m;
         this.aL = var1.aL;
      }

   }

   public void a(class_pc var1) {
      super.a(var1);
      if(var1.i() instanceof class_xd && var1.j() instanceof class_xa) {
         class_xa var2 = (class_xa)var1.j();
         double var3 = var2.s - this.s;
         double var5 = var2.u - this.u;
         if(var3 * var3 + var5 * var5 >= 2500.0D) {
            var2.b((class_my)class_mt.v);
         }
      } else if(var1.j() instanceof class_wa && ((class_wa)var1.j()).n() && ((class_wa)var1.j()).cE()) {
         ((class_wa)var1.j()).cF();
         this.a(new class_aas(class_aau.ca, 1, this.cB() == 1?1:0), 0.0F);
      }

   }

   protected class_aar D() {
      return class_aau.g;
   }

   protected void b(boolean var1, int var2) {
      int var3;
      int var4;
      if(this.cB() == 1) {
         var3 = this.V.nextInt(3 + var2) - 1;

         for(var4 = 0; var4 < var3; ++var4) {
            this.a(class_aau.j, 1);
         }
      } else {
         var3 = this.V.nextInt(3 + var2);

         for(var4 = 0; var4 < var3; ++var4) {
            this.a(class_aau.g, 1);
         }
      }

      var3 = this.V.nextInt(3 + var2);

      for(var4 = 0; var4 < var3; ++var4) {
         this.a(class_aau.aZ, 1);
      }

   }

   protected void br() {
      if(this.cB() == 1) {
         this.a(new class_aas(class_aau.ca, 1, 1), 0.0F);
      }

   }

   protected void a(class_on var1) {
      super.a(var1);
      this.a(class_pw.a, new class_aas(class_aau.f));
   }

   public class_qd a(class_on var1, class_qd var2) {
      var2 = super.a(var1, var2);
      if(this.o.t instanceof class_apa && this.bd().nextInt(5) > 0) {
         this.i.a(4, this.bs);
         this.a(1);
         this.a(class_pw.a, new class_aas(class_aau.s));
         this.a((class_qk)class_wl.e).a(4.0D);
      } else {
         this.i.a(4, this.c);
         this.a(var1);
         this.b(var1);
      }

      this.j(this.V.nextFloat() < 0.55F * var1.c());
      if(this.a((class_pw)class_pw.f) == null) {
         Calendar var3 = this.o.Z();
         if(var3.get(2) + 1 == 10 && var3.get(5) == 31 && this.V.nextFloat() < 0.25F) {
            this.a(class_pw.f, new class_aas(this.V.nextFloat() < 0.1F?class_agk.aZ:class_agk.aU));
            this.bp[class_pw.f.b()] = 0.0F;
         }
      }

      return var2;
   }

   public void n() {
      this.i.a((class_rm)this.bs);
      this.i.a((class_rm)this.c);
      class_aas var1 = this.bA();
      if(var1 != null && var1.b() == class_aau.f) {
         this.i.a(4, this.c);
      } else {
         this.i.a(4, this.bs);
      }

   }

   public void a(class_qa var1, float var2) {
      class_xd var3 = new class_xd(this.o, this);
      double var4 = var1.s - this.s;
      double var6 = var1.aT().b + (double)(var1.K / 3.0F) - var3.t;
      double var8 = var1.u - this.u;
      double var10 = (double)class_nu.a(var4 * var4 + var8 * var8);
      var3.c(var4, var6 + var10 * 0.20000000298023224D, var8, 1.6F, (float)(14 - this.o.ab().a() * 4));
      int var12 = class_adk.a((class_adi)class_adm.t, (class_qa)this);
      int var13 = class_adk.a((class_adi)class_adm.u, (class_qa)this);
      var3.b((double)(var2 * 2.0F) + this.V.nextGaussian() * 0.25D + (double)((float)this.o.ab().a() * 0.11F));
      if(var12 > 0) {
         var3.b(var3.l() + (double)var12 * 0.5D + 0.5D);
      }

      if(var13 > 0) {
         var3.a(var13);
      }

      if(class_adk.a((class_adi)class_adm.v, (class_qa)this) > 0 || this.cB() == 1) {
         var3.f(100);
      }

      this.a("random.bow", 1.0F, 1.0F / (this.bd().nextFloat() * 0.4F + 0.8F));
      this.o.a((class_pr)var3);
   }

   public int cB() {
      return this.ac.a(a);
   }

   public void a(int var1) {
      this.ac.b(a, Byte.valueOf((byte)var1));
      this.ab = var1 == 1;
      if(var1 == 1) {
         this.a(0.72F, 2.535F);
      } else {
         this.a(0.6F, 1.95F);
      }

   }

   public void a(class_dn var1) {
      super.a(var1);
      if(var1.b("SkeletonType", 99)) {
         byte var2 = var1.e("SkeletonType");
         this.a(var2);
      }

      this.n();
   }

   public void b(class_dn var1) {
      super.b(var1);
      var1.a("SkeletonType", (byte)this.cB());
   }

   public void a(class_pw var1, class_aas var2) {
      super.a(var1, var2);
      if(!this.o.D && var1 == class_pw.a) {
         this.n();
      }

   }

   public float aU() {
      return this.cB() == 1?super.aU():1.74F;
   }

   public double am() {
      return this.j_()?0.0D:-0.35D;
   }

   public void a(boolean var1) {
      this.ac.b(b, Byte.valueOf((byte)(var1?1:0)));
   }
}
