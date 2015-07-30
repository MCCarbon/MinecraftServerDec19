package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_dn;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayOut;

public class class_ft implements Packet {
   private BlockPosition a;
   private int b;
   private class_dn c;

   public class_ft() {
   }

   public class_ft(BlockPosition var1, int var2, class_dn var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = var1.readBlockPosition();
      this.b = var1.readUnsignedByte();
      this.c = var1.h();
   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeBlockPosition(this.a);
      var1.writeByte((byte)this.b);
      var1.a(this.c);
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
