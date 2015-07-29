package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.server.class_aeh;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_ajx;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_anp;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_lg;
import net.minecraft.server.class_ns;
import net.minecraft.server.class_nu;
import net.minecraft.server.class_pr;

public class class_aev {
   private final class_lg a;
   private final Random b;
   private final class_ns c = new class_ns();
   private final List d = Lists.newArrayList();

   public class_aev(class_lg var1) {
      this.a = var1;
      this.b = new Random(var1.K());
   }

   public void a(class_pr var1, float var2) {
      if(this.a.t.p().a() != 1) {
         if(!this.b(var1, var2)) {
            this.a(var1);
            this.b(var1, var2);
         }
      } else {
         int var3 = class_nu.c(var1.s);
         int var4 = class_nu.c(var1.t) - 1;
         int var5 = class_nu.c(var1.u);
         byte var6 = 1;
         byte var7 = 0;

         for(int var8 = -2; var8 <= 2; ++var8) {
            for(int var9 = -2; var9 <= 2; ++var9) {
               for(int var10 = -1; var10 < 3; ++var10) {
                  int var11 = var3 + var9 * var6 + var8 * var7;
                  int var12 = var4 + var10;
                  int var13 = var5 + var9 * var7 - var8 * var6;
                  boolean var14 = var10 < 0;
                  this.a.a((class_cj)(new class_cj(var11, var12, var13)), (IBlockData)(var14?class_agk.Z.S():class_agk.a.S()));
               }
            }
         }

         var1.b((double)var3, (double)var4, (double)var5, var1.y, 0.0F);
         var1.v = var1.w = var1.x = 0.0D;
      }
   }

   public boolean b(class_pr var1, float var2) {
      boolean var3 = true;
      double var4 = -1.0D;
      int var6 = class_nu.c(var1.s);
      int var7 = class_nu.c(var1.u);
      boolean var8 = true;
      Object var9 = class_cj.a;
      long var10 = class_aeh.a(var6, var7);
      if(this.c.b(var10)) {
         class_aev.class_a_in_class_aev var12 = (class_aev.class_a_in_class_aev)this.c.a(var10);
         var4 = 0.0D;
         var9 = var12;
         var12.c = this.a.L();
         var8 = false;
      } else {
         class_cj var30 = new class_cj(var1);

         for(int var13 = -128; var13 <= 128; ++var13) {
            class_cj var16;
            for(int var14 = -128; var14 <= 128; ++var14) {
               for(class_cj var15 = var30.a(var13, this.a.W() - 1 - var30.o(), var14); var15.o() >= 0; var15 = var16) {
                  var16 = var15.b();
                  if(this.a.p(var15).getBlock() == class_agk.aY) {
                     while(this.a.p(var16 = var15.b()).getBlock() == class_agk.aY) {
                        var15 = var16;
                     }

                     double var17 = var15.i(var30);
                     if(var4 < 0.0D || var17 < var4) {
                        var4 = var17;
                        var9 = var15;
                     }
                  }
               }
            }
         }
      }

      if(var4 >= 0.0D) {
         if(var8) {
            this.c.a(var10, new class_aev.class_a_in_class_aev((class_cj)var9, this.a.L()));
            this.d.add(Long.valueOf(var10));
         }

         double var31 = (double)((class_cj)var9).n() + 0.5D;
         double var32 = (double)((class_cj)var9).o() + 0.5D;
         double var33 = (double)((class_cj)var9).p() + 0.5D;
         class_anp.class_b_in_class_anp var18 = class_agk.aY.f(this.a, (class_cj)var9);
         boolean var19 = var18.b().e().c() == class_cq.class_b_in_class_cq.b;
         double var20 = var18.b().k() == class_cq.class_a_in_class_cq.a?(double)var18.a().p():(double)var18.a().n();
         var32 = (double)(var18.a().o() + 1) - var1.aI().b * (double)var18.e();
         if(var19) {
            ++var20;
         }

         if(var18.b().k() == class_cq.class_a_in_class_cq.a) {
            var33 = var20 + (1.0D - var1.aI().a) * (double)var18.d() * (double)var18.b().e().c().a();
         } else {
            var31 = var20 + (1.0D - var1.aI().a) * (double)var18.d() * (double)var18.b().e().c().a();
         }

         float var22 = 0.0F;
         float var23 = 0.0F;
         float var24 = 0.0F;
         float var25 = 0.0F;
         if(var18.b().d() == var1.aJ()) {
            var22 = 1.0F;
            var23 = 1.0F;
         } else if(var18.b().d() == var1.aJ().d()) {
            var22 = -1.0F;
            var23 = -1.0F;
         } else if(var18.b().d() == var1.aJ().e()) {
            var24 = 1.0F;
            var25 = -1.0F;
         } else {
            var24 = -1.0F;
            var25 = 1.0F;
         }

         double var26 = var1.v;
         double var28 = var1.x;
         var1.v = var26 * (double)var22 + var28 * (double)var25;
         var1.x = var26 * (double)var24 + var28 * (double)var23;
         var1.y = var2 - (float)(var1.aJ().d().b() * 90) + (float)(var18.b().b() * 90);
         var1.b(var31, var32, var33, var1.y, var1.z);
         return true;
      } else {
         return false;
      }
   }

