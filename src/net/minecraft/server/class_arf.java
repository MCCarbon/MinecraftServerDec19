package net.minecraft.server;

import java.util.Random;

public class class_arf extends class_apw {
   private static final IBlockData a;
   private static final IBlockData b;

   public class_arf(boolean var1) {
      super(var1);
   }

   public boolean generate(World var1, Random var2, BlockPosition var3) {
      int var4 = var2.nextInt(3) + var2.nextInt(2) + 6;
      int var5 = var3.getX();
      int var6 = var3.getY();
      int var7 = var3.getZ();
      if(var6 >= 1 && var6 + var4 + 1 < 256) {
         BlockPosition var8 = var3.down();
         Block var9 = var1.getType(var8).getBlock();
         if(var9 != Blocks.GRASS && var9 != Blocks.DIRT) {
            return false;
         } else if(!this.a(var1, var3, var4)) {
            return false;
         } else {
            this.a(var1, var8);
            this.a(var1, var8.east());
            this.a(var1, var8.south());
            this.a(var1, var8.south().east());
            EnumDirection var10 = EnumDirection.EnumDirectionLimit.HORIZONTAL.getRandomDirection(var2);
            int var11 = var4 - var2.nextInt(4);
            int var12 = 2 - var2.nextInt(3);
            int var13 = var5;
            int var14 = var7;
            int var15 = var6 + var4 - 1;

            int var16;
            int var17;
            for(var16 = 0; var16 < var4; ++var16) {
               if(var16 >= var11 && var12 > 0) {
                  var13 += var10.getAdjacentX();
                  var14 += var10.getAdjacentZ();
                  --var12;
               }

               var17 = var6 + var16;
               BlockPosition var18 = new BlockPosition(var13, var17, var14);
               Material var19 = var1.getType(var18).getBlock().getMaterial();
               if(var19 == Material.AIR || var19 == Material.LEAVES) {
                  this.b(var1, var18);
                  this.b(var1, var18.east());
                  this.b(var1, var18.south());
                  this.b(var1, var18.east().south());
               }
            }

            for(var16 = -2; var16 <= 0; ++var16) {
               for(var17 = -2; var17 <= 0; ++var17) {
                  byte var21 = -1;
                  this.a(var1, var13 + var16, var15 + var21, var14 + var17);
                  this.a(var1, 1 + var13 - var16, var15 + var21, var14 + var17);
                  this.a(var1, var13 + var16, var15 + var21, 1 + var14 - var17);
                  this.a(var1, 1 + var13 - var16, var15 + var21, 1 + var14 - var17);
                  if((var16 > -2 || var17 > -1) && (var16 != -1 || var17 != -2)) {
                     byte var22 = 1;
                     this.a(var1, var13 + var16, var15 + var22, var14 + var17);
                     this.a(var1, 1 + var13 - var16, var15 + var22, var14 + var17);
                     this.a(var1, var13 + var16, var15 + var22, 1 + var14 - var17);
                     this.a(var1, 1 + var13 - var16, var15 + var22, 1 + var14 - var17);
                  }
               }
            }

            if(var2.nextBoolean()) {
               this.a(var1, var13, var15 + 2, var14);
               this.a(var1, var13 + 1, var15 + 2, var14);
               this.a(var1, var13 + 1, var15 + 2, var14 + 1);
               this.a(var1, var13, var15 + 2, var14 + 1);
            }

            for(var16 = -3; var16 <= 4; ++var16) {
               for(var17 = -3; var17 <= 4; ++var17) {
                  if((var16 != -3 || var17 != -3) && (var16 != -3 || var17 != 4) && (var16 != 4 || var17 != -3) && (var16 != 4 || var17 != 4) && (Math.abs(var16) < 3 || Math.abs(var17) < 3)) {
                     this.a(var1, var13 + var16, var15, var14 + var17);
                  }
               }
            }

            for(var16 = -1; var16 <= 2; ++var16) {
               for(var17 = -1; var17 <= 2; ++var17) {
                  if((var16 < 0 || var16 > 1 || var17 < 0 || var17 > 1) && var2.nextInt(3) <= 0) {
                     int var23 = var2.nextInt(3) + 2;

                     int var24;
                     for(var24 = 0; var24 < var23; ++var24) {
                        this.b(var1, new BlockPosition(var5 + var16, var15 - var24 - 1, var7 + var17));
                     }

                     int var20;
                     for(var24 = -1; var24 <= 1; ++var24) {
                        for(var20 = -1; var20 <= 1; ++var20) {
                           this.a(var1, var13 + var16 + var24, var15, var14 + var17 + var20);
                        }
                     }

                     for(var24 = -2; var24 <= 2; ++var24) {
                        for(var20 = -2; var20 <= 2; ++var20) {
                           if(Math.abs(var24) != 2 || Math.abs(var20) != 2) {
                              this.a(var1, var13 + var16 + var24, var15 - 1, var14 + var17 + var20);
                           }
                        }
                     }
                  }
               }
            }

            return true;
         }
      } else {
         return false;
      }
   }

   private boolean a(World var1, BlockPosition var2, int var3) {
      int var4 = var2.getX();
      int var5 = var2.getY();
      int var6 = var2.getZ();
      BlockPosition.MutableBlockPosition var7 = new BlockPosition.MutableBlockPosition();

      for(int var8 = 0; var8 <= var3 + 1; ++var8) {
         byte var9 = 1;
         if(var8 == 0) {
            var9 = 0;
         }

         if(var8 >= var3 - 1) {
            var9 = 2;
         }

         for(int var10 = -var9; var10 <= var9; ++var10) {
            for(int var11 = -var9; var11 <= var9; ++var11) {
               if(!this.a(var1.getType(var7.setPosition(var4 + var10, var5 + var8, var6 + var11)).getBlock())) {
                  return false;
               }
            }
         }
      }

      return true;
   }

   private void b(World var1, BlockPosition var2) {
      if(this.a(var1.getType(var2).getBlock())) {
         this.setTypeAndData(var1, var2, a);
      }

   }

   private void a(World var1, int var2, int var3, int var4) {
      BlockPosition var5 = new BlockPosition(var2, var3, var4);
      Block var6 = var1.getType(var5).getBlock();
      if(var6.getMaterial() == Material.AIR) {
         this.setTypeAndData(var1, var5, b);
      }

   }

   static {
      a = Blocks.LOG2.getBlockData().set(BlockLog2.b, BlockWood.EnumLogVariant.DARK_OAK);
      b = Blocks.LEAVES2.getBlockData().set(BlockLeaves2.Q, BlockWood.EnumLogVariant.DARK_OAK).set(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));
   }
}
