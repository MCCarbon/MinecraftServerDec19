package net.minecraft.server;

import java.util.List;
import net.minecraft.server.class_aen;
import net.minecraft.server.class_agj;
import net.minecraft.server.class_agk;
import net.minecraft.server.class_amg;
import net.minecraft.server.class_anl;
import net.minecraft.server.class_bz;
import net.minecraft.server.class_cf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_ec;
import net.minecraft.server.class_ed;
import net.minecraft.server.class_i;
import net.minecraft.server.class_m;
import net.minecraft.server.class_n;
import net.minecraft.server.class_oj;

public class class_be extends class_i {
   public String c() {
      return "setblock";
   }

   public int a() {
      return 2;
   }

   public String c(class_m var1) {
      return "commands.setblock.usage";
   }

   public void a(class_m var1, String[] var2) throws class_bz {
      if(var2.length < 4) {
         throw new class_cf("commands.setblock.usage", new Object[0]);
      } else {
         var1.a(class_n.class_a_in_class_n.b, 0);
         class_cj var3 = a(var1, var2, 0, false);
         class_agj var4 = class_i.g(var1, var2[3]);
         int var5 = 0;
         if(var2.length >= 5) {
            var5 = a(var2[4], 0, 15);
         }

         class_aen var6 = var1.e();
         if(!var6.e(var3)) {
            throw new class_bz("commands.setblock.outOfWorld", new Object[0]);
         } else {
            class_dn var7 = new class_dn();
            boolean var8 = false;
            if(var2.length >= 7 && var4.B()) {
               String var9 = a(var1, var2, 6).c();

               try {
                  var7 = class_ed.a(var9);
                  var8 = true;
               } catch (class_ec var12) {
                  throw new class_bz("commands.setblock.tagError", new Object[]{var12.getMessage()});
               }
            }

            if(var2.length >= 6) {
               if(var2[5].equals("destroy")) {
                  var6.b(var3, true);
                  if(var4 == class_agk.a) {
                     a(var1, this, "commands.setblock.success", new Object[0]);
                     return;
                  }
               } else if(var2[5].equals("keep") && !var6.d(var3)) {
                  throw new class_bz("commands.setblock.noChange", new Object[0]);
               }
            }

            class_amg var13 = var6.s(var3);
            if(var13 != null) {
               if(var13 instanceof class_oj) {
                  ((class_oj)var13).l();
               }

               var6.a(var3, class_agk.a.S(), var4 == class_agk.a?2:4);
            }

            class_anl var10 = var4.a(var5);
            if(!var6.a((class_cj)var3, (class_anl)var10, 2)) {
               throw new class_bz("commands.setblock.noChange", new Object[0]);
            } else {
               if(var8) {
                  class_amg var11 = var6.s(var3);
                  if(var11 != null) {
                     var7.a("x", var3.n());
                     var7.a("y", var3.o());
                     var7.a("z", var3.p());
                     var11.a(var7);
                  }
               }

               var6.b(var3, var10.c());
               var1.a(class_n.class_a_in_class_n.b, 1);
               a(var1, this, "commands.setblock.success", new Object[0]);
            }
         }
      }
   }

   public List a(class_m var1, String[] var2, class_cj var3) {
      return var2.length > 0 && var2.length <= 3?a(var2, 0, var3):(var2.length == 4?a(var2, class_agj.c.c()):(var2.length == 6?a(var2, new String[]{"replace", "destroy", "keep"}):null));
   }
}
