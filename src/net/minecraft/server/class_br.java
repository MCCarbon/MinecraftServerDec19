package net.minecraft.server;

import java.util.List;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.class_bz;
import net.minecraft.server.class_cf;
import net.minecraft.server.class_cj;
import net.minecraft.server.class_i;
import net.minecraft.server.class_lg;
import net.minecraft.server.class_m;
import net.minecraft.server.class_n;

public class class_br extends class_i {
   public String c() {
      return "time";
   }

   public int a() {
      return 2;
   }

   public String c(class_m var1) {
      return "commands.time.usage";
   }

   public void a(class_m var1, String[] var2) throws class_bz {
      if(var2.length > 1) {
         int var3;
         if(var2[0].equals("set")) {
            if(var2[1].equals("day")) {
               var3 = 1000;
            } else if(var2[1].equals("night")) {
               var3 = 13000;
            } else {
               var3 = a(var2[1], 0);
            }

            this.a(var1, var3);
            a(var1, this, "commands.time.set", new Object[]{Integer.valueOf(var3)});
            return;
         }

         if(var2[0].equals("add")) {
            var3 = a(var2[1], 0);
            this.b(var1, var3);
            a(var1, this, "commands.time.added", new Object[]{Integer.valueOf(var3)});
            return;
         }

         if(var2[0].equals("query")) {
            if(var2[1].equals("daytime")) {
               var3 = (int)(var1.e().M() % 2147483647L);
               var1.a(class_n.class_a_in_class_n.e, var3);
               a(var1, this, "commands.time.query", new Object[]{Integer.valueOf(var3)});
               return;
            }

            if(var2[1].equals("gametime")) {
               var3 = (int)(var1.e().L() % 2147483647L);
               var1.a(class_n.class_a_in_class_n.e, var3);
               a(var1, this, "commands.time.query", new Object[]{Integer.valueOf(var3)});
               return;
            }
         }
      }

      throw new class_cf("commands.time.usage", new Object[0]);
   }

   public List a(class_m var1, String[] var2, class_cj var3) {
      return var2.length == 1?a(var2, new String[]{"set", "add", "query"}):(var2.length == 2 && var2[0].equals("set")?a(var2, new String[]{"day", "night"}):(var2.length == 2 && var2[0].equals("query")?a(var2, new String[]{"daytime", "gametime"}):null));
   }

   protected void a(class_m var1, int var2) {
      for(int var3 = 0; var3 < MinecraftServer.N().d.length; ++var3) {
         MinecraftServer.N().d[var3].b((long)var2);
      }

   }

   protected void b(class_m var1, int var2) {
      for(int var3 = 0; var3 < MinecraftServer.N().d.length; ++var3) {
         class_lg var4 = MinecraftServer.N().d[var3];
         var4.b(var4.M() + (long)var2);
      }

   }
}
