package net.minecraft.server;

import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xg;

public class class_aaj extends class_aar {
   public class_oq a(class_aas var1, class_xa var2, class_aen var3, class_cj var4, class_oo var5, class_cq var6, float var7, float var8, float var9) {
      if(!var3.D) {
         class_xg var10 = new class_xg(var3, (double)((float)var4.n() + var7), (double)((float)var4.o() + var8), (double)((float)var4.p() + var9), var1);
         var3.a((class_pr)var10);
         if(!var2.bH.d) {
            --var1.b;
         }

         return class_oq.a;
      } else {
         return class_oq.b;
      }
   }
}
