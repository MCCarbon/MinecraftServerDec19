package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aen;
import net.minecraft.server.Block;
import net.minecraft.server.class_agk;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_aql;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_cj;

public class class_arg extends class_aql {
   private Block a;
   private int b;

   public class_arg(Block var1, int var2) {
      this.a = var1;
      this.b = var2;
   }

   public boolean b(class_aen var1, Random var2, class_cj var3) {
      if(var1.p(var3).getBlock().v() != class_atk.h) {
         return false;
      } else {
         int var4 = var2.nextInt(this.b - 2) + 2;
         byte var5 = 2;

         for(int var6 = var3.n() - var4; var6 <= var3.n() + var4; ++var6) {
            for(int var7 = var3.p() - var4; var7 <= var3.p() + var4; ++var7) {
               int var8 = var6 - var3.n();
               int var9 = var7 - var3.p();
               if(var8 * var8 + var9 * var9 <= var4 * var4) {
                  for(int var10 = var3.o() - var5; var10 <= var3.o() + var5; ++var10) {
                     class_cj var11 = new class_cj(var6, var10, var7);
                     Block var12 = var1.p(var11).getBlock();
                     if(var12 == class_agk.d || var12 == class_agk.c) {
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
