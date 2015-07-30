package net.minecraft.server;

import net.minecraft.server.PacketListener;
import net.minecraft.server.Packet;
import net.minecraft.server.class_kj;
import net.minecraft.server.class_of;

public class class_fh {
   public static void a(final Packet var0, final PacketListener var1, class_of var2) throws class_kj {
      if(!var2.aJ()) {
         var2.a(new Runnable() {
            public void run() {
               var0.handle(var1);
            }
         });
         throw class_kj.a;
      }
   }
}
