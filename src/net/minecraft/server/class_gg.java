package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.class_aas;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayOut;

public class class_gg implements Packet {
   private int a;
   private int b;
   private class_aas c;

   public class_gg() {
   }

   public class_gg(int var1, int var2, class_aas var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3 == null?null:var3.k();
   }

   public void a(PacketListenerPlayOut var1) {
      var1.a(this);
   }

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = var1.readByte();
      this.b = var1.readShort();
      this.c = var1.i();
   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeByte(this.a);
      var1.writeShort(this.b);
      var1.a(this.c);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void handle(PacketListener var1) {
      this.a((PacketListenerPlayOut)var1);
   }
}
