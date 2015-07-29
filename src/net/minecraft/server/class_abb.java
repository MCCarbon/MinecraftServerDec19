package net.minecraft.server;

import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_qb;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_zu;

public class class_abb extends class_aar {
   public class_abb() {
      this.a(class_zu.i);
   }

   public boolean a(class_aas var1, class_xa var2, class_qa var3, class_oo var4) {
      if(!var1.s()) {
         return false;
      } else if(var3 instanceof class_qb) {
         class_qb var5 = (class_qb)var3;
         var5.a((String)var1.q());
         var5.cl();
         --var1.b;
         return true;
      } else {
         return super.a(var1, var2, var3, var4);
      }
   }
}
