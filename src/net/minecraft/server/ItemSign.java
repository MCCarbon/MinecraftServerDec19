package net.minecraft.server;

public class ItemSign extends Item {
   public ItemSign() {
      this.maxStackSize = 16;
      this.setCreativeTab(CreativeTab.DECORATIONS);
   }

   public UseResult interactWith(ItemStack var1, EntityHuman var2, World var3, BlockPosition var4, EnumUsedHand var5, EnumDirection var6, float var7, float var8, float var9) {
      if(var6 == EnumDirection.DOWN) {
         return UseResult.CANT_USE;
      } else if(!var3.getType(var4).getBlock().getMaterial().isBuildable()) {
         return UseResult.CANT_USE;
      } else {
         var4 = var4.shift(var6);
         if(!var2.a(var4, var6, var1)) {
            return UseResult.CANT_USE;
         } else if(!Blocks.STANDING_SIGN.canPlace(var3, var4)) {
            return UseResult.CANT_USE;
         } else if(var3.isClientSide) {
            return UseResult.SUCCESS;
         } else {
            if(var6 == EnumDirection.UP) {
               int var10 = MathHelper.floor((double)((var2.yaw + 180.0F) * 16.0F / 360.0F) + 0.5D) & 15;
               var3.setTypeAndData((BlockPosition)var4, (IBlockData)Blocks.STANDING_SIGN.getBlockData().set(BlockFloorSign.a, Integer.valueOf(var10)), 3);
            } else {
               var3.setTypeAndData((BlockPosition)var4, (IBlockData)Blocks.WALL_SIGN.getBlockData().set(BlockWallSign.a, var6), 3);
            }

            --var1.count;
            TileEntity var11 = var3.getTileEntity(var4);
            if(var11 instanceof TileEntitySign && !ItemBlock.a(var3, var2, var4, var1)) {
               var2.a((TileEntitySign)var11);
            }

            return UseResult.SUCCESS;
         }
      }
   }
}
