package net.minecraft.server;

public class EntityMinecartFurnace extends EntityMinecartAbstract {
   private static final int c = Datawathcer.claimId(EntityMinecartFurnace.class);
   private int d;
   public double a;
   public double b;

   public EntityMinecartFurnace(World var1) {
      super(var1);
   }

   public EntityMinecartFurnace(World var1, double var2, double var4, double var6) {
      super(var1, var2, var4, var6);
   }

   public EnumMinecartType s() {
      return EnumMinecartType.FURNACE;
   }

   protected void initDatawatcher() {
      super.initDatawatcher();
      this.datawatcher.add(c, new Byte((byte)0));
   }

   public void t_() {
      super.t_();
      if(this.d > 0) {
         --this.d;
      }

      if(this.d <= 0) {
         this.a = this.b = 0.0D;
      }

      this.i(this.d > 0);
      if(this.j() && this.random.nextInt(4) == 0) {
         this.o.a(class_cy.m, this.s, this.t + 0.8D, this.u, 0.0D, 0.0D, 0.0D, new int[0]);
      }

   }

   protected double m() {
      return 0.2D;
   }

   public void a(DamageSource var1) {
      super.a(var1);
      if(!var1.c() && this.o.R().getBooleanValue("doEntityDrops")) {
         this.a(new ItemStack(Blocks.FURNACE, 1), 0.0F);
      }

   }

   protected void a(BlockPosition var1, IBlockData var2) {
      super.a(var1, var2);
      double var3 = this.a * this.a + this.b * this.b;
      if(var3 > 1.0E-4D && this.v * this.v + this.x * this.x > 0.001D) {
         var3 = (double)MathHelper.sqrt(var3);
         this.a /= var3;
         this.b /= var3;
         if(this.a * this.v + this.b * this.x < 0.0D) {
            this.a = 0.0D;
            this.b = 0.0D;
         } else {
            double var5 = var3 / this.m();
            this.a *= var5;
            this.b *= var5;
         }
      }

   }

   protected void o() {
      double var1 = this.a * this.a + this.b * this.b;
      if(var1 > 1.0E-4D) {
         var1 = (double)MathHelper.sqrt(var1);
         this.a /= var1;
         this.b /= var1;
         double var3 = 1.0D;
         this.v *= 0.800000011920929D;
         this.motY *= 0.0D;
         this.x *= 0.800000011920929D;
         this.v += this.a * var3;
         this.x += this.b * var3;
      } else {
         this.v *= 0.9800000190734863D;
         this.motY *= 0.0D;
         this.x *= 0.9800000190734863D;
      }

      super.o();
   }

   public boolean a(EntityHuman var1, ItemStack var2, EnumUsedHand var3) {
      if(var2 != null && var2.getItem() == Items.COAL) {
         if(!var1.abilities.instabuild) {
            --var2.count;
         }

         this.d += 3600;
      }

      this.a = this.s - var1.s;
      this.b = this.u - var1.u;
      return true;
   }

   protected void write(NBTTagCompound var1) {
      super.write(var1);
      var1.put("PushX", this.a);
      var1.put("PushZ", this.b);
      var1.put("Fuel", (short)this.d);
   }

   protected void read(NBTTagCompound var1) {
      super.read(var1);
      this.a = var1.getDouble("PushX");
      this.b = var1.getDouble("PushZ");
      this.d = var1.getShort("Fuel");
   }

   protected boolean j() {
      return (this.datawatcher.getByte(c) & 1) != 0;
   }

   protected void i(boolean var1) {
      if(var1) {
         this.datawatcher.update(c, Byte.valueOf((byte)(this.datawatcher.getByte(c) | 1)));
      } else {
         this.datawatcher.update(c, Byte.valueOf((byte)(this.datawatcher.getByte(c) & -2)));
      }

   }

   public IBlockData u() {
      return (this.j()?Blocks.LIT_FURNACE:Blocks.FURNACE).getBlockData().set(BlockFurnace.a, EnumDirection.NORTH);
   }
}
