package net.minecraft.server;

import net.minecraft.server.class_rm;
import net.minecraft.server.class_wv;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xz;

public class class_ss extends class_rm {
   private class_wv a;

   public class_ss(class_wv var1) {
      this.a = var1;
      this.a(5);
   }

   public boolean a() {
      if(!this.a.ai()) {
         return false;
      } else if(this.a.V()) {
         return false;
      } else if(!this.a.C) {
         return false;
      } else if(this.a.G) {
         return false;
      } else {
         class_xa var1 = this.a.v_();
         return var1 == null?false:(this.a.h(var1) > 16.0D?false:var1.br instanceof class_xz);
      }
   }

   public void c() {
      this.a.u().n();
   }

   public void d() {
      this.a.a((class_xa)null);
   }
}
