package net.minecraft.server;

import net.minecraft.server.class_aas;
import net.minecraft.server.class_aco;
import net.minecraft.server.class_amr;
import net.minecraft.server.class_oj;
import net.minecraft.server.class_wz;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xz;
import net.minecraft.server.class_ye;
import net.minecraft.server.class_yk;
import net.minecraft.server.class_ym;
import net.minecraft.server.class_yx;

public class class_yl extends class_xz {
   private final class_oj a;
   private int f;
   private int g;
   private int h;
   private int i;

   public class_yl(class_wz var1, class_oj var2) {
      this.a = var2;
      this.a((class_yx)(new class_yx(var2, 0, 56, 17)));
      this.a((class_yx)(new class_yk(var2, 1, 56, 53)));
      this.a((class_yx)(new class_ym(var1.e, var2, 2, 116, 35)));

      int var3;
      for(var3 = 0; var3 < 3; ++var3) {
         for(int var4 = 0; var4 < 9; ++var4) {
            this.a((class_yx)(new class_yx(var1, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18)));
         }
      }

      for(var3 = 0; var3 < 9; ++var3) {
         this.a((class_yx)(new class_yx(var1, var3, 8 + var3 * 18, 142)));
      }

   }

   public void a(class_ye var1) {
      super.a(var1);
      var1.a(this, (class_oj)this.a);
   }

   public void b() {
      super.b();

      for(int var1 = 0; var1 < this.e.size(); ++var1) {
         class_ye var2 = (class_ye)this.e.get(var1);
         if(this.f != this.a.a_(2)) {
            var2.a(this, 2, this.a.a_(2));
         }

         if(this.h != this.a.a_(0)) {
            var2.a(this, 0, this.a.a_(0));
         }

         if(this.i != this.a.a_(1)) {
            var2.a(this, 1, this.a.a_(1));
         }

         if(this.g != this.a.a_(3)) {
            var2.a(this, 3, this.a.a_(3));
         }
      }

      this.f = this.a.a_(2);
      this.h = this.a.a_(0);
      this.i = this.a.a_(1);
      this.g = this.a.a_(3);
   }

   public boolean a(class_xa var1) {
      return this.a.a(var1);
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
         } else if(var2 != 1 && var2 != 0) {
            if(class_aco.a().a(var5) != null) {
               if(!this.a(var5, 0, 1, false)) {
                  return null;
               }
            } else if(class_amr.c(var5)) {
               if(!this.a(var5, 1, 2, false)) {
                  return null;
               }
            } else if(var2 >= 3 && var2 < 30) {
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
}