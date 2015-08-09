package net.minecraft.server;

import com.google.gson.JsonObject;

public class JsonListEntry {
   private final Object a;

   public JsonListEntry(Object var1) {
      this.a = var1;
   }

   protected JsonListEntry(Object var1, JsonObject var2) {
      this.a = var1;
   }

   Object f() {
      return this.a;
   }

   boolean hasExpired() {
      return false;
   }

   protected void a(JsonObject var1) {
   }
}
