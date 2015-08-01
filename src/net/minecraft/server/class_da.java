package net.minecraft.server;

import net.minecraft.server.class_cz;

public class class_da implements class_cz {
   protected final double a;
   protected final double b;
   protected final double c;

   public class_da(double var1, double var3, double var5) {
      this.a = var1;
      this.b = var3;
      this.c = var5;
   }

   public double getX() {
      return this.a;
   }

   public double getY() {
      return this.b;
   }

   public double getZ() {
      return this.c;
   }
}
