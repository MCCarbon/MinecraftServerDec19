package net.minecraft.server;

public class ItemCarrotStick extends Item {
   public ItemCarrotStick() {
      this.registerItemKey(CreativeTab.TRANSPORTATION);
      this.d(1);
      this.e(25);
   }

   public class_or registerItemKey(ItemStack var1, World var2, EntityHuman var3, EnumUsedHand var4) {
      if(var3.aw() && var3.vehicle instanceof EntityPig) {
         EntityPig var5 = (EntityPig)var3.vehicle;
         if(var5.cB().h() && var1.j() - var1.i() >= 7) {
            var5.cB().g();
            var1.a(7, (EntityLiving)var3);
            if(var1.count == 0) {
               ItemStack var6 = new ItemStack(Items.FISHING_ROD);
               var6.setTag(var1.getTag());
               return new class_or(UseResult.SUCCESS, var6);
            }

            return new class_or(UseResult.SUCCESS, var1);
         }
      }

      var3.b(StatisticList.ad[Item.getId((Item)this)]);
      return new class_or(UseResult.CANT_USE, var1);
   }
}
