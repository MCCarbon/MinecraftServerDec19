package net.minecraft.server;

import net.minecraft.server.class_adi;
import net.minecraft.server.class_adj;
import net.minecraft.server.class_pw;

public class class_adw extends class_adi {
   public class_adw(class_adi.class_a_in_class_adi var1, class_pw... var2) {
      super(var1, class_adj.f, var2);
      this.c("waterWorker");
   }

   public int a(int var1) {
      return 1;
   }

   public int b(int var1) {
      return this.a(var1) + 40;
   }

   public int b() {
      return 1;
   }
}
