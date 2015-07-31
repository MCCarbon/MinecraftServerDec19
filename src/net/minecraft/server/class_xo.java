package net.minecraft.server;

import java.util.List;
import java.util.UUID;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_awg;
import net.minecraft.server.Vec3D;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_cy;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.MinecraftKey;
import net.minecraft.server.class_lg;
import net.minecraft.server.MathHelper;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xi;

public abstract class class_xo extends class_pr implements class_xi {
   private int d;
   private int e;
   private int f;
   private Block g;
   protected boolean a;
   public int b;
   private class_qa h;
   private String i;
   private int as;
   private int at;
   public class_pr c;
   private int au;

   public class_xo(World var1) {
      super(var1);
      this.d = -1;
      this.e = -1;
      this.f = -1;
      this.a(0.25F, 0.25F);
   }

   public class_xo(World var1, double var2, double var4, double var6) {
      this(var1);
      this.b(var2, var4, var6);
   }

   public class_xo(World var1, class_qa var2) {
      this(var1, var2.s, var2.t + (double)var2.aU() - 0.10000000149011612D, var2.u);
      this.h = var2;
   }

   protected void h() {
   }

   public void a(float var1, float var2, float var3, float var4, float var5) {
      float var6 = -MathHelper.sin(var2 * 0.017453292F) * MathHelper.cos(var1 * 0.017453292F);
      float var7 = -MathHelper.sin((var1 + var3) * 0.017453292F);
      float var8 = MathHelper.cos(var2 * 0.017453292F) * MathHelper.cos(var1 * 0.017453292F);
      this.c((double)var6, (double)var7, (double)var8, var4, var5);
   }

   public void c(double var1, double var3, double var5, float var7, float var8) {
      float var9 = MathHelper.sqrt(var1 * var1 + var3 * var3 + var5 * var5);
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
      float var10 = MathHelper.sqrt(var1 * var1 + var5 * var5);
      this.A = this.y = (float)(MathHelper.b(var1, var5) * 180.0D / 3.1415927410125732D);
      this.B = this.z = (float)(MathHelper.b(var3, (double)var10) * 180.0D / 3.1415927410125732D);
      this.as = 0;
   }

