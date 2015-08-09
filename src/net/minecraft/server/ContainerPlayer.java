package net.minecraft.server;

public class ContainerPlayer extends Container {
   private static final EnumWearable[] h;
   public InventoryCrafting a = new InventoryCrafting(this, 2, 2);
   public IInventory f = new InventoryCraftResult();
   public boolean g;
   private final EntityHuman i;

   public ContainerPlayer(final PlayerInventory var1, boolean var2, EntityHuman var3) {
      this.g = var2;
      this.i = var3;
      this.a((Slot)(new SlotResult(var1.e, this.a, this.f, 0, 154, 28)));

      int var4;
      int var5;
      for(var4 = 0; var4 < 2; ++var4) {
         for(var5 = 0; var5 < 2; ++var5) {
            this.a((Slot)(new Slot(this.a, var5 + var4 * 2, 98 + var5 * 18, 18 + var4 * 18)));
         }
      }

      for(var4 = 0; var4 < 4; ++var4) {
         final EnumWearable var6 = h[var4];
         this.a((Slot)(new Slot(var1, 36 + (3 - var4), 8, 8 + var4 * 18) {
            public int a() {
               return 1;
            }

            public boolean a(ItemStack var1) {
               return var1 == null?false:(var1.getItem() instanceof ItemArmor ?((ItemArmor)var1.getItem()).b == var6:(var1.getItem() != Item.getItemOf(Blocks.PUMPKIN) && var1.getItem() != Items.SKULL ?false:var6 == EnumWearable.HEAD));
            }
         }));
      }

      for(var4 = 0; var4 < 3; ++var4) {
         for(var5 = 0; var5 < 9; ++var5) {
            this.a((Slot)(new Slot(var1, var5 + (var4 + 1) * 9, 8 + var5 * 18, 84 + var4 * 18)));
         }
      }

      for(var4 = 0; var4 < 9; ++var4) {
         this.a((Slot)(new Slot(var1, var4, 8 + var4 * 18, 142)));
      }

      this.a((Slot)(new Slot(var1, 40, 77, 62) {
         public boolean a(ItemStack var1) {
            return super.a(var1);
         }
      }));
      this.a((IInventory)this.a);
   }

   public void a(IInventory var1) {
      this.f.setItem(0, CraftingManager.a().craft(this.a, this.i.world));
   }

   public void b(EntityHuman var1) {
      super.b(var1);

      for(int var2 = 0; var2 < 4; ++var2) {
         ItemStack var3 = this.a.splitWithoutUpdate(var2);
         if(var3 != null) {
            var1.a(var3, false);
         }
      }

      this.f.setItem(0, (ItemStack)null);
   }

   public boolean a(EntityHuman var1) {
      return true;
   }

   public ItemStack b(EntityHuman var1, int var2) {
      ItemStack var3 = null;
      Slot var4 = (Slot)this.c.get(var2);
      if(var4 != null && var4.e()) {
         ItemStack var5 = var4.d();
         var3 = var5.clone();
         if(var2 == 0) {
            if(!this.a(var5, 9, 45, true)) {
               return null;
            }

            var4.a(var5, var3);
         } else if(var2 >= 1 && var2 < 5) {
            if(!this.a(var5, 9, 45, false)) {
               return null;
            }
         } else if(var2 >= 5 && var2 < 9) {
            if(!this.a(var5, 9, 45, false)) {
               return null;
            }
         } else if(var3.getItem() instanceof ItemArmor && !((Slot)this.c.get(8 - ((ItemArmor)var3.getItem()).b.getRelative())).e()) {
            int var6 = 8 - ((ItemArmor)var3.getItem()).b.getRelative();
            if(!this.a(var5, var6, var6 + 1, false)) {
               return null;
            }
         } else if(var2 >= 9 && var2 < 36) {
            if(!this.a(var5, 36, 45, false)) {
               return null;
            }
         } else if(var2 >= 36 && var2 < 45) {
            if(!this.a(var5, 9, 36, false)) {
               return null;
            }
         } else if(!this.a(var5, 9, 45, false)) {
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

   public boolean a(ItemStack var1, Slot var2) {
      return var2.d != this.f && super.a(var1, var2);
   }

   static {
      h = new EnumWearable[]{EnumWearable.HEAD, EnumWearable.TORSO, EnumWearable.LEGS, EnumWearable.FEET};
   }
}
