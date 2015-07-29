package net.minecraft.server;

import net.minecraft.server.class_aba;
import net.minecraft.server.class_agj;

public class class_yz extends class_aba {
   public class_yz(class_agj var1) {
      super(var1, var1, new String[]{"intact", "slightlyDamaged", "veryDamaged"});
   }

   public int a(int var1) {
      return var1 << 2;
   }
}
