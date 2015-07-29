package net.minecraft.server;

import net.minecraft.server.class_qb;
import net.minecraft.server.class_rm;

public class class_sh extends class_rm {
   private class_qb a;
   private double b;
   private double c;
   private int d;

   public class_sh(class_qb var1) {
      this.a = var1;
      this.a(3);
   }

   public boolean a() {
      return this.a.bd().nextFloat() < 0.02F;
   }

   public boolean b() {
      return this.d >= 0;
   }

   public void c() {
      double var1 = 6.283185307179586D * this.a.bd().nextDouble();
      this.b = Math.cos(var1);
      this.c = Math.sin(var1);
      this.d = 20 + this.a.bd().nextInt(20);
   }

   public void e() {
      --this.d;
      this.a.q().a(this.a.s + this.b, this.a.t + (double)this.a.aU(), this.a.u + this.c, (float)this.a.ce(), (float)this.a.cd());
   }
}
