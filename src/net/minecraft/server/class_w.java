package net.minecraft.server;

import com.mojang.authlib.GameProfile;
import java.util.List;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.class_bz;
import net.minecraft.server.class_cf;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_i;
import net.minecraft.server.class_m;

public class class_w extends class_i {
   public String c() {
      return "deop";
   }

   public int a() {
      return 3;
   }

   public String c(class_m var1) {
      return "commands.deop.usage";
   }

   public void a(class_m var1, String[] var2) throws class_bz {
      if(var2.length == 1 && var2[0].length() > 0) {
         MinecraftServer var3 = MinecraftServer.N();
         GameProfile var4 = var3.getPlayerList().m().a(var2[0]);
         if(var4 == null) {
            throw new class_bz("commands.deop.failed", new Object[]{var2[0]});
         } else {
            var3.getPlayerList().b(var4);
            a(var1, this, "commands.deop.success", new Object[]{var2[0]});
         }
      } else {
         throw new class_cf("commands.deop.usage", new Object[0]);
      }
   }

   public List a(class_m var1, String[] var2, BlockPosition var3) {
      return var2.length == 1?a(var2, MinecraftServer.N().getPlayerList().n()):null;
   }
}
