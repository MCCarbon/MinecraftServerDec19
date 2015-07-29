package net.minecraft.server;

import java.util.Random;
import net.minecraft.server.Item;
import net.minecraft.server.class_aas;
import net.minecraft.server.Items;
import net.minecraft.server.class_abf;
import net.minecraft.server.class_adi;
import net.minecraft.server.class_adk;
import net.minecraft.server.class_adl;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_du;
import net.minecraft.server.class_eb;
import net.minecraft.server.class_od;

public class class_aad extends Item {
   public boolean f_(class_aas var1) {
      return false;
   }

   public class_abf g(class_aas var1) {
      return !this.h(var1).c_()?class_abf.b:super.g(var1);
   }

   public class_du h(class_aas var1) {
      class_dn var2 = var1.o();
      return var2 != null && var2.b("StoredEnchantments", 9)?(class_du)var2.b("StoredEnchantments"):new class_du();
   }

   public void a(class_aas var1, class_adl var2) {
      class_du var3 = this.h(var1);
      boolean var4 = true;

      for(int var5 = 0; var5 < var3.c(); ++var5) {
         class_dn var6 = var3.b(var5);
         if(class_adi.c(var6.f("id")) == var2.b) {
            if(var6.f("lvl") < var2.c) {
               var6.a("lvl", (short)var2.c);
            }

            var4 = false;
            break;
         }
      }

      if(var4) {
         class_dn var7 = new class_dn();
         var7.a("id", (short)class_adi.b(var2.b));
         var7.a("lvl", (short)var2.c);
         var3.a((class_eb)var7);
      }

      if(!var1.n()) {
         var1.d(new class_dn());
      }

      var1.o().a((String)"StoredEnchantments", (class_eb)var3);
   }

   public class_aas a(class_adl var1) {
      class_aas var2 = new class_aas(this);
      this.a(var2, var1);
      return var2;
   }

   public class_od b(Random var1) {
      return this.a(var1, 1, 1, 1);
   }

   public class_od a(Random var1, int var2, int var3, int var4) {
      class_aas var5 = new class_aas(Items.aN);
      class_adk.a(var1, var5, 30);
      return new class_od(var5, var2, var3, var4);
   }
}
