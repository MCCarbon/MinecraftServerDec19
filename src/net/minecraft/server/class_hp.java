package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayOut;

public class class_hp implements Packet {
   private float a;
   private int b;
   private float c;

   public class_hp() {
   }

   public class_hp(float var1, int var2, float var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = var1.readFloat();
      this.b = var1.readVarInt();
      this.c = var1.readFloat();
   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeFloat(this.a);
      var1.writeVarInt(this.b);
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
