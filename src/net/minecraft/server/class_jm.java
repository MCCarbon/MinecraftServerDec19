package net.minecraft.server;

import com.mojang.authlib.GameProfile;
import java.io.IOException;
import java.util.UUID;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_jl;

public class class_jm implements class_ff {
   private GameProfile a;

   public class_jm() {
   }

   public class_jm(GameProfile var1) {
      this.a = var1;
   }

   public void a(class_em var1) throws IOException {
      this.a = new GameProfile((UUID)null, var1.c(16));
   }

   public void b(class_em var1) throws IOException {
      var1.a(this.a.getName());
   }

   public void a(class_jl var1) {
      var1.a(this);
   }

   public GameProfile a() {
      return this.a;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void a(class_ep var1) {
      this.a((class_jl)var1);
   }
}
