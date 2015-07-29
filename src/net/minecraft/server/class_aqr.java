package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_aiw;
import net.minecraft.server.class_aql;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_cj;

public class class_aqr extends class_aql {
   private class_agj a;

   public class_aqr(class_agj var1) {
      super(true);
      this.a = var1;
   }

   public class_aqr() {
      super(false);
   }

   public boolean b(class_aen var1, Random var2, class_cj var3) {
      if(this.a == null) {
         this.a = var2.nextBoolean()?class_agk.bg:class_agk.bh;
      }

      int var4 = var2.nextInt(3) + 4;
      boolean var5 = true;
      if(var3.o() >= 1 && var3.o() + var4 + 1 < 256) {
         int var9;
         int var10;
         for(int var6 = var3.o(); var6 <= var3.o() + 1 + var4; ++var6) {
            byte var7 = 3;
            if(var6 <= var3.o() + 3) {
               var7 = 0;
            }

            class_cj.class_a_in_class_cj var8 = new class_cj.class_a_in_class_cj();

            for(var9 = var3.n() - var7; var9 <= var3.n() + var7 && var5; ++var9) {
               for(var10 = var3.p() - var7; var10 <= var3.p() + var7 && var5; ++var10) {
                  if(var6 >= 0 && var6 < 256) {
                     class_agj var11 = var1.p(var8.c(var9, var6, var10)).c();
                     if(var11.v() != class_atk.a && var11.v() != class_atk.j) {
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
            class_agj var19 = var1.p(var3.b()).c();
            if(var19 != class_agk.d && var19 != class_agk.c && var19 != class_agk.bw) {
               return false;
            } else {
               int var20 = var3.o() + var4;
               if(this.a == class_agk.bh) {
                  var20 = var3.o() + var4 - 3;
               }

               int var21;
               for(var21 = var20; var21 <= var3.o() + var4; ++var21) {
                  var9 = 1;
                  if(var21 < var3.o() + var4) {
                     ++var9;
                  }

                  if(this.a == class_agk.bg) {
                     var9 = 3;
                  }

                  var10 = var3.n() - var9;
                  int var23 = var3.n() + var9;
                  int var12 = var3.p() - var9;
                  int var13 = var3.p() + var9;

                  for(int var14 = var10; var14 <= var23; ++var14) {
                     for(int var15 = var12; var15 <= var13; ++var15) {
                        int var16 = 5;
                        if(var14 == var10) {
                           --var16;
                        } else if(var14 == var23) {
                           ++var16;
                        }

                        if(var15 == var12) {
                           var16 -= 3;
                        } else if(var15 == var13) {
                           var16 += 3;
                        }

                        class_aiw.class_a_in_class_aiw var17 = class_aiw.class_a_in_class_aiw.a(var16);
                        if(this.a == class_agk.bg || var21 < var3.o() + var4) {
                           if((var14 == var10 || var14 == var23) && (var15 == var12 || var15 == var13)) {
                              continue;
                           }

                           if(var14 == var3.n() - (var9 - 1) && var15 == var12) {
                              var17 = class_aiw.class_a_in_class_aiw.a;
                           }

                           if(var14 == var10 && var15 == var3.p() - (var9 - 1)) {
                              var17 = class_aiw.class_a_in_class_aiw.a;
                           }

                           if(var14 == var3.n() + (var9 - 1) && var15 == var12) {
                              var17 = class_aiw.class_a_in_class_aiw.c;
                           }

                           if(var14 == var23 && var15 == var3.p() - (var9 - 1)) {
                              var17 = class_aiw.class_a_in_class_aiw.c;
                           }

                           if(var14 == var3.n() - (var9 - 1) && var15 == var13) {
                              var17 = class_aiw.class_a_in_class_aiw.g;
                           }

                           if(var14 == var10 && var15 == var3.p() + (var9 - 1)) {
                              var17 = class_aiw.class_a_in_class_aiw.g;
                           }

                           if(var14 == var3.n() + (var9 - 1) && var15 == var13) {
                              var17 = class_aiw.class_a_in_class_aiw.i;
                           }

                           if(var14 == var23 && var15 == var3.p() + (var9 - 1)) {
                              var17 = class_aiw.class_a_in_class_aiw.i;
                           }
                        }

                        if(var17 == class_aiw.class_a_in_class_aiw.e && var21 < var3.o() + var4) {
                           var17 = class_aiw.class_a_in_class_aiw.k;
                        }

                        if(var3.o() >= var3.o() + var4 - 1 || var17 != class_aiw.class_a_in_class_aiw.k) {
                           class_cj var18 = new class_cj(var14, var21, var15);
                           if(!var1.p(var18).c().q()) {
                              this.a(var1, var18, this.a.S().a(class_aiw.a, var17));
                           }
                        }
                     }
                  }
               }

               for(var21 = 0; var21 < var4; ++var21) {
                  class_agj var22 = var1.p(var3.b(var21)).c();
                  if(!var22.q()) {
                     this.a(var1, var3.b(var21), this.a.S().a(class_aiw.a, class_aiw.class_a_in_class_aiw.j));
                  }
               }

               return true;
            }
         }
      } else {
         return false;
      }
   }
}
