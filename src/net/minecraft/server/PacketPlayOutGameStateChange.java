package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayOut;

public class PacketPlayOutGameStateChange implements Packet {
   public static final String[] a = new String[]{"tile.bed.notValid"};
   private int b;
   private float c;

   public PacketPlayOutGameStateChange() {
   }

   public PacketPlayOutGameStateChange(int var1, float var2) {
      this.b = var1;
      this.c = var2;
   }

   public void decode(PacketDataSerializer var1) throws IOException {
      this.b = var1.readUnsignedByte();
      this.c = var1.readFloat();
   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeByte(this.b);
      var1.writeFloat(this.c);
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
