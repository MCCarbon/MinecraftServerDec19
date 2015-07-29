package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_aql;
import net.minecraft.server.class_cj;

public class class_aqc extends class_aql {
   public boolean b(class_aen var1, Random var2, class_cj var3) {
      for(int var4 = 0; var4 < 10; ++var4) {
         class_cj var5 = var3.a(var2.nextInt(8) - var2.nextInt(8), var2.nextInt(4) - var2.nextInt(4), var2.nextInt(8) - var2.nextInt(8));
         if(var1.d(var5)) {
            int var6 = 1 + var2.nextInt(var2.nextInt(3) + 1);

            for(int var7 = 0; var7 < var6; ++var7) {
               if(class_agk.aK.e(var1, var5)) {
                  var1.a((class_cj)var5.b(var7), (class_anl)class_agk.aK.S(), 2);
               }
            }
         }
      }

      return true;
   }
}
