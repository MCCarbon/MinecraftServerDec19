package net.minecraft.server;

import java.io.IOException;
import java.util.List;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayOut;
import net.minecraft.server.DataWathcer;

public class PacketPlayOutEntityMetadata implements Packet {
   private int a;
   private List b;

   public PacketPlayOutEntityMetadata() {
   }

   public PacketPlayOutEntityMetadata(int var1, DataWathcer var2, boolean var3) {
      this.a = var1;
      if(var3) {
         this.b = var2.getObjects();
      } else {
         this.b = var2.b();
      }

   }

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = var1.readVarInt();
      this.b = DataWathcer.b(var1);
   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeVarInt(this.a);
      DataWathcer.a(this.b, var1);
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
