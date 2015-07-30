package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayOut;
import net.minecraft.server.class_pr;

public class class_hh implements Packet {
   public int a;

   public class_hh() {
   }

   public class_hh(class_pr var1) {
      this.a = var1.getId();
   }

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = var1.readVarInt();
   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeVarInt(this.a);
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
