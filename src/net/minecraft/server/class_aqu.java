package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_aet;
import net.minecraft.server.class_aez;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_aql;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_cj;

public class class_aqu extends class_aql {
   private class_agj a;

   public class_aqu(class_agj var1) {
      this.a = var1;
   }

   public boolean b(class_aen var1, Random var2, class_cj var3) {
      for(var3 = var3.a(-8, 0, -8); var3.o() > 5 && var1.d(var3); var3 = var3.b()) {
         ;
      }

      if(var3.o() <= 4) {
         return false;
      } else {
         var3 = var3.c(4);
         boolean[] var4 = new boolean[2048];
         int var5 = var2.nextInt(4) + 4;

         int var6;
         for(var6 = 0; var6 < var5; ++var6) {
            double var7 = var2.nextDouble() * 6.0D + 3.0D;
            double var9 = var2.nextDouble() * 4.0D + 2.0D;
            double var11 = var2.nextDouble() * 6.0D + 3.0D;
            double var13 = var2.nextDouble() * (16.0D - var7 - 2.0D) + 1.0D + var7 / 2.0D;
            double var15 = var2.nextDouble() * (8.0D - var9 - 4.0D) + 2.0D + var9 / 2.0D;
            double var17 = var2.nextDouble() * (16.0D - var11 - 2.0D) + 1.0D + var11 / 2.0D;

            for(int var19 = 1; var19 < 15; ++var19) {
               for(int var20 = 1; var20 < 15; ++var20) {
                  for(int var21 = 1; var21 < 7; ++var21) {
                     double var22 = ((double)var19 - var13) / (var7 / 2.0D);
                     double var24 = ((double)var21 - var15) / (var9 / 2.0D);
                     double var26 = ((double)var20 - var17) / (var11 / 2.0D);
                     double var28 = var22 * var22 + var24 * var24 + var26 * var26;
                     if(var28 < 1.0D) {
                        var4[(var19 * 16 + var20) * 8 + var21] = true;
                     }
                  }
               }
            }
         }

         int var8;
         int var30;
         boolean var31;
         for(var6 = 0; var6 < 16; ++var6) {
            for(var30 = 0; var30 < 16; ++var30) {
               for(var8 = 0; var8 < 8; ++var8) {
                  var31 = !var4[(var6 * 16 + var30) * 8 + var8] && (var6 < 15 && var4[((var6 + 1) * 16 + var30) * 8 + var8] || var6 > 0 && var4[((var6 - 1) * 16 + var30) * 8 + var8] || var30 < 15 && var4[(var6 * 16 + var30 + 1) * 8 + var8] || var30 > 0 && var4[(var6 * 16 + (var30 - 1)) * 8 + var8] || var8 < 7 && var4[(var6 * 16 + var30) * 8 + var8 + 1] || var8 > 0 && var4[(var6 * 16 + var30) * 8 + (var8 - 1)]);
                  if(var31) {
                     class_atk var10 = var1.p(var3.a(var6, var8, var30)).c().v();
                     if(var8 >= 4 && var10.d()) {
                        return false;
                     }

                     if(var8 < 4 && !var10.a() && var1.p(var3.a(var6, var8, var30)).c() != this.a) {
                        return false;
                     }
                  }
               }
            }
         }

         for(var6 = 0; var6 < 16; ++var6) {
            for(var30 = 0; var30 < 16; ++var30) {
               for(var8 = 0; var8 < 8; ++var8) {
                  if(var4[(var6 * 16 + var30) * 8 + var8]) {
                     var1.a((class_cj)var3.a(var6, var8, var30), (class_anl)(var8 >= 4?class_agk.a.S():this.a.S()), 2);
                  }
               }
            }
         }

         for(var6 = 0; var6 < 16; ++var6) {
            for(var30 = 0; var30 < 16; ++var30) {
               for(var8 = 4; var8 < 8; ++var8) {
                  if(var4[(var6 * 16 + var30) * 8 + var8]) {
                     class_cj var32 = var3.a(var6, var8 - 1, var30);
                     if(var1.p(var32).c() == class_agk.d && var1.b(class_aet.a, var3.a(var6, var8, var30)) > 0) {
                        class_aez var33 = var1.b(var32);
                        if(var33.ak.c() == class_agk.bw) {
                           var1.a((class_cj)var32, (class_anl)class_agk.bw.S(), 2);
                        } else {
                           var1.a((class_cj)var32, (class_anl)class_agk.c.S(), 2);
                        }
                     }
                  }
               }
            }
         }

         if(this.a.v() == class_atk.i) {
            for(var6 = 0; var6 < 16; ++var6) {
               for(var30 = 0; var30 < 16; ++var30) {
                  for(var8 = 0; var8 < 8; ++var8) {
                     var31 = !var4[(var6 * 16 + var30) * 8 + var8] && (var6 < 15 && var4[((var6 + 1) * 16 + var30) * 8 + var8] || var6 > 0 && var4[((var6 - 1) * 16 + var30) * 8 + var8] || var30 < 15 && var4[(var6 * 16 + var30 + 1) * 8 + var8] || var30 > 0 && var4[(var6 * 16 + (var30 - 1)) * 8 + var8] || var8 < 7 && var4[(var6 * 16 + var30) * 8 + var8 + 1] || var8 > 0 && var4[(var6 * 16 + var30) * 8 + (var8 - 1)]);
                     if(var31 && (var8 < 4 || var2.nextInt(2) != 0) && var1.p(var3.a(var6, var8, var30)).c().v().a()) {
                        var1.a((class_cj)var3.a(var6, var8, var30), (class_anl)class_agk.b.S(), 2);
                     }
                  }
               }
            }
         }

         if(this.a.v() == class_atk.h) {
            for(var6 = 0; var6 < 16; ++var6) {
               for(var30 = 0; var30 < 16; ++var30) {
                  byte var34 = 4;
                  if(var1.v(var3.a(var6, var34, var30))) {
                     var1.a((class_cj)var3.a(var6, var34, var30), (class_anl)class_agk.aI.S(), 2);
                  }
               }
            }
         }

         return true;
      }
   }
}
