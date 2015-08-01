package net.minecraft.server;

import net.minecraft.server.EntityLiving;
import net.minecraft.server.class_td;
import net.minecraft.server.class_tp;
import net.minecraft.server.class_uj;
import net.minecraft.server.class_wa;

public class class_sv extends class_td {
   class_uj a;
   EntityLiving b;

   public class_sv(class_uj var1) {
      super(var1, false, true);
      this.a = var1;
      this.a(1);
   }

   public boolean a() {
      class_tp var1 = this.a.n();
      if(var1 == null) {
         return false;
      } else {
         this.b = var1.b((EntityLiving)this.a);
         if(this.b instanceof class_wa) {
            return false;
         } else if(!this.a(this.b, false)) {
            if(this.e.bd().nextInt(20) == 0) {
               this.b = var1.c((EntityLiving)this.a);
               return this.a(this.b, false);
            } else {
               return false;
            }
         } else {
            return true;
         }
      }
   }

   public void c() {
      this.a.d(this.b);
      super.c();
   }
}
