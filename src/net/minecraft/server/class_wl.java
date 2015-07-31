package net.minecraft.server;

import java.util.Collection;
import java.util.Iterator;
import java.util.UUID;
import net.minecraft.server.NBTTagCompound;
import net.minecraft.server.NBTTagList;
import net.minecraft.server.NBTTag;
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

   public static NBTTagList a(class_qo var0) {
      NBTTagList var1 = new NBTTagList();
      Iterator var2 = var0.a().iterator();

      while(var2.hasNext()) {
         class_ql var3 = (class_ql)var2.next();
         var1.add((NBTTag)a(var3));
      }

      return var1;
   }

   private static NBTTagCompound a(class_ql var0) {
      NBTTagCompound var1 = new NBTTagCompound();
      class_qk var2 = var0.a();
      var1.put("Name", var2.a());
      var1.put("Base", var0.b());
      Collection var3 = var0.c();
      if(var3 != null && !var3.isEmpty()) {
         NBTTagList var4 = new NBTTagList();
         Iterator var5 = var3.iterator();

         while(var5.hasNext()) {
            class_qm var6 = (class_qm)var5.next();
            if(var6.e()) {
               var4.add((NBTTag)a(var6));
            }
         }

         var1.put((String)"Modifiers", (NBTTag)var4);
      }

      return var1;
   }

   private static NBTTagCompound a(class_qm var0) {
      NBTTagCompound var1 = new NBTTagCompound();
      var1.put("Name", var0.b());
      var1.put("Amount", var0.d());
      var1.put("Operation", var0.c());
      var1.put("UUIDMost", var0.a().getMostSignificantBits());
      var1.put("UUIDLeast", var0.a().getLeastSignificantBits());
      return var1;
   }

   public static void a(class_qo var0, NBTTagList var1) {
      for(int var2 = 0; var2 < var1.getSize(); ++var2) {
         NBTTagCompound var3 = var1.getCompound(var2);
         class_ql var4 = var0.a(var3.getString("Name"));
         if(var4 != null) {
            a(var4, var3);
         } else {
            f.warn("Ignoring unknown attribute \'" + var3.getString("Name") + "\'");
         }
      }

   }

   private static void a(class_ql var0, NBTTagCompound var1) {
      var0.a(var1.getDouble("Base"));
      if(var1.hasOfType("Modifiers", 9)) {
         NBTTagList var2 = var1.getList("Modifiers", 10);

         for(int var3 = 0; var3 < var2.getSize(); ++var3) {
            class_qm var4 = a(var2.getCompound(var3));
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

   public static class_qm a(NBTTagCompound var0) {
      UUID var1 = new UUID(var0.getLong("UUIDMost"), var0.getLong("UUIDLeast"));

      try {
         return new class_qm(var1, var0.getString("Name"), var0.getDouble("Amount"), var0.getInt("Operation"));
      } catch (Exception var3) {
         f.warn("Unable to create attribute: " + var3.getMessage());
         return null;
      }
   }
}
