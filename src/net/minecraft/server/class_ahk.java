package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aas;
import net.minecraft.server.World;
import net.minecraft.server.class_agd;
import net.minecraft.server.Block;
import net.minecraft.server.class_ahi;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_amm;
import net.minecraft.server.class_amn;
import net.minecraft.server.class_ane;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.class_anw;
import net.minecraft.server.class_anx;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_ck;
import net.minecraft.server.class_cl;
import net.minecraft.server.class_cn;
import net.minecraft.server.class_cp;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.class_cr;
import net.minecraft.server.class_cz;
import net.minecraft.server.class_da;
import net.minecraft.server.class_nc;
import net.minecraft.server.class_oj;
import net.minecraft.server.class_ol;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xz;
import net.minecraft.server.CreativeTab;

public class class_ahk extends class_agd {
   public static final class_anx a;
   public static final class_anw b;
   public static final class_cp N;
   protected Random O = new Random();

   protected class_ahk() {
      super(Material.STONE);
      this.setBlockData(this.blockStateList.getFirst().set(a, EnumDirection.NORTH).set(b, Boolean.valueOf(false)));
      this.a((CreativeTab)CreativeTab.d);
   }

   public int a(World var1) {
      return 4;
   }

   public void c(World var1, BlockPosition var2, IBlockData var3) {
      super.c(var1, var2, var3);
      this.e(var1, var2, var3);
   }

   private void e(World var1, BlockPosition var2, IBlockData var3) {
      if(!var1.D) {
         EnumDirection var4 = (EnumDirection)var3.get(a);
         boolean var5 = var1.p(var2.shiftNorth()).getBlock().isFullBlock();
         boolean var6 = var1.p(var2.shiftSouth()).getBlock().isFullBlock();
         if(var4 == EnumDirection.NORTH && var5 && !var6) {
            var4 = EnumDirection.SOUTH;
         } else if(var4 == EnumDirection.SOUTH && var6 && !var5) {
            var4 = EnumDirection.NORTH;
         } else {
            boolean var7 = var1.p(var2.shiftWest()).getBlock().isFullBlock();
            boolean var8 = var1.p(var2.shiftEast()).getBlock().isFullBlock();
            if(var4 == EnumDirection.WEST && var7 && !var8) {
               var4 = EnumDirection.EAST;
            } else if(var4 == EnumDirection.EAST && var8 && !var7) {
               var4 = EnumDirection.WEST;
            }
         }

         var1.a((BlockPosition)var2, (IBlockData)var3.set(a, var4).set(b, Boolean.valueOf(false)), 2);
      }
   }

   public boolean a(World var1, BlockPosition var2, IBlockData var3, class_xa var4, class_oo var5, class_aas var6, EnumDirection var7, float var8, float var9, float var10) {
      if(var1.D) {
         return true;
      } else {
         class_amg var11 = var1.s(var2);
         if(var11 instanceof class_amm) {
            var4.a((class_oj)((class_amm)var11));
            if(var11 instanceof class_amn) {
               var4.b(class_nc.O);
            } else {
               var4.b(class_nc.Q);
            }
         }

         return true;
      }
   }

   protected void f(World var1, BlockPosition var2) {
      class_cl var3 = new class_cl(var1, var2);
      class_amm var4 = (class_amm)var3.h();
      if(var4 != null) {
         int var5 = var4.m();
         if(var5 < 0) {
            var1.b(1001, var2, 0);
         } else {
            class_aas var6 = var4.a(var5);
            class_cr var7 = this.a(var6);
            if(var7 != class_cr.a) {
               class_aas var8 = var7.a(var3, var6);
               var4.a(var5, var8.b <= 0?null:var8);
            }

         }
      }
   }

   protected class_cr a(class_aas var1) {
      return (class_cr)N.c(var1 == null?null:var1.b());
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, Block var4) {
      boolean var5 = var1.z(var2) || var1.z(var2.shiftUp());
      boolean var6 = ((Boolean)var3.get(b)).booleanValue();
      if(var5 && !var6) {
         var1.a((BlockPosition)var2, (Block)this, this.a(var1));
         var1.a((BlockPosition)var2, (IBlockData)var3.set(b, Boolean.valueOf(true)), 4);
      } else if(!var5 && var6) {
         var1.a((BlockPosition)var2, (IBlockData)var3.set(b, Boolean.valueOf(false)), 4);
      }

   }

   public void b(World var1, BlockPosition var2, IBlockData var3, Random var4) {
      if(!var1.D) {
         this.f(var1, var2);
      }

   }

   public class_amg a(World var1, int var2) {
      return new class_amm();
   }

   public IBlockData a(World var1, BlockPosition var2, EnumDirection var3, float var4, float var5, float var6, int var7, class_qa var8) {
      return this.getBlockData().set(a, class_ane.a(var1, var2, var8)).set(b, Boolean.valueOf(false));
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, class_qa var4, class_aas var5) {
      var1.a((BlockPosition)var2, (IBlockData)var3.set(a, class_ane.a(var1, var2, var4)), 2);
      if(var5.s()) {
         class_amg var6 = var1.s(var2);
         if(var6 instanceof class_amm) {
            ((class_amm)var6).a(var5.q());
         }
      }

   }

   public void b(World var1, BlockPosition var2, IBlockData var3) {
      class_amg var4 = var1.s(var2);
      if(var4 instanceof class_amm) {
         class_ol.a(var1, (BlockPosition)var2, (class_amm)var4);
         var1.e(var2, this);
      }

      super.b(var1, var2, var3);
   }

   public static class_cz a(class_ck var0) {
      EnumDirection var1 = b(var0.f());
      double var2 = var0.a() + 0.7D * (double)var1.getAdjacentX();
      double var4 = var0.b() + 0.7D * (double)var1.getAdjacentY();
      double var6 = var0.c() + 0.7D * (double)var1.getAdjacentZ();
      return new class_da(var2, var4, var6);
   }

   public static EnumDirection b(int var0) {
      return EnumDirection.getById(var0 & 7);
   }

   public boolean Q() {
      return true;
   }

   public int l(World var1, BlockPosition var2) {
      return class_xz.a(var1.s(var2));
   }

   public int getRenderType() {
      return 3;
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(a, b(var1)).set(b, Boolean.valueOf((var1 & 8) > 0));
   }

   public int toLegacyData(IBlockData var1) {
      byte var2 = 0;
      int var3 = var2 | ((EnumDirection)var1.get(a)).getId();
      if(((Boolean)var1.get(b)).booleanValue()) {
         var3 |= 8;
      }

      return var3;
   }

   public IBlockData a(IBlockData var1, Block.class_c_in_class_agj var2) {
      return var1.getBlock() != this?var1:var1.set(a, var2.a((EnumDirection)var1.get(a)));
   }

   public IBlockData a(IBlockData var1, Block.class_a_in_class_agj var2) {
      return var1.getBlock() != this?var1:this.a(var1, var2.a((EnumDirection)var1.get(a)));
   }

   protected BlockStateList createBlockStateList() {
      return new BlockStateList(this, new IBlockState[]{a, b});
   }

   static {
      a = class_ahi.b;
      b = class_anw.a("triggered");
      N = new class_cp(new class_cn());
   }
}
