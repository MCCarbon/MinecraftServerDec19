package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayOut;
import net.minecraft.server.class_om;

public class PacketPlayOutServerDifficulty implements Packet {
   private class_om a;
   private boolean b;

   public PacketPlayOutServerDifficulty() {
   }

   public PacketPlayOutServerDifficulty(class_om var1, boolean var2) {
      this.a = var1;
      this.b = var2;
   }

   public void a(PacketListenerPlayOut var1) {
      var1.a(this);
   }

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = class_om.a(var1.readUnsignedByte());
   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeByte(this.a.a());
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void handle(PacketListener var1) {
      this.a((PacketListenerPlayOut)var1);
   }
}
