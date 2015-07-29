package net.minecraft.server;

import net.minecraft.server.class_adi;
import net.minecraft.server.class_adj;
import net.minecraft.server.class_pw;

public class class_ado extends class_adi {
   protected class_ado(class_adi.class_a_in_class_adi var1, class_adj var2, class_pw... var3) {
      super(var1, var2, var3);
      this.c("fishingSpeed");
   }

   public int a(int var1) {
      return 15 + (var1 - 1) * 9;
   }

   public int b(int var1) {
      return super.a(var1) + 50;
   }

   public int b() {
      return 3;
   }
}
