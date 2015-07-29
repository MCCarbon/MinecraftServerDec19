package net.minecraft.server;

import net.minecraft.server.class_pk;
import net.minecraft.server.class_qm;

public class class_ph extends class_pk {
   protected final double a;

   protected class_ph(boolean var1, int var2, double var3) {
      super(var1, var2);
      this.a = var3;
   }

   public double a(int var1, class_qm var2) {
      return this.a * (double)(var1 + 1);
   }
}
