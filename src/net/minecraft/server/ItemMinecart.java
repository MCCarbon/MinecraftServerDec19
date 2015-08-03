package net.minecraft.server;

public class ItemMinecart extends Item {
   private static final IDispenseBehavior a = new DispenseBehaviorItem() {
      private final DispenseBehaviorItem b = new DispenseBehaviorItem();

      public ItemStack b(ISourceBlock var1, ItemStack var2) {
         EnumDirection var3 = BlockDispenser.b(var1.getData());
         World var4 = var1.getWorld();
         double var5 = var1.getX() + (double)var3.getAdjacentX() * 1.125D;
         double var7 = Math.floor(var1.getY()) + (double)var3.getAdjacentY();
         double var9 = var1.getZ() + (double)var3.getAdjacentZ() * 1.125D;
         BlockPosition var11 = var1.getPosition().shift(var3);
         IBlockData var12 = var4.getType(var11);
         BlockMinecartTrackAbstract.EnumTrackPosition var13 = var12.getBlock() instanceof BlockMinecartTrackAbstract?(BlockMinecartTrackAbstract.EnumTrackPosition)var12.get(((BlockMinecartTrackAbstract)var12.getBlock()).n()):BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_SOUTH;
         double var14;
         if(BlockMinecartTrackAbstract.d(var12)) {
            if(var13.isAscending()) {
               var14 = 0.6D;
            } else {
               var14 = 0.1D;
            }
         } else {
            if(var12.getBlock().getMaterial() != Material.AIR || !BlockMinecartTrackAbstract.d(var4.getType(var11.down()))) {
               return this.b.a(var1, var2);
            }

            IBlockData var16 = var4.getType(var11.down());
            BlockMinecartTrackAbstract.EnumTrackPosition var17 = var16.getBlock() instanceof BlockMinecartTrackAbstract?(BlockMinecartTrackAbstract.EnumTrackPosition)var16.get(((BlockMinecartTrackAbstract)var16.getBlock()).n()):BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_SOUTH;
            if(var3 != EnumDirection.DOWN && var17.isAscending()) {
               var14 = -0.4D;
            } else {
               var14 = -0.9D;
            }
         }

         EntityMinecartAbstract var18 = EntityMinecartAbstract.a(var4, var5, var7 + var14, var9, ((ItemMinecart) var2.getItem()).b);
         if(var2.hasDisplayName()) {
            var18.a(var2.getDisplayName());
         }

         var4.addEntity((Entity)var18);
         var2.a(1);
         return var2;
      }

      protected void a(ISourceBlock var1) {
         var1.getWorld().b(1000, var1.getPosition(), 0);
      }
   };
   private final EntityMinecartAbstract.EnumMinecartType b;

   public ItemMinecart(EntityMinecartAbstract.EnumMinecartType var1) {
      this.h = 1;
      this.b = var1;
      this.registerItemKey(CreativeTab.TRANSPORTATION);
      BlockDispenser.REGISTRY.register(this, a);
   }

   public UseResult registerItemKey(ItemStack var1, EntityHuman var2, World var3, BlockPosition var4, EnumUsedHand var5, EnumDirection var6, float var7, float var8, float var9) {
      IBlockData var10 = var3.getType(var4);
      if(BlockMinecartTrackAbstract.d(var10)) {
         if(!var3.isClientSide) {
            BlockMinecartTrackAbstract.EnumTrackPosition var11 = var10.getBlock() instanceof BlockMinecartTrackAbstract?(BlockMinecartTrackAbstract.EnumTrackPosition)var10.get(((BlockMinecartTrackAbstract)var10.getBlock()).n()):BlockMinecartTrackAbstract.EnumTrackPosition.NORTH_SOUTH;
            double var12 = 0.0D;
            if(var11.isAscending()) {
               var12 = 0.5D;
            }

            EntityMinecartAbstract var14 = EntityMinecartAbstract.a(var3, (double) var4.getX() + 0.5D, (double) var4.getY() + 0.0625D + var12, (double) var4.getZ() + 0.5D, this.b);
            if(var1.hasDisplayName()) {
               var14.a(var1.getDisplayName());
            }

            var3.addEntity((Entity)var14);
         }

         --var1.count;
         return UseResult.SUCCESS;
      } else {
         return UseResult.CANT_USE;
      }
   }
}
