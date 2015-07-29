package net.minecraft.server;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.mojang.authlib.GameProfile;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_adk;
import net.minecraft.server.class_adz;
import net.minecraft.server.class_aed;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_aeq;
import net.minecraft.server.class_agh;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_aiv;
import net.minecraft.server.class_amx;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_awj;
import net.minecraft.server.class_awk;
import net.minecraft.server.class_awl;
import net.minecraft.server.class_awn;
import net.minecraft.server.class_awp;
import net.minecraft.server.class_awt;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_du;
import net.minecraft.server.class_eb;
import net.minecraft.server.class_et;
import net.minecraft.server.class_eu;
import net.minecraft.server.class_fa;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_hm;
import net.minecraft.server.class_lh;
import net.minecraft.server.class_mt;
import net.minecraft.server.class_my;
import net.minecraft.server.class_nc;
import net.minecraft.server.class_nu;
import net.minecraft.server.class_oj;
import net.minecraft.server.class_om;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_op;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_ot;
import net.minecraft.server.class_pc;
import net.minecraft.server.class_pk;
import net.minecraft.server.class_pm;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_pt;
import net.minecraft.server.class_pw;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_qb;
import net.minecraft.server.class_qf;
import net.minecraft.server.class_qi;
import net.minecraft.server.class_qk;
import net.minecraft.server.class_ql;
import net.minecraft.server.class_tz;
import net.minecraft.server.class_ud;
import net.minecraft.server.class_uo;
import net.minecraft.server.class_up;
import net.minecraft.server.class_ve;
import net.minecraft.server.class_vk;
import net.minecraft.server.class_vm;
import net.minecraft.server.class_vn;
import net.minecraft.server.class_wd;
import net.minecraft.server.class_wi;
import net.minecraft.server.class_wl;
import net.minecraft.server.class_wy;
import net.minecraft.server.class_wz;
import net.minecraft.server.class_xd;
import net.minecraft.server.class_xx;
import net.minecraft.server.class_xz;
import net.minecraft.server.class_yp;
import net.minecraft.server.class_yu;
import net.minecraft.server.class_za;
import net.minecraft.server.class_zg;

public abstract class class_xa extends class_qa {
   private static final int a = class_qi.a(class_xa.class);
   private static final int b = class_qi.a(class_xa.class);
   protected static final int bn = class_qi.a(class_xa.class);
   protected static final int bo = class_qi.a(class_xa.class);
   public class_wz bp = new class_wz(this);
   private class_yu c = new class_yu();
   public class_xz bq;
   public class_xz br;
   protected class_xx bs = new class_xx();
   protected int bt;
   public float bu;
   public float bv;
   public int bw;
   public double bx;
   public double by;
   public double bz;
   public double bA;
   public double bB;
   public double bC;
   protected boolean bD;
   public class_cj bE;
   private int d;
   public float bF;
   public float bG;
   private class_cj e;
   private boolean f;
   private class_cj g;
   public class_wy bH = new class_wy();
   public int bI;
   public int bJ;
   public float bK;
   private int h;
   protected float bL = 0.1F;
   protected float bM = 0.02F;
   private int i;
   private final GameProfile bO;
   private boolean bP = false;
   public class_ve bN;

   public class_xa(class_aen var1, GameProfile var2) {
      super(var1);
      this.aq = a(var2);
      this.bO = var2;
      this.bq = new class_yp(this.bp, !var1.D, this);
      this.br = this.bq;
      class_cj var3 = var1.N();
      this.b((double)var3.n() + 0.5D, (double)(var3.o() + 1), (double)var3.p() + 0.5D, 0.0F, 0.0F);
      this.aY = 180.0F;
      this.X = 20;
   }

   protected void aY() {
      super.aY();
      this.by().b(class_wl.e).a(1.0D);
      this.a((class_qk)class_wl.d).a(0.10000000149011612D);
   }

   protected void h() {
      super.h();
      this.ac.a(a, Float.valueOf(0.0F));
      this.ac.a(b, Integer.valueOf(0));
      this.ac.a(bn, Byte.valueOf((byte)0));
      this.ac.a(bo, Byte.valueOf((byte)1));
   }

   public void t_() {
      this.T = this.v();
      if(this.v()) {
         this.C = false;
      }

      if(this.bw > 0) {
         --this.bw;
      }

      if(this.bK()) {
         ++this.d;
         if(this.d > 100) {
            this.d = 100;
         }

         if(!this.o.D) {
            if(!this.p()) {
               this.a(true, true, false);
            } else if(this.o.x()) {
               this.a(false, true, true);
            }
         }
      } else if(this.d > 0) {
         ++this.d;
         if(this.d >= 110) {
            this.d = 0;
         }
      }

      super.t_();
      if(!this.o.D && this.br != null && !this.br.a(this)) {
         this.n();
         this.br = this.bq;
      }

      if(this.av() && this.bH.a) {
         this.N();
      }

      this.bx = this.bA;
      this.by = this.bB;
      this.bz = this.bC;
      double var1 = this.s - this.bA;
      double var3 = this.t - this.bB;
      double var5 = this.u - this.bC;
      double var7 = 10.0D;
      if(var1 > var7) {
         this.bx = this.bA = this.s;
      }

      if(var5 > var7) {
         this.bz = this.bC = this.u;
      }

      if(var3 > var7) {
         this.by = this.bB = this.t;
      }

      if(var1 < -var7) {
         this.bx = this.bA = this.s;
      }

      if(var5 < -var7) {
         this.bz = this.bC = this.u;
      }

      if(var3 < -var7) {
         this.by = this.bB = this.t;
      }

      this.bA += var1 * 0.25D;
      this.bC += var5 * 0.25D;
      this.bB += var3 * 0.25D;
      if(this.m == null) {
         this.g = null;
      }

      if(!this.o.D) {
         this.bs.a(this);
         this.b(class_nc.g);
         if(this.ai()) {
            this.b(class_nc.h);
         }
      }

      int var9 = 29999999;
      double var10 = class_nu.a(this.s, -2.9999999E7D, 2.9999999E7D);
      double var12 = class_nu.a(this.u, -2.9999999E7D, 2.9999999E7D);
      if(var10 != this.s || var12 != this.u) {
         this.b(var10, this.t, var12);
      }

   }

