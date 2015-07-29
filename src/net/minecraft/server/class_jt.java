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
import net.minecraft.server.class_eu;
import net.minecraft.server.class_nk;

public class class_jt {
   private class_eu a;
   private class_jt.class_a_in_class_jt b;
   private class_jt.class_c_in_class_jt c;
   private String d;

   public class_eu a() {
      return this.a;
   }

   public void a(class_eu var1) {
      this.a = var1;
   }

   public class_jt.class_a_in_class_jt b() {
      return this.b;
   }

   public void a(class_jt.class_a_in_class_jt var1) {
      this.b = var1;
   }

   public class_jt.class_c_in_class_jt c() {
      return this.c;
   }

   public void a(class_jt.class_c_in_class_jt var1) {
      this.c = var1;
   }

   public void a(String var1) {
      this.d = var1;
   }

   public String d() {
      return this.d;
   }

   public static class class_b_in_class_jt implements JsonDeserializer, JsonSerializer {
      public class_jt a(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
         JsonObject var4 = class_nk.l(var1, "status");
         class_jt var5 = new class_jt();
         if(var4.has("description")) {
            var5.a((class_eu)var3.deserialize(var4.get("description"), class_eu.class));
         }

         if(var4.has("players")) {
            var5.a((class_jt.class_a_in_class_jt)var3.deserialize(var4.get("players"), class_jt.class_a_in_class_jt.class));
         }

         if(var4.has("version")) {
            var5.a((class_jt.class_c_in_class_jt)var3.deserialize(var4.get("version"), class_jt.class_c_in_class_jt.class));
         }

         if(var4.has("favicon")) {
            var5.a(class_nk.h(var4, "favicon"));
         }

         return var5;
      }

      public JsonElement a(class_jt var1, Type var2, JsonSerializationContext var3) {
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
         return this.a((class_jt)var1, var2, var3);
      }

      // $FF: synthetic method
      public Object deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
         return this.a(var1, var2, var3);
      }
   }

   public static class class_c_in_class_jt {
      private final String a;
      private final int b;

      public class_c_in_class_jt(String var1, int var2) {
         this.a = var1;
         this.b = var2;
      }

      public String a() {
         return this.a;
      }

      public int b() {
         return this.b;
      }

      public static class class_c_in_class_jt$class_a_in_class_c_in_class_jt implements JsonDeserializer, JsonSerializer {
         public class_jt.class_c_in_class_jt a(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
            JsonObject var4 = class_nk.l(var1, "version");
            return new class_jt.class_c_in_class_jt(class_nk.h(var4, "name"), class_nk.m(var4, "protocol"));
         }

         public JsonElement a(class_jt.class_c_in_class_jt var1, Type var2, JsonSerializationContext var3) {
            JsonObject var4 = new JsonObject();
            var4.addProperty("name", var1.a());
            var4.addProperty("protocol", (Number)Integer.valueOf(var1.b()));
            return var4;
         }

         // $FF: synthetic method
         public JsonElement serialize(Object var1, Type var2, JsonSerializationContext var3) {
            return this.a((class_jt.class_c_in_class_jt)var1, var2, var3);
         }

         // $FF: synthetic method
         public Object deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
            return this.a(var1, var2, var3);
         }
      }
   }

   public static class class_a_in_class_jt {
      private final int a;
      private final int b;
      private GameProfile[] c;

      public class_a_in_class_jt(int var1, int var2) {
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

      public static class class_a_in_class_jt$class_a_in_class_a_in_class_jt implements JsonDeserializer, JsonSerializer {
         public class_jt.class_a_in_class_jt a(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
            JsonObject var4 = class_nk.l(var1, "players");
            class_jt.class_a_in_class_jt var5 = new class_jt.class_a_in_class_jt(class_nk.m(var4, "max"), class_nk.m(var4, "online"));
            if(class_nk.d(var4, "sample")) {
               JsonArray var6 = class_nk.t(var4, "sample");
               if(var6.size() > 0) {
                  GameProfile[] var7 = new GameProfile[var6.size()];

                  for(int var8 = 0; var8 < var7.length; ++var8) {
                     JsonObject var9 = class_nk.l(var6.get(var8), "player[" + var8 + "]");
                     String var10 = class_nk.h(var9, "id");
                     var7[var8] = new GameProfile(UUID.fromString(var10), class_nk.h(var9, "name"));
                  }

                  var5.a(var7);
               }
            }

            return var5;
         }

         public JsonElement a(class_jt.class_a_in_class_jt var1, Type var2, JsonSerializationContext var3) {
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
            return this.a((class_jt.class_a_in_class_jt)var1, var2, var3);
         }

         // $FF: synthetic method
         public Object deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
            return this.a(var1, var2, var3);
         }
      }
   }
}
