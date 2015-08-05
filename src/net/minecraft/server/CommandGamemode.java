package net.minecraft.server;

import java.util.List;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.WorldSettings;
import net.minecraft.server.class_bz;
import net.minecraft.server.class_cb;
import net.minecraft.server.class_cf;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.ChatMessage;
import net.minecraft.server.CommandAbstract;
import net.minecraft.server.EntityPlayer;
import net.minecraft.server.class_m;

public class CommandGamemode extends CommandAbstract {
   public String getCommand() {
      return "gamemode";
   }

   public int a() {
      return 2;
   }

   public String c(class_m var1) {
      return "commands.gamemode.usage";
   }

   public void execute(class_m var1, String[] var2) throws class_bz {
      if(var2.length <= 0) {
         throw new class_cf("commands.gamemode.usage", new Object[0]);
      } else {
         WorldSettings.EnumGameMode var3 = this.h(var1, var2[0]);
         EntityPlayer var4 = var2.length >= 2?a(var1, var2[1]):b(var1);
         var4.a(var3);
         var4.O = 0.0F;
         if(var1.e().R().b("sendCommandFeedback")) {
            var4.a((IChatBaseComponent)(new ChatMessage("gameMode.changed", new Object[0])));
         }

         ChatMessage var5 = new ChatMessage("gameMode." + var3.getName(), new Object[0]);
         if(var4 != var1) {
            a(var1, this, 1, "commands.gamemode.success.other", new Object[]{var4.getName(), var5});
         } else {
            a(var1, this, 1, "commands.gamemode.success.self", new Object[]{var5});
         }

      }
   }

   protected WorldSettings.EnumGameMode h(class_m var1, String var2) throws class_cb {
      return !var2.equalsIgnoreCase(WorldSettings.EnumGameMode.SURVIVAL.getName()) && !var2.equalsIgnoreCase("s")?(!var2.equalsIgnoreCase(WorldSettings.EnumGameMode.CREATIVE.getName()) && !var2.equalsIgnoreCase("c")?(!var2.equalsIgnoreCase(WorldSettings.EnumGameMode.ADVENTURE.getName()) && !var2.equalsIgnoreCase("a")?(!var2.equalsIgnoreCase(WorldSettings.EnumGameMode.SPECTATOR.getName()) && !var2.equalsIgnoreCase("sp")?WorldSettings.a(a(var2, 0, WorldSettings.EnumGameMode.values().length - 2)):WorldSettings.EnumGameMode.SPECTATOR):WorldSettings.EnumGameMode.ADVENTURE):WorldSettings.EnumGameMode.CREATIVE):WorldSettings.EnumGameMode.SURVIVAL;
   }

   public List tabComplete(class_m var1, String[] var2, BlockPosition var3) {
      return var2.length == 1?a(var2, new String[]{"survival", "creative", "adventure", "spectator"}):(var2.length == 2?a(var2, this.d()):null);
   }

   protected String[] d() {
      return MinecraftServer.N().K();
   }

   public boolean isListStart(String[] var1, int var2) {
      return var2 == 1;
   }
}
