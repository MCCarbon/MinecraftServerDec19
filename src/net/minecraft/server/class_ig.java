package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayIn;

public class class_ig implements Packet {
   private class_ig.class_a_in_class_ig a;

   public class_ig() {
   }

   public class_ig(class_ig.class_a_in_class_ig var1) {
      this.a = var1;
   }

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = (class_ig.class_a_in_class_ig)var1.readEnum(class_ig.class_a_in_class_ig.class);
   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeEnum((Enum)this.a);
   }

   public void a(PacketListenerPlayIn var1) {
      var1.handle(this);
   }

   public class_ig.class_a_in_class_ig a() {
      return this.a;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void handle(PacketListener var1) {
      this.a((PacketListenerPlayIn)var1);
   }

   public static enum class_a_in_class_ig {
      a,
      b,
      c;
   }
}
