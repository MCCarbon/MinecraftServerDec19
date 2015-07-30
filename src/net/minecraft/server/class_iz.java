package net.minecraft.server;

import java.io.IOException;
import java.util.UUID;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayIn;
import net.minecraft.server.class_lg;
import net.minecraft.server.class_pr;

public class class_iz implements Packet {
   private UUID a;

   public class_iz() {
   }

   public class_iz(UUID var1) {
      this.a = var1;
   }

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = var1.readUUID();
   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeUUID(this.a);
   }

   public void a(PacketListenerPlayIn var1) {
      var1.handle(this);
   }

   public class_pr a(class_lg var1) {
      return var1.a(this.a);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void handle(PacketListener var1) {
      this.a((PacketListenerPlayIn)var1);
   }
}
