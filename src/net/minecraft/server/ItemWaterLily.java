package net.minecraft.server;

public class ItemWaterLily extends ItemWithAuxData {
   public ItemWaterLily(Block var1) {
      super(var1, false);
   }

   public class_or registerItemKey(ItemStack var1, World var2, EntityHuman var3, EnumUsedHand var4) {
      MovingObjectPosition var5 = this.registerItemKey(var2, var3, true);
      if(var5 == null) {
         return new class_or(UseResult.CANT_USE, var1);
      } else {
         if(var5.a == MovingObjectPosition.class_a_in_class_awg.b) {
            BlockPosition var6 = var5.a();
            if(!var2.a(var3, var6)) {
               return new class_or(UseResult.CANT_USE, var1);
            }

            if(!var3.a(var6.shift(var5.b), var5.b, var1)) {
               return new class_or(UseResult.CANT_USE, var1);
            }

            BlockPosition var7 = var6.up();
            IBlockData var8 = var2.getType(var6);
            if(var8.getBlock().getMaterial() == Material.WATER && ((Integer)var8.get(BlockFluids.LEVEL)).intValue() == 0 && var2.isEmpty(var7)) {
               var2.setTypeUpdate(var7, Blocks.WATERLILY.getBlockData());
               if(!var3.abilities.instabuild) {
                  --var1.count;
               }

               var3.b(StatisticList.ad[Item.getId((Item)this)]);
               return new class_or(UseResult.SUCCESS, var1);
            }
         }

         return new class_or(UseResult.CANT_USE, var1);
      }
   }
}
