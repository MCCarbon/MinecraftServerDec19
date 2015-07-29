package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aen;
import net.minecraft.server.Block;
import net.minecraft.server.class_agk;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_aql;
import net.minecraft.server.class_cj;

public class class_aqs extends class_aql {
   private Block a;
   private int b;

   public class_aqs(int var1) {
      this.a = class_agk.cB;
      this.b = var1;
   }

   public boolean b(class_aen var1, Random var2, class_cj var3) {
      while(var1.d(var3) && var3.o() > 2) {
         var3 = var3.b();
      }

      if(var1.p(var3).getBlock() != class_agk.aJ) {
         return false;
      } else {
         int var4 = var2.nextInt(this.b - 2) + 2;
         byte var5 = 1;

         for(int var6 = var3.n() - var4; var6 <= var3.n() + var4; ++var6) {
            for(int var7 = var3.p() - var4; var7 <= var3.p() + var4; ++var7) {
               int var8 = var6 - var3.n();
               int var9 = var7 - var3.p();
               if(var8 * var8 + var9 * var9 <= var4 * var4) {
                  for(int var10 = var3.o() - var5; var10 <= var3.o() + var5; ++var10) {
                     class_cj var11 = new class_cj(var6, var10, var7);
                     Block var12 = var1.p(var11).getBlock();
                     if(var12 == class_agk.d || var12 == class_agk.aJ || var12 == class_agk.aI) {
                        var1.a((class_cj)var11, (IBlockData)this.a.S(), 2);
                     }
                  }
               }
            }
         }

         return true;
      }
   }
}
