package net.minecraft.server;

public class class_qy {
   private EntityInsentient a;
   private float b;
   private float c;
   private boolean d;
   private double e;
   private double f;
   private double g;

   public class_qy(EntityInsentient var1) {
      this.a = var1;
   }

   public void a(Entity var1, float var2, float var3) {
      this.e = var1.s;
      if(var1 instanceof EntityLiving) {
         this.f = var1.t + (double)var1.aU();
      } else {
         this.f = (var1.aT().yMin + var1.aT().yMax) / 2.0D;
      }

      this.g = var1.u;
      this.b = var2;
      this.c = var3;
      this.d = true;
   }

   public void a(double var1, double var3, double var5, float var7, float var8) {
      this.e = var1;
      this.f = var3;
      this.g = var5;
      this.b = var7;
      this.c = var8;
      this.d = true;
   }

   public void a() {
      this.a.z = 0.0F;
      if(this.d) {
         this.d = false;
         double var1 = this.e - this.a.s;
         double var3 = this.f - (this.a.t + (double)this.a.aU());
         double var5 = this.g - this.a.u;
         double var7 = (double)MathHelper.sqrt(var1 * var1 + var5 * var5);
         float var9 = (float)(MathHelper.b(var5, var1) * 180.0D / 3.1415927410125732D) - 90.0F;
         float var10 = (float)(-(MathHelper.b(var3, var7) * 180.0D / 3.1415927410125732D));
         this.a.z = this.a(this.a.z, var10, this.c);
         this.a.aN = this.a(this.a.aN, var9, this.b);
      } else {
         this.a.aN = this.a(this.a.aN, this.a.aL, 10.0F);
      }

      float var11 = MathHelper.clampAngle(this.a.aN - this.a.aL);
      if(!this.a.u().m()) {
         if(var11 < -75.0F) {
            this.a.aN = this.a.aL - 75.0F;
         }

         if(var11 > 75.0F) {
            this.a.aN = this.a.aL + 75.0F;
         }
      }

   }

   private float a(float var1, float var2, float var3) {
      float var4 = MathHelper.clampAngle(var2 - var1);
      if(var4 > var3) {
         var4 = var3;
      }

      if(var4 < -var3) {
         var4 = -var3;
      }

      return var1 + var4;
   }

   public boolean b() {
      return this.d;
   }

   public double e() {
      return this.e;
   }

   public double f() {
      return this.f;
   }

   public double g() {
      return this.g;
   }
}
