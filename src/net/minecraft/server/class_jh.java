package net.minecraft.server;

import com.mojang.authlib.GameProfile;
import java.io.IOException;
import java.util.UUID;
import net.minecraft.server.class_em;
import net.minecraft.server.class_ep;
import net.minecraft.server.class_ff;
import net.minecraft.server.class_jg;

public class class_jh implements class_ff {
   private GameProfile a;

   public class_jh() {
   }

   public class_jh(GameProfile var1) {
      this.a = var1;
   }

   public void a(class_em var1) throws IOException {
      String var2 = var1.c(36);
      String var3 = var1.c(16);
      UUID var4 = UUID.fromString(var2);
      this.a = new GameProfile(var4, var3);
   }

   public void b(class_em var1) throws IOException {
      UUID var2 = this.a.getId();
      var1.a(var2 == null?"":var2.toString());
      var1.a(this.a.getName());
   }

   public void a(class_jg var1) {
      var1.a(this);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public void a(class_ep var1) {
      this.a((class_jg)var1);
   }
}
