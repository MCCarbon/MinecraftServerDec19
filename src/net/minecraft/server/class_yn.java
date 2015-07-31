package net.minecraft.server;

import net.minecraft.server.ItemStack;
import net.minecraft.server.class_oj;
import net.minecraft.server.class_wz;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xz;
import net.minecraft.server.class_yx;

public class class_yn extends class_xz {
   private final class_oj a;

   public class_yn(class_wz var1, class_oj var2, class_xa var3) {
      this.a = var2;
      var2.b(var3);
      byte var4 = 51;

      int var5;
      for(var5 = 0; var5 < var2.o_(); ++var5) {
         this.a(new class_yx(var2, var5, 44 + var5 * 18, 20));
      }

      for(var5 = 0; var5 < 3; ++var5) {
         for(int var6 = 0; var6 < 9; ++var6) {
            this.a(new class_yx(var1, var6 + var5 * 9 + 9, 8 + var6 * 18, var5 * 18 + var4));
         }
      }

      for(var5 = 0; var5 < 9; ++var5) {
         this.a(new class_yx(var1, var5, 8 + var5 * 18, 58 + var4));
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
         if(var2 < this.a.o_()) {
            if(!this.a(var5, this.a.o_(), this.c.size(), true)) {
               return null;
            }
         } else if(!this.a(var5, 0, this.a.o_(), false)) {
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
}
