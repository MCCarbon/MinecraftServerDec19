package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.World;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayOut;

public class PacketPlayOutUpdateSign implements Packet {
   private World a;
   private BlockPosition b;
   private IChatBaseComponent[] c;

   public PacketPlayOutUpdateSign() {
   }

   public PacketPlayOutUpdateSign(World var1, BlockPosition var2, IChatBaseComponent[] var3) {
      this.a = var1;
      this.b = var2;
      this.c = new IChatBaseComponent[]{var3[0], var3[1], var3[2], var3[3]};
   }

   public void decode(PacketDataSerializer var1) throws IOException {
      this.b = var1.readBlockPosition();
      this.c = new IChatBaseComponent[4];

      for(int var2 = 0; var2 < 4; ++var2) {
         this.c[var2] = var1.readChat();
      }

   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeBlockPosition(this.b);

      for(int var2 = 0; var2 < 4; ++var2) {
         var1.writeChat(this.c[var2]);
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
