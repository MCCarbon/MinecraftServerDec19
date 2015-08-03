package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.ItemStack;
import net.minecraft.server.class_adi;
import net.minecraft.server.class_adj;
import net.minecraft.server.class_pw;
import net.minecraft.server.ItemArmor;

public class class_adg extends class_adi {
   protected class_adg(class_adi.class_a_in_class_adi var1, class_pw... var2) {
      super(var1, class_adj.j, var2);
      this.c("durability");
   }

   public int a(int var1) {
      return 5 + (var1 - 1) * 8;
   }

   public int b(int var1) {
      return super.a(var1) + 50;
   }

   public int b() {
      return 3;
   }

   public boolean a(ItemStack var1) {
      return var1.e()?true:super.a(var1);
   }

   public static boolean a(ItemStack var0, int var1, Random var2) {
      return var0.getItem() instanceof ItemArmor && var2.nextFloat() < 0.6F?false:var2.nextInt(var1 + 1) > 0;
   }
}
