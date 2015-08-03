package net.minecraft.server;

import java.util.Iterator;
import java.util.List;
import net.minecraft.server.Explosion;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.BlockStainedGlassPane;
import net.minecraft.server.class_apc;
import net.minecraft.server.class_apd;
import net.minecraft.server.class_aqk;
import net.minecraft.server.Material;
import net.minecraft.server.class_aus;
import net.minecraft.server.class_aut;
import net.minecraft.server.class_auv;
import net.minecraft.server.AxisAlignedBB;
import net.minecraft.server.Vec3D;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_cy;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.MathHelper;
import net.minecraft.server.class_pc;
import net.minecraft.server.class_pd;
import net.minecraft.server.Entity;
import net.minecraft.server.class_pv;
import net.minecraft.server.EntityExperienceOrb;
import net.minecraft.server.EntityLiving;
import net.minecraft.server.class_qb;
import net.minecraft.server.class_qi;
import net.minecraft.server.class_qk;
import net.minecraft.server.class_uo;
import net.minecraft.server.class_up;
import net.minecraft.server.class_uq;
import net.minecraft.server.class_us;
import net.minecraft.server.class_wd;
import net.minecraft.server.class_wl;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.class_xh;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_ur extends class_qb implements class_uo, class_wd {
   private static final Logger bH = LogManager.getLogger();
   private static final int bI = class_qi.a(class_ur.class);
   public double a;
   public double b;
   public double c;
   public double[][] bq = new double[64][3];
   public int br = -1;
   public class_up[] bs;
   public class_up bt;
   public class_up bu;
   public class_up bv;
   public class_up bw;
   public class_up bx;
   public class_up by;
   public class_up bz;
   public class_up bA;
   public float bB;
   public float bC;
   public boolean bD;
   public boolean bE;
   private Entity bJ;
   public int bF;
   public class_uq bG;
   private final class_apc bK;
   private int bL = 200;
   private int bM;
   private boolean bN;
   private int bO;
   private int bP;
   private int bQ;
   private AxisAlignedBB bR = new AxisAlignedBB(-4.0D, -10.0D, -3.0D, 6.0D, 3.0D, 3.0D);
   private final class_aut[] bS = new class_aut[24];
   private final int[] bT = new int[24];
   private final class_aus bU = new class_aus();
   private class_auv bV;

   public class_ur(World var1) {
      super(var1);
      this.bs = new class_up[]{this.bt = new class_up(this, "head", 6.0F, 6.0F), this.bu = new class_up(this, "neck", 6.0F, 6.0F), this.bv = new class_up(this, "body", 8.0F, 8.0F), this.bw = new class_up(this, "tail", 4.0F, 4.0F), this.bx = new class_up(this, "tail", 4.0F, 4.0F), this.by = new class_up(this, "tail", 4.0F, 4.0F), this.bz = new class_up(this, "wing", 4.0F, 4.0F), this.bA = new class_up(this, "wing", 4.0F, 4.0F)};
      this.i(this.bv());
      this.a(16.0F, 8.0F);
      this.T = true;
      this.ab = true;
      this.b = 100.0D;
      this.bL = 100;
      this.ah = true;
      if(!var1.isClientSide && var1.worldProvider instanceof class_apd) {
         this.bK = ((class_apd)var1.worldProvider).s();
      } else {
         this.bK = null;
      }

   }

   protected void aY() {
      super.aY();
      this.a((class_qk)class_wl.a).a(200.0D);
   }

   protected void h() {
      super.h();
      this.H().a(bI, Byte.valueOf((byte)class_us.a.a()));
   }

   public class_us n() {
      return class_us.a(this.H().a(bI));
   }

   public boolean a(class_us var1) {
      return this.a(var1, false);
   }

   public boolean a(class_us var1, boolean var2) {
      boolean var3;
      var3 = false;
      label59:
      switch(class_ur.SyntheticClass_1.a[this.n().ordinal()]) {
      case 1:
         switch(class_ur.SyntheticClass_1.a[var1.ordinal()]) {
         case 2:
         case 3:
            var3 = true;
         default:
            break label59;
         }
      case 2:
         switch(class_ur.SyntheticClass_1.a[var1.ordinal()]) {
         case 4:
            var3 = true;
         default:
            break label59;
         }
      case 3:
         switch(class_ur.SyntheticClass_1.a[var1.ordinal()]) {
         case 1:
         case 2:
            var3 = true;
         default:
            break label59;
         }
      case 4:
         switch(class_ur.SyntheticClass_1.a[var1.ordinal()]) {
         case 5:
         case 6:
            var3 = true;
         default:
            break label59;
         }
      case 5:
         switch(class_ur.SyntheticClass_1.a[var1.ordinal()]) {
         case 6:
         case 7:
         case 8:
            var3 = true;
         default:
            break label59;
         }
      case 6:
         switch(class_ur.SyntheticClass_1.a[var1.ordinal()]) {
         case 5:
         case 7:
         case 8:
            var3 = true;
         case 6:
         default:
            break label59;
         }
      case 7:
         switch(class_ur.SyntheticClass_1.a[var1.ordinal()]) {
         case 5:
         case 6:
         case 8:
            var3 = true;
         case 7:
         default:
            break label59;
         }
      case 8:
         switch(class_ur.SyntheticClass_1.a[var1.ordinal()]) {
         case 3:
            var3 = true;
         }
      }

      if(!var2 && !var3) {
         bH.debug("Couldn\'t transition dragon into phase " + var1 + " from " + this.n());
         return false;
      } else {
         bH.debug("Dragon phase is now " + var1 + " (from " + this.n() + ")");
         this.H().b(bI, Byte.valueOf((byte)var1.a()));
         return true;
      }
   }

   public double[] a(int var1, float var2) {
      if(this.bo() <= 0.0F) {
         var2 = 0.0F;
      }

      var2 = 1.0F - var2;
      int var3 = this.br - var1 * 1 & 63;
      int var4 = this.br - var1 * 1 - 1 & 63;
      double[] var5 = new double[3];
      double var6 = this.bq[var3][0];
      double var8 = MathHelper.clampAngle(this.bq[var4][0] - var6);
      var5[0] = var6 + var8 * (double)var2;
      var6 = this.bq[var3][1];
      var8 = this.bq[var4][1] - var6;
      var5[1] = var6 + var8 * (double)var2;
      var5[2] = this.bq[var3][2] + (this.bq[var4][2] - this.bq[var3][2]) * (double)var2;
      return var5;
   }

   public void m() {
      class_us var1 = this.n();
      float var2;
      float var3;
      if(this.o.isClientSide) {
         this.i(this.bo());
         if(!this.R()) {
            var2 = MathHelper.cos(this.bC * 3.1415927F * 2.0F);
            var3 = MathHelper.cos(this.bB * 3.1415927F * 2.0F);
            if(var3 <= -0.3F && var2 >= -0.3F) {
               this.o.a(this.s, this.t, this.u, "mob.enderdragon.wings", 5.0F, 0.8F + this.V.nextFloat() * 0.3F, false);
            }

            if(!var1.b() && --this.bL < 0) {
               this.o.a(this.s, this.t, this.u, "mob.enderdragon.growl", 2.5F, 0.8F + this.V.nextFloat() * 0.3F, false);
               this.bL = 200 + this.V.nextInt(200);
            }
         }
      }

      this.bB = this.bC;
      float var34;
      if(this.bo() <= 0.0F) {
         var2 = (this.V.nextFloat() - 0.5F) * 8.0F;
         var3 = (this.V.nextFloat() - 0.5F) * 4.0F;
         var34 = (this.V.nextFloat() - 0.5F) * 8.0F;
         this.o.a(class_cy.b, this.s + (double)var2, this.t + 2.0D + (double)var3, this.u + (double)var34, 0.0D, 0.0D, 0.0D, new int[0]);
      } else {
         this.cu();
         var2 = 0.2F / (MathHelper.sqrt(this.v * this.v + this.x * this.x) * 10.0F + 1.0F);
         var2 *= (float)Math.pow(2.0D, this.motY);
         if(var1.b()) {
            this.bC += 0.1F;
         } else if(this.bE) {
            this.bC += var2 * 0.5F;
         } else {
            this.bC += var2;
         }

         this.y = MathHelper.clampAngle(this.y);
         if(this.cs()) {
            this.bC = 0.5F;
         } else {
            if(this.br < 0) {
               for(int var32 = 0; var32 < this.bq.length; ++var32) {
                  this.bq[var32][0] = (double)this.y;
                  this.bq[var32][1] = this.t;
               }
            }

            if(++this.br == this.bq.length) {
               this.br = 0;
            }

            this.bq[this.br][0] = (double)this.y;
            this.bq[this.br][1] = this.t;
            double var5;
            double var7;
            double var9;
            double var10;
            float var12;
            double var15;
            double var16;
            double var17;
            float var18;
            double var21;
            double var23;
            double var33;
            double var45;
            float var49;
            Vec3D var50;
            float var51;
            double var53;
            float var54;
            float var59;
            float var61;
            double var63;
            if(this.o.isClientSide) {
               if(this.bf > 0) {
                  var33 = this.s + (this.bg - this.s) / (double)this.bf;
                  var5 = this.t + (this.bh - this.t) / (double)this.bf;
                  var7 = this.u + (this.bi - this.u) / (double)this.bf;
                  var9 = MathHelper.clampAngle(this.bj - (double)this.y);
                  this.y = (float)((double)this.y + var9 / (double)this.bf);
                  this.z = (float)((double)this.z + (this.bk - (double)this.z) / (double)this.bf);
                  --this.bf;
                  this.b(var33, var5, var7);
                  this.b(this.y, this.z);
               }

               Vec3D var4;
               if(var1 == class_us.f) {
                  var3 = 0.08F;
                  var4 = this.o(1.0F).normalize();
                  var4.rotateYaw(-0.7853982F);

                  for(int var35 = 0; var35 < 8; ++var35) {
                     double var6 = MathHelper.getRandomDoubleInRange(this.V, this.bR.xMin, this.bR.xMax);
                     double var8 = MathHelper.getRandomDoubleInRange(this.V, this.bR.yMin, this.bR.yMax);
                     var10 = MathHelper.getRandomDoubleInRange(this.V, this.bR.zMin, this.bR.zMax);
                     var12 = 0.3F;
                     this.o.a(class_cy.Q, var6, var8, var10, -var4.x * (double)var3 + this.v, -var4.y * (double)var12 + this.motY, -var4.z * (double)var3 + this.x, new int[0]);
                  }
               }

               if(var1 != class_us.d && (var1 != class_us.f || this.W % 2 != 0)) {
                  if(var1 == class_us.h) {
                     this.o.a(this.s, this.t, this.u, "mob.enderdragon.growl", 2.5F, 0.8F + this.V.nextFloat() * 0.3F, false);
                  }
               } else {
                  var3 = 0.08F;
                  var4 = this.o(1.0F).normalize();
                  var4.rotateYaw(-0.7853982F);
                  var5 = this.bt.s;
                  var7 = this.bt.t + (double)(this.bt.K / 2.0F);
                  var9 = this.bt.u;

                  for(int var11 = 0; var11 < 8; ++var11) {
                     var45 = var5 + this.V.nextGaussian() / 2.0D;
                     double var14 = var7 + this.V.nextGaussian() / 2.0D;
                     var16 = var9 + this.V.nextGaussian() / 2.0D;
                     if(var1 == class_us.d) {
                        var18 = 0.3F;
                        this.o.a(class_cy.Q, var45, var14, var16, -var4.x * (double)var3 + this.v, -var4.y * (double)var18 + this.motY, -var4.z * (double)var3 + this.x, new int[0]);
                     } else {
                        var18 = 0.6F;

                        for(int var19 = 0; var19 < 6; ++var19) {
                           this.o.a(class_cy.Q, var45, var14, var16, -var4.x * (double)var3 * (double)var19, -var4.y * (double)var18, -var4.z * (double)var3 * (double)var19, new int[0]);
                        }
                     }

                     var4.rotateYaw(0.19634955F);
                  }
               }
            } else {
               var33 = this.a - this.s;
               var5 = this.b - this.t;
               var7 = this.c - this.u;
               var9 = var33 * var33 + var5 * var5 + var7 * var7;
               if(var1 == class_us.f) {
                  if(--this.bO <= 0) {
                     if(this.bQ >= 4) {
                        this.a(class_us.e);
                        this.bD = true;
                     } else {
                        this.a(class_us.g);
                        this.bJ = this.o.a((Entity)this, 20.0D, 10.0D);
                     }
                  }
               } else if(var1 == class_us.g) {
                  this.bJ = this.o.a((Entity)this, 20.0D, 10.0D);
                  ++this.bO;
                  if(this.bJ != null) {
                     if(this.bO > 25) {
                        this.a(class_us.h);
                        this.bO = 40;
                     }
                  } else if(this.bO >= 100) {
                     this.a(class_us.e);
                     this.bD = true;
                  }
               } else if(var1 == class_us.h) {
                  if(--this.bO <= 0) {
                     ++this.bQ;
                     this.a(class_us.f);
                     this.bJ = this.o.a((Entity)this, 20.0D, 10.0D);
                     this.bO = 60;
                  }
               } else if(!this.bD && var1 == class_us.e) {
                  BlockPosition var43 = this.o.r(class_aqk.a);
                  var45 = this.c(var43);
                  if(var45 > 100.0D) {
                     this.a(class_us.a);
                  }
               } else if(this.bD || var1 != class_us.d && var9 < 100.0D || var9 < 1.0D || var9 > 22500.0D || this.D || this.E) {
                  this.cv();
               }

               var1 = this.n();
               if((var1 == class_us.f || var1 == class_us.d) && this.bO < 50) {
                  List var44 = this.o.a(EntityLiving.class, this.bR, class_pv.d);
                  if(!var44.isEmpty()) {
                     Iterator var48 = var44.iterator();

                     while(var48.hasNext()) {
                        EntityLiving var13 = (EntityLiving)var48.next();
                        var13.a(class_pc.b(this, this), 2.0F);
                     }
                  }
               }

               if(var1 != class_us.f) {
                  if(var1 == class_us.g) {
                     if(this.bJ != null) {
                        Vec3D var46 = (new Vec3D(this.bJ.s - this.s, 0.0D, this.bJ.u - this.u)).normalize();
                        var50 = (new Vec3D((double)MathHelper.sin(this.y * 3.1415927F / 180.0F), 0.0D, (double)(-MathHelper.cos(this.y * 3.1415927F / 180.0F)))).normalize();
                        var51 = (float)var50.dotProduct(var46);
                        var54 = (float)(Math.acos((double)var51) * 180.0D / 3.1415927410125732D) + 0.5F;
                        if(var54 < 0.0F || var54 > 10.0F) {
                           var15 = this.bJ.s - this.bt.s;
                           var17 = this.bJ.u - this.bt.u;
                           var63 = MathHelper.clamp(MathHelper.clampAngle(180.0D - MathHelper.b(var15, var17) * 180.0D / 3.1415927410125732D - (double)this.y), -50.0D, 50.0D);
                           var21 = this.a - this.s;
                           var23 = this.c - this.u;
                           this.be *= 0.8F;
                           float var25 = MathHelper.sqrt(var21 * var21 + var23 * var23) * 1.0F + 1.0F;
                           float var26 = var25;
                           if(var25 > 40.0F) {
                              var25 = 40.0F;
                           }

                           this.be = (float)((double)this.be + var63 * (double)(0.7F / var25 / var26));
                           this.y += this.be;
                        }
                     }
                  } else if(var1 != class_us.h) {
                     if(var1 == class_us.b && this.bJ != null && this.bV != null && this.bV.b()) {
                        this.a = this.bJ.s;
                        this.c = this.bJ.u;
                        double var47 = this.a - this.s;
                        var53 = this.c - this.u;
                        var15 = (double)MathHelper.sqrt(var47 * var47 + var53 * var53);
                        var17 = Math.min(0.4000000059604645D + var15 / 80.0D - 1.0D, 10.0D);
                        this.b = this.bJ.t + var17;
                     }

                     var49 = var1 == class_us.d?1.5F:0.6F;
                     var5 = MathHelper.clamp(var5 / (double)MathHelper.sqrt(var33 * var33 + var7 * var7), (double)(-var49), (double)var49);
                     this.motY += var5 * 0.10000000149011612D;
                     this.y = MathHelper.clampAngle(this.y);
                     var45 = MathHelper.clamp(MathHelper.clampAngle(180.0D - MathHelper.b(var33, var7) * 180.0D / 3.1415927410125732D - (double)this.y), -50.0D, 50.0D);
                     Vec3D var56 = (new Vec3D(this.a - this.s, this.b - this.t, this.c - this.u)).normalize();
                     Vec3D var58 = (new Vec3D((double)MathHelper.sin(this.y * 3.1415927F / 180.0F), this.motY, (double)(-MathHelper.cos(this.y * 3.1415927F / 180.0F)))).normalize();
                     var59 = Math.max(((float)var58.dotProduct(var56) + 0.5F) / 1.5F, 0.0F);
                     this.be *= 0.8F;
                     var61 = MathHelper.sqrt(this.v * this.v + this.x * this.x) * 1.0F + 1.0F;
                     var18 = var61;
                     if(var61 > 40.0F) {
                        var61 = 40.0F;
                     }

                     if(var1 == class_us.d) {
                        this.be = (float)((double)this.be + var45 * (double)(var61 / var18));
                     } else {
                        this.be = (float)((double)this.be + var45 * (double)(0.7F / var61 / var18));
                     }

                     this.y += this.be * 0.1F;
                     float var64 = (float)(2.0D / (var9 + 1.0D));
                     float var20 = 0.06F;
                     this.a(0.0F, -1.0F, var20 * (var59 * var64 + (1.0F - var64)));
                     if(this.bE) {
                        this.d(this.v * 0.800000011920929D, this.motY * 0.800000011920929D, this.x * 0.800000011920929D);
                     } else {
                        this.d(this.v, this.motY, this.x);
                     }

                     Vec3D var65 = (new Vec3D(this.v, this.motY, this.x)).normalize();
                     float var22 = ((float)var65.dotProduct(var58) + 1.0F) / 2.0F;
                     var22 = 0.8F + 0.15F * var22;
                     this.v *= (double)var22;
                     this.x *= (double)var22;
                     this.motY *= 0.9100000262260437D;
                  }
               }
            }

            this.aL = this.y;
            this.bt.J = this.bt.K = 1.0F;
            this.bu.J = this.bu.K = 3.0F;
            this.bw.J = this.bw.K = 2.0F;
            this.bx.J = this.bx.K = 2.0F;
            this.by.J = this.by.K = 2.0F;
            this.bv.K = 3.0F;
            this.bv.J = 5.0F;
            this.bz.K = 2.0F;
            this.bz.J = 4.0F;
            this.bA.K = 3.0F;
            this.bA.J = 4.0F;
            var3 = (float)(this.a(5, 1.0F)[1] - this.a(10, 1.0F)[1]) * 10.0F / 180.0F * 3.1415927F;
            var34 = MathHelper.cos(var3);
            float var37 = MathHelper.sin(var3);
            float var36 = this.y * 3.1415927F / 180.0F;
            float var38 = MathHelper.sin(var36);
            float var39 = MathHelper.cos(var36);
            this.bv.t_();
            this.bv.b(this.s + (double)(var38 * 0.5F), this.t, this.u - (double)(var39 * 0.5F), 0.0F, 0.0F);
            this.bz.t_();
            this.bz.b(this.s + (double)(var39 * 4.5F), this.t + 2.0D, this.u + (double)(var38 * 4.5F), 0.0F, 0.0F);
            this.bA.t_();
            this.bA.b(this.s - (double)(var39 * 4.5F), this.t + 2.0D, this.u - (double)(var38 * 4.5F), 0.0F, 0.0F);
            if(!this.o.isClientSide && this.ax == 0) {
               this.a(this.o.b((Entity)this, (AxisAlignedBB)this.bz.aT().grow(4.0D, 2.0D, 4.0D).c(0.0D, -2.0D, 0.0D)));
               this.a(this.o.b((Entity)this, (AxisAlignedBB)this.bA.aT().grow(4.0D, 2.0D, 4.0D).c(0.0D, -2.0D, 0.0D)));
               this.b(this.o.b((Entity)this, (AxisAlignedBB)this.bt.aT().grow(1.0D, 1.0D, 1.0D)));
               this.b(this.o.b((Entity)this, (AxisAlignedBB)this.bu.aT().grow(1.0D, 1.0D, 1.0D)));
            }

            double[] var40 = this.a(5, 1.0F);
            float var41 = MathHelper.sin(this.y * 3.1415927F / 180.0F - this.be * 0.01F);
            var49 = MathHelper.cos(this.y * 3.1415927F / 180.0F - this.be * 0.01F);
            this.bt.t_();
            this.bu.t_();
            var12 = this.a(1.0F);
            this.bt.b(this.s + (double)(var41 * 6.5F * var34), this.t + (double)var12 + (double)(var37 * 6.5F), this.u - (double)(var49 * 6.5F * var34), 0.0F, 0.0F);
            this.bu.b(this.s + (double)(var41 * 5.5F * var34), this.t + (double)var12 + (double)(var37 * 5.5F), this.u - (double)(var49 * 5.5F * var34), 0.0F, 0.0F);
            var53 = this.s + (double)(var41 * 9.5F * var34);
            var15 = this.t + (double)var12 + (double)(var37 * 10.5F);
            var17 = this.u - (double)(var49 * 9.5F * var34);
            this.bR = new AxisAlignedBB(var53 - 5.0D, var15 - 17.0D, var17 - 5.0D, var53 + 5.0D, var15 + 4.0D, var17 + 5.0D);

            float var60;
            for(int var42 = 0; var42 < 3; ++var42) {
               class_up var52 = null;
               if(var42 == 0) {
                  var52 = this.bw;
               }

               if(var42 == 1) {
                  var52 = this.bx;
               }

               if(var42 == 2) {
                  var52 = this.by;
               }

               double[] var55 = this.a(12 + var42 * 2, 1.0F);
               var51 = this.y * 3.1415927F / 180.0F + this.b(var55[0] - var40[0]) * 3.1415927F / 180.0F * 1.0F;
               var54 = MathHelper.sin(var51);
               var60 = MathHelper.cos(var51);
               var59 = 1.5F;
               var61 = (float)(var42 + 1) * 2.0F;
               var52.t_();
               var52.b(this.s - (double)((var38 * var59 + var54 * var61) * var34), this.t + (var55[1] - var40[1]) * 1.0D - (double)((var61 + var59) * var37) + 1.5D, this.u + (double)((var39 * var59 + var60 * var61) * var34), 0.0F, 0.0F);
            }

            if(!this.o.isClientSide) {
               var10 = 64.0D;
               if(var1 == class_us.b && this.bJ != null && this.bJ.h(this) < var10 * var10) {
                  if(this.t(this.bJ)) {
                     ++this.bM;
                     var50 = (new Vec3D(this.bJ.s - this.s, 0.0D, this.bJ.u - this.u)).normalize();
                     Vec3D var57 = (new Vec3D((double)MathHelper.sin(this.y * 3.1415927F / 180.0F), 0.0D, (double)(-MathHelper.cos(this.y * 3.1415927F / 180.0F)))).normalize();
                     var54 = (float)var57.dotProduct(var50);
                     var60 = (float)(Math.acos((double)var54) * 180.0D / 3.1415927410125732D);
                     var60 += 0.5F;
                     if(this.bM >= 5 && var60 >= 0.0F && var60 < 10.0F) {
                        var16 = 1.0D;
                        Vec3D var62 = this.d(1.0F);
                        var63 = this.bt.s - var62.x * var16;
                        var21 = this.bt.t + (double)(this.bt.K / 2.0F) + 0.5D;
                        var23 = this.bt.u - var62.z * var16;
                        double var66 = this.bJ.s - var63;
                        double var27 = this.bJ.t + (double)(this.bJ.K / 2.0F) - (var21 + (double)(this.bt.K / 2.0F));
                        double var29 = this.bJ.u - var23;
                        this.o.a((EntityHuman)null, 1008, new BlockPosition(this), 0);
                        class_xh var31 = new class_xh(this.o, this, var66, var27, var29);
                        var31.s = var63;
                        var31.t = var21;
                        var31.u = var23;
                        this.o.addEntity((Entity)var31);
                        this.bM = 0;
                        if(this.bV != null) {
                           while(!this.bV.b()) {
                              this.bV.a();
                           }
                        }

                        this.bD = true;
                        this.cv();
                     }
                  } else if(this.bM > 0) {
                     --this.bM;
                  }
               } else if(this.bM > 0) {
                  --this.bM;
               }
            }

            if(!this.o.isClientSide) {
               this.bE = this.b(this.bt.aT()) | this.b(this.bu.aT()) | this.b(this.bv.aT());
               if(this.bK != null) {
                  this.bK.b(this);
               }
            }

         }
      }
   }

   private float a(float var1) {
      double var2 = 0.0D;
      if(this.n().b()) {
         var2 = -1.0D;
      } else {
         double[] var4 = this.a(5, 1.0F);
         double[] var5 = this.a(0, 1.0F);
         var2 = (var4[1] - var5[0]) * 1.0D;
      }

      return (float)var2;
   }

   private void cu() {
      if(this.bG != null) {
         if(this.bG.I) {
            if(!this.o.isClientSide) {
               this.a(this.bt, class_pc.a((Explosion)null), 10.0F);
            }

            this.bG = null;
         } else if(this.W % 10 == 0 && this.bo() < this.bv()) {
            this.i(this.bo() + 1.0F);
         }
      }

      if(this.V.nextInt(10) == 0) {
         float var1 = 32.0F;
         List var2 = this.o.getEntities(class_uq.class, this.aT().grow((double)var1, (double)var1, (double)var1));
         class_uq var3 = null;
         double var4 = Double.MAX_VALUE;
         Iterator var6 = var2.iterator();

         while(var6.hasNext()) {
            class_uq var7 = (class_uq)var6.next();
            double var8 = var7.h(this);
            if(var8 < var4) {
               var4 = var8;
               var3 = var7;
            }
         }

         this.bG = var3;
      }

   }

   private void a(List var1) {
      double var2 = (this.bv.aT().xMin + this.bv.aT().xMax) / 2.0D;
      double var4 = (this.bv.aT().zMin + this.bv.aT().zMax) / 2.0D;
      Iterator var6 = var1.iterator();

      while(var6.hasNext()) {
         Entity var7 = (Entity)var6.next();
         if(var7 instanceof EntityLiving) {
            double var8 = var7.s - var2;
            double var10 = var7.u - var4;
            double var12 = var8 * var8 + var10 * var10;
            var7.g(var8 / var12 * 4.0D, 0.20000000298023224D, var10 / var12 * 4.0D);
         }
      }

   }

   private void b(List var1) {
      for(int var2 = 0; var2 < var1.size(); ++var2) {
         Entity var3 = (Entity)var1.get(var2);
         if(var3 instanceof EntityLiving) {
            var3.a(class_pc.a((EntityLiving)this), 10.0F);
            this.a((EntityLiving)this, (Entity)var3);
         }
      }

   }

   private void cv() {
      EntityHuman var1 = null;
      switch(class_ur.SyntheticClass_1.a[this.n().ordinal()]) {
      case 1:
         if(this.bV == null || this.bV.b() && this.bD) {
            this.a(class_us.a);
         }
      case 2:
      case 5:
      case 6:
      case 7:
      default:
         break;
      case 3:
      case 8:
         if(!this.bD && this.bV != null && this.bV.b()) {
            BlockPosition var2 = this.o.r(new BlockPosition(class_aqk.a));
            double var3 = 64.0D;
            var1 = this.o.a(var2, var3, var3);
            if(var1 != null) {
               var3 = var1.c(var2) / 512.0D;
            }

            int var5 = this.bK == null?0:this.bK.c();
            if(this.V.nextInt(var5 + 3) == 0) {
               this.a(class_us.c);
            } else if(var1 != null && (this.V.nextInt(MathHelper.abs((int)var3) + 2) == 0 || this.V.nextInt(var5 + 2) == 0)) {
               this.a(class_us.b);
            }
         }
         break;
      case 4:
         this.bQ = 0;
         this.a(class_us.g);
         this.bJ = this.o.a((Entity)this, 20.0D, 10.0D);
         this.bO = 0;
      }

      this.bD = false;
      if(this.n() == class_us.b && var1 != null) {
         this.bJ = var1;
         this.cw();
      } else {
         int var6;
         if(this.n() == class_us.c) {
            if(this.bV == null || this.bV.b()) {
               var6 = this.cy();
               BlockPosition var7 = this.o.r(class_aqk.a);
               var1 = this.o.a(var7, 128.0D, 128.0D);
               boolean var4 = false;
               int var9;
               if(var1 != null) {
                  Vec3D var10 = (new Vec3D(var1.s, 0.0D, var1.u)).normalize();
                  var9 = this.k(-var10.x * 40.0D, 105.0D, -var10.z * 40.0D);
               } else {
                  var9 = this.k(40.0D, (double)var7.getY(), 0.0D);
               }

               class_aut var12 = new class_aut(var7.getX(), var7.getY(), var7.getZ());
               this.bV = this.a(var6, var9, var12);
               if(this.bV != null) {
                  this.bV.a();
               }
            }

            this.bO = 0;
            this.cx();
            if(this.bV != null && this.bV.b()) {
               this.a(class_us.d);
            }
         } else if(!this.n().b()) {
            if(this.bV == null || this.bV.b()) {
               var6 = this.cy();
               int var8 = var6;
               if(this.n() == class_us.e) {
                  Vec3D var11 = this.o(1.0F);
                  var8 = this.k(-var11.x * 40.0D, 105.0D, -var11.z * 40.0D);
               } else {
                  if(this.V.nextInt(8) == 0) {
                     this.bN = !this.bN;
                     var8 = var6 + 6;
                  }

                  if(this.bN) {
                     ++var8;
                  } else {
                     --var8;
                  }
               }

               if(this.bK != null && this.bK.c() >= 0) {
                  var8 %= 12;
                  if(var8 < 0) {
                     var8 += 12;
                  }
               } else {
                  var8 -= 12;
                  var8 &= 7;
                  var8 += 12;
               }

               this.bV = this.a(var6, var8, (class_aut)null);
               if(this.bV != null) {
                  this.bV.a();
               }
            }

            this.cx();
            if(this.n() != class_us.b) {
               this.bJ = null;
            }
         }
      }

   }

   private float b(double var1) {
      return (float)MathHelper.clampAngle(var1);
   }

   private boolean b(AxisAlignedBB var1) {
      int var2 = MathHelper.floor(var1.xMin);
      int var3 = MathHelper.floor(var1.yMin);
      int var4 = MathHelper.floor(var1.zMin);
      int var5 = MathHelper.floor(var1.xMax);
      int var6 = MathHelper.floor(var1.yMax);
      int var7 = MathHelper.floor(var1.zMax);
      boolean var8 = false;
      boolean var9 = false;

      for(int var10 = var2; var10 <= var5; ++var10) {
         for(int var11 = var3; var11 <= var6; ++var11) {
            for(int var12 = var4; var12 <= var7; ++var12) {
               BlockPosition var13 = new BlockPosition(var10, var11, var12);
               Block var14 = this.o.getType(var13).getBlock();
               if(var14.getMaterial() != Material.AIR && var14.getMaterial() != Material.FIRE) {
                  if(var14 != BlockStainedGlassPane.BARRIER && var14 != BlockStainedGlassPane.OBSIDIAN && var14 != BlockStainedGlassPane.END_STONE && var14 != BlockStainedGlassPane.BEDROCK && var14 != BlockStainedGlassPane.COMMAND_BLOCK && var14 != BlockStainedGlassPane.IRON_BARS && this.o.R().b("mobGriefing")) {
                     var9 = this.o.setAir(var13) || var9;
                  } else {
                     var8 = true;
                  }
               }
            }
         }
      }

      if(var9) {
         double var16 = var1.xMin + (var1.xMax - var1.xMin) * (double)this.V.nextFloat();
         double var17 = var1.yMin + (var1.yMax - var1.yMin) * (double)this.V.nextFloat();
         double var18 = var1.zMin + (var1.zMax - var1.zMin) * (double)this.V.nextFloat();
         this.o.a(class_cy.b, var16, var17, var18, 0.0D, 0.0D, 0.0D, new int[0]);
      }

      return var8;
   }

   public boolean a(class_up var1, class_pc var2, float var3) {
      if(var1 != this.bt) {
         var3 = var3 / 4.0F + 1.0F;
      }

      if(var2.j() instanceof EntityHuman || var2.c()) {
         float var4 = this.bo();
         this.e(var2, var3);
         if(this.bo() <= 0.0F && !this.n().b()) {
            this.i(1.0F);
            if(this.a(class_us.c)) {
               if(this.bV != null) {
                  while(!this.bV.b()) {
                     this.bV.a();
                  }
               }

               bH.debug("Dragon died whilst in the air, ignoring damage and going in to land");
               this.cv();
            }

            if(this.n().b()) {
               this.bP = (int)((float)this.bP + (var4 - this.bo()));
               if((float)this.bP > 0.25F * this.bv()) {
                  this.bP = 0;
                  this.a(class_us.e);
                  this.bD = true;
               }
            }
         }
      }

      return true;
   }

   public boolean a(class_pc var1, float var2) {
      if(var1 instanceof class_pd && ((class_pd)var1).w()) {
         this.a(this.bv, var1, var2);
      }

      return false;
   }

   protected boolean e(class_pc var1, float var2) {
      return super.a(var1, var2);
   }

   public void G() {
      this.J();
   }

   protected void ba() {
      if(this.bK != null) {
         this.bK.b(this);
      }

      if(!this.n().b() && !this.o.isClientSide) {
         this.i(1.0F);
      } else {
         ++this.bF;
         if(this.bF >= 180 && this.bF <= 200) {
            float var1 = (this.V.nextFloat() - 0.5F) * 8.0F;
            float var2 = (this.V.nextFloat() - 0.5F) * 4.0F;
            float var3 = (this.V.nextFloat() - 0.5F) * 8.0F;
            this.o.a(class_cy.c, this.s + (double)var1, this.t + 2.0D + (double)var2, this.u + (double)var3, 0.0D, 0.0D, 0.0D, new int[0]);
         }

         boolean var4 = false;
         if(this.bK != null) {
            var4 = !this.bK.d() && this.o.R().b("doMobLoot");
         }

         int var5;
         int var6;
         if(!this.o.isClientSide) {
            if(this.bF > 150 && this.bF % 5 == 0 && var4) {
               var5 = 1000;

               while(var5 > 0) {
                  var6 = EntityExperienceOrb.getOrbValue(var5);
                  var5 -= var6;
                  this.o.addEntity((Entity)(new EntityExperienceOrb(this.o, this.s, this.t, this.u, var6)));
               }
            }

            if(this.bF == 1) {
               this.o.a(1018, new BlockPosition(this), 0);
            }
         }

         this.d(0.0D, 0.10000000149011612D, 0.0D);
         this.aL = this.y += 20.0F;
         if(this.bF == 200 && !this.o.isClientSide) {
            if(var4) {
               var5 = 2000;

               while(var5 > 0) {
                  var6 = EntityExperienceOrb.getOrbValue(var5);
                  var5 -= var6;
                  this.o.addEntity((Entity)(new EntityExperienceOrb(this.o, this.s, this.t, this.u, var6)));
               }
            }

            if(this.bK != null) {
               this.bK.a(this);
            }

            this.J();
         }

      }
   }

   private void cw() {
      int var1 = this.cy();
      int var2 = this.k(this.bJ.s, this.bJ.t, this.bJ.u);
      int var3 = MathHelper.floor(this.bJ.s);
      int var4 = MathHelper.floor(this.bJ.u);
      double var5 = (double)var3 - this.s;
      double var7 = (double)var4 - this.u;
      double var9 = (double)MathHelper.sqrt(var5 * var5 + var7 * var7);
      double var11 = Math.min(0.4000000059604645D + var9 / 80.0D - 1.0D, 10.0D);
      int var13 = MathHelper.floor(this.bJ.t + var11);
      class_aut var14 = new class_aut(var3, var13, var4);
      this.bV = this.a(var1, var2, var14);
      if(this.bV != null) {
         this.bV.a();
         this.cx();
      }

   }

   private void cx() {
      if(this.bV != null && !this.bV.b()) {
         Vec3D var1 = this.bV.f();
         this.bV.a();
         this.a = var1.x;
         if(this.n() == class_us.c && this.bV.b()) {
            this.b = var1.y;
         } else {
            do {
               this.b = var1.y + (double)(this.V.nextFloat() * 20.0F);
            } while(this.b < var1.y);
         }

         this.c = var1.z;
      }

   }

   private int cy() {
      if(this.bS[0] == null) {
         boolean var1 = false;
         boolean var2 = false;
         boolean var3 = false;
         boolean var4 = false;

         for(int var5 = 0; var5 < 24; ++var5) {
            int var6 = 5;
            int var7;
            int var9;
            if(var5 < 12) {
               var7 = (int)(60.0F * MathHelper.cos(2.0F * (-3.1415927F + 0.2617994F * (float)var5)));
               var9 = (int)(60.0F * MathHelper.sin(2.0F * (-3.1415927F + 0.2617994F * (float)var5)));
            } else {
               int var10;
               if(var5 < 20) {
                  var10 = var5 - 12;
                  var7 = (int)(40.0F * MathHelper.cos(2.0F * (-3.1415927F + 0.3926991F * (float)var10)));
                  var9 = (int)(40.0F * MathHelper.sin(2.0F * (-3.1415927F + 0.3926991F * (float)var10)));
                  var6 += 10;
               } else {
                  var10 = var5 - 20;
                  var7 = (int)(20.0F * MathHelper.cos(2.0F * (-3.1415927F + 0.7853982F * (float)var10)));
                  var9 = (int)(20.0F * MathHelper.sin(2.0F * (-3.1415927F + 0.7853982F * (float)var10)));
               }
            }

            int var8 = Math.max(this.o.G() + 10, this.o.r(new BlockPosition(var7, 0, var9)).getY() + var6);
            this.bS[var5] = new class_aut(var7, var8, var9);
         }

         this.bT[0] = 6146;
         this.bT[1] = 8197;
         this.bT[2] = 8202;
         this.bT[3] = 16404;
         this.bT[4] = '耨';
         this.bT[5] = '聐';
         this.bT[6] = 65696;
         this.bT[7] = 131392;
         this.bT[8] = 131712;
         this.bT[9] = 263424;
         this.bT[10] = 526848;
         this.bT[11] = 525313;
         this.bT[12] = 1581057;
         this.bT[13] = 3166214;
         this.bT[14] = 2138120;
         this.bT[15] = 6373424;
         this.bT[16] = 4358208;
         this.bT[17] = 12910976;
         this.bT[18] = 9044480;
         this.bT[19] = 9706496;
         this.bT[20] = 15216640;
         this.bT[21] = 13688832;
         this.bT[22] = 11763712;
         this.bT[23] = 8257536;
      }

      return this.k(this.s, this.t, this.u);
   }

   private int k(double var1, double var3, double var5) {
      float var7 = 10000.0F;
      int var8 = 0;
      class_aut var9 = new class_aut(MathHelper.floor(var1), MathHelper.floor(var3), MathHelper.floor(var5));
      byte var10 = 0;
      if(this.bK == null || this.bK.c() == 0) {
         var10 = 12;
      }

      for(int var11 = var10; var11 < 24; ++var11) {
         if(this.bS[var11] != null) {
            float var12 = this.bS[var11].b(var9);
            if(var12 < var7) {
               var7 = var12;
               var8 = var11;
            }
         }
      }

      return var8;
   }

   private class_auv a(int var1, int var2, class_aut var3) {
      class_aut var5;
      for(int var4 = 0; var4 < 24; ++var4) {
         var5 = this.bS[var4];
         var5.i = false;
         var5.g = 0.0F;
         var5.e = 0.0F;
         var5.f = 0.0F;
         var5.h = null;
         var5.d = -1;
      }

      class_aut var13 = this.bS[var1];
      var5 = this.bS[var2];
      var13.e = 0.0F;
      var13.f = var13.a(var5);
      var13.g = var13.f;
      this.bU.a();
      this.bU.a(var13);
      class_aut var6 = var13;
      byte var7 = 0;
      if(this.bK == null || this.bK.c() == 0) {
         var7 = 12;
      }

      while(!this.bU.e()) {
         class_aut var8 = this.bU.c();
         if(var8.equals(var5)) {
            if(var3 != null) {
               var3.h = var5;
               var5 = var3;
            }

            return this.a(var13, var5);
         }

         if(var8.a(var5) < var6.a(var5)) {
            var6 = var8;
         }

         var8.i = true;
         int var9 = 0;

         int var10;
         for(var10 = 0; var10 < 24; ++var10) {
            if(this.bS[var10] == var8) {
               var9 = var10;
               break;
            }
         }

         for(var10 = var7; var10 < 24; ++var10) {
            if((this.bT[var9] & 1 << var10) > 0) {
               class_aut var11 = this.bS[var10];
               if(!var11.i) {
                  float var12 = var8.e + var8.a(var11);
                  if(!var11.a() || var12 < var11.e) {
                     var11.h = var8;
                     var11.e = var12;
                     var11.f = var11.a(var5);
                     if(var11.a()) {
                        this.bU.a(var11, var11.e + var11.f);
                     } else {
                        var11.g = var11.e + var11.f;
                        this.bU.a(var11);
                     }
                  }
               }
            }
         }
      }

      if(var6 == var13) {
         return null;
      } else {
         bH.debug("Failed to find path from {} to {}", new Object[]{Integer.valueOf(var1), Integer.valueOf(var2)});
         if(var3 != null) {
            var3.h = var6;
            var6 = var3;
         }

         return this.a(var13, var6);
      }
   }

   private class_auv a(class_aut var1, class_aut var2) {
      int var3 = 1;

      class_aut var4;
      for(var4 = var2; var4.h != null; var4 = var4.h) {
         ++var3;
      }

      class_aut[] var5 = new class_aut[var3];
      var4 = var2;
      --var3;

      for(var5[var3] = var2; var4.h != null; var5[var3] = var4) {
         var4 = var4.h;
         --var3;
      }

      return new class_auv(var5);
   }

   public void b(NBTTagCompound var1) {
      super.b(var1);
      var1.put("DragonPhase", this.n().a());
   }

   public void a(NBTTagCompound var1) {
      super.a(var1);
      this.a(class_us.a(var1.getInt("DragonPhase")), true);
   }

   protected void cb() {
   }

   public Entity[] aD() {
      return this.bs;
   }

   public boolean ad() {
      return false;
   }

   public World a() {
      return this.o;
   }

   protected String C() {
      return "mob.enderdragon.growl";
   }

   protected String bp() {
      return "mob.enderdragon.hit";
   }

   protected float bC() {
      return 5.0F;
   }

   private Vec3D o(float var1) {
      class_us var2 = this.n();
      Vec3D var3;
      float var5;
      if(var2 != class_us.d && var2 != class_us.e) {
         if(var2.b()) {
            float var9 = this.z;
            var5 = 1.5F;
            this.z = -6.0F * var5 * 5.0F;
            var3 = this.d(var1);
            this.z = var9;
         } else {
            var3 = this.d(var1);
         }
      } else {
         BlockPosition var4 = this.o.r(class_aqk.a);
         var5 = Math.max(MathHelper.sqrt(this.c(var4)) / 4.0F, 1.0F);
         float var6 = 6.0F / var5;
         float var7 = this.z;
         float var8 = 1.5F;
         this.z = -var6 * var8 * 5.0F;
         var3 = this.d(var1);
         this.z = var7;
      }

      return var3;
   }

   public void a(BlockPosition var1, class_pc var2) {
      EntityHuman var3;
      if(var2.j() instanceof EntityHuman) {
         var3 = (EntityHuman)var2.j();
      } else {
         var3 = this.o.a(var1, 64.0D, 64.0D);
      }

      if(var3 != null && this.a(class_us.b)) {
         this.bJ = var3;
         this.cw();
      } else if(this.bK != null && this.bK.c() % 2 == 0 && this.a(class_us.c)) {
         if(this.bV != null) {
            while(!this.bV.b()) {
               this.bV.a();
            }
         }

         this.bO = 1;
      }

   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a = new int[class_us.values().length];

      static {
         try {
            a[class_us.b.ordinal()] = 1;
         } catch (NoSuchFieldError var8) {
            ;
         }

         try {
            a[class_us.c.ordinal()] = 2;
         } catch (NoSuchFieldError var7) {
            ;
         }

         try {
            a[class_us.a.ordinal()] = 3;
         } catch (NoSuchFieldError var6) {
            ;
         }

         try {
            a[class_us.d.ordinal()] = 4;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            a[class_us.f.ordinal()] = 5;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            a[class_us.g.ordinal()] = 6;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[class_us.h.ordinal()] = 7;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[class_us.e.ordinal()] = 8;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
