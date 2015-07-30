package net.minecraft.server;

import com.google.gson.JsonParseException;
import java.util.List;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.class_bz;
import net.minecraft.server.class_cc;
import net.minecraft.server.class_cf;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.class_ev;
import net.minecraft.server.Packet;
import net.minecraft.server.class_hv;
import net.minecraft.server.class_i;
import net.minecraft.server.class_lh;
import net.minecraft.server.class_m;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_bs extends class_i {
   private static final Logger a = LogManager.getLogger();

   public String c() {
      return "title";
   }

   public int a() {
      return 2;
   }

   public String c(class_m var1) {
      return "commands.title.usage";
   }

   public void a(class_m var1, String[] var2) throws class_bz {
      if(var2.length < 2) {
         throw new class_cf("commands.title.usage", new Object[0]);
      } else {
         if(var2.length < 3) {
            if("title".equals(var2[1]) || "subtitle".equals(var2[1])) {
               throw new class_cf("commands.title.usage.title", new Object[0]);
            }

            if("times".equals(var2[1])) {
               throw new class_cf("commands.title.usage.times", new Object[0]);
            }
         }

         class_lh var3 = a(var1, var2[0]);
         class_hv.class_a_in_class_hv var4 = class_hv.class_a_in_class_hv.a(var2[1]);
         if(var4 != class_hv.class_a_in_class_hv.d && var4 != class_hv.class_a_in_class_hv.e) {
            if(var4 == class_hv.class_a_in_class_hv.c) {
               if(var2.length != 5) {
                  throw new class_cf("commands.title.usage", new Object[0]);
               } else {
                  int var11 = a(var2[2]);
                  int var12 = a(var2[3]);
                  int var13 = a(var2[4]);
                  class_hv var14 = new class_hv(var11, var12, var13);
                  var3.a.a((Packet)var14);
                  a(var1, this, "commands.title.success", new Object[0]);
               }
            } else if(var2.length < 3) {
               throw new class_cf("commands.title.usage", new Object[0]);
            } else {
               String var10 = a(var2, 2);

               IChatBaseComponent var6;
               try {
                  var6 = IChatBaseComponent.class_a_in_class_eu.a(var10);
               } catch (JsonParseException var9) {
            	   throw class_bs.a(var9);
               }

               class_hv var7 = new class_hv(var4, class_ev.a(var1, var6, var3));
               var3.a.a((Packet)var7);
               a(var1, this, "commands.title.success", new Object[0]);
            }
         } else if(var2.length != 2) {
            throw new class_cf("commands.title.usage", new Object[0]);
         } else {
            class_hv var5 = new class_hv(var4, (IChatBaseComponent)null);
            var3.a.a((Packet)var5);
            a(var1, this, "commands.title.success", new Object[0]);
         }
      }
   }

   public List a(class_m var1, String[] var2, BlockPosition var3) {
      return var2.length == 1?a(var2, MinecraftServer.N().K()):(var2.length == 2?a(var2, class_hv.class_a_in_class_hv.a()):null);
   }

   public boolean b(String[] var1, int var2) {
      return var2 == 0;
   }
}
