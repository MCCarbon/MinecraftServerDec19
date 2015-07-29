package net.minecraft.server;

import net.minecraft.server.class_aas;
import net.minecraft.server.Items;
import net.minecraft.server.class_abe;
import net.minecraft.server.class_ace;
import net.minecraft.server.class_acf;
import net.minecraft.server.class_mt;
import net.minecraft.server.class_my;
import net.minecraft.server.class_oj;
import net.minecraft.server.class_wz;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_xz;
import net.minecraft.server.class_ye;
import net.minecraft.server.class_yx;

public class class_yd extends class_xz {
   private class_oj a;
   private final class_yx f;
   private int g;

   public class_yd(class_wz var1, class_oj var2) {
      this.a = var2;
      this.a((class_yx)(new class_yd.class_b_in_class_yd(var1.e, var2, 0, 56, 46)));
      this.a((class_yx)(new class_yd.class_b_in_class_yd(var1.e, var2, 1, 79, 53)));
      this.a((class_yx)(new class_yd.class_b_in_class_yd(var1.e, var2, 2, 102, 46)));
      this.f = this.a((class_yx)(new class_yd.class_a_in_class_yd(var2, 3, 79, 17)));

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
         if(this.g != this.a.a_(0)) {
            var2.a(this, 0, this.a.a_(0));
         }
      }

      this.g = this.a.a_(0);
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
         if((var2 < 0 || var2 > 2) && var2 != 3) {
            if(!this.f.e() && this.f.a(var5)) {
               if(!this.a(var5, 3, 4, false)) {
                  return null;
               }
            } else if(class_yd.class_b_in_class_yd.b_(var3)) {
               if(!this.a(var5, 0, 3, false)) {
                  return null;
               }
            } else if(var2 >= 4 && var2 < 31) {
               if(!this.a(var5, 31, 40, false)) {
                  return null;
               }
            } else if(var2 >= 31 && var2 < 40) {
               if(!this.a(var5, 4, 31, false)) {
                  return null;
               }
            } else if(!this.a(var5, 4, 40, false)) {
               return null;
            }
         } else {
            if(!this.a(var5, 4, 40, true)) {
               return null;
            }

            var4.a(var5, var3);
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

   static class class_a_in_class_yd extends class_yx {
      public class_a_in_class_yd(class_oj var1, int var2, int var3, int var4) {
         super(var1, var2, var3, var4);
      }

      public boolean a(class_aas var1) {
         return var1 != null && class_ace.a(var1);
      }

      public int a() {
         return 64;
      }
   }

   static class class_b_in_class_yd extends class_yx {
      private class_xa a;

      public class_b_in_class_yd(class_xa var1, class_oj var2, int var3, int var4, int var5) {
         super(var2, var3, var4, var5);
         this.a = var1;
      }

      public boolean a(class_aas var1) {
         return b_(var1);
      }

      public int a() {
         return 1;
      }

      public void a(class_xa var1, class_aas var2) {
         if(class_abe.i(var2) != class_acf.a) {
            this.a.b((class_my)class_mt.B);
         }

         super.a(var1, var2);
      }

      public static boolean b_(class_aas var0) {
         return var0 != null && (var0.b() == Items.bB || var0.b() == Items.bD);
      }
   }
}
