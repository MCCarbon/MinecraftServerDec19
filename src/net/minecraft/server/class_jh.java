package net.minecraft.server;

import com.mojang.authlib.GameProfile;
import java.io.IOException;
import java.util.UUID;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.Packet;
import net.minecraft.server.class_jg;

public class class_jh implements Packet {
   private GameProfile a;

   public class_jh() {
   }

   public class_jh(GameProfile var1) {
      this.a = var1;
   }

   public void decode(PacketDataSerializer var1) throws IOException {
      String var2 = var1.readString(36);
      String var3 = var1.readString(16);
      UUID var4 = UUID.fromString(var2);
      this.a = new GameProfile(var4, var3);
   }

   public void encode(PacketDataSerializer var1) throws IOException {
      UUID var2 = this.a.getId();
      var1.writeString(var2 == null?"":var2.toString());
      var1.writeString(this.a.getName());
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
