package net.minecraft.server;

public class ItemFishingRod extends Item {
   public ItemFishingRod() {
      this.setMaxDurability(64);
      this.d(1);
      this.setCreativeTab(CreativeTab.TOOLS);
      this.registerItemState(new MinecraftKey("cast"), new ItemState() {
      });
   }

   public UseResultWithValue onUse(ItemStack var1, World var2, EntityHuman var3, EnumUsedHand var4) {
      if(var3.bN != null) {
         int var5 = var3.bN.l();
         var1.a(var5, (EntityLiving)var3);
         var3.a((EnumUsedHand)var4);
         return new UseResultWithValue(UseResult.CANT_USE, var1);
      } else {
         var2.a((Entity)var3, "random.bow", 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
         if(!var2.isClientSide) {
            var2.addEntity((Entity)(new class_ve(var2, var3)));
         }

         var3.a((EnumUsedHand)var4);
         var3.b(StatisticList.ad[Item.getId((Item)this)]);
         return new UseResultWithValue(UseResult.SUCCESS, var1);
      }
   }

   public boolean isTool(ItemStack var1) {
      return super.isTool(var1);
   }

   public int getItemEnchantability() {
      return 1;
   }
}
