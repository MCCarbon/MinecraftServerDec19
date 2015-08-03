package net.minecraft.server;

import java.util.Random;

public class class_aku extends BlockContainer {
   protected class_aku() {
      super(Material.WOOD);
      float var1 = 0.25F;
      float var2 = 1.0F;
      this.setSizes(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, var2, 0.5F + var1);
   }

   public AxisAlignedBB getBoundingBox(World var1, BlockPosition var2, IBlockData var3) {
      return null;
   }

   public boolean isFullCube() {
      return false;
   }

   public boolean isPassable(IBlockAccess var1, BlockPosition var2) {
      return true;
   }

   public boolean isOpaqueCube() {
      return false;
   }

   public boolean g() {
      return true;
   }

   public TileEntity createTileEntity(World var1, int var2) {
      return new TileEntitySign();
   }

   public Item getDropType(IBlockData var1, Random var2, int var3) {
      return Items.SIGN;
   }

   public boolean interact(World var1, BlockPosition var2, IBlockData var3, EntityHuman var4, EnumUsedHand var5, ItemStack var6, EnumDirection var7, float var8, float var9, float var10) {
      if(var1.isClientSide) {
         return true;
      } else {
         TileEntity var11 = var1.getTileEntity(var2);
         return var11 instanceof TileEntitySign?((TileEntitySign)var11).b(var4):false;
      }
   }

   public boolean canPlace(World var1, BlockPosition var2) {
      return !this.e(var1, var2) && super.canPlace(var1, var2);
   }
}
