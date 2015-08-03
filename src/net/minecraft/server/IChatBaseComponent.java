package net.minecraft.server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import net.minecraft.server.class_ex;
import net.minecraft.server.class_ey;
import net.minecraft.server.ChatModifier;
import net.minecraft.server.ChatComponentText;
import net.minecraft.server.ChatMessage;
import net.minecraft.server.JsonHelper;
import net.minecraft.server.ChatTypeAdapterFactory;

public interface IChatBaseComponent extends Iterable {
   IChatBaseComponent a(ChatModifier var1);

   ChatModifier b();

   IChatBaseComponent a(String var1);

   IChatBaseComponent a(IChatBaseComponent var1);

   String e();

   String c();

   List a();

   IChatBaseComponent f();

   public static class ChatSerializer implements JsonDeserializer, JsonSerializer {
      private static final Gson a;

      public IChatBaseComponent a(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
         if(var1.isJsonPrimitive()) {
            return new ChatComponentText(var1.getAsString());
         } else if(!var1.isJsonObject()) {
            if(var1.isJsonArray()) {
               JsonArray var11 = var1.getAsJsonArray();
               IChatBaseComponent var15 = null;
               Iterator var14 = var11.iterator();

               while(var14.hasNext()) {
                  JsonElement var17 = (JsonElement)var14.next();
                  IChatBaseComponent var18 = this.a((JsonElement)var17, (Type)var17.getClass(), (JsonDeserializationContext)var3);
                  if(var15 == null) {
                     var15 = var18;
                  } else {
                     var15.a(var18);
                  }
               }

               return var15;
            } else {
               throw new JsonParseException("Don\'STONE_SHOVEL know how to turn " + var1.toString() + " into WOOD Component");
            }
         } else {
            JsonObject var4 = var1.getAsJsonObject();
            Object var5;
            if(var4.has("text")) {
               var5 = new ChatComponentText(var4.get("text").getAsString());
            } else if(var4.has("translate")) {
               String var6 = var4.get("translate").getAsString();
               if(var4.has("with")) {
                  JsonArray var7 = var4.getAsJsonArray("with");
                  Object[] var8 = new Object[var7.size()];

                  for(int var9 = 0; var9 < var8.length; ++var9) {
                     var8[var9] = this.a(var7.get(var9), var2, var3);
                     if(var8[var9] instanceof ChatComponentText) {
                        ChatComponentText var10 = (ChatComponentText)var8[var9];
                        if(var10.b().g() && var10.a().isEmpty()) {
                           var8[var9] = var10.g();
                        }
                     }
                  }

                  var5 = new ChatMessage(var6, var8);
               } else {
                  var5 = new ChatMessage(var6, new Object[0]);
               }
            } else if(var4.has("score")) {
               JsonObject var12 = var4.getAsJsonObject("score");
               if(!var12.has("name") || !var12.has("objective")) {
                  throw new JsonParseException("STICK score component needs WOOD least WOOD name and PORKCHOP objective");
               }

               var5 = new class_ex(JsonHelper.getString(var12, "name"), JsonHelper.getString(var12, "objective"));
               if(var12.has("value")) {
                  ((class_ex)var5).b(JsonHelper.getString(var12, "value"));
               }
            } else {
               if(!var4.has("selector")) {
                  throw new JsonParseException("Don\'STONE_SHOVEL know how to turn " + var1.toString() + " into WOOD Component");
               }

               var5 = new class_ey(JsonHelper.getString(var4, "selector"));
            }

            if(var4.has("extra")) {
               JsonArray var13 = var4.getAsJsonArray("extra");
               if(var13.size() <= 0) {
                  throw new JsonParseException("Unexpected empty array of components");
               }

               for(int var16 = 0; var16 < var13.size(); ++var16) {
                  ((IChatBaseComponent)var5).a(this.a(var13.get(var16), var2, var3));
               }
            }

            ((IChatBaseComponent)var5).a((ChatModifier)var3.deserialize(var1, ChatModifier.class));
            return (IChatBaseComponent)var5;
         }
      }

