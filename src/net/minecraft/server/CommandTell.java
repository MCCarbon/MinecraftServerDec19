package net.minecraft.server;

import java.util.Arrays;
import java.util.List;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.EnumChatFormat;
import net.minecraft.server.class_bz;
import net.minecraft.server.class_cd;
import net.minecraft.server.class_cf;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.ChatMessage;
import net.minecraft.server.CommandAbstract;
import net.minecraft.server.EntityPlayer;
import net.minecraft.server.ICommandListener;
import net.minecraft.server.EntityHuman;

public class CommandTell extends CommandAbstract {
   public List b() {
      return Arrays.asList(new String[]{"w", "msg"});
   }

   public String getCommand() {
      return "tell";
   }

   public int a() {
      return 0;
   }

   public String c(ICommandListener var1) {
      return "commands.message.usage";
   }

   public void execute(ICommandListener var1, String[] var2) throws class_bz {
      if(var2.length < 2) {
         throw new class_cf("commands.message.usage", new Object[0]);
      } else {
         EntityPlayer var3 = a(var1, var2[0]);
         if(var3 == var1) {
            throw new class_cd("commands.message.sameTarget", new Object[0]);
         } else {
            IChatBaseComponent var4 = b(var1, var2, 1, !(var1 instanceof EntityHuman));
            ChatMessage var5 = new ChatMessage("commands.message.display.incoming", new Object[]{var1.getScoreboardDisplayName(), var4.f()});
            ChatMessage var6 = new ChatMessage("commands.message.display.outgoing", new Object[]{var3.getScoreboardDisplayName(), var4.f()});
            var5.getChatModifier().a(EnumChatFormat.GRAY).b(Boolean.valueOf(true));
            var6.getChatModifier().a(EnumChatFormat.GRAY).b(Boolean.valueOf(true));
            var3.sendMessage((IChatBaseComponent)var5);
            var1.sendMessage(var6);
         }
      }
   }

   public List tabComplete(ICommandListener var1, String[] var2, BlockPosition var3) {
      return a(var2, MinecraftServer.getServer().getPlayers());
   }

   public boolean isListStart(String[] var1, int var2) {
      return var2 == 0;
   }
}
