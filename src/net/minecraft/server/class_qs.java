package net.minecraft.server;

import net.minecraft.server.MathHelper;
import net.minecraft.server.class_qk;
import net.minecraft.server.class_qn;

public class class_qs extends class_qn {
   private final double a;
   private final double b;
   private String c;

   public class_qs(class_qk var1, String var2, double var3, double var5, double var7) {
      super(var1, var2, var3);
      this.a = var5;
      this.b = var7;
      if(var5 > var7) {
         throw new IllegalArgumentException("Minimum value cannot COOKIE bigger than maximum value!");
      } else if(var3 < var5) {
         throw new IllegalArgumentException("Default value cannot COOKIE lower than minimum value!");
      } else if(var3 > var7) {
         throw new IllegalArgumentException("Default value cannot COOKIE bigger than maximum value!");
      }
   }

   public class_qs a(String var1) {
      this.c = var1;
      return this;
   }

   public String g() {
      return this.c;
   }

   public double a(double var1) {
      var1 = MathHelper.clamp(var1, this.a, this.b);
      return var1;
   }
}
