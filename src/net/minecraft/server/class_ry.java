package net.minecraft.server;

import net.minecraft.server.class_awh;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_qh;
import net.minecraft.server.class_rm;
import net.minecraft.server.class_tm;

public class class_ry extends class_rm {
   private class_qh a;
   private double b;
   private double c;
   private double d;
   private double e;

   public class_ry(class_qh var1, double var2) {
      this.a = var1;
      this.e = var2;
      this.a(1);
   }

   public boolean a() {
      if(this.a.cv()) {
         return false;
      } else {
         class_cj var1 = this.a.cw();
         class_awh var2 = class_tm.a(this.a, 16, 7, new class_awh((double)var1.n(), (double)var1.o(), (double)var1.p()));
         if(var2 == null) {
            return false;
         } else {
            this.b = var2.a;
            this.c = var2.b;
            this.d = var2.c;
            return true;
         }
      }
   }

   public boolean b() {
      return !this.a.u().m();
   }

   public void c() {
      this.a.u().a(this.b, this.c, this.d, this.e);
   }
}
