package net.minecraft.server;

public class ItemSeeds extends Item {
   private Block a;
   private Block b;

   public ItemSeeds(Block var1, Block var2) {
      this.a = var1;
      this.b = var2;
      this.registerItemKey(CreativeTab.MATERIALS);
   }

   public UseResult registerItemKey(ItemStack var1, EntityHuman var2, World var3, BlockPosition var4, EnumUsedHand var5, EnumDirection var6, float var7, float var8, float var9) {
      if(var6 != EnumDirection.UP) {
         return UseResult.CANT_USE;
      } else if(!var2.a(var4.shift(var6), var6, var1)) {
         return UseResult.CANT_USE;
      } else if(var3.getType(var4).getBlock() == this.b && var3.isEmpty(var4.up())) {
         var3.setTypeUpdate(var4.up(), this.a.getBlockData());
         --var1.count;
         return UseResult.SUCCESS;
      } else {
         return UseResult.CANT_USE;
      }
   }
}
