package net.minecraft.server;

public class EntitySpectralArrow extends EntityArrow {
   private int f = 200;

   public EntitySpectralArrow(World var1) {
      super(var1);
   }

   public EntitySpectralArrow(World var1, EntityLiving var2) {
      super(var1, var2);
   }

   public EntitySpectralArrow(World var1, double var2, double var4, double var6) {
      super(var1, var2, var4, var6);
   }

   public void t_() {
      super.t_();
      if(this.world.isClientSide && !this.a) {
         this.world.addParticle(EnumParticle.o, this.locX, this.locY, this.locZ, 0.0D, 0.0D, 0.0D, new int[0]);
      }

   }

   protected ItemStack j() {
      return new ItemStack(Items.SPECTRAL_ARROW);
   }

   protected void b(EntityLiving var1) {
      super.b(var1);
      MobEffect var2 = new MobEffect(MobEffectList.x, this.f, 0);
      var1.addEffect(var2);
   }

   public void read(NBTTagCompound var1) {
      super.read(var1);
      if(var1.has("Duration")) {
         this.f = var1.getInt("Duration");
      }

   }

   public void write(NBTTagCompound var1) {
      super.write(var1);
      var1.put("Duration", this.f);
   }
}
