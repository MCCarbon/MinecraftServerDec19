package net.minecraft.server;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Callable;

public abstract class Entity implements class_m {
   private static final AxisAlignedBB a = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
   private static int b;
   private int c;
   public double j;
   public boolean k;
   public Entity passenger;
   public Entity vehicle;
   public boolean n;
   public World o;
   public double p;
   public double q;
   public double r;
   public double s;
   public double t;
   public double u;
   public double v;
   public double motY;
   public double x;
   public float y;
   public float z;
   public float A;
   public float B;
   private AxisAlignedBB f;
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
   protected Random random;
   public int W;
   public int X;
   private int i;
   protected boolean Y;
   public int Z;
   protected boolean aa;
   protected boolean ab;
   protected Datawathcer datawatcher;
   private static final int as = Datawathcer.claimId(Entity.class);
   private static final int at = Datawathcer.claimId(Entity.class);
   private static final int au = Datawathcer.claimId(Entity.class);
   private static final int av = Datawathcer.claimId(Entity.class);
   private static final int aw = Datawathcer.claimId(Entity.class);
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
   protected BlockPosition an;
   protected Vec3D ao;
   protected EnumDirection ap;
   private boolean az;
   protected UUID uniqueID;
   private final class_n aA;
   private final List aB;
   protected boolean ar;

   public int getId() {
      return this.c;
   }

   public void e(int var1) {
      this.c = var1;
   }

   public void G() {
      this.J();
   }

   public Entity(World var1) {
      this.c = b++;
      this.j = 1.0D;
      this.f = a;
      this.J = 0.6F;
      this.K = 1.8F;
      this.h = 1;
      this.random = new Random();
      this.X = 1;
      this.aa = true;
      this.uniqueID = MathHelper.getRandomUUID(this.random);
      this.aA = new class_n();
      this.aB = Lists.newArrayList();
      this.o = var1;
      this.b(0.0D, 0.0D, 0.0D);
      if(var1 != null) {
         this.am = var1.worldProvider.p().a();
      }

      this.datawatcher = new Datawathcer(this);
      this.datawatcher.add(as, Byte.valueOf((byte)0));
      this.datawatcher.add(at, Short.valueOf((short)300));
      this.datawatcher.add(av, Byte.valueOf((byte)0));
      this.datawatcher.add(au, "");
      this.datawatcher.add(aw, Byte.valueOf((byte)0));
      this.h();
   }

   protected abstract void h();

   public Datawathcer H() {
      return this.datawatcher;
   }

