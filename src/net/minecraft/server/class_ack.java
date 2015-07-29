package net.minecraft.server;

import net.minecraft.server.class_aas;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_acc;
import net.minecraft.server.class_acs;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_yg;

public class class_ack implements class_acs {
   public boolean a(class_yg var1, class_aen var2) {
      int var3 = 0;
      class_aas var4 = null;

      for(int var5 = 0; var5 < var1.o_(); ++var5) {
         class_aas var6 = var1.a(var5);
         if(var6 != null) {
            if(var6.b() == class_aau.bQ) {
               if(var4 != null) {
                  return false;
               }

               var4 = var6;
            } else {
               if(var6.b() != class_aau.bP) {
                  return false;
               }

               ++var3;
            }
         }
      }

      return var4 != null && var3 > 0;
   }

   public class_aas a(class_yg var1) {
      int var2 = 0;
      class_aas var3 = null;

      for(int var4 = 0; var4 < var1.o_(); ++var4) {
         class_aas var5 = var1.a(var4);
         if(var5 != null) {
            if(var5.b() == class_aau.bQ) {
               if(var3 != null) {
                  return null;
               }

               var3 = var5;
            } else {
               if(var5.b() != class_aau.bP) {
                  return null;
               }

               ++var2;
            }
         }
      }

      if(var3 != null && var2 >= 1 && class_acc.h(var3) < 2) {
         class_aas var6 = new class_aas(class_aau.bQ, var2);
         var6.d((class_dn)var3.o().b());
         var6.o().a("generation", class_acc.h(var3) + 1);
         if(var3.s()) {
            var6.c(var3.q());
         }

         return var6;
      } else {
         return null;
      }
   }

   public int a() {
      return 9;
   }

   public class_aas b() {
      return null;
   }

   public class_aas[] b(class_yg var1) {
      class_aas[] var2 = new class_aas[var1.o_()];

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class_aas var4 = var1.a(var3);
         if(var4 != null && var4.b() instanceof class_acc) {
            var2[var3] = var4;
            break;
         }
      }

      return var2;
   }
}
