package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayOut;

public class PacketPlayOutUpdateTime implements Packet {
   private long a;
   private long b;

   public PacketPlayOutUpdateTime() {
   }

   public PacketPlayOutUpdateTime(long var1, long var3, boolean var5) {
      this.a = var1;
      this.b = var3;
      if(!var5) {
         this.b = -this.b;
         if(this.b == 0L) {
            this.b = -1L;
         }
      }

   }

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = var1.readLong();
      this.b = var1.readLong();
   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeLong(this.a);
      var1.writeLong(this.b);
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