   public int L() {
      return this.bH.a?0:80;
   }

   protected String P() {
      return "game.player.swim";
   }

   protected String aa() {
      return "game.player.swim.splash";
   }

   public int aq() {
      return 10;
   }

   public void a(String var1, float var2, float var3) {
      this.o.a(this, var1, var2, var3);
   }

   protected boolean bE() {
      return this.bo() <= 0.0F || this.bK();
   }

   protected void n() {
      this.br = this.bq;
   }

   public void ak() {
      if(!this.o.D && this.ax()) {
         this.a((class_pr)null);
         this.c(false);
      } else {
         double var1 = this.s;
         double var3 = this.t;
         double var5 = this.u;
         float var7 = this.y;
         float var8 = this.z;
         super.ak();
         this.bu = this.bv;
         this.bv = 0.0F;
         this.l(this.s - var1, this.t - var3, this.u - var5);
         if(this.m instanceof class_ud) {
            this.z = var8;
            this.y = var7;
            this.aL = ((class_ud)this.m).aL;
         }

      }
   }

   protected void bL() {
      super.bL();
      this.bx();
      this.aN = this.y;
   }

   public void m() {
      if(this.bt > 0) {
         --this.bt;
      }

      if(this.o.ab() == class_om.a && this.o.R().b("naturalRegeneration")) {
         if(this.bo() < this.bv() && this.W % 20 == 0) {
            this.h(1.0F);
         }

         if(this.bs.c() && this.W % 10 == 0) {
            this.bs.a(this.bs.a() + 1);
         }
      }

      this.bp.k();
      this.bu = this.bv;
      super.m();
      class_ql var1 = this.a((class_qk)class_wl.d);
      if(!this.o.D) {
         var1.a((double)this.bH.b());
      }

      this.aP = this.bM;
      if(this.ay()) {
         this.aP = (float)((double)this.aP + (double)this.bM * 0.3D);
      }

      this.k((float)var1.e());
      float var2 = class_nu.a(this.v * this.v + this.x * this.x);
      float var3 = (float)(Math.atan(-this.w * 0.20000000298023224D) * 15.0D);
      if(var2 > 0.1F) {
         var2 = 0.1F;
      }

      if(!this.C || this.bo() <= 0.0F) {
         var2 = 0.0F;
      }

      if(this.C || this.bo() <= 0.0F) {
         var3 = 0.0F;
      }

      this.bv += (var2 - this.bv) * 0.4F;
      this.aI += (var3 - this.aI) * 0.8F;
      if(this.bo() > 0.0F && !this.v()) {
         class_awf var4 = null;
         if(this.m != null && !this.m.I) {
            var4 = this.aT().a(this.m.aT()).b(1.0D, 0.0D, 1.0D);
         } else {
            var4 = this.aT().b(1.0D, 0.5D, 1.0D);
         }

         List var5 = this.o.b((class_pr)this, (class_awf)var4);

         for(int var6 = 0; var6 < var5.size(); ++var6) {
            class_pr var7 = (class_pr)var5.get(var6);
            if(!var7.I) {
               this.d(var7);
            }
         }
      }

   }

   private void d(class_pr var1) {
      var1.d(this);
   }

   public int cb() {
      return this.ac.c(b);
   }

   public void m(int var1) {
      this.ac.b(b, Integer.valueOf(var1));
   }

   public void n(int var1) {
      int var2 = this.cb();
      this.ac.b(b, Integer.valueOf(var2 + var1));
   }

   public void a(class_pc var1) {
      super.a(var1);
      this.a(0.2F, 0.2F);
      this.b(this.s, this.t, this.u);
      this.w = 0.10000000149011612D;
      if(this.e_().equals("Notch")) {
         this.a(new class_aas(class_aau.e, 1), true, false);
      }

      if(!this.o.R().b("keepInventory")) {
         this.bp.n();
      }

      if(var1 != null) {
         this.v = (double)(-class_nu.b((this.az + this.y) * 3.1415927F / 180.0F) * 0.1F);
         this.x = (double)(-class_nu.a((this.az + this.y) * 3.1415927F / 180.0F) * 0.1F);
      } else {
         this.v = this.x = 0.0D;
      }

      this.b(class_nc.y);
      this.a(class_nc.h);
   }

