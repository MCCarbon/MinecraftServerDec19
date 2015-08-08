package net.minecraft.server;

public abstract class EntityAnimal extends EntityAgeable implements class_pp {
   protected Block bv;
   private int bs;
   private EntityHuman bt;

   public EntityAnimal(World var1) {
      super(var1);
      this.bv = Blocks.GRASS;
   }

   protected void cc() {
      if(this.getAge() != 0) {
         this.bs = 0;
      }

      super.cc();
   }

   public void m() {
      super.m();
      if(this.getAge() != 0) {
         this.bs = 0;
      }

      if(this.bs > 0) {
         --this.bs;
         if(this.bs % 10 == 0) {
            double var1 = this.random.nextGaussian() * 0.02D;
            double var3 = this.random.nextGaussian() * 0.02D;
            double var5 = this.random.nextGaussian() * 0.02D;
            this.world.a(class_cy.I, this.locX + (double)(this.random.nextFloat() * this.width * 2.0F) - (double)this.width, this.locY + 0.5D + (double)(this.random.nextFloat() * this.length), this.locZ + (double)(this.random.nextFloat() * this.width * 2.0F) - (double)this.width, var1, var3, var5, new int[0]);
         }
      }

   }

   public boolean damageEntity(DamageSource var1, float var2) {
      if(this.b((DamageSource)var1)) {
         return false;
      } else {
         this.bs = 0;
         return super.damageEntity(var1, var2);
      }
   }

   public float a(BlockPosition var1) {
      return this.world.getType(var1.down()).getBlock() == Blocks.GRASS?10.0F:this.world.o(var1) - 0.5F;
   }

   public void write(NBTTagCompound var1) {
      super.write(var1);
      var1.put("InLove", this.bs);
   }

   public void read(NBTTagCompound var1) {
      super.read(var1);
      this.bs = var1.getInt("InLove");
   }

   public boolean cf() {
      int var1 = MathHelper.floor(this.locX);
      int var2 = MathHelper.floor(this.aT().yMin);
      int var3 = MathHelper.floor(this.locZ);
      BlockPosition var4 = new BlockPosition(var1, var2, var3);
      return this.world.getType(var4.down()).getBlock() == this.bv && this.world.k(var4) > 8 && super.cf();
   }

   public int y() {
      return 120;
   }

   protected boolean E() {
      return false;
   }

   protected int b(EntityHuman var1) {
      return 1 + this.world.random.nextInt(3);
   }

   public boolean d(ItemStack var1) {
      return var1 == null?false:var1.getItem() == Items.WHEAT;
   }

   public boolean a(EntityHuman var1, EnumUsedHand var2, ItemStack var3) {
      if(var3 != null) {
         if(this.d(var3) && this.getAge() == 0 && this.bs <= 0) {
            this.a(var1, var3);
            this.a(var1);
            return true;
         }

         if(this.isBaby() && this.d(var3)) {
            this.a(var1, var3);
            this.setAge((int)((float)(-this.getAge() / 20) * 0.1F), true);
            return true;
         }
      }

      return super.a(var1, var2, var3);
   }

   protected void a(EntityHuman var1, ItemStack var2) {
      if(!var1.abilities.instabuild) {
         --var2.count;
      }

   }

   public void a(EntityHuman var1) {
      this.bs = 600;
      this.bt = var1;
      this.world.a((Entity)this, (byte)18);
   }

   public EntityHuman cF() {
      return this.bt;
   }

   public boolean cG() {
      return this.bs > 0;
   }

   public void cH() {
      this.bs = 0;
   }

   public boolean a(EntityAnimal var1) {
      return var1 == this?false:(var1.getClass() != this.getClass()?false:this.cG() && var1.cG());
   }
}
