package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.class_agg;
import net.minecraft.server.class_aiq;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.BlockStateEnum;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.CreativeTab;
import net.minecraft.server.class_zy;

public class class_alb extends class_aiq {
   public static final BlockStateEnum a = BlockStateEnum.of("color", class_zy.class);

   public class_alb(Material var1) {
      super(var1, false);
      this.setBlockData(this.blockStateList.getFirst().set(a, class_zy.a));
      this.a((CreativeTab)CreativeTab.b);
   }

   public int getDropData(IBlockData var1) {
      return ((class_zy)var1.get(a)).a();
   }

   public MaterialMapColor getMapColor(IBlockData var1) {
      return ((class_zy)var1.get(a)).e();
   }

   public int a(Random var1) {
      return 0;
   }

   protected boolean K() {
      return true;
   }

   public boolean isFullCube() {
      return false;
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(a, class_zy.b(var1));
   }

   public void c(World var1, BlockPosition var2, IBlockData var3) {
      if(!var1.D) {
         class_agg.f(var1, var2);
      }

   }

   public void b(World var1, BlockPosition var2, IBlockData var3) {
      if(!var1.D) {
         class_agg.f(var1, var2);
      }

   }

   public int toLegacyData(IBlockData var1) {
      return ((class_zy)var1.get(a)).a();
   }

   protected BlockStateList createBlockStateList() {
      return new BlockStateList(this, new IBlockState[]{a});
   }
}
