package net.minecraft.server;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.class_bz;
import net.minecraft.server.class_cf;
import net.minecraft.server.class_i;
import net.minecraft.server.class_m;

public class class_bg extends class_i {
   public String getCommand() {
      return "setidletimeout";
   }

   public int a() {
      return 3;
   }

   public String c(class_m var1) {
      return "commands.setidletimeout.usage";
   }

   public void execute(class_m var1, String[] var2) throws class_bz {
      if(var2.length != 1) {
         throw new class_cf("commands.setidletimeout.usage", new Object[0]);
      } else {
         int var3 = a(var2[0], 0);
         MinecraftServer.N().d(var3);
         a(var1, this, "commands.setidletimeout.success", new Object[]{Integer.valueOf(var3)});
      }
   }
}
