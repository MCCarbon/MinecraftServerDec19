package net.minecraft.server;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aej;
import net.minecraft.server.World;
import net.minecraft.server.class_aer;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_aiv;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.class_anx;
import net.minecraft.server.BlockStateEnum;
import net.minecraft.server.IBlockState;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_awg;
import net.minecraft.server.Vec3D;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.INamable;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_xa;
import net.minecraft.server.CreativeTab;

public class class_ald extends Block {
   public static final class_anx a;
   public static final BlockStateEnum b;
   public static final BlockStateEnum N;
   private static final int[][] O;
   private final Block P;
   private final IBlockData Q;
   private boolean R;
   private int S;

   protected class_ald(IBlockData var1) {
      super(var1.getBlock().material);
      this.setBlockData(this.blockStateList.getFirst().set(a, EnumDirection.NORTH).set(b, class_ald.class_a_in_class_ald.b).set(N, class_ald.class_b_in_class_ald.a));
      this.P = var1.getBlock();
      this.Q = var1;
      this.setStrength(this.P.strength);
      this.setExplosionResist(this.P.explosionResist / 3.0F);
      this.setStepSound((Block.StepSound)this.P.stepSound);
      this.setLightOpacity(255);
      this.a((CreativeTab)CreativeTab.b);
   }

