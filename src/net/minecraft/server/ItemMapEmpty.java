package net.minecraft.server;

public class ItemMapEmpty extends class_zt {
   protected ItemMapEmpty() {
      this.setCreativeTab(CreativeTab.MISC);
   }

   public UseResultWithValue onUse(ItemStack var1, World var2, EntityHuman var3, EnumUsedHand var4) {
      ItemStack var5 = new ItemStack(Items.FILLED_MAP, 1, var2.b("map"));
      String var6 = "map_" + var5.i();
      class_avf var7 = new class_avf(var6);
      var2.a((String)var6, (class_avd)var7);
      var7.e = 0;
      var7.a(var3.locX, var3.locZ, var7.e);
      var7.d = (byte)var2.worldProvider.p().a();
      var7.c();
      --var1.count;
      if(var1.count <= 0) {
         return new UseResultWithValue(UseResult.SUCCESS, var5);
      } else {
         if(!var3.inventory.a(var5.clone())) {
            var3.a(var5, false);
         }

         var3.b(StatisticList.ad[Item.getId((Item)this)]);
         return new UseResultWithValue(UseResult.SUCCESS, var1);
      }
   }
}
