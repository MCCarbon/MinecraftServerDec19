package net.minecraft.server;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayOut;
import net.minecraft.server.MathHelper;
import net.minecraft.server.DataWathcer;
import net.minecraft.server.EntityHuman;

public class PacketPlayOutNamedEntitySpawn implements Packet {
   private int a;
   private UUID b;
   private int c;
   private int d;
   private int e;
   private byte f;
   private byte g;
   private DataWathcer h;
   private List i;

   public PacketPlayOutNamedEntitySpawn() {
   }

   public PacketPlayOutNamedEntitySpawn(EntityHuman var1) {
      this.a = var1.getId();
      this.b = var1.cf().getId();
      this.c = MathHelper.floor(var1.locX * 32.0D);
      this.d = MathHelper.floor(var1.locY * 32.0D);
      this.e = MathHelper.floor(var1.locZ * 32.0D);
      this.f = (byte)((int)(var1.yaw * 256.0F / 360.0F));
      this.g = (byte)((int)(var1.pitch * 256.0F / 360.0F));
      this.h = var1.H();
   }

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = var1.readVarInt();
      this.b = var1.readUUID();
      this.c = var1.readInt();
      this.d = var1.readInt();
      this.e = var1.readInt();
      this.f = var1.readByte();
      this.g = var1.readByte();
      this.i = DataWathcer.b(var1);
   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeVarInt(this.a);
      var1.writeUUID(this.b);
      var1.writeInt(this.c);
      var1.writeInt(this.d);
      var1.writeInt(this.e);
      var1.writeByte(this.f);
      var1.writeByte(this.g);
      this.h.a(var1);
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
