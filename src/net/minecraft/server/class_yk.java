package net.minecraft.server;

import net.minecraft.server.ItemStack;
import net.minecraft.server.Items;
import net.minecraft.server.class_amr;
import net.minecraft.server.class_oj;
import net.minecraft.server.class_yx;

public class class_yk extends class_yx {
   public class_yk(class_oj var1, int var2, int var3, int var4) {
      super(var1, var2, var3, var4);
   }

   public boolean a(ItemStack var1) {
      return class_amr.c(var1) || c_(var1);
   }

   public int b(ItemStack var1) {
      return c_(var1)?1:super.b(var1);
   }

   public static boolean c_(ItemStack var0) {
      return var0 != null && var0.getItem() != null && var0.getItem() == Items.ay;
   }
}
