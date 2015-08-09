package net.minecraft.server;

import com.google.gson.JsonObject;
import com.mojang.authlib.GameProfile;
import java.util.UUID;
import net.minecraft.server.JsonListEntry;

public class class_mh extends JsonListEntry {
   public class_mh(GameProfile var1) {
      super(var1);
   }

   public class_mh(JsonObject var1) {
      super(b(var1), var1);
   }

   protected void a(JsonObject var1) {
      if(this.f() != null) {
         var1.addProperty("uuid", ((GameProfile)this.f()).getId() == null?"":((GameProfile)this.f()).getId().toString());
         var1.addProperty("name", ((GameProfile)this.f()).getName());
         super.a(var1);
      }
   }

   private static GameProfile b(JsonObject var0) {
      if(var0.has("uuid") && var0.has("name")) {
         String var1 = var0.get("uuid").getAsString();

         UUID var2;
         try {
            var2 = UUID.fromString(var1);
         } catch (Throwable var4) {
            return null;
         }

         return new GameProfile(var2, var0.get("name").getAsString());
      } else {
         return null;
      }
   }
}
