package net.minecraft.server;

import java.util.List;
import java.util.UUID;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.AxisAlignedBB;
import net.minecraft.server.MovingObjectPosition;
import net.minecraft.server.Vec3D;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumParticle;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.MinecraftKey;
import net.minecraft.server.WorldServer;
import net.minecraft.server.MathHelper;
import net.minecraft.server.Entity;
import net.minecraft.server.EntityLiving;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.IProjectile;

public abstract class class_xo extends Entity implements IProjectile {
   private int d;
   private int e;
   private int f;
   private Block g;
   protected boolean a;
   public int b;
   private EntityLiving h;
   private String i;
   private int as;
   private int at;
   public Entity c;
   private int au;

   public class_xo(World var1) {
      super(var1);
      this.d = -1;
      this.e = -1;
      this.f = -1;
      this.setSize(0.25F, 0.25F);
   }

   public class_xo(World var1, double var2, double var4, double var6) {
      this(var1);
      this.setPosition(var2, var4, var6);
   }

   public class_xo(World var1, EntityLiving var2) {
      this(var1, var2.locX, var2.locY + (double)var2.getHeadHeight() - 0.10000000149011612D, var2.locZ);
      this.h = var2;
   }

   protected void initDatawatcher() {
   }

   public void a(float var1, float var2, float var3, float var4, float var5) {
      float var6 = -MathHelper.sin(var2 * 0.017453292F) * MathHelper.cos(var1 * 0.017453292F);
      float var7 = -MathHelper.sin((var1 + var3) * 0.017453292F);
      float var8 = MathHelper.cos(var2 * 0.017453292F) * MathHelper.cos(var1 * 0.017453292F);
      this.shoot((double)var6, (double)var7, (double)var8, var4, var5);
   }

   public void shoot(double var1, double var3, double var5, float var7, float var8) {
      float var9 = MathHelper.sqrt(var1 * var1 + var3 * var3 + var5 * var5);
      var1 /= (double)var9;
      var3 /= (double)var9;
      var5 /= (double)var9;
      var1 += this.random.nextGaussian() * 0.007499999832361937D * (double)var8;
      var3 += this.random.nextGaussian() * 0.007499999832361937D * (double)var8;
      var5 += this.random.nextGaussian() * 0.007499999832361937D * (double)var8;
      var1 *= (double)var7;
      var3 *= (double)var7;
      var5 *= (double)var7;
      this.motX = var1;
      this.motY = var3;
      this.motZ = var5;
      float var10 = MathHelper.sqrt(var1 * var1 + var5 * var5);
      this.lastYaw = this.yaw = (float)(MathHelper.b(var1, var5) * 180.0D / 3.1415927410125732D);
      this.lastPitch = this.pitch = (float)(MathHelper.b(var3, (double)var10) * 180.0D / 3.1415927410125732D);
      this.as = 0;
   }

