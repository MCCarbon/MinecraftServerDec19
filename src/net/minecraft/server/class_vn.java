package net.minecraft.server;

import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;

public abstract class class_vn extends Entity implements INamableTileEntity {
   private static final int a = Datawathcer.claimId(class_vn.class);
   private static final int b = Datawathcer.claimId(class_vn.class);
   private static final int c = Datawathcer.claimId(class_vn.class);
   private static final int d = Datawathcer.claimId(class_vn.class);
   private static final int e = Datawathcer.claimId(class_vn.class);
   private static final int f = Datawathcer.claimId(class_vn.class);
   private boolean g;
   private String h;
   private static final int[][][] i = new int[][][]{{{0, 0, -1}, {0, 0, 1}}, {{-1, 0, 0}, {1, 0, 0}}, {{-1, -1, 0}, {1, 0, 0}}, {{-1, 0, 0}, {1, -1, 0}}, {{0, 0, -1}, {0, -1, 1}}, {{0, -1, -1}, {0, 0, 1}}, {{0, 0, 1}, {1, 0, 0}}, {{0, 0, 1}, {-1, 0, 0}}, {{0, 0, -1}, {-1, 0, 0}}, {{0, 0, -1}, {1, 0, 0}}};
   private int as;
   private double at;
   private double au;
   private double av;
   private double aw;
   private double ax;

   public class_vn(World var1) {
      super(var1);
      this.k = true;
      this.a(0.98F, 0.7F);
   }

   public static class_vn a(World var0, double var1, double var3, double var5, class_vn.class_a_in_class_vn var7) {
      switch(class_vn.SyntheticClass_1.a[var7.ordinal()]) {
      case 1:
         return new class_vo(var0, var1, var3, var5);
      case 2:
         return new class_vr(var0, var1, var3, var5);
      case 3:
         return new class_vv(var0, var1, var3, var5);
      case 4:
         return new class_vu(var0, var1, var3, var5);
      case 5:
         return new class_vs(var0, var1, var3, var5);
      case 6:
         return new class_vp(var0, var1, var3, var5);
      default:
         return new class_vt(var0, var1, var3, var5);
      }
   }

   protected boolean s_() {
      return false;
   }

   protected void h() {
      this.datawatcher.add(a, new Integer(0));
      this.datawatcher.add(b, new Integer(1));
      this.datawatcher.add(c, new Float(0.0F));
      this.datawatcher.add(d, new Integer(0));
      this.datawatcher.add(e, new Integer(6));
      this.datawatcher.add(f, Byte.valueOf((byte)0));
   }

   public AxisAlignedBB j(Entity var1) {
      return var1.ae()?var1.aT():null;
   }

   public AxisAlignedBB S() {
      return null;
   }

   public boolean ae() {
      return true;
   }

   public class_vn(World var1, double var2, double var4, double var6) {
      this(var1);
      this.b(var2, var4, var6);
      this.v = 0.0D;
      this.motY = 0.0D;
      this.x = 0.0D;
      this.p = var2;
      this.q = var4;
      this.r = var6;
   }

   public double an() {
      return 0.0D;
   }

   public boolean damageEntity(class_pc var1, float var2) {
      if(!this.o.isClientSide && !this.I) {
         if(this.b(var1)) {
            return false;
         } else {
            this.k(-this.r());
            this.j(10);
            this.ac();
            this.a(this.p() + var2 * 10.0F);
            boolean var3 = var1.j() instanceof EntityHuman && ((EntityHuman)var1.j()).abilities.instabuild;
            if(var3 || this.p() > 40.0F) {
               if(this.passenger != null) {
                  this.passenger.a((Entity)null);
               }

               if(var3 && !this.hasCustomName()) {
                  this.J();
               } else {
                  this.a(var1);
               }
            }

            return true;
         }
      } else {
         return true;
      }
   }

