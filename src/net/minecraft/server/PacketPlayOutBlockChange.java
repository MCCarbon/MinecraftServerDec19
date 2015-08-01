package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.World;
import net.minecraft.server.Block;
import net.minecraft.server.IBlockData;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayOut;

public class PacketPlayOutBlockChange implements Packet {
   private BlockPosition a;
   private IBlockData b;

   public PacketPlayOutBlockChange() {
   }

   public PacketPlayOutBlockChange(World var1, BlockPosition var2) {
      this.a = var2;
      this.b = var1.p(var2);
   }

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = var1.readBlockPosition();
      this.b = (IBlockData)Block.BLOCKDATA_REGISTRY.get(var1.readVarInt());
   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeBlockPosition(this.a);
      var1.writeVarInt(Block.BLOCKDATA_REGISTRY.getId(this.b));
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
