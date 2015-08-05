package net.minecraft.server;

import java.util.List;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.class_bz;
import net.minecraft.server.class_cf;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.CommandAbstract;
import net.minecraft.server.EntityPlayer;
import net.minecraft.server.class_m;
import net.minecraft.server.class_n;

public class CommandXp extends CommandAbstract {
   public String getCommand() {
      return "xp";
   }

   public int a() {
      return 2;
   }

   public String c(class_m var1) {
      return "commands.xp.usage";
   }

   public void execute(class_m var1, String[] var2) throws class_bz {
      if(var2.length <= 0) {
         throw new class_cf("commands.xp.usage", new Object[0]);
      } else {
         String var3 = var2[0];
         boolean var4 = var3.endsWith("l") || var3.endsWith("L");
         if(var4 && var3.length() > 1) {
            var3 = var3.substring(0, var3.length() - 1);
         }

         int var5 = a(var3);
         boolean var6 = var5 < 0;
         if(var6) {
            var5 *= -1;
         }

         EntityPlayer var7 = var2.length > 1?a(var1, var2[1]):b(var1);
         if(var4) {
            var1.a(class_n.class_a_in_class_n.e, var7.expLevel);
            if(var6) {
               var7.a(-var5);
               a(var1, this, "commands.xp.success.negative.levels", new Object[]{Integer.valueOf(var5), var7.getName()});
            } else {
               var7.a(var5);
               a(var1, this, "commands.xp.success.levels", new Object[]{Integer.valueOf(var5), var7.getName()});
            }
         } else {
            var1.a(class_n.class_a_in_class_n.e, var7.expTotal);
            if(var6) {
               throw new class_bz("commands.xp.failure.widthdrawXp", new Object[0]);
            }

            var7.o(var5);
            a(var1, this, "commands.xp.success", new Object[]{Integer.valueOf(var5), var7.getName()});
         }

      }
   }

   public List tabComplete(class_m var1, String[] var2, BlockPosition var3) {
      return var2.length == 2?a(var2, this.d()):null;
   }

   protected String[] d() {
      return MinecraftServer.N().K();
   }

   public boolean isListStart(String[] var1, int var2) {
      return var2 == 1;
   }
}
