package net.minecraft.server;

import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import net.minecraft.server.Chunk;
import net.minecraft.server.ChunkSection;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayOut;

public class PacketPlayOutMapChunk implements Packet {
   private int a;
   private int b;
   private PacketPlayOutMapChunk.class_a_in_class_go c;
   private boolean d;

   public PacketPlayOutMapChunk() {
   }

   public PacketPlayOutMapChunk(Chunk var1, boolean var2, int var3) {
      this.a = var1.locX;
      this.b = var1.locZ;
      this.d = var2;
      this.c = a(var1, var2, !var1.p().worldProvider.m(), var3);
   }

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = var1.readInt();
      this.b = var1.readInt();
      this.d = var1.readBoolean();
      this.c = new PacketPlayOutMapChunk.class_a_in_class_go();
      this.c.b = var1.readShort();
      this.c.a = var1.readArray();
   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeInt(this.a);
      var1.writeInt(this.b);
      var1.writeBoolean(this.d);
      var1.writeShort((short)(this.c.b & '\uffff'));
      var1.writeArray(this.c.a);
   }

   public void a(PacketListenerPlayOut var1) {
      var1.a(this);
   }

   protected static int a(int var0, boolean var1, boolean var2) {
      int var3 = var0 * 2 * 16 * 16 * 16;
      int var4 = var0 * 16 * 16 * 16 / 2;
      int var5 = var1?var0 * 16 * 16 * 16 / 2:0;
      int var6 = var2?256:0;
      return var3 + var4 + var5 + var6;
   }

   public static PacketPlayOutMapChunk.class_a_in_class_go a(Chunk var0, boolean var1, boolean var2, int var3) {
      ChunkSection[] var4 = var0.getSections();
      PacketPlayOutMapChunk.class_a_in_class_go var5 = new PacketPlayOutMapChunk.class_a_in_class_go();
      ArrayList var6 = Lists.newArrayList();

      int var7;
      for(var7 = 0; var7 < var4.length; ++var7) {
         ChunkSection var8 = var4[var7];
         if(var8 != null && (!var1 || !var8.a()) && (var3 & 1 << var7) != 0) {
            var5.b |= 1 << var7;
            var6.add(var8);
         }
      }

      var5.a = new byte[a(Integer.bitCount(var5.b), var2, var1)];
      var7 = 0;
      Iterator var15 = var6.iterator();

      ChunkSection var9;
      while(var15.hasNext()) {
         var9 = (ChunkSection)var15.next();
         char[] var10 = var9.g();
         char[] var11 = var10;
         int var12 = var10.length;

         for(int var13 = 0; var13 < var12; ++var13) {
            char var14 = var11[var13];
            var5.a[var7++] = (byte)(var14 & 255);
            var5.a[var7++] = (byte)(var14 >> 8 & 255);
         }
      }

      for(var15 = var6.iterator(); var15.hasNext(); var7 = a(var9.h().a(), var5.a, var7)) {
         var9 = (ChunkSection)var15.next();
      }

      if(var2) {
         for(var15 = var6.iterator(); var15.hasNext(); var7 = a(var9.i().a(), var5.a, var7)) {
            var9 = (ChunkSection)var15.next();
         }
      }

      if(var1) {
         a(var0.getBiomeIndex(), var5.a, var7);
      }

      return var5;
   }

   private static int a(byte[] var0, byte[] var1, int var2) {
      System.arraycopy(var0, 0, var1, var2, var0.length);
      return var2 + var0.length;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void handle(PacketListener var1) {
      this.a((PacketListenerPlayOut)var1);
   }

   public static class class_a_in_class_go {
      public byte[] a;
      public int b;
   }
}
