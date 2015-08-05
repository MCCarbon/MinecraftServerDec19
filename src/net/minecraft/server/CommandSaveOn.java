package net.minecraft.server;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.class_bz;
import net.minecraft.server.CommandAbstract;
import net.minecraft.server.WorldServer;
import net.minecraft.server.class_m;

public class CommandSaveOn extends CommandAbstract {
   public String getCommand() {
      return "save-on";
   }

   public String c(class_m var1) {
      return "commands.save-on.usage";
   }

   public void execute(class_m var1, String[] var2) throws class_bz {
      MinecraftServer var3 = MinecraftServer.N();
      boolean var4 = false;

      for(int var5 = 0; var5 < var3.d.length; ++var5) {
         if(var3.d[var5] != null) {
            WorldServer var6 = var3.d[var5];
            if(var6.c) {
               var6.c = false;
               var4 = true;
            }
         }
      }

      if(var4) {
         a(var1, this, "commands.save.enabled", new Object[0]);
      } else {
         throw new class_bz("commands.save-on.alreadyOn", new Object[0]);
      }
   }
}
