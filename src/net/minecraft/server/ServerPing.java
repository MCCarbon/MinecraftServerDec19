package net.minecraft.server;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.mojang.authlib.GameProfile;
import java.lang.reflect.Type;
import java.util.UUID;
import net.minecraft.server.IChatBaseComponent;
import net.minecraft.server.JsonHelper;

public class ServerPing {
   private IChatBaseComponent a;
   private ServerPing.ServerPingPlayerSample b;
   private ServerPing.ServerData c;
   private String d;

   public IChatBaseComponent a() {
      return this.a;
   }

   public void a(IChatBaseComponent var1) {
      this.a = var1;
   }

   public ServerPing.ServerPingPlayerSample b() {
      return this.b;
   }

   public void a(ServerPing.ServerPingPlayerSample var1) {
      this.b = var1;
   }

   public ServerPing.ServerData c() {
      return this.c;
   }

   public void a(ServerPing.ServerData var1) {
      this.c = var1;
   }

   public void a(String var1) {
      this.d = var1;
   }

   public String d() {
      return this.d;
   }

   public static class Serializer implements JsonDeserializer, JsonSerializer {
      public ServerPing a(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
         JsonObject var4 = JsonHelper.asJsonObject(var1, "status");
         ServerPing var5 = new ServerPing();
         if(var4.has("description")) {
            var5.a((IChatBaseComponent)var3.deserialize(var4.get("description"), IChatBaseComponent.class));
         }

         if(var4.has("players")) {
            var5.a((ServerPing.ServerPingPlayerSample)var3.deserialize(var4.get("players"), ServerPing.ServerPingPlayerSample.class));
         }

         if(var4.has("version")) {
            var5.a((ServerPing.ServerData)var3.deserialize(var4.get("version"), ServerPing.ServerData.class));
         }

         if(var4.has("favicon")) {
            var5.a(JsonHelper.getString(var4, "favicon"));
         }

         return var5;
      }

      public JsonElement a(ServerPing var1, Type var2, JsonSerializationContext var3) {
         JsonObject var4 = new JsonObject();
         if(var1.a() != null) {
            var4.add("description", var3.serialize(var1.a()));
         }

         if(var1.b() != null) {
            var4.add("players", var3.serialize(var1.b()));
         }

         if(var1.c() != null) {
            var4.add("version", var3.serialize(var1.c()));
         }

         if(var1.d() != null) {
            var4.addProperty("favicon", var1.d());
         }

         return var4;
      }

      // $FF: synthetic method
      public JsonElement serialize(Object var1, Type var2, JsonSerializationContext var3) {
         return this.a((ServerPing)var1, var2, var3);
      }

      // $FF: synthetic method
      public Object deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
         return this.a(var1, var2, var3);
      }
   }

   public static class ServerData {
      private final String a;
      private final int b;

      public ServerData(String var1, int var2) {
         this.a = var1;
         this.b = var2;
      }

      public String a() {
         return this.a;
      }

      public int b() {
         return this.b;
      }

      public static class Serializer implements JsonDeserializer, JsonSerializer {
         public ServerPing.ServerData a(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
            JsonObject var4 = JsonHelper.asJsonObject(var1, "version");
            return new ServerPing.ServerData(JsonHelper.getString(var4, "name"), JsonHelper.getInt(var4, "protocol"));
         }

         public JsonElement a(ServerPing.ServerData var1, Type var2, JsonSerializationContext var3) {
            JsonObject var4 = new JsonObject();
            var4.addProperty("name", var1.a());
            var4.addProperty("protocol", (Number)Integer.valueOf(var1.b()));
            return var4;
         }

         // $FF: synthetic method
         public JsonElement serialize(Object var1, Type var2, JsonSerializationContext var3) {
            return this.a((ServerPing.ServerData)var1, var2, var3);
         }

         // $FF: synthetic method
         public Object deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
            return this.a(var1, var2, var3);
         }
      }
   }

   public static class ServerPingPlayerSample {
      private final int a;
      private final int b;
      private GameProfile[] c;

      public ServerPingPlayerSample(int var1, int var2) {
         this.a = var1;
         this.b = var2;
      }

      public int a() {
         return this.a;
      }

      public int b() {
         return this.b;
      }

      public GameProfile[] c() {
         return this.c;
      }

      public void a(GameProfile[] var1) {
         this.c = var1;
      }

      public static class Serializer implements JsonDeserializer, JsonSerializer {
         public ServerPing.ServerPingPlayerSample a(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
            JsonObject var4 = JsonHelper.asJsonObject(var1, "players");
            ServerPing.ServerPingPlayerSample var5 = new ServerPing.ServerPingPlayerSample(JsonHelper.getInt(var4, "max"), JsonHelper.getInt(var4, "online"));
            if(JsonHelper.d(var4, "sample")) {
               JsonArray var6 = JsonHelper.getJsonArray(var4, "sample");
               if(var6.size() > 0) {
                  GameProfile[] var7 = new GameProfile[var6.size()];

                  for(int var8 = 0; var8 < var7.length; ++var8) {
                     JsonObject var9 = JsonHelper.asJsonObject(var6.get(var8), "player[" + var8 + "]");
                     String var10 = JsonHelper.getString(var9, "id");
                     var7[var8] = new GameProfile(UUID.fromString(var10), JsonHelper.getString(var9, "name"));
                  }

                  var5.a(var7);
               }
            }

            return var5;
         }

         public JsonElement a(ServerPing.ServerPingPlayerSample var1, Type var2, JsonSerializationContext var3) {
            JsonObject var4 = new JsonObject();
            var4.addProperty("max", (Number)Integer.valueOf(var1.a()));
            var4.addProperty("online", (Number)Integer.valueOf(var1.b()));
            if(var1.c() != null && var1.c().length > 0) {
               JsonArray var5 = new JsonArray();

               for(int var6 = 0; var6 < var1.c().length; ++var6) {
                  JsonObject var7 = new JsonObject();
                  UUID var8 = var1.c()[var6].getId();
                  var7.addProperty("id", var8 == null?"":var8.toString());
                  var7.addProperty("name", var1.c()[var6].getName());
                  var5.add(var7);
               }

               var4.add("sample", var5);
            }

            return var4;
         }

         // $FF: synthetic method
         public JsonElement serialize(Object var1, Type var2, JsonSerializationContext var3) {
            return this.a((ServerPing.ServerPingPlayerSample)var1, var2, var3);
         }

         // $FF: synthetic method
         public Object deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
            return this.a(var1, var2, var3);
         }
      }
   }
}
