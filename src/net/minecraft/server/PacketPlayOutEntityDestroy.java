package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayOut;

public class PacketPlayOutEntityDestroy implements Packet {
   private int[] a;

   public PacketPlayOutEntityDestroy() {
   }

   public PacketPlayOutEntityDestroy(int... var1) {
      this.a = var1;
   }

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = new int[var1.readVarInt()];

      for(int var2 = 0; var2 < this.a.length; ++var2) {
         this.a[var2] = var1.readVarInt();
      }

   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeVarInt(this.a.length);

      for(int var2 = 0; var2 < this.a.length; ++var2) {
         var1.writeVarInt(this.a[var2]);
      }

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
