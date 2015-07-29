package net.minecraft.server;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Callable;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aeh;
import net.minecraft.server.class_aej;
import net.minecraft.server.class_ael;
import net.minecraft.server.class_aeo;
import net.minecraft.server.class_aep;
import net.minecraft.server.class_aeq;
import net.minecraft.server.class_aer;
import net.minecraft.server.class_aes;
import net.minecraft.server.class_aet;
import net.minecraft.server.class_aez;
import net.minecraft.server.class_afd;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_aio;
import net.minecraft.server.class_aiu;
import net.minecraft.server.class_ajd;
import net.minecraft.server.class_aky;
import net.minecraft.server.class_ald;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_aoe;
import net.minecraft.server.class_aoh;
import net.minecraft.server.class_aok;
import net.minecraft.server.class_aoy;
import net.minecraft.server.class_arw;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_avd;
import net.minecraft.server.class_avn;
import net.minecraft.server.class_avo;
import net.minecraft.server.class_avz;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_awg;
import net.minecraft.server.class_awh;
import net.minecraft.server.class_awn;
import net.minecraft.server.class_b;
import net.minecraft.server.class_c;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_cy;
import net.minecraft.server.class_e;
import net.minecraft.server.class_kn;
import net.minecraft.server.class_no;
import net.minecraft.server.class_nu;
import net.minecraft.server.class_nv;
import net.minecraft.server.class_om;
import net.minecraft.server.class_on;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_pv;
import net.minecraft.server.class_qb;
import net.minecraft.server.class_tr;
import net.minecraft.server.class_xa;

public abstract class class_aen implements class_aer {
   private int a = 63;
   protected boolean e;
   public final List f = Lists.newArrayList();
   protected final List g = Lists.newArrayList();
   public final List h = Lists.newArrayList();
   public final List i = Lists.newArrayList();
   private final List b = Lists.newArrayList();
   private final List c = Lists.newArrayList();
   public final List j = Lists.newArrayList();
   public final List k = Lists.newArrayList();
   protected final class_no l = new class_no();
   private long d = 16777215L;
   private int I;
   protected int m = (new Random()).nextInt();
   protected final int n = 1013904223;
   protected float o;
   protected float p;
   protected float q;
   protected float r;
   private int J;
   public final Random s = new Random();
   public final class_aoy t;
   protected List u = Lists.newArrayList();
   protected class_aoh v;
   protected final class_avo w;
   protected class_avn x;
   protected boolean y;
   protected class_avz z;
   protected class_tr A;
   public final class_nv B;
   private final Calendar K = Calendar.getInstance();
   protected class_awn C = new class_awn();
   public final boolean D;
   protected Set E = Sets.newHashSet();
   private int L;
   protected boolean F;
   protected boolean G;
   private boolean M;
   private final class_aoe N;
   int[] H;

   protected class_aen(class_avo var1, class_avn var2, class_aoy var3, class_nv var4, boolean var5) {
      this.L = this.s.nextInt(12000);
      this.F = true;
      this.G = true;
      this.H = new int['耀'];
      this.w = var1;
      this.B = var4;
      this.x = var2;
      this.t = var3;
      this.D = var5;
      this.N = var3.o();
   }

   public class_aen b() {
      return this;
   }

   public class_aez b(final class_cj var1) {
      if(this.e(var1)) {
         class_aok var2 = this.f(var1);

         try {
            return var2.a(var1, this.t.k());
         } catch (Throwable var6) {
            class_b var4 = class_b.a(var6, "Getting biome");
            class_c var5 = var4.a("Coordinates of biome request");
            var5.a("Location", new Callable() {
               public String a() throws Exception {
                  return class_c.a(var1);
               }

               // $FF: synthetic method
               public Object call() throws Exception {
                  return this.a();
               }
            });
            throw new class_e(var4);
         }
      } else {
         return this.t.k().a(var1, class_aez.q);
      }
   }

   public class_afd w() {
      return this.t.k();
   }

   protected abstract class_aoh l();

   public void a(class_aeq var1) {
      this.x.d(true);
   }

   public class_agj c(class_cj var1) {
      class_cj var2;
      for(var2 = new class_cj(var1.n(), this.G(), var1.p()); !this.d(var2.a()); var2 = var2.a()) {
         ;
      }

      return this.p(var2).c();
   }

   private boolean a(class_cj var1) {
      return var1.n() >= -30000000 && var1.p() >= -30000000 && var1.n() < 30000000 && var1.p() < 30000000 && var1.o() >= 0 && var1.o() < 256;
   }

   public boolean d(class_cj var1) {
      return this.p(var1).c().v() == class_atk.a;
   }

   public boolean e(class_cj var1) {
      return this.a(var1, true);
   }

   public boolean a(class_cj var1, boolean var2) {
      return !this.a(var1)?false:this.a(var1.n() >> 4, var1.p() >> 4, var2);
   }

   public boolean a(class_cj var1, int var2) {
      return this.a(var1, var2, true);
   }

   public boolean a(class_cj var1, int var2, boolean var3) {
      return this.a(var1.n() - var2, var1.o() - var2, var1.p() - var2, var1.n() + var2, var1.o() + var2, var1.p() + var2, var3);
   }

   public boolean a(class_cj var1, class_cj var2) {
      return this.a(var1, var2, true);
   }

   public boolean a(class_cj var1, class_cj var2, boolean var3) {
      return this.a(var1.n(), var1.o(), var1.p(), var2.n(), var2.o(), var2.p(), var3);
   }

   public boolean a(class_arw var1) {
      return this.b(var1, true);
   }

   public boolean b(class_arw var1, boolean var2) {
      return this.a(var1.a, var1.b, var1.c, var1.d, var1.e, var1.f, var2);
   }

   private boolean a(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      if(var5 >= 0 && var2 < 256) {
         var1 >>= 4;
         var3 >>= 4;
         var4 >>= 4;
         var6 >>= 4;

         for(int var8 = var1; var8 <= var4; ++var8) {
            for(int var9 = var3; var9 <= var6; ++var9) {
               if(!this.a(var8, var9, var7)) {
                  return false;
               }
            }
         }

         return true;
      } else {
         return false;
      }
   }

   protected boolean a(int var1, int var2, boolean var3) {
      return this.v.a(var1, var2) && (var3 || !this.v.d(var1, var2).f());
   }

   public class_aok f(class_cj var1) {
      return this.a(var1.n() >> 4, var1.p() >> 4);
   }

   public class_aok a(int var1, int var2) {
      return this.v.d(var1, var2);
   }

   public boolean a(class_cj var1, class_anl var2, int var3) {
      if(!this.a(var1)) {
         return false;
      } else if(!this.D && this.x.u() == class_aes.g) {
         return false;
      } else {
         class_aok var4 = this.f(var1);
         class_agj var5 = var2.c();
         class_anl var6 = var4.a(var1, var2);
         if(var6 == null) {
            return false;
         } else {
            class_agj var7 = var6.c();
            if(var5.r() != var7.r() || var5.t() != var7.t()) {
               this.B.a("checkLight");
               this.x(var1);
               this.B.b();
            }

            if((var3 & 2) != 0 && (!this.D || (var3 & 4) == 0) && var4.i()) {
               this.h(var1);
            }

            if(!this.D && (var3 & 1) != 0) {
               this.b(var1, var6.c());
               if(var5.Q()) {
                  this.e(var1, var5);
               }
            }

            return true;
         }
      }
   }

   public boolean g(class_cj var1) {
      return this.a((class_cj)var1, (class_anl)class_agk.a.S(), 3);
   }

   public boolean b(class_cj var1, boolean var2) {
      class_anl var3 = this.p(var1);
      class_agj var4 = var3.c();
      if(var4.v() == class_atk.a) {
         return false;
      } else {
         this.b(2001, var1, class_agj.f(var3));
         if(var2) {
            var4.b(this, var1, var3, 0);
         }

         return this.a((class_cj)var1, (class_anl)class_agk.a.S(), 3);
      }
   }

   public boolean a(class_cj var1, class_anl var2) {
      return this.a((class_cj)var1, (class_anl)var2, 3);
   }

   public void h(class_cj var1) {
      for(int var2 = 0; var2 < this.u.size(); ++var2) {
         ((class_aep)this.u.get(var2)).a(var1);
      }

   }

   public void b(class_cj var1, class_agj var2) {
      if(this.x.u() != class_aes.g) {
         this.c(var1, var2);
      }

   }

   public void a(int var1, int var2, int var3, int var4) {
      int var5;
      if(var3 > var4) {
         var5 = var4;
         var4 = var3;
         var3 = var5;
      }

      if(!this.t.m()) {
         for(var5 = var3; var5 <= var4; ++var5) {
            this.c(class_aet.a, new class_cj(var1, var5, var2));
         }
      }

      this.b(var1, var3, var2, var1, var4, var2);
   }

   public void b(class_cj var1, class_cj var2) {
      this.b(var1.n(), var1.o(), var1.p(), var2.n(), var2.o(), var2.p());
   }

   public void b(int var1, int var2, int var3, int var4, int var5, int var6) {
      for(int var7 = 0; var7 < this.u.size(); ++var7) {
         ((class_aep)this.u.get(var7)).a(var1, var2, var3, var4, var5, var6);
      }

   }

   public void c(class_cj var1, class_agj var2) {
      this.d(var1.e(), var2);
      this.d(var1.f(), var2);
      this.d(var1.b(), var2);
      this.d(var1.a(), var2);
      this.d(var1.c(), var2);
      this.d(var1.d(), var2);
   }

