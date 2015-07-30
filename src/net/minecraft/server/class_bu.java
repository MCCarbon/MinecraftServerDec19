package net.minecraft.server;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.class_awj;
import net.minecraft.server.class_awl;
import net.minecraft.server.class_awn;
import net.minecraft.server.class_awt;
import net.minecraft.server.class_bz;
import net.minecraft.server.class_cf;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_i;
import net.minecraft.server.class_lh;
import net.minecraft.server.class_m;
import net.minecraft.server.class_pr;

public class class_bu extends class_i {
   public String c() {
      return "trigger";
   }

   public int a() {
      return 0;
   }

   public String c(class_m var1) {
      return "commands.trigger.usage";
   }

   public void a(class_m var1, String[] var2) throws class_bz {
      if(var2.length < 3) {
         throw new class_cf("commands.trigger.usage", new Object[0]);
      } else {
         class_lh var3;
         if(var1 instanceof class_lh) {
            var3 = (class_lh)var1;
         } else {
            class_pr var4 = var1.f();
            if(!(var4 instanceof class_lh)) {
               throw new class_bz("commands.trigger.invalidPlayer", new Object[0]);
            }

            var3 = (class_lh)var4;
         }

         class_awn var8 = MinecraftServer.N().a(0).aa();
         class_awj var5 = var8.b(var2[0]);
         if(var5 != null && var5.c() == class_awt.c) {
            int var6 = a(var2[2]);
            if(!var8.b(var3.e_(), var5)) {
               throw new class_bz("commands.trigger.invalidObjective", new Object[]{var2[0]});
            } else {
               class_awl var7 = var8.c(var3.e_(), var5);
               if(var7.g()) {
                  throw new class_bz("commands.trigger.disabled", new Object[]{var2[0]});
               } else {
                  if("set".equals(var2[1])) {
                     var7.c(var6);
                  } else {
                     if(!"add".equals(var2[1])) {
                        throw new class_bz("commands.trigger.invalidMode", new Object[]{var2[1]});
                     }

                     var7.a(var6);
                  }

                  var7.a(true);
                  if(var3.c.d()) {
                     a(var1, this, "commands.trigger.success", new Object[]{var2[0], var2[1], var2[2]});
                  }

               }
            }
         } else {
            throw new class_bz("commands.trigger.invalidObjective", new Object[]{var2[0]});
         }
      }
   }

   public List a(class_m var1, String[] var2, BlockPosition var3) {
      if(var2.length == 1) {
         class_awn var4 = MinecraftServer.N().a(0).aa();
         ArrayList var5 = Lists.newArrayList();
         Iterator var6 = var4.c().iterator();

         while(var6.hasNext()) {
            class_awj var7 = (class_awj)var6.next();
            if(var7.c() == class_awt.c) {
               var5.add(var7.b());
            }
         }

         return a(var2, (String[])var5.toArray(new String[var5.size()]));
      } else {
         return var2.length == 2?a(var2, new String[]{"add", "set"}):null;
      }
   }
}
