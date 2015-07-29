package net.minecraft.server;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.util.List;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_adk;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_aer;
import net.minecraft.server.Block;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_awg;
import net.minecraft.server.class_awh;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cy;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_gm;
import net.minecraft.server.MinecraftKey;
import net.minecraft.server.class_lh;
import net.minecraft.server.class_nu;
import net.minecraft.server.class_pc;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_pv;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_qi;
import net.minecraft.server.class_wb;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xi;

public class class_xd extends class_pr implements class_xi {
   private static final Predicate f;
   private static final int g;
   private int h;
   private int i;
   private int as;
   private Block at;
   private int au;
   protected boolean a;
   protected int b;
   public int c;
   public int d;
   public class_pr e;
   private int av;
   private int aw;
   private double ax;
   private int ay;

   public class_xd(class_aen var1) {
      super(var1);
      this.h = -1;
      this.i = -1;
      this.as = -1;
      this.ax = 2.0D;
      this.j = 10.0D;
      this.a(0.5F, 0.5F);
   }

   public class_xd(class_aen var1, double var2, double var4, double var6) {
      this(var1);
      this.b(var2, var4, var6);
   }

   public class_xd(class_aen var1, class_qa var2) {
      this(var1, var2.s, var2.t + (double)var2.aU() - 0.10000000149011612D, var2.u);
      this.e = var2;
      if(var2 instanceof class_xa) {
         this.c = 1;
      }

   }

   protected void h() {
      this.ac.a(g, Byte.valueOf((byte)0));
   }

   public void a(float var1, float var2, float var3, float var4, float var5) {
      float var6 = -class_nu.a(var2 * 0.017453292F) * class_nu.b(var1 * 0.017453292F);
      float var7 = -class_nu.a(var1 * 0.017453292F);
      float var8 = class_nu.b(var2 * 0.017453292F) * class_nu.b(var1 * 0.017453292F);
      this.c((double)var6, (double)var7, (double)var8, var4, var5);
   }

   public void c(double var1, double var3, double var5, float var7, float var8) {
      float var9 = class_nu.a(var1 * var1 + var3 * var3 + var5 * var5);
      var1 /= (double)var9;
      var3 /= (double)var9;
      var5 /= (double)var9;
      var1 += this.V.nextGaussian() * 0.007499999832361937D * (double)var8;
      var3 += this.V.nextGaussian() * 0.007499999832361937D * (double)var8;
      var5 += this.V.nextGaussian() * 0.007499999832361937D * (double)var8;
      var1 *= (double)var7;
      var3 *= (double)var7;
      var5 *= (double)var7;
      this.v = var1;
      this.w = var3;
      this.x = var5;
      float var10 = class_nu.a(var1 * var1 + var5 * var5);
      this.A = this.y = (float)(class_nu.b(var1, var5) * 180.0D / 3.1415927410125732D);
      this.B = this.z = (float)(class_nu.b(var3, (double)var10) * 180.0D / 3.1415927410125732D);
      this.av = 0;
   }

