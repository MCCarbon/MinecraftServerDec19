package net.minecraft.server;

public class ItemWaterLily extends ItemWithAuxData {
   public ItemWaterLily(Block var1) {
      super(var1, false);
   }

   public UseResultWithValue onUse(ItemStack var1, World var2, EntityHuman var3, EnumUsedHand var4) {
      MovingObjectPosition var5 = this.getMovingObjectPositionFromPlayer(var2, var3, true);
      if(var5 == null) {
         return new UseResultWithValue(UseResult.CANT_USE, var1);
      } else {
         if(var5.type == MovingObjectPosition.EnumMovingObjectType.BLOCK) {
            BlockPosition var6 = var5.a();
            if(!var2.a(var3, var6)) {
               return new UseResultWithValue(UseResult.CANT_USE, var1);
            }

            if(!var3.a(var6.shift(var5.direction), var5.direction, var1)) {
               return new UseResultWithValue(UseResult.CANT_USE, var1);
            }

            BlockPosition var7 = var6.up();
            IBlockData var8 = var2.getType(var6);
            if(var8.getBlock().getMaterial() == Material.WATER && ((Integer)var8.get(BlockFluids.LEVEL)).intValue() == 0 && var2.isEmpty(var7)) {
               var2.setTypeUpdate(var7, Blocks.WATERLILY.getBlockData());
               if(!var3.abilities.instabuild) {
                  --var1.count;
               }

               var3.b(StatisticList.ad[Item.getId((Item)this)]);
               return new UseResultWithValue(UseResult.SUCCESS, var1);
            }
         }

         return new UseResultWithValue(UseResult.CANT_USE, var1);
      }
   }
}
