package net.minecraft.server;

import java.util.Iterator;
import java.util.Random;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_adi;
import net.minecraft.server.class_adk;
import net.minecraft.server.class_adl;
import net.minecraft.server.class_adz;
import net.minecraft.server.class_aea;
import net.minecraft.server.class_aeb;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_du;
import net.minecraft.server.class_eb;
import net.minecraft.server.class_eu;
import net.minecraft.server.class_fa;
import net.minecraft.server.class_fb;
import net.minecraft.server.class_nc;
import net.minecraft.server.class_nu;
import net.minecraft.server.class_ob;
import net.minecraft.server.class_on;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_ow;
import net.minecraft.server.class_pc;
import net.minecraft.server.class_pl;
import net.minecraft.server.class_pm;
import net.minecraft.server.class_po;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_px;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_qb;
import net.minecraft.server.class_qd;
import net.minecraft.server.class_qi;
import net.minecraft.server.class_qk;
import net.minecraft.server.class_rb;
import net.minecraft.server.class_rj;
import net.minecraft.server.class_ro;
import net.minecraft.server.class_rp;
import net.minecraft.server.class_rr;
import net.minecraft.server.class_rs;
import net.minecraft.server.class_rt;
import net.minecraft.server.class_rv;
import net.minecraft.server.class_ry;
import net.minecraft.server.class_sd;
import net.minecraft.server.class_sf;
import net.minecraft.server.class_si;
import net.minecraft.server.class_sl;
import net.minecraft.server.class_sq;
import net.minecraft.server.class_ss;
import net.minecraft.server.class_st;
import net.minecraft.server.class_tf;
import net.minecraft.server.class_tp;
import net.minecraft.server.class_vi;
import net.minecraft.server.class_vm;
import net.minecraft.server.class_wd;
import net.minecraft.server.class_wl;
import net.minecraft.server.class_wq;
import net.minecraft.server.class_wr;
import net.minecraft.server.class_wu;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_zy;

public class class_wv extends class_po implements class_adz, class_wu {
   private static final int bt = class_qi.a(class_wv.class);
   private int bu;
   private boolean bv;
   private boolean bw;
   class_tp bs;
   private class_xa bx;
   private class_aeb by;
   private int bz;
   private boolean bA;
   private boolean bB;
   private int bC;
   private String bD;
   private int bE;
   private int bF;
   private boolean bG;
   private boolean bH;
   private class_ow bI;
   private static final class_wv.class_f_in_class_wv[][][][] bJ;

   public class_wv(class_aen var1) {
      this(var1, 0);
   }

   public class_wv(class_aen var1, int var2) {
      super(var1);
      this.bI = new class_ow("Items", false, 8);
      this.m(var2);
      this.a(0.6F, 1.8F);
      ((class_tf)this.u()).b(true);
      ((class_tf)this.u()).a(true);
      this.i.a(0, new class_rj(this));
      this.i.a(1, new class_rb(this, class_wr.class, 8.0F, 0.6D, 0.6D));
      this.i.a(1, new class_ss(this));
      this.i.a(1, new class_rs(this));
      this.i.a(2, new class_rv(this));
      this.i.a(3, new class_sl(this));
      this.i.a(4, new class_sd(this, true));
      this.i.a(5, new class_ry(this, 0.6D));
      this.i.a(6, new class_rt(this));
      this.i.a(7, new class_sq(this));
      this.i.a(9, new class_rp(this, class_xa.class, 3.0F, 1.0F));
      this.i.a(9, new class_st(this));
      this.i.a(9, new class_si(this, 0.6D));
      this.i.a(10, new class_rr(this, class_qb.class, 8.0F));
      this.j(true);
   }

   private void cK() {
      if(!this.bH) {
         this.bH = true;
         if(this.j_()) {
            this.i.a(8, new class_sf(this, 0.32D));
         } else if(this.cA() == 0) {
            this.i.a(6, new class_ro(this, 0.6D));
         }

      }
   }

   protected void n() {
      if(this.cA() == 0) {
         this.i.a(8, new class_ro(this, 0.6D));
      }

      super.n();
   }

