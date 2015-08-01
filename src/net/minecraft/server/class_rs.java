package net.minecraft.server;

import net.minecraft.server.class_rr;
import net.minecraft.server.class_wv;
import net.minecraft.server.EntityHuman;

public class class_rs extends class_rr {
   private final class_wv e;

   public class_rs(class_wv var1) {
      super(var1, EntityHuman.class, 8.0F);
      this.e = var1;
   }

   public boolean a() {
      if(this.e.cD()) {
         this.b = this.e.v_();
         return true;
      } else {
         return false;
      }
   }
}
