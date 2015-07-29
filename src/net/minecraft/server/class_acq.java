package net.minecraft.server;

import net.minecraft.server.class_aas;
import net.minecraft.server.class_aau;
import net.minecraft.server.class_acv;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_avf;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_yg;

public class class_acq extends class_acv {
   public class_acq() {
      super(3, 3, new class_aas[]{new class_aas(class_aau.aM), new class_aas(class_aau.aM), new class_aas(class_aau.aM), new class_aas(class_aau.aM), new class_aas(class_aau.bf, 0, 32767), new class_aas(class_aau.aM), new class_aas(class_aau.aM), new class_aas(class_aau.aM), new class_aas(class_aau.aM)}, new class_aas(class_aau.bY, 0, 0));
   }

   public boolean a(class_yg var1, class_aen var2) {
      if(!super.a(var1, var2)) {
         return false;
      } else {
         class_aas var3 = null;

         for(int var4 = 0; var4 < var1.o_() && var3 == null; ++var4) {
            class_aas var5 = var1.a(var4);
            if(var5 != null && var5.b() == class_aau.bf) {
               var3 = var5;
            }
         }

         if(var3 == null) {
            return false;
         } else {
            class_avf var6 = class_aau.bf.a(var3, var2);
            return var6 == null?false:var6.e < 4;
         }
      }
   }

   public class_aas a(class_yg var1) {
      class_aas var2 = null;

      for(int var3 = 0; var3 < var1.o_() && var2 == null; ++var3) {
         class_aas var4 = var1.a(var3);
         if(var4 != null && var4.b() == class_aau.bf) {
            var2 = var4;
         }
      }

      var2 = var2.k();
      var2.b = 1;
      if(var2.o() == null) {
         var2.d(new class_dn());
      }

      var2.o().a("map_is_scaling", true);
      return var2;
   }
}
