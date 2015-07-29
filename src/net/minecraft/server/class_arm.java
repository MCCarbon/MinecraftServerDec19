package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_alm;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_aql;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_cj;

public class class_arm extends class_aql {
   private final class_anl a;

   public class_arm(class_alm.class_a_in_class_alm var1) {
      this.a = class_agk.H.S().a(class_alm.a, var1);
   }

   public boolean b(class_aen var1, Random var2, class_cj var3) {
      class_agj var4;
      while(((var4 = var1.p(var3).c()).v() == class_atk.a || var4.v() == class_atk.j) && var3.o() > 0) {
         var3 = var3.b();
      }

      for(int var5 = 0; var5 < 128; ++var5) {
         class_cj var6 = var3.a(var2.nextInt(8) - var2.nextInt(8), var2.nextInt(4) - var2.nextInt(4), var2.nextInt(8) - var2.nextInt(8));
         if(var1.d(var6) && class_agk.H.f(var1, var6, this.a)) {
            var1.a((class_cj)var6, (class_anl)this.a, 2);
         }
      }

      return true;
   }
}
