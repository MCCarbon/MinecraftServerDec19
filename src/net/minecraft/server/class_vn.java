package net.minecraft.server;

import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.class_agf;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_aka;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_awf;
import net.minecraft.server.Vec3D;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.class_fa;
import net.minecraft.server.class_fb;
import net.minecraft.server.MinecraftKey;
import net.minecraft.server.WorldServer;
import net.minecraft.server.MathHelper;
import net.minecraft.server.class_ov;
import net.minecraft.server.class_pc;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_qi;
import net.minecraft.server.class_uj;
import net.minecraft.server.class_vo;
import net.minecraft.server.class_vp;
import net.minecraft.server.class_vr;
import net.minecraft.server.class_vs;
import net.minecraft.server.class_vt;
import net.minecraft.server.class_vu;
import net.minecraft.server.class_vv;
import net.minecraft.server.class_xa;

public abstract class class_vn extends class_pr implements class_ov {
   private static final int a = class_qi.a(class_vn.class);
   private static final int b = class_qi.a(class_vn.class);
   private static final int c = class_qi.a(class_vn.class);
   private static final int d = class_qi.a(class_vn.class);
   private static final int e = class_qi.a(class_vn.class);
   private static final int f = class_qi.a(class_vn.class);
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
      this.ac.a(a, new Integer(0));
      this.ac.a(b, new Integer(1));
      this.ac.a(c, new Float(0.0F));
      this.ac.a(d, new Integer(0));
      this.ac.a(e, new Integer(6));
      this.ac.a(f, Byte.valueOf((byte)0));
   }

   public class_awf j(class_pr var1) {
      return var1.ae()?var1.aT():null;
   }

   public class_awf S() {
      return null;
   }

   public boolean ae() {
      return true;
   }

   public class_vn(World var1, double var2, double var4, double var6) {
      this(var1);
      this.b(var2, var4, var6);
      this.v = 0.0D;
      this.w = 0.0D;
      this.x = 0.0D;
      this.p = var2;
      this.q = var4;
      this.r = var6;
   }

   public double an() {
      return 0.0D;
   }

   public boolean a(class_pc var1, float var2) {
      if(!this.o.D && !this.I) {
         if(this.b(var1)) {
            return false;
         } else {
            this.k(-this.r());
            this.j(10);
            this.ac();
            this.a(this.p() + var2 * 10.0F);
            boolean var3 = var1.j() instanceof class_xa && ((class_xa)var1.j()).bH.instabuild;
            if(var3 || this.p() > 40.0F) {
               if(this.l != null) {
                  this.l.a((class_pr)null);
               }

               if(var3 && !this.l_()) {
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
         ItemStack var2 = new ItemStack(Items.aB, 1);
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
      if(!this.o.D && this.o instanceof WorldServer) {
         this.o.B.a("portal");
         MinecraftServer var1 = ((WorldServer)this.o).s();
         var2 = this.L();
         if(this.ak) {
            if(var1.C()) {
               if(this.m == null && this.al++ >= var2) {
                  this.al = var2;
                  this.aj = this.aq();
                  byte var3;
                  if(this.o.t.p().a() == -1) {
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

      if(this.o.D) {
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
         this.w -= 0.03999999910593033D;
         int var14 = MathHelper.floor(this.s);
         var2 = MathHelper.floor(this.t);
         int var16 = MathHelper.floor(this.u);
         if(class_agf.e(this.o, new BlockPosition(var14, var2 - 1, var16))) {
            --var2;
         }

         BlockPosition var4 = new BlockPosition(var14, var2, var16);
         IBlockData var5 = this.o.p(var4);
         if(class_agf.d(var5)) {
            this.a(var4, var5);
            if(var5.getBlock() == Blocks.ACTIVATOR_RAIL) {
               this.a(var14, var2, var16, ((Boolean)var5.get(class_aka.N)).booleanValue());
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
         Iterator var12 = this.o.b((class_pr)this, (class_awf)this.aT().b(0.20000000298023224D, 0.0D, 0.20000000298023224D)).iterator();

         while(var12.hasNext()) {
            class_pr var13 = (class_pr)var12.next();
            if(var13 != this.l && var13.ae() && var13 instanceof class_vn) {
               var13.i(this);
            }
         }

         if(this.l != null && this.l.I) {
            if(this.l.m == this) {
               this.l.m = null;
            }

            this.l = null;
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
         this.w *= 0.5D;
         this.x *= 0.5D;
      }

      this.d(this.v, this.w, this.x);
      if(!this.C) {
         this.v *= 0.949999988079071D;
         this.w *= 0.949999988079071D;
         this.x *= 0.949999988079071D;
      }

   }

   protected void a(BlockPosition var1, IBlockData var2) {
      this.O = 0.0F;
      Vec3D var3 = this.k(this.s, this.t, this.u);
      this.t = (double)var1.getY();
      boolean var4 = false;
      boolean var5 = false;
      class_agf var6 = (class_agf)var2.getBlock();
      if(var6 == Blocks.GOLDEN_RAIL) {
         var4 = ((Boolean)var2.get(class_aka.N)).booleanValue();
         var5 = !var4;
      }

      double var7 = 0.0078125D;
      class_agf.class_b_in_class_agf var9 = (class_agf.class_b_in_class_agf)var2.get(var6.n());
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

      int[][] var10 = i[var9.a()];
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
      if(this.l instanceof class_qa) {
         var21 = (double)((class_qa)this.l).bd;
         if(var21 > 0.0D) {
            var23 = -Math.sin((double)(this.l.y * 3.1415927F / 180.0F));
            var25 = Math.cos((double)(this.l.y * 3.1415927F / 180.0F));
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
            this.w *= 0.0D;
            this.x *= 0.0D;
         } else {
            this.v *= 0.5D;
            this.w *= 0.0D;
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
      if(this.l != null) {
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
         } else if(var9 == class_agf.class_b_in_class_agf.b) {
            if(this.o.p(var1.shiftWest()).getBlock().isOccluding()) {
               this.v = 0.02D;
            } else if(this.o.p(var1.shiftEast()).getBlock().isOccluding()) {
               this.v = -0.02D;
            }
         } else if(var9 == class_agf.class_b_in_class_agf.a) {
            if(this.o.p(var1.shiftNorth()).getBlock().isOccluding()) {
               this.x = 0.02D;
            } else if(this.o.p(var1.shiftSouth()).getBlock().isOccluding()) {
               this.x = -0.02D;
            }
         }
      }

   }

   protected void o() {
      if(this.l != null) {
         this.v *= 0.996999979019165D;
         this.w *= 0.0D;
         this.x *= 0.996999979019165D;
      } else {
         this.v *= 0.9599999785423279D;
         this.w *= 0.0D;
         this.x *= 0.9599999785423279D;
      }

   }

   public void b(double var1, double var3, double var5) {
      this.s = var1;
      this.t = var3;
      this.u = var5;
      float var7 = this.J / 2.0F;
      float var8 = this.K;
      this.a((class_awf)(new class_awf(var1 - (double)var7, var3, var5 - (double)var7, var1 + (double)var7, var3 + (double)var8, var5 + (double)var7)));
   }

   public Vec3D k(double var1, double var3, double var5) {
      int var7 = MathHelper.floor(var1);
      int var8 = MathHelper.floor(var3);
      int var9 = MathHelper.floor(var5);
      if(class_agf.e(this.o, new BlockPosition(var7, var8 - 1, var9))) {
         --var8;
      }

      IBlockData var10 = this.o.p(new BlockPosition(var7, var8, var9));
      if(class_agf.d(var10)) {
         class_agf.class_b_in_class_agf var11 = (class_agf.class_b_in_class_agf)var10.get(((class_agf)var10.getBlock()).n());
         int[][] var12 = i[var11.a()];
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

   protected void a(NBTTagCompound var1) {
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

   protected void b(NBTTagCompound var1) {
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

   public void i(class_pr var1) {
      if(!this.o.D) {
         if(!var1.T && !this.T) {
            if(var1 != this.l) {
               if(var1 instanceof class_qa && !(var1 instanceof class_xa) && !(var1 instanceof class_uj) && this.s() == class_vn.class_a_in_class_vn.a && this.v * this.v + this.x * this.x > 0.01D && this.l == null && var1.m == null) {
                  var1.a((class_pr)this);
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
      this.ac.b(c, Float.valueOf(var1));
   }

   public float p() {
      return this.ac.d(c);
   }

   public void j(int var1) {
      this.ac.b(a, Integer.valueOf(var1));
   }

   public int q() {
      return this.ac.c(a);
   }

   public void k(int var1) {
      this.ac.b(b, Integer.valueOf(var1));
   }

   public int r() {
      return this.ac.c(b);
   }

   public abstract class_vn.class_a_in_class_vn s();

   public IBlockData t() {
      return !this.x()?this.u():Block.getByCombinedId(this.H().c(d));
   }

   public IBlockData u() {
      return Blocks.AIR.getBlockData();
   }

   public int v() {
      return !this.x()?this.w():this.H().c(e);
   }

   public int w() {
      return 6;
   }

   public void a(IBlockData var1) {
      this.H().b(d, Integer.valueOf(Block.getCombinedId(var1)));
      this.a(true);
   }

   public void l(int var1) {
      this.H().b(e, Integer.valueOf(var1));
      this.a(true);
   }

   public boolean x() {
      return this.H().a(f) == 1;
   }

   public void a(boolean var1) {
      this.H().b(f, Byte.valueOf((byte)(var1?1:0)));
   }

   public void a(String var1) {
      this.h = var1;
   }

   public String e_() {
      return this.h != null?this.h:super.e_();
   }

   public boolean l_() {
      return this.h != null;
   }

   public String aO() {
      return this.h;
   }

   public IChatBaseComponent f_() {
      if(this.l_()) {
         class_fa var2 = new class_fa(this.h);
         var2.b().a(this.aS());
         var2.b().a(this.aM().toString());
         return var2;
      } else {
         class_fb var1 = new class_fb(this.e_(), new Object[0]);
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
      static final int[] b = new int[class_agf.class_b_in_class_agf.values().length];

      static {
         try {
            b[class_agf.class_b_in_class_agf.c.ordinal()] = 1;
         } catch (NoSuchFieldError var10) {
            ;
         }

         try {
            b[class_agf.class_b_in_class_agf.d.ordinal()] = 2;
         } catch (NoSuchFieldError var9) {
            ;
         }

         try {
            b[class_agf.class_b_in_class_agf.e.ordinal()] = 3;
         } catch (NoSuchFieldError var8) {
            ;
         }

         try {
            b[class_agf.class_b_in_class_agf.f.ordinal()] = 4;
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
