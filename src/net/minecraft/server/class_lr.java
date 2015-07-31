package net.minecraft.server;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.NetworkManager;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.class_fa;
import net.minecraft.server.Packet;
import net.minecraft.server.class_jr;
import net.minecraft.server.class_js;
import net.minecraft.server.class_ju;
import net.minecraft.server.class_jv;
import net.minecraft.server.class_jw;

public class class_lr implements class_ju {
   private static final IChatBaseComponent a = new class_fa("Status request has been handled.");
   private final MinecraftServer b;
   private final NetworkManager c;
   private boolean d;

   public class_lr(MinecraftServer var1, NetworkManager var2) {
      this.b = var1;
      this.c = var2;
   }

   public void disconnect(IChatBaseComponent var1) {
   }

   public void a(class_jw var1) {
      if(this.d) {
         this.c.close(a);
      } else {
         this.d = true;
         this.c.sendPacket((Packet)(new class_js(this.b.aG())));
      }
   }

   public void a(class_jv var1) {
      this.c.sendPacket((Packet)(new class_jr(var1.a())));
      this.c.close(a);
   }
}
