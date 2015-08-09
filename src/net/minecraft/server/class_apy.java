package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.BlockLeaves1;
import net.minecraft.server.BlockLog1;
import net.minecraft.server.BlockWood;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_apw;
import net.minecraft.server.Material;
import net.minecraft.server.BlockPosition;

public class class_apy extends class_apw {
   private static final IBlockData a;
   private static final IBlockData b;
   private boolean c;

   public class_apy(boolean var1, boolean var2) {
      super(var1);
      this.c = var2;
   }

   public boolean generate(World var1, Random var2, BlockPosition var3) {
      int var4 = var2.nextInt(3) + 5;
      if(this.c) {
         var4 += var2.nextInt(7);
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
               var7 = 2;
            }

            BlockPosition.MutableBlockPosition var8 = new BlockPosition.MutableBlockPosition();

            for(var9 = var3.getX() - var7; var9 <= var3.getX() + var7 && var5; ++var9) {
               for(var10 = var3.getZ() - var7; var10 <= var3.getZ() + var7 && var5; ++var10) {
                  if(var6 >= 0 && var6 < 256) {
                     if(!this.a(var1.getType(var8.setPosition(var9, var6, var10)).getBlock())) {
                        var5 = false;
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
            Block var16 = var1.getType(var3.down()).getBlock();
            if((var16 == Blocks.GRASS || var16 == Blocks.DIRT || var16 == Blocks.FARMLAND) && var3.getY() < 256 - var4 - 1) {
               this.a(var1, var3.down());

               int var17;
               for(var17 = var3.getY() - 3 + var4; var17 <= var3.getY() + var4; ++var17) {
                  int var18 = var17 - (var3.getY() + var4);
                  var9 = 1 - var18 / 2;

                  for(var10 = var3.getX() - var9; var10 <= var3.getX() + var9; ++var10) {
                     int var11 = var10 - var3.getX();

                     for(int var12 = var3.getZ() - var9; var12 <= var3.getZ() + var9; ++var12) {
                        int var13 = var12 - var3.getZ();
                        if(Math.abs(var11) != var9 || Math.abs(var13) != var9 || var2.nextInt(2) != 0 && var18 != 0) {
                           BlockPosition var14 = new BlockPosition(var10, var17, var12);
                           Block var15 = var1.getType(var14).getBlock();
                           if(var15.getMaterial() == Material.AIR || var15.getMaterial() == Material.LEAVES) {
                              this.setTypeAndData(var1, var14, b);
                           }
                        }
                     }
                  }
               }

               for(var17 = 0; var17 < var4; ++var17) {
                  Block var19 = var1.getType(var3.up(var17)).getBlock();
                  if(var19.getMaterial() == Material.AIR || var19.getMaterial() == Material.LEAVES) {
                     this.setTypeAndData(var1, var3.up(var17), a);
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
      a = Blocks.LOG.getBlockData().set(BlockLog1.b, BlockWood.EnumLogVariant.BIRCH);
      b = Blocks.LEAVES.getBlockData().set(BlockLeaves1.VARIANT, BlockWood.EnumLogVariant.BIRCH).set(BlockLeaves1.CHECK_DECAY, Boolean.valueOf(false));
   }
}
