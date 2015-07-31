package net.minecraft.server;

import com.google.common.base.Predicate;
import java.util.List;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;
import net.minecraft.server.class_aer;
import net.minecraft.server.class_agd;
import net.minecraft.server.Block;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_amt;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.class_anw;
import net.minecraft.server.class_anx;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.class_awf;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.class_nc;
import net.minecraft.server.class_oj;
import net.minecraft.server.class_ol;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xz;
import net.minecraft.server.CreativeTab;

public class class_aiu extends class_agd {
   public static final class_anx a = class_anx.a("facing", new Predicate() {
      public boolean a(EnumDirection var1) {
         return var1 != EnumDirection.UP;
      }

      // $FF: synthetic method
      public boolean apply(Object var1) {
         return this.a((EnumDirection)var1);
      }
   });
   public static final class_anw b = class_anw.a("enabled");

   public class_aiu() {
      super(Material.ORE, MaterialMapColor.COLOR12);
      this.setBlockData(this.blockStateList.getFirst().set(a, EnumDirection.DOWN).set(b, Boolean.valueOf(true)));
      this.a(CreativeTab.d);
      this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public void a(class_aer var1, BlockPosition var2) {
      this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, class_awf var4, List var5, class_pr var6) {
      this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 0.625F, 1.0F);
      super.a(var1, var2, var3, var4, var5, var6);
      float var7 = 0.125F;
      this.setSizes(0.0F, 0.0F, 0.0F, var7, 1.0F, 1.0F);
      super.a(var1, var2, var3, var4, var5, var6);
      this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var7);
      super.a(var1, var2, var3, var4, var5, var6);
      this.setSizes(1.0F - var7, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      super.a(var1, var2, var3, var4, var5, var6);
      this.setSizes(0.0F, 0.0F, 1.0F - var7, 1.0F, 1.0F, 1.0F);
      super.a(var1, var2, var3, var4, var5, var6);
      this.setSizes(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public IBlockData a(World var1, BlockPosition var2, EnumDirection var3, float var4, float var5, float var6, int var7, class_qa var8) {
      EnumDirection var9 = var3.getOpposite();
      if(var9 == EnumDirection.UP) {
         var9 = EnumDirection.DOWN;
      }

      return this.getBlockData().set(a, var9).set(b, Boolean.valueOf(true));
   }

   public class_amg a(World var1, int var2) {
      return new class_amt();
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, class_qa var4, ItemStack var5) {
      super.a(var1, var2, var3, var4, var5);
      if(var5.hasDisplayName()) {
         class_amg var6 = var1.s(var2);
         if(var6 instanceof class_amt) {
            ((class_amt)var6).a(var5.getDisplayName());
         }
      }

   }

   public void c(World var1, BlockPosition var2, IBlockData var3) {
      this.e(var1, var2, var3);
   }

   public boolean a(World var1, BlockPosition var2, IBlockData var3, class_xa var4, EnumUsedHand var5, ItemStack var6, EnumDirection var7, float var8, float var9, float var10) {
      if(var1.D) {
         return true;
      } else {
         class_amg var11 = var1.s(var2);
         if(var11 instanceof class_amt) {
            var4.a((class_oj)((class_amt)var11));
            var4.b(class_nc.P);
         }

         return true;
      }
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, Block var4) {
      this.e(var1, var2, var3);
   }

   private void e(World var1, BlockPosition var2, IBlockData var3) {
      boolean var4 = !var1.z(var2);
      if(var4 != ((Boolean)var3.get(b)).booleanValue()) {
         var1.a((BlockPosition)var2, (IBlockData)var3.set(b, Boolean.valueOf(var4)), 4);
      }

   }

   public void b(World var1, BlockPosition var2, IBlockData var3) {
      class_amg var4 = var1.s(var2);
      if(var4 instanceof class_amt) {
         class_ol.a(var1, (BlockPosition)var2, (class_amt)var4);
         var1.e(var2, this);
      }

      super.b(var1, var2, var3);
   }

   public int getRenderType() {
      return 3;
   }

   public boolean isFullCube() {
      return false;
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public static EnumDirection b(int var0) {
      return EnumDirection.getById(var0 & 7);
   }

   public static boolean f(int var0) {
      return (var0 & 8) != 8;
   }

   public boolean Q() {
      return true;
   }

   public int l(World var1, BlockPosition var2) {
      return class_xz.a(var1.s(var2));
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(a, b(var1)).set(b, Boolean.valueOf(f(var1)));
   }

   public int toLegacyData(IBlockData var1) {
      byte var2 = 0;
      int var3 = var2 | ((EnumDirection)var1.get(a)).getId();
      if(!((Boolean)var1.get(b)).booleanValue()) {
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
}