   public void t_() {
      super.t_();
      if(this.B == 0.0F && this.A == 0.0F) {
         float var1 = class_nu.a(this.v * this.v + this.x * this.x);
         this.A = this.y = (float)(class_nu.b(this.v, this.x) * 180.0D / 3.1415927410125732D);
         this.B = this.z = (float)(class_nu.b(this.w, (double)var1) * 180.0D / 3.1415927410125732D);
      }

      class_cj var13 = new class_cj(this.h, this.i, this.as);
      IBlockData var2 = this.o.p(var13);
      Block var3 = var2.getBlock();
      if(var3.v() != class_atk.a) {
         var3.a((class_aer)this.o, (class_cj)var13);
         class_awf var4 = var3.a(this.o, var13, var2);
         if(var4 != null && var4.a(new class_awh(this.s, this.t, this.u))) {
            this.a = true;
         }
      }

      if(this.d > 0) {
         --this.d;
      }

      if(this.a) {
         int var15 = var3.c(var2);
         if(var3 == this.at && var15 == this.au) {
            ++this.av;
            if(this.av >= 1200) {
               this.J();
            }
         } else {
            this.a = false;
            this.v *= (double)(this.V.nextFloat() * 0.2F);
            this.w *= (double)(this.V.nextFloat() * 0.2F);
            this.x *= (double)(this.V.nextFloat() * 0.2F);
            this.av = 0;
            this.aw = 0;
         }

         ++this.b;
      } else {
         this.b = 0;
         ++this.aw;
         class_awh var14 = new class_awh(this.s, this.t, this.u);
         class_awh var5 = new class_awh(this.s + this.v, this.t + this.w, this.u + this.x);
         class_awg var6 = this.o.a(var14, var5, false, true, false);
         var14 = new class_awh(this.s, this.t, this.u);
         var5 = new class_awh(this.s + this.v, this.t + this.w, this.u + this.x);
         if(var6 != null) {
            var5 = new class_awh(var6.c.a, var6.c.b, var6.c.c);
         }

         class_pr var7 = this.a(var14, var5);
         if(var7 != null) {
            var6 = new class_awg(var7);
         }

         if(var6 != null && var6.d != null && var6.d instanceof class_xa) {
            class_xa var8 = (class_xa)var6.d;
            if(var8.bH.a || this.e instanceof class_xa && !((class_xa)this.e).a(var8)) {
               var6 = null;
            }
         }

         if(var6 != null) {
            this.a(var6);
         }

         if(this.m()) {
            for(int var16 = 0; var16 < 4; ++var16) {
               this.o.a(class_cy.j, this.s + this.v * (double)var16 / 4.0D, this.t + this.w * (double)var16 / 4.0D, this.u + this.x * (double)var16 / 4.0D, -this.v, -this.w + 0.2D, -this.x, new int[0]);
            }
         }

         this.s += this.v;
         this.t += this.w;
         this.u += this.x;
         float var17 = class_nu.a(this.v * this.v + this.x * this.x);
         this.y = (float)(class_nu.b(this.v, this.x) * 180.0D / 3.1415927410125732D);

         for(this.z = (float)(class_nu.b(this.w, (double)var17) * 180.0D / 3.1415927410125732D); this.z - this.B < -180.0F; this.B -= 360.0F) {
            ;
         }

         while(this.z - this.B >= 180.0F) {
            this.B += 360.0F;
         }

         while(this.y - this.A < -180.0F) {
            this.A -= 360.0F;
         }

         while(this.y - this.A >= 180.0F) {
            this.A += 360.0F;
         }

         this.z = this.B + (this.z - this.B) * 0.2F;
         this.y = this.A + (this.y - this.A) * 0.2F;
         float var9 = 0.99F;
         float var10 = 0.05F;
         if(this.V()) {
            for(int var11 = 0; var11 < 4; ++var11) {
               float var12 = 0.25F;
               this.o.a(class_cy.e, this.s - this.v * (double)var12, this.t - this.w * (double)var12, this.u - this.x * (double)var12, this.v, this.w, this.x, new int[0]);
            }

            var9 = 0.6F;
         }

         if(this.U()) {
            this.N();
         }

         this.v *= (double)var9;
         this.w *= (double)var9;
         this.x *= (double)var9;
         this.w -= (double)var10;
         this.b(this.s, this.t, this.u);
         this.Q();
      }
   }

   protected void a(class_awg var1) {
      class_pr var2 = var1.d;
      if(var2 != null) {
         float var3 = class_nu.a(this.v * this.v + this.w * this.w + this.x * this.x);
         int var4 = class_nu.f((double)var3 * this.ax);
         if(this.m()) {
            var4 += this.V.nextInt(var4 / 2 + 2);
         }

         class_pc var5;
         if(this.e == null) {
            var5 = class_pc.a((class_xd)this, (class_pr)this);
         } else {
            var5 = class_pc.a(this, this.e);
         }

         if(this.av() && !(var2 instanceof class_wb)) {
            var2.f(5);
         }

         if(var2.a(var5, (float)var4)) {
            if(var2 instanceof class_qa) {
               class_qa var6 = (class_qa)var2;
               if(!this.o.D) {
                  var6.l(var6.bw() + 1);
               }

               if(this.ay > 0) {
                  float var7 = class_nu.a(this.v * this.v + this.x * this.x);
                  if(var7 > 0.0F) {
                     var6.g(this.v * (double)this.ay * 0.6000000238418579D / (double)var7, 0.1D, this.x * (double)this.ay * 0.6000000238418579D / (double)var7);
                  }
               }

               if(this.e instanceof class_qa) {
                  class_adk.a(var6, this.e);
                  class_adk.b((class_qa)((class_qa)this.e), (class_pr)var6);
               }

               this.b(var6);
               if(this.e != null && var6 != this.e && var6 instanceof class_xa && this.e instanceof class_lh) {
                  ((class_lh)this.e).a.a((class_ff)(new class_gm(6, 0.0F)));
               }
            }

            this.a("random.bowhit", 1.0F, 1.2F / (this.V.nextFloat() * 0.2F + 0.9F));
            if(!(var2 instanceof class_wb)) {
               this.J();
            }
         } else {
            this.v *= -0.10000000149011612D;
            this.w *= -0.10000000149011612D;
            this.x *= -0.10000000149011612D;
            this.y += 180.0F;
            this.A += 180.0F;
            this.aw = 0;
         }
      } else {
         class_cj var8 = var1.a();
         this.h = var8.n();
         this.i = var8.o();
         this.as = var8.p();
         IBlockData var9 = this.o.p(var8);
         this.at = var9.getBlock();
         this.au = this.at.c(var9);
         this.v = (double)((float)(var1.c.a - this.s));
         this.w = (double)((float)(var1.c.b - this.t));
         this.x = (double)((float)(var1.c.c - this.u));
         float var10 = class_nu.a(this.v * this.v + this.w * this.w + this.x * this.x);
         this.s -= this.v / (double)var10 * 0.05000000074505806D;
         this.t -= this.w / (double)var10 * 0.05000000074505806D;
         this.u -= this.x / (double)var10 * 0.05000000074505806D;
         this.a("random.bowhit", 1.0F, 1.2F / (this.V.nextFloat() * 0.2F + 0.9F));
         this.a = true;
         this.d = 7;
         this.a(false);
         if(this.at.v() != class_atk.a) {
            this.at.a((class_aen)this.o, var8, (IBlockData)var9, (class_pr)this);
         }
      }

   }

