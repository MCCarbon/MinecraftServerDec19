package net.minecraft.server;

import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_qh;
import net.minecraft.server.class_rm;
import net.minecraft.server.class_tf;
import net.minecraft.server.class_to;
import net.minecraft.server.class_tp;

public class class_sl extends class_rm {
   private class_qh a;
   private class_to b;

   public class_sl(class_qh var1) {
      this.a = var1;
      if(!(var1.u() instanceof class_tf)) {
         throw new IllegalArgumentException("Unsupported mob type for RestrictOpenDoorGoal");
      }
   }

   public boolean a() {
      if(this.a.o.x()) {
         return false;
      } else {
         BlockPosition var1 = new BlockPosition(this.a);
         class_tp var2 = this.a.o.af().a(var1, 16);
         if(var2 == null) {
            return false;
         } else {
            this.b = var2.b(var1);
            return this.b == null?false:(double)this.b.b(var1) < 2.25D;
         }
      }
   }

   public boolean b() {
      return this.a.o.x()?false:!this.b.i() && this.b.c(new BlockPosition(this.a));
   }

   public void c() {
      ((class_tf)this.a.u()).b(false);
      ((class_tf)this.a.u()).c(false);
   }

   public void d() {
      ((class_tf)this.a.u()).b(true);
      ((class_tf)this.a.u()).c(true);
      this.b = null;
   }

   public void e() {
      this.b.b();
   }
}
