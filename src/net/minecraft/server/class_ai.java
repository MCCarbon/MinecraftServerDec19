package net.minecraft.server;

import java.util.Iterator;
import java.util.List;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.class_ael;
import net.minecraft.server.class_bz;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.ChatComponentText;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketPlayOutEntityStatus;
import net.minecraft.server.class_i;
import net.minecraft.server.EntityPlayer;
import net.minecraft.server.class_m;
import net.minecraft.server.class_n;

public class class_ai extends class_i {
   public String getCommand() {
      return "gamerule";
   }

   public int a() {
      return 2;
   }

   public String c(class_m var1) {
      return "commands.gamerule.usage";
   }

   public void execute(class_m var1, String[] var2) throws class_bz {
      class_ael var3 = this.d();
      String var4 = var2.length > 0?var2[0]:"";
      String var5 = var2.length > 1?a(var2, 1):"";
      switch(var2.length) {
      case 0:
         var1.a(new ChatComponentText(a(var3.b())));
         break;
      case 1:
         if(!var3.e(var4)) {
            throw new class_bz("commands.gamerule.norule", new Object[]{var4});
         }

         String var6 = var3.a(var4);
         var1.a((new ChatComponentText(var4)).a(" = ").a(var6));
         var1.a(class_n.class_a_in_class_n.e, var3.c(var4));
         break;
      default:
         if(var3.execute(var4, class_ael.class_ael.b) && !"true".equals(var5) && !"false".equals(var5)) {
            throw new class_bz("commands.generic.boolean.invalid", new Object[]{var5});
         }

         var3.a(var4, var5);
         a(var3, var4);
         a(var1, this, "commands.gamerule.success", new Object[0]);
      }

   }

   public static void a(class_ael var0, String var1) {
      if("reducedDebugInfo".equals(var1)) {
         int var2 = var0.b(var1)?22:23;
         Iterator var3 = MinecraftServer.N().getPlayerList().v().iterator();

         while(var3.hasNext()) {
            EntityPlayer var4 = (EntityPlayer)var3.next();
            var4.playerConnection.sendPacket((Packet)(new PacketPlayOutEntityStatus(var4, (byte)var2)));
         }
      }

   }

   public List tabComplete(class_m var1, String[] var2, BlockPosition var3) {
      if(var2.length == 1) {
         return a((String[])var2, (String[])this.d().b());
      } else {
         if(var2.length == 2) {
            class_ael var4 = this.d();
            if(var4.execute(var2[0], class_ael.class_ael.b)) {
               return a((String[])var2, (String[])(new String[]{"true", "false"}));
            }
         }

         return null;
      }
   }

   private class_ael d() {
      return MinecraftServer.N().getWorldServer(0).R();
   }
}
