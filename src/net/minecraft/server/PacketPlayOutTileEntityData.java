package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayOut;

public class PacketPlayOutTileEntityData implements Packet {
   private BlockPosition a;
   private int b;
   private NBTTagCompound c;

   public PacketPlayOutTileEntityData() {
   }

   public PacketPlayOutTileEntityData(BlockPosition var1, int var2, NBTTagCompound var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = var1.readBlockPosition();
      this.b = var1.readUnsignedByte();
      this.c = var1.readNBTTagCompund();
   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeBlockPosition(this.a);
      var1.writeByte((byte)this.b);
      var1.writeNBTTagCompound(this.c);
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
