package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayOut;

public class class_gf implements Packet {
   private int a;
   private int b;
   private int c;

   public class_gf() {
   }

   public class_gf(int var1, int var2, int var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public void a(PacketListenerPlayOut var1) {
      var1.a(this);
   }

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = var1.readUnsignedByte();
      this.b = var1.readShort();
      this.c = var1.readShort();
   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeByte(this.a);
      var1.writeShort(this.b);
      var1.writeShort(this.c);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void handle(PacketListener var1) {
      this.a((PacketListenerPlayOut)var1);
   }
}
