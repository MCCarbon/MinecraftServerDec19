package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_aja;
import net.minecraft.server.class_ajn;
import net.minecraft.server.class_ajo;
import net.minecraft.server.class_ajw;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_apw;
import net.minecraft.server.Material;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;

public class class_arh extends class_apw {
   private static final IBlockData a;
   private static final IBlockData b;

   public class_arh(boolean var1) {
      super(var1);
   }

   public boolean b(World var1, Random var2, class_cj var3) {
      int var4 = var2.nextInt(3) + var2.nextInt(3) + 5;
      boolean var5 = true;
      if(var3.o() >= 1 && var3.o() + var4 + 1 <= 256) {
         int var9;
         int var10;
         for(int var6 = var3.o(); var6 <= var3.o() + 1 + var4; ++var6) {
            byte var7 = 1;
            if(var6 == var3.o()) {
               var7 = 0;
            }

            if(var6 >= var3.o() + 1 + var4 - 2) {
               var7 = 2;
            }

            class_cj.class_a_in_class_cj var8 = new class_cj.class_a_in_class_cj();

            for(var9 = var3.n() - var7; var9 <= var3.n() + var7 && var5; ++var9) {
               for(var10 = var3.p() - var7; var10 <= var3.p() + var7 && var5; ++var10) {
                  if(var6 >= 0 && var6 < 256) {
                     if(!this.a(var1.p(var8.c(var9, var6, var10)).getBlock())) {
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
            Block var20 = var1.p(var3.b()).getBlock();
            if((var20 == Blocks.GRASS || var20 == Blocks.DIRT) && var3.o() < 256 - var4 - 1) {
               this.a(var1, var3.b());
               class_cq var21 = class_cq.class_c_in_class_cq.a.a(var2);
               int var22 = var4 - var2.nextInt(4) - 1;
               var9 = 3 - var2.nextInt(3);
               var10 = var3.n();
               int var11 = var3.p();
               int var12 = 0;

               int var14;
               for(int var13 = 0; var13 < var4; ++var13) {
                  var14 = var3.o() + var13;
                  if(var13 >= var22 && var9 > 0) {
                     var10 += var21.g();
                     var11 += var21.i();
                     --var9;
                  }

                  class_cj var15 = new class_cj(var10, var14, var11);
                  Material var16 = var1.p(var15).getBlock().getMaterial();
                  if(var16 == Material.a || var16 == Material.j) {
                     this.b(var1, var15);
                     var12 = var14;
                  }
               }

               class_cj var23 = new class_cj(var10, var12, var11);

               int var25;
               for(var14 = -3; var14 <= 3; ++var14) {
                  for(var25 = -3; var25 <= 3; ++var25) {
                     if(Math.abs(var14) != 3 || Math.abs(var25) != 3) {
                        this.c(var1, var23.a(var14, 0, var25));
                     }
                  }
               }

               var23 = var23.a();

               for(var14 = -1; var14 <= 1; ++var14) {
                  for(var25 = -1; var25 <= 1; ++var25) {
                     this.c(var1, var23.a(var14, 0, var25));
                  }
               }

               this.c(var1, var23.g(2));
               this.c(var1, var23.f(2));
               this.c(var1, var23.e(2));
               this.c(var1, var23.d(2));
               var10 = var3.n();
               var11 = var3.p();
               class_cq var24 = class_cq.class_c_in_class_cq.a.a(var2);
               if(var24 != var21) {
                  var14 = var22 - var2.nextInt(2) - 1;
                  var25 = 1 + var2.nextInt(3);
                  var12 = 0;

                  int var17;
                  for(int var26 = var14; var26 < var4 && var25 > 0; --var25) {
                     if(var26 >= 1) {
                        var17 = var3.o() + var26;
                        var10 += var24.g();
                        var11 += var24.i();
                        class_cj var18 = new class_cj(var10, var17, var11);
                        Material var19 = var1.p(var18).getBlock().getMaterial();
                        if(var19 == Material.a || var19 == Material.j) {
                           this.b(var1, var18);
                           var12 = var17;
                        }
                     }

                     ++var26;
                  }

                  if(var12 > 0) {
                     class_cj var27 = new class_cj(var10, var12, var11);

                     int var28;
                     for(var17 = -2; var17 <= 2; ++var17) {
                        for(var28 = -2; var28 <= 2; ++var28) {
                           if(Math.abs(var17) != 2 || Math.abs(var28) != 2) {
                              this.c(var1, var27.a(var17, 0, var28));
                           }
                        }
                     }

                     var27 = var27.a();

                     for(var17 = -1; var17 <= 1; ++var17) {
                        for(var28 = -1; var28 <= 1; ++var28) {
                           this.c(var1, var27.a(var17, 0, var28));
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

   private void b(World var1, class_cj var2) {
      this.a(var1, var2, a);
   }

   private void c(World var1, class_cj var2) {
      Material var3 = var1.p(var2).getBlock().getMaterial();
      if(var3 == Material.a || var3 == Material.j) {
         this.a(var1, var2, b);
      }

   }

   static {
      a = Blocks.LOG2.getBlockData().set(class_ajo.b, class_ajw.class_a_in_class_ajw.e);
      b = Blocks.LEAVES2.getBlockData().set(class_ajn.Q, class_ajw.class_a_in_class_ajw.e).set(class_aja.b, Boolean.valueOf(false));
   }
}
