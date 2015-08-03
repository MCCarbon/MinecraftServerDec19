package net.minecraft.server;

public abstract class class_tw extends class_po implements class_pp {
   protected Block bv;
   private int bs;
   private EntityHuman bt;

   public class_tw(World var1) {
      super(var1);
      this.bv = Blocks.GRASS;
   }

   protected void cc() {
      if(this.l() != 0) {
         this.bs = 0;
      }

      super.cc();
   }

   public void m() {
      super.m();
      if(this.l() != 0) {
         this.bs = 0;
      }

      if(this.bs > 0) {
         --this.bs;
         if(this.bs % 10 == 0) {
            double var1 = this.random.nextGaussian() * 0.02D;
            double var3 = this.random.nextGaussian() * 0.02D;
            double var5 = this.random.nextGaussian() * 0.02D;
            this.o.a(class_cy.I, this.s + (double)(this.random.nextFloat() * this.J * 2.0F) - (double)this.J, this.t + 0.5D + (double)(this.random.nextFloat() * this.K), this.u + (double)(this.random.nextFloat() * this.J * 2.0F) - (double)this.J, var1, var3, var5, new int[0]);
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
      return this.o.getType(var1.down()).getBlock() == Blocks.GRASS?10.0F:this.o.o(var1) - 0.5F;
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
      int var1 = MathHelper.floor(this.s);
      int var2 = MathHelper.floor(this.aT().yMin);
      int var3 = MathHelper.floor(this.u);
      BlockPosition var4 = new BlockPosition(var1, var2, var3);
      return this.o.getType(var4.down()).getBlock() == this.bv && this.o.k(var4) > 8 && super.cf();
   }

   public int y() {
      return 120;
   }

   protected boolean E() {
      return false;
   }

   protected int b(EntityHuman var1) {
      return 1 + this.o.random.nextInt(3);
   }

   public boolean d(ItemStack var1) {
      return var1 == null?false:var1.getItem() == Items.WHEAT;
   }

   public boolean a(EntityHuman var1, EnumUsedHand var2, ItemStack var3) {
      if(var3 != null) {
         if(this.d(var3) && this.l() == 0 && this.bs <= 0) {
            this.a(var1, var3);
            this.a(var1);
            return true;
         }

         if(this.j_() && this.d(var3)) {
            this.a(var1, var3);
            this.a((int)((float)(-this.l() / 20) * 0.1F), true);
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
      this.o.a((Entity)this, (byte)18);
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

   public boolean a(class_tw var1) {
      return var1 == this?false:(var1.getClass() != this.getClass()?false:this.cG() && var1.cG());
   }
}
