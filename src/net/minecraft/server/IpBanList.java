package net.minecraft.server;

import com.google.gson.JsonObject;
import java.io.File;
import java.net.SocketAddress;
import net.minecraft.server.IpBanEntry;
import net.minecraft.server.JsonListEntry;
import net.minecraft.server.JsonList;

public class IpBanList extends JsonList {
   public IpBanList(File var1) {
      super(var1);
   }

   protected JsonListEntry a(JsonObject var1) {
      return new IpBanEntry(var1);
   }

   public boolean isBanned(SocketAddress var1) {
      String var2 = this.c(var1);
      return this.d(var2);
   }

   public IpBanEntry get(SocketAddress var1) {
      String var2 = this.c(var1);
      return (IpBanEntry)this.b(var2);
   }

   private String c(SocketAddress var1) {
      String var2 = var1.toString();
      if(var2.contains("/")) {
         var2 = var2.substring(var2.indexOf(47) + 1);
      }

      if(var2.contains(":")) {
         var2 = var2.substring(0, var2.indexOf(58));
      }

      return var2;
   }
}
