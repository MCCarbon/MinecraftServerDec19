package net.minecraft.server;

import java.util.Iterator;
import java.util.Random;

public class class_arn extends class_apw {
   private static final IBlockData a;
   private static final IBlockData b;
   private final int c;
   private final boolean d;
   private final IBlockData e;
   private final IBlockData f;

   public class_arn(boolean var1) {
      this(var1, 4, a, b, false);
   }

   public class_arn(boolean var1, int var2, IBlockData var3, IBlockData var4, boolean var5) {
      super(var1);
      this.c = var2;
      this.e = var3;
      this.f = var4;
      this.d = var5;
   }

   public boolean generate(World var1, Random var2, BlockPosition var3) {
      int var4 = var2.nextInt(3) + this.c;
      boolean var5 = true;
      if(var3.getY() >= 1 && var3.getY() + var4 + 1 <= 256) {
         byte var7;
         int var9;
         int var10;
         for(int var6 = var3.getY(); var6 <= var3.getY() + 1 + var4; ++var6) {
            var7 = 1;
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
            Block var19 = var1.getType(var3.down()).getBlock();
            if((var19 == Blocks.GRASS || var19 == Blocks.DIRT || var19 == Blocks.FARMLAND) && var3.getY() < 256 - var4 - 1) {
               this.a(var1, var3.down());
               var7 = 3;
               byte var20 = 0;

               int var11;
               int var13;
               int var14;
               BlockPosition var16;
               for(var9 = var3.getY() - var7 + var4; var9 <= var3.getY() + var4; ++var9) {
                  var10 = var9 - (var3.getY() + var4);
                  var11 = var20 + 1 - var10 / 2;

                  for(int var12 = var3.getX() - var11; var12 <= var3.getX() + var11; ++var12) {
                     var13 = var12 - var3.getX();

                     for(var14 = var3.getZ() - var11; var14 <= var3.getZ() + var11; ++var14) {
                        int var15 = var14 - var3.getZ();
                        if(Math.abs(var13) != var11 || Math.abs(var15) != var11 || var2.nextInt(2) != 0 && var10 != 0) {
                           var16 = new BlockPosition(var12, var9, var14);
                           Block var17 = var1.getType(var16).getBlock();
                           if(var17.getMaterial() == Material.AIR || var17.getMaterial() == Material.LEAVES || var17.getMaterial() == Material.REPLACEABLE_PLANT) {
                              this.setTypeAndData(var1, var16, this.f);
                           }
                        }
                     }
                  }
               }

               for(var9 = 0; var9 < var4; ++var9) {
                  Block var21 = var1.getType(var3.up(var9)).getBlock();
                  if(var21.getMaterial() == Material.AIR || var21.getMaterial() == Material.LEAVES || var21.getMaterial() == Material.REPLACEABLE_PLANT) {
                     this.setTypeAndData(var1, var3.up(var9), this.e);
                     if(this.d && var9 > 0) {
                        if(var2.nextInt(3) > 0 && var1.isEmpty(var3.add(-1, var9, 0))) {
                           this.a(var1, var3.add(-1, var9, 0), BlockVine.N);
                        }

                        if(var2.nextInt(3) > 0 && var1.isEmpty(var3.add(1, var9, 0))) {
                           this.a(var1, var3.add(1, var9, 0), BlockVine.P);
                        }

                        if(var2.nextInt(3) > 0 && var1.isEmpty(var3.add(0, var9, -1))) {
                           this.a(var1, var3.add(0, var9, -1), BlockVine.O);
                        }

                        if(var2.nextInt(3) > 0 && var1.isEmpty(var3.add(0, var9, 1))) {
                           this.a(var1, var3.add(0, var9, 1), BlockVine.b);
                        }
                     }
                  }
               }

               if(this.d) {
                  for(var9 = var3.getY() - 3 + var4; var9 <= var3.getY() + var4; ++var9) {
                     var10 = var9 - (var3.getY() + var4);
                     var11 = 2 - var10 / 2;
                     BlockPosition.MutableBlockPosition var24 = new BlockPosition.MutableBlockPosition();

                     for(var13 = var3.getX() - var11; var13 <= var3.getX() + var11; ++var13) {
                        for(var14 = var3.getZ() - var11; var14 <= var3.getZ() + var11; ++var14) {
                           var24.setPosition(var13, var9, var14);
                           if(var1.getType(var24).getBlock().getMaterial() == Material.LEAVES) {
                              BlockPosition var26 = var24.west();
                              var16 = var24.east();
                              BlockPosition var27 = var24.north();
                              BlockPosition var18 = var24.south();
                              if(var2.nextInt(4) == 0 && var1.getType(var26).getBlock().getMaterial() == Material.AIR) {
                                 this.b(var1, var26, BlockVine.N);
                              }

                              if(var2.nextInt(4) == 0 && var1.getType(var16).getBlock().getMaterial() == Material.AIR) {
                                 this.b(var1, var16, BlockVine.P);
                              }

                              if(var2.nextInt(4) == 0 && var1.getType(var27).getBlock().getMaterial() == Material.AIR) {
                                 this.b(var1, var27, BlockVine.O);
                              }

                              if(var2.nextInt(4) == 0 && var1.getType(var18).getBlock().getMaterial() == Material.AIR) {
                                 this.b(var1, var18, BlockVine.b);
                              }
                           }
                        }
                     }
                  }

                  if(var2.nextInt(5) == 0 && var4 > 5) {
                     for(var9 = 0; var9 < 2; ++var9) {
                        Iterator var22 = EnumDirection.EnumDirectionLimit.HORIZONTAL.iterator();

                        while(var22.hasNext()) {
                           EnumDirection var23 = (EnumDirection)var22.next();
                           if(var2.nextInt(4 - var9) == 0) {
                              EnumDirection var25 = var23.opposite();
                              this.a(var1, var2.nextInt(3), var3.add(var25.getAdjacentX(), var4 - 5 + var9, var25.getAdjacentZ()), var23);
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

   private void a(World var1, int var2, BlockPosition var3, EnumDirection var4) {
      this.setTypeAndData(var1, var3, Blocks.COCOA.getBlockData().set(BlockCocoa.a, Integer.valueOf(var2)).set(BlockCocoa.FACING, var4));
   }

   private void a(World var1, BlockPosition var2, BlockStateBoolean var3) {
      this.setTypeAndData(var1, var2, Blocks.VINE.getBlockData().set(var3, Boolean.valueOf(true)));
   }

   private void b(World var1, BlockPosition var2, BlockStateBoolean var3) {
      this.a(var1, var2, var3);
      int var4 = 4;

      for(var2 = var2.down(); var1.getType(var2).getBlock().getMaterial() == Material.AIR && var4 > 0; --var4) {
         this.a(var1, var2, var3);
         var2 = var2.down();
      }

   }

   static {
      a = Blocks.LOG.getBlockData().set(BlockLog1.b, BlockWood.EnumLogVariant.OAK);
      b = Blocks.LEAVES.getBlockData().set(BlockLeaves1.VARIANT, BlockWood.EnumLogVariant.OAK).set(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));
   }
}
