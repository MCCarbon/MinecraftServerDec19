package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.EnumDirection;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayIn;
import net.minecraft.server.EnumUsedHand;

public class class_ja implements Packet {
   private BlockPosition a;
   private EnumDirection b;
   private EnumUsedHand c;
   private float d;
   private float e;
   private float f;

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = var1.readBlockPosition();
      this.b = (EnumDirection)var1.readEnum(EnumDirection.class);
      this.c = (EnumUsedHand)var1.readEnum(EnumUsedHand.class);
      this.d = (float)var1.readUnsignedByte() / 16.0F;
      this.e = (float)var1.readUnsignedByte() / 16.0F;
      this.f = (float)var1.readUnsignedByte() / 16.0F;
   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeBlockPosition(this.a);
      var1.writeEnum((Enum)this.b);
      var1.writeEnum((Enum)this.c);
      var1.writeByte((int)(this.d * 16.0F));
      var1.writeByte((int)(this.e * 16.0F));
      var1.writeByte((int)(this.f * 16.0F));
   }

   public void a(PacketListenerPlayIn var1) {
      var1.handle(this);
   }

   public BlockPosition a() {
      return this.a;
   }

   public EnumDirection b() {
      return this.b;
   }

   public EnumUsedHand c() {
      return this.c;
   }

   public float d() {
      return this.d;
   }

   public float e() {
      return this.e;
   }

   public float f() {
      return this.f;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void handle(PacketListener var1) {
      this.a((PacketListenerPlayIn)var1);
   }
}
