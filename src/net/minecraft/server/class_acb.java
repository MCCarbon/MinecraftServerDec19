package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.class_aas;
import net.minecraft.server.World;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_du;
import net.minecraft.server.class_nc;
import net.minecraft.server.EnumUsedHand;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_or;
import net.minecraft.server.class_xa;

public class class_acb extends Item {
   public class_acb() {
      this.d(1);
   }

   public class_or a(class_aas var1, World var2, class_xa var3, EnumUsedHand var4) {
      var3.a(var1);
      var3.b(class_nc.ad[Item.getId((Item)this)]);
      return new class_or(class_oq.a, var1);
   }

   public static boolean b(class_dn var0) {
      if(var0 == null) {
         return false;
      } else if(!var0.b("pages", 9)) {
         return false;
      } else {
         class_du var1 = var0.c("pages", 8);

         for(int var2 = 0; var2 < var1.c(); ++var2) {
            String var3 = var1.g(var2);
            if(var3 == null) {
               return false;
            }

            if(var3.length() > 32767) {
               return false;
            }
         }

         return true;
      }
   }
}