   public void t_() {
      this.P = this.s;
      this.Q = this.t;
      this.R = this.u;
      super.t_();
      if(this.b > 0) {
         --this.b;
      }

      if(this.a) {
         if(this.o.p(new BlockPosition(this.d, this.e, this.f)).getBlock() == this.g) {
            ++this.as;
            if(this.as == 1200) {
               this.J();
            }

            return;
         }

         this.a = false;
         this.v *= (double)(this.V.nextFloat() * 0.2F);
         this.w *= (double)(this.V.nextFloat() * 0.2F);
         this.x *= (double)(this.V.nextFloat() * 0.2F);
         this.as = 0;
         this.at = 0;
      } else {
         ++this.at;
      }

      Vec3D var1 = new Vec3D(this.s, this.t, this.u);
      Vec3D var2 = new Vec3D(this.s + this.v, this.t + this.w, this.u + this.x);
      class_awg var3 = this.o.a(var1, var2);
      var1 = new Vec3D(this.s, this.t, this.u);
      var2 = new Vec3D(this.s + this.v, this.t + this.w, this.u + this.x);
      if(var3 != null) {
         var2 = new Vec3D(var3.c.x, var3.c.y, var3.c.z);
      }

      if(!this.o.D) {
         class_pr var4 = null;
         List var5 = this.o.b((class_pr)this, (class_awf)this.aT().a(this.v, this.w, this.x).b(1.0D, 1.0D, 1.0D));
         double var6 = 0.0D;
         boolean var8 = false;

         for(int var9 = 0; var9 < var5.size(); ++var9) {
            class_pr var10 = (class_pr)var5.get(var9);
            if(var10.ad()) {
               if(var10 == this.c) {
                  var8 = true;
               } else if(this.W < 2 && this.c == null) {
                  this.c = var10;
                  var8 = true;
               } else {
                  var8 = false;
                  float var11 = 0.3F;
                  class_awf var12 = var10.aT().b((double)var11, (double)var11, (double)var11);
                  class_awg var13 = var12.a(var1, var2);
                  if(var13 != null) {
                     double var14 = var1.distanceSquared(var13.c);
                     if(var14 < var6 || var6 == 0.0D) {
                        var4 = var10;
                        var6 = var14;
                     }
                  }
               }
            }
         }

         if(this.c != null) {
            if(var8) {
               this.au = 2;
            } else if(this.au-- <= 0) {
               this.c = null;
            }
         }

         if(var4 != null) {
            var3 = new class_awg(var4);
         }
      }

      if(var3 != null) {
         if(var3.a == class_awg.class_a_in_class_awg.b && this.o.p(var3.a()).getBlock() == Blocks.PORTAL) {
            this.d(var3.a());
         } else {
            this.a(var3);
         }
      }

      this.s += this.v;
      this.t += this.w;
      this.u += this.x;
      float var16 = MathHelper.sqrt(this.v * this.v + this.x * this.x);
      this.y = (float)(MathHelper.b(this.v, this.x) * 180.0D / 3.1415927410125732D);

      for(this.z = (float)(MathHelper.b(this.w, (double)var16) * 180.0D / 3.1415927410125732D); this.z - this.B < -180.0F; this.B -= 360.0F) {
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
      float var17 = 0.99F;
      float var18 = this.j();
      if(this.V()) {
         for(int var7 = 0; var7 < 4; ++var7) {
            float var19 = 0.25F;
            this.o.a(class_cy.e, this.s - this.v * (double)var19, this.t - this.w * (double)var19, this.u - this.x * (double)var19, this.v, this.w, this.x, new int[0]);
         }

         var17 = 0.8F;
      }

      this.v *= (double)var17;
      this.w *= (double)var17;
      this.x *= (double)var17;
      this.w -= (double)var18;
      this.b(this.s, this.t, this.u);
   }

   protected float j() {
      return 0.03F;
   }

   protected abstract void a(class_awg var1);

   public void b(NBTTagCompound var1) {
      var1.put("xTile", (short)this.d);
      var1.put("yTile", (short)this.e);
      var1.put("zTile", (short)this.f);
      MinecraftKey var2 = (MinecraftKey)Block.BLOCK_REGISTRY.getKey(this.g);
      var1.put("inTile", var2 == null?"":var2.toString());
      var1.put("shake", (byte)this.b);
      var1.put("inGround", (byte)(this.a?1:0));
      if((this.i == null || this.i.isEmpty()) && this.h instanceof class_xa) {
         this.i = this.h.e_();
      }

      var1.put("ownerName", this.i == null?"":this.i);
   }

   public void a(NBTTagCompound var1) {
      this.d = var1.getShort("xTile");
      this.e = var1.getShort("yTile");
      this.f = var1.getShort("zTile");
      if(var1.hasOfType("inTile", 8)) {
         this.g = Block.getByName(var1.getString("inTile"));
      } else {
         this.g = Block.getById(var1.getByte("inTile") & 255);
      }

      this.b = var1.getByte("shake") & 255;
      this.a = var1.getByte("inGround") == 1;
      this.h = null;
      this.i = var1.getString("ownerName");
      if(this.i != null && this.i.isEmpty()) {
         this.i = null;
      }

      this.h = this.l();
   }

   public class_qa l() {
      if(this.h == null && this.i != null && !this.i.isEmpty()) {
         this.h = this.o.a(this.i);
         if(this.h == null && this.o instanceof class_lg) {
            try {
               class_pr var1 = ((class_lg)this.o).a(UUID.fromString(this.i));
               if(var1 instanceof class_qa) {
                  this.h = (class_qa)var1;
               }
            } catch (Throwable var2) {
               this.h = null;
            }
         }
      }

      return this.h;
   }
}
