package net.minecraft.server;

public class ItemMilkBucket extends Item {
   public ItemMilkBucket() {
      this.d(1);
      this.setCreativeTab(CreativeTab.MISC);
   }

   public ItemStack onUseFinish(ItemStack var1, World var2, EntityLiving var3) {
      if(var3 instanceof EntityHuman && !((EntityHuman)var3).abilities.instabuild) {
         --var1.count;
      }

      if(!var2.isClientSide) {
         var3.bl();
      }

      if(var3 instanceof EntityHuman) {
         ((EntityHuman)var3).b(StatisticList.ad[Item.getId((Item)this)]);
      }

      return var1.count <= 0?new ItemStack(Items.BUCKET):var1;
   }

   public int getUseDuration(ItemStack var1) {
      return 32;
   }

   public EnumAnimation getAnimation(ItemStack var1) {
      return EnumAnimation.DRINK;
   }

   public UseResultWithValue onUse(ItemStack var1, World var2, EntityHuman var3, EnumUsedHand var4) {
      var3.c(var4);
      return new UseResultWithValue(UseResult.SUCCESS, var1);
   }
}
