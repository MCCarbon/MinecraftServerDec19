package net.minecraft.server;

import net.minecraft.server.ItemStack;
import net.minecraft.server.Items;
import net.minecraft.server.class_adi;
import net.minecraft.server.class_adj;
import net.minecraft.server.Enchantment;
import net.minecraft.server.class_pw;

public class class_adu extends class_adi {
   protected class_adu(class_adi.class_a_in_class_adi var1, class_pw... var2) {
      super(var1, class_adj.h, var2);
      this.c("untouching");
   }

   public int a(int var1) {
      return 15;
   }

   public int b(int var1) {
      return super.a(var1) + 50;
   }

   public int b() {
      return 1;
   }

   public boolean a(class_adi var1) {
      return super.a(var1) && var1 != Enchantment.s;
   }

   public boolean a(ItemStack var1) {
      return var1.getItem() == Items.bg?true:super.a(var1);
   }
}
