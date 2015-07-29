package net.minecraft.server;

import net.minecraft.server.class_aar;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_zu;

public class class_zr extends class_aar {
   public class_zr() {
      this.a(true);
      this.e(0);
      this.a(class_zu.l);
   }

   public String e_(class_aas var1) {
      return var1.i() == 1?"item.charcoal":"item.coal";
   }
}
