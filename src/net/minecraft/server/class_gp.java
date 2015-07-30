package net.minecraft.server;

import java.io.IOException;
import java.util.List;
import net.minecraft.server.class_aok;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayOut;
import net.minecraft.server.class_go;

public class class_gp implements Packet {
   private int[] a;
   private int[] b;
   private class_go.class_a_in_class_go[] c;
   private boolean d;

   public class_gp() {
   }

   public class_gp(List var1) {
      int var2 = var1.size();
      this.a = new int[var2];
      this.b = new int[var2];
      this.c = new class_go.class_a_in_class_go[var2];
      this.d = !((class_aok)var1.get(0)).p().t.m();

      for(int var3 = 0; var3 < var2; ++var3) {
         class_aok var4 = (class_aok)var1.get(var3);
         class_go.class_a_in_class_go var5 = class_go.a(var4, true, this.d, '\uffff');
         this.a[var3] = var4.a;
         this.b[var3] = var4.b;
         this.c[var3] = var5;
      }

   }

   public void decode(PacketDataSerializer var1) throws IOException {
      this.d = var1.readBoolean();
      int var2 = var1.readVarInt();
      this.a = new int[var2];
      this.b = new int[var2];
      this.c = new class_go.class_a_in_class_go[var2];

      int var3;
      for(var3 = 0; var3 < var2; ++var3) {
         this.a[var3] = var1.readInt();
         this.b[var3] = var1.readInt();
         this.c[var3] = new class_go.class_a_in_class_go();
         this.c[var3].b = var1.readShort() & '\uffff';
         this.c[var3].a = new byte[class_go.a(Integer.bitCount(this.c[var3].b), this.d, true)];
      }

      for(var3 = 0; var3 < var2; ++var3) {
         var1.readBytes(this.c[var3].a);
      }

   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeBoolean(this.d);
      var1.writeVarInt(this.c.length);

      int var2;
      for(var2 = 0; var2 < this.a.length; ++var2) {
         var1.writeInt(this.a[var2]);
         var1.writeInt(this.b[var2]);
         var1.writeShort((short)(this.c[var2].b & '\uffff'));
      }

      for(var2 = 0; var2 < this.a.length; ++var2) {
         var1.writeBytes(this.c[var2].a);
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
