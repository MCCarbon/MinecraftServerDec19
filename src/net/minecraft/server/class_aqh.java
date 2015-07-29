package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_ahm;
import net.minecraft.server.class_aql;
import net.minecraft.server.class_cj;

public class class_aqh extends class_aql {
   private class_ahm.class_b_in_class_ahm a;

   public void a(class_ahm.class_b_in_class_ahm var1) {
      this.a = var1;
   }

   public boolean b(class_aen var1, Random var2, class_cj var3) {
      boolean var4 = false;

      for(int var5 = 0; var5 < 64; ++var5) {
         class_cj var6 = var3.a(var2.nextInt(8) - var2.nextInt(8), var2.nextInt(4) - var2.nextInt(4), var2.nextInt(8) - var2.nextInt(8));
         if(var1.d(var6) && (!var1.t.m() || var6.o() < 254) && class_agk.cF.d(var1, var6)) {
            class_agk.cF.a(var1, var6, this.a, 2);
            var4 = true;
         }
      }

      return var4;
   }
}
