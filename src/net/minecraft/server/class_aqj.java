package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_aql;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_nu;

public class class_aqj extends class_aql {
   public boolean b(class_aen var1, Random var2, class_cj var3) {
      int var4 = var2.nextInt(3) + 4;
      float var5 = (float)var4;

      for(int var6 = 0; var5 > 0.5F; --var6) {
         for(int var7 = class_nu.d(-var5); var7 <= class_nu.f(var5); ++var7) {
            for(int var8 = class_nu.d(-var5); var8 <= class_nu.f(var5); ++var8) {
               if((float)(var7 * var7 + var8 * var8) <= (var5 + 1.0F) * (var5 + 1.0F)) {
                  this.a(var1, var3.a(var7, var6, var8), class_agk.bH.S());
               }
            }
         }

         var5 = (float)((double)var5 - ((double)var2.nextInt(2) + 0.5D));
      }

      return true;
   }
}
