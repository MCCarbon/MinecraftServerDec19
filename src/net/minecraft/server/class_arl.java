package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.BlockStainedGlassPane;
import net.minecraft.server.BlockLeaves1;
import net.minecraft.server.BlockLog1;
import net.minecraft.server.BlockWood;
import net.minecraft.server.class_alu;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockStateBoolean;
import net.minecraft.server.class_apw;
import net.minecraft.server.Material;
import net.minecraft.server.BlockPosition;

public class class_arl extends class_apw {
   private static final IBlockData a;
   private static final IBlockData b;

   public class_arl() {
      super(false);
   }

   public boolean b(World var1, Random var2, BlockPosition var3) {
      int var4;
      for(var4 = var2.nextInt(4) + 5; var1.getType(var3.down()).getBlock().getMaterial() == Material.WATER; var3 = var3.down()) {
         ;
      }

      boolean var5 = true;
      if(var3.getY() >= 1 && var3.getY() + var4 + 1 <= 256) {
         int var9;
         int var10;
         for(int var6 = var3.getY(); var6 <= var3.getY() + 1 + var4; ++var6) {
            byte var7 = 1;
            if(var6 == var3.getY()) {
               var7 = 0;
            }

            if(var6 >= var3.getY() + 1 + var4 - 2) {
               var7 = 3;
            }

            BlockPosition.MutableBlockPosition var8 = new BlockPosition.MutableBlockPosition();

            for(var9 = var3.getX() - var7; var9 <= var3.getX() + var7 && var5; ++var9) {
               for(var10 = var3.getZ() - var7; var10 <= var3.getZ() + var7 && var5; ++var10) {
                  if(var6 >= 0 && var6 < 256) {
                     Block var11 = var1.getType(var8.setPosition(var9, var6, var10)).getBlock();
                     if(var11.getMaterial() != Material.AIR && var11.getMaterial() != Material.LEAVES) {
                        if(var11 != BlockStainedGlassPane.WATER && var11 != BlockStainedGlassPane.FLOWING_WATER) {
                           var5 = false;
                        } else if(var6 > var3.getY()) {
                           var5 = false;
                        }
                     }
                  } else {
                     var5 = false;
                  }
               }
            }
         }

         if(!var5) {
            return false;
         } else {
            Block var17 = var1.getType(var3.down()).getBlock();
            if((var17 == BlockStainedGlassPane.GRASS || var17 == BlockStainedGlassPane.DIRT) && var3.getY() < 256 - var4 - 1) {
               this.a(var1, var3.down());

               int var12;
               BlockPosition var14;
               int var18;
               int var19;
               int var21;
               for(var18 = var3.getY() - 3 + var4; var18 <= var3.getY() + var4; ++var18) {
                  var19 = var18 - (var3.getY() + var4);
                  var9 = 2 - var19 / 2;

                  for(var10 = var3.getX() - var9; var10 <= var3.getX() + var9; ++var10) {
                     var21 = var10 - var3.getX();

                     for(var12 = var3.getZ() - var9; var12 <= var3.getZ() + var9; ++var12) {
                        int var13 = var12 - var3.getZ();
                        if(Math.abs(var21) != var9 || Math.abs(var13) != var9 || var2.nextInt(2) != 0 && var19 != 0) {
                           var14 = new BlockPosition(var10, var18, var12);
                           if(!var1.getType(var14).getBlock().isFullBlock()) {
                              this.a(var1, var14, b);
                           }
                        }
                     }
                  }
               }

               for(var18 = 0; var18 < var4; ++var18) {
                  Block var20 = var1.getType(var3.up(var18)).getBlock();
                  if(var20.getMaterial() == Material.AIR || var20.getMaterial() == Material.LEAVES || var20 == BlockStainedGlassPane.FLOWING_WATER || var20 == BlockStainedGlassPane.WATER) {
                     this.a(var1, var3.up(var18), a);
                  }
               }

               for(var18 = var3.getY() - 3 + var4; var18 <= var3.getY() + var4; ++var18) {
                  var19 = var18 - (var3.getY() + var4);
                  var9 = 2 - var19 / 2;
                  BlockPosition.MutableBlockPosition var22 = new BlockPosition.MutableBlockPosition();

                  for(var21 = var3.getX() - var9; var21 <= var3.getX() + var9; ++var21) {
                     for(var12 = var3.getZ() - var9; var12 <= var3.getZ() + var9; ++var12) {
                        var22.setPosition(var21, var18, var12);
                        if(var1.getType(var22).getBlock().getMaterial() == Material.LEAVES) {
                           BlockPosition var23 = var22.west();
                           var14 = var22.east();
                           BlockPosition var15 = var22.north();
                           BlockPosition var16 = var22.south();
                           if(var2.nextInt(4) == 0 && var1.getType(var23).getBlock().getMaterial() == Material.AIR) {
                              this.a(var1, var23, class_alu.N);
                           }

                           if(var2.nextInt(4) == 0 && var1.getType(var14).getBlock().getMaterial() == Material.AIR) {
                              this.a(var1, var14, class_alu.P);
                           }

                           if(var2.nextInt(4) == 0 && var1.getType(var15).getBlock().getMaterial() == Material.AIR) {
                              this.a(var1, var15, class_alu.O);
                           }

                           if(var2.nextInt(4) == 0 && var1.getType(var16).getBlock().getMaterial() == Material.AIR) {
                              this.a(var1, var16, class_alu.b);
                           }
                        }
                     }
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

   private void a(World var1, BlockPosition var2, BlockStateBoolean var3) {
      IBlockData var4 = BlockStainedGlassPane.VINE.getBlockData().set(var3, Boolean.valueOf(true));
      this.a(var1, var2, var4);
      int var5 = 4;

      for(var2 = var2.down(); var1.getType(var2).getBlock().getMaterial() == Material.AIR && var5 > 0; --var5) {
         this.a(var1, var2, var4);
         var2 = var2.down();
      }

   }

   static {
      a = BlockStainedGlassPane.LOG.getBlockData().set(BlockLog1.b, BlockWood.EnumLogVariant.OAK);
      b = BlockStainedGlassPane.LEAVES.getBlockData().set(BlockLeaves1.VARIANT, BlockWood.EnumLogVariant.OAK).set(BlockLeaves1.CHECK_DECAY, Boolean.valueOf(false));
   }
}
