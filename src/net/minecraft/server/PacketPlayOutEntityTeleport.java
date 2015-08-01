package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayOut;
import net.minecraft.server.MathHelper;
import net.minecraft.server.class_pr;

public class PacketPlayOutEntityTeleport implements Packet {
   private int a;
   private int b;
   private int c;
   private int d;
   private byte e;
   private byte f;
   private boolean g;

   public PacketPlayOutEntityTeleport() {
   }

   public PacketPlayOutEntityTeleport(class_pr var1) {
      this.a = var1.getId();
      this.b = MathHelper.floor(var1.s * 32.0D);
      this.c = MathHelper.floor(var1.t * 32.0D);
      this.d = MathHelper.floor(var1.u * 32.0D);
      this.e = (byte)((int)(var1.y * 256.0F / 360.0F));
      this.f = (byte)((int)(var1.z * 256.0F / 360.0F));
      this.g = var1.C;
   }

   public PacketPlayOutEntityTeleport(int var1, int var2, int var3, int var4, byte var5, byte var6, boolean var7) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
      this.f = var6;
      this.g = var7;
   }

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = var1.readVarInt();
      this.b = var1.readInt();
      this.c = var1.readInt();
      this.d = var1.readInt();
      this.e = var1.readByte();
      this.f = var1.readByte();
      this.g = var1.readBoolean();
   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeVarInt(this.a);
      var1.writeInt(this.b);
      var1.writeInt(this.c);
      var1.writeInt(this.d);
      var1.writeByte(this.e);
      var1.writeByte(this.f);
      var1.writeBoolean(this.g);
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
