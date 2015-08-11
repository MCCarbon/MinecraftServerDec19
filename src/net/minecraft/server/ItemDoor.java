package net.minecraft.server;

public class ItemDoor extends Item {
   private Block a;

   public ItemDoor(Block var1) {
      this.a = var1;
      this.setCreativeTab(CreativeTab.REDSTONE);
   }

   public UseResult interactWith(ItemStack var1, EntityHuman var2, World var3, BlockPosition var4, EnumUsedHand var5, EnumDirection var6, float var7, float var8, float var9) {
      if(var6 != EnumDirection.UP) {
         return UseResult.CANT_USE;
      } else {
         IBlockData var10 = var3.getType(var4);
         Block var11 = var10.getBlock();
         if(!var11.isReplaceable(var3, var4)) {
            var4 = var4.shift(var6);
         }

         if(!var2.a(var4, var6, var1)) {
            return UseResult.CANT_USE;
         } else if(!this.a.canPlace(var3, var4)) {
            return UseResult.CANT_USE;
         } else {
            a(var3, var4, EnumDirection.fromAngle((double)var2.yaw), this.a);
            --var1.count;
            return UseResult.SUCCESS;
         }
      }
   }

   public static void a(World var0, BlockPosition var1, EnumDirection var2, Block var3) {
      BlockPosition var4 = var1.shift(var2.rotateY());
      BlockPosition var5 = var1.shift(var2.rotateYCCW());
      int var6 = (var0.getType(var5).getBlock().isOccluding()?1:0) + (var0.getType(var5.up()).getBlock().isOccluding()?1:0);
      int var7 = (var0.getType(var4).getBlock().isOccluding()?1:0) + (var0.getType(var4.up()).getBlock().isOccluding()?1:0);
      boolean var8 = var0.getType(var5).getBlock() == var3 || var0.getType(var5.up()).getBlock() == var3;
      boolean var9 = var0.getType(var4).getBlock() == var3 || var0.getType(var4.up()).getBlock() == var3;
      boolean var10 = false;
      if(var8 && !var9 || var7 > var6) {
         var10 = true;
      }

      BlockPosition var11 = var1.up();
      IBlockData var12 = var3.getBlockData().set(BlockDoor.a, var2).set(BlockDoor.N, var10? BlockDoor.class_b_in_class_ahl.b: BlockDoor.class_b_in_class_ahl.a);
      var0.setTypeAndData((BlockPosition)var1, (IBlockData)var12.set(BlockDoor.P, BlockDoor.class_a_in_class_ahl.b), 2);
      var0.setTypeAndData((BlockPosition)var11, (IBlockData)var12.set(BlockDoor.P, BlockDoor.class_a_in_class_ahl.a), 2);
      var0.applyPhysics(var1, var3);
      var0.applyPhysics(var11, var3);
   }
}
