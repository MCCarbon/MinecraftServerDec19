package net.minecraft.server;

import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.class_awg;
import net.minecraft.server.class_awh;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cy;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_du;
import net.minecraft.server.class_eb;
import net.minecraft.server.MinecraftKey;
import net.minecraft.server.class_nu;
import net.minecraft.server.class_pc;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_xj;

public abstract class class_xf extends class_pr {
   private int e = -1;
   private int f = -1;
   private int g = -1;
   private Block h;
   private boolean i;
   public class_qa a;
   private int as;
   private int at;
   public double b;
   public double c;
   public double d;

   public class_xf(World var1) {
      super(var1);
      this.a(1.0F, 1.0F);
   }

   protected void h() {
   }

   public class_xf(World var1, double var2, double var4, double var6, double var8, double var10, double var12) {
      super(var1);
      this.a(1.0F, 1.0F);
      this.b(var2, var4, var6, this.y, this.z);
      this.b(var2, var4, var6);
      double var14 = (double)class_nu.a(var8 * var8 + var10 * var10 + var12 * var12);
      this.b = var8 / var14 * 0.1D;
      this.c = var10 / var14 * 0.1D;
      this.d = var12 / var14 * 0.1D;
   }

   public class_xf(World var1, class_qa var2, double var3, double var5, double var7) {
      super(var1);
      this.a = var2;
      this.a(1.0F, 1.0F);
      this.b(var2.s, var2.t, var2.u, var2.y, var2.z);
      this.b(this.s, this.t, this.u);
      this.v = this.w = this.x = 0.0D;
      var3 += this.V.nextGaussian() * 0.4D;
      var5 += this.V.nextGaussian() * 0.4D;
      var7 += this.V.nextGaussian() * 0.4D;
      double var9 = (double)class_nu.a(var3 * var3 + var5 * var5 + var7 * var7);
      this.b = var3 / var9 * 0.1D;
      this.c = var5 / var9 * 0.1D;
      this.d = var7 / var9 * 0.1D;
   }

   public void t_() {
      if(this.o.D || (this.a == null || !this.a.I) && this.o.e(new class_cj(this))) {
         super.t_();
         this.f(1);
         if(this.i) {
            if(this.o.p(new class_cj(this.e, this.f, this.g)).getBlock() == this.h) {
               ++this.as;
               if(this.as == 600) {
                  this.J();
               }

               return;
            }

            this.i = false;
            this.v *= (double)(this.V.nextFloat() * 0.2F);
            this.w *= (double)(this.V.nextFloat() * 0.2F);
            this.x *= (double)(this.V.nextFloat() * 0.2F);
            this.as = 0;
            this.at = 0;
         } else {
            ++this.at;
         }

         class_awg var1 = class_xj.a(this, true, this.at >= 25, this.a);
         if(var1 != null) {
            this.a(var1);
         }

         this.s += this.v;
         this.t += this.w;
         this.u += this.x;
         class_xj.a(this, 0.2F);
         float var2 = this.j();
         if(this.V()) {
            for(int var3 = 0; var3 < 4; ++var3) {
               float var4 = 0.25F;
               this.o.a(class_cy.e, this.s - this.v * (double)var4, this.t - this.w * (double)var4, this.u - this.x * (double)var4, this.v, this.w, this.x, new int[0]);
            }

            var2 = 0.8F;
         }

         this.v += this.b;
         this.w += this.c;
         this.x += this.d;
         this.v *= (double)var2;
         this.w *= (double)var2;
         this.x *= (double)var2;
         this.o.a(class_cy.l, this.s, this.t + 0.5D, this.u, 0.0D, 0.0D, 0.0D, new int[0]);
         this.b(this.s, this.t, this.u);
      } else {
         this.J();
      }
   }

   protected float j() {
      return 0.95F;
   }

   protected abstract void a(class_awg var1);

   public void b(class_dn var1) {
      var1.a("xTile", (short)this.e);
      var1.a("yTile", (short)this.f);
      var1.a("zTile", (short)this.g);
      MinecraftKey var2 = (MinecraftKey)Block.BLOCK_REGISTRY.getKey(this.h);
      var1.a("inTile", var2 == null?"":var2.toString());
      var1.a("inGround", (byte)(this.i?1:0));
      var1.a((String)"direction", (class_eb)this.a((double[])(new double[]{this.v, this.w, this.x})));
   }

   public void a(class_dn var1) {
      this.e = var1.f("xTile");
      this.f = var1.f("yTile");
      this.g = var1.f("zTile");
      if(var1.b("inTile", 8)) {
         this.h = Block.getByName(var1.k("inTile"));
      } else {
         this.h = Block.getById(var1.e("inTile") & 255);
      }

      this.i = var1.e("inGround") == 1;
      if(var1.b("direction", 9)) {
         class_du var2 = var1.c("direction", 6);
         this.v = var2.e(0);
         this.w = var2.e(1);
         this.x = var2.e(2);
      } else {
         this.J();
      }

   }

   public boolean ad() {
      return true;
   }

   public float ao() {
      return 1.0F;
   }

   public boolean a(class_pc var1, float var2) {
      if(this.b(var1)) {
         return false;
      } else {
         this.ac();
         if(var1.j() != null) {
            class_awh var3 = var1.j().ap();
            if(var3 != null) {
               this.v = var3.a;
               this.w = var3.b;
               this.x = var3.c;
               this.b = this.v * 0.1D;
               this.c = this.w * 0.1D;
               this.d = this.x * 0.1D;
            }

            if(var1.j() instanceof class_qa) {
               this.a = (class_qa)var1.j();
            }

            return true;
         } else {
            return false;
         }
      }
   }

   public float c(float var1) {
      return 1.0F;
   }
}