   public void a(class_cj var1, class_agj var2, class_cq var3) {
      if(var3 != class_cq.e) {
         this.d(var1.e(), var2);
      }

      if(var3 != class_cq.f) {
         this.d(var1.f(), var2);
      }

      if(var3 != class_cq.a) {
         this.d(var1.b(), var2);
      }

      if(var3 != class_cq.b) {
         this.d(var1.a(), var2);
      }

      if(var3 != class_cq.c) {
         this.d(var1.c(), var2);
      }

      if(var3 != class_cq.d) {
         this.d(var1.d(), var2);
      }

   }

   public void d(class_cj var1, final class_agj var2) {
      if(!this.D) {
         class_anl var3 = this.p(var1);

         try {
            var3.c().a(this, var1, var3, var2);
         } catch (Throwable var7) {
            class_b var5 = class_b.a(var7, "Exception while updating neighbours");
            class_c var6 = var5.a("Block being updated");
            var6.a("Source block type", new Callable() {
               public String a() throws Exception {
                  try {
                     return String.format("ID #%d (%s // %s)", new Object[]{Integer.valueOf(class_agj.a(var2)), var2.a(), var2.getClass().getCanonicalName()});
                  } catch (Throwable var2x) {
                     return "ID #" + class_agj.a(var2);
                  }
               }

               // $FF: synthetic method
               public Object call() throws Exception {
                  return this.a();
               }
            });
            class_c.a(var6, var1, var3);
            throw new class_e(var5);
         }
      }
   }

   public boolean a(class_cj var1, class_agj var2) {
      return false;
   }

   public boolean i(class_cj var1) {
      return this.f(var1).d(var1);
   }

   public boolean j(class_cj var1) {
      if(var1.o() >= this.G()) {
         return this.i(var1);
      } else {
         class_cj var2 = new class_cj(var1.n(), this.G(), var1.p());
         if(!this.i(var2)) {
            return false;
         } else {
            for(var2 = var2.b(); var2.o() > var1.o(); var2 = var2.b()) {
               class_agj var3 = this.p(var2).c();
               if(var3.r() > 0 && !var3.v().d()) {
                  return false;
               }
            }

            return true;
         }
      }
   }

   public int k(class_cj var1) {
      if(var1.o() < 0) {
         return 0;
      } else {
         if(var1.o() >= 256) {
            var1 = new class_cj(var1.n(), 255, var1.p());
         }

         return this.f(var1).a((class_cj)var1, 0);
      }
   }

   public int l(class_cj var1) {
      return this.c(var1, true);
   }

   public int c(class_cj var1, boolean var2) {
      if(var1.n() >= -30000000 && var1.p() >= -30000000 && var1.n() < 30000000 && var1.p() < 30000000) {
         if(var2 && this.p(var1).c().u()) {
            int var8 = this.c(var1.a(), false);
            int var4 = this.c(var1.f(), false);
            int var5 = this.c(var1.e(), false);
            int var6 = this.c(var1.d(), false);
            int var7 = this.c(var1.c(), false);
            if(var4 > var8) {
               var8 = var4;
            }

            if(var5 > var8) {
               var8 = var5;
            }

            if(var6 > var8) {
               var8 = var6;
            }

            if(var7 > var8) {
               var8 = var7;
            }

            return var8;
         } else if(var1.o() < 0) {
            return 0;
         } else {
            if(var1.o() >= 256) {
               var1 = new class_cj(var1.n(), 255, var1.p());
            }

            class_aok var3 = this.f(var1);
            return var3.a(var1, this.I);
         }
      } else {
         return 15;
      }
   }

   public class_cj m(class_cj var1) {
      int var2;
      if(var1.n() >= -30000000 && var1.p() >= -30000000 && var1.n() < 30000000 && var1.p() < 30000000) {
         if(this.a(var1.n() >> 4, var1.p() >> 4, true)) {
            var2 = this.a(var1.n() >> 4, var1.p() >> 4).b(var1.n() & 15, var1.p() & 15);
         } else {
            var2 = 0;
         }
      } else {
         var2 = this.G() + 1;
      }

      return new class_cj(var1.n(), var2, var1.p());
   }

   public int b(int var1, int var2) {
      if(var1 >= -30000000 && var2 >= -30000000 && var1 < 30000000 && var2 < 30000000) {
         if(!this.a(var1 >> 4, var2 >> 4, true)) {
            return 0;
         } else {
            class_aok var3 = this.a(var1 >> 4, var2 >> 4);
            return var3.v();
         }
      } else {
         return this.G() + 1;
      }
   }

   public int b(class_aet var1, class_cj var2) {
      if(var2.o() < 0) {
         var2 = new class_cj(var2.n(), 0, var2.p());
      }

      if(!this.a(var2)) {
         return var1.c;
      } else if(!this.e(var2)) {
         return var1.c;
      } else {
         class_aok var3 = this.f(var2);
         return var3.a(var1, var2);
      }
   }

   public void a(class_aet var1, class_cj var2, int var3) {
      if(this.a(var2)) {
         if(this.e(var2)) {
            class_aok var4 = this.f(var2);
            var4.a(var1, var2, var3);
            this.n(var2);
         }
      }
   }

   public void n(class_cj var1) {
      for(int var2 = 0; var2 < this.u.size(); ++var2) {
         ((class_aep)this.u.get(var2)).b(var1);
      }

   }

   public float o(class_cj var1) {
      return this.t.n()[this.l(var1)];
   }

   public class_anl p(class_cj var1) {
      if(!this.a(var1)) {
         return class_agk.a.S();
      } else {
         class_aok var2 = this.f(var1);
         return var2.g(var1);
      }
   }

   public boolean x() {
      return this.I < 4;
   }

   public class_awg a(class_awh var1, class_awh var2) {
      return this.a(var1, var2, false, false, false);
   }

   public class_awg a(class_awh var1, class_awh var2, boolean var3) {
      return this.a(var1, var2, var3, false, false);
   }

   public class_awg a(class_awh var1, class_awh var2, boolean var3, boolean var4, boolean var5) {
      if(!Double.isNaN(var1.a) && !Double.isNaN(var1.b) && !Double.isNaN(var1.c)) {
         if(!Double.isNaN(var2.a) && !Double.isNaN(var2.b) && !Double.isNaN(var2.c)) {
            int var6 = class_nu.c(var2.a);
            int var7 = class_nu.c(var2.b);
            int var8 = class_nu.c(var2.c);
            int var9 = class_nu.c(var1.a);
            int var10 = class_nu.c(var1.b);
            int var11 = class_nu.c(var1.c);
            class_cj var12 = new class_cj(var9, var10, var11);
            class_anl var13 = this.p(var12);
            class_agj var14 = var13.c();
            if((!var4 || var14.a(this, var12, var13) != null) && var14.a(var13, var3)) {
               class_awg var15 = var14.a(this, var12, var1, var2);
               if(var15 != null) {
                  return var15;
               }
            }

            class_awg var40 = null;
            int var41 = 200;

            while(var41-- >= 0) {
               if(Double.isNaN(var1.a) || Double.isNaN(var1.b) || Double.isNaN(var1.c)) {
                  return null;
               }

               if(var9 == var6 && var10 == var7 && var11 == var8) {
                  return var5?var40:null;
               }

               boolean var42 = true;
               boolean var16 = true;
               boolean var17 = true;
               double var18 = 999.0D;
               double var20 = 999.0D;
               double var22 = 999.0D;
               if(var6 > var9) {
                  var18 = (double)var9 + 1.0D;
               } else if(var6 < var9) {
                  var18 = (double)var9 + 0.0D;
               } else {
                  var42 = false;
               }

               if(var7 > var10) {
                  var20 = (double)var10 + 1.0D;
               } else if(var7 < var10) {
                  var20 = (double)var10 + 0.0D;
               } else {
                  var16 = false;
               }

               if(var8 > var11) {
                  var22 = (double)var11 + 1.0D;
               } else if(var8 < var11) {
                  var22 = (double)var11 + 0.0D;
               } else {
                  var17 = false;
               }

               double var24 = 999.0D;
               double var26 = 999.0D;
               double var28 = 999.0D;
               double var30 = var2.a - var1.a;
               double var32 = var2.b - var1.b;
               double var34 = var2.c - var1.c;
               if(var42) {
                  var24 = (var18 - var1.a) / var30;
               }

               if(var16) {
                  var26 = (var20 - var1.b) / var32;
               }

               if(var17) {
                  var28 = (var22 - var1.c) / var34;
               }

               if(var24 == -0.0D) {
                  var24 = -1.0E-4D;
               }

               if(var26 == -0.0D) {
                  var26 = -1.0E-4D;
               }

               if(var28 == -0.0D) {
                  var28 = -1.0E-4D;
               }

               class_cq var36;
               if(var24 < var26 && var24 < var28) {
                  var36 = var6 > var9?class_cq.e:class_cq.f;
                  var1 = new class_awh(var18, var1.b + var32 * var24, var1.c + var34 * var24);
               } else if(var26 < var28) {
                  var36 = var7 > var10?class_cq.a:class_cq.b;
                  var1 = new class_awh(var1.a + var30 * var26, var20, var1.c + var34 * var26);
               } else {
                  var36 = var8 > var11?class_cq.c:class_cq.d;
                  var1 = new class_awh(var1.a + var30 * var28, var1.b + var32 * var28, var22);
               }

               var9 = class_nu.c(var1.a) - (var36 == class_cq.f?1:0);
               var10 = class_nu.c(var1.b) - (var36 == class_cq.b?1:0);
               var11 = class_nu.c(var1.c) - (var36 == class_cq.d?1:0);
               var12 = new class_cj(var9, var10, var11);
               class_anl var37 = this.p(var12);
               class_agj var38 = var37.c();
               if(!var4 || var38.a(this, var12, var37) != null) {
                  if(var38.a(var37, var3)) {
                     class_awg var39 = var38.a(this, var12, var1, var2);
                     if(var39 != null) {
                        return var39;
                     }
                  } else {
                     var40 = new class_awg(class_awg.class_a_in_class_awg.a, var1, var36, var12);
                  }
               }
            }

            return var5?var40:null;
         } else {
            return null;
         }
      } else {
         return null;
      }
   }

