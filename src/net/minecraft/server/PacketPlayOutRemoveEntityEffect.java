package net.minecraft.server;

import java.io.IOException;

public class PacketPlayOutRemoveEntityEffect implements Packet {
   private int a;
   private MobEffect b;

   public PacketPlayOutRemoveEntityEffect() {
   }

   public PacketPlayOutRemoveEntityEffect(int var1, MobEffect var2) {
      this.a = var1;
      this.b = var2;
   }

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = var1.readVarInt();
      this.b = MobEffect.a(var1.readUnsignedByte());
   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeVarInt(this.a);
      var1.writeByte(MobEffect.a(this.b));
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
