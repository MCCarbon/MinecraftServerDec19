package net.minecraft.server;

import java.util.Iterator;
import java.util.List;
import net.minecraft.server.class_bz;
import net.minecraft.server.class_ca;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.class_ex;
import net.minecraft.server.class_ey;
import net.minecraft.server.ChatModifier;
import net.minecraft.server.class_fa;
import net.minecraft.server.class_fb;
import net.minecraft.server.class_m;
import net.minecraft.server.class_o;
import net.minecraft.server.class_pr;

public class class_ev {
   public static IChatBaseComponent a(class_m var0, IChatBaseComponent var1, class_pr var2) throws class_bz {
      Object var3 = null;
      if(var1 instanceof class_ex) {
         class_ex var4 = (class_ex)var1;
         String var5 = var4.g();
         if(class_o.b(var5)) {
            List var6 = class_o.b(var0, var5, class_pr.class);
            if(var6.size() != 1) {
               throw new class_ca();
            }

            var5 = ((class_pr)var6.get(0)).e_();
         }

         var3 = var2 != null && var5.equals("*")?new class_ex(var2.e_(), var4.h()):new class_ex(var5, var4.h());
         ((class_ex)var3).b(var4.e());
      } else if(var1 instanceof class_ey) {
         String var7 = ((class_ey)var1).g();
         var3 = class_o.b(var0, var7);
         if(var3 == null) {
            var3 = new class_fa("");
         }
      } else if(var1 instanceof class_fa) {
         var3 = new class_fa(((class_fa)var1).g());
      } else {
         if(!(var1 instanceof class_fb)) {
            return var1;
         }

         Object[] var8 = ((class_fb)var1).j();

         for(int var10 = 0; var10 < var8.length; ++var10) {
            Object var11 = var8[var10];
            if(var11 instanceof IChatBaseComponent) {
               var8[var10] = a(var0, (IChatBaseComponent)var11, var2);
            }
         }

         var3 = new class_fb(((class_fb)var1).i(), var8);
      }

      ChatModifier var9 = var1.b();
      if(var9 != null) {
         ((IChatBaseComponent)var3).a(var9.m());
      }

      Iterator var13 = var1.a().iterator();

      while(var13.hasNext()) {
         IChatBaseComponent var12 = (IChatBaseComponent)var13.next();
         ((IChatBaseComponent)var3).a(a(var0, var12, var2));
      }

      return (IChatBaseComponent)var3;
   }
}