   public void a(class_pr var1, String var2, float var3, float var4) {
      for(int var5 = 0; var5 < this.u.size(); ++var5) {
         ((class_aep)this.u.get(var5)).a(var2, var1.s, var1.t, var1.u, var3, var4);
      }

   }

   public void a(class_xa var1, String var2, float var3, float var4) {
      for(int var5 = 0; var5 < this.u.size(); ++var5) {
         ((class_aep)this.u.get(var5)).a(var1, var2, var1.s, var1.t, var1.u, var3, var4);
      }

   }

   public void a(double var1, double var3, double var5, String var7, float var8, float var9) {
      for(int var10 = 0; var10 < this.u.size(); ++var10) {
         ((class_aep)this.u.get(var10)).a(var7, var1, var3, var5, var8, var9);
      }

   }

   public void a(double var1, double var3, double var5, String var7, float var8, float var9, boolean var10) {
   }

   public void a(class_cj var1, String var2) {
      for(int var3 = 0; var3 < this.u.size(); ++var3) {
         ((class_aep)this.u.get(var3)).a(var2, var1);
      }

   }

   public void a(class_cy var1, double var2, double var4, double var6, double var8, double var10, double var12, int... var14) {
      this.a(var1.c(), var1.e(), var2, var4, var6, var8, var10, var12, var14);
   }

   private void a(int var1, boolean var2, double var3, double var5, double var7, double var9, double var11, double var13, int... var15) {
      for(int var16 = 0; var16 < this.u.size(); ++var16) {
         ((class_aep)this.u.get(var16)).a(var1, var2, var3, var5, var7, var9, var11, var13, var15);
      }

   }

   public boolean d(class_pr var1) {
      this.k.add(var1);
      return true;
   }

   public boolean a(class_pr var1) {
      int var2 = class_nu.c(var1.s / 16.0D);
      int var3 = class_nu.c(var1.u / 16.0D);
      boolean var4 = var1.n;
      if(var1 instanceof class_xa) {
         var4 = true;
      }

      if(!var4 && !this.a(var2, var3, true)) {
         return false;
      } else {
         if(var1 instanceof class_xa) {
            class_xa var5 = (class_xa)var1;
            this.j.add(var5);
            this.e();
         }

         this.a(var2, var3).a(var1);
         this.f.add(var1);
         this.b(var1);
         return true;
      }
   }

   protected void b(class_pr var1) {
      for(int var2 = 0; var2 < this.u.size(); ++var2) {
         ((class_aep)this.u.get(var2)).a(var1);
      }

   }

   protected void c(class_pr var1) {
      for(int var2 = 0; var2 < this.u.size(); ++var2) {
         ((class_aep)this.u.get(var2)).b(var1);
      }

   }

   public void e(class_pr var1) {
      if(var1.l != null) {
         var1.l.a((class_pr)null);
      }

      if(var1.m != null) {
         var1.a((class_pr)null);
      }

      var1.J();
      if(var1 instanceof class_xa) {
         this.j.remove(var1);
         this.e();
         this.c(var1);
      }

   }

   public void f(class_pr var1) {
      var1.J();
      if(var1 instanceof class_xa) {
         this.j.remove(var1);
         this.e();
      }

      int var2 = var1.ae;
      int var3 = var1.ag;
      if(var1.ad && this.a(var2, var3, true)) {
         this.a(var2, var3).b(var1);
      }

      this.f.remove(var1);
      this.c(var1);
   }

   public void a(class_aep var1) {
      this.u.add(var1);
   }

   public List a(class_pr var1, class_awf var2) {
      ArrayList var3 = Lists.newArrayList();
      int var4 = class_nu.c(var2.a);
      int var5 = class_nu.c(var2.d + 1.0D);
      int var6 = class_nu.c(var2.b);
      int var7 = class_nu.c(var2.e + 1.0D);
      int var8 = class_nu.c(var2.c);
      int var9 = class_nu.c(var2.f + 1.0D);
      class_aoe var10 = this.ag();
      boolean var11 = var1.aV();
      boolean var12 = this.a(var10, var1);
      class_anl var13 = class_agk.b.S();
      class_cj.class_a_in_class_cj var14 = new class_cj.class_a_in_class_cj();

      for(int var15 = var4; var15 < var5; ++var15) {
         for(int var16 = var8; var16 < var9; ++var16) {
            if(this.e((class_cj)var14.c(var15, 64, var16))) {
               for(int var17 = var6 - 1; var17 < var7; ++var17) {
                  var14.c(var15, var17, var16);
                  if(var11 && var12) {
                     var1.h(false);
                  } else if(!var11 && !var12) {
                     var1.h(true);
                  }

                  class_anl var18 = var13;
                  if(var10.a((class_cj)var14) || !var12) {
                     var18 = this.p(var14);
                  }

                  var18.c().a(this, (class_cj)var14, (class_anl)var18, (class_awf)var2, (List)var3, (class_pr)var1);
               }
            }
         }
      }

      double var21 = 0.25D;
      List var22 = this.b(var1, var2.b(var21, var21, var21));

      for(int var23 = 0; var23 < var22.size(); ++var23) {
         class_pr var19 = (class_pr)var22.get(var23);
         if(var1.l != var19 && var1.m != var19) {
            class_awf var20 = var19.S();
            if(var20 != null && var20.b(var2)) {
               var3.add(var20);
            }

            var20 = var1.j(var19);
            if(var20 != null && var20.b(var2)) {
               var3.add(var20);
            }
         }
      }

      return var3;
   }

   public boolean a(class_aoe var1, class_pr var2) {
      double var3 = var1.b();
      double var5 = var1.c();
      double var7 = var1.d();
      double var9 = var1.e();
      if(var2.aV()) {
         ++var3;
         ++var5;
         --var7;
         --var9;
      } else {
         --var3;
         --var5;
         ++var7;
         ++var9;
      }

      return var2.s > var3 && var2.s < var7 && var2.u > var5 && var2.u < var9;
   }

   public List a(class_awf var1) {
      ArrayList var2 = Lists.newArrayList();
      int var3 = class_nu.c(var1.a);
      int var4 = class_nu.c(var1.d + 1.0D);
      int var5 = class_nu.c(var1.b);
      int var6 = class_nu.c(var1.e + 1.0D);
      int var7 = class_nu.c(var1.c);
      int var8 = class_nu.c(var1.f + 1.0D);
      class_cj.class_a_in_class_cj var9 = new class_cj.class_a_in_class_cj();

      for(int var10 = var3; var10 < var4; ++var10) {
         for(int var11 = var7; var11 < var8; ++var11) {
            if(this.e((class_cj)var9.c(var10, 64, var11))) {
               for(int var12 = var5 - 1; var12 < var6; ++var12) {
                  var9.c(var10, var12, var11);
                  class_anl var13;
                  if(var10 >= -30000000 && var10 < 30000000 && var11 >= -30000000 && var11 < 30000000) {
                     var13 = this.p(var9);
                  } else {
                     var13 = class_agk.h.S();
                  }

                  var13.c().a(this, (class_cj)var9, (class_anl)var13, (class_awf)var1, (List)var2, (class_pr)null);
               }
            }
         }
      }

      return var2;
   }

   public int a(float var1) {
      float var2 = this.c(var1);
      float var3 = 1.0F - (class_nu.b(var2 * 3.1415927F * 2.0F) * 2.0F + 0.5F);
      var3 = class_nu.a(var3, 0.0F, 1.0F);
      var3 = 1.0F - var3;
      var3 = (float)((double)var3 * (1.0D - (double)(this.j(var1) * 5.0F) / 16.0D));
      var3 = (float)((double)var3 * (1.0D - (double)(this.h(var1) * 5.0F) / 16.0D));
      var3 = 1.0F - var3;
      return (int)(var3 * 11.0F);
   }

   public float c(float var1) {
      return this.t.a(this.x.g(), var1);
   }

   public float z() {
      return class_aoy.a[this.t.a(this.x.g())];
   }

   public float d(float var1) {
      float var2 = this.c(var1);
      return var2 * 3.1415927F * 2.0F;
   }

   public class_cj q(class_cj var1) {
      return this.f(var1).h(var1);
   }

   public class_cj r(class_cj var1) {
      class_aok var2 = this.f(var1);

      class_cj var3;
      class_cj var4;
      for(var3 = new class_cj(var1.n(), var2.g() + 16, var1.p()); var3.o() >= 0; var3 = var4) {
         var4 = var3.b();
         class_atk var5 = var2.a(var4).v();
         if(var5.c() && var5 != class_atk.j) {
            break;
         }
      }

      return var3;
   }

