package net.minecraft.server;

import java.util.Iterator;
import java.util.Random;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_aql;
import net.minecraft.server.class_cj;

public class class_aqi extends class_aql {
   public boolean b(class_aen var1, Random var2, class_cj var3) {
      Iterator var4 = class_cj.b(var3.a(-1, -2, -1), var3.a(1, 2, 1)).iterator();

      while(true) {
         while(var4.hasNext()) {
            class_cj.class_a_in_class_cj var5 = (class_cj.class_a_in_class_cj)var4.next();
            boolean var6 = var5.n() == var3.n();
            boolean var7 = var5.o() == var3.o();
            boolean var8 = var5.p() == var3.p();
            boolean var9 = Math.abs(var5.o() - var3.o()) == 2;
            if(var6 && var7 && var8) {
               this.a(var1, new class_cj(var5), class_agk.db.S());
            } else if(var7) {
               this.a(var1, var5, class_agk.a.S());
            } else if(var9 && var6 && var8) {
               this.a(var1, var5, class_agk.h.S());
            } else if((var6 || var8) && !var9) {
               this.a(var1, var5, class_agk.h.S());
            } else {
               this.a(var1, var5, class_agk.a.S());
            }
         }

         return true;
      }
   }
}
