package net.minecraft.server;

import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.MovingObjectPosition;
import net.minecraft.server.Vec3D;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_cy;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.NBTTagList;
import net.minecraft.server.NBTTag;
import net.minecraft.server.MinecraftKey;
import net.minecraft.server.MathHelper;
import net.minecraft.server.class_pc;
import net.minecraft.server.Entity;
import net.minecraft.server.EntityLiving;
import net.minecraft.server.class_xj;

public abstract class class_xf extends Entity {
   private int e = -1;
   private int f = -1;
   private int g = -1;
   private Block h;
   private boolean i;
   public EntityLiving a;
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
      double var14 = (double)MathHelper.sqrt(var8 * var8 + var10 * var10 + var12 * var12);
      this.b = var8 / var14 * 0.1D;
      this.c = var10 / var14 * 0.1D;
      this.d = var12 / var14 * 0.1D;
   }

   public class_xf(World var1, EntityLiving var2, double var3, double var5, double var7) {
      super(var1);
      this.a = var2;
      this.a(1.0F, 1.0F);
      this.b(var2.s, var2.t, var2.u, var2.y, var2.z);
      this.b(this.s, this.t, this.u);
      this.v = this.motY = this.x = 0.0D;
      var3 += this.random.nextGaussian() * 0.4D;
      var5 += this.random.nextGaussian() * 0.4D;
      var7 += this.random.nextGaussian() * 0.4D;
      double var9 = (double)MathHelper.sqrt(var3 * var3 + var5 * var5 + var7 * var7);
      this.b = var3 / var9 * 0.1D;
      this.c = var5 / var9 * 0.1D;
      this.d = var7 / var9 * 0.1D;
   }

   public void t_() {
      if(this.o.isClientSide || (this.a == null || !this.a.I) && this.o.e(new BlockPosition(this))) {
         super.t_();
         this.f(1);
         if(this.i) {
            if(this.o.getType(new BlockPosition(this.e, this.f, this.g)).getBlock() == this.h) {
               ++this.as;
               if(this.as == 600) {
                  this.J();
               }

               return;
            }

            this.i = false;
            this.v *= (double)(this.random.nextFloat() * 0.2F);
            this.motY *= (double)(this.random.nextFloat() * 0.2F);
            this.x *= (double)(this.random.nextFloat() * 0.2F);
            this.as = 0;
            this.at = 0;
         } else {
            ++this.at;
         }

         MovingObjectPosition var1 = class_xj.a(this, true, this.at >= 25, this.a);
         if(var1 != null) {
            this.a(var1);
         }

         this.s += this.v;
         this.t += this.motY;
         this.u += this.x;
         class_xj.a(this, 0.2F);
         float var2 = this.j();
         if(this.V()) {
            for(int var3 = 0; var3 < 4; ++var3) {
               float var4 = 0.25F;
               this.o.a(class_cy.e, this.s - this.v * (double)var4, this.t - this.motY * (double)var4, this.u - this.x * (double)var4, this.v, this.motY, this.x, new int[0]);
            }

            var2 = 0.8F;
         }

         this.v += this.b;
         this.motY += this.c;
         this.x += this.d;
         this.v *= (double)var2;
         this.motY *= (double)var2;
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

   protected abstract void a(MovingObjectPosition var1);

   public void write(NBTTagCompound var1) {
      var1.put("xTile", (short)this.e);
      var1.put("yTile", (short)this.f);
      var1.put("zTile", (short)this.g);
      MinecraftKey var2 = (MinecraftKey)Block.BLOCK_REGISTRY.getKey(this.h);
      var1.put("inTile", var2 == null?"":var2.toString());
      var1.put("inGround", (byte)(this.i?1:0));
      var1.put((String)"direction", (NBTTag)this.a((double[])(new double[]{this.v, this.motY, this.x})));
   }

   public void read(NBTTagCompound var1) {
      this.e = var1.getShort("xTile");
      this.f = var1.getShort("yTile");
      this.g = var1.getShort("zTile");
      if(var1.hasOfType("inTile", 8)) {
         this.h = Block.getByName(var1.getString("inTile"));
      } else {
         this.h = Block.getById(var1.getByte("inTile") & 255);
      }

      this.i = var1.getByte("inGround") == 1;
      if(var1.hasOfType("direction", 9)) {
         NBTTagList var2 = var1.getList("direction", 6);
         this.v = var2.getDouble(0);
         this.motY = var2.getDouble(1);
         this.x = var2.getDouble(2);
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

   public boolean damageEntity(class_pc var1, float var2) {
      if(this.b(var1)) {
         return false;
      } else {
         this.ac();
         if(var1.j() != null) {
            Vec3D var3 = var1.j().ap();
            if(var3 != null) {
               this.v = var3.x;
               this.motY = var3.y;
               this.x = var3.z;
               this.b = this.v * 0.1D;
               this.c = this.motY * 0.1D;
               this.d = this.x * 0.1D;
            }

            if(var1.j() instanceof EntityLiving) {
               this.a = (EntityLiving)var1.j();
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
