package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayOut;

public class class_hx implements Packet {
   private IChatBaseComponent a;
   private IChatBaseComponent b;

   public class_hx() {
   }

   public class_hx(IChatBaseComponent var1) {
      this.a = var1;
   }

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = var1.readChat();
      this.b = var1.readChat();
   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeChat(this.a);
      var1.writeChat(this.b);
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
