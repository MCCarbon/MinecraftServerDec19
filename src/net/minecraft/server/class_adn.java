package net.minecraft.server;

import net.minecraft.server.class_adi;
import net.minecraft.server.class_adj;
import net.minecraft.server.class_pw;

public class class_adn extends class_adi {
   protected class_adn(class_adi.class_a_in_class_adi var1, class_pw... var2) {
      super(var1, class_adj.g, var2);
      this.c("fire");
   }

   public int a(int var1) {
      return 10 + 20 * (var1 - 1);
   }

   public int b(int var1) {
      return super.a(var1) + 50;
   }

   public int b() {
      return 2;
   }
}
