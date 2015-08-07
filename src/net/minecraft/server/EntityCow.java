package net.minecraft.server;

public class EntityCow extends EntityAnimal {
   public EntityCow(World var1) {
      super(var1);
      this.a(0.9F, 1.3F);
      ((class_tf)this.u()).a(true);
      this.i.a(0, new class_rj(this));
      this.i.a(1, new class_se(this, 2.0D));
      this.i.a(2, new class_re(this, 1.0D));
      this.i.a(3, new class_sr(this, 1.25D, Items.WHEAT, false));
      this.i.a(4, new class_rl(this, 1.25D));
      this.i.a(5, new class_si(this, 1.0D));
      this.i.a(6, new class_rr(this, EntityHuman.class, 6.0F));
      this.i.a(7, new class_sh(this));
   }

   protected void aY() {
      super.aY();
      this.a(class_wl.a).a(10.0D);
      this.a(class_wl.d).a(0.20000000298023224D);
   }

   protected String C() {
      return "mob.cow.say";
   }

   protected String bp() {
      return "mob.cow.hurt";
   }

   protected String bq() {
      return "mob.cow.hurt";
   }

   protected void a(BlockPosition var1, Block var2) {
      this.a("mob.cow.step", 0.15F, 1.0F);
   }

   protected float bC() {
      return 0.4F;
   }

   protected Item D() {
      return Items.LEATHER;
   }

   protected void b(boolean var1, int var2) {
      int var3 = this.random.nextInt(3) + this.random.nextInt(1 + var2);

      int var4;
      for(var4 = 0; var4 < var3; ++var4) {
         this.a(Items.LEATHER, 1);
      }

      var3 = this.random.nextInt(3) + 1 + this.random.nextInt(1 + var2);

      for(var4 = 0; var4 < var3; ++var4) {
         if(this.av()) {
            this.a(Items.COOKED_BEEF, 1);
         } else {
            this.a(Items.BEEF, 1);
         }
      }

   }

   public boolean a(EntityHuman var1, EnumUsedHand var2, ItemStack var3) {
      if(var3 != null && var3.getItem() == Items.BUCKET && !var1.abilities.instabuild && !this.isBaby()) {
         if(--var3.count == 0) {
            var1.a((EnumUsedHand)var2, (ItemStack)(new ItemStack(Items.MILK_BUCKET)));
         } else if(!var1.inventory.a(new ItemStack(Items.MILK_BUCKET))) {
            var1.a(new ItemStack(Items.MILK_BUCKET), false);
         }

         return true;
      } else {
         return super.a(var1, var2, var3);
      }
   }

   public EntityCow b(EntityAgeable var1) {
      return new EntityCow(this.o);
   }

   public float aU() {
      return this.K;
   }

   // $FF: synthetic method
   public EntityAgeable createChild(EntityAgeable var1) {
      return this.b(var1);
   }
}
