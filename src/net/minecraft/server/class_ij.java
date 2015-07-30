package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayIn;

public class class_ij implements Packet {
   private int a;
   private int b;

   public void a(PacketListenerPlayIn var1) {
      var1.handle(this);
   }

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = var1.readByte();
      this.b = var1.readByte();
   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeByte(this.a);
      var1.writeByte(this.b);
   }

   public int a() {
      return this.a;
   }

   public int b() {
      return this.b;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void handle(PacketListener var1) {
      this.a((PacketListenerPlayIn)var1);
   }
}
