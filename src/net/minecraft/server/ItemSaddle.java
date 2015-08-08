package net.minecraft.server;

public class ItemSaddle extends Item {
   public ItemSaddle() {
      this.maxStackSize = 1;
      this.setCreativeTab(CreativeTab.TRANSPORTATION);
   }

   public boolean canUseOn(ItemStack var1, EntityHuman var2, EntityLiving var3, EnumUsedHand var4) {
      if(var3 instanceof EntityPig) {
         EntityPig var5 = (EntityPig)var3;
         if(!var5.cA() && !var5.isBaby()) {
            var5.m(true);
            var5.world.a((Entity)var5, "mob.horse.leather", 0.5F, 1.0F);
            --var1.count;
         }

         return true;
      } else {
         return false;
      }
   }

   public boolean hitEntity(ItemStack var1, EntityLiving var2, EntityLiving var3) {
      this.canUseOn(var1, (EntityHuman) null, var2, EnumUsedHand.MAIN_HAND);
      return true;
   }
}
