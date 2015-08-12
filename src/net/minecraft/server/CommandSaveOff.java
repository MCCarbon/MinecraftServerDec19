package net.minecraft.server;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.class_bz;
import net.minecraft.server.CommandAbstract;
import net.minecraft.server.WorldServer;
import net.minecraft.server.ICommandListener;

public class CommandSaveOff extends CommandAbstract {
   public String getCommand() {
      return "save-off";
   }

   public String c(ICommandListener var1) {
      return "commands.save-off.usage";
   }

   public void execute(ICommandListener var1, String[] var2) throws class_bz {
      MinecraftServer var3 = MinecraftServer.getServer();
      boolean var4 = false;

      for(int var5 = 0; var5 < var3.d.length; ++var5) {
         if(var3.d[var5] != null) {
            WorldServer var6 = var3.d[var5];
            if(!var6.c) {
               var6.c = true;
               var4 = true;
            }
         }
      }

      if(var4) {
         a(var1, this, "commands.save.disabled", new Object[0]);
      } else {
         throw new class_bz("commands.save-off.alreadyOff", new Object[0]);
      }
   }
}
