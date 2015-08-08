package net.minecraft.server;

public class class_ti extends class_tg {
   public class_ti(EntityInsentient var1, World var2) {
      super(var1, var2);
   }

   protected class_auw a() {
      return new class_auw(new class_auy());
   }

   protected boolean b() {
      return this.o();
   }

   protected Vec3D c() {
      return new Vec3D(this.b.locX, this.b.locY + (double)this.b.length * 0.5D, this.b.locZ);
   }

   protected void l() {
      Vec3D var1 = this.c();
      float var2 = this.b.width * this.b.width;
      byte var3 = 6;
      if(var1.distanceSquared(this.d.a(this.b, this.d.e())) < (double)var2) {
         this.d.a();
      }

      for(int var4 = Math.min(this.d.e() + var3, this.d.d() - 1); var4 > this.d.e(); --var4) {
         Vec3D var5 = this.d.a(this.b, var4);
         if(var5.distanceSquared(var1) <= 36.0D && this.a(var1, var5, 0, 0, 0)) {
            this.d.c(var4);
            break;
         }
      }

      this.a(var1);
   }

   protected void d() {
      super.d();
   }

   protected boolean a(Vec3D var1, Vec3D var2, int var3, int var4, int var5) {
      MovingObjectPosition var6 = this.c.rayTrace(var1, new Vec3D(var2.x, var2.y + (double)this.b.length * 0.5D, var2.z), false, true, false);
      return var6 == null || var6.a == MovingObjectPosition.class_a_in_class_awg.a;
   }
}
