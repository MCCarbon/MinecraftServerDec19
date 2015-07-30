package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.Packet;
import net.minecraft.server.class_jq;

public class class_jr implements Packet {
   private long a;

   public class_jr() {
   }

   public class_jr(long var1) {
      this.a = var1;
   }

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = var1.readLong();
   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeLong(this.a);
   }

   public void a(class_jq var1) {
      var1.a(this);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void handle(PacketListener var1) {
      this.a((class_jq)var1);
   }
}
