package net.minecraft.server;

import java.util.List;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.class_bz;
import net.minecraft.server.class_cd;
import net.minecraft.server.class_cf;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.CommandAbstract;
import net.minecraft.server.EntityPlayer;
import net.minecraft.server.ICommandListener;

public class CommandKick extends CommandAbstract {
   public String getCommand() {
      return "kick";
   }

   public int a() {
      return 3;
   }

   public String c(ICommandListener var1) {
      return "commands.kick.usage";
   }

   public void execute(ICommandListener var1, String[] var2) throws class_bz {
      if(var2.length > 0 && var2[0].length() > 1) {
         EntityPlayer var3 = MinecraftServer.getServer().getPlayerList().a(var2[0]);
         String var4 = "Kicked by an operator.";
         boolean var5 = false;
         if(var3 == null) {
            throw new class_cd();
         } else {
            if(var2.length >= 2) {
               var4 = a(var1, var2, 1).c();
               var5 = true;
            }

            var3.playerConnection.c(var4);
            if(var5) {
               a(var1, this, "commands.kick.success.reason", new Object[]{var3.getName(), var4});
            } else {
               a(var1, this, "commands.kick.success", new Object[]{var3.getName()});
            }

         }
      } else {
         throw new class_cf("commands.kick.usage", new Object[0]);
      }
   }

   public List tabComplete(ICommandListener var1, String[] var2, BlockPosition var3) {
      return var2.length >= 1?a(var2, MinecraftServer.getServer().getPlayers()):null;
   }
}
