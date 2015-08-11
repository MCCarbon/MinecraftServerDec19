package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.class_aeh;
import net.minecraft.server.Block;
import net.minecraft.server.IBlockData;
import net.minecraft.server.Chunk;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayOut;

public class PacketPlayOutMultiBlockChange implements Packet {
   private class_aeh a;
   private PacketPlayOutMultiBlockChange.class_a_in_class_ga[] b;

   public PacketPlayOutMultiBlockChange() {
   }

   public PacketPlayOutMultiBlockChange(int var1, short[] var2, Chunk var3) {
      this.a = new class_aeh(var3.locX, var3.locZ);
      this.b = new PacketPlayOutMultiBlockChange.class_a_in_class_ga[var1];

      for(int var4 = 0; var4 < this.b.length; ++var4) {
         this.b[var4] = new PacketPlayOutMultiBlockChange.class_a_in_class_ga(var2[var4], var3);
      }

   }

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = new class_aeh(var1.readInt(), var1.readInt());
      this.b = new PacketPlayOutMultiBlockChange.class_a_in_class_ga[var1.readVarInt()];

      for(int var2 = 0; var2 < this.b.length; ++var2) {
         this.b[var2] = new PacketPlayOutMultiBlockChange.class_a_in_class_ga(var1.readShort(), (IBlockData)Block.BLOCKDATA_REGISTRY.get(var1.readVarInt()));
      }

   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeInt(this.a.a);
      var1.writeInt(this.a.b);
      var1.writeVarInt(this.b.length);
      PacketPlayOutMultiBlockChange.class_a_in_class_ga[] var2 = this.b;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         PacketPlayOutMultiBlockChange.class_a_in_class_ga var5 = var2[var4];
         var1.writeShort(var5.b());
         var1.writeVarInt(Block.BLOCKDATA_REGISTRY.getId(var5.c()));
      }

   }

   public void a(PacketListenerPlayOut var1) {
      var1.a(this);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void handle(PacketListener var1) {
      this.a((PacketListenerPlayOut)var1);
   }

   public class class_a_in_class_ga {
      private final short b;
      private final IBlockData c;

      public class_a_in_class_ga(short var2, IBlockData var3) {
         this.b = var2;
         this.c = var3;
      }

      public class_a_in_class_ga(short var2, Chunk var3) {
         this.b = var2;
         this.c = var3.getBlockData(this.a());
      }

      public BlockPosition a() {
         return new BlockPosition(PacketPlayOutMultiBlockChange.this.a.a(this.b >> 12 & 15, this.b & 255, this.b >> 8 & 15));
      }

      public short b() {
         return this.b;
      }

      public IBlockData c() {
         return this.c;
      }
   }
}
