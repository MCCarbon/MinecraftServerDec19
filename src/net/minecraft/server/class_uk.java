package net.minecraft.server;

public abstract class class_uk extends EntityInsentient implements class_pp {
   public class_uk(World var1) {
      super(var1);
   }

   public boolean aZ() {
      return true;
   }

   public boolean cf() {
      return true;
   }

   public boolean cg() {
      return this.world.a((AxisAlignedBB)this.getBoundingBox(), (Entity)this);
   }

   public int y() {
      return 120;
   }

   protected boolean E() {
      return true;
   }

   protected int b(EntityHuman var1) {
      return 1 + this.world.random.nextInt(3);
   }

   public void K() {
      int var1 = this.aB();
      super.K();
      if(this.isAlive() && !this.V()) {
         --var1;
         this.i(var1);
         if(this.aB() == -20) {
            this.i(0);
            this.damageEntity(DamageSource.f, 2.0F);
         }
      } else {
         this.i(300);
      }

   }

   public boolean aN() {
      return false;
   }
}
