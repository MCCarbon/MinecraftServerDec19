package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.class_aas;
import net.minecraft.server.CreativeTab;

public class class_zr extends Item {
   public class_zr() {
      this.a(true);
      this.e(0);
      this.a(CreativeTab.l);
   }

   public String e_(class_aas var1) {
      return var1.i() == 1?"item.charcoal":"item.coal";
   }
}
