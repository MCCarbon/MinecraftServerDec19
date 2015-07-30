package net.minecraft.server;

import java.util.List;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.class_bz;
import net.minecraft.server.class_cf;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.class_fb;
import net.minecraft.server.class_i;
import net.minecraft.server.class_m;
import net.minecraft.server.class_xa;

public class class_aa extends class_i {
   public String c() {
      return "me";
   }

   public int a() {
      return 0;
   }

   public String c(class_m var1) {
      return "commands.me.usage";
   }

   public void a(class_m var1, String[] var2) throws class_bz {
      if(var2.length <= 0) {
         throw new class_cf("commands.me.usage", new Object[0]);
      } else {
         IChatBaseComponent var3 = b(var1, var2, 0, !(var1 instanceof class_xa));
         MinecraftServer.N().ap().a((IChatBaseComponent)(new class_fb("chat.type.emote", new Object[]{var1.f_(), var3})));
      }
   }

   public List a(class_m var1, String[] var2, BlockPosition var3) {
      return a(var2, MinecraftServer.N().K());
   }
}
