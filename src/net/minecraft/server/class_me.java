package net.minecraft.server;

import com.google.gson.JsonObject;
import com.mojang.authlib.GameProfile;
import java.io.File;
import java.util.Iterator;
import net.minecraft.server.class_mc;
import net.minecraft.server.class_md;
import net.minecraft.server.class_mf;

public class class_me extends class_md {
   public class_me(File var1) {
      super(var1);
   }

   protected class_mc a(JsonObject var1) {
      return new class_mf(var1);
   }

   public boolean a(GameProfile var1) {
      return this.d(var1);
   }

   public String[] a() {
      String[] var1 = new String[this.e().size()];
      int var2 = 0;

      class_mf var4;
      for(Iterator var3 = this.e().values().iterator(); var3.hasNext(); var1[var2++] = ((GameProfile)var4.f()).getName()) {
         var4 = (class_mf)var3.next();
      }

      return var1;
   }

   protected String b(GameProfile var1) {
      return var1.getId().toString();
   }

   public GameProfile a(String var1) {
      Iterator var2 = this.e().values().iterator();

      class_mf var3;
      do {
         if(!var2.hasNext()) {
            return null;
         }

         var3 = (class_mf)var2.next();
      } while(!var1.equalsIgnoreCase(((GameProfile)var3.f()).getName()));

      return (GameProfile)var3.f();
   }

   // $FF: synthetic method
   protected String a(Object var1) {
      return this.b((GameProfile)var1);
   }
}
