package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_aja;
import net.minecraft.server.class_ajs;
import net.minecraft.server.class_ajt;
import net.minecraft.server.class_ajw;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_apw;
import net.minecraft.server.Material;
import net.minecraft.server.BlockPosition;

public class class_arc extends class_apw {
   private static final IBlockData a;
   private static final IBlockData b;

   public class_arc() {
      super(false);
   }

   public boolean b(World var1, Random var2, BlockPosition var3) {
      int var4 = var2.nextInt(5) + 7;
      int var5 = var4 - var2.nextInt(2) - 3;
      int var6 = var4 - var5;
      int var7 = 1 + var2.nextInt(var6 + 1);
      boolean var8 = true;
      if(var3.getY() >= 1 && var3.getY() + var4 + 1 <= 256) {
         int var12;
         int var13;
         int var18;
         for(int var9 = var3.getY(); var9 <= var3.getY() + 1 + var4 && var8; ++var9) {
            boolean var10 = true;
            if(var9 - var3.getY() < var5) {
               var18 = 0;
            } else {
               var18 = var7;
            }

            BlockPosition.MutableBlockPosition var11 = new BlockPosition.MutableBlockPosition();

            for(var12 = var3.getX() - var18; var12 <= var3.getX() + var18 && var8; ++var12) {
               for(var13 = var3.getZ() - var18; var13 <= var3.getZ() + var18 && var8; ++var13) {
                  if(var9 >= 0 && var9 < 256) {
                     if(!this.a(var1.p(var11.setPosition(var12, var9, var13)).getBlock())) {
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
            Block var17 = var1.p(var3.shiftDown()).getBlock();
            if((var17 == Blocks.GRASS || var17 == Blocks.DIRT) && var3.getY() < 256 - var4 - 1) {
               this.a(var1, var3.shiftDown());
               var18 = 0;

               int var19;
               for(var19 = var3.getY() + var4; var19 >= var3.getY() + var5; --var19) {
                  for(var12 = var3.getX() - var18; var12 <= var3.getX() + var18; ++var12) {
                     var13 = var12 - var3.getX();

                     for(int var14 = var3.getZ() - var18; var14 <= var3.getZ() + var18; ++var14) {
                        int var15 = var14 - var3.getZ();
                        if(Math.abs(var13) != var18 || Math.abs(var15) != var18 || var18 <= 0) {
                           BlockPosition var16 = new BlockPosition(var12, var19, var14);
                           if(!var1.p(var16).getBlock().isFullBlock()) {
                              this.a(var1, var16, b);
                           }
                        }
                     }
                  }

                  if(var18 >= 1 && var19 == var3.getY() + var5 + 1) {
                     --var18;
                  } else if(var18 < var7) {
                     ++var18;
                  }
               }

               for(var19 = 0; var19 < var4 - 1; ++var19) {
                  Block var20 = var1.p(var3.shiftUp(var19)).getBlock();
                  if(var20.getMaterial() == Material.AIR || var20.getMaterial() == Material.LEAVES) {
                     this.a(var1, var3.shiftUp(var19), a);
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
      a = Blocks.LOG.getBlockData().set(class_ajt.b, class_ajw.class_a_in_class_ajw.b);
      b = Blocks.LEAVES.getBlockData().set(class_ajs.Q, class_ajw.class_a_in_class_ajw.b).set(class_aja.b, Boolean.valueOf(false));
   }
}
