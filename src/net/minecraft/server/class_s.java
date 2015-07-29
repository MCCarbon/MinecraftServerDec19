package net.minecraft.server;

import java.util.List;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_bz;
import net.minecraft.server.class_cf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_ec;
import net.minecraft.server.class_ed;
import net.minecraft.server.class_i;
import net.minecraft.server.class_m;
import net.minecraft.server.class_n;

public class class_s extends class_i {
   public String c() {
      return "blockdata";
   }

   public int a() {
      return 2;
   }

   public String c(class_m var1) {
      return "commands.blockdata.usage";
   }

   public void a(class_m var1, String[] var2) throws class_bz {
      if(var2.length < 4) {
         throw new class_cf("commands.blockdata.usage", new Object[0]);
      } else {
         var1.a(class_n.class_a_in_class_n.b, 0);
         class_cj var3 = a(var1, var2, 0, false);
         class_aen var4 = var1.e();
         if(!var4.e(var3)) {
            throw new class_bz("commands.blockdata.outOfWorld", new Object[0]);
         } else {
            class_amg var5 = var4.s(var3);
            if(var5 == null) {
               throw new class_bz("commands.blockdata.notValid", new Object[0]);
            } else {
               class_dn var6 = new class_dn();
               var5.b(var6);
               class_dn var7 = (class_dn)var6.b();

               class_dn var8;
               try {
                  var8 = class_ed.a(a(var1, var2, 3).c());
               } catch (class_ec var10) {
                  throw new class_bz("commands.blockdata.tagError", new Object[]{var10.getMessage()});
               }

               var6.a(var8);
               var6.a("x", var3.n());
               var6.a("y", var3.o());
               var6.a("z", var3.p());
               if(var6.equals(var7)) {
                  throw new class_bz("commands.blockdata.failed", new Object[]{var6.toString()});
               } else {
                  var5.a(var6);
                  var5.p_();
                  var4.h(var3);
                  var1.a(class_n.class_a_in_class_n.b, 1);
                  a(var1, this, "commands.blockdata.success", new Object[]{var6.toString()});
               }
            }
         }
      }
   }

   public List a(class_m var1, String[] var2, class_cj var3) {
      return var2.length > 0 && var2.length <= 3?a(var2, 0, var3):null;
   }
}