   public void a(class_pc var1) {
      this.J();
      if(this.o.R().b("doEntityDrops")) {
         ItemStack var2 = new ItemStack(Items.MINECART, 1);
         if(this.h != null) {
            var2.setDisplayName(this.h);
         }

         this.a(var2, 0.0F);
      }

   }

   public boolean ad() {
      return !this.I;
   }

   public void J() {
      super.J();
   }

   public void t_() {
      if(this.q() > 0) {
         this.j(this.q() - 1);
      }

      if(this.p() > 0.0F) {
         this.a(this.p() - 1.0F);
      }

      if(this.t < -64.0D) {
         this.O();
      }

      int var2;
      if(!this.o.isClientSide && this.o instanceof WorldServer) {
         this.o.B.a("portal");
         MinecraftServer var1 = ((WorldServer)this.o).s();
         var2 = this.L();
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

      if(this.o.isClientSide) {
         if(this.as > 0) {
            double var15 = this.s + (this.at - this.s) / (double)this.as;
            double var17 = this.t + (this.au - this.t) / (double)this.as;
            double var18 = this.u + (this.av - this.u) / (double)this.as;
            double var7 = MathHelper.clampAngle(this.aw - (double)this.y);
            this.y = (float)((double)this.y + var7 / (double)this.as);
            this.z = (float)((double)this.z + (this.ax - (double)this.z) / (double)this.as);
            --this.as;
            this.b(var15, var17, var18);
            this.b(this.y, this.z);
         } else {
            this.b(this.s, this.t, this.u);
            this.b(this.y, this.z);
         }

      } else {
         this.p = this.s;
         this.q = this.t;
         this.r = this.u;
         this.motY -= 0.03999999910593033D;
         int var14 = MathHelper.floor(this.s);
         var2 = MathHelper.floor(this.t);
         int var16 = MathHelper.floor(this.u);
         if(BlockMinecartTrackAbstract.e(this.o, new BlockPosition(var14, var2 - 1, var16))) {
            --var2;
         }

         BlockPosition var4 = new BlockPosition(var14, var2, var16);
         IBlockData var5 = this.o.getType(var4);
         if(BlockMinecartTrackAbstract.d(var5)) {
            this.a(var4, var5);
            if(var5.getBlock() == Blocks.ACTIVATOR_RAIL) {
               this.a(var14, var2, var16, ((Boolean)var5.get(BlockPoweredRail.POWERED)).booleanValue());
            }
         } else {
            this.n();
         }

         this.Q();
         this.z = 0.0F;
         double var6 = this.p - this.s;
         double var8 = this.r - this.u;
         if(var6 * var6 + var8 * var8 > 0.001D) {
            this.y = (float)(MathHelper.b(var8, var6) * 180.0D / 3.141592653589793D);
            if(this.g) {
               this.y += 180.0F;
            }
         }

         double var10 = (double)MathHelper.clampAngle(this.y - this.A);
         if(var10 < -170.0D || var10 >= 170.0D) {
            this.y += 180.0F;
            this.g = !this.g;
         }

         this.b(this.y, this.z);
         Iterator var12 = this.o.getEntities((Entity)this, (AxisAlignedBB)this.aT().grow(0.20000000298023224D, 0.0D, 0.20000000298023224D)).iterator();

         while(var12.hasNext()) {
            Entity var13 = (Entity)var12.next();
            if(var13 != this.passenger && var13.ae() && var13 instanceof class_vn) {
               var13.i(this);
            }
         }

         if(this.passenger != null && this.passenger.I) {
            if(this.passenger.vehicle == this) {
               this.passenger.vehicle = null;
            }

            this.passenger = null;
         }

         this.W();
      }
   }

   protected double m() {
      return 0.4D;
   }

   public void a(int var1, int var2, int var3, boolean var4) {
   }

   protected void n() {
      double var1 = this.m();
      this.v = MathHelper.clamp(this.v, -var1, var1);
      this.x = MathHelper.clamp(this.x, -var1, var1);
      if(this.C) {
         this.v *= 0.5D;
         this.motY *= 0.5D;
         this.x *= 0.5D;
      }

      this.d(this.v, this.motY, this.x);
      if(!this.C) {
         this.v *= 0.949999988079071D;
         this.motY *= 0.949999988079071D;
         this.x *= 0.949999988079071D;
      }

   }

   protected void a(BlockPosition var1, IBlockData var2) {
      this.O = 0.0F;
      Vec3D var3 = this.k(this.s, this.t, this.u);
      this.t = (double)var1.getY();
      boolean var4 = false;
      boolean var5 = false;
      BlockMinecartTrackAbstract var6 = (BlockMinecartTrackAbstract)var2.getBlock();
      if(var6 == Blocks.GOLDEN_RAIL) {
         var4 = ((Boolean)var2.get(BlockPoweredRail.POWERED)).booleanValue();
         var5 = !var4;
      }

      double var7 = 0.0078125D;
      BlockMinecartTrackAbstract.EnumTrackPosition var9 = (BlockMinecartTrackAbstract.EnumTrackPosition)var2.get(var6.n());
      switch(class_vn.SyntheticClass_1.b[var9.ordinal()]) {
      case 1:
         this.v -= 0.0078125D;
         ++this.t;
         break;
      case 2:
         this.v += 0.0078125D;
         ++this.t;
         break;
      case 3:
         this.x += 0.0078125D;
         ++this.t;
         break;
      case 4:
         this.x -= 0.0078125D;
         ++this.t;
      }

      int[][] var10 = i[var9.getId()];
      double var11 = (double)(var10[1][0] - var10[0][0]);
      double var13 = (double)(var10[1][2] - var10[0][2]);
      double var15 = Math.sqrt(var11 * var11 + var13 * var13);
      double var17 = this.v * var11 + this.x * var13;
      if(var17 < 0.0D) {
         var11 = -var11;
         var13 = -var13;
      }

      double var19 = Math.sqrt(this.v * this.v + this.x * this.x);
      if(var19 > 2.0D) {
         var19 = 2.0D;
      }

      this.v = var19 * var11 / var15;
      this.x = var19 * var13 / var15;
      double var21;
      double var23;
      double var25;
      double var27;
      if(this.passenger instanceof EntityLiving) {
         var21 = (double)((EntityLiving)this.passenger).bd;
         if(var21 > 0.0D) {
            var23 = -Math.sin((double)(this.passenger.y * 3.1415927F / 180.0F));
            var25 = Math.cos((double)(this.passenger.y * 3.1415927F / 180.0F));
            var27 = this.v * this.v + this.x * this.x;
            if(var27 < 0.01D) {
               this.v += var23 * 0.1D;
               this.x += var25 * 0.1D;
               var5 = false;
            }
         }
      }

      if(var5) {
         var21 = Math.sqrt(this.v * this.v + this.x * this.x);
         if(var21 < 0.03D) {
            this.v *= 0.0D;
            this.motY *= 0.0D;
            this.x *= 0.0D;
         } else {
            this.v *= 0.5D;
            this.motY *= 0.0D;
            this.x *= 0.5D;
         }
      }

      var21 = 0.0D;
      var23 = (double)var1.getX() + 0.5D + (double)var10[0][0] * 0.5D;
      var25 = (double)var1.getZ() + 0.5D + (double)var10[0][2] * 0.5D;
      var27 = (double)var1.getX() + 0.5D + (double)var10[1][0] * 0.5D;
      double var29 = (double)var1.getZ() + 0.5D + (double)var10[1][2] * 0.5D;
      var11 = var27 - var23;
      var13 = var29 - var25;
      double var31;
      double var33;
      if(var11 == 0.0D) {
         this.s = (double)var1.getX() + 0.5D;
         var21 = this.u - (double)var1.getZ();
      } else if(var13 == 0.0D) {
         this.u = (double)var1.getZ() + 0.5D;
         var21 = this.s - (double)var1.getX();
      } else {
         var31 = this.s - var23;
         var33 = this.u - var25;
         var21 = (var31 * var11 + var33 * var13) * 2.0D;
      }

      this.s = var23 + var11 * var21;
      this.u = var25 + var13 * var21;
      this.b(this.s, this.t, this.u);
      var31 = this.v;
      var33 = this.x;
      if(this.passenger != null) {
         var31 *= 0.75D;
         var33 *= 0.75D;
      }

      double var35 = this.m();
      var31 = MathHelper.clamp(var31, -var35, var35);
      var33 = MathHelper.clamp(var33, -var35, var35);
      this.d(var31, 0.0D, var33);
      if(var10[0][1] != 0 && MathHelper.floor(this.s) - var1.getX() == var10[0][0] && MathHelper.floor(this.u) - var1.getZ() == var10[0][2]) {
         this.b(this.s, this.t + (double)var10[0][1], this.u);
      } else if(var10[1][1] != 0 && MathHelper.floor(this.s) - var1.getX() == var10[1][0] && MathHelper.floor(this.u) - var1.getZ() == var10[1][2]) {
         this.b(this.s, this.t + (double)var10[1][1], this.u);
      }

      this.o();
      Vec3D var37 = this.k(this.s, this.t, this.u);
      if(var37 != null && var3 != null) {
         double var38 = (var3.y - var37.y) * 0.05D;
         var19 = Math.sqrt(this.v * this.v + this.x * this.x);
         if(var19 > 0.0D) {
            this.v = this.v / var19 * (var19 + var38);
            this.x = this.x / var19 * (var19 + var38);
         }

         this.b(this.s, var37.y, this.u);
      }

      int var44 = MathHelper.floor(this.s);
      int var39 = MathHelper.floor(this.u);
      if(var44 != var1.getX() || var39 != var1.getZ()) {
         var19 = Math.sqrt(this.v * this.v + this.x * this.x);
         this.v = var19 * (double)(var44 - var1.getX());
         this.x = var19 * (double)(var39 - var1.getZ());
      }

      if(var4) {
         double var40 = Math.sqrt(this.v * this.v + this.x * this.x);
         if(var40 > 0.01D) {
            double var42 = 0.06D;
            this.v += this.v / var40 * var42;
            this.x += this.x / var40 * var42;
         } else if(var9 == BlockMinecartTrackAbstract.EnumTrackPosition.EAST_WEST) {
            if(this.o.getType(var1.west()).getBlock().isOccluding()) {
               this.v = 0.02D;
            } else if(this.o.getType(var1.east()).getBlock().isOccluding()) {
               this.v = -0.02D;
            }
         } else if(var9 == BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_SOUTH) {
            if(this.o.getType(var1.north()).getBlock().isOccluding()) {
               this.x = 0.02D;
            } else if(this.o.getType(var1.south()).getBlock().isOccluding()) {
               this.x = -0.02D;
            }
         }
      }

   }

   protected void o() {
      if(this.passenger != null) {
         this.v *= 0.996999979019165D;
         this.motY *= 0.0D;
         this.x *= 0.996999979019165D;
      } else {
         this.v *= 0.9599999785423279D;
         this.motY *= 0.0D;
         this.x *= 0.9599999785423279D;
      }

   }

   public void b(double var1, double var3, double var5) {
      this.s = var1;
      this.t = var3;
      this.u = var5;
      float var7 = this.J / 2.0F;
      float var8 = this.K;
      this.a((AxisAlignedBB)(new AxisAlignedBB(var1 - (double)var7, var3, var5 - (double)var7, var1 + (double)var7, var3 + (double)var8, var5 + (double)var7)));
   }

   public Vec3D k(double var1, double var3, double var5) {
      int var7 = MathHelper.floor(var1);
      int var8 = MathHelper.floor(var3);
      int var9 = MathHelper.floor(var5);
      if(BlockMinecartTrackAbstract.e(this.o, new BlockPosition(var7, var8 - 1, var9))) {
         --var8;
      }

      IBlockData var10 = this.o.getType(new BlockPosition(var7, var8, var9));
      if(BlockMinecartTrackAbstract.d(var10)) {
         BlockMinecartTrackAbstract.EnumTrackPosition var11 = (BlockMinecartTrackAbstract.EnumTrackPosition)var10.get(((BlockMinecartTrackAbstract)var10.getBlock()).n());
         int[][] var12 = i[var11.getId()];
         double var13 = 0.0D;
         double var15 = (double)var7 + 0.5D + (double)var12[0][0] * 0.5D;
         double var17 = (double)var8 + 0.0625D + (double)var12[0][1] * 0.5D;
         double var19 = (double)var9 + 0.5D + (double)var12[0][2] * 0.5D;
         double var21 = (double)var7 + 0.5D + (double)var12[1][0] * 0.5D;
         double var23 = (double)var8 + 0.0625D + (double)var12[1][1] * 0.5D;
         double var25 = (double)var9 + 0.5D + (double)var12[1][2] * 0.5D;
         double var27 = var21 - var15;
         double var29 = (var23 - var17) * 2.0D;
         double var31 = var25 - var19;
         if(var27 == 0.0D) {
            var1 = (double)var7 + 0.5D;
            var13 = var5 - (double)var9;
         } else if(var31 == 0.0D) {
            var5 = (double)var9 + 0.5D;
            var13 = var1 - (double)var7;
         } else {
            double var33 = var1 - var15;
            double var35 = var5 - var19;
            var13 = (var33 * var27 + var35 * var31) * 2.0D;
         }

         var1 = var15 + var27 * var13;
         var3 = var17 + var29 * var13;
         var5 = var19 + var31 * var13;
         if(var29 < 0.0D) {
            ++var3;
         }

         if(var29 > 0.0D) {
            var3 += 0.5D;
         }

         return new Vec3D(var1, var3, var5);
      } else {
         return null;
      }
   }

   protected void read(NBTTagCompound var1) {
      if(var1.getBoolean("CustomDisplayTile")) {
         int var2 = var1.getInt("DisplayData");
         Block var3;
         if(var1.hasOfType("DisplayTile", 8)) {
            var3 = Block.getByName(var1.getString("DisplayTile"));
            if(var3 == null) {
               this.a(Blocks.AIR.getBlockData());
            } else {
               this.a(var3.fromLegacyData(var2));
            }
         } else {
            var3 = Block.getById(var1.getInt("DisplayTile"));
            if(var3 == null) {
               this.a(Blocks.AIR.getBlockData());
            } else {
               this.a(var3.fromLegacyData(var2));
            }
         }

         this.l(var1.getInt("DisplayOffset"));
      }

      if(var1.hasOfType("CustomName", 8) && !var1.getString("CustomName").isEmpty()) {
         this.h = var1.getString("CustomName");
      }

   }

   protected void write(NBTTagCompound var1) {
      if(this.x()) {
         var1.put("CustomDisplayTile", true);
         IBlockData var2 = this.t();
         MinecraftKey var3 = (MinecraftKey)Block.BLOCK_REGISTRY.getKey(var2.getBlock());
         var1.put("DisplayTile", var3 == null?"":var3.toString());
         var1.put("DisplayData", var2.getBlock().toLegacyData(var2));
         var1.put("DisplayOffset", this.v());
      }

      if(this.h != null && !this.h.isEmpty()) {
         var1.put("CustomName", this.h);
      }

   }

   public void i(Entity var1) {
      if(!this.o.isClientSide) {
         if(!var1.T && !this.T) {
            if(var1 != this.passenger) {
               if(var1 instanceof EntityLiving && !(var1 instanceof EntityHuman) && !(var1 instanceof class_uj) && this.s() == class_vn.class_a_in_class_vn.a && this.v * this.v + this.x * this.x > 0.01D && this.passenger == null && var1.vehicle == null) {
                  var1.a((Entity)this);
               }

               double var2 = var1.s - this.s;
               double var4 = var1.u - this.u;
               double var6 = var2 * var2 + var4 * var4;
               if(var6 >= 9.999999747378752E-5D) {
                  var6 = (double)MathHelper.sqrt(var6);
                  var2 /= var6;
                  var4 /= var6;
                  double var8 = 1.0D / var6;
                  if(var8 > 1.0D) {
                     var8 = 1.0D;
                  }

                  var2 *= var8;
                  var4 *= var8;
                  var2 *= 0.10000000149011612D;
                  var4 *= 0.10000000149011612D;
                  var2 *= (double)(1.0F - this.U);
                  var4 *= (double)(1.0F - this.U);
                  var2 *= 0.5D;
                  var4 *= 0.5D;
                  if(var1 instanceof class_vn) {
                     double var10 = var1.s - this.s;
                     double var12 = var1.u - this.u;
                     Vec3D var14 = (new Vec3D(var10, 0.0D, var12)).normalize();
                     Vec3D var15 = (new Vec3D((double)MathHelper.cos(this.y * 3.1415927F / 180.0F), 0.0D, (double)MathHelper.sin(this.y * 3.1415927F / 180.0F))).normalize();
                     double var16 = Math.abs(var14.dotProduct(var15));
                     if(var16 < 0.800000011920929D) {
                        return;
                     }

                     double var18 = var1.v + this.v;
                     double var20 = var1.x + this.x;
                     if(((class_vn)var1).s() == class_vn.class_a_in_class_vn.c && this.s() != class_vn.class_a_in_class_vn.c) {
                        this.v *= 0.20000000298023224D;
                        this.x *= 0.20000000298023224D;
                        this.g(var1.v - var2, 0.0D, var1.x - var4);
                        var1.v *= 0.949999988079071D;
                        var1.x *= 0.949999988079071D;
                     } else if(((class_vn)var1).s() != class_vn.class_a_in_class_vn.c && this.s() == class_vn.class_a_in_class_vn.c) {
                        var1.v *= 0.20000000298023224D;
                        var1.x *= 0.20000000298023224D;
                        var1.g(this.v + var2, 0.0D, this.x + var4);
                        this.v *= 0.949999988079071D;
                        this.x *= 0.949999988079071D;
                     } else {
                        var18 /= 2.0D;
                        var20 /= 2.0D;
                        this.v *= 0.20000000298023224D;
                        this.x *= 0.20000000298023224D;
                        this.g(var18 - var2, 0.0D, var20 - var4);
                        var1.v *= 0.20000000298023224D;
                        var1.x *= 0.20000000298023224D;
                        var1.g(var18 + var2, 0.0D, var20 + var4);
                     }
                  } else {
                     this.g(-var2, 0.0D, -var4);
                     var1.g(var2 / 4.0D, 0.0D, var4 / 4.0D);
                  }
               }

            }
         }
      }
   }

   public void a(float var1) {
      this.datawatcher.update(c, Float.valueOf(var1));
   }

   public float p() {
      return this.datawatcher.getFloat(c);
   }

   public void j(int var1) {
      this.datawatcher.update(a, Integer.valueOf(var1));
   }

   public int q() {
      return this.datawatcher.getInt(a);
   }

   public void k(int var1) {
      this.datawatcher.update(b, Integer.valueOf(var1));
   }

   public int r() {
      return this.datawatcher.getInt(b);
   }

   public abstract class_vn.class_a_in_class_vn s();

   public IBlockData t() {
      return !this.x()?this.u():Block.getByCombinedId(this.H().getInt(d));
   }

   public IBlockData u() {
      return Blocks.AIR.getBlockData();
   }

   public int v() {
      return !this.x()?this.w():this.H().getInt(e);
   }

   public int w() {
      return 6;
   }

   public void a(IBlockData var1) {
      this.H().update(d, Integer.valueOf(Block.getCombinedId(var1)));
      this.a(true);
   }

   public void l(int var1) {
      this.H().update(e, Integer.valueOf(var1));
      this.a(true);
   }

   public boolean x() {
      return this.H().getByte(f) == 1;
   }

   public void a(boolean var1) {
      this.H().update(f, Byte.valueOf((byte)(var1?1:0)));
   }

   public void a(String var1) {
      this.h = var1;
   }

   public String getName() {
      return this.h != null?this.h:super.getName();
   }

   public boolean hasCustomName() {
      return this.h != null;
   }

   public String aO() {
      return this.h;
   }

   public IChatBaseComponent getScoreboardDisplayName() {
      if(this.hasCustomName()) {
         ChatComponentText var2 = new ChatComponentText(this.h);
         var2.b().a(this.aS());
         var2.b().a(this.aM().toString());
         return var2;
      } else {
         ChatMessage var1 = new ChatMessage(this.getName(), new Object[0]);
         var1.b().a(this.aS());
         var1.b().a(this.aM().toString());
         return var1;
      }
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a;
      // $FF: synthetic field
      static final int[] b = new int[BlockMinecartTrackAbstract.EnumTrackPosition.values().length];

      static {
         try {
            b[BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_EAST.ordinal()] = 1;
         } catch (NoSuchFieldError var10) {
            ;
         }

         try {
            b[BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_WEST.ordinal()] = 2;
         } catch (NoSuchFieldError var9) {
            ;
         }

         try {
            b[BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_NORTH.ordinal()] = 3;
         } catch (NoSuchFieldError var8) {
            ;
         }

         try {
            b[BlockMinecartTrackAbstract.EnumTrackPosition.ASCENDING_SOUTH.ordinal()] = 4;
         } catch (NoSuchFieldError var7) {
            ;
         }

         a = new int[class_vn.class_a_in_class_vn.values().length];

         try {
            a[class_vn.class_a_in_class_vn.b.ordinal()] = 1;
         } catch (NoSuchFieldError var6) {
            ;
         }

         try {
            a[class_vn.class_a_in_class_vn.c.ordinal()] = 2;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            a[class_vn.class_a_in_class_vn.d.ordinal()] = 3;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            a[class_vn.class_a_in_class_vn.e.ordinal()] = 4;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[class_vn.class_a_in_class_vn.f.ordinal()] = 5;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[class_vn.class_a_in_class_vn.g.ordinal()] = 6;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }

   public static enum class_a_in_class_vn {
      a(0, "MinecartRideable"),
      b(1, "MinecartChest"),
      c(2, "MinecartFurnace"),
      d(3, "MinecartTNT"),
      e(4, "MinecartSpawner"),
      f(5, "MinecartHopper"),
      g(6, "MinecartCommandBlock");

      private static final Map h;
      private final int i;
      private final String j;

      private class_a_in_class_vn(int var3, String var4) {
         this.i = var3;
         this.j = var4;
      }

      public int a() {
         return this.i;
      }

      public String b() {
         return this.j;
      }

      public static class_vn.class_a_in_class_vn a(int var0) {
         class_vn.class_a_in_class_vn var1 = (class_vn.class_a_in_class_vn)h.get(Integer.valueOf(var0));
         return var1 == null?a:var1;
      }

      static {
         h = Maps.newHashMap();
         class_vn.class_a_in_class_vn[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            class_vn.class_a_in_class_vn var3 = var0[var2];
            h.put(Integer.valueOf(var3.a()), var3);
         }

      }
   }
}
