package net.minecraft.server;

public class ItemReed extends Item {
   private Block a;

   public ItemReed(Block var1) {
      this.a = var1;
   }

   public UseResult interactWith(ItemStack var1, EntityHuman var2, World var3, BlockPosition var4, EnumUsedHand var5, EnumDirection var6, float var7, float var8, float var9) {
      IBlockData var10 = var3.getType(var4);
      Block var11 = var10.getBlock();
      if(var11 == Blocks.SNOW_LAYER && ((Integer)var10.get(BlockSnow.a)).intValue() < 1) {
         var6 = EnumDirection.UP;
      } else if(!var11.isReplaceable(var3, var4)) {
         var4 = var4.shift(var6);
      }

      if(!var2.a(var4, var6, var1)) {
         return UseResult.CANT_USE;
      } else if(var1.count == 0) {
         return UseResult.CANT_USE;
      } else {
         if(var3.a(this.a, var4, false, var6, (Entity)null, var1)) {
            IBlockData var12 = this.a.getPlacedState(var3, var4, var6, var7, var8, var9, 0, var2);
            if(var3.setTypeAndData((BlockPosition)var4, (IBlockData)var12, 3)) {
               var12 = var3.getType(var4);
               if(var12.getBlock() == this.a) {
                  ItemBlock.a(var3, var2, var4, var1);
                  var12.getBlock().postPlace(var3, var4, var12, var2, var1);
               }

               var3.a((double)((float)var4.getX() + 0.5F), (double)((float)var4.getY() + 0.5F), (double)((float)var4.getZ() + 0.5F), this.a.stepSound.getPlaceSound(), (this.a.stepSound.getVolume() + 1.0F) / 2.0F, this.a.stepSound.getPitch() * 0.8F);
               --var1.count;
               return UseResult.SUCCESS;
            }
         }

         return UseResult.CANT_USE;
      }
   }
}