   public boolean a(class_pr var1) {
      byte var2 = 16;
      double var3 = -1.0D;
      int var5 = class_nu.c(var1.s);
      int var6 = class_nu.c(var1.t);
      int var7 = class_nu.c(var1.u);
      int var8 = var5;
      int var9 = var6;
      int var10 = var7;
      int var11 = 0;
      int var12 = this.b.nextInt(4);
      class_cj.class_a_in_class_cj var13 = new class_cj.class_a_in_class_cj();

      int var14;
      double var15;
      int var17;
      double var18;
      int var20;
      int var21;
      int var22;
      int var23;
      int var24;
      int var25;
      int var26;
      int var27;
      int var28;
      double var33;
      double var34;
      for(var14 = var5 - var2; var14 <= var5 + var2; ++var14) {
         var15 = (double)var14 + 0.5D - var1.s;

         for(var17 = var7 - var2; var17 <= var7 + var2; ++var17) {
            var18 = (double)var17 + 0.5D - var1.u;

            label293:
            for(var20 = this.a.W() - 1; var20 >= 0; --var20) {
               if(this.a.d(var13.c(var14, var20, var17))) {
                  while(var20 > 0 && this.a.d(var13.c(var14, var20 - 1, var17))) {
                     --var20;
                  }

                  for(var21 = var12; var21 < var12 + 4; ++var21) {
                     var22 = var21 % 2;
                     var23 = 1 - var22;
                     if(var21 % 4 >= 2) {
                        var22 = -var22;
                        var23 = -var23;
                     }

                     for(var24 = 0; var24 < 3; ++var24) {
                        for(var25 = 0; var25 < 4; ++var25) {
                           for(var26 = -1; var26 < 4; ++var26) {
                              var27 = var14 + (var25 - 1) * var22 + var24 * var23;
                              var28 = var20 + var26;
                              int var29 = var17 + (var25 - 1) * var23 - var24 * var22;
                              var13.c(var27, var28, var29);
                              if(var26 < 0 && !this.a.p(var13).getBlock().v().a() || var26 >= 0 && !this.a.d(var13)) {
                                 continue label293;
                              }
                           }
                        }
                     }

                     var33 = (double)var20 + 0.5D - var1.t;
                     var34 = var15 * var15 + var33 * var33 + var18 * var18;
                     if(var3 < 0.0D || var34 < var3) {
                        var3 = var34;
                        var8 = var14;
                        var9 = var20;
                        var10 = var17;
                        var11 = var21 % 4;
                     }
                  }
               }
            }
         }
      }

      if(var3 < 0.0D) {
         for(var14 = var5 - var2; var14 <= var5 + var2; ++var14) {
            var15 = (double)var14 + 0.5D - var1.s;

            for(var17 = var7 - var2; var17 <= var7 + var2; ++var17) {
               var18 = (double)var17 + 0.5D - var1.u;

               label231:
               for(var20 = this.a.W() - 1; var20 >= 0; --var20) {
                  if(this.a.d(var13.c(var14, var20, var17))) {
                     while(var20 > 0 && this.a.d(var13.c(var14, var20 - 1, var17))) {
                        --var20;
                     }

                     for(var21 = var12; var21 < var12 + 2; ++var21) {
                        var22 = var21 % 2;
                        var23 = 1 - var22;

                        for(var24 = 0; var24 < 4; ++var24) {
                           for(var25 = -1; var25 < 4; ++var25) {
                              var26 = var14 + (var24 - 1) * var22;
                              var27 = var20 + var25;
                              var28 = var17 + (var24 - 1) * var23;
                              var13.c(var26, var27, var28);
                              if(var25 < 0 && !this.a.p(var13).getBlock().v().a() || var25 >= 0 && !this.a.d(var13)) {
                                 continue label231;
                              }
                           }
                        }

                        var33 = (double)var20 + 0.5D - var1.t;
                        var34 = var15 * var15 + var33 * var33 + var18 * var18;
                        if(var3 < 0.0D || var34 < var3) {
                           var3 = var34;
                           var8 = var14;
                           var9 = var20;
                           var10 = var17;
                           var11 = var21 % 2;
                        }
                     }
                  }
               }
            }
         }
      }

      int var30 = var8;
      int var16 = var9;
      var17 = var10;
      int var31 = var11 % 2;
      int var19 = 1 - var31;
      if(var11 % 4 >= 2) {
         var31 = -var31;
         var19 = -var19;
      }

      if(var3 < 0.0D) {
         var9 = class_nu.a(var9, 70, this.a.W() - 10);
         var16 = var9;

         for(var20 = -1; var20 <= 1; ++var20) {
            for(var21 = 1; var21 < 3; ++var21) {
               for(var22 = -1; var22 < 3; ++var22) {
                  var23 = var30 + (var21 - 1) * var31 + var20 * var19;
                  var24 = var16 + var22;
                  var25 = var17 + (var21 - 1) * var19 - var20 * var31;
                  boolean var35 = var22 < 0;
                  this.a.a((class_cj)(new class_cj(var23, var24, var25)), (IBlockData)(var35?class_agk.Z.S():class_agk.a.S()));
               }
            }
         }
      }

      IBlockData var32 = class_agk.aY.S().set(class_ajx.a, var31 != 0?class_cq.class_a_in_class_cq.a:class_cq.class_a_in_class_cq.c);

      for(var21 = 0; var21 < 4; ++var21) {
         for(var22 = 0; var22 < 4; ++var22) {
            for(var23 = -1; var23 < 4; ++var23) {
               var24 = var30 + (var22 - 1) * var31;
               var25 = var16 + var23;
               var26 = var17 + (var22 - 1) * var19;
               boolean var36 = var22 == 0 || var22 == 3 || var23 == -1 || var23 == 3;
               this.a.a(new class_cj(var24, var25, var26), var36?class_agk.Z.S():var32, 2);
            }
         }

         for(var22 = 0; var22 < 4; ++var22) {
            for(var23 = -1; var23 < 4; ++var23) {
               var24 = var30 + (var22 - 1) * var31;
               var25 = var16 + var23;
               var26 = var17 + (var22 - 1) * var19;
               class_cj var37 = new class_cj(var24, var25, var26);
               this.a.c(var37, this.a.p(var37).getBlock());
            }
         }
      }

      return true;
   }

   public void a(long var1) {
      if(var1 % 100L == 0L) {
         Iterator var3 = this.d.iterator();
         long var4 = var1 - 300L;

         while(true) {
            Long var6;
            class_aev.class_a_in_class_aev var7;
            do {
               if(!var3.hasNext()) {
                  return;
               }

               var6 = (Long)var3.next();
               var7 = (class_aev.class_a_in_class_aev)this.c.a(var6.longValue());
            } while(var7 != null && var7.c >= var4);

            var3.remove();
            this.c.d(var6.longValue());
         }
      }
   }

   public class class_a_in_class_aev extends class_cj {
      public long c;

      public class_a_in_class_aev(class_cj var2, long var3) {
         super(var2.n(), var2.o(), var2.p());
         this.c = var3;
      }
   }
}
