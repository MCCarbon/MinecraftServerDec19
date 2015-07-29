package net.minecraft.server;

import net.minecraft.server.class_aan;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_om;
import net.minecraft.server.class_pc;
import net.minecraft.server.class_xa;

public class class_xx {
   private int a = 20;
   private float b = 5.0F;
   private float c;
   private int d;
   private int e = 20;

   public void a(int var1, float var2) {
      this.a = Math.min(var1 + this.a, 20);
      this.b = Math.min(this.b + (float)var1 * var2 * 2.0F, (float)this.a);
   }

   public void a(class_aan var1, class_aas var2) {
      this.a(var1.h(var2), var1.i(var2));
   }

   public void a(class_xa var1) {
      class_om var2 = var1.o.ab();
      this.e = this.a;
      if(this.c > 4.0F) {
         this.c -= 4.0F;
         if(this.b > 0.0F) {
            this.b = Math.max(this.b - 1.0F, 0.0F);
         } else if(var2 != class_om.a) {
            this.a = Math.max(this.a - 1, 0);
         }
      }

      if(var1.o.R().b("naturalRegeneration") && this.a >= 18 && var1.co()) {
         ++this.d;
         if(this.d >= 80) {
            var1.h(1.0F);
            this.a(3.0F);
            this.d = 0;
         }
      } else if(this.a <= 0) {
         ++this.d;
         if(this.d >= 80) {
            if(var1.bo() > 10.0F || var2 == class_om.d || var1.bo() > 1.0F && var2 == class_om.c) {
               var1.a(class_pc.g, 1.0F);
            }

            this.d = 0;
         }
      } else {
         this.d = 0;
      }

   }

   public void a(class_dn var1) {
      if(var1.b("foodLevel", 99)) {
         this.a = var1.g("foodLevel");
         this.d = var1.g("foodTickTimer");
         this.b = var1.i("foodSaturationLevel");
         this.c = var1.i("foodExhaustionLevel");
      }

   }

   public void b(class_dn var1) {
      var1.a("foodLevel", this.a);
      var1.a("foodTickTimer", this.d);
      var1.a("foodSaturationLevel", this.b);
      var1.a("foodExhaustionLevel", this.c);
   }

   public int a() {
      return this.a;
   }

   public boolean c() {
      return this.a < 20;
   }

   public void a(float var1) {
      this.c = Math.min(this.c + var1, 40.0F);
   }

   public float e() {
      return this.b;
   }

   public void a(int var1) {
      this.a = var1;
   }
}
