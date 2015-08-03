package net.minecraft.server;

public class ItemFireworks extends Item {
   public UseResult registerItemKey(ItemStack var1, EntityHuman var2, World var3, BlockPosition var4, EnumUsedHand var5, EnumDirection var6, float var7, float var8, float var9) {
      if(!var3.isClientSide) {
         EntityFireworks var10 = new EntityFireworks(var3, (double)((float)var4.getX() + var7), (double)((float)var4.getY() + var8), (double)((float)var4.getZ() + var9), var1);
         var3.addEntity((Entity)var10);
         if(!var2.abilities.instabuild) {
            --var1.count;
         }

         return UseResult.SUCCESS;
      } else {
         return UseResult.CANT_USE;
      }
   }
}
