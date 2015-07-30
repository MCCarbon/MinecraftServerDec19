package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayIn;

public class class_iu implements Packet {
   private String a;
   private class_iu.class_a_in_class_iu b;

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = var1.readString(40);
      this.b = (class_iu.class_a_in_class_iu)var1.readEnum(class_iu.class_a_in_class_iu.class);
   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeString(this.a);
      var1.writeEnum((Enum)this.b);
   }

   public void a(PacketListenerPlayIn var1) {
      var1.handle(this);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void handle(PacketListener var1) {
      this.a((PacketListenerPlayIn)var1);
   }

   public static enum class_a_in_class_iu {
      a,
      b,
      c,
      d;
   }
}
