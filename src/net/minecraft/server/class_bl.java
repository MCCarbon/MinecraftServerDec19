package net.minecraft.server;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.class_bz;
import net.minecraft.server.class_i;
import net.minecraft.server.class_m;

public class class_bl extends class_i {
   public String getCommand() {
      return "stop";
   }

   public String c(class_m var1) {
      return "commands.stop.usage";
   }

   public void execute(class_m var1, String[] var2) throws class_bz {
      if(MinecraftServer.N().d != null) {
         a(var1, this, "commands.stop.start", new Object[0]);
      }

      MinecraftServer.N().w();
   }
}
