package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.BlockStainedGlassPane;
import net.minecraft.server.BlockLeaves;
import net.minecraft.server.BlockLeaves1;
import net.minecraft.server.BlockLog1;
import net.minecraft.server.BlockWood;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_apw;
import net.minecraft.server.Material;
import net.minecraft.server.BlockPosition;

public class class_ark extends class_apw {
   private static final IBlockData a;
   private static final IBlockData b;

   public class_ark(boolean var1) {
      super(var1);
   }

   public boolean b(World var1, Random var2, BlockPosition var3) {
      int var4 = var2.nextInt(4) + 6;
      int var5 = 1 + var2.nextInt(2);
      int var6 = var4 - var5;
      int var7 = 2 + var2.nextInt(2);
      boolean var8 = true;
      if(var3.getY() >= 1 && var3.getY() + var4 + 1 <= 256) {
         int var13;
         int var21;
         for(int var9 = var3.getY(); var9 <= var3.getY() + 1 + var4 && var8; ++var9) {
            boolean var10 = true;
            if(var9 - var3.getY() < var5) {
               var21 = 0;
            } else {
               var21 = var7;
            }

            BlockPosition.MutableBlockPosition var11 = new BlockPosition.MutableBlockPosition();

            for(int var12 = var3.getX() - var21; var12 <= var3.getX() + var21 && var8; ++var12) {
               for(var13 = var3.getZ() - var21; var13 <= var3.getZ() + var21 && var8; ++var13) {
                  if(var9 >= 0 && var9 < 256) {
                     Block var14 = var1.getType(var11.setPosition(var12, var9, var13)).getBlock();
                     if(var14.getMaterial() != Material.AIR && var14.getMaterial() != Material.LEAVES) {
                        var8 = false;
                     }
                  } else {
                     var8 = false;
                  }
               }
            }
         }

         if(!var8) {
            return false;
         } else {
            Block var20 = var1.getType(var3.down()).getBlock();
            if((var20 == BlockStainedGlassPane.GRASS || var20 == BlockStainedGlassPane.DIRT || var20 == BlockStainedGlassPane.FARMLAND) && var3.getY() < 256 - var4 - 1) {
               this.a(var1, var3.down());
               var21 = var2.nextInt(2);
               int var22 = 1;
               byte var23 = 0;

               int var24;
               for(var13 = 0; var13 <= var6; ++var13) {
                  var24 = var3.getY() + var4 - var13;

                  for(int var15 = var3.getX() - var21; var15 <= var3.getX() + var21; ++var15) {
                     int var16 = var15 - var3.getX();

                     for(int var17 = var3.getZ() - var21; var17 <= var3.getZ() + var21; ++var17) {
                        int var18 = var17 - var3.getZ();
                        if(Math.abs(var16) != var21 || Math.abs(var18) != var21 || var21 <= 0) {
                           BlockPosition var19 = new BlockPosition(var15, var24, var17);
                           if(!var1.getType(var19).getBlock().isFullBlock()) {
                              this.a(var1, var19, b);
                           }
                        }
                     }
                  }

                  if(var21 >= var22) {
                     var21 = var23;
                     var23 = 1;
                     ++var22;
                     if(var22 > var7) {
                        var22 = var7;
                     }
                  } else {
                     ++var21;
                  }
               }

               var13 = var2.nextInt(3);

               for(var24 = 0; var24 < var4 - var13; ++var24) {
                  Block var25 = var1.getType(var3.up(var24)).getBlock();
                  if(var25.getMaterial() == Material.AIR || var25.getMaterial() == Material.LEAVES) {
                     this.a(var1, var3.up(var24), a);
                  }
               }

               return true;
            } else {
               return false;
            }
         }
      } else {
         return false;
      }
   }

   static {
      a = BlockStainedGlassPane.LOG.getBlockData().set(BlockLog1.b, BlockWood.EnumLogVariant.SPRUCE);
      b = BlockStainedGlassPane.LEAVES.getBlockData().set(BlockLeaves1.VARIANT, BlockWood.EnumLogVariant.SPRUCE).set(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));
   }
}
