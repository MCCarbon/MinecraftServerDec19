package net.minecraft.server;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class class_ve extends Entity {
   private static final List d;
   private static final List e;
   private static final List f;
   private int g = -1;
   private int h = -1;
   private int i = -1;
   private Block as;
   private boolean at;
   public int a;
   public EntityHuman b;
   private int au;
   private int av;
   private int aw;
   private int ax;
   private int ay;
   private float az;
   public Entity c;
   private int aA;
   private double aB;
   private double aC;
   private double aD;
   private double aE;
   private double aF;

   public static List j() {
      return f;
   }

   public class_ve(World var1) {
      super(var1);
      this.a(0.25F, 0.25F);
      this.ah = true;
   }

   public class_ve(World var1, EntityHuman var2) {
      super(var1);
      this.ah = true;
      this.b = var2;
      this.b.bN = this;
      this.a(0.25F, 0.25F);
      this.b(var2.locX, var2.locY + (double)var2.getHeadHeight(), var2.locZ, var2.yaw, var2.pitch);
      this.locX -= (double)(MathHelper.cos(this.yaw / 180.0F * 3.1415927F) * 0.16F);
      this.locY -= 0.10000000149011612D;
      this.locZ -= (double)(MathHelper.sin(this.yaw / 180.0F * 3.1415927F) * 0.16F);
      this.b(this.locX, this.locY, this.locZ);
      float var3 = 0.4F;
      this.motX = (double)(-MathHelper.sin(this.yaw / 180.0F * 3.1415927F) * MathHelper.cos(this.pitch / 180.0F * 3.1415927F) * var3);
      this.motZ = (double)(MathHelper.cos(this.yaw / 180.0F * 3.1415927F) * MathHelper.cos(this.pitch / 180.0F * 3.1415927F) * var3);
      this.motY = (double)(-MathHelper.sin(this.pitch / 180.0F * 3.1415927F) * var3);
      this.c(this.motX, this.motY, this.motZ, 1.5F, 1.0F);
   }

   protected void initDatawatcher() {
   }

   public void c(double var1, double var3, double var5, float var7, float var8) {
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
      this.au = 0;
   }

   public void t_() {
      super.t_();
      if(this.aA > 0) {
         double var29 = this.locX + (this.aB - this.locX) / (double)this.aA;
         double var30 = this.locY + (this.aC - this.locY) / (double)this.aA;
         double var31 = this.locZ + (this.aD - this.locZ) / (double)this.aA;
         double var7 = MathHelper.clampAngle(this.aE - (double)this.yaw);
         this.yaw = (float)((double)this.yaw + var7 / (double)this.aA);
         this.pitch = (float)((double)this.pitch + (this.aF - (double)this.pitch) / (double)this.aA);
         --this.aA;
         this.b(var29, var30, var31);
         this.b(this.yaw, this.pitch);
      } else {
         if(!this.world.isClientSide) {
            ItemStack var1 = this.b.bA();
            if(this.b.dead || !this.b.isAlive() || var1 == null || var1.getItem() != Items.FISHING_ROD || this.h(this.b) > 1024.0D) {
               this.J();
               this.b.bN = null;
               return;
            }

            if(this.c != null) {
               if(!this.c.dead) {
                  this.locX = this.c.locX;
                  double var10002 = (double)this.c.length;
                  this.locY = this.c.getBoundingBox().yMin + var10002 * 0.8D;
                  this.locZ = this.c.locZ;
                  return;
               }

               this.c = null;
            }
         }

         if(this.a > 0) {
            --this.a;
         }

         if(this.at) {
            if(this.world.getType(new BlockPosition(this.g, this.h, this.i)).getBlock() == this.as) {
               ++this.au;
               if(this.au == 1200) {
                  this.J();
               }

               return;
            }

            this.at = false;
            this.motX *= (double)(this.random.nextFloat() * 0.2F);
            this.motY *= (double)(this.random.nextFloat() * 0.2F);
            this.motZ *= (double)(this.random.nextFloat() * 0.2F);
            this.au = 0;
            this.av = 0;
         } else {
            ++this.av;
         }

         Vec3D var28 = new Vec3D(this.locX, this.locY, this.locZ);
         Vec3D var2 = new Vec3D(this.locX + this.motX, this.locY + this.motY, this.locZ + this.motZ);
         MovingObjectPosition var3 = this.world.a(var28, var2);
         var28 = new Vec3D(this.locX, this.locY, this.locZ);
         var2 = new Vec3D(this.locX + this.motX, this.locY + this.motY, this.locZ + this.motZ);
         if(var3 != null) {
            var2 = new Vec3D(var3.c.x, var3.c.y, var3.c.z);
         }

         Entity var4 = null;
         List var5 = this.world.getEntities((Entity)this, (AxisAlignedBB)this.getBoundingBox().add(this.motX, this.motY, this.motZ).grow(1.0D, 1.0D, 1.0D));
         double var6 = 0.0D;

         double var13;
         for(int var8 = 0; var8 < var5.size(); ++var8) {
            Entity var9 = (Entity)var5.get(var8);
            if(var9.ad() && (var9 != this.b || this.av >= 5)) {
               float var10 = 0.3F;
               AxisAlignedBB var11 = var9.getBoundingBox().grow((double)var10, (double)var10, (double)var10);
               MovingObjectPosition var12 = var11.a(var28, var2);
               if(var12 != null) {
                  var13 = var28.distanceSquared(var12.c);
                  if(var13 < var6 || var6 == 0.0D) {
                     var4 = var9;
                     var6 = var13;
                  }
               }
            }
         }

         if(var4 != null) {
            var3 = new MovingObjectPosition(var4);
         }

         if(var3 != null) {
            if(var3.d != null) {
               if(var3.d.damageEntity(DamageSource.a((Entity) this, (Entity) this.b), 0.0F)) {
                  this.c = var3.d;
               }
            } else {
               this.at = true;
            }
         }

         if(!this.at) {
            this.d(this.motX, this.motY, this.motZ);
            float var32 = MathHelper.sqrt(this.motX * this.motX + this.motZ * this.motZ);
            this.yaw = (float)(MathHelper.b(this.motX, this.motZ) * 180.0D / 3.1415927410125732D);

            for(this.pitch = (float)(MathHelper.b(this.motY, (double)var32) * 180.0D / 3.1415927410125732D); this.pitch - this.lastPitch < -180.0F; this.lastPitch -= 360.0F) {
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
            float var33 = 0.92F;
            if(this.onGround || this.positionChanged) {
               var33 = 0.5F;
            }

            byte var34 = 5;
            double var35 = 0.0D;

            double var19;
            for(int var36 = 0; var36 < var34; ++var36) {
               AxisAlignedBB var14 = this.getBoundingBox();
               double var15 = var14.yMax - var14.yMin;
               double var17 = var14.yMin + var15 * (double)var36 / (double)var34;
               var19 = var14.yMin + var15 * (double)(var36 + 1) / (double)var34;
               AxisAlignedBB var21 = new AxisAlignedBB(var14.xMin, var17, var14.zMin, var14.xMax, var19, var14.zMax);
               if(this.world.b(var21, Material.WATER)) {
                  var35 += 1.0D / (double)var34;
               }
            }

            if(!this.world.isClientSide && var35 > 0.0D) {
               WorldServer var37 = (WorldServer)this.world;
               int var38 = 1;
               BlockPosition var39 = (new BlockPosition(this)).up();
               if(this.random.nextFloat() < 0.25F && this.world.C(var39)) {
                  var38 = 2;
               }

               if(this.random.nextFloat() < 0.5F && !this.world.i(var39)) {
                  --var38;
               }

               if(this.aw > 0) {
                  --this.aw;
                  if(this.aw <= 0) {
                     this.ax = 0;
                     this.ay = 0;
                  }
               } else {
                  float var16;
                  float var18;
                  double var23;
                  Block var25;
                  float var40;
                  double var41;
                  if(this.ay > 0) {
                     this.ay -= var38;
                     if(this.ay <= 0) {
                        this.motY -= 0.20000000298023224D;
                        this.makeSound("random.splash", 0.25F, 1.0F + (this.random.nextFloat() - this.random.nextFloat()) * 0.4F);
                        var16 = (float)MathHelper.floor(this.getBoundingBox().yMin);
                        var37.a(EnumParticle.e, this.locX, (double)(var16 + 1.0F), this.locZ, (int)(1.0F + this.width * 20.0F), (double)this.width, 0.0D, (double)this.width, 0.20000000298023224D, new int[0]);
                        var37.a(EnumParticle.g, this.locX, (double)(var16 + 1.0F), this.locZ, (int)(1.0F + this.width * 20.0F), (double)this.width, 0.0D, (double)this.width, 0.20000000298023224D, new int[0]);
                        this.aw = MathHelper.getRandomIntInRange((Random)this.random, 10, 30);
                     } else {
                        this.az = (float)((double)this.az + this.random.nextGaussian() * 4.0D);
                        var16 = this.az * 0.017453292F;
                        var40 = MathHelper.sin(var16);
                        var18 = MathHelper.cos(var16);
                        var19 = this.locX + (double)(var40 * (float)this.ay * 0.1F);
                        var41 = (double)((float)MathHelper.floor(this.getBoundingBox().yMin) + 1.0F);
                        var23 = this.locZ + (double)(var18 * (float)this.ay * 0.1F);
                        var25 = var37.getType(new BlockPosition((int)var19, (int)var41 - 1, (int)var23)).getBlock();
                        if(var25 == Blocks.WATER || var25 == Blocks.FLOWING_WATER) {
                           if(this.random.nextFloat() < 0.15F) {
                              var37.a(EnumParticle.e, var19, var41 - 0.10000000149011612D, var23, 1, (double)var40, 0.1D, (double)var18, 0.0D, new int[0]);
                           }

                           float var26 = var40 * 0.04F;
                           float var27 = var18 * 0.04F;
                           var37.a(EnumParticle.g, var19, var41, var23, 0, (double)var27, 0.01D, (double)(-var26), 1.0D, new int[0]);
                           var37.a(EnumParticle.g, var19, var41, var23, 0, (double)(-var27), 0.01D, (double)var26, 1.0D, new int[0]);
                        }
                     }
                  } else if(this.ax > 0) {
                     this.ax -= var38;
                     var16 = 0.15F;
                     if(this.ax < 20) {
                        var16 = (float)((double)var16 + (double)(20 - this.ax) * 0.05D);
                     } else if(this.ax < 40) {
                        var16 = (float)((double)var16 + (double)(40 - this.ax) * 0.02D);
                     } else if(this.ax < 60) {
                        var16 = (float)((double)var16 + (double)(60 - this.ax) * 0.01D);
                     }

                     if(this.random.nextFloat() < var16) {
                        var40 = MathHelper.getRandomFloatInRange(this.random, 0.0F, 360.0F) * 0.017453292F;
                        var18 = MathHelper.getRandomFloatInRange(this.random, 25.0F, 60.0F);
                        var19 = this.locX + (double)(MathHelper.sin(var40) * var18 * 0.1F);
                        var41 = (double)((float)MathHelper.floor(this.getBoundingBox().yMin) + 1.0F);
                        var23 = this.locZ + (double)(MathHelper.cos(var40) * var18 * 0.1F);
                        var25 = var37.getType(new BlockPosition((int)var19, (int)var41 - 1, (int)var23)).getBlock();
                        if(var25 == Blocks.WATER || var25 == Blocks.FLOWING_WATER) {
                           var37.a(EnumParticle.f, var19, var41, var23, 2 + this.random.nextInt(2), 0.10000000149011612D, 0.0D, 0.10000000149011612D, 0.0D, new int[0]);
                        }
                     }

                     if(this.ax <= 0) {
                        this.az = MathHelper.getRandomFloatInRange(this.random, 0.0F, 360.0F);
                        this.ay = MathHelper.getRandomIntInRange((Random)this.random, 20, 80);
                     }
                  } else {
                     this.ax = MathHelper.getRandomIntInRange((Random)this.random, 100, 900);
                     this.ax -= EnchantmentManager.g(this.b) * 20 * 5;
                  }
               }

               if(this.aw > 0) {
                  this.motY -= (double)(this.random.nextFloat() * this.random.nextFloat() * this.random.nextFloat()) * 0.2D;
               }
            }

            var13 = var35 * 2.0D - 1.0D;
            this.motY += 0.03999999910593033D * var13;
            if(var35 > 0.0D) {
               var33 = (float)((double)var33 * 0.9D);
               this.motY *= 0.8D;
            }

            this.motX *= (double)var33;
            this.motY *= (double)var33;
            this.motZ *= (double)var33;
            this.b(this.locX, this.locY, this.locZ);
         }
      }
   }

   public void write(NBTTagCompound var1) {
      var1.put("xTile", (short)this.g);
      var1.put("yTile", (short)this.h);
      var1.put("zTile", (short)this.i);
      MinecraftKey var2 = (MinecraftKey)Block.BLOCK_REGISTRY.getKey(this.as);
      var1.put("inTile", var2 == null?"":var2.toString());
      var1.put("shake", (byte)this.a);
      var1.put("inGround", (byte)(this.at?1:0));
   }

   public void read(NBTTagCompound var1) {
      this.g = var1.getShort("xTile");
      this.h = var1.getShort("yTile");
      this.i = var1.getShort("zTile");
      if(var1.hasOfType("inTile", 8)) {
         this.as = Block.getByName(var1.getString("inTile"));
      } else {
         this.as = Block.getById(var1.getByte("inTile") & 255);
      }

      this.a = var1.getByte("shake") & 255;
      this.at = var1.getByte("inGround") == 1;
   }

   public int l() {
      if(this.world.isClientSide) {
         return 0;
      } else {
         byte var1 = 0;
         if(this.c != null) {
            double var2 = this.b.locX - this.locX;
            double var4 = this.b.locY - this.locY;
            double var6 = this.b.locZ - this.locZ;
            double var8 = (double)MathHelper.sqrt(var2 * var2 + var4 * var4 + var6 * var6);
            double var10 = 0.1D;
            this.c.motX += var2 * var10;
            this.c.motY += var4 * var10 + (double)MathHelper.sqrt(var8) * 0.08D;
            this.c.motZ += var6 * var10;
            var1 = 3;
         } else if(this.aw > 0) {
            EntityItem var13 = new EntityItem(this.world, this.locX, this.locY, this.locZ, this.m());
            double var3 = this.b.locX - this.locX;
            double var5 = this.b.locY - this.locY;
            double var7 = this.b.locZ - this.locZ;
            double var9 = (double)MathHelper.sqrt(var3 * var3 + var5 * var5 + var7 * var7);
            double var11 = 0.1D;
            var13.motX = var3 * var11;
            var13.motY = var5 * var11 + (double)MathHelper.sqrt(var9) * 0.08D;
            var13.motZ = var7 * var11;
            this.world.addEntity((Entity)var13);
            this.b.world.addEntity((Entity)(new EntityExperienceOrb(this.b.world, this.b.locX, this.b.locY + 0.5D, this.b.locZ + 0.5D, this.random.nextInt(6) + 1)));
            var1 = 1;
         }

         if(this.at) {
            var1 = 2;
         }

         this.J();
         this.b.bN = null;
         return var1;
      }
   }

   private ItemStack m() {
      float var1 = this.world.random.nextFloat();
      int var2 = EnchantmentManager.f(this.b);
      int var3 = EnchantmentManager.g(this.b);
      float var4 = 0.1F - (float)var2 * 0.025F - (float)var3 * 0.01F;
      float var5 = 0.05F + (float)var2 * 0.01F - (float)var3 * 0.01F;
      var4 = MathHelper.clamp(var4, 0.0F, 1.0F);
      var5 = MathHelper.clamp(var5, 0.0F, 1.0F);
      if(var1 < var4) {
         this.b.b(StatisticList.D);
         return ((class_vf)class_oc.a(this.random, d)).a(this.random);
      } else {
         var1 -= var4;
         if(var1 < var5) {
            this.b.b(StatisticList.E);
            return ((class_vf)class_oc.a(this.random, e)).a(this.random);
         } else {
            float var10000 = var1 - var5;
            this.b.b(StatisticList.C);
            return ((class_vf)class_oc.a(this.random, f)).a(this.random);
         }
      }
   }

   public void J() {
      super.J();
      if(this.b != null) {
         this.b.bN = null;
      }

   }

   static {
      d = Arrays.asList(new class_vf[]{(new class_vf(new ItemStack(Items.LEATHER_BOOTS), 10)).a(0.9F), new class_vf(new ItemStack(Items.LEATHER), 10), new class_vf(new ItemStack(Items.BONE), 10), new class_vf(new ItemStack(Items.POTION), 10), new class_vf(new ItemStack(Items.STRING), 5), (new class_vf(new ItemStack(Items.FISHING_ROD), 2)).a(0.9F), new class_vf(new ItemStack(Items.BOWL), 10), new class_vf(new ItemStack(Items.STICK), 5), new class_vf(new ItemStack(Items.DYE, 10, EnumColor.p.b()), 1), new class_vf(new ItemStack(Blocks.TRIPWIRE_HOOK), 10), new class_vf(new ItemStack(Items.ROTTEN_FLESH), 10)});
      e = Arrays.asList(new class_vf[]{new class_vf(new ItemStack(Blocks.WATERLILY), 1), new class_vf(new ItemStack(Items.NAME_TAG), 1), new class_vf(new ItemStack(Items.SADDLE), 1), (new class_vf(new ItemStack(Items.BOW), 1)).a(0.25F).a(), (new class_vf(new ItemStack(Items.FISHING_ROD), 1)).a(0.25F).a(), (new class_vf(new ItemStack(Items.BOOK), 1)).a()});
      f = Arrays.asList(new class_vf[]{new class_vf(new ItemStack(Items.FISH, 1, ItemFish.class_a_in_class_aak.a.a()), 60), new class_vf(new ItemStack(Items.FISH, 1, ItemFish.class_a_in_class_aak.b.a()), 25), new class_vf(new ItemStack(Items.FISH, 1, ItemFish.class_a_in_class_aak.c.a()), 2), new class_vf(new ItemStack(Items.FISH, 1, ItemFish.class_a_in_class_aak.d.a()), 13)});
   }
}
