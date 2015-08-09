package net.minecraft.server;

import net.minecraft.server.Enchantment;
import net.minecraft.server.class_oc;

public class class_adl extends class_oc.WeightedRandomChoice {
   public final Enchantment b;
   public final int c;

   public class_adl(Enchantment var1, int var2) {
      super(var1.c().a());
      this.b = var1;
      this.c = var2;
   }
}
