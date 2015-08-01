package net.minecraft.server;

import com.mojang.authlib.GameProfile;
import java.util.List;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.class_bz;
import net.minecraft.server.class_cf;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_fa;
import net.minecraft.server.class_fb;
import net.minecraft.server.class_i;
import net.minecraft.server.class_m;

public class class_bw extends class_i {
   public String c() {
      return "whitelist";
   }

   public int a() {
      return 3;
   }

   public String c(class_m var1) {
      return "commands.whitelist.usage";
   }

   public void a(class_m var1, String[] var2) throws class_bz {
      if(var2.length < 1) {
         throw new class_cf("commands.whitelist.usage", new Object[0]);
      } else {
         MinecraftServer var3 = MinecraftServer.N();
         if(var2[0].equals("on")) {
            var3.getPlayerList().setHasWhitelist(true);
            a(var1, this, "commands.whitelist.enabled", new Object[0]);
         } else if(var2[0].equals("off")) {
            var3.getPlayerList().setHasWhitelist(false);
            a(var1, this, "commands.whitelist.disabled", new Object[0]);
         } else if(var2[0].equals("list")) {
            var1.a(new class_fb("commands.whitelist.list", new Object[]{Integer.valueOf(var3.getPlayerList().l().length), Integer.valueOf(var3.getPlayerList().q().length)}));
            String[] var4 = var3.getPlayerList().l();
            var1.a(new class_fa(a(var4)));
         } else {
            GameProfile var5;
            if(var2[0].equals("add")) {
               if(var2.length < 2) {
                  throw new class_cf("commands.whitelist.add.usage", new Object[0]);
               }

               var5 = var3.aF().a(var2[1]);
               if(var5 == null) {
                  throw new class_bz("commands.whitelist.add.failed", new Object[]{var2[1]});
               }

               var3.getPlayerList().d(var5);
               a(var1, this, "commands.whitelist.add.success", new Object[]{var2[1]});
            } else if(var2[0].equals("remove")) {
               if(var2.length < 2) {
                  throw new class_cf("commands.whitelist.remove.usage", new Object[0]);
               }

               var5 = var3.getPlayerList().k().a(var2[1]);
               if(var5 == null) {
                  throw new class_bz("commands.whitelist.remove.failed", new Object[]{var2[1]});
               }

               var3.getPlayerList().c(var5);
               a(var1, this, "commands.whitelist.remove.success", new Object[]{var2[1]});
            } else if(var2[0].equals("reload")) {
               var3.getPlayerList().a();
               a(var1, this, "commands.whitelist.reloaded", new Object[0]);
            }
         }

      }
   }

   public List a(class_m var1, String[] var2, BlockPosition var3) {
      if(var2.length == 1) {
         return a(var2, new String[]{"on", "off", "list", "add", "remove", "reload"});
      } else {
         if(var2.length == 2) {
            if(var2[0].equals("remove")) {
               return a(var2, MinecraftServer.N().getPlayerList().l());
            }

            if(var2[0].equals("add")) {
               return a(var2, MinecraftServer.N().aF().a());
            }
         }

         return null;
      }
   }
}
