package net.minecraft.server;

import net.minecraft.server.ItemStack;
import net.minecraft.server.IInventory;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.Container;
import net.minecraft.server.Slot;

public class ContainerChest extends Container {
   private IInventory a;
   private int f;

   public ContainerChest(IInventory var1, IInventory var2, EntityHuman var3) {
      this.a = var2;
      this.f = var2.getSize() / 9;
      var2.startOpen(var3);
      int var4 = (this.f - 4) * 18;

      int var5;
      int var6;
      for(var5 = 0; var5 < this.f; ++var5) {
         for(var6 = 0; var6 < 9; ++var6) {
            this.a(new Slot(var2, var6 + var5 * 9, 8 + var6 * 18, 18 + var5 * 18));
         }
      }

      for(var5 = 0; var5 < 3; ++var5) {
         for(var6 = 0; var6 < 9; ++var6) {
            this.a(new Slot(var1, var6 + var5 * 9 + 9, 8 + var6 * 18, 103 + var5 * 18 + var4));
         }
      }

      for(var5 = 0; var5 < 9; ++var5) {
         this.a(new Slot(var1, var5, 8 + var5 * 18, 161 + var4));
      }

   }

   public boolean a(EntityHuman var1) {
      return this.a.isReachable(var1);
   }

   public ItemStack b(EntityHuman var1, int var2) {
      ItemStack var3 = null;
      Slot var4 = (Slot)this.c.get(var2);
      if(var4 != null && var4.e()) {
         ItemStack var5 = var4.d();
         var3 = var5.clone();
         if(var2 < this.f * 9) {
            if(!this.a(var5, this.f * 9, this.c.size(), true)) {
               return null;
            }
         } else if(!this.a(var5, 0, this.f * 9, false)) {
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

   public IInventory e() {
      return this.a;
   }
}
