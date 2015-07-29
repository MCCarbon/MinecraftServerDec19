package net.minecraft.server;

import java.util.List;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.class_bz;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_fa;
import net.minecraft.server.class_fb;
import net.minecraft.server.class_i;
import net.minecraft.server.class_m;

public class class_an extends class_i {
   public String c() {
      return "banlist";
   }

   public int a() {
      return 3;
   }

   public boolean a(class_m var1) {
      return (MinecraftServer.N().ap().i().b() || MinecraftServer.N().ap().h().b()) && super.a(var1);
   }

   public String c(class_m var1) {
      return "commands.banlist.usage";
   }

   public void a(class_m var1, String[] var2) throws class_bz {
      if(var2.length >= 1 && var2[0].equalsIgnoreCase("ips")) {
         var1.a(new class_fb("commands.banlist.ips", new Object[]{Integer.valueOf(MinecraftServer.N().ap().i().a().length)}));
         var1.a(new class_fa(a(MinecraftServer.N().ap().i().a())));
      } else {
         var1.a(new class_fb("commands.banlist.players", new Object[]{Integer.valueOf(MinecraftServer.N().ap().h().a().length)}));
         var1.a(new class_fa(a(MinecraftServer.N().ap().h().a())));
      }

   }

   public List a(class_m var1, String[] var2, class_cj var3) {
      return var2.length == 1?a(var2, new String[]{"players", "ips"}):null;
   }
}
