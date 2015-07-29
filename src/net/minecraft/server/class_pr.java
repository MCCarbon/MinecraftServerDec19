package net.minecraft.server;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Callable;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.Item;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_adk;
import net.minecraft.server.class_ads;
import net.minecraft.server.class_aej;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_ahz;
import net.minecraft.server.class_aia;
import net.minecraft.server.class_ajd;
import net.minecraft.server.class_alv;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_anp;
import net.minecraft.server.Material;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_awh;
import net.minecraft.server.class_b;
import net.minecraft.server.class_c;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_cy;
import net.minecraft.server.LocaleI18n;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_dp;
import net.minecraft.server.class_dr;
import net.minecraft.server.class_du;
import net.minecraft.server.class_e;
import net.minecraft.server.class_eb;
import net.minecraft.server.class_eu;
import net.minecraft.server.class_ew;
import net.minecraft.server.class_fa;
import net.minecraft.server.class_lg;
import net.minecraft.server.class_lh;
import net.minecraft.server.class_m;
import net.minecraft.server.class_n;
import net.minecraft.server.class_nu;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_pc;
import net.minecraft.server.class_pt;
import net.minecraft.server.class_pw;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_qi;
import net.minecraft.server.class_vi;
import net.minecraft.server.class_vm;
import net.minecraft.server.class_xa;

