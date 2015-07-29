package net.minecraft.server;

import net.minecraft.server.class_qb;
import net.minecraft.server.class_rm;
import net.minecraft.server.class_tf;

public class class_rj extends class_rm {
   private class_qb a;

   public class_rj(class_qb var1) {
      this.a = var1;
      this.a(4);
      ((class_tf)var1.u()).d(true);
   }

   public boolean a() {
      return this.a.V() || this.a.ab();
   }

   public void e() {
      if(this.a.bd().nextFloat() < 0.8F) {
         this.a.t().a();
      }

   }
}
