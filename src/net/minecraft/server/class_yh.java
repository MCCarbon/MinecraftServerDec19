package net.minecraft.server;

public class class_yh extends Container {
   public InventoryCrafting a = new InventoryCrafting(this, 3, 3);
   public IInventory f = new class_yv();
   private World g;
   private BlockPosition h;

   public class_yh(PlayerInventory var1, World var2, BlockPosition var3) {
      this.g = var2;
      this.h = var3;
      this.a((class_yx)(new class_yw(var1.e, this.a, this.f, 0, 124, 35)));

      int var4;
      int var5;
      for(var4 = 0; var4 < 3; ++var4) {
         for(var5 = 0; var5 < 3; ++var5) {
            this.a((class_yx)(new class_yx(this.a, var5 + var4 * 3, 30 + var5 * 18, 17 + var4 * 18)));
         }
      }

      for(var4 = 0; var4 < 3; ++var4) {
         for(var5 = 0; var5 < 9; ++var5) {
            this.a((class_yx)(new class_yx(var1, var5 + var4 * 9 + 9, 8 + var5 * 18, 84 + var4 * 18)));
         }
      }

      for(var4 = 0; var4 < 9; ++var4) {
         this.a((class_yx)(new class_yx(var1, var4, 8 + var4 * 18, 142)));
      }

      this.a((IInventory)this.a);
   }

   public void a(IInventory var1) {
      this.f.setItem(0, CraftingManager.a().craft(this.a, this.g));
   }

   public void b(EntityHuman var1) {
      super.b(var1);
      if(!this.g.isClientSide) {
         for(int var2 = 0; var2 < 9; ++var2) {
            ItemStack var3 = this.a.splitWithoutUpdate(var2);
            if(var3 != null) {
               var1.a(var3, false);
            }
         }

      }
   }

   public boolean a(EntityHuman var1) {
      return this.g.getType(this.h).getBlock() != Blocks.CRAFTING_TABLE?false:var1.e((double)this.h.getX() + 0.5D, (double)this.h.getY() + 0.5D, (double)this.h.getZ() + 0.5D) <= 64.0D;
   }

   public ItemStack b(EntityHuman var1, int var2) {
      ItemStack var3 = null;
      class_yx var4 = (class_yx)this.c.get(var2);
      if(var4 != null && var4.e()) {
         ItemStack var5 = var4.d();
         var3 = var5.clone();
         if(var2 == 0) {
            if(!this.a(var5, 10, 46, true)) {
               return null;
            }

            var4.a(var5, var3);
         } else if(var2 >= 10 && var2 < 37) {
            if(!this.a(var5, 37, 46, false)) {
               return null;
            }
         } else if(var2 >= 37 && var2 < 46) {
            if(!this.a(var5, 10, 37, false)) {
               return null;
            }
         } else if(!this.a(var5, 10, 46, false)) {
            return null;
         }

         if(var5.count == 0) {
            var4.d((ItemStack)null);
         } else {
            var4.f();
         }

         if(var5.count == var3.count) {
            return null;
         }

         var4.a(var1, var5);
      }

      return var3;
   }

   public boolean a(ItemStack var1, class_yx var2) {
      return var2.d != this.f && super.a(var1, var2);
   }
}
