package net.minecraft.server;

public class ItemGlassBottle extends Item {
   public ItemGlassBottle() {
      this.setCreativeTab(CreativeTab.BREWING);
   }

   public UseResultWithValue onUse(ItemStack var1, World var2, EntityHuman var3, EnumUsedHand var4) {
      MovingObjectPosition var5 = this.getMovingObjectPositionFromPlayer(var2, var3, true);
      if(var5 == null) {
         return new UseResultWithValue(UseResult.CANT_USE, var1);
      } else {
         if(var5.a == MovingObjectPosition.class_a_in_class_awg.b) {
            BlockPosition var6 = var5.a();
            if(!var2.a(var3, var6)) {
               return new UseResultWithValue(UseResult.CANT_USE, var1);
            }

            if(!var3.a(var6.shift(var5.b), var5.b, var1)) {
               return new UseResultWithValue(UseResult.CANT_USE, var1);
            }

            if(var2.getType(var6).getBlock().getMaterial() == Material.WATER) {
               --var1.count;
               var3.b(StatisticList.ad[Item.getId((Item)this)]);
               if(var1.count <= 0) {
                  return new UseResultWithValue(UseResult.SUCCESS, new ItemStack(Items.POTION));
               }

               if(!var3.inventory.pickup(new ItemStack(Items.POTION))) {
                  var3.a(new ItemStack(Items.POTION), false);
               }

               return new UseResultWithValue(UseResult.SUCCESS, var1);
            }
         }

         return new UseResultWithValue(UseResult.CANT_USE, var1);
      }
   }
}
