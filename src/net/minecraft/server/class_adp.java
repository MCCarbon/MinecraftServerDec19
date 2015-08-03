package net.minecraft.server;

public class class_adp extends class_adi {
   protected class_adp(class_adi.class_a_in_class_adi var1, EnumWearable... var2) {
      super(var1, class_adj.g, var2);
      this.c("knockback");
   }

   public int a(int var1) {
      return 5 + 20 * (var1 - 1);
   }

   public int b(int var1) {
      return super.a(var1) + 50;
   }

   public int b() {
      return 2;
   }
}
