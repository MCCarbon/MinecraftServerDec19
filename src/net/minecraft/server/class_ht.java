package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayOut;

public class class_ht implements Packet {
   private BlockPosition a;

   public class_ht() {
   }

   public class_ht(BlockPosition var1) {
      this.a = var1;
   }

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = var1.readBlockPosition();
   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeBlockPosition(this.a);
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
