package net.minecraft.server;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.EnumChatFormat;
import net.minecraft.server.class_bz;
import net.minecraft.server.class_cb;
import net.minecraft.server.class_ce;
import net.minecraft.server.class_cf;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_et;
import net.minecraft.server.ChatMessage;
import net.minecraft.server.CommandAbstract;
import net.minecraft.server.ICommand;
import net.minecraft.server.ICommandListener;
import net.minecraft.server.MathHelper;
import net.minecraft.server.EntityHuman;

public class CommandHelp extends CommandAbstract {
   public String getCommand() {
      return "help";
   }

   public int a() {
      return 0;
   }

   public String c(ICommandListener var1) {
      return "commands.help.usage";
   }

   public List b() {
      return Arrays.asList(new String[]{"?"});
   }

   public void execute(ICommandListener var1, String[] var2) throws class_bz {
      List var3 = this.d(var1);
      boolean var4 = true;
      int var5 = (var3.size() - 1) / 7;
      boolean var6 = false;

      int var13;
      try {
         var13 = var2.length == 0?0:a(var2[0], 1, var5 + 1) - 1;
      } catch (class_cb var12) {
         Map var8 = this.d();
         ICommand var9 = (ICommand)var8.get(var2[0]);
         if(var9 != null) {
            throw new class_cf(var9.c(var1), new Object[0]);
         }

         if(MathHelper.parseIntWithDef(var2[0], -1) != -1) {
            throw var12;
         }

         throw new class_ce();
      }

      int var7 = Math.min((var13 + 1) * 7, var3.size());
      ChatMessage var14 = new ChatMessage("commands.help.header", new Object[]{Integer.valueOf(var13 + 1), Integer.valueOf(var5 + 1)});
      var14.getChatModifier().a(EnumChatFormat.DARK_GREEN);
      var1.sendMessage(var14);

      for(int var15 = var13 * 7; var15 < var7; ++var15) {
         ICommand var10 = (ICommand)var3.get(var15);
         ChatMessage var11 = new ChatMessage(var10.c(var1), new Object[0]);
         var11.getChatModifier().a(new class_et(class_et.class_a_in_class_et.d, "/" + var10.getCommand() + " "));
         var1.sendMessage(var11);
      }

      if(var13 == 0 && var1 instanceof EntityHuman) {
         ChatMessage var16 = new ChatMessage("commands.help.footer", new Object[0]);
         var16.getChatModifier().a(EnumChatFormat.GREEN);
         var1.sendMessage(var16);
      }

   }

   protected List d(ICommandListener var1) {
      List var2 = MinecraftServer.getServer().P().a(var1);
      Collections.sort(var2);
      return var2;
   }

   protected Map d() {
      return MinecraftServer.getServer().P().a();
   }

   public List tabComplete(ICommandListener var1, String[] var2, BlockPosition var3) {
      if(var2.length == 1) {
         Set var4 = this.d().keySet();
         return a(var2, (String[])var4.toArray(new String[var4.size()]));
      } else {
         return null;
      }
   }
}
