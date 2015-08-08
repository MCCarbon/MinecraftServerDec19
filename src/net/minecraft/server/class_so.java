package net.minecraft.server;

import net.minecraft.server.EntityLiving;
import net.minecraft.server.EntityTameable;
import net.minecraft.server.class_rm;

public class class_so extends class_rm {
   private EntityTameable a;
   private boolean b;

   public class_so(EntityTameable var1) {
      this.a = var1;
      this.a(5);
   }

   public boolean a() {
      if(!this.a.cA()) {
         return false;
      } else if(this.a.V()) {
         return false;
      } else if(!this.a.onGround) {
         return false;
      } else {
         EntityLiving var1 = this.a.cD();
         return var1 == null?true:(this.a.h(var1) < 144.0D && var1.be() != null?false:this.b);
      }
   }

   public void c() {
      this.a.u().n();
      this.a.o(true);
   }

   public void d() {
      this.a.o(false);
   }

   public void a(boolean var1) {
      this.b = var1;
   }
}
