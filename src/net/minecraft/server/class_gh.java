package net.minecraft.server;

import io.netty.buffer.ByteBuf;
import java.io.IOException;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayOut;

public class class_gh implements Packet {
   private String a;
   private PacketDataSerializer b;

   public class_gh() {
   }

   public class_gh(String var1, PacketDataSerializer var2) {
      this.a = var1;
      this.b = var2;
      if(var2.writerIndex() > 1048576) {
         throw new IllegalArgumentException("Payload may not be larger than 1048576 bytes");
      }
   }

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = var1.readString(20);
      int var2 = var1.readableBytes();
      if(var2 >= 0 && var2 <= 1048576) {
         this.b = new PacketDataSerializer(var1.readBytes(var2));
      } else {
         throw new IOException("Payload may not be larger than 1048576 bytes");
      }
   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeString(this.a);
      var1.writeBytes((ByteBuf)this.b);
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
