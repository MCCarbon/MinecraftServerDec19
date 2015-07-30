package net.minecraft.server;

import net.minecraft.server.class_amg;
import net.minecraft.server.class_dn;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.class_fa;
import net.minecraft.server.class_fb;
import net.minecraft.server.class_op;
import net.minecraft.server.class_ot;
import net.minecraft.server.class_ou;

public abstract class class_amu extends class_amg implements class_op, class_ou {
   private class_ot a;

   public class_amu() {
      this.a = class_ot.a;
   }

   public void a(class_dn var1) {
      super.a(var1);
      this.a = class_ot.b(var1);
   }

   public void b(class_dn var1) {
      super.b(var1);
      if(this.a != null) {
         this.a.a(var1);
      }

   }

   public boolean r_() {
      return this.a != null && !this.a.a();
   }

   public class_ot i() {
      return this.a;
   }

   public void a(class_ot var1) {
      this.a = var1;
   }

   public IChatBaseComponent f_() {
      return (IChatBaseComponent)(this.l_()?new class_fa(this.e_()):new class_fb(this.e_(), new Object[0]));
   }
}
