package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.class_aeq;
import net.minecraft.server.class_aes;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayOut;
import net.minecraft.server.class_om;

public class class_he implements Packet {
   private int a;
   private class_om b;
   private class_aeq.class_a_in_class_aeq c;
   private class_aes d;

   public class_he() {
   }

   public class_he(int var1, class_om var2, class_aes var3, class_aeq.class_a_in_class_aeq var4) {
      this.a = var1;
      this.b = var2;
      this.c = var4;
      this.d = var3;
   }

   public void a(PacketListenerPlayOut var1) {
      var1.a(this);
   }

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = var1.readInt();
      this.b = class_om.a(var1.readUnsignedByte());
      this.c = class_aeq.class_a_in_class_aeq.a(var1.readUnsignedByte());
      this.d = class_aes.a(var1.readString(16));
      if(this.d == null) {
         this.d = class_aes.b;
      }

   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeInt(this.a);
      var1.writeByte(this.b.a());
      var1.writeByte(this.c.a());
      var1.writeString(this.d.a());
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void handle(PacketListener var1) {
      this.a((PacketListenerPlayOut)var1);
   }
}
