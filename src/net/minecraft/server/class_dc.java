package net.minecraft.server;

import net.minecraft.server.class_dr;
import net.minecraft.server.class_du;
import net.minecraft.server.class_eb;

public class class_dc {
   protected final float a;
   protected final float b;
   protected final float c;

   public class_dc(float var1, float var2, float var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public class_dc(class_du var1) {
      this.a = var1.f(0);
      this.b = var1.f(1);
      this.c = var1.f(2);
   }

   public class_du a() {
      class_du var1 = new class_du();
      var1.a((class_eb)(new class_dr(this.a)));
      var1.a((class_eb)(new class_dr(this.b)));
      var1.a((class_eb)(new class_dr(this.c)));
      return var1;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class_dc)) {
         return false;
      } else {
         class_dc var2 = (class_dc)var1;
         return this.a == var2.a && this.b == var2.b && this.c == var2.c;
      }
   }

   public float b() {
      return this.a;
   }

   public float c() {
      return this.b;
   }

   public float d() {
      return this.c;
   }
}
