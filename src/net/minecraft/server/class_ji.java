package net.minecraft.server;

import java.io.IOException;
import java.security.PublicKey;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.Packet;
import net.minecraft.server.class_jg;
import net.minecraft.server.class_ni;

public class class_ji implements Packet {
   private String a;
   private PublicKey b;
   private byte[] c;

   public class_ji() {
   }

   public class_ji(String var1, PublicKey var2, byte[] var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = var1.readString(20);
      this.b = class_ni.a(var1.readArray());
      this.c = var1.readArray();
   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeString(this.a);
      var1.writeArray(this.b.getEncoded());
      var1.writeArray(this.c);
   }

   public void a(class_jg var1) {
      var1.a(this);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void handle(PacketListener var1) {
      this.a((class_jg)var1);
   }
}
