package net.minecraft.server;

import java.util.List;
import java.util.Random;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.class_avn;
import net.minecraft.server.class_bz;
import net.minecraft.server.class_cf;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_i;
import net.minecraft.server.WorldServer;
import net.minecraft.server.class_m;

public class class_bv extends class_i {
   public String getCommand() {
      return "weather";
   }

   public int a() {
      return 2;
   }

   public String c(class_m var1) {
      return "commands.weather.usage";
   }

   public void execute(class_m var1, String[] var2) throws class_bz {
      if(var2.length >= 1 && var2.length <= 2) {
         int var3 = (300 + (new Random()).nextInt(600)) * 20;
         if(var2.length >= 2) {
            var3 = a(var2[1], 1, 1000000) * 20;
         }

         WorldServer var4 = MinecraftServer.N().d[0];
         class_avn var5 = var4.Q();
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

   public List tabComplete(class_m var1, String[] var2, BlockPosition var3) {
      return var2.length == 1?a(var2, new String[]{"clear", "rain", "thunder"}):null;
   }
}
