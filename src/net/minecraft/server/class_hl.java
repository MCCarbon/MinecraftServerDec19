package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayOut;
import net.minecraft.server.class_pr;

public class class_hl implements Packet {
   private int a;
   private int b;
   private int c;

   public class_hl() {
   }

   public class_hl(int var1, class_pr var2, class_pr var3) {
      this.a = var1;
      this.b = var2.getId();
      this.c = var3 != null?var3.getId():-1;
   }

   public void decode(PacketDataSerializer var1) throws IOException {
      this.b = var1.readInt();
      this.c = var1.readInt();
      this.a = var1.readUnsignedByte();
   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeInt(this.b);
      var1.writeInt(this.c);
      var1.writeByte(this.a);
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