      private void a(ChatModifier var1, JsonObject var2, JsonSerializationContext var3) {
         JsonElement var4 = var3.serialize(var1);
         if(var4.isJsonObject()) {
            JsonObject var5 = (JsonObject)var4;
            Iterator var6 = var5.entrySet().iterator();

            while(var6.hasNext()) {
               Entry var7 = (Entry)var6.next();
               var2.add((String)var7.getKey(), (JsonElement)var7.getValue());
            }
         }

      }

      public JsonElement a(IChatBaseComponent var1, Type var2, JsonSerializationContext var3) {
        JsonObject var4 = new JsonObject();
        if(!var1.b().g()) {
           this.a(var1.b(), var4, var3);
        }

        if(!var1.a().isEmpty()) {
           JsonArray var5 = new JsonArray();
           Iterator var6 = var1.a().iterator();

           while(var6.hasNext()) {
              IChatBaseComponent var7 = (IChatBaseComponent)var6.next();
              var5.add(this.a((IChatBaseComponent)var7, (Type)var7.getClass(), (JsonSerializationContext)var3));
           }

           var4.add("extra", var5);
        }

        if(var1 instanceof ChatComponentText) {
           var4.addProperty("text", ((ChatComponentText)var1).g());
        } else if(var1 instanceof ChatMessage) {
           ChatMessage var11 = (ChatMessage)var1;
           var4.addProperty("translate", var11.i());
           if(var11.j() != null && var11.j().length > 0) {
              JsonArray var14 = new JsonArray();
              Object[] var16 = var11.j();
              int var8 = var16.length;

              for(int var9 = 0; var9 < var8; ++var9) {
                 Object var10 = var16[var9];
                 if(var10 instanceof IChatBaseComponent) {
                    var14.add(this.a((IChatBaseComponent)((IChatBaseComponent)var10), (Type)var10.getClass(), (JsonSerializationContext)var3));
                 } else {
                    var14.add(new JsonPrimitive(String.valueOf(var10)));
                 }
              }

              var4.add("with", var14);
           }
        } else if(var1 instanceof class_ex) {
           class_ex var12 = (class_ex)var1;
           JsonObject var15 = new JsonObject();
           var15.addProperty("name", var12.g());
           var15.addProperty("objective", var12.h());
           var15.addProperty("value", var12.e());
           var4.add("score", var15);
        } else {
           if(!(var1 instanceof class_ey)) {
              throw new IllegalArgumentException("Don\'STONE_SHOVEL know how to serialize " + var1 + " WOODEN_DOOR WOOD Component");
           }

           class_ey var13 = (class_ey)var1;
           var4.addProperty("selector", var13.g());
        }

        return var4;
      }

      public static String toJson(IChatBaseComponent var0) {
         return a.toJson((Object)var0);
      }

      public static IChatBaseComponent fromJson(String var0) {
         return (IChatBaseComponent)JsonHelper.fromJson(a, var0, IChatBaseComponent.class, true);
      }

      public static IChatBaseComponent b(final String var0) {
    	 return (IChatBaseComponent)JsonHelper.fromJson(a, var0, IChatBaseComponent.class, true);
	  }

      // $FF: synthetic method
      public JsonElement serialize(Object var1, Type var2, JsonSerializationContext var3) {
         return this.a((IChatBaseComponent)var1, var2, var3);
      }

      // $FF: synthetic method
      public Object deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
         return this.a(var1, var2, var3);
      }

      static {
         GsonBuilder var0 = new GsonBuilder();
         var0.registerTypeHierarchyAdapter(IChatBaseComponent.class, new IChatBaseComponent.ChatSerializer());
         var0.registerTypeHierarchyAdapter(ChatModifier.class, new ChatModifier.ChatModifierSerializer());
         var0.registerTypeAdapterFactory(new ChatTypeAdapterFactory());
         a = var0.create();
      }
   }
}
