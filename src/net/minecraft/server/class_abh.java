package net.minecraft.server;

import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_aen;
import net.minecraft.server.Block;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_cq;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_xa;
import net.minecraft.server.CreativeTab;

public class class_abh extends class_aar {
   public class_abh() {
      this.a(CreativeTab.d);
   }

   public class_oq a(class_aas var1, class_xa var2, class_aen var3, class_cj var4, class_oo var5, class_cq var6, float var7, float var8, float var9) {
      boolean var10 = var3.p(var4).getBlock().a(var3, var4);
      class_cj var11 = var10?var4:var4.a(var6);
      if(!var2.a(var11, var6, var1)) {
         return class_oq.b;
      } else {
         Block var12 = var3.p(var11).getBlock();
         if(!var3.a(var12, var11, false, var6, (class_pr)null, var1)) {
            return class_oq.b;
         } else if(class_agk.af.d(var3, var11)) {
            --var1.b;
            var3.a(var11, class_agk.af.S());
            return class_oq.a;
         } else {
            return class_oq.b;
         }
      }
   }
}
