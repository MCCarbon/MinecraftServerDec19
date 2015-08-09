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
import net.minecraft.server.EntityHuman;

public class CommandMe extends CommandAbstract {
   public String getCommand() {
      return "me";
   }

   public int a() {
      return 0;
   }

   public String c(ICommandListener var1) {
      return "commands.me.usage";
   }

   public void execute(ICommandListener var1, String[] var2) throws class_bz {
      if(var2.length <= 0) {
         throw new class_cf("commands.me.usage", new Object[0]);
      } else {
         IChatBaseComponent var3 = b(var1, var2, 0, !(var1 instanceof EntityHuman));
         MinecraftServer.N().getPlayerList().a((IChatBaseComponent)(new ChatMessage("chat.type.emote", new Object[]{var1.getScoreboardDisplayName(), var3})));
      }
   }

   public List tabComplete(ICommandListener var1, String[] var2, BlockPosition var3) {
      return a(var2, MinecraftServer.N().getPlayers());
   }
}
