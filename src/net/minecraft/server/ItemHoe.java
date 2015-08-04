package net.minecraft.server;

public class ItemHoe extends Item {
   protected EnumToolMaterial a;

   public ItemHoe(EnumToolMaterial var1) {
      this.a = var1;
      this.h = 1;
      this.e(var1.a());
      this.registerItemKey(CreativeTab.TOOLS);
   }

   public UseResult registerItemKey(ItemStack var1, EntityHuman var2, World var3, BlockPosition var4, EnumUsedHand var5, EnumDirection var6, float var7, float var8, float var9) {
      if(!var2.a(var4.shift(var6), var6, var1)) {
         return UseResult.CANT_USE;
      } else {
         IBlockData var10 = var3.getType(var4);
         Block var11 = var10.getBlock();
         if(var6 != EnumDirection.DOWN && var3.getType(var4.up()).getBlock().getMaterial() == Material.AIR) {
            if(var11 == Blocks.GRASS || var11 == Blocks.GRASS_PATH) {
               return this.a(var1, var2, var3, var4, Blocks.FARMLAND.getBlockData());
            }

            if(var11 == Blocks.DIRT) {
               switch(ItemHoe.SyntheticClass_1.a[((BlockDirt.EnumDirtVariant)var10.get(BlockDirt.VARIANT)).ordinal()]) {
               case 1:
                  return this.a(var1, var2, var3, var4, Blocks.FARMLAND.getBlockData());
               case 2:
                  return this.a(var1, var2, var3, var4, Blocks.DIRT.getBlockData().set(BlockDirt.VARIANT, BlockDirt.EnumDirtVariant.DIRT));
               }
            }
         }

         return UseResult.CANT_USE;
      }
   }

   protected UseResult a(ItemStack var1, EntityHuman var2, World var3, BlockPosition var4, IBlockData var5) {
      var3.a((double)((float)var4.getX() + 0.5F), (double)((float)var4.getY() + 0.5F), (double)((float)var4.getZ() + 0.5F), var5.getBlock().stepSound.getStepSound(), (var5.getBlock().stepSound.getVolume() + 1.0F) / 2.0F, var5.getBlock().stepSound.getPitch() * 0.8F);
      if(var3.isClientSide) {
         return UseResult.SUCCESS;
      } else {
         var3.setTypeUpdate(var4, var5);
         var1.a(1, (EntityLiving)var2);
         return UseResult.SUCCESS;
      }
   }

   public String g() {
      return this.a.toString();
   }

   // $FF: synthetic class
   static class SyntheticClass_1 {
      // $FF: synthetic field
      static final int[] a = new int[BlockDirt.EnumDirtVariant.values().length];

      static {
         try {
            a[BlockDirt.EnumDirtVariant.DIRT.ordinal()] = 1;
         } catch (NoSuchFieldError var2) {
            ;
         }

         try {
            a[BlockDirt.EnumDirtVariant.COARSE_DIRT.ordinal()] = 2;
         } catch (NoSuchFieldError var1) {
            ;
         }

      }
   }
}
