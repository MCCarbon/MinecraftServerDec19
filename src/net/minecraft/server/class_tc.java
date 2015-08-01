package net.minecraft.server;

import net.minecraft.server.EntityLiving;
import net.minecraft.server.class_qj;
import net.minecraft.server.class_td;

public class class_tc extends class_td {
   class_qj a;
   EntityLiving b;
   private int c;

   public class_tc(class_qj var1) {
      super(var1, false);
      this.a = var1;
      this.a(1);
   }

   public boolean a() {
      if(!this.a.cA()) {
         return false;
      } else {
         EntityLiving var1 = this.a.cD();
         if(var1 == null) {
            return false;
         } else {
            this.b = var1.bg();
            int var2 = var1.bh();
            return var2 != this.c && this.a(this.b, false) && this.a.a(this.b, var1);
         }
      }
   }

   public void c() {
      this.e.d(this.b);
      EntityLiving var1 = this.a.cD();
      if(var1 != null) {
         this.c = var1.bh();
      }

      super.c();
   }
}
