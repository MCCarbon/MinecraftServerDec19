package net.minecraft.server;

import net.minecraft.server.class_aas;
import net.minecraft.server.World;
import net.minecraft.server.class_aer;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_aiv;
import net.minecraft.server.class_ajw;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.class_anw;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.class_awf;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_xa;
import net.minecraft.server.CreativeTab;

public class class_aia extends class_aiv {
   public static final class_anw a = class_anw.a("open");
   public static final class_anw b = class_anw.a("powered");
   public static final class_anw N = class_anw.a("in_wall");

   public class_aia(class_ajw.class_a_in_class_ajw var1) {
      super(Material.WOOD, var1.c());
      this.setBlockData(this.blockStateList.getFirst().set(a, Boolean.valueOf(false)).set(b, Boolean.valueOf(false)).set(N, Boolean.valueOf(false)));
      this.a(CreativeTab.d);
   }

   public IBlockData a(IBlockData var1, class_aer var2, BlockPosition var3) {
      EnumDirection.EnumAxis var4 = ((EnumDirection)var1.get(O)).getAxis();
      if(var4 == EnumDirection.EnumAxis.Z && (var2.p(var3.shiftWest()).getBlock() == Blocks.COBBLESTONE_WALL || var2.p(var3.shiftEast()).getBlock() == Blocks.COBBLESTONE_WALL) || var4 == EnumDirection.EnumAxis.X && (var2.p(var3.shiftNorth()).getBlock() == Blocks.COBBLESTONE_WALL || var2.p(var3.shiftSouth()).getBlock() == Blocks.COBBLESTONE_WALL)) {
         var1 = var1.set(N, Boolean.valueOf(true));
      }

      return var1;
   }

   public IBlockData a(IBlockData var1, Block.class_c_in_class_agj var2) {
      return var1.getBlock() != this?var1:var1.set(O, var2.a((EnumDirection)var1.get(O)));
   }

   public IBlockData a(IBlockData var1, Block.class_a_in_class_agj var2) {
      return var1.getBlock() != this?var1:this.a(var1, var2.a((EnumDirection)var1.get(O)));
   }

   public boolean d(World var1, BlockPosition var2) {
      return var1.p(var2.shiftDown()).getBlock().getMaterial().isBuildable()?super.d(var1, var2):false;
   }

   public class_awf a(World var1, BlockPosition var2, IBlockData var3) {
      if(((Boolean)var3.get(a)).booleanValue()) {
         return null;
      } else {
         EnumDirection.EnumAxis var4 = ((EnumDirection)var3.get(O)).getAxis();
         return var4 == EnumDirection.EnumAxis.Z?new class_awf((double)var2.getX(), (double)var2.getY(), (double)((float)var2.getZ() + 0.375F), (double)(var2.getX() + 1), (double)((float)var2.getY() + 1.5F), (double)((float)var2.getZ() + 0.625F)):new class_awf((double)((float)var2.getX() + 0.375F), (double)var2.getY(), (double)var2.getZ(), (double)((float)var2.getX() + 0.625F), (double)((float)var2.getY() + 1.5F), (double)(var2.getZ() + 1));
      }
   }

   public void a(class_aer var1, BlockPosition var2) {
      EnumDirection.EnumAxis var3 = ((EnumDirection)var1.p(var2).get(O)).getAxis();
      if(var3 == EnumDirection.EnumAxis.Z) {
         this.setSizes(0.0F, 0.0F, 0.375F, 1.0F, 1.0F, 0.625F);
      } else {
         this.setSizes(0.375F, 0.0F, 0.0F, 0.625F, 1.0F, 1.0F);
      }

   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean isFullCube() {
      return false;
   }

   public boolean isPassable(class_aer var1, BlockPosition var2) {
      return ((Boolean)var1.p(var2).get(a)).booleanValue();
   }

   public IBlockData a(World var1, BlockPosition var2, EnumDirection var3, float var4, float var5, float var6, int var7, class_qa var8) {
      return this.getBlockData().set(O, var8.aR()).set(a, Boolean.valueOf(false)).set(b, Boolean.valueOf(false)).set(N, Boolean.valueOf(false));
   }

   public boolean a(World var1, BlockPosition var2, IBlockData var3, class_xa var4, class_oo var5, class_aas var6, EnumDirection var7, float var8, float var9, float var10) {
      if(((Boolean)var3.get(a)).booleanValue()) {
         var3 = var3.set(a, Boolean.valueOf(false));
         var1.a((BlockPosition)var2, (IBlockData)var3, 2);
      } else {
         EnumDirection var11 = EnumDirection.fromAngle((double)var4.y);
         if(var3.get(O) == var11.getOpposite()) {
            var3 = var3.set(O, var11);
         }

         var3 = var3.set(a, Boolean.valueOf(true));
         var1.a((BlockPosition)var2, (IBlockData)var3, 2);
      }

      var1.a(var4, ((Boolean)var3.get(a)).booleanValue()?1003:1006, var2, 0);
      return true;
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, Block var4) {
      if(!var1.D) {
         boolean var5 = var1.z(var2);
         if(var5 || var4.isPowerSource()) {
            if(var5 && !((Boolean)var3.get(a)).booleanValue() && !((Boolean)var3.get(b)).booleanValue()) {
               var1.a((BlockPosition)var2, (IBlockData)var3.set(a, Boolean.valueOf(true)).set(b, Boolean.valueOf(true)), 2);
               var1.a((class_xa)null, 1003, var2, 0);
            } else if(!var5 && ((Boolean)var3.get(a)).booleanValue() && ((Boolean)var3.get(b)).booleanValue()) {
               var1.a((BlockPosition)var2, (IBlockData)var3.set(a, Boolean.valueOf(false)).set(b, Boolean.valueOf(false)), 2);
               var1.a((class_xa)null, 1006, var2, 0);
            } else if(var5 != ((Boolean)var3.get(b)).booleanValue()) {
               var1.a((BlockPosition)var2, (IBlockData)var3.set(b, Boolean.valueOf(var5)), 2);
            }
         }

      }
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(O, EnumDirection.getByHorizontalId(var1)).set(a, Boolean.valueOf((var1 & 4) != 0)).set(b, Boolean.valueOf((var1 & 8) != 0));
   }

   public int toLegacyData(IBlockData var1) {
      byte var2 = 0;
      int var3 = var2 | ((EnumDirection)var1.get(O)).getHorizontalId();
      if(((Boolean)var1.get(b)).booleanValue()) {
         var3 |= 8;
      }

      if(((Boolean)var1.get(a)).booleanValue()) {
         var3 |= 4;
      }

      return var3;
   }

   protected BlockStateList createBlockStateList() {
      return new BlockStateList(this, new IBlockState[]{O, a, b, N});
   }
}
