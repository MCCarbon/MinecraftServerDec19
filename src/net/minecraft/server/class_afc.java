package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_aez;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_aic;
import net.minecraft.server.class_alh;
import net.minecraft.server.class_api;
import net.minecraft.server.class_apw;
import net.minecraft.server.class_aqb;
import net.minecraft.server.class_aqc;
import net.minecraft.server.class_aqe;
import net.minecraft.server.class_aqf;
import net.minecraft.server.class_aql;
import net.minecraft.server.class_aqm;
import net.minecraft.server.class_aqr;
import net.minecraft.server.class_arb;
import net.minecraft.server.class_ard;
import net.minecraft.server.class_are;
import net.minecraft.server.class_arg;
import net.minecraft.server.class_arj;
import net.minecraft.server.class_arp;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_cj;

public class class_afc {
   protected class_aen a;
   protected Random b;
   protected class_cj c;
   protected class_api d;
   protected class_aql e = new class_aqe(4);
   protected class_aql f;
   protected class_aql g;
   protected class_aql h;
   protected class_aql i;
   protected class_aql j;
   protected class_aql k;
   protected class_aql l;
   protected class_aql m;
   protected class_aql n;
   protected class_aql o;
   protected class_aql p;
   protected class_aql q;
   protected class_aql r;
   protected class_aqm s;
   protected class_aql t;
   protected class_aql u;
   protected class_aql v;
   protected class_aql w;
   protected class_aql x;
   protected class_aql y;
   protected int z;
   protected int A;
   protected int B;
   protected int C;
   protected int D;
   protected int E;
   protected int F;
   protected int G;
   protected int H;
   protected int I;
   protected int J;
   protected int K;
   public boolean L;

   public class_afc() {
      this.f = new class_arg(class_agk.m, 7);
      this.g = new class_arg(class_agk.n, 6);
      this.s = new class_aqm(class_agk.N, class_aic.class_a_in_class_aic.a);
      this.t = new class_aqb(class_agk.P);
      this.u = new class_aqb(class_agk.Q);
      this.v = new class_aqr();
      this.w = new class_are();
      this.x = new class_aqc();
      this.y = new class_arp();
      this.B = 2;
      this.C = 1;
      this.H = 1;
      this.I = 3;
      this.J = 1;
      this.L = true;
   }

   public void a(class_aen var1, Random var2, class_aez var3, class_cj var4) {
      if(this.a != null) {
         throw new RuntimeException("Already decorating");
      } else {
         this.a = var1;
         String var5 = var1.Q().B();
         if(var5 != null) {
            this.d = class_api.class_a_in_class_api.a(var5).b();
         } else {
            this.d = class_api.class_a_in_class_api.a("").b();
         }

         this.b = var2;
         this.c = var4;
         this.h = new class_arb(class_agk.d.S(), this.d.I);
         this.i = new class_arb(class_agk.n.S(), this.d.M);
         this.j = new class_arb(class_agk.b.S().set(class_alh.a, class_alh.class_a_in_class_alh.b), this.d.Q);
         this.k = new class_arb(class_agk.b.S().set(class_alh.a, class_alh.class_a_in_class_alh.d), this.d.U);
         this.l = new class_arb(class_agk.b.S().set(class_alh.a, class_alh.class_a_in_class_alh.f), this.d.Y);
         this.m = new class_arb(class_agk.q.S(), this.d.ac);
         this.n = new class_arb(class_agk.p.S(), this.d.ag);
         this.o = new class_arb(class_agk.o.S(), this.d.ak);
         this.p = new class_arb(class_agk.aC.S(), this.d.ao);
         this.q = new class_arb(class_agk.ag.S(), this.d.as);
         this.r = new class_arb(class_agk.x.S(), this.d.aw);
         this.a(var3);
         this.a = null;
         this.b = null;
      }
   }

