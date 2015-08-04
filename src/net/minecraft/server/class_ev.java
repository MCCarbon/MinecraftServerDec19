package net.minecraft.server;

import java.util.Iterator;
import java.util.List;
import net.minecraft.server.class_bz;
import net.minecraft.server.class_ca;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.ChatComponentScore;
import net.minecraft.server.ChatComponentSelector;
import net.minecraft.server.ChatModifier;
import net.minecraft.server.ChatComponentText;
import net.minecraft.server.ChatMessage;
import net.minecraft.server.class_m;
import net.minecraft.server.class_o;
import net.minecraft.server.Entity;

public class class_ev {
   public static IChatBaseComponent a(class_m var0, IChatBaseComponent var1, Entity var2) throws class_bz {
      Object var3 = null;
      if(var1 instanceof ChatComponentScore) {
         ChatComponentScore var4 = (ChatComponentScore)var1;
         String var5 = var4.g();
         if(class_o.b(var5)) {
            List var6 = class_o.b(var0, var5, Entity.class);
            if(var6.size() != 1) {
               throw new class_ca();
            }

            var5 = ((Entity)var6.get(0)).getName();
         }

         var3 = var2 != null && var5.equals("*")?new ChatComponentScore(var2.getName(), var4.h()):new ChatComponentScore(var5, var4.h());
         ((ChatComponentScore)var3).b(var4.getText());
      } else if(var1 instanceof ChatComponentSelector) {
         String var7 = ((ChatComponentSelector)var1).g();
         var3 = class_o.b(var0, var7);
         if(var3 == null) {
            var3 = new ChatComponentText("");
         }
      } else if(var1 instanceof ChatComponentText) {
         var3 = new ChatComponentText(((ChatComponentText)var1).g());
      } else {
         if(!(var1 instanceof ChatMessage)) {
            return var1;
         }

         Object[] var8 = ((ChatMessage)var1).j();

         for(int var10 = 0; var10 < var8.length; ++var10) {
            Object var11 = var8[var10];
            if(var11 instanceof IChatBaseComponent) {
               var8[var10] = a(var0, (IChatBaseComponent)var11, var2);
            }
         }

         var3 = new ChatMessage(((ChatMessage)var1).i(), var8);
      }

      ChatModifier var9 = var1.getChatModifier();
      if(var9 != null) {
         ((IChatBaseComponent)var3).a(var9.m());
      }

      Iterator var13 = var1.a().iterator();

      while(var13.hasNext()) {
         IChatBaseComponent var12 = (IChatBaseComponent)var13.next();
         ((IChatBaseComponent)var3).addSibling(a(var0, var12, var2));
      }

      return (IChatBaseComponent)var3;
   }
}
