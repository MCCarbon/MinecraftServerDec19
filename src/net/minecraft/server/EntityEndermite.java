package net.minecraft.server;

public class EntityEndermite extends EntityMonster {
   private int a = 0;
   private boolean b = false;

   public EntityEndermite(World var1) {
      super(var1);
      this.b_ = 3;
      this.a(0.4F, 0.3F);
      this.i.a(1, new class_rj(this));
      this.i.a(2, new class_ru(this, EntityHuman.class, 1.0D, false));
      this.i.a(3, new class_si(this, 1.0D));
      this.i.a(7, new class_rr(this, EntityHuman.class, 8.0F));
      this.i.a(8, new class_sh(this));
      this.bn.a(1, new class_sw(this, true, new Class[0]));
      this.bn.a(2, new class_sz(this, EntityHuman.class, true));
   }

   public float getHeadHeight() {
      return 0.1F;
   }

   protected void aY() {
      super.aY();
      this.a(class_wl.a).a(8.0D);
      this.a(class_wl.d).a(0.25D);
      this.a(class_wl.e).a(2.0D);
   }

   protected boolean s_() {
      return false;
   }

   protected String C() {
      return "mob.silverfish.say";
   }

   protected String bp() {
      return "mob.silverfish.hit";
   }

   protected String bq() {
      return "mob.silverfish.kill";
   }

   protected void a(BlockPosition var1, Block var2) {
      this.makeSound("mob.silverfish.step", 0.15F, 1.0F);
   }

   protected Item D() {
      return null;
   }

   public void read(NBTTagCompound var1) {
      super.read(var1);
      this.a = var1.getInt("Lifetime");
      this.b = var1.getBoolean("PlayerSpawned");
   }

   public void write(NBTTagCompound var1) {
      super.write(var1);
      var1.put("Lifetime", this.a);
      var1.put("PlayerSpawned", this.b);
   }

   public void t_() {
      this.aL = this.yaw;
      super.t_();
   }

   public boolean n() {
      return this.b;
   }

   public void a(boolean var1) {
      this.b = var1;
   }

   public void m() {
      super.m();
      if(this.world.isClientSide) {
         for(int var1 = 0; var1 < 2; ++var1) {
            this.world.addParticle(EnumParticle.PORTAL, this.locX + (this.random.nextDouble() - 0.5D) * (double)this.width, this.locY + this.random.nextDouble() * (double)this.length, this.locZ + (this.random.nextDouble() - 0.5D) * (double)this.width, (this.random.nextDouble() - 0.5D) * 2.0D, -this.random.nextDouble(), (this.random.nextDouble() - 0.5D) * 2.0D, new int[0]);
         }
      } else {
         if(!this.cn()) {
            ++this.a;
         }

         if(this.a >= 2400) {
            this.J();
         }
      }

   }

   protected boolean n_() {
      return true;
   }

   public boolean cf() {
      if(super.cf()) {
         EntityHuman var1 = this.world.a(this, 5.0D);
         return var1 == null;
      } else {
         return false;
      }
   }

   public class_qf bz() {
      return class_qf.c;
   }
}
