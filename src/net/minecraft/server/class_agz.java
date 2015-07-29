package net.minecraft.server;

import net.minecraft.server.Block;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateList;
import net.minecraft.server.BlockStateEnum;
import net.minecraft.server.IBlockState;
import net.minecraft.server.Material;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.CreativeTab;
import net.minecraft.server.class_zy;

public class class_agz extends Block {
   public static final BlockStateEnum a = BlockStateEnum.of("color", class_zy.class);

   public class_agz(Material var1) {
      super(var1);
      this.setBlockData(this.blockStateList.getFirst().set(a, class_zy.a));
      this.a(CreativeTab.b);
   }

   public int getDropData(IBlockData var1) {
      return ((class_zy)var1.get(a)).a();
   }

   public MaterialMapColor getMapColor(IBlockData var1) {
      return ((class_zy)var1.get(a)).e();
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(a, class_zy.b(var1));
   }

   public int toLegacyData(IBlockData var1) {
      return ((class_zy)var1.get(a)).a();
   }

   protected BlockStateList createBlockStateList() {
      return new BlockStateList(this, new IBlockState[]{a});
   }
}