   public void t_() {
      this.P = this.locX;
      this.Q = this.locY;
      this.R = this.locZ;
      super.t_();
      if(this.b > 0) {
         --this.b;
      }

      if(this.a) {
         if(this.world.getType(new BlockPosition(this.d, this.e, this.f)).getBlock() == this.g) {
            ++this.as;
            if(this.as == 1200) {
               this.die();
            }

            return;
         }

         this.a = false;
         this.motX *= (double)(this.random.nextFloat() * 0.2F);
         this.motY *= (double)(this.random.nextFloat() * 0.2F);
         this.motZ *= (double)(this.random.nextFloat() * 0.2F);
         this.as = 0;
         this.at = 0;
      } else {
         ++this.at;
      }

      Vec3D var1 = new Vec3D(this.locX, this.locY, this.locZ);
      Vec3D var2 = new Vec3D(this.locX + this.motX, this.locY + this.motY, this.locZ + this.motZ);
      MovingObjectPosition var3 = this.world.a(var1, var2);
      var1 = new Vec3D(this.locX, this.locY, this.locZ);
      var2 = new Vec3D(this.locX + this.motX, this.locY + this.motY, this.locZ + this.motZ);
      if(var3 != null) {
         var2 = new Vec3D(var3.pos.x, var3.pos.y, var3.pos.z);
      }

      if(!this.world.isClientSide) {
         Entity var4 = null;
         List var5 = this.world.getEntities((Entity)this, (AxisAlignedBB)this.getBoundingBox().add(this.motX, this.motY, this.motZ).grow(1.0D, 1.0D, 1.0D));
         double var6 = 0.0D;
         boolean var8 = false;

         for(int var9 = 0; var9 < var5.size(); ++var9) {
            Entity var10 = (Entity)var5.get(var9);
            if(var10.ad()) {
               if(var10 == this.c) {
                  var8 = true;
               } else if(this.ticksLived < 2 && this.c == null) {
                  this.c = var10;
                  var8 = true;
               } else {
                  var8 = false;
                  float var11 = 0.3F;
                  AxisAlignedBB var12 = var10.getBoundingBox().grow((double)var11, (double)var11, (double)var11);
                  MovingObjectPosition var13 = var12.a(var1, var2);
                  if(var13 != null) {
                     double var14 = var1.distanceSquared(var13.pos);
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
            var3 = new MovingObjectPosition(var4);
         }
      }

      if(var3 != null) {
         if(var3.type == MovingObjectPosition.EnumMovingObjectType.BLOCK && this.world.getType(var3.a()).getBlock() == Blocks.PORTAL) {
            this.d(var3.a());
         } else {
            this.a(var3);
         }
      }

      this.locX += this.motX;
      this.locY += this.motY;
      this.locZ += this.motZ;
      float var16 = MathHelper.sqrt(this.motX * this.motX + this.motZ * this.motZ);
      this.yaw = (float)(MathHelper.b(this.motX, this.motZ) * 180.0D / 3.1415927410125732D);

      for(this.pitch = (float)(MathHelper.b(this.motY, (double)var16) * 180.0D / 3.1415927410125732D); this.pitch - this.lastPitch < -180.0F; this.lastPitch -= 360.0F) {
         ;
      }

      while(this.pitch - this.lastPitch >= 180.0F) {
         this.lastPitch += 360.0F;
      }

      while(this.yaw - this.lastYaw < -180.0F) {
         this.lastYaw -= 360.0F;
      }

      while(this.yaw - this.lastYaw >= 180.0F) {
         this.lastYaw += 360.0F;
      }

      this.pitch = this.lastPitch + (this.pitch - this.lastPitch) * 0.2F;
      this.yaw = this.lastYaw + (this.yaw - this.lastYaw) * 0.2F;
      float var17 = 0.99F;
      float var18 = this.j();
      if(this.V()) {
         for(int var7 = 0; var7 < 4; ++var7) {
            float var19 = 0.25F;
            this.world.addParticle(EnumParticle.e, this.locX - this.motX * (double)var19, this.locY - this.motY * (double)var19, this.locZ - this.motZ * (double)var19, this.motX, this.motY, this.motZ, new int[0]);
         }

         var17 = 0.8F;
      }

      this.motX *= (double)var17;
      this.motY *= (double)var17;
      this.motZ *= (double)var17;
      this.motY -= (double)var18;
      this.setPosition(this.locX, this.locY, this.locZ);
   }

   protected float j() {
      return 0.03F;
   }

   protected abstract void a(MovingObjectPosition var1);

   public void write(NBTTagCompound var1) {
      var1.put("xTile", (short)this.d);
      var1.put("yTile", (short)this.e);
      var1.put("zTile", (short)this.f);
      MinecraftKey var2 = (MinecraftKey)Block.BLOCK_REGISTRY.getKey(this.g);
      var1.put("inTile", var2 == null?"":var2.toString());
      var1.put("shake", (byte)this.b);
      var1.put("inGround", (byte)(this.a?1:0));
      if((this.i == null || this.i.isEmpty()) && this.h instanceof EntityHuman) {
         this.i = this.h.getName();
      }

      var1.put("ownerName", this.i == null?"":this.i);
   }

   public void read(NBTTagCompound var1) {
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

   public EntityLiving l() {
      if(this.h == null && this.i != null && !this.i.isEmpty()) {
         this.h = this.world.a(this.i);
         if(this.h == null && this.world instanceof WorldServer) {
            try {
               Entity var1 = ((WorldServer)this.world).getEntityByUUID(UUID.fromString(this.i));
               if(var1 instanceof EntityLiving) {
                  this.h = (EntityLiving)var1;
               }
            } catch (Throwable var2) {
               this.h = null;
            }
         }
      }

      return this.h;
   }
}
