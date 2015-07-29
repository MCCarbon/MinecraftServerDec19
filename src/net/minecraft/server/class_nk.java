package net.minecraft.server;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import org.apache.commons.lang3.StringUtils;

public class class_nk {
   public static boolean d(JsonObject var0, String var1) {
      return !g(var0, var1)?false:var0.get(var1).isJsonArray();
   }

   public static boolean g(JsonObject var0, String var1) {
      return var0 == null?false:var0.get(var1) != null;
   }

   public static String a(JsonElement var0, String var1) {
      if(var0.isJsonPrimitive()) {
         return var0.getAsString();
      } else {
         throw new JsonSyntaxException("Expected " + var1 + " to be a string, was " + d(var0));
      }
   }

   public static String h(JsonObject var0, String var1) {
      if(var0.has(var1)) {
         return a(var0.get(var1), var1);
      } else {
         throw new JsonSyntaxException("Missing " + var1 + ", expected to find a string");
      }
   }

   public static boolean b(JsonElement var0, String var1) {
      if(var0.isJsonPrimitive()) {
         return var0.getAsBoolean();
      } else {
         throw new JsonSyntaxException("Expected " + var1 + " to be a Boolean, was " + d(var0));
      }
   }

   public static boolean a(JsonObject var0, String var1, boolean var2) {
      return var0.has(var1)?b(var0.get(var1), var1):var2;
   }

   public static float d(JsonElement var0, String var1) {
      if(var0.isJsonPrimitive() && var0.getAsJsonPrimitive().isNumber()) {
         return var0.getAsFloat();
      } else {
         throw new JsonSyntaxException("Expected " + var1 + " to be a Float, was " + d(var0));
      }
   }

   public static float a(JsonObject var0, String var1, float var2) {
      return var0.has(var1)?d(var0.get(var1), var1):var2;
   }

   public static int f(JsonElement var0, String var1) {
      if(var0.isJsonPrimitive() && var0.getAsJsonPrimitive().isNumber()) {
         return var0.getAsInt();
      } else {
         throw new JsonSyntaxException("Expected " + var1 + " to be a Int, was " + d(var0));
      }
   }

   public static int m(JsonObject var0, String var1) {
      if(var0.has(var1)) {
         return f(var0.get(var1), var1);
      } else {
         throw new JsonSyntaxException("Missing " + var1 + ", expected to find a Int");
      }
   }

   public static int a(JsonObject var0, String var1, int var2) {
      return var0.has(var1)?f(var0.get(var1), var1):var2;
   }

   public static JsonObject l(JsonElement var0, String var1) {
      if(var0.isJsonObject()) {
         return var0.getAsJsonObject();
      } else {
         throw new JsonSyntaxException("Expected " + var1 + " to be a JsonObject, was " + d(var0));
      }
   }

   public static JsonArray m(JsonElement var0, String var1) {
      if(var0.isJsonArray()) {
         return var0.getAsJsonArray();
      } else {
         throw new JsonSyntaxException("Expected " + var1 + " to be a JsonArray, was " + d(var0));
      }
   }

   public static JsonArray t(JsonObject var0, String var1) {
      if(var0.has(var1)) {
         return m(var0.get(var1), var1);
      } else {
         throw new JsonSyntaxException("Missing " + var1 + ", expected to find a JsonArray");
      }
   }

   public static String d(JsonElement var0) {
      String var1 = StringUtils.abbreviateMiddle(String.valueOf(var0), "...", 10);
      if(var0 == null) {
         return "null (missing)";
      } else if(var0.isJsonNull()) {
         return "null (json)";
      } else if(var0.isJsonArray()) {
         return "an array (" + var1 + ")";
      } else if(var0.isJsonObject()) {
         return "an object (" + var1 + ")";
      } else {
         if(var0.isJsonPrimitive()) {
            JsonPrimitive var2 = var0.getAsJsonPrimitive();
            if(var2.isNumber()) {
               return "a number (" + var1 + ")";
            }

            if(var2.isBoolean()) {
               return "a boolean (" + var1 + ")";
            }
         }

         return var1;
      }
   }

   public static Object a(Gson var0, Reader var1, Class var2) {
      try {
         return var0.getAdapter(var2).fromJson(var1);
      } catch (IOException var4) {
         throw new JsonParseException(var4);
      }
   }

   public static Object a(Gson var0, String var1, Class var2) {
      return a(var0, (Reader)(new StringReader(var1)), var2);
   }
}
