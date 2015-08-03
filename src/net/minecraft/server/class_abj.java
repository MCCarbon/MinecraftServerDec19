package net.minecraft.server;

public class class_abj extends ItemBeetroot {
   private Block b;
   private Block c;

   public class_abj(int var1, float var2, Block var3, Block var4) {
      super(var1, var2, false);
      this.b = var3;
      this.c = var4;
   }

   public UseResult a(ItemStack var1, EntityHuman var2, World var3, BlockPosition var4, EnumUsedHand var5, EnumDirection var6, float var7, float var8, float var9) {
      if(var6 != EnumDirection.UP) {
         return UseResult.CANT_USE;
      } else if(!var2.a(var4.shift(var6), var6, var1)) {
         return UseResult.CANT_USE;
      } else if(var3.getType(var4).getBlock() == this.c && var3.isEmpty(var4.up())) {
         var3.setTypeUpdate(var4.up(), this.b.getBlockData());
         --var1.count;
         return UseResult.SUCCESS;
      } else {
         return UseResult.CANT_USE;
      }
   }
}
