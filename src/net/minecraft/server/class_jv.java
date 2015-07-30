package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.Packet;
import net.minecraft.server.class_ju;

public class class_jv implements Packet {
   private long a;

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = var1.readLong();
   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeLong(this.a);
   }

   public void a(class_ju var1) {
      var1.a(this);
   }

   public long a() {
      return this.a;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void handle(PacketListener var1) {
      this.a((class_ju)var1);
   }
}
