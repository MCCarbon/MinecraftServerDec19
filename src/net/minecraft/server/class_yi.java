package net.minecraft.server;

import net.minecraft.server.ItemStack;
import net.minecraft.server.class_oj;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xz;
import net.minecraft.server.class_yx;

public class class_yi extends class_xz {
   private class_oj a;

   public class_yi(class_oj var1, class_oj var2) {
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

   public boolean a(class_xa var1) {
      return this.a.a(var1);
   }

   public ItemStack b(class_xa var1, int var2) {
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
