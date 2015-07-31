package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.ItemStack;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.class_aer;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_agl;
import net.minecraft.server.class_aiv;
import net.minecraft.server.class_ajt;
import net.minecraft.server.class_ajw;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.class_anz;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.class_awf;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_zy;

public class class_agy extends class_aiv implements class_agl {
   public static final class_anz a = class_anz.a("age", 0, 2);

   public class_agy() {
      super(Material.PLANT);
      this.setBlockData(this.blockStateList.getFirst().set(O, EnumDirection.NORTH).set(a, Integer.valueOf(0)));
      this.setTicking(true);
   }

   public void b(World var1, BlockPosition var2, IBlockData var3, Random var4) {
      if(!this.e(var1, var2, var3)) {
         this.f(var1, var2, var3);
      } else if(var1.s.nextInt(5) == 0) {
         int var5 = ((Integer)var3.get(a)).intValue();
         if(var5 < 2) {
            var1.a((BlockPosition)var2, (IBlockData)var3.set(a, Integer.valueOf(var5 + 1)), 2);
         }
      }

   }

   public boolean e(World var1, BlockPosition var2, IBlockData var3) {
      var2 = var2.shift((EnumDirection)var3.get(O));
      IBlockData var4 = var1.p(var2);
      return var4.getBlock() == Blocks.LOG && var4.get(class_ajt.b) == class_ajw.class_a_in_class_ajw.d;
   }

   public boolean isFullCube() {
      return false;
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public class_awf a(World var1, BlockPosition var2, IBlockData var3) {
      this.a((class_aer)var1, (BlockPosition)var2);
      return super.a(var1, var2, var3);
   }

   public void a(class_aer var1, BlockPosition var2) {
      IBlockData var3 = var1.p(var2);
      EnumDirection var4 = (EnumDirection)var3.get(O);
      int var5 = ((Integer)var3.get(a)).intValue();
      int var6 = 4 + var5 * 2;
      int var7 = 5 + var5 * 2;
      float var8 = (float)var6 / 2.0F;
      switch(class_agy.SyntheticClass_1.a[var4.ordinal()]) {
      case 1:
         this.setSizes((8.0F - var8) / 16.0F, (12.0F - (float)var7) / 16.0F, (15.0F - (float)var6) / 16.0F, (8.0F + var8) / 16.0F, 0.75F, 0.9375F);
         break;
      case 2:
         this.setSizes((8.0F - var8) / 16.0F, (12.0F - (float)var7) / 16.0F, 0.0625F, (8.0F + var8) / 16.0F, 0.75F, (1.0F + (float)var6) / 16.0F);
         break;
      case 3:
         this.setSizes(0.0625F, (12.0F - (float)var7) / 16.0F, (8.0F - var8) / 16.0F, (1.0F + (float)var6) / 16.0F, 0.75F, (8.0F + var8) / 16.0F);
         break;
      case 4:
         this.setSizes((15.0F - (float)var6) / 16.0F, (12.0F - (float)var7) / 16.0F, (8.0F - var8) / 16.0F, 0.9375F, 0.75F, (8.0F + var8) / 16.0F);
      }

   }

   public IBlockData a(IBlockData var1, Block.class_c_in_class_agj var2) {
      return var1.getBlock() != this?var1:var1.set(O, var2.a((EnumDirection)var1.get(O)));
   }

   public IBlockData a(IBlockData var1, Block.class_a_in_class_agj var2) {
      return var1.getBlock() != this?var1:this.a(var1, var2.a((EnumDirection)var1.get(O)));
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, class_qa var4, ItemStack var5) {
      EnumDirection var6 = EnumDirection.fromAngle((double)var4.y);
      var1.a((BlockPosition)var2, (IBlockData)var3.set(O, var6), 2);
   }

   public IBlockData a(World var1, BlockPosition var2, EnumDirection var3, float var4, float var5, float var6, int var7, class_qa var8) {
      if(!var3.getAxis().isHorizontal()) {
         var3 = EnumDirection.NORTH;
      }

      return this.getBlockData().set(O, var3.getOpposite()).set(a, Integer.valueOf(0));
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, Block var4) {
      if(!this.e(var1, var2, var3)) {
         this.f(var1, var2, var3);
      }

   }

   private void f(World var1, BlockPosition var2, IBlockData var3) {
      var1.a((BlockPosition)var2, (IBlockData)Blocks.AIR.getBlockData(), 3);
      this.b(var1, var2, var3, 0);
   }

   public void dropNaturally(World var1, BlockPosition var2, IBlockData var3, float var4, int var5) {
      int var6 = ((Integer)var3.get(a)).intValue();
      byte var7 = 1;
      if(var6 >= 2) {
         var7 = 3;
      }

      for(int var8 = 0; var8 < var7; ++var8) {
         a(var1, var2, new ItemStack(Items.aY, 1, class_zy.m.b()));
      }

   }

   public int j(World var1, BlockPosition var2) {
      return class_zy.m.b();
   }

   public boolean a(World var1, BlockPosition var2, IBlockData var3, boolean var4) {
      return ((Integer)var3.get(a)).intValue() < 2;
   }

   public boolean a(World var1, Random var2, BlockPosition var3, IBlockData var4) {
      return true;
   }

   public void b(World var1, Random var2, BlockPosition var3, IBlockData var4) {
      var1.a((BlockPosition)var3, (IBlockData)var4.set(a, Integer.valueOf(((Integer)var4.get(a)).intValue() + 1)), 2);
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(O, EnumDirection.getByHorizontalId(var1)).set(a, Integer.valueOf((var1 & 15) >> 2));
   }

   public int toLegacyData(IBlockData var1) {
      byte var2 = 0;
      int var3 = var2 | ((EnumDirection)var1.get(O)).getHorizontalId();
      var3 |= ((Integer)var1.get(a)).intValue() << 2;
      return var3;
   }

   protected BlockStateList createBlockStateList() {
      return new BlockStateList(this, new IBlockState[]{O, a});
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a = new int[EnumDirection.values().length];

      static {
         try {
            a[EnumDirection.SOUTH.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            a[EnumDirection.NORTH.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            a[EnumDirection.WEST.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[EnumDirection.EAST.ordinal()] = 4;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
