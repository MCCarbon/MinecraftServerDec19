package net.minecraft.server;

import net.minecraft.server.ItemStack;
import net.minecraft.server.IInventory;
import net.minecraft.server.EntityHuman;
import net.minecraft.server.Container;
import net.minecraft.server.class_yx;

public class class_yi extends Container {
   private IInventory a;

   public class_yi(IInventory var1, IInventory var2) {
      this.a = var2;

      int var3;
      int var4;
      for(var3 = 0; var3 < 3; ++var3) {
         for(var4 = 0; var4 < 3; ++var4) {
            this.a(new class_yx(var2, var4 + var3 * 3, 62 + var4 * 18, 17 + var3 * 18));
         }
      }

      for(var3 = 0; var3 < 3; ++var3) {
         for(var4 = 0; var4 < 9; ++var4) {
            this.a(new class_yx(var1, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
         }
      }

      for(var3 = 0; var3 < 9; ++var3) {
         this.a(new class_yx(var1, var3, 8 + var3 * 18, 142));
      }

   }

   public boolean a(EntityHuman var1) {
      return this.a.isReachable(var1);
   }

   public ItemStack b(EntityHuman var1, int var2) {
      ItemStack var3 = null;
      class_yx var4 = (class_yx)this.c.get(var2);
      if(var4 != null && var4.e()) {
         ItemStack var5 = var4.d();
         var3 = var5.clone();
         if(var2 < 9) {
            if(!this.a(var5, 9, 45, true)) {
               return null;
            }
         } else if(!this.a(var5, 0, 9, false)) {
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
}
