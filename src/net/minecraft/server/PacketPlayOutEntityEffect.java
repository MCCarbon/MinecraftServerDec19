package net.minecraft.server;

import java.io.IOException;

public class PacketPlayOutEntityEffect implements Packet {
   private int a;
   private byte b;
   private byte c;
   private int d;
   private byte e;

   public PacketPlayOutEntityEffect() {
   }

   public PacketPlayOutEntityEffect(int var1, class_pl var2) {
      this.a = var1;
      this.b = (byte)(MobEffect.a(var2.a()) & 255);
      this.c = (byte)(var2.c() & 255);
      if(var2.b() > 32767) {
         this.d = 32767;
      } else {
         this.d = var2.b();
      }

      this.e = (byte)(var2.e()?1:0);
   }

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = var1.readVarInt();
      this.b = var1.readByte();
      this.c = var1.readByte();
      this.d = var1.readVarInt();
      this.e = var1.readByte();
   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeVarInt(this.a);
      var1.writeByte(this.b);
      var1.writeByte(this.c);
      var1.writeVarInt(this.d);
      var1.writeByte(this.e);
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
