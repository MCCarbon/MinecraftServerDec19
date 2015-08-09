package net.minecraft.server;

import java.util.List;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.class_bz;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.ChatComponentText;
import net.minecraft.server.ChatMessage;
import net.minecraft.server.CommandAbstract;
import net.minecraft.server.ICommandListener;

public class CommandBanList extends CommandAbstract {
   public String getCommand() {
      return "banlist";
   }

   public int a() {
      return 3;
   }

   public boolean canUse(ICommandListener var1) {
      return (MinecraftServer.N().getPlayerList().i().b() || MinecraftServer.N().getPlayerList().h().b()) && super.canUse(var1);
   }

   public String c(ICommandListener var1) {
      return "commands.banlist.usage";
   }

   public void execute(ICommandListener var1, String[] var2) throws class_bz {
      if(var2.length >= 1 && var2[0].equalsIgnoreCase("ips")) {
         var1.sendMessage(new ChatMessage("commands.banlist.ips", new Object[]{Integer.valueOf(MinecraftServer.N().getPlayerList().i().a().length)}));
         var1.sendMessage(new ChatComponentText(a(MinecraftServer.N().getPlayerList().i().a())));
      } else {
         var1.sendMessage(new ChatMessage("commands.banlist.players", new Object[]{Integer.valueOf(MinecraftServer.N().getPlayerList().h().a().length)}));
         var1.sendMessage(new ChatComponentText(a(MinecraftServer.N().getPlayerList().h().a())));
      }

   }

   public List tabComplete(ICommandListener var1, String[] var2, BlockPosition var3) {
      return var2.length == 1?a(var2, new String[]{"players", "ips"}):null;
   }
}
