package net.minecraft.server;

public class ItemDye extends Item {
   public static final int[] a = new int[]{1973019, 11743532, 3887386, 5320730, 2437522, 8073150, 2651799, 11250603, 4408131, 14188952, 4312372, 14602026, 6719955, 12801229, 15435844, 15790320};

   public ItemDye() {
      this.registerItemKey(true);
      this.e(0);
      this.registerItemKey(CreativeTab.MATERIALS);
   }

   public String e_(ItemStack var1) {
      int var2 = var1.i();
      return super.registerItemKey() + "." + EnumColor.a(var2).d();
   }

   public UseResult registerItemKey(ItemStack var1, EntityHuman var2, World var3, BlockPosition var4, EnumUsedHand var5, EnumDirection var6, float var7, float var8, float var9) {
      if(!var2.a(var4.shift(var6), var6, var1)) {
         return UseResult.CANT_USE;
      } else {
         EnumColor var10 = EnumColor.a(var1.i());
         if(var10 == EnumColor.a) {
            if(a(var1, var3, var4)) {
               if(!var3.isClientSide) {
                  var3.b(2005, var4, 0);
               }

               return UseResult.SUCCESS;
            }
         } else if(var10 == EnumColor.m) {
            IBlockData var11 = var3.getType(var4);
            Block var12 = var11.getBlock();
            if(var12 == Blocks.LOG && var11.get(BlockLog1.b) == BlockWood.EnumLogVariant.JUNGLE) {
               if(var6 == EnumDirection.DOWN) {
                  return UseResult.CANT_USE;
               }

               if(var6 == EnumDirection.UP) {
                  return UseResult.CANT_USE;
               }

               var4 = var4.shift(var6);
               if(var3.isEmpty(var4)) {
                  IBlockData var13 = Blocks.COCOA.getPlacedState(var3, var4, var6, var7, var8, var9, 0, var2);
                  var3.setTypeAndData((BlockPosition)var4, (IBlockData)var13, 2);
                  if(!var2.abilities.instabuild) {
                     --var1.count;
                  }
               }

               return UseResult.SUCCESS;
            }
         }

         return UseResult.CANT_USE;
      }
   }

   public static boolean a(ItemStack var0, World var1, BlockPosition var2) {
      IBlockData var3 = var1.getType(var2);
      if(var3.getBlock() instanceof IBlockFragilePlantElement) {
         IBlockFragilePlantElement var4 = (IBlockFragilePlantElement)var3.getBlock();
         if(var4.a(var1, var2, var3, var1.isClientSide)) {
            if(!var1.isClientSide) {
               if(var4.a(var1, var1.random, var2, var3)) {
                  var4.b(var1, var1.random, var2, var3);
               }

               --var0.count;
            }

            return true;
         }
      }

      return false;
   }

   public boolean registerItemKey(ItemStack var1, EntityHuman var2, EntityLiving var3, EnumUsedHand var4) {
      if(var3 instanceof EntitySheep) {
         EntitySheep var5 = (EntitySheep)var3;
         EnumColor var6 = EnumColor.a(var1.i());
         if(!var5.cB() && var5.cA() != var6) {
            var5.b(var6);
            --var1.count;
         }

         return true;
      } else {
         return false;
      }
   }
}
