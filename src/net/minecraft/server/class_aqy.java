package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aen;
import net.minecraft.server.Block;
import net.minecraft.server.class_agk;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_apw;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_cj;

public abstract class class_aqy extends class_apw {
   protected final int a;
   protected final IBlockData b;
   protected final IBlockData c;
   protected int d;

   public class_aqy(boolean var1, int var2, int var3, IBlockData var4, IBlockData var5) {
      super(var1);
      this.a = var2;
      this.d = var3;
      this.b = var4;
      this.c = var5;
   }

   protected int a(Random var1) {
      int var2 = var1.nextInt(3) + this.a;
      if(this.d > 1) {
         var2 += var1.nextInt(this.d);
      }

      return var2;
   }

   private boolean c(class_aen var1, class_cj var2, int var3) {
      boolean var4 = true;
      if(var2.o() >= 1 && var2.o() + var3 + 1 <= 256) {
         for(int var5 = 0; var5 <= 1 + var3; ++var5) {
            byte var6 = 2;
            if(var5 == 0) {
               var6 = 1;
            } else if(var5 >= 1 + var3 - 2) {
               var6 = 2;
            }

            for(int var7 = -var6; var7 <= var6 && var4; ++var7) {
               for(int var8 = -var6; var8 <= var6 && var4; ++var8) {
                  if(var2.o() + var5 < 0 || var2.o() + var5 >= 256 || !this.a(var1.p(var2.a(var7, var5, var8)).getBlock())) {
                     var4 = false;
                  }
               }
            }
         }

         return var4;
      } else {
         return false;
      }
   }

   private boolean a(class_cj var1, class_aen var2) {
      class_cj var3 = var1.b();
      Block var4 = var2.p(var3).getBlock();
      if((var4 == class_agk.c || var4 == class_agk.d) && var1.o() >= 2) {
         this.a(var2, var3);
         this.a(var2, var3.f());
         this.a(var2, var3.d());
         this.a(var2, var3.d().f());
         return true;
      } else {
         return false;
      }
   }

   protected boolean a(class_aen var1, Random var2, class_cj var3, int var4) {
      return this.c(var1, var3, var4) && this.a(var3, var1);
   }

   protected void a(class_aen var1, class_cj var2, int var3) {
      int var4 = var3 * var3;

      for(int var5 = -var3; var5 <= var3 + 1; ++var5) {
         for(int var6 = -var3; var6 <= var3 + 1; ++var6) {
            int var7 = var5 - 1;
            int var8 = var6 - 1;
            if(var5 * var5 + var6 * var6 <= var4 || var7 * var7 + var8 * var8 <= var4 || var5 * var5 + var8 * var8 <= var4 || var7 * var7 + var6 * var6 <= var4) {
               class_cj var9 = var2.a(var5, 0, var6);
               class_atk var10 = var1.p(var9).getBlock().v();
               if(var10 == class_atk.a || var10 == class_atk.j) {
                  this.a(var1, var9, this.c);
               }
            }
         }
      }

   }

   protected void b(class_aen var1, class_cj var2, int var3) {
      int var4 = var3 * var3;

      for(int var5 = -var3; var5 <= var3; ++var5) {
         for(int var6 = -var3; var6 <= var3; ++var6) {
            if(var5 * var5 + var6 * var6 <= var4) {
               class_cj var7 = var2.a(var5, 0, var6);
               class_atk var8 = var1.p(var7).getBlock().v();
               if(var8 == class_atk.a || var8 == class_atk.j) {
                  this.a(var1, var7, this.c);
               }
            }
         }
      }

   }
}
