package net.minecraft.server;

import com.google.gson.JsonObject;
import java.io.File;
import java.net.SocketAddress;
import net.minecraft.server.class_lx;
import net.minecraft.server.class_mc;
import net.minecraft.server.class_md;

public class class_lw extends class_md {
   public class_lw(File var1) {
      super(var1);
   }

   protected class_mc a(JsonObject var1) {
      return new class_lx(var1);
   }

   public boolean a(SocketAddress var1) {
      String var2 = this.c(var1);
      return this.d(var2);
   }

   public class_lx b(SocketAddress var1) {
      String var2 = this.c(var1);
      return (class_lx)this.b(var2);
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
