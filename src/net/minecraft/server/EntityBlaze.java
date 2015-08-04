package net.minecraft.server;

public class EntityBlaze extends EntityMonster {
   private float a = 0.5F;
   private int b;
   private static final int c = Datawathcer.claimId(EntityBlaze.class);

   public EntityBlaze(World var1) {
      super(var1);
      this.ab = true;
      this.b_ = 10;
      this.i.a(4, new EntityBlaze.class_a_in_class_vy(this));
      this.i.a(5, new class_ry(this, 1.0D));
      this.i.a(7, new class_si(this, 1.0D));
      this.i.a(8, new class_rr(this, EntityHuman.class, 8.0F));
      this.i.a(8, new class_sh(this));
      this.bn.a(1, new class_sw(this, true, new Class[0]));
      this.bn.a(2, new class_sz(this, EntityHuman.class, true));
   }

   protected void aY() {
      super.aY();
      this.a(class_wl.e).a(6.0D);
      this.a(class_wl.d).a(0.23000000417232513D);
      this.a(class_wl.b).a(48.0D);
   }

   protected void initDatawatcher() {
      super.initDatawatcher();
      this.datawatcher.add(c, new Byte((byte)0));
   }

   protected String C() {
      return "mob.blaze.breathe";
   }

   protected String bp() {
      return "mob.blaze.hit";
   }

   protected String bq() {
      return "mob.blaze.death";
   }

   public float c(float var1) {
      return 1.0F;
   }

   public void m() {
      if(!this.C && this.motY < 0.0D) {
         this.motY *= 0.6D;
      }

      if(this.o.isClientSide) {
         if(this.random.nextInt(24) == 0 && !this.R()) {
            this.o.a(this.s + 0.5D, this.t + 0.5D, this.u + 0.5D, "fire.fire", 1.0F + this.random.nextFloat(), this.random.nextFloat() * 0.7F + 0.3F, false);
         }

         for(int var1 = 0; var1 < 2; ++var1) {
            this.o.a(class_cy.m, this.s + (this.random.nextDouble() - 0.5D) * (double)this.J, this.t + this.random.nextDouble() * (double)this.K, this.u + (this.random.nextDouble() - 0.5D) * (double)this.J, 0.0D, 0.0D, 0.0D, new int[0]);
         }
      }

      super.m();
   }

   protected void cc() {
      if(this.U()) {
         this.damageEntity(DamageSource.f, 1.0F);
      }

      --this.b;
      if(this.b <= 0) {
         this.b = 100;
         this.a = 0.5F + (float)this.random.nextGaussian() * 3.0F;
      }

      EntityLiving var1 = this.w();
      if(var1 != null && var1.t + (double)var1.aU() > this.t + (double)this.aU() + (double)this.a) {
         this.motY += (0.30000001192092896D - this.motY) * 0.30000001192092896D;
         this.ai = true;
      }

      super.cc();
   }

   public void e(float var1, float var2) {
   }

   protected Item D() {
      return Items.BLAZE_ROD;
   }

   public boolean av() {
      return this.n();
   }

   protected void b(boolean var1, int var2) {
      if(var1) {
         int var3 = this.random.nextInt(2 + var2);

         for(int var4 = 0; var4 < var3; ++var4) {
            this.a(Items.BLAZE_ROD, 1);
         }
      }

   }

   public boolean n() {
      return (this.datawatcher.getByte(c) & 1) != 0;
   }

   public void a(boolean var1) {
      byte var2 = this.datawatcher.getByte(c);
      if(var1) {
         var2 = (byte)(var2 | 1);
      } else {
         var2 &= -2;
      }

      this.datawatcher.update(c, Byte.valueOf(var2));
   }

   protected boolean n_() {
      return true;
   }

   static class class_a_in_class_vy extends class_rm {
      private EntityBlaze a;
      private int b;
      private int c;

      public class_a_in_class_vy(EntityBlaze var1) {
         this.a = var1;
         this.a(3);
      }

      public boolean a() {
         EntityLiving var1 = this.a.w();
         return var1 != null && var1.isAlive();
      }

      public void c() {
         this.b = 0;
      }

      public void d() {
         this.a.a(false);
      }

      public void e() {
         --this.c;
         EntityLiving var1 = this.a.w();
         double var2 = this.a.h(var1);
         if(var2 < 4.0D) {
            if(this.c <= 0) {
               this.c = 20;
               this.a.r(var1);
            }

            this.a.r().a(var1.s, var1.t, var1.u, 1.0D);
         } else if(var2 < 256.0D) {
            double var4 = var1.s - this.a.s;
            double var6 = var1.aT().yMin + (double)(var1.K / 2.0F) - (this.a.t + (double)(this.a.K / 2.0F));
            double var8 = var1.u - this.a.u;
            if(this.c <= 0) {
               ++this.b;
               if(this.b == 1) {
                  this.c = 60;
                  this.a.a(true);
               } else if(this.b <= 4) {
                  this.c = 6;
               } else {
                  this.c = 100;
                  this.b = 0;
                  this.a.a(false);
               }

               if(this.b > 1) {
                  float var10 = MathHelper.sqrt(MathHelper.sqrt(var2)) * 0.5F;
                  this.a.o.a((EntityHuman)null, 1009, new BlockPosition((int)this.a.s, (int)this.a.t, (int)this.a.u), 0);

                  for(int var11 = 0; var11 < 1; ++var11) {
                     EntitySmallFireball var12 = new EntitySmallFireball(this.a.o, this.a, var4 + this.a.bd().nextGaussian() * (double)var10, var6, var8 + this.a.bd().nextGaussian() * (double)var10);
                     var12.t = this.a.t + (double)(this.a.K / 2.0F) + 0.5D;
                     this.a.o.addEntity((Entity)var12);
                  }
               }
            }

            this.a.q().a(var1, 10.0F, 10.0F);
         } else {
            this.a.u().n();
            this.a.r().a(var1.s, var1.t, var1.u, 1.0D);
         }

         super.e();
      }
   }
}
