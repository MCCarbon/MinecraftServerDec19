package net.minecraft.server;

import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aat;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_jz;
import net.minecraft.server.class_nc;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_or;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_ve;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_zu;

public class class_aal extends class_aar {
   public class_aal() {
      this.e(64);
      this.d(1);
      this.a(class_zu.i);
      this.a(new class_jz("cast"), new class_aat() {
      });
   }

   public class_or a(class_aas var1, class_aen var2, class_xa var3, class_oo var4) {
      if(var3.bN != null) {
         int var5 = var3.bN.l();
         var1.a(var5, (class_qa)var3);
         var3.a((class_oo)var4);
         return new class_or(class_oq.b, var1);
      } else {
         var2.a((class_pr)var3, "random.bow", 0.5F, 0.4F / (g.nextFloat() * 0.4F + 0.8F));
         if(!var2.D) {
            var2.a((class_pr)(new class_ve(var2, var3)));
         }

         var3.a((class_oo)var4);
         var3.b(class_nc.ad[class_aar.b((class_aar)this)]);
         return new class_or(class_oq.a, var1);
      }
   }

   public boolean f_(class_aas var1) {
      return super.f_(var1);
   }

   public int c() {
      return 1;
   }
}
