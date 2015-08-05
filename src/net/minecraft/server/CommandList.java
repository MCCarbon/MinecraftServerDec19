package net.minecraft.server;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.class_bz;
import net.minecraft.server.ChatComponentText;
import net.minecraft.server.ChatMessage;
import net.minecraft.server.CommandAbstract;
import net.minecraft.server.class_m;
import net.minecraft.server.class_n;

public class CommandList extends CommandAbstract {
   public String getCommand() {
      return "list";
   }

   public int a() {
      return 0;
   }

   public String c(class_m var1) {
      return "commands.players.usage";
   }

   public void execute(class_m var1, String[] var2) throws class_bz {
      int var3 = MinecraftServer.N().I();
      var1.a(new ChatMessage("commands.players.list", new Object[]{Integer.valueOf(var3), Integer.valueOf(MinecraftServer.N().J())}));
      var1.a(new ChatComponentText(MinecraftServer.N().getPlayerList().b(var2.length > 0 && "uuids".equalsIgnoreCase(var2[0]))));
      var1.a(class_n.class_a_in_class_n.e, var3);
   }
}
