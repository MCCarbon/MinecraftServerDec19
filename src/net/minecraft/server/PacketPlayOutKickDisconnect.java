package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayOut;

public class PacketPlayOutKickDisconnect implements Packet {
   private IChatBaseComponent a;

   public PacketPlayOutKickDisconnect() {
   }

   public PacketPlayOutKickDisconnect(IChatBaseComponent var1) {
      this.a = var1;
   }

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = var1.readChat();
   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeChat(this.a);
      System.out.println(IChatBaseComponent.ChatSerializer.toJson(a));
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
