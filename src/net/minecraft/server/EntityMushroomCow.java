package net.minecraft.server;

public class EntityMushroomCow extends EntityCow {
   public EntityMushroomCow(World var1) {
      super(var1);
      this.a(0.9F, 1.3F);
      this.bv = Blocks.MYCELIM;
   }

   public boolean a(EntityHuman var1, EnumUsedHand var2, ItemStack var3) {
      if(var3 != null && var3.getItem() == Items.BOWL && this.getAge() >= 0 && !var1.abilities.instabuild) {
         if(--var3.count == 0) {
            var1.a((EnumUsedHand)var2, (ItemStack)(new ItemStack(Items.MUSHROOM_STEW)));
         } else if(!var1.inventory.a(new ItemStack(Items.MUSHROOM_STEW))) {
            var1.a(new ItemStack(Items.MUSHROOM_STEW), false);
         }

         return true;
      } else if(var3 != null && var3.getItem() == Items.SHEARS && this.getAge() >= 0) {
         this.J();
         this.o.a(class_cy.b, this.s, this.t + (double)(this.K / 2.0F), this.u, 0.0D, 0.0D, 0.0D, new int[0]);
         if(!this.o.isClientSide) {
            EntityCow var4 = new EntityCow(this.o);
            var4.b(this.s, this.t, this.u, this.y, this.z);
            var4.i(this.getHealth());
            var4.aL = this.aL;
            if(this.hasCustomName()) {
               var4.a(this.aO());
            }

            this.o.addEntity((Entity)var4);

            for(int var5 = 0; var5 < 5; ++var5) {
               this.o.addEntity((Entity)(new EntityItem(this.o, this.s, this.t + (double)this.K, this.u, new ItemStack(Blocks.RED_MUSHROOM))));
            }

            var3.a(1, (EntityLiving)var1);
            this.a("mob.sheep.shear", 1.0F, 1.0F);
         }

         return true;
      } else {
         return super.a(var1, var2, var3);
      }
   }

   public EntityMushroomCow c(EntityAgeable var1) {
      return new EntityMushroomCow(this.o);
   }

   // $FF: synthetic method
   public EntityCow b(EntityAgeable var1) {
      return this.c(var1);
   }

   // $FF: synthetic method
   public EntityAgeable createChild(EntityAgeable var1) {
      return this.c(var1);
   }
}
