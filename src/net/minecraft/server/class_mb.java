package net.minecraft.server;

import com.google.gson.JsonObject;
import com.mojang.authlib.GameProfile;
import java.util.UUID;
import net.minecraft.server.class_mc;

public class class_mb extends class_mc {
   private final int a;
   private final boolean b;

   public class_mb(GameProfile var1, int var2, boolean var3) {
      super(var1);
      this.a = var2;
      this.b = var3;
   }

   public class_mb(JsonObject var1) {
      super(b(var1), var1);
      this.a = var1.has("level")?var1.get("level").getAsInt():0;
      this.b = var1.has("bypassesPlayerLimit") && var1.get("bypassesPlayerLimit").getAsBoolean();
   }

   public int a() {
      return this.a;
   }

   public boolean b() {
      return this.b;
   }

   protected void a(JsonObject var1) {
      if(this.f() != null) {
         var1.addProperty("uuid", ((GameProfile)this.f()).getId() == null?"":((GameProfile)this.f()).getId().toString());
         var1.addProperty("name", ((GameProfile)this.f()).getName());
         super.a(var1);
         var1.addProperty("level", (Number)Integer.valueOf(this.a));
         var1.addProperty("bypassesPlayerLimit", Boolean.valueOf(this.b));
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
