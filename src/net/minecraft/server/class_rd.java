package net.minecraft.server;

public class class_rd extends class_rg {
   private int g;
   private int h = -1;

   public class_rd(EntityInsentient var1) {
      super(var1);
   }

   public boolean a() {
      if(!super.a()) {
         return false;
      } else if(!this.a.o.R().getBooleanValue("mobGriefing")) {
         return false;
      } else {
         BlockDoor var10000 = this.c;
         return !BlockDoor.f(this.a.o, this.b);
      }
   }

   public void c() {
      super.c();
      this.g = 0;
   }

   public boolean b() {
      double var1 = this.a.b((BlockPosition)this.b);
      boolean var3;
      if(this.g <= 240) {
         BlockDoor var10000 = this.c;
         if(!BlockDoor.f(this.a.o, this.b) && var1 < 4.0D) {
            var3 = true;
            return var3;
         }
      }

      var3 = false;
      return var3;
   }

   public void d() {
      super.d();
      this.a.o.c(this.a.getId(), this.b, -1);
   }

   public void e() {
      super.e();
      if(this.a.bd().nextInt(20) == 0) {
         this.a.o.b(1010, this.b, 0);
      }

      ++this.g;
      int var1 = (int)((float)this.g / 240.0F * 10.0F);
      if(var1 != this.h) {
         this.a.o.c(this.a.getId(), this.b, var1);
         this.h = var1;
      }

      if(this.g == 240 && this.a.o.ab() == class_om.d) {
         this.a.o.setAir(this.b);
         this.a.o.b(1012, this.b, 0);
         this.a.o.b(2001, this.b, Block.getId((Block)this.c));
      }

   }
}
