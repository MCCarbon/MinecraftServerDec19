package net.minecraft.server;

import com.google.common.collect.Sets;
import java.util.Set;

public class EntityChicken extends EntityAnimal {
   private static final Set bA;
   public float bs;
   public float bt;
   public float bu;
   public float bw;
   public float bx = 1.0F;
   public int by;
   public boolean bz;

   public EntityChicken(World var1) {
      super(var1);
      this.a(0.4F, 0.7F);
      this.by = this.random.nextInt(6000) + 6000;
      this.i.a(0, new class_rj(this));
      this.i.a(1, new class_se(this, 1.4D));
      this.i.a(2, new class_re(this, 1.0D));
      this.i.a(3, new class_sr(this, 1.0D, false, bA));
      this.i.a(4, new class_rl(this, 1.1D));
      this.i.a(5, new class_si(this, 1.0D));
      this.i.a(6, new class_rr(this, EntityHuman.class, 6.0F));
      this.i.a(7, new class_sh(this));
   }

   public float aU() {
      return this.length;
   }

   protected void aY() {
      super.aY();
      this.a((class_qk)class_wl.a).a(4.0D);
      this.a((class_qk)class_wl.d).a(0.25D);
   }

   public void m() {
      super.m();
      this.bw = this.bs;
      this.bu = this.bt;
      this.bt = (float)((double)this.bt + (double)(this.onGround?-1:4) * 0.3D);
      this.bt = MathHelper.clamp(this.bt, 0.0F, 1.0F);
      if(!this.onGround && this.bx < 1.0F) {
         this.bx = 1.0F;
      }

      this.bx = (float)((double)this.bx * 0.9D);
      if(!this.onGround && this.motY < 0.0D) {
         this.motY *= 0.6D;
      }

      this.bs += this.bx * 2.0F;
      if(!this.world.isClientSide && !this.isBaby() && !this.cA() && --this.by <= 0) {
         this.a("mob.chicken.plop", 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
         this.a(Items.EGG, 1);
         this.by = this.random.nextInt(6000) + 6000;
      }

   }

   public void e(float var1, float var2) {
   }

   protected String C() {
      return "mob.chicken.say";
   }

   protected String bp() {
      return "mob.chicken.hurt";
   }

   protected String bq() {
      return "mob.chicken.hurt";
   }

   protected void a(BlockPosition var1, Block var2) {
      this.a("mob.chicken.step", 0.15F, 1.0F);
   }

   protected Item D() {
      return Items.FEATHER;
   }

   protected void b(boolean var1, int var2) {
      int var3 = this.random.nextInt(3) + this.random.nextInt(1 + var2);

      for(int var4 = 0; var4 < var3; ++var4) {
         this.a(Items.FEATHER, 1);
      }

      if(this.av()) {
         this.a(Items.COOKED_CHICKEN, 1);
      } else {
         this.a(Items.CHICKEN, 1);
      }

   }

   public EntityChicken b(EntityAgeable var1) {
      return new EntityChicken(this.world);
   }

   public boolean d(ItemStack var1) {
      return var1 != null && bA.contains(var1.getItem());
   }

   public void read(NBTTagCompound var1) {
      super.read(var1);
      this.bz = var1.getBoolean("IsChickenJockey");
      if(var1.has("EggLayTime")) {
         this.by = var1.getInt("EggLayTime");
      }

   }

   protected int b(EntityHuman var1) {
      return this.cA()?10:super.b(var1);
   }

   public void write(NBTTagCompound var1) {
      super.write(var1);
      var1.put("IsChickenJockey", this.bz);
      var1.put("EggLayTime", this.by);
   }

   protected boolean E() {
      return this.cA() && this.passenger == null;
   }

   public void al() {
      super.al();
      float var1 = MathHelper.sin(this.aL * 3.1415927F / 180.0F);
      float var2 = MathHelper.cos(this.aL * 3.1415927F / 180.0F);
      float var3 = 0.1F;
      float var4 = 0.0F;
      this.passenger.b(this.locX + (double)(var3 * var1), this.locY + (double)(this.length * 0.5F) + this.passenger.am() + (double)var4, this.locZ - (double)(var3 * var2));
      if(this.passenger instanceof EntityLiving) {
         ((EntityLiving)this.passenger).aL = this.aL;
      }

   }

   public boolean cA() {
      return this.bz;
   }

   public void m(boolean var1) {
      this.bz = var1;
   }

   // $FF: synthetic method
   public EntityAgeable createChild(EntityAgeable var1) {
      return this.b(var1);
   }

   static {
      bA = Sets.newHashSet((Object[])(new Item[]{Items.WHEAT_SEEDS, Items.MELON_SEEDS, Items.PUMPKIN_SEEDS, Items.BEETROOT_SEEDS}));
   }
}
