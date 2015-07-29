package net.minecraft.server;

import net.minecraft.server.class_awh;
import net.minecraft.server.class_qa;
import net.minecraft.server.class_qh;
import net.minecraft.server.class_rm;
import net.minecraft.server.class_tm;

public class class_rz extends class_rm {
   private class_qh a;
   private class_qa b;
   private double c;
   private double d;
   private double e;
   private double f;
   private float g;

   public class_rz(class_qh var1, double var2, float var4) {
      this.a = var1;
      this.f = var2;
      this.g = var4;
      this.a(1);
   }

   public boolean a() {
      this.b = this.a.w();
      if(this.b == null) {
         return false;
      } else if(this.b.h(this.a) > (double)(this.g * this.g)) {
         return false;
      } else {
         class_awh var1 = class_tm.a(this.a, 16, 7, new class_awh(this.b.s, this.b.t, this.b.u));
         if(var1 == null) {
            return false;
         } else {
            this.c = var1.a;
            this.d = var1.b;
            this.e = var1.c;
            return true;
         }
      }
   }

   public boolean b() {
      return !this.a.u().m() && this.b.ai() && this.b.h(this.a) < (double)(this.g * this.g);
   }

   public void d() {
      this.b = null;
   }

   public void c() {
      this.a.u().a(this.c, this.d, this.e, this.f);
   }
}