   protected void a(class_aez var1) {
      this.a();

      int var2;
      int var3;
      int var4;
      for(var2 = 0; var2 < this.I; ++var2) {
         var3 = this.b.nextInt(16) + 8;
         var4 = this.b.nextInt(16) + 8;
         this.f.b(this.a, this.b, this.a.r(this.c.a(var3, 0, var4)));
      }

      for(var2 = 0; var2 < this.J; ++var2) {
         var3 = this.b.nextInt(16) + 8;
         var4 = this.b.nextInt(16) + 8;
         this.e.b(this.a, this.b, this.a.r(this.c.a(var3, 0, var4)));
      }

      for(var2 = 0; var2 < this.H; ++var2) {
         var3 = this.b.nextInt(16) + 8;
         var4 = this.b.nextInt(16) + 8;
         this.g.b(this.a, this.b, this.a.r(this.c.a(var3, 0, var4)));
      }

      var2 = this.A;
      if(this.b.nextInt(10) == 0) {
         ++var2;
      }

      int var5;
      class_cj var7;
      for(var3 = 0; var3 < var2; ++var3) {
         var4 = this.b.nextInt(16) + 8;
         var5 = this.b.nextInt(16) + 8;
         class_apw var6 = var1.a(this.b);
         var6.e();
         var7 = this.a.m(this.c.a(var4, 0, var5));
         if(var6.b(this.a, this.b, var7)) {
            var6.a(this.a, this.b, var7);
         }
      }

      for(var3 = 0; var3 < this.K; ++var3) {
         var4 = this.b.nextInt(16) + 8;
         var5 = this.b.nextInt(16) + 8;
         this.v.b(this.a, this.b, this.a.m(this.c.a(var4, 0, var5)));
      }

      class_cj var8;
      int var11;
      int var12;
      for(var3 = 0; var3 < this.B; ++var3) {
         var4 = this.b.nextInt(16) + 8;
         var5 = this.b.nextInt(16) + 8;
         var11 = this.a.m(this.c.a(var4, 0, var5)).o() + 32;
         if(var11 > 0) {
            var12 = this.b.nextInt(var11);
            var8 = this.c.a(var4, var12, var5);
            class_aic.class_a_in_class_aic var9 = var1.a(this.b, var8);
            class_aic var10 = var9.a().a();
            if(var10.v() != class_atk.a) {
               this.s.a(var10, var9);
               this.s.b(this.a, this.b, var8);
            }
         }
      }

      for(var3 = 0; var3 < this.C; ++var3) {
         var4 = this.b.nextInt(16) + 8;
         var5 = this.b.nextInt(16) + 8;
         var11 = this.a.m(this.c.a(var4, 0, var5)).o() * 2;
         if(var11 > 0) {
            var12 = this.b.nextInt(var11);
            var1.b(this.b).b(this.a, this.b, this.c.a(var4, var12, var5));
         }
      }

      for(var3 = 0; var3 < this.D; ++var3) {
         var4 = this.b.nextInt(16) + 8;
         var5 = this.b.nextInt(16) + 8;
         var11 = this.a.m(this.c.a(var4, 0, var5)).o() * 2;
         if(var11 > 0) {
            var12 = this.b.nextInt(var11);
            (new class_aqf()).b(this.a, this.b, this.c.a(var4, var12, var5));
         }
      }

      for(var3 = 0; var3 < this.z; ++var3) {
         var4 = this.b.nextInt(16) + 8;
         var5 = this.b.nextInt(16) + 8;
         var11 = this.a.m(this.c.a(var4, 0, var5)).o() * 2;
         if(var11 > 0) {
            var12 = this.b.nextInt(var11);

            class_cj var14;
            for(var8 = this.c.a(var4, var12, var5); var8.o() > 0; var8 = var14) {
               var14 = var8.b();
               if(!this.a.d(var14)) {
                  break;
               }
            }

            this.y.b(this.a, this.b, var8);
         }
      }

      for(var3 = 0; var3 < this.E; ++var3) {
         if(this.b.nextInt(4) == 0) {
            var4 = this.b.nextInt(16) + 8;
            var5 = this.b.nextInt(16) + 8;
            class_cj var13 = this.a.m(this.c.a(var4, 0, var5));
            this.t.b(this.a, this.b, var13);
         }

         if(this.b.nextInt(8) == 0) {
            var4 = this.b.nextInt(16) + 8;
            var5 = this.b.nextInt(16) + 8;
            var11 = this.a.m(this.c.a(var4, 0, var5)).o() * 2;
            if(var11 > 0) {
               var12 = this.b.nextInt(var11);
               var8 = this.c.a(var4, var12, var5);
               this.u.b(this.a, this.b, var8);
            }
         }
      }

      if(this.b.nextInt(4) == 0) {
         var3 = this.b.nextInt(16) + 8;
         var4 = this.b.nextInt(16) + 8;
         var5 = this.a.m(this.c.a(var3, 0, var4)).o() * 2;
         if(var5 > 0) {
            var11 = this.b.nextInt(var5);
            this.t.b(this.a, this.b, this.c.a(var3, var11, var4));
         }
      }

      if(this.b.nextInt(8) == 0) {
         var3 = this.b.nextInt(16) + 8;
         var4 = this.b.nextInt(16) + 8;
         var5 = this.a.m(this.c.a(var3, 0, var4)).o() * 2;
         if(var5 > 0) {
            var11 = this.b.nextInt(var5);
            this.u.b(this.a, this.b, this.c.a(var3, var11, var4));
         }
      }

      for(var3 = 0; var3 < this.F; ++var3) {
         var4 = this.b.nextInt(16) + 8;
         var5 = this.b.nextInt(16) + 8;
         var11 = this.a.m(this.c.a(var4, 0, var5)).o() * 2;
         if(var11 > 0) {
            var12 = this.b.nextInt(var11);
            this.w.b(this.a, this.b, this.c.a(var4, var12, var5));
         }
      }

      for(var3 = 0; var3 < 10; ++var3) {
         var4 = this.b.nextInt(16) + 8;
         var5 = this.b.nextInt(16) + 8;
         var11 = this.a.m(this.c.a(var4, 0, var5)).o() * 2;
         if(var11 > 0) {
            var12 = this.b.nextInt(var11);
            this.w.b(this.a, this.b, this.c.a(var4, var12, var5));
         }
      }

      if(this.b.nextInt(32) == 0) {
         var3 = this.b.nextInt(16) + 8;
         var4 = this.b.nextInt(16) + 8;
         var5 = this.a.m(this.c.a(var3, 0, var4)).o() * 2;
         if(var5 > 0) {
            var11 = this.b.nextInt(var5);
            (new class_ard()).b(this.a, this.b, this.c.a(var3, var11, var4));
         }
      }

      for(var3 = 0; var3 < this.G; ++var3) {
         var4 = this.b.nextInt(16) + 8;
         var5 = this.b.nextInt(16) + 8;
         var11 = this.a.m(this.c.a(var4, 0, var5)).o() * 2;
         if(var11 > 0) {
            var12 = this.b.nextInt(var11);
            this.x.b(this.a, this.b, this.c.a(var4, var12, var5));
         }
      }

      if(this.L) {
         for(var3 = 0; var3 < 50; ++var3) {
            var4 = this.b.nextInt(16) + 8;
            var5 = this.b.nextInt(16) + 8;
            var11 = this.b.nextInt(248) + 8;
            if(var11 > 0) {
               var12 = this.b.nextInt(var11);
               var8 = this.c.a(var4, var12, var5);
               (new class_arj(class_agk.i)).b(this.a, this.b, var8);
            }
         }

         for(var3 = 0; var3 < 20; ++var3) {
            var4 = this.b.nextInt(16) + 8;
            var5 = this.b.nextInt(16) + 8;
            var11 = this.b.nextInt(this.b.nextInt(this.b.nextInt(240) + 8) + 8);
            var7 = this.c.a(var4, var11, var5);
            (new class_arj(class_agk.k)).b(this.a, this.b, var7);
         }
      }

   }

