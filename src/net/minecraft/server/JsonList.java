package net.minecraft.server;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.io.Files;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.minecraft.server.JsonListEntry;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JsonList {
   protected static final Logger a = LogManager.getLogger();
   protected final Gson b;
   private final File c;
   private final Map d = Maps.newHashMap();
   private boolean e = true;
   private static final ParameterizedType f = new ParameterizedType() {
      public Type[] getActualTypeArguments() {
         return new Type[]{JsonListEntry.class};
      }

      public Type getRawType() {
         return List.class;
      }

      public Type getOwnerType() {
         return null;
      }
   };

   public JsonList(File var1) {
      this.c = var1;
      GsonBuilder var2 = (new GsonBuilder()).setPrettyPrinting();
      var2.registerTypeHierarchyAdapter(JsonListEntry.class, new JsonList.class_a_in_class_md(null));
      this.b = var2.create();
   }

   public boolean b() {
      return this.e;
   }

   public void a(boolean var1) {
      this.e = var1;
   }

   public File c() {
      return this.c;
   }

   public void a(JsonListEntry var1) {
      this.d.put(this.a(var1.f()), var1);

      try {
         this.f();
      } catch (IOException var3) {
         a.warn((String)"Could not save the list after adding a user.", (Throwable)var3);
      }

   }

   public JsonListEntry b(Object var1) {
      this.h();
      return (JsonListEntry)this.d.get(this.a(var1));
   }

   public void c(Object var1) {
      this.d.remove(this.a(var1));

      try {
         this.f();
      } catch (IOException var3) {
         a.warn((String)"Could not save the list after removing a user.", (Throwable)var3);
      }

   }

   public String[] a() {
      return (String[])this.d.keySet().toArray(new String[this.d.size()]);
   }

   public boolean d() {
      return this.d.size() < 1;
   }

   protected String a(Object var1) {
      return var1.toString();
   }

   protected boolean d(Object var1) {
      return this.d.containsKey(this.a(var1));
   }

   private void h() {
      ArrayList var1 = Lists.newArrayList();
      Iterator var2 = this.d.values().iterator();

      while(var2.hasNext()) {
         JsonListEntry var3 = (JsonListEntry)var2.next();
         if(var3.hasExpired()) {
            var1.add(var3.f());
         }
      }

      var2 = var1.iterator();

      while(var2.hasNext()) {
         Object var4 = var2.next();
         this.d.remove(var4);
      }

   }

   protected JsonListEntry a(JsonObject var1) {
      return new JsonListEntry((Object)null, var1);
   }

   protected Map e() {
      return this.d;
   }

   public void f() throws IOException {
      Collection var1 = this.d.values();
      String var2 = this.b.toJson((Object)var1);
      BufferedWriter var3 = null;

      try {
         var3 = Files.newWriter(this.c, Charsets.UTF_8);
         var3.write(var2);
      } finally {
         IOUtils.closeQuietly((Writer)var3);
      }

   }

   public void g() throws FileNotFoundException {
      Collection var1 = null;
      BufferedReader var2 = null;

      try {
         var2 = Files.newReader(this.c, Charsets.UTF_8);
         var1 = (Collection)this.b.fromJson((Reader)var2, (Type)f);
      } finally {
         IOUtils.closeQuietly((Reader)var2);
      }

      if(var1 != null) {
         this.d.clear();
         Iterator var3 = var1.iterator();

         while(var3.hasNext()) {
            JsonListEntry var4 = (JsonListEntry)var3.next();
            if(var4.f() != null) {
               this.d.put(this.a(var4.f()), var4);
            }
         }
      }

   }

   class class_a_in_class_md implements JsonDeserializer, JsonSerializer {
      private class_a_in_class_md() {
      }

      public JsonElement a(JsonListEntry var1, Type var2, JsonSerializationContext var3) {
         JsonObject var4 = new JsonObject();
         var1.a(var4);
         return var4;
      }

      public JsonListEntry a(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
         if(var1.isJsonObject()) {
            JsonObject var4 = var1.getAsJsonObject();
            JsonListEntry var5 = JsonList.this.a(var4);
            return var5;
         } else {
            return null;
         }
      }

      // $FF: synthetic method
      public JsonElement serialize(Object var1, Type var2, JsonSerializationContext var3) {
         return this.a((JsonListEntry)var1, var2, var3);
      }

      // $FF: synthetic method
      public Object deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
         return this.a(var1, var2, var3);
      }

      // $FF: synthetic method
      class_a_in_class_md(Object var2) {
         this();
      }
   }
}
