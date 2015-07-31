package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.Item;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;
import net.minecraft.server.class_agd;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_aiv;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_amp;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.class_anx;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.class_nc;
import net.minecraft.server.class_oj;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_yu;
import net.minecraft.server.CreativeTab;

public class class_ahv extends class_agd {
   public static final class_anx a;

   protected class_ahv() {
      super(Material.STONE);
      this.setBlockData(this.blockStateList.getFirst().set(a, EnumDirection.NORTH));
      this.a(CreativeTab.c);
      this.setSizes(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean isFullCube() {
      return false;
   }

   public int getRenderType() {
      return 2;
   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return Item.getByBlock(Blocks.OBSIDIAN);
   }

   public int a(Random var1) {
      return 8;
   }

   protected boolean K() {
      return true;
   }

   public IBlockData a(World var1, BlockPosition var2, EnumDirection var3, float var4, float var5, float var6, int var7, class_qa var8) {
      return this.getBlockData().set(a, var8.aR().getOpposite());
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, class_qa var4, ItemStack var5) {
      var1.a((BlockPosition)var2, (IBlockData)var3.set(a, var4.aR().getOpposite()), 2);
   }

   public boolean a(World var1, BlockPosition var2, IBlockData var3, class_xa var4, EnumUsedHand var5, ItemStack var6, EnumDirection var7, float var8, float var9, float var10) {
      class_yu var11 = var4.cq();
      class_amg var12 = var1.s(var2);
      if(var11 != null && var12 instanceof class_amp) {
         if(var1.p(var2.shiftUp()).getBlock().isOccluding()) {
            return true;
         } else if(var1.D) {
            return true;
         } else {
            var11.a((class_amp)var12);
            var4.a((class_oj)var11);
            var4.b(class_nc.V);
            return true;
         }
      } else {
         return true;
      }
   }

   public class_amg a(World var1, int var2) {
      return new class_amp();
   }

   public IBlockData fromLegacyData(int var1) {
      EnumDirection var2 = EnumDirection.getById(var1);
      if(var2.getAxis() == EnumDirection.EnumAxis.Y) {
         var2 = EnumDirection.NORTH;
      }

      return this.getBlockData().set(a, var2);
   }

   public int toLegacyData(IBlockData var1) {
      return ((EnumDirection)var1.get(a)).getId();
   }

   public IBlockData a(IBlockData var1, Block.class_c_in_class_agj var2) {
      return var1.getBlock() != this?var1:var1.set(a, var2.a((EnumDirection)var1.get(a)));
   }

   public IBlockData a(IBlockData var1, Block.class_a_in_class_agj var2) {
      return var1.getBlock() != this?var1:this.a(var1, var2.a((EnumDirection)var1.get(a)));
   }

   protected BlockStateList createBlockStateList() {
      return new BlockStateList(this, new IBlockState[]{a});
   }

   static {
      a = class_aiv.O;
   }
}
