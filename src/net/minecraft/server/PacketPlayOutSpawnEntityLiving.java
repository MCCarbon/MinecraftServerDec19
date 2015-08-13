package net.minecraft.server;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class PacketPlayOutSpawnEntityLiving implements Packet {
   private int a;
   private UUID b;
   private int c;
   private int d;
   private int e;
   private int f;
   private int g;
   private int h;
   private int i;
   private byte j;
   private byte k;
   private byte l;
   private Datawatcher m;
   private List n;

   public PacketPlayOutSpawnEntityLiving() {
   }

   public PacketPlayOutSpawnEntityLiving(EntityLiving var1) {
      this.a = var1.getId();
      this.b = var1.getUniqueId();
      this.c = (byte) EntityTypes.a(var1);
      this.d = MathHelper.floor(var1.locX * 32.0D);
      this.e = MathHelper.floor(var1.locY * 32.0D);
      this.f = MathHelper.floor(var1.locZ * 32.0D);
      this.j = (byte)((int)(var1.yaw * 256.0F / 360.0F));
      this.k = (byte)((int)(var1.pitch * 256.0F / 360.0F));
      this.l = (byte)((int)(var1.aN * 256.0F / 360.0F));
      double var2 = 3.9D;
      double var4 = var1.motX;
      double var6 = var1.motY;
      double var8 = var1.motZ;
      if(var4 < -var2) {
         var4 = -var2;
      }

      if(var6 < -var2) {
         var6 = -var2;
      }

      if(var8 < -var2) {
         var8 = -var2;
      }

      if(var4 > var2) {
         var4 = var2;
      }

      if(var6 > var2) {
         var6 = var2;
      }

      if(var8 > var2) {
         var8 = var2;
      }

      this.g = (int)(var4 * 8000.0D);
      this.h = (int)(var6 * 8000.0D);
      this.i = (int)(var8 * 8000.0D);
      this.m = var1.H();
   }

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = var1.readVarInt();
      this.b = var1.readUUID();
      this.c = var1.readByte() & 255;
      this.d = var1.readInt();
      this.e = var1.readInt();
      this.f = var1.readInt();
      this.j = var1.readByte();
      this.k = var1.readByte();
      this.l = var1.readByte();
      this.g = var1.readShort();
      this.h = var1.readShort();
      this.i = var1.readShort();
      this.n = Datawatcher.b(var1);
   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeVarInt(this.a);
      var1.writeUUID(this.b);
      var1.writeByte(this.c & 255);
      var1.writeInt(this.d);
      var1.writeInt(this.e);
      var1.writeInt(this.f);
      var1.writeByte(this.j);
      var1.writeByte(this.k);
      var1.writeByte(this.l);
      var1.writeShort(this.g);
      var1.writeShort(this.h);
      var1.writeShort(this.i);
      this.m.a(var1);
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
