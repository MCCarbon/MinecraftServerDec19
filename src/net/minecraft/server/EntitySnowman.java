package net.minecraft.server;

public class EntitySnowman extends class_ua implements class_wk {
   public EntitySnowman(World var1) {
      super(var1);
      this.a(0.7F, 1.9F);
      ((class_tf)this.u()).a(true);
      this.i.a(1, new class_sj(this, 1.25D, 20, 10.0F));
      this.i.a(2, new class_si(this, 1.0D));
      this.i.a(3, new class_rr(this, EntityHuman.class, 6.0F));
      this.i.a(4, new class_sh(this));
      this.bn.a(1, new class_sz(this, EntityInsentient.class, 10, true, false, class_wd.d));
   }

   protected void aY() {
      super.aY();
      this.a(class_wl.a).a(4.0D);
      this.a(class_wl.d).a(0.20000000298023224D);
   }

   public void m() {
      super.m();
      if(!this.world.isClientSide) {
         int var1 = MathHelper.floor(this.locX);
         int var2 = MathHelper.floor(this.locY);
         int var3 = MathHelper.floor(this.locZ);
         if(this.U()) {
            this.damageEntity(DamageSource.f, 1.0F);
         }

         if(this.world.b(new BlockPosition(var1, 0, var3)).a(new BlockPosition(var1, var2, var3)) > 1.0F) {
            this.damageEntity(DamageSource.c, 1.0F);
         }

         for(int var4 = 0; var4 < 4; ++var4) {
            var1 = MathHelper.floor(this.locX + (double)((float)(var4 % 2 * 2 - 1) * 0.25F));
            var2 = MathHelper.floor(this.locY);
            var3 = MathHelper.floor(this.locZ + (double)((float)(var4 / 2 % 2 * 2 - 1) * 0.25F));
            BlockPosition var5 = new BlockPosition(var1, var2, var3);
            if(this.world.getType(var5).getBlock().getMaterial() == Material.AIR && this.world.b(new BlockPosition(var1, 0, var3)).a(var5) < 0.8F && Blocks.SNOW_LAYER.canPlace(this.world, var5)) {
               this.world.setTypeUpdate(var5, Blocks.SNOW_LAYER.getBlockData());
            }
         }
      }

   }

   protected Item D() {
      return Items.SNOWBALL;
   }

   protected void b(boolean var1, int var2) {
      int var3 = this.random.nextInt(16);

      for(int var4 = 0; var4 < var3; ++var4) {
         this.a(Items.SNOWBALL, 1);
      }

   }

   public void a(EntityLiving var1, float var2) {
      EntitySnowball var3 = new EntitySnowball(this.world, this);
      double var4 = var1.locY + (double)var1.aU() - 1.100000023841858D;
      double var6 = var1.locX - this.locX;
      double var8 = var4 - var3.locY;
      double var10 = var1.locZ - this.locZ;
      float var12 = MathHelper.sqrt(var6 * var6 + var10 * var10) * 0.2F;
      var3.c(var6, var8 + (double)var12, var10, 1.6F, 12.0F);
      this.a("random.bow", 1.0F, 1.0F / (this.bd().nextFloat() * 0.4F + 0.8F));
      this.world.addEntity((Entity)var3);
   }

   public float aU() {
      return 1.7F;
   }
}
