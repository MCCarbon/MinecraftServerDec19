package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayIn;

public class class_ix implements Packet {
   private BlockPosition a;
   private IChatBaseComponent[] b;

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = var1.readBlockPosition();
      this.b = new IChatBaseComponent[4];

      for(int var2 = 0; var2 < 4; ++var2) {
         String var3 = var1.readString(384);
         IChatBaseComponent var4 = IChatBaseComponent.ChatSerializer.fromJson(var3);
         this.b[var2] = var4;
      }

   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeBlockPosition(this.a);

      for(int var2 = 0; var2 < 4; ++var2) {
         IChatBaseComponent var3 = this.b[var2];
         String var4 = IChatBaseComponent.ChatSerializer.toJson(var3);
         var1.writeString(var4);
      }

   }

   public void a(PacketListenerPlayIn var1) {
      var1.handle(this);
   }

   public BlockPosition a() {
      return this.a;
   }

   public IChatBaseComponent[] b() {
      return this.b;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void handle(PacketListener var1) {
      this.a((PacketListenerPlayIn)var1);
   }
}
