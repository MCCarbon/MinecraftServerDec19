package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayOut;

public class class_hy implements Packet {
   private int a;
   private int b;

   public class_hy() {
   }

   public class_hy(int var1, int var2) {
      this.a = var1;
      this.b = var2;
   }

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = var1.readVarInt();
      this.b = var1.readVarInt();
   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeVarInt(this.a);
      var1.writeVarInt(this.b);
   }

   public void a(PacketListenerPlayOut var1) {
      var1.a(this);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void handle(PacketListener var1) {
      this.a((PacketListenerPlayOut)var1);
   }
}
