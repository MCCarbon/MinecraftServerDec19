package net.minecraft.server;

public class ContainerHorse extends Container {
   private IInventory a;
   private EntityHorse f;

   public ContainerHorse(IInventory var1, final IInventory var2, final EntityHorse var3, EntityHuman var4) {
      this.a = var2;
      this.f = var3;
      byte var5 = 3;
      var2.startOpen(var4);
      int var6 = (var5 - 4) * 18;
      this.a(new Slot(var2, 0, 8, 18) {
         public boolean a(ItemStack var1) {
            return super.a(var1) && var1.getItem() == Items.SADDLE && !this.e();
         }
      });
      this.a(new Slot(var2, 1, 8, 36) {
         public boolean a(ItemStack var1) {
            return super.a(var1) && var3.dd() && EntityHorse.a(var1.getItem());
         }
      });
      int var7;
      int var8;
      if(var3.cL()) {
         for(var7 = 0; var7 < var5; ++var7) {
            for(var8 = 0; var8 < 5; ++var8) {
               this.a(new Slot(var2, 2 + var8 + var7 * 5, 80 + var8 * 18, 18 + var7 * 18));
            }
         }
      }

      for(var7 = 0; var7 < 3; ++var7) {
         for(var8 = 0; var8 < 9; ++var8) {
            this.a(new Slot(var1, var8 + var7 * 9 + 9, 8 + var8 * 18, 102 + var7 * 18 + var6));
         }
      }

      for(var7 = 0; var7 < 9; ++var7) {
         this.a(new Slot(var1, var7, 8 + var7 * 18, 160 + var6));
      }

   }

   public boolean a(EntityHuman var1) {
      return this.a.isReachable(var1) && this.f.isAlive() && this.f.g(var1) < 8.0F;
   }

   public ItemStack b(EntityHuman var1, int var2) {
      ItemStack var3 = null;
      Slot var4 = (Slot)this.c.get(var2);
      if(var4 != null && var4.e()) {
         ItemStack var5 = var4.d();
         var3 = var5.clone();
         if(var2 < this.a.getSize()) {
            if(!this.a(var5, this.a.getSize(), this.c.size(), true)) {
               return null;
            }
         } else if(this.a(1).a(var5) && !this.a(1).e()) {
            if(!this.a(var5, 1, 2, false)) {
               return null;
            }
         } else if(this.a(0).a(var5)) {
            if(!this.a(var5, 0, 1, false)) {
               return null;
            }
         } else if(this.a.getSize() <= 2 || !this.a(var5, 2, this.a.getSize(), false)) {
            return null;
         }

         if(var5.count == 0) {
            var4.d((ItemStack)null);
         } else {
            var4.f();
         }
      }

      return var3;
   }

   public void b(EntityHuman var1) {
      super.b(var1);
      this.a.closeContainer(var1);
   }
}
