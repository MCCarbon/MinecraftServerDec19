package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayOut;

public class class_gq implements Packet {
   private int a;
   private BlockPosition b;
   private int c;
   private boolean d;

   public class_gq() {
   }

   public class_gq(int var1, BlockPosition var2, int var3, boolean var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = var1.readInt();
      this.b = var1.readBlockPosition();
      this.c = var1.readInt();
      this.d = var1.readBoolean();
   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeInt(this.a);
      var1.writeBlockPosition(this.b);
      var1.writeInt(this.c);
      var1.writeBoolean(this.d);
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
