package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.class_aes;
import net.minecraft.server.BiomeBase;
import net.minecraft.server.Chunk;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_cy;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.MathHelper;
import net.minecraft.server.class_om;
import net.minecraft.server.class_on;
import net.minecraft.server.class_pc;
import net.minecraft.server.Entity;
import net.minecraft.server.EntityLiving;
import net.minecraft.server.class_qb;
import net.minecraft.server.class_qd;
import net.minecraft.server.Datawathcer;
import net.minecraft.server.class_qk;
import net.minecraft.server.class_qz;
import net.minecraft.server.class_rm;
import net.minecraft.server.class_sx;
import net.minecraft.server.class_sy;
import net.minecraft.server.class_tf;
import net.minecraft.server.class_uj;
import net.minecraft.server.class_wd;
import net.minecraft.server.class_wl;
import net.minecraft.server.EntityHuman;

public class class_wo extends class_qb implements class_wd {
   private static final int bq = Datawathcer.claimId(class_wo.class);
   public float a;
   public float b;
   public float c;
   private boolean br;

   public class_wo(World var1) {
      super(var1);
      this.f = new class_wo.class_d_in_class_wo(this);
      this.i.a(1, new class_wo.class_b_in_class_wo(this));
      this.i.a(2, new class_wo.class_a_in_class_wo(this));
      this.i.a(3, new class_wo.class_e_in_class_wo(this));
      this.i.a(5, new class_wo.class_c_in_class_wo(this));
      this.bn.a(1, new class_sy(this));
      this.bn.a(3, new class_sx(this, class_uj.class));
   }

   protected void h() {
      super.h();
      this.ac.add(bq, Byte.valueOf((byte)1));
   }

   protected void a(int var1) {
      this.ac.b(bq, Byte.valueOf((byte)var1));
      this.a(0.51000005F * (float)var1, 0.51000005F * (float)var1);
      this.b(this.s, this.t, this.u);
      this.a(class_wl.a).a((double)(var1 * var1));
      this.a(class_wl.d).a((double)(0.2F + 0.1F * (float)var1));
      this.i(this.bv());
      this.b_ = var1;
   }

   public int cB() {
      return this.ac.getByte(bq);
   }

   public void b(NBTTagCompound var1) {
      super.b(var1);
      var1.put("Size", this.cB() - 1);
      var1.put("wasOnGround", this.br);
   }

   public void a(NBTTagCompound var1) {
      super.a(var1);
      int var2 = var1.getInt("Size");
      if(var2 < 0) {
         var2 = 0;
      }

      this.a(var2 + 1);
      this.br = var1.getBoolean("wasOnGround");
   }

   protected class_cy n() {
      return class_cy.H;
   }

   protected String cz() {
      return "mob.slime." + (this.cB() > 1?"big":"small");
   }

   public void t_() {
      if(!this.o.isClientSide && this.o.ab() == class_om.a && this.cB() > 0) {
         this.I = true;
      }

      this.b += (this.a - this.b) * 0.5F;
      this.c = this.b;
      super.t_();
      if(this.C && !this.br) {
         int var1 = this.cB();

         for(int var2 = 0; var2 < var1 * 8; ++var2) {
            float var3 = this.V.nextFloat() * 3.1415927F * 2.0F;
            float var4 = this.V.nextFloat() * 0.5F + 0.5F;
            float var5 = MathHelper.sin(var3) * (float)var1 * 0.5F * var4;
            float var6 = MathHelper.cos(var3) * (float)var1 * 0.5F * var4;
            World var10000 = this.o;
            class_cy var10001 = this.n();
            double var10002 = this.s + (double)var5;
            double var10004 = this.u + (double)var6;
            var10000.a(var10001, var10002, this.aT().yMin, var10004, 0.0D, 0.0D, 0.0D, new int[0]);
         }

         if(this.cA()) {
            this.a(this.cz(), this.bC(), ((this.V.nextFloat() - this.V.nextFloat()) * 0.2F + 1.0F) / 0.8F);
         }

         this.a = -0.5F;
      } else if(!this.C && this.br) {
         this.a = 1.0F;
      }

      this.br = this.C;
      this.cw();
   }

