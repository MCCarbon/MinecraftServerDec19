package net.minecraft.server;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import net.minecraft.server.EnumChatFormat;
import net.minecraft.server.class_et;
import net.minecraft.server.class_eu;
import net.minecraft.server.class_ew;

public class class_ez {
   private class_ez a;
   private EnumChatFormat b;
   private Boolean c;
   private Boolean d;
   private Boolean e;
   private Boolean f;
   private Boolean g;
   private class_et h;
   private class_ew i;
   private String j;
   private static final class_ez k = new class_ez() {
      public EnumChatFormat a() {
         return null;
      }

      public boolean b() {
         return false;
      }

      public boolean c() {
         return false;
      }

      public boolean d() {
         return false;
      }

      public boolean e() {
         return false;
      }

      public boolean f() {
         return false;
      }

      public class_et h() {
         return null;
      }

      public class_ew i() {
         return null;
      }

      public String j() {
         return null;
      }

      public class_ez a(EnumChatFormat var1) {
         throw new UnsupportedOperationException();
      }

      public class_ez a(Boolean var1) {
         throw new UnsupportedOperationException();
      }

      public class_ez b(Boolean var1) {
         throw new UnsupportedOperationException();
      }

      public class_ez c(Boolean var1) {
         throw new UnsupportedOperationException();
      }

      public class_ez d(Boolean var1) {
         throw new UnsupportedOperationException();
      }

      public class_ez e(Boolean var1) {
         throw new UnsupportedOperationException();
      }

      public class_ez a(class_et var1) {
         throw new UnsupportedOperationException();
      }

      public class_ez a(class_ew var1) {
         throw new UnsupportedOperationException();
      }

      public class_ez a(class_ez var1) {
         throw new UnsupportedOperationException();
      }

      public String toString() {
         return "Style.ROOT";
      }

      public class_ez m() {
         return this;
      }

      public class_ez n() {
         return this;
      }
   };

   public EnumChatFormat a() {
      return this.b == null?this.o().a():this.b;
   }

   public boolean b() {
      return this.c == null?this.o().b():this.c.booleanValue();
   }

   public boolean c() {
      return this.d == null?this.o().c():this.d.booleanValue();
   }

   public boolean d() {
      return this.f == null?this.o().d():this.f.booleanValue();
   }

   public boolean e() {
      return this.e == null?this.o().e():this.e.booleanValue();
   }

   public boolean f() {
      return this.g == null?this.o().f():this.g.booleanValue();
   }

   public boolean g() {
      return this.c == null && this.d == null && this.f == null && this.e == null && this.g == null && this.b == null && this.h == null && this.i == null;
   }

   public class_et h() {
      return this.h == null?this.o().h():this.h;
   }

   public class_ew i() {
      return this.i == null?this.o().i():this.i;
   }

   public String j() {
      return this.j == null?this.o().j():this.j;
   }

   public class_ez a(EnumChatFormat var1) {
      this.b = var1;
      return this;
   }

   public class_ez a(Boolean var1) {
      this.c = var1;
      return this;
   }

   public class_ez b(Boolean var1) {
      this.d = var1;
      return this;
   }

   public class_ez c(Boolean var1) {
      this.f = var1;
      return this;
   }

   public class_ez d(Boolean var1) {
      this.e = var1;
      return this;
   }

   public class_ez e(Boolean var1) {
      this.g = var1;
      return this;
   }

   public class_ez a(class_et var1) {
      this.h = var1;
      return this;
   }

   public class_ez a(class_ew var1) {
      this.i = var1;
      return this;
   }

   public class_ez a(String var1) {
      this.j = var1;
      return this;
   }

   public class_ez a(class_ez var1) {
      this.a = var1;
      return this;
   }

   private class_ez o() {
      return this.a == null?k:this.a;
   }

