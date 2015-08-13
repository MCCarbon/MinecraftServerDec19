package net.minecraft.server;

public class EntityTNTPrimed extends Entity {
   public int a;
   private EntityLiving b;

   public EntityTNTPrimed(World var1) {
      super(var1);
      this.k = true;
      this.setSize(0.98F, 0.98F);
   }

   public EntityTNTPrimed(World var1, double var2, double var4, double var6, EntityLiving var8) {
      this(var1);
      this.setPosition(var2, var4, var6);
      float var9 = (float)(Math.random() * 3.1415927410125732D * 2.0D);
      this.motX = (double)(-((float)Math.sin((double)var9)) * 0.02F);
      this.motY = 0.20000000298023224D;
      this.motZ = (double)(-((float)Math.cos((double)var9)) * 0.02F);
      this.a = 80;
      this.lastX = var2;
      this.lastY = var4;
      this.lastZ = var6;
      this.b = var8;
   }

   protected void initDatawatcher() {
   }

   protected boolean s_() {
      return false;
   }

   public boolean ad() {
      return !this.dead;
   }

   public void t_() {
      this.lastX = this.locX;
      this.lastY = this.locY;
      this.lastZ = this.locZ;
      this.motY -= 0.03999999910593033D;
      this.d(this.motX, this.motY, this.motZ);
      this.motX *= 0.9800000190734863D;
      this.motY *= 0.9800000190734863D;
      this.motZ *= 0.9800000190734863D;
      if(this.onGround) {
         this.motX *= 0.699999988079071D;
         this.motZ *= 0.699999988079071D;
         this.motY *= -0.5D;
      }

      if(this.a-- <= 0) {
         this.die();
         if(!this.world.isClientSide) {
            this.l();
         }
      } else {
         this.W();
         this.world.addParticle(EnumParticle.SMOKE, this.locX, this.locY + 0.5D, this.locZ, 0.0D, 0.0D, 0.0D, new int[0]);
      }

   }

   private void l() {
      float var1 = 4.0F;
      this.world.a(this, this.locX, this.locY + (double)(this.length / 16.0F), this.locZ, var1, true);
   }

   protected void write(NBTTagCompound var1) {
      var1.put("Fuse", (byte)this.a);
   }

   protected void read(NBTTagCompound var1) {
      this.a = var1.getByte("Fuse");
   }

   public EntityLiving getSource() {
      return this.b;
   }

   public float getHeadHeight() {
      return 0.0F;
   }
}
