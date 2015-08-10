package net.minecraft.server;

public abstract class EntityFireball extends Entity {
   private int e = -1;
   private int f = -1;
   private int g = -1;
   private Block h;
   private boolean i;
   public EntityLiving a;
   private int as;
   private int at;
   public double b;
   public double c;
   public double d;

   public EntityFireball(World var1) {
      super(var1);
      this.setSize(1.0F, 1.0F);
   }

   protected void initDatawatcher() {
   }

   public EntityFireball(World var1, double var2, double var4, double var6, double var8, double var10, double var12) {
      super(var1);
      this.setSize(1.0F, 1.0F);
      this.b(var2, var4, var6, this.yaw, this.pitch);
      this.setPosition(var2, var4, var6);
      double var14 = (double)MathHelper.sqrt(var8 * var8 + var10 * var10 + var12 * var12);
      this.b = var8 / var14 * 0.1D;
      this.c = var10 / var14 * 0.1D;
      this.d = var12 / var14 * 0.1D;
   }

   public EntityFireball(World var1, EntityLiving var2, double var3, double var5, double var7) {
      super(var1);
      this.a = var2;
      this.setSize(1.0F, 1.0F);
      this.b(var2.locX, var2.locY, var2.locZ, var2.yaw, var2.pitch);
      this.setPosition(this.locX, this.locY, this.locZ);
      this.motX = this.motY = this.motZ = 0.0D;
      var3 += this.random.nextGaussian() * 0.4D;
      var5 += this.random.nextGaussian() * 0.4D;
      var7 += this.random.nextGaussian() * 0.4D;
      double var9 = (double)MathHelper.sqrt(var3 * var3 + var5 * var5 + var7 * var7);
      this.b = var3 / var9 * 0.1D;
      this.c = var5 / var9 * 0.1D;
      this.d = var7 / var9 * 0.1D;
   }

   public void t_() {
      if(this.world.isClientSide || (this.a == null || !this.a.dead) && this.world.isLoaded(new BlockPosition(this))) {
         super.t_();
         this.f(1);
         if(this.i) {
            if(this.world.getType(new BlockPosition(this.e, this.f, this.g)).getBlock() == this.h) {
               ++this.as;
               if(this.as == 600) {
                  this.die();
               }

               return;
            }

            this.i = false;
            this.motX *= (double)(this.random.nextFloat() * 0.2F);
            this.motY *= (double)(this.random.nextFloat() * 0.2F);
            this.motZ *= (double)(this.random.nextFloat() * 0.2F);
            this.as = 0;
            this.at = 0;
         } else {
            ++this.at;
         }

         MovingObjectPosition var1 = class_xj.a(this, true, this.at >= 25, this.a);
         if(var1 != null) {
            this.a(var1);
         }

         this.locX += this.motX;
         this.locY += this.motY;
         this.locZ += this.motZ;
         class_xj.a(this, 0.2F);
         float var2 = this.j();
         if(this.V()) {
            for(int var3 = 0; var3 < 4; ++var3) {
               float var4 = 0.25F;
               this.world.addParticle(EnumParticle.e, this.locX - this.motX * (double)var4, this.locY - this.motY * (double)var4, this.locZ - this.motZ * (double)var4, this.motX, this.motY, this.motZ, new int[0]);
            }

            var2 = 0.8F;
         }

         this.motX += this.b;
         this.motY += this.c;
         this.motZ += this.d;
         this.motX *= (double)var2;
         this.motY *= (double)var2;
         this.motZ *= (double)var2;
         this.world.addParticle(EnumParticle.l, this.locX, this.locY + 0.5D, this.locZ, 0.0D, 0.0D, 0.0D, new int[0]);
         this.setPosition(this.locX, this.locY, this.locZ);
      } else {
         this.die();
      }
   }

   protected float j() {
      return 0.95F;
   }

   protected abstract void a(MovingObjectPosition var1);

   public void write(NBTTagCompound var1) {
      var1.put("xTile", (short)this.e);
      var1.put("yTile", (short)this.f);
      var1.put("zTile", (short)this.g);
      MinecraftKey var2 = (MinecraftKey)Block.BLOCK_REGISTRY.getKey(this.h);
      var1.put("inTile", var2 == null?"":var2.toString());
      var1.put("inGround", (byte)(this.i?1:0));
      var1.put((String)"direction", (NBTTag)this.a((double[])(new double[]{this.motX, this.motY, this.motZ})));
   }

   public void read(NBTTagCompound var1) {
      this.e = var1.getShort("xTile");
      this.f = var1.getShort("yTile");
      this.g = var1.getShort("zTile");
      if(var1.hasOfType("inTile", 8)) {
         this.h = Block.getByName(var1.getString("inTile"));
      } else {
         this.h = Block.getById(var1.getByte("inTile") & 255);
      }

      this.i = var1.getByte("inGround") == 1;
      if(var1.hasOfType("direction", 9)) {
         NBTTagList var2 = var1.getList("direction", 6);
         this.motX = var2.getDouble(0);
         this.motY = var2.getDouble(1);
         this.motZ = var2.getDouble(2);
      } else {
         this.die();
      }

   }

   public boolean ad() {
      return true;
   }

   public float ao() {
      return 1.0F;
   }

   public boolean damageEntity(DamageSource var1, float var2) {
      if(this.b(var1)) {
         return false;
      } else {
         this.ac();
         if(var1.getEntity() != null) {
            Vec3D var3 = var1.getEntity().ap();
            if(var3 != null) {
               this.motX = var3.x;
               this.motY = var3.y;
               this.motZ = var3.z;
               this.b = this.motX * 0.1D;
               this.c = this.motY * 0.1D;
               this.d = this.motZ * 0.1D;
            }

            if(var1.getEntity() instanceof EntityLiving) {
               this.a = (EntityLiving)var1.getEntity();
            }

            return true;
         } else {
            return false;
         }
      }
   }

   public float c(float var1) {
      return 1.0F;
   }
}
