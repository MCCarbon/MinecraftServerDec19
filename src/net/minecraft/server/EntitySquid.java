package net.minecraft.server;

public class EntitySquid extends class_uk {
   public float a;
   public float b;
   public float c;
   public float bq;
   public float br;
   public float bs;
   public float bt;
   public float bu;
   private float bv;
   private float bw;
   private float bx;
   private float by;
   private float bz;
   private float bA;

   public EntitySquid(World var1) {
      super(var1);
      this.setSize(0.95F, 0.95F);
      this.random.setSeed((long)(1 + this.getId()));
      this.bw = 1.0F / (this.random.nextFloat() + 1.0F) * 0.2F;
      this.i.a(0, new EntitySquid.class_a_in_class_ui(this));
   }

   protected void aY() {
      super.aY();
      this.a(class_wl.a).a(10.0D);
   }

   public float getHeadHeight() {
      return this.length * 0.5F;
   }

   protected String C() {
      return null;
   }

   protected String bp() {
      return null;
   }

   protected String bq() {
      return null;
   }

   protected float bC() {
      return 0.4F;
   }

   protected Item D() {
      return null;
   }

   protected boolean s_() {
      return false;
   }

   protected void b(boolean var1, int var2) {
      int var3 = this.random.nextInt(3 + var2) + 1;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.a(new ItemStack(Items.DYE, 1, EnumColor.p.b()), 0.0F);
      }

   }

   public boolean V() {
      return this.world.a((AxisAlignedBB)this.getBoundingBox().grow(0.0D, -0.6000000238418579D, 0.0D), (Material)Material.WATER, (Entity)this);
   }

   public void m() {
      super.m();
      this.b = this.a;
      this.bq = this.c;
      this.bs = this.br;
      this.bu = this.bt;
      this.br += this.bw;
      if((double)this.br > 6.283185307179586D) {
         if(this.world.isClientSide) {
            this.br = 6.2831855F;
         } else {
            this.br = (float)((double)this.br - 6.283185307179586D);
            if(this.random.nextInt(10) == 0) {
               this.bw = 1.0F / (this.random.nextFloat() + 1.0F) * 0.2F;
            }

            this.world.a((Entity)this, (byte)19);
         }
      }

      if(this.inWater) {
         float var1;
         if(this.br < 3.1415927F) {
            var1 = this.br / 3.1415927F;
            this.bt = MathHelper.sin(var1 * var1 * 3.1415927F) * 3.1415927F * 0.25F;
            if((double)var1 > 0.75D) {
               this.bv = 1.0F;
               this.bx = 1.0F;
            } else {
               this.bx *= 0.8F;
            }
         } else {
            this.bt = 0.0F;
            this.bv *= 0.9F;
            this.bx *= 0.99F;
         }

         if(!this.world.isClientSide) {
            this.motX = (double)(this.by * this.bv);
            this.motY = (double)(this.bz * this.bv);
            this.motZ = (double)(this.bA * this.bv);
         }

         var1 = MathHelper.sqrt(this.motX * this.motX + this.motZ * this.motZ);
         this.aL += (-((float)MathHelper.b(this.motX, this.motZ)) * 180.0F / 3.1415927F - this.aL) * 0.1F;
         this.yaw = this.aL;
         this.c = (float)((double)this.c + 3.141592653589793D * (double)this.bx * 1.5D);
         this.a += (-((float)MathHelper.b((double)var1, this.motY)) * 180.0F / 3.1415927F - this.a) * 0.1F;
      } else {
         this.bt = MathHelper.abs(MathHelper.sin(this.br)) * 3.1415927F * 0.25F;
         if(!this.world.isClientSide) {
            this.motX = 0.0D;
            this.motY -= 0.08D;
            this.motY *= 0.9800000190734863D;
            this.motZ = 0.0D;
         }

         this.a = (float)((double)this.a + (double)(-90.0F - this.a) * 0.02D);
      }

   }

   public void g(float var1, float var2) {
      this.d(this.motX, this.motY, this.motZ);
   }

   public boolean cf() {
      return this.locY > 45.0D && this.locY < (double)this.world.G() && super.cf();
   }

   public void b(float var1, float var2, float var3) {
      this.by = var1;
      this.bz = var2;
      this.bA = var3;
   }

   public boolean n() {
      return this.by != 0.0F || this.bz != 0.0F || this.bA != 0.0F;
   }

   static class class_a_in_class_ui extends class_rm {
      private EntitySquid a;

      public class_a_in_class_ui(EntitySquid var1) {
         this.a = var1;
      }

      public boolean a() {
         return true;
      }

      public void e() {
         int var1 = this.a.bi();
         if(var1 > 100) {
            this.a.b(0.0F, 0.0F, 0.0F);
         } else if(this.a.getRandom().nextInt(50) == 0 || !this.a.inWater || !this.a.n()) {
            float var2 = this.a.getRandom().nextFloat() * 3.1415927F * 2.0F;
            float var3 = MathHelper.cos(var2) * 0.2F;
            float var4 = -0.1F + this.a.getRandom().nextFloat() * 0.2F;
            float var5 = MathHelper.sin(var2) * 0.2F;
            this.a.b(var3, var4, var5);
         }

      }
   }
}
