package net.minecraft.server;

import java.io.IOException;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.Packet;
import net.minecraft.server.PacketListenerPlayIn;
import org.apache.commons.lang3.StringUtils;

public class class_id implements Packet {
   private String a;
   private BlockPosition b;

   public class_id() {
   }

   public class_id(String var1) {
      this(var1, (BlockPosition)null);
   }

   public class_id(String var1, BlockPosition var2) {
      this.a = var1;
      this.b = var2;
   }

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = var1.readString(32767);
      boolean var2 = var1.readBoolean();
      if(var2) {
         this.b = var1.readBlockPosition();
      }

   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeString(StringUtils.substring(this.a, 0, 32767));
      boolean var2 = this.b != null;
      var1.writeBoolean(var2);
      if(var2) {
         var1.writeBlockPosition(this.b);
      }

   }

   public void a(PacketListenerPlayIn var1) {
      var1.handle(this);
   }

   public String a() {
      return this.a;
   }

   public BlockPosition b() {
      return this.b;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void handle(PacketListener var1) {
      this.a((PacketListenerPlayIn)var1);
   }
}
