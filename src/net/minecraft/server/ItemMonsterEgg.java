package net.minecraft.server;

public class ItemMonsterEgg extends Item {
   public ItemMonsterEgg() {
      this.registerItemKey(true);
      this.registerItemKey(CreativeTab.MISC);
   }

   public String getLocalizedName(ItemStack var1) {
      String var2 = ("" + LocaleI18n.get(this.registerItemKey() + ".name")).trim();
      String var3 = EntityTypes.b(var1.i());
      if(var3 != null) {
         var2 = var2 + " " + LocaleI18n.get("entity." + var3 + ".name");
      }

      return var2;
   }

   public UseResult registerItemKey(ItemStack var1, EntityHuman var2, World var3, BlockPosition var4, EnumUsedHand var5, EnumDirection var6, float var7, float var8, float var9) {
      if(var3.isClientSide) {
         return UseResult.SUCCESS;
      } else if(!var2.a(var4.shift(var6), var6, var1)) {
         return UseResult.CANT_USE;
      } else {
         IBlockData var10 = var3.getType(var4);
         if(var10.getBlock() == Blocks.MOB_SPAWNER) {
            TileEntity var11 = var3.getTileEntity(var4);
            if(var11 instanceof TileEntityMobSpawner) {
               class_aee var12 = ((TileEntityMobSpawner)var11).b();
               var12.a(EntityTypes.b(var1.i()));
               var11.update();
               var3.notify(var4);
               if(!var2.abilities.instabuild) {
                  --var1.count;
               }

               return UseResult.SUCCESS;
            }
         }

         var4 = var4.shift(var6);
         double var14 = 0.0D;
         if(var6 == EnumDirection.UP && var10 instanceof BlockFence) {
            var14 = 0.5D;
         }

         Entity var13 = a(var3, var1.i(), (double)var4.getX() + 0.5D, (double)var4.getY() + var14, (double)var4.getZ() + 0.5D);
         if(var13 != null) {
            if(var13 instanceof EntityLiving && var1.hasDisplayName()) {
               var13.a(var1.getDisplayName());
            }

            if(!var2.abilities.instabuild) {
               --var1.count;
            }
         }

         return UseResult.SUCCESS;
      }
   }

   public class_or registerItemKey(ItemStack var1, World var2, EntityHuman var3, EnumUsedHand var4) {
      if(var2.isClientSide) {
         return new class_or(UseResult.CANT_USE, var1);
      } else {
         MovingObjectPosition var5 = this.registerItemKey(var2, var3, true);
         if(var5 == null) {
            return new class_or(UseResult.CANT_USE, var1);
         } else {
            if(var5.a == MovingObjectPosition.class_a_in_class_awg.b) {
               BlockPosition var6 = var5.a();
               if(!var2.a(var3, var6)) {
                  return new class_or(UseResult.CANT_USE, var1);
               }

               if(!var3.a(var6, var5.b, var1)) {
                  return new class_or(UseResult.CANT_USE, var1);
               }

               if(var2.getType(var6).getBlock() instanceof BlockFluids) {
                  Entity var7 = a(var2, var1.i(), (double)var6.getX() + 0.5D, (double)var6.getY() + 0.5D, (double)var6.getZ() + 0.5D);
                  if(var7 != null) {
                     if(var7 instanceof EntityLiving && var1.hasDisplayName()) {
                        var7.a(var1.getDisplayName());
                     }

                     if(!var3.abilities.instabuild) {
                        --var1.count;
                     }

                     var3.b(StatisticList.ad[Item.getId((Item)this)]);
                     return new class_or(UseResult.SUCCESS, var1);
                  }
               }
            }

            return new class_or(UseResult.CANT_USE, var1);
         }
      }
   }

   public static Entity a(World var0, int var1, double var2, double var4, double var6) {
      if(!EntityTypes.a.containsKey(Integer.valueOf(var1))) {
         return null;
      } else {
         Entity var8 = null;

         for(int var9 = 0; var9 < 1; ++var9) {
            var8 = EntityTypes.a(var1, var0);
            if(var8 instanceof EntityLiving) {
               EntityInsentient var10 = (EntityInsentient)var8;
               var8.b(var2, var4, var6, MathHelper.clampAngle(var0.random.nextFloat() * 360.0F), 0.0F);
               var10.aN = var10.y;
               var10.aL = var10.y;
               var10.a((class_on)var0.E(new BlockPosition(var10)), (class_qd)null);
               var0.addEntity(var8);
               var10.z();
            }
         }

         return var8;
      }
   }
}
