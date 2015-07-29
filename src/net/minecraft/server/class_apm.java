package net.minecraft.server;

import com.google.common.base.Objects;
import java.util.Random;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_akq;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_aph;
import net.minecraft.server.class_apn;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_nu;

public class class_apm extends class_apn {
   protected void a(long var1, int var3, int var4, class_aph var5, double var6, double var8, double var10) {
      this.a(var1, var3, var4, var5, var6, var8, var10, 1.0F + this.b.nextFloat() * 6.0F, 0.0F, 0.0F, -1, -1, 0.5D);
   }

   protected void a(long var1, int var3, int var4, class_aph var5, double var6, double var8, double var10, float var12, float var13, float var14, int var15, int var16, double var17) {
      double var19 = (double)(var3 * 16 + 8);
      double var21 = (double)(var4 * 16 + 8);
      float var23 = 0.0F;
      float var24 = 0.0F;
      Random var25 = new Random(var1);
      if(var16 <= 0) {
         int var26 = this.a * 16 - 16;
         var16 = var26 - var25.nextInt(var26 / 4);
      }

      boolean var55 = false;
      if(var15 == -1) {
         var15 = var16 / 2;
         var55 = true;
      }

      int var27 = var25.nextInt(var16 / 2) + var16 / 4;

      for(boolean var28 = var25.nextInt(6) == 0; var15 < var16; ++var15) {
         double var29 = 1.5D + (double)(class_nu.a((float)var15 * 3.1415927F / (float)var16) * var12 * 1.0F);
         double var31 = var29 * var17;
         float var33 = class_nu.b(var14);
         float var34 = class_nu.a(var14);
         var6 += (double)(class_nu.b(var13) * var33);
         var8 += (double)var34;
         var10 += (double)(class_nu.a(var13) * var33);
         if(var28) {
            var14 *= 0.92F;
         } else {
            var14 *= 0.7F;
         }

         var14 += var24 * 0.1F;
         var13 += var23 * 0.1F;
         var24 *= 0.9F;
         var23 *= 0.75F;
         var24 += (var25.nextFloat() - var25.nextFloat()) * var25.nextFloat() * 2.0F;
         var23 += (var25.nextFloat() - var25.nextFloat()) * var25.nextFloat() * 4.0F;
         if(!var55 && var15 == var27 && var12 > 1.0F && var16 > 0) {
            this.a(var25.nextLong(), var3, var4, var5, var6, var8, var10, var25.nextFloat() * 0.5F + 0.5F, var13 - 1.5707964F, var14 / 3.0F, var15, var16, 1.0D);
            this.a(var25.nextLong(), var3, var4, var5, var6, var8, var10, var25.nextFloat() * 0.5F + 0.5F, var13 + 1.5707964F, var14 / 3.0F, var15, var16, 1.0D);
            return;
         }

         if(var55 || var25.nextInt(4) != 0) {
            double var35 = var6 - var19;
            double var37 = var10 - var21;
            double var39 = (double)(var16 - var15);
            double var41 = (double)(var12 + 2.0F + 16.0F);
            if(var35 * var35 + var37 * var37 - var39 * var39 > var41 * var41) {
               return;
            }

            if(var6 >= var19 - 16.0D - var29 * 2.0D && var10 >= var21 - 16.0D - var29 * 2.0D && var6 <= var19 + 16.0D + var29 * 2.0D && var10 <= var21 + 16.0D + var29 * 2.0D) {
               int var56 = class_nu.c(var6 - var29) - var3 * 16 - 1;
               int var36 = class_nu.c(var6 + var29) - var3 * 16 + 1;
               int var57 = class_nu.c(var8 - var31) - 1;
               int var38 = class_nu.c(var8 + var31) + 1;
               int var58 = class_nu.c(var10 - var29) - var4 * 16 - 1;
               int var40 = class_nu.c(var10 + var29) - var4 * 16 + 1;
               if(var56 < 0) {
                  var56 = 0;
               }

               if(var36 > 16) {
                  var36 = 16;
               }

               if(var57 < 1) {
                  var57 = 1;
               }

               if(var38 > 248) {
                  var38 = 248;
               }

               if(var58 < 0) {
                  var58 = 0;
               }

               if(var40 > 16) {
                  var40 = 16;
               }

               boolean var59 = false;

               int var43;
               for(int var42 = var56; !var59 && var42 < var36; ++var42) {
                  for(var43 = var58; !var59 && var43 < var40; ++var43) {
                     for(int var44 = var38 + 1; !var59 && var44 >= var57 - 1; --var44) {
                        if(var44 >= 0 && var44 < 256) {
                           IBlockData var45 = var5.a(var42, var44, var43);
                           if(var45.getBlock() == class_agk.i || var45.getBlock() == class_agk.j) {
                              var59 = true;
                           }

                           if(var44 != var57 - 1 && var42 != var56 && var42 != var36 - 1 && var43 != var58 && var43 != var40 - 1) {
                              var44 = var57;
                           }
                        }
                     }
                  }
               }

               if(!var59) {
                  class_cj.class_a_in_class_cj var60 = new class_cj.class_a_in_class_cj();

                  for(var43 = var56; var43 < var36; ++var43) {
                     double var61 = ((double)(var43 + var3 * 16) + 0.5D - var6) / var29;

                     for(int var46 = var58; var46 < var40; ++var46) {
                        double var47 = ((double)(var46 + var4 * 16) + 0.5D - var10) / var29;
                        boolean var49 = false;
                        if(var61 * var61 + var47 * var47 < 1.0D) {
                           for(int var50 = var38; var50 > var57; --var50) {
                              double var51 = ((double)(var50 - 1) + 0.5D - var8) / var31;
                              if(var51 > -0.7D && var61 * var61 + var51 * var51 + var47 * var47 < 1.0D) {
                                 IBlockData var53 = var5.a(var43, var50, var46);
                                 IBlockData var54 = (IBlockData)Objects.firstNonNull(var5.a(var43, var50 + 1, var46), class_agk.a.S());
                                 if(var53.getBlock() == class_agk.c || var53.getBlock() == class_agk.bw) {
                                    var49 = true;
                                 }

                                 if(this.a(var53, var54)) {
                                    if(var50 - 1 < 10) {
                                       var5.a(var43, var50, var46, class_agk.l.S());
                                    } else {
                                       var5.a(var43, var50, var46, class_agk.a.S());
                                       if(var54.getBlock() == class_agk.m) {
                                          var5.a(var43, var50 + 1, var46, var54.get(class_akq.a) == class_akq.class_a_in_class_akq.b?class_agk.cM.S():class_agk.A.S());
                                       }

                                       if(var49 && var5.a(var43, var50 - 1, var46).getBlock() == class_agk.d) {
                                          var60.c(var43 + var3 * 16, 0, var46 + var4 * 16);
                                          var5.a(var43, var50 - 1, var46, this.c.b((class_cj)var60).ak.getBlock().S());
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }

                  if(var55) {
                     break;
                  }
               }
            }
         }
      }

   }

   protected boolean a(IBlockData var1, IBlockData var2) {
      return var1.getBlock() == class_agk.b?true:(var1.getBlock() == class_agk.d?true:(var1.getBlock() == class_agk.c?true:(var1.getBlock() == class_agk.cz?true:(var1.getBlock() == class_agk.cu?true:(var1.getBlock() == class_agk.A?true:(var1.getBlock() == class_agk.cM?true:(var1.getBlock() == class_agk.bw?true:(var1.getBlock() == class_agk.aH?true:(var1.getBlock() == class_agk.m || var1.getBlock() == class_agk.n) && var2.getBlock().v() != class_atk.h))))))));
   }

   protected void a(class_aen var1, int var2, int var3, int var4, int var5, class_aph var6) {
      int var7 = this.b.nextInt(this.b.nextInt(this.b.nextInt(15) + 1) + 1);
      if(this.b.nextInt(7) != 0) {
         var7 = 0;
      }

      for(int var8 = 0; var8 < var7; ++var8) {
         double var9 = (double)(var2 * 16 + this.b.nextInt(16));
         double var11 = (double)this.b.nextInt(this.b.nextInt(120) + 8);
         double var13 = (double)(var3 * 16 + this.b.nextInt(16));
         int var15 = 1;
         if(this.b.nextInt(4) == 0) {
            this.a(this.b.nextLong(), var4, var5, var6, var9, var11, var13);
            var15 += this.b.nextInt(4);
         }

         for(int var16 = 0; var16 < var15; ++var16) {
            float var17 = this.b.nextFloat() * 3.1415927F * 2.0F;
            float var18 = (this.b.nextFloat() - 0.5F) * 2.0F / 8.0F;
            float var19 = this.b.nextFloat() * 2.0F + this.b.nextFloat();
            if(this.b.nextInt(10) == 0) {
               var19 *= this.b.nextFloat() * this.b.nextFloat() * 3.0F + 1.0F;
            }

            this.a(this.b.nextLong(), var4, var5, var6, var9, var11, var13, var19, var17, var18, 0, 0, 1.0D);
         }
      }

   }
}
