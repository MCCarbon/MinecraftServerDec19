package net.minecraft.server;

import net.minecraft.server.class_adi;
import net.minecraft.server.class_adj;
import net.minecraft.server.class_pw;

public class class_adv extends class_adi {
   public class_adv(class_adi.class_a_in_class_adi var1, class_pw... var2) {
      super(var1, class_adj.c, var2);
      this.c("waterWalker");
   }

   public int a(int var1) {
      return var1 * 10;
   }

   public int b(int var1) {
      return this.a(var1) + 15;
   }

   public int b() {
      return 3;
   }
}
