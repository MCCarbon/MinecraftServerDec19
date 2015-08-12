package net.minecraft.server;

import java.util.List;
import java.util.Random;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.WorldData;
import net.minecraft.server.class_bz;
import net.minecraft.server.class_cf;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.CommandAbstract;
import net.minecraft.server.WorldServer;
import net.minecraft.server.ICommandListener;

public class CommandWeather extends CommandAbstract {
   public String getCommand() {
      return "weather";
   }

   public int a() {
      return 2;
   }

   public String c(ICommandListener var1) {
      return "commands.weather.usage";
   }

   public void execute(ICommandListener var1, String[] var2) throws class_bz {
      if(var2.length >= 1 && var2.length <= 2) {
         int var3 = (300 + (new Random()).nextInt(600)) * 20;
         if(var2.length >= 2) {
            var3 = a(var2[1], 1, 1000000) * 20;
         }

         WorldServer var4 = MinecraftServer.getServer().d[0];
         WorldData var5 = var4.Q();
         if("clear".equalsIgnoreCase(var2[0])) {
            var5.i(var3);
            var5.g(0);
            var5.f(0);
            var5.b(false);
            var5.a(false);
            a(var1, this, "commands.weather.clear", new Object[0]);
         } else if("rain".equalsIgnoreCase(var2[0])) {
            var5.i(0);
            var5.g(var3);
            var5.f(var3);
            var5.b(true);
            var5.a(false);
            a(var1, this, "commands.weather.rain", new Object[0]);
         } else {
            if(!"thunder".equalsIgnoreCase(var2[0])) {
               throw new class_cf("commands.weather.usage", new Object[0]);
            }

            var5.i(0);
            var5.g(var3);
            var5.f(var3);
            var5.b(true);
            var5.a(true);
            a(var1, this, "commands.weather.thunder", new Object[0]);
         }

      } else {
         throw new class_cf("commands.weather.usage", new Object[0]);
      }
   }

   public List tabComplete(ICommandListener var1, String[] var2, BlockPosition var3) {
      return var2.length == 1?a(var2, new String[]{"clear", "rain", "thunder"}):null;
   }
}
