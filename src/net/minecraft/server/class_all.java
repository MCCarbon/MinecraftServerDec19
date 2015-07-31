package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.ItemStack;
import net.minecraft.server.World;
import net.minecraft.server.class_agd;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_amz;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.BlockStateEnum;
import net.minecraft.server.IBlockState;
import net.minecraft.server.class_ast;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_xa;

public class class_all extends class_agd {
   public static final BlockStateEnum a = BlockStateEnum.of("mode", class_amz.class_a_in_class_amz.class);
   private final class_ast b = new class_ast();

   public class_all() {
      super(Material.ORE, MaterialMapColor.COLOR23);
      this.setBlockData(this.blockStateList.getFirst());
   }

   public class_amg a(World var1, int var2) {
      return new class_amz();
   }

   public boolean a(World var1, BlockPosition var2, IBlockData var3, class_xa var4, EnumUsedHand var5, ItemStack var6, EnumDirection var7, float var8, float var9, float var10) {
      return false;
   }

   public void a(World var1, BlockPosition var2, IBlockData var3, class_qa var4, ItemStack var5) {
   }

   public int a(Random var1) {
      return 0;
   }

   public int getRenderType() {
      return 3;
   }

   public IBlockData a(World var1, BlockPosition var2, EnumDirection var3, float var4, float var5, float var6, int var7, class_qa var8) {
      return this.getBlockData().set(a, class_amz.class_a_in_class_amz.d);
   }

   public class_ast l() {
      return this.b;
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(a, class_amz.class_a_in_class_amz.a(var1));
   }

   public int toLegacyData(IBlockData var1) {
      return ((class_amz.class_a_in_class_amz)var1.get(a)).a();
   }

   protected BlockStateList createBlockStateList() {
      return new BlockStateList(this, new IBlockState[]{a});
   }
}
