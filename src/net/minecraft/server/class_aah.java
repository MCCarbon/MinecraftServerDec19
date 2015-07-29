package net.minecraft.server;

import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_atk;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_xa;
import net.minecraft.server.CreativeTab;

public class class_aah extends class_aar {
   public class_aah() {
      this.a(CreativeTab.f);
   }

   public class_oq a(class_aas var1, class_xa var2, class_aen var3, class_cj var4, class_oo var5, class_cq var6, float var7, float var8, float var9) {
      if(var3.D) {
         return class_oq.a;
      } else {
         var4 = var4.a(var6);
         if(!var2.a(var4, var6, var1)) {
            return class_oq.b;
         } else {
            if(var3.p(var4).getBlock().v() == class_atk.a) {
               var3.a((double)var4.n() + 0.5D, (double)var4.o() + 0.5D, (double)var4.p() + 0.5D, "item.fireCharge.use", 1.0F, (g.nextFloat() - g.nextFloat()) * 0.2F + 1.0F);
               var3.a(var4, class_agk.ab.S());
            }

            if(!var2.bH.d) {
               --var1.b;
            }

            return class_oq.a;
         }
      }
   }
}