   protected void aY() {
      super.aY();
      this.a((class_qk)class_wl.d).a(0.5D);
   }

   protected void cc() {
      if(--this.bu <= 0) {
         class_cj var1 = new class_cj(this);
         this.o.af().a(var1);
         this.bu = 70 + this.V.nextInt(50);
         this.bs = this.o.af().a(var1, 32);
         if(this.bs == null) {
            this.cy();
         } else {
            class_cj var2 = this.bs.a();
            this.a(var2, (int)((float)this.bs.b() * 1.0F));
            if(this.bG) {
               this.bG = false;
               this.bs.b(5);
            }
         }
      }

      if(!this.cD() && this.bz > 0) {
         --this.bz;
         if(this.bz <= 0) {
            if(this.bA) {
               Iterator var3 = this.by.iterator();

               while(var3.hasNext()) {
                  class_aea var4 = (class_aea)var3.next();
                  if(var4.h()) {
                     var4.a(this.V.nextInt(6) + this.V.nextInt(6) + 2);
                  }
               }

               this.cL();
               this.bA = false;
               if(this.bs != null && this.bD != null) {
                  this.o.a((class_pr)this, (byte)14);
                  this.bs.a(this.bD, 1);
               }
            }

            this.c(new class_pl(class_pm.j, 200, 0));
         }
      }

      super.cc();
   }

   public boolean a(class_xa var1, class_oo var2, class_aas var3) {
      boolean var4 = var3 != null && var3.b() == class_aau.bM;
      if(!var4 && this.ai() && !this.cD() && !this.j_()) {
         if(!this.o.D && (this.by == null || !this.by.isEmpty())) {
            this.a(var1);
            var1.a((class_adz)this);
         }

         var1.b(class_nc.F);
         return true;
      } else {
         return super.a(var1, var2, var3);
      }
   }

   protected void h() {
      super.h();
      this.ac.a(bt, Integer.valueOf(0));
   }

   public void b(class_dn var1) {
      super.b(var1);
      var1.a("Profession", this.cA());
      var1.a("Riches", this.bC);
      var1.a("Career", this.bE);
      var1.a("CareerLevel", this.bF);
      var1.a("Willing", this.bB);
      if(this.by != null) {
         var1.a((String)"Offers", (class_eb)this.by.a());
      }

      class_du var2 = new class_du();

      for(int var3 = 0; var3 < this.bI.o_(); ++var3) {
         class_aas var4 = this.bI.a(var3);
         if(var4 != null) {
            var2.a((class_eb)var4.b(new class_dn()));
         }
      }

      var1.a((String)"Inventory", (class_eb)var2);
   }

   public void a(class_dn var1) {
      super.a(var1);
      this.m(var1.g("Profession"));
      this.bC = var1.g("Riches");
      this.bE = var1.g("Career");
      this.bF = var1.g("CareerLevel");
      this.bB = var1.o("Willing");
      if(var1.b("Offers", 10)) {
         class_dn var2 = var1.n("Offers");
         this.by = new class_aeb(var2);
      }

      class_du var5 = var1.c("Inventory", 10);

      for(int var3 = 0; var3 < var5.c(); ++var3) {
         class_aas var4 = class_aas.a(var5.b(var3));
         if(var4 != null) {
            this.bI.a(var4);
         }
      }

      this.j(true);
      this.cK();
   }

   protected boolean E() {
      return false;
   }

   protected String C() {
      return this.cD()?"mob.villager.haggle":"mob.villager.idle";
   }

   protected String bp() {
      return "mob.villager.hit";
   }

   protected String bq() {
      return "mob.villager.death";
   }

   public void m(int var1) {
      this.ac.b(bt, Integer.valueOf(var1));
   }

   public int cA() {
      return Math.max(this.ac.c(bt) % 5, 0);
   }

   public boolean cB() {
      return this.bv;
   }

   public void m(boolean var1) {
      this.bv = var1;
   }

   public void n(boolean var1) {
      this.bw = var1;
   }

   public boolean cC() {
      return this.bw;
   }

