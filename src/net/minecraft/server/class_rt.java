package net.minecraft.server;

public class class_rt extends class_rm {
   private EntityVillager b;
   private EntityVillager c;
   private World d;
   private int e;
   class_tp a;

   public class_rt(EntityVillager var1) {
      this.b = var1;
      this.d = var1.world;
      this.a(3);
   }

   public boolean a() {
      if(this.b.getAge() != 0) {
         return false;
      } else if(this.b.getRandom().nextInt(500) != 0) {
         return false;
      } else {
         this.a = this.d.af().a(new BlockPosition(this.b), 0);
         if(this.a == null) {
            return false;
         } else if(this.f() && this.b.o(true)) {
            Entity var1 = this.d.a((Class)EntityVillager.class, (AxisAlignedBB)this.b.getBoundingBox().grow(8.0D, 3.0D, 8.0D), (Entity)this.b);
            if(var1 == null) {
               return false;
            } else {
               this.c = (EntityVillager)var1;
               return this.c.getAge() == 0 && this.c.o(true);
            }
         } else {
            return false;
         }
      }
   }

   public void c() {
      this.e = 300;
      this.b.m(true);
   }

   public void d() {
      this.a = null;
      this.c = null;
      this.b.m(false);
   }

   public boolean b() {
      return this.e >= 0 && this.f() && this.b.getAge() == 0 && this.b.o(false);
   }

   public void e() {
      --this.e;
      this.b.q().a(this.c, 10.0F, 30.0F);
      if(this.b.h(this.c) > 2.25D) {
         this.b.u().a((Entity)this.c, 0.25D);
      } else if(this.e == 0 && this.c.cB()) {
         this.g();
      }

      if(this.b.getRandom().nextInt(35) == 0) {
         this.d.a((Entity)this.b, (byte)12);
      }

   }

   private boolean f() {
      if(!this.a.i()) {
         return false;
      } else {
         int var1 = (int)((double)((float)this.a.c()) * 0.35D);
         return this.a.e() < var1;
      }
   }

   private void g() {
      EntityVillager var1 = this.b.b((EntityAgeable)this.c);
      this.c.b(6000);
      this.b.b(6000);
      this.c.p(false);
      this.b.p(false);
      var1.b(-24000);
      var1.b(this.b.locX, this.b.locY, this.b.locZ, 0.0F, 0.0F);
      this.d.addEntity((Entity)var1);
      this.d.a((Entity)var1, (byte)12);
   }
}
