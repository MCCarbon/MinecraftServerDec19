package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.ItemStack;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayIn;

public class class_iw implements Packet {
   private int a;
   private ItemStack b;

   public void a(PacketListenerPlayIn var1) {
      var1.handle(this);
   }

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = var1.readShort();
      this.b = var1.readItemStack();
   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeShort(this.a);
      var1.writeItemStack(this.b);
   }

   public int a() {
      return this.a;
   }

   public ItemStack b() {
      return this.b;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void handle(PacketListener var1) {
      this.a((PacketListenerPlayIn)var1);
   }
}