   public void b(class_qa var1) {
      super.b(var1);
      if(this.bs != null && var1 != null) {
         this.bs.a(var1);
         if(var1 instanceof class_xa) {
            byte var2 = -1;
            if(this.j_()) {
               var2 = -3;
            }

            this.bs.a(var1.e_(), var2);
            if(this.ai()) {
               this.o.a((class_pr)this, (byte)13);
            }
         }
      }

   }

   public void a(class_pc var1) {
      if(this.bs != null) {
         class_pr var2 = var1.j();
         if(var2 != null) {
            if(var2 instanceof class_xa) {
               this.bs.a(var2.e_(), -2);
            } else if(var2 instanceof class_wd) {
               this.bs.h();
            }
         } else {
            class_xa var3 = this.o.a(this, 16.0D);
            if(var3 != null) {
               this.bs.h();
            }
         }
      }

      super.a((class_pc)var1);
   }

   public void a(class_xa var1) {
      this.bx = var1;
   }

   public class_xa v_() {
      return this.bx;
   }

   public boolean cD() {
      return this.bx != null;
   }

   public boolean o(boolean var1) {
      if(!this.bB && var1 && this.cG()) {
         boolean var2 = false;

         for(int var3 = 0; var3 < this.bI.o_(); ++var3) {
            class_aas var4 = this.bI.a(var3);
            if(var4 != null) {
               if(var4.b() == class_aau.R && var4.b >= 3) {
                  var2 = true;
                  this.bI.a(var3, 3);
               } else if((var4.b() == class_aau.bV || var4.b() == class_aau.bU) && var4.b >= 12) {
                  var2 = true;
                  this.bI.a(var3, 12);
               }
            }

            if(var2) {
               this.o.a((class_pr)this, (byte)18);
               this.bB = true;
               break;
            }
         }
      }

      return this.bB;
   }

   public void p(boolean var1) {
      this.bB = var1;
   }

   public void a(class_aea var1) {
      var1.g();
      this.a_ = -this.y();
      this.a("mob.villager.yes", this.bC(), this.bD());
      int var2 = 3 + this.V.nextInt(4);
      if(var1.e() == 1 || this.V.nextInt(5) == 0) {
         this.bz = 40;
         this.bA = true;
         this.bB = true;
         if(this.bx != null) {
            this.bD = this.bx.e_();
         } else {
            this.bD = null;
         }

         var2 += 5;
      }

      if(var1.a().b() == class_aau.bR) {
         this.bC += var1.a().b;
      }

      if(var1.j()) {
         this.o.a((class_pr)(new class_px(this.o, this.s, this.t + 0.5D, this.u, var2)));
      }

   }

   public void a_(class_aas var1) {
      if(!this.o.D && this.a_ > -this.y() + 20) {
         this.a_ = -this.y();
         if(var1 != null) {
            this.a("mob.villager.yes", this.bC(), this.bD());
         } else {
            this.a("mob.villager.no", this.bC(), this.bD());
         }
      }

   }

   public class_aeb a_(class_xa var1) {
      if(this.by == null) {
         this.cL();
      }

      return this.by;
   }

   private void cL() {
      class_wv.class_f_in_class_wv[][][] var1 = bJ[this.cA()];
      if(this.bE != 0 && this.bF != 0) {
         ++this.bF;
      } else {
         this.bE = this.V.nextInt(var1.length) + 1;
         this.bF = 1;
      }

      if(this.by == null) {
         this.by = new class_aeb();
      }

      int var2 = this.bE - 1;
      int var3 = this.bF - 1;
      class_wv.class_f_in_class_wv[][] var4 = var1[var2];
      if(var3 >= 0 && var3 < var4.length) {
         class_wv.class_f_in_class_wv[] var5 = var4[var3];
         class_wv.class_f_in_class_wv[] var6 = var5;
         int var7 = var5.length;

         for(int var8 = 0; var8 < var7; ++var8) {
            class_wv.class_f_in_class_wv var9 = var6[var8];
            var9.a(this.by, this.V);
         }
      }

   }

