package net.minecraft.server;

import net.minecraft.server.Item;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_acb;
import net.minecraft.server.World;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_du;
import net.minecraft.server.class_ea;
import net.minecraft.server.class_eb;
import net.minecraft.server.class_eu;
import net.minecraft.server.class_ev;
import net.minecraft.server.class_fa;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_gg;
import net.minecraft.server.class_lh;
import net.minecraft.server.class_nc;
import net.minecraft.server.class_nz;
import net.minecraft.server.class_oj;
import net.minecraft.server.class_oo;
import net.minecraft.server.class_oq;
import net.minecraft.server.class_or;
import net.minecraft.server.class_xa;
import net.minecraft.server.class_yx;

public class class_acc extends Item {
   public class_acc() {
      this.d(1);
   }

   public static boolean b(class_dn var0) {
      if(!class_acb.b(var0)) {
         return false;
      } else if(!var0.b("title", 8)) {
         return false;
      } else {
         String var1 = var0.k("title");
         return var1 != null && var1.length() <= 32?var0.b("author", 8):false;
      }
   }

   public static int h(class_aas var0) {
      return var0.o().g("generation");
   }

   public String a(class_aas var1) {
      if(var1.n()) {
         class_dn var2 = var1.o();
         String var3 = var2.k("title");
         if(!class_nz.b(var3)) {
            return var3;
         }
      }

      return super.a(var1);
   }

   public class_or a(class_aas var1, World var2, class_xa var3, class_oo var4) {
      if(!var2.D) {
         this.a(var1, var3);
      }

      var3.a(var1);
      var3.b(class_nc.ad[Item.getId((Item)this)]);
      return new class_or(class_oq.a, var1);
   }

   private void a(class_aas var1, class_xa var2) {
      if(var1 != null && var1.o() != null) {
         class_dn var3 = var1.o();
         if(!var3.o("resolved")) {
            var3.a("resolved", true);
            if(b(var3)) {
               class_du var4 = var3.c("pages", 8);

               for(int var5 = 0; var5 < var4.c(); ++var5) {
                  String var6 = var4.g(var5);

                  Object var7;
                  try {
                     class_eu var11 = class_eu.class_a_in_class_eu.b(var6);
                     var7 = class_ev.a(var2, var11, var2);
                  } catch (Exception var9) {
                     var7 = new class_fa(var6);
                  }

                  var4.a(var5, new class_ea(class_eu.class_a_in_class_eu.a((class_eu)var7)));
               }

               var3.a((String)"pages", (class_eb)var4);
               if(var2 instanceof class_lh && var2.bA() == var1) {
                  class_yx var10 = var2.br.a((class_oj)var2.bp, var2.bp.d);
                  ((class_lh)var2).a.a((class_ff)(new class_gg(0, var10.e, var1)));
               }

            }
         }
      }
   }
}