   protected String bp() {
      return "game.player.hurt";
   }

   protected String bq() {
      return "game.player.die";
   }

   public void b(class_pr var1, int var2) {
      this.n(var2);
      Collection var3 = this.cr().a(class_awt.f);
      if(var1 instanceof class_xa) {
         this.b(class_nc.B);
         var3.addAll(this.cr().a(class_awt.e));
         var3.addAll(this.e(var1));
      } else {
         this.b(class_nc.z);
      }

      Iterator var4 = var3.iterator();

      while(var4.hasNext()) {
         class_awj var5 = (class_awj)var4.next();
         class_awl var6 = this.cr().c(this.e_(), var5);
         var6.a();
      }

   }

   private Collection e(class_pr var1) {
      class_awk var2 = this.cr().h(this.e_());
      if(var2 != null) {
         int var3 = var2.l().b();
         if(var3 >= 0 && var3 < class_awt.i.length) {
            Iterator var4 = this.cr().a(class_awt.i[var3]).iterator();

            while(var4.hasNext()) {
               class_awj var5 = (class_awj)var4.next();
               class_awl var6 = this.cr().c(var1.e_(), var5);
               var6.a();
            }
         }
      }

      class_awk var7 = this.cr().h(var1.e_());
      if(var7 != null) {
         int var8 = var7.l().b();
         if(var8 >= 0 && var8 < class_awt.h.length) {
            return this.cr().a(class_awt.h[var8]);
         }
      }

      return Lists.newArrayList();
   }

   public class_vm a(boolean var1) {
      return this.a(this.bp.a(this.bp.d, var1 && this.bp.h() != null?this.bp.h().b:1), false, true);
   }

   public class_vm a(class_aas var1, boolean var2) {
      return this.a(var1, false, false);
   }

   public class_vm a(class_aas var1, boolean var2, boolean var3) {
      if(var1 == null) {
         return null;
      } else if(var1.b == 0) {
         return null;
      } else {
         double var4 = this.t - 0.30000001192092896D + (double)this.aU();
         class_vm var6 = new class_vm(this.o, this.s, var4, this.u, var1);
         var6.a(40);
         if(var3) {
            var6.c(this.e_());
         }

         float var7;
         float var8;
         if(var2) {
            var7 = this.V.nextFloat() * 0.5F;
            var8 = this.V.nextFloat() * 3.1415927F * 2.0F;
            var6.v = (double)(-class_nu.a(var8) * var7);
            var6.x = (double)(class_nu.b(var8) * var7);
            var6.w = 0.20000000298023224D;
         } else {
            var7 = 0.3F;
            var6.v = (double)(-class_nu.a(this.y / 180.0F * 3.1415927F) * class_nu.b(this.z / 180.0F * 3.1415927F) * var7);
            var6.x = (double)(class_nu.b(this.y / 180.0F * 3.1415927F) * class_nu.b(this.z / 180.0F * 3.1415927F) * var7);
            var6.w = (double)(-class_nu.a(this.z / 180.0F * 3.1415927F) * var7 + 0.1F);
            var8 = this.V.nextFloat() * 3.1415927F * 2.0F;
            var7 = 0.02F * this.V.nextFloat();
            var6.v += Math.cos((double)var8) * (double)var7;
            var6.w += (double)((this.V.nextFloat() - this.V.nextFloat()) * 0.1F);
            var6.x += Math.sin((double)var8) * (double)var7;
         }

         this.a(var6);
         if(var3) {
            this.b(class_nc.v);
         }

         return var6;
      }
   }

   protected void a(class_vm var1) {
      this.o.a((class_pr)var1);
   }

   public float a(class_agj var1) {
      float var2 = this.bp.a(var1);
      if(var2 > 1.0F) {
         int var3 = class_adk.e(this);
         class_aas var4 = this.bA();
         if(var3 > 0 && var4 != null) {
            var2 += (float)(var3 * var3 + 1);
         }
      }

      if(this.a((class_pk)class_pm.c)) {
         var2 *= 1.0F + (float)(this.b((class_pk)class_pm.c).c() + 1) * 0.2F;
      }

      if(this.a((class_pk)class_pm.d)) {
         float var5 = 1.0F;
         switch(this.b((class_pk)class_pm.d).c()) {
         case 0:
            var5 = 0.3F;
            break;
         case 1:
            var5 = 0.09F;
            break;
         case 2:
            var5 = 0.0027F;
            break;
         case 3:
         default:
            var5 = 8.1E-4F;
         }

         var2 *= var5;
      }

      if(this.a((class_atk)class_atk.h) && !class_adk.i(this)) {
         var2 /= 5.0F;
      }

      if(!this.C) {
         var2 /= 5.0F;
      }

      return var2;
   }

   public boolean b(class_agj var1) {
      return this.bp.b(var1);
   }

