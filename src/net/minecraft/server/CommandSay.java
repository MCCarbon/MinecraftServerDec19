package net.minecraft.server;

import java.util.List;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.class_bz;
import net.minecraft.server.class_cf;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.ChatMessage;
import net.minecraft.server.CommandAbstract;
import net.minecraft.server.ICommandListener;

public class CommandSay extends CommandAbstract {
   public String getCommand() {
      return "say";
   }

   public int a() {
      return 1;
   }

   public String c(ICommandListener var1) {
      return "commands.say.usage";
   }

   public void execute(ICommandListener var1, String[] var2) throws class_bz {
      if(var2.length > 0 && var2[0].length() > 0) {
         IChatBaseComponent var3 = b(var1, var2, 0, true);
         MinecraftServer.getServer().getPlayerList().a((IChatBaseComponent)(new ChatMessage("chat.type.announcement", new Object[]{var1.getScoreboardDisplayName(), var3})));
      } else {
         throw new class_cf("commands.say.usage", new Object[0]);
      }
   }

   public List tabComplete(ICommandListener var1, String[] var2, BlockPosition var3) {
      return var2.length >= 1?a(var2, MinecraftServer.getServer().getPlayers()):null;
   }
}
