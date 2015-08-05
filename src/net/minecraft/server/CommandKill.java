package net.minecraft.server;

import java.util.List;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.class_bz;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.CommandAbstract;
import net.minecraft.server.EntityPlayer;
import net.minecraft.server.class_m;
import net.minecraft.server.Entity;

public class CommandKill extends CommandAbstract {
   public String getCommand() {
      return "kill";
   }

   public int a() {
      return 2;
   }

   public String c(class_m var1) {
      return "commands.kill.usage";
   }

   public void execute(class_m var1, String[] var2) throws class_bz {
      if(var2.length == 0) {
         EntityPlayer var4 = b(var1);
         var4.G();
         a(var1, this, "commands.kill.successful", new Object[]{var4.getScoreboardDisplayName()});
      } else {
         Entity var3 = b(var1, var2[0]);
         var3.G();
         a(var1, this, "commands.kill.successful", new Object[]{var3.getScoreboardDisplayName()});
      }
   }

   public boolean isListStart(String[] var1, int var2) {
      return var2 == 0;
   }

   public List tabComplete(class_m var1, String[] var2, BlockPosition var3) {
      return var2.length == 1?a(var2, MinecraftServer.N().K()):null;
   }
}