   public String toString() {
      return "Style{hasParent=" + (this.a != null) + ", color=" + this.b + ", bold=" + this.c + ", italic=" + this.d + ", underlined=" + this.e + ", obfuscated=" + this.g + ", clickEvent=" + this.h() + ", hoverEvent=" + this.i() + ", insertion=" + this.j() + '}';
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof class_ez)) {
         return false;
      } else {
         boolean var10000;
         label77: {
            class_ez var2 = (class_ez)var1;
            if(this.b() == var2.b() && this.a() == var2.a() && this.c() == var2.c() && this.f() == var2.f() && this.d() == var2.d() && this.e() == var2.e()) {
               label71: {
                  if(this.h() != null) {
                     if(!this.h().equals(var2.h())) {
                        break label71;
                     }
                  } else if(var2.h() != null) {
                     break label71;
                  }

                  if(this.i() != null) {
                     if(!this.i().equals(var2.i())) {
                        break label71;
                     }
                  } else if(var2.i() != null) {
                     break label71;
                  }

                  if(this.j() != null) {
                     if(this.j().equals(var2.j())) {
                        break label77;
                     }
                  } else if(var2.j() == null) {
                     break label77;
                  }
               }
            }

            var10000 = false;
            return var10000;
         }

         var10000 = true;
         return var10000;
      }
   }

   public int hashCode() {
      int var1 = this.b.hashCode();
      var1 = 31 * var1 + this.c.hashCode();
      var1 = 31 * var1 + this.d.hashCode();
      var1 = 31 * var1 + this.e.hashCode();
      var1 = 31 * var1 + this.f.hashCode();
      var1 = 31 * var1 + this.g.hashCode();
      var1 = 31 * var1 + this.h.hashCode();
      var1 = 31 * var1 + this.i.hashCode();
      var1 = 31 * var1 + this.j.hashCode();
      return var1;
   }

   public class_ez m() {
      class_ez var1 = new class_ez();
      var1.c = this.c;
      var1.d = this.d;
      var1.f = this.f;
      var1.e = this.e;
      var1.g = this.g;
      var1.b = this.b;
      var1.h = this.h;
      var1.i = this.i;
      var1.a = this.a;
      var1.j = this.j;
      return var1;
   }

   public class_ez n() {
      class_ez var1 = new class_ez();
      var1.a(Boolean.valueOf(this.b()));
      var1.b(Boolean.valueOf(this.c()));
      var1.c(Boolean.valueOf(this.d()));
      var1.d(Boolean.valueOf(this.e()));
      var1.e(Boolean.valueOf(this.f()));
      var1.a(this.a());
      var1.a(this.h());
      var1.a(this.i());
      var1.a(this.j());
      return var1;
   }

   public static class class_a_in_class_ez implements JsonDeserializer, JsonSerializer {
      public class_ez a(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
         if(var1.isJsonObject()) {
            class_ez var4 = new class_ez();
            JsonObject var5 = var1.getAsJsonObject();
            if(var5 == null) {
               return null;
            } else {
               if(var5.has("bold")) {
                  var4.c = Boolean.valueOf(var5.get("bold").getAsBoolean());
               }

               if(var5.has("italic")) {
                  var4.d = Boolean.valueOf(var5.get("italic").getAsBoolean());
               }

               if(var5.has("underlined")) {
                  var4.e = Boolean.valueOf(var5.get("underlined").getAsBoolean());
               }

               if(var5.has("strikethrough")) {
                  var4.f = Boolean.valueOf(var5.get("strikethrough").getAsBoolean());
               }

               if(var5.has("obfuscated")) {
                  var4.g = Boolean.valueOf(var5.get("obfuscated").getAsBoolean());
               }

               if(var5.has("color")) {
                  var4.b = (EnumChatFormat)var3.deserialize(var5.get("color"), EnumChatFormat.class);
               }

               if(var5.has("insertion")) {
                  var4.j = var5.get("insertion").getAsString();
               }

               JsonObject var6;
               JsonPrimitive var7;
               if(var5.has("clickEvent")) {
                  var6 = var5.getAsJsonObject("clickEvent");
                  if(var6 != null) {
                     var7 = var6.getAsJsonPrimitive("action");
                     class_et.class_a_in_class_et var8 = var7 == null?null:class_et.class_a_in_class_et.a(var7.getAsString());
                     JsonPrimitive var9 = var6.getAsJsonPrimitive("value");
                     String var10 = var9 == null?null:var9.getAsString();
                     if(var8 != null && var10 != null && var8.a()) {
                        var4.h = new class_et(var8, var10);
                     }
                  }
               }

               if(var5.has("hoverEvent")) {
                  var6 = var5.getAsJsonObject("hoverEvent");
                  if(var6 != null) {
                     var7 = var6.getAsJsonPrimitive("action");
                     class_ew.class_a_in_class_ew var11 = var7 == null?null:class_ew.class_a_in_class_ew.a(var7.getAsString());
                     class_eu var12 = (class_eu)var3.deserialize(var6.get("value"), class_eu.class);
                     if(var11 != null && var12 != null && var11.a()) {
                        var4.i = new class_ew(var11, var12);
                     }
                  }
               }

               return var4;
            }
         } else {
            return null;
         }
      }

      public JsonElement a(class_ez var1, Type var2, JsonSerializationContext var3) {
         if(var1.g()) {
            return null;
         } else {
            JsonObject var4 = new JsonObject();
            if(var1.c != null) {
               var4.addProperty("bold", var1.c);
            }

            if(var1.d != null) {
               var4.addProperty("italic", var1.d);
            }

            if(var1.e != null) {
               var4.addProperty("underlined", var1.e);
            }

            if(var1.f != null) {
               var4.addProperty("strikethrough", var1.f);
            }

            if(var1.g != null) {
               var4.addProperty("obfuscated", var1.g);
            }

            if(var1.b != null) {
               var4.add("color", var3.serialize(var1.b));
            }

            if(var1.j != null) {
               var4.add("insertion", var3.serialize(var1.j));
            }

            JsonObject var5;
            if(var1.h != null) {
               var5 = new JsonObject();
               var5.addProperty("action", var1.h.a().b());
               var5.addProperty("value", var1.h.b());
               var4.add("clickEvent", var5);
            }

            if(var1.i != null) {
               var5 = new JsonObject();
               var5.addProperty("action", var1.i.a().b());
               var5.add("value", var3.serialize(var1.i.b()));
               var4.add("hoverEvent", var5);
            }

            return var4;
         }
      }

      // $FF: synthetic method
      public JsonElement serialize(Object var1, Type var2, JsonSerializationContext var3) {
         return this.a((class_ez)var1, var2, var3);
      }

      // $FF: synthetic method
      public Object deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
         return this.a(var1, var2, var3);
      }
   }
}