   public class_eu f_() {
      String var1 = this.aO();
      if(var1 != null && !var1.isEmpty()) {
         class_fa var4 = new class_fa(var1);
         var4.b().a(this.aS());
         var4.b().a(this.aM().toString());
         return var4;
      } else {
         if(this.by == null) {
            this.cL();
         }

         String var2 = null;
         switch(this.cA()) {
         case 0:
            if(this.bE == 1) {
               var2 = "farmer";
            } else if(this.bE == 2) {
               var2 = "fisherman";
            } else if(this.bE == 3) {
               var2 = "shepherd";
            } else if(this.bE == 4) {
               var2 = "fletcher";
            }
            break;
         case 1:
            var2 = "librarian";
            break;
         case 2:
            var2 = "cleric";
            break;
         case 3:
            if(this.bE == 1) {
               var2 = "armor";
            } else if(this.bE == 2) {
               var2 = "weapon";
            } else if(this.bE == 3) {
               var2 = "tool";
            }
            break;
         case 4:
            if(this.bE == 1) {
               var2 = "butcher";
            } else if(this.bE == 2) {
               var2 = "leather";
            }
         }

         if(var2 != null) {
            class_fb var3 = new class_fb("entity.Villager." + var2, new Object[0]);
            var3.b().a(this.aS());
            var3.b().a(this.aM().toString());
            return var3;
         } else {
            return super.f_();
         }
      }
   }

   public float aU() {
      float var1 = 1.62F;
      if(this.j_()) {
         var1 = (float)((double)var1 - 0.81D);
      }

      return var1;
   }

   public class_qd a(class_on var1, class_qd var2) {
      var2 = super.a(var1, var2);
      this.m(this.o.s.nextInt(5));
      this.cK();
      return var2;
   }

   public void cE() {
      this.bG = true;
   }

   public class_wv b(class_po var1) {
      class_wv var2 = new class_wv(this.o);
      var2.a(this.o.E(new class_cj(var2)), (class_qd)null);
      return var2;
   }

   public boolean cp() {
      return false;
   }

   public void a(class_vi var1) {
      if(!this.o.D && !this.I) {
         class_wq var2 = new class_wq(this.o);
         var2.b(this.s, this.t, this.u, this.y, this.z);
         var2.a(this.o.E(new class_cj(var2)), (class_qd)null);
         var2.k(this.cs());
         if(this.l_()) {
            var2.a(this.aO());
            var2.g(this.aP());
         }

         this.o.a((class_pr)var2);
         this.J();
      }
   }

   public class_ow cF() {
      return this.bI;
   }

   protected void a(class_vm var1) {
      class_aas var2 = var1.l();
      class_aar var3 = var2.b();
      if(this.a(var3)) {
         class_aas var4 = this.bI.a(var2);
         if(var4 == null) {
            var1.J();
         } else {
            var2.b = var4.b;
         }
      }

   }

   private boolean a(class_aar var1) {
      return var1 == class_aau.R || var1 == class_aau.bV || var1 == class_aau.bU || var1 == class_aau.Q || var1 == class_aau.P;
   }

   public boolean cG() {
      return this.n(1);
   }

   public boolean cH() {
      return this.n(2);
   }

   public boolean cI() {
      boolean var1 = this.cA() == 0;
      return var1?!this.n(5):!this.n(1);
   }

   private boolean n(int var1) {
      boolean var2 = this.cA() == 0;

      for(int var3 = 0; var3 < this.bI.o_(); ++var3) {
         class_aas var4 = this.bI.a(var3);
         if(var4 != null) {
            if(var4.b() == class_aau.R && var4.b >= 3 * var1 || var4.b() == class_aau.bV && var4.b >= 12 * var1 || var4.b() == class_aau.bU && var4.b >= 12 * var1) {
               return true;
            }

            if(var2 && var4.b() == class_aau.Q && var4.b >= 9 * var1) {
               return true;
            }
         }
      }

      return false;
   }

   public boolean cJ() {
      for(int var1 = 0; var1 < this.bI.o_(); ++var1) {
         class_aas var2 = this.bI.a(var1);
         if(var2 != null && (var2.b() == class_aau.P || var2.b() == class_aau.bV || var2.b() == class_aau.bU)) {
            return true;
         }
      }

      return false;
   }

