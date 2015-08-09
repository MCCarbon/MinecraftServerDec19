package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_ara extends WorldGenerator {
   private static final Logger a = LogManager.getLogger();
   private static final String[] b = new String[]{"Skeleton", "Zombie", "Zombie", "Spider"};
   private static final List c;

   public boolean generate(World var1, Random var2, BlockPosition var3) {
      boolean var4 = true;
      int var5 = var2.nextInt(2) + 2;
      int var6 = -var5 - 1;
      int var7 = var5 + 1;
      boolean var8 = true;
      boolean var9 = true;
      int var10 = var2.nextInt(2) + 2;
      int var11 = -var10 - 1;
      int var12 = var10 + 1;
      int var13 = 0;

      int var14;
      int var15;
      int var16;
      BlockPosition var17;
      for(var14 = var6; var14 <= var7; ++var14) {
         for(var15 = -1; var15 <= 4; ++var15) {
            for(var16 = var11; var16 <= var12; ++var16) {
               var17 = var3.add(var14, var15, var16);
               Material var18 = var1.getType(var17).getBlock().getMaterial();
               boolean var19 = var18.isBuildable();
               if(var15 == -1 && !var19) {
                  return false;
               }

               if(var15 == 4 && !var19) {
                  return false;
               }

               if((var14 == var6 || var14 == var7 || var16 == var11 || var16 == var12) && var15 == 0 && var1.isEmpty(var17) && var1.isEmpty(var17.up())) {
                  ++var13;
               }
            }
         }
      }

      if(var13 >= 1 && var13 <= 5) {
         for(var14 = var6; var14 <= var7; ++var14) {
            for(var15 = 3; var15 >= -1; --var15) {
               for(var16 = var11; var16 <= var12; ++var16) {
                  var17 = var3.add(var14, var15, var16);
                  if(var14 != var6 && var15 != -1 && var16 != var11 && var14 != var7 && var15 != 4 && var16 != var12) {
                     if(var1.getType(var17).getBlock() != Blocks.CHEST) {
                        var1.setAir(var17);
                     }
                  } else if(var17.getY() >= 0 && !var1.getType(var17.down()).getBlock().getMaterial().isBuildable()) {
                     var1.setAir(var17);
                  } else if(var1.getType(var17).getBlock().getMaterial().isBuildable() && var1.getType(var17).getBlock() != Blocks.CHEST) {
                     if(var15 == -1 && var2.nextInt(4) != 0) {
                        var1.setTypeAndData((BlockPosition)var17, (IBlockData)Blocks.MOSSY_COBBLESTONE.getBlockData(), 2);
                     } else {
                        var1.setTypeAndData((BlockPosition)var17, (IBlockData)Blocks.COBBLESTONE.getBlockData(), 2);
                     }
                  }
               }
            }
         }

         for(var14 = 0; var14 < 2; ++var14) {
            for(var15 = 0; var15 < 3; ++var15) {
               var16 = var3.getX() + var2.nextInt(var5 * 2 + 1) - var5;
               int var24 = var3.getY();
               int var25 = var3.getZ() + var2.nextInt(var10 * 2 + 1) - var10;
               BlockPosition var26 = new BlockPosition(var16, var24, var25);
               if(var1.isEmpty(var26)) {
                  int var20 = 0;
                  Iterator var21 = EnumDirection.EnumDirectionLimit.HORIZONTAL.iterator();

                  while(var21.hasNext()) {
                     EnumDirection var22 = (EnumDirection)var21.next();
                     if(var1.getType(var26.shift(var22)).getBlock().getMaterial().isBuildable()) {
                        ++var20;
                     }
                  }

                  if(var20 == 1) {
                     var1.setTypeAndData((BlockPosition)var26, (IBlockData)Blocks.CHEST.f(var1, var26, Blocks.CHEST.getBlockData()), 2);
                     List var27 = class_od.a(c, new class_od[]{Items.ENCHANTED_BOOK.b(var2)});
                     TileEntity var28 = var1.getTileEntity(var26);
                     if(var28 instanceof TileEntityChest) {
                        class_od.a(var2, var27, (IInventory)((TileEntityChest)var28), 8);
                     }
                     break;
                  }
               }
            }
         }

         var1.setTypeAndData((BlockPosition)var3, (IBlockData)Blocks.MOB_SPAWNER.getBlockData(), 2);
         TileEntity var23 = var1.getTileEntity(var3);
         if(var23 instanceof TileEntityMobSpawner) {
            ((TileEntityMobSpawner)var23).b().a(this.a(var2));
         } else {
            a.error("Failed to fetch mob spawner entity at (" + var3.getX() + ", " + var3.getY() + ", " + var3.getZ() + ")");
         }

         return true;
      } else {
         return false;
      }
   }

   private String a(Random var1) {
      return b[var1.nextInt(b.length)];
   }

   static {
      c = Lists.newArrayList((Object[])(new class_od[]{new class_od(Items.SADDLE, 0, 1, 1, 10), new class_od(Items.IRON_INGOT, 0, 1, 4, 10), new class_od(Items.BREAD, 0, 1, 1, 10), new class_od(Items.WHEAT, 0, 1, 4, 10), new class_od(Items.GUNPOWDER, 0, 1, 4, 10), new class_od(Items.STRING, 0, 1, 4, 10), new class_od(Items.BUCKET, 0, 1, 1, 10), new class_od(Items.GOLDEN_APPLE, 0, 1, 1, 1), new class_od(Items.REDSTONE, 0, 1, 4, 10), new class_od(Items.RECORD_13, 0, 1, 1, 4), new class_od(Items.RECORD_CAT, 0, 1, 1, 4), new class_od(Items.NAME_TAG, 0, 1, 1, 10), new class_od(Items.GOLDEN_HORSE_ARMOR, 0, 1, 1, 2), new class_od(Items.IRON_HORSE_ARMOR, 0, 1, 1, 5), new class_od(Items.DIAMOND_HORSE_ARMOR, 0, 1, 1, 1)}));
   }
}
