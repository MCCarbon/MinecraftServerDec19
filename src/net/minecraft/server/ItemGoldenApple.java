package net.minecraft.server;

public class ItemGoldenApple extends ItemFood {
   public ItemGoldenApple(int var1, float var2, boolean var3) {
      super(var1, var2, var3);
      this.setUsesData(true);
   }

   public EnumItemRarity getRarity(ItemStack var1) {
      return var1.i() == 0?EnumItemRarity.RARE:EnumItemRarity.EPIC;
   }

   protected void a(ItemStack var1, World var2, EntityHuman var3) {
      if(!var2.isClientSide) {
         var3.addEffect(new MobEffect(MobEffectList.v, 2400, 0));
      }

      if(var1.i() > 0) {
         if(!var2.isClientSide) {
            var3.addEffect(new MobEffect(MobEffectList.j, 600, 4));
            var3.addEffect(new MobEffect(MobEffectList.k, 6000, 0));
            var3.addEffect(new MobEffect(MobEffectList.l, 6000, 0));
         }
      } else {
         super.a(var1, var2, var3);
      }

   }
}