   protected void cw() {
      this.a *= 0.6F;
   }

   protected int cv() {
      return this.V.nextInt(20) + 10;
   }

   protected class_wo cu() {
      return new class_wo(this.o);
   }

   public void d(int var1) {
      if(var1 == bq) {
         int var2 = this.cB();
         this.a(0.51000005F * (float)var2, 0.51000005F * (float)var2);
         this.y = this.aN;
         this.aL = this.aN;
         if(this.V() && this.V.nextInt(20) == 0) {
            this.X();
         }
      }

      super.d(var1);
   }

   public void J() {
      int var1 = this.cB();
      if(!this.o.isClientSide && var1 > 1 && this.bo() <= 0.0F) {
         int var2 = 2 + this.V.nextInt(3);

         for(int var3 = 0; var3 < var2; ++var3) {
            float var4 = ((float)(var3 % 2) - 0.5F) * (float)var1 / 4.0F;
            float var5 = ((float)(var3 / 2) - 0.5F) * (float)var1 / 4.0F;
            class_wo var6 = this.cu();
            if(this.hasCustomName()) {
               var6.a(this.aO());
            }

            if(this.cn()) {
               var6.cl();
            }

            var6.a(var1 / 2);
            var6.b(this.s + (double)var4, this.t + 0.5D, this.u + (double)var5, this.V.nextFloat() * 360.0F, 0.0F);
            this.o.addEntity((Entity)var6);
         }
      }

      super.J();
   }

   public void i(Entity var1) {
      super.i(var1);
      if(var1 instanceof class_uj && this.cx()) {
         this.e((EntityLiving)var1);
      }

   }

   public void d(EntityHuman var1) {
      if(this.cx()) {
         this.e(var1);
      }

   }

   protected void e(EntityLiving var1) {
      int var2 = this.cB();
      if(this.t(var1) && this.h(var1) < 0.6D * (double)var2 * 0.6D * (double)var2 && var1.a(class_pc.a((EntityLiving)this), (float)this.cy())) {
         this.a("mob.attack", 1.0F, (this.V.nextFloat() - this.V.nextFloat()) * 0.2F + 1.0F);
         this.a(this, var1);
      }

   }

   public float aU() {
      return 0.625F * this.K;
   }

   protected boolean cx() {
      return this.cB() > 1;
   }

   protected int cy() {
      return this.cB();
   }

   protected String bp() {
      return "mob.slime." + (this.cB() > 1?"big":"small");
   }

   protected String bq() {
      return "mob.slime." + (this.cB() > 1?"big":"small");
   }

   protected Item D() {
      return this.cB() == 1?Items.aO:null;
   }

   public boolean cf() {
      BlockPosition var1 = new BlockPosition(MathHelper.floor(this.s), 0, MathHelper.floor(this.u));
      Chunk var2 = this.o.f(var1);
      if(this.o.Q().u() == class_aes.c && this.V.nextInt(4) != 1) {
         return false;
      } else {
         if(this.o.ab() != class_om.a) {
            BiomeBase var3 = this.o.b(var1);
            if(var3 == BiomeBase.v && this.t > 50.0D && this.t < 70.0D && this.V.nextFloat() < 0.5F && this.V.nextFloat() < this.o.z() && this.o.l(new BlockPosition(this)) <= this.V.nextInt(8)) {
               return super.cf();
            }

            if(this.V.nextInt(10) == 0 && var2.a(987234911L).nextInt(10) == 0 && this.t < 40.0D) {
               return super.cf();
            }
         }

         return false;
      }
   }

   protected float bC() {
      return 0.4F * (float)this.cB();
   }

   public int cd() {
      return 0;
   }

   protected boolean cC() {
      return this.cB() > 0;
   }

   protected boolean cA() {
      return this.cB() > 2;
   }

   protected void bG() {
      this.motY = 0.41999998688697815D;
      this.ai = true;
   }

