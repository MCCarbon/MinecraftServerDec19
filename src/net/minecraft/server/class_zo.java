package net.minecraft.server;

import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_nc;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_or;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_ud;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_zu;

public class class_zo extends class_aar {
   public class_zo() {
      this.a(class_zu.e);
      this.d(1);
      this.e(25);
   }

   public class_or a(class_aas var1, class_aen var2, class_xa var3, class_oo var4) {
      if(var3.aw() && var3.m instanceof class_ud) {
         class_ud var5 = (class_ud)var3.m;
         if(var5.cB().h() && var1.j() - var1.i() >= 7) {
            var5.cB().g();
            var1.a(7, (class_qa)var3);
            if(var1.b == 0) {
               class_aas var6 = new class_aas(class_aau.aT);
               var6.d(var1.o());
               return new class_or(class_oq.a, var6);
            }

            return new class_or(class_oq.a, var1);
         }
      }

      var3.b(class_nc.ad[class_aar.b((class_aar)this)]);
      return new class_or(class_oq.b, var1);
   }
}
