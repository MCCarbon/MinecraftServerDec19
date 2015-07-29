package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aen;
import net.minecraft.server.Block;
import net.minecraft.server.class_agk;
import net.minecraft.server.IBlockData;
import net.minecraft.server.class_aql;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_cj;

public class class_aqf extends class_aql {
   public boolean b(class_aen var1, Random var2, class_cj var3) {
      Block var4;
      while(((var4 = var1.p(var3).getBlock()).v() == class_atk.a || var4.v() == class_atk.j) && var3.o() > 0) {
         var3 = var3.b();
      }

      for(int var5 = 0; var5 < 4; ++var5) {
         class_cj var6 = var3.a(var2.nextInt(8) - var2.nextInt(8), var2.nextInt(4) - var2.nextInt(4), var2.nextInt(8) - var2.nextInt(8));
         if(var1.d(var6) && class_agk.I.f(var1, var6, class_agk.I.S())) {
            var1.a((class_cj)var6, (IBlockData)class_agk.I.S(), 2);
         }
      }

      return true;
   }
}
