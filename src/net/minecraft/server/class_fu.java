package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.Block;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayOut;

public class class_fu implements Packet {
   private BlockPosition a;
   private int b;
   private int c;
   private Block d;

   public class_fu() {
   }

   public class_fu(BlockPosition var1, Block var2, int var3, int var4) {
      this.a = var1;
      this.b = var3;
      this.c = var4;
      this.d = var2;
   }

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = var1.readBlockPosition();
      this.b = var1.readUnsignedByte();
      this.c = var1.readUnsignedByte();
      this.d = Block.getById(var1.readVarInt() & 4095);
   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeBlockPosition(this.a);
      var1.writeByte(this.b);
      var1.writeByte(this.c);
      var1.writeVarInt(Block.getId(this.d) & 4095);
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
