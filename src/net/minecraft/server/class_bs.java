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
import net.minecraft.server.PacketPlayOutTitle;
import net.minecraft.server.class_i;
import net.minecraft.server.EntityPlayer;
import net.minecraft.server.class_m;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_bs extends class_i {
   private static final Logger a = LogManager.getLogger();

   public String getCommand() {
      return "title";
   }

   public int a() {
      return 2;
   }

   public String c(class_m var1) {
      return "commands.title.usage";
   }

   public void execute(class_m var1, String[] var2) throws class_bz {
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

         EntityPlayer var3 = a(var1, var2[0]);
         PacketPlayOutTitle.class_a_in_class_hv var4 = PacketPlayOutTitle.class_a_in_class_hv.a(var2[1]);
         if(var4 != PacketPlayOutTitle.class_a_in_class_hv.d && var4 != PacketPlayOutTitle.class_a_in_class_hv.e) {
            if(var4 == PacketPlayOutTitle.class_a_in_class_hv.c) {
               if(var2.length != 5) {
                  throw new class_cf("commands.title.usage", new Object[0]);
               } else {
                  int var11 = a(var2[2]);
                  int var12 = a(var2[3]);
                  int var13 = a(var2[4]);
                  PacketPlayOutTitle var14 = new PacketPlayOutTitle(var11, var12, var13);
                  var3.playerConnection.sendPacket((Packet)var14);
                  a(var1, this, "commands.title.success", new Object[0]);
               }
            } else if(var2.length < 3) {
               throw new class_cf("commands.title.usage", new Object[0]);
            } else {
               String var10 = a(var2, 2);

               IChatBaseComponent var6;
               try {
                  var6 = IChatBaseComponent.ChatSerializer.fromJson(var10);
               } catch (JsonParseException var9) {
            	   throw class_bs.a(var9);
               }

               PacketPlayOutTitle var7 = new PacketPlayOutTitle(var4, class_ev.a(var1, var6, var3));
               var3.playerConnection.sendPacket((Packet)var7);
               a(var1, this, "commands.title.success", new Object[0]);
            }
         } else if(var2.length != 2) {
            throw new class_cf("commands.title.usage", new Object[0]);
         } else {
            PacketPlayOutTitle var5 = new PacketPlayOutTitle(var4, (IChatBaseComponent)null);
            var3.playerConnection.sendPacket((Packet)var5);
            a(var1, this, "commands.title.success", new Object[0]);
         }
      }
   }

   public List tabComplete(class_m var1, String[] var2, BlockPosition var3) {
      return var2.length == 1?a(var2, MinecraftServer.N().K()):(var2.length == 2?a(var2, PacketPlayOutTitle.class_a_in_class_hv.a()):null);
   }

   public boolean isListStart(String[] var1, int var2) {
      return var2 == 0;
   }
}
