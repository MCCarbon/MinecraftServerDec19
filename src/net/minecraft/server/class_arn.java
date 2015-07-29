package net.minecraft.server;

import java.util.Iterator;
import java.util.Random;
import net.minecraft.server.class_aen;
import net.minecraft.server.Block;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_agy;
import net.minecraft.server.class_aja;
import net.minecraft.server.class_ajs;
import net.minecraft.server.class_ajt;
import net.minecraft.server.class_ajw;
import net.minecraft.server.class_alu;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_anw;
import net.minecraft.server.class_apw;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;

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

   public boolean b(class_aen var1, Random var2, class_cj var3) {
      int var4 = var2.nextInt(3) + this.c;
      boolean var5 = true;
      if(var3.o() >= 1 && var3.o() + var4 + 1 <= 256) {
         byte var7;
         int var9;
         int var10;
         for(int var6 = var3.o(); var6 <= var3.o() + 1 + var4; ++var6) {
            var7 = 1;
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
            Block var19 = var1.p(var3.b()).getBlock();
            if((var19 == class_agk.c || var19 == class_agk.d || var19 == class_agk.ak) && var3.o() < 256 - var4 - 1) {
               this.a(var1, var3.b());
               var7 = 3;
               byte var20 = 0;

               int var11;
               int var13;
               int var14;
               class_cj var16;
               for(var9 = var3.o() - var7 + var4; var9 <= var3.o() + var4; ++var9) {
                  var10 = var9 - (var3.o() + var4);
                  var11 = var20 + 1 - var10 / 2;

                  for(int var12 = var3.n() - var11; var12 <= var3.n() + var11; ++var12) {
                     var13 = var12 - var3.n();

                     for(var14 = var3.p() - var11; var14 <= var3.p() + var11; ++var14) {
                        int var15 = var14 - var3.p();
                        if(Math.abs(var13) != var11 || Math.abs(var15) != var11 || var2.nextInt(2) != 0 && var10 != 0) {
                           var16 = new class_cj(var12, var9, var14);
                           Block var17 = var1.p(var16).getBlock();
                           if(var17.v() == class_atk.a || var17.v() == class_atk.j || var17.v() == class_atk.l) {
                              this.a(var1, var16, this.f);
                           }
                        }
                     }
                  }
               }

               for(var9 = 0; var9 < var4; ++var9) {
                  Block var21 = var1.p(var3.b(var9)).getBlock();
                  if(var21.v() == class_atk.a || var21.v() == class_atk.j || var21.v() == class_atk.l) {
                     this.a(var1, var3.b(var9), this.e);
                     if(this.d && var9 > 0) {
                        if(var2.nextInt(3) > 0 && var1.d(var3.a(-1, var9, 0))) {
                           this.a(var1, var3.a(-1, var9, 0), class_alu.N);
                        }

                        if(var2.nextInt(3) > 0 && var1.d(var3.a(1, var9, 0))) {
                           this.a(var1, var3.a(1, var9, 0), class_alu.P);
                        }

                        if(var2.nextInt(3) > 0 && var1.d(var3.a(0, var9, -1))) {
                           this.a(var1, var3.a(0, var9, -1), class_alu.O);
                        }

                        if(var2.nextInt(3) > 0 && var1.d(var3.a(0, var9, 1))) {
                           this.a(var1, var3.a(0, var9, 1), class_alu.b);
                        }
                     }
                  }
               }

               if(this.d) {
                  for(var9 = var3.o() - 3 + var4; var9 <= var3.o() + var4; ++var9) {
                     var10 = var9 - (var3.o() + var4);
                     var11 = 2 - var10 / 2;
                     class_cj.class_a_in_class_cj var24 = new class_cj.class_a_in_class_cj();

                     for(var13 = var3.n() - var11; var13 <= var3.n() + var11; ++var13) {
                        for(var14 = var3.p() - var11; var14 <= var3.p() + var11; ++var14) {
                           var24.c(var13, var9, var14);
                           if(var1.p(var24).getBlock().v() == class_atk.j) {
                              class_cj var26 = var24.e();
                              var16 = var24.f();
                              class_cj var27 = var24.c();
                              class_cj var18 = var24.d();
                              if(var2.nextInt(4) == 0 && var1.p(var26).getBlock().v() == class_atk.a) {
                                 this.b(var1, var26, class_alu.N);
                              }

                              if(var2.nextInt(4) == 0 && var1.p(var16).getBlock().v() == class_atk.a) {
                                 this.b(var1, var16, class_alu.P);
                              }

                              if(var2.nextInt(4) == 0 && var1.p(var27).getBlock().v() == class_atk.a) {
                                 this.b(var1, var27, class_alu.O);
                              }

                              if(var2.nextInt(4) == 0 && var1.p(var18).getBlock().v() == class_atk.a) {
                                 this.b(var1, var18, class_alu.b);
                              }
                           }
                        }
                     }
                  }

                  if(var2.nextInt(5) == 0 && var4 > 5) {
                     for(var9 = 0; var9 < 2; ++var9) {
                        Iterator var22 = class_cq.class_c_in_class_cq.a.iterator();

                        while(var22.hasNext()) {
                           class_cq var23 = (class_cq)var22.next();
                           if(var2.nextInt(4 - var9) == 0) {
                              class_cq var25 = var23.d();
                              this.a(var1, var2.nextInt(3), var3.a(var25.g(), var4 - 5 + var9, var25.i()), var23);
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

   private void a(class_aen var1, int var2, class_cj var3, class_cq var4) {
      this.a(var1, var3, class_agk.bN.S().set(class_agy.a, Integer.valueOf(var2)).set(class_agy.O, var4));
   }

   private void a(class_aen var1, class_cj var2, class_anw var3) {
      this.a(var1, var2, class_agk.bn.S().set(var3, Boolean.valueOf(true)));
   }

   private void b(class_aen var1, class_cj var2, class_anw var3) {
      this.a(var1, var2, var3);
      int var4 = 4;

      for(var2 = var2.b(); var1.p(var2).getBlock().v() == class_atk.a && var4 > 0; --var4) {
         this.a(var1, var2, var3);
         var2 = var2.b();
      }

   }

   static {
      a = class_agk.r.S().set(class_ajt.b, class_ajw.class_a_in_class_ajw.a);
      b = class_agk.t.S().set(class_ajs.Q, class_ajw.class_a_in_class_ajw.a).set(class_aja.b, Boolean.valueOf(false));
   }
}
