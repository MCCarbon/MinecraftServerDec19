package net.minecraft.server;

import net.minecraft.server.ItemStack;
import net.minecraft.server.class_oj;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xz;
import net.minecraft.server.class_yx;

public class class_yf extends class_xz {
   private class_oj a;
   private int f;

   public class_yf(class_oj var1, class_oj var2, class_xa var3) {
      this.a = var2;
      this.f = var2.o_() / 9;
      var2.b(var3);
      int var4 = (this.f - 4) * 18;

      int var5;
      int var6;
      for(var5 = 0; var5 < this.f; ++var5) {
         for(var6 = 0; var6 < 9; ++var6) {
            this.a(new class_yx(var2, var6 + var5 * 9, 8 + var6 * 18, 18 + var5 * 18));
         }
      }

      for(var5 = 0; var5 < 3; ++var5) {
         for(var6 = 0; var6 < 9; ++var6) {
            this.a(new class_yx(var1, var6 + var5 * 9 + 9, 8 + var6 * 18, 103 + var5 * 18 + var4));
         }
      }

      for(var5 = 0; var5 < 9; ++var5) {
         this.a(new class_yx(var1, var5, 8 + var5 * 18, 161 + var4));
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

   public void b(class_xa var1) {
      super.b(var1);
      this.a.c(var1);
   }

   public class_oj e() {
      return this.a;
   }
}
