package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayIn;

public class class_iv implements Packet {
   private int a;

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = var1.readShort();
   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeShort(this.a);
   }

   public void a(PacketListenerPlayIn var1) {
      var1.handle(this);
   }

   public int a() {
      return this.a;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void handle(PacketListener var1) {
      this.a((PacketListenerPlayIn)var1);
   }
}