   public void a(class_aer var1, BlockPosition var2) {
      if(this.R) {
         this.setSizes(0.5F * (float)(this.S % 2), 0.5F * (float)(this.S / 4 % 2), 0.5F * (float)(this.S / 2 % 2), 0.5F + 0.5F * (float)(this.S % 2), 0.5F + 0.5F * (float)(this.S / 4 % 2), 0.5F + 0.5F * (float)(this.S / 2 % 2));
      } else {
         this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      }

   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean isFullCube() {
      return false;
   }

   public void e(class_aer var1, BlockPosition var2) {
      if(var1.p(var2).get(b) == class_ald.class_a_in_class_ald.a) {
         this.setSizes(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
      } else {
         this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
      }

   }

   public static boolean c(Block var0) {
      return var0 instanceof class_ald;
   }

   public static boolean a(class_aer var0, BlockPosition var1, IBlockData var2) {
      IBlockData var3 = var0.p(var1);
      Block var4 = var3.getBlock();
      return c(var4) && var3.get(b) == var2.get(b) && var3.get(a) == var2.get(a);
   }

   public int f(class_aer var1, BlockPosition var2) {
      IBlockData var3 = var1.p(var2);
      EnumDirection var4 = (EnumDirection)var3.get(a);
      class_ald.class_a_in_class_ald var5 = (class_ald.class_a_in_class_ald)var3.get(b);
      boolean var6 = var5 == class_ald.class_a_in_class_ald.a;
      IBlockData var7;
      Block var8;
      EnumDirection var9;
      if(var4 == EnumDirection.EAST) {
         var7 = var1.p(var2.shiftEast());
         var8 = var7.getBlock();
         if(c(var8) && var5 == var7.get(b)) {
            var9 = (EnumDirection)var7.get(a);
            if(var9 == EnumDirection.NORTH && !a(var1, var2.shiftSouth(), var3)) {
               return var6?1:2;
            }

            if(var9 == EnumDirection.SOUTH && !a(var1, var2.shiftNorth(), var3)) {
               return var6?2:1;
            }
         }
      } else if(var4 == EnumDirection.WEST) {
         var7 = var1.p(var2.shiftWest());
         var8 = var7.getBlock();
         if(c(var8) && var5 == var7.get(b)) {
            var9 = (EnumDirection)var7.get(a);
            if(var9 == EnumDirection.NORTH && !a(var1, var2.shiftSouth(), var3)) {
               return var6?2:1;
            }

            if(var9 == EnumDirection.SOUTH && !a(var1, var2.shiftNorth(), var3)) {
               return var6?1:2;
            }
         }
      } else if(var4 == EnumDirection.SOUTH) {
         var7 = var1.p(var2.shiftSouth());
         var8 = var7.getBlock();
         if(c(var8) && var5 == var7.get(b)) {
            var9 = (EnumDirection)var7.get(a);
            if(var9 == EnumDirection.WEST && !a(var1, var2.shiftEast(), var3)) {
               return var6?2:1;
            }

            if(var9 == EnumDirection.EAST && !a(var1, var2.shiftWest(), var3)) {
               return var6?1:2;
            }
         }
      } else if(var4 == EnumDirection.NORTH) {
         var7 = var1.p(var2.shiftNorth());
         var8 = var7.getBlock();
         if(c(var8) && var5 == var7.get(b)) {
            var9 = (EnumDirection)var7.get(a);
            if(var9 == EnumDirection.WEST && !a(var1, var2.shiftEast(), var3)) {
               return var6?1:2;
            }

            if(var9 == EnumDirection.EAST && !a(var1, var2.shiftWest(), var3)) {
               return var6?2:1;
            }
         }
      }

      return 0;
   }

   public int g(class_aer var1, BlockPosition var2) {
      IBlockData var3 = var1.p(var2);
      EnumDirection var4 = (EnumDirection)var3.get(a);
      class_ald.class_a_in_class_ald var5 = (class_ald.class_a_in_class_ald)var3.get(b);
      boolean var6 = var5 == class_ald.class_a_in_class_ald.a;
      IBlockData var7;
      Block var8;
      EnumDirection var9;
      if(var4 == EnumDirection.EAST) {
         var7 = var1.p(var2.shiftWest());
         var8 = var7.getBlock();
         if(c(var8) && var5 == var7.get(b)) {
            var9 = (EnumDirection)var7.get(a);
            if(var9 == EnumDirection.NORTH && !a(var1, var2.shiftNorth(), var3)) {
               return var6?1:2;
            }

            if(var9 == EnumDirection.SOUTH && !a(var1, var2.shiftSouth(), var3)) {
               return var6?2:1;
            }
         }
      } else if(var4 == EnumDirection.WEST) {
         var7 = var1.p(var2.shiftEast());
         var8 = var7.getBlock();
         if(c(var8) && var5 == var7.get(b)) {
            var9 = (EnumDirection)var7.get(a);
            if(var9 == EnumDirection.NORTH && !a(var1, var2.shiftNorth(), var3)) {
               return var6?2:1;
            }

            if(var9 == EnumDirection.SOUTH && !a(var1, var2.shiftSouth(), var3)) {
               return var6?1:2;
            }
         }
      } else if(var4 == EnumDirection.SOUTH) {
         var7 = var1.p(var2.shiftNorth());
         var8 = var7.getBlock();
         if(c(var8) && var5 == var7.get(b)) {
            var9 = (EnumDirection)var7.get(a);
            if(var9 == EnumDirection.WEST && !a(var1, var2.shiftWest(), var3)) {
               return var6?2:1;
            }

            if(var9 == EnumDirection.EAST && !a(var1, var2.shiftEast(), var3)) {
               return var6?1:2;
            }
         }
      } else if(var4 == EnumDirection.NORTH) {
         var7 = var1.p(var2.shiftSouth());
         var8 = var7.getBlock();
         if(c(var8) && var5 == var7.get(b)) {
            var9 = (EnumDirection)var7.get(a);
            if(var9 == EnumDirection.WEST && !a(var1, var2.shiftWest(), var3)) {
               return var6?1:2;
            }

            if(var9 == EnumDirection.EAST && !a(var1, var2.shiftEast(), var3)) {
               return var6?2:1;
            }
         }
      }

      return 0;
   }

   public boolean h(class_aer var1, BlockPosition var2) {
      IBlockData var3 = var1.p(var2);
      EnumDirection var4 = (EnumDirection)var3.get(a);
      class_ald.class_a_in_class_ald var5 = (class_ald.class_a_in_class_ald)var3.get(b);
      boolean var6 = var5 == class_ald.class_a_in_class_ald.a;
      float var7 = 0.5F;
      float var8 = 1.0F;
      if(var6) {
         var7 = 0.0F;
         var8 = 0.5F;
      }

      float var9 = 0.0F;
      float var10 = 1.0F;
      float var11 = 0.0F;
      float var12 = 0.5F;
      boolean var13 = true;
      IBlockData var14;
      Block var15;
      EnumDirection var16;
      if(var4 == EnumDirection.EAST) {
         var9 = 0.5F;
         var12 = 1.0F;
         var14 = var1.p(var2.shiftEast());
         var15 = var14.getBlock();
         if(c(var15) && var5 == var14.get(b)) {
            var16 = (EnumDirection)var14.get(a);
            if(var16 == EnumDirection.NORTH && !a(var1, var2.shiftSouth(), var3)) {
               var12 = 0.5F;
               var13 = false;
            } else if(var16 == EnumDirection.SOUTH && !a(var1, var2.shiftNorth(), var3)) {
               var11 = 0.5F;
               var13 = false;
            }
         }
      } else if(var4 == EnumDirection.WEST) {
         var10 = 0.5F;
         var12 = 1.0F;
         var14 = var1.p(var2.shiftWest());
         var15 = var14.getBlock();
         if(c(var15) && var5 == var14.get(b)) {
            var16 = (EnumDirection)var14.get(a);
            if(var16 == EnumDirection.NORTH && !a(var1, var2.shiftSouth(), var3)) {
               var12 = 0.5F;
               var13 = false;
            } else if(var16 == EnumDirection.SOUTH && !a(var1, var2.shiftNorth(), var3)) {
               var11 = 0.5F;
               var13 = false;
            }
         }
      } else if(var4 == EnumDirection.SOUTH) {
         var11 = 0.5F;
         var12 = 1.0F;
         var14 = var1.p(var2.shiftSouth());
         var15 = var14.getBlock();
         if(c(var15) && var5 == var14.get(b)) {
            var16 = (EnumDirection)var14.get(a);
            if(var16 == EnumDirection.WEST && !a(var1, var2.shiftEast(), var3)) {
               var10 = 0.5F;
               var13 = false;
            } else if(var16 == EnumDirection.EAST && !a(var1, var2.shiftWest(), var3)) {
               var9 = 0.5F;
               var13 = false;
            }
         }
      } else if(var4 == EnumDirection.NORTH) {
         var14 = var1.p(var2.shiftNorth());
         var15 = var14.getBlock();
         if(c(var15) && var5 == var14.get(b)) {
            var16 = (EnumDirection)var14.get(a);
            if(var16 == EnumDirection.WEST && !a(var1, var2.shiftEast(), var3)) {
               var10 = 0.5F;
               var13 = false;
            } else if(var16 == EnumDirection.EAST && !a(var1, var2.shiftWest(), var3)) {
               var9 = 0.5F;
               var13 = false;
            }
         }
      }

      this.setSizes(var9, var7, var11, var10, var8, var12);
      return var13;
   }

   public boolean i(class_aer var1, BlockPosition var2) {
      IBlockData var3 = var1.p(var2);
      EnumDirection var4 = (EnumDirection)var3.get(a);
      class_ald.class_a_in_class_ald var5 = (class_ald.class_a_in_class_ald)var3.get(b);
      boolean var6 = var5 == class_ald.class_a_in_class_ald.a;
      float var7 = 0.5F;
      float var8 = 1.0F;
      if(var6) {
         var7 = 0.0F;
         var8 = 0.5F;
      }

      float var9 = 0.0F;
      float var10 = 0.5F;
      float var11 = 0.5F;
      float var12 = 1.0F;
      boolean var13 = false;
      IBlockData var14;
      Block var15;
      EnumDirection var16;
      if(var4 == EnumDirection.EAST) {
         var14 = var1.p(var2.shiftWest());
         var15 = var14.getBlock();
         if(c(var15) && var5 == var14.get(b)) {
            var16 = (EnumDirection)var14.get(a);
            if(var16 == EnumDirection.NORTH && !a(var1, var2.shiftNorth(), var3)) {
               var11 = 0.0F;
               var12 = 0.5F;
               var13 = true;
            } else if(var16 == EnumDirection.SOUTH && !a(var1, var2.shiftSouth(), var3)) {
               var11 = 0.5F;
               var12 = 1.0F;
               var13 = true;
            }
         }
      } else if(var4 == EnumDirection.WEST) {
         var14 = var1.p(var2.shiftEast());
         var15 = var14.getBlock();
         if(c(var15) && var5 == var14.get(b)) {
            var9 = 0.5F;
            var10 = 1.0F;
            var16 = (EnumDirection)var14.get(a);
            if(var16 == EnumDirection.NORTH && !a(var1, var2.shiftNorth(), var3)) {
               var11 = 0.0F;
               var12 = 0.5F;
               var13 = true;
            } else if(var16 == EnumDirection.SOUTH && !a(var1, var2.shiftSouth(), var3)) {
               var11 = 0.5F;
               var12 = 1.0F;
               var13 = true;
            }
         }
      } else if(var4 == EnumDirection.SOUTH) {
         var14 = var1.p(var2.shiftNorth());
         var15 = var14.getBlock();
         if(c(var15) && var5 == var14.get(b)) {
            var11 = 0.0F;
            var12 = 0.5F;
            var16 = (EnumDirection)var14.get(a);
            if(var16 == EnumDirection.WEST && !a(var1, var2.shiftWest(), var3)) {
               var13 = true;
            } else if(var16 == EnumDirection.EAST && !a(var1, var2.shiftEast(), var3)) {
               var9 = 0.5F;
               var10 = 1.0F;
               var13 = true;
            }
         }
      } else if(var4 == EnumDirection.NORTH) {
         var14 = var1.p(var2.shiftSouth());
         var15 = var14.getBlock();
         if(c(var15) && var5 == var14.get(b)) {
            var16 = (EnumDirection)var14.get(a);
            if(var16 == EnumDirection.WEST && !a(var1, var2.shiftWest(), var3)) {
               var13 = true;
            } else if(var16 == EnumDirection.EAST && !a(var1, var2.shiftEast(), var3)) {
               var9 = 0.5F;
               var10 = 1.0F;
               var13 = true;
            }
         }
      }

      if(var13) {
         this.setSizes(var9, var7, var11, var10, var8, var12);
      }

      return var13;
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, class_awf var4, List var5, class_pr var6) {
      this.e(var1, var2);
      super.a(var1, var2, var3, var4, var5, var6);
      boolean var7 = this.h(var1, var2);
      super.a(var1, var2, var3, var4, var5, var6);
      if(var7 && this.i(var1, var2)) {
         super.a(var1, var2, var3, var4, var5, var6);
      }

      this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public void a(World var1, BlockPosition var2, class_xa var3) {
      this.P.a(var1, var2, var3);
   }

   public void d(World var1, BlockPosition var2, IBlockData var3) {
      this.P.d(var1, var2, var3);
   }

   public float a(class_pr var1) {
      return this.P.a(var1);
   }

   public int a(World var1) {
      return this.P.a(var1);
   }

   public Vec3D a(World var1, BlockPosition var2, class_pr var3, Vec3D var4) {
      return this.P.a(var1, var2, var3, var4);
   }

   public boolean C() {
      return this.P.C();
   }

   public boolean a(IBlockData var1, boolean var2) {
      return this.P.a(var1, var2);
   }

   public boolean d(World var1, BlockPosition var2) {
      return this.P.d(var1, var2);
   }

   public void c(World var1, BlockPosition var2, IBlockData var3) {
      this.a(var1, var2, (IBlockData)this.Q, (Block)Blocks.AIR);
      this.P.c(var1, var2, this.Q);
   }

   public void b(World var1, BlockPosition var2, IBlockData var3) {
      this.P.b(var1, var2, this.Q);
   }

   public void a(World var1, BlockPosition var2, class_pr var3) {
      this.P.a(var1, var2, var3);
   }

   public void b(World var1, BlockPosition var2, IBlockData var3, Random var4) {
      this.P.b(var1, var2, var3, var4);
   }

   public boolean a(World var1, BlockPosition var2, IBlockData var3, class_xa var4, EnumUsedHand var5, class_aas var6, EnumDirection var7, float var8, float var9, float var10) {
      return this.P.a(var1, var2, this.Q, var4, var5, var6, EnumDirection.DOWN, 0.0F, 0.0F, 0.0F);
   }

   public void a(World var1, BlockPosition var2, class_aej var3) {
      this.P.a(var1, var2, var3);
   }

   public MaterialMapColor getMapColor(IBlockData var1) {
      return this.P.getMapColor(this.Q);
   }

   public IBlockData a(World var1, BlockPosition var2, EnumDirection var3, float var4, float var5, float var6, int var7, class_qa var8) {
      IBlockData var9 = super.a(var1, var2, var3, var4, var5, var6, var7, var8);
      var9 = var9.set(a, var8.aR()).set(N, class_ald.class_b_in_class_ald.a);
      return var3 != EnumDirection.DOWN && (var3 == EnumDirection.UP || (double)var5 <= 0.5D)?var9.set(b, class_ald.class_a_in_class_ald.b):var9.set(b, class_ald.class_a_in_class_ald.a);
   }

   public class_awg a(World var1, BlockPosition var2, Vec3D var3, Vec3D var4) {
      class_awg[] var5 = new class_awg[8];
      IBlockData var6 = var1.p(var2);
      int var7 = ((EnumDirection)var6.get(a)).getHorizontalId();
      boolean var8 = var6.get(b) == class_ald.class_a_in_class_ald.a;
      int[] var9 = O[var7 + (var8?4:0)];
      this.R = true;

      for(int var10 = 0; var10 < 8; ++var10) {
         this.S = var10;
         if(Arrays.binarySearch(var9, var10) < 0) {
            var5[var10] = super.a(var1, var2, var3, var4);
         }
      }

      int[] var19 = var9;
      int var11 = var9.length;

      for(int var12 = 0; var12 < var11; ++var12) {
         int var13 = var19[var12];
         var5[var13] = null;
      }

      class_awg var20 = null;
      double var21 = 0.0D;
      class_awg[] var22 = var5;
      int var14 = var5.length;

      for(int var15 = 0; var15 < var14; ++var15) {
         class_awg var16 = var22[var15];
         if(var16 != null) {
            double var17 = var16.c.distanceSquared(var4);
            if(var17 > var21) {
               var20 = var16;
               var21 = var17;
            }
         }
      }

      return var20;
   }

   public IBlockData fromLegacyData(int var1) {
      IBlockData var2 = this.getBlockData().set(b, (var1 & 4) > 0?class_ald.class_a_in_class_ald.a:class_ald.class_a_in_class_ald.b);
      var2 = var2.set(a, EnumDirection.getById(5 - (var1 & 3)));
      return var2;
   }

   public int toLegacyData(IBlockData var1) {
      int var2 = 0;
      if(var1.get(b) == class_ald.class_a_in_class_ald.a) {
         var2 |= 4;
      }

      var2 |= 5 - ((EnumDirection)var1.get(a)).getId();
      return var2;
   }

   public IBlockData a(IBlockData var1, class_aer var2, BlockPosition var3) {
      if(this.h(var2, var3)) {
         switch(this.g(var2, var3)) {
         case 0:
            var1 = var1.set(N, class_ald.class_b_in_class_ald.a);
            break;
         case 1:
            var1 = var1.set(N, class_ald.class_b_in_class_ald.c);
            break;
         case 2:
            var1 = var1.set(N, class_ald.class_b_in_class_ald.b);
         }
      } else {
         switch(this.f(var2, var3)) {
         case 0:
            var1 = var1.set(N, class_ald.class_b_in_class_ald.a);
            break;
         case 1:
            var1 = var1.set(N, class_ald.class_b_in_class_ald.e);
            break;
         case 2:
            var1 = var1.set(N, class_ald.class_b_in_class_ald.d);
         }
      }

      return var1;
   }

   public IBlockData a(IBlockData var1, Block.class_c_in_class_agj var2) {
      return var1.getBlock() != this?var1:var1.set(a, var2.a((EnumDirection)var1.get(a)));
   }

   public IBlockData a(IBlockData var1, Block.class_a_in_class_agj var2) {
      if(var1.getBlock() != this) {
         return var1;
      } else {
         EnumDirection var3 = (EnumDirection)var1.get(a);
         class_ald.class_b_in_class_ald var4 = (class_ald.class_b_in_class_ald)var1.get(N);
         switch(class_ald.SyntheticClass_1.b[var2.ordinal()]) {
         case 1:
            if(var3.getAxis() == EnumDirection.EnumAxis.Z) {
               switch(class_ald.SyntheticClass_1.a[var4.ordinal()]) {
               case 1:
                  return this.a(var1, Block.class_c_in_class_agj.c).set(N, class_ald.class_b_in_class_ald.c);
               case 2:
                  return this.a(var1, Block.class_c_in_class_agj.c).set(N, class_ald.class_b_in_class_ald.b);
               case 3:
                  return this.a(var1, Block.class_c_in_class_agj.c).set(N, class_ald.class_b_in_class_ald.e);
               case 4:
                  return this.a(var1, Block.class_c_in_class_agj.c).set(N, class_ald.class_b_in_class_ald.d);
               default:
                  return this.a(var1, Block.class_c_in_class_agj.c);
               }
            }
            break;
         case 2:
            if(var3.getAxis() == EnumDirection.EnumAxis.X) {
               switch(class_ald.SyntheticClass_1.a[var4.ordinal()]) {
               case 1:
                  return this.a(var1, Block.class_c_in_class_agj.c).set(N, class_ald.class_b_in_class_ald.b);
               case 2:
                  return this.a(var1, Block.class_c_in_class_agj.c).set(N, class_ald.class_b_in_class_ald.c);
               case 3:
                  return this.a(var1, Block.class_c_in_class_agj.c).set(N, class_ald.class_b_in_class_ald.e);
               case 4:
                  return this.a(var1, Block.class_c_in_class_agj.c).set(N, class_ald.class_b_in_class_ald.d);
               case 5:
                  return this.a(var1, Block.class_c_in_class_agj.c);
               }
            }
         }

         return super.a(var1, var2);
      }
   }

   protected BlockStateList createBlockStateList() {
      return new BlockStateList(this, new IBlockState[]{a, b, N});
   }

   static {
      a = class_aiv.O;
      b = BlockStateEnum.of("half", class_ald.class_a_in_class_ald.class);
      N = BlockStateEnum.of("shape", class_ald.class_b_in_class_ald.class);
      O = new int[][]{{4, 5}, {5, 7}, {6, 7}, {4, 6}, {0, 1}, {1, 3}, {2, 3}, {0, 2}};
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a;
      // $FF: synthetic field
      static final int[] b = new int[Block.class_a_in_class_agj.values().length];

      static {
         try {
            b[Block.class_a_in_class_agj.b.ordinal()] = 1;
         } catch (NoSuchFieldError var7) {
            ;
         }

         try {
            b[Block.class_a_in_class_agj.c.ordinal()] = 2;
         } catch (NoSuchFieldError var6) {
            ;
         }

         a = new int[class_ald.class_b_in_class_ald.values().length];

         try {
            a[class_ald.class_b_in_class_ald.b.ordinal()] = 1;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            a[class_ald.class_b_in_class_ald.c.ordinal()] = 2;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            a[class_ald.class_b_in_class_ald.d.ordinal()] = 3;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[class_ald.class_b_in_class_ald.e.ordinal()] = 4;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[class_ald.class_b_in_class_ald.a.ordinal()] = 5;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }

   public static enum class_b_in_class_ald implements INamable {
      a("straight"),
      b("inner_left"),
      c("inner_right"),
      d("outer_left"),
      e("outer_right");

      private final String f;

      private class_b_in_class_ald(String var3) {
         this.f = var3;
      }

      public String toString() {
         return this.f;
      }

      public String getName() {
         return this.f;
      }
   }

   public static enum class_a_in_class_ald implements INamable {
      a("top"),
      b("bottom");

      private final String c;

      private class_a_in_class_ald(String var3) {
         this.c = var3;
      }

      public String toString() {
         return this.c;
      }

      public String getName() {
         return this.c;
      }
   }
}
