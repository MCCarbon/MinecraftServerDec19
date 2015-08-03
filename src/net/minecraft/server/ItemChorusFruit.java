package net.minecraft.server;

public class ItemChorusFruit extends ItemFood {
   public ItemChorusFruit(int var1, float var2) {
      super(var1, var2, false);
   }

   public ItemStack a(ItemStack var1, World var2, EntityLiving var3) {
      ItemStack var4 = super.a(var1, var2, var3);

      for(int var5 = 0; var5 < 16; ++var5) {
         double var6 = var3.s + (var3.bd().nextDouble() - 0.5D) * 64.0D;
         double var8 = var3.t + (double)(var3.bd().nextInt(64) - 32);
         double var10 = var3.u + (var3.bd().nextDouble() - 0.5D) * 64.0D;
         if(class_wb.a(var3, var6, var8, var10)) {
            break;
         }
      }

      return var4;
   }
}