   public boolean c(int var1, class_aas var2) {
      if(super.c(var1, var2)) {
         return true;
      } else {
         int var3 = var1 - 300;
         if(var3 >= 0 && var3 < this.bI.o_()) {
            this.bI.a(var3, var2);
            return true;
         } else {
            return false;
         }
      }
   }

   // $FF: synthetic method
   public class_po a(class_po var1) {
      return this.b(var1);
   }

   static {
      bJ = new class_wv.class_f_in_class_wv[][][][]{{{{new class_wv.class_a_in_class_wv(class_aau.Q, new class_wv.class_g_in_class_wv(18, 22)), new class_wv.class_a_in_class_wv(class_aau.bV, new class_wv.class_g_in_class_wv(15, 19)), new class_wv.class_a_in_class_wv(class_aau.bU, new class_wv.class_g_in_class_wv(15, 19)), new class_wv.class_e_in_class_wv(class_aau.R, new class_wv.class_g_in_class_wv(-4, -2))}, {new class_wv.class_a_in_class_wv(class_aar.a(class_agk.aU), new class_wv.class_g_in_class_wv(8, 13)), new class_wv.class_e_in_class_wv(class_aau.cd, new class_wv.class_g_in_class_wv(-3, -2))}, {new class_wv.class_a_in_class_wv(class_aar.a(class_agk.bk), new class_wv.class_g_in_class_wv(7, 12)), new class_wv.class_e_in_class_wv(class_aau.e, new class_wv.class_g_in_class_wv(-5, -7))}, {new class_wv.class_e_in_class_wv(class_aau.be, new class_wv.class_g_in_class_wv(-6, -10)), new class_wv.class_e_in_class_wv(class_aau.bb, new class_wv.class_g_in_class_wv(1, 1))}}, {{new class_wv.class_a_in_class_wv(class_aau.H, new class_wv.class_g_in_class_wv(15, 20)), new class_wv.class_a_in_class_wv(class_aau.j, new class_wv.class_g_in_class_wv(16, 24)), new class_wv.class_d_in_class_wv(class_aau.aW, new class_wv.class_g_in_class_wv(6, 6), class_aau.aX, new class_wv.class_g_in_class_wv(6, 6))}, {new class_wv.class_c_in_class_wv(class_aau.aT, new class_wv.class_g_in_class_wv(7, 8))}}, {{new class_wv.class_a_in_class_wv(class_aar.a(class_agk.L), new class_wv.class_g_in_class_wv(16, 22)), new class_wv.class_e_in_class_wv(class_aau.bg, new class_wv.class_g_in_class_wv(3, 4))}, {new class_wv.class_e_in_class_wv(new class_aas(class_aar.a(class_agk.L)), new class_wv.class_g_in_class_wv(1, 2)), new class_wv.class_e_in_class_wv(new class_aas(class_aar.a(class_agk.L), 1, 1), new class_wv.class_g_in_class_wv(1, 2)), new class_wv.class_e_in_class_wv(new class_aas(class_aar.a(class_agk.L), 1, 2), new class_wv.class_g_in_class_wv(1, 2)), new class_wv.class_e_in_class_wv(new class_aas(class_aar.a(class_agk.L), 1, 3), new class_wv.class_g_in_class_wv(1, 2)), new class_wv.class_e_in_class_wv(new class_aas(class_aar.a(class_agk.L), 1, 4), new class_wv.class_g_in_class_wv(1, 2)), new class_wv.class_e_in_class_wv(new class_aas(class_aar.a(class_agk.L), 1, 5), new class_wv.class_g_in_class_wv(1, 2)), new class_wv.class_e_in_class_wv(new class_aas(class_aar.a(class_agk.L), 1, 6), new class_wv.class_g_in_class_wv(1, 2)), new class_wv.class_e_in_class_wv(new class_aas(class_aar.a(class_agk.L), 1, 7), new class_wv.class_g_in_class_wv(1, 2)), new class_wv.class_e_in_class_wv(new class_aas(class_aar.a(class_agk.L), 1, 8), new class_wv.class_g_in_class_wv(1, 2)), new class_wv.class_e_in_class_wv(new class_aas(class_aar.a(class_agk.L), 1, 9), new class_wv.class_g_in_class_wv(1, 2)), new class_wv.class_e_in_class_wv(new class_aas(class_aar.a(class_agk.L), 1, 10), new class_wv.class_g_in_class_wv(1, 2)), new class_wv.class_e_in_class_wv(new class_aas(class_aar.a(class_agk.L), 1, 11), new class_wv.class_g_in_class_wv(1, 2)), new class_wv.class_e_in_class_wv(new class_aas(class_aar.a(class_agk.L), 1, 12), new class_wv.class_g_in_class_wv(1, 2)), new class_wv.class_e_in_class_wv(new class_aas(class_aar.a(class_agk.L), 1, 13), new class_wv.class_g_in_class_wv(1, 2)), new class_wv.class_e_in_class_wv(new class_aas(class_aar.a(class_agk.L), 1, 14), new class_wv.class_g_in_class_wv(1, 2)), new class_wv.class_e_in_class_wv(new class_aas(class_aar.a(class_agk.L), 1, 15), new class_wv.class_g_in_class_wv(1, 2))}}, {{new class_wv.class_a_in_class_wv(class_aau.H, new class_wv.class_g_in_class_wv(15, 20)), new class_wv.class_e_in_class_wv(class_aau.g, new class_wv.class_g_in_class_wv(-12, -8))}, {new class_wv.class_e_in_class_wv(class_aau.f, new class_wv.class_g_in_class_wv(2, 3)), new class_wv.class_d_in_class_wv(class_aar.a(class_agk.n), new class_wv.class_g_in_class_wv(10, 10), class_aau.am, new class_wv.class_g_in_class_wv(6, 10))}}}, {{{new class_wv.class_a_in_class_wv(class_aau.aM, new class_wv.class_g_in_class_wv(24, 36)), new class_wv.class_b_in_class_wv()}, {new class_wv.class_a_in_class_wv(class_aau.aN, new class_wv.class_g_in_class_wv(8, 10)), new class_wv.class_e_in_class_wv(class_aau.aS, new class_wv.class_g_in_class_wv(10, 12)), new class_wv.class_e_in_class_wv(class_aar.a(class_agk.X), new class_wv.class_g_in_class_wv(3, 4))}, {new class_wv.class_a_in_class_wv(class_aau.bQ, new class_wv.class_g_in_class_wv(2, 2)), new class_wv.class_e_in_class_wv(class_aau.aU, new class_wv.class_g_in_class_wv(10, 12)), new class_wv.class_e_in_class_wv(class_aar.a(class_agk.w), new class_wv.class_g_in_class_wv(-5, -3))}, {new class_wv.class_b_in_class_wv()}, {new class_wv.class_b_in_class_wv()}, {new class_wv.class_e_in_class_wv(class_aau.cr, new class_wv.class_g_in_class_wv(20, 22))}}}, {{{new class_wv.class_a_in_class_wv(class_aau.bv, new class_wv.class_g_in_class_wv(36, 40)), new class_wv.class_a_in_class_wv(class_aau.m, new class_wv.class_g_in_class_wv(8, 10))}, {new class_wv.class_e_in_class_wv(class_aau.aE, new class_wv.class_g_in_class_wv(-4, -1)), new class_wv.class_e_in_class_wv(new class_aas(class_aau.aY, 1, class_zy.l.b()), new class_wv.class_g_in_class_wv(-2, -1))}, {new class_wv.class_e_in_class_wv(class_aau.bK, new class_wv.class_g_in_class_wv(7, 11)), new class_wv.class_e_in_class_wv(class_aar.a(class_agk.aX), new class_wv.class_g_in_class_wv(-3, -1))}, {new class_wv.class_e_in_class_wv(class_aau.bN, new class_wv.class_g_in_class_wv(3, 11))}}}, {{{new class_wv.class_a_in_class_wv(class_aau.j, new class_wv.class_g_in_class_wv(16, 24)), new class_wv.class_e_in_class_wv(class_aau.aa, new class_wv.class_g_in_class_wv(4, 6))}, {new class_wv.class_a_in_class_wv(class_aau.l, new class_wv.class_g_in_class_wv(7, 9)), new class_wv.class_e_in_class_wv(class_aau.ab, new class_wv.class_g_in_class_wv(10, 14))}, {new class_wv.class_a_in_class_wv(class_aau.k, new class_wv.class_g_in_class_wv(3, 4)), new class_wv.class_c_in_class_wv(class_aau.af, new class_wv.class_g_in_class_wv(16, 19))}, {new class_wv.class_e_in_class_wv(class_aau.Z, new class_wv.class_g_in_class_wv(5, 7)), new class_wv.class_e_in_class_wv(class_aau.Y, new class_wv.class_g_in_class_wv(9, 11)), new class_wv.class_e_in_class_wv(class_aau.W, new class_wv.class_g_in_class_wv(5, 7)), new class_wv.class_e_in_class_wv(class_aau.X, new class_wv.class_g_in_class_wv(11, 15))}}, {{new class_wv.class_a_in_class_wv(class_aau.j, new class_wv.class_g_in_class_wv(16, 24)), new class_wv.class_e_in_class_wv(class_aau.c, new class_wv.class_g_in_class_wv(6, 8))}, {new class_wv.class_a_in_class_wv(class_aau.l, new class_wv.class_g_in_class_wv(7, 9)), new class_wv.class_c_in_class_wv(class_aau.n, new class_wv.class_g_in_class_wv(9, 10))}, {new class_wv.class_a_in_class_wv(class_aau.k, new class_wv.class_g_in_class_wv(3, 4)), new class_wv.class_c_in_class_wv(class_aau.w, new class_wv.class_g_in_class_wv(12, 15)), new class_wv.class_c_in_class_wv(class_aau.z, new class_wv.class_g_in_class_wv(9, 12))}}, {{new class_wv.class_a_in_class_wv(class_aau.j, new class_wv.class_g_in_class_wv(16, 24)), new class_wv.class_c_in_class_wv(class_aau.a, new class_wv.class_g_in_class_wv(5, 7))}, {new class_wv.class_a_in_class_wv(class_aau.l, new class_wv.class_g_in_class_wv(7, 9)), new class_wv.class_c_in_class_wv(class_aau.b, new class_wv.class_g_in_class_wv(9, 11))}, {new class_wv.class_a_in_class_wv(class_aau.k, new class_wv.class_g_in_class_wv(3, 4)), new class_wv.class_c_in_class_wv(class_aau.y, new class_wv.class_g_in_class_wv(12, 15))}}}, {{{new class_wv.class_a_in_class_wv(class_aau.an, new class_wv.class_g_in_class_wv(14, 18)), new class_wv.class_a_in_class_wv(class_aau.bm, new class_wv.class_g_in_class_wv(14, 18))}, {new class_wv.class_a_in_class_wv(class_aau.j, new class_wv.class_g_in_class_wv(16, 24)), new class_wv.class_e_in_class_wv(class_aau.ao, new class_wv.class_g_in_class_wv(-7, -5)), new class_wv.class_e_in_class_wv(class_aau.bn, new class_wv.class_g_in_class_wv(-8, -6))}}, {{new class_wv.class_a_in_class_wv(class_aau.aH, new class_wv.class_g_in_class_wv(9, 12)), new class_wv.class_e_in_class_wv(class_aau.U, new class_wv.class_g_in_class_wv(2, 4))}, {new class_wv.class_c_in_class_wv(class_aau.T, new class_wv.class_g_in_class_wv(7, 12))}, {new class_wv.class_e_in_class_wv(class_aau.aC, new class_wv.class_g_in_class_wv(8, 10))}}}};
   }

