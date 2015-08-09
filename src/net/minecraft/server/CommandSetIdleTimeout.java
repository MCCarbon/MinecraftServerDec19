package net.minecraft.server;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.class_bz;
import net.minecraft.server.class_cf;
import net.minecraft.server.CommandAbstract;
import net.minecraft.server.ICommandListener;

public class CommandSetIdleTimeout extends CommandAbstract {
   public String getCommand() {
      return "setidletimeout";
   }

   public int a() {
      return 3;
   }

   public String c(ICommandListener var1) {
      return "commands.setidletimeout.usage";
   }

   public void execute(ICommandListener var1, String[] var2) throws class_bz {
      if(var2.length != 1) {
         throw new class_cf("commands.setidletimeout.usage", new Object[0]);
      } else {
         int var3 = a(var2[0], 0);
         MinecraftServer.N().d(var3);
         a(var1, this, "commands.setidletimeout.success", new Object[]{Integer.valueOf(var3)});
      }
   }
}
