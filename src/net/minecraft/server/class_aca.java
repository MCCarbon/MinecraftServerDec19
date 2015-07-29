package net.minecraft.server;

import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_abx;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_ajd;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_awg;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_nc;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_or;
import net.minecraft.server.class_xa;

public class class_aca extends class_abx {
   public class_aca(class_agj var1) {
      super(var1, false);
   }

   public class_or a(class_aas var1, class_aen var2, class_xa var3, class_oo var4) {
      class_awg var5 = this.a(var2, var3, true);
      if(var5 == null) {
         return new class_or(class_oq.b, var1);
      } else {
         if(var5.a == class_awg.class_a_in_class_awg.b) {
            class_cj var6 = var5.a();
            if(!var2.a(var3, var6)) {
               return new class_or(class_oq.b, var1);
            }

            if(!var3.a(var6.a(var5.b), var5.b, var1)) {
               return new class_or(class_oq.b, var1);
            }

            class_cj var7 = var6.a();
            class_anl var8 = var2.p(var6);
            if(var8.c().v() == class_atk.h && ((Integer)var8.b(class_ajd.b)).intValue() == 0 && var2.d(var7)) {
               var2.a(var7, class_agk.bx.S());
               if(!var3.bH.d) {
                  --var1.b;
               }

               var3.b(class_nc.ad[class_aar.b((class_aar)this)]);
               return new class_or(class_oq.a, var1);
            }
         }

         return new class_or(class_oq.b, var1);
      }
   }
}