   public boolean equals(Object var1) {
      return var1 instanceof Entity?((Entity)var1).c == this.c:false;
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
         this.a(new AxisAlignedBB(this.aT().xMin, this.aT().yMin, this.aT().zMin, this.aT().xMin + (double)this.J, this.aT().yMin + (double)this.K, this.aT().zMin + (double)this.J));
         if(this.J > var3 && !this.aa && !this.o.isClientSide) {
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
      this.a(new AxisAlignedBB(var1 - (double)var7, var3, var5 - (double)var7, var1 + (double)var7, var3 + (double)var8, var5 + (double)var7));
   }

   public void t_() {
      if(!this.o.isClientSide) {
         this.b(6, this.az());
      }

      this.K();
   }

   public void K() {
      this.o.B.a("entityBaseTick");
      if(this.vehicle != null && this.vehicle.I) {
         this.vehicle = null;
      }

      this.L = this.M;
      this.p = this.s;
      this.q = this.t;
      this.r = this.u;
      this.B = this.z;
      this.A = this.y;
      if(!this.o.isClientSide && this.o instanceof WorldServer) {
         this.o.B.a("portal");
         MinecraftServer var1 = ((WorldServer)this.o).s();
         int var2 = this.L();
         if(this.ak) {
            if(var1.C()) {
               if(this.vehicle == null && this.al++ >= var2) {
                  this.al = var2;
                  this.aj = this.aq();
                  byte var3;
                  if(this.o.worldProvider.p().a() == -1) {
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
      if(this.o.isClientSide) {
         this.i = 0;
      } else if(this.i > 0) {
         if(this.ab) {
            this.i -= 4;
            if(this.i < 0) {
               this.i = 0;
            }
         } else {
            if(this.i % 20 == 0) {
               this.damageEntity(class_pc.c, 1.0F);
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

      if(!this.o.isClientSide) {
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
         this.damageEntity(class_pc.d, 4.0F);
         this.f(15);
      }
   }

   public void f(int var1) {
      int var2 = var1 * 20;
      if(this instanceof EntityLiving) {
         var2 = class_ads.a((EntityLiving)this, var2);
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
      AxisAlignedBB var7 = this.aT().c(var1, var3, var5);
      return this.b(var7);
   }

   private boolean b(AxisAlignedBB var1) {
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
            this.motY = 0.0D;
            this.x = 0.0D;
         }

         double var13 = var1;
         double var15 = var3;
         double var17 = var5;
         boolean var19 = this.C && this.ax() && this instanceof EntityHuman;
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

         List var53 = this.o.a(this, this.aT().add(var1, var3, var5));
         AxisAlignedBB var21 = this.aT();

         AxisAlignedBB var23;
         for(Iterator var22 = var53.iterator(); var22.hasNext(); var3 = var23.b(this.aT(), var3)) {
            var23 = (AxisAlignedBB)var22.next();
         }

         this.a(this.aT().c(0.0D, var3, 0.0D));
         boolean var54 = this.C || var15 != var3 && var15 < 0.0D;

         AxisAlignedBB var24;
         Iterator var55;
         for(var55 = var53.iterator(); var55.hasNext(); var1 = var24.a(this.aT(), var1)) {
            var24 = (AxisAlignedBB)var55.next();
         }

         this.a(this.aT().c(var1, 0.0D, 0.0D));

         for(var55 = var53.iterator(); var55.hasNext(); var5 = var24.c(this.aT(), var5)) {
            var24 = (AxisAlignedBB)var55.next();
         }

         this.a(this.aT().c(0.0D, 0.0D, var5));
         if(this.S > 0.0F && var54 && (var13 != var1 || var17 != var5)) {
            double var56 = var1;
            double var25 = var3;
            double var27 = var5;
            AxisAlignedBB var29 = this.aT();
            this.a(var21);
            var3 = (double)this.S;
            List var30 = this.o.a(this, this.aT().add(var13, var3, var17));
            AxisAlignedBB var31 = this.aT();
            AxisAlignedBB var32 = var31.add(var13, 0.0D, var17);
            double var33 = var3;

            AxisAlignedBB var36;
            for(Iterator var35 = var30.iterator(); var35.hasNext(); var33 = var36.b(var32, var33)) {
               var36 = (AxisAlignedBB)var35.next();
            }

            var31 = var31.c(0.0D, var33, 0.0D);
            double var67 = var13;

            AxisAlignedBB var38;
            for(Iterator var37 = var30.iterator(); var37.hasNext(); var67 = var38.a(var31, var67)) {
               var38 = (AxisAlignedBB)var37.next();
            }

            var31 = var31.c(var67, 0.0D, 0.0D);
            double var68 = var17;

            AxisAlignedBB var40;
            for(Iterator var39 = var30.iterator(); var39.hasNext(); var68 = var40.c(var31, var68)) {
               var40 = (AxisAlignedBB)var39.next();
            }

            var31 = var31.c(0.0D, 0.0D, var68);
            AxisAlignedBB var69 = this.aT();
            double var70 = var3;

            AxisAlignedBB var43;
            for(Iterator var42 = var30.iterator(); var42.hasNext(); var70 = var43.b(var69, var70)) {
               var43 = (AxisAlignedBB)var42.next();
            }

            var69 = var69.c(0.0D, var70, 0.0D);
            double var71 = var13;

            AxisAlignedBB var45;
            for(Iterator var44 = var30.iterator(); var44.hasNext(); var71 = var45.a(var69, var71)) {
               var45 = (AxisAlignedBB)var44.next();
            }

            var69 = var69.c(var71, 0.0D, 0.0D);
            double var72 = var17;

            AxisAlignedBB var47;
            for(Iterator var46 = var30.iterator(); var46.hasNext(); var72 = var47.c(var69, var72)) {
               var47 = (AxisAlignedBB)var46.next();
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

            AxisAlignedBB var51;
            for(Iterator var50 = var30.iterator(); var50.hasNext(); var3 = var51.b(this.aT(), var3)) {
               var51 = (AxisAlignedBB)var50.next();
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
         int var57 = MathHelper.floor(this.s);
         int var58 = MathHelper.floor(this.t - 0.20000000298023224D);
         int var59 = MathHelper.floor(this.u);
         BlockPosition var26 = new BlockPosition(var57, var58, var59);
         Block var60 = this.o.getType(var26).getBlock();
         if(var60.getMaterial() == Material.AIR) {
            Block var28 = this.o.getType(var26.down()).getBlock();
            if(var28 instanceof class_ahz || var28 instanceof class_alv || var28 instanceof class_aia) {
               var60 = var28;
               var26 = var26.down();
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
            var60.landOn(this.o, this);
         }

         if(this.s_() && !var19 && this.vehicle == null) {
            double var61 = this.s - var7;
            double var64 = this.t - var9;
            double var66 = this.u - var11;
            if(var60 != Blocks.LADDER) {
               var64 = 0.0D;
            }

            if(var60 != null && this.C) {
               var60.onCollide(this.o, var26, this);
            }

            this.M = (float)((double)this.M + (double)MathHelper.sqrt(var61 * var61 + var66 * var66) * 0.6D);
            this.N = (float)((double)this.N + (double)MathHelper.sqrt(var61 * var61 + var64 * var64 + var66 * var66) * 0.6D);
            if(this.N > (float)this.h && var60.getMaterial() != Material.AIR) {
               this.h = (int)this.N + 1;
               if(this.V()) {
                  float var34 = MathHelper.sqrt(this.v * this.v * 0.20000000298023224D + this.motY * this.motY + this.x * this.x * 0.20000000298023224D) * 0.35F;
                  if(var34 > 1.0F) {
                     var34 = 1.0F;
                  }

                  this.a(this.P(), var34, 1.0F + (this.random.nextFloat() - this.random.nextFloat()) * 0.4F);
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
            this.a("random.fizz", 0.7F, 1.6F + (this.random.nextFloat() - this.random.nextFloat()) * 0.4F);
            this.i = -this.X;
         }

         this.o.B.b();
      }
   }

   private void m() {
      this.s = (this.aT().xMin + this.aT().xMax) / 2.0D;
      this.t = this.aT().yMin;
      this.u = (this.aT().zMin + this.aT().zMax) / 2.0D;
   }

   protected String P() {
      return "game.neutral.swim";
   }

   protected void Q() {
      BlockPosition var1 = new BlockPosition(this.aT().xMin + 0.001D, this.aT().yMin + 0.001D, this.aT().zMin + 0.001D);
      BlockPosition var2 = new BlockPosition(this.aT().xMax - 0.001D, this.aT().yMax - 0.001D, this.aT().zMax - 0.001D);
      if(this.o.areChunksLoadedBetween(var1, var2)) {
         for(int var3 = var1.getX(); var3 <= var2.getX(); ++var3) {
            for(int var4 = var1.getY(); var4 <= var2.getY(); ++var4) {
               for(int var5 = var1.getZ(); var5 <= var2.getZ(); ++var5) {
                  BlockPosition var6 = new BlockPosition(var3, var4, var5);
                  IBlockData var7 = this.o.getType(var6);

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

   protected void a(BlockPosition var1, Block var2) {
      Block.Sound var3 = var2.stepSound;
      if(this.o.getType(var1.up()).getBlock() == Blocks.SNOW_LAYER) {
         var3 = Blocks.SNOW_LAYER.stepSound;
         this.a(var3.getStepSound(), var3.getVolume() * 0.15F, var3.getPitch());
      } else if(!var2.getMaterial().isLiquid()) {
         this.a(var3.getStepSound(), var3.getVolume() * 0.15F, var3.getPitch());
      }

   }

   public void a(String var1, float var2, float var3) {
      if(!this.R()) {
         this.o.a(this, var1, var2, var3);
      }

   }

   public boolean R() {
      return this.datawatcher.getByte(aw) == 1;
   }

   public void b(boolean var1) {
      this.datawatcher.update(aw, Byte.valueOf((byte)(var1?1:0)));
   }

   protected boolean s_() {
      return true;
   }

   protected void a(double var1, boolean var3, Block var4, BlockPosition var5) {
      if(var3) {
         if(this.O > 0.0F) {
            if(var4 != null) {
               var4.fallOn(this.o, var5, this, this.O);
            } else {
               this.e(this.O, 1.0F);
            }

            this.O = 0.0F;
         }
      } else if(var1 < 0.0D) {
         this.O = (float)((double)this.O - var1);
      }

   }

   public AxisAlignedBB S() {
      return null;
   }

   protected void g(int var1) {
      if(!this.ab) {
         this.damageEntity(class_pc.a, (float)var1);
      }

   }

   public final boolean T() {
      return this.ab;
   }

   public void e(float var1, float var2) {
      if(this.passenger != null) {
         this.passenger.e(var1, var2);
      }

   }

   public boolean U() {
      return this.Y || this.o.C(new BlockPosition(this.s, this.t, this.u)) || this.o.C(new BlockPosition(this.s, this.t + (double)this.K, this.u));
   }

   public boolean V() {
      return this.Y;
   }

   public boolean W() {
      if(this.o.a(this.aT().grow(0.0D, -0.4000000059604645D, 0.0D).d(0.001D, 0.001D, 0.001D), Material.WATER, this)) {
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
      float var1 = MathHelper.sqrt(this.v * this.v * 0.20000000298023224D + this.motY * this.motY + this.x * this.x * 0.20000000298023224D) * 0.2F;
      if(var1 > 1.0F) {
         var1 = 1.0F;
      }

      this.a(this.aa(), var1, 1.0F + (this.random.nextFloat() - this.random.nextFloat()) * 0.4F);
      float var2 = (float)MathHelper.floor(this.aT().yMin);

      int var3;
      float var4;
      float var5;
      for(var3 = 0; (float)var3 < 1.0F + this.J * 20.0F; ++var3) {
         var4 = (this.random.nextFloat() * 2.0F - 1.0F) * this.J;
         var5 = (this.random.nextFloat() * 2.0F - 1.0F) * this.J;
         this.o.a(class_cy.e, this.s + (double)var4, (double)(var2 + 1.0F), this.u + (double)var5, this.v, this.motY - (double)(this.random.nextFloat() * 0.2F), this.x, new int[0]);
      }

      for(var3 = 0; (float)var3 < 1.0F + this.J * 20.0F; ++var3) {
         var4 = (this.random.nextFloat() * 2.0F - 1.0F) * this.J;
         var5 = (this.random.nextFloat() * 2.0F - 1.0F) * this.J;
         this.o.a(class_cy.f, this.s + (double)var4, (double)(var2 + 1.0F), this.u + (double)var5, this.v, this.motY, this.x, new int[0]);
      }

   }

   public void Y() {
      if(this.ay() && !this.V()) {
         this.Z();
      }

   }

   protected void Z() {
      int var1 = MathHelper.floor(this.s);
      int var2 = MathHelper.floor(this.t - 0.20000000298023224D);
      int var3 = MathHelper.floor(this.u);
      BlockPosition var4 = new BlockPosition(var1, var2, var3);
      IBlockData var5 = this.o.getType(var4);
      Block var6 = var5.getBlock();
      if(var6.getRenderType() != -1) {
         this.o.a(class_cy.L, this.s + ((double)this.random.nextFloat() - 0.5D) * (double)this.J, this.aT().yMin + 0.1D, this.u + ((double)this.random.nextFloat() - 0.5D) * (double)this.J, -this.v * 4.0D, 1.5D, -this.x * 4.0D, new int[]{Block.getCombinedId(var5)});
      }

   }

   protected String aa() {
      return "game.neutral.swim.splash";
   }

   public boolean a(Material var1) {
      double var2 = this.t + (double)this.aU();
      BlockPosition var4 = new BlockPosition(this.s, var2, this.u);
      IBlockData var5 = this.o.getType(var4);
      Block var6 = var5.getBlock();
      if(var6.getMaterial() == var1) {
         float var7 = BlockFluids.b(var5.getBlock().toLegacyData(var5)) - 0.11111111F;
         float var8 = (float)(var4.getY() + 1) - var7;
         boolean var9 = var2 < (double)var8;
         return !var9 && this instanceof EntityHuman?false:var9;
      } else {
         return false;
      }
   }

   public boolean ab() {
      return this.o.a(this.aT().grow(-0.10000000149011612D, -0.4000000059604645D, -0.10000000149011612D), Material.LAVA);
   }

   public void a(float var1, float var2, float var3) {
      float var4 = var1 * var1 + var2 * var2;
      if(var4 >= 1.0E-4F) {
         var4 = MathHelper.sqrt(var4);
         if(var4 < 1.0F) {
            var4 = 1.0F;
         }

         var4 = var3 / var4;
         var1 *= var4;
         var2 *= var4;
         float var5 = MathHelper.sin(this.y * 3.1415927F / 180.0F);
         float var6 = MathHelper.cos(this.y * 3.1415927F / 180.0F);
         this.v += (double)(var1 * var6 - var2 * var5);
         this.x += (double)(var2 * var6 + var1 * var5);
      }
   }

   public float c(float var1) {
      BlockPosition var2 = new BlockPosition(this.s, this.t + (double)this.aU(), this.u);
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

   public void a(BlockPosition var1, float var2, float var3) {
      this.b((double)var1.getX() + 0.5D, (double)var1.getY(), (double)var1.getZ() + 0.5D, var2, var3);
   }

   public void b(double var1, double var3, double var5, float var7, float var8) {
      this.P = this.p = this.s = var1;
      this.Q = this.q = this.t = var3;
      this.R = this.r = this.u = var5;
      this.y = var7;
      this.z = var8;
      this.b(this.s, this.t, this.u);
   }

   public float g(Entity var1) {
      float var2 = (float)(this.s - var1.s);
      float var3 = (float)(this.t - var1.t);
      float var4 = (float)(this.u - var1.u);
      return MathHelper.sqrt(var2 * var2 + var3 * var3 + var4 * var4);
   }

   public double e(double var1, double var3, double var5) {
      double var7 = this.s - var1;
      double var9 = this.t - var3;
      double var11 = this.u - var5;
      return var7 * var7 + var9 * var9 + var11 * var11;
   }

   public double b(BlockPosition var1) {
      return var1.distanceSquared(this.s, this.t, this.u);
   }

   public double c(BlockPosition var1) {
      return var1.distanceSquaredFromCenter(this.s, this.t, this.u);
   }

   public double f(double var1, double var3, double var5) {
      double var7 = this.s - var1;
      double var9 = this.t - var3;
      double var11 = this.u - var5;
      return (double)MathHelper.sqrt(var7 * var7 + var9 * var9 + var11 * var11);
   }

   public double h(Entity var1) {
      double var2 = this.s - var1.s;
      double var4 = this.t - var1.t;
      double var6 = this.u - var1.u;
      return var2 * var2 + var4 * var4 + var6 * var6;
   }

   public void d(EntityHuman var1) {
   }

   public void i(Entity var1) {
      if(var1.passenger != this && var1.vehicle != this) {
         if(!var1.T && !this.T) {
            double var2 = var1.s - this.s;
            double var4 = var1.u - this.u;
            double var6 = MathHelper.maxAbs(var2, var4);
            if(var6 >= 0.009999999776482582D) {
               var6 = (double)MathHelper.sqrt(var6);
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
               if(this.passenger == null) {
                  this.g(-var2, 0.0D, -var4);
               }

               if(var1.passenger == null) {
                  var1.g(var2, 0.0D, var4);
               }
            }

         }
      }
   }

   public void g(double var1, double var3, double var5) {
      this.v += var1;
      this.motY += var3;
      this.x += var5;
      this.ai = true;
   }

   protected void ac() {
      this.G = true;
   }

   public boolean damageEntity(class_pc var1, float var2) {
      if(this.b(var1)) {
         return false;
      } else {
         this.ac();
         return false;
      }
   }

   public Vec3D d(float var1) {
      if(var1 == 1.0F) {
         return this.f(this.z, this.y);
      } else {
         float var2 = this.B + (this.z - this.B) * var1;
         float var3 = this.A + (this.y - this.A) * var1;
         return this.f(var2, var3);
      }
   }

   protected final Vec3D f(float var1, float var2) {
      float var3 = MathHelper.cos(-var2 * 0.017453292F - 3.1415927F);
      float var4 = MathHelper.sin(-var2 * 0.017453292F - 3.1415927F);
      float var5 = -MathHelper.cos(-var1 * 0.017453292F);
      float var6 = MathHelper.sin(-var1 * 0.017453292F);
      return new Vec3D((double)(var4 * var5), (double)var6, (double)(var3 * var5));
   }

   public boolean ad() {
      return false;
   }

   public boolean ae() {
      return false;
   }

   public void b(Entity var1, int var2) {
   }

   public boolean c(NBTTagCompound var1) {
      String var2 = this.ag();
      if(!this.I && var2 != null) {
         var1.put("id", var2);
         this.e(var1);
         return true;
      } else {
         return false;
      }
   }

   public boolean d(NBTTagCompound var1) {
      String var2 = this.ag();
      if(!this.I && var2 != null && this.passenger == null) {
         var1.put("id", var2);
         this.e(var1);
         return true;
      } else {
         return false;
      }
   }

   public void e(NBTTagCompound var1) {
      try {
         var1.put((String)"Pos", (NBTTag)this.a(new double[]{this.s, this.t, this.u}));
         var1.put((String)"Motion", (NBTTag)this.a(new double[]{this.v, this.motY, this.x}));
         var1.put((String)"Rotation", (NBTTag)this.a(new float[]{this.y, this.z}));
         var1.put("FallDistance", this.O);
         var1.put("Fire", (short)this.i);
         var1.put("Air", (short)this.aB());
         var1.put("OnGround", this.C);
         var1.put("Dimension", this.am);
         var1.put("Invulnerable", this.az);
         var1.put("PortalCooldown", this.aj);
         var1.put("UUID", this.aM());
         if(this.aO() != null && !this.aO().isEmpty()) {
            var1.put("CustomName", this.aO());
            var1.put("CustomNameVisible", this.aP());
         }

         this.aA.b(var1);
         if(this.R()) {
            var1.put("Silent", this.R());
         }

         if(this.ar) {
            var1.put("Glowing", this.ar);
         }

         this.write(var1);
         if(this.vehicle != null) {
            NBTTagCompound var2 = new NBTTagCompound();
            if(this.vehicle.c(var2)) {
               var1.put((String)"Riding", (NBTTag)var2);
            }
         }

      } catch (Throwable var5) {
         class_b var3 = class_b.a(var5, "Saving entity NBT");
         class_c var4 = var3.a("Entity being saved");
         this.a(var4);
         throw new class_e(var3);
      }
   }

   public void f(NBTTagCompound var1) {
      try {
         NBTTagList var2 = var1.getList("Pos", 6);
         NBTTagList var7 = var1.getList("Motion", 6);
         NBTTagList var8 = var1.getList("Rotation", 5);
         this.v = var7.getDouble(0);
         this.motY = var7.getDouble(1);
         this.x = var7.getDouble(2);
         if(Math.abs(this.v) > 10.0D) {
            this.v = 0.0D;
         }

         if(Math.abs(this.motY) > 10.0D) {
            this.motY = 0.0D;
         }

         if(Math.abs(this.x) > 10.0D) {
            this.x = 0.0D;
         }

         this.p = this.P = this.s = var2.getDouble(0);
         this.q = this.Q = this.t = var2.getDouble(1);
         this.r = this.R = this.u = var2.getDouble(2);
         this.A = this.y = var8.getFloat(0);
         this.B = this.z = var8.getFloat(1);
         this.f(this.y);
         this.g(this.y);
         this.O = var1.getFloat("FallDistance");
         this.i = var1.getShort("Fire");
         this.i(var1.getShort("Air"));
         this.C = var1.getBoolean("OnGround");
         this.am = var1.getInt("Dimension");
         this.az = var1.getBoolean("Invulnerable");
         this.aj = var1.getInt("PortalCooldown");
         UUID var5 = var1.getUUID("UUID");
         if(var5 != null) {
            this.uniqueID = var5;
         } else if(var1.hasOfType("UUID", 8)) {
            this.uniqueID = UUID.fromString(var1.getString("UUID"));
         }

         this.b(this.s, this.t, this.u);
         this.b(this.y, this.z);
         if(var1.hasOfType("CustomName", 8) && !var1.getString("CustomName").isEmpty()) {
            this.a(var1.getString("CustomName"));
         }

         this.g(var1.getBoolean("CustomNameVisible"));
         this.aA.a(var1);
         this.b(var1.getBoolean("Silent"));
         this.ar = var1.getBoolean("Glowing");
         this.read(var1);
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
      return EntityTypes.b(this);
   }

   protected abstract void read(NBTTagCompound var1);

   protected abstract void write(NBTTagCompound var1);

   public void ah() {
   }

   protected NBTTagList a(double... var1) {
      NBTTagList var2 = new NBTTagList();
      double[] var3 = var1;
      int var4 = var1.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         double var6 = var3[var5];
         var2.add((NBTTag)(new NBTTagDouble(var6)));
      }

      return var2;
   }

   protected NBTTagList a(float... var1) {
      NBTTagList var2 = new NBTTagList();
      float[] var3 = var1;
      int var4 = var1.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         float var6 = var3[var5];
         var2.add((NBTTag)(new NBTTagFloat(var6)));
      }

      return var2;
   }

   public EntityItem a(Item var1, int var2) {
      return this.a(var1, var2, 0.0F);
   }

   public EntityItem a(Item var1, int var2, float var3) {
      return this.a(new ItemStack(var1, var2, 0), var3);
   }

   public EntityItem a(ItemStack var1, float var2) {
      if(var1.count != 0 && var1.getItem() != null) {
         EntityItem var3 = new EntityItem(this.o, this.s, this.t + (double)var2, this.u, var1);
         var3.setPickupDelay();
         this.o.addEntity((Entity)var3);
         return var3;
      } else {
         return null;
      }
   }

   public boolean isAlive() {
      return !this.I;
   }

   public boolean aj() {
      if(this.T) {
         return false;
      } else {
         BlockPosition.MutableBlockPosition var1 = new BlockPosition.MutableBlockPosition(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);

         for(int var2 = 0; var2 < 8; ++var2) {
            int var3 = MathHelper.floor(this.t + (double)(((float)((var2 >> 0) % 2) - 0.5F) * 0.1F) + (double)this.aU());
            int var4 = MathHelper.floor(this.s + (double)(((float)((var2 >> 1) % 2) - 0.5F) * this.J * 0.8F));
            int var5 = MathHelper.floor(this.u + (double)(((float)((var2 >> 2) % 2) - 0.5F) * this.J * 0.8F));
            if(var1.getX() != var4 || var1.getY() != var3 || var1.getZ() != var5) {
               var1.setPosition(var4, var3, var5);
               if(this.o.getType(var1).getBlock().isVisuallyOpaque()) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   public boolean a(EntityHuman var1, ItemStack var2, EnumUsedHand var3) {
      return false;
   }

   public AxisAlignedBB j(Entity var1) {
      return null;
   }

   public void ak() {
      if(this.vehicle.I) {
         this.vehicle = null;
      } else {
         this.v = 0.0D;
         this.motY = 0.0D;
         this.x = 0.0D;
         this.t_();
         if(this.vehicle != null) {
            this.vehicle.al();
            this.ay += (double)(this.vehicle.y - this.vehicle.A);

            for(this.ax += (double)(this.vehicle.z - this.vehicle.B); this.ay >= 180.0D; this.ay -= 360.0D) {
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
      if(this.passenger != null) {
         this.passenger.b(this.s, this.t + this.an() + this.passenger.am(), this.u);
      }
   }

   public double am() {
      return 0.0D;
   }

   public double an() {
      return (double)this.K * 0.75D;
   }

   public void a(Entity var1) {
      this.ax = 0.0D;
      this.ay = 0.0D;
      if(var1 == null) {
         if(this.vehicle != null) {
            this.b(this.vehicle.s, this.vehicle.aT().yMin + (double)this.vehicle.K, this.vehicle.u, this.y, this.z);
            this.vehicle.passenger = null;
         }

         this.vehicle = null;
      } else {
         if(this.vehicle != null) {
            this.vehicle.passenger = null;
         }

         if(var1 != null) {
            for(Entity var2 = var1.vehicle; var2 != null; var2 = var2.vehicle) {
               if(var2 == this) {
                  return;
               }
            }
         }

         this.vehicle = var1;
         var1.passenger = this;
      }
   }

   public float ao() {
      return 0.1F;
   }

   public Vec3D ap() {
      return null;
   }

   public void d(BlockPosition var1) {
      if(this.aj > 0) {
         this.aj = this.aq();
      } else {
         if(!this.o.isClientSide && !var1.equals(this.an)) {
            this.an = var1;
            class_anp.class_b_in_class_anp var2 = Blocks.PORTAL.f(this.o, var1);
            double var3 = var2.b().getAxis() == EnumDirection.EnumAxis.X?(double)var2.a().getZ():(double)var2.a().getX();
            double var5 = var2.b().getAxis() == EnumDirection.EnumAxis.X?this.u:this.s;
            var5 = Math.abs(MathHelper.c(var5 - (double)(var2.b().rotateY().getAxisDirection() == EnumDirection.EnumAxisDirection.NEGATIVE?1:0), var3, var3 - (double)var2.d()));
            double var7 = MathHelper.c(this.t - 1.0D, (double)var2.a().getY(), (double)(var2.a().getY() - var2.e()));
            this.ao = new Vec3D(var5, var7, 0.0D);
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

   public void a(class_pw var1, ItemStack var2) {
   }

   public boolean av() {
      boolean var1 = this.o != null && this.o.isClientSide;
      return !this.ab && (this.i > 0 || var1 && this.h(0));
   }

   public boolean aw() {
      return this.vehicle != null;
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
      return this.ar || this.o.isClientSide && this.h(6);
   }

   public boolean aA() {
      return this.h(5);
   }

   public void f(boolean var1) {
      this.b(5, var1);
   }

   protected boolean h(int var1) {
      return (this.datawatcher.getByte(as) & 1 << var1) != 0;
   }

   protected void b(int var1, boolean var2) {
      byte var3 = this.datawatcher.getByte(as);
      if(var2) {
         this.datawatcher.update(as, Byte.valueOf((byte)(var3 | 1 << var1)));
      } else {
         this.datawatcher.update(as, Byte.valueOf((byte)(var3 & ~(1 << var1))));
      }

   }

   public int aB() {
      return this.datawatcher.getShort(at);
   }

   public void i(int var1) {
      this.datawatcher.update(at, Short.valueOf((short)var1));
   }

   public void a(class_vi var1) {
      this.damageEntity(class_pc.b, 5.0F);
      ++this.i;
      if(this.i == 0) {
         this.f(8);
      }

   }

   public void a(EntityLiving var1) {
   }

   protected boolean j(double var1, double var3, double var5) {
      BlockPosition var7 = new BlockPosition(var1, var3, var5);
      double var8 = var1 - (double)var7.getX();
      double var10 = var3 - (double)var7.getY();
      double var12 = var5 - (double)var7.getZ();
      List var14 = this.o.a(this.aT());
      if(var14.isEmpty() && !this.o.u(var7)) {
         return false;
      } else {
         byte var15 = 3;
         double var16 = 9999.0D;
         if(!this.o.u(var7.west()) && var8 < var16) {
            var16 = var8;
            var15 = 0;
         }

         if(!this.o.u(var7.east()) && 1.0D - var8 < var16) {
            var16 = 1.0D - var8;
            var15 = 1;
         }

         if(!this.o.u(var7.up()) && 1.0D - var10 < var16) {
            var16 = 1.0D - var10;
            var15 = 3;
         }

         if(!this.o.u(var7.north()) && var12 < var16) {
            var16 = var12;
            var15 = 4;
         }

         if(!this.o.u(var7.south()) && 1.0D - var12 < var16) {
            var16 = 1.0D - var12;
            var15 = 5;
         }

         float var18 = this.random.nextFloat() * 0.2F + 0.1F;
         if(var15 == 0) {
            this.v = (double)(-var18);
         }

         if(var15 == 1) {
            this.v = (double)var18;
         }

         if(var15 == 3) {
            this.motY = (double)var18;
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

   public String getName() {
      if(this.hasCustomName()) {
         return this.aO();
      } else {
         String var1 = EntityTypes.b(this);
         if(var1 == null) {
            var1 = "generic";
         }

         return LocaleI18n.get("entity." + var1 + ".name");
      }
   }

   public Entity[] aD() {
      return null;
   }

   public boolean k(Entity var1) {
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

   public boolean l(Entity var1) {
      return false;
   }

   public String toString() {
      return String.format("%s[\'%s\'/%d, l=\'%s\', x=%.2f, y=%.2f, z=%.2f]", new Object[]{this.getClass().getSimpleName(), this.getName(), Integer.valueOf(this.c), this.o == null?"~NULL~":this.o.Q().k(), Double.valueOf(this.s), Double.valueOf(this.t), Double.valueOf(this.u)});
   }

   public boolean b(class_pc var1) {
      return this.az && var1 != class_pc.j && !var1.u();
   }

   public void m(Entity var1) {
      this.b(var1.s, var1.t, var1.u, var1.y, var1.z);
   }

   public void n(Entity var1) {
      NBTTagCompound var2 = new NBTTagCompound();
      var1.e(var2);
      this.f(var2);
      this.aj = var1.aj;
      this.an = var1.an;
      this.ao = var1.ao;
      this.ap = var1.ap;
   }

   public void c(int var1) {
      if(!this.o.isClientSide && !this.I) {
         this.o.B.a("changeDimension");
         MinecraftServer var2 = MinecraftServer.N();
         int var3 = this.am;
         WorldServer var4 = var2.getWorldServer(var3);
         WorldServer var5 = var2.getWorldServer(var1);
         this.am = var1;
         if(var3 == 1 && var1 == 1) {
            var5 = var2.getWorldServer(0);
            this.am = 0;
         }

         this.o.e(this);
         this.I = false;
         this.o.B.a("reposition");
         var2.getPlayerList().a(this, var3, var4, var5);
         this.o.B.c("reloading");
         Entity var6 = EntityTypes.a((String) EntityTypes.b(this), (World) var5);
         if(var6 != null) {
            var6.n(this);
            if(var3 == 1 && var1 == 1) {
               BlockPosition var7 = this.o.r(var5.N());
               var6.a(var7, var6.y, var6.z);
            }

            var5.addEntity(var6);
         }

         this.I = true;
         this.o.B.b();
         var4.k();
         var5.k();
         this.o.B.b();
      }
   }

   public float a(Explosion var1, World var2, BlockPosition var3, IBlockData var4) {
      return var4.getBlock().getResistance(this);
   }

   public boolean a(Explosion var1, World var2, BlockPosition var3, IBlockData var4, float var5) {
      return true;
   }

   public int aG() {
      return 3;
   }

   public Vec3D aI() {
      return this.ao;
   }

   public EnumDirection aJ() {
      return this.ap;
   }

   public boolean aK() {
      return false;
   }

   public void a(class_c var1) {
      var1.a("Entity Type", new Callable() {
         public String a() throws Exception {
            return EntityTypes.b(Entity.this) + " (" + Entity.this.getClass().getCanonicalName() + ")";
         }

         // $FF: synthetic method
         public Object call() throws Exception {
            return this.a();
         }
      });
      var1.a((String)"Entity ID", (Object)Integer.valueOf(this.c));
      var1.a("Entity Name", new Callable() {
         public String a() throws Exception {
            return Entity.this.getName();
         }

         // $FF: synthetic method
         public Object call() throws Exception {
            return this.a();
         }
      });
      var1.a((String)"Entity\'s Exact location", (Object)String.format("%.2f, %.2f, %.2f", new Object[]{Double.valueOf(this.s), Double.valueOf(this.t), Double.valueOf(this.u)}));
      var1.a((String)"Entity\'s Block location", (Object)class_c.a((double)MathHelper.floor(this.s), (double)MathHelper.floor(this.t), (double)MathHelper.floor(this.u)));
      var1.a((String)"Entity\'s Momentum", (Object)String.format("%.2f, %.2f, %.2f", new Object[]{Double.valueOf(this.v), Double.valueOf(this.motY), Double.valueOf(this.x)}));
      var1.a("Entity\'s Rider", new Callable() {
         public String a() throws Exception {
            return Entity.this.passenger.toString();
         }

         // $FF: synthetic method
         public Object call() throws Exception {
            return this.a();
         }
      });
      var1.a("Entity\'s Vehicle", new Callable() {
         public String a() throws Exception {
            return Entity.this.vehicle.toString();
         }

         // $FF: synthetic method
         public Object call() throws Exception {
            return this.a();
         }
      });
   }

   public UUID aM() {
      return this.uniqueID;
   }

   public boolean aN() {
      return true;
   }

   public IChatBaseComponent getScoreboardDisplayName() {
      ChatComponentText var1 = new ChatComponentText(this.getName());
      var1.b().a(this.aS());
      var1.b().a(this.aM().toString());
      return var1;
   }

   public void a(String var1) {
      this.datawatcher.update(au, var1);
   }

   public String aO() {
      return this.datawatcher.getString(au);
   }

   public boolean hasCustomName() {
      return !this.datawatcher.getString(au).isEmpty();
   }

   public void g(boolean var1) {
      this.datawatcher.update(av, Byte.valueOf((byte)(var1?1:0)));
   }

   public boolean aP() {
      return this.datawatcher.getByte(av) == 1;
   }

   public void a(double var1, double var3, double var5) {
      this.b(var1, var3, var5, this.y, this.z);
   }

   public void d(int var1) {
   }

   public EnumDirection aR() {
      return EnumDirection.getByHorizontalId(MathHelper.floor((double)(this.y * 4.0F / 360.0F) + 0.5D) & 3);
   }

   protected class_ew aS() {
      NBTTagCompound var1 = new NBTTagCompound();
      String var2 = EntityTypes.b(this);
      var1.put("id", this.aM().toString());
      if(var2 != null) {
         var1.put("type", var2);
      }

      var1.put("name", this.getName());
      return new class_ew(class_ew.class_a_in_class_ew.d, new ChatComponentText(var1.toString()));
   }

   public boolean a(EntityPlayer var1) {
      return true;
   }

   public AxisAlignedBB aT() {
      return this.f;
   }

   public void a(AxisAlignedBB var1) {
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

   public boolean c(int var1, ItemStack var2) {
      return false;
   }

   public void a(IChatBaseComponent var1) {
   }

   public boolean a(int var1, String var2) {
      return true;
   }

   public BlockPosition c() {
      return new BlockPosition(this.s, this.t + 0.5D, this.u);
   }

   public Vec3D d() {
      return new Vec3D(this.s, this.t, this.u);
   }

   public World e() {
      return this.o;
   }

   public Entity f() {
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

   public void o(Entity var1) {
      this.aA.a(var1.aW());
   }

   public UseResult a(EntityHuman var1, Vec3D var2, ItemStack var3, EnumUsedHand var4) {
      return UseResult.CANT_USE;
   }

   public boolean aX() {
      return false;
   }

   protected void a(EntityLiving var1, Entity var2) {
      if(var2 instanceof EntityLiving) {
         EnchantmentManager.a((EntityLiving)((EntityLiving)var2), (Entity)var1);
      }

      EnchantmentManager.b(var1, var2);
   }

   public void b(EntityPlayer var1) {
   }

   public void c(EntityPlayer var1) {
   }

   public float a(Block.EnumRotation var1) {
      float var2 = MathHelper.clampAngle(this.y);
      switch(Entity.SyntheticClass_1.a[var1.ordinal()]) {
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
      float var2 = MathHelper.clampAngle(this.y);
      switch(Entity.SyntheticClass_1.b[var1.ordinal()]) {
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
            b[Block.class_a_in_class_agj.LEFT_RIGHT.ordinal()] = 1;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            b[Block.class_a_in_class_agj.FRONT_BACK.ordinal()] = 2;
         } catch (NoSuchFieldError var4) {
            ;
         }

         a = new int[Block.EnumRotation.values().length];

         try {
            a[Block.EnumRotation.CLOCKWISE_180.ordinal()] = 1;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[Block.EnumRotation.COUNTERCLOCKWISE_90.ordinal()] = 2;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[Block.EnumRotation.CLOCKWISE_90.ordinal()] = 3;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
