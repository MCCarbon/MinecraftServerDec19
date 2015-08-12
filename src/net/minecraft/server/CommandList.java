package net.minecraft.server;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.class_bz;
import net.minecraft.server.ChatComponentText;
import net.minecraft.server.ChatMessage;
import net.minecraft.server.CommandAbstract;
import net.minecraft.server.ICommandListener;
import net.minecraft.server.CommandObjectiveExecutor;

public class CommandList extends CommandAbstract {
   public String getCommand() {
      return "list";
   }

   public int a() {
      return 0;
   }

   public String c(ICommandListener var1) {
      return "commands.players.usage";
   }

   public void execute(ICommandListener var1, String[] var2) throws class_bz {
      int var3 = MinecraftServer.getServer().I();
      var1.sendMessage(new ChatMessage("commands.players.list", new Object[]{Integer.valueOf(var3), Integer.valueOf(MinecraftServer.getServer().J())}));
      var1.sendMessage(new ChatComponentText(MinecraftServer.getServer().getPlayerList().b(var2.length > 0 && "uuids".equalsIgnoreCase(var2[0]))));
      var1.a(CommandObjectiveExecutor.class_a_in_class_n.e, var3);
   }
}
