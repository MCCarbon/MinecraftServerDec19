package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayIn;
import net.minecraft.server.EnumUsedHand;

public class class_iy implements Packet {
   private EnumUsedHand a;

   public class_iy() {
   }

   public class_iy(EnumUsedHand var1) {
      this.a = var1;
   }

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = (EnumUsedHand)var1.readEnum(EnumUsedHand.class);
   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeEnum((Enum)this.a);
   }

   public void a(PacketListenerPlayIn var1) {
      var1.handle(this);
   }

   public EnumUsedHand a() {
      return this.a;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void handle(PacketListener var1) {
      this.a((PacketListenerPlayIn)var1);
   }
}