   static class class_d_in_class_wv implements class_wv.class_f_in_class_wv {
      public class_aas a;
      public class_wv.class_g_in_class_wv b;
      public class_aas c;
      public class_wv.class_g_in_class_wv d;

      public class_d_in_class_wv(class_aar var1, class_wv.class_g_in_class_wv var2, class_aar var3, class_wv.class_g_in_class_wv var4) {
         this.a = new class_aas(var1);
         this.b = var2;
         this.c = new class_aas(var3);
         this.d = var4;
      }

      public void a(class_aeb var1, Random var2) {
         int var3 = 1;
         if(this.b != null) {
            var3 = this.b.a(var2);
         }

         int var4 = 1;
         if(this.d != null) {
            var4 = this.d.a(var2);
         }

         var1.add(new class_aea(new class_aas(this.a.b(), var3, this.a.i()), new class_aas(class_aau.bR), new class_aas(this.c.b(), var4, this.c.i())));
      }
   }

   static class class_b_in_class_wv implements class_wv.class_f_in_class_wv {
      public void a(class_aeb var1, Random var2) {
         class_adi var3 = (class_adi)class_adi.b.a(var2);
         int var4 = class_nu.a(var2, var3.d(), var3.b());
         class_aas var5 = class_aau.cg.a(new class_adl(var3, var4));
         int var6 = 2 + var2.nextInt(5 + var4 * 10) + 3 * var4;
         if(var6 > 64) {
            var6 = 64;
         }

         var1.add(new class_aea(new class_aas(class_aau.aN), new class_aas(class_aau.bR, var6), var5));
      }
   }

