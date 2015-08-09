package net.minecraft.server;

import com.google.gson.JsonObject;
import java.util.Date;
import net.minecraft.server.ExpirableListEntry;

public class IpBanEntry extends ExpirableListEntry {
   public IpBanEntry(String var1) {
      this(var1, (Date)null, (String)null, (Date)null, (String)null);
   }

   public IpBanEntry(String var1, Date var2, String var3, Date var4, String var5) {
      super(var1, var2, var3, var4, var5);
   }

   public IpBanEntry(JsonObject var1) {
      super(b(var1), var1);
   }

   private static String b(JsonObject var0) {
      return var0.has("ip")?var0.get("ip").getAsString():null;
   }

   protected void a(JsonObject var1) {
      if(this.f() != null) {
         var1.addProperty("ip", (String)this.f());
         super.a(var1);
      }
   }
}
