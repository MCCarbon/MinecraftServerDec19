package net.minecraft.server;

import io.netty.buffer.ByteBuf;
import java.io.IOException;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayIn;

public class class_im implements Packet {
   private String a;
   private PacketDataSerializer b;

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = var1.readString(20);
      int var2 = var1.readableBytes();
      if(var2 >= 0 && var2 <= 32767) {
         this.b = new PacketDataSerializer(var1.readBytes(var2));
      } else {
         throw new IOException("Payload may not be larger than 32767 bytes");
      }
   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeString(this.a);
      var1.writeBytes((ByteBuf)this.b);
   }

   public void a(PacketListenerPlayIn var1) {
      var1.handle(this);
   }

   public String a() {
      return this.a;
   }

   public PacketDataSerializer b() {
      return this.b;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void handle(PacketListener var1) {
      this.a((PacketListenerPlayIn)var1);
   }
}