   public void a(class_dn var1) {
      super.a(var1);
      this.aq = a(this.bO);
      class_du var2 = var1.c("Inventory", 10);
      this.bp.b(var2);
      this.bp.d = var1.g("SelectedItemSlot");
      this.bD = var1.o("Sleeping");
      this.d = var1.f("SleepTimer");
      this.bK = var1.i("XpP");
      this.bI = var1.g("XpLevel");
      this.bJ = var1.g("XpTotal");
      this.h = var1.g("XpSeed");
      if(this.h == 0) {
         this.h = this.V.nextInt();
      }

      this.m(var1.g("Score"));
      if(this.bD) {
         this.bE = new class_cj(this);
         this.a(true, true, false);
      }

      if(var1.b("SpawnX", 99) && var1.b("SpawnY", 99) && var1.b("SpawnZ", 99)) {
         this.e = new class_cj(var1.g("SpawnX"), var1.g("SpawnY"), var1.g("SpawnZ"));
         this.f = var1.o("SpawnForced");
      }

      this.bs.a(var1);
      this.bH.b(var1);
      if(var1.b("EnderItems", 9)) {
         class_du var3 = var1.c("EnderItems", 10);
         this.c.a(var3);
      }

   }

   public void b(class_dn var1) {
      super.b(var1);
      var1.a((String)"Inventory", (class_eb)this.bp.a(new class_du()));
      var1.a("SelectedItemSlot", this.bp.d);
      var1.a("Sleeping", this.bD);
      var1.a("SleepTimer", (short)this.d);
      var1.a("XpP", this.bK);
      var1.a("XpLevel", this.bI);
      var1.a("XpTotal", this.bJ);
      var1.a("XpSeed", this.h);
      var1.a("Score", this.cb());
      if(this.e != null) {
         var1.a("SpawnX", this.e.n());
         var1.a("SpawnY", this.e.o());
         var1.a("SpawnZ", this.e.p());
         var1.a("SpawnForced", this.f);
      }

      this.bs.b(var1);
      this.bH.a(var1);
      var1.a((String)"EnderItems", (class_eb)this.c.h());
      class_aas var2 = this.bp.h();
      if(var2 != null && var2.b() != null) {
         var1.a((String)"SelectedItem", (class_eb)var2.b(new class_dn()));
      }

   }

   public boolean a(class_pc var1, float var2) {
      if(this.b((class_pc)var1)) {
         return false;
      } else if(this.bH.a && !var1.g()) {
         return false;
      } else {
         this.aT = 0;
         if(this.bo() <= 0.0F) {
            return false;
         } else {
            if(this.bK() && !this.o.D) {
               this.a(true, true, false);
            }

            if(var1.r()) {
               if(this.o.ab() == class_om.a) {
                  var2 = 0.0F;
               }

               if(this.o.ab() == class_om.b) {
                  var2 = var2 / 2.0F + 1.0F;
               }

               if(this.o.ab() == class_om.d) {
                  var2 = var2 * 3.0F / 2.0F;
               }
            }

            if(var2 == 0.0F) {
               return false;
            } else {
               class_pr var3 = var1.j();
               if(var3 instanceof class_xd && ((class_xd)var3).e != null) {
                  var3 = ((class_xd)var3).e;
               }

               return super.a(var1, var2);
            }
         }
      }
   }

   public boolean a(class_xa var1) {
      class_awp var2 = this.bP();
      class_awp var3 = var1.bP();
      return var2 == null?true:(!var2.a(var3)?true:var2.g());
   }

   protected void j(float var1) {
      this.bp.a(var1);
   }

   public int bs() {
      return this.bp.m();
   }

   public float cc() {
      int var1 = 0;
      class_aas[] var2 = this.bp.b;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         class_aas var5 = var2[var4];
         if(var5 != null) {
            ++var1;
         }
      }