   public void a(class_cj var1, class_agj var2, int var3) {
   }

   public void a(class_cj var1, class_agj var2, int var3, int var4) {
   }

   public void b(class_cj var1, class_agj var2, int var3, int var4) {
   }

   public void j() {
      this.B.a("entities");
      this.B.a("global");

      int var1;
      class_pr var2;
      class_b var4;
      class_c var5;
      for(var1 = 0; var1 < this.k.size(); ++var1) {
         var2 = (class_pr)this.k.get(var1);

         try {
            ++var2.W;
            var2.t_();
         } catch (Throwable var9) {
            var4 = class_b.a(var9, "Ticking entity");
            var5 = var4.a("Entity being ticked");
            if(var2 == null) {
               var5.a((String)"Entity", (Object)"~~NULL~~");
            } else {
               var2.a(var5);
            }

            throw new class_e(var4);
         }

         if(var2.I) {
            this.k.remove(var1--);
         }
      }

      this.B.c("remove");
      this.f.removeAll(this.g);

      int var3;
      int var14;
      for(var1 = 0; var1 < this.g.size(); ++var1) {
         var2 = (class_pr)this.g.get(var1);
         var3 = var2.ae;
         var14 = var2.ag;
         if(var2.ad && this.a(var3, var14, true)) {
            this.a(var3, var14).b(var2);
         }
      }

      for(var1 = 0; var1 < this.g.size(); ++var1) {
         this.c((class_pr)this.g.get(var1));
      }

      this.g.clear();
      this.B.c("regular");

      for(var1 = 0; var1 < this.f.size(); ++var1) {
         var2 = (class_pr)this.f.get(var1);
         if(var2.m != null) {
            if(!var2.m.I && var2.m.l == var2) {
               continue;
            }

            var2.m.l = null;
            var2.m = null;
         }

         this.B.a("tick");
         if(!var2.I) {
            try {
               this.g(var2);
            } catch (Throwable var8) {
               var4 = class_b.a(var8, "Ticking entity");
               var5 = var4.a("Entity being ticked");
               var2.a(var5);
               throw new class_e(var4);
            }
         }

         this.B.b();
         this.B.a("remove");
         if(var2.I) {
            var3 = var2.ae;
            var14 = var2.ag;
            if(var2.ad && this.a(var3, var14, true)) {
               this.a(var3, var14).b(var2);
            }

            this.f.remove(var1--);
            this.c(var2);
         }

         this.B.b();
      }

      this.B.c("blockEntities");
      this.M = true;
      Iterator var15 = this.i.iterator();

      while(var15.hasNext()) {
         class_amg var10 = (class_amg)var15.next();
         if(!var10.x() && var10.t()) {
            class_cj var12 = var10.v();
            if(this.e(var12) && this.N.a(var12)) {
               try {
                  ((class_kn)var10).c();
               } catch (Throwable var7) {
                  class_b var16 = class_b.a(var7, "Ticking block entity");
                  class_c var6 = var16.a("Block entity being ticked");
                  var10.a(var6);
                  throw new class_e(var16);
               }
            }
         }

         if(var10.x()) {
            var15.remove();
            this.h.remove(var10);
            if(this.e(var10.v())) {
               this.f(var10.v()).e(var10.v());
            }
         }
      }

      this.M = false;
      if(!this.c.isEmpty()) {
         this.i.removeAll(this.c);
         this.h.removeAll(this.c);
         this.c.clear();
      }

      this.B.c("pendingBlockEntities");
      if(!this.b.isEmpty()) {
         for(int var11 = 0; var11 < this.b.size(); ++var11) {
            class_amg var13 = (class_amg)this.b.get(var11);
            if(!var13.x()) {
               if(!this.h.contains(var13)) {
                  this.a(var13);
               }

               if(this.e(var13.v())) {
                  this.f(var13.v()).a(var13.v(), var13);
               }

               this.h(var13.v());
            }
         }

         this.b.clear();
      }

      this.B.b();
      this.B.b();
   }

   public boolean a(class_amg var1) {
      boolean var2 = this.h.add(var1);
      if(var2 && var1 instanceof class_kn) {
         this.i.add(var1);
      }

      return var2;
   }

   public void b(Collection var1) {
      if(this.M) {
         this.b.addAll(var1);
      } else {
         Iterator var2 = var1.iterator();

         while(var2.hasNext()) {
            class_amg var3 = (class_amg)var2.next();
            this.h.add(var3);
            if(var3 instanceof class_kn) {
               this.i.add(var3);
            }
         }
      }

   }

   public void g(class_pr var1) {
      this.a(var1, true);
   }

   public void a(class_pr var1, boolean var2) {
      int var3 = class_nu.c(var1.s);
      int var4 = class_nu.c(var1.u);
      byte var5 = 32;
      if(!var2 || this.a(var3 - var5, 0, var4 - var5, var3 + var5, 0, var4 + var5, true)) {
         var1.P = var1.s;
         var1.Q = var1.t;
         var1.R = var1.u;
         var1.A = var1.y;
         var1.B = var1.z;
         if(var2 && var1.ad) {
            ++var1.W;
            if(var1.m != null) {
               var1.ak();
            } else {
               var1.t_();
            }
         }

         this.B.a("chunkCheck");
         if(Double.isNaN(var1.s) || Double.isInfinite(var1.s)) {
            var1.s = var1.P;
         }

         if(Double.isNaN(var1.t) || Double.isInfinite(var1.t)) {
            var1.t = var1.Q;
         }

         if(Double.isNaN(var1.u) || Double.isInfinite(var1.u)) {
            var1.u = var1.R;
         }

         if(Double.isNaN((double)var1.z) || Double.isInfinite((double)var1.z)) {
            var1.z = var1.B;
         }

         if(Double.isNaN((double)var1.y) || Double.isInfinite((double)var1.y)) {
            var1.y = var1.A;
         }

         int var6 = class_nu.c(var1.s / 16.0D);
         int var7 = class_nu.c(var1.t / 16.0D);
         int var8 = class_nu.c(var1.u / 16.0D);
         if(!var1.ad || var1.ae != var6 || var1.af != var7 || var1.ag != var8) {
            if(var1.ad && this.a(var1.ae, var1.ag, true)) {
               this.a(var1.ae, var1.ag).a(var1, var1.af);
            }

            if(this.a(var6, var8, true)) {
               var1.ad = true;
               this.a(var6, var8).a(var1);
            } else {
               var1.ad = false;
            }
         }

         this.B.b();
         if(var2 && var1.ad && var1.l != null) {
            if(!var1.l.I && var1.l.m == var1) {
               this.g(var1.l);
            } else {
               var1.l.m = null;
               var1.l = null;
            }
         }

      }
   }

   public boolean b(class_awf var1) {
      return this.a((class_awf)var1, (class_pr)null);
   }

   public boolean a(class_awf var1, class_pr var2) {
      List var3 = this.b((class_pr)null, (class_awf)var1);

      for(int var4 = 0; var4 < var3.size(); ++var4) {
         class_pr var5 = (class_pr)var3.get(var4);
         if(!var5.I && var5.k && var5 != var2 && (var2 == null || var2.m != var5 && var2.l != var5)) {
            return false;
         }
      }

      return true;
   }

