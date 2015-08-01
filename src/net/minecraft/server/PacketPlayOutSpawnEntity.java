package net.minecraft.server;

import java.io.IOException;
import java.util.UUID;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayOut;
import net.minecraft.server.MathHelper;
import net.minecraft.server.class_pr;

public class PacketPlayOutSpawnEntity implements Packet {
   private int a;
   private UUID b;
   private int c;
   private int d;
   private int e;
   private int f;
   private int g;
   private int h;
   private int i;
   private int j;
   private int k;
   private int l;

   public PacketPlayOutSpawnEntity() {
   }

   public PacketPlayOutSpawnEntity(class_pr var1, int var2) {
      this(var1, var2, 0);
   }

   public PacketPlayOutSpawnEntity(class_pr var1, int var2, int var3) {
      this.a = var1.getId();
      this.b = var1.aM();
      this.c = MathHelper.floor(var1.s * 32.0D);
      this.d = MathHelper.floor(var1.t * 32.0D);
      this.e = MathHelper.floor(var1.u * 32.0D);
      this.i = MathHelper.floor(var1.z * 256.0F / 360.0F);
      this.j = MathHelper.floor(var1.y * 256.0F / 360.0F);
      this.k = var2;
      this.l = var3;
      double var4 = 3.9D;
      this.f = (int)(MathHelper.clamp(var1.v, -3.9D, 3.9D) * 8000.0D);
      this.g = (int)(MathHelper.clamp(var1.w, -3.9D, 3.9D) * 8000.0D);
      this.h = (int)(MathHelper.clamp(var1.x, -3.9D, 3.9D) * 8000.0D);
   }

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = var1.readVarInt();
      this.b = var1.readUUID();
      this.k = var1.readByte();
      this.c = var1.readInt();
      this.d = var1.readInt();
      this.e = var1.readInt();
      this.i = var1.readByte();
      this.j = var1.readByte();
      this.l = var1.readInt();
      this.f = var1.readShort();
      this.g = var1.readShort();
      this.h = var1.readShort();
   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeVarInt(this.a);
      var1.writeUUID(this.b);
      var1.writeByte(this.k);
      var1.writeInt(this.c);
      var1.writeInt(this.d);
      var1.writeInt(this.e);
      var1.writeByte(this.i);
      var1.writeByte(this.j);
      var1.writeInt(this.l);
      var1.writeShort(this.f);
      var1.writeShort(this.g);
      var1.writeShort(this.h);
   }

   public void a(PacketListenerPlayOut var1) {
      var1.a(this);
   }

   public void a(int var1) {
      this.c = var1;
   }

   public void b(int var1) {
      this.d = var1;
   }

   public void c(int var1) {
      this.e = var1;
   }

   public void d(int var1) {
      this.f = var1;
   }

   public void e(int var1) {
      this.g = var1;
   }

   public void f(int var1) {
      this.h = var1;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void handle(PacketListener var1) {
      this.a((PacketListenerPlayOut)var1);
   }
}