public abstract class class_pr implements class_m {
   private static final class_awf a = new class_awf(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
   private static int b;
   private int c;
   public double j;
   public boolean k;
   public class_pr l;
   public class_pr m;
   public boolean n;
   public World o;
   public double p;
   public double q;
   public double r;
   public double s;
   public double t;
   public double u;
   public double v;
   public double w;
   public double x;
   public float y;
   public float z;
   public float A;
   public float B;
   private class_awf f;
   public boolean C;
   public boolean D;
   public boolean E;
   public boolean F;
   public boolean G;
   protected boolean H;
   private boolean g;
   public boolean I;
   public float J;
   public float K;
   public float L;
   public float M;
   public float N;
   public float O;
   private int h;
   public double P;
   public double Q;
   public double R;
   public float S;
   public boolean T;
   public float U;
   protected Random V;
   public int W;
   public int X;
   private int i;
   protected boolean Y;
   public int Z;
   protected boolean aa;
   protected boolean ab;
   protected class_qi ac;
   private static final int as = class_qi.a(class_pr.class);
   private static final int at = class_qi.a(class_pr.class);
   private static final int au = class_qi.a(class_pr.class);
   private static final int av = class_qi.a(class_pr.class);
   private static final int aw = class_qi.a(class_pr.class);
   private double ax;
   private double ay;
   public boolean ad;
   public int ae;
   public int af;
   public int ag;
   public boolean ah;
   public boolean ai;
   public int aj;
   protected boolean ak;
   protected int al;
   public int am;
   protected class_cj an;
   protected class_awh ao;
   protected class_cq ap;
   private boolean az;
   protected UUID aq;
   private final class_n aA;
   private final List aB;
   protected boolean ar;

   public int F() {
      return this.c;
   }

   public void e(int var1) {
      this.c = var1;
   }

   public void G() {
      this.J();
   }

   public class_pr(World var1) {
      this.c = b++;
      this.j = 1.0D;
      this.f = a;
      this.J = 0.6F;
      this.K = 1.8F;
      this.h = 1;
      this.V = new Random();
      this.X = 1;
      this.aa = true;
      this.aq = class_nu.a(this.V);
      this.aA = new class_n();
      this.aB = Lists.newArrayList();
      this.o = var1;
      this.b(0.0D, 0.0D, 0.0D);
      if(var1 != null) {
         this.am = var1.t.p().a();
      }

      this.ac = new class_qi(this);
      this.ac.a(as, Byte.valueOf((byte)0));
      this.ac.a(at, Short.valueOf((short)300));
      this.ac.a(av, Byte.valueOf((byte)0));
      this.ac.a(au, "");
      this.ac.a(aw, Byte.valueOf((byte)0));
      this.h();
   }

   protected abstract void h();

   public class_qi H() {
      return this.ac;
   }

   public boolean equals(Object var1) {
      return var1 instanceof class_pr?((class_pr)var1).c == this.c:false;
   }

   public int hashCode() {
      return this.c;
   }

   public void J() {
      this.I = true;
   }

   protected void a(float var1, float var2) {
      if(var1 != this.J || var2 != this.K) {
         float var3 = this.J;
         this.J = var1;
         this.K = var2;
         this.a(new class_awf(this.aT().a, this.aT().b, this.aT().c, this.aT().a + (double)this.J, this.aT().b + (double)this.K, this.aT().c + (double)this.J));
         if(this.J > var3 && !this.aa && !this.o.D) {
            this.d((double)(var3 - this.J), 0.0D, (double)(var3 - this.J));
         }
      }

   }

   protected void b(float var1, float var2) {
      this.y = var1 % 360.0F;
      this.z = var2 % 360.0F;
   }

   public void b(double var1, double var3, double var5) {
      this.s = var1;
      this.t = var3;
      this.u = var5;
      float var7 = this.J / 2.0F;
      float var8 = this.K;
      this.a(new class_awf(var1 - (double)var7, var3, var5 - (double)var7, var1 + (double)var7, var3 + (double)var8, var5 + (double)var7));
   }

   public void t_() {
      if(!this.o.D) {
         this.b(6, this.az());
      }

      this.K();
   }

   public void K() {
      this.o.B.a("entityBaseTick");
      if(this.m != null && this.m.I) {
         this.m = null;
      }

      this.L = this.M;
      this.p = this.s;
      this.q = this.t;
      this.r = this.u;
      this.B = this.z;
      this.A = this.y;
      if(!this.o.D && this.o instanceof class_lg) {
         this.o.B.a("portal");
         MinecraftServer var1 = ((class_lg)this.o).s();
         int var2 = this.L();
         if(this.ak) {
            if(var1.C()) {
               if(this.m == null && this.al++ >= var2) {
                  this.al = var2;
                  this.aj = this.aq();
                  byte var3;
                  if(this.o.t.p().a() == -1) {
                     var3 = 0;
                  } else {
                     var3 = -1;
                  }

                  this.c(var3);
               }

               this.ak = false;
            }
         } else {
            if(this.al > 0) {
               this.al -= 4;
            }

            if(this.al < 0) {
               this.al = 0;
            }
         }

         if(this.aj > 0) {
            --this.aj;
         }

         this.o.B.b();
      }

      this.Y();
      this.W();
      if(this.o.D) {
         this.i = 0;
      } else if(this.i > 0) {
         if(this.ab) {
            this.i -= 4;
            if(this.i < 0) {
               this.i = 0;
            }
         } else {
            if(this.i % 20 == 0) {
               this.a(class_pc.c, 1.0F);
            }

            --this.i;
         }
      }

      if(this.ab()) {
         this.M();
         this.O *= 0.5F;
      }

      if(this.t < -64.0D) {
         this.O();
      }

      if(!this.o.D) {
         this.b(0, this.i > 0);
      }

      this.aa = false;
      this.o.B.b();
   }

   public int L() {
      return 0;
   }

   protected void M() {
      if(!this.ab) {
         this.a(class_pc.d, 4.0F);
         this.f(15);
      }
   }

   public void f(int var1) {
      int var2 = var1 * 20;
      if(this instanceof class_qa) {
         var2 = class_ads.a((class_qa)this, var2);
      }

      if(this.i < var2) {
         this.i = var2;
      }

   }

   public void N() {
      this.i = 0;
   }

   protected void O() {
      this.J();
   }

   public boolean c(double var1, double var3, double var5) {
      class_awf var7 = this.aT().c(var1, var3, var5);
      return this.b(var7);
   }

   private boolean b(class_awf var1) {
      return this.o.a(this, var1).isEmpty() && !this.o.d(var1);
   }

   public void d(double var1, double var3, double var5) {
      if(this.T) {
         this.a(this.aT().c(var1, var3, var5));
         this.m();
      } else {
         this.o.B.a("move");
         double var7 = this.s;
         double var9 = this.t;
         double var11 = this.u;
         if(this.H) {
            this.H = false;
            var1 *= 0.25D;
            var3 *= 0.05000000074505806D;
            var5 *= 0.25D;
            this.v = 0.0D;
            this.w = 0.0D;
            this.x = 0.0D;
         }

         double var13 = var1;
         double var15 = var3;
         double var17 = var5;
         boolean var19 = this.C && this.ax() && this instanceof class_xa;
         if(var19) {
            double var20;
            for(var20 = 0.05D; var1 != 0.0D && this.o.a(this, this.aT().c(var1, -1.0D, 0.0D)).isEmpty(); var13 = var1) {
               if(var1 < var20 && var1 >= -var20) {
                  var1 = 0.0D;
               } else if(var1 > 0.0D) {
                  var1 -= var20;
               } else {
                  var1 += var20;
               }
            }

            for(; var5 != 0.0D && this.o.a(this, this.aT().c(0.0D, -1.0D, var5)).isEmpty(); var17 = var5) {
               if(var5 < var20 && var5 >= -var20) {
                  var5 = 0.0D;
               } else if(var5 > 0.0D) {
                  var5 -= var20;
               } else {
                  var5 += var20;
               }
            }

            for(; var1 != 0.0D && var5 != 0.0D && this.o.a(this, this.aT().c(var1, -1.0D, var5)).isEmpty(); var17 = var5) {
               if(var1 < var20 && var1 >= -var20) {
                  var1 = 0.0D;
               } else if(var1 > 0.0D) {
                  var1 -= var20;
               } else {
                  var1 += var20;
               }

               var13 = var1;
               if(var5 < var20 && var5 >= -var20) {
                  var5 = 0.0D;
               } else if(var5 > 0.0D) {
                  var5 -= var20;
               } else {
                  var5 += var20;
               }
            }
         }

         List var53 = this.o.a(this, this.aT().a(var1, var3, var5));
         class_awf var21 = this.aT();

         class_awf var23;
         for(Iterator var22 = var53.iterator(); var22.hasNext(); var3 = var23.b(this.aT(), var3)) {
            var23 = (class_awf)var22.next();
         }

         this.a(this.aT().c(0.0D, var3, 0.0D));
         boolean var54 = this.C || var15 != var3 && var15 < 0.0D;

         class_awf var24;
         Iterator var55;
         for(var55 = var53.iterator(); var55.hasNext(); var1 = var24.a(this.aT(), var1)) {
            var24 = (class_awf)var55.next();
         }

         this.a(this.aT().c(var1, 0.0D, 0.0D));

         for(var55 = var53.iterator(); var55.hasNext(); var5 = var24.c(this.aT(), var5)) {
            var24 = (class_awf)var55.next();
         }

         this.a(this.aT().c(0.0D, 0.0D, var5));
         if(this.S > 0.0F && var54 && (var13 != var1 || var17 != var5)) {
            double var56 = var1;
            double var25 = var3;
            double var27 = var5;
            class_awf var29 = this.aT();
            this.a(var21);
            var3 = (double)this.S;
            List var30 = this.o.a(this, this.aT().a(var13, var3, var17));
            class_awf var31 = this.aT();
            class_awf var32 = var31.a(var13, 0.0D, var17);
            double var33 = var3;

            class_awf var36;
            for(Iterator var35 = var30.iterator(); var35.hasNext(); var33 = var36.b(var32, var33)) {
               var36 = (class_awf)var35.next();
            }

            var31 = var31.c(0.0D, var33, 0.0D);
            double var67 = var13;

            class_awf var38;
            for(Iterator var37 = var30.iterator(); var37.hasNext(); var67 = var38.a(var31, var67)) {
               var38 = (class_awf)var37.next();
            }

            var31 = var31.c(var67, 0.0D, 0.0D);
            double var68 = var17;

            class_awf var40;
            for(Iterator var39 = var30.iterator(); var39.hasNext(); var68 = var40.c(var31, var68)) {
               var40 = (class_awf)var39.next();
            }

            var31 = var31.c(0.0D, 0.0D, var68);
            class_awf var69 = this.aT();
            double var70 = var3;

            class_awf var43;
            for(Iterator var42 = var30.iterator(); var42.hasNext(); var70 = var43.b(var69, var70)) {
               var43 = (class_awf)var42.next();
            }

            var69 = var69.c(0.0D, var70, 0.0D);
            double var71 = var13;

            class_awf var45;
            for(Iterator var44 = var30.iterator(); var44.hasNext(); var71 = var45.a(var69, var71)) {
               var45 = (class_awf)var44.next();
            }

            var69 = var69.c(var71, 0.0D, 0.0D);
            double var72 = var17;

            class_awf var47;
            for(Iterator var46 = var30.iterator(); var46.hasNext(); var72 = var47.c(var69, var72)) {
               var47 = (class_awf)var46.next();
            }

            var69 = var69.c(0.0D, 0.0D, var72);
            double var73 = var67 * var67 + var68 * var68;
            double var48 = var71 * var71 + var72 * var72;
            if(var73 > var48) {
               var1 = var67;
               var5 = var68;
               var3 = -var33;
               this.a(var31);
            } else {
               var1 = var71;
               var5 = var72;
               var3 = -var70;
               this.a(var69);
            }

            class_awf var51;
            for(Iterator var50 = var30.iterator(); var50.hasNext(); var3 = var51.b(this.aT(), var3)) {
               var51 = (class_awf)var50.next();
            }

            this.a(this.aT().c(0.0D, var3, 0.0D));
            if(var56 * var56 + var27 * var27 >= var1 * var1 + var5 * var5) {
               var1 = var56;
               var3 = var25;
               var5 = var27;
               this.a(var29);
            }
         }

         this.o.B.b();
         this.o.B.a("rest");
         this.m();
         this.D = var13 != var1 || var17 != var5;
         this.E = var15 != var3;
         this.C = this.E && var15 < 0.0D;
         this.F = this.D || this.E;
         int var57 = class_nu.c(this.s);
         int var58 = class_nu.c(this.t - 0.20000000298023224D);
         int var59 = class_nu.c(this.u);
         class_cj var26 = new class_cj(var57, var58, var59);
         Block var60 = this.o.p(var26).getBlock();
         if(var60.getMaterial() == Material.a) {
            Block var28 = this.o.p(var26.b()).getBlock();
            if(var28 instanceof class_ahz || var28 instanceof class_alv || var28 instanceof class_aia) {
               var60 = var28;
               var26 = var26.b();
            }
         }

         this.a(var3, this.C, var60, var26);
         if(var13 != var1) {
            this.v = 0.0D;
         }

         if(var17 != var5) {
            this.x = 0.0D;
         }

         if(var15 != var3) {
            var60.a(this.o, this);
         }

         if(this.s_() && !var19 && this.m == null) {
            double var61 = this.s - var7;
            double var64 = this.t - var9;
            double var66 = this.u - var11;
            if(var60 != Blocks.LADDER) {
               var64 = 0.0D;
            }

            if(var60 != null && this.C) {
               var60.a(this.o, var26, this);
            }

            this.M = (float)((double)this.M + (double)class_nu.a(var61 * var61 + var66 * var66) * 0.6D);
            this.N = (float)((double)this.N + (double)class_nu.a(var61 * var61 + var64 * var64 + var66 * var66) * 0.6D);
            if(this.N > (float)this.h && var60.getMaterial() != Material.a) {
               this.h = (int)this.N + 1;
               if(this.V()) {
                  float var34 = class_nu.a(this.v * this.v * 0.20000000298023224D + this.w * this.w + this.x * this.x * 0.20000000298023224D) * 0.35F;
                  if(var34 > 1.0F) {
                     var34 = 1.0F;
                  }

                  this.a(this.P(), var34, 1.0F + (this.V.nextFloat() - this.V.nextFloat()) * 0.4F);
               }

               this.a(var26, var60);
            }
         }

         try {
            this.Q();
         } catch (Throwable var52) {
            class_b var63 = class_b.a(var52, "Checking entity block collision");
            class_c var65 = var63.a("Entity being checked for collision");
            this.a(var65);
            throw new class_e(var63);
         }

         boolean var62 = this.U();
         if(this.o.e(this.aT().d(0.001D, 0.001D, 0.001D))) {
            this.g(1);
            if(!var62) {
               ++this.i;
               if(this.i == 0) {
                  this.f(8);
               }
            }
         } else if(this.i <= 0) {
            this.i = -this.X;
         }

         if(var62 && this.i > 0) {
            this.a("random.fizz", 0.7F, 1.6F + (this.V.nextFloat() - this.V.nextFloat()) * 0.4F);
            this.i = -this.X;
         }

         this.o.B.b();
      }
   }

   private void m() {
      this.s = (this.aT().a + this.aT().d) / 2.0D;
      this.t = this.aT().b;
      this.u = (this.aT().c + this.aT().f) / 2.0D;
   }

   protected String P() {
      return "game.neutral.swim";
   }

   protected void Q() {
      class_cj var1 = new class_cj(this.aT().a + 0.001D, this.aT().b + 0.001D, this.aT().c + 0.001D);
      class_cj var2 = new class_cj(this.aT().d - 0.001D, this.aT().e - 0.001D, this.aT().f - 0.001D);
      if(this.o.a(var1, var2)) {
         for(int var3 = var1.n(); var3 <= var2.n(); ++var3) {
            for(int var4 = var1.o(); var4 <= var2.o(); ++var4) {
               for(int var5 = var1.p(); var5 <= var2.p(); ++var5) {
                  class_cj var6 = new class_cj(var3, var4, var5);
                  IBlockData var7 = this.o.p(var6);

                  try {
                     var7.getBlock().a(this.o, var6, var7, this);
                  } catch (Throwable var11) {
                     class_b var9 = class_b.a(var11, "Colliding entity with block");
                     class_c var10 = var9.a("Block being collided with");
                     class_c.a(var10, var6, var7);
                     throw new class_e(var9);
                  }
               }
            }
         }
      }

   }

   protected void a(class_cj var1, Block var2) {
      Block.StepSound var3 = var2.stepSound;
      if(this.o.p(var1.a()).getBlock() == Blocks.SNOW_LAYER) {
         var3 = Blocks.SNOW_LAYER.stepSound;
         this.a(var3.c(), var3.d() * 0.15F, var3.e());
      } else if(!var2.getMaterial().d()) {
         this.a(var3.c(), var3.d() * 0.15F, var3.e());
      }

   }

   public void a(String var1, float var2, float var3) {
      if(!this.R()) {
         this.o.a(this, var1, var2, var3);
      }

   }

   public boolean R() {
      return this.ac.a(aw) == 1;
   }

   public void b(boolean var1) {
      this.ac.b(aw, Byte.valueOf((byte)(var1?1:0)));
   }

   protected boolean s_() {
      return true;
   }

   protected void a(double var1, boolean var3, Block var4, class_cj var5) {
      if(var3) {
         if(this.O > 0.0F) {
            if(var4 != null) {
               var4.a(this.o, var5, this, this.O);
            } else {
               this.e(this.O, 1.0F);
            }

            this.O = 0.0F;
         }
      } else if(var1 < 0.0D) {
         this.O = (float)((double)this.O - var1);
      }

   }

   public class_awf S() {
      return null;
   }

   protected void g(int var1) {
      if(!this.ab) {
         this.a(class_pc.a, (float)var1);
      }

   }

   public final boolean T() {
      return this.ab;
   }

   public void e(float var1, float var2) {
      if(this.l != null) {
         this.l.e(var1, var2);
      }

   }

   public boolean U() {
      return this.Y || this.o.C(new class_cj(this.s, this.t, this.u)) || this.o.C(new class_cj(this.s, this.t + (double)this.K, this.u));
   }

   public boolean V() {
      return this.Y;
   }

   public boolean W() {
      if(this.o.a(this.aT().b(0.0D, -0.4000000059604645D, 0.0D).d(0.001D, 0.001D, 0.001D), Material.h, this)) {
         if(!this.Y && !this.aa) {
            this.X();
         }

         this.O = 0.0F;
         this.Y = true;
         this.i = 0;
      } else {
         this.Y = false;
      }

      return this.Y;
   }

   protected void X() {
      float var1 = class_nu.a(this.v * this.v * 0.20000000298023224D + this.w * this.w + this.x * this.x * 0.20000000298023224D) * 0.2F;
      if(var1 > 1.0F) {
         var1 = 1.0F;
      }

      this.a(this.aa(), var1, 1.0F + (this.V.nextFloat() - this.V.nextFloat()) * 0.4F);
      float var2 = (float)class_nu.c(this.aT().b);

      int var3;
      float var4;
      float var5;
      for(var3 = 0; (float)var3 < 1.0F + this.J * 20.0F; ++var3) {
         var4 = (this.V.nextFloat() * 2.0F - 1.0F) * this.J;
         var5 = (this.V.nextFloat() * 2.0F - 1.0F) * this.J;
         this.o.a(class_cy.e, this.s + (double)var4, (double)(var2 + 1.0F), this.u + (double)var5, this.v, this.w - (double)(this.V.nextFloat() * 0.2F), this.x, new int[0]);
      }

      for(var3 = 0; (float)var3 < 1.0F + this.J * 20.0F; ++var3) {
         var4 = (this.V.nextFloat() * 2.0F - 1.0F) * this.J;
         var5 = (this.V.nextFloat() * 2.0F - 1.0F) * this.J;
         this.o.a(class_cy.f, this.s + (double)var4, (double)(var2 + 1.0F), this.u + (double)var5, this.v, this.w, this.x, new int[0]);
      }

   }

   public void Y() {
      if(this.ay() && !this.V()) {
         this.Z();
      }

   }

   protected void Z() {
      int var1 = class_nu.c(this.s);
      int var2 = class_nu.c(this.t - 0.20000000298023224D);
      int var3 = class_nu.c(this.u);
      class_cj var4 = new class_cj(var1, var2, var3);
      IBlockData var5 = this.o.p(var4);
      Block var6 = var5.getBlock();
      if(var6.getRenderType() != -1) {
         this.o.a(class_cy.L, this.s + ((double)this.V.nextFloat() - 0.5D) * (double)this.J, this.aT().b + 0.1D, this.u + ((double)this.V.nextFloat() - 0.5D) * (double)this.J, -this.v * 4.0D, 1.5D, -this.x * 4.0D, new int[]{Block.getCombinedId(var5)});
      }

   }

   protected String aa() {
      return "game.neutral.swim.splash";
   }

   public boolean a(Material var1) {
      double var2 = this.t + (double)this.aU();
      class_cj var4 = new class_cj(this.s, var2, this.u);
      IBlockData var5 = this.o.p(var4);
      Block var6 = var5.getBlock();
      if(var6.getMaterial() == var1) {
         float var7 = class_ajd.b(var5.getBlock().toLegacyData(var5)) - 0.11111111F;
         float var8 = (float)(var4.o() + 1) - var7;
         boolean var9 = var2 < (double)var8;
         return !var9 && this instanceof class_xa?false:var9;
      } else {
         return false;
      }
   }

   public boolean ab() {
      return this.o.a(this.aT().b(-0.10000000149011612D, -0.4000000059604645D, -0.10000000149011612D), Material.i);
   }

   public void a(float var1, float var2, float var3) {
      float var4 = var1 * var1 + var2 * var2;
      if(var4 >= 1.0E-4F) {
         var4 = class_nu.c(var4);
         if(var4 < 1.0F) {
            var4 = 1.0F;
         }

         var4 = var3 / var4;
         var1 *= var4;
         var2 *= var4;
         float var5 = class_nu.a(this.y * 3.1415927F / 180.0F);
         float var6 = class_nu.b(this.y * 3.1415927F / 180.0F);
         this.v += (double)(var1 * var6 - var2 * var5);
         this.x += (double)(var2 * var6 + var1 * var5);
      }
   }

   public float c(float var1) {
      class_cj var2 = new class_cj(this.s, this.t + (double)this.aU(), this.u);
      return this.o.e(var2)?this.o.o(var2):0.0F;
   }

   public void a(World var1) {
      this.o = var1;
   }

   public void a(double var1, double var3, double var5, float var7, float var8) {
      this.p = this.s = var1;
      this.q = this.t = var3;
      this.r = this.u = var5;
      this.A = this.y = var7;
      this.B = this.z = var8;
      double var9 = (double)(this.A - var7);
      if(var9 < -180.0D) {
         this.A += 360.0F;
      }

      if(var9 >= 180.0D) {
         this.A -= 360.0F;
      }

      this.b(this.s, this.t, this.u);
      this.b(var7, var8);
   }

   public void a(class_cj var1, float var2, float var3) {
      this.b((double)var1.n() + 0.5D, (double)var1.o(), (double)var1.p() + 0.5D, var2, var3);
   }

   public void b(double var1, double var3, double var5, float var7, float var8) {
      this.P = this.p = this.s = var1;
      this.Q = this.q = this.t = var3;
      this.R = this.r = this.u = var5;
      this.y = var7;
      this.z = var8;
      this.b(this.s, this.t, this.u);
   }

   public float g(class_pr var1) {
      float var2 = (float)(this.s - var1.s);
      float var3 = (float)(this.t - var1.t);
      float var4 = (float)(this.u - var1.u);
      return class_nu.c(var2 * var2 + var3 * var3 + var4 * var4);
   }

   public double e(double var1, double var3, double var5) {
      double var7 = this.s - var1;
      double var9 = this.t - var3;
      double var11 = this.u - var5;
      return var7 * var7 + var9 * var9 + var11 * var11;
   }

   public double b(class_cj var1) {
      return var1.c(this.s, this.t, this.u);
   }

   public double c(class_cj var1) {
      return var1.d(this.s, this.t, this.u);
   }

   public double f(double var1, double var3, double var5) {
      double var7 = this.s - var1;
      double var9 = this.t - var3;
      double var11 = this.u - var5;
      return (double)class_nu.a(var7 * var7 + var9 * var9 + var11 * var11);
   }

   public double h(class_pr var1) {
      double var2 = this.s - var1.s;
      double var4 = this.t - var1.t;
      double var6 = this.u - var1.u;
      return var2 * var2 + var4 * var4 + var6 * var6;
   }

   public void d(class_xa var1) {
   }

   public void i(class_pr var1) {
      if(var1.l != this && var1.m != this) {
         if(!var1.T && !this.T) {
            double var2 = var1.s - this.s;
            double var4 = var1.u - this.u;
            double var6 = class_nu.a(var2, var4);
            if(var6 >= 0.009999999776482582D) {
               var6 = (double)class_nu.a(var6);
               var2 /= var6;
               var4 /= var6;
               double var8 = 1.0D / var6;
               if(var8 > 1.0D) {
                  var8 = 1.0D;
               }

               var2 *= var8;
               var4 *= var8;
               var2 *= 0.05000000074505806D;
               var4 *= 0.05000000074505806D;
               var2 *= (double)(1.0F - this.U);
               var4 *= (double)(1.0F - this.U);
               if(this.l == null) {
                  this.g(-var2, 0.0D, -var4);
               }

               if(var1.l == null) {
                  var1.g(var2, 0.0D, var4);
               }
            }

         }
      }
   }

   public void g(double var1, double var3, double var5) {
      this.v += var1;
      this.w += var3;
      this.x += var5;
      this.ai = true;
   }

   protected void ac() {
      this.G = true;
   }

   public boolean a(class_pc var1, float var2) {
      if(this.b(var1)) {
         return false;
      } else {
         this.ac();
         return false;
      }
   }

   public class_awh d(float var1) {
      if(var1 == 1.0F) {
         return this.f(this.z, this.y);
      } else {
         float var2 = this.B + (this.z - this.B) * var1;
         float var3 = this.A + (this.y - this.A) * var1;
         return this.f(var2, var3);
      }
   }

   protected final class_awh f(float var1, float var2) {
      float var3 = class_nu.b(-var2 * 0.017453292F - 3.1415927F);
      float var4 = class_nu.a(-var2 * 0.017453292F - 3.1415927F);
      float var5 = -class_nu.b(-var1 * 0.017453292F);
      float var6 = class_nu.a(-var1 * 0.017453292F);
      return new class_awh((double)(var4 * var5), (double)var6, (double)(var3 * var5));
   }

   public boolean ad() {
      return false;
   }

   public boolean ae() {
      return false;
   }

   public void b(class_pr var1, int var2) {
   }

   public boolean c(class_dn var1) {
      String var2 = this.ag();
      if(!this.I && var2 != null) {
         var1.a("id", var2);
         this.e(var1);
         return true;
      } else {
         return false;
      }
   }

   public boolean d(class_dn var1) {
      String var2 = this.ag();
      if(!this.I && var2 != null && this.l == null) {
         var1.a("id", var2);
         this.e(var1);
         return true;
      } else {
         return false;
      }
   }

   public void e(class_dn var1) {
      try {
         var1.a((String)"Pos", (class_eb)this.a(new double[]{this.s, this.t, this.u}));
         var1.a((String)"Motion", (class_eb)this.a(new double[]{this.v, this.w, this.x}));
         var1.a((String)"Rotation", (class_eb)this.a(new float[]{this.y, this.z}));
         var1.a("FallDistance", this.O);
         var1.a("Fire", (short)this.i);
         var1.a("Air", (short)this.aB());
         var1.a("OnGround", this.C);
         var1.a("Dimension", this.am);
         var1.a("Invulnerable", this.az);
         var1.a("PortalCooldown", this.aj);
         var1.a("UUID", this.aM());
         if(this.aO() != null && !this.aO().isEmpty()) {
            var1.a("CustomName", this.aO());
            var1.a("CustomNameVisible", this.aP());
         }

         this.aA.b(var1);
         if(this.R()) {
            var1.a("Silent", this.R());
         }

         if(this.ar) {
            var1.a("Glowing", this.ar);
         }

         this.b(var1);
         if(this.m != null) {
            class_dn var2 = new class_dn();
            if(this.m.c(var2)) {
               var1.a((String)"Riding", (class_eb)var2);
            }
         }

      } catch (Throwable var5) {
         class_b var3 = class_b.a(var5, "Saving entity NBT");
         class_c var4 = var3.a("Entity being saved");
         this.a(var4);
         throw new class_e(var3);
      }
   }

   public void f(class_dn var1) {
      try {
         class_du var2 = var1.c("Pos", 6);
         class_du var7 = var1.c("Motion", 6);
         class_du var8 = var1.c("Rotation", 5);
         this.v = var7.e(0);
         this.w = var7.e(1);
         this.x = var7.e(2);
         if(Math.abs(this.v) > 10.0D) {
            this.v = 0.0D;
         }

         if(Math.abs(this.w) > 10.0D) {
            this.w = 0.0D;
         }

         if(Math.abs(this.x) > 10.0D) {
            this.x = 0.0D;
         }

         this.p = this.P = this.s = var2.e(0);
         this.q = this.Q = this.t = var2.e(1);
         this.r = this.R = this.u = var2.e(2);
         this.A = this.y = var8.f(0);
         this.B = this.z = var8.f(1);
         this.f(this.y);
         this.g(this.y);
         this.O = var1.i("FallDistance");
         this.i = var1.f("Fire");
         this.i(var1.f("Air"));
         this.C = var1.o("OnGround");
         this.am = var1.g("Dimension");
         this.az = var1.o("Invulnerable");
         this.aj = var1.g("PortalCooldown");
         UUID var5 = var1.a("UUID");
         if(var5 != null) {
            this.aq = var5;
         } else if(var1.b("UUID", 8)) {
            this.aq = UUID.fromString(var1.k("UUID"));
         }

         this.b(this.s, this.t, this.u);
         this.b(this.y, this.z);
         if(var1.b("CustomName", 8) && !var1.k("CustomName").isEmpty()) {
            this.a(var1.k("CustomName"));
         }

         this.g(var1.o("CustomNameVisible"));
         this.aA.a(var1);
         this.b(var1.o("Silent"));
         this.ar = var1.o("Glowing");
         this.a(var1);
         if(this.af()) {
            this.b(this.s, this.t, this.u);
         }

      } catch (Throwable var6) {
         class_b var3 = class_b.a(var6, "Loading entity NBT");
         class_c var4 = var3.a("Entity being loaded");
         this.a(var4);
         throw new class_e(var3);
      }
   }

   protected boolean af() {
      return true;
   }

   protected final String ag() {
      return class_pt.b(this);
   }

   protected abstract void a(class_dn var1);

   protected abstract void b(class_dn var1);

   public void ah() {
   }

   protected class_du a(double... var1) {
      class_du var2 = new class_du();
      double[] var3 = var1;
      int var4 = var1.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         double var6 = var3[var5];
         var2.a((class_eb)(new class_dp(var6)));
      }

      return var2;
   }

