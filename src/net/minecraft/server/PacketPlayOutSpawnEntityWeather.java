package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayOut;
import net.minecraft.server.MathHelper;
import net.minecraft.server.Entity;
import net.minecraft.server.class_vi;

public class PacketPlayOutSpawnEntityWeather implements Packet {
   private int a;
   private int b;
   private int c;
   private int d;
   private int e;

   public PacketPlayOutSpawnEntityWeather() {
   }

   public PacketPlayOutSpawnEntityWeather(Entity var1) {
      this.a = var1.getId();
      this.b = MathHelper.floor(var1.s * 32.0D);
      this.c = MathHelper.floor(var1.t * 32.0D);
      this.d = MathHelper.floor(var1.u * 32.0D);
      if(var1 instanceof class_vi) {
         this.e = 1;
      }

   }

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = var1.readVarInt();
      this.e = var1.readByte();
      this.b = var1.readInt();
      this.c = var1.readInt();
      this.d = var1.readInt();
   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeVarInt(this.a);
      var1.writeByte(this.e);
      var1.writeInt(this.b);
      var1.writeInt(this.c);
      var1.writeInt(this.d);
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
