package net.minecraft.server;

import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_nc;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_or;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xq;
import net.minecraft.server.class_zu;

public class class_aaf extends class_aar {
   public class_aaf() {
      this.h = 16;
      this.a(class_zu.f);
   }

   public class_or a(class_aas var1, class_aen var2, class_xa var3, class_oo var4) {
      --var1.b;
      var2.a((class_pr)var3, "random.bow", 0.5F, 0.4F / (g.nextFloat() * 0.4F + 0.8F));
      if(!var2.D) {
         class_xq var5 = new class_xq(var2, var3);
         var5.a(var3.z, var3.y, 0.0F, 1.5F, 1.0F);
         var2.a((class_pr)var5);
      }

      var3.b(class_nc.ad[class_aar.b((class_aar)this)]);
      return new class_or(class_oq.a, var1);
   }
}
