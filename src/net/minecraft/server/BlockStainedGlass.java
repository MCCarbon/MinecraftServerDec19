package net.minecraft.server;

import java.util.Random;

public class BlockStainedGlass extends BlockHalfTransparent {
   public static final BlockStateEnum a = BlockStateEnum.of("color", EnumColor.class);

   public BlockStainedGlass(Material var1) {
      super(var1, false);
      this.setBlockData(this.blockStateList.getFirst().set(a, EnumColor.a));
      this.setCreativeTab((CreativeTab)CreativeTab.BUILDING_BLOCKS);
   }

   public int getDropData(IBlockData var1) {
      return ((EnumColor)var1.get(a)).a();
   }

   public MaterialMapColor getMapColor(IBlockData var1) {
      return ((EnumColor)var1.get(a)).e();
   }

   public int getDropCount(Random var1) {
      return 0;
   }

   protected boolean canApplySilkTouch() {
      return true;
   }

   public boolean isFullCube() {
      return false;
   }

   public IBlockData fromLegacyData(int var1) {
      return this.getBlockData().set(a, EnumColor.b(var1));
   }

   public void onPlace(World var1, BlockPosition var2, IBlockData var3) {
      if(!var1.isClientSide) {
         BlockBeacon.f(var1, var2);
      }

   }

   public void remove(World var1, BlockPosition var2, IBlockData var3) {
      if(!var1.isClientSide) {
         BlockBeacon.f(var1, var2);
      }

   }

   public int toLegacyData(IBlockData var1) {
      return ((EnumColor)var1.get(a)).a();
   }

   protected BlockStateList getStateList() {
      return new BlockStateList(this, new IBlockState[]{a});
   }
}
