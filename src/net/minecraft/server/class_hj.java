package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.class_awj;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayOut;

public class class_hj implements Packet {
   private int a;
   private String b;

   public class_hj() {
   }

   public class_hj(int var1, class_awj var2) {
      this.a = var1;
      if(var2 == null) {
         this.b = "";
      } else {
         this.b = var2.b();
      }

   }

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = var1.readByte();
      this.b = var1.readString(16);
   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeByte(this.a);
      var1.writeString(this.b);
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