   public class_qd a(class_on var1, class_qd var2) {
      int var3 = this.V.nextInt(3);
      if(var3 < 2 && this.V.nextFloat() < 0.5F * var1.c()) {
         ++var3;
      }

      int var4 = 1 << var3;
      this.a(var4);
      return super.a(var1, var2);
   }

   static class class_c_in_class_wo extends class_rm {
      private class_wo a;

      public class_c_in_class_wo(class_wo var1) {
         this.a = var1;
         this.a(5);
      }

      public boolean a() {
         return true;
      }

      public void e() {
         ((class_wo.class_d_in_class_wo)this.a.r()).a(1.0D);
      }
   }

   static class class_b_in_class_wo extends class_rm {
      private class_wo a;

      public class_b_in_class_wo(class_wo var1) {
         this.a = var1;
         this.a(5);
         ((class_tf)var1.u()).d(true);
      }

      public boolean a() {
         return this.a.V() || this.a.ab();
      }

      public void e() {
         if(this.a.bd().nextFloat() < 0.8F) {
            this.a.t().a();
         }

         ((class_wo.class_d_in_class_wo)this.a.r()).a(1.2D);
      }
   }

   static class class_e_in_class_wo extends class_rm {
      private class_wo a;
      private float b;
      private int c;

      public class_e_in_class_wo(class_wo var1) {
         this.a = var1;
         this.a(2);
      }

      public boolean a() {
         return this.a.w() == null && (this.a.C || this.a.V() || this.a.ab());
      }

      public void e() {
         if(--this.c <= 0) {
            this.c = 40 + this.a.bd().nextInt(60);
            this.b = (float)this.a.bd().nextInt(360);
         }

         ((class_wo.class_d_in_class_wo)this.a.r()).a(this.b, false);
      }
   }

   static class class_a_in_class_wo extends class_rm {
      private class_wo a;
      private int b;

      public class_a_in_class_wo(class_wo var1) {
         this.a = var1;
         this.a(2);
      }

      public boolean a() {
         EntityLiving var1 = this.a.w();
         return var1 == null?false:(!var1.ai()?false:!(var1 instanceof EntityHuman) || !((EntityHuman)var1).bH.invulnerable);
      }

      public void c() {
         this.b = 300;
         super.c();
      }

      public boolean b() {
         EntityLiving var1 = this.a.w();
         return var1 == null?false:(!var1.ai()?false:(var1 instanceof EntityHuman && ((EntityHuman)var1).bH.invulnerable?false:--this.b > 0));
      }

      public void e() {
         this.a.a(this.a.w(), 10.0F, 10.0F);
         ((class_wo.class_d_in_class_wo)this.a.r()).a(this.a.y, this.a.cx());
      }
   }

   static class class_d_in_class_wo extends class_qz {
      private float g;
      private int h;
      private class_wo i;
      private boolean j;

      public class_d_in_class_wo(class_wo var1) {
         super(var1);
         this.i = var1;
      }

      public void a(float var1, boolean var2) {
         this.g = var1;
         this.j = var2;
      }

      public void a(double var1) {
         this.e = var1;
         this.f = true;
      }

      public void c() {
         this.a.y = this.a(this.a.y, this.g, 30.0F);
         this.a.aN = this.a.y;
         this.a.aL = this.a.y;
         if(!this.f) {
            this.a.n(0.0F);
         } else {
            this.f = false;
            if(this.a.C) {
               this.a.k((float)(this.e * this.a.a((class_qk)class_wl.d).e()));
               if(this.h-- <= 0) {
                  this.h = this.i.cv();
                  if(this.j) {
                     this.h /= 3;
                  }

                  this.i.t().a();
                  if(this.i.cC()) {
                     this.i.a(this.i.cz(), this.i.bC(), ((this.i.bd().nextFloat() - this.i.bd().nextFloat()) * 0.2F + 1.0F) * 0.8F);
                  }
               } else {
                  this.i.bc = this.i.bd = 0.0F;
                  this.a.k(0.0F);
               }
            } else {
               this.a.k((float)(this.e * this.a.a((class_qk)class_wl.d).e()));
            }

         }
      }
   }
}
