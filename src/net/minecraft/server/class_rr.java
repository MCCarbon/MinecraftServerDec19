package net.minecraft.server;

public class class_rr extends class_rm {
   protected EntityInsentient a;
   protected Entity b;
   protected float c;
   private int e;
   private float f;
   protected Class d;

   public class_rr(EntityInsentient var1, Class var2, float var3) {
      this.a = var1;
      this.d = var2;
      this.c = var3;
      this.f = 0.02F;
      this.a(2);
   }

   public class_rr(EntityInsentient var1, Class var2, float var3, float var4) {
      this.a = var1;
      this.d = var2;
      this.c = var3;
      this.f = var4;
      this.a(2);
   }

   public boolean a() {
      if(this.a.getRandom().nextFloat() >= this.f) {
         return false;
      } else {
         if(this.a.w() != null) {
            this.b = this.a.w();
         }

         if(this.d == EntityHuman.class) {
            this.b = this.a.world.a(this.a, (double)this.c);
         } else {
            this.b = this.a.world.a((Class)this.d, (AxisAlignedBB)this.a.getBoundingBox().grow((double)this.c, 3.0D, (double)this.c), (Entity)this.a);
         }

         return this.b != null;
      }
   }

   public boolean b() {
      return !this.b.isAlive()?false:(this.a.h(this.b) > (double)(this.c * this.c)?false:this.e > 0);
   }

   public void c() {
      this.e = 40 + this.a.getRandom().nextInt(40);
   }

   public void d() {
      this.b = null;
   }

   public void e() {
      this.a.q().a(this.b.locX, this.b.locY + (double)this.b.getHeadHeight(), this.b.locZ, (float)this.a.ce(), (float)this.a.cd());
      --this.e;
   }
}
