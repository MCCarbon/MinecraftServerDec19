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
      this.b(var2.s, var2.t + (double)var2.aU(), var2.u, var2.y, var2.z);
      this.s -= (double)(MathHelper.cos(this.y / 180.0F * 3.1415927F) * 0.16F);
      this.t -= 0.10000000149011612D;
      this.u -= (double)(MathHelper.sin(this.y / 180.0F * 3.1415927F) * 0.16F);
      this.b(this.s, this.t, this.u);
      float var3 = 0.4F;
      this.v = (double)(-MathHelper.sin(this.y / 180.0F * 3.1415927F) * MathHelper.cos(this.z / 180.0F * 3.1415927F) * var3);
      this.x = (double)(MathHelper.cos(this.y / 180.0F * 3.1415927F) * MathHelper.cos(this.z / 180.0F * 3.1415927F) * var3);
      this.motY = (double)(-MathHelper.sin(this.z / 180.0F * 3.1415927F) * var3);
      this.c(this.v, this.motY, this.x, 1.5F, 1.0F);
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
      this.v = var1;
      this.motY = var3;
      this.x = var5;
      float var10 = MathHelper.sqrt(var1 * var1 + var5 * var5);
      this.A = this.y = (float)(MathHelper.b(var1, var5) * 180.0D / 3.1415927410125732D);
      this.B = this.z = (float)(MathHelper.b(var3, (double)var10) * 180.0D / 3.1415927410125732D);
      this.au = 0;
   }

   public void t_() {
      super.t_();
      if(this.aA > 0) {
         double var29 = this.s + (this.aB - this.s) / (double)this.aA;
         double var30 = this.t + (this.aC - this.t) / (double)this.aA;
         double var31 = this.u + (this.aD - this.u) / (double)this.aA;
         double var7 = MathHelper.clampAngle(this.aE - (double)this.y);
         this.y = (float)((double)this.y + var7 / (double)this.aA);
         this.z = (float)((double)this.z + (this.aF - (double)this.z) / (double)this.aA);
         --this.aA;
         this.b(var29, var30, var31);
         this.b(this.y, this.z);
      } else {
         if(!this.o.isClientSide) {
            ItemStack var1 = this.b.bA();
            if(this.b.I || !this.b.isAlive() || var1 == null || var1.getItem() != Items.FISHING_ROD || this.h(this.b) > 1024.0D) {
               this.J();
               this.b.bN = null;
               return;
            }

            if(this.c != null) {
               if(!this.c.I) {
                  this.s = this.c.s;
                  double var10002 = (double)this.c.K;
                  this.t = this.c.aT().yMin + var10002 * 0.8D;
                  this.u = this.c.u;
                  return;
               }

               this.c = null;
            }
         }

         if(this.a > 0) {
            --this.a;
         }

         if(this.at) {
            if(this.o.getType(new BlockPosition(this.g, this.h, this.i)).getBlock() == this.as) {
               ++this.au;
               if(this.au == 1200) {
                  this.J();
               }

               return;
            }

            this.at = false;
            this.v *= (double)(this.random.nextFloat() * 0.2F);
            this.motY *= (double)(this.random.nextFloat() * 0.2F);
            this.x *= (double)(this.random.nextFloat() * 0.2F);
            this.au = 0;
            this.av = 0;
         } else {
            ++this.av;
         }

         Vec3D var28 = new Vec3D(this.s, this.t, this.u);
         Vec3D var2 = new Vec3D(this.s + this.v, this.t + this.motY, this.u + this.x);
         MovingObjectPosition var3 = this.o.a(var28, var2);
         var28 = new Vec3D(this.s, this.t, this.u);
         var2 = new Vec3D(this.s + this.v, this.t + this.motY, this.u + this.x);
         if(var3 != null) {
            var2 = new Vec3D(var3.c.x, var3.c.y, var3.c.z);
         }

         Entity var4 = null;
         List var5 = this.o.getEntities((Entity)this, (AxisAlignedBB)this.aT().add(this.v, this.motY, this.x).grow(1.0D, 1.0D, 1.0D));
         double var6 = 0.0D;

         double var13;
         for(int var8 = 0; var8 < var5.size(); ++var8) {
            Entity var9 = (Entity)var5.get(var8);
            if(var9.ad() && (var9 != this.b || this.av >= 5)) {
               float var10 = 0.3F;
               AxisAlignedBB var11 = var9.aT().grow((double)var10, (double)var10, (double)var10);
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
            this.d(this.v, this.motY, this.x);
            float var32 = MathHelper.sqrt(this.v * this.v + this.x * this.x);
            this.y = (float)(MathHelper.b(this.v, this.x) * 180.0D / 3.1415927410125732D);

            for(this.z = (float)(MathHelper.b(this.motY, (double)var32) * 180.0D / 3.1415927410125732D); this.z - this.B < -180.0F; this.B -= 360.0F) {
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
            float var33 = 0.92F;
            if(this.C || this.D) {
               var33 = 0.5F;
            }

            byte var34 = 5;
            double var35 = 0.0D;

            double var19;
            for(int var36 = 0; var36 < var34; ++var36) {
               AxisAlignedBB var14 = this.aT();
               double var15 = var14.yMax - var14.yMin;
               double var17 = var14.yMin + var15 * (double)var36 / (double)var34;
               var19 = var14.yMin + var15 * (double)(var36 + 1) / (double)var34;
               AxisAlignedBB var21 = new AxisAlignedBB(var14.xMin, var17, var14.zMin, var14.xMax, var19, var14.zMax);
               if(this.o.b(var21, Material.WATER)) {
                  var35 += 1.0D / (double)var34;
               }
            }

            if(!this.o.isClientSide && var35 > 0.0D) {
               WorldServer var37 = (WorldServer)this.o;
               int var38 = 1;
               BlockPosition var39 = (new BlockPosition(this)).up();
               if(this.random.nextFloat() < 0.25F && this.o.C(var39)) {
                  var38 = 2;
               }

               if(this.random.nextFloat() < 0.5F && !this.o.i(var39)) {
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
                        this.a("random.splash", 0.25F, 1.0F + (this.random.nextFloat() - this.random.nextFloat()) * 0.4F);
                        var16 = (float)MathHelper.floor(this.aT().yMin);
                        var37.a(class_cy.e, this.s, (double)(var16 + 1.0F), this.u, (int)(1.0F + this.J * 20.0F), (double)this.J, 0.0D, (double)this.J, 0.20000000298023224D, new int[0]);
                        var37.a(class_cy.g, this.s, (double)(var16 + 1.0F), this.u, (int)(1.0F + this.J * 20.0F), (double)this.J, 0.0D, (double)this.J, 0.20000000298023224D, new int[0]);
                        this.aw = MathHelper.getRandomIntInRange((Random)this.random, 10, 30);
                     } else {
                        this.az = (float)((double)this.az + this.random.nextGaussian() * 4.0D);
                        var16 = this.az * 0.017453292F;
                        var40 = MathHelper.sin(var16);
                        var18 = MathHelper.cos(var16);
                        var19 = this.s + (double)(var40 * (float)this.ay * 0.1F);
                        var41 = (double)((float)MathHelper.floor(this.aT().yMin) + 1.0F);
                        var23 = this.u + (double)(var18 * (float)this.ay * 0.1F);
                        var25 = var37.getType(new BlockPosition((int)var19, (int)var41 - 1, (int)var23)).getBlock();
                        if(var25 == Blocks.WATER || var25 == Blocks.FLOWING_WATER) {
                           if(this.random.nextFloat() < 0.15F) {
                              var37.a(class_cy.e, var19, var41 - 0.10000000149011612D, var23, 1, (double)var40, 0.1D, (double)var18, 0.0D, new int[0]);
                           }

                           float var26 = var40 * 0.04F;
                           float var27 = var18 * 0.04F;
                           var37.a(class_cy.g, var19, var41, var23, 0, (double)var27, 0.01D, (double)(-var26), 1.0D, new int[0]);
                           var37.a(class_cy.g, var19, var41, var23, 0, (double)(-var27), 0.01D, (double)var26, 1.0D, new int[0]);
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
                        var19 = this.s + (double)(MathHelper.sin(var40) * var18 * 0.1F);
                        var41 = (double)((float)MathHelper.floor(this.aT().yMin) + 1.0F);
                        var23 = this.u + (double)(MathHelper.cos(var40) * var18 * 0.1F);
                        var25 = var37.getType(new BlockPosition((int)var19, (int)var41 - 1, (int)var23)).getBlock();
                        if(var25 == Blocks.WATER || var25 == Blocks.FLOWING_WATER) {
                           var37.a(class_cy.f, var19, var41, var23, 2 + this.random.nextInt(2), 0.10000000149011612D, 0.0D, 0.10000000149011612D, 0.0D, new int[0]);
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

            this.v *= (double)var33;
            this.motY *= (double)var33;
            this.x *= (double)var33;
            this.b(this.s, this.t, this.u);
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
      if(this.o.isClientSide) {
         return 0;
      } else {
         byte var1 = 0;
         if(this.c != null) {
            double var2 = this.b.s - this.s;
            double var4 = this.b.t - this.t;
            double var6 = this.b.u - this.u;
            double var8 = (double)MathHelper.sqrt(var2 * var2 + var4 * var4 + var6 * var6);
            double var10 = 0.1D;
            this.c.v += var2 * var10;
            this.c.motY += var4 * var10 + (double)MathHelper.sqrt(var8) * 0.08D;
            this.c.x += var6 * var10;
            var1 = 3;
         } else if(this.aw > 0) {
            EntityItem var13 = new EntityItem(this.o, this.s, this.t, this.u, this.m());
            double var3 = this.b.s - this.s;
            double var5 = this.b.t - this.t;
            double var7 = this.b.u - this.u;
            double var9 = (double)MathHelper.sqrt(var3 * var3 + var5 * var5 + var7 * var7);
            double var11 = 0.1D;
            var13.v = var3 * var11;
            var13.motY = var5 * var11 + (double)MathHelper.sqrt(var9) * 0.08D;
            var13.x = var7 * var11;
            this.o.addEntity((Entity)var13);
            this.b.o.addEntity((Entity)(new EntityExperienceOrb(this.b.o, this.b.s, this.b.t + 0.5D, this.b.u + 0.5D, this.random.nextInt(6) + 1)));
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
      float var1 = this.o.random.nextFloat();
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
