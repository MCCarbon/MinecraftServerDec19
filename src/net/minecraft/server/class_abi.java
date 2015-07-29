package net.minecraft.server;

import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_pr;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_ud;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_zu;

public class class_abi extends class_aar {
   public class_abi() {
      this.h = 1;
      this.a(class_zu.e);
   }

   public boolean a(class_aas var1, class_xa var2, class_qa var3, class_oo var4) {
      if(var3 instanceof class_ud) {
         class_ud var5 = (class_ud)var3;
         if(!var5.cA() && !var5.j_()) {
            var5.m(true);
            var5.o.a((class_pr)var5, "mob.horse.leather", 0.5F, 1.0F);
            --var1.b;
         }

         return true;
      } else {
         return false;
      }
   }

   public boolean a(class_aas var1, class_qa var2, class_qa var3) {
      this.a(var1, (class_xa)null, var2, class_oo.a);
      return true;
   }
}