   protected void b(class_qa var1) {
   }

   protected class_pr a(class_awh var1, class_awh var2) {
      class_pr var3 = null;
      List var4 = this.o.a((class_pr)this, (class_awf)this.aT().a(this.v, this.w, this.x).b(1.0D, 1.0D, 1.0D), (Predicate)f);
      double var5 = 0.0D;

      for(int var7 = 0; var7 < var4.size(); ++var7) {
         class_pr var8 = (class_pr)var4.get(var7);
         if(var8 != this.e || this.aw >= 5) {
            float var9 = 0.3F;
            class_awf var10 = var8.aT().b((double)var9, (double)var9, (double)var9);
            class_awg var11 = var10.a(var1, var2);
            if(var11 != null) {
               double var12 = var1.g(var11.c);
               if(var12 < var5 || var5 == 0.0D) {
                  var3 = var8;
                  var5 = var12;
               }
            }
         }
      }

      return var3;
   }

   public void b(class_dn var1) {
      var1.a("xTile", (short)this.h);
      var1.a("yTile", (short)this.i);
      var1.a("zTile", (short)this.as);
      var1.a("life", (short)this.av);
      MinecraftKey var2 = (MinecraftKey)Block.BLOCK_REGISTRY.getKey(this.at);
      var1.a("inTile", var2 == null?"":var2.toString());
      var1.a("inData", (byte)this.au);
      var1.a("shake", (byte)this.d);
      var1.a("inGround", (byte)(this.a?1:0));
      var1.a("pickup", (byte)this.c);
      var1.a("damage", this.ax);
   }

   public void a(class_dn var1) {
      this.h = var1.f("xTile");
      this.i = var1.f("yTile");
      this.as = var1.f("zTile");
      this.av = var1.f("life");
      if(var1.b("inTile", 8)) {
         this.at = Block.getByName(var1.k("inTile"));
      } else {
         this.at = Block.getById(var1.e("inTile") & 255);
      }

      this.au = var1.e("inData") & 255;
      this.d = var1.e("shake") & 255;
      this.a = var1.e("inGround") == 1;
      if(var1.b("damage", 99)) {
         this.ax = var1.j("damage");
      }

      if(var1.b("pickup", 99)) {
         this.c = var1.e("pickup");
      } else if(var1.b("player", 99)) {
         this.c = var1.o("player")?1:0;
      }

   }

   public void d(class_xa var1) {
      if(!this.o.D && this.a && this.d <= 0) {
         boolean var2 = this.c == 1 || this.c == 2 && var1.bH.d;
         if(this.c == 1 && !var1.bp.a(this.j())) {
            var2 = false;
         }

         if(var2) {
            this.a("random.pop", 0.2F, ((this.V.nextFloat() - this.V.nextFloat()) * 0.7F + 1.0F) * 2.0F);
            var1.a(this, 1);
            this.J();
         }

      }
   }

   protected class_aas j() {
      return new class_aas(class_aau.g);
   }

   protected boolean s_() {
      return false;
   }

   public void b(double var1) {
      this.ax = var1;
   }

   public double l() {
      return this.ax;
   }

   public void a(int var1) {
      this.ay = var1;
   }

   public boolean aF() {
      return false;
   }

   public float aU() {
      return 0.0F;
   }

   public void a(boolean var1) {
      byte var2 = this.ac.a(g);
      if(var1) {
         this.ac.b(g, Byte.valueOf((byte)(var2 | 1)));
      } else {
         this.ac.b(g, Byte.valueOf((byte)(var2 & -2)));
      }

   }

   public boolean m() {
      byte var1 = this.ac.a(g);
      return (var1 & 1) != 0;
   }

   static {
      f = Predicates.and(new Predicate[]{class_pv.d, class_pv.a, new Predicate() {
         public boolean a(class_pr var1) {
            return var1.ad();
         }

         // $FF: synthetic method
         public boolean apply(Object var1) {
            return this.a((class_pr)var1);
         }
      }});
      g = class_qi.a(class_xd.class);
   }
}
