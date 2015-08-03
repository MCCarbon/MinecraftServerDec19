package net.minecraft.server;

public class class_aam extends Item {
   public class_aam() {
      this.h = 1;
      this.e(64);
      this.registerItemKey(CreativeTab.TOOLS);
   }

   public UseResult registerItemKey(ItemStack var1, EntityHuman var2, World var3, BlockPosition var4, EnumUsedHand var5, EnumDirection var6, float var7, float var8, float var9) {
      var4 = var4.shift(var6);
      if(!var2.a(var4, var6, var1)) {
         return UseResult.CANT_USE;
      } else {
         if(var3.getType(var4).getBlock().getMaterial() == Material.AIR) {
            var3.a((double)var4.getX() + 0.5D, (double)var4.getY() + 0.5D, (double)var4.getZ() + 0.5D, "fire.ignite", 1.0F, random.nextFloat() * 0.4F + 0.8F);
            var3.setTypeUpdate(var4, Blocks.FIRE.getBlockData());
         }

         var1.a(1, (EntityLiving)var2);
         return UseResult.SUCCESS;
      }
   }
}
