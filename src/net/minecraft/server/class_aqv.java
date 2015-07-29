package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_aql;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;

public class class_aqv extends class_aql {
   public boolean b(class_aen var1, Random var2, class_cj var3) {
      if(!var1.d(var3)) {
         return false;
      } else if(var1.p(var3.a()).c() != class_agk.aV) {
         return false;
      } else {
         var1.a((class_cj)var3, (class_anl)class_agk.aX.S(), 2);

         for(int var4 = 0; var4 < 1500; ++var4) {
            class_cj var5 = var3.a(var2.nextInt(8) - var2.nextInt(8), -var2.nextInt(12), var2.nextInt(8) - var2.nextInt(8));
            if(var1.p(var5).c().v() == class_atk.a) {
               int var6 = 0;
               class_cq[] var7 = class_cq.values();
               int var8 = var7.length;

               for(int var9 = 0; var9 < var8; ++var9) {
                  class_cq var10 = var7[var9];
                  if(var1.p(var5.a(var10)).c() == class_agk.aX) {
                     ++var6;
                  }

                  if(var6 > 1) {
                     break;
                  }
               }

               if(var6 == 1) {
                  var1.a((class_cj)var5, (class_anl)class_agk.aX.S(), 2);
               }
            }
         }

         return true;
      }
   }
}
