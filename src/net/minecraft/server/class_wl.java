package net.minecraft.server;

import java.util.Collection;
import java.util.Iterator;
import java.util.UUID;
import net.minecraft.server.class_dn;
import net.minecraft.server.class_du;
import net.minecraft.server.class_eb;
import net.minecraft.server.class_qk;
import net.minecraft.server.class_ql;
import net.minecraft.server.class_qm;
import net.minecraft.server.class_qo;
import net.minecraft.server.class_qs;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class class_wl {
   private static final Logger f = LogManager.getLogger();
   public static final class_qk a = (new class_qs((class_qk)null, "generic.maxHealth", 20.0D, 0.0D, 1024.0D)).a("Max Health").a(true);
   public static final class_qk b = (new class_qs((class_qk)null, "generic.followRange", 32.0D, 0.0D, 2048.0D)).a("Follow Range");
   public static final class_qk c = (new class_qs((class_qk)null, "generic.knockbackResistance", 0.0D, 0.0D, 1.0D)).a("Knockback Resistance");
   public static final class_qk d = (new class_qs((class_qk)null, "generic.movementSpeed", 0.699999988079071D, 0.0D, 1024.0D)).a("Movement Speed").a(true);
   public static final class_qk e = new class_qs((class_qk)null, "generic.attackDamage", 2.0D, 0.0D, 2048.0D);

   public static class_du a(class_qo var0) {
      class_du var1 = new class_du();
      Iterator var2 = var0.a().iterator();

      while(var2.hasNext()) {
         class_ql var3 = (class_ql)var2.next();
         var1.a((class_eb)a(var3));
      }

      return var1;
   }

   private static class_dn a(class_ql var0) {
      class_dn var1 = new class_dn();
      class_qk var2 = var0.a();
      var1.a("Name", var2.a());
      var1.a("Base", var0.b());
      Collection var3 = var0.c();
      if(var3 != null && !var3.isEmpty()) {
         class_du var4 = new class_du();
         Iterator var5 = var3.iterator();

         while(var5.hasNext()) {
            class_qm var6 = (class_qm)var5.next();
            if(var6.e()) {
               var4.a((class_eb)a(var6));
            }
         }

         var1.a((String)"Modifiers", (class_eb)var4);
      }

      return var1;
   }

   private static class_dn a(class_qm var0) {
      class_dn var1 = new class_dn();
      var1.a("Name", var0.b());
      var1.a("Amount", var0.d());
      var1.a("Operation", var0.c());
      var1.a("UUIDMost", var0.a().getMostSignificantBits());
      var1.a("UUIDLeast", var0.a().getLeastSignificantBits());
      return var1;
   }

   public static void a(class_qo var0, class_du var1) {
      for(int var2 = 0; var2 < var1.c(); ++var2) {
         class_dn var3 = var1.b(var2);
         class_ql var4 = var0.a(var3.k("Name"));
         if(var4 != null) {
            a(var4, var3);
         } else {
            f.warn("Ignoring unknown attribute \'" + var3.k("Name") + "\'");
         }
      }

   }

   private static void a(class_ql var0, class_dn var1) {
      var0.a(var1.j("Base"));
      if(var1.b("Modifiers", 9)) {
         class_du var2 = var1.c("Modifiers", 10);

         for(int var3 = 0; var3 < var2.c(); ++var3) {
            class_qm var4 = a(var2.b(var3));
            if(var4 != null) {
               class_qm var5 = var0.a(var4.a());
               if(var5 != null) {
                  var0.c(var5);
               }

               var0.b(var4);
            }
         }
      }

   }

   public static class_qm a(class_dn var0) {
      UUID var1 = new UUID(var0.h("UUIDMost"), var0.h("UUIDLeast"));

      try {
         return new class_qm(var1, var0.k("Name"), var0.j("Amount"), var0.g("Operation"));
      } catch (Exception var3) {
         f.warn("Unable to create attribute: " + var3.getMessage());
         return null;
      }
   }
}
