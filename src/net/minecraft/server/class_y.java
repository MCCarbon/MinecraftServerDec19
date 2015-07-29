package net.minecraft.server;

import java.util.Iterator;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.class_aeq;
import net.minecraft.server.class_ah;
import net.minecraft.server.class_bz;
import net.minecraft.server.class_cf;
import net.minecraft.server.class_fb;
import net.minecraft.server.class_lh;
import net.minecraft.server.class_m;

public class class_y extends class_ah {
   public String c() {
      return "defaultgamemode";
   }

   public String c(class_m var1) {
      return "commands.defaultgamemode.usage";
   }

   public void a(class_m var1, String[] var2) throws class_bz {
      if(var2.length <= 0) {
         throw new class_cf("commands.defaultgamemode.usage", new Object[0]);
      } else {
         class_aeq.class_a_in_class_aeq var3 = this.h(var1, var2[0]);
         this.a(var3);
         a(var1, this, "commands.defaultgamemode.success", new Object[]{new class_fb("gameMode." + var3.b(), new Object[0])});
      }
   }

   protected void a(class_aeq.class_a_in_class_aeq var1) {
      MinecraftServer var2 = MinecraftServer.N();
      var2.a(var1);
      class_lh var4;
      if(var2.ax()) {
         for(Iterator var3 = MinecraftServer.N().ap().v().iterator(); var3.hasNext(); var4.O = 0.0F) {
            var4 = (class_lh)var3.next();
            var4.a(var1);
         }
      }

   }
}
