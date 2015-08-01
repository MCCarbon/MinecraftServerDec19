package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayOut;
import net.minecraft.server.class_vc;

public class PacketPlayOutSpawnEntityPainting implements Packet {
   private int a;
   private BlockPosition b;
   private EnumDirection c;
   private String d;

   public PacketPlayOutSpawnEntityPainting() {
   }

   public PacketPlayOutSpawnEntityPainting(class_vc var1) {
      this.a = var1.getId();
      this.b = var1.n();
      this.c = var1.b;
      this.d = var1.c.B;
   }

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = var1.readVarInt();
      this.d = var1.readString(class_vc.class_a_in_class_vc.A);
      this.b = var1.readBlockPosition();
      this.c = EnumDirection.getByHorizontalId(var1.readUnsignedByte());
   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeVarInt(this.a);
      var1.writeString(this.d);
      var1.writeBlockPosition(this.b);
      var1.writeByte(this.c.getHorizontalId());
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
