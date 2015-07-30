package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.class_awj;
import net.minecraft.server.class_awt;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayOut;

public class class_hq implements Packet {
   private String a;
   private String b;
   private class_awt.class_a_in_class_awt c;
   private int d;

   public class_hq() {
   }

   public class_hq(class_awj var1, int var2) {
      this.a = var1.b();
      this.b = var1.d();
      this.c = var1.c().c();
      this.d = var2;
   }

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = var1.readString(16);
      this.d = var1.readByte();
      if(this.d == 0 || this.d == 2) {
         this.b = var1.readString(32);
         this.c = class_awt.class_a_in_class_awt.a(var1.readString(16));
      }

   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeString(this.a);
      var1.writeByte(this.d);
      if(this.d == 0 || this.d == 2) {
         var1.writeString(this.b);
         var1.writeString(this.c.a());
      }

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
