package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_alu;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_aql;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;

public class class_aro extends class_aql {
   public boolean b(class_aen var1, Random var2, class_cj var3) {
      for(; var3.o() < 128; var3 = var3.a()) {
         if(var1.d(var3)) {
            class_cq[] var4 = class_cq.class_c_in_class_cq.a.a();
            int var5 = var4.length;

            for(int var6 = 0; var6 < var5; ++var6) {
               class_cq var7 = var4[var6];
               if(class_agk.bn.b(var1, var3, var7)) {
                  IBlockData var8 = class_agk.bn.S().set(class_alu.b, Boolean.valueOf(var7 == class_cq.c)).set(class_alu.N, Boolean.valueOf(var7 == class_cq.f)).set(class_alu.O, Boolean.valueOf(var7 == class_cq.d)).set(class_alu.P, Boolean.valueOf(var7 == class_cq.e));
                  var1.a((class_cj)var3, (IBlockData)var8, 2);
                  break;
               }
            }
         } else {
            var3 = var3.a(var2.nextInt(4) - var2.nextInt(4), 0, var2.nextInt(4) - var2.nextInt(4));
         }
      }

      return true;
   }
}
