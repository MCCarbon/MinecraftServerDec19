package net.minecraft.server;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.class_aeq;
import net.minecraft.server.class_bz;
import net.minecraft.server.class_i;
import net.minecraft.server.class_m;

public class class_aw extends class_i {
   public String c() {
      return "publish";
   }

   public String c(class_m var1) {
      return "commands.publish.usage";
   }

   public void a(class_m var1, String[] var2) throws class_bz {
      String var3 = MinecraftServer.N().a(class_aeq.class_a_in_class_aeq.b, false);
      if(var3 != null) {
         a(var1, this, "commands.publish.started", new Object[]{var3});
      } else {
         a(var1, this, "commands.publish.failed", new Object[0]);
      }

   }
}
