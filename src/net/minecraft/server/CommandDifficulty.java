package net.minecraft.server;

import java.util.List;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.class_bz;
import net.minecraft.server.class_cb;
import net.minecraft.server.class_cf;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.ChatMessage;
import net.minecraft.server.CommandAbstract;
import net.minecraft.server.class_m;
import net.minecraft.server.class_om;

public class CommandDifficulty extends CommandAbstract {
   public String getCommand() {
      return "difficulty";
   }

   public int a() {
      return 2;
   }

   public String c(class_m var1) {
      return "commands.difficulty.usage";
   }

   public void execute(class_m var1, String[] var2) throws class_bz {
      if(var2.length <= 0) {
         throw new class_cf("commands.difficulty.usage", new Object[0]);
      } else {
         class_om var3 = this.e(var2[0]);
         MinecraftServer.N().a(var3);
         a(var1, this, "commands.difficulty.success", new Object[]{new ChatMessage(var3.b(), new Object[0])});
      }
   }

   protected class_om e(String var1) throws class_cb {
      return !var1.equalsIgnoreCase("peaceful") && !var1.equalsIgnoreCase("p")?(!var1.equalsIgnoreCase("easy") && !var1.equalsIgnoreCase("e")?(!var1.equalsIgnoreCase("normal") && !var1.equalsIgnoreCase("n")?(!var1.equalsIgnoreCase("hard") && !var1.equalsIgnoreCase("h")?class_om.a(a(var1, 0, 3)):class_om.d):class_om.c):class_om.b):class_om.a;
   }

   public List tabComplete(class_m var1, String[] var2, BlockPosition var3) {
      return var2.length == 1?a(var2, new String[]{"peaceful", "easy", "normal", "hard"}):null;
   }
}
