package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aen;
import net.minecraft.server.Block;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_ajs;
import net.minecraft.server.class_ajt;
import net.minecraft.server.class_ajw;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_apw;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_cj;

public class class_apy extends class_apw {
   private static final IBlockData a;
   private static final IBlockData b;
   private boolean c;

   public class_apy(boolean var1, boolean var2) {
      super(var1);
      this.c = var2;
   }

   public boolean b(class_aen var1, Random var2, class_cj var3) {
      int var4 = var2.nextInt(3) + 5;
      if(this.c) {
         var4 += var2.nextInt(7);
      }

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
            Block var16 = var1.p(var3.b()).getBlock();
            if((var16 == class_agk.c || var16 == class_agk.d || var16 == class_agk.ak) && var3.o() < 256 - var4 - 1) {
               this.a(var1, var3.b());

               int var17;
               for(var17 = var3.o() - 3 + var4; var17 <= var3.o() + var4; ++var17) {
                  int var18 = var17 - (var3.o() + var4);
                  var9 = 1 - var18 / 2;

                  for(var10 = var3.n() - var9; var10 <= var3.n() + var9; ++var10) {
                     int var11 = var10 - var3.n();

                     for(int var12 = var3.p() - var9; var12 <= var3.p() + var9; ++var12) {
                        int var13 = var12 - var3.p();
                        if(Math.abs(var11) != var9 || Math.abs(var13) != var9 || var2.nextInt(2) != 0 && var18 != 0) {
                           class_cj var14 = new class_cj(var10, var17, var12);
                           Block var15 = var1.p(var14).getBlock();
                           if(var15.v() == class_atk.a || var15.v() == class_atk.j) {
                              this.a(var1, var14, b);
                           }
                        }
                     }
                  }
               }

               for(var17 = 0; var17 < var4; ++var17) {
                  Block var19 = var1.p(var3.b(var17)).getBlock();
                  if(var19.v() == class_atk.a || var19.v() == class_atk.j) {
                     this.a(var1, var3.b(var17), a);
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

   static {
      a = class_agk.r.S().set(class_ajt.b, class_ajw.class_a_in_class_ajw.c);
      b = class_agk.t.S().set(class_ajs.Q, class_ajw.class_a_in_class_ajw.c).set(class_ajs.b, Boolean.valueOf(false));
   }
}
