package net.minecraft.server;

import java.util.List;
import java.util.regex.Matcher;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.class_bz;
import net.minecraft.server.class_cc;
import net.minecraft.server.class_cf;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.CommandAbstract;
import net.minecraft.server.ICommandListener;
import net.minecraft.server.CommandBanIp;

public class CommandPardonIp extends CommandAbstract {
   public String getCommand() {
      return "pardon-ip";
   }

   public int a() {
      return 3;
   }

   public boolean canUse(ICommandListener var1) {
      return MinecraftServer.N().getPlayerList().i().b() && super.canUse(var1);
   }

   public String c(ICommandListener var1) {
      return "commands.unbanip.usage";
   }

   public void execute(ICommandListener var1, String[] var2) throws class_bz {
      if(var2.length == 1 && var2[0].length() > 1) {
         Matcher var3 = CommandBanIp.a.matcher(var2[0]);
         if(var3.matches()) {
            MinecraftServer.N().getPlayerList().i().c(var2[0]);
            a(var1, this, "commands.unbanip.success", new Object[]{var2[0]});
         } else {
            throw new class_cc("commands.unbanip.invalid", new Object[0]);
         }
      } else {
         throw new class_cf("commands.unbanip.usage", new Object[0]);
      }
   }

   public List tabComplete(ICommandListener var1, String[] var2, BlockPosition var3) {
      return var2.length == 1?a(var2, MinecraftServer.N().getPlayerList().i().a()):null;
   }
}
