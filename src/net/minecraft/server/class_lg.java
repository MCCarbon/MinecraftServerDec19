package net.minecraft.server;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_aef;
import net.minecraft.server.class_aeh;
import net.minecraft.server.class_aej;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_aeo;
import net.minecraft.server.class_aeq;
import net.minecraft.server.class_aes;
import net.minecraft.server.class_aeu;
import net.minecraft.server.class_aev;
import net.minecraft.server.class_aex;
import net.minecraft.server.class_aez;
import net.minecraft.server.class_afd;
import net.minecraft.server.Block;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_amg;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_aoh;
import net.minecraft.server.class_aok;
import net.minecraft.server.class_aol;
import net.minecraft.server.class_aop;
import net.minecraft.server.class_aoz;
import net.minecraft.server.class_aqa;
import net.minecraft.server.class_arw;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_avd;
import net.minecraft.server.class_avn;
import net.minecraft.server.class_avo;
import net.minecraft.server.class_avz;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_awh;
import net.minecraft.server.class_awo;
import net.minecraft.server.class_b;
import net.minecraft.server.class_c;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cy;
import net.minecraft.server.class_e;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_fm;
import net.minecraft.server.class_fu;
import net.minecraft.server.class_gj;
import net.minecraft.server.class_gk;
import net.minecraft.server.class_gm;
import net.minecraft.server.class_gr;
import net.minecraft.server.class_kl;
import net.minecraft.server.class_la;
import net.minecraft.server.class_lb;
import net.minecraft.server.class_ld;
import net.minecraft.server.class_lf;
import net.minecraft.server.class_lh;
import net.minecraft.server.class_nv;
import net.minecraft.server.class_nw;
import net.minecraft.server.class_oc;
import net.minecraft.server.class_od;
import net.minecraft.server.class_of;
import net.minecraft.server.class_om;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_qc;
import net.minecraft.server.class_tq;
import net.minecraft.server.class_tr;
import net.minecraft.server.class_tw;
import net.minecraft.server.class_uk;
import net.minecraft.server.class_vi;
import net.minecraft.server.class_wu;
import net.minecraft.server.class_xa;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_lg extends class_aen implements class_of {
   private static final Logger a = LogManager.getLogger();
   private final MinecraftServer I;
   private final class_lb J;
   private final class_ld K;
   private final Set L = Sets.newHashSet();
   private final TreeSet M = new TreeSet();
   private final Map N = Maps.newHashMap();
   public class_lf b;
   public boolean c;
   private boolean O;
   private int P;
   private final class_aev Q;
   private final class_aeu R = new class_aeu();
   protected final class_tq d = new class_tq(this);
   private class_lg.class_a_in_class_lg[] S = new class_lg.class_a_in_class_lg[]{new class_lg.class_a_in_class_lg(null), new class_lg.class_a_in_class_lg(null)};
   private int T;
   private static final List U;
   private List V = Lists.newArrayList();

   public class_lg(MinecraftServer var1, class_avo var2, class_avn var3, int var4, class_nv var5) {
      super(var2, var3, class_aoz.a(var4).d(), var5, false);
      this.I = var1;
      this.J = new class_lb(this);
      this.K = new class_ld(this);
      this.t.a((class_aen)this);
      this.v = this.l();
      this.Q = new class_aev(this);
      this.C();
      this.D();
      this.ag().a(var1.aI());
   }

   public class_aen b() {
      this.z = new class_avz(this.w);
      String var1 = class_tr.a(this.t);
      class_tr var2 = (class_tr)this.z.a(class_tr.class, var1);
      if(var2 == null) {
         this.A = new class_tr(this);
         this.z.a((String)var1, (class_avd)this.A);
      } else {
         this.A = var2;
         this.A.a((class_aen)this);
      }

      this.C = new class_kl(this.I);
      class_awo var3 = (class_awo)this.z.a(class_awo.class, "scoreboard");
      if(var3 == null) {
         var3 = new class_awo();
         this.z.a((String)"scoreboard", (class_avd)var3);
      }

      var3.a(this.C);
      ((class_kl)this.C).a(var3);
      this.ag().c(this.x.C(), this.x.D());
      this.ag().c(this.x.I());
      this.ag().b(this.x.H());
      this.ag().c(this.x.J());
      this.ag().b(this.x.K());
      if(this.x.F() > 0L) {
         this.ag().a(this.x.E(), this.x.G(), this.x.F());
      } else {
         this.ag().a(this.x.E());
      }

      return this;
   }

   public void d() {
      super.d();
      if(this.Q().t() && this.ab() != class_om.d) {
         this.Q().a(class_om.d);
      }

      this.t.k().b();
      if(this.g()) {
         if(this.R().b("doDaylightCycle")) {
            long var1 = this.x.g() + 24000L;
            this.x.c(var1 - var1 % 24000L);
         }

         this.f();
      }

      this.B.a("mobSpawner");
      if(this.R().b("doMobSpawning") && this.x.u() != class_aes.g) {
         this.R.a(this, this.F, this.G, this.x.f() % 400L == 0L);
      }

      this.B.c("chunkSource");
      this.v.d();
      int var3 = this.a(1.0F);
      if(var3 != this.ac()) {
         this.c(var3);
      }

      this.x.b(this.x.f() + 1L);
      if(this.R().b("doDaylightCycle")) {
         this.x.c(this.x.g() + 1L);
      }

      this.B.c("tickPending");
      this.a(false);
      this.B.c("tickBlocks");
      this.i();
      this.B.c("chunkMap");
      this.K.b();
      this.B.c("village");
      this.A.a();
      this.d.a();
      this.B.c("portalForcer");
      this.Q.a(this.L());
      this.B.b();
      this.ak();
   }

   public class_aez.class_c_in_class_aez a(class_qc var1, class_cj var2) {
      List var3 = this.O().a(var1, var2);
      return var3 != null && !var3.isEmpty()?(class_aez.class_c_in_class_aez)class_oc.a(this.s, var3):null;
   }

   public boolean a(class_qc var1, class_aez.class_c_in_class_aez var2, class_cj var3) {
      List var4 = this.O().a(var1, var3);
      return var4 != null && !var4.isEmpty()?var4.contains(var2):false;
   }

   public void e() {
      this.O = false;
      if(!this.j.isEmpty()) {
         int var1 = 0;
         int var2 = 0;
         Iterator var3 = this.j.iterator();

         while(var3.hasNext()) {
            class_xa var4 = (class_xa)var3.next();
            if(var4.v()) {
               ++var1;
            } else if(var4.bK()) {
               ++var2;
            }
         }

         this.O = var2 > 0 && var2 >= this.j.size() - var1;
      }

   }

   protected void f() {
      this.O = false;
      Iterator var1 = this.j.iterator();

      while(var1.hasNext()) {
         class_xa var2 = (class_xa)var1.next();
         if(var2.bK()) {
            var2.a(false, false, true);
         }
      }

      this.c();
   }

   private void c() {
      this.x.g(0);
      this.x.b(false);
      this.x.f(0);
      this.x.a(false);
   }

   public boolean g() {
      if(this.O && !this.D) {
         Iterator var1 = this.j.iterator();

         class_xa var2;
         do {
            if(!var1.hasNext()) {
               return true;
            }

            var2 = (class_xa)var1.next();
         } while(!var2.v() && var2.ch());

         return false;
      } else {
         return false;
      }
   }

   protected void i() {
      super.i();
      if(this.x.u() == class_aes.g) {
         Iterator var20 = this.E.iterator();

         while(var20.hasNext()) {
            class_aeh var21 = (class_aeh)var20.next();
            this.a(var21.a, var21.b).b(false);
         }

      } else {
         int var1 = 0;
         int var2 = 0;

         for(Iterator var3 = this.E.iterator(); var3.hasNext(); this.B.b()) {
            class_aeh var4 = (class_aeh)var3.next();
            int var5 = var4.a * 16;
            int var6 = var4.b * 16;
            this.B.a("getChunk");
            class_aok var7 = this.a(var4.a, var4.b);
            this.a(var5, var6, var7);
            this.B.c("tickChunk");
            var7.b(false);
            this.B.c("thunder");
            int var8;
            class_cj var9;
            if(this.s.nextInt(100000) == 0 && this.T() && this.S()) {
               this.m = this.m * 3 + 1013904223;
               var8 = this.m >> 2;
               var9 = this.a(new class_cj(var5 + (var8 & 15), 0, var6 + (var8 >> 8 & 15)));
               if(this.C(var9)) {
                  this.d(new class_vi(this, (double)var9.n(), (double)var9.o(), (double)var9.p()));
               }
            }

            this.B.c("iceandsnow");
            if(this.s.nextInt(16) == 0) {
               this.m = this.m * 3 + 1013904223;
               var8 = this.m >> 2;
               var9 = this.q(new class_cj(var5 + (var8 & 15), 0, var6 + (var8 >> 8 & 15)));
               class_cj var10 = var9.b();
               if(this.w(var10)) {
                  this.a((class_cj)var10, (IBlockData)class_agk.aI.S());
               }

               if(this.T() && this.f(var9, true)) {
                  this.a((class_cj)var9, (IBlockData)class_agk.aH.S());
               }

               if(this.T() && this.b((class_cj)var10).e()) {
                  this.p(var10).getBlock().k(this, var10);
               }
            }

            this.B.c("tickBlocks");
            var8 = this.R().c("randomTickSpeed");
            if(var8 > 0) {
               class_aol[] var22 = var7.h();
               int var23 = var22.length;

               for(int var11 = 0; var11 < var23; ++var11) {
                  class_aol var12 = var22[var11];
                  if(var12 != null && var12.b()) {
                     for(int var13 = 0; var13 < var8; ++var13) {
                        this.m = this.m * 3 + 1013904223;
                        int var14 = this.m >> 2;
                        int var15 = var14 & 15;
                        int var16 = var14 >> 8 & 15;
                        int var17 = var14 >> 16 & 15;
                        ++var2;
                        IBlockData var18 = var12.a(var15, var17, var16);
                        Block var19 = var18.getBlock();
                        if(var19.A()) {
                           ++var1;
                           var19.a((class_aen)this, new class_cj(var15 + var5, var17 + var12.d(), var16 + var6), (IBlockData)var18, (Random)this.s);
                        }
                     }
                  }
               }
            }
         }

      }
   }

   protected class_cj a(class_cj var1) {
      class_cj var2 = this.q(var1);
      class_awf var3 = (new class_awf(var2, new class_cj(var2.n(), this.V(), var2.p()))).b(3.0D, 3.0D, 3.0D);
      List var4 = this.a(class_qa.class, var3, new Predicate() {
         public boolean a(class_qa var1) {
            return var1 != null && var1.ai() && class_lg.this.i(var1.c());
         }

         // $FF: synthetic method
         public boolean apply(Object var1) {
            return this.a((class_qa)var1);
         }
      });
      return !var4.isEmpty()?((class_qa)var4.get(this.s.nextInt(var4.size()))).c():var2;
   }

   public boolean a(class_cj var1, Block var2) {
      class_aex var3 = new class_aex(var1, var2);
      return this.V.contains(var3);
   }

   public void a(class_cj var1, Block var2, int var3) {
      this.a(var1, var2, var3, 0);
   }

   public void a(class_cj var1, Block var2, int var3, int var4) {
      class_aex var5 = new class_aex(var1, var2);
      byte var6 = 0;
      if(this.e && var2.v() != class_atk.a) {
         if(var2.P()) {
            var6 = 8;
            if(this.a((class_cj)var5.a.a(-var6, -var6, -var6), (class_cj)var5.a.a(var6, var6, var6))) {
               IBlockData var7 = this.p(var5.a);
               if(var7.getBlock().v() != class_atk.a && var7.getBlock() == var5.a()) {
                  var7.getBlock().b((class_aen)this, var5.a, var7, (Random)this.s);
               }
            }

            return;
         }

         var3 = 1;
      }

      if(this.a((class_cj)var1.a(-var6, -var6, -var6), (class_cj)var1.a(var6, var6, var6))) {
         if(var2.v() != class_atk.a) {
            var5.a((long)var3 + this.x.f());
            var5.a(var4);
         }

         if(!this.L.contains(var5)) {
            this.L.add(var5);
            this.M.add(var5);
         }
      }

   }

   public void b(class_cj var1, Block var2, int var3, int var4) {
      class_aex var5 = new class_aex(var1, var2);
      var5.a(var4);
      if(var2.v() != class_atk.a) {
         var5.a((long)var3 + this.x.f());
      }

      if(!this.L.contains(var5)) {
         this.L.add(var5);
         this.M.add(var5);
      }

   }

   public void j() {
      if(this.j.isEmpty()) {
         if(this.P++ >= 300) {
            return;
         }
      } else {
         this.k();
      }

      this.t.r();
      super.j();
   }

   public void k() {
      this.P = 0;
   }

   public boolean a(boolean var1) {
      if(this.x.u() == class_aes.g) {
         return false;
      } else {
         int var2 = this.M.size();
         if(var2 != this.L.size()) {
            throw new IllegalStateException("TickNextTick list out of synch");
         } else {
            if(var2 > 1000) {
               var2 = 1000;
            }

            this.B.a("cleaning");

            class_aex var4;
            for(int var3 = 0; var3 < var2; ++var3) {
               var4 = (class_aex)this.M.first();
               if(!var1 && var4.b > this.x.f()) {
                  break;
               }

               this.M.remove(var4);
               this.L.remove(var4);
               this.V.add(var4);
            }

            this.B.b();
            this.B.a("ticking");
            Iterator var11 = this.V.iterator();

            while(var11.hasNext()) {
               var4 = (class_aex)var11.next();
               var11.remove();
               byte var5 = 0;
               if(this.a((class_cj)var4.a.a(-var5, -var5, -var5), (class_cj)var4.a.a(var5, var5, var5))) {
                  IBlockData var6 = this.p(var4.a);
                  if(var6.getBlock().v() != class_atk.a && Block.a(var6.getBlock(), var4.a())) {
                     try {
                        var6.getBlock().b((class_aen)this, var4.a, var6, (Random)this.s);
                     } catch (Throwable var10) {
                        class_b var8 = class_b.a(var10, "Exception while ticking a block");
                        class_c var9 = var8.a("Block being ticked");
                        class_c.a(var9, var4.a, var6);
                        throw new class_e(var8);
                     }
                  }
               } else {
                  this.a(var4.a, var4.a(), 0);
               }
            }

            this.B.b();
            this.V.clear();
            return !this.M.isEmpty();
         }
      }
   }

   public List a(class_aok var1, boolean var2) {
      class_aeh var3 = var1.j();
      int var4 = (var3.a << 4) - 2;
      int var5 = var4 + 16 + 2;
      int var6 = (var3.b << 4) - 2;
      int var7 = var6 + 16 + 2;
      return this.a(new class_arw(var4, 0, var6, var5, 256, var7), var2);
   }

   public List a(class_arw var1, boolean var2) {
      ArrayList var3 = null;

      for(int var4 = 0; var4 < 2; ++var4) {
         Iterator var5;
         if(var4 == 0) {
            var5 = this.M.iterator();
         } else {
            var5 = this.V.iterator();
         }

         while(var5.hasNext()) {
            class_aex var6 = (class_aex)var5.next();
            class_cj var7 = var6.a;
            if(var7.n() >= var1.a && var7.n() < var1.d && var7.p() >= var1.c && var7.p() < var1.f) {
               if(var2) {
                  this.L.remove(var6);
                  var5.remove();
               }

               if(var3 == null) {
                  var3 = Lists.newArrayList();
               }

               var3.add(var6);
            }
         }
      }

      return var3;
   }

   public void a(class_pr var1, boolean var2) {
      if(!this.ai() && (var1 instanceof class_tw || var1 instanceof class_uk)) {
         var1.J();
      }

      if(!this.ah() && var1 instanceof class_wu) {
         var1.J();
      }

      super.a(var1, var2);
   }

   private boolean ah() {
      return this.I.ah();
   }

   private boolean ai() {
      return this.I.ag();
   }

   protected class_aoh l() {
      class_aop var1 = this.w.a(this.t);
      this.b = new class_lf(this, var1, this.t.c());
      return this.b;
   }

   public List a(int var1, int var2, int var3, int var4, int var5, int var6) {
      ArrayList var7 = Lists.newArrayList();

      for(int var8 = 0; var8 < this.h.size(); ++var8) {
         class_amg var9 = (class_amg)this.h.get(var8);
         class_cj var10 = var9.v();
         if(var10.n() >= var1 && var10.o() >= var2 && var10.p() >= var3 && var10.n() < var4 && var10.o() < var5 && var10.p() < var6) {
            var7.add(var9);
         }
      }

      return var7;
   }

   public boolean a(class_xa var1, class_cj var2) {
      return !this.I.a((class_aen)this, (class_cj)var2, (class_xa)var1) && this.ag().a(var2);
   }

   public void a(class_aeq var1) {
      if(!this.x.w()) {
         try {
            this.b(var1);
            if(this.x.u() == class_aes.g) {
               this.aj();
            }

            super.a(var1);
         } catch (Throwable var6) {
            class_b var3 = class_b.a(var6, "Exception initializing level");

            try {
               this.a((class_b)var3);
            } catch (Throwable var5) {
               ;
            }

            throw new class_e(var3);
         }

         this.x.d(true);
      }

   }

   private void aj() {
      this.x.f(false);
      this.x.c(true);
      this.x.b(false);
      this.x.a(false);
      this.x.i(1000000000);
      this.x.c(6000L);
      this.x.a(class_aeq.class_a_in_class_aeq.e);
      this.x.g(false);
      this.x.a(class_om.a);
      this.x.e(true);
      this.R().a("doDaylightCycle", "false");
   }

   private void b(class_aeq var1) {
      if(!this.t.e()) {
         this.x.a(class_cj.a.b(this.t.i()));
      } else if(this.x.u() == class_aes.g) {
         this.x.a(class_cj.a.a());
      } else {
         this.y = true;
         class_afd var2 = this.t.k();
         List var3 = var2.a();
         Random var4 = new Random(this.K());
         class_cj var5 = var2.a(0, 0, 256, var3, var4);
         int var6 = 0;
         int var7 = this.t.i();
         int var8 = 0;
         if(var5 != null) {
            var6 = var5.n();
            var8 = var5.p();
         } else {
            a.warn("Unable to find spawn biome");
         }

         int var9 = 0;

         while(!this.t.a(var6, var8)) {
            var6 += var4.nextInt(64) - var4.nextInt(64);
            var8 += var4.nextInt(64) - var4.nextInt(64);
            ++var9;
            if(var9 == 1000) {
               break;
            }
         }

         this.x.a(new class_cj(var6, var7, var8));
         this.y = false;
         if(var1.c()) {
            this.m();
         }

      }
   }

   protected void m() {
      class_aqa var1 = new class_aqa(U, 10);

      for(int var2 = 0; var2 < 10; ++var2) {
         int var3 = this.x.c() + this.s.nextInt(6) - this.s.nextInt(6);
         int var4 = this.x.e() + this.s.nextInt(6) - this.s.nextInt(6);
         class_cj var5 = this.r(new class_cj(var3, 0, var4)).a();
         if(var1.b(this, this.s, var5)) {
            break;
         }
      }

   }

   public class_cj n() {
      return this.t.h();
   }

   public void a(boolean var1, class_nw var2) throws class_aeo {
      if(this.v.e()) {
         if(var2 != null) {
            var2.a("Saving level");
         }

         this.a();
         if(var2 != null) {
            var2.c("Saving chunks");
         }

         this.v.a(var1, var2);
         ArrayList var3 = Lists.newArrayList((Iterable)this.b.a());
         Iterator var4 = var3.iterator();

         while(var4.hasNext()) {
            class_aok var5 = (class_aok)var4.next();
            if(var5 != null && !this.K.a(var5.a, var5.b)) {
               this.b.b(var5.a, var5.b);
            }
         }

      }
   }

   public void o() {
      if(this.v.e()) {
         this.v.c();
      }
   }

   protected void a() throws class_aeo {
      this.J();
      class_lg[] var1 = this.I.d;
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         class_lg var4 = var1[var3];
         if(var4 instanceof class_la) {
            ((class_la)var4).c();
         }
      }

      this.x.a(this.ag().h());
      this.x.d(this.ag().f());
      this.x.c(this.ag().g());
      this.x.e(this.ag().m());
      this.x.f(this.ag().n());
      this.x.j(this.ag().q());
      this.x.k(this.ag().p());
      this.x.b(this.ag().j());
      this.x.e(this.ag().i());
      this.w.a(this.x, this.I.ap().t());
      this.z.a();
   }

   public boolean a(class_pr var1) {
      UUID var2 = var1.aM();
      if(this.N.containsKey(var2)) {
         a.warn("Tried to add entity with duplicate UUID " + var2.toString());
         return false;
      } else {
         return super.a(var1);
      }
   }

   public void a(Collection var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         class_pr var3 = (class_pr)var2.next();
         UUID var4 = var3.aM();
         if(this.N.containsKey(var4)) {
            a.warn("Tried to add entity with duplicate UUID " + var4.toString());
         } else {
            this.f.add(var3);
            this.b(var3);
         }
      }

   }

   protected void b(class_pr var1) {
      super.b(var1);
      this.l.a(var1.F(), var1);
      this.N.put(var1.aM(), var1);
      class_pr[] var2 = var1.aD();
      if(var2 != null) {
         for(int var3 = 0; var3 < var2.length; ++var3) {
            this.l.a(var2[var3].F(), var2[var3]);
         }
      }

   }

   protected void c(class_pr var1) {
      super.c(var1);
      this.l.d(var1.F());
      this.N.remove(var1.aM());
      class_pr[] var2 = var1.aD();
      if(var2 != null) {
         for(int var3 = 0; var3 < var2.length; ++var3) {
            this.l.d(var2[var3].F());
         }
      }

   }

   public boolean d(class_pr var1) {
      if(super.d(var1)) {
         this.I.ap().a(var1.s, var1.t, var1.u, 512.0D, this.t.p().a(), new class_fm(var1));
         return true;
      } else {
         return false;
      }
   }

   public void a(class_pr var1, byte var2) {
      this.t().b(var1, new class_gj(var1, var2));
   }

   public class_aej a(class_pr var1, double var2, double var4, double var6, float var8, boolean var9, boolean var10) {
      class_aej var11 = new class_aej(this, var1, var2, var4, var6, var8, var9, var10);
      var11.a();
      var11.a(false);
      if(!var10) {
         var11.d();
      }

      Iterator var12 = this.j.iterator();

      while(var12.hasNext()) {
         class_xa var13 = (class_xa)var12.next();
         if(var13.e(var2, var4, var6) < 4096.0D) {
            ((class_lh)var13).a.a((class_ff)(new class_gk(var2, var4, var6, var8, var11.e(), (class_awh)var11.b().get(var13))));
         }
      }

      return var11;
   }

   public void c(class_cj var1, Block var2, int var3, int var4) {
      class_aef var5 = new class_aef(var1, var2, var3, var4);
      Iterator var6 = this.S[this.T].iterator();

      class_aef var7;
      do {
         if(!var6.hasNext()) {
            this.S[this.T].add(var5);
            return;
         }

         var7 = (class_aef)var6.next();
      } while(!var7.equals(var5));

   }

   private void ak() {
      while(!this.S[this.T].isEmpty()) {
         int var1 = this.T;
         this.T ^= 1;
         Iterator var2 = this.S[var1].iterator();

         while(var2.hasNext()) {
            class_aef var3 = (class_aef)var2.next();
            if(this.a(var3)) {
               this.I.ap().a((double)var3.a().n(), (double)var3.a().o(), (double)var3.a().p(), 64.0D, this.t.p().a(), new class_fu(var3.a(), var3.d(), var3.b(), var3.c()));
            }
         }

         this.S[var1].clear();
      }

   }

   private boolean a(class_aef var1) {
      IBlockData var2 = this.p(var1.a());
      return var2.getBlock() == var1.d()?var2.getBlock().a(this, var1.a(), var2, var1.b(), var1.c()):false;
   }

   public void p() {
      this.w.a();
   }

   protected void q() {
      boolean var1 = this.T();
      super.q();
      if(this.o != this.p) {
         this.I.ap().a((class_ff)(new class_gm(7, this.p)), this.t.p().a());
      }

      if(this.q != this.r) {
         this.I.ap().a((class_ff)(new class_gm(8, this.r)), this.t.p().a());
      }

      if(var1 != this.T()) {
         if(var1) {
            this.I.ap().a((class_ff)(new class_gm(2, 0.0F)));
         } else {
            this.I.ap().a((class_ff)(new class_gm(1, 0.0F)));
         }

         this.I.ap().a((class_ff)(new class_gm(7, this.p)));
         this.I.ap().a((class_ff)(new class_gm(8, this.r)));
      }

   }

   protected int r() {
      return this.I.ap().s();
   }

   public MinecraftServer s() {
      return this.I;
   }

   public class_lb t() {
      return this.J;
   }

   public class_ld u() {
      return this.K;
   }

   public class_aev v() {
      return this.Q;
   }

   public void a(class_cy var1, double var2, double var4, double var6, int var8, double var9, double var11, double var13, double var15, int... var17) {
      this.a(var1, false, var2, var4, var6, var8, var9, var11, var13, var15, var17);
   }

   public void a(class_cy var1, boolean var2, double var3, double var5, double var7, int var9, double var10, double var12, double var14, double var16, int... var18) {
      class_gr var19 = new class_gr(var1, var2, (float)var3, (float)var5, (float)var7, (float)var10, (float)var12, (float)var14, (float)var16, var9, var18);

      for(int var20 = 0; var20 < this.j.size(); ++var20) {
         class_lh var21 = (class_lh)this.j.get(var20);
         class_cj var22 = var21.c();
         double var23 = var22.c(var3, var5, var7);
         if(var23 <= 256.0D || var2 && var23 <= 65536.0D) {
            var21.a.a((class_ff)var19);
         }
      }

   }

   public class_pr a(UUID var1) {
      return (class_pr)this.N.get(var1);
   }

   public ListenableFuture a(Runnable var1) {
      return this.I.a(var1);
   }

   public boolean aJ() {
      return this.I.aJ();
   }

   static {
      U = Lists.newArrayList((Object[])(new class_od[]{new class_od(class_aau.A, 0, 1, 3, 10), new class_od(class_aar.a(class_agk.f), 0, 1, 3, 10), new class_od(class_aar.a(class_agk.r), 0, 1, 3, 10), new class_od(class_aau.v, 0, 1, 1, 3), new class_od(class_aau.r, 0, 1, 1, 5), new class_od(class_aau.u, 0, 1, 1, 3), new class_od(class_aau.q, 0, 1, 1, 5), new class_od(class_aau.e, 0, 2, 3, 5), new class_od(class_aau.R, 0, 2, 3, 3), new class_od(class_aar.a(class_agk.s), 0, 1, 3, 10)}));
   }

   static class class_a_in_class_lg extends ArrayList {
      private class_a_in_class_lg() {
      }

      // $FF: synthetic method
      class_a_in_class_lg(Object var1) {
         this();
      }
   }
}
