package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayOut;

public class class_gv implements Packet {
   protected int a;
   protected byte b;
   protected byte c;
   protected byte d;
   protected byte e;
   protected byte f;
   protected boolean g;
   protected boolean h;

   public class_gv() {
   }

   public class_gv(int var1) {
      this.a = var1;
   }

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = var1.readVarInt();
   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeVarInt(this.a);
   }

   public void a(PacketListenerPlayOut var1) {
      var1.a(this);
   }

   public String toString() {
      return "Entity_" + super.toString();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void handle(PacketListener var1) {
      this.a((PacketListenerPlayOut)var1);
   }

   public static class class_c_in_class_gv extends class_gv {
      public class_c_in_class_gv() {
         this.h = true;
      }

      public class_c_in_class_gv(int var1, byte var2, byte var3, boolean var4) {
         super(var1);
         this.e = var2;
         this.f = var3;
         this.h = true;
         this.g = var4;
      }

      public void decode(PacketDataSerializer var1) throws IOException {
         super.decode(var1);
         this.e = var1.readByte();
         this.f = var1.readByte();
         this.g = var1.readBoolean();
      }

      public void encode(PacketDataSerializer var1) throws IOException {
         super.encode(var1);
         var1.writeByte(this.e);
         var1.writeByte(this.f);
         var1.writeBoolean(this.g);
      }

      // $FF: synthetic method
      // $FF: bridge method
      public void handle(PacketListener var1) {
         super.a((PacketListenerPlayOut)var1);
      }
   }

   public static class class_a_in_class_gv extends class_gv {
      public class_a_in_class_gv() {
      }

      public class_a_in_class_gv(int var1, byte var2, byte var3, byte var4, boolean var5) {
         super(var1);
         this.b = var2;
         this.c = var3;
         this.d = var4;
         this.g = var5;
      }

      public void decode(PacketDataSerializer var1) throws IOException {
         super.decode(var1);
         this.b = var1.readByte();
         this.c = var1.readByte();
         this.d = var1.readByte();
         this.g = var1.readBoolean();
      }

      public void encode(PacketDataSerializer var1) throws IOException {
         super.encode(var1);
         var1.writeByte(this.b);
         var1.writeByte(this.c);
         var1.writeByte(this.d);
         var1.writeBoolean(this.g);
      }

      // $FF: synthetic method
      // $FF: bridge method
      public void handle(PacketListener var1) {
         super.a((PacketListenerPlayOut)var1);
      }
   }

   public static class class_b_in_class_gv extends class_gv {
      public class_b_in_class_gv() {
         this.h = true;
      }

      public class_b_in_class_gv(int var1, byte var2, byte var3, byte var4, byte var5, byte var6, boolean var7) {
         super(var1);
         this.b = var2;
         this.c = var3;
         this.d = var4;
         this.e = var5;
         this.f = var6;
         this.g = var7;
         this.h = true;
      }

      public void decode(PacketDataSerializer var1) throws IOException {
         super.decode(var1);
         this.b = var1.readByte();
         this.c = var1.readByte();
         this.d = var1.readByte();
         this.e = var1.readByte();
         this.f = var1.readByte();
         this.g = var1.readBoolean();
      }

      public void encode(PacketDataSerializer var1) throws IOException {
         super.encode(var1);
         var1.writeByte(this.b);
         var1.writeByte(this.c);
         var1.writeByte(this.d);
         var1.writeByte(this.e);
         var1.writeByte(this.f);
         var1.writeBoolean(this.g);
      }

      // $FF: synthetic method
      // $FF: bridge method
      public void handle(PacketListener var1) {
         super.a((PacketListenerPlayOut)var1);
      }
   }
}
