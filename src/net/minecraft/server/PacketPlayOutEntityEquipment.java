package net.minecraft.server;

import java.io.IOException;

public class PacketPlayOutEntityEquipment implements Packet {
   private int a;
   private EnumWearable b;
   private ItemStack c;

   public PacketPlayOutEntityEquipment() {
   }

   public PacketPlayOutEntityEquipment(int var1, EnumWearable var2, ItemStack var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3 == null?null:var3.clone();
   }

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = var1.readVarInt();
      this.b = (EnumWearable)var1.readEnum(EnumWearable.class);
      this.c = var1.readItemStack();
   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeVarInt(this.a);
      var1.writeEnum((Enum)this.b);
      var1.writeItemStack(this.c);
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
