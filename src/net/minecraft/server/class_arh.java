package net.minecraft.server;

import java.util.Random;

public class class_arh extends class_apw {
   private static final IBlockData a;
   private static final IBlockData b;

   public class_arh(boolean var1) {
      super(var1);
   }

   public boolean b(World var1, Random var2, BlockPosition var3) {
      int var4 = var2.nextInt(3) + var2.nextInt(3) + 5;
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
            Block var20 = var1.getType(var3.down()).getBlock();
            if((var20 == Blocks.GRASS || var20 == Blocks.DIRT) && var3.getY() < 256 - var4 - 1) {
               this.a(var1, var3.down());
               EnumDirection var21 = EnumDirection.EnumDirectionLimit.HORIZONTAL.getRandomDirection(var2);
               int var22 = var4 - var2.nextInt(4) - 1;
               var9 = 3 - var2.nextInt(3);
               var10 = var3.getX();
               int var11 = var3.getZ();
               int var12 = 0;

               int var14;
               for(int var13 = 0; var13 < var4; ++var13) {
                  var14 = var3.getY() + var13;
                  if(var13 >= var22 && var9 > 0) {
                     var10 += var21.getAdjacentX();
                     var11 += var21.getAdjacentZ();
                     --var9;
                  }

                  BlockPosition var15 = new BlockPosition(var10, var14, var11);
                  Material var16 = var1.getType(var15).getBlock().getMaterial();
                  if(var16 == Material.AIR || var16 == Material.LEAVES) {
                     this.b(var1, var15);
                     var12 = var14;
                  }
               }

               BlockPosition var23 = new BlockPosition(var10, var12, var11);

               int var25;
               for(var14 = -3; var14 <= 3; ++var14) {
                  for(var25 = -3; var25 <= 3; ++var25) {
                     if(Math.abs(var14) != 3 || Math.abs(var25) != 3) {
                        this.c(var1, var23.add(var14, 0, var25));
                     }
                  }
               }

               var23 = var23.up();

               for(var14 = -1; var14 <= 1; ++var14) {
                  for(var25 = -1; var25 <= 1; ++var25) {
                     this.c(var1, var23.add(var14, 0, var25));
                  }
               }

               this.c(var1, var23.east(2));
               this.c(var1, var23.west(2));
               this.c(var1, var23.south(2));
               this.c(var1, var23.north(2));
               var10 = var3.getX();
               var11 = var3.getZ();
               EnumDirection var24 = EnumDirection.EnumDirectionLimit.HORIZONTAL.getRandomDirection(var2);
               if(var24 != var21) {
                  var14 = var22 - var2.nextInt(2) - 1;
                  var25 = 1 + var2.nextInt(3);
                  var12 = 0;

                  int var17;
                  for(int var26 = var14; var26 < var4 && var25 > 0; --var25) {
                     if(var26 >= 1) {
                        var17 = var3.getY() + var26;
                        var10 += var24.getAdjacentX();
                        var11 += var24.getAdjacentZ();
                        BlockPosition var18 = new BlockPosition(var10, var17, var11);
                        Material var19 = var1.getType(var18).getBlock().getMaterial();
                        if(var19 == Material.AIR || var19 == Material.LEAVES) {
                           this.b(var1, var18);
                           var12 = var17;
                        }
                     }

                     ++var26;
                  }

                  if(var12 > 0) {
                     BlockPosition var27 = new BlockPosition(var10, var12, var11);

                     int var28;
                     for(var17 = -2; var17 <= 2; ++var17) {
                        for(var28 = -2; var28 <= 2; ++var28) {
                           if(Math.abs(var17) != 2 || Math.abs(var28) != 2) {
                              this.c(var1, var27.add(var17, 0, var28));
                           }
                        }
                     }

                     var27 = var27.up();

                     for(var17 = -1; var17 <= 1; ++var17) {
                        for(var28 = -1; var28 <= 1; ++var28) {
                           this.c(var1, var27.add(var17, 0, var28));
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

   private void b(World var1, BlockPosition var2) {
      this.a(var1, var2, a);
   }

   private void c(World var1, BlockPosition var2) {
      Material var3 = var1.getType(var2).getBlock().getMaterial();
      if(var3 == Material.AIR || var3 == Material.LEAVES) {
         this.a(var1, var2, b);
      }

   }

   static {
      a = Blocks.LOG2.getBlockData().set(BlockLog2.b, BlockWood.EnumLogVariant.ACACIA);
      b = Blocks.LEAVES2.getBlockData().set(BlockLeaves2.Q, BlockWood.EnumLogVariant.ACACIA).set(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));
   }
}
