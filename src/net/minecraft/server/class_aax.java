package net.minecraft.server;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multisets;
import net.minecraft.server.class_aas;
import net.minecraft.server.Items;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.Blocks;
import net.minecraft.server.class_ahj;
import net.minecraft.server.BlockStone;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_aok;
import net.minecraft.server.MaterialMapColor;
import net.minecraft.server.class_avd;
import net.minecraft.server.class_avf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_nu;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_zt;

public class class_aax extends class_zt {
   protected class_aax() {
      this.a(true);
   }

   public class_avf a(class_aas var1, World var2) {
      String var3 = "map_" + var1.i();
      class_avf var4 = (class_avf)var2.a(class_avf.class, var3);
      if(var4 == null && !var2.D) {
         var1.b(var2.b("map"));
         var3 = "map_" + var1.i();
         var4 = new class_avf(var3);
         var4.e = 3;
         var4.a((double)var2.Q().c(), (double)var2.Q().e(), var4.e);
         var4.d = (byte)var2.t.p().a();
         var4.c();
         var2.a((String)var3, (class_avd)var4);
      }

      return var4;
   }

   public void a(World var1, class_pr var2, class_avf var3) {
      if(var1.t.p().a() == var3.d && var2 instanceof class_xa) {
         int var4 = 1 << var3.e;
         int var5 = var3.b;
         int var6 = var3.c;
         int var7 = class_nu.c(var2.s - (double)var5) / var4 + 64;
         int var8 = class_nu.c(var2.u - (double)var6) / var4 + 64;
         int var9 = 128 / var4;
         if(var1.t.m()) {
            var9 /= 2;
         }

         class_avf.class_a_in_class_avf var10 = var3.a((class_xa)var2);
         ++var10.b;
         boolean var11 = false;

         for(int var12 = var7 - var9 + 1; var12 < var7 + var9; ++var12) {
            if((var12 & 15) == (var10.b & 15) || var11) {
               var11 = false;
               double var13 = 0.0D;

               for(int var15 = var8 - var9 - 1; var15 < var8 + var9; ++var15) {
                  if(var12 >= 0 && var15 >= -1 && var12 < 128 && var15 < 128) {
                     int var16 = var12 - var7;
                     int var17 = var15 - var8;
                     boolean var18 = var16 * var16 + var17 * var17 > (var9 - 2) * (var9 - 2);
                     int var19 = (var5 / var4 + var12 - 64) * var4;
                     int var20 = (var6 / var4 + var15 - 64) * var4;
                     HashMultiset var21 = HashMultiset.create();
                     class_aok var22 = var1.f(new class_cj(var19, 0, var20));
                     if(!var22.f()) {
                        int var23 = var19 & 15;
                        int var24 = var20 & 15;
                        int var25 = 0;
                        double var26 = 0.0D;
                        if(var1.t.m()) {
                           int var28 = var19 + var20 * 231871;
                           var28 = var28 * var28 * 31287121 + var28 * 11;
                           if((var28 >> 20 & 1) == 0) {
                              var21.add(Blocks.DIRT.getMapColor(Blocks.DIRT.getBlockData().set(class_ahj.a, class_ahj.class_a_in_class_ahj.a)), 10);
                           } else {
                              var21.add(Blocks.STONE.getMapColor(Blocks.STONE.getBlockData().set(BlockStone.VARIANT, BlockStone.EnumStoneVariant.STONE)), 100);
                           }

                           var26 = 100.0D;
                        } else {
                           class_cj.class_a_in_class_cj var35 = new class_cj.class_a_in_class_cj();

                           for(int var29 = 0; var29 < var4; ++var29) {
                              for(int var30 = 0; var30 < var4; ++var30) {
                                 int var31 = var22.b(var29 + var23, var30 + var24) + 1;
                                 IBlockData var32 = Blocks.AIR.getBlockData();
                                 if(var31 > 1) {
                                    do {
                                       --var31;
                                       var32 = var22.g(var35.c(var29 + var23, var31, var30 + var24));
                                    } while(var32.getBlock().getMapColor(var32) == MaterialMapColor.b && var31 > 0);

                                    if(var31 > 0 && var32.getBlock().getMaterial().d()) {
                                       int var33 = var31 - 1;

                                       Block var34;
                                       do {
                                          var34 = var22.a(var29 + var23, var33--, var30 + var24);
                                          ++var25;
                                       } while(var33 > 0 && var34.getMaterial().d());
                                    }
                                 }

                                 var26 += (double)var31 / (double)(var4 * var4);
                                 var21.add(var32.getBlock().getMapColor(var32));
                              }
                           }
                        }

                        var25 /= var4 * var4;
                        double var36 = (var26 - var13) * 4.0D / (double)(var4 + 4) + ((double)(var12 + var15 & 1) - 0.5D) * 0.4D;
                        byte var37 = 1;
                        if(var36 > 0.6D) {
                           var37 = 2;
                        }

                        if(var36 < -0.6D) {
                           var37 = 0;
                        }

                        MaterialMapColor var38 = (MaterialMapColor)Iterables.getFirst(Multisets.copyHighestCountFirst(var21), MaterialMapColor.b);
                        if(var38 == MaterialMapColor.n) {
                           var36 = (double)var25 * 0.1D + (double)(var12 + var15 & 1) * 0.2D;
                           var37 = 1;
                           if(var36 < 0.5D) {
                              var37 = 2;
                           }

                           if(var36 > 0.9D) {
                              var37 = 0;
                           }
                        }

                        var13 = var26;
                        if(var15 >= 0 && var16 * var16 + var17 * var17 < var9 * var9 && (!var18 || (var12 + var15 & 1) != 0)) {
                           byte var39 = var3.f[var12 + var15 * 128];
                           byte var40 = (byte)(var38.color * 4 + var37);
                           if(var39 != var40) {
                              var3.f[var12 + var15 * 128] = var40;
                              var3.a(var12, var15);
                              var11 = true;
                           }
                        }
                     }
                  }
               }
            }
         }

      }
   }

   public void a(class_aas var1, World var2, class_pr var3, int var4, boolean var5) {
      if(!var2.D) {
         class_avf var6 = this.a(var1, var2);
         if(var3 instanceof class_xa) {
            class_xa var7 = (class_xa)var3;
            var6.a(var7, var1);
         }

         if(var5) {
            this.a(var2, var3, var6);
         }

      }
   }

   public class_ff a(class_aas var1, World var2, class_xa var3) {
      return this.a(var1, var2).a(var1, var2, var3);
   }

   public void b(class_aas var1, World var2, class_xa var3) {
      if(var1.n() && var1.o().o("map_is_scaling")) {
         class_avf var4 = Items.bf.a(var1, var2);
         var1.b(var2.b("map"));
         class_avf var5 = new class_avf("map_" + var1.i());
         var5.e = (byte)(var4.e + 1);
         if(var5.e > 4) {
            var5.e = 4;
         }

         var5.a((double)var4.b, (double)var4.c, var5.e);
         var5.d = var4.d;
         var5.c();
         var2.a((String)("map_" + var1.i()), (class_avd)var5);
      }

   }
}
