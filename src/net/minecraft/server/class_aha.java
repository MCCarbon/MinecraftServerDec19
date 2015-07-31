package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.ItemStack;
import net.minecraft.server.class_aed;
import net.minecraft.server.World;
import net.minecraft.server.class_agd;
import net.minecraft.server.Block;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_amj;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.class_anw;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_xa;

public class class_aha extends class_agd {
   public static final class_anw a = class_anw.a("triggered");

   public class_aha() {
      super(Material.ORE, MaterialMapColor.COLOR16);
      this.setBlockData(this.blockStateList.getFirst().set(a, Boolean.valueOf(false)));
   }

   public class_amg a(World var1, int var2) {
      return new class_amj();
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, Block var4) {
      if(!var1.D) {
         boolean var5 = var1.z(var2);
         boolean var6 = ((Boolean)var3.get(a)).booleanValue();
         if(var5 && !var6) {
            var1.a((BlockPosition)var2, (IBlockData)var3.set(a, Boolean.valueOf(true)), 4);
            var1.a((BlockPosition)var2, (Block)this, this.a(var1));
         } else if(!var5 && var6) {
            var1.a((BlockPosition)var2, (IBlockData)var3.set(a, Boolean.valueOf(false)), 4);
         }
      }

   }

   public void b(World var1, BlockPosition var2, IBlockData var3, Random var4) {
      class_amg var5 = var1.s(var2);
      if(var5 instanceof class_amj) {
         ((class_amj)var5).b().a(var1);
         var1.e(var2, this);
      }

   }

   public int a(World var1) {
      return 1;
   }

   public boolean a(World var1, BlockPosition var2, IBlockData var3, class_xa var4, EnumUsedHand var5, ItemStack var6, EnumDirection var7, float var8, float var9, float var10) {
      class_amg var11 = var1.s(var2);
      return var11 instanceof class_amj?((class_amj)var11).b().a(var4):false;
   }

   public boolean Q() {
      return true;
   }

   public int l(World var1, BlockPosition var2) {
      class_amg var3 = var1.s(var2);
      return var3 instanceof class_amj?((class_amj)var3).b().j():0;
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, class_qa var4, ItemStack var5) {
      class_amg var6 = var1.s(var2);
      if(var6 instanceof class_amj) {
         class_aed var7 = ((class_amj)var6).b();
         if(var5.hasDisplayName()) {
            var7.b(var5.getDisplayName());
         }

         if(!var1.D) {
            var7.a(var1.R().b("sendCommandFeedback"));
         }

      }
   }

   public int a(Random var1) {
      return 0;
   }

   public int getRenderType() {
      return 3;
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(a, Boolean.valueOf((var1 & 1) > 0));
   }

   public int toLegacyData(IBlockData var1) {
      int var2 = 0;
      if(((Boolean)var1.get(a)).booleanValue()) {
         var2 |= 1;
      }

      return var2;
   }

   protected BlockStateList createBlockStateList() {
      return new BlockStateList(this, new IBlockState[]{a});
   }

   public IBlockData a(World var1, BlockPosition var2, EnumDirection var3, float var4, float var5, float var6, int var7, class_qa var8) {
      return this.getBlockData().set(a, Boolean.valueOf(false));
   }
}
