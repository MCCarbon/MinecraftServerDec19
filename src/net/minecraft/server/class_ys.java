package net.minecraft.server;

import net.minecraft.server.class_aas;
import net.minecraft.server.class_adz;
import net.minecraft.server.World;
import net.minecraft.server.class_oj;
import net.minecraft.server.class_wz;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xz;
import net.minecraft.server.class_ye;
import net.minecraft.server.class_yr;
import net.minecraft.server.class_yt;
import net.minecraft.server.class_yx;

public class class_ys extends class_xz {
   private class_adz a;
   private class_yr f;
   private final World g;

   public class_ys(class_wz var1, class_adz var2, World var3) {
      this.a = var2;
      this.g = var3;
      this.f = new class_yr(var1.e, var2);
      this.a((class_yx)(new class_yx(this.f, 0, 36, 53)));
      this.a((class_yx)(new class_yx(this.f, 1, 62, 53)));
      this.a((class_yx)(new class_yt(var1.e, var2, this.f, 2, 120, 53)));

      int var4;
      for(var4 = 0; var4 < 3; ++var4) {
         for(int var5 = 0; var5 < 9; ++var5) {
            this.a((class_yx)(new class_yx(var1, var5 + var4 * 9 + 9, 8 + var5 * 18, 84 + var4 * 18)));
         }
      }

      for(var4 = 0; var4 < 9; ++var4) {
         this.a((class_yx)(new class_yx(var1, var4, 8 + var4 * 18, 142)));
      }

   }

   public class_yr e() {
      return this.f;
   }

   public void a(class_ye var1) {
      super.a(var1);
   }

   public void b() {
      super.b();
   }

   public void a(class_oj var1) {
      this.f.h();
      super.a(var1);
   }

   public void d(int var1) {
      this.f.d(var1);
   }

   public boolean a(class_xa var1) {
      return this.a.v_() == var1;
   }

   public class_aas b(class_xa var1, int var2) {
      class_aas var3 = null;
      class_yx var4 = (class_yx)this.c.get(var2);
      if(var4 != null && var4.e()) {
         class_aas var5 = var4.d();
         var3 = var5.k();
         if(var2 == 2) {
            if(!this.a(var5, 3, 39, true)) {
               return null;
            }

            var4.a(var5, var3);
         } else if(var2 != 0 && var2 != 1) {
            if(var2 >= 3 && var2 < 30) {
               if(!this.a(var5, 30, 39, false)) {
                  return null;
               }
            } else if(var2 >= 30 && var2 < 39 && !this.a(var5, 3, 30, false)) {
               return null;
            }
         } else if(!this.a(var5, 3, 39, false)) {
            return null;
         }

         if(var5.b == 0) {
            var4.d((class_aas)null);
         } else {
            var4.f();
         }

         if(var5.b == var3.b) {
            return null;
         }

         var4.a(var1, var5);
      }

      return var3;
   }

   public void b(class_xa var1) {
      super.b(var1);
      this.a.a((class_xa)null);
      super.b(var1);
      if(!this.g.D) {
         class_aas var2 = this.f.b(0);
         if(var2 != null) {
            var1.a(var2, false);
         }

         var2 = this.f.b(1);
         if(var2 != null) {
            var1.a(var2, false);
         }

      }
   }
}
