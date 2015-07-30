package net.minecraft.server;

import com.mojang.authlib.GameProfile;
import java.io.IOException;
import java.util.UUID;
import net.minecraft.server.PacketDataSerializer;
import net.minecraft.server.PacketListener;
import net.minecraft.server.Packet;
import net.minecraft.server.class_jl;

public class class_jm implements Packet {
   private GameProfile a;

   public class_jm() {
   }

   public class_jm(GameProfile var1) {
      this.a = var1;
   }

   public void decode(PacketDataSerializer var1) throws IOException {
      this.a = new GameProfile((UUID)null, var1.readString(16));
   }

   public void encode(PacketDataSerializer var1) throws IOException {
      var1.writeString(this.a.getName());
   }

   public void a(class_jl var1) {
      var1.a(this);
   }

   public GameProfile a() {
      return this.a;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void handle(PacketListener var1) {
      this.a((class_jl)var1);
   }
}
