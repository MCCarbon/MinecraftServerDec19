package net.minecraft.server;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import java.util.Iterator;
import java.util.UUID;
import net.minecraft.server.BlockPosition;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_du;
import net.minecraft.server.class_eb;
import net.minecraft.server.class_nz;

public final class class_dy {
   public static GameProfile a(class_dn var0) {
      String var1 = null;
      String var2 = null;
      if(var0.b("Name", 8)) {
         var1 = var0.k("Name");
      }

      if(var0.b("Id", 8)) {
         var2 = var0.k("Id");
      }

      if(class_nz.b(var1) && class_nz.b(var2)) {
         return null;
      } else {
         UUID var3;
         try {
            var3 = UUID.fromString(var2);
         } catch (Throwable var12) {
            var3 = null;
         }

         GameProfile var4 = new GameProfile(var3, var1);
         if(var0.b("Properties", 10)) {
            class_dn var5 = var0.n("Properties");
            Iterator var6 = var5.c().iterator();

            while(var6.hasNext()) {
               String var7 = (String)var6.next();
               class_du var8 = var5.c(var7, 10);

               for(int var9 = 0; var9 < var8.c(); ++var9) {
                  class_dn var10 = var8.b(var9);
                  String var11 = var10.k("Value");
                  if(var10.b("Signature", 8)) {
                     var4.getProperties().put(var7, new Property(var7, var11, var10.k("Signature")));
                  } else {
                     var4.getProperties().put(var7, new Property(var7, var11));
                  }
               }
            }
         }

         return var4;
      }
   }

   public static class_dn a(class_dn var0, GameProfile var1) {
      if(!class_nz.b(var1.getName())) {
         var0.a("Name", var1.getName());
      }

      if(var1.getId() != null) {
         var0.a("Id", var1.getId().toString());
      }

      if(!var1.getProperties().isEmpty()) {
         class_dn var2 = new class_dn();
         Iterator var3 = var1.getProperties().keySet().iterator();

         while(var3.hasNext()) {
            String var4 = (String)var3.next();
            class_du var5 = new class_du();

            class_dn var8;
            for(Iterator var6 = var1.getProperties().get(var4).iterator(); var6.hasNext(); var5.a((class_eb)var8)) {
               Property var7 = (Property)var6.next();
               var8 = new class_dn();
               var8.a("Value", var7.getValue());
               if(var7.hasSignature()) {
                  var8.a("Signature", var7.getSignature());
               }
            }

            var2.a((String)var4, (class_eb)var5);
         }

         var0.a((String)"Properties", (class_eb)var2);
      }

      return var0;
   }

   public static boolean a(class_eb var0, class_eb var1, boolean var2) {
      if(var0 == var1) {
         return true;
      } else if(var0 == null) {
         return true;
      } else if(var1 == null) {
         return false;
      } else if(!var0.getClass().equals(var1.getClass())) {
         return false;
      } else if(var0 instanceof class_dn) {
         class_dn var9 = (class_dn)var0;
         class_dn var10 = (class_dn)var1;
         Iterator var11 = var9.c().iterator();

         String var12;
         class_eb var13;
         do {
            if(!var11.hasNext()) {
               return true;
            }

            var12 = (String)var11.next();
            var13 = var9.b(var12);
         } while(a(var13, var10.b(var12), var2));

         return false;
      } else if(var0 instanceof class_du && var2) {
         class_du var3 = (class_du)var0;
         class_du var4 = (class_du)var1;
         if(var3.c() == 0) {
            return var4.c() == 0;
         } else {
            for(int var5 = 0; var5 < var3.c(); ++var5) {
               class_eb var6 = var3.h(var5);
               boolean var7 = false;

               for(int var8 = 0; var8 < var4.c(); ++var8) {
                  if(a(var6, var4.h(var8), var2)) {
                     var7 = true;
                     break;
                  }
               }

               if(!var7) {
                  return false;
               }
            }

            return true;
         }
      } else {
         return var0.equals(var1);
      }
   }

   public static class_dn a(UUID var0) {
      class_dn var1 = new class_dn();
      var1.a("M", var0.getMostSignificantBits());
      var1.a("L", var0.getLeastSignificantBits());
      return var1;
   }

   public static UUID b(class_dn var0) {
      return new UUID(var0.h("M"), var0.h("L"));
   }

   public static BlockPosition c(class_dn var0) {
      return new BlockPosition(var0.g("X"), var0.g("Y"), var0.g("Z"));
   }

   public static class_dn a(BlockPosition var0) {
      class_dn var1 = new class_dn();
      var1.a("X", var0.getX());
      var1.a("Y", var0.getY());
      var1.a("Z", var0.getZ());
      return var1;
   }
}
