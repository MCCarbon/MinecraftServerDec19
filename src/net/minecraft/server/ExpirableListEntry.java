package net.minecraft.server;

import com.google.gson.JsonObject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import net.minecraft.server.JsonListEntry;

public abstract class ExpirableListEntry extends JsonListEntry {
   public static final SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
   protected final Date b;
   protected final String c;
   protected final Date d;
   protected final String e;

   public ExpirableListEntry(Object object, Date date, String s, Date date1, String s1) {
      super(object);
      this.b = date == null?new Date():date;
      this.c = s == null?"(Unknown)":s;
      this.d = date1;
      this.e = s1 == null?"Banned by an operator.":s1;
   }

   protected ExpirableListEntry(Object object, JsonObject jsonObject) {
      super(object, jsonObject);

      Date var3;
      try {
         var3 = jsonObject.has("created")?a.parse(jsonObject.get("created").getAsString()):new Date();
      } catch (ParseException var7) {
         var3 = new Date();
      }

      this.b = var3;
      this.c = jsonObject.has("source")?jsonObject.get("source").getAsString():"(Unknown)";

      Date var4;
      try {
         var4 = jsonObject.has("expires")?a.parse(jsonObject.get("expires").getAsString()):null;
      } catch (ParseException var6) {
         var4 = null;
      }

      this.d = var4;
      this.e = jsonObject.has("reason")?jsonObject.get("reason").getAsString():"Banned by an operator.";
   }

   public Date c() {
      return this.d;
   }

   public String d() {
      return this.e;
   }

   boolean hasExpired() {
      return this.d == null?false:this.d.before(new Date());
   }

   protected void a(JsonObject var1) {
      var1.addProperty("created", a.format(this.b));
      var1.addProperty("source", this.c);
      var1.addProperty("expires", this.d == null?"forever":a.format(this.d));
      var1.addProperty("reason", this.e);
   }
}
