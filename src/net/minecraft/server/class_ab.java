package net.minecraft.server;

import java.util.List;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.class_aas;
import net.minecraft.server.class_adi;
import net.minecraft.server.class_bz;
import net.minecraft.server.class_cb;
import net.minecraft.server.class_cf;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_du;
import net.minecraft.server.class_i;
import net.minecraft.server.class_lh;
import net.minecraft.server.class_m;
import net.minecraft.server.class_n;

public class class_ab extends class_i {
   public String c() {
      return "enchant";
   }

   public int a() {
      return 2;
   }

   public String c(class_m var1) {
      return "commands.enchant.usage";
   }

   public void a(class_m var1, String[] var2) throws class_bz {
      if(var2.length < 2) {
         throw new class_cf("commands.enchant.usage", new Object[0]);
      } else {
         class_lh var3 = a(var1, var2[0]);
         var1.a(class_n.class_a_in_class_n.d, 0);

         class_adi var4;
         try {
            var4 = class_adi.c(a(var2[1], 0));
         } catch (class_cb var11) {
            var4 = class_adi.b(var2[1]);
         }

         if(var4 == null) {
            throw new class_cb("commands.enchant.notFound", new Object[]{Integer.valueOf(class_adi.b(var4))});
         } else {
            int var5 = 1;
            class_aas var6 = var3.bA();
            if(var6 == null) {
               throw new class_bz("commands.enchant.noItem", new Object[0]);
            } else if(!var4.a(var6)) {
               throw new class_bz("commands.enchant.cantEnchant", new Object[0]);
            } else {
               if(var2.length >= 3) {
                  var5 = a(var2[2], var4.d(), var4.b());
               }

               if(var6.n()) {
                  class_du var7 = var6.p();
                  if(var7 != null) {
                     for(int var8 = 0; var8 < var7.c(); ++var8) {
                        short var9 = var7.b(var8).f("id");
                        if(class_adi.c(var9) != null) {
                           class_adi var10 = class_adi.c(var9);
                           if(!var4.a(var10)) {
                              throw new class_bz("commands.enchant.cantCombine", new Object[]{var4.d(var5), var10.d(var7.b(var8).f("lvl"))});
                           }
                        }
                     }
                  }
               }

               var6.a(var4, var5);
               a(var1, this, "commands.enchant.success", new Object[0]);
               var1.a(class_n.class_a_in_class_n.d, 1);
            }
         }
      }
   }

   public List a(class_m var1, String[] var2, BlockPosition var3) {
      return var2.length == 1?a(var2, this.d()):(var2.length == 2?a(var2, class_adi.b.getKeys()):null);
   }

   protected String[] d() {
      return MinecraftServer.N().K();
   }

   public boolean b(String[] var1, int var2) {
      return var2 == 0;
   }
}
