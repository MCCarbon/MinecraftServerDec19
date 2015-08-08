package net.minecraft.server;

public abstract class EntityMonster extends EntityCreature implements class_wd {
   public EntityMonster(World var1) {
      super(var1);
      this.b_ = 5;
   }

   public void m() {
      this.bx();
      float var1 = this.c(1.0F);
      if(var1 > 0.5F) {
         this.aT += 2;
      }

      super.m();
   }

   public void t_() {
      super.t_();
      if(!this.world.isClientSide && this.world.ab() == class_om.a) {
         this.J();
      }

   }

   protected String P() {
      return "game.hostile.swim";
   }

   protected String aa() {
      return "game.hostile.swim.splash";
   }

   public boolean damageEntity(DamageSource var1, float var2) {
      if(this.b(var1)) {
         return false;
      } else if(super.damageEntity(var1, var2)) {
         Entity var3 = var1.j();
         return this.passenger != var3 && this.vehicle != var3?true:true;
      } else {
         return false;
      }
   }

   protected String bp() {
      return "game.hostile.hurt";
   }

   protected String bq() {
      return "game.hostile.die";
   }

   protected String k(int var1) {
      return var1 > 4?"game.hostile.hurt.fall.big":"game.hostile.hurt.fall.small";
   }

   public boolean r(Entity var1) {
      float var2 = (float)this.a(class_wl.e).e();
      int var3 = 0;
      if(var1 instanceof EntityLiving) {
         var2 += EnchantmentManager.a(this.bA(), ((EntityLiving)var1).bz());
         var3 += EnchantmentManager.a((EntityLiving)this);
      }

      boolean var4 = var1.damageEntity(DamageSource.a((EntityLiving) this), var2);
      if(var4) {
         if(var3 > 0) {
            var1.g((double)(-MathHelper.sin(this.yaw * 3.1415927F / 180.0F) * (float)var3 * 0.5F), 0.1D, (double)(MathHelper.cos(this.yaw * 3.1415927F / 180.0F) * (float)var3 * 0.5F));
            this.motX *= 0.6D;
            this.motZ *= 0.6D;
         }

         int var5 = EnchantmentManager.b(this);
         if(var5 > 0) {
            var1.f(var5 * 4);
         }

         this.a(this, var1);
      }

      return var4;
   }

   public float a(BlockPosition var1) {
      return 0.5F - this.world.o(var1);
   }

   protected boolean n_() {
      BlockPosition var1 = new BlockPosition(this.locX, this.getBoundingBox().yMin, this.locZ);
      if(this.world.b(class_aet.a, var1) > this.random.nextInt(32)) {
         return false;
      } else {
         int var2 = this.world.l(var1);
         if(this.world.S()) {
            int var3 = this.world.ac();
            this.world.c(10);
            var2 = this.world.l(var1);
            this.world.c(var3);
         }

         return var2 <= this.random.nextInt(8);
      }
   }

   public boolean cf() {
      return this.world.ab() != class_om.a && this.n_() && super.cf();
   }

   protected void aY() {
      super.aY();
      this.by().b(class_wl.e);
   }

   protected boolean bb() {
      return true;
   }
}
