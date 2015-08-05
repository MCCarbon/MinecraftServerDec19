package net.minecraft.server;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.class_aeo;
import net.minecraft.server.class_bz;
import net.minecraft.server.ChatMessage;
import net.minecraft.server.CommandAbstract;
import net.minecraft.server.WorldServer;
import net.minecraft.server.class_m;
import net.minecraft.server.class_nw;

public class CommandSaveAll extends CommandAbstract {
   public String getCommand() {
      return "save-all";
   }

   public String c(class_m var1) {
      return "commands.save.usage";
   }

   public void execute(class_m var1, String[] var2) throws class_bz {
      MinecraftServer var3 = MinecraftServer.N();
      var1.a(new ChatMessage("commands.save.start", new Object[0]));
      if(var3.getPlayerList() != null) {
         var3.getPlayerList().j();
      }

      try {
         int var4;
         WorldServer var5;
         boolean var6;
         for(var4 = 0; var4 < var3.d.length; ++var4) {
            if(var3.d[var4] != null) {
               var5 = var3.d[var4];
               var6 = var5.c;
               var5.c = false;
               var5.a(true, (class_nw)null);
               var5.c = var6;
            }
         }

         if(var2.length > 0 && "flush".equals(var2[0])) {
            var1.a(new ChatMessage("commands.save.flushStart", new Object[0]));

            for(var4 = 0; var4 < var3.d.length; ++var4) {
               if(var3.d[var4] != null) {
                  var5 = var3.d[var4];
                  var6 = var5.c;
                  var5.c = false;
                  var5.o();
                  var5.c = var6;
               }
            }

            var1.a(new ChatMessage("commands.save.flushEnd", new Object[0]));
         }
      } catch (class_aeo var7) {
         a(var1, this, "commands.save.failed", new Object[]{var7.getMessage()});
         return;
      }

      a(var1, this, "commands.save.success", new Object[0]);
   }
}
