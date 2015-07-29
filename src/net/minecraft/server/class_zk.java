package net.minecraft.server;

import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_awg;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_nc;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_or;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_zu;

public class class_zk extends class_aar {
   public class_zk() {
      this.a(class_zu.k);
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

            if(var2.p(var6).c().v() == class_atk.h) {
               --var1.b;
               var3.b(class_nc.ad[class_aar.b((class_aar)this)]);
               if(var1.b <= 0) {
                  return new class_or(class_oq.a, new class_aas(class_aau.bB));
               }

               if(!var3.bp.a(new class_aas(class_aau.bB))) {
                  var3.a(new class_aas(class_aau.bB), false);
               }

               return new class_or(class_oq.a, var1);
            }
         }

         return new class_or(class_oq.b, var1);
      }
   }
}
