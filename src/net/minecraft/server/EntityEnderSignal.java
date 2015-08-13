package net.minecraft.server;

public class EntityEnderSignal extends Entity {
   private double a;
   private double b;
   private double c;
   private int d;
   private boolean e;

   public EntityEnderSignal(World var1) {
      super(var1);
      this.setSize(0.25F, 0.25F);
   }

   protected void initDatawatcher() {
   }

   public EntityEnderSignal(World var1, double var2, double var4, double var6) {
      super(var1);
      this.d = 0;
      this.setSize(0.25F, 0.25F);
      this.setPosition(var2, var4, var6);
   }

   public void a(BlockPosition var1) {
      double var2 = (double)var1.getX();
      int var4 = var1.getY();
      double var5 = (double)var1.getZ();
      double var7 = var2 - this.locX;
      double var9 = var5 - this.locZ;
      float var11 = MathHelper.sqrt(var7 * var7 + var9 * var9);
      if(var11 > 12.0F) {
         this.a = this.locX + var7 / (double)var11 * 12.0D;
         this.c = this.locZ + var9 / (double)var11 * 12.0D;
         this.b = this.locY + 8.0D;
      } else {
         this.a = var2;
         this.b = (double)var4;
         this.c = var5;
      }

      this.d = 0;
      this.e = this.random.nextInt(5) > 0;
   }

   public void t_() {
      this.P = this.locX;
      this.Q = this.locY;
      this.R = this.locZ;
      super.t_();
      this.locX += this.motX;
      this.locY += this.motY;
      this.locZ += this.motZ;
      float var1 = MathHelper.sqrt(this.motX * this.motX + this.motZ * this.motZ);
      this.yaw = (float)(MathHelper.b(this.motX, this.motZ) * 180.0D / 3.1415927410125732D);

      for(this.pitch = (float)(MathHelper.b(this.motY, (double)var1) * 180.0D / 3.1415927410125732D); this.pitch - this.lastPitch < -180.0F; this.lastPitch -= 360.0F) {
         ;
      }

      while(this.pitch - this.lastPitch >= 180.0F) {
         this.lastPitch += 360.0F;
      }

      while(this.yaw - this.lastYaw < -180.0F) {
         this.lastYaw -= 360.0F;
      }

      while(this.yaw - this.lastYaw >= 180.0F) {
         this.lastYaw += 360.0F;
      }

      this.pitch = this.lastPitch + (this.pitch - this.lastPitch) * 0.2F;
      this.yaw = this.lastYaw + (this.yaw - this.lastYaw) * 0.2F;
      if(!this.world.isClientSide) {
         double var2 = this.a - this.locX;
         double var4 = this.c - this.locZ;
         float var6 = (float)Math.sqrt(var2 * var2 + var4 * var4);
         float var7 = (float)MathHelper.b(var4, var2);
         double var8 = (double)var1 + (double)(var6 - var1) * 0.0025D;
         if(var6 < 1.0F) {
            var8 *= 0.8D;
            this.motY *= 0.8D;
         }

         this.motX = Math.cos((double)var7) * var8;
         this.motZ = Math.sin((double)var7) * var8;
         if(this.locY < this.b) {
            this.motY += (1.0D - this.motY) * 0.014999999664723873D;
         } else {
            this.motY += (-1.0D - this.motY) * 0.014999999664723873D;
         }
      }

      float var10 = 0.25F;
      if(this.V()) {
         for(int var3 = 0; var3 < 4; ++var3) {
            this.world.addParticle(EnumParticle.BUBBLE, this.locX - this.motX * (double)var10, this.locY - this.motY * (double)var10, this.locZ - this.motZ * (double)var10, this.motX, this.motY, this.motZ, new int[0]);
         }
      } else {
         this.world.addParticle(EnumParticle.PORTAL, this.locX - this.motX * (double)var10 + this.random.nextDouble() * 0.6D - 0.3D, this.locY - this.motY * (double)var10 - 0.5D, this.locZ - this.motZ * (double)var10 + this.random.nextDouble() * 0.6D - 0.3D, this.motX, this.motY, this.motZ, new int[0]);
      }

      if(!this.world.isClientSide) {
         this.setPosition(this.locX, this.locY, this.locZ);
         ++this.d;
         if(this.d > 80 && !this.world.isClientSide) {
            this.die();
            if(this.e) {
               this.world.addEntity((Entity)(new EntityItem(this.world, this.locX, this.locY, this.locZ, new ItemStack(Items.ENDER_EYE))));
            } else {
               this.world.b(2003, new BlockPosition(this), 0);
            }
         }
      }

   }

   public void write(NBTTagCompound var1) {
   }

   public void read(NBTTagCompound var1) {
   }

   public float c(float var1) {
      return 1.0F;
   }

   public boolean aF() {
      return false;
   }
}