   protected class_du a(float... var1) {
      class_du var2 = new class_du();
      float[] var3 = var1;
      int var4 = var1.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         float var6 = var3[var5];
         var2.a((class_eb)(new class_dr(var6)));
      }

      return var2;
   }

   public class_vm a(Item var1, int var2) {
      return this.a(var1, var2, 0.0F);
   }

   public class_vm a(Item var1, int var2, float var3) {
      return this.a(new class_aas(var1, var2, 0), var3);
   }

   public class_vm a(class_aas var1, float var2) {
      if(var1.b != 0 && var1.b() != null) {
         class_vm var3 = new class_vm(this.o, this.s, this.t + (double)var2, this.u, var1);
         var3.p();
         this.o.a((class_pr)var3);
         return var3;
      } else {
         return null;
      }
   }

   public boolean ai() {
      return !this.I;
   }

   public boolean aj() {
      if(this.T) {
         return false;
      } else {
         class_cj.class_a_in_class_cj var1 = new class_cj.class_a_in_class_cj(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);

         for(int var2 = 0; var2 < 8; ++var2) {
            int var3 = class_nu.c(this.t + (double)(((float)((var2 >> 0) % 2) - 0.5F) * 0.1F) + (double)this.aU());
            int var4 = class_nu.c(this.s + (double)(((float)((var2 >> 1) % 2) - 0.5F) * this.J * 0.8F));
            int var5 = class_nu.c(this.u + (double)(((float)((var2 >> 2) % 2) - 0.5F) * this.J * 0.8F));
            if(var1.n() != var4 || var1.o() != var3 || var1.p() != var5) {
               var1.c(var4, var3, var5);
               if(this.o.p(var1).getBlock().isVisuallyOpaque()) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   public boolean a(class_xa var1, class_aas var2, class_oo var3) {
      return false;
   }

   public class_awf j(class_pr var1) {
      return null;
   }

   public void ak() {
      if(this.m.I) {
         this.m = null;
      } else {
         this.v = 0.0D;
         this.w = 0.0D;
         this.x = 0.0D;
         this.t_();
         if(this.m != null) {
            this.m.al();
            this.ay += (double)(this.m.y - this.m.A);

            for(this.ax += (double)(this.m.z - this.m.B); this.ay >= 180.0D; this.ay -= 360.0D) {
               ;
            }

            while(this.ay < -180.0D) {
               this.ay += 360.0D;
            }

            while(this.ax >= 180.0D) {
               this.ax -= 360.0D;
            }

            while(this.ax < -180.0D) {
               this.ax += 360.0D;
            }

            double var1 = this.ay * 0.5D;
            double var3 = this.ax * 0.5D;
            float var5 = 10.0F;
            if(var1 > (double)var5) {
               var1 = (double)var5;
            }

            if(var1 < (double)(-var5)) {
               var1 = (double)(-var5);
            }

            if(var3 > (double)var5) {
               var3 = (double)var5;
            }

            if(var3 < (double)(-var5)) {
               var3 = (double)(-var5);
            }

            this.ay -= var1;
            this.ax -= var3;
         }
      }
   }

   public void al() {
      if(this.l != null) {
         this.l.b(this.s, this.t + this.an() + this.l.am(), this.u);
      }
   }

   public double am() {
      return 0.0D;
   }

   public double an() {
      return (double)this.K * 0.75D;
   }

   public void a(class_pr var1) {
      this.ax = 0.0D;
      this.ay = 0.0D;
      if(var1 == null) {
         if(this.m != null) {
            this.b(this.m.s, this.m.aT().b + (double)this.m.K, this.m.u, this.y, this.z);
            this.m.l = null;
         }

         this.m = null;
      } else {
         if(this.m != null) {
            this.m.l = null;
         }

         if(var1 != null) {
            for(class_pr var2 = var1.m; var2 != null; var2 = var2.m) {
               if(var2 == this) {
                  return;
               }
            }
         }

         this.m = var1;
         var1.l = this;
      }
   }

   public float ao() {
      return 0.1F;
   }

   public class_awh ap() {
      return null;
   }

   public void d(class_cj var1) {
      if(this.aj > 0) {
         this.aj = this.aq();
      } else {
         if(!this.o.D && !var1.equals(this.an)) {
            this.an = var1;
            class_anp.class_b_in_class_anp var2 = Blocks.PORTAL.f(this.o, var1);
            double var3 = var2.b().k() == class_cq.class_a_in_class_cq.a?(double)var2.a().p():(double)var2.a().n();
            double var5 = var2.b().k() == class_cq.class_a_in_class_cq.a?this.u:this.s;
            var5 = Math.abs(class_nu.c(var5 - (double)(var2.b().e().c() == class_cq.class_b_in_class_cq.b?1:0), var3, var3 - (double)var2.d()));
            double var7 = class_nu.c(this.t - 1.0D, (double)var2.a().o(), (double)(var2.a().o() - var2.e()));
            this.ao = new class_awh(var5, var7, 0.0D);
            this.ap = var2.b();
         }

         this.ak = true;
      }
   }

   public int aq() {
      return 300;
   }

   public Iterable as() {
      return this.aB;
   }

   public Iterable at() {
      return this.aB;
   }

   public Iterable au() {
      return Iterables.concat(this.as(), this.at());
   }

   public void a(class_pw var1, class_aas var2) {
   }

   public boolean av() {
      boolean var1 = this.o != null && this.o.D;
      return !this.ab && (this.i > 0 || var1 && this.h(0));
   }

   public boolean aw() {
      return this.m != null;
   }

   public boolean ax() {
      return this.h(1);
   }

   public void c(boolean var1) {
      this.b(1, var1);
   }

   public boolean ay() {
      return this.h(3);
   }

   public void d(boolean var1) {
      this.b(3, var1);
   }

   public boolean az() {
      return this.ar || this.o.D && this.h(6);
   }

   public boolean aA() {
      return this.h(5);
   }

   public void f(boolean var1) {
      this.b(5, var1);
   }

   protected boolean h(int var1) {
      return (this.ac.a(as) & 1 << var1) != 0;
   }

   protected void b(int var1, boolean var2) {
      byte var3 = this.ac.a(as);
      if(var2) {
         this.ac.b(as, Byte.valueOf((byte)(var3 | 1 << var1)));
      } else {
         this.ac.b(as, Byte.valueOf((byte)(var3 & ~(1 << var1))));
      }

   }

   public int aB() {
      return this.ac.b(at);
   }

   public void i(int var1) {
      this.ac.b(at, Short.valueOf((short)var1));
   }

   public void a(class_vi var1) {
      this.a(class_pc.b, 5.0F);
      ++this.i;
      if(this.i == 0) {
         this.f(8);
      }

   }

   public void a(class_qa var1) {
   }

   protected boolean j(double var1, double var3, double var5) {
      class_cj var7 = new class_cj(var1, var3, var5);
      double var8 = var1 - (double)var7.n();
      double var10 = var3 - (double)var7.o();
      double var12 = var5 - (double)var7.p();
      List var14 = this.o.a(this.aT());
      if(var14.isEmpty() && !this.o.u(var7)) {
         return false;
      } else {
         byte var15 = 3;
         double var16 = 9999.0D;
         if(!this.o.u(var7.e()) && var8 < var16) {
            var16 = var8;
            var15 = 0;
         }

         if(!this.o.u(var7.f()) && 1.0D - var8 < var16) {
            var16 = 1.0D - var8;
            var15 = 1;
         }

         if(!this.o.u(var7.a()) && 1.0D - var10 < var16) {
            var16 = 1.0D - var10;
            var15 = 3;
         }

         if(!this.o.u(var7.c()) && var12 < var16) {
            var16 = var12;
            var15 = 4;
         }

         if(!this.o.u(var7.d()) && 1.0D - var12 < var16) {
            var16 = 1.0D - var12;
            var15 = 5;
         }

         float var18 = this.V.nextFloat() * 0.2F + 0.1F;
         if(var15 == 0) {
            this.v = (double)(-var18);
         }

         if(var15 == 1) {
            this.v = (double)var18;
         }

         if(var15 == 3) {
            this.w = (double)var18;
         }

         if(var15 == 4) {
            this.x = (double)(-var18);
         }

         if(var15 == 5) {
            this.x = (double)var18;
         }

         return true;
      }
   }

   public void aC() {
      this.H = true;
      this.O = 0.0F;
   }

   public String e_() {
      if(this.l_()) {
         return this.aO();
      } else {
         String var1 = class_pt.b(this);
         if(var1 == null) {
            var1 = "generic";
         }

         return LocaleI18n.get("entity." + var1 + ".name");
      }
   }

   public class_pr[] aD() {
      return null;
   }

   public boolean k(class_pr var1) {
      return this == var1;
   }

   public float aE() {
      return 0.0F;
   }

   public void f(float var1) {
   }

   public void g(float var1) {
   }

   public boolean aF() {
      return true;
   }

   public boolean l(class_pr var1) {
      return false;
   }

   public String toString() {
      return String.format("%s[\'%s\'/%d, l=\'%s\', x=%.2f, y=%.2f, z=%.2f]", new Object[]{this.getClass().getSimpleName(), this.e_(), Integer.valueOf(this.c), this.o == null?"~NULL~":this.o.Q().k(), Double.valueOf(this.s), Double.valueOf(this.t), Double.valueOf(this.u)});
   }

   public boolean b(class_pc var1) {
      return this.az && var1 != class_pc.j && !var1.u();
   }

   public void m(class_pr var1) {
      this.b(var1.s, var1.t, var1.u, var1.y, var1.z);
   }

   public void n(class_pr var1) {
      class_dn var2 = new class_dn();
      var1.e(var2);
      this.f(var2);
      this.aj = var1.aj;
      this.an = var1.an;
      this.ao = var1.ao;
      this.ap = var1.ap;
   }

   public void c(int var1) {
      if(!this.o.D && !this.I) {
         this.o.B.a("changeDimension");
         MinecraftServer var2 = MinecraftServer.N();
         int var3 = this.am;
         class_lg var4 = var2.a(var3);
         class_lg var5 = var2.a(var1);
         this.am = var1;
         if(var3 == 1 && var1 == 1) {
            var5 = var2.a(0);
            this.am = 0;
         }

         this.o.e(this);
         this.I = false;
         this.o.B.a("reposition");
         var2.ap().a(this, var3, var4, var5);
         this.o.B.c("reloading");
         class_pr var6 = class_pt.a((String)class_pt.b(this), (World)var5);
         if(var6 != null) {
            var6.n(this);
            if(var3 == 1 && var1 == 1) {
               class_cj var7 = this.o.r(var5.N());
               var6.a(var7, var6.y, var6.z);
            }

            var5.a(var6);
         }

         this.I = true;
         this.o.B.b();
         var4.k();
         var5.k();
         this.o.B.b();
      }
   }

   public float a(class_aej var1, World var2, class_cj var3, IBlockData var4) {
      return var4.getBlock().a(this);
   }

   public boolean a(class_aej var1, World var2, class_cj var3, IBlockData var4, float var5) {
      return true;
   }

   public int aG() {
      return 3;
   }

   public class_awh aI() {
      return this.ao;
   }

   public class_cq aJ() {
      return this.ap;
   }

   public boolean aK() {
      return false;
   }

   public void a(class_c var1) {
      var1.a("Entity Type", new Callable() {
         public String a() throws Exception {
            return class_pt.b(class_pr.this) + " (" + class_pr.this.getClass().getCanonicalName() + ")";
         }

         // $FF: synthetic method
         public Object call() throws Exception {
            return this.a();
         }
      });
      var1.a((String)"Entity ID", (Object)Integer.valueOf(this.c));
      var1.a("Entity Name", new Callable() {
         public String a() throws Exception {
            return class_pr.this.e_();
         }

         // $FF: synthetic method
         public Object call() throws Exception {
            return this.a();
         }
      });
      var1.a((String)"Entity\'s Exact location", (Object)String.format("%.2f, %.2f, %.2f", new Object[]{Double.valueOf(this.s), Double.valueOf(this.t), Double.valueOf(this.u)}));
      var1.a((String)"Entity\'s Block location", (Object)class_c.a((double)class_nu.c(this.s), (double)class_nu.c(this.t), (double)class_nu.c(this.u)));
      var1.a((String)"Entity\'s Momentum", (Object)String.format("%.2f, %.2f, %.2f", new Object[]{Double.valueOf(this.v), Double.valueOf(this.w), Double.valueOf(this.x)}));
      var1.a("Entity\'s Rider", new Callable() {
         public String a() throws Exception {
            return class_pr.this.l.toString();
         }

         // $FF: synthetic method
         public Object call() throws Exception {
            return this.a();
         }
      });
      var1.a("Entity\'s Vehicle", new Callable() {
         public String a() throws Exception {
            return class_pr.this.m.toString();
         }

         // $FF: synthetic method
         public Object call() throws Exception {
            return this.a();
         }
      });
   }

   public UUID aM() {
      return this.aq;
   }

   public boolean aN() {
      return true;
   }

   public class_eu f_() {
      class_fa var1 = new class_fa(this.e_());
      var1.b().a(this.aS());
      var1.b().a(this.aM().toString());
      return var1;
   }

   public void a(String var1) {
      this.ac.b(au, var1);
   }

   public String aO() {
      return this.ac.e(au);
   }

   public boolean l_() {
      return !this.ac.e(au).isEmpty();
   }

   public void g(boolean var1) {
      this.ac.b(av, Byte.valueOf((byte)(var1?1:0)));
   }

   public boolean aP() {
      return this.ac.a(av) == 1;
   }

   public void a(double var1, double var3, double var5) {
      this.b(var1, var3, var5, this.y, this.z);
   }

   public void d(int var1) {
   }

   public class_cq aR() {
      return class_cq.b(class_nu.c((double)(this.y * 4.0F / 360.0F) + 0.5D) & 3);
   }

   protected class_ew aS() {
      class_dn var1 = new class_dn();
      String var2 = class_pt.b(this);
      var1.a("id", this.aM().toString());
      if(var2 != null) {
         var1.a("type", var2);
      }

      var1.a("name", this.e_());
      return new class_ew(class_ew.class_a_in_class_ew.d, new class_fa(var1.toString()));
   }

   public boolean a(class_lh var1) {
      return true;
   }

   public class_awf aT() {
      return this.f;
   }

   public void a(class_awf var1) {
      this.f = var1;
   }

   public float aU() {
      return this.K * 0.85F;
   }

   public boolean aV() {
      return this.g;
   }

   public void h(boolean var1) {
      this.g = var1;
   }

   public boolean c(int var1, class_aas var2) {
      return false;
   }

   public void a(class_eu var1) {
   }

   public boolean a(int var1, String var2) {
      return true;
   }

   public class_cj c() {
      return new class_cj(this.s, this.t + 0.5D, this.u);
   }

   public class_awh d() {
      return new class_awh(this.s, this.t, this.u);
   }

   public World e() {
      return this.o;
   }

   public class_pr f() {
      return this;
   }

   public boolean u_() {
      return false;
   }

   public void a(class_n.class_a_in_class_n var1, int var2) {
      this.aA.a(this, var1, var2);
   }

   public class_n aW() {
      return this.aA;
   }

   public void o(class_pr var1) {
      this.aA.a(var1.aW());
   }

   public class_oq a(class_xa var1, class_awh var2, class_aas var3, class_oo var4) {
      return class_oq.b;
   }

   public boolean aX() {
      return false;
   }

   protected void a(class_qa var1, class_pr var2) {
      if(var2 instanceof class_qa) {
         class_adk.a((class_qa)((class_qa)var2), (class_pr)var1);
      }

      class_adk.b(var1, var2);
   }

   public void b(class_lh var1) {
   }

   public void c(class_lh var1) {
   }

   public float a(Block.class_c_in_class_agj var1) {
      float var2 = class_nu.g(this.y);
      switch(class_pr.SyntheticClass_1.a[var1.ordinal()]) {
      case 1:
         return var2 + 180.0F;
      case 2:
         return var2 + 270.0F;
      case 3:
         return var2 + 90.0F;
      default:
         return var2;
      }
   }

   public float a(Block.class_a_in_class_agj var1) {
      float var2 = class_nu.g(this.y);
      switch(class_pr.SyntheticClass_1.b[var1.ordinal()]) {
      case 1:
         return -var2;
      case 2:
         return 180.0F - var2;
      default:
         return var2;
      }
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a;
      // $FF: synthetic field
      static final int[] b = new int[Block.class_a_in_class_agj.values().length];

      static {
         try {
            b[Block.class_a_in_class_agj.b.ordinal()] = 1;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            b[Block.class_a_in_class_agj.c.ordinal()] = 2;
         } catch (NoSuchFieldError var4) {
            ;
         }

         a = new int[Block.class_c_in_class_agj.values().length];

         try {
            a[Block.class_c_in_class_agj.c.ordinal()] = 1;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[Block.class_c_in_class_agj.d.ordinal()] = 2;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[Block.class_c_in_class_agj.b.ordinal()] = 3;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
