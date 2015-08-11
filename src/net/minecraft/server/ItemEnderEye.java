package net.minecraft.server;

public class ItemEnderEye extends Item {
   public ItemEnderEye() {
      this.setCreativeTab(CreativeTab.MISC);
   }

   public UseResult interactWith(ItemStack var1, EntityHuman var2, World var3, BlockPosition var4, EnumUsedHand var5, EnumDirection var6, float var7, float var8, float var9) {
      IBlockData var10 = var3.getType(var4);
      if(var2.a(var4.shift(var6), var6, var1) && var10.getBlock() == Blocks.END_PORTAL_FRAME && !((Boolean)var10.get(BlockEnderPortalFrame.b)).booleanValue()) {
         if(var3.isClientSide) {
            return UseResult.SUCCESS;
         } else {
            var3.setTypeAndData((BlockPosition)var4, (IBlockData)var10.set(BlockEnderPortalFrame.b, Boolean.valueOf(true)), 2);
            var3.updateAdjacentComparators(var4, Blocks.END_PORTAL_FRAME);
            --var1.count;

            for(int var11 = 0; var11 < 16; ++var11) {
               double var12 = (double)((float)var4.getX() + (5.0F + random.nextFloat() * 6.0F) / 16.0F);
               double var14 = (double)((float)var4.getY() + 0.8125F);
               double var16 = (double)((float)var4.getZ() + (5.0F + random.nextFloat() * 6.0F) / 16.0F);
               double var18 = 0.0D;
               double var20 = 0.0D;
               double var22 = 0.0D;
               var3.addParticle(EnumParticle.l, var12, var14, var16, var18, var20, var22, new int[0]);
            }

            EnumDirection var24 = (EnumDirection)var10.get(BlockEnderPortalFrame.a);
            int var25 = 0;
            int var13 = 0;
            boolean var26 = false;
            boolean var15 = true;
            EnumDirection var27 = var24.rotateY();

            for(int var17 = -2; var17 <= 2; ++var17) {
               BlockPosition var29 = var4.shift(var27, var17);
               IBlockData var19 = var3.getType(var29);
               if(var19.getBlock() == Blocks.END_PORTAL_FRAME) {
                  if(!((Boolean)var19.get(BlockEnderPortalFrame.b)).booleanValue()) {
                     var15 = false;
                     break;
                  }

                  var13 = var17;
                  if(!var26) {
                     var25 = var17;
                     var26 = true;
                  }
               }
            }

            if(var15 && var13 == var25 + 2) {
               BlockPosition var28 = var4.shift(var24, 4);

               int var30;
               for(var30 = var25; var30 <= var13; ++var30) {
                  BlockPosition var31 = var28.shift(var27, var30);
                  IBlockData var33 = var3.getType(var31);
                  if(var33.getBlock() != Blocks.END_PORTAL_FRAME || !((Boolean)var33.get(BlockEnderPortalFrame.b)).booleanValue()) {
                     var15 = false;
                     break;
                  }
               }

               int var32;
               BlockPosition var34;
               for(var30 = var25 - 1; var30 <= var13 + 1; var30 += 4) {
                  var28 = var4.shift(var27, var30);

                  for(var32 = 1; var32 <= 3; ++var32) {
                     var34 = var28.shift(var24, var32);
                     IBlockData var21 = var3.getType(var34);
                     if(var21.getBlock() != Blocks.END_PORTAL_FRAME || !((Boolean)var21.get(BlockEnderPortalFrame.b)).booleanValue()) {
                        var15 = false;
                        break;
                     }
                  }
               }

               if(var15) {
                  for(var30 = var25; var30 <= var13; ++var30) {
                     var28 = var4.shift(var27, var30);

                     for(var32 = 1; var32 <= 3; ++var32) {
                        var34 = var28.shift(var24, var32);
                        var3.setTypeAndData((BlockPosition)var34, (IBlockData)Blocks.END_PORTAL.getBlockData(), 2);
                     }
                  }
               }
            }

            return UseResult.SUCCESS;
         }
      } else {
         return UseResult.CANT_USE;
      }
   }

   public UseResultWithValue onUse(ItemStack var1, World var2, EntityHuman var3, EnumUsedHand var4) {
      MovingObjectPosition var5 = this.getMovingObjectPositionFromPlayer(var2, var3, false);
      if(var5 != null && var5.type == MovingObjectPosition.EnumMovingObjectType.BLOCK && var2.getType(var5.a()).getBlock() == Blocks.END_PORTAL_FRAME) {
         return new UseResultWithValue(UseResult.SUCCESS, var1);
      } else {
         if(!var2.isClientSide) {
            BlockPosition var6 = var2.a("Stronghold", new BlockPosition(var3));
            if(var6 != null) {
               EntityEnderSignal var7 = new EntityEnderSignal(var2, var3.locX, var3.locY, var3.locZ);
               var7.a(var6);
               var2.addEntity((Entity)var7);
               var2.a((Entity)var3, "random.bow", 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
               var2.a((EntityHuman)null, 1002, new BlockPosition(var3), 0);
               if(!var3.abilities.instabuild) {
                  --var1.count;
               }

               var3.b(StatisticList.ad[Item.getId((Item)this)]);
               return new UseResultWithValue(UseResult.SUCCESS, var1);
            }
         }

         return new UseResultWithValue(UseResult.CANT_USE, var1);
      }
   }
}
