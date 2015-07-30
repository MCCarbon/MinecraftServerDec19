package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayOut;

public class class_gc implements Packet {
   private int a;

   public class_gc() {
   }

   public class_gc(int var1) {
      this.a = var1;
   }

   public void a(PacketListenerPlayOut var1) {
      var1.a(this);
   }

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = var1.readUnsignedByte();
   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeByte(this.a);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void handle(PacketListener var1) {
      this.a((PacketListenerPlayOut)var1);
   }
}
