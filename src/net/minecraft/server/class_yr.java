package net.minecraft.server;

import net.minecraft.server.class_aas;
import net.minecraft.server.class_adz;
import net.minecraft.server.class_aea;
import net.minecraft.server.class_aeb;
import net.minecraft.server.class_eu;
import net.minecraft.server.class_fa;
import net.minecraft.server.class_fb;
import net.minecraft.server.class_oj;
import net.minecraft.server.class_xa;

public class class_yr implements class_oj {
   private final class_adz a;
   private class_aas[] b = new class_aas[3];
   private final class_xa c;
   private class_aea d;
   private int e;

   public class_yr(class_xa var1, class_adz var2) {
      this.c = var1;
      this.a = var2;
   }

   public int o_() {
      return this.b.length;
   }

   public class_aas a(int var1) {
      return this.b[var1];
   }

   public class_aas a(int var1, int var2) {
      if(this.b[var1] != null) {
         class_aas var3;
         if(var1 == 2) {
            var3 = this.b[var1];
            this.b[var1] = null;
            return var3;
         } else if(this.b[var1].b <= var2) {
            var3 = this.b[var1];
            this.b[var1] = null;
            if(this.e(var1)) {
               this.h();
            }

            return var3;
         } else {
            var3 = this.b[var1].a(var2);
            if(this.b[var1].b == 0) {
               this.b[var1] = null;
            }

            if(this.e(var1)) {
               this.h();
            }

            return var3;
         }
      } else {
         return null;
      }
   }

   private boolean e(int var1) {
      return var1 == 0 || var1 == 1;
   }

   public class_aas b(int var1) {
      if(this.b[var1] != null) {
         class_aas var2 = this.b[var1];
         this.b[var1] = null;
         return var2;
      } else {
         return null;
      }
   }

   public void a(int var1, class_aas var2) {
      this.b[var1] = var2;
      if(var2 != null && var2.b > this.q_()) {
         var2.b = this.q_();
      }

      if(this.e(var1)) {
         this.h();
      }

   }

   public String e_() {
      return "mob.villager";
   }

   public boolean l_() {
      return false;
   }

   public class_eu f_() {
      return (class_eu)(this.l_()?new class_fa(this.e_()):new class_fb(this.e_(), new Object[0]));
   }

   public int q_() {
      return 64;
   }

   public boolean a(class_xa var1) {
      return this.a.v_() == var1;
   }

   public void b(class_xa var1) {
   }

   public void c(class_xa var1) {
   }

   public boolean b(int var1, class_aas var2) {
      return true;
   }

   public void p_() {
      this.h();
   }

   public void h() {
      this.d = null;
      class_aas var1 = this.b[0];
      class_aas var2 = this.b[1];
      if(var1 == null) {
         var1 = var2;
         var2 = null;
      }

      if(var1 == null) {
         this.a(2, (class_aas)null);
      } else {
         class_aeb var3 = this.a.a_(this.c);
         if(var3 != null) {
            class_aea var4 = var3.a(var1, var2, this.e);
            if(var4 != null && !var4.h()) {
               this.d = var4;
               this.a(2, var4.d().k());
            } else if(var2 != null) {
               var4 = var3.a(var2, var1, this.e);
               if(var4 != null && !var4.h()) {
                  this.d = var4;
                  this.a(2, var4.d().k());
               } else {
                  this.a(2, (class_aas)null);
               }
            } else {
               this.a(2, (class_aas)null);
            }
         }
      }

      this.a.a_(this.a(2));
   }

   public class_aea i() {
      return this.d;
   }

   public void d(int var1) {
      this.e = var1;
      this.h();
   }

   public int a_(int var1) {
      return 0;
   }

   public void b(int var1, int var2) {
   }

   public int g() {
      return 0;
   }

   public void l() {
      for(int var1 = 0; var1 < this.b.length; ++var1) {
         this.b[var1] = null;
      }

   }
}
