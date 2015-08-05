package net.minecraft.server;

import com.mojang.authlib.GameProfile;
import java.util.Date;
import java.util.List;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.class_bz;
import net.minecraft.server.class_cf;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_i;
import net.minecraft.server.EntityPlayer;
import net.minecraft.server.class_m;
import net.minecraft.server.class_mc;
import net.minecraft.server.class_mf;

public class class_r extends class_i {
   public String getCommand() {
      return "ban";
   }

   public int a() {
      return 3;
   }

   public String c(class_m var1) {
      return "commands.ban.usage";
   }

   public boolean canUse(class_m var1) {
      return MinecraftServer.N().getPlayerList().h().b() && super.canUse(var1);
   }

   public void execute(class_m var1, String[] var2) throws class_bz {
      if(var2.length >= 1 && var2[0].length() > 0) {
         MinecraftServer var3 = MinecraftServer.N();
         GameProfile var4 = var3.aF().a(var2[0]);
         if(var4 == null) {
            throw new class_bz("commands.ban.failed", new Object[]{var2[0]});
         } else {
            String var5 = null;
            if(var2.length >= 2) {
               var5 = a(var1, var2, 1).c();
            }

            class_mf var6 = new class_mf(var4, (Date)null, var1.getName(), (Date)null, var5);
            var3.getPlayerList().h().a((class_mc)var6);
            EntityPlayer var7 = var3.getPlayerList().a(var2[0]);
            if(var7 != null) {
               var7.playerConnection.c("You are banned from this server.");
            }

            a(var1, this, "commands.ban.success", new Object[]{var2[0]});
         }
      } else {
         throw new class_cf("commands.ban.usage", new Object[0]);
      }
   }

   public List tabComplete(class_m var1, String[] var2, BlockPosition var3) {
      return var2.length >= 1?a(var2, MinecraftServer.N().K()):null;
   }
}
