package net.minecraft.server;

public class ItemRedstone extends Item {
   public ItemRedstone() {
      this.registerItemKey(CreativeTab.REDSTONE);
   }

   public UseResult registerItemKey(ItemStack var1, EntityHuman var2, World var3, BlockPosition var4, EnumUsedHand var5, EnumDirection var6, float var7, float var8, float var9) {
      boolean var10 = var3.getType(var4).getBlock().isReplaceable(var3, var4);
      BlockPosition var11 = var10?var4:var4.shift(var6);
      if(!var2.a(var11, var6, var1)) {
         return UseResult.CANT_USE;
      } else {
         Block var12 = var3.getType(var11).getBlock();
         if(!var3.a(var12, var11, false, var6, (Entity)null, var1)) {
            return UseResult.CANT_USE;
         } else if(Blocks.REDSTONE_WIRE.canPlace(var3, var11)) {
            --var1.count;
            var3.setTypeUpdate(var11, Blocks.REDSTONE_WIRE.getBlockData());
            return UseResult.SUCCESS;
         } else {
            return UseResult.CANT_USE;
         }
      }
   }
}
