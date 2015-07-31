package net.minecraft.server;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import net.minecraft.server.NBTTagCompound;

public class class_ael {
   private TreeMap a = new TreeMap();

   public class_ael() {
      this.a("doFireTick", "true", class_ael.class_b_in_class_ael.b);
      this.a("mobGriefing", "true", class_ael.class_b_in_class_ael.b);
      this.a("keepInventory", "false", class_ael.class_b_in_class_ael.b);
      this.a("doMobSpawning", "true", class_ael.class_b_in_class_ael.b);
      this.a("doMobLoot", "true", class_ael.class_b_in_class_ael.b);
      this.a("doTileDrops", "true", class_ael.class_b_in_class_ael.b);
      this.a("doEntityDrops", "true", class_ael.class_b_in_class_ael.b);
      this.a("commandBlockOutput", "true", class_ael.class_b_in_class_ael.b);
      this.a("naturalRegeneration", "true", class_ael.class_b_in_class_ael.b);
      this.a("doDaylightCycle", "true", class_ael.class_b_in_class_ael.b);
      this.a("logAdminCommands", "true", class_ael.class_b_in_class_ael.b);
      this.a("showDeathMessages", "true", class_ael.class_b_in_class_ael.b);
      this.a("randomTickSpeed", "3", class_ael.class_b_in_class_ael.c);
      this.a("sendCommandFeedback", "true", class_ael.class_b_in_class_ael.b);
      this.a("reducedDebugInfo", "false", class_ael.class_b_in_class_ael.b);
   }

   public void a(String var1, String var2, class_ael.class_b_in_class_ael var3) {
      this.a.put(var1, new class_ael.class_a_in_class_ael(var2, var3));
   }

   public void a(String var1, String var2) {
      class_ael.class_a_in_class_ael var3 = (class_ael.class_a_in_class_ael)this.a.get(var1);
      if(var3 != null) {
         var3.a(var2);
      } else {
         this.a(var1, var2, class_ael.class_b_in_class_ael.a);
      }

   }

   public String a(String var1) {
      class_ael.class_a_in_class_ael var2 = (class_ael.class_a_in_class_ael)this.a.get(var1);
      return var2 != null?var2.a():"";
   }

   public boolean b(String var1) {
      class_ael.class_a_in_class_ael var2 = (class_ael.class_a_in_class_ael)this.a.get(var1);
      return var2 != null?var2.b():false;
   }

   public int c(String var1) {
      class_ael.class_a_in_class_ael var2 = (class_ael.class_a_in_class_ael)this.a.get(var1);
      return var2 != null?var2.c():0;
   }

   public NBTTagCompound a() {
      NBTTagCompound var1 = new NBTTagCompound();
      Iterator var2 = this.a.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         class_ael.class_a_in_class_ael var4 = (class_ael.class_a_in_class_ael)this.a.get(var3);
         var1.put(var3, var4.a());
      }

      return var1;
   }

   public void a(NBTTagCompound var1) {
      Set var2 = var1.getKeys();
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         String var4 = (String)var3.next();
         String var6 = var1.getString(var4);
         this.a(var4, var6);
      }

   }

   public String[] b() {
      Set var1 = this.a.keySet();
      return (String[])var1.toArray(new String[var1.size()]);
   }

   public boolean e(String var1) {
      return this.a.containsKey(var1);
   }

   public boolean a(String var1, class_ael.class_b_in_class_ael var2) {
      class_ael.class_a_in_class_ael var3 = (class_ael.class_a_in_class_ael)this.a.get(var1);
      return var3 != null && (var3.e() == var2 || var2 == class_ael.class_b_in_class_ael.a);
   }

   public static enum class_b_in_class_ael {
      a,
      b,
      c;
   }

   static class class_a_in_class_ael {
      private String a;
      private boolean b;
      private int c;
      private double d;
      private final class_ael.class_b_in_class_ael e;

      public class_a_in_class_ael(String var1, class_ael.class_b_in_class_ael var2) {
         this.e = var2;
         this.a(var1);
      }

      public void a(String var1) {
         this.a = var1;
         this.b = Boolean.parseBoolean(var1);
         this.c = this.b?1:0;

         try {
            this.c = Integer.parseInt(var1);
         } catch (NumberFormatException var4) {
            ;
         }

         try {
            this.d = Double.parseDouble(var1);
         } catch (NumberFormatException var3) {
            ;
         }

      }

      public String a() {
         return this.a;
      }

      public boolean b() {
         return this.b;
      }

      public int c() {
         return this.c;
      }

      public class_ael.class_b_in_class_ael e() {
         return this.e;
      }
   }
}
