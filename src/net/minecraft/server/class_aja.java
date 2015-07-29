package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aen;
import net.minecraft.server.Block;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_ajw;
import net.minecraft.server.class_alq;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_anw;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_cj;
import net.minecraft.server.CreativeTab;

public abstract class class_aja extends class_alq {
   public static final class_anw a = class_anw.a("decayable");
   public static final class_anw b = class_anw.a("check_decay");
   int[] N;

   public class_aja() {
      super(class_atk.j, false);
      this.a(true);
      this.a(CreativeTab.c);
      this.c(0.2F);
      this.e(1);
      this.a(STEP_SOUND_GRASS);
   }

   public void b(class_aen var1, class_cj var2, IBlockData var3) {
      byte var4 = 1;
      int var5 = var4 + 1;
      int var6 = var2.n();
      int var7 = var2.o();
      int var8 = var2.p();
      if(var1.a(new class_cj(var6 - var5, var7 - var5, var8 - var5), new class_cj(var6 + var5, var7 + var5, var8 + var5))) {
         for(int var9 = -var4; var9 <= var4; ++var9) {
            for(int var10 = -var4; var10 <= var4; ++var10) {
               for(int var11 = -var4; var11 <= var4; ++var11) {
                  class_cj var12 = var2.a(var9, var10, var11);
                  IBlockData var13 = var1.p(var12);
                  if(var13.getBlock().v() == class_atk.j && !((Boolean)var13.get(b)).booleanValue()) {
                     var1.a((class_cj)var12, (IBlockData)var13.set(b, Boolean.valueOf(true)), 4);
                  }
               }
            }
         }
      }

   }

   public void b(class_aen var1, class_cj var2, IBlockData var3, Random var4) {
      if(!var1.D) {
         if(((Boolean)var3.get(b)).booleanValue() && ((Boolean)var3.get(a)).booleanValue()) {
            byte var5 = 4;
            int var6 = var5 + 1;
            int var7 = var2.n();
            int var8 = var2.o();
            int var9 = var2.p();
            byte var10 = 32;
            int var11 = var10 * var10;
            int var12 = var10 / 2;
            if(this.N == null) {
               this.N = new int[var10 * var10 * var10];
            }

            if(var1.a(new class_cj(var7 - var6, var8 - var6, var9 - var6), new class_cj(var7 + var6, var8 + var6, var9 + var6))) {
               class_cj.class_a_in_class_cj var13 = new class_cj.class_a_in_class_cj();
               int var14 = -var5;

               label116:
               while(true) {
                  int var15;
                  int var16;
                  if(var14 > var5) {
                     var14 = 1;

                     while(true) {
                        if(var14 > 4) {
                           break label116;
                        }

                        for(var15 = -var5; var15 <= var5; ++var15) {
                           for(var16 = -var5; var16 <= var5; ++var16) {
                              for(int var19 = -var5; var19 <= var5; ++var19) {
                                 if(this.N[(var15 + var12) * var11 + (var16 + var12) * var10 + var19 + var12] == var14 - 1) {
                                    if(this.N[(var15 + var12 - 1) * var11 + (var16 + var12) * var10 + var19 + var12] == -2) {
                                       this.N[(var15 + var12 - 1) * var11 + (var16 + var12) * var10 + var19 + var12] = var14;
                                    }

                                    if(this.N[(var15 + var12 + 1) * var11 + (var16 + var12) * var10 + var19 + var12] == -2) {
                                       this.N[(var15 + var12 + 1) * var11 + (var16 + var12) * var10 + var19 + var12] = var14;
                                    }

                                    if(this.N[(var15 + var12) * var11 + (var16 + var12 - 1) * var10 + var19 + var12] == -2) {
                                       this.N[(var15 + var12) * var11 + (var16 + var12 - 1) * var10 + var19 + var12] = var14;
                                    }

                                    if(this.N[(var15 + var12) * var11 + (var16 + var12 + 1) * var10 + var19 + var12] == -2) {
                                       this.N[(var15 + var12) * var11 + (var16 + var12 + 1) * var10 + var19 + var12] = var14;
                                    }

                                    if(this.N[(var15 + var12) * var11 + (var16 + var12) * var10 + (var19 + var12 - 1)] == -2) {
                                       this.N[(var15 + var12) * var11 + (var16 + var12) * var10 + (var19 + var12 - 1)] = var14;
                                    }

                                    if(this.N[(var15 + var12) * var11 + (var16 + var12) * var10 + var19 + var12 + 1] == -2) {
                                       this.N[(var15 + var12) * var11 + (var16 + var12) * var10 + var19 + var12 + 1] = var14;
                                    }
                                 }
                              }
                           }
                        }

                        ++var14;
                     }
                  }

                  for(var15 = -var5; var15 <= var5; ++var15) {
                     for(var16 = -var5; var16 <= var5; ++var16) {
                        Block var17 = var1.p(var13.c(var7 + var14, var8 + var15, var9 + var16)).getBlock();
                        if(var17 != class_agk.r && var17 != class_agk.s) {
                           if(var17.v() == class_atk.j) {
                              this.N[(var14 + var12) * var11 + (var15 + var12) * var10 + var16 + var12] = -2;
                           } else {
                              this.N[(var14 + var12) * var11 + (var15 + var12) * var10 + var16 + var12] = -1;
                           }
                        } else {
                           this.N[(var14 + var12) * var11 + (var15 + var12) * var10 + var16 + var12] = 0;
                        }
                     }
                  }

                  ++var14;
               }
            }

            int var18 = this.N[var12 * var11 + var12 * var10 + var12];
            if(var18 >= 0) {
               var1.a((class_cj)var2, (IBlockData)var3.set(b, Boolean.valueOf(false)), 4);
            } else {
               this.e(var1, var2);
            }
         }

      }
   }

   private void e(class_aen var1, class_cj var2) {
      this.b(var1, var2, var1.p(var2), 0);
      var1.g(var2);
   }

   public int a(Random var1) {
      return var1.nextInt(20) == 0?1:0;
   }

   public class_aar a(IBlockData var1, Random var2, int var3) {
      return class_aar.a(class_agk.g);
   }

   public void a(class_aen var1, class_cj var2, IBlockData var3, float var4, int var5) {
      if(!var1.D) {
         int var6 = this.d(var3);
         if(var5 > 0) {
            var6 -= 2 << var5;
            if(var6 < 10) {
               var6 = 10;
            }
         }

         if(var1.s.nextInt(var6) == 0) {
            class_aar var7 = this.a(var3, var1.s, var5);
            a(var1, var2, new class_aas(var7, 1, this.a(var3)));
         }

         var6 = 200;
         if(var5 > 0) {
            var6 -= 10 << var5;
            if(var6 < 40) {
               var6 = 40;
            }
         }

         this.a(var1, var2, var3, var6);
      }

   }

   protected void a(class_aen var1, class_cj var2, IBlockData var3, int var4) {
   }

   protected int d(IBlockData var1) {
      return 20;
   }

   public boolean c() {
      return !this.R;
   }

   public boolean y() {
      return false;
   }

   public abstract class_ajw.class_a_in_class_ajw b(int var1);
}
