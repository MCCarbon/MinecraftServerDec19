package net.minecraft.server;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multisets;

public class ItemWorldMap extends class_zt {
   protected ItemWorldMap() {
      this.setUsesData(true);
   }

   public class_avf a(ItemStack var1, World var2) {
      String var3 = "map_" + var1.i();
      class_avf var4 = (class_avf)var2.a(class_avf.class, var3);
      if(var4 == null && !var2.isClientSide) {
         var1.setData(var2.b("map"));
         var3 = "map_" + var1.i();
         var4 = new class_avf(var3);
         var4.e = 3;
         var4.a((double)var2.Q().c(), (double)var2.Q().e(), var4.e);
         var4.d = (byte)var2.worldProvider.p().a();
         var4.c();
         var2.a((String)var3, (PersistentBase)var4);
      }

      return var4;
   }

   public void a(World var1, Entity var2, class_avf var3) {
      if(var1.worldProvider.p().a() == var3.d && var2 instanceof EntityHuman) {
         int var4 = 1 << var3.e;
         int var5 = var3.b;
         int var6 = var3.c;
         int var7 = MathHelper.floor(var2.locX - (double)var5) / var4 + 64;
         int var8 = MathHelper.floor(var2.locZ - (double)var6) / var4 + 64;
         int var9 = 128 / var4;
         if(var1.worldProvider.m()) {
            var9 /= 2;
         }

         class_avf.class_a_in_class_avf var10 = var3.a((EntityHuman)var2);
         ++var10.b;
         boolean var11 = false;

         for(int var12 = var7 - var9 + 1; var12 < var7 + var9; ++var12) {
            if((var12 & 15) == (var10.b & 15) || var11) {
               var11 = false;
               double var13 = 0.0D;

               for(int var15 = var8 - var9 - 1; var15 < var8 + var9; ++var15) {
                  if(var12 >= 0 && var15 >= -1 && var12 < 128 && var15 < 128) {
                     int var16 = var12 - var7;
                     int var17 = var15 - var8;
                     boolean var18 = var16 * var16 + var17 * var17 > (var9 - 2) * (var9 - 2);
                     int var19 = (var5 / var4 + var12 - 64) * var4;
                     int var20 = (var6 / var4 + var15 - 64) * var4;
                     HashMultiset var21 = HashMultiset.create();
                     Chunk var22 = var1.f(new BlockPosition(var19, 0, var20));
                     if(!var22.f()) {
                        int var23 = var19 & 15;
                        int var24 = var20 & 15;
                        int var25 = 0;
                        double var26 = 0.0D;
                        if(var1.worldProvider.m()) {
                           int var28 = var19 + var20 * 231871;
                           var28 = var28 * var28 * 31287121 + var28 * 11;
                           if((var28 >> 20 & 1) == 0) {
                              var21.add(Blocks.DIRT.getMapColor(Blocks.DIRT.getBlockData().set(BlockDirt.VARIANT, BlockDirt.EnumDirtVariant.DIRT)), 10);
                           } else {
                              var21.add(Blocks.STONE.getMapColor(Blocks.STONE.getBlockData().set(BlockStone.VARIANT, BlockStone.EnumStoneVariant.STONE)), 100);
                           }

                           var26 = 100.0D;
                        } else {
                           BlockPosition.MutableBlockPosition var35 = new BlockPosition.MutableBlockPosition();

                           for(int var29 = 0; var29 < var4; ++var29) {
                              for(int var30 = 0; var30 < var4; ++var30) {
                                 int var31 = var22.b(var29 + var23, var30 + var24) + 1;
                                 IBlockData var32 = Blocks.AIR.getBlockData();
                                 if(var31 > 1) {
                                    do {
                                       --var31;
                                       var32 = var22.g(var35.setPosition(var29 + var23, var31, var30 + var24));
                                    } while(var32.getBlock().getMapColor(var32) == MaterialMapColor.COLOR1 && var31 > 0);

                                    if(var31 > 0 && var32.getBlock().getMaterial().isLiquid()) {
                                       int var33 = var31 - 1;

                                       Block var34;
                                       do {
                                          var34 = var22.a(var29 + var23, var33--, var30 + var24);
                                          ++var25;
                                       } while(var33 > 0 && var34.getMaterial().isLiquid());
                                    }
                                 }

                                 var26 += (double)var31 / (double)(var4 * var4);
                                 var21.add(var32.getBlock().getMapColor(var32));
                              }
                           }
                        }

                        var25 /= var4 * var4;
                        double var36 = (var26 - var13) * 4.0D / (double)(var4 + 4) + ((double)(var12 + var15 & 1) - 0.5D) * 0.4D;
                        byte var37 = 1;
                        if(var36 > 0.6D) {
                           var37 = 2;
                        }

                        if(var36 < -0.6D) {
                           var37 = 0;
                        }

                        MaterialMapColor var38 = (MaterialMapColor)Iterables.getFirst(Multisets.copyHighestCountFirst(var21), MaterialMapColor.COLOR1);
                        if(var38 == MaterialMapColor.COLOR13) {
                           var36 = (double)var25 * 0.1D + (double)(var12 + var15 & 1) * 0.2D;
                           var37 = 1;
                           if(var36 < 0.5D) {
                              var37 = 2;
                           }

                           if(var36 > 0.9D) {
                              var37 = 0;
                           }
                        }

                        var13 = var26;
                        if(var15 >= 0 && var16 * var16 + var17 * var17 < var9 * var9 && (!var18 || (var12 + var15 & 1) != 0)) {
                           byte var39 = var3.f[var12 + var15 * 128];
                           byte var40 = (byte)(var38.color * 4 + var37);
                           if(var39 != var40) {
                              var3.f[var12 + var15 * 128] = var40;
                              var3.a(var12, var15);
                              var11 = true;
                           }
                        }
                     }
                  }
               }
            }
         }

      }
   }

   public void tick(ItemStack var1, World var2, Entity var3, int var4, boolean var5) {
      if(!var2.isClientSide) {
         class_avf var6 = this.a(var1, var2);
         if(var3 instanceof EntityHuman) {
            EntityHuman var7 = (EntityHuman)var3;
            var6.a(var7, var1);
         }

         if(var5) {
            this.a(var2, var3, var6);
         }

      }
   }

   public Packet a(ItemStack var1, World var2, EntityHuman var3) {
      return this.a(var1, var2).a(var1, var2, var3);
   }

   public void onCrafted(ItemStack var1, World var2, EntityHuman var3) {
      if(var1.hasTag() && var1.getTag().getBoolean("map_is_scaling")) {
         class_avf var4 = Items.FILLED_MAP.a(var1, var2);
         var1.setData(var2.b("map"));
         class_avf var5 = new class_avf("map_" + var1.i());
         var5.e = (byte)(var4.e + 1);
         if(var5.e > 4) {
            var5.e = 4;
         }

         var5.a((double)var4.b, (double)var4.c, var5.e);
         var5.d = var4.d;
         var5.c();
         var2.a((String)("map_" + var1.i()), (PersistentBase)var5);
      }

   }
}