   static class class_c_in_class_wv implements class_wv.class_f_in_class_wv {
      public class_aas a;
      public class_wv.class_g_in_class_wv b;

      public class_c_in_class_wv(class_aar var1, class_wv.class_g_in_class_wv var2) {
         this.a = new class_aas(var1);
         this.b = var2;
      }

      public void a(class_aeb var1, Random var2) {
         int var3 = 1;
         if(this.b != null) {
            var3 = this.b.a(var2);
         }

         class_aas var4 = new class_aas(class_aau.bR, var3, 0);
         class_aas var5 = new class_aas(this.a.b(), 1, this.a.i());
         var5 = class_adk.a(var2, var5, 5 + var2.nextInt(15));
         var1.add(new class_aea(var4, var5));
      }
   }

   static class class_e_in_class_wv implements class_wv.class_f_in_class_wv {
      public class_aas a;
      public class_wv.class_g_in_class_wv b;

      public class_e_in_class_wv(class_aar var1, class_wv.class_g_in_class_wv var2) {
         this.a = new class_aas(var1);
         this.b = var2;
      }

      public class_e_in_class_wv(class_aas var1, class_wv.class_g_in_class_wv var2) {
         this.a = var1;
         this.b = var2;
      }

      public void a(class_aeb var1, Random var2) {
         int var3 = 1;
         if(this.b != null) {
            var3 = this.b.a(var2);
         }

         class_aas var4;
         class_aas var5;
         if(var3 < 0) {
            var4 = new class_aas(class_aau.bR);
            var5 = new class_aas(this.a.b(), -var3, this.a.i());
         } else {
            var4 = new class_aas(class_aau.bR, var3, 0);
            var5 = new class_aas(this.a.b(), 1, this.a.i());
         }

         var1.add(new class_aea(var4, var5));
      }
   }

   static class class_a_in_class_wv implements class_wv.class_f_in_class_wv {
      public class_aar a;
      public class_wv.class_g_in_class_wv b;

      public class_a_in_class_wv(class_aar var1, class_wv.class_g_in_class_wv var2) {
         this.a = var1;
         this.b = var2;
      }

      public void a(class_aeb var1, Random var2) {
         int var3 = 1;
         if(this.b != null) {
            var3 = this.b.a(var2);
         }

         var1.add(new class_aea(new class_aas(this.a, var3, 0), class_aau.bR));
      }
   }

   interface class_f_in_class_wv {
      void a(class_aeb var1, Random var2);
   }

   static class class_g_in_class_wv extends class_ob {
      public class_g_in_class_wv(int var1, int var2) {
         super(Integer.valueOf(var1), Integer.valueOf(var2));
      }

      public int a(Random var1) {
         return ((Integer)this.a()).intValue() >= ((Integer)this.b()).intValue()?((Integer)this.a()).intValue():((Integer)this.a()).intValue() + var1.nextInt(((Integer)this.b()).intValue() - ((Integer)this.a()).intValue() + 1);
      }
   }
}
