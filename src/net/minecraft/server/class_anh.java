package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.Item;
import net.minecraft.server.class_aas;
import net.minecraft.server.World;
import net.minecraft.server.class_aer;
import net.minecraft.server.class_agd;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_ane;
import net.minecraft.server.class_anf;
import net.minecraft.server.class_ang;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.class_anx;
import net.minecraft.server.BlockStateEnum;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.class_awf;
import net.minecraft.server.class_awg;
import net.minecraft.server.Vec3D;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_xa;

public class class_anh extends class_agd {
   public static final class_anx a;
   public static final BlockStateEnum b;

   public class_anh() {
      super(Material.PISTON);
      this.setBlockData(this.blockStateList.getFirst().set(a, EnumDirection.NORTH).set(b, class_anf.class_a_in_class_anf.a));
      this.setStrength(-1.0F);
   }

   public class_amg a(World var1, int var2) {
      return null;
   }

   public static class_amg a(IBlockData var0, EnumDirection var1, boolean var2, boolean var3) {
      return new class_ang(var0, var1, var2, var3);
   }

   public void b(World var1, BlockPosition var2, IBlockData var3) {
      class_amg var4 = var1.s(var2);
      if(var4 instanceof class_ang) {
         ((class_ang)var4).h();
      } else {
         super.b(var1, var2, var3);
      }

   }

   public boolean d(World var1, BlockPosition var2) {
      return false;
   }

   public boolean b(World var1, BlockPosition var2, EnumDirection var3) {
      return false;
   }

   public void d(World var1, BlockPosition var2, IBlockData var3) {
      BlockPosition var4 = var2.shift(((EnumDirection)var3.get(a)).getOpposite());
      IBlockData var5 = var1.p(var4);
      if(var5.getBlock() instanceof class_ane && ((Boolean)var5.get(class_ane.a)).booleanValue()) {
         var1.g(var4);
      }

   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean isFullCube() {
      return false;
   }

   public boolean a(World var1, BlockPosition var2, IBlockData var3, class_xa var4, EnumUsedHand var5, class_aas var6, EnumDirection var7, float var8, float var9, float var10) {
      if(!var1.D && var1.s(var2) == null) {
         var1.g(var2);
         return true;
      } else {
         return false;
      }
   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return null;
   }

   public void dropNaturally(World var1, BlockPosition var2, IBlockData var3, float var4, int var5) {
      if(!var1.D) {
         class_ang var6 = this.e((class_aer) var1, var2);
         if(var6 != null) {
            IBlockData var7 = var6.b();
            var7.getBlock().b(var1, var2, var7, 0);
         }
      }
   }

   public class_awg a(World var1, BlockPosition var2, Vec3D var3, Vec3D var4) {
      return null;
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, Block var4) {
      if(!var1.D) {
         var1.s(var2);
      }

   }

   public class_awf a(World var1, BlockPosition var2, IBlockData var3) {
      class_ang var4 = this.e((class_aer) var1, var2);
      if(var4 == null) {
         return null;
      } else {
         float var5 = var4.a(0.0F);
         if(var4.d()) {
            var5 = 1.0F - var5;
         }

         return this.a(var1, var2, var4.b(), var5, var4.e());
      }
   }

   public void a(class_aer var1, BlockPosition var2) {
      class_ang var3 = this.e(var1, var2);
      if(var3 != null) {
         IBlockData var4 = var3.b();
         Block var5 = var4.getBlock();
         if(var5 == this || var5.getMaterial() == Material.AIR) {
            return;
         }

         float var6 = var3.a(0.0F);
         if(var3.d()) {
            var6 = 1.0F - var6;
         }

         var5.a(var1, var2);
         if(var5 == Blocks.PISTON || var5 == Blocks.STICKY_PISTON) {
            var6 = 0.0F;
         }

         EnumDirection var7 = var3.e();
         this.minX = var5.getMinX() - (double)((float)var7.getAdjacentX() * var6);
         this.minY = var5.getMinY() - (double)((float)var7.getAdjacentY() * var6);
         this.minZ = var5.getMinZ() - (double)((float)var7.getAdjacentZ() * var6);
         this.maxX = var5.getMaxX() - (double)((float)var7.getAdjacentX() * var6);
         this.maxY = var5.getMaxY() - (double)((float)var7.getAdjacentY() * var6);
         this.maxZ = var5.getMaxZ() - (double)((float)var7.getAdjacentZ() * var6);
      }

   }

   public class_awf a(World var1, BlockPosition var2, IBlockData var3, float var4, EnumDirection var5) {
      if(var3.getBlock() != this && var3.getBlock().getMaterial() != Material.AIR) {
         class_awf var6 = var3.getBlock().a(var1, var2, var3);
         if(var6 == null) {
            return null;
         } else {
            double var7 = var6.a;
            double var9 = var6.b;
            double var11 = var6.c;
            double var13 = var6.d;
            double var15 = var6.e;
            double var17 = var6.f;
            if(var5.getAdjacentX() < 0) {
               var7 -= (double)((float)var5.getAdjacentX() * var4);
            } else {
               var13 -= (double)((float)var5.getAdjacentX() * var4);
            }

            if(var5.getAdjacentY() < 0) {
               var9 -= (double)((float)var5.getAdjacentY() * var4);
            } else {
               var15 -= (double)((float)var5.getAdjacentY() * var4);
            }

            if(var5.getAdjacentZ() < 0) {
               var11 -= (double)((float)var5.getAdjacentZ() * var4);
            } else {
               var17 -= (double)((float)var5.getAdjacentZ() * var4);
            }

            return new class_awf(var7, var9, var11, var13, var15, var17);
         }
      } else {
         return null;
      }
   }

   private class_ang e(class_aer var1, BlockPosition var2) {
      class_amg var3 = var1.s(var2);
      return var3 instanceof class_ang?(class_ang)var3:null;
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(a, class_anf.b(var1)).set(b, (var1 & 8) > 0?class_anf.class_a_in_class_anf.b:class_anf.class_a_in_class_anf.a);
   }

   public IBlockData a(IBlockData var1, Block.class_c_in_class_agj var2) {
      return var1.getBlock() != this?var1:var1.set(a, var2.a((EnumDirection)var1.get(a)));
   }

   public IBlockData a(IBlockData var1, Block.class_a_in_class_agj var2) {
      return var1.getBlock() != this?var1:this.a(var1, var2.a((EnumDirection)var1.get(a)));
   }

   public int toLegacyData(IBlockData var1) {
      byte var2 = 0;
      int var3 = var2 | ((EnumDirection)var1.get(a)).getId();
      if(var1.get(b) == class_anf.class_a_in_class_anf.b) {
         var3 |= 8;
      }

      return var3;
   }

   protected BlockStateList createBlockStateList() {
      return new BlockStateList(this, new IBlockState[]{a, b});
   }

   static {
      a = class_anf.b;
      b = class_anf.a;
   }
}
