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

public class class_arf extends class_apw {
   private static final IBlockData a;
   private static final IBlockData b;

   public class_arf(boolean var1) {
      super(var1);
   }

   public boolean b(World var1, Random var2, class_cj var3) {
      int var4 = var2.nextInt(3) + var2.nextInt(2) + 6;
      int var5 = var3.n();
      int var6 = var3.o();
      int var7 = var3.p();
      if(var6 >= 1 && var6 + var4 + 1 < 256) {
         class_cj var8 = var3.b();
         Block var9 = var1.p(var8).getBlock();
         if(var9 != Blocks.GRASS && var9 != Blocks.DIRT) {
            return false;
         } else if(!this.a(var1, var3, var4)) {
            return false;
         } else {
            this.a(var1, var8);
            this.a(var1, var8.f());
            this.a(var1, var8.d());
            this.a(var1, var8.d().f());
            class_cq var10 = class_cq.class_c_in_class_cq.a.a(var2);
            int var11 = var4 - var2.nextInt(4);
            int var12 = 2 - var2.nextInt(3);
            int var13 = var5;
            int var14 = var7;
            int var15 = var6 + var4 - 1;

            int var16;
            int var17;
            for(var16 = 0; var16 < var4; ++var16) {
               if(var16 >= var11 && var12 > 0) {
                  var13 += var10.g();
                  var14 += var10.i();
                  --var12;
               }

               var17 = var6 + var16;
               class_cj var18 = new class_cj(var13, var17, var14);
               Material var19 = var1.p(var18).getBlock().getMaterial();
               if(var19 == Material.a || var19 == Material.j) {
                  this.b(var1, var18);
                  this.b(var1, var18.f());
                  this.b(var1, var18.d());
                  this.b(var1, var18.f().d());
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
                        this.b(var1, new class_cj(var5 + var16, var15 - var24 - 1, var7 + var17));
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

   private boolean a(World var1, class_cj var2, int var3) {
      int var4 = var2.n();
      int var5 = var2.o();
      int var6 = var2.p();
      class_cj.class_a_in_class_cj var7 = new class_cj.class_a_in_class_cj();

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
               if(!this.a(var1.p(var7.c(var4 + var10, var5 + var8, var6 + var11)).getBlock())) {
                  return false;
               }
            }
         }
      }

      return true;
   }

   private void b(World var1, class_cj var2) {
      if(this.a(var1.p(var2).getBlock())) {
         this.a(var1, var2, a);
      }

   }

   private void a(World var1, int var2, int var3, int var4) {
      class_cj var5 = new class_cj(var2, var3, var4);
      Block var6 = var1.p(var5).getBlock();
      if(var6.getMaterial() == Material.a) {
         this.a(var1, var5, b);
      }

   }

   static {
      a = Blocks.LOG2.getBlockData().set(class_ajo.b, class_ajw.class_a_in_class_ajw.f);
      b = Blocks.LEAVES2.getBlockData().set(class_ajn.Q, class_ajw.class_a_in_class_ajw.f).set(class_aja.b, Boolean.valueOf(false));
   }
}
