package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.Packet;
import net.minecraft.server.class_jg;

public class class_jk implements Packet {
   private IChatBaseComponent a;

   public class_jk() {
   }

   public class_jk(IChatBaseComponent var1) {
      this.a = var1;
   }

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = var1.readChat();
   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeChat(this.a);
   }

   public void a(class_jg var1) {
      var1.a(this);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void handle(PacketListener var1) {
      this.a((class_jg)var1);
   }
}
