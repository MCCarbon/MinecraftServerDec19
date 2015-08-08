package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayOut;
import net.minecraft.server.Entity;

public class PacketPlayOutEntityVelocity implements Packet {
   private int a;
   private int b;
   private int c;
   private int d;

   public PacketPlayOutEntityVelocity() {
   }

   public PacketPlayOutEntityVelocity(Entity var1) {
      this(var1.getId(), var1.motX, var1.motY, var1.motZ);
   }

   public PacketPlayOutEntityVelocity(int var1, double var2, double var4, double var6) {
      this.a = var1;
      double var8 = 3.9D;
      if(var2 < -var8) {
         var2 = -var8;
      }

      if(var4 < -var8) {
         var4 = -var8;
      }

      if(var6 < -var8) {
         var6 = -var8;
      }

      if(var2 > var8) {
         var2 = var8;
      }

      if(var4 > var8) {
         var4 = var8;
      }

      if(var6 > var8) {
         var6 = var8;
      }

      this.b = (int)(var2 * 8000.0D);
      this.c = (int)(var4 * 8000.0D);
      this.d = (int)(var6 * 8000.0D);
   }

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = var1.readVarInt();
      this.b = var1.readShort();
      this.c = var1.readShort();
      this.d = var1.readShort();
   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeVarInt(this.a);
      var1.writeShort(this.b);
      var1.writeShort(this.c);
      var1.writeShort(this.d);
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
