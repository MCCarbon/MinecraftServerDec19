package net.minecraft.server;

import java.util.Iterator;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.WorldSettings;
import net.minecraft.server.CommandGamemode;
import net.minecraft.server.class_bz;
import net.minecraft.server.class_cf;
import net.minecraft.server.ChatMessage;
import net.minecraft.server.EntityPlayer;
import net.minecraft.server.class_m;

public class CommandGamemodeDefault extends CommandGamemode {
   public String getCommand() {
      return "defaultgamemode";
   }

   public String c(class_m var1) {
      return "commands.defaultgamemode.usage";
   }

   public void execute(class_m var1, String[] var2) throws class_bz {
      if(var2.length <= 0) {
         throw new class_cf("commands.defaultgamemode.usage", new Object[0]);
      } else {
         WorldSettings.EnumGameMode var3 = this.h(var1, var2[0]);
         this.a(var3);
         a(var1, this, "commands.defaultgamemode.success", new Object[]{new ChatMessage("gameMode." + var3.getName(), new Object[0])});
      }
   }

   protected void a(WorldSettings.EnumGameMode var1) {
      MinecraftServer var2 = MinecraftServer.N();
      var2.a(var1);
      EntityPlayer var4;
      if(var2.ax()) {
         for(Iterator var3 = MinecraftServer.N().getPlayerList().v().iterator(); var3.hasNext(); var4.O = 0.0F) {
            var4 = (EntityPlayer)var3.next();
            var4.a(var1);
         }
      }

   }
}
