package net.minecraft.server;

public class class_sh extends class_rm {
   private EntityInsentient a;
   private double b;
   private double c;
   private int d;

   public class_sh(EntityInsentient var1) {
      this.a = var1;
      this.a(3);
   }

   public boolean a() {
      return this.a.getRandom().nextFloat() < 0.02F;
   }

   public boolean b() {
      return this.d >= 0;
   }

   public void c() {
      double var1 = 6.283185307179586D * this.a.getRandom().nextDouble();
      this.b = Math.cos(var1);
      this.c = Math.sin(var1);
      this.d = 20 + this.a.getRandom().nextInt(20);
   }

   public void e() {
      --this.d;
      this.a.q().a(this.a.locX + this.b, this.a.locY + (double)this.a.aU(), this.a.locZ + this.c, (float)this.a.ce(), (float)this.a.cd());
   }
}