   public boolean c(class_awf var1) {
      int var2 = class_nu.c(var1.a);
      int var3 = class_nu.c(var1.d);
      int var4 = class_nu.c(var1.b);
      int var5 = class_nu.c(var1.e);
      int var6 = class_nu.c(var1.c);
      int var7 = class_nu.c(var1.f);
      class_cj.class_a_in_class_cj var8 = new class_cj.class_a_in_class_cj();

      for(int var9 = var2; var9 <= var3; ++var9) {
         for(int var10 = var4; var10 <= var5; ++var10) {
            for(int var11 = var6; var11 <= var7; ++var11) {
               class_agj var12 = this.p(var8.c(var9, var10, var11)).c();
               if(var12.v() != class_atk.a) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   public boolean d(class_awf var1) {
      int var2 = class_nu.c(var1.a);
      int var3 = class_nu.c(var1.d);
      int var4 = class_nu.c(var1.b);
      int var5 = class_nu.c(var1.e);
      int var6 = class_nu.c(var1.c);
      int var7 = class_nu.c(var1.f);
      class_cj.class_a_in_class_cj var8 = new class_cj.class_a_in_class_cj();

      for(int var9 = var2; var9 <= var3; ++var9) {
         for(int var10 = var4; var10 <= var5; ++var10) {
            for(int var11 = var6; var11 <= var7; ++var11) {
               class_agj var12 = this.p(var8.c(var9, var10, var11)).c();
               if(var12.v().d()) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   public boolean e(class_awf var1) {
      int var2 = class_nu.c(var1.a);
      int var3 = class_nu.c(var1.d + 1.0D);
      int var4 = class_nu.c(var1.b);
      int var5 = class_nu.c(var1.e + 1.0D);
      int var6 = class_nu.c(var1.c);
      int var7 = class_nu.c(var1.f + 1.0D);
      if(this.a(var2, var4, var6, var3, var5, var7, true)) {
         class_cj.class_a_in_class_cj var8 = new class_cj.class_a_in_class_cj();

         for(int var9 = var2; var9 < var3; ++var9) {
            for(int var10 = var4; var10 < var5; ++var10) {
               for(int var11 = var6; var11 < var7; ++var11) {
                  class_agj var12 = this.p(var8.c(var9, var10, var11)).c();
                  if(var12 == class_agk.ab || var12 == class_agk.k || var12 == class_agk.l) {
                     return true;
                  }
               }
            }
         }
      }

      return false;
   }

   public boolean a(class_awf var1, class_atk var2, class_pr var3) {
      int var4 = class_nu.c(var1.a);
      int var5 = class_nu.c(var1.d + 1.0D);
      int var6 = class_nu.c(var1.b);
      int var7 = class_nu.c(var1.e + 1.0D);
      int var8 = class_nu.c(var1.c);
      int var9 = class_nu.c(var1.f + 1.0D);
      if(!this.a(var4, var6, var8, var5, var7, var9, true)) {
         return false;
      } else {
         boolean var10 = false;
         class_awh var11 = new class_awh(0.0D, 0.0D, 0.0D);
         class_cj.class_a_in_class_cj var12 = new class_cj.class_a_in_class_cj();

         for(int var13 = var4; var13 < var5; ++var13) {
            for(int var14 = var6; var14 < var7; ++var14) {
               for(int var15 = var8; var15 < var9; ++var15) {
                  var12.c(var13, var14, var15);
                  class_anl var16 = this.p(var12);
                  class_agj var17 = var16.c();
                  if(var17.v() == var2) {
                     double var18 = (double)((float)(var14 + 1) - class_ajd.b(((Integer)var16.b(class_ajd.b)).intValue()));
                     if((double)var7 >= var18) {
                        var10 = true;
                        var11 = var17.a((class_aen)this, var12, (class_pr)var3, (class_awh)var11);
                     }
                  }
               }
            }
         }

         if(var11.b() > 0.0D && var3.aN()) {
            var11 = var11.a();
            double var20 = 0.014D;
            var3.v += var11.a * var20;
            var3.w += var11.b * var20;
            var3.x += var11.c * var20;
         }

         return var10;
      }
   }

   public boolean a(class_awf var1, class_atk var2) {
      int var3 = class_nu.c(var1.a);
      int var4 = class_nu.c(var1.d + 1.0D);
      int var5 = class_nu.c(var1.b);
      int var6 = class_nu.c(var1.e + 1.0D);
      int var7 = class_nu.c(var1.c);
      int var8 = class_nu.c(var1.f + 1.0D);
      class_cj.class_a_in_class_cj var9 = new class_cj.class_a_in_class_cj();

      for(int var10 = var3; var10 < var4; ++var10) {
         for(int var11 = var5; var11 < var6; ++var11) {
            for(int var12 = var7; var12 < var8; ++var12) {
               if(this.p(var9.c(var10, var11, var12)).c().v() == var2) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   public boolean b(class_awf var1, class_atk var2) {
      int var3 = class_nu.c(var1.a);
      int var4 = class_nu.c(var1.d + 1.0D);
      int var5 = class_nu.c(var1.b);
      int var6 = class_nu.c(var1.e + 1.0D);
      int var7 = class_nu.c(var1.c);
      int var8 = class_nu.c(var1.f + 1.0D);
      class_cj.class_a_in_class_cj var9 = new class_cj.class_a_in_class_cj();

      for(int var10 = var3; var10 < var4; ++var10) {
         for(int var11 = var5; var11 < var6; ++var11) {
            for(int var12 = var7; var12 < var8; ++var12) {
               class_anl var13 = this.p(var9.c(var10, var11, var12));
               class_agj var14 = var13.c();
               if(var14.v() == var2) {
                  int var15 = ((Integer)var13.b(class_ajd.b)).intValue();
                  double var16 = (double)(var11 + 1);
                  if(var15 < 8) {
                     var16 = (double)(var11 + 1) - (double)var15 / 8.0D;
                  }

                  if(var16 >= var1.b) {
                     return true;
                  }
               }
            }
         }
      }

      return false;
   }

   public class_aej a(class_pr var1, double var2, double var4, double var6, float var8, boolean var9) {
      return this.a(var1, var2, var4, var6, var8, false, var9);
   }

   public class_aej a(class_pr var1, double var2, double var4, double var6, float var8, boolean var9, boolean var10) {
      class_aej var11 = new class_aej(this, var1, var2, var4, var6, var8, var9, var10);
      var11.a();
      var11.a(true);
      return var11;
   }

   public float a(class_awh var1, class_awf var2) {
      double var3 = 1.0D / ((var2.d - var2.a) * 2.0D + 1.0D);
      double var5 = 1.0D / ((var2.e - var2.b) * 2.0D + 1.0D);
      double var7 = 1.0D / ((var2.f - var2.c) * 2.0D + 1.0D);
      double var9 = (1.0D - Math.floor(1.0D / var3) * var3) / 2.0D;
      double var11 = (1.0D - Math.floor(1.0D / var7) * var7) / 2.0D;
      if(var3 >= 0.0D && var5 >= 0.0D && var7 >= 0.0D) {
         int var13 = 0;
         int var14 = 0;

         for(float var15 = 0.0F; var15 <= 1.0F; var15 = (float)((double)var15 + var3)) {
            for(float var16 = 0.0F; var16 <= 1.0F; var16 = (float)((double)var16 + var5)) {
               for(float var17 = 0.0F; var17 <= 1.0F; var17 = (float)((double)var17 + var7)) {
                  double var18 = var2.a + (var2.d - var2.a) * (double)var15;
                  double var20 = var2.b + (var2.e - var2.b) * (double)var16;
                  double var22 = var2.c + (var2.f - var2.c) * (double)var17;
                  if(this.a(new class_awh(var18 + var9, var20, var22 + var11), var1) == null) {
                     ++var13;
                  }

                  ++var14;
               }
            }
         }

         return (float)var13 / (float)var14;
      } else {
         return 0.0F;
      }
   }

   public boolean a(class_xa var1, class_cj var2, class_cq var3) {
      var2 = var2.a(var3);
      if(this.p(var2).c() == class_agk.ab) {
         this.a(var1, 1004, var2, 0);
         this.g(var2);
         return true;
      } else {
         return false;
      }
   }

   public class_amg s(class_cj var1) {
      if(!this.a(var1)) {
         return null;
      } else {
         class_amg var2 = null;
         int var3;
         class_amg var4;
         if(this.M) {
            for(var3 = 0; var3 < this.b.size(); ++var3) {
               var4 = (class_amg)this.b.get(var3);
               if(!var4.x() && var4.v().equals(var1)) {
                  var2 = var4;
                  break;
               }
            }
         }

         if(var2 == null) {
            var2 = this.f(var1).a(var1, class_aok.class_a_in_class_aok.a);
         }

         if(var2 == null) {
            for(var3 = 0; var3 < this.b.size(); ++var3) {
               var4 = (class_amg)this.b.get(var3);
               if(!var4.x() && var4.v().equals(var1)) {
                  var2 = var4;
                  break;
               }
            }
         }

         return var2;
      }
   }

   public void a(class_cj var1, class_amg var2) {
      if(var2 != null && !var2.x()) {
         if(this.M) {
            var2.a(var1);
            Iterator var3 = this.b.iterator();

            while(var3.hasNext()) {
               class_amg var4 = (class_amg)var3.next();
               if(var4.v().equals(var1)) {
                  var4.y();
                  var3.remove();
               }
            }

            this.b.add(var2);
         } else {
            this.a(var2);
            this.f(var1).a(var1, var2);
         }
      }

   }

   public void t(class_cj var1) {
      class_amg var2 = this.s(var1);
      if(var2 != null && this.M) {
         var2.y();
         this.b.remove(var2);
      } else {
         if(var2 != null) {
            this.b.remove(var2);
            this.h.remove(var2);
            this.i.remove(var2);
         }

         this.f(var1).e(var1);
      }

   }

   public void b(class_amg var1) {
      this.c.add(var1);
   }

   public boolean u(class_cj var1) {
      class_anl var2 = this.p(var1);
      class_awf var3 = var2.c().a(this, var1, var2);
      return var3 != null && var3.a() >= 1.0D;
   }

   public static boolean a(class_aer var0, class_cj var1) {
      class_anl var2 = var0.p(var1);
      class_agj var3 = var2.c();
      return var3.v().k() && var3.d()?true:(var3 instanceof class_ald?var2.b(class_ald.b) == class_ald.class_a_in_class_ald.a:(var3 instanceof class_aio?var2.b(class_aio.a) == class_aio.class_a_in_class_aio.a:(var3 instanceof class_aiu?true:(var3 instanceof class_aky?((Integer)var2.b(class_aky.a)).intValue() == 7:false))));
   }

   public boolean d(class_cj var1, boolean var2) {
      if(!this.a(var1)) {
         return var2;
      } else {
         class_aok var3 = this.v.a(var1);
         if(var3.f()) {
            return var2;
         } else {
            class_agj var4 = this.p(var1).c();
            return var4.v().k() && var4.d();
         }
      }
   }

   public void C() {
      int var1 = this.a(1.0F);
      if(var1 != this.I) {
         this.I = var1;
      }

   }

   public void a(boolean var1, boolean var2) {
      this.F = var1;
      this.G = var2;
   }

   public void d() {
      this.q();
   }

   protected void D() {
      if(this.x.p()) {
         this.p = 1.0F;
         if(this.x.n()) {
            this.r = 1.0F;
         }
      }

   }

   protected void q() {
      if(!this.t.m()) {
         if(!this.D) {
            int var1 = this.x.A();
            if(var1 > 0) {
               --var1;
               this.x.i(var1);
               this.x.f(this.x.n()?1:2);
               this.x.g(this.x.p()?1:2);
            }

            int var2 = this.x.o();
            if(var2 <= 0) {
               if(this.x.n()) {
                  this.x.f(this.s.nextInt(12000) + 3600);
               } else {
                  this.x.f(this.s.nextInt(168000) + 12000);
               }
            } else {
               --var2;
               this.x.f(var2);
               if(var2 <= 0) {
                  this.x.a(!this.x.n());
               }
            }

            this.q = this.r;
            if(this.x.n()) {
               this.r = (float)((double)this.r + 0.01D);
            } else {
               this.r = (float)((double)this.r - 0.01D);
            }

            this.r = class_nu.a(this.r, 0.0F, 1.0F);
            int var3 = this.x.q();
            if(var3 <= 0) {
               if(this.x.p()) {
                  this.x.g(this.s.nextInt(12000) + 12000);
               } else {
                  this.x.g(this.s.nextInt(168000) + 12000);
               }
            } else {
               --var3;
               this.x.g(var3);
               if(var3 <= 0) {
                  this.x.b(!this.x.p());
               }
            }

            this.o = this.p;
            if(this.x.p()) {
               this.p = (float)((double)this.p + 0.01D);
            } else {
               this.p = (float)((double)this.p - 0.01D);
            }

            this.p = class_nu.a(this.p, 0.0F, 1.0F);
         }
      }
   }

   protected void E() {
      this.E.clear();
      this.B.a("buildList");

      int var1;
      class_xa var2;
      int var3;
      int var4;
      int var5;
      for(var1 = 0; var1 < this.j.size(); ++var1) {
         var2 = (class_xa)this.j.get(var1);
         var3 = class_nu.c(var2.s / 16.0D);
         var4 = class_nu.c(var2.u / 16.0D);
         var5 = this.r();

         for(int var6 = -var5; var6 <= var5; ++var6) {
            for(int var7 = -var5; var7 <= var5; ++var7) {
               this.E.add(new class_aeh(var6 + var3, var7 + var4));
            }
         }
      }

      this.B.b();
      if(this.L > 0) {
         --this.L;
      }

      this.B.a("playerCheckLight");
      if(!this.j.isEmpty()) {
         var1 = this.s.nextInt(this.j.size());
         var2 = (class_xa)this.j.get(var1);
         var3 = class_nu.c(var2.s) + this.s.nextInt(11) - 5;
         var4 = class_nu.c(var2.t) + this.s.nextInt(11) - 5;
         var5 = class_nu.c(var2.u) + this.s.nextInt(11) - 5;
         this.x(new class_cj(var3, var4, var5));
      }

      this.B.b();
   }

   protected abstract int r();

   protected void a(int var1, int var2, class_aok var3) {
      this.B.c("moodSound");
      if(this.L == 0 && !this.D) {
         this.m = this.m * 3 + 1013904223;
         int var4 = this.m >> 2;
         int var5 = var4 & 15;
         int var6 = var4 >> 8 & 15;
         int var7 = var4 >> 16 & 255;
         class_cj var8 = new class_cj(var5, var7, var6);
         class_agj var9 = var3.a(var8);
         var5 += var1;
         var6 += var2;
         if(var9.v() == class_atk.a && this.k(var8) <= this.s.nextInt(8) && this.b(class_aet.a, var8) <= 0) {
            class_xa var10 = this.a((double)var5 + 0.5D, (double)var7 + 0.5D, (double)var6 + 0.5D, 8.0D);
            if(var10 != null && var10.e((double)var5 + 0.5D, (double)var7 + 0.5D, (double)var6 + 0.5D) > 4.0D) {
               this.a((double)var5 + 0.5D, (double)var7 + 0.5D, (double)var6 + 0.5D, "ambient.cave.cave", 0.7F, 0.8F + this.s.nextFloat() * 0.2F);
               this.L = this.s.nextInt(12000) + 6000;
            }
         }
      }

      this.B.c("checkLight");
      var3.m();
   }

   protected void i() {
      this.E();
   }

   public void a(class_agj var1, class_cj var2, Random var3) {
      this.e = true;
      var1.b(this, var2, this.p(var2), var3);
      this.e = false;
   }

   public boolean v(class_cj var1) {
      return this.e(var1, false);
   }

   public boolean w(class_cj var1) {
      return this.e(var1, true);
   }

   public boolean e(class_cj var1, boolean var2) {
      class_aez var3 = this.b(var1);
      float var4 = var3.a(var1);
      if(var4 > 0.15F) {
         return false;
      } else {
         if(var1.o() >= 0 && var1.o() < 256 && this.b(class_aet.b, var1) < 10) {
            class_anl var5 = this.p(var1);
            class_agj var6 = var5.c();
            if((var6 == class_agk.j || var6 == class_agk.i) && ((Integer)var5.b(class_ajd.b)).intValue() == 0) {
               if(!var2) {
                  return true;
               }

               boolean var7 = this.F(var1.e()) && this.F(var1.f()) && this.F(var1.c()) && this.F(var1.d());
               if(!var7) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   private boolean F(class_cj var1) {
      return this.p(var1).c().v() == class_atk.h;
   }

   public boolean f(class_cj var1, boolean var2) {
      class_aez var3 = this.b(var1);
      float var4 = var3.a(var1);
      if(var4 > 0.15F) {
         return false;
      } else if(!var2) {
         return true;
      } else {
         if(var1.o() >= 0 && var1.o() < 256 && this.b(class_aet.b, var1) < 10) {
            class_agj var5 = this.p(var1).c();
            if(var5.v() == class_atk.a && class_agk.aH.d(this, var1)) {
               return true;
            }
         }

         return false;
      }
   }

   public boolean x(class_cj var1) {
      boolean var2 = false;
      if(!this.t.m()) {
         var2 |= this.c(class_aet.a, var1);
      }

      var2 |= this.c(class_aet.b, var1);
      return var2;
   }

   private int a(class_cj var1, class_aet var2) {
      if(var2 == class_aet.a && this.i(var1)) {
         return 15;
      } else {
         class_agj var3 = this.p(var1).c();
         int var4 = var2 == class_aet.a?0:var3.t();
         int var5 = var3.r();
         if(var5 >= 15 && var3.t() > 0) {
            var5 = 1;
         }

         if(var5 < 1) {
            var5 = 1;
         }

         if(var5 >= 15) {
            return 0;
         } else if(var4 >= 14) {
            return var4;
         } else {
            class_cq[] var6 = class_cq.values();
            int var7 = var6.length;

            for(int var8 = 0; var8 < var7; ++var8) {
               class_cq var9 = var6[var8];
               class_cj var10 = var1.a(var9);
               int var11 = this.b(var2, var10) - var5;
               if(var11 > var4) {
                  var4 = var11;
               }

               if(var4 >= 14) {
                  return var4;
               }
            }

            return var4;
         }
      }
   }

   public boolean c(class_aet var1, class_cj var2) {
      if(!this.a(var2, 17, false)) {
         return false;
      } else {
         int var3 = 0;
         int var4 = 0;
         this.B.a("getBrightness");
         int var5 = this.b(var1, var2);
         int var6 = this.a(var2, var1);
         int var7 = var2.n();
         int var8 = var2.o();
         int var9 = var2.p();
         int var10;
         int var11;
         int var12;
         int var13;
         int var16;
         int var17;
         int var18;
         int var19;
         if(var6 > var5) {
            this.H[var4++] = 133152;
         } else if(var6 < var5) {
            this.H[var4++] = 133152 | var5 << 18;

            label90:
            while(true) {
               int var14;
               do {
                  do {
                     class_cj var15;
                     do {
                        if(var3 >= var4) {
                           var3 = 0;
                           break label90;
                        }

                        var10 = this.H[var3++];
                        var11 = (var10 & 63) - 32 + var7;
                        var12 = (var10 >> 6 & 63) - 32 + var8;
                        var13 = (var10 >> 12 & 63) - 32 + var9;
                        var14 = var10 >> 18 & 15;
                        var15 = new class_cj(var11, var12, var13);
                        var16 = this.b(var1, var15);
                     } while(var16 != var14);

                     this.a((class_aet)var1, (class_cj)var15, 0);
                  } while(var14 <= 0);

                  var17 = class_nu.a(var11 - var7);
                  var18 = class_nu.a(var12 - var8);
                  var19 = class_nu.a(var13 - var9);
               } while(var17 + var18 + var19 >= 17);

               class_cj.class_a_in_class_cj var20 = new class_cj.class_a_in_class_cj();
               class_cq[] var21 = class_cq.values();
               int var22 = var21.length;

               for(int var23 = 0; var23 < var22; ++var23) {
                  class_cq var24 = var21[var23];
                  int var25 = var11 + var24.g();
                  int var26 = var12 + var24.h();
                  int var27 = var13 + var24.i();
                  var20.c(var25, var26, var27);
                  int var28 = Math.max(1, this.p(var20).c().r());
                  var16 = this.b((class_aet)var1, (class_cj)var20);
                  if(var16 == var14 - var28 && var4 < this.H.length) {
                     this.H[var4++] = var25 - var7 + 32 | var26 - var8 + 32 << 6 | var27 - var9 + 32 << 12 | var14 - var28 << 18;
                  }
               }
            }
         }

         this.B.b();
         this.B.a("checkedPosition < toCheckCount");

         while(var3 < var4) {
            var10 = this.H[var3++];
            var11 = (var10 & 63) - 32 + var7;
            var12 = (var10 >> 6 & 63) - 32 + var8;
            var13 = (var10 >> 12 & 63) - 32 + var9;
            class_cj var29 = new class_cj(var11, var12, var13);
            int var30 = this.b(var1, var29);
            var16 = this.a(var29, var1);
            if(var16 != var30) {
               this.a(var1, var29, var16);
               if(var16 > var30) {
                  var17 = Math.abs(var11 - var7);
                  var18 = Math.abs(var12 - var8);
                  var19 = Math.abs(var13 - var9);
                  boolean var31 = var4 < this.H.length - 6;
                  if(var17 + var18 + var19 < 17 && var31) {
                     if(this.b(var1, var29.e()) < var16) {
                        this.H[var4++] = var11 - 1 - var7 + 32 + (var12 - var8 + 32 << 6) + (var13 - var9 + 32 << 12);
                     }

                     if(this.b(var1, var29.f()) < var16) {
                        this.H[var4++] = var11 + 1 - var7 + 32 + (var12 - var8 + 32 << 6) + (var13 - var9 + 32 << 12);
                     }

                     if(this.b(var1, var29.b()) < var16) {
                        this.H[var4++] = var11 - var7 + 32 + (var12 - 1 - var8 + 32 << 6) + (var13 - var9 + 32 << 12);
                     }

                     if(this.b(var1, var29.a()) < var16) {
                        this.H[var4++] = var11 - var7 + 32 + (var12 + 1 - var8 + 32 << 6) + (var13 - var9 + 32 << 12);
                     }

                     if(this.b(var1, var29.c()) < var16) {
                        this.H[var4++] = var11 - var7 + 32 + (var12 - var8 + 32 << 6) + (var13 - 1 - var9 + 32 << 12);
                     }

                     if(this.b(var1, var29.d()) < var16) {
                        this.H[var4++] = var11 - var7 + 32 + (var12 - var8 + 32 << 6) + (var13 + 1 - var9 + 32 << 12);
                     }
                  }
               }
            }
         }

         this.B.b();
         return true;
      }
   }

   public boolean a(boolean var1) {
      return false;
   }

   public List a(class_aok var1, boolean var2) {
      return null;
   }

   public List a(class_arw var1, boolean var2) {
      return null;
   }

   public List b(class_pr var1, class_awf var2) {
      return this.a(var1, var2, class_pv.d);
   }

   public List a(class_pr var1, class_awf var2, Predicate var3) {
      ArrayList var4 = Lists.newArrayList();
      int var5 = class_nu.c((var2.a - 2.0D) / 16.0D);
      int var6 = class_nu.c((var2.d + 2.0D) / 16.0D);
      int var7 = class_nu.c((var2.c - 2.0D) / 16.0D);
      int var8 = class_nu.c((var2.f + 2.0D) / 16.0D);

      for(int var9 = var5; var9 <= var6; ++var9) {
         for(int var10 = var7; var10 <= var8; ++var10) {
            if(this.a(var9, var10, true)) {
               this.a(var9, var10).a((class_pr)var1, var2, var4, var3);
            }
         }
      }

      return var4;
   }

   public List a(Class var1, Predicate var2) {
      ArrayList var3 = Lists.newArrayList();
      Iterator var4 = this.f.iterator();

      while(var4.hasNext()) {
         class_pr var5 = (class_pr)var4.next();
         if(var1.isAssignableFrom(var5.getClass()) && var2.apply(var5)) {
            var3.add(var5);
         }
      }

      return var3;
   }

   public List b(Class var1, Predicate var2) {
      ArrayList var3 = Lists.newArrayList();
      Iterator var4 = this.j.iterator();

      while(var4.hasNext()) {
         class_pr var5 = (class_pr)var4.next();
         if(var1.isAssignableFrom(var5.getClass()) && var2.apply(var5)) {
            var3.add(var5);
         }
      }

      return var3;
   }

   public List a(Class var1, class_awf var2) {
      return this.a(var1, var2, class_pv.d);
   }

   public List a(Class var1, class_awf var2, Predicate var3) {
      int var4 = class_nu.c((var2.a - 2.0D) / 16.0D);
      int var5 = class_nu.c((var2.d + 2.0D) / 16.0D);
      int var6 = class_nu.c((var2.c - 2.0D) / 16.0D);
      int var7 = class_nu.c((var2.f + 2.0D) / 16.0D);
      ArrayList var8 = Lists.newArrayList();

      for(int var9 = var4; var9 <= var5; ++var9) {
         for(int var10 = var6; var10 <= var7; ++var10) {
            if(this.a(var9, var10, true)) {
               this.a(var9, var10).a((Class)var1, var2, var8, var3);
            }
         }
      }

      return var8;
   }

   public class_pr a(Class var1, class_awf var2, class_pr var3) {
      List var4 = this.a(var1, var2);
      class_pr var5 = null;
      double var6 = Double.MAX_VALUE;

      for(int var8 = 0; var8 < var4.size(); ++var8) {
         class_pr var9 = (class_pr)var4.get(var8);
         if(var9 != var3 && class_pv.d.apply(var9)) {
            double var10 = var3.h(var9);
            if(var10 <= var6) {
               var5 = var9;
               var6 = var10;
            }
         }
      }

      return var5;
   }

   public class_pr a(int var1) {
      return (class_pr)this.l.a(var1);
   }

   public void b(class_cj var1, class_amg var2) {
      if(this.e(var1)) {
         this.f(var1).e();
      }

   }

   public int a(Class var1) {
      int var2 = 0;
      Iterator var3 = this.f.iterator();

      while(true) {
         class_pr var4;
         do {
            if(!var3.hasNext()) {
               return var2;
            }

            var4 = (class_pr)var3.next();
         } while(var4 instanceof class_qb && ((class_qb)var4).cn());

         if(var1.isAssignableFrom(var4.getClass())) {
            ++var2;
         }
      }
   }

   public void a(Collection var1) {
      this.f.addAll(var1);
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         class_pr var3 = (class_pr)var2.next();
         this.b(var3);
      }

   }

   public void c(Collection var1) {
      this.g.addAll(var1);
   }

   public boolean a(class_agj var1, class_cj var2, boolean var3, class_cq var4, class_pr var5, class_aas var6) {
      class_agj var7 = this.p(var2).c();
      class_awf var8 = var3?null:var1.a(this, var2, var1.S());
      return var8 != null && !this.a(var8, var5)?false:(var7.v() == class_atk.q && var1 == class_agk.cf?true:var7.v().j() && var1.a(this, var2, var4, var6));
   }

   public int G() {
      return this.a;
   }

   public void b(int var1) {
      this.a = var1;
   }

   public int a(class_cj var1, class_cq var2) {
      class_anl var3 = this.p(var1);
      return var3.c().b((class_aer)this, var1, var3, (class_cq)var2);
   }

   public class_aes H() {
      return this.x.u();
   }

   public int y(class_cj var1) {
      byte var2 = 0;
      int var3 = Math.max(var2, this.a(var1.b(), class_cq.a));
      if(var3 >= 15) {
         return var3;
      } else {
         var3 = Math.max(var3, this.a(var1.a(), class_cq.b));
         if(var3 >= 15) {
            return var3;
         } else {
            var3 = Math.max(var3, this.a(var1.c(), class_cq.c));
            if(var3 >= 15) {
               return var3;
            } else {
               var3 = Math.max(var3, this.a(var1.d(), class_cq.d));
               if(var3 >= 15) {
                  return var3;
               } else {
                  var3 = Math.max(var3, this.a(var1.e(), class_cq.e));
                  if(var3 >= 15) {
                     return var3;
                  } else {
                     var3 = Math.max(var3, this.a(var1.f(), class_cq.f));
                     return var3 >= 15?var3:var3;
                  }
               }
            }
         }
      }
   }

   public boolean b(class_cj var1, class_cq var2) {
      return this.c(var1, var2) > 0;
   }

   public int c(class_cj var1, class_cq var2) {
      class_anl var3 = this.p(var1);
      class_agj var4 = var3.c();
      return var4.x()?this.y(var1):var4.a((class_aer)this, var1, (class_anl)var3, (class_cq)var2);
   }

   public boolean z(class_cj var1) {
      return this.c(var1.b(), class_cq.a) > 0?true:(this.c(var1.a(), class_cq.b) > 0?true:(this.c(var1.c(), class_cq.c) > 0?true:(this.c(var1.d(), class_cq.d) > 0?true:(this.c(var1.e(), class_cq.e) > 0?true:this.c(var1.f(), class_cq.f) > 0))));
   }

   public int A(class_cj var1) {
      int var2 = 0;
      class_cq[] var3 = class_cq.values();
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         class_cq var6 = var3[var5];
         int var7 = this.c(var1.a(var6), var6);
         if(var7 >= 15) {
            return 15;
         }

         if(var7 > var2) {
            var2 = var7;
         }
      }

      return var2;
   }

   public class_xa a(class_pr var1, double var2) {
      return this.a(var1.s, var1.t, var1.u, var2);
   }

   public class_xa a(double var1, double var3, double var5, double var7) {
      double var9 = -1.0D;
      class_xa var11 = null;

      for(int var12 = 0; var12 < this.j.size(); ++var12) {
         class_xa var13 = (class_xa)this.j.get(var12);
         if(class_pv.d.apply(var13)) {
            double var14 = var13.e(var1, var3, var5);
            if((var7 < 0.0D || var14 < var7 * var7) && (var9 == -1.0D || var14 < var9)) {
               var9 = var14;
               var11 = var13;
            }
         }
      }

      return var11;
   }

   public boolean b(double var1, double var3, double var5, double var7) {
      for(int var9 = 0; var9 < this.j.size(); ++var9) {
         class_xa var10 = (class_xa)this.j.get(var9);
         if(class_pv.d.apply(var10)) {
            double var11 = var10.e(var1, var3, var5);
            if(var7 < 0.0D || var11 < var7 * var7) {
               return true;
            }
         }
      }

      return false;
   }

   public class_xa a(class_pr var1, double var2, double var4) {
      return this.a(var1.s, var1.t, var1.u, var2, var4);
   }

   public class_xa a(class_cj var1, double var2, double var4) {
      return this.a((double)((float)var1.n() + 0.5F), (double)((float)var1.o() + 0.5F), (double)((float)var1.p() + 0.5F), var2, var4);
   }

   public class_xa a(double var1, double var3, double var5, double var7, double var9) {
      double var11 = -1.0D;
      class_xa var13 = null;

      for(int var14 = 0; var14 < this.j.size(); ++var14) {
         class_xa var15 = (class_xa)this.j.get(var14);
         if(!var15.bH.a && var15.ai() && !var15.v()) {
            double var16 = var15.e(var1, var15.t, var5);
            double var18 = var7;
            if(var15.ax()) {
               var18 = var7 * 0.800000011920929D;
            }

            if(var15.aA()) {
               float var20 = var15.cc();
               if(var20 < 0.1F) {
                  var20 = 0.1F;
               }

               var18 *= (double)(0.7F * var20);
            }

            if((var9 < 0.0D || Math.abs(var15.t - var3) < var9 * var9) && (var7 < 0.0D || var16 < var18 * var18) && (var11 == -1.0D || var16 < var11)) {
               var11 = var16;
               var13 = var15;
            }
         }
      }

      return var13;
   }

   public class_xa a(String var1) {
      for(int var2 = 0; var2 < this.j.size(); ++var2) {
         class_xa var3 = (class_xa)this.j.get(var2);
         if(var1.equals(var3.e_())) {
            return var3;
         }
      }

      return null;
   }

   public class_xa b(UUID var1) {
      for(int var2 = 0; var2 < this.j.size(); ++var2) {
         class_xa var3 = (class_xa)this.j.get(var2);
         if(var1.equals(var3.aM())) {
            return var3;
         }
      }

      return null;
   }

   public void J() throws class_aeo {
      this.w.c();
   }

   public long K() {
      return this.x.b();
   }

   public long L() {
      return this.x.f();
   }

   public long M() {
      return this.x.g();
   }

   public void b(long var1) {
      this.x.c(var1);
   }

   public class_cj N() {
      class_cj var1 = new class_cj(this.x.c(), this.x.d(), this.x.e());
      if(!this.ag().a(var1)) {
         var1 = this.m(new class_cj(this.ag().f(), 0.0D, this.ag().g()));
      }

      return var1;
   }

   public void B(class_cj var1) {
      this.x.a(var1);
   }

   public boolean a(class_xa var1, class_cj var2) {
      return true;
   }

   public void a(class_pr var1, byte var2) {
   }

   public class_aoh O() {
      return this.v;
   }

   public void c(class_cj var1, class_agj var2, int var3, int var4) {
      var2.a(this, var1, this.p(var1), var3, var4);
   }

   public class_avo P() {
      return this.w;
   }

   public class_avn Q() {
      return this.x;
   }

   public class_ael R() {
      return this.x.x();
   }

   public void e() {
   }

   public float h(float var1) {
      return (this.q + (this.r - this.q) * var1) * this.j(var1);
   }

   public float j(float var1) {
      return this.o + (this.p - this.o) * var1;
   }

   public boolean S() {
      return (double)this.h(1.0F) > 0.9D;
   }

   public boolean T() {
      return (double)this.j(1.0F) > 0.2D;
   }

   public boolean C(class_cj var1) {
      if(!this.T()) {
         return false;
      } else if(!this.i(var1)) {
         return false;
      } else if(this.q(var1).o() > var1.o()) {
         return false;
      } else {
         class_aez var2 = this.b(var1);
         return var2.d()?false:(this.f(var1, false)?false:var2.e());
      }
   }

   public boolean D(class_cj var1) {
      class_aez var2 = this.b(var1);
      return var2.f();
   }

   public class_avz U() {
      return this.z;
   }

   public void a(String var1, class_avd var2) {
      this.z.a(var1, var2);
   }

   public class_avd a(Class var1, String var2) {
      return this.z.a(var1, var2);
   }

   public int b(String var1) {
      return this.z.a(var1);
   }

   public void a(int var1, class_cj var2, int var3) {
      for(int var4 = 0; var4 < this.u.size(); ++var4) {
         ((class_aep)this.u.get(var4)).a(var1, var2, var3);
      }

   }

   public void b(int var1, class_cj var2, int var3) {
      this.a((class_xa)null, var1, var2, var3);
   }

   public void a(class_xa var1, int var2, class_cj var3, int var4) {
      try {
         for(int var5 = 0; var5 < this.u.size(); ++var5) {
            ((class_aep)this.u.get(var5)).a(var1, var2, var3, var4);
         }

      } catch (Throwable var8) {
         class_b var6 = class_b.a(var8, "Playing level event");
         class_c var7 = var6.a("Level event being played");
         var7.a((String)"Block coordinates", (Object)class_c.a(var3));
         var7.a((String)"Event source", (Object)var1);
         var7.a((String)"Event type", (Object)Integer.valueOf(var2));
         var7.a((String)"Event data", (Object)Integer.valueOf(var4));
         throw new class_e(var6);
      }
   }

   public int V() {
      return 256;
   }

   public int W() {
      return this.t.m()?128:256;
   }

   public Random a(int var1, int var2, int var3) {
      long var4 = (long)var1 * 341873128712L + (long)var2 * 132897987541L + this.Q().b() + (long)var3;
      this.s.setSeed(var4);
      return this.s;
   }

   public class_cj a(String var1, class_cj var2) {
      return this.O().a(this, var1, var2);
   }

   public class_c a(class_b var1) {
      class_c var2 = var1.a("Affected level", 1);
      var2.a((String)"Level name", (Object)(this.x == null?"????":this.x.k()));
      var2.a("All players", new Callable() {
         public String a() {
            return class_aen.this.j.size() + " total; " + class_aen.this.j.toString();
         }

         // $FF: synthetic method
         public Object call() throws Exception {
            return this.a();
         }
      });
      var2.a("Chunk stats", new Callable() {
         public String a() {
            return class_aen.this.v.f();
         }

         // $FF: synthetic method
         public Object call() throws Exception {
            return this.a();
         }
      });

      try {
         this.x.a(var2);
      } catch (Throwable var4) {
         var2.a("Level Data Unobtainable", var4);
      }

      return var2;
   }

   public void c(int var1, class_cj var2, int var3) {
      for(int var4 = 0; var4 < this.u.size(); ++var4) {
         class_aep var5 = (class_aep)this.u.get(var4);
         var5.b(var1, var2, var3);
      }

   }

   public Calendar Z() {
      if(this.L() % 600L == 0L) {
         this.K.setTimeInMillis(MinecraftServer.az());
      }

      return this.K;
   }

   public class_awn aa() {
      return this.C;
   }

   public void e(class_cj var1, class_agj var2) {
      Iterator var3 = class_cq.class_c_in_class_cq.a.iterator();

      while(var3.hasNext()) {
         class_cq var4 = (class_cq)var3.next();
         class_cj var5 = var1.a(var4);
         if(this.e(var5)) {
            class_anl var6 = this.p(var5);
            if(class_agk.cj.e(var6.c())) {
               var6.c().a(this, var5, var6, var2);
            } else if(var6.c().x()) {
               var5 = var5.a(var4);
               var6 = this.p(var5);
               if(class_agk.cj.e(var6.c())) {
                  var6.c().a(this, var5, var6, var2);
               }
            }
         }
      }

   }

   public class_on E(class_cj var1) {
      long var2 = 0L;
      float var4 = 0.0F;
      if(this.e(var1)) {
         var4 = this.z();
         var2 = this.f(var1).w();
      }

      return new class_on(this.ab(), this.M(), var2, var4);
   }

   public class_om ab() {
      return this.Q().y();
   }

   public int ac() {
      return this.I;
   }

   public void c(int var1) {
      this.I = var1;
   }

   public void d(int var1) {
      this.J = var1;
   }

   public boolean ae() {
      return this.y;
   }

   public class_tr af() {
      return this.A;
   }

   public class_aoe ag() {
      return this.N;
   }

   public boolean c(int var1, int var2) {
      class_cj var3 = this.N();
      int var4 = var1 * 16 + 8 - var3.n();
      int var5 = var2 * 16 + 8 - var3.p();
      short var6 = 128;
      return var4 >= -var6 && var4 <= var6 && var5 >= -var6 && var5 <= var6;
   }
}
