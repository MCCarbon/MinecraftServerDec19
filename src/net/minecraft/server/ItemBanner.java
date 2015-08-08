package net.minecraft.server;

public class ItemBanner extends ItemBlock {
   public ItemBanner() {
      super(Blocks.STANDING_BANNER);
      this.maxStackSize = 16;
      this.setCreativeTab(CreativeTab.DECORATIONS);
      this.setUsesData(true);
      this.setMaxDurability(0);
   }

   public UseResult interactWith(ItemStack var1, EntityHuman var2, World var3, BlockPosition var4, EnumUsedHand var5, EnumDirection var6, float var7, float var8, float var9) {
      if(var6 == EnumDirection.DOWN) {
         return UseResult.CANT_USE;
      } else if(!var3.getType(var4).getBlock().getMaterial().isBuildable()) {
         return UseResult.CANT_USE;
      } else {
         var4 = var4.shift(var6);
         if(!var2.a(var4, var6, var1)) {
            return UseResult.CANT_USE;
         } else if(!Blocks.STANDING_BANNER.canPlace(var3, var4)) {
            return UseResult.CANT_USE;
         } else if(var3.isClientSide) {
            return UseResult.SUCCESS;
         } else {
            if(var6 == EnumDirection.UP) {
               int var10 = MathHelper.floor((double)((var2.yaw + 180.0F) * 16.0F / 360.0F) + 0.5D) & 15;
               var3.setTypeAndData((BlockPosition)var4, (IBlockData)Blocks.STANDING_BANNER.getBlockData().set(BlockFloorSign.a, Integer.valueOf(var10)), 3);
            } else {
               var3.setTypeAndData((BlockPosition)var4, (IBlockData)Blocks.WALL_BANNER.getBlockData().set(BlockWallSign.a, var6), 3);
            }

            --var1.count;
            TileEntity var11 = var3.getTileEntity(var4);
            if(var11 instanceof TileEntityBanner) {
               ((TileEntityBanner)var11).a(var1);
            }

            return UseResult.SUCCESS;
         }
      }
   }

   public String getLocalizedName(ItemStack var1) {
      String var2 = "item.banner.";
      EnumColor var3 = this.h(var1);
      var2 = var2 + var3.d() + ".name";
      return LocaleI18n.get(var2);
   }

   private EnumColor h(ItemStack var1) {
      NBTTagCompound var2 = var1.getCompound("BlockEntityTag", false);
      EnumColor var3 = null;
      if(var2 != null && var2.has("Base")) {
         var3 = EnumColor.a(var2.getInt("Base"));
      } else {
         var3 = EnumColor.a(var1.i());
      }

      return var3;
   }
}
