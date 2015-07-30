package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayIn;

public class class_is implements Packet {
   private int a;
   private class_is.class_a_in_class_is b;
   private int c;

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = var1.readVarInt();
      this.b = (class_is.class_a_in_class_is)var1.readEnum(class_is.class_a_in_class_is.class);
      this.c = var1.readVarInt();
   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeVarInt(this.a);
      var1.writeEnum((Enum)this.b);
      var1.writeVarInt(this.c);
   }

   public void a(PacketListenerPlayIn var1) {
      var1.handle(this);
   }

   public class_is.class_a_in_class_is b() {
      return this.b;
   }

   public int c() {
      return this.c;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void handle(PacketListener var1) {
      this.a((PacketListenerPlayIn)var1);
   }

   public static enum class_a_in_class_is {
      a,
      b,
      c,
      d,
      e,
      f,
      g;
   }
}
