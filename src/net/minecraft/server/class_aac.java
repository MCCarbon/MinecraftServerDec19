package net.minecraft.server;

import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_avd;
import net.minecraft.server.class_avf;
import net.minecraft.server.class_nc;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_or;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_zt;
import net.minecraft.server.class_zu;

public class class_aac extends class_zt {
   protected class_aac() {
      this.a(class_zu.f);
   }

   public class_or a(class_aas var1, class_aen var2, class_xa var3, class_oo var4) {
      class_aas var5 = new class_aas(class_aau.bf, 1, var2.b("map"));
      String var6 = "map_" + var5.i();
      class_avf var7 = new class_avf(var6);
      var2.a((String)var6, (class_avd)var7);
      var7.e = 0;
      var7.a(var3.s, var3.u, var7.e);
      var7.d = (byte)var2.t.p().a();
      var7.c();
      --var1.b;
      if(var1.b <= 0) {
         return new class_or(class_oq.a, var5);
      } else {
         if(!var3.bp.a(var5.k())) {
            var3.a(var5, false);
         }

         var3.b(class_nc.ad[class_aar.b((class_aar)this)]);
         return new class_or(class_oq.a, var1);
      }
   }
}
