package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayIn;
import net.minecraft.server.class_pz;
import net.minecraft.server.class_xa;

public class class_ih implements Packet {
   private String a;
   private int b;
   private class_xa.class_b_in_class_xa c;
   private boolean d;
   private int e;
   private class_pz f;

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = var1.readString(7);
      this.b = var1.readByte();
      this.c = (class_xa.class_b_in_class_xa)var1.readEnum(class_xa.class_b_in_class_xa.class);
      this.d = var1.readBoolean();
      this.e = var1.readUnsignedByte();
      this.f = (class_pz)var1.readEnum(class_pz.class);
   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeString(this.a);
      var1.writeByte(this.b);
      var1.writeEnum((Enum)this.c);
      var1.writeBoolean(this.d);
      var1.writeByte(this.e);
      var1.writeEnum((Enum)this.f);
   }

   public void a(PacketListenerPlayIn var1) {
      var1.handle(this);
   }

   public String a() {
      return this.a;
   }

   public class_xa.class_b_in_class_xa c() {
      return this.c;
   }

   public boolean d() {
      return this.d;
   }

   public int e() {
      return this.e;
   }

   public class_pz f() {
      return this.f;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void handle(PacketListener var1) {
      this.a((PacketListenerPlayIn)var1);
   }
}