      return (float)var1 / (float)this.bp.b.length;
   }

   protected void d(class_pc var1, float var2) {
      if(!this.b((class_pc)var1)) {
         if(!var1.e() && this.ca() && var2 > 0.0F) {
            var2 = (1.0F + var2) * 0.5F;
         }

         var2 = this.b(var1, var2);
         var2 = this.c(var1, var2);
         float var3 = var2;
         var2 = Math.max(var2 - this.bO(), 0.0F);
         this.m(this.bO() - (var3 - var2));
         if(var2 != 0.0F) {
            this.a(var1.f());
            float var4 = this.bo();
            this.i(this.bo() - var2);
            this.bt().a(var1, var4, var2);
            if(var2 < 3.4028235E37F) {
               this.a(class_nc.x, Math.round(var2 * 10.0F));
            }

         }
      }
   }

   public void a(class_amx var1) {
   }

   public void a(class_aed var1) {
   }

   public void a(class_adz var1) {
   }

   public void a(class_oj var1) {
   }

   public void a(class_tz var1, class_oj var2) {
   }

   public void a(class_op var1) {
   }

   public void a(class_aas var1) {
   }

   public class_oq a(class_pr var1, class_aas var2, class_oo var3) {
      if(this.v()) {
         if(var1 instanceof class_oj) {
            this.a((class_oj)var1);
         }

         return class_oq.b;
      } else {
         class_aas var4 = var2 != null?var2.k():null;
         if(!var1.a(this, var2, var3)) {
            if(var2 != null && var1 instanceof class_qa) {
               if(this.bH.d) {
                  var2 = var4;
               }

               if(var2.a(this, (class_qa)var1, var3)) {
                  if(var2.b <= 0 && !this.bH.d) {
                     this.a((class_oo)var3, (class_aas)null);
                  }

                  return class_oq.a;
               }
            }

            return class_oq.b;
         } else {
            if(var2 != null && var2 == this.bA()) {
               if(var2.b <= 0 && !this.bH.d) {
                  this.a((class_oo)var3, (class_aas)null);
               } else if(var2.b < var4.b && this.bH.d) {
                  var2.b = var4.b;
               }
            }

            return class_oq.a;
         }
      }
   }

   public double am() {
      return -0.35D;
   }

   public void f(class_pr var1) {
      if(var1.aF()) {
         if(!var1.l(this)) {
            float var2 = (float)this.a((class_qk)class_wl.e).e();
            byte var3 = 0;
            float var4 = 0.0F;
            if(var1 instanceof class_qa) {
               var4 = class_adk.a(this.bA(), ((class_qa)var1).bz());
            } else {
               var4 = class_adk.a(this.bA(), class_qf.a);
            }

            int var18 = var3 + class_adk.a((class_qa)this);
            if(this.ay()) {
               ++var18;
            }

            if(var2 > 0.0F || var4 > 0.0F) {
               boolean var5 = this.O > 0.0F && !this.C && !this.k_() && !this.V() && !this.a((class_pk)class_pm.o) && this.m == null && var1 instanceof class_qa;
               if(var5 && var2 > 0.0F) {
                  var2 *= 1.5F;
               }

               var2 += var4;
               boolean var6 = false;
               int var7 = class_adk.b(this);
               if(var1 instanceof class_qa && var7 > 0 && !var1.av()) {
                  var6 = true;
                  var1.f(1);
               }

               double var8 = var1.v;
               double var10 = var1.w;
               double var12 = var1.x;
               boolean var14 = var1.a(class_pc.a(this), var2);
               if(var14) {
                  if(var18 > 0) {
                     var1.g((double)(-class_nu.a(this.y * 3.1415927F / 180.0F) * (float)var18 * 0.5F), 0.1D, (double)(class_nu.b(this.y * 3.1415927F / 180.0F) * (float)var18 * 0.5F));
                     this.v *= 0.6D;
                     this.x *= 0.6D;
                     this.d(false);
                  }

                  if(var1 instanceof class_lh && var1.G) {
                     ((class_lh)var1).a.a((class_ff)(new class_hm(var1)));
                     var1.G = false;
                     var1.v = var8;
                     var1.w = var10;
                     var1.x = var12;
                  }

                  if(var5) {
                     this.b(var1);
                  }

                  if(var4 > 0.0F) {
                     this.c(var1);
                  }

                  if(var2 >= 18.0F) {
                     this.b((class_my)class_mt.F);
                  }

                  this.p(var1);
                  if(var1 instanceof class_qa) {
                     class_adk.a((class_qa)((class_qa)var1), (class_pr)this);
                  }

                  class_adk.b((class_qa)this, (class_pr)var1);
                  class_aas var15 = this.bA();
                  Object var16 = var1;
                  if(var1 instanceof class_up) {
                     class_uo var17 = ((class_up)var1).a;
                     if(var17 instanceof class_qa) {
                        var16 = (class_qa)var17;
                     }
                  }

                  if(var15 != null && var16 instanceof class_qa) {
                     var15.a((class_qa)var16, this);
                     if(var15.b <= 0) {
                        this.a((class_oo)class_oo.a, (class_aas)null);
                     }
                  }

                  if(var1 instanceof class_qa) {
                     this.a(class_nc.w, Math.round(var2 * 10.0F));
                     if(var7 > 0) {
                        var1.f(var7 * 4);
                     }
                  }

                  this.a(0.3F);
               } else if(var6) {
                  var1.N();
               }
            }

         }
      }
   }

   public void b(class_pr var1) {
   }

   public void c(class_pr var1) {
   }

   public void J() {
      super.J();
      this.bq.b(this);
      if(this.br != null) {
         this.br.b(this);
      }

   }

   public boolean aj() {
      return !this.bD && super.aj();
   }

   public GameProfile cf() {
      return this.bO;
   }

   public class_xa.class_a_in_class_xa a(class_cj var1) {
      if(!this.o.D) {
         if(this.bK() || !this.ai()) {
            return class_xa.class_a_in_class_xa.e;
         }

         if(!this.o.t.d()) {
            return class_xa.class_a_in_class_xa.b;
         }

         if(this.o.x()) {
            return class_xa.class_a_in_class_xa.c;
         }

         if(Math.abs(this.s - (double)var1.n()) > 3.0D || Math.abs(this.t - (double)var1.o()) > 2.0D || Math.abs(this.u - (double)var1.p()) > 3.0D) {
            return class_xa.class_a_in_class_xa.d;
         }

         double var2 = 8.0D;
         double var4 = 5.0D;
         List var6 = this.o.a(class_wi.class, new class_awf((double)var1.n() - var2, (double)var1.o() - var4, (double)var1.p() - var2, (double)var1.n() + var2, (double)var1.o() + var4, (double)var1.p() + var2));
         if(!var6.isEmpty()) {
            return class_xa.class_a_in_class_xa.f;
         }
      }

      if(this.aw()) {
         this.a((class_pr)null);
      }

      this.a(0.2F, 0.2F);
      if(this.o.e(var1)) {
         class_cq var7 = (class_cq)this.o.p(var1).b(class_aiv.O);
         float var3 = 0.5F;
         float var8 = 0.5F;
         switch(class_xa.SyntheticClass_1.a[var7.ordinal()]) {
         case 1:
            var8 = 0.9F;
            break;
         case 2:
            var8 = 0.1F;
            break;
         case 3:
            var3 = 0.1F;
            break;
         case 4:
            var3 = 0.9F;
         }

         this.a(var7);
         this.b((double)((float)var1.n() + var3), (double)((float)var1.o() + 0.6875F), (double)((float)var1.p() + var8));
      } else {
         this.b((double)((float)var1.n() + 0.5F), (double)((float)var1.o() + 0.6875F), (double)((float)var1.p() + 0.5F));
      }

      this.bD = true;
      this.d = 0;
      this.bE = var1;
      this.v = this.x = this.w = 0.0D;
      if(!this.o.D) {
         this.o.e();
      }

      return class_xa.class_a_in_class_xa.a;
   }

   private void a(class_cq var1) {
      this.bF = 0.0F;
      this.bG = 0.0F;
      switch(class_xa.SyntheticClass_1.a[var1.ordinal()]) {
      case 1:
         this.bG = -1.8F;
         break;
      case 2:
         this.bG = 1.8F;
         break;
      case 3:
         this.bF = 1.8F;
         break;
      case 4:
         this.bF = -1.8F;
      }

   }

   public void a(boolean var1, boolean var2, boolean var3) {
      this.a(0.6F, 1.8F);
      class_anl var4 = this.o.p(this.bE);
      if(this.bE != null && var4.c() == class_agk.C) {
         this.o.a((class_cj)this.bE, (class_anl)var4.a(class_agh.b, Boolean.valueOf(false)), 4);
         class_cj var5 = class_agh.a((class_aen)this.o, (class_cj)this.bE, 0);
         if(var5 == null) {
            var5 = this.bE.a();
         }

         this.b((double)((float)var5.n() + 0.5F), (double)((float)var5.o() + 0.1F), (double)((float)var5.p() + 0.5F));
      }

      this.bD = false;
      if(!this.o.D && var2) {
         this.o.e();
      }

      this.d = var1?0:100;
      if(var3) {
         this.a(this.bE, false);
      }

   }

   private boolean p() {
      return this.o.p(this.bE).c() == class_agk.C;
   }

   public static class_cj a(class_aen var0, class_cj var1, boolean var2) {
      class_agj var3 = var0.p(var1).c();
      if(var3 != class_agk.C) {
         if(!var2) {
            return null;
         } else {
            boolean var4 = var3.g();
            boolean var5 = var0.p(var1.a()).c().g();
            return var4 && var5?var1:null;
         }
      } else {
         return class_agh.a((class_aen)var0, (class_cj)var1, 0);
      }
   }

   public boolean bK() {
      return this.bD;
   }

   public boolean ch() {
      return this.bD && this.d >= 100;
   }

   public void b(class_eu var1) {
   }

   public class_cj cj() {
      return this.e;
   }

   public boolean ck() {
      return this.f;
   }

   public void a(class_cj var1, boolean var2) {
      if(var1 != null) {
         this.e = var1;
         this.f = var2;
      } else {
         this.e = null;
         this.f = false;
      }

   }

   public void b(class_my var1) {
      this.a(var1, 1);
   }

   public void a(class_my var1, int var2) {
   }

   public void a(class_my var1) {
   }

   public void bG() {
      super.bG();
      this.b(class_nc.u);
      if(this.ay()) {
         this.a(0.8F);
      } else {
         this.a(0.2F);
      }

   }

   public void g(float var1, float var2) {
      double var3 = this.s;
      double var5 = this.t;
      double var7 = this.u;
      if(this.bH.b && this.m == null) {
         double var9 = this.w;
         float var11 = this.aP;
         this.aP = this.bH.a() * (float)(this.ay()?2:1);
         super.g(var1, var2);
         this.w = var9 * 0.6D;
         this.aP = var11;
      } else {
         super.g(var1, var2);
      }

      this.k(this.s - var3, this.t - var5, this.u - var7);
   }

   public float bJ() {
      return (float)this.a((class_qk)class_wl.d).e();
   }

   public void k(double var1, double var3, double var5) {
      if(this.m == null) {
         int var7;
         if(this.a((class_atk)class_atk.h)) {
            var7 = Math.round(class_nu.a(var1 * var1 + var3 * var3 + var5 * var5) * 100.0F);
            if(var7 > 0) {
               this.a(class_nc.p, var7);
               this.a(0.015F * (float)var7 * 0.01F);
            }
         } else if(this.V()) {
            var7 = Math.round(class_nu.a(var1 * var1 + var5 * var5) * 100.0F);
            if(var7 > 0) {
               this.a(class_nc.l, var7);
               this.a(0.015F * (float)var7 * 0.01F);
            }
         } else if(this.k_()) {
            if(var3 > 0.0D) {
               this.a(class_nc.n, (int)Math.round(var3 * 100.0D));
            }
         } else if(this.C) {
            var7 = Math.round(class_nu.a(var1 * var1 + var5 * var5) * 100.0F);
            if(var7 > 0) {
               this.a(class_nc.i, var7);
               if(this.ay()) {
                  this.a(class_nc.k, var7);
                  this.a(0.099999994F * (float)var7 * 0.01F);
               } else {
                  if(this.ax()) {
                     this.a(class_nc.j, var7);
                  }

                  this.a(0.01F * (float)var7 * 0.01F);
               }
            }
         } else {
            var7 = Math.round(class_nu.a(var1 * var1 + var5 * var5) * 100.0F);
            if(var7 > 25) {
               this.a(class_nc.o, var7);
            }
         }

      }
   }

   private void l(double var1, double var3, double var5) {
      if(this.m != null) {
         int var7 = Math.round(class_nu.a(var1 * var1 + var3 * var3 + var5 * var5) * 100.0F);
         if(var7 > 0) {
            if(this.m instanceof class_vn) {
               this.a(class_nc.q, var7);
               if(this.g == null) {
                  this.g = new class_cj(this);
               } else if(this.g.c((double)class_nu.c(this.s), (double)class_nu.c(this.t), (double)class_nu.c(this.u)) >= 1000000.0D) {
                  this.b((class_my)class_mt.q);
               }
            } else if(this.m instanceof class_vk) {
               this.a(class_nc.r, var7);
            } else if(this.m instanceof class_ud) {
               this.a(class_nc.s, var7);
            } else if(this.m instanceof class_tz) {
               this.a(class_nc.t, var7);
            }
         }
      }

   }

   public void e(float var1, float var2) {
      if(!this.bH.c) {
         if(var1 >= 2.0F) {
            this.a(class_nc.m, (int)Math.round((double)var1 * 100.0D));
         }

         super.e(var1, var2);
      }
   }

   protected void X() {
      if(!this.v()) {
         super.X();
      }

   }

   protected String k(int var1) {
      return var1 > 4?"game.player.hurt.fall.big":"game.player.hurt.fall.small";
   }

   public void a(class_qa var1) {
      if(var1 instanceof class_wd) {
         this.b((class_my)class_mt.s);
      }

      class_pt.class_a_in_class_pt var2 = (class_pt.class_a_in_class_pt)class_pt.a.get(Integer.valueOf(class_pt.a(var1)));
      if(var2 != null) {
         this.b(var2.d);
      }

   }

   public void aC() {
      if(!this.bH.b) {
         super.aC();
      }

   }

   public void o(int var1) {
      this.n(var1);
      int var2 = Integer.MAX_VALUE - this.bJ;
      if(var1 > var2) {
         var1 = var2;
      }

      this.bK += (float)var1 / (float)this.cm();

      for(this.bJ += var1; this.bK >= 1.0F; this.bK /= (float)this.cm()) {
         this.bK = (this.bK - 1.0F) * (float)this.cm();
         this.a(1);
      }

   }

   public int cl() {
      return this.h;
   }

   public void b(int var1) {
      this.bI -= var1;
      if(this.bI < 0) {
         this.bI = 0;
         this.bK = 0.0F;
         this.bJ = 0;
      }

      this.h = this.V.nextInt();
   }

   public void a(int var1) {
      this.bI += var1;
      if(this.bI < 0) {
         this.bI = 0;
         this.bK = 0.0F;
         this.bJ = 0;
      }

      if(var1 > 0 && this.bI % 5 == 0 && (float)this.i < (float)this.W - 100.0F) {
         float var2 = this.bI > 30?1.0F:(float)this.bI / 30.0F;
         this.o.a((class_pr)this, "random.levelup", var2 * 0.75F, 1.0F);
         this.i = this.W;
      }

   }

   public int cm() {
      return this.bI >= 30?112 + (this.bI - 30) * 9:(this.bI >= 15?37 + (this.bI - 15) * 5:7 + this.bI * 2);
   }

   public void a(float var1) {
      if(!this.bH.a) {
         if(!this.o.D) {
            this.bs.a(var1);
         }

      }
   }

   public class_xx cn() {
      return this.bs;
   }

   public boolean j(boolean var1) {
      return (var1 || this.bs.c()) && !this.bH.a;
   }

   public boolean co() {
      return this.bo() > 0.0F && this.bo() < this.bv();
   }

   public boolean cp() {
      return this.bH.e;
   }

   public boolean a(class_cj var1, class_cq var2, class_aas var3) {
      if(this.bH.e) {
         return true;
      } else if(var3 == null) {
         return false;
      } else {
         class_cj var4 = var1.a(var2.d());
         class_agj var5 = this.o.p(var4).c();
         return var3.d(var5) || var3.x();
      }
   }

   protected int b(class_xa var1) {
      if(this.o.R().b("keepInventory")) {
         return 0;
      } else {
         int var2 = this.bI * 7;
         return var2 > 100?100:var2;
      }
   }

   protected boolean bc() {
      return true;
   }

   public void a(class_xa var1, boolean var2) {
      if(var2) {
         this.bp.a(var1.bp);
         this.i(var1.bo());
         this.bs = var1.bs;
         this.bI = var1.bI;
         this.bJ = var1.bJ;
         this.bK = var1.bK;
         this.m(var1.cb());
         this.an = var1.an;
         this.ao = var1.ao;
         this.ap = var1.ap;
      } else if(this.o.R().b("keepInventory")) {
         this.bp.a(var1.bp);
         this.bI = var1.bI;
         this.bJ = var1.bJ;
         this.bK = var1.bK;
         this.m(var1.cb());
      }

      this.h = var1.h;
      this.c = var1.c;
      this.H().b(bn, Byte.valueOf(var1.H().a(bn)));
   }

   protected boolean s_() {
      return !this.bH.b;
   }

   public void t() {
   }

   public void a(class_aeq.class_a_in_class_aeq var1) {
   }

   public String e_() {
      return this.bO.getName();
   }

   public class_yu cq() {
      return this.c;
   }

   public class_aas a(class_pw var1) {
      return var1 == class_pw.a?this.bp.h():(var1 == class_pw.b?this.bp.c[0]:(var1.a() == class_pw.class_a_in_class_pw.b?this.bp.b[var1.b()]:null));
   }

   public void a(class_pw var1, class_aas var2) {
      if(var1 == class_pw.a) {
         this.bp.a[this.bp.d] = var2;
      } else if(var1 == class_pw.b) {
         this.bp.c[0] = var2;
      } else if(var1.a() == class_pw.class_a_in_class_pw.b) {
         this.bp.b[var1.b()] = var2;
      }

   }

   public Iterable as() {
      return Lists.newArrayList((Object[])(new class_aas[]{this.bA(), this.bB()}));
   }

   public Iterable at() {
      return Arrays.asList(this.bp.b);
   }

   public abstract boolean v();

   public boolean aN() {
      return !this.bH.b;
   }

   public class_awn cr() {
      return this.o.aa();
   }

   public class_awp bP() {
      return this.cr().h(this.e_());
   }

   public class_eu f_() {
      class_fa var1 = new class_fa(class_awk.a(this.bP(), this.e_()));
      var1.b().a(new class_et(class_et.class_a_in_class_et.d, "/msg " + this.e_() + " "));
      var1.b().a(this.aS());
      var1.b().a(this.e_());
      return var1;
   }

   public float aU() {
      float var1 = 1.62F;
      if(this.bK()) {
         var1 = 0.2F;
      }

      if(this.ax()) {
         var1 -= 0.08F;
      }

      return var1;
   }

   public void m(float var1) {
      if(var1 < 0.0F) {
         var1 = 0.0F;
      }

      this.H().b(a, Float.valueOf(var1));
   }

   public float bO() {
      return this.H().d(a);
   }

   public static UUID a(GameProfile var0) {
      UUID var1 = var0.getId();
      if(var1 == null) {
         var1 = b(var0.getName());
      }

      return var1;
   }

   public static UUID b(String var0) {
      return UUID.nameUUIDFromBytes(("OfflinePlayer:" + var0).getBytes(Charsets.UTF_8));
   }

   public boolean a(class_ot var1) {
      if(var1.a()) {
         return true;
      } else {
         class_aas var2 = this.bA();
         return var2 != null && var2.s()?var2.q().equals(var1.b()):false;
      }
   }

   public boolean u_() {
      return MinecraftServer.N().d[0].R().b("sendCommandFeedback");
   }

   public boolean c(int var1, class_aas var2) {
      if(var1 >= 0 && var1 < this.bp.a.length) {
         this.bp.a(var1, var2);
         return true;
      } else {
         class_pw var3;
         if(var1 == 100 + class_pw.f.b()) {
            var3 = class_pw.f;
         } else if(var1 == 100 + class_pw.e.b()) {
            var3 = class_pw.e;
         } else if(var1 == 100 + class_pw.d.b()) {
            var3 = class_pw.d;
         } else if(var1 == 100 + class_pw.c.b()) {
            var3 = class_pw.c;
         } else {
            var3 = null;
         }

         if(var1 == 98) {
            this.a(class_pw.a, var2);
            return true;
         } else if(var1 == 99) {
            this.a(class_pw.b, var2);
            return true;
         } else if(var3 == null) {
            int var4 = var1 - 200;
            if(var4 >= 0 && var4 < this.c.o_()) {
               this.c.a(var4, var2);
               return true;
            } else {
               return false;
            }
         } else {
            if(var2 != null && var2.b() != null) {
               if(var2.b() instanceof class_za) {
                  if(class_qb.c(var2) != var3) {
                     return false;
                  }
               } else if(var3 != class_pw.f || var2.b() != class_aau.ca && !(var2.b() instanceof class_zg)) {
                  return false;
               }
            }

            this.bp.a(var3.b() + this.bp.a.length, var2);
            return true;
         }
      }
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a = new int[class_cq.values().length];

      static {
         try {
            a[class_cq.d.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            a[class_cq.c.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[class_cq.e.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[class_cq.f.ordinal()] = 4;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }

   public static enum class_a_in_class_xa {
      a,
      b,
      c,
      d,
      e,
      f;
   }

   public static enum class_b_in_class_xa {
      a(0, "options.chat.visibility.full"),
      b(1, "options.chat.visibility.system"),
      c(2, "options.chat.visibility.hidden");

      private static final class_xa.class_b_in_class_xa[] d;
      private final int e;
      private final String f;

      private class_b_in_class_xa(int var3, String var4) {
         this.e = var3;
         this.f = var4;
      }

      static {
         d = new class_xa.class_b_in_class_xa[values().length];
         class_xa.class_b_in_class_xa[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            class_xa.class_b_in_class_xa var3 = var0[var2];
            d[var3.e] = var3;
         }

      }
   }
}