   protected void a(int var1, class_aql var2, int var3, int var4) {
      int var5;
      if(var4 < var3) {
         var5 = var3;
         var3 = var4;
         var4 = var5;
      } else if(var4 == var3) {
         if(var3 < 255) {
            ++var4;
         } else {
            --var3;
         }
      }

      for(var5 = 0; var5 < var1; ++var5) {
         class_cj var6 = this.c.a(this.b.nextInt(16), this.b.nextInt(var4 - var3) + var3, this.b.nextInt(16));
         var2.b(this.a, this.b, var6);
      }

   }

   protected void b(int var1, class_aql var2, int var3, int var4) {
      for(int var5 = 0; var5 < var1; ++var5) {
         class_cj var6 = this.c.a(this.b.nextInt(16), this.b.nextInt(var4) + this.b.nextInt(var4) + var3 - var4, this.b.nextInt(16));
         var2.b(this.a, this.b, var6);
      }

   }

   protected void a() {
      this.a(this.d.J, this.h, this.d.K, this.d.L);
      this.a(this.d.N, this.i, this.d.O, this.d.P);
      this.a(this.d.V, this.k, this.d.W, this.d.X);
      this.a(this.d.R, this.j, this.d.S, this.d.T);
      this.a(this.d.Z, this.l, this.d.aa, this.d.ab);
      this.a(this.d.ad, this.m, this.d.ae, this.d.af);
      this.a(this.d.ah, this.n, this.d.ai, this.d.aj);
      this.a(this.d.al, this.o, this.d.am, this.d.an);
      this.a(this.d.ap, this.p, this.d.aq, this.d.ar);
      this.a(this.d.at, this.q, this.d.au, this.d.av);
      this.b(this.d.ax, this.r, this.d.ay, this.d.az);
   }
}
