package net.minecraft.server;

public class ItemSaddle extends Item {
   public ItemSaddle() {
      this.h = 1;
      this.registerItemKey(CreativeTab.TRANSPORTATION);
   }

   public boolean registerItemKey(ItemStack var1, EntityHuman var2, EntityLiving var3, EnumUsedHand var4) {
      if(var3 instanceof EntityPig) {
         EntityPig var5 = (EntityPig)var3;
         if(!var5.cA() && !var5.j_()) {
            var5.m(true);
            var5.o.a((Entity)var5, "mob.horse.leather", 0.5F, 1.0F);
            --var1.count;
         }

         return true;
      } else {
         return false;
      }
   }

   public boolean registerItemKey(ItemStack var1, EntityLiving var2, EntityLiving var3) {
      this.registerItemKey(var1, (EntityHuman) null, var2, EnumUsedHand.MAIN_HAND);
      return true;
   }
}
